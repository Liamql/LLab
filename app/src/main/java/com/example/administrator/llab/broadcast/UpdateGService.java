package com.example.administrator.llab.broadcast;

import android.app.Service;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.IBinder;
import android.support.annotation.Nullable;

import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by Administrator on 2017/7/25 0025.
 */
public class UpdateGService extends Service {

    @Override
    public void onCreate() {
        super.onCreate();
        new Timer().scheduleAtFixedRate(new TimerTask() {

            @Override
            public void run() {
                Intent timeIntent = new Intent();
                timeIntent.setAction("ACTION_UPDATE_TIME");//自定义Action
                sendBroadcast(timeIntent); //发送广播
            }
        }, 0, 1000); //每隔1秒
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
}
