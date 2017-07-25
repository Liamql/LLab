package com.example.administrator.llab.IPC;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import com.example.administrator.llab.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by Administrator on 2017/7/25 0025.
 */
public class MessengerBasic extends Activity {

    @BindView(R.id.bind_messenger)
    Button bindM;
    @BindView(R.id.handler_msg)
    Button send;
    @BindView(R.id.tv)
    TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.messenger_basic_main);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.bind_messenger) void bd()
    {

    }
}
