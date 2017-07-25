package com.example.administrator.llab.IPC;

import android.app.Service;
import android.content.Intent;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
import android.util.Log;

/**
 * Created by Administrator on 2017/7/25 0025.
 */
public class MessengerService extends Service {

    private static final int MSG_SUM = 0x110;

    private Messenger mMessenger = new Messenger(new Handler(){
        @Override
        public void handleMessage(Message msgFromClient) {
            super.handleMessage(msgFromClient);

            Message msgToClient = Message.obtain(msgFromClient);
            switch(msgFromClient.what)
            {
                case MSG_SUM:
                    int res = msgFromClient.arg1 + msgFromClient.arg2;
                    msgToClient.what = MSG_SUM;
                    msgToClient.arg1 = res;
                    try{
                        msgFromClient.replyTo.send(msgToClient);
                    }
                    catch(RemoteException e){e.printStackTrace();}
                    break;
            }
        }
    });

    @Override
    public IBinder onBind(Intent intent)
    {
        return mMessenger.getBinder();
    }
}
