package com.example.administrator.llab.Dagger2;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

import com.example.administrator.llab.R;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Administrator on 2017/7/30 0030.
 */
public class DaggerActivity extends Activity {

    @BindView(R.id.dg_tv)
    TextView tv;

    @Inject
    DaggerPresenter daggerPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dagger_main_activity);
        ButterKnife.bind(this);

        DaggerActivityComponent.builder()
                .daggerActivityModule(new DaggerActivityModule(this))
                .build()
                .inject(this);

        daggerPresenter.showUser();

    }

    public void showUser(String str)
    {
        tv.setText(str);
    }
}
