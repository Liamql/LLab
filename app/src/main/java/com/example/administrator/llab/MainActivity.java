package com.example.administrator.llab;

import android.graphics.drawable.AnimationDrawable;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;

public class MainActivity extends AppCompatActivity {


    Toolbar toolbar;
    DrawerLayout mainDrawerLayout;
    NavigationView nvLeftLayout;
    NavigationView nvRightLayout;

    private AnimationDrawable mAnimationDrawable;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findID();
        initView();
    }

    private void findID()
    {
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        mainDrawerLayout = (DrawerLayout) findViewById(R.id.main_drawer_layout);
        nvLeftLayout = (NavigationView) findViewById(R.id.nv_left_layout);
        nvRightLayout = (NavigationView) findViewById(R.id.nv_right_layout);
    }

    private void initView() {
        initToolBar(toolbar, false, "LLab");
        //监听home,想加滑动动画在这里加
        ActionBarDrawerToggle drawerToggle = new ActionBarDrawerToggle(this, mainDrawerLayout, toolbar, R.string.drawer_open, R.string.drawer_close)
        {
            @Override
            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);
                mAnimationDrawable.stop();
            }
            @Override
            public void onDrawerClosed(View drawerView) {
                super.onDrawerClosed(drawerView);
                mAnimationDrawable.start();
            }
        };
        drawerToggle.syncState();
    }

    //显示home图标
    public void initToolBar(Toolbar toolbar, boolean homeAsUpEnabled, String title) {
        toolbar.setTitle(title);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(homeAsUpEnabled);
    }
}
