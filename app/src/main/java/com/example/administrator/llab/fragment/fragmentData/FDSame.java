package com.example.administrator.llab.fragment.fragmentData;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.widget.Button;

import com.example.administrator.llab.R;

/**
 * Created by Administrator on 2017/7/22 0022.
 */
public class FDSame extends FragmentActivity{

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_d);
        FragmentData1 f1 = new FragmentData1();
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.fd,f1);
        transaction.commit();
    }

}
