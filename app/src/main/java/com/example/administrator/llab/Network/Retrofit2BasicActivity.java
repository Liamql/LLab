package com.example.administrator.llab.Network;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

import com.example.administrator.llab.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit.Retrofit;

/**
 * Created by Administrator on 2017/7/27 0027.
 */
public class Retrofit2BasicActivity extends Activity {

    @BindView(R.id.sn_tv)
    TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.simple_network_main);

        ButterKnife.bind(this);

        retrofitRun();
    }

    void retrofitRun()
    {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://localhost:8090/")
                .build();
    }
}
