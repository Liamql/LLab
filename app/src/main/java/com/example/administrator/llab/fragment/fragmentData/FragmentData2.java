package com.example.administrator.llab.fragment.fragmentData;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.administrator.llab.R;

/**
 * Created by Administrator on 2017/7/22 0022.
 */
public class FragmentData2 extends Fragment{

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootview = inflater.inflate(R.layout.fragment_d2,container,false);
        if(getArguments()!=null)
        {
            String text = getArguments().getString("data");
            TextView tv = (TextView)rootview.findViewById(R.id.tv);
            tv.setText(text);
        }
        return rootview;
    }
}
