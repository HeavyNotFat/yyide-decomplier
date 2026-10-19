package com.yd.android_brand_mvp.landscape.custom;

import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import com.blankj.utilcode.util.SizeUtils;
import com.yd.android_brand_mvp.R;
import com.yd.android_brand_mvp.adapter.CustomBannerListAdapter;
import com.yd.android_brand_mvp.base.KTBaseFragment;
import com.yd.android_brand_mvp.databinding.FragmentCustomImageText4Binding;
import com.yd.android_brand_mvp.model.custom.RichTextContentBean;
import com.yd.android_brand_mvp.utils.SimpleUtilsKt;
import com.youth.banner.Banner;
import com.youth.banner.indicator.CircleIndicator;
import kotlin.Metadata;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: CustomImageText4Fragment.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u000e2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u000eB\u0005¢\u0006\u0002\u0010\u0003J\b\u0010\u0006\u001a\u00020\u0007H\u0014J\u001a\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/yd/android_brand_mvp/landscape/custom/CustomImageText4Fragment;", "Lcom/yd/android_brand_mvp/base/KTBaseFragment;", "Lcom/yd/android_brand_mvp/databinding/FragmentCustomImageText4Binding;", "()V", "type", "", "needControlTopTitleShow", "", "onViewCreated", "", "view", "Landroid/view/View;", "savedInstanceState", "Landroid/os/Bundle;", "Companion", "app_commonRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class CustomImageText4Fragment extends KTBaseFragment<FragmentCustomImageText4Binding> {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private String type;

    @Override // com.yd.android_brand_mvp.base.KTBaseFragment
    protected boolean needControlTopTitleShow() {
        return true;
    }

    /* JADX INFO: renamed from: com.yd.android_brand_mvp.landscape.custom.CustomImageText4Fragment$1, reason: invalid class name */
    /* JADX INFO: compiled from: CustomImageText4Fragment.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements Function3<LayoutInflater, ViewGroup, Boolean, FragmentCustomImageText4Binding> {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        AnonymousClass1() {
            super(3, FragmentCustomImageText4Binding.class, "inflate", "inflate(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Z)Lcom/yd/android_brand_mvp/databinding/FragmentCustomImageText4Binding;", 0);
        }

        public final FragmentCustomImageText4Binding invoke(LayoutInflater p0, ViewGroup viewGroup, boolean z) {
            Intrinsics.checkNotNullParameter(p0, "p0");
            return FragmentCustomImageText4Binding.inflate(p0, viewGroup, z);
        }

        @Override // kotlin.jvm.functions.Function3
        public /* bridge */ /* synthetic */ FragmentCustomImageText4Binding invoke(LayoutInflater layoutInflater, ViewGroup viewGroup, Boolean bool) {
            return invoke(layoutInflater, viewGroup, bool.booleanValue());
        }
    }

    public CustomImageText4Fragment() {
        super(AnonymousClass1.INSTANCE);
        this.type = "";
    }

    /* JADX INFO: compiled from: CustomImageText4Fragment.kt */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J5\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\n2\u0006\u0010\u000b\u001a\u00020\f¢\u0006\u0002\u0010\r¨\u0006\u000e"}, d2 = {"Lcom/yd/android_brand_mvp/landscape/custom/CustomImageText4Fragment$Companion;", "", "()V", "newInstance", "Landroidx/fragment/app/Fragment;", "type", "", "title", "borderColor", "showTopTile", "", "data", "Lcom/yd/android_brand_mvp/model/custom/RichTextContentBean;", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Lcom/yd/android_brand_mvp/model/custom/RichTextContentBean;)Landroidx/fragment/app/Fragment;", "app_commonRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final Fragment newInstance(String type, String title, String borderColor, Boolean showTopTile, RichTextContentBean data) {
            Intrinsics.checkNotNullParameter(type, "type");
            Intrinsics.checkNotNullParameter(title, "title");
            Intrinsics.checkNotNullParameter(borderColor, "borderColor");
            Intrinsics.checkNotNullParameter(data, "data");
            CustomImageText4Fragment customImageText4Fragment = new CustomImageText4Fragment();
            Bundle bundle = new Bundle();
            bundle.putString("type", type);
            bundle.putString("title", title);
            bundle.putString("borderColor", borderColor);
            bundle.putBoolean("showTopTile", showTopTile != null ? showTopTile.booleanValue() : true);
            bundle.putParcelable("richTextData", data);
            customImageText4Fragment.setArguments(bundle);
            return customImageText4Fragment;
        }
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    @Override // com.yd.android_brand_mvp.base.KTBaseFragment, com.yd.android_brand_mvp.base.BaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        String string;
        String string2;
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        Bundle arguments = getArguments();
        String string3 = arguments != null ? arguments.getString("type") : null;
        if (string3 == null) {
            string3 = "hbzdy44";
        }
        this.type = string3;
        Bundle arguments2 = getArguments();
        if (arguments2 == null || (string = arguments2.getString("title")) == null) {
            string = "";
        }
        getBinding().topFragmentTitle.title.setText(string);
        String str = this.type;
        switch (str.hashCode()) {
            case 732525653:
                if (str.equals("hbzdy22")) {
                    getBinding().clFragmentCustomImageText4.getLayoutParams().width = SizeUtils.dp2px(444.0f);
                    getBinding().clFragmentCustomImageText4.getLayoutParams().height = SizeUtils.dp2px(291.0f);
                }
                break;
            case 732525654:
                if (str.equals("hbzdy23")) {
                    getBinding().clFragmentCustomImageText4.getLayoutParams().width = SizeUtils.dp2px(444.0f);
                    getBinding().clFragmentCustomImageText4.getLayoutParams().height = SizeUtils.dp2px(454.0f);
                }
                break;
            case 732525655:
                if (str.equals("hbzdy24")) {
                    getBinding().clFragmentCustomImageText4.getLayoutParams().width = SizeUtils.dp2px(444.0f);
                    getBinding().clFragmentCustomImageText4.getLayoutParams().height = SizeUtils.dp2px(604.0f);
                }
                break;
            case 732525715:
                if (str.equals("hbzdy42")) {
                    getBinding().clFragmentCustomImageText4.getLayoutParams().width = SizeUtils.dp2px(908.0f);
                    getBinding().clFragmentCustomImageText4.getLayoutParams().height = SizeUtils.dp2px(291.0f);
                }
                break;
            case 732525717:
                if (str.equals("hbzdy44")) {
                    getBinding().clFragmentCustomImageText4.getLayoutParams().width = SizeUtils.dp2px(908.0f);
                    getBinding().clFragmentCustomImageText4.getLayoutParams().height = SizeUtils.dp2px(604.0f);
                }
                break;
            case 732525719:
                if (str.equals("hbzdy46")) {
                    getBinding().clFragmentCustomImageText4.getLayoutParams().width = SizeUtils.dp2px(908.0f);
                    getBinding().clFragmentCustomImageText4.getLayoutParams().height = SizeUtils.dp2px(916.0f);
                    Banner banner = getBinding().bannerFragmentCustomImageText;
                    ViewGroup.LayoutParams layoutParams = banner.getLayoutParams();
                    Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
                    ConstraintLayout.LayoutParams layoutParams2 = (ConstraintLayout.LayoutParams) layoutParams;
                    layoutParams2.matchConstraintPercentHeight = 0.6f;
                    banner.setLayoutParams(layoutParams2);
                }
                break;
            case 1905131552:
                if (str.equals("sbzdy22")) {
                    getBinding().clFragmentCustomImageText4.getLayoutParams().width = SizeUtils.dp2px(320.0f);
                    getBinding().clFragmentCustomImageText4.getLayoutParams().height = SizeUtils.dp2px(424.0f);
                }
                break;
            case 1905131583:
                if (str.equals("sbzdy32")) {
                    getBinding().clFragmentCustomImageText4.getLayoutParams().width = SizeUtils.dp2px(490.0f);
                    getBinding().clFragmentCustomImageText4.getLayoutParams().height = SizeUtils.dp2px(424.0f);
                }
                break;
            case 1905131616:
                if (str.equals("sbzdy44")) {
                    getBinding().clFragmentCustomImageText4.getLayoutParams().width = SizeUtils.dp2px(660.0f);
                    getBinding().clFragmentCustomImageText4.getLayoutParams().height = SizeUtils.dp2px(868.0f);
                    Banner banner2 = getBinding().bannerFragmentCustomImageText;
                    ViewGroup.LayoutParams layoutParams3 = banner2.getLayoutParams();
                    Intrinsics.checkNotNull(layoutParams3, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
                    ConstraintLayout.LayoutParams layoutParams4 = (ConstraintLayout.LayoutParams) layoutParams3;
                    layoutParams4.matchConstraintPercentHeight = 0.5f;
                    banner2.setLayoutParams(layoutParams4);
                }
                break;
            case 1905131617:
                if (str.equals("sbzdy45")) {
                    getBinding().clFragmentCustomImageText4.getLayoutParams().width = SizeUtils.dp2px(660.0f);
                    getBinding().clFragmentCustomImageText4.getLayoutParams().height = SizeUtils.dp2px(1090.0f);
                    Banner banner3 = getBinding().bannerFragmentCustomImageText;
                    ViewGroup.LayoutParams layoutParams5 = banner3.getLayoutParams();
                    Intrinsics.checkNotNull(layoutParams5, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
                    ConstraintLayout.LayoutParams layoutParams6 = (ConstraintLayout.LayoutParams) layoutParams5;
                    layoutParams6.matchConstraintPercentHeight = 0.73f;
                    banner3.setLayoutParams(layoutParams6);
                }
                break;
            case 1905131676:
                if (str.equals("sbzdy62")) {
                    getBinding().clFragmentCustomImageText4.getLayoutParams().width = SizeUtils.dp2px(1000.0f);
                    getBinding().clFragmentCustomImageText4.getLayoutParams().height = SizeUtils.dp2px(424.0f);
                }
                break;
            case 1905131677:
                if (str.equals("sbzdy63")) {
                    getBinding().clFragmentCustomImageText4.getLayoutParams().width = SizeUtils.dp2px(1000.0f);
                    getBinding().clFragmentCustomImageText4.getLayoutParams().height = SizeUtils.dp2px(646.0f);
                    Banner banner4 = getBinding().bannerFragmentCustomImageText;
                    ViewGroup.LayoutParams layoutParams7 = banner4.getLayoutParams();
                    Intrinsics.checkNotNull(layoutParams7, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
                    ConstraintLayout.LayoutParams layoutParams8 = (ConstraintLayout.LayoutParams) layoutParams7;
                    layoutParams8.matchConstraintPercentHeight = 0.5f;
                    banner4.setLayoutParams(layoutParams8);
                }
                break;
            case 1905131682:
                if (str.equals("sbzdy68")) {
                    getBinding().clFragmentCustomImageText4.getLayoutParams().width = SizeUtils.dp2px(1000.0f);
                    getBinding().clFragmentCustomImageText4.getLayoutParams().height = SizeUtils.dp2px(1756.0f);
                    Banner banner5 = getBinding().bannerFragmentCustomImageText;
                    ViewGroup.LayoutParams layoutParams9 = banner5.getLayoutParams();
                    Intrinsics.checkNotNull(layoutParams9, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
                    ConstraintLayout.LayoutParams layoutParams10 = (ConstraintLayout.LayoutParams) layoutParams9;
                    layoutParams10.matchConstraintPercentHeight = 0.8f;
                    banner5.setLayoutParams(layoutParams10);
                }
                break;
        }
        Bundle arguments3 = getArguments();
        if (arguments3 == null || (string2 = arguments3.getString("borderColor")) == null) {
            string2 = "#ffffff";
        }
        int length = 0;
        String str2 = string2.length() == 0 ? "#ffffff" : string2;
        Drawable drawable = AppCompatResources.getDrawable(requireContext(), R.drawable.bg_custom_20);
        Intrinsics.checkNotNull(drawable, "null cannot be cast to non-null type android.graphics.drawable.GradientDrawable");
        GradientDrawable gradientDrawable = (GradientDrawable) drawable;
        gradientDrawable.setStroke(SizeUtils.dp2px(4.0f), Color.parseColor(str2));
        getBinding().clFragmentCustomImageText4.setBackground(gradientDrawable);
        Bundle arguments4 = getArguments();
        RichTextContentBean richTextContentBean = arguments4 != null ? (RichTextContentBean) arguments4.getParcelable("richTextData") : null;
        if (richTextContentBean != null) {
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
            if (richTextContentBean.getShowFirstTitle()) {
                String str3 = richTextContentBean.getFirstTitle() + "\r\n";
                spannableStringBuilder.append((CharSequence) str3);
                spannableStringBuilder.setSpan(new ForegroundColorSpan(SimpleUtilsKt.asColor(R.color.text_333333)), 0, str3.length(), 17);
                spannableStringBuilder.setSpan(new AbsoluteSizeSpan(20, true), 0, str3.length(), 17);
                length = str3.length();
            }
            if (richTextContentBean.getShowSecondTitle()) {
                String str4 = richTextContentBean.getSecondTitle() + "\r\n";
                spannableStringBuilder.append((CharSequence) str4);
                spannableStringBuilder.setSpan(new ForegroundColorSpan(SimpleUtilsKt.asColor(R.color.text_999999)), length, str4.length() + length, 17);
                spannableStringBuilder.setSpan(new AbsoluteSizeSpan(18, true), length, str4.length() + length, 17);
            }
            if (richTextContentBean.getShowContent()) {
                spannableStringBuilder.append((CharSequence) richTextContentBean.getContent());
            }
            getBinding().tvFragmentCustomImageTextDesc.setText(spannableStringBuilder);
            getBinding().bannerFragmentCustomImageText.addBannerLifecycleObserver(getViewLifecycleOwner()).setAdapter(new CustomBannerListAdapter()).setIndicator(new CircleIndicator(requireContext()));
            getBinding().bannerFragmentCustomImageText.setDatas(richTextContentBean.getImages());
        }
    }
}
