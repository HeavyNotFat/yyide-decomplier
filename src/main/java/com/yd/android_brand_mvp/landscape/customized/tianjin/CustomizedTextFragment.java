package com.yd.android_brand_mvp.landscape.customized.tianjin;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import com.blankj.utilcode.util.SizeUtils;
import com.yd.android_brand_mvp.base.KTBaseFragment;
import com.yd.android_brand_mvp.databinding.FragmentCustomizedTextBinding;
import com.yd.android_brand_mvp.model.custom.TextContentBean;
import kotlin.Metadata;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: CustomizedTextFragment.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u000e2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u000eB\u0005¢\u0006\u0002\u0010\u0003J\b\u0010\u0006\u001a\u00020\u0007H\u0014J\u001a\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/yd/android_brand_mvp/landscape/customized/tianjin/CustomizedTextFragment;", "Lcom/yd/android_brand_mvp/base/KTBaseFragment;", "Lcom/yd/android_brand_mvp/databinding/FragmentCustomizedTextBinding;", "()V", "type", "", "needControlTopTitleShow", "", "onViewCreated", "", "view", "Landroid/view/View;", "savedInstanceState", "Landroid/os/Bundle;", "Companion", "app_commonRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class CustomizedTextFragment extends KTBaseFragment<FragmentCustomizedTextBinding> {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private String type;

    @Override // com.yd.android_brand_mvp.base.KTBaseFragment
    protected boolean needControlTopTitleShow() {
        return true;
    }

    /* JADX INFO: renamed from: com.yd.android_brand_mvp.landscape.customized.tianjin.CustomizedTextFragment$1, reason: invalid class name */
    /* JADX INFO: compiled from: CustomizedTextFragment.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements Function3<LayoutInflater, ViewGroup, Boolean, FragmentCustomizedTextBinding> {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        AnonymousClass1() {
            super(3, FragmentCustomizedTextBinding.class, "inflate", "inflate(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Z)Lcom/yd/android_brand_mvp/databinding/FragmentCustomizedTextBinding;", 0);
        }

        public final FragmentCustomizedTextBinding invoke(LayoutInflater p0, ViewGroup viewGroup, boolean z) {
            Intrinsics.checkNotNullParameter(p0, "p0");
            return FragmentCustomizedTextBinding.inflate(p0, viewGroup, z);
        }

        @Override // kotlin.jvm.functions.Function3
        public /* bridge */ /* synthetic */ FragmentCustomizedTextBinding invoke(LayoutInflater layoutInflater, ViewGroup viewGroup, Boolean bool) {
            return invoke(layoutInflater, viewGroup, bool.booleanValue());
        }
    }

    public CustomizedTextFragment() {
        super(AnonymousClass1.INSTANCE);
        this.type = "";
    }

    /* JADX INFO: compiled from: CustomizedTextFragment.kt */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J5\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\n2\u0006\u0010\u000b\u001a\u00020\f¢\u0006\u0002\u0010\r¨\u0006\u000e"}, d2 = {"Lcom/yd/android_brand_mvp/landscape/customized/tianjin/CustomizedTextFragment$Companion;", "", "()V", "newInstance", "Landroidx/fragment/app/Fragment;", "type", "", "title", "borderColor", "showTopTile", "", "data", "Lcom/yd/android_brand_mvp/model/custom/TextContentBean;", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Lcom/yd/android_brand_mvp/model/custom/TextContentBean;)Landroidx/fragment/app/Fragment;", "app_commonRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final Fragment newInstance(String type, String title, String borderColor, Boolean showTopTile, TextContentBean data) {
            Intrinsics.checkNotNullParameter(type, "type");
            Intrinsics.checkNotNullParameter(title, "title");
            Intrinsics.checkNotNullParameter(borderColor, "borderColor");
            Intrinsics.checkNotNullParameter(data, "data");
            CustomizedTextFragment customizedTextFragment = new CustomizedTextFragment();
            Bundle bundle = new Bundle();
            bundle.putString("type", type);
            bundle.putString("title", title);
            bundle.putString("borderColor", borderColor);
            bundle.putBoolean("showTopTile", showTopTile != null ? showTopTile.booleanValue() : true);
            bundle.putParcelable("richTextData", data);
            customizedTextFragment.setArguments(bundle);
            return customizedTextFragment;
        }
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    @Override // com.yd.android_brand_mvp.base.KTBaseFragment, com.yd.android_brand_mvp.base.BaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        String string;
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        Bundle arguments = getArguments();
        String string2 = arguments != null ? arguments.getString("type") : null;
        if (string2 == null) {
            string2 = "hbzdy44";
        }
        this.type = string2;
        Bundle arguments2 = getArguments();
        if (arguments2 == null || (string = arguments2.getString("title")) == null) {
            string = "";
        }
        getBinding().topFragmentTitle.title.setText(string);
        String str = this.type;
        switch (str.hashCode()) {
            case 732525652:
                if (str.equals("hbzdy21")) {
                    getBinding().clFragmentCustomText.getLayoutParams().width = SizeUtils.dp2px(444.0f);
                    getBinding().clFragmentCustomText.getLayoutParams().height = SizeUtils.dp2px(136.0f);
                }
                break;
            case 732525653:
                if (str.equals("hbzdy22")) {
                    getBinding().clFragmentCustomText.getLayoutParams().width = SizeUtils.dp2px(444.0f);
                    getBinding().clFragmentCustomText.getLayoutParams().height = SizeUtils.dp2px(291.0f);
                }
                break;
            case 732525683:
                if (str.equals("hbzdy31")) {
                    getBinding().clFragmentCustomText.getLayoutParams().width = SizeUtils.dp2px(676.0f);
                    getBinding().clFragmentCustomText.getLayoutParams().height = SizeUtils.dp2px(136.0f);
                }
                break;
            case 732525684:
                if (str.equals("hbzdy32")) {
                    getBinding().clFragmentCustomText.getLayoutParams().width = SizeUtils.dp2px(676.0f);
                    getBinding().clFragmentCustomText.getLayoutParams().height = SizeUtils.dp2px(292.0f);
                }
                break;
            case 732525714:
                if (str.equals("hbzdy41")) {
                    getBinding().clFragmentCustomText.getLayoutParams().width = SizeUtils.dp2px(908.0f);
                    getBinding().clFragmentCustomText.getLayoutParams().height = SizeUtils.dp2px(136.0f);
                }
                break;
            case 732525715:
                if (str.equals("hbzdy42")) {
                    getBinding().clFragmentCustomText.getLayoutParams().width = SizeUtils.dp2px(908.0f);
                    getBinding().clFragmentCustomText.getLayoutParams().height = SizeUtils.dp2px(291.0f);
                }
                break;
            case 1905131551:
                if (str.equals("sbzdy21")) {
                    getBinding().clFragmentCustomText.getLayoutParams().width = SizeUtils.dp2px(320.0f);
                    getBinding().clFragmentCustomText.getLayoutParams().height = SizeUtils.dp2px(202.0f);
                }
                break;
            case 1905131613:
                if (str.equals("sbzdy41")) {
                    getBinding().clFragmentCustomText.getLayoutParams().width = SizeUtils.dp2px(660.0f);
                    getBinding().clFragmentCustomText.getLayoutParams().height = SizeUtils.dp2px(202.0f);
                }
                break;
            case 1905131675:
                if (str.equals("sbzdy61")) {
                    getBinding().clFragmentCustomText.getLayoutParams().width = SizeUtils.dp2px(1000.0f);
                    getBinding().clFragmentCustomText.getLayoutParams().height = SizeUtils.dp2px(202.0f);
                }
                break;
        }
        Bundle arguments3 = getArguments();
        TextContentBean textContentBean = arguments3 != null ? (TextContentBean) arguments3.getParcelable("richTextData") : null;
        if (textContentBean != null) {
            getBinding().tvFragmentCustomTextDesc.setText(textContentBean.getText());
        }
    }
}
