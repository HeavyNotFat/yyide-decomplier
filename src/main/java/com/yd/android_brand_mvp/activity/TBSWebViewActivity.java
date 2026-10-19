package com.yd.android_brand_mvp.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import com.tencent.smtt.export.external.interfaces.WebResourceRequest;
import com.tencent.smtt.sdk.TbsReaderView;
import com.tencent.smtt.sdk.WebChromeClient;
import com.tencent.smtt.sdk.WebView;
import com.tencent.smtt.sdk.WebViewClient;
import com.yd.android_brand_mvp.base.BaseDominateActivity;
import com.yd.android_brand_mvp.databinding.ActivityTbsWebviewBinding;
import com.yd.android_brand_mvp.utils.SimpleUtilsKt;
import com.yyide.facepass.AppExtKt;
import java.io.File;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: TBSWebViewActivity.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u0000 \r2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\rB\u0005¢\u0006\u0002\u0010\u0003J\b\u0010\n\u001a\u00020\u000bH\u0014J\b\u0010\f\u001a\u00020\u000bH\u0014R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\t¨\u0006\u000e"}, d2 = {"Lcom/yd/android_brand_mvp/activity/TBSWebViewActivity;", "Lcom/yd/android_brand_mvp/base/BaseDominateActivity;", "Lcom/yd/android_brand_mvp/databinding/ActivityTbsWebviewBinding;", "()V", "mTbsReaderView", "Lcom/tencent/smtt/sdk/TbsReaderView;", "getMTbsReaderView", "()Lcom/tencent/smtt/sdk/TbsReaderView;", "setMTbsReaderView", "(Lcom/tencent/smtt/sdk/TbsReaderView;)V", "initView", "", "onDestroy", "Companion", "app_commonRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class TBSWebViewActivity extends BaseDominateActivity<ActivityTbsWebviewBinding> {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private TbsReaderView mTbsReaderView;

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$1(Integer num, Object obj, Object obj2) {
    }

    /* JADX INFO: renamed from: com.yd.android_brand_mvp.activity.TBSWebViewActivity$1, reason: invalid class name */
    /* JADX INFO: compiled from: TBSWebViewActivity.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements Function1<LayoutInflater, ActivityTbsWebviewBinding> {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        AnonymousClass1() {
            super(1, ActivityTbsWebviewBinding.class, "inflate", "inflate(Landroid/view/LayoutInflater;)Lcom/yd/android_brand_mvp/databinding/ActivityTbsWebviewBinding;", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public final ActivityTbsWebviewBinding invoke(LayoutInflater p0) {
            Intrinsics.checkNotNullParameter(p0, "p0");
            return ActivityTbsWebviewBinding.inflate(p0);
        }
    }

    public TBSWebViewActivity() {
        super(AnonymousClass1.INSTANCE);
    }

    /* JADX INFO: compiled from: TBSWebViewActivity.kt */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J(\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\b2\b\b\u0002\u0010\n\u001a\u00020\b¨\u0006\u000b"}, d2 = {"Lcom/yd/android_brand_mvp/activity/TBSWebViewActivity$Companion;", "", "()V", "startGo", "", "context", "Landroid/content/Context;", "url", "", "title", "type", "app_commonRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public static /* synthetic */ void startGo$default(Companion companion, Context context, String str, String str2, String str3, int i, Object obj) {
            if ((i & 8) != 0) {
                str3 = "web";
            }
            companion.startGo(context, str, str2, str3);
        }

        public final void startGo(Context context, String url, String title, String type) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(url, "url");
            Intrinsics.checkNotNullParameter(title, "title");
            Intrinsics.checkNotNullParameter(type, "type");
            Intent intent = new Intent(context, (Class<?>) TBSWebViewActivity.class);
            intent.putExtra("urlStr", url);
            intent.putExtra("title", title);
            intent.putExtra("type", type);
            context.startActivity(intent);
        }
    }

    public final TbsReaderView getMTbsReaderView() {
        return this.mTbsReaderView;
    }

    public final void setMTbsReaderView(TbsReaderView tbsReaderView) {
        this.mTbsReaderView = tbsReaderView;
    }

    @Override // com.yd.android_brand_mvp.base.BaseDominateActivity
    protected void initView() {
        TbsReaderView tbsReaderView;
        super.initView();
        String stringExtra = getIntent().getStringExtra("urlStr");
        if (stringExtra == null) {
            stringExtra = "";
        }
        String stringExtra2 = getIntent().getStringExtra("title");
        if (stringExtra2 == null) {
            stringExtra2 = "Web";
        }
        String stringExtra3 = getIntent().getStringExtra("type");
        if (stringExtra3 == null) {
            stringExtra3 = "web";
        }
        getBinding().topActivityTbsWeb.titleName.setText(stringExtra2);
        getBinding().topActivityTbsWeb.backLayout.setOnClickListener(new View.OnClickListener() { // from class: com.yd.android_brand_mvp.activity.-$$Lambda$TBSWebViewActivity$mYHhNkQUJEiYd5t06fpWj0rcNgc
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                TBSWebViewActivity.initView$lambda$0(this.f$0, view);
            }
        });
        getBinding().wvActivityTbs.setWebViewClient(new WebViewClient() { // from class: com.yd.android_brand_mvp.activity.TBSWebViewActivity.initView.2
            @Override // com.tencent.smtt.sdk.WebViewClient
            public boolean shouldOverrideUrlLoading(WebView p0, WebResourceRequest p1) {
                return super.shouldOverrideUrlLoading(p0, p1);
            }
        });
        getBinding().wvActivityTbs.setWebChromeClient(new WebChromeClient() { // from class: com.yd.android_brand_mvp.activity.TBSWebViewActivity.initView.3
            @Override // com.tencent.smtt.sdk.WebChromeClient
            public void onProgressChanged(WebView p0, int p1) {
                super.onProgressChanged(p0, p1);
                if (p1 == 100) {
                    TBSWebViewActivity.this.hideLoading();
                }
            }
        });
        getBinding().wvActivityTbs.getSettings().setJavaScriptEnabled(true);
        if (Intrinsics.areEqual(stringExtra3, "web")) {
            AppExtKt.logd(this, "web url = " + stringExtra);
            showLoading();
            getBinding().wvActivityTbs.loadUrl(stringExtra);
            return;
        }
        if (getBinding().wvActivityTbs.getX5WebViewExtension() == null) {
            SimpleUtilsKt.showShotToast(this, "TBS初始化失败,重新启动应用后再尝试");
            return;
        }
        File file = new File(stringExtra);
        if (file.exists()) {
            this.mTbsReaderView = new TbsReaderView(this, new TbsReaderView.ReaderCallback() { // from class: com.yd.android_brand_mvp.activity.-$$Lambda$TBSWebViewActivity$6Q6s_4cuupHoQfEeZNDTjPghr2k
                @Override // com.tencent.smtt.sdk.TbsReaderView.ReaderCallback
                public final void onCallBackAction(Integer num, Object obj, Object obj2) {
                    TBSWebViewActivity.initView$lambda$1(num, obj, obj2);
                }
            });
            getBinding().wvActivityTbs.addView(this.mTbsReaderView, new LinearLayout.LayoutParams(-1, -1));
            Bundle bundle = new Bundle();
            bundle.putString("filePath", file.getAbsolutePath());
            bundle.putString(TbsReaderView.KEY_TEMP_PATH, getCacheDir().getAbsolutePath() + "/TbsReaderTemp");
            TbsReaderView tbsReaderView2 = this.mTbsReaderView;
            if (!(tbsReaderView2 != null ? tbsReaderView2.preOpen(stringExtra3, false) : false) || (tbsReaderView = this.mTbsReaderView) == null) {
                return;
            }
            tbsReaderView.openFile(bundle);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$0(TBSWebViewActivity this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.finish();
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        getBinding().wvActivityTbs.destroy();
        TbsReaderView tbsReaderView = this.mTbsReaderView;
        if (tbsReaderView != null) {
            tbsReaderView.onStop();
        }
    }
}
