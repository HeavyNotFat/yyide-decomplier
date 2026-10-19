package com.yd.android_brand_mvp.activity.repair;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.FragmentTransaction;
import com.yd.android_brand_mvp.R;
import com.yd.android_brand_mvp.base.KTBaseFragment;
import com.yd.android_brand_mvp.databinding.FragmentRepairDetailBinding;
import com.yd.android_brand_mvp.model.EventBean;
import com.yd.android_brand_mvp.model.collect.UserVerifyBean;
import com.yd.android_brand_mvp.utils.SimpleUtilsKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

/* JADX INFO: compiled from: RepairFragment.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \u001a2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u001aB\u0005¢\u0006\u0002\u0010\u0003J\b\u0010\r\u001a\u00020\u000eH\u0002J\b\u0010\u000f\u001a\u00020\u000eH\u0016J\u001a\u0010\u0010\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0016J\u0010\u0010\u0015\u001a\u00020\u000e2\u0006\u0010\u0016\u001a\u00020\u0017H\u0007J\u0010\u0010\u0018\u001a\u00020\u000e2\u0006\u0010\u0019\u001a\u00020\u0005H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001b"}, d2 = {"Lcom/yd/android_brand_mvp/activity/repair/RepairFragment;", "Lcom/yd/android_brand_mvp/base/KTBaseFragment;", "Lcom/yd/android_brand_mvp/databinding/FragmentRepairDetailBinding;", "()V", "currentShow", "", "formContent", "", "formKey", "modifyFormId", "reason", "verifyData", "Lcom/yd/android_brand_mvp/model/collect/UserVerifyBean;", "initView", "", "onDestroyView", "onViewCreated", "view", "Landroid/view/View;", "savedInstanceState", "Landroid/os/Bundle;", "parseEventBean", "data", "Lcom/yd/android_brand_mvp/model/EventBean;", "showFragment", "type", "Companion", "app_commonRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class RepairFragment extends KTBaseFragment<FragmentRepairDetailBinding> {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private int currentShow;
    private String formContent;
    private String formKey;
    private String modifyFormId;
    private String reason;
    private UserVerifyBean verifyData;

    /* JADX INFO: renamed from: com.yd.android_brand_mvp.activity.repair.RepairFragment$1, reason: invalid class name */
    /* JADX INFO: compiled from: RepairFragment.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements Function3<LayoutInflater, ViewGroup, Boolean, FragmentRepairDetailBinding> {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        AnonymousClass1() {
            super(3, FragmentRepairDetailBinding.class, "inflate", "inflate(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Z)Lcom/yd/android_brand_mvp/databinding/FragmentRepairDetailBinding;", 0);
        }

        public final FragmentRepairDetailBinding invoke(LayoutInflater p0, ViewGroup viewGroup, boolean z) {
            Intrinsics.checkNotNullParameter(p0, "p0");
            return FragmentRepairDetailBinding.inflate(p0, viewGroup, z);
        }

        @Override // kotlin.jvm.functions.Function3
        public /* bridge */ /* synthetic */ FragmentRepairDetailBinding invoke(LayoutInflater layoutInflater, ViewGroup viewGroup, Boolean bool) {
            return invoke(layoutInflater, viewGroup, bool.booleanValue());
        }
    }

    public RepairFragment() {
        super(AnonymousClass1.INSTANCE);
        this.currentShow = 1;
        this.formContent = "";
        this.formKey = "";
        this.reason = "";
        this.modifyFormId = "";
    }

    /* JADX INFO: compiled from: RepairFragment.kt */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006J.\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\b¨\u0006\f"}, d2 = {"Lcom/yd/android_brand_mvp/activity/repair/RepairFragment$Companion;", "", "()V", "newInstance", "Lcom/yd/android_brand_mvp/activity/repair/RepairFragment;", "data", "Lcom/yd/android_brand_mvp/model/collect/UserVerifyBean;", "formContent", "", "formKeyStr", "modifyReason", "modifyFormId", "app_commonRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final RepairFragment newInstance(UserVerifyBean data) {
            Intrinsics.checkNotNullParameter(data, "data");
            Bundle bundle = new Bundle();
            RepairFragment repairFragment = new RepairFragment();
            bundle.putParcelable("verifyData", data);
            repairFragment.setArguments(bundle);
            return repairFragment;
        }

        public final RepairFragment newInstance(UserVerifyBean data, String formContent, String formKeyStr, String modifyReason, String modifyFormId) {
            Intrinsics.checkNotNullParameter(data, "data");
            Intrinsics.checkNotNullParameter(formContent, "formContent");
            Intrinsics.checkNotNullParameter(formKeyStr, "formKeyStr");
            Intrinsics.checkNotNullParameter(modifyReason, "modifyReason");
            Intrinsics.checkNotNullParameter(modifyFormId, "modifyFormId");
            Bundle bundle = new Bundle();
            bundle.putParcelable("verifyData", data);
            bundle.putString("formContent", formContent);
            bundle.putString("formKey", formKeyStr);
            bundle.putString("reason", modifyReason);
            bundle.putString("formId", modifyFormId);
            RepairFragment repairFragment = new RepairFragment();
            repairFragment.setArguments(bundle);
            return repairFragment;
        }
    }

    @Override // com.yd.android_brand_mvp.base.KTBaseFragment, com.yd.android_brand_mvp.base.BaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        EventBus.getDefault().register(this);
        initView();
        showFragment(1);
    }

    private final void initView() {
        UserVerifyBean userVerifyBean;
        Bundle arguments = getArguments();
        if (arguments == null || (userVerifyBean = (UserVerifyBean) arguments.getParcelable("verifyData")) == null) {
            userVerifyBean = new UserVerifyBean(false, null, null, null, 15, null);
        }
        this.verifyData = userVerifyBean;
        Bundle arguments2 = getArguments();
        String string = arguments2 != null ? arguments2.getString("formContent") : null;
        if (string == null) {
            string = "";
        }
        this.formContent = string;
        Bundle arguments3 = getArguments();
        String string2 = arguments3 != null ? arguments3.getString("formKey") : null;
        if (string2 == null) {
            string2 = "";
        }
        this.formKey = string2;
        Bundle arguments4 = getArguments();
        String string3 = arguments4 != null ? arguments4.getString("reason") : null;
        if (string3 == null) {
            string3 = "";
        }
        this.reason = string3;
        Bundle arguments5 = getArguments();
        String string4 = arguments5 != null ? arguments5.getString("formId") : null;
        this.modifyFormId = string4 != null ? string4 : "";
        getBinding().tvFragmentRepairDetailLaunch.setOnClickListener(new View.OnClickListener() { // from class: com.yd.android_brand_mvp.activity.repair.-$$Lambda$RepairFragment$h55npu9LSyWmvL-_RBwTmAjhhxM
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                RepairFragment.initView$lambda$0(this.f$0, view);
            }
        });
        getBinding().tvFragmentRepairDetailList.setOnClickListener(new View.OnClickListener() { // from class: com.yd.android_brand_mvp.activity.repair.-$$Lambda$RepairFragment$4MVmrXLVAomRAdHM4Vtg8nKKB5w
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                RepairFragment.initView$lambda$1(this.f$0, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$0(RepairFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (this$0.currentShow == 1) {
            return;
        }
        this$0.getBinding().tvFragmentRepairDetailLaunch.setTextColor(SimpleUtilsKt.asColor(R.color.white));
        this$0.getBinding().tvFragmentRepairDetailLaunch.setBackgroundResource(R.drawable.bg_purple23);
        this$0.getBinding().tvFragmentRepairDetailList.setTextColor(SimpleUtilsKt.asColor(R.color.black16));
        this$0.getBinding().tvFragmentRepairDetailList.setBackground(null);
        this$0.showFragment(1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$1(RepairFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (this$0.currentShow == 2) {
            return;
        }
        this$0.getBinding().tvFragmentRepairDetailList.setTextColor(SimpleUtilsKt.asColor(R.color.white));
        this$0.getBinding().tvFragmentRepairDetailList.setBackgroundResource(R.drawable.bg_purple23);
        this$0.getBinding().tvFragmentRepairDetailLaunch.setTextColor(SimpleUtilsKt.asColor(R.color.black16));
        this$0.getBinding().tvFragmentRepairDetailLaunch.setBackground(null);
        this$0.showFragment(2);
    }

    private final void showFragment(int type) {
        LaunchRepairFragment launchRepairFragmentNewInstance;
        this.currentShow = type;
        FragmentTransaction fragmentTransactionBeginTransaction = getChildFragmentManager().beginTransaction();
        Intrinsics.checkNotNullExpressionValue(fragmentTransactionBeginTransaction, "childFragmentManager.beginTransaction()");
        if (type == 1) {
            if (this.formKey.length() == 0) {
                LaunchRepairFragment.Companion companion = LaunchRepairFragment.INSTANCE;
                UserVerifyBean userVerifyBean = this.verifyData;
                Intrinsics.checkNotNull(userVerifyBean);
                launchRepairFragmentNewInstance = companion.newInstance(userVerifyBean);
            } else {
                LaunchRepairFragment.Companion companion2 = LaunchRepairFragment.INSTANCE;
                UserVerifyBean userVerifyBean2 = this.verifyData;
                Intrinsics.checkNotNull(userVerifyBean2);
                launchRepairFragmentNewInstance = companion2.newInstance(userVerifyBean2, this.formContent, this.formKey, this.reason, this.modifyFormId);
            }
            fragmentTransactionBeginTransaction.replace(getBinding().flFragmentRepairDetail.getId(), launchRepairFragmentNewInstance, Reflection.getOrCreateKotlinClass(launchRepairFragmentNewInstance.getClass()).getSimpleName());
        } else {
            RepairListFragment.Companion companion3 = RepairListFragment.INSTANCE;
            UserVerifyBean userVerifyBean3 = this.verifyData;
            Intrinsics.checkNotNull(userVerifyBean3);
            RepairListFragment repairListFragmentNewInstance = companion3.newInstance(userVerifyBean3);
            fragmentTransactionBeginTransaction.replace(getBinding().flFragmentRepairDetail.getId(), repairListFragmentNewInstance, Reflection.getOrCreateKotlinClass(repairListFragmentNewInstance.getClass()).getSimpleName());
        }
        fragmentTransactionBeginTransaction.commitNowAllowingStateLoss();
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public final void parseEventBean(EventBean data) {
        Intrinsics.checkNotNullParameter(data, "data");
        if (data.Event == 10002) {
            getBinding().tvFragmentRepairDetailList.setTextColor(SimpleUtilsKt.asColor(R.color.white));
            getBinding().tvFragmentRepairDetailList.setBackgroundResource(R.drawable.bg_purple23);
            getBinding().tvFragmentRepairDetailLaunch.setTextColor(SimpleUtilsKt.asColor(R.color.black16));
            getBinding().tvFragmentRepairDetailLaunch.setBackground(null);
            showFragment(2);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        EventBus.getDefault().unregister(this);
    }
}
