package com.example.administrator.llab.Dagger2;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Administrator on 2017/7/30 0030.
 */

@Module
public class DaggerActivityModule {

    DaggerActivity activity;

    DaggerActivityModule(DaggerActivity activity)
    {
        this.activity = activity;
    }

    @Provides
    DaggerActivity provideDaggerActivity()
    {
        return activity;
    }
}
