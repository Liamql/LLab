package com.example.administrator.llab.fragment.fragmentBase;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.administrator.llab.R;

/**
 * Created by Administrator on 2017/7/21 0021.
 */
public class Fragment3 extends Fragment{

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootview = inflater.inflate(R.layout.fragment3, container, false);
        return rootview;
    }
}
