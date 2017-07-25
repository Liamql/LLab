package com.example.administrator.llab.service;

import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;

import com.example.administrator.llab.R;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * Created by Administrator on 2017/7/24 0024.
 */
public class AIDLSimpleActivity extends AppCompatActivity {

    @BindView(R.id.start_service)
    Button stbtn;
    @BindView(R.id.stop_service)
    Button spbtn;

    @BindView(R.id.bind_service)
    Button bsbtn;
    @BindView(R.id.unbind_service)
    Button ubbtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.service_aidl);
    }

    @OnClick(R.id.start_service) void st()
    {
        Intent intent = new Intent(this,SimpleAIDL.class);
        startService(intent);
    }

    @OnClick(R.id.stop_service) void sp()
    {
        Intent intent = new Intent(this,SimpleAIDL.class);
        stopService(intent);
    }

    @OnClick(R.id.bind_service) void bs()
    {
        Intent intent = new Intent(this,IPCnoAIDL.class);
        startService(intent);
    }

    @OnClick(R.id.unbind_service) void ubs()
    {
        Intent intent = new Intent(this,IPCnoAIDL.class);
        stopService(intent);
    }


}
