package com.yd.android_brand_mvp.landscape.patrol;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.blankj.utilcode.util.SizeUtils;
import com.yd.android_brand_mvp.R;
import com.yd.android_brand_mvp.base.KTBaseFragment;
import com.yd.android_brand_mvp.databinding.FragmentHomePatrolBinding;
import com.yd.android_brand_mvp.dialog.patrol.PatrolVerifyDialog;
import com.yd.android_brand_mvp.utils.GlideUtil;
import kotlin.Metadata;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;

/* JADX INFO: compiled from: HomePatrolFragment.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \r2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\rB\u0005¢\u0006\u0002\u0010\u0003J\b\u0010\u0006\u001a\u00020\u0007H\u0002J\u001a\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lcom/yd/android_brand_mvp/landscape/patrol/HomePatrolFragment;", "Lcom/yd/android_brand_mvp/base/KTBaseFragment;", "Lcom/yd/android_brand_mvp/databinding/FragmentHomePatrolBinding;", "()V", "type", "", "initView", "", "onViewCreated", "view", "Landroid/view/View;", "savedInstanceState", "Landroid/os/Bundle;", "Companion", "app_commonRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class HomePatrolFragment extends KTBaseFragment<FragmentHomePatrolBinding> {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private String type;

    /* JADX INFO: renamed from: com.yd.android_brand_mvp.landscape.patrol.HomePatrolFragment$1, reason: invalid class name */
    /* JADX INFO: compiled from: HomePatrolFragment.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements Function3<LayoutInflater, ViewGroup, Boolean, FragmentHomePatrolBinding> {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        AnonymousClass1() {
            super(3, FragmentHomePatrolBinding.class, "inflate", "inflate(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Z)Lcom/yd/android_brand_mvp/databinding/FragmentHomePatrolBinding;", 0);
        }

        public final FragmentHomePatrolBinding invoke(LayoutInflater p0, ViewGroup viewGroup, boolean z) {
            Intrinsics.checkNotNullParameter(p0, "p0");
            return FragmentHomePatrolBinding.inflate(p0, viewGroup, z);
        }

        @Override // kotlin.jvm.functions.Function3
        public /* bridge */ /* synthetic */ FragmentHomePatrolBinding invoke(LayoutInflater layoutInflater, ViewGroup viewGroup, Boolean bool) {
            return invoke(layoutInflater, viewGroup, bool.booleanValue());
        }
    }

    public HomePatrolFragment() {
        super(AnonymousClass1.INSTANCE);
        this.type = "";
    }

    /* JADX INFO: compiled from: HomePatrolFragment.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\u0007"}, d2 = {"Lcom/yd/android_brand_mvp/landscape/patrol/HomePatrolFragment$Companion;", "", "()V", "newInstance", "Lcom/yd/android_brand_mvp/landscape/patrol/HomePatrolFragment;", "type", "", "app_commonRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final HomePatrolFragment newInstance(String type) {
            Intrinsics.checkNotNullParameter(type, "type");
            Bundle bundle = new Bundle();
            bundle.putString("type", type);
            HomePatrolFragment homePatrolFragment = new HomePatrolFragment();
            homePatrolFragment.setArguments(bundle);
            return homePatrolFragment;
        }
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    @Override // com.yd.android_brand_mvp.base.KTBaseFragment, com.yd.android_brand_mvp.base.BaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        Bundle arguments = getArguments();
        String string = arguments != null ? arguments.getString("type") : null;
        if (string == null) {
            string = "hbcdxk22";
        }
        this.type = string;
        switch (string.hashCode()) {
            case -1728909469:
                if (string.equals("sbcdxk22")) {
                    getBinding().clFragmentHomePatrol.getLayoutParams().width = SizeUtils.dp2px(320.0f);
                    getBinding().clFragmentHomePatrol.getLayoutParams().height = SizeUtils.dp2px(424.0f);
                    GlideUtil.loadImage(requireContext(), R.drawable.home_patrol_xunke_p, getBinding().ivFragmentHomePatrol);
                }
                break;
            case -1728908508:
                if (string.equals("sbcdxl22")) {
                    getBinding().clFragmentHomePatrol.getLayoutParams().width = SizeUtils.dp2px(320.0f);
                    getBinding().clFragmentHomePatrol.getLayoutParams().height = SizeUtils.dp2px(424.0f);
                    GlideUtil.loadImage(requireContext(), R.drawable.home_patrol_xunluo_p, getBinding().ivFragmentHomePatrol);
                }
                break;
            case 575013326:
                if (string.equals("hbcdxk22")) {
                    getBinding().clFragmentHomePatrol.getLayoutParams().width = SizeUtils.dp2px(444.0f);
                    getBinding().clFragmentHomePatrol.getLayoutParams().height = SizeUtils.dp2px(292.0f);
                    GlideUtil.loadImage(requireContext(), R.drawable.home_patrol_xunke, getBinding().ivFragmentHomePatrol);
                }
                break;
            case 575014287:
                if (string.equals("hbcdxl22")) {
                    getBinding().clFragmentHomePatrol.getLayoutParams().width = SizeUtils.dp2px(444.0f);
                    getBinding().clFragmentHomePatrol.getLayoutParams().height = SizeUtils.dp2px(292.0f);
                    GlideUtil.loadImage(requireContext(), R.drawable.home_patrol_xunluo, getBinding().ivFragmentHomePatrol);
                }
                break;
        }
        initView();
    }

    private final void initView() {
        getBinding().ivFragmentHomePatrol.setOnClickListener(new View.OnClickListener() { // from class: com.yd.android_brand_mvp.landscape.patrol.-$$Lambda$HomePatrolFragment$VYzKEeWGMlY2UgCEDVaj2ntRsLU
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                HomePatrolFragment.initView$lambda$0(this.f$0, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$0(HomePatrolFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        new PatrolVerifyDialog(new Regex("xk").containsMatchIn(this$0.type) ? 2 : 1).show(this$0.getChildFragmentManager(), "patrolVerify");
    }
}
