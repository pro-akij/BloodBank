package com.something.iccworldcup2019;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class PointTable extends AppCompatActivity {
    private WebView webView;
    private String url="https://www.cricbuzz.com/cricket-series/2697/icc-cricket-world-cup-2019/points-table";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_point_table);

        webView = findViewById(R.id.webview2);
        WebSettings webSettings = webView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        webView.setWebViewClient(new WebViewClient());
        webView.loadUrl(url);
    }

    @Override
    public void onBackPressed() {
    }
}
