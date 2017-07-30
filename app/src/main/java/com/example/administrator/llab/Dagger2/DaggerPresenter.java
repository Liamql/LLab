package com.example.administrator.llab.Dagger2;

import javax.inject.Inject;

import dagger.Component;
import dagger.Module;
import dagger.Provides;

/**
 * Created by Administrator on 2017/7/30 0030.
 */
public class DaggerPresenter {

    DaggerActivity daggerActivity;

    User user;

    @Inject
    DaggerPresenter(DaggerActivity daggerActivity)
    {
        this.daggerActivity = daggerActivity;
    }

    void showUser()
    {
        user = new User("a","123");
        daggerActivity.showUser(user.toString());
    }

}
