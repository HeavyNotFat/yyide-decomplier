package com.yd.android_brand_mvp.landscape.custom;

import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.blankj.utilcode.util.SizeUtils;
import com.yd.android_brand_mvp.R;
import com.yd.android_brand_mvp.adapter.custom.CustomFormAdapter;
import com.yd.android_brand_mvp.adapter.custom.CustomListAdapter;
import com.yd.android_brand_mvp.base.KTBaseFragment;
import com.yd.android_brand_mvp.databinding.FragmentCustomRecyclerBinding;
import com.yd.android_brand_mvp.model.custom.CustomListBean;
import com.yd.android_brand_mvp.model.custom.FormContentBean;
import com.yd.android_brand_mvp.model.custom.ListContentBean;
import com.yd.android_brand_mvp.model.custom.ListContentItemBean;
import com.yd.android_brand_mvp.utils.TransUtils;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: CustomRecyclerviewFragment.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u000e2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u000eB\u0005¢\u0006\u0002\u0010\u0003J\b\u0010\u0006\u001a\u00020\u0007H\u0014J\u001a\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/yd/android_brand_mvp/landscape/custom/CustomRecyclerviewFragment;", "Lcom/yd/android_brand_mvp/base/KTBaseFragment;", "Lcom/yd/android_brand_mvp/databinding/FragmentCustomRecyclerBinding;", "()V", "type", "", "needControlTopTitleShow", "", "onViewCreated", "", "view", "Landroid/view/View;", "savedInstanceState", "Landroid/os/Bundle;", "Companion", "app_commonRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class CustomRecyclerviewFragment extends KTBaseFragment<FragmentCustomRecyclerBinding> {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private String type;

    @Override // com.yd.android_brand_mvp.base.KTBaseFragment
    protected boolean needControlTopTitleShow() {
        return true;
    }

    /* JADX INFO: renamed from: com.yd.android_brand_mvp.landscape.custom.CustomRecyclerviewFragment$1, reason: invalid class name */
    /* JADX INFO: compiled from: CustomRecyclerviewFragment.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements Function3<LayoutInflater, ViewGroup, Boolean, FragmentCustomRecyclerBinding> {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        AnonymousClass1() {
            super(3, FragmentCustomRecyclerBinding.class, "inflate", "inflate(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Z)Lcom/yd/android_brand_mvp/databinding/FragmentCustomRecyclerBinding;", 0);
        }

        public final FragmentCustomRecyclerBinding invoke(LayoutInflater p0, ViewGroup viewGroup, boolean z) {
            Intrinsics.checkNotNullParameter(p0, "p0");
            return FragmentCustomRecyclerBinding.inflate(p0, viewGroup, z);
        }

        @Override // kotlin.jvm.functions.Function3
        public /* bridge */ /* synthetic */ FragmentCustomRecyclerBinding invoke(LayoutInflater layoutInflater, ViewGroup viewGroup, Boolean bool) {
            return invoke(layoutInflater, viewGroup, bool.booleanValue());
        }
    }

    public CustomRecyclerviewFragment() {
        super(AnonymousClass1.INSTANCE);
        this.type = "";
    }

    /* JADX INFO: compiled from: CustomRecyclerviewFragment.kt */
    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J5\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\n2\u0006\u0010\u000b\u001a\u00020\f¢\u0006\u0002\u0010\rJ5\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\n2\u0006\u0010\u000b\u001a\u00020\u000e¢\u0006\u0002\u0010\u000f¨\u0006\u0010"}, d2 = {"Lcom/yd/android_brand_mvp/landscape/custom/CustomRecyclerviewFragment$Companion;", "", "()V", "newInstance", "Landroidx/fragment/app/Fragment;", "type", "", "title", "borderColor", "showTopTile", "", "data", "Lcom/yd/android_brand_mvp/model/custom/FormContentBean;", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Lcom/yd/android_brand_mvp/model/custom/FormContentBean;)Landroidx/fragment/app/Fragment;", "Lcom/yd/android_brand_mvp/model/custom/ListContentBean;", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Lcom/yd/android_brand_mvp/model/custom/ListContentBean;)Landroidx/fragment/app/Fragment;", "app_commonRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final Fragment newInstance(String type, String title, String borderColor, Boolean showTopTile, ListContentBean data) {
            Intrinsics.checkNotNullParameter(type, "type");
            Intrinsics.checkNotNullParameter(title, "title");
            Intrinsics.checkNotNullParameter(borderColor, "borderColor");
            Intrinsics.checkNotNullParameter(data, "data");
            CustomRecyclerviewFragment customRecyclerviewFragment = new CustomRecyclerviewFragment();
            Bundle bundle = new Bundle();
            bundle.putString("type", type);
            bundle.putString("title", title);
            bundle.putInt("adapterType", 3);
            bundle.putString("borderColor", borderColor);
            bundle.putBoolean("showTopTile", showTopTile != null ? showTopTile.booleanValue() : true);
            bundle.putParcelable("listData", data);
            customRecyclerviewFragment.setArguments(bundle);
            return customRecyclerviewFragment;
        }

        public final Fragment newInstance(String type, String title, String borderColor, Boolean showTopTile, FormContentBean data) {
            Intrinsics.checkNotNullParameter(type, "type");
            Intrinsics.checkNotNullParameter(title, "title");
            Intrinsics.checkNotNullParameter(borderColor, "borderColor");
            Intrinsics.checkNotNullParameter(data, "data");
            CustomRecyclerviewFragment customRecyclerviewFragment = new CustomRecyclerviewFragment();
            Bundle bundle = new Bundle();
            bundle.putString("type", type);
            bundle.putString("title", title);
            bundle.putInt("adapterType", 4);
            bundle.putString("borderColor", borderColor);
            bundle.putBoolean("showTopTile", showTopTile != null ? showTopTile.booleanValue() : true);
            bundle.putParcelable("formData", data);
            customRecyclerviewFragment.setArguments(bundle);
            return customRecyclerviewFragment;
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
            string3 = "hbzdy22";
        }
        this.type = string3;
        Bundle arguments2 = getArguments();
        if (arguments2 == null || (string = arguments2.getString("title")) == null) {
            string = "";
        }
        getBinding().topFragmentTitle.title.setText(string);
        Bundle arguments3 = getArguments();
        if (arguments3 == null || (string2 = arguments3.getString("borderColor")) == null) {
            string2 = "#ffffff";
        }
        int i = 0;
        String str = string2.length() == 0 ? "#ffffff" : string2;
        Drawable drawable = AppCompatResources.getDrawable(requireContext(), R.drawable.bg_custom_20);
        Intrinsics.checkNotNull(drawable, "null cannot be cast to non-null type android.graphics.drawable.GradientDrawable");
        GradientDrawable gradientDrawable = (GradientDrawable) drawable;
        gradientDrawable.setStroke(SizeUtils.dp2px(4.0f), Color.parseColor(str));
        getBinding().clFragmentCustomRecycler.setBackground(gradientDrawable);
        String str2 = this.type;
        switch (str2.hashCode()) {
            case 732525653:
                if (str2.equals("hbzdy22")) {
                    getBinding().clFragmentCustomRecycler.getLayoutParams().width = SizeUtils.dp2px(444.0f);
                    getBinding().clFragmentCustomRecycler.getLayoutParams().height = SizeUtils.dp2px(292.0f);
                }
                break;
            case 732525654:
                if (str2.equals("hbzdy23")) {
                    getBinding().clFragmentCustomRecycler.getLayoutParams().width = SizeUtils.dp2px(444.0f);
                    getBinding().clFragmentCustomRecycler.getLayoutParams().height = SizeUtils.dp2px(454.0f);
                }
                break;
            case 732525655:
                if (str2.equals("hbzdy24")) {
                    getBinding().clFragmentCustomRecycler.getLayoutParams().width = SizeUtils.dp2px(444.0f);
                    getBinding().clFragmentCustomRecycler.getLayoutParams().height = SizeUtils.dp2px(604.0f);
                }
                break;
            case 732525683:
                if (str2.equals("hbzdy31")) {
                    getBinding().clFragmentCustomRecycler.getLayoutParams().width = SizeUtils.dp2px(668.0f);
                    getBinding().clFragmentCustomRecycler.getLayoutParams().height = SizeUtils.dp2px(136.0f);
                }
                break;
            case 1905131551:
                if (str2.equals("sbzdy21")) {
                    getBinding().clFragmentCustomRecycler.getLayoutParams().width = SizeUtils.dp2px(320.0f);
                    getBinding().clFragmentCustomRecycler.getLayoutParams().height = SizeUtils.dp2px(202.0f);
                }
                break;
            case 1905131552:
                if (str2.equals("sbzdy22")) {
                    getBinding().clFragmentCustomRecycler.getLayoutParams().width = SizeUtils.dp2px(320.0f);
                    getBinding().clFragmentCustomRecycler.getLayoutParams().height = SizeUtils.dp2px(424.0f);
                }
                break;
        }
        Bundle arguments4 = getArguments();
        int i2 = arguments4 != null ? arguments4.getInt("adapterType") : 3;
        if (i2 != 3) {
            if (i2 != 4) {
                return;
            }
            Bundle arguments5 = getArguments();
            FormContentBean formContentBean = arguments5 != null ? (FormContentBean) arguments5.getParcelable("formData") : null;
            if (formContentBean == null) {
                formContentBean = new FormContentBean(null, null, 3, null);
            }
            CustomFormAdapter customFormAdapter = new CustomFormAdapter();
            getBinding().rvFragmentCustomRecycler.setLayoutManager(new LinearLayoutManager(requireContext()));
            getBinding().rvFragmentCustomRecycler.setAdapter(customFormAdapter);
            customFormAdapter.setList(formContentBean.getFormContents());
            return;
        }
        Bundle arguments6 = getArguments();
        ListContentBean listContentBean = arguments6 != null ? (ListContentBean) arguments6.getParcelable("listData") : null;
        if (listContentBean != null) {
            ArrayList arrayList = new ArrayList();
            if (listContentBean.getLevel() == 1 && listContentBean.getSymbol() == 1) {
                int i3 = 0;
                for (Object obj : listContentBean.getContent()) {
                    int i4 = i3 + 1;
                    if (i3 < 0) {
                        CollectionsKt.throwIndexOverflow();
                    }
                    arrayList.add(new CustomListBean(TransUtils.INSTANCE.toChineseNumber(i4) + ". " + ((ListContentItemBean) obj).getFirstTitle(), 0));
                    i3 = i4;
                }
            } else if (listContentBean.getLevel() == 1 && listContentBean.getSymbol() == 2) {
                for (Object obj2 : listContentBean.getContent()) {
                    int i5 = i + 1;
                    if (i < 0) {
                        CollectionsKt.throwIndexOverflow();
                    }
                    arrayList.add(new CustomListBean(' ' + ((ListContentItemBean) obj2).getFirstTitle(), 2));
                    i = i5;
                }
            } else if (listContentBean.getLevel() == 2 && listContentBean.getSymbol() == 1) {
                int i6 = 0;
                for (Object obj3 : listContentBean.getContent()) {
                    int i7 = i6 + 1;
                    if (i6 < 0) {
                        CollectionsKt.throwIndexOverflow();
                    }
                    ListContentItemBean listContentItemBean = (ListContentItemBean) obj3;
                    arrayList.add(new CustomListBean(TransUtils.INSTANCE.toChineseNumber(i7) + ". " + listContentItemBean.getFirstTitle(), 0));
                    int i8 = 0;
                    for (Object obj4 : listContentItemBean.getSecondTitles()) {
                        int i9 = i8 + 1;
                        if (i8 < 0) {
                            CollectionsKt.throwIndexOverflow();
                        }
                        arrayList.add(new CustomListBean(i9 + ". " + ((String) obj4), 1));
                        i8 = i9;
                    }
                    i6 = i7;
                }
            } else if (listContentBean.getLevel() == 2 && listContentBean.getSymbol() == 2) {
                int i10 = 0;
                for (Object obj5 : listContentBean.getContent()) {
                    int i11 = i10 + 1;
                    if (i10 < 0) {
                        CollectionsKt.throwIndexOverflow();
                    }
                    ListContentItemBean listContentItemBean2 = (ListContentItemBean) obj5;
                    arrayList.add(new CustomListBean(' ' + listContentItemBean2.getFirstTitle(), 2));
                    int i12 = 0;
                    for (Object obj6 : listContentItemBean2.getSecondTitles()) {
                        int i13 = i12 + 1;
                        if (i12 < 0) {
                            CollectionsKt.throwIndexOverflow();
                        }
                        arrayList.add(new CustomListBean(' ' + ((String) obj6), 3));
                        i12 = i13;
                    }
                    i10 = i11;
                }
            }
            CustomListAdapter customListAdapter = new CustomListAdapter();
            getBinding().rvFragmentCustomRecycler.setLayoutManager(new LinearLayoutManager(requireContext()));
            getBinding().rvFragmentCustomRecycler.setAdapter(customListAdapter);
            customListAdapter.setList(arrayList);
        }
    }
}
