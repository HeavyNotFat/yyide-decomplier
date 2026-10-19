package com.yd.android_brand_mvp.landscape;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.net.Uri;
import android.net.http.SslError;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.webkit.JavascriptInterface;
import android.webkit.SslErrorHandler;
import android.webkit.ValueCallback;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.work.WorkRequest;
import com.blankj.utilcode.util.SizeUtils;
import com.google.android.exoplayer2.text.ttml.TtmlNode;
import com.ttlock.bl.sdk.util.GsonUtil;
import com.yd.android_brand_mvp.BaseApplication;
import com.yd.android_brand_mvp.R;
import com.yd.android_brand_mvp.activity.YDWebViewActivity;
import com.yd.android_brand_mvp.adapter.CustomBannerListAdapter;
import com.yd.android_brand_mvp.base.BaseFragment;
import com.yd.android_brand_mvp.base.ValidationConstant;
import com.yd.android_brand_mvp.databinding.WebViewFragmentBinding;
import com.yd.android_brand_mvp.landscape.cctv.CCTVFragment;
import com.yd.android_brand_mvp.model.BrandInfoBean;
import com.yd.android_brand_mvp.model.BrandSiteBean;
import com.yd.android_brand_mvp.model.EventBean;
import com.yd.android_brand_mvp.model.NewBrandLoginRsp;
import com.yd.android_brand_mvp.observer.ObserverListener;
import com.yd.android_brand_mvp.observer.ObserverManager;
import com.yd.android_brand_mvp.utils.SimpleUtilsKt;
import com.yd.android_brand_mvp.utils.SpData;
import com.yd.android_brand_mvp.utils.view.net.GsonUtils;
import com.yd.android_brand_mvp.verfity.TeacherCheackActivity2;
import com.yd.android_brand_mvp.widget.YDWebView;
import com.youth.banner.Banner;
import com.youth.banner.indicator.CircleIndicator;
import com.youth.banner.listener.OnBannerListener;
import com.youth.banner.util.BannerUtils;
import com.yyide.facepass.AppExtKt;
import java.io.File;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

