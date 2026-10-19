package com.yd.android_brand_mvp.activity.repair;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.FragmentTransaction;
import com.blankj.utilcode.util.SizeUtils;
import com.yd.android_brand_mvp.R;
import com.yd.android_brand_mvp.base.KTBaseFragment;
import com.yd.android_brand_mvp.databinding.FragmentUserRepairBinding;
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

/* JADX INFO: compiled from: UserRepairFragment.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \u00152\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0015B\u0005¢\u0006\u0002\u0010\u0003J\b\u0010\b\u001a\u00020\tH\u0002J\b\u0010\n\u001a\u00020\tH\u0016J\u001a\u0010\u000b\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0016J\u0010\u0010\u0010\u001a\u00020\t2\u0006\u0010\u0011\u001a\u00020\u0012H\u0007J\u0010\u0010\u0013\u001a\u00020\t2\u0006\u0010\u0014\u001a\u00020\u0005H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"Lcom/yd/android_brand_mvp/activity/repair/UserRepairFragment;", "Lcom/yd/android_brand_mvp/base/KTBaseFragment;", "Lcom/yd/android_brand_mvp/databinding/FragmentUserRepairBinding;", "()V", "currentShow", "", "verifyData", "Lcom/yd/android_brand_mvp/model/collect/UserVerifyBean;", "initView", "", "onDestroyView", "onViewCreated", "view", "Landroid/view/View;", "savedInstanceState", "Landroid/os/Bundle;", "parseEventBean", "data", "Lcom/yd/android_brand_mvp/model/EventBean;", "showFragment", "type", "Companion", "app_commonRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class UserRepairFragment extends KTBaseFragment<FragmentUserRepairBinding> {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private int currentShow;
    private UserVerifyBean verifyData;

    /* JADX INFO: renamed from: com.yd.android_brand_mvp.activity.repair.UserRepairFragment$1, reason: invalid class name */
    /* JADX INFO: compiled from: UserRepairFragment.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements Function3<LayoutInflater, ViewGroup, Boolean, FragmentUserRepairBinding> {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        AnonymousClass1() {
            super(3, FragmentUserRepairBinding.class, "inflate", "inflate(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Z)Lcom/yd/android_brand_mvp/databinding/FragmentUserRepairBinding;", 0);
        }

        public final FragmentUserRepairBinding invoke(LayoutInflater p0, ViewGroup viewGroup, boolean z) {
            Intrinsics.checkNotNullParameter(p0, "p0");
            return FragmentUserRepairBinding.inflate(p0, viewGroup, z);
        }

        @Override // kotlin.jvm.functions.Function3
        public /* bridge */ /* synthetic */ FragmentUserRepairBinding invoke(LayoutInflater layoutInflater, ViewGroup viewGroup, Boolean bool) {
            return invoke(layoutInflater, viewGroup, bool.booleanValue());
        }
    }

    public UserRepairFragment() {
        super(AnonymousClass1.INSTANCE);
        this.currentShow = 1;
    }

    /* JADX INFO: compiled from: UserRepairFragment.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\u0007"}, d2 = {"Lcom/yd/android_brand_mvp/activity/repair/UserRepairFragment$Companion;", "", "()V", "newInstance", "Lcom/yd/android_brand_mvp/activity/repair/UserRepairFragment;", "data", "Lcom/yd/android_brand_mvp/model/collect/UserVerifyBean;", "app_commonRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final UserRepairFragment newInstance(UserVerifyBean data) {
            Intrinsics.checkNotNullParameter(data, "data");
            Bundle bundle = new Bundle();
            UserRepairFragment userRepairFragment = new UserRepairFragment();
            bundle.putParcelable("verifyData", data);
            userRepairFragment.setArguments(bundle);
            return userRepairFragment;
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
        getBinding().tvFragmentRepairDetailLaunch.setOnClickListener(new View.OnClickListener() { // from class: com.yd.android_brand_mvp.activity.repair.-$$Lambda$UserRepairFragment$DVI4bwaSNG77dbw2-PRlN_kAubs
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                UserRepairFragment.initView$lambda$0(this.f$0, view);
            }
        });
        getBinding().tvFragmentRepairDetailList.setOnClickListener(new View.OnClickListener() { // from class: com.yd.android_brand_mvp.activity.repair.-$$Lambda$UserRepairFragment$xkEZ7JYAVOleD39zw6bYzkZ_M5M
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                UserRepairFragment.initView$lambda$1(this.f$0, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$0(UserRepairFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (this$0.currentShow == 1) {
            return;
        }
        this$0.getBinding().tvFragmentRepairDetailLaunch.setTextColor(SimpleUtilsKt.asColor(R.color.text_333333));
        this$0.getBinding().tvFragmentRepairDetailList.setTextColor(SimpleUtilsKt.asColor(R.color.color_999999));
        this$0.getBinding().tvFragmentRepairDetailLaunch.setTextSize(SizeUtils.dp2px(26.0f));
        this$0.getBinding().tvFragmentRepairDetailList.setTextSize(SizeUtils.dp2px(24.0f));
        this$0.showFragment(1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$1(UserRepairFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (this$0.currentShow == 2) {
            return;
        }
        this$0.getBinding().tvFragmentRepairDetailList.setTextColor(SimpleUtilsKt.asColor(R.color.text_333333));
        this$0.getBinding().tvFragmentRepairDetailLaunch.setTextColor(SimpleUtilsKt.asColor(R.color.color_999999));
        this$0.getBinding().tvFragmentRepairDetailLaunch.setTextSize(SizeUtils.dp2px(24.0f));
        this$0.getBinding().tvFragmentRepairDetailList.setTextSize(SizeUtils.dp2px(26.0f));
        this$0.showFragment(2);
    }

    private final void showFragment(int type) {
        this.currentShow = type;
        FragmentTransaction fragmentTransactionBeginTransaction = getChildFragmentManager().beginTransaction();
        Intrinsics.checkNotNullExpressionValue(fragmentTransactionBeginTransaction, "childFragmentManager.beginTransaction()");
        if (type == 1) {
            LaunchRepairFragment.Companion companion = LaunchRepairFragment.INSTANCE;
            UserVerifyBean userVerifyBean = this.verifyData;
            Intrinsics.checkNotNull(userVerifyBean);
            LaunchRepairFragment launchRepairFragmentNewInstance = companion.newInstance(userVerifyBean);
            fragmentTransactionBeginTransaction.replace(getBinding().flFragmentRepairDetail.getId(), launchRepairFragmentNewInstance, Reflection.getOrCreateKotlinClass(launchRepairFragmentNewInstance.getClass()).getSimpleName());
        } else {
            RepairListFragment.Companion companion2 = RepairListFragment.INSTANCE;
            UserVerifyBean userVerifyBean2 = this.verifyData;
            Intrinsics.checkNotNull(userVerifyBean2);
            RepairListFragment repairListFragmentNewInstance = companion2.newInstance(userVerifyBean2);
            fragmentTransactionBeginTransaction.replace(getBinding().flFragmentRepairDetail.getId(), repairListFragmentNewInstance, Reflection.getOrCreateKotlinClass(repairListFragmentNewInstance.getClass()).getSimpleName());
        }
        fragmentTransactionBeginTransaction.commitNowAllowingStateLoss();
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public final void parseEventBean(EventBean data) {
        Intrinsics.checkNotNullParameter(data, "data");
        if (data.Event == 10002) {
            getBinding().tvFragmentRepairDetailList.setTextColor(SimpleUtilsKt.asColor(R.color.text_333333));
            getBinding().tvFragmentRepairDetailLaunch.setTextColor(SimpleUtilsKt.asColor(R.color.color_999999));
            getBinding().tvFragmentRepairDetailLaunch.setTextSize(SizeUtils.dp2px(24.0f));
            getBinding().tvFragmentRepairDetailList.setTextSize(SizeUtils.dp2px(26.0f));
            showFragment(2);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        EventBus.getDefault().unregister(this);
    }
}
