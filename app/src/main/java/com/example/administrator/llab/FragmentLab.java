package com.example.administrator.llab;

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

import com.example.administrator.llab.fragment.fragmentData.FragmentData;
import com.example.administrator.llab.fragment.fragmentBase.FragmentTest;

/**
 * Created by Administrator on 2017/7/22 0022.
 */
public class FragmentLab extends Fragment{

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_lab_main,container,false);
        initView(rootView);
        return rootView;
    }

    void initView(View view)
    {
        Button b1 = (Button)view.findViewById(R.id.fragbase);
        Button b2 = (Button)view.findViewById(R.id.fragTran);
        
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(),FragmentTest.class);
                startActivity(intent);
            }
        });

        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(),FragmentData.class);
                startActivity(intent);
            }
        });
    }
}
