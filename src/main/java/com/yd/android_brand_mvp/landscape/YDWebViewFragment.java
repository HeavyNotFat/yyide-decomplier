package com.yd.android_brand_mvp.landscape;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.graphics.Bitmap;
import android.net.Uri;
import android.net.http.SslError;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.JavascriptInterface;
import android.webkit.SslErrorHandler;
import android.webkit.ValueCallback;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.blankj.utilcode.util.ToastUtils;
import com.google.android.exoplayer2.text.ttml.TtmlNode;
import com.ttlock.bl.sdk.util.GsonUtil;
import com.yd.android_brand_mvp.BaseApplication;
import com.yd.android_brand_mvp.base.BaseFragment;
import com.yd.android_brand_mvp.databinding.LayoutYdWebViewFragmentBinding;
import com.yd.android_brand_mvp.model.BrandInfoBean;
import com.yd.android_brand_mvp.model.BrandSiteBean;
import com.yd.android_brand_mvp.model.EventBean;
import com.yd.android_brand_mvp.model.NewBrandLoginRsp;
import com.yd.android_brand_mvp.observer.ObserverListener;
import com.yd.android_brand_mvp.observer.ObserverManager;
import com.yd.android_brand_mvp.utils.SpData;
import com.yd.android_brand_mvp.utils.view.net.GsonUtils;
import com.yd.android_brand_mvp.widget.YDWebView;
import com.yyide.facepass.AppExtKt;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

