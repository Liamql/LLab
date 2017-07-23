package com.example.administrator.llab.annotation;

import android.app.Activity;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Created by Administrator on 2017/7/23 0023.
 */
public class MyAnnoUtils {

    public static void ltag(Activity activity)
    {
        Class<? extends Activity> obj = activity.getClass();
        Field[] field = obj.getDeclaredFields();
        for(Field fd:field)
        {
            MyTag myTag = fd.getAnnotation(MyTag.class);
            if(myTag!=null)
            {
                int viewid = myTag.value();
                if(viewid!=-1)
                {
                    try
                    {
                        Method method = obj.getMethod("findViewById",int.class);
                        Object resobj = method.invoke(activity, viewid);
                        fd.setAccessible(true);
                        fd.set(activity,resobj);
                    }
                    catch (NoSuchMethodException e)
                    {e.printStackTrace();}
                    catch (IllegalAccessException e)
                    {e.printStackTrace();}
                    catch (InvocationTargetException e)
                    {e.printStackTrace();}
                }
            }
        }
    }
}
