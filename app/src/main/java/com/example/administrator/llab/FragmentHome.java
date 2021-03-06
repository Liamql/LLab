package com.example.administrator.llab;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.administrator.llab.Dagger2.DaggerActivity;
import com.example.administrator.llab.FragmentLab;
import com.example.administrator.llab.IPC.handlerBasic;
import com.example.administrator.llab.Network.JsoupBasicActivity;
import com.example.administrator.llab.Network.OkHttp3BasicActivity;
import com.example.administrator.llab.Network.Retrofit2BasicActivity;
import com.example.administrator.llab.Network.SimpleHttpActivity;
import com.example.administrator.llab.R;
import com.example.administrator.llab.RichText.BasicRichTextActivity;
import com.example.administrator.llab.Thread.ThreadActitvity;
import com.example.administrator.llab.Thread.ThreadPoolActivity;
import com.example.administrator.llab.annotation.anno_RT;
import com.example.administrator.llab.broadcast.BasicBroadcastActivity;
import com.example.administrator.llab.database.DBActivity;
import com.example.administrator.llab.proxy.DyProxyInterfaceActivity;
import com.example.administrator.llab.reflection.ref_base;
import com.example.administrator.llab.service.AIDLSimpleActivity;
import com.example.administrator.llab.service.ServiceBasicActivity;
import com.example.administrator.llab.view.ShapeViewActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by Administrator on 2017/7/23 0023.
 */
public class FragmentHome extends Fragment {

    @BindView(R.id.tv_retrofit)
    TextView tvRetrofit;
    @BindView(R.id.ll_okhttp)
    LinearLayout llOkhttp;
    @BindView(R.id.ll_multi_thread)
    LinearLayout llMultiThread;
    @BindView(R.id.tv_thread_pool)
    TextView tvThreadPool;
    @BindView(R.id.tv_thread)
    TextView tvThread;
    @BindView(R.id.tv_reflection)
    TextView tvReflection;
    @BindView(R.id.tv_annotation)
    TextView tvAnnotation;
    @BindView(R.id.ll_shape_view)
    LinearLayout llShapeView;
    @BindView(R.id.tv_MarqueeView)
    TextView tvMarqueeView;
    @BindView(R.id.tv_ShareView)
    TextView tvShareView;
    @BindView(R.id.ll_status_bar)
    LinearLayout llStatusBar;
    @BindView(R.id.tv_Bezier)
    TextView tvBezier;
    @BindView(R.id.ll_rv_list)
    LinearLayout llRvList;
    @BindView(R.id.tv_multi_theme)
    TextView tvMultiTheme;
    @BindView(R.id.tv_CircleTextView)
    TextView tvCircleTextView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootview = inflater.inflate(R.layout.fragment_home,container,false);
        ButterKnife.bind(this,rootview);
        return rootview;
    }

    @OnClick(R.id.tv_annotation) void toAn()
    {
        Intent intent = new Intent(getContext(), anno_RT.class);
        startActivity(intent);
    }

    @OnClick(R.id.tv_reflection) void toRe()
    {
        Intent intent = new Intent(getContext(), ref_base.class);
        startActivity(intent);
    }

    @OnClick(R.id.tv_thread) void toTh()
    {
        Intent intent = new Intent(getContext(), ThreadActitvity.class);
        startActivity(intent);
    }

    @OnClick(R.id.tv_thread_pool) void toTP()
    {
        Intent intent = new Intent(getContext(), ThreadPoolActivity.class);
        startActivity(intent);
    }

    @OnClick(R.id.tv_service) void toSer()
    {
        Intent intent = new Intent(getContext(), ServiceBasicActivity.class);
        startActivity(intent);
    }

    @OnClick(R.id.tv_aidl) void toAI()
    {
        Intent intent = new Intent(getContext(), AIDLSimpleActivity.class);
        startActivity(intent);
    }

    @OnClick(R.id.ll_handler) void toPo()
    {
        Intent intent = new Intent(getContext(), handlerBasic.class);
        startActivity(intent);
    }

    @OnClick(R.id.ll_broadcast) void toBr()
    {
        Intent intent = new Intent(getContext(), BasicBroadcastActivity.class);
        startActivity(intent);
    }

    @OnClick(R.id.ll_shape_view) void toSh()
    {
        Intent intent = new Intent(getContext(), ShapeViewActivity.class);
        startActivity(intent);
    }

    @OnClick(R.id.tv_http_url) void toHT()
    {
        Intent intent = new Intent(getContext(), SimpleHttpActivity.class);
        startActivity(intent);
    }

    @OnClick(R.id.ll_okhttp) void toOK()
    {
        Intent intent = new Intent(getContext(), OkHttp3BasicActivity.class);
        startActivity(intent);
    }

    @OnClick(R.id.tv_retrofit) void toRF()
    {
        Intent intent = new Intent(getContext(), Retrofit2BasicActivity.class);
        startActivity(intent);
    }

    @OnClick(R.id.tv_dagger) void toDA()
    {
        Intent intent = new Intent(getContext(), DaggerActivity.class);
        startActivity(intent);
    }

    @OnClick(R.id.tv_jsoup) void toJP()
    {
        Intent intent = new Intent(getContext(), JsoupBasicActivity.class);
        startActivity(intent);
    }

    @OnClick(R.id.ll_disk_cache) void toDC()
    {
        Intent intent = new Intent(getContext(), DBActivity.class);
        startActivity(intent);
    }

    @OnClick(R.id.tv_proxy_inter) void toPr()
    {
        Intent intent = new Intent(getContext(), DyProxyInterfaceActivity.class);
        startActivity(intent);
    }

    @OnClick(R.id.tv_rich_tv) void toRT()
    {
        Intent intent = new Intent(getContext(), BasicRichTextActivity.class);
        startActivity(intent);
    }

}
