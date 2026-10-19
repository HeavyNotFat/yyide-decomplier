package com.yd.android_brand_mvp.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.TextView;

/* JADX INFO: loaded from: classes4.dex */
public class X5WebView extends WebView {
    private WebViewClient client;
    TextView title;

    public X5WebView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        WebViewClient webViewClient = new WebViewClient() { // from class: com.yd.android_brand_mvp.widget.X5WebView.1
            @Override // android.webkit.WebViewClient
            public boolean shouldOverrideUrlLoading(WebView webView, String str) {
                webView.loadUrl(str);
                return true;
            }
        };
        this.client = webViewClient;
        setWebViewClient(webViewClient);
        initWebViewSettings();
    }

    private void initWebViewSettings() {
        WebSettings settings = getSettings();
        settings.setJavaScriptEnabled(true);
        settings.setJavaScriptCanOpenWindowsAutomatically(true);
        settings.setAllowFileAccess(true);
        settings.setLayoutAlgorithm(WebSettings.LayoutAlgorithm.NARROW_COLUMNS);
        settings.setSupportZoom(true);
        settings.setBuiltInZoomControls(true);
        settings.setUseWideViewPort(true);
        settings.setSupportMultipleWindows(true);
        settings.setAppCacheEnabled(true);
        settings.setDomStorageEnabled(true);
        settings.setGeolocationEnabled(true);
        settings.setAppCacheMaxSize(Long.MAX_VALUE);
        settings.setCacheMode(2);
    }

    public X5WebView(Context context) {
        super(context);
        this.client = new WebViewClient() { // from class: com.yd.android_brand_mvp.widget.X5WebView.1
            @Override // android.webkit.WebViewClient
            public boolean shouldOverrideUrlLoading(WebView webView, String str) {
                webView.loadUrl(str);
                return true;
            }
        };
        setBackgroundColor(85621);
    }
}
