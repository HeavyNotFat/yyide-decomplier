package com.yd.android_brand_mvp.activity.collect.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import com.yd.android_brand_mvp.R;
import com.yd.android_brand_mvp.databinding.ViewCollectFormAutoLocationBinding;
import com.yd.android_brand_mvp.model.FormVerifyBean;
import com.yd.android_brand_mvp.model.collect.FormBaseBean;
import com.yd.android_brand_mvp.model.collect.FormLocationBean;
import com.yd.android_brand_mvp.utils.SimpleUtilsKt;
import com.yd.android_brand_mvp.utils.SpData;
import com.yd.android_brand_mvp.utils.TransUtils;
import com.yd.android_brand_mvp.utils.view.net.GsonUtils;
import kotlin.Metadata;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: FormAutoLocationFragment.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u000f2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u000fB\u0005¢\u0006\u0002\u0010\u0003J\b\u0010\u0006\u001a\u00020\u0007H\u0002J\u001a\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0016J\b\u0010\r\u001a\u00020\u000eH\u0016R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lcom/yd/android_brand_mvp/activity/collect/fragment/FormAutoLocationFragment;", "Lcom/yd/android_brand_mvp/activity/collect/fragment/BaseCollectFragment;", "Lcom/yd/android_brand_mvp/databinding/ViewCollectFormAutoLocationBinding;", "()V", "formItemData", "Lcom/yd/android_brand_mvp/model/collect/FormBaseBean;", "initView", "", "onViewCreated", "view", "Landroid/view/View;", "savedInstanceState", "Landroid/os/Bundle;", "readySubmit", "Lcom/yd/android_brand_mvp/model/FormVerifyBean;", "Companion", "app_commonRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class FormAutoLocationFragment extends BaseCollectFragment<ViewCollectFormAutoLocationBinding> {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private FormBaseBean formItemData;

    /* JADX INFO: renamed from: com.yd.android_brand_mvp.activity.collect.fragment.FormAutoLocationFragment$1, reason: invalid class name */
    /* JADX INFO: compiled from: FormAutoLocationFragment.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements Function3<LayoutInflater, ViewGroup, Boolean, ViewCollectFormAutoLocationBinding> {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        AnonymousClass1() {
            super(3, ViewCollectFormAutoLocationBinding.class, "inflate", "inflate(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Z)Lcom/yd/android_brand_mvp/databinding/ViewCollectFormAutoLocationBinding;", 0);
        }

        public final ViewCollectFormAutoLocationBinding invoke(LayoutInflater p0, ViewGroup viewGroup, boolean z) {
            Intrinsics.checkNotNullParameter(p0, "p0");
            return ViewCollectFormAutoLocationBinding.inflate(p0, viewGroup, z);
        }

        @Override // kotlin.jvm.functions.Function3
        public /* bridge */ /* synthetic */ ViewCollectFormAutoLocationBinding invoke(LayoutInflater layoutInflater, ViewGroup viewGroup, Boolean bool) {
            return invoke(layoutInflater, viewGroup, bool.booleanValue());
        }
    }

    public FormAutoLocationFragment() {
        super(AnonymousClass1.INSTANCE);
    }

    /* JADX INFO: compiled from: FormAutoLocationFragment.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\u0007"}, d2 = {"Lcom/yd/android_brand_mvp/activity/collect/fragment/FormAutoLocationFragment$Companion;", "", "()V", "newInstance", "Landroidx/fragment/app/Fragment;", "dataBean", "Lcom/yd/android_brand_mvp/model/collect/FormBaseBean;", "app_commonRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final Fragment newInstance(FormBaseBean dataBean) {
            Intrinsics.checkNotNullParameter(dataBean, "dataBean");
            FormAutoLocationFragment formAutoLocationFragment = new FormAutoLocationFragment();
            Bundle bundle = new Bundle();
            bundle.putString("data", GsonUtils.toJson(dataBean));
            formAutoLocationFragment.setArguments(bundle);
            return formAutoLocationFragment;
        }
    }

    @Override // com.yd.android_brand_mvp.base.KTBaseFragment, com.yd.android_brand_mvp.base.BaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        initView();
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void initView() {
        Bundle arguments = getArguments();
        FormBaseBean formBaseBean = (FormBaseBean) GsonUtils.fromJson(arguments != null ? arguments.getString("data") : null, FormBaseBean.class);
        this.formItemData = formBaseBean;
        if (formBaseBean != null) {
            ((ViewCollectFormAutoLocationBinding) getBinding()).tvViewCollectFormLocationName.setText(TransUtils.INSTANCE.transIntToString(formBaseBean.getSortNum()) + '.' + formBaseBean.getTitle());
            if (!formBaseBean.getProps().getRequired()) {
                TextView textView = ((ViewCollectFormAutoLocationBinding) getBinding()).tvViewCollectFormLocationRequired;
                Intrinsics.checkNotNullExpressionValue(textView, "binding.tvViewCollectFormLocationRequired");
                SimpleUtilsKt.remove(textView);
            }
            String value = formBaseBean.getValue();
            if (!(value == null || value.length() == 0)) {
                FormLocationBean formLocationBean = (FormLocationBean) GsonUtils.fromJson(formBaseBean.getValue(), FormLocationBean.class);
                ((ViewCollectFormAutoLocationBinding) getBinding()).tvViewCollectFormLocationAddress.setTextColor(SimpleUtilsKt.asColor(R.color.text_333333));
                ((ViewCollectFormAutoLocationBinding) getBinding()).tvViewCollectFormLocationAddress.setText(formLocationBean.getAddress());
                ((ViewCollectFormAutoLocationBinding) getBinding()).ivViewCollectFormLocation.setImageResource(R.mipmap.icon_location);
                ImageView imageView = ((ViewCollectFormAutoLocationBinding) getBinding()).ivViewCollectFormLocationDel;
                Intrinsics.checkNotNullExpressionValue(imageView, "binding.ivViewCollectFormLocationDel");
                SimpleUtilsKt.show(imageView);
            }
        }
        ((ViewCollectFormAutoLocationBinding) getBinding()).clViewCollectFormLocation.setOnClickListener(new View.OnClickListener() { // from class: com.yd.android_brand_mvp.activity.collect.fragment.-$$Lambda$FormAutoLocationFragment$uFJzv1lFPeH7QJ4mZxbg1MYHltE
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                FormAutoLocationFragment.initView$lambda$1(this.f$0, view);
            }
        });
        ((ViewCollectFormAutoLocationBinding) getBinding()).ivViewCollectFormLocationDel.setOnClickListener(new View.OnClickListener() { // from class: com.yd.android_brand_mvp.activity.collect.fragment.-$$Lambda$FormAutoLocationFragment$ZiLgw2Wcta14DNoJZobz5fjFxp8
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                FormAutoLocationFragment.initView$lambda$2(this.f$0, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final void initView$lambda$1(FormAutoLocationFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        ((ViewCollectFormAutoLocationBinding) this$0.getBinding()).tvViewCollectFormLocationAddress.setText(SpData.getSchoolInfo2().data.area + SpData.getSchoolInfo2().data.address);
        ((ViewCollectFormAutoLocationBinding) this$0.getBinding()).ivViewCollectFormLocation.setImageResource(R.mipmap.icon_location);
        ImageView imageView = ((ViewCollectFormAutoLocationBinding) this$0.getBinding()).ivViewCollectFormLocationDel;
        Intrinsics.checkNotNullExpressionValue(imageView, "binding.ivViewCollectFormLocationDel");
        SimpleUtilsKt.show(imageView);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final void initView$lambda$2(FormAutoLocationFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        ((ViewCollectFormAutoLocationBinding) this$0.getBinding()).tvViewCollectFormLocationAddress.setText("");
        ((ViewCollectFormAutoLocationBinding) this$0.getBinding()).ivViewCollectFormLocation.setImageResource(R.mipmap.icon_location_not);
        ImageView imageView = ((ViewCollectFormAutoLocationBinding) this$0.getBinding()).ivViewCollectFormLocationDel;
        Intrinsics.checkNotNullExpressionValue(imageView, "binding.ivViewCollectFormLocationDel");
        SimpleUtilsKt.hide(imageView);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.yd.android_brand_mvp.activity.collect.fragment.BaseCollectFragment
    public FormVerifyBean readySubmit() {
        FormVerifyBean formVerifyBean = new FormVerifyBean(false, null, 0, null, null, null, 63, null);
        FormBaseBean formBaseBean = this.formItemData;
        if (formBaseBean == null) {
            formVerifyBean.setStatus(false);
            formVerifyBean.setErrorMessage("数据为空");
            return formVerifyBean;
        }
        Intrinsics.checkNotNull(formBaseBean);
        if (formBaseBean.getProps().getRequired()) {
            CharSequence text = ((ViewCollectFormAutoLocationBinding) getBinding()).tvViewCollectFormLocationAddress.getText();
            Intrinsics.checkNotNullExpressionValue(text, "binding.tvViewCollectFormLocationAddress.text");
            if (text.length() == 0) {
                formVerifyBean.setStatus(false);
                formVerifyBean.setErrorMessage("自动定位必填项未填写");
                return formVerifyBean;
            }
        }
        String json = GsonUtils.toJson(new FormLocationBean(null, ((ViewCollectFormAutoLocationBinding) getBinding()).tvViewCollectFormLocationAddress.getText().toString(), null, null, 13, null));
        FormBaseBean formBaseBean2 = this.formItemData;
        Intrinsics.checkNotNull(formBaseBean2);
        formVerifyBean.setSort(formBaseBean2.getSort());
        formVerifyBean.setDataValue(json);
        return formVerifyBean;
    }
}
