package com.example.administrator.llab.fragment.fragmentData;


import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.administrator.llab.R;

/**
 * Created by Administrator on 2017/7/22 0022.
 */
public class FragmentData extends FragmentActivity{

    private Button b1;
    private Button b2;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_data1);
        initView();
    }

    void initView()
    {
        b1 = (Button)findViewById(R.id.sameC);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(FragmentData.this,FDSame.class);
                startActivity(intent);
            }
        });

        b2 = (Button)findViewById(R.id.diffC);
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(FragmentData.this,FDiff.class);
                startActivity(intent);
            }
        });
    }
}
