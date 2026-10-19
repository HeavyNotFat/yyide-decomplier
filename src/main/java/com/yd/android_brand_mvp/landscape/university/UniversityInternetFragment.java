package com.yd.android_brand_mvp.landscape.university;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.yd.android_brand_mvp.activity.iotControl.DoorControlActivity;
import com.yd.android_brand_mvp.base.KTBaseFragment;
import com.yd.android_brand_mvp.databinding.FragmentUniverstyInternetBinding;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* JADX INFO: compiled from: UniversityInternetFragment.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u000b2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u000bB\u0005¢\u0006\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0002J\u001a\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0016¨\u0006\f"}, d2 = {"Lcom/yd/android_brand_mvp/landscape/university/UniversityInternetFragment;", "Lcom/yd/android_brand_mvp/base/KTBaseFragment;", "Lcom/yd/android_brand_mvp/databinding/FragmentUniverstyInternetBinding;", "()V", "initView", "", "onViewCreated", "view", "Landroid/view/View;", "savedInstanceState", "Landroid/os/Bundle;", "Companion", "app_commonRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class UniversityInternetFragment extends KTBaseFragment<FragmentUniverstyInternetBinding> {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final String LAYOUT_TAG = RemoteMessageConst.Notification.TAG;

    @JvmStatic
    public static final UniversityInternetFragment newInstance(String str, int i) {
        return INSTANCE.newInstance(str, i);
    }

    /* JADX INFO: renamed from: com.yd.android_brand_mvp.landscape.university.UniversityInternetFragment$1, reason: invalid class name */
    /* JADX INFO: compiled from: UniversityInternetFragment.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements Function3<LayoutInflater, ViewGroup, Boolean, FragmentUniverstyInternetBinding> {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        AnonymousClass1() {
            super(3, FragmentUniverstyInternetBinding.class, "inflate", "inflate(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Z)Lcom/yd/android_brand_mvp/databinding/FragmentUniverstyInternetBinding;", 0);
        }

        public final FragmentUniverstyInternetBinding invoke(LayoutInflater p0, ViewGroup viewGroup, boolean z) {
            Intrinsics.checkNotNullParameter(p0, "p0");
            return FragmentUniverstyInternetBinding.inflate(p0, viewGroup, z);
        }

        @Override // kotlin.jvm.functions.Function3
        public /* bridge */ /* synthetic */ FragmentUniverstyInternetBinding invoke(LayoutInflater layoutInflater, ViewGroup viewGroup, Boolean bool) {
            return invoke(layoutInflater, viewGroup, bool.booleanValue());
        }
    }

    public UniversityInternetFragment() {
        super(AnonymousClass1.INSTANCE);
    }

    /* JADX INFO: compiled from: UniversityInternetFragment.kt */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001a\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u00042\b\b\u0002\u0010\n\u001a\u00020\u000bH\u0007R\u0014\u0010\u0003\u001a\u00020\u0004X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\f"}, d2 = {"Lcom/yd/android_brand_mvp/landscape/university/UniversityInternetFragment$Companion;", "", "()V", "LAYOUT_TAG", "", "getLAYOUT_TAG", "()Ljava/lang/String;", "newInstance", "Lcom/yd/android_brand_mvp/landscape/university/UniversityInternetFragment;", "layoutTag", "time", "", "app_commonRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final String getLAYOUT_TAG() {
            return UniversityInternetFragment.LAYOUT_TAG;
        }

        public static /* synthetic */ UniversityInternetFragment newInstance$default(Companion companion, String str, int i, int i2, Object obj) {
            if ((i2 & 2) != 0) {
                i = 60;
            }
            return companion.newInstance(str, i);
        }

        @JvmStatic
        public final UniversityInternetFragment newInstance(String layoutTag, int time) {
            Intrinsics.checkNotNullParameter(layoutTag, "layoutTag");
            UniversityInternetFragment universityInternetFragment = new UniversityInternetFragment();
            Bundle bundle = new Bundle();
            bundle.putString(UniversityInternetFragment.INSTANCE.getLAYOUT_TAG(), layoutTag);
            bundle.putInt("time", time);
            universityInternetFragment.setArguments(bundle);
            return universityInternetFragment;
        }
    }

    /* JADX WARN: Code duplicated, block: B:15:0x0059  */
    @Override // com.yd.android_brand_mvp.base.KTBaseFragment, com.yd.android_brand_mvp.base.BaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        getBinding().cl25.setVisibility(8);
        getBinding().constraintLayout3.setVisibility(8);
        Bundle arguments = getArguments();
        if (Intrinsics.areEqual(arguments != null ? arguments.getString(LAYOUT_TAG) : null, "hbwl_machine_52")) {
            getBinding().cl25.setVisibility(0);
        } else {
            Bundle arguments2 = getArguments();
            if (Intrinsics.areEqual(arguments2 != null ? arguments2.getString(LAYOUT_TAG) : null, "hbwl52")) {
                getBinding().cl25.setVisibility(0);
            } else {
                getBinding().constraintLayout3.setVisibility(0);
            }
        }
        initView();
    }

    private final void initView() {
        final Ref.IntRef intRef = new Ref.IntRef();
        intRef.element = 60;
        if (getArguments() != null) {
            intRef.element = requireArguments().getInt("time", 60);
            if (intRef.element < 1) {
                intRef.element = 60;
            }
        }
        getBinding().ivMsg.setOnClickListener(new View.OnClickListener() { // from class: com.yd.android_brand_mvp.landscape.university.-$$Lambda$UniversityInternetFragment$RrGzwImu2cNvrIw7eOm3_hHc_J4
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                UniversityInternetFragment.initView$lambda$1(this.f$0, intRef, view);
            }
        });
        getBinding().ivMsg0.setOnClickListener(new View.OnClickListener() { // from class: com.yd.android_brand_mvp.landscape.university.-$$Lambda$UniversityInternetFragment$zqBtZz-lZKIC3NGWWB4jVj92MPE
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                UniversityInternetFragment.initView$lambda$2(this.f$0, intRef, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$1(UniversityInternetFragment this$0, Ref.IntRef exitTime, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(exitTime, "$exitTime");
        DoorControlActivity.Companion companion = DoorControlActivity.INSTANCE;
        Context contextRequireContext = this$0.requireContext();
        Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext()");
        companion.startGo(contextRequireContext, exitTime.element);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$2(UniversityInternetFragment this$0, Ref.IntRef exitTime, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(exitTime, "$exitTime");
        DoorControlActivity.Companion companion = DoorControlActivity.INSTANCE;
        Context contextRequireContext = this$0.requireContext();
        Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext()");
        companion.startGo(contextRequireContext, exitTime.element);
    }
}
