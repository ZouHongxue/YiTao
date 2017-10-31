package com.example.test;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.webkit.WebBackForwardList;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import java.util.ArrayList;

public class NewsDetail extends Activity {
    private WebView webView;
    private ArrayList<String> loadHistoryUrls = new ArrayList<String>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        webView = new WebView(this);
        //获得意图
        Intent intent = getIntent();
        //读取数据
        final String url = intent.getStringExtra("url");
        webView.getSettings().setJavaScriptEnabled(true);//设置webView属性，能够执行JavaScript脚本
        webView.loadUrl(url);//可以本地加载，也可网络加载
        loadHistoryUrls.add(url);
        setContentView(webView);

    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {

        //判断是否可以返回操作
        if ((keyCode == KeyEvent.KEYCODE_BACK) && webView.canGoBack()) {
            //获取历史列表
            WebBackForwardList webBackForwardList = webView.copyBackForwardList();
            if(webBackForwardList.getCurrentIndex()>0){
                //获取历史列表
                String historyUrl = webBackForwardList.getItemAtIndex(
                        webBackForwardList.getCurrentIndex()-1).getUrl();
                //按照自己规则检查是否为可跳转地址
                //注意：这里可根据自己逻辑循环判断，拿到可以跳转的那一个然后webView.goBackOrForward（steps）
                if(!historyUrl.contains("index.html")){
                    webView.goBack();
                    return true;
                }
            }
        }
        return super.onKeyDown(keyCode,event);
    }
}
