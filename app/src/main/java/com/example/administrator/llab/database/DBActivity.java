package com.example.administrator.llab.database;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.example.administrator.llab.R;

import java.io.File;
import java.io.IOException;
import java.io.OutputStream;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Administrator on 2017/8/4 0004.
 */
public class DBActivity extends AppCompatActivity {

    @BindView(R.id.dc_tv)
    TextView tv;

    private DBOpenHelper helper = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.disk_cache_layout);
        ButterKnife.bind(this);

        init();
        initData();
    }

    void init()
    {
        helper = new DBOpenHelper(this);
    }

    void initData()
    {
        String url = "<p>中文aaa666</p>";
        String content = "还是中文";

        String res = queryItem(url);
        if(res==null)
        {
            insert(url,content);
            res = queryItem(url);
        }
        tv.setText(res);

    }

    public String queryItem(String url)
    {
        SQLiteDatabase db = helper.getReadableDatabase();
        if(db.isOpen())
        {
            Cursor cursor= db.rawQuery("select * from collectionlist where url= ?;", new String []{url});
            if(cursor!=null&&cursor.moveToFirst())
            {
                String res = cursor.getString(1);
                db.close();
                return res;
            }
            db.close();
        }
        return null;
    }

    public void insert(String url,String content)
    {
        SQLiteDatabase db = helper.getWritableDatabase();
        if(db.isOpen())
        {
            db.execSQL("insert into collectionlist(url, content) values(?, ?);",
                    new Object[]{url,content});
            db.close();
        }
    }
}
