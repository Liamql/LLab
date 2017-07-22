package com.example.administrator.llab.fragment.fragmentData;

import android.app.FragmentManager;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;

import com.example.administrator.llab.R;

/**
 * Created by Administrator on 2017/7/22 0022.
 */
public class FDiff extends FragmentActivity implements FragDiff1.titleSelectInterface{

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_diff_main);
    }

    @Override
    public void setTitle(String str) {
        FragDiff2 fd2 = (FragDiff2)getSupportFragmentManager().findFragmentById(R.id.fragment2);
        fd2.setText(str);
    }

}
