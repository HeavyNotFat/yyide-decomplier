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
import androidx.fragment.app.Fragment;
import com.blankj.utilcode.util.ScreenUtils;
import com.blankj.utilcode.util.SizeUtils;
import com.yd.android_brand_mvp.R;
import com.yd.android_brand_mvp.adapter.CustomBannerListAdapter;
import com.yd.android_brand_mvp.base.KTBaseFragment;
import com.yd.android_brand_mvp.databinding.FragmentCustomImageText2Binding;
import com.yd.android_brand_mvp.model.custom.RichTextContentBean;
import com.yd.android_brand_mvp.utils.SimpleUtilsKt;
import com.youth.banner.indicator.CircleIndicator;
import kotlin.Metadata;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: CustomImageText2Fragment.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u000e2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u000eB\u0005¢\u0006\u0002\u0010\u0003J\b\u0010\u0006\u001a\u00020\u0007H\u0014J\u001a\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/yd/android_brand_mvp/landscape/custom/CustomImageText2Fragment;", "Lcom/yd/android_brand_mvp/base/KTBaseFragment;", "Lcom/yd/android_brand_mvp/databinding/FragmentCustomImageText2Binding;", "()V", "type", "", "needControlTopTitleShow", "", "onViewCreated", "", "view", "Landroid/view/View;", "savedInstanceState", "Landroid/os/Bundle;", "Companion", "app_commonRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class CustomImageText2Fragment extends KTBaseFragment<FragmentCustomImageText2Binding> {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private String type;

    @Override // com.yd.android_brand_mvp.base.KTBaseFragment
    protected boolean needControlTopTitleShow() {
        return true;
    }

    /* JADX INFO: renamed from: com.yd.android_brand_mvp.landscape.custom.CustomImageText2Fragment$1, reason: invalid class name */
    /* JADX INFO: compiled from: CustomImageText2Fragment.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements Function3<LayoutInflater, ViewGroup, Boolean, FragmentCustomImageText2Binding> {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        AnonymousClass1() {
            super(3, FragmentCustomImageText2Binding.class, "inflate", "inflate(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Z)Lcom/yd/android_brand_mvp/databinding/FragmentCustomImageText2Binding;", 0);
        }

        public final FragmentCustomImageText2Binding invoke(LayoutInflater p0, ViewGroup viewGroup, boolean z) {
            Intrinsics.checkNotNullParameter(p0, "p0");
            return FragmentCustomImageText2Binding.inflate(p0, viewGroup, z);
        }

        @Override // kotlin.jvm.functions.Function3
        public /* bridge */ /* synthetic */ FragmentCustomImageText2Binding invoke(LayoutInflater layoutInflater, ViewGroup viewGroup, Boolean bool) {
            return invoke(layoutInflater, viewGroup, bool.booleanValue());
        }
    }

    public CustomImageText2Fragment() {
        super(AnonymousClass1.INSTANCE);
        this.type = "";
    }

    /* JADX INFO: compiled from: CustomImageText2Fragment.kt */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J5\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\n2\u0006\u0010\u000b\u001a\u00020\f¢\u0006\u0002\u0010\r¨\u0006\u000e"}, d2 = {"Lcom/yd/android_brand_mvp/landscape/custom/CustomImageText2Fragment$Companion;", "", "()V", "newInstance", "Landroidx/fragment/app/Fragment;", "type", "", "title", "borderColor", "showTopTile", "", "data", "Lcom/yd/android_brand_mvp/model/custom/RichTextContentBean;", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Lcom/yd/android_brand_mvp/model/custom/RichTextContentBean;)Landroidx/fragment/app/Fragment;", "app_commonRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
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
            CustomImageText2Fragment customImageText2Fragment = new CustomImageText2Fragment();
            Bundle bundle = new Bundle();
            bundle.putString("type", type);
            bundle.putString("title", title);
            bundle.putParcelable("richTextData", data);
            bundle.putBoolean("showTopTile", showTopTile != null ? showTopTile.booleanValue() : true);
            bundle.putString("borderColor", borderColor);
            customImageText2Fragment.setArguments(bundle);
            return customImageText2Fragment;
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
            case 732525715:
                if (str.equals("hbzdy42")) {
                    getBinding().clFragmentCustomImageText2.getLayoutParams().width = SizeUtils.dp2px(908.0f);
                    getBinding().clFragmentCustomImageText2.getLayoutParams().height = SizeUtils.dp2px(291.0f);
                }
                break;
            case 732525717:
                if (str.equals("hbzdy44")) {
                    getBinding().clFragmentCustomImageText2.getLayoutParams().width = SizeUtils.dp2px(908.0f);
                    getBinding().clFragmentCustomImageText2.getLayoutParams().height = SizeUtils.dp2px(604.0f);
                }
                break;
            case 1905131613:
                if (str.equals("sbzdy41")) {
                    getBinding().clFragmentCustomImageText2.getLayoutParams().width = SizeUtils.dp2px(660.0f);
                    getBinding().clFragmentCustomImageText2.getLayoutParams().height = SizeUtils.dp2px(202.0f);
                }
                break;
            case 1905131675:
                if (str.equals("sbzdy61")) {
                    getBinding().clFragmentCustomImageText2.getLayoutParams().width = SizeUtils.dp2px(1000.0f);
                    getBinding().clFragmentCustomImageText2.getLayoutParams().height = SizeUtils.dp2px(202.0f);
                }
                break;
            case 1905131677:
                if (str.equals("sbzdy63")) {
                    getBinding().clFragmentCustomImageText2.getLayoutParams().width = SizeUtils.dp2px(1000.0f);
                    getBinding().clFragmentCustomImageText2.getLayoutParams().height = SizeUtils.dp2px(646.0f);
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
        getBinding().clFragmentCustomImageText2.setBackground(gradientDrawable);
        Bundle arguments4 = getArguments();
        RichTextContentBean richTextContentBean = arguments4 != null ? (RichTextContentBean) arguments4.getParcelable("richTextData") : null;
        if (richTextContentBean != null) {
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
            if (richTextContentBean.getShowFirstTitle()) {
                String str3 = richTextContentBean.getFirstTitle() + "\r\n";
                spannableStringBuilder.append((CharSequence) str3);
                spannableStringBuilder.setSpan(new ForegroundColorSpan(SimpleUtilsKt.asColor(R.color.text_333333)), 0, str3.length(), 17);
                if (ScreenUtils.isPortrait()) {
                    spannableStringBuilder.setSpan(new AbsoluteSizeSpan(35, true), 0, str3.length(), 17);
                } else {
                    spannableStringBuilder.setSpan(new AbsoluteSizeSpan(40, true), 0, str3.length(), 17);
                }
                length = str3.length();
            }
            if (richTextContentBean.getShowSecondTitle()) {
                String str4 = richTextContentBean.getSecondTitle() + "\r\n";
                spannableStringBuilder.append((CharSequence) str4);
                spannableStringBuilder.setSpan(new ForegroundColorSpan(SimpleUtilsKt.asColor(R.color.text_262626)), length, str4.length() + length, 17);
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
