package com.example.administrator.llab.RichText;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.AsyncTask;
import android.text.Html;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.TextView;

import java.io.BufferedInputStream;
import java.lang.ref.WeakReference;
import java.net.URL;
import java.net.URLConnection;

/**
 * Created by Administrator on 2017/8/8 0008.
 */
public class URLImageParser implements Html.ImageGetter {
    Context c;
    TextView container;

    /***
     * Construct the URLImageParser which will execute AsyncTask and refresh the container
     *
     * @param t
     * @param c
     */
    public URLImageParser(TextView t, Context c) {
        this.c = c;
        this.container = t;
    }

    public Drawable getDrawable(String source) {
        URLDrawable urlDrawable = new URLDrawable();

        // get the actual source
        ImageGetterAsyncTask asyncTask =
                new ImageGetterAsyncTask(urlDrawable);

        asyncTask.execute(source);

        // return reference to URLDrawable where I will change with actual image from
        // the src tag
        return urlDrawable;
    }

    public class ImageGetterAsyncTask extends AsyncTask<String, Void, Drawable> {
        URLDrawable urlDrawable;
        //private final WeakReference<URLDrawable> drawableReference;

        public ImageGetterAsyncTask(URLDrawable d) {
            this.urlDrawable = d;
            //this.drawableReference = new WeakReference<>(d);
        }

        @Override
        protected Drawable doInBackground(String... params) {
            String source = params[0];
            return fetchDrawable(source);
        }

        @Override
        protected void onPostExecute(Drawable result) {
            // set the correct bound according to the result from HTTP call
            /*
            Log.d("height", "" + result.getIntrinsicHeight());
            Log.d("width", "" + result.getIntrinsicWidth());
            int w = getScreenSize(c).x;
            int hh=result.getIntrinsicHeight();
            int ww=result.getIntrinsicWidth() ;
            Log.e("hh", String.valueOf(result.getIntrinsicHeight()));
            int high=hh*(w-40)/ww;
            Rect rect = new Rect(20, 20,w-20,high);
            result.setBounds(rect);
            urlDrawable.setBounds(rect);
            //urlDrawable.setBounds(0, 0, result.getIntrinsicWidth(), result.getIntrinsicHeight());

            // change the reference of the current drawable to the result
            // from the HTTP call
            urlDrawable.setDrawable(result);
            //urlDrawable.setBounds(0, 0, 50, 100);*/
/*
            // For ICS
            URLImageParser.this.container.setHeight((URLImageParser.this.container.getHeight()
                    + result.getIntrinsicHeight()));
*/
            //URLImageParser.this.container.setEllipsize(null);

            // redraw the image by invalidating the container
            //URLImageParser.this.container.setText(URLImageParser.this.container.getText());
  /*          final URLDrawable urlDrawable = drawableReference.get();
            if (urlDrawable == null) {
                return;
            }*/
            result.setBounds(0, 0, result.getIntrinsicWidth(), result.getIntrinsicHeight());
            urlDrawable.setBounds(0, 0, result.getIntrinsicWidth(), result.getIntrinsicHeight());
            urlDrawable.setDrawable(result);

            container.invalidate();
            try {
                Thread.sleep(3000);
            }
            catch (Exception e)
            {e.printStackTrace();}
            //Log.d("text", "" + URLImageParser.this.container.getText());
            container.setText(container.getText());

        }

        /***
         * Get the Drawable from URL
         *
         * @param urlString
         * @return
         */
        public Drawable fetchDrawable(String urlString) {
            try {
                URL aURL = new URL(urlString);
                final URLConnection conn = aURL.openConnection();
                conn.connect();
                final BufferedInputStream bis = new BufferedInputStream(conn.getInputStream());
                final Bitmap bm = BitmapFactory.decodeStream(bis);
                Drawable drawable = new BitmapDrawable(c.getResources(),bm);
                //drawable.setBounds(0, 0, bm.getWidth(), bm.getHeight());
                //Log.d("BMheight", "" + bm.getHeight());
                //Log.d("BMwidth", "" + bm.getWidth());
                return drawable;
            } catch (Exception e) {
                return null;
            }
        }
    }

    public static Point getScreenSize(Context context) {

        // 获取屏幕宽高
        WindowManager wm = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
        Point screenSize = new Point();
        wm.getDefaultDisplay().getSize(screenSize);
        return screenSize;
    }
}
