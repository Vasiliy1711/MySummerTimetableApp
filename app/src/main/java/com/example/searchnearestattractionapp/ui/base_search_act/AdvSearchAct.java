package com.example.searchnearestattractionapp.ui.base_search_act;

import android.annotation.TargetApi;
import android.os.Build;
import android.os.Bundle;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.searchnearestattractionapp.R;

public class AdvSearchAct extends AppCompatActivity
{
    private WebView webView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_adv_search);
        webView = findViewById(R.id.webView);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.loadUrl("https://rasp.yandex.ru/informers/widgets/search/vert");
        webView.setWebViewClient(new MyWebViewClient());
    }

    @Override
    public void onBackPressed()
    {

        if (webView.canGoBack())
        {
            webView.goBack();
        }else
        {
            super.onBackPressed();
        }
    }

    private class MyWebViewClient extends WebViewClient
    {
        @TargetApi(Build.VERSION_CODES.N)
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request)
        {
            view.loadUrl(request.getUrl().toString());
            return true;
        }
    }
}




//  webView = findViewById(R.id.webView);
//    // включаем поддержку JavaScript
//    webView.getSettings().setJavaScriptEnabled(true);
//    // указываем страницу загрузки
//    webView.loadUrl("http://developer.alexanderklimov.ru/android");