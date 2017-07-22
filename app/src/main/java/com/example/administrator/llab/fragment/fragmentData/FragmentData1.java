package com.example.administrator.llab.fragment.fragmentData;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.administrator.llab.R;

/**
 * Created by Administrator on 2017/7/22 0022.
 */
public class FragmentData1 extends Fragment{

    private Button b1;
    private Button b2;
    private Button b3;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootview = inflater.inflate(R.layout.fragment_d1,container,false);
        initView(rootview);
        return rootview;
    }

    void initView(View view)
    {
        b1 = (Button)view.findViewById(R.id.BA);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentData2 f2 = new FragmentData2();
                FragmentTransaction transaction = getFragmentManager().beginTransaction();
                Bundle args = new Bundle();
                args.putString("data","A");
                f2.setArguments(args);
                transaction.replace(R.id.fd,f2);
                transaction.commit();
            }
        });

        b2 = (Button)view.findViewById(R.id.BB);
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentData2 f2 = new FragmentData2();
                FragmentTransaction transaction = getFragmentManager().beginTransaction();
                Bundle args = new Bundle();
                args.putString("data","B");
                f2.setArguments(args);
                transaction.replace(R.id.fd,f2);
                transaction.commit();
            }
        });

        b3 = (Button)view.findViewById(R.id.BC);
        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentData2 f2 = new FragmentData2();
                FragmentTransaction transaction = getFragmentManager().beginTransaction();
                Bundle args = new Bundle();
                args.putString("data","C");
                f2.setArguments(args);
                transaction.replace(R.id.fd,f2);
                transaction.commit();
            }
        });
    }
}
