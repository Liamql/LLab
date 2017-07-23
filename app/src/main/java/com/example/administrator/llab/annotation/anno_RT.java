package com.example.administrator.llab.annotation;


import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.TextView;

import com.example.administrator.llab.R;

/**
 * Created by Administrator on 2017/7/23 0023.
 */
public class anno_RT extends AppCompatActivity {

    @MyTag(R.id.anno_b)
    private Button b1;
    @MyTag(R.id.anno_tv)
    private TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.anno_b1);
        MyAnnoUtils.ltag(this);
    }
}
