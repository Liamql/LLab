package com.example.administrator.llab.service;

import android.app.IntentService;
import android.content.Intent;
import android.util.Log;

/**
 * Created by Administrator on 2017/7/24 0024.
 */
public class MyIntentService extends IntentService {

    public MyIntentService(){
        super("MyIntentService");
    }

    @Override
    protected void onHandleIntent(Intent intent) {
        for(int i = 0;i<3;i++) {
            //Service要执行的逻辑
            //这里我们只打印当前线程的id
            Log.d("MyIntentService", "IntentService线程的id是：" + Thread.currentThread().getId());
            try {
                //线程睡眠一秒钟
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d("MyIntentService","onDestroy");
    }
}
