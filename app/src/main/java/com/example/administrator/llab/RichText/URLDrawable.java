package com.example.administrator.llab.RichText;

import android.app.Activity;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.view.Display;

import com.example.administrator.llab.R;

/**
 * Created by Administrator on 2017/8/8 0008.
 */
public class URLDrawable extends BitmapDrawable {
    protected Drawable drawable;

    public URLDrawable() {
    }

    @SuppressWarnings("deprecation")
    public URLDrawable(Context context) {
    }

    @Override
    public void draw(Canvas canvas) {
        if (drawable != null) {
            drawable.draw(canvas);
        }
    }

    public void setDrawable(Drawable drawable) {
        this.drawable = drawable;
    }
}