package com.example.administrator.llab.fragment.fragmentData;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.administrator.llab.R;

/**
 * Created by Administrator on 2017/7/22 0022.
 */
public class FragDiff2 extends Fragment{


    private TextView tv;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootview = inflater.inflate(R.layout.frag_diff2,container,false);
        initView(rootview);
        return rootview;
    }

    void initView(View view)
    {
        tv = (TextView) view.findViewById(R.id.fragment2_tv);
    }

    void setText(String str)
    {
        tv.setText(str);
    }
}
