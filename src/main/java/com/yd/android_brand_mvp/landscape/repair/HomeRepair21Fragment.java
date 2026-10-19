package com.yd.android_brand_mvp.landscape.repair;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.blankj.utilcode.util.SizeUtils;
import com.yd.android_brand_mvp.activity.repair.RepairActivity;
import com.yd.android_brand_mvp.base.BaseConstant;
import com.yd.android_brand_mvp.base.KTBaseFragment;
import com.yd.android_brand_mvp.databinding.FragmentRepair21Binding;
import com.yd.android_brand_mvp.dialog.MessageTipDialog;
import com.yd.android_brand_mvp.model.EventBean;
import com.yd.android_brand_mvp.model.collect.UserVerifyBean;
import com.yd.android_brand_mvp.verfity.CheackNomalActivity;
import kotlin.Metadata;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

/* JADX INFO: compiled from: HomeRepair21Fragment.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u00102\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0010B\u0005¢\u0006\u0002\u0010\u0003J\b\u0010\u0006\u001a\u00020\u0007H\u0016J\u0010\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\nH\u0007J\u001a\u0010\u000b\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lcom/yd/android_brand_mvp/landscape/repair/HomeRepair21Fragment;", "Lcom/yd/android_brand_mvp/base/KTBaseFragment;", "Lcom/yd/android_brand_mvp/databinding/FragmentRepair21Binding;", "()V", "type", "", "onDestroyView", "", "onEvent", "eventBean", "Lcom/yd/android_brand_mvp/model/EventBean;", "onViewCreated", "view", "Landroid/view/View;", "savedInstanceState", "Landroid/os/Bundle;", "Companion", "app_commonRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class HomeRepair21Fragment extends KTBaseFragment<FragmentRepair21Binding> {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private String type;

    /* JADX INFO: renamed from: com.yd.android_brand_mvp.landscape.repair.HomeRepair21Fragment$1, reason: invalid class name */
    /* JADX INFO: compiled from: HomeRepair21Fragment.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements Function3<LayoutInflater, ViewGroup, Boolean, FragmentRepair21Binding> {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        AnonymousClass1() {
            super(3, FragmentRepair21Binding.class, "inflate", "inflate(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Z)Lcom/yd/android_brand_mvp/databinding/FragmentRepair21Binding;", 0);
        }

        public final FragmentRepair21Binding invoke(LayoutInflater p0, ViewGroup viewGroup, boolean z) {
            Intrinsics.checkNotNullParameter(p0, "p0");
            return FragmentRepair21Binding.inflate(p0, viewGroup, z);
        }

        @Override // kotlin.jvm.functions.Function3
        public /* bridge */ /* synthetic */ FragmentRepair21Binding invoke(LayoutInflater layoutInflater, ViewGroup viewGroup, Boolean bool) {
            return invoke(layoutInflater, viewGroup, bool.booleanValue());
        }
    }

    public HomeRepair21Fragment() {
        super(AnonymousClass1.INSTANCE);
        this.type = "";
    }

    /* JADX INFO: compiled from: HomeRepair21Fragment.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\u0007"}, d2 = {"Lcom/yd/android_brand_mvp/landscape/repair/HomeRepair21Fragment$Companion;", "", "()V", "newInstance", "Lcom/yd/android_brand_mvp/landscape/repair/HomeRepair21Fragment;", "type", "", "app_commonRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final HomeRepair21Fragment newInstance(String type) {
            Intrinsics.checkNotNullParameter(type, "type");
            Bundle bundle = new Bundle();
            bundle.putString("type", type);
            HomeRepair21Fragment homeRepair21Fragment = new HomeRepair21Fragment();
            homeRepair21Fragment.setArguments(bundle);
            return homeRepair21Fragment;
        }
    }

    @Override // com.yd.android_brand_mvp.base.KTBaseFragment, com.yd.android_brand_mvp.base.BaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        Bundle arguments = getArguments();
        String string = arguments != null ? arguments.getString("type") : null;
        if (string == null) {
            string = "hbbx21";
        }
        this.type = string;
        EventBus.getDefault().register(this);
        String str = this.type;
        if (Intrinsics.areEqual(str, "hbbx21")) {
            getBinding().clFragmentRepair.getLayoutParams().width = SizeUtils.dp2px(444.0f);
            getBinding().clFragmentRepair.getLayoutParams().height = SizeUtils.dp2px(136.0f);
        } else if (Intrinsics.areEqual(str, "sbbx21")) {
            getBinding().clFragmentRepair.getLayoutParams().width = SizeUtils.dp2px(320.0f);
            getBinding().clFragmentRepair.getLayoutParams().height = SizeUtils.dp2px(202.0f);
        }
        getBinding().btnFragmentRepair.setOnClickListener(new View.OnClickListener() { // from class: com.yd.android_brand_mvp.landscape.repair.-$$Lambda$HomeRepair21Fragment$EaMHYMyFWveFlRP1lPGughpJ1Ts
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                HomeRepair21Fragment.onViewCreated$lambda$0(this.f$0, view2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onViewCreated$lambda$0(HomeRepair21Fragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intent intent = new Intent(this$0.requireContext(), (Class<?>) CheackNomalActivity.class);
        intent.putExtra("type", BaseConstant.homeReportCode21);
        this$0.startActivity(intent);
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public final void onEvent(EventBean eventBean) {
        Intrinsics.checkNotNullParameter(eventBean, "eventBean");
        if (eventBean.type != BaseConstant.homeReportCode21) {
            return;
        }
        if (eventBean.isStudent) {
            getChildFragmentManager().beginTransaction().add(new MessageTipDialog("学生如需发起报修请在学生个人空间操作,当前入口为教师报修入口", "我已知晓"), "messageTip").commitAllowingStateLoss();
            return;
        }
        boolean z = eventBean.isStudent;
        String str = eventBean.name;
        Intrinsics.checkNotNullExpressionValue(str, "eventBean.name");
        String str2 = eventBean.id;
        if (str2 == null) {
            str2 = "";
        }
        String str3 = eventBean.identityId;
        UserVerifyBean userVerifyBean = new UserVerifyBean(z, str, str2, str3 != null ? str3 : "");
        RepairActivity.Companion companion = RepairActivity.INSTANCE;
        Context contextRequireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext()");
        RepairActivity.Companion.start$default(companion, contextRequireContext, userVerifyBean, null, 4, null);
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        EventBus.getDefault().unregister(this);
    }
}
