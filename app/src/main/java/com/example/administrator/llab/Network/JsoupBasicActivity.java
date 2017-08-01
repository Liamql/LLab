package com.example.administrator.llab.Network;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.text.method.ScrollingMovementMethod;
import android.util.Log;
import android.widget.Button;
import android.widget.TextView;

import com.example.administrator.llab.R;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by Administrator on 2017/8/2 0002.
 */
public class JsoupBasicActivity extends AppCompatActivity{

    @BindView(R.id.sn_tv)
    TextView tv;

    @BindView(R.id.btn_get)
    Button getbtn;

    @BindView(R.id.btn_get_as) Button getasbtn;
    @BindView(R.id.btn_dl_img) Button dlbtn;
    @BindView(R.id.btn_json) Button jsbtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.okhttp3_main);

        ButterKnife.bind(this);

        tv.setMovementMethod(ScrollingMovementMethod.getInstance());

    }

    private Handler mHandler = new Handler()
    {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what)
            {
                case 1:
                    tv.setText(msg.obj.toString());
                    break;
            }
        }
    };

    @OnClick(R.id.btn_get) void getHtml()
    {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Document doc = Jsoup.connect("http://www.zhihu.com/collection/31241928").get();
                    Elements list_title_container = doc.select("div.zg-section-title");
                    Document TitleDoc = Jsoup.parse(list_title_container.toString());
                    Elements collectionTitle = TitleDoc.select("h2");
                    Message msg = Message.obtain();
                    msg.what =1;
                    msg.obj =collectionTitle.text();
                    mHandler.sendMessage(msg);

                    Element item_container = doc.getElementById("zh-list-collection-wrap");
                    Document itemCtrDoc = Jsoup.parse(item_container.toString());
                    Elements clearfix = itemCtrDoc.select(".zm-item");  //选择器的形式
                    for(Element zmItem : clearfix)
                    {
                        Document zmItemDoc = Jsoup.parse(zmItem.toString());
                        Elements title = zmItemDoc.select("h2");
                        Log.e("J",title.text());
                        Elements zm_item_answer = zmItemDoc.select("div.zm-item-answer");
                        Document zm_item_answer_doc = Jsoup.parse(zm_item_answer.toString());
                        Elements herf = zm_item_answer_doc.select("link");
                        Log.e("J",herf.attr("herf"));
                        Elements summary_wrapper = zm_item_answer_doc.select("span.summary-wrapper");
                        Document summary_wrapper_doc = Jsoup.parse(summary_wrapper.toString());
                        Elements author = zm_item_answer_doc.select("span.author-link-line");
                        Log.e("J",author.text());



                    }
                }
                catch (Exception e){e.printStackTrace();}
            }
        }).start();
    }

}
