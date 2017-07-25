package com.example.administrator.llab.broadcast;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.BatteryManager;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.administrator.llab.R;

import java.text.SimpleDateFormat;
import java.util.Date;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by Administrator on 2017/7/25 0025.
 */
public class BasicBroadcastActivity extends Activity{

    @BindView(R.id.sendBC)
    Button sendBC;

    @BindView(R.id.progressBar)
    ProgressBar progressBar;

    @BindView(R.id.tv_info1)
    TextView tv;

    @BindView(R.id.tv_date)
    TextView tv_date;

    SimpleBroadcastReceiver simpleBroadcastReceiver;
    UpdateTimeReceiver updateTimeReceiver;

    private static final String TAG = "BatteryChangedReceiver";

    @Override
    protected void onResume() {
        super.onResume();

        IntentFilter intentFilter = new IntentFilter(Intent.ACTION_BATTERY_CHANGED);
        simpleBroadcastReceiver = new SimpleBroadcastReceiver();
        registerReceiver(simpleBroadcastReceiver, intentFilter);

        intentFilter = new IntentFilter("ACTION_UPDATE_TIME");
        updateTimeReceiver = new UpdateTimeReceiver();
        registerReceiver(updateTimeReceiver, intentFilter);

        Intent intent = new Intent(this,UpdateGService.class);
        startService(intent);
    }

    @Override
    protected void onPause() {
        super.onPause();
        unregisterReceiver(simpleBroadcastReceiver);
        unregisterReceiver(updateTimeReceiver);
        Intent intent = new Intent(this,UpdateGService.class);
        stopService(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_broadcast);
        ButterKnife.bind(this);

        progressBar.setMax(100);
        progressBar.setProgress(0);
    }

    @OnClick(R.id.sendBC) void sbc()
    {
        Intent intent = new Intent();
        intent.setAction(Intent.ACTION_BATTERY_CHANGED);
        //sendBroadcast(intent);
    }


    private class SimpleBroadcastReceiver extends BroadcastReceiver
    {
        @Override
        public void onReceive(Context context, Intent intent) {
            int currLevel =   intent.getIntExtra(BatteryManager.EXTRA_LEVEL, 0);  //当前电量
            int total = intent.getIntExtra(BatteryManager.EXTRA_SCALE,   1);      //总电量
            int percent = currLevel * 100 / total;
            updateG(percent);
            Log.i(TAG, "battery: " + percent + "%");
        }
    }

    private class UpdateTimeReceiver extends BroadcastReceiver
    {
        @Override
        public void onReceive(Context context, Intent intent) {
            Date date = new Date();

            SimpleDateFormat dateFormat = new SimpleDateFormat("MM-dd");
            SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm:ss");

            String dateStr = dateFormat.format(date);
            String timeStr = timeFormat.format(date);

            tv_date.setText(dateStr + ":" + timeStr);//显示出日期
        }
    }

    void updateG(int percent)
    {
        progressBar.setProgress(percent);
        tv.setText("电池电量:" + percent + "%");
    }
}
