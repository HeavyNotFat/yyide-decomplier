package com.yd.android_brand_mvp.landscape.custom;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import com.yd.android_brand_mvp.activity.YDWebViewActivity;
import com.yd.android_brand_mvp.base.KTBaseFragment;
import com.yd.android_brand_mvp.databinding.FragmentCustomBannerBinding;
import com.yd.android_brand_mvp.model.custom.ImageContentBean;
import kotlin.Metadata;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: CustomBannerFragment.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u000e2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u000eB\u0005¢\u0006\u0002\u0010\u0003J\b\u0010\u0006\u001a\u00020\u0007H\u0014J\u001a\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/yd/android_brand_mvp/landscape/custom/CustomBannerFragment;", "Lcom/yd/android_brand_mvp/base/KTBaseFragment;", "Lcom/yd/android_brand_mvp/databinding/FragmentCustomBannerBinding;", "()V", "type", "", "needControlTopTitleShow", "", "onViewCreated", "", "view", "Landroid/view/View;", "savedInstanceState", "Landroid/os/Bundle;", "Companion", "app_commonRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class CustomBannerFragment extends KTBaseFragment<FragmentCustomBannerBinding> {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private String type;

    @Override // com.yd.android_brand_mvp.base.KTBaseFragment
    protected boolean needControlTopTitleShow() {
        return true;
    }

    /* JADX INFO: renamed from: com.yd.android_brand_mvp.landscape.custom.CustomBannerFragment$1, reason: invalid class name */
    /* JADX INFO: compiled from: CustomBannerFragment.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements Function3<LayoutInflater, ViewGroup, Boolean, FragmentCustomBannerBinding> {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        AnonymousClass1() {
            super(3, FragmentCustomBannerBinding.class, "inflate", "inflate(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Z)Lcom/yd/android_brand_mvp/databinding/FragmentCustomBannerBinding;", 0);
        }

        public final FragmentCustomBannerBinding invoke(LayoutInflater p0, ViewGroup viewGroup, boolean z) {
            Intrinsics.checkNotNullParameter(p0, "p0");
            return FragmentCustomBannerBinding.inflate(p0, viewGroup, z);
        }

        @Override // kotlin.jvm.functions.Function3
        public /* bridge */ /* synthetic */ FragmentCustomBannerBinding invoke(LayoutInflater layoutInflater, ViewGroup viewGroup, Boolean bool) {
            return invoke(layoutInflater, viewGroup, bool.booleanValue());
        }
    }

    public CustomBannerFragment() {
        super(AnonymousClass1.INSTANCE);
        this.type = "";
    }

    /* JADX INFO: compiled from: CustomBannerFragment.kt */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J5\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\n2\u0006\u0010\u000b\u001a\u00020\f¢\u0006\u0002\u0010\r¨\u0006\u000e"}, d2 = {"Lcom/yd/android_brand_mvp/landscape/custom/CustomBannerFragment$Companion;", "", "()V", "newInstance", "Landroidx/fragment/app/Fragment;", "type", "", "title", "borderColor", "showTopTile", "", "imageData", "Lcom/yd/android_brand_mvp/model/custom/ImageContentBean;", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Lcom/yd/android_brand_mvp/model/custom/ImageContentBean;)Landroidx/fragment/app/Fragment;", "app_commonRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final Fragment newInstance(String type, String title, String borderColor, Boolean showTopTile, ImageContentBean imageData) {
            Intrinsics.checkNotNullParameter(type, "type");
            Intrinsics.checkNotNullParameter(title, "title");
            Intrinsics.checkNotNullParameter(borderColor, "borderColor");
            Intrinsics.checkNotNullParameter(imageData, "imageData");
            CustomBannerFragment customBannerFragment = new CustomBannerFragment();
            Bundle bundle = new Bundle();
            bundle.putString("type", type);
            bundle.putString("title", title);
            bundle.putParcelable("imageData", imageData);
            bundle.putBoolean("showTopTile", showTopTile != null ? showTopTile.booleanValue() : true);
            bundle.putString("borderColor", borderColor);
            customBannerFragment.setArguments(bundle);
            return customBannerFragment;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:58:0x01a5, code lost:
    
        if (r12.equals("sbzdy45") != false) goto L60;
     */
    /* JADX WARN: Code restructure failed: missing block: B:62:0x01d8, code lost:
    
        if (r12.equals("sbzdy44") != false) goto L64;
     */
    /* JADX WARN: Code restructure failed: missing block: B:66:0x0208, code lost:
    
        if (r12.equals("sbzdy43") != false) goto L68;
     */
    /* JADX WARN: Code restructure failed: missing block: B:70:0x0238, code lost:
    
        if (r12.equals("sbzdy42") != false) goto L72;
     */
    /* JADX WARN: Code restructure failed: missing block: B:74:0x0268, code lost:
    
        if (r12.equals("sbzdy41") != false) goto L76;
     */
    /* JADX WARN: Failed to clean up code after switch over string restore
    jadx.core.utils.exceptions.JadxRuntimeException: Can't remove SSA var: r0v11 int, still in use, count: 4, list:
  (r0v11 int) from 0x00b7: SWITCH (r0v11 int)
 case 732525652: goto B:153:0x062e
 case 732525653: goto B:149:0x0600
 case 732525654: goto B:145:0x05d1
 case 732525655: goto B:141:0x05a1
 case 732525656: goto B:137:0x056f
 case 732525657: goto B:133:0x053f
 default: goto B:32:0x00ba A[RegionRef:SW:31]
  (r0v11 int) from 0x00c8: SWITCH (r0v11 int)
 case 732525715: goto B:93:0x0352
 case 732525716: goto B:89:0x0322
 case 732525717: goto B:85:0x02f2
 default: goto B:35:0x00cb A[RegionRef:SW:34]
  (r0v11 int) from 0x00cf: SWITCH (r0v11 int)
 case 1905131551: goto B:81:0x02c2
 case 1905131552: goto B:77:0x0292
 default: goto B:37:0x00d2 A[RegionRef:SW:36]
  (r0v11 int) from 0x00da: SWITCH (r0v11 int)
 case 1905131675: goto B:53:0x016f
 case 1905131676: goto B:49:0x013f
 case 1905131677: goto B:45:0x010f
 case 1905131678: goto B:41:0x00df
 default: goto B:157:0x065d A[RegionRef:SW:39]
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
    jadx.core.utils.exceptions.JadxRuntimeException: Can't remove SSA var: r0v11 int, still in use, count: 5, list:
  (r0v11 int) from 0x00b7: SWITCH (r0v11 int)
 case 732525652: goto B:153:0x062e
 case 732525653: goto B:149:0x0600
 case 732525654: goto B:145:0x05d1
 case 732525655: goto B:141:0x05a1
 case 732525656: goto B:137:0x056f
 case 732525657: goto B:133:0x053f
 default: goto B:32:0x00ba A[RegionRef:SW:31]
  (r0v11 int) from 0x00c8: SWITCH (r0v11 int)
 case 732525715: goto B:93:0x0352
 case 732525716: goto B:89:0x0322
 case 732525717: goto B:85:0x02f2
 default: goto B:35:0x00cb A[RegionRef:SW:34]
  (r0v11 int) from 0x00cf: SWITCH (r0v11 int)
 case 1905131551: goto B:81:0x02c2
 case 1905131552: goto B:77:0x0292
 default: goto B:37:0x00d2 A[RegionRef:SW:36]
  (r0v11 int) from 0x00d7: SWITCH (r0v11 int)
 case 1905131613: goto B:73:0x0262
 case 1905131614: goto B:69:0x0232
 case 1905131615: goto B:65:0x0202
 case 1905131616: goto B:61:0x01d2
 case 1905131617: goto B:57:0x019f
 default: goto B:39:0x00da A[RegionRef:SW:38]
  (r0v11 int) from 0x00da: SWITCH (r0v11 int)
 case 1905131675: goto B:53:0x016f
 case 1905131676: goto B:49:0x013f
 case 1905131677: goto B:45:0x010f
 case 1905131678: goto B:41:0x00df
 default: goto B:157:0x065d A[RegionRef:SW:39]
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
    @Override // com.yd.android_brand_mvp.base.KTBaseFragment, com.yd.android_brand_mvp.base.BaseFragment, androidx.fragment.app.Fragment
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void onViewCreated(android.view.View r11, android.os.Bundle r12) {
        /*
            Method dump skipped, instruction units count: 1814
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.yd.android_brand_mvp.landscape.custom.CustomBannerFragment.onViewCreated(android.view.View, android.os.Bundle):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onViewCreated$lambda$0(ImageContentBean imageData, CustomBannerFragment this$0, Object obj, int i) {
        Intrinsics.checkNotNullParameter(imageData, "$imageData");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (TextUtils.isEmpty(imageData.getUrl())) {
            return;
        }
        Intent intent = new Intent(this$0.requireContext(), (Class<?>) YDWebViewActivity.class);
        intent.putExtra("url", imageData.getUrl());
        intent.putExtra("title", "");
        this$0.goPermissionsActivity(intent);
    }
}
