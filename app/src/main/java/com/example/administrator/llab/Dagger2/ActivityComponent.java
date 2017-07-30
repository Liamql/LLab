package com.example.administrator.llab.Dagger2;

import dagger.Component;

/**
 * Created by Administrator on 2017/7/30 0030.
 */
@Component(modules = DaggerActivityModule.class)
public interface ActivityComponent
{
    void inject(DaggerActivity activity);
}