/* JADX INFO: compiled from: YDWebViewFragment.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \"2\u00020\u00012\u00020\u0002:\u0001\"B\u0005¢\u0006\u0002\u0010\u0003J\u0012\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0002J\u0012\u0010\n\u001a\u00020\u00072\b\u0010\u000b\u001a\u0004\u0018\u00010\tH\u0002J\u0012\u0010\f\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0002J\b\u0010\r\u001a\u00020\u0007H\u0002J\b\u0010\u000e\u001a\u00020\u0007H\u0002J\b\u0010\u000f\u001a\u00020\u0007H\u0003J\b\u0010\u0010\u001a\u00020\u0007H\u0002J\u0012\u0010\u0011\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0016J$\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0016J\b\u0010\u001a\u001a\u00020\u0007H\u0016J\u0010\u0010\u001b\u001a\u00020\u00072\u0006\u0010\u001c\u001a\u00020\u001dH\u0007J\b\u0010\u001e\u001a\u00020\u0007H\u0016J\b\u0010\u001f\u001a\u00020\u0007H\u0016J\u001a\u0010 \u001a\u00020\u00072\u0006\u0010!\u001a\u00020\u00132\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0017R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082.¢\u0006\u0002\n\u0000¨\u0006#"}, d2 = {"Lcom/yd/android_brand_mvp/landscape/YDWebViewFragment;", "Lcom/yd/android_brand_mvp/base/BaseFragment;", "Lcom/yd/android_brand_mvp/observer/ObserverListener;", "()V", "viewBinding", "Lcom/yd/android_brand_mvp/databinding/LayoutYdWebViewFragmentBinding;", "callBackEventCard", "", "cardNo", "", "callBackEventFace", "json", "callBackHtmlEvent", "getBrandInfo", "getBrandSite", "initWebView", "load", "observerUpData", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", TtmlNode.RUBY_CONTAINER, "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onEvent", "eventBean", "Lcom/yd/android_brand_mvp/model/EventBean;", "onPause", "onResume", "onViewCreated", "view", "Companion", "app_commonRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class YDWebViewFragment extends BaseFragment implements ObserverListener {
    private LayoutYdWebViewFragmentBinding viewBinding;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final String PARAMS = "path";
    private static final String PARAMS3 = "title";
    private static final String IDENTITY = "identity";

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean initWebView$lambda$2(View view) {
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initWebView$lambda$3(View view) {
    }

    /* JADX INFO: compiled from: YDWebViewFragment.kt */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J$\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\u00042\b\u0010\n\u001a\u0004\u0018\u00010\u00042\b\u0010\u000b\u001a\u0004\u0018\u00010\u0004J\b\u0010\f\u001a\u00020\rH\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082D¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lcom/yd/android_brand_mvp/landscape/YDWebViewFragment$Companion;", "", "()V", "IDENTITY", "", "PARAMS", "PARAMS3", "newInstance", "Landroidx/fragment/app/Fragment;", "url", "title", "identity", "showDialog", "", "app_commonRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final Fragment newInstance(String url, String title, String identity) {
            YDWebViewFragment yDWebViewFragment = new YDWebViewFragment();
            Bundle bundle = new Bundle();
            bundle.putString(YDWebViewFragment.PARAMS, url);
            bundle.putString(YDWebViewFragment.PARAMS3, title);
            bundle.putString(YDWebViewFragment.IDENTITY, identity);
            yDWebViewFragment.setArguments(bundle);
            return yDWebViewFragment;
        }

        @JavascriptInterface
        public final void showDialog() {
            ToastUtils.showShort("HTML 调用Android 函数", new Object[0]);
            new AlertDialog.Builder(BaseApplication.getInstance().getApplicationContext()).setTitle("开发语言列表").setItems(new String[]{"Java", "C", "C++", "Python", "PHP"}, (DialogInterface.OnClickListener) null).setPositiveButton("确定", (DialogInterface.OnClickListener) null).create().show();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        LayoutYdWebViewFragmentBinding layoutYdWebViewFragmentBindingInflate = LayoutYdWebViewFragmentBinding.inflate(getLayoutInflater());
        Intrinsics.checkNotNullExpressionValue(layoutYdWebViewFragmentBindingInflate, "inflate(layoutInflater)");
        this.viewBinding = layoutYdWebViewFragmentBindingInflate;
        if (layoutYdWebViewFragmentBindingInflate == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
            layoutYdWebViewFragmentBindingInflate = null;
        }
        ConstraintLayout root = layoutYdWebViewFragmentBindingInflate.getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "viewBinding.root");
        return root;
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        ObserverManager.getInstance().add(this);
    }

    @Override // androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        ObserverManager.getInstance().remove(this);
    }

    @Override // com.yd.android_brand_mvp.base.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }

    @Override // com.yd.android_brand_mvp.base.BaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        EventBus.getDefault().register(this);
        initWebView();
        LayoutYdWebViewFragmentBinding layoutYdWebViewFragmentBinding = this.viewBinding;
        LayoutYdWebViewFragmentBinding layoutYdWebViewFragmentBinding2 = null;
        if (layoutYdWebViewFragmentBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
            layoutYdWebViewFragmentBinding = null;
        }
        layoutYdWebViewFragmentBinding.tvReload.setOnClickListener(new View.OnClickListener() { // from class: com.yd.android_brand_mvp.landscape.-$$Lambda$YDWebViewFragment$TtEtyfAUIwVZ3Sr1FVQk2IL3YAk
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                YDWebViewFragment.onViewCreated$lambda$0(this.f$0, view2);
            }
        });
        LayoutYdWebViewFragmentBinding layoutYdWebViewFragmentBinding3 = this.viewBinding;
        if (layoutYdWebViewFragmentBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
        } else {
            layoutYdWebViewFragmentBinding2 = layoutYdWebViewFragmentBinding3;
        }
        layoutYdWebViewFragmentBinding2.ivClose.setOnClickListener(new View.OnClickListener() { // from class: com.yd.android_brand_mvp.landscape.-$$Lambda$YDWebViewFragment$Jw_SQiHXpA7YJsOXyaUBJkUeaZo
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                YDWebViewFragment.onViewCreated$lambda$1(this.f$0, view2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onViewCreated$lambda$0(YDWebViewFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        LayoutYdWebViewFragmentBinding layoutYdWebViewFragmentBinding = this$0.viewBinding;
        if (layoutYdWebViewFragmentBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
            layoutYdWebViewFragmentBinding = null;
        }
        layoutYdWebViewFragmentBinding.tvReload.setVisibility(4);
        this$0.load();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onViewCreated$lambda$1(YDWebViewFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        FragmentActivity activity = this$0.getActivity();
        if (activity != null) {
            activity.finish();
        }
    }

    private final void initWebView() {
        LayoutYdWebViewFragmentBinding layoutYdWebViewFragmentBinding = this.viewBinding;
        LayoutYdWebViewFragmentBinding layoutYdWebViewFragmentBinding2 = null;
        if (layoutYdWebViewFragmentBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
            layoutYdWebViewFragmentBinding = null;
        }
        layoutYdWebViewFragmentBinding.webView.setOverScrollMode(2);
        LayoutYdWebViewFragmentBinding layoutYdWebViewFragmentBinding3 = this.viewBinding;
        if (layoutYdWebViewFragmentBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
            layoutYdWebViewFragmentBinding3 = null;
        }
        layoutYdWebViewFragmentBinding3.webView.setHapticFeedbackEnabled(false);
        LayoutYdWebViewFragmentBinding layoutYdWebViewFragmentBinding4 = this.viewBinding;
        if (layoutYdWebViewFragmentBinding4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
            layoutYdWebViewFragmentBinding4 = null;
        }
        layoutYdWebViewFragmentBinding4.webView.setLayerType(1, null);
        LayoutYdWebViewFragmentBinding layoutYdWebViewFragmentBinding5 = this.viewBinding;
        if (layoutYdWebViewFragmentBinding5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
            layoutYdWebViewFragmentBinding5 = null;
        }
        WebSettings settings = layoutYdWebViewFragmentBinding5.webView.getSettings();
        Intrinsics.checkNotNullExpressionValue(settings, "viewBinding.webView.settings");
        settings.setMixedContentMode(0);
        settings.setLoadsImagesAutomatically(true);
        settings.setUseWideViewPort(true);
        settings.setLoadWithOverviewMode(true);
        settings.setUseWideViewPort(true);
        settings.setJavaScriptEnabled(true);
        settings.setDomStorageEnabled(true);
        settings.setBlockNetworkImage(false);
        settings.setSupportZoom(false);
        settings.setBuiltInZoomControls(false);
        settings.setDisplayZoomControls(true);
        settings.setAllowFileAccess(true);
        LayoutYdWebViewFragmentBinding layoutYdWebViewFragmentBinding6 = this.viewBinding;
        if (layoutYdWebViewFragmentBinding6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
            layoutYdWebViewFragmentBinding6 = null;
        }
        layoutYdWebViewFragmentBinding6.webView.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.yd.android_brand_mvp.landscape.-$$Lambda$YDWebViewFragment$f8rHDp88VPkfUTJztCK64LVRn8Y
            @Override // android.view.View.OnLongClickListener
            public final boolean onLongClick(View view) {
                return YDWebViewFragment.initWebView$lambda$2(view);
            }
        });
        LayoutYdWebViewFragmentBinding layoutYdWebViewFragmentBinding7 = this.viewBinding;
        if (layoutYdWebViewFragmentBinding7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
            layoutYdWebViewFragmentBinding7 = null;
        }
        layoutYdWebViewFragmentBinding7.webView.dispatchSetSelected(false);
        LayoutYdWebViewFragmentBinding layoutYdWebViewFragmentBinding8 = this.viewBinding;
        if (layoutYdWebViewFragmentBinding8 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
            layoutYdWebViewFragmentBinding8 = null;
        }
        layoutYdWebViewFragmentBinding8.webView.setOnClickListener(new View.OnClickListener() { // from class: com.yd.android_brand_mvp.landscape.-$$Lambda$YDWebViewFragment$ychhpImc8j3W0iYtiMIX3uOyZ5w
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                YDWebViewFragment.initWebView$lambda$3(view);
            }
        });
        LayoutYdWebViewFragmentBinding layoutYdWebViewFragmentBinding9 = this.viewBinding;
        if (layoutYdWebViewFragmentBinding9 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
            layoutYdWebViewFragmentBinding9 = null;
        }
        layoutYdWebViewFragmentBinding9.webView.setWebChromeClient(new WebChromeClient() { // from class: com.yd.android_brand_mvp.landscape.YDWebViewFragment.initWebView.3
            @Override // android.webkit.WebChromeClient
            public boolean onShowFileChooser(WebView webView, ValueCallback<Uri[]> filePathCallback, WebChromeClient.FileChooserParams fileChooserParams) {
                Intrinsics.checkNotNullParameter(webView, "webView");
                Intrinsics.checkNotNullParameter(filePathCallback, "filePathCallback");
                Intrinsics.checkNotNullParameter(fileChooserParams, "fileChooserParams");
                return true;
            }

            @Override // android.webkit.WebChromeClient
            public void onReceivedTitle(WebView view, String title) {
                Intrinsics.checkNotNullParameter(view, "view");
                Intrinsics.checkNotNullParameter(title, "title");
                super.onReceivedTitle(view, title);
            }

            @Override // android.webkit.WebChromeClient
            public void onProgressChanged(WebView view, int newProgress) {
                Intrinsics.checkNotNullParameter(view, "view");
                LayoutYdWebViewFragmentBinding layoutYdWebViewFragmentBinding10 = null;
                if (newProgress != 100) {
                    LayoutYdWebViewFragmentBinding layoutYdWebViewFragmentBinding11 = YDWebViewFragment.this.viewBinding;
                    if (layoutYdWebViewFragmentBinding11 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
                    } else {
                        layoutYdWebViewFragmentBinding10 = layoutYdWebViewFragmentBinding11;
                    }
                    layoutYdWebViewFragmentBinding10.progress.setProgress(newProgress);
                    return;
                }
                YDWebViewFragment.this.dismissProgressDialog();
                LayoutYdWebViewFragmentBinding layoutYdWebViewFragmentBinding12 = YDWebViewFragment.this.viewBinding;
                if (layoutYdWebViewFragmentBinding12 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
                } else {
                    layoutYdWebViewFragmentBinding10 = layoutYdWebViewFragmentBinding12;
                }
                layoutYdWebViewFragmentBinding10.progress.setVisibility(8);
            }
        });
        LayoutYdWebViewFragmentBinding layoutYdWebViewFragmentBinding10 = this.viewBinding;
        if (layoutYdWebViewFragmentBinding10 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
            layoutYdWebViewFragmentBinding10 = null;
        }
        layoutYdWebViewFragmentBinding10.webView.setWebViewClient(new WebViewClient() { // from class: com.yd.android_brand_mvp.landscape.YDWebViewFragment.initWebView.4
            @Override // android.webkit.WebViewClient
            public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {
                Intrinsics.checkNotNullParameter(view, "view");
                Intrinsics.checkNotNullParameter(request, "request");
                return false;
            }

            @Override // android.webkit.WebViewClient
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                Intrinsics.checkNotNullParameter(view, "view");
                Intrinsics.checkNotNullParameter(url, "url");
                return false;
            }

            @Override // android.webkit.WebViewClient
            public void onPageStarted(WebView view, String url, Bitmap favicon) {
                Intrinsics.checkNotNullParameter(view, "view");
                super.onPageStarted(view, url, favicon);
                LayoutYdWebViewFragmentBinding layoutYdWebViewFragmentBinding11 = YDWebViewFragment.this.viewBinding;
                LayoutYdWebViewFragmentBinding layoutYdWebViewFragmentBinding12 = null;
                if (layoutYdWebViewFragmentBinding11 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
                    layoutYdWebViewFragmentBinding11 = null;
                }
                if (layoutYdWebViewFragmentBinding11.progress.getVisibility() == 8) {
                    LayoutYdWebViewFragmentBinding layoutYdWebViewFragmentBinding13 = YDWebViewFragment.this.viewBinding;
                    if (layoutYdWebViewFragmentBinding13 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
                        layoutYdWebViewFragmentBinding13 = null;
                    }
                    layoutYdWebViewFragmentBinding13.progress.setProgress(0);
                    LayoutYdWebViewFragmentBinding layoutYdWebViewFragmentBinding14 = YDWebViewFragment.this.viewBinding;
                    if (layoutYdWebViewFragmentBinding14 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
                    } else {
                        layoutYdWebViewFragmentBinding12 = layoutYdWebViewFragmentBinding14;
                    }
                    layoutYdWebViewFragmentBinding12.progress.setVisibility(0);
                }
            }

            @Override // android.webkit.WebViewClient
            public void onPageFinished(WebView view, String url) {
                Intrinsics.checkNotNullParameter(view, "view");
                super.onPageFinished(view, url);
                YDWebViewFragment.this.getBrandInfo();
                YDWebViewFragment.this.getBrandSite();
            }

            @Override // android.webkit.WebViewClient
            public void onReceivedSslError(WebView view, SslErrorHandler handler, SslError error) {
                Intrinsics.checkNotNullParameter(view, "view");
                Intrinsics.checkNotNullParameter(handler, "handler");
                Intrinsics.checkNotNullParameter(error, "error");
                handler.proceed();
                super.onReceivedSslError(view, handler, error);
            }

            @Override // android.webkit.WebViewClient
            public void onReceivedError(WebView view, WebResourceRequest request, WebResourceError error) {
                super.onReceivedError(view, request, error);
                YDWebViewFragment.this.load();
            }
        });
        LayoutYdWebViewFragmentBinding layoutYdWebViewFragmentBinding11 = this.viewBinding;
        if (layoutYdWebViewFragmentBinding11 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
        } else {
            layoutYdWebViewFragmentBinding2 = layoutYdWebViewFragmentBinding11;
        }
        layoutYdWebViewFragmentBinding2.webView.addJavascriptInterface(WebViewFragment.INSTANCE, "android");
        load();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void load() {
        String string;
        HashMap map = new HashMap();
        Bundle arguments = getArguments();
        String str = "";
        LayoutYdWebViewFragmentBinding layoutYdWebViewFragmentBinding = null;
        HashMap map2 = map;
        map2.put("cardNo", String.valueOf(arguments != null ? arguments.getString(IDENTITY, "") : null));
        LayoutYdWebViewFragmentBinding layoutYdWebViewFragmentBinding2 = this.viewBinding;
        if (layoutYdWebViewFragmentBinding2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
        } else {
            layoutYdWebViewFragmentBinding = layoutYdWebViewFragmentBinding2;
        }
        YDWebView yDWebView = layoutYdWebViewFragmentBinding.webView;
        Bundle arguments2 = getArguments();
        if (arguments2 != null && (string = arguments2.getString(PARAMS)) != null) {
            str = string;
        }
        yDWebView.loadUrl(str, map2);
    }

    @Override // com.yd.android_brand_mvp.observer.ObserverListener
    public void observerUpData(String cardNo) {
        if (TextUtils.isEmpty(cardNo)) {
            return;
        }
        callBackHtmlEvent(cardNo);
    }

    private final void callBackHtmlEvent(final String cardNo) {
        LayoutYdWebViewFragmentBinding layoutYdWebViewFragmentBinding = this.viewBinding;
        if (layoutYdWebViewFragmentBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
            layoutYdWebViewFragmentBinding = null;
        }
        layoutYdWebViewFragmentBinding.webView.post(new Runnable() { // from class: com.yd.android_brand_mvp.landscape.-$$Lambda$YDWebViewFragment$KS_NjrsiBOCqiA-SAcMnt78VEbI
            @Override // java.lang.Runnable
            public final void run() {
                YDWebViewFragment.callBackHtmlEvent$lambda$4(this.f$0, cardNo);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void callBackHtmlEvent$lambda$4(YDWebViewFragment this$0, String str) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        LayoutYdWebViewFragmentBinding layoutYdWebViewFragmentBinding = this$0.viewBinding;
        if (layoutYdWebViewFragmentBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
            layoutYdWebViewFragmentBinding = null;
        }
        layoutYdWebViewFragmentBinding.webView.loadUrl("javascript:cardCallBack('" + str + "')");
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public final void onEvent(EventBean eventBean) {
        Intrinsics.checkNotNullParameter(eventBean, "eventBean");
        if (eventBean.Event == 10000) {
            callBackEventCard(eventBean.name);
        } else if (eventBean.Event == 10001) {
            callBackEventFace(GsonUtils.toJson(eventBean));
        }
    }

    private final void callBackEventCard(final String cardNo) {
        LayoutYdWebViewFragmentBinding layoutYdWebViewFragmentBinding = this.viewBinding;
        if (layoutYdWebViewFragmentBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
            layoutYdWebViewFragmentBinding = null;
        }
        layoutYdWebViewFragmentBinding.webView.post(new Runnable() { // from class: com.yd.android_brand_mvp.landscape.-$$Lambda$YDWebViewFragment$Bxj1whyuHG42n2ssIYUgQjZPxWE
            @Override // java.lang.Runnable
            public final void run() {
                YDWebViewFragment.callBackEventCard$lambda$5(cardNo, this);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void callBackEventCard$lambda$5(String str, YDWebViewFragment this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        String json = GsonUtil.toJson(str);
        AppExtKt.loge(this$0, "callBackEventCard= " + json);
        LayoutYdWebViewFragmentBinding layoutYdWebViewFragmentBinding = this$0.viewBinding;
        if (layoutYdWebViewFragmentBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
            layoutYdWebViewFragmentBinding = null;
        }
        layoutYdWebViewFragmentBinding.webView.loadUrl("javascript:cardCallBack('" + json + "')");
    }

    private final void callBackEventFace(final String json) {
        LayoutYdWebViewFragmentBinding layoutYdWebViewFragmentBinding = this.viewBinding;
        if (layoutYdWebViewFragmentBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
            layoutYdWebViewFragmentBinding = null;
        }
        layoutYdWebViewFragmentBinding.webView.post(new Runnable() { // from class: com.yd.android_brand_mvp.landscape.-$$Lambda$YDWebViewFragment$As36PCwte6FfnHVFAuDhyH2j65c
            @Override // java.lang.Runnable
            public final void run() {
                YDWebViewFragment.callBackEventFace$lambda$6(this.f$0, json);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void callBackEventFace$lambda$6(YDWebViewFragment this$0, String str) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        AppExtKt.loge(this$0, "callBackEventFace= " + str);
        LayoutYdWebViewFragmentBinding layoutYdWebViewFragmentBinding = this$0.viewBinding;
        if (layoutYdWebViewFragmentBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
            layoutYdWebViewFragmentBinding = null;
        }
        layoutYdWebViewFragmentBinding.webView.loadUrl("javascript:faceCallBack('" + str + "')");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Type inference failed for: r0v8, types: [T, java.lang.Object, java.lang.String] */
    public final void getBrandInfo() {
        NewBrandLoginRsp.DataBean dataBean = SpData.NewUser().data;
        final Ref.ObjectRef objectRef = new Ref.ObjectRef();
        String str = "";
        objectRef.element = "";
        if (dataBean != null) {
            String str2 = dataBean.id;
            Intrinsics.checkNotNullExpressionValue(str2, "it.id");
            String str3 = dataBean.brandName;
            if (str3 == null) {
                str3 = "";
            } else {
                Intrinsics.checkNotNullExpressionValue(str3, "it.brandName ?: \"\"");
            }
            String str4 = dataBean.classesId;
            if (str4 != null) {
                Intrinsics.checkNotNullExpressionValue(str4, "it.classesId ?: \"\"");
                str = str4;
            }
            ?? json = GsonUtil.toJson(new BrandInfoBean(str2, str3, str));
            Intrinsics.checkNotNullExpressionValue(json, "toJson(ben)");
            objectRef.element = json;
        }
        LayoutYdWebViewFragmentBinding layoutYdWebViewFragmentBinding = this.viewBinding;
        if (layoutYdWebViewFragmentBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
            layoutYdWebViewFragmentBinding = null;
        }
        layoutYdWebViewFragmentBinding.webView.post(new Runnable() { // from class: com.yd.android_brand_mvp.landscape.-$$Lambda$YDWebViewFragment$A2sTUw562sAIhphAKA5WIEXqhsU
            @Override // java.lang.Runnable
            public final void run() {
                YDWebViewFragment.getBrandInfo$lambda$8(this.f$0, objectRef);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final void getBrandInfo$lambda$8(YDWebViewFragment this$0, Ref.ObjectRef json) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(json, "$json");
        AppExtKt.loge(this$0, "getBrandInfo= " + ((String) json.element));
        LayoutYdWebViewFragmentBinding layoutYdWebViewFragmentBinding = this$0.viewBinding;
        if (layoutYdWebViewFragmentBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
            layoutYdWebViewFragmentBinding = null;
        }
        layoutYdWebViewFragmentBinding.webView.loadUrl("javascript:getBrandInfo('" + ((String) json.element) + "')");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Type inference failed for: r0v8, types: [T, java.lang.Object, java.lang.String] */
    public final void getBrandSite() {
        NewBrandLoginRsp.DataBean dataBean = SpData.NewUser().data;
        final Ref.ObjectRef objectRef = new Ref.ObjectRef();
        String str = "";
        objectRef.element = "";
        if (dataBean != null) {
            String str2 = dataBean.siteId;
            Intrinsics.checkNotNullExpressionValue(str2, "it.siteId");
            String str3 = dataBean.siteName;
            if (str3 != null) {
                Intrinsics.checkNotNullExpressionValue(str3, "it.siteName ?: \"\"");
                str = str3;
            }
            ?? json = GsonUtil.toJson(new BrandSiteBean(str2, str));
            Intrinsics.checkNotNullExpressionValue(json, "toJson(ben)");
            objectRef.element = json;
        }
        LayoutYdWebViewFragmentBinding layoutYdWebViewFragmentBinding = this.viewBinding;
        if (layoutYdWebViewFragmentBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
            layoutYdWebViewFragmentBinding = null;
        }
        layoutYdWebViewFragmentBinding.webView.post(new Runnable() { // from class: com.yd.android_brand_mvp.landscape.-$$Lambda$YDWebViewFragment$m0dfvNxS1WPBIjm31zWPTW0pkQc
            @Override // java.lang.Runnable
            public final void run() {
                YDWebViewFragment.getBrandSite$lambda$10(this.f$0, objectRef);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final void getBrandSite$lambda$10(YDWebViewFragment this$0, Ref.ObjectRef json) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(json, "$json");
        AppExtKt.loge(this$0, "getBrandSite= " + ((String) json.element));
        LayoutYdWebViewFragmentBinding layoutYdWebViewFragmentBinding = this$0.viewBinding;
        if (layoutYdWebViewFragmentBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
            layoutYdWebViewFragmentBinding = null;
        }
        layoutYdWebViewFragmentBinding.webView.loadUrl("javascript:getBrandSite('" + ((String) json.element) + "')");
    }
}
