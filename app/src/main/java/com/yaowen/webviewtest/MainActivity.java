package com.yaowen.webviewtest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private WebView webView;
    private Button conn;
    private EditText et_url;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        et_url = (EditText) findViewById(R.id.et_url);
        conn = (Button) findViewById(R.id.btn_conn);
        conn.setOnClickListener(this);
        webView = (WebView) findViewById(R.id.webView);
    }

    @Override
    public void onClick(View v) {

        if (v == conn) {
            webView.getSettings().setJavaScriptEnabled(true);
            webView.setWebViewClient(new WebViewClient() {
                @Override
                public boolean shouldOverrideUrlLoading(WebView view, String url) {
                    webView.loadUrl(url);// 根据传⼊的参数再去加载新的⺴⻚
                    return true;// 表⽰当前WebView可以处理打开新网络的请求，不⽤借助系统浏览器
                }
            });
            String url = et_url.getText().toString();
            webView.loadUrl(url);
        }
    }
}
