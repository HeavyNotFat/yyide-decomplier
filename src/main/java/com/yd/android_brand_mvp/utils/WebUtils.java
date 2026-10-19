package com.yd.android_brand_mvp.utils;

import android.os.Environment;
import android.webkit.WebSettings;
import android.webkit.WebView;
import java.io.File;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: WebUtils.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fR\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b¨\u0006\r"}, d2 = {"Lcom/yd/android_brand_mvp/utils/WebUtils;", "", "()V", "cacheDirPath", "", "getCacheDirPath", "()Ljava/lang/String;", "setCacheDirPath", "(Ljava/lang/String;)V", "initWebView", "", "webView", "Landroid/webkit/WebView;", "app_commonRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class WebUtils {
    public static final WebUtils INSTANCE = new WebUtils();
    private static String cacheDirPath = Environment.getExternalStorageDirectory().toString() + File.separator + "brand_webview";

    private WebUtils() {
    }

    public final String getCacheDirPath() {
        return cacheDirPath;
    }

    public final void setCacheDirPath(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        cacheDirPath = str;
    }

    public final void initWebView(WebView webView) {
        Intrinsics.checkNotNullParameter(webView, "webView");
        WebSettings settings = webView.getSettings();
        Intrinsics.checkNotNullExpressionValue(settings, "webView.settings");
        settings.setAllowFileAccessFromFileURLs(true);
        settings.setJavaScriptEnabled(true);
        settings.setAppCacheEnabled(true);
        settings.setDomStorageEnabled(true);
        settings.supportMultipleWindows();
        settings.setAllowContentAccess(true);
        settings.setLayoutAlgorithm(WebSettings.LayoutAlgorithm.NARROW_COLUMNS);
        settings.setUseWideViewPort(true);
        settings.setLoadWithOverviewMode(true);
        settings.setSavePassword(true);
        settings.setSaveFormData(true);
        settings.setJavaScriptCanOpenWindowsAutomatically(true);
        settings.setLoadsImagesAutomatically(true);
        settings.setDomStorageEnabled(true);
        settings.setDatabaseEnabled(true);
        settings.setDatabasePath(FileUtils.filePath);
        settings.setAppCachePath(cacheDirPath);
        settings.setAppCacheEnabled(true);
        settings.setCacheMode(1);
    }
}
