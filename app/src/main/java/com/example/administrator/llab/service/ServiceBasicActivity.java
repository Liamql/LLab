package com.example.administrator.llab.service;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Button;
import android.widget.Toast;

import com.example.administrator.llab.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by Administrator on 2017/7/24 0024.
 */
public class ServiceBasicActivity extends AppCompatActivity {

    @BindView(R.id.bind_service)
    Button bindbutton;
    @BindView(R.id.unbind_service)
    Button unbindbutton;
    @BindView(R.id.start_service)
    Button startbutton;
    @BindView(R.id.stop_service)
    Button stopbutton;
    @BindView(R.id.start_rservice) Button startre;
    @BindView(R.id.stop_rservice) Button stopre;

    private SimpleService.MyBinder myBinder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.service_basic);
        ButterKnife.bind(this);
    }

    private ServiceConnection connection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            myBinder = (SimpleService.MyBinder)service;
            myBinder.startDownload();
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {

        }
    };

    @OnClick(R.id.start_service) void start()
    {
        Intent intent = new Intent(this,SimpleService.class);
        startService(intent);
    }

    @OnClick(R.id.stop_service) void stop()
    {
        Intent intent = new Intent(this,SimpleService.class);
        stopService(intent);
    }

    @OnClick(R.id.start_iservice) void istart()
    {
        Log.d("MainActivity", "主线程的id是：" + Thread.currentThread().getId());
        Intent intent = new Intent(this,MyIntentService.class);
        startService(intent);
    }

    @OnClick(R.id.stop_iservice) void istop()
    {
        Intent intent = new Intent(this,MyIntentService.class);
        stopService(intent);
    }

    @OnClick(R.id.bind_service) void bd()
    {
        Intent intent = new Intent(this,SimpleService.class);
        bindService(intent, connection, BIND_AUTO_CREATE);
    }

    @OnClick(R.id.unbind_service) void unbd()
    {
        unbindService(connection);
    }

    @OnClick(R.id.start_rservice) void stre()
    {
        Log.d("MainActivity", "主线程的id是：" + Thread.currentThread().getId());
        Intent intent = new Intent(this,SimpleRemoteService.class);
        startService(intent);
    }

    @OnClick(R.id.stop_rservice) void spre()
    {
        Intent intent = new Intent(this,SimpleRemoteService.class);
        stopService(intent);
    }

}
