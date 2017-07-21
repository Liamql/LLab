package com.example.administrator.llab;


import android.app.FragmentManager;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.example.administrator.llab.fragment.Fragment1;
import com.example.administrator.llab.fragment.Fragment2;
import com.example.administrator.llab.fragment.Fragment3;


/**
 * Created by Administrator on 2017/7/21 0021.
 */
public class FragmentTest extends Fragment implements View.OnClickListener{

    private Button addF1;
    private Button addF2;
    private Button addF3;
    private Button hideF1;
    private Button hideF2;
    private Button showF1;
    private Button showF2;
    private Button deF3;
    private Button deF2;
    private Button atF3;
    private Button atF2;
    private Button rmF2;
    private Button rpF1;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View rootview = inflater.inflate(R.layout.fragment_main,container,false);
        initView(rootview);
        initListener();
        return rootview;
    }

    void initView(View view)
    {
        addF1 = (Button) view.findViewById(R.id.btn_add_frag1);
        addF2 = (Button) view.findViewById(R.id.btn_add_frag2);
        addF3 = (Button) view.findViewById(R.id.btn_add_frag3);
        hideF1 = (Button) view.findViewById(R.id.btn_hide_frag1);
        hideF2 = (Button) view.findViewById(R.id.btn_hide_frag2);
        showF1 = (Button) view.findViewById(R.id.btn_show_frag1);
        showF2 = (Button) view.findViewById(R.id.btn_show_frag2);
        atF2 = (Button) view.findViewById(R.id.btn_attach_frag2);
        atF3 = (Button) view.findViewById(R.id.btn_attach_frag3);
        deF2 = (Button) view.findViewById(R.id.btn_detach_frag2);
        deF3 = (Button) view.findViewById(R.id.btn_detach_frag3);
        rmF2 = (Button) view.findViewById(R.id.btn_remove_frag2);
        rpF1 = (Button) view.findViewById(R.id.btn_replace_frag1);
    }

    void initListener()
    {
        addF1.setOnClickListener(this);
        addF2.setOnClickListener(this);
        addF3.setOnClickListener(this);
        hideF1.setOnClickListener(this);
        hideF2.setOnClickListener(this);
        atF2.setOnClickListener(this);
        atF3.setOnClickListener(this);
        deF2.setOnClickListener(this);
        deF3.setOnClickListener(this);
        showF1.setOnClickListener(this);
        showF2.setOnClickListener(this);
        rmF2.setOnClickListener(this);
        rpF1.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch(v.getId())
        {
            case R.id.btn_add_frag1:
                Fragment1 fragment1 = new Fragment1();
                addFragment(fragment1,"fragment1");
                Toast.makeText(getContext(),"addF1",Toast.LENGTH_SHORT).show();
                break;
            case R.id.btn_add_frag2:
                Fragment2 fragment2 = new Fragment2();
                addFragment(fragment2,"fragment2");
                break;
            case R.id.btn_add_frag3:
                Fragment3 fragment3 = new Fragment3();
                addFragment(fragment3, "fragment3");
                break;
            case R.id.btn_remove_frag2:
                removeFragment2();
                break;
            case R.id.btn_replace_frag1:
                Fragment f1 = new Fragment1();
                replaceFragment1(f1, "fragment1");
            case R.id.btn_attach_frag2:
                attachF("fragment2");
                break;
            case R.id.btn_attach_frag3:
                Fragment3 f3 = new Fragment3();
                attachF("fragment3");
                break;
            case R.id.btn_detach_frag2:
                detachF("fragment2");
                break;
            case R.id.btn_detach_frag3:
                detachF("fragment3");
                break;
            case R.id.btn_hide_frag1:
                hideF("fragment1");
                break;
            case R.id.btn_show_frag1:
                showF("fragment1");
                break;
            case R.id.btn_hide_frag2:
                hideF("fragment2");
                break;
            case R.id.btn_show_frag2:
                showF("fragment2");
                break;
            default:
                break;
        }
    }

    void addFragment(Fragment fragment,String tag)
    {
        FragmentTransaction transaction = getFragmentManager().beginTransaction();
        transaction.add(R.id.fragment_container,fragment,tag);
        transaction.commit();
    }

    private void removeFragment2() {
        FragmentTransaction transaction = getFragmentManager().beginTransaction();
        transaction.remove(getFragmentManager().findFragmentByTag("fragment2"));
        transaction.commit();
    }

    private void replaceFragment1(Fragment fragment,String tag) {
        FragmentTransaction transaction = getFragmentManager().beginTransaction();
        transaction.replace(R.id.fragment_container, fragment, tag);
        transaction.commit();
    }

    private void detachF(String tag)
    {
        FragmentTransaction transaction = getFragmentManager().beginTransaction();
        transaction.detach(getFragmentManager().findFragmentByTag(tag));
        transaction.commit();
    }

    private void attachF(String tag)
    {
        FragmentTransaction transaction = getFragmentManager().beginTransaction();
        transaction.attach(getFragmentManager().findFragmentByTag(tag));
        transaction.commit();
    }

    private void hideF(String tag)
    {
        FragmentTransaction transaction = getFragmentManager().beginTransaction();
        transaction.hide(getFragmentManager().findFragmentByTag(tag));
        transaction.commit();
    }

    private void showF(String tag)
    {
        FragmentTransaction transaction = getFragmentManager().beginTransaction();
        transaction.show(getFragmentManager().findFragmentByTag(tag));
        transaction.commit();
    }
}
