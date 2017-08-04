package com.example.administrator.llab.cache;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.example.administrator.llab.R;
import com.jakewharton.disklrucache.DiskLruCache;

import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.security.NoSuchAlgorithmException;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Administrator on 2017/8/4 0004.
 */
public class DiskCacheActivity extends AppCompatActivity {

    @BindView(R.id.dc_tv)
    TextView tv;

    DiskLruCache mDiskLruCache = null;
    private String mKey;

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
        try {
            File cacheDir = DiskLrucacheUtils.getDiskCacheDir(this, "bitmap");
            if (!cacheDir.exists()) {
                cacheDir.mkdirs();
            }
            mDiskLruCache = DiskLruCache.open(cacheDir, DiskLrucacheUtils.getAppVersion(this), 1, 10 * 1024 * 1024);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    void initData()
    {

        try {
            String Url = "<p>真的</p>";

            if(mDiskLruCache!=null)
            {

            }

            String key = DiskLrucacheUtils.getKey(Url);
            DiskLruCache.Editor editor = mDiskLruCache.edit(key);
            if (editor != null) {
                OutputStream outputStream = editor.newOutputStream(0);
                if (inputData(outputStream)) {
                    editor.commit();
                } else {
                    editor.abort();
                }
            }
            mDiskLruCache.flush();
        }
        catch (Exception e){e.printStackTrace();}
    }

    Boolean inputData(OutputStream out)
    {
        try{
            String str = "Hello World!!!" ;  // 准备一个字符串
            byte b[] = str.getBytes() ;   // 只能输出byte数组，所以将字符串变为byte数组
            out.write(b);
            return true;
        }
        catch (Exception e){e.printStackTrace();}
        return false;
    }
}
