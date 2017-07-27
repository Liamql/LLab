package com.example.administrator.llab.Network;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

import com.example.administrator.llab.R;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Administrator on 2017/7/26 0026.
 */
public class SimpleHttpActivity extends Activity {

    @BindView(R.id.sn_tv)
    TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.simple_network_main);
        ButterKnife.bind(this);

        AsynNetUtils.get("http://www.baidu.com",new AsynNetUtils.Callback(){
            @Override
            public void onResponse(String response) {
                tv.setText(response);
            }
        });
    }
}
