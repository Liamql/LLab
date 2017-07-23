package com.example.administrator.llab.reflection;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import com.example.administrator.llab.R;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Administrator on 2017/7/23 0023.
 */
public class ref_base extends AppCompatActivity {

    @BindView(R.id.tv_info)
    TextView tv;

    @BindView(R.id.toolbar)
    Toolbar toolbar;

    private int i = 10;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reflection);
        ButterKnife.bind(this);

        initToolBar(toolbar, true, "反射");
        getClassObj();
    }

    public void initToolBar(Toolbar toolbar, boolean homeAsUpEnabled, String title) {
        toolbar.setTitle(title);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(homeAsUpEnabled);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_reflection, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.item_getClassObj:
                getClassObj();
                return true;
            case R.id.item_getFieldsInfo:
                getFieldsInfo();
                return true;
            case R.id.item_getMethodsInfo:
                getMethodsInfo();
                return true;
            case R.id.item_modifyFieldValue:
                modifyFieldValue();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    private void getClassObj()
    {
        Class<?> c1 = ref_base.class;

        ref_base acitvity = new ref_base();
        Class<?> c2 = acitvity.getClass();

        Class<?> c3 = null;
        try {
            c3 = Class.forName("com.example.administrator.llab.reflection.ref_base");
        }
        catch (ClassNotFoundException e){e.printStackTrace();}

        StringBuilder sb = new StringBuilder();
        sb.append("cls1: ").append(c1).append("\n\n");
        sb.append("cls2: ").append(c2).append("\n\n");
        sb.append("cls3: ").append(c3);
        tv.setText(sb.toString());
        toolbar.setSubtitle("三种方式获得类对象");
    }

    private void getFieldsInfo()
    {
        Class<?> c1 = ref_base.class;
        Field[] fields = c1.getDeclaredFields();
        if(fields==null) return;

        StringBuilder sb = new StringBuilder();
        for (Field field:fields) {
            sb.append(Modifier.toString(field.getModifiers())).append(" ");
            sb.append(field.getType().getSimpleName()).append(" ");
            sb.append(field.getName()).append(";");
            sb.append("\n\n");
        }

        tv.setText(sb.toString());
        toolbar.setSubtitle("获得类的所有属性信息");
    }

    private void getMethodsInfo()
    {
        Class<?> c1 = ref_base.class;
        Method[] methods = c1.getDeclaredMethods();
        if(methods==null) return;

        StringBuilder sb = new StringBuilder();
        for (Method method:methods) {
            sb.append(Modifier.toString(method.getModifiers())).append(" ");
            sb.append(method.getReturnType()).append(" ");
            sb.append(method.getName()).append("(");
            Class[] parameters = method.getParameterTypes();
            if (parameters != null) {
                for (int i=0; i<parameters.length; i++) {
                    Class paramCls = parameters[i];
                    sb.append(paramCls.getSimpleName());
                    if (i < parameters.length - 1) sb.append(", ");
                }
            }
            sb.append(")\n\n");
        }

        tv.setText(sb.toString());
        toolbar.setSubtitle("获得类的所有方法信息");
    }

    private void modifyFieldValue()
    {
        Class<?> c1 = ref_base.class;

        Field[] fields = c1.getDeclaredFields();
        if (fields == null) return;

        StringBuilder sb = new StringBuilder();
        sb.append("获得类的所有属性信息：\n\n");
        for (Field field:fields) {
            sb.append(Modifier.toString(field.getModifiers())).append(" ");
            sb.append(field.getType().getSimpleName()).append(" ");
            sb.append(field.getName()).append(";");
            sb.append("\n\n");
        }

        try {
            sb.append("属性i的默认值：i = ");
            Field f = c1.getDeclaredField("i");
            sb.append(f.getInt("i")).append("\n\n");
            f.set("i", 100);
            sb.append("属性i修改后的值：i = ");
            sb.append(f.getInt("i")).append("\n\n");
        } catch (Exception e) {
            e.printStackTrace();
        }

        tv.setText(sb.toString());
        toolbar.setSubtitle("修改类型Int属性i的值");
    }


}
