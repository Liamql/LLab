package com.example.administrator.llab.Network;

import android.accounts.NetworkErrorException;
import android.util.Log;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by Administrator on 2017/7/26 0026.
 */
public class NetUtils {
    public static String post(String url, String content) {

        HttpURLConnection conn = null;
        try{
            URL mURL = new URL(url);
            conn = (HttpURLConnection)mURL.openConnection();

            // post请求的参数
            String data = content;
            // 获得一个输出流,向服务器写数据,默认情况下,系统不允许向服务器输出内容
            OutputStream out = conn.getOutputStream();// 获得一个输出流,向服务器写数据
            out.write(data.getBytes());
            out.flush();
            out.close();

            conn.setRequestMethod("POST");// 设置请求方法为post
            conn.setReadTimeout(5000);// 设置读取超时为5秒
            conn.setConnectTimeout(10000);// 设置连接网络超时为10秒
            conn.setDoOutput(true);// 设置此方法,允许向服务器输出内容

            int requestCode = conn.getResponseCode();
            if(requestCode == 200)
            {
                InputStream is = conn.getInputStream();
                String response = getStringFromInputStream(is);
                Log.i("WEB", "请求状态码:" + requestCode + "\n请求结果:\n" + response);
                return response;
            }

        }catch(Exception e){e.printStackTrace();}
        finally {
            if(conn!=null) conn.disconnect();
        }

        return null;
    }

    public static String get(String url)
    {
        HttpURLConnection conn = null;

        try {
            URL mURL = new URL(url);
            conn = (HttpURLConnection) mURL.openConnection();

            conn.setRequestMethod("GET");
            conn.setReadTimeout(5000);
            conn.setConnectTimeout(10000);

            int requestCode = conn.getResponseCode();
            if(requestCode==200)
            {
                InputStream is = conn.getInputStream();
                String response = getStringFromInputStream(is);
                Log.i("WEB", "请求状态码:" + requestCode + "\n请求结果:\n" + response);
                return response;
            }

        }
        catch(Exception e){e.printStackTrace();}
        finally {
            if(conn!=null) conn.disconnect();
        }

        return null;

    }

    private static String getStringFromInputStream(InputStream is) throws IOException
    {
        ByteArrayOutputStream os = new ByteArrayOutputStream();

        byte[] buffer = new byte[1024];
        int len = -1;
        String state = null;
        while ((len = is.read(buffer)) != -1)
        {
            os.write(buffer,0,len);
        }
        is.close();
        state = os.toString();
        os.close();
        return state;
    }

}
