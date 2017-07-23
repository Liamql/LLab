package com.example.administrator.llab.annotation;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.TextView;

import com.example.administrator.llab.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by Administrator on 2017/7/23 0023.
 */
public class anno_bknife extends AppCompatActivity {

    @BindView(R.id.anno_b)
    Button b1;
    @BindView(R.id.anno_tv)
    TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.anno_b1);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.anno_b) void Lclick()
    {
        tv.setText("666");
    }
}
