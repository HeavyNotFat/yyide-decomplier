package com.yd.android_brand_mvp.landscape;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.yd.android_brand_mvp.base.KTBaseFragment;
import com.yd.android_brand_mvp.databinding.FragmentPunchBinding;
import com.yd.android_brand_mvp.utils.SpData;
import com.yd.android_brand_mvp.verfity.AllCheckActivity;
import com.yd.android_brand_mvp.verfity.CheckEnum;
import kotlin.Metadata;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: PunchThirdFragment.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u000b2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u000bB\u0005¢\u0006\u0002\u0010\u0003J\u0006\u0010\u0004\u001a\u00020\u0005J\u001a\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0016¨\u0006\f"}, d2 = {"Lcom/yd/android_brand_mvp/landscape/PunchThirdFragment;", "Lcom/yd/android_brand_mvp/base/KTBaseFragment;", "Lcom/yd/android_brand_mvp/databinding/FragmentPunchBinding;", "()V", "initView", "", "onViewCreated", "view", "Landroid/view/View;", "savedInstanceState", "Landroid/os/Bundle;", "Companion", "app_commonRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class PunchThirdFragment extends KTBaseFragment<FragmentPunchBinding> {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* JADX INFO: renamed from: com.yd.android_brand_mvp.landscape.PunchThirdFragment$1, reason: invalid class name */
    /* JADX INFO: compiled from: PunchThirdFragment.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements Function3<LayoutInflater, ViewGroup, Boolean, FragmentPunchBinding> {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        AnonymousClass1() {
            super(3, FragmentPunchBinding.class, "inflate", "inflate(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Z)Lcom/yd/android_brand_mvp/databinding/FragmentPunchBinding;", 0);
        }

        public final FragmentPunchBinding invoke(LayoutInflater p0, ViewGroup viewGroup, boolean z) {
            Intrinsics.checkNotNullParameter(p0, "p0");
            return FragmentPunchBinding.inflate(p0, viewGroup, z);
        }

        @Override // kotlin.jvm.functions.Function3
        public /* bridge */ /* synthetic */ FragmentPunchBinding invoke(LayoutInflater layoutInflater, ViewGroup viewGroup, Boolean bool) {
            return invoke(layoutInflater, viewGroup, bool.booleanValue());
        }
    }

    public PunchThirdFragment() {
        super(AnonymousClass1.INSTANCE);
    }

    /* JADX INFO: compiled from: PunchThirdFragment.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0003\u001a\u00020\u0004¨\u0006\u0005"}, d2 = {"Lcom/yd/android_brand_mvp/landscape/PunchThirdFragment$Companion;", "", "()V", "newInstance", "Lcom/yd/android_brand_mvp/landscape/PunchThirdFragment;", "app_commonRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final PunchThirdFragment newInstance() {
            return new PunchThirdFragment();
        }
    }

    @Override // com.yd.android_brand_mvp.base.KTBaseFragment, com.yd.android_brand_mvp.base.BaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        initView();
    }

    public final void initView() {
        getBinding().top.title.setText("打卡签到");
        getBinding().tvSiteName.setText(SpData.getSiteName());
        getBinding().btnSign.setOnClickListener(new View.OnClickListener() { // from class: com.yd.android_brand_mvp.landscape.-$$Lambda$PunchThirdFragment$L-secHiPICu9q1L4rRp-SFcyvBc
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                PunchThirdFragment.initView$lambda$0(this.f$0, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$0(PunchThirdFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        AllCheckActivity.Companion companion = AllCheckActivity.INSTANCE;
        Context contextRequireContext = this$0.requireContext();
        Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext()");
        companion.startGo(contextRequireContext, CheckEnum.THIRD_PARTY.getTodoType());
    }
}
