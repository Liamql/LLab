package com.example.administrator.llab.service;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteException;
import android.support.annotation.Nullable;

import com.example.administrator.llab.AIDL.ICount;

/**
 * Created by Administrator on 2017/7/24 0024.
 */
public class SimpleAIDL extends Service{


    private ICount.Stub mBinder = new ICount.Stub() {
        @Override
        public String greet(String someone) throws RemoteException {
            return "hello, " + someone;
        }
    };

    @Override
    public void onCreate() {
        super.onCreate();
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return mBinder;
    }

    @Override
    public boolean onUnbind(Intent intent) {
        return super.onUnbind(intent);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }
}