/* JADX INFO: compiled from: WebViewFragment.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 22\u00020\u00012\u00020\u0002:\u00012B\u0005¢\u0006\u0002\u0010\u0003J\u0012\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0002J\u0012\u0010\u0012\u001a\u00020\u000f2\b\u0010\u0013\u001a\u0004\u0018\u00010\u0011H\u0002J\u0018\u0010\u0014\u001a\u00020\u000f2\u0006\u0010\u0015\u001a\u00020\u00052\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017J\u0018\u0010\u0018\u001a\u00020\u000f2\u0006\u0010\u0015\u001a\u00020\u00052\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017J\b\u0010\u0019\u001a\u00020\u000fH\u0002J\b\u0010\u001a\u001a\u00020\u000fH\u0002J\b\u0010\u001b\u001a\u00020\u000fH\u0003J\u0012\u0010\u001c\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0016J\u0012\u0010\u001d\u001a\u00020\u000f2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fH\u0016J\"\u0010 \u001a\u00020\u000f2\u0006\u0010!\u001a\u00020\u00052\u0006\u0010\u0015\u001a\u00020\u00052\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0016J$\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020%2\b\u0010&\u001a\u0004\u0018\u00010'2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fH\u0016J\b\u0010(\u001a\u00020\u000fH\u0016J\u0010\u0010)\u001a\u00020\u000f2\u0006\u0010*\u001a\u00020+H\u0007J\b\u0010,\u001a\u00020\u000fH\u0016J\b\u0010-\u001a\u00020\u000fH\u0016J\u0010\u0010.\u001a\u00020\u000f2\u0006\u0010/\u001a\u00020\u0011H\u0002J\b\u00100\u001a\u00020\u000fH\u0002J\b\u00101\u001a\u00020\u000fH\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082.¢\u0006\u0002\n\u0000R\u001c\u0010\b\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\n\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082.¢\u0006\u0002\n\u0000¨\u00063"}, d2 = {"Lcom/yd/android_brand_mvp/landscape/WebViewFragment;", "Lcom/yd/android_brand_mvp/base/BaseFragment;", "Lcom/yd/android_brand_mvp/observer/ObserverListener;", "()V", "count", "", "imageUri", "Landroid/net/Uri;", "mUploadCallbackAboveL", "Landroid/webkit/ValueCallback;", "", "mUploadMessage", "viewBinding", "Lcom/yd/android_brand_mvp/databinding/WebViewFragmentBinding;", "callBackEventCard", "", "cardNo", "", "callBackEventFace", "json", "chooseAbove", "resultCode", "data", "Landroid/content/Intent;", "chooseBelow", "getBrandInfo", "getBrandSite", "initWebView", "observerUpData", "onActivityCreated", "savedInstanceState", "Landroid/os/Bundle;", "onActivityResult", "requestCode", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", TtmlNode.RUBY_CONTAINER, "Landroid/view/ViewGroup;", "onDestroy", "onEvent", "eventBean", "Lcom/yd/android_brand_mvp/model/EventBean;", "onPause", "onResume", "reload", "url", "takePhoto", "updatePhotos", "Companion", "app_commonRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class WebViewFragment extends BaseFragment implements ObserverListener {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final String PARAMS = "path";
    private static final String PARAMS2 = "type";
    private static final String PARAMS3 = "title";
    private static final String PARAMS4 = "modelType";
    private static final String PARAMS5 = "imageUrl";
    private static final String PARAMS6 = "moduleId";
    private static final String PARAMS7 = "borderColor";
    private static final String PARAMS8 = "showTopTile";
    private int count;
    private Uri imageUri;
    private ValueCallback<Uri[]> mUploadCallbackAboveL;
    private ValueCallback<Uri> mUploadMessage;
    private WebViewFragmentBinding viewBinding;

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean initWebView$lambda$2(View view) {
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean initWebView$lambda$4(View view) {
        return true;
    }

    /* JADX INFO: compiled from: WebViewFragment.kt */
    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002Jm\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u00042\u001a\u0010\u000f\u001a\u0016\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0010j\n\u0012\u0004\u0012\u00020\u0004\u0018\u0001`\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u00042\b\u0010\u0013\u001a\u0004\u0018\u00010\u00042\b\u0010\u0014\u001a\u0004\u0018\u00010\u00042\b\u0010\u0015\u001a\u0004\u0018\u00010\u00042\b\u0010\u0016\u001a\u0004\u0018\u00010\u00042\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018¢\u0006\u0002\u0010\u0019J\b\u0010\u001a\u001a\u00020\u001bH\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004X\u0082D¢\u0006\u0002\n\u0000¨\u0006\u001c"}, d2 = {"Lcom/yd/android_brand_mvp/landscape/WebViewFragment$Companion;", "", "()V", "PARAMS", "", "PARAMS2", "PARAMS3", "PARAMS4", "PARAMS5", "PARAMS6", "PARAMS7", "PARAMS8", "newInstance", "Landroidx/fragment/app/Fragment;", "url", "imageUrl", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "type", "title", "modelType", "moduleId", "borderColor", "showTopTile", "", "(Ljava/lang/String;Ljava/util/ArrayList;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;)Landroidx/fragment/app/Fragment;", "showValidation", "", "app_commonRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final Fragment newInstance(String url, ArrayList<String> imageUrl, String type, String title, String modelType, String moduleId, String borderColor, Boolean showTopTile) {
            WebViewFragment webViewFragment = new WebViewFragment();
            Bundle bundle = new Bundle();
            bundle.putString(WebViewFragment.PARAMS, url);
            bundle.putString(WebViewFragment.PARAMS2, type);
            bundle.putString(WebViewFragment.PARAMS3, title);
            bundle.putString(WebViewFragment.PARAMS4, modelType);
            bundle.putStringArrayList(WebViewFragment.PARAMS5, imageUrl);
            bundle.putString(WebViewFragment.PARAMS6, moduleId);
            bundle.putString(WebViewFragment.PARAMS7, borderColor);
            bundle.putBoolean(WebViewFragment.PARAMS8, showTopTile != null ? showTopTile.booleanValue() : true);
            webViewFragment.setArguments(bundle);
            return webViewFragment;
        }

        @JavascriptInterface
        public final void showValidation() {
            new Handler().post(new Runnable() { // from class: com.yd.android_brand_mvp.landscape.-$$Lambda$WebViewFragment$Companion$zGgSQr0KE68cLMSHoGvXE4oc9HA
                @Override // java.lang.Runnable
                public final void run() {
                    WebViewFragment.Companion.showValidation$lambda$0();
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void showValidation$lambda$0() {
            TeacherCheackActivity2.start(BaseApplication.getInstance().getApplicationContext(), ValidationConstant.HTML_OPEN_API);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:100:0x0207, code lost:
    
        if (r11.equals("sbzdy41") != false) goto L102;
     */
    /* JADX WARN: Code restructure failed: missing block: B:60:0x0134, code lost:
    
        if (r11.equals("sbzdy45") != false) goto L62;
     */
    /* JADX WARN: Code restructure failed: missing block: B:70:0x016b, code lost:
    
        if (r11.equals("sbzdy44") != false) goto L72;
     */
    /* JADX WARN: Code restructure failed: missing block: B:80:0x019f, code lost:
    
        if (r11.equals("sbzdy43") != false) goto L82;
     */
    /* JADX WARN: Code restructure failed: missing block: B:90:0x01d3, code lost:
    
        if (r11.equals("sbzdy42") != false) goto L92;
     */
    /* JADX WARN: Failed to clean up code after switch over string restore
    jadx.core.utils.exceptions.JadxRuntimeException: Can't remove SSA var: r0v1 int, still in use, count: 4, list:
  (r0v1 int) from 0x0036: SWITCH (r0v1 int)
 case 732525652: goto B:289:0x05e6
 case 732525653: goto B:279:0x05b4
 case 732525654: goto B:269:0x0581
 case 732525655: goto B:259:0x054d
 case 732525656: goto B:249:0x0517
 case 732525657: goto B:239:0x04e3
 default: goto B:10:0x0039 A[RegionRef:SW:9]
  (r0v1 int) from 0x0047: SWITCH (r0v1 int)
 case 732525715: goto B:149:0x0305
 case 732525716: goto B:139:0x02d1
 case 732525717: goto B:129:0x029d
 default: goto B:13:0x004a A[RegionRef:SW:12]
  (r0v1 int) from 0x004e: SWITCH (r0v1 int)
 case 1905131551: goto B:119:0x0269
 case 1905131552: goto B:109:0x0235
 default: goto B:15:0x0051 A[RegionRef:SW:14]
  (r0v1 int) from 0x0059: SWITCH (r0v1 int)
 case 1905131675: goto B:49:0x00fa
 case 1905131676: goto B:39:0x00c6
 case 1905131677: goto B:29:0x0092
 case 1905131678: goto B:19:0x005e
 default: goto B:299:0x0619 A[RegionRef:SW:17]
    	at jadx.core.utils.InsnRemover.removeSsaVar(InsnRemover.java:164)
    	at jadx.core.utils.InsnRemover.unbindResult(InsnRemover.java:129)
    	at jadx.core.utils.InsnRemover.lambda$unbindInsns$1(InsnRemover.java:101)
    	at java.base/java.util.ArrayList.forEach(Unknown Source)
    	at jadx.core.utils.InsnRemover.unbindInsns(InsnRemover.java:100)
    	at jadx.core.utils.InsnRemover.perform(InsnRemover.java:75)
    	at jadx.core.utils.InsnRemover.removeAllMarked(InsnRemover.java:276)
    	at jadx.core.dex.visitors.regions.SwitchOverStringVisitor.replaceWithMergedSwitch(SwitchOverStringVisitor.java:354)
    	at jadx.core.dex.visitors.regions.SwitchOverStringVisitor.restoreSwitchOverString(SwitchOverStringVisitor.java:111)
    	at jadx.core.dex.visitors.regions.SwitchOverStringVisitor.visitRegion(SwitchOverStringVisitor.java:72)
    	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterativeStepInternal(DepthRegionTraversal.java:140)
    	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterative(DepthRegionTraversal.java:47)
    	at jadx.core.dex.visitors.regions.SwitchOverStringVisitor.visit(SwitchOverStringVisitor.java:66)
     */
    /* JADX WARN: Failed to clean up code after switch over string restore
    jadx.core.utils.exceptions.JadxRuntimeException: Can't remove SSA var: r0v1 int, still in use, count: 5, list:
  (r0v1 int) from 0x0036: SWITCH (r0v1 int)
 case 732525652: goto B:289:0x05e6
 case 732525653: goto B:279:0x05b4
 case 732525654: goto B:269:0x0581
 case 732525655: goto B:259:0x054d
 case 732525656: goto B:249:0x0517
 case 732525657: goto B:239:0x04e3
 default: goto B:10:0x0039 A[RegionRef:SW:9]
  (r0v1 int) from 0x0047: SWITCH (r0v1 int)
 case 732525715: goto B:149:0x0305
 case 732525716: goto B:139:0x02d1
 case 732525717: goto B:129:0x029d
 default: goto B:13:0x004a A[RegionRef:SW:12]
  (r0v1 int) from 0x004e: SWITCH (r0v1 int)
 case 1905131551: goto B:119:0x0269
 case 1905131552: goto B:109:0x0235
 default: goto B:15:0x0051 A[RegionRef:SW:14]
  (r0v1 int) from 0x0056: SWITCH (r0v1 int)
 case 1905131613: goto B:99:0x0201
 case 1905131614: goto B:89:0x01cd
 case 1905131615: goto B:79:0x0199
 case 1905131616: goto B:69:0x0165
 case 1905131617: goto B:59:0x012e
 default: goto B:17:0x0059 A[RegionRef:SW:16]
  (r0v1 int) from 0x0059: SWITCH (r0v1 int)
 case 1905131675: goto B:49:0x00fa
 case 1905131676: goto B:39:0x00c6
 case 1905131677: goto B:29:0x0092
 case 1905131678: goto B:19:0x005e
 default: goto B:299:0x0619 A[RegionRef:SW:17]
    	at jadx.core.utils.InsnRemover.removeSsaVar(InsnRemover.java:164)
    	at jadx.core.utils.InsnRemover.unbindResult(InsnRemover.java:129)
    	at jadx.core.utils.InsnRemover.unbindInsn(InsnRemover.java:93)
    	at jadx.core.utils.InsnRemover.remove(InsnRemover.java:226)
    	at jadx.core.utils.InsnRemover.remove(InsnRemover.java:215)
    	at jadx.core.dex.visitors.regions.SwitchOverStringVisitor.replaceWithMergedSwitch(SwitchOverStringVisitor.java:355)
    	at jadx.core.dex.visitors.regions.SwitchOverStringVisitor.restoreSwitchOverString(SwitchOverStringVisitor.java:111)
    	at jadx.core.dex.visitors.regions.SwitchOverStringVisitor.visitRegion(SwitchOverStringVisitor.java:72)
    	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterativeStepInternal(DepthRegionTraversal.java:140)
    	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterative(DepthRegionTraversal.java:47)
    	at jadx.core.dex.visitors.regions.SwitchOverStringVisitor.visit(SwitchOverStringVisitor.java:66)
     */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    @Override // androidx.fragment.app.Fragment
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public android.view.View onCreateView(android.view.LayoutInflater r11, android.view.ViewGroup r12, android.os.Bundle r13) {
        /*
            Method dump skipped, instruction units count: 1676
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.yd.android_brand_mvp.landscape.WebViewFragment.onCreateView(android.view.LayoutInflater, android.view.ViewGroup, android.os.Bundle):android.view.View");
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

    @Override // androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        EventBus.getDefault().register(this);
        initWebView();
    }

    private final void initWebView() {
        String string;
        final String string2;
        Banner startPosition;
        Banner adapter;
        Banner bannerIsAutoLoop;
        Banner loopTime;
        Banner indicator;
        Banner indicatorGravity;
        Banner indicatorSpace;
        Banner indicatorNormalColor;
        Banner indicatorSelectedColor;
        Banner indicatorWidth;
        Bundle arguments = getArguments();
        if (arguments == null || (string = arguments.getString(PARAMS7)) == null) {
            string = "#ffffff";
        }
        String str = string.length() == 0 ? "#ffffff" : string;
        Drawable drawable = AppCompatResources.getDrawable(requireContext(), R.drawable.bg_custom_20);
        Intrinsics.checkNotNull(drawable, "null cannot be cast to non-null type android.graphics.drawable.GradientDrawable");
        GradientDrawable gradientDrawable = (GradientDrawable) drawable;
        gradientDrawable.setStroke(SizeUtils.dp2px(4.0f), Color.parseColor(str));
        WebViewFragmentBinding webViewFragmentBinding = this.viewBinding;
        WebViewFragmentBinding webViewFragmentBinding2 = null;
        if (webViewFragmentBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
            webViewFragmentBinding = null;
        }
        webViewFragmentBinding.clContent.setBackground(gradientDrawable);
        Bundle arguments2 = getArguments();
        if (!(arguments2 != null ? arguments2.getBoolean(PARAMS8) : true)) {
            WebViewFragmentBinding webViewFragmentBinding3 = this.viewBinding;
            if (webViewFragmentBinding3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
                webViewFragmentBinding3 = null;
            }
            webViewFragmentBinding3.top.llTitle.setVisibility(8);
        }
        Bundle arguments3 = getArguments();
        final String string3 = arguments3 != null ? arguments3.getString(PARAMS4) : null;
        Bundle arguments4 = getArguments();
        if (arguments4 == null || (string2 = arguments4.getString(PARAMS)) == null) {
            string2 = "";
        }
        Bundle arguments5 = getArguments();
        ArrayList<String> stringArrayList = arguments5 != null ? arguments5.getStringArrayList(PARAMS5) : null;
        WebViewFragmentBinding webViewFragmentBinding4 = this.viewBinding;
        if (webViewFragmentBinding4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
            webViewFragmentBinding4 = null;
        }
        TextView textView = webViewFragmentBinding4.top.title;
        Bundle arguments6 = getArguments();
        textView.setText(arguments6 != null ? arguments6.getString(PARAMS3) : null);
        WebViewFragmentBinding webViewFragmentBinding5 = this.viewBinding;
        if (webViewFragmentBinding5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
            webViewFragmentBinding5 = null;
        }
        webViewFragmentBinding5.clContent.setOnClickListener(new View.OnClickListener() { // from class: com.yd.android_brand_mvp.landscape.-$$Lambda$WebViewFragment$4snoyYROYBLluIVIPEz221JXPxc
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                WebViewFragment.initWebView$lambda$0(string3, this, view);
            }
        });
        if (Intrinsics.areEqual(string3, "2")) {
            WebViewFragmentBinding webViewFragmentBinding6 = this.viewBinding;
            if (webViewFragmentBinding6 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
                webViewFragmentBinding6 = null;
            }
            webViewFragmentBinding6.clContent.setBackgroundResource(R.drawable.bg_black20);
            WebViewFragmentBinding webViewFragmentBinding7 = this.viewBinding;
            if (webViewFragmentBinding7 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
                webViewFragmentBinding7 = null;
            }
            webViewFragmentBinding7.webView.setVisibility(8);
            CustomBannerListAdapter customBannerListAdapter = new CustomBannerListAdapter();
            WebViewFragmentBinding webViewFragmentBinding8 = this.viewBinding;
            if (webViewFragmentBinding8 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
                webViewFragmentBinding8 = null;
            }
            Banner banner = webViewFragmentBinding8.banner;
            Intrinsics.checkNotNullExpressionValue(banner, "viewBinding.banner");
            SimpleUtilsKt.show(banner);
            WebViewFragmentBinding webViewFragmentBinding9 = this.viewBinding;
            if (webViewFragmentBinding9 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
                webViewFragmentBinding9 = null;
            }
            Banner bannerAddBannerLifecycleObserver = webViewFragmentBinding9.banner.addBannerLifecycleObserver(this);
            if (bannerAddBannerLifecycleObserver != null && (startPosition = bannerAddBannerLifecycleObserver.setStartPosition(1)) != null && (adapter = startPosition.setAdapter(customBannerListAdapter)) != null && (bannerIsAutoLoop = adapter.isAutoLoop(false)) != null && (loopTime = bannerIsAutoLoop.setLoopTime(WorkRequest.MIN_BACKOFF_MILLIS)) != null && (indicator = loopTime.setIndicator(new CircleIndicator(requireContext()))) != null && (indicatorGravity = indicator.setIndicatorGravity(1)) != null && (indicatorSpace = indicatorGravity.setIndicatorSpace(BannerUtils.dp2px(10.0f))) != null && (indicatorNormalColor = indicatorSpace.setIndicatorNormalColor(SimpleUtilsKt.asColor(R.color.gray))) != null && (indicatorSelectedColor = indicatorNormalColor.setIndicatorSelectedColor(SimpleUtilsKt.asColor(R.color.blue12))) != null && (indicatorWidth = indicatorSelectedColor.setIndicatorWidth(BannerUtils.dp2px(10.0f), BannerUtils.dp2px(10.0f))) != null) {
                indicatorWidth.setIndicatorHeight(BannerUtils.dp2px(10.0f));
            }
            WebViewFragmentBinding webViewFragmentBinding10 = this.viewBinding;
            if (webViewFragmentBinding10 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
                webViewFragmentBinding10 = null;
            }
            webViewFragmentBinding10.banner.setDatas(stringArrayList);
            WebViewFragmentBinding webViewFragmentBinding11 = this.viewBinding;
            if (webViewFragmentBinding11 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
            } else {
                webViewFragmentBinding2 = webViewFragmentBinding11;
            }
            webViewFragmentBinding2.banner.setOnBannerListener(new OnBannerListener() { // from class: com.yd.android_brand_mvp.landscape.-$$Lambda$WebViewFragment$FM85A4-l32VpNOOuqDzk0zOwZkk
                @Override // com.youth.banner.listener.OnBannerListener
                public final void OnBannerClick(Object obj, int i) {
                    WebViewFragment.initWebView$lambda$1(string2, this, obj, i);
                }
            });
            return;
        }
        if (Intrinsics.areEqual(string3, "3")) {
            Bundle arguments7 = getArguments();
            String string4 = arguments7 != null ? arguments7.getString(PARAMS6) : null;
            WebViewFragmentBinding webViewFragmentBinding12 = this.viewBinding;
            if (webViewFragmentBinding12 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
                webViewFragmentBinding12 = null;
            }
            Banner banner2 = webViewFragmentBinding12.banner;
            Intrinsics.checkNotNullExpressionValue(banner2, "viewBinding.banner");
            SimpleUtilsKt.remove(banner2);
            WebViewFragmentBinding webViewFragmentBinding13 = this.viewBinding;
            if (webViewFragmentBinding13 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
                webViewFragmentBinding13 = null;
            }
            YDWebView yDWebView = webViewFragmentBinding13.webView;
            Intrinsics.checkNotNullExpressionValue(yDWebView, "viewBinding.webView");
            SimpleUtilsKt.remove(yDWebView);
            FragmentTransaction fragmentTransactionBeginTransaction = getChildFragmentManager().beginTransaction();
            WebViewFragmentBinding webViewFragmentBinding14 = this.viewBinding;
            if (webViewFragmentBinding14 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
            } else {
                webViewFragmentBinding2 = webViewFragmentBinding14;
            }
            fragmentTransactionBeginTransaction.replace(webViewFragmentBinding2.container.getId(), CCTVFragment.INSTANCE.newInstance(string4 != null ? string4 : "", SpData.getBrandId())).commit();
            return;
        }
        WebViewFragmentBinding webViewFragmentBinding15 = this.viewBinding;
        if (webViewFragmentBinding15 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
            webViewFragmentBinding15 = null;
        }
        Banner banner3 = webViewFragmentBinding15.banner;
        Intrinsics.checkNotNullExpressionValue(banner3, "viewBinding.banner");
        SimpleUtilsKt.remove(banner3);
        WebViewFragmentBinding webViewFragmentBinding16 = this.viewBinding;
        if (webViewFragmentBinding16 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
            webViewFragmentBinding16 = null;
        }
        webViewFragmentBinding16.clContent.setBackgroundResource(R.drawable.bg_grenn20_stroke);
        WebViewFragmentBinding webViewFragmentBinding17 = this.viewBinding;
        if (webViewFragmentBinding17 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
            webViewFragmentBinding17 = null;
        }
        webViewFragmentBinding17.webView.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.yd.android_brand_mvp.landscape.-$$Lambda$WebViewFragment$dvqj397cK24YvHrzoioVdoQYO1g
            @Override // android.view.View.OnLongClickListener
            public final boolean onLongClick(View view) {
                return WebViewFragment.initWebView$lambda$2(view);
            }
        });
        WebViewFragmentBinding webViewFragmentBinding18 = this.viewBinding;
        if (webViewFragmentBinding18 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
            webViewFragmentBinding18 = null;
        }
        webViewFragmentBinding18.top.llTitle.setOnClickListener(new View.OnClickListener() { // from class: com.yd.android_brand_mvp.landscape.-$$Lambda$WebViewFragment$OqWrPYjb2bfybxSiP19mXnhpQkY
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                WebViewFragment.initWebView$lambda$3(this.f$0, view);
            }
        });
        WebViewFragmentBinding webViewFragmentBinding19 = this.viewBinding;
        if (webViewFragmentBinding19 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
            webViewFragmentBinding19 = null;
        }
        webViewFragmentBinding19.webView.setOverScrollMode(2);
        new FrameLayout.LayoutParams(-1, -1);
        WebViewFragmentBinding webViewFragmentBinding20 = this.viewBinding;
        if (webViewFragmentBinding20 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
            webViewFragmentBinding20 = null;
        }
        WebSettings settings = webViewFragmentBinding20.webView.getSettings();
        Intrinsics.checkNotNullExpressionValue(settings, "viewBinding.webView.settings");
        settings.setLoadsImagesAutomatically(true);
        WebViewFragmentBinding webViewFragmentBinding21 = this.viewBinding;
        if (webViewFragmentBinding21 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
            webViewFragmentBinding21 = null;
        }
        webViewFragmentBinding21.webView.setLayerType(1, null);
        settings.setMixedContentMode(0);
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
        WebViewFragmentBinding webViewFragmentBinding22 = this.viewBinding;
        if (webViewFragmentBinding22 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
            webViewFragmentBinding22 = null;
        }
        webViewFragmentBinding22.webView.setLongClickable(true);
        WebViewFragmentBinding webViewFragmentBinding23 = this.viewBinding;
        if (webViewFragmentBinding23 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
            webViewFragmentBinding23 = null;
        }
        webViewFragmentBinding23.webView.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.yd.android_brand_mvp.landscape.-$$Lambda$WebViewFragment$sck_4Mct8-joh7RgOWIcS-_7iic
            @Override // android.view.View.OnLongClickListener
            public final boolean onLongClick(View view) {
                return WebViewFragment.initWebView$lambda$4(view);
            }
        });
        WebViewFragmentBinding webViewFragmentBinding24 = this.viewBinding;
        if (webViewFragmentBinding24 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
            webViewFragmentBinding24 = null;
        }
        webViewFragmentBinding24.webView.setWebChromeClient(new WebChromeClient() { // from class: com.yd.android_brand_mvp.landscape.WebViewFragment.initWebView.6
            @Override // android.webkit.WebChromeClient
            public void onProgressChanged(WebView view, int newProgress) {
                Intrinsics.checkNotNullParameter(view, "view");
            }

            @Override // android.webkit.WebChromeClient
            public void onReceivedTitle(WebView view, String title) {
                Intrinsics.checkNotNullParameter(view, "view");
                Intrinsics.checkNotNullParameter(title, "title");
                super.onReceivedTitle(view, title);
            }

            @Override // android.webkit.WebChromeClient
            public boolean onShowFileChooser(WebView webView, ValueCallback<Uri[]> filePathCallback, WebChromeClient.FileChooserParams fileChooserParams) {
                Intrinsics.checkNotNullParameter(webView, "webView");
                Intrinsics.checkNotNullParameter(filePathCallback, "filePathCallback");
                Intrinsics.checkNotNullParameter(fileChooserParams, "fileChooserParams");
                WebViewFragment.this.mUploadCallbackAboveL = filePathCallback;
                WebViewFragment.this.takePhoto();
                return true;
            }
        });
        WebViewFragmentBinding webViewFragmentBinding25 = this.viewBinding;
        if (webViewFragmentBinding25 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
            webViewFragmentBinding25 = null;
        }
        webViewFragmentBinding25.webView.setWebViewClient(new WebViewClient() { // from class: com.yd.android_brand_mvp.landscape.WebViewFragment.initWebView.7
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
            }

            @Override // android.webkit.WebViewClient
            public void onPageFinished(WebView view, String url) {
                Intrinsics.checkNotNullParameter(view, "view");
                super.onPageFinished(view, url);
                WebViewFragment.this.getBrandInfo();
                WebViewFragment.this.getBrandSite();
            }

            @Override // android.webkit.WebViewClient
            public void onReceivedSslError(WebView view, SslErrorHandler handler, SslError error) {
                Intrinsics.checkNotNullParameter(view, "view");
                Intrinsics.checkNotNullParameter(handler, "handler");
                Intrinsics.checkNotNullParameter(error, "error");
                handler.proceed();
            }

            @Override // android.webkit.WebViewClient
            public void onReceivedError(WebView view, WebResourceRequest request, WebResourceError error) {
                super.onReceivedError(view, request, error);
                WebViewFragment.this.reload(string2);
                Log.e("WebViewFragment", "onReceivedHttpError:" + string2);
            }

            @Override // android.webkit.WebViewClient
            public void onReceivedHttpError(WebView view, WebResourceRequest request, WebResourceResponse errorResponse) {
                super.onReceivedHttpError(view, request, errorResponse);
                WebViewFragment.this.reload(string2);
                Log.e("WebViewFragment", "onReceivedHttpError:" + string2);
            }

            @Override // android.webkit.WebViewClient
            public void onReceivedError(WebView view, int errorCode, String description, String failingUrl) {
                super.onReceivedError(view, errorCode, description, failingUrl);
                WebViewFragment.this.reload(string2);
                Log.e("WebViewFragment", "onReceivedError:" + string2);
            }
        });
        WebViewFragmentBinding webViewFragmentBinding26 = this.viewBinding;
        if (webViewFragmentBinding26 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
            webViewFragmentBinding26 = null;
        }
        webViewFragmentBinding26.webView.addJavascriptInterface(INSTANCE, "android");
        AppExtKt.loge(this, string2);
        WebViewFragmentBinding webViewFragmentBinding27 = this.viewBinding;
        if (webViewFragmentBinding27 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
        } else {
            webViewFragmentBinding2 = webViewFragmentBinding27;
        }
        webViewFragmentBinding2.webView.loadUrl(string2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initWebView$lambda$0(String str, WebViewFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (Intrinsics.areEqual(str, "1")) {
            WebViewFragmentBinding webViewFragmentBinding = this$0.viewBinding;
            if (webViewFragmentBinding == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
                webViewFragmentBinding = null;
            }
            webViewFragmentBinding.webView.reload();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initWebView$lambda$1(String url, WebViewFragment this$0, Object obj, int i) {
        Intrinsics.checkNotNullParameter(url, "$url");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (TextUtils.isEmpty(url)) {
            return;
        }
        Intent intent = new Intent(this$0.getActivity(), (Class<?>) YDWebViewActivity.class);
        intent.putExtra("url", url);
        Bundle arguments = this$0.getArguments();
        intent.putExtra("title", arguments != null ? arguments.getString(PARAMS3) : null);
        this$0.goPermissionsActivity(intent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initWebView$lambda$3(WebViewFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        WebViewFragmentBinding webViewFragmentBinding = this$0.viewBinding;
        WebViewFragmentBinding webViewFragmentBinding2 = null;
        if (webViewFragmentBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
            webViewFragmentBinding = null;
        }
        if (webViewFragmentBinding.webView.canGoBack()) {
            WebViewFragmentBinding webViewFragmentBinding3 = this$0.viewBinding;
            if (webViewFragmentBinding3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
                webViewFragmentBinding3 = null;
            }
            webViewFragmentBinding3.webView.goBack();
            WebViewFragmentBinding webViewFragmentBinding4 = this$0.viewBinding;
            if (webViewFragmentBinding4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
            } else {
                webViewFragmentBinding2 = webViewFragmentBinding4;
            }
            webViewFragmentBinding2.webView.removeAllViews();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void takePhoto() {
        Uri uriFromFile = Uri.fromFile(new File((Environment.getExternalStorageDirectory().toString() + File.separator) + "IMG_WEB_Camera_yd.jpg"));
        Intrinsics.checkNotNullExpressionValue(uriFromFile, "fromFile(File(filePath + fileName))");
        this.imageUri = uriFromFile;
        Intent intent = new Intent("android.media.action.IMAGE_CAPTURE");
        Uri uri = this.imageUri;
        if (uri == null) {
            Intrinsics.throwUninitializedPropertyAccessException("imageUri");
            uri = null;
        }
        intent.putExtra("output", uri);
        Intent intentCreateChooser = Intent.createChooser(intent, "选择上传方式");
        intentCreateChooser.putExtra("android.intent.extra.INITIAL_INTENTS", new Parcelable[0]);
        startActivityForResult(intentCreateChooser, 1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void reload(final String url) {
        if (this.count == 10) {
            new Handler().postDelayed(new Runnable() { // from class: com.yd.android_brand_mvp.landscape.-$$Lambda$WebViewFragment$5q_EgTLF1zBO8JpOLTDp1jS4Jjw
                @Override // java.lang.Runnable
                public final void run() {
                    WebViewFragment.reload$lambda$5(this.f$0, url);
                }
            }, 5000L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void reload$lambda$5(WebViewFragment this$0, String url) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(url, "$url");
        this$0.count++;
        WebViewFragmentBinding webViewFragmentBinding = this$0.viewBinding;
        if (webViewFragmentBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
            webViewFragmentBinding = null;
        }
        webViewFragmentBinding.webView.loadUrl(url);
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

    @Override // com.yd.android_brand_mvp.base.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }

    @Override // com.yd.android_brand_mvp.observer.ObserverListener
    public void observerUpData(String cardNo) {
        if (TextUtils.isEmpty(cardNo)) {
            return;
        }
        callBackEventCard(cardNo);
    }

    private final void callBackEventCard(final String cardNo) {
        WebViewFragmentBinding webViewFragmentBinding = this.viewBinding;
        if (webViewFragmentBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
            webViewFragmentBinding = null;
        }
        webViewFragmentBinding.webView.post(new Runnable() { // from class: com.yd.android_brand_mvp.landscape.-$$Lambda$WebViewFragment$AjAIOGDTqSoL8p33UV8xJlq5mJk
            @Override // java.lang.Runnable
            public final void run() {
                WebViewFragment.callBackEventCard$lambda$6(cardNo, this);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void callBackEventCard$lambda$6(String str, WebViewFragment this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Log.i("WebViewFragment", "callBackEventCard= " + str);
        WebViewFragmentBinding webViewFragmentBinding = this$0.viewBinding;
        if (webViewFragmentBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
            webViewFragmentBinding = null;
        }
        webViewFragmentBinding.webView.loadUrl("javascript:cardCallBack('" + str + "')");
    }

    private final void callBackEventFace(final String json) {
        WebViewFragmentBinding webViewFragmentBinding = this.viewBinding;
        if (webViewFragmentBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
            webViewFragmentBinding = null;
        }
        webViewFragmentBinding.webView.post(new Runnable() { // from class: com.yd.android_brand_mvp.landscape.-$$Lambda$WebViewFragment$4NowmNYKPZCB7BEDya-IdP1ySXE
            @Override // java.lang.Runnable
            public final void run() {
                WebViewFragment.callBackEventFace$lambda$7(json, this);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void callBackEventFace$lambda$7(String str, WebViewFragment this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Log.i("WebViewFragment", "callBackEventFace= " + str);
        WebViewFragmentBinding webViewFragmentBinding = this$0.viewBinding;
        if (webViewFragmentBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
            webViewFragmentBinding = null;
        }
        webViewFragmentBinding.webView.loadUrl("javascript:faceCallBack('" + str + "')");
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
        WebViewFragmentBinding webViewFragmentBinding = this.viewBinding;
        if (webViewFragmentBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
            webViewFragmentBinding = null;
        }
        webViewFragmentBinding.webView.post(new Runnable() { // from class: com.yd.android_brand_mvp.landscape.-$$Lambda$WebViewFragment$-MKCqub14gEH1aAjDsf6wP3XF2c
            @Override // java.lang.Runnable
            public final void run() {
                WebViewFragment.getBrandInfo$lambda$9(objectRef, this);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final void getBrandInfo$lambda$9(Ref.ObjectRef json, WebViewFragment this$0) {
        Intrinsics.checkNotNullParameter(json, "$json");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Log.i("WebViewFragment", "getBrandInfo= " + ((String) json.element));
        WebViewFragmentBinding webViewFragmentBinding = this$0.viewBinding;
        if (webViewFragmentBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
            webViewFragmentBinding = null;
        }
        webViewFragmentBinding.webView.loadUrl("javascript:getBrandInfo('" + ((String) json.element) + "')");
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
        WebViewFragmentBinding webViewFragmentBinding = this.viewBinding;
        if (webViewFragmentBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
            webViewFragmentBinding = null;
        }
        webViewFragmentBinding.webView.post(new Runnable() { // from class: com.yd.android_brand_mvp.landscape.-$$Lambda$WebViewFragment$siDwD12UcvtBrAJIfwKEMo4GB2Y
            @Override // java.lang.Runnable
            public final void run() {
                WebViewFragment.getBrandSite$lambda$11(objectRef, this);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final void getBrandSite$lambda$11(Ref.ObjectRef json, WebViewFragment this$0) {
        Intrinsics.checkNotNullParameter(json, "$json");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Log.i("WebViewFragment", "getBrandSite= " + ((String) json.element));
        WebViewFragmentBinding webViewFragmentBinding = this$0.viewBinding;
        if (webViewFragmentBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
            webViewFragmentBinding = null;
        }
        webViewFragmentBinding.webView.loadUrl("javascript:getBrandSite('" + ((String) json.element) + "')");
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        chooseAbove(resultCode, data);
    }

    public final void chooseBelow(int resultCode, Intent data) {
        Log.e("Base", "调用方法  chooseBelow");
        if (-1 == resultCode) {
            updatePhotos();
            if (data != null) {
                Uri data2 = data.getData();
                if (data2 != null) {
                    Log.e("Base", "系统里取到的图片：" + data2);
                    ValueCallback<Uri> valueCallback = this.mUploadMessage;
                    Intrinsics.checkNotNull(valueCallback);
                    valueCallback.onReceiveValue(data2);
                } else {
                    ValueCallback<Uri> valueCallback2 = this.mUploadMessage;
                    Intrinsics.checkNotNull(valueCallback2);
                    valueCallback2.onReceiveValue(null);
                }
            } else {
                StringBuilder sb = new StringBuilder();
                sb.append("自己命名的图片：");
                Uri uri = this.imageUri;
                if (uri == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("imageUri");
                    uri = null;
                }
                sb.append(uri);
                Log.e("Base", sb.toString());
                ValueCallback<Uri> valueCallback3 = this.mUploadMessage;
                Intrinsics.checkNotNull(valueCallback3);
                Uri uri2 = this.imageUri;
                if (uri2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("imageUri");
                    uri2 = null;
                }
                valueCallback3.onReceiveValue(uri2);
            }
        } else {
            ValueCallback<Uri> valueCallback4 = this.mUploadMessage;
            Intrinsics.checkNotNull(valueCallback4);
            valueCallback4.onReceiveValue(null);
        }
        this.mUploadMessage = null;
    }

    public final void chooseAbove(int resultCode, Intent data) {
        Log.e("Base", "调用方法  chooseAbove   " + data);
        if (-1 == resultCode) {
            updatePhotos();
            if (data != null) {
                Uri data2 = data.getData();
                if (data2 != null) {
                    Uri[] uriArr = {data2};
                    for (int i = 0; i < 1; i++) {
                        Log.e("Base", "系统里取到的图片：" + uriArr[i]);
                    }
                    ValueCallback<Uri[]> valueCallback = this.mUploadCallbackAboveL;
                    if (valueCallback != null) {
                        valueCallback.onReceiveValue(uriArr);
                    }
                } else {
                    ValueCallback<Uri[]> valueCallback2 = this.mUploadCallbackAboveL;
                    if (valueCallback2 != null) {
                        valueCallback2.onReceiveValue(null);
                    }
                }
            } else {
                StringBuilder sb = new StringBuilder();
                sb.append("自己命名的图片：");
                Uri uri = this.imageUri;
                if (uri == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("imageUri");
                    uri = null;
                }
                sb.append(uri);
                Log.e("Base", sb.toString());
                if (this.imageUri == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("imageUri");
                }
                Uri[] uriArr2 = new Uri[1];
                Uri uri2 = this.imageUri;
                if (uri2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("imageUri");
                    uri2 = null;
                }
                uriArr2[0] = uri2;
                ValueCallback<Uri[]> valueCallback3 = this.mUploadCallbackAboveL;
                if (valueCallback3 != null) {
                    valueCallback3.onReceiveValue(uriArr2);
                }
            }
        } else {
            ValueCallback<Uri[]> valueCallback4 = this.mUploadCallbackAboveL;
            if (valueCallback4 != null) {
                valueCallback4.onReceiveValue(null);
            }
        }
        this.mUploadCallbackAboveL = null;
    }

    private final void updatePhotos() {
        Intent intent = new Intent("android.intent.action.MEDIA_SCANNER_SCAN_FILE");
        Uri uri = this.imageUri;
        if (uri == null) {
            Intrinsics.throwUninitializedPropertyAccessException("imageUri");
            uri = null;
        }
        intent.setData(uri);
        this.mActivity.sendBroadcast(intent);
    }
}
