package com.example.administrator.llab;

import android.graphics.drawable.AnimationDrawable;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;

import com.example.administrator.llab.fragment.fragmentBase.FragmentTest;

public class MainActivity extends AppCompatActivity {


    Toolbar toolbar;
    DrawerLayout mainDrawerLayout;
    NavigationView nvLeftLayout;
    NavigationView nvRightLayout;

    private MenuItem leftCheckedItem;
    private MenuItem rightCheckedItem;

    public int lastFragmentIndex = 0;

    private AnimationDrawable mAnimationDrawable;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findID();
        initView();
        initListener();
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
        controlShowFragment(0);
    }

    //显示home图标
    public void initToolBar(Toolbar toolbar, boolean homeAsUpEnabled, String title) {
        toolbar.setTitle(title);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(homeAsUpEnabled);
    }

    private void initListener()
    {
        nvLeftLayout.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem item) {
                if (rightCheckedItem != null && rightCheckedItem.isChecked()) {
                    rightCheckedItem.setChecked(false);
                }
                leftCheckedItem = item;

                switch (item.getItemId()) {
                    case R.id.left_menu_fragment:
                        controlShowFragment(1);
                        toolbar.setTitle(R.string.left_menu_fragment);
                        break;
                    case R.id.left_menu_anno:
                        controlShowFragment(2);
                        toolbar.setTitle(R.string.left_menu_anno);
                        break;
                    default:
                        controlShowFragment(0);
                        toolbar.setTitle(R.string.app_name);
                        break;
                }
                //getSettingsSharedPreferences().lastFragmentIndex(lastFragmentIndex);
                item.setChecked(true);
                mainDrawerLayout.closeDrawer(Gravity.LEFT);
                return true;
            }
        });
    }

    private Fragment getLeftFragment(int position) {
        Fragment fragment;
        switch (position) {
            case 1:
                fragment = new FragmentLab();
                break;
            case 2:
                fragment = new AnnoLab();
                break;
            default:
                fragment = new FragmentHome();
                break;
        }
        return fragment;
    }

    private String makeTag(int position) {
        return R.id.fl_container + "_" + position;
    }

    //显示相应的Fragment
    private void controlShowFragment(int position) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        Fragment lastFragment = fragmentManager.findFragmentByTag(makeTag(lastFragmentIndex));
        if (lastFragment != null) {
            fragmentTransaction.hide(lastFragment);
        }
        lastFragmentIndex = position;

        Fragment currentFragment = fragmentManager.findFragmentByTag(makeTag(position));
        if (currentFragment != null) {
            fragmentTransaction.show(currentFragment);
        } else {
            if (mainDrawerLayout.isDrawerOpen(Gravity.LEFT)) {
                fragmentTransaction.add(R.id.fl_container, getLeftFragment(position), makeTag(position));
            } else if (mainDrawerLayout.isDrawerOpen(Gravity.RIGHT)) {
                //fragmentTransaction.add(R.id.fl_container, getRightFragment(position), makeTag(position));
            } else {
                //fragmentTransaction.add(R.id.fl_container, getRightFragment(0), makeTag(position));
            }
        }
        fragmentTransaction.commitAllowingStateLoss();
    }
}
