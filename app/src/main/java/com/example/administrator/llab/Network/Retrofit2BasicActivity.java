package com.example.administrator.llab.Network;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.administrator.llab.Network.retrofit.City;
import com.example.administrator.llab.Network.retrofit.IWeather;
import com.example.administrator.llab.R;
import com.google.gson.Gson;
import com.squareup.okhttp.Interceptor;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;

import java.io.IOException;
import java.io.InputStream;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import retrofit.Call;
import retrofit.Callback;
import retrofit.GsonConverterFactory;
import retrofit.Response;
import retrofit.Retrofit;

/**
 * Created by Administrator on 2017/7/27 0027.
 */
public class Retrofit2BasicActivity extends Activity {

    @BindView(R.id.sn_tv)
    TextView tv;

    @BindView(R.id.btn_get)
    Button getbtn;

    @BindView(R.id.btn_get_as) Button getasbtn;
    @BindView(R.id.btn_dl_img) Button dlbtn;
    @BindView(R.id.btn_json) Button jsbtn;
    @BindView(R.id.sn_iv)
    ImageView iv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.okhttp3_main);

        ButterKnife.bind(this);

    }

    private String httpurl = "https://api.seniverse.com";
    private String S_KEY = "8gqkro1pbbhh4ijm";
    String API_KEY = "8gqkro1pbbhh4ijm";

    private Handler handler = new Handler()
    {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what)
            {
                case 1:
                    tv.setText(msg.obj.toString());
                    break;
                case 2:
                    iv.setImageBitmap((Bitmap)msg.obj);
                    break;
            }
        }
    };

    //增加拦截器
    private class RequestInterceptor implements Interceptor
    {
        @Override
        public com.squareup.okhttp.Response intercept(Chain chain) throws IOException {
            Request request = chain.request()
                    .newBuilder()
                    .addHeader("apikey",API_KEY)
                    .build();
            return chain.proceed(request);
        }
    }

    private OkHttpClient getOkHttpClient()
    {
        RequestInterceptor interceptor = new RequestInterceptor();
        OkHttpClient client = new OkHttpClient();
        client.interceptors().add(interceptor);
        return client;
    }

    /**
     * Retrofit2的get请求
     */
    @OnClick(R.id.btn_get) void okget()
    {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(httpurl)
                .addConverterFactory(GsonConverterFactory.create())
                .client(getOkHttpClient())
                .build();
        IWeather iWeather = retrofit.create(IWeather.class);
        Call<City> call = iWeather.getCity(API_KEY, "shenzhen");
        call.enqueue(new Callback<City>() {
            @Override
            public void onResponse(Response<City> response) {
                Message msg = Message.obtain();
                msg.what = 1;
                msg.obj = response.body().toString();
                handler.sendMessage(msg);
            }

            @Override
            public void onFailure(Throwable t) {

            }
        });

    }


    /**
     * retrofit2的get请求
     */
    @OnClick(R.id.btn_get_as) void okas()
    {
        /*
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(httpurl)
                .addConverterFactory(GsonConverterFactory.create())
                .client(new OkHttpClient())
                .build();
        IWeather iWeather = retrofit.create(IWeather.class);
        Call<City> call = iWeather.weather(API_KEY,"shenzhen");
        call.enqueue(new Callback<City>() {
            @Override
            public void onResponse(Response<City> response) {
                Message msg = Message.obtain();
                msg.what = 1;
                msg.obj = response.body().toString();
                handler.sendMessage(msg);
            }

            @Override
            public void onFailure(Throwable t) {

            }
        });
        */

    }

    @OnClick(R.id.btn_dl_img) void okrun()
    {


    }

    @OnClick(R.id.btn_json) void jb()
    {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(httpurl)
                .addConverterFactory(GsonConverterFactory.create())
                .client(new OkHttpClient())
                .build();
        IWeather iWeather = retrofit.create(IWeather.class);
        Call<City> call = iWeather.getCity(S_KEY,"shenzhen");
        call.enqueue(new Callback<City>() {
            @Override
            public void onResponse(Response<City> response) {
                Message msg = Message.obtain();
                msg.what = 1;
                msg.obj = response.body().toString();
                handler.sendMessage(msg);
            }

            @Override
            public void onFailure(Throwable t) {

            }
        });
    }
}
