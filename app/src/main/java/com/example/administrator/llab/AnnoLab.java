package com.example.administrator.llab;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.administrator.llab.annotation.MyTag;
import com.example.administrator.llab.annotation.anno_RT;
import com.example.administrator.llab.annotation.anno_bknife;

/**
 * Created by Administrator on 2017/7/23 0023.
 */
public class AnnoLab extends Fragment {

    private Button basic;
    private Button adv;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.anno_lab_main, container, false);
        initView(rootView);
        return rootView;
    }

    void initView(View view)
    {
        basic = (Button) view.findViewById(R.id.anno_base);
        adv = (Button) view.findViewById(R.id.anno_more);
        basic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(),anno_RT.class);
                startActivity(intent);
            }
        });

        adv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(),anno_bknife.class);
                startActivity(intent);
            }
        });
    }
}