package com.example.administrator.llab.service;


import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import android.support.annotation.Nullable;
import android.util.Log;

/**
 * Created by Administrator on 2017/7/25 0025.
 */
public class IPCnoAIDL extends Service {

    private static final String DESCRIPTOR = "IPCnoAIDL";
    private static final String TAG = "IPCnoAIDL";

    public void onCreate()
    {
        Log.e(TAG, "onCreate");
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId)
    {
        Log.e(TAG, "onStartCommand");
        return super.onStartCommand(intent, flags, startId);
    }

    public IBinder onBind(Intent t)
    {
        Log.e(TAG, "onBind");
        return mBinder;
    }

    public void onDestroy()
    {
        Log.e(TAG, "onDestroy");
        super.onDestroy();
    }

    public boolean onUnbind(Intent intent)
    {
        Log.e(TAG, "onUnbind");
        return super.onUnbind(intent);
    }

    public void onRebind(Intent intent)
    {
        Log.e(TAG, "onRebind");
        super.onRebind(intent);
    }

    private IBinder mBinder = new MyBinder();

    private class MyBinder extends Binder
    {
        @Override
        protected boolean onTransact(int code, Parcel data, Parcel reply, int flags) throws RemoteException {

            switch (code)
            {
                case 0x110:
                    data.enforceInterface(DESCRIPTOR);
                    int _arg0 = data.readInt();
                    int _arg1 = data.readInt();
                    int res = _arg0+_arg1;
                    reply.writeNoException();
                    reply.writeInt(res);
                    return true;
                case 0x111:
                    data.enforceInterface(DESCRIPTOR);
                    int _arg2 = data.readInt();
                    int _arg3 = data.readInt();
                    int res2 = _arg2*_arg3;
                    reply.writeNoException();
                    reply.writeInt(res2);
                    return true;
            }
            return super.onTransact(code, data, reply, flags);
        }
    }
}
