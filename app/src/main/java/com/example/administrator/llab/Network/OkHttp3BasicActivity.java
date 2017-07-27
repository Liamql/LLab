package com.example.administrator.llab.Network;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.administrator.llab.Network.retrofit.City;
import com.example.administrator.llab.R;
import com.google.gson.Gson;
import com.squareup.okhttp.MediaType;
import com.squareup.okhttp.RequestBody;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Headers;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okio.BufferedSink;

/**
 * Created by Administrator on 2017/7/27 0027.
 */
public class OkHttp3BasicActivity extends Activity {

    @BindView(R.id.sn_tv)
    TextView tv;

    @BindView(R.id.btn_get)
    Button getbtn;

    @BindView(R.id.btn_get_as) Button getasbtn;
    @BindView(R.id.btn_dl_img) Button dlbtn;
    @BindView(R.id.btn_json) Button jsbtn;
    @BindView(R.id.sn_iv)
    ImageView iv;

    String httpUrl = "http://apis.baidu.com/bdyunfenxi/intelligence/ip";
    String httpArg = "ip=113.116.207.101";
    String API_KEY = "8gqkro1pbbhh4ijm";

    private OkHttpClient client ;

    String str = "";

    private Handler handler = new Handler()
    {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what)
            {
                case 1:
                    tv.setText(msg.obj.toString());
                    break;
                case 2:
                    iv.setImageBitmap((Bitmap)msg.obj);
                    break;
            }
        }
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.okhttp3_main);

        ButterKnife.bind(this);

    }

    /**
     * OkHttp的get请求
     * 需要加线程
     */
    @OnClick(R.id.btn_get) void okget()
    {
        new Thread(new Runnable() {
            @Override
            public void run() {
                client = new OkHttpClient();

                Request request = new Request.Builder()
                        .url("http://publicobject.com/helloworld.txt")
                        .build();
                try {
                    Response response = client.newCall(request).execute();
                    if (!response.isSuccessful()) throw new IOException("Unexpected code " + response);
                    str = response.body().string();
                    Message msg = Message.obtain();
                    msg.what =1;
                    msg.obj = str;
                    handler.sendMessage(msg);
                }
                catch (Exception e){e.printStackTrace();}
            }
        }).start();

    }


    /**
     * OkHttp的get请求
     * 不需要加线程
     */
    @OnClick(R.id.btn_get_as) void okas()
    {
        client = new OkHttpClient();

        Request request = new Request.Builder()
                .url("http://www.baidu.com")
                .build();

        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                if (!response.isSuccessful()) throw new IOException("Unexpected code " + response);

                str = response.body().string();
                Message msg = Message.obtain();
                msg.what = 1;
                msg.obj = str;
                handler.sendMessage(msg);
            }
        });
    }

    @OnClick(R.id.btn_dl_img) void okrun()
    {
        client = new OkHttpClient();

        Request request = new Request.Builder()
                .url("http://www.cnblogs.com/images/logo_small.gif")
                .build();

        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                if (!response.isSuccessful()) throw new IOException("Unexpected code " + response);

                InputStream is = response.body().byteStream();

                Bitmap bitmap = BitmapFactory.decodeStream(is);

                Message msg = Message.obtain();
                msg.what = 2;
                msg.obj = bitmap;
                handler.sendMessage(msg);
            }
        });

    }

    @OnClick(R.id.btn_json) void jb()
    {
        client = new OkHttpClient();

        Request request = new Request.Builder()
                .url("https://api.seniverse.com/v3/location/search.json?key=8gqkro1pbbhh4ijm&q=shenzhen")
                .addHeader("apikey",API_KEY)
                .build();

        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                if (!response.isSuccessful()) throw new IOException("Unexpected code " + response);

                City city = new Gson().fromJson(response.body().string(),City.class);

                Message msg = Message.obtain();
                msg.what = 1;
                msg.obj = city.toString();
                handler.sendMessage(msg);
            }
        });
    }
}
