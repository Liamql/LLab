package com.example.administrator.llab.Network;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.administrator.llab.Network.retrofit.City;
import com.example.administrator.llab.Network.retrofit.ICollection;
import com.example.administrator.llab.Network.retrofit.IWeather;
import com.example.administrator.llab.R;
import com.google.gson.Gson;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.io.InputStream;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

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
        public Response intercept(Chain chain) throws IOException {
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
                .build();
        IWeather iWeather = retrofit.create(IWeather.class);
        Call<City> call = iWeather.getCity(API_KEY, "shenzhen");
        call.enqueue(new Callback<City>() {
            @Override
            public void onResponse(Call<City> call, retrofit2.Response<City> response) {
                Message msg = Message.obtain();
                msg.what = 1;
                msg.obj = response.body().toString();
                handler.sendMessage(msg);
            }

            @Override
            public void onFailure(Call<City> call, Throwable t) {

            }
        });

    }


    /**
     * retrofit2的get请求
     */
    @OnClick(R.id.btn_get_as) void okas()
    {

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://www.zhihu.com")
                .client(new OkHttpClient())
                .build();
        ICollection iCollection = retrofit.create(ICollection.class);
        Call<ResponseBody> call = iCollection.getCollection("31241928");
        call.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, retrofit2.Response<ResponseBody> response) {

                try {
                    String result = response.body().string();
                    Message msg = Message.obtain();
                    msg.what = 1;
                    msg.obj = result;
                    handler.sendMessage(msg);
                }
                catch (IOException e){e.printStackTrace();}
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {

            }
        });


    }

    @OnClick(R.id.btn_dl_img) void okrun()
    {


    }

    @OnClick(R.id.btn_json) void jb()
    {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(httpurl)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        IWeather iWeather = retrofit.create(IWeather.class);
        Call<City> call = iWeather.getCity(S_KEY,"shenzhen");
        call.enqueue(new Callback<City>() {
            @Override
            public void onResponse(Call<City> call, retrofit2.Response<City> response) {
                Message msg = Message.obtain();
                msg.what = 1;
                msg.obj = response.body().toString();
                handler.sendMessage(msg);
            }

            @Override
            public void onFailure(Call<City> call, Throwable t) {

            }
        });
    }
}
