package com.example.administrator.llab.proxy;

import android.util.Log;

/**
 * Created by Administrator on 2017/8/7 0007.
 */
public class ElectricCar implements Rechargable, Vehicle {

    @Override
    public void drive() {
        Log.e("ElectricCar","Electric Car is Moving silently...");
    }

    @Override
    public void recharge() {
        Log.e("ElectricCar","Electric Car is Recharging...");
    }

}