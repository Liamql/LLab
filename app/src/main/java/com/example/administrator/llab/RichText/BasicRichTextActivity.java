package com.example.administrator.llab.RichText;

import android.graphics.drawable.Drawable;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Html;
import android.text.method.ScrollingMovementMethod;
import android.widget.TextView;

import com.example.administrator.llab.R;

import java.io.InputStream;
import java.net.URL;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Administrator on 2017/8/8 0008.
 */
public class BasicRichTextActivity extends AppCompatActivity {

    @BindView(R.id.ll_richtv)
    TextView tv;

    String html = "<h1>this is h1</h1>"
            + "<p>This text is normal</p>"
            + "<img src='http://pic1.zhimg.com/v2-4b507e2b5b0207dcae071ac8c11adea4_r.jpg' />"
            + "<p>This text is normal2</p>"
            + "<img src='http://pic1.zhimg.com/v2-4b507e2b5b0207dcae071ac8c11adea4_r.jpg' />"
            + "<p>This text is normal3</p>"
            + "<img src='http://pic1.zhimg.com/v2-4b507e2b5b0207dcae071ac8c11adea4_r.jpg' />"
            + "<p>This text is normal6</p>"
            + "<img src='http://pic1.zhimg.com/v2-4b507e2b5b0207dcae071ac8c11adea4_r.jpg' />"
    + "<p>This text is normal4</p>"
            + "<img src='http://pic1.zhimg.com/v2-4b507e2b5b0207dcae071ac8c11adea4_r.jpg' />"
    + "<p>This text is normal5</p>"
            + "<img src='http://pic1.zhimg.com/v2-4b507e2b5b0207dcae071ac8c11adea4_r.jpg' />";

    String html2 = "我上个周在闲鱼上卖一支钢笔。<br>原来标价是8500，一位哥们就来问能不能便宜点啊。我说，行啊，8000拿走。<br>他说妥勒，要求我改价格。<br>我改价，他付款，我发货，他确认。<br>3天行云流水般熟练的操作，一次愉快的交易。<br><img data-rawheight=\"570\" src=\"https://pic2.zhimg.com/v2-27c41071ef6a49f12c29f3fad0a5b31d_b.jpg\" data-rawwidth=\"635\" class=\"origin_image zh-lightbox-thumb\" width=\"635\" data-original=\"https://pic2.zhimg.com/v2-27c41071ef6a49f12c29f3fad0a5b31d_r.jpg\"><br><br>不过，4天后。当我正准备拿着8000大洋准备搞事情的时候。<br>买家联系我说，大哥，还我72000块。<br>我？！？！！？<br>你改价改成8万了！<br>我点开支付宝一看，的确是8万(´Д` )<br><img data-rawheight=\"441\" src=\"https://pic2.zhimg.com/v2-288cead95fb01d24495e5436256692e9_b.jpg\" data-rawwidth=\"640\" class=\"origin_image zh-lightbox-thumb\" width=\"640\" data-original=\"https://pic2.zhimg.com/v2-288cead95fb01d24495e5436256692e9_r.jpg\"><br><img data-rawheight=\"204\" src=\"https://pic3.zhimg.com/v2-44026c4dbeb18048070eb98ee42942ee_b.jpg\" data-rawwidth=\"640\" class=\"origin_image zh-lightbox-thumb\" width=\"640\" data-original=\"https://pic3.zhimg.com/v2-44026c4dbeb18048070eb98ee42942ee_r.jpg\"><br><br><br>没错，两个视金钱如粪土的人(最爱粪土)！！！<br>就是有这样的操作";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.basic_rich_text_main);
        ButterKnife.bind(this);
        initData();
    }

    void initData() {

        URLImageParser urlImageParser = new URLImageParser(tv, this);
        tv.setMovementMethod(ScrollingMovementMethod.getInstance());
        tv.setText(Html.fromHtml(html2, new HtmlHttpImageGetter(tv), null));
        //tv.setText(Html.fromHtml(html2, urlImageParser, null));
    }




    Html.ImageGetter imgGetter = new Html.ImageGetter() {
        public Drawable getDrawable(String source) {
            InputStream is = null;
            Drawable d = null;
            try {
                is = (InputStream) new URL(source).getContent();
                d = Drawable.createFromStream(is, "src");
                d.setBounds(0, 0, d.getIntrinsicWidth(), d.getIntrinsicHeight());
                is.close();
                return d;
            } catch (Exception e) {
                return null;
            }
        }
    };
}
