package com.example.administrator.llab.proxy;

import android.util.Log;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * Created by Administrator on 2017/8/7 0007.
 */
public class InvocationHandlerImpl implements InvocationHandler {

    private ElectricCar car;

    public InvocationHandlerImpl(ElectricCar car)
    {
        this.car=car;
    }

    @Override
    public Object invoke(Object paramObject, Method paramMethod,
                         Object[] paramArrayOfObject) throws Throwable {
        Log.e("InvocationHandlerImpl","You are going to invoke " + paramMethod.getName() + " ...");
        paramMethod.invoke(car, null);
        Log.e("InvocationHandlerImpl",paramMethod.getName() + " invocation Has Been finished...");
        return null;
    }

}