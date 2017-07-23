package com.example.administrator.llab.Thread;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.CheckBox;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.administrator.llab.R;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;
import java.util.logging.LogRecord;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by Administrator on 2017/7/23 0023.
 */
public class ThreadActitvity extends AppCompatActivity {

    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.progressBar)
    ProgressBar progressBar;
    @BindView(R.id.tv_start)
    TextView tvStart;
    @BindView(R.id.tv_cancel)
    TextView tvCancel;
    @BindView(R.id.tv_info1)
    TextView tvInfo1;
    @BindView(R.id.tv_info2)
    TextView tvInfo2;
    @BindView(R.id.cb_cancel)
    CheckBox cbCancel;

    private Callable<String> callable;
    private FutureTask<String> task;
    private Thread thread;

    private final int TYPE_MSG_RUN = 1001;
    private final int TYPE_MSG_DONE = 1002;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thread);
        ButterKnife.bind(this);

        initView();
    }

    private void initView() {
        initToolBar(toolbar, true, "线程");

        progressBar.setMax(100);
        progressBar.setProgress(0);
    }

    //显示home图标
    public void initToolBar(Toolbar toolbar, boolean homeAsUpEnabled, String title) {
        toolbar.setTitle(title);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(homeAsUpEnabled);
    }

    @OnClick(R.id.tv_start) void start()
    {
        if (task == null || thread == null || task.isDone()) {
            StartThread();
            showStatus();
        }
    }

    @OnClick(R.id.tv_cancel) void cancel()
    {
        if (task != null) {
            task.cancel(cbCancel.isChecked());
            showStatus();
        }
    }

    private Handler mHandler = new Handler() {

        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);

            switch(msg.what)
            {
                case TYPE_MSG_DONE:
                    tvInfo1.setText("计数完成");
                    break;
                case TYPE_MSG_RUN:
                    progressBar.setProgress(msg.arg1);
                    tvInfo1.setText("线程计数: " + msg.arg1);
                    break;
                default:
                    break;
            }
        }
    };

    void sendMsg(int val,int type)
    {
        Message msg = Message.obtain();
        msg.what = type;
        msg.arg1 = val;
        mHandler.sendMessage(msg);
    }

    void StartThread()
    {
        callable = new Callable<String>() {

            int num = 0;

            @Override
            public String call() throws Exception {

                while(num<100)
                {
                    num++;
                    sendMsg(num,TYPE_MSG_RUN);
                    thread.sleep(100);
                }

                sendMsg(num,TYPE_MSG_DONE);

                return null;
            }
        };

        task = new FutureTask<>(callable);
        thread = new Thread(task);
        thread.start();
    }

    private void showStatus() {
        if (task == null || thread == null) {
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("状态: ");
        sb.append("\nFutureTask isCancelled(): " + task.isCancelled());
        sb.append("\nFutureTask isDone(): " + task.isDone());
        sb.append("\n\nThread isAlive(): " + thread.isAlive());
        sb.append("\nThread isInterrupted(): " + thread.isInterrupted());
        tvInfo2.setText(sb.toString());
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (task != null && !task.isDone()) {
            task.cancel(true);
        }
    }
}
