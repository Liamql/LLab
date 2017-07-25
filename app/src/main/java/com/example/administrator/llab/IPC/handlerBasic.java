package com.example.administrator.llab.IPC;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.TextView;

import com.example.administrator.llab.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by Administrator on 2017/7/25 0025.
 */
public class handlerBasic extends AppCompatActivity {

    @BindView(R.id.handler_post)
    Button post;
    @BindView(R.id.handler_msg)
    Button send;
    @BindView(R.id.tv)
    TextView tv;

    Handler mHandler = new Handler()
    {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what)
            {
                case 1:
                    tv.setText(msg.obj.toString());
                    break;
            }
        }
    };




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.handler_basic_main);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.handler_post) void pt()
    {
        new Thread(new Runnable() {
            @Override
            public void run() {
                mHandler.post(new Runnable() {
                    @Override
                    public void run() {
                        tv.setText("使用Handler.post在工作线程中发送一段执行到消息队列中，在主线程中执行。");
                    }
                });
            }
        }).start();
    }

    @OnClick(R.id.handler_msg) void sd()
    {
        new Thread(new Runnable() {
            @Override
            public void run() {
                Message msg = Message.obtain();
                msg.what = 1;
                msg.obj = "使用Message.Obtain+Hander.sendMessage()发送消息";
                mHandler.sendMessage(msg);
            }
        }).start();
    }
}
