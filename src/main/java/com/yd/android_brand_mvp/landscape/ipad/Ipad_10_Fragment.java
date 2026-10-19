package com.yd.android_brand_mvp.landscape.ipad;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.ViewModelProvider;
import com.yd.android_brand_mvp.base.KTBaseFragment;
import com.yd.android_brand_mvp.databinding.FragmentIpad10Binding;
import com.yd.android_brand_mvp.landscape.reserve.HomeReservation36Fragment;
import com.yd.android_brand_mvp.landscape.university.UniversityInternetFragment;
import com.yd.android_brand_mvp.landscape.university.UniversityReservationFragment;
import kotlin.Metadata;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: Ipad_10_Fragment.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u000e2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u000eB\u0005¢\u0006\u0002\u0010\u0003J\b\u0010\u0006\u001a\u00020\u0007H\u0002J\u0012\u0010\b\u001a\u00020\u00072\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0016J\u001a\u0010\u000b\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\r2\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082.¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/yd/android_brand_mvp/landscape/ipad/Ipad_10_Fragment;", "Lcom/yd/android_brand_mvp/base/KTBaseFragment;", "Lcom/yd/android_brand_mvp/databinding/FragmentIpad10Binding;", "()V", "viewModel", "Lcom/yd/android_brand_mvp/landscape/ipad/Ipad10ViewModel;", "initView", "", "onActivityCreated", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "view", "Landroid/view/View;", "Companion", "app_commonRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class Ipad_10_Fragment extends KTBaseFragment<FragmentIpad10Binding> {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private Ipad10ViewModel viewModel;

    /* JADX INFO: renamed from: com.yd.android_brand_mvp.landscape.ipad.Ipad_10_Fragment$1, reason: invalid class name */
    /* JADX INFO: compiled from: Ipad_10_Fragment.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements Function3<LayoutInflater, ViewGroup, Boolean, FragmentIpad10Binding> {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        AnonymousClass1() {
            super(3, FragmentIpad10Binding.class, "inflate", "inflate(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Z)Lcom/yd/android_brand_mvp/databinding/FragmentIpad10Binding;", 0);
        }

        public final FragmentIpad10Binding invoke(LayoutInflater p0, ViewGroup viewGroup, boolean z) {
            Intrinsics.checkNotNullParameter(p0, "p0");
            return FragmentIpad10Binding.inflate(p0, viewGroup, z);
        }

        @Override // kotlin.jvm.functions.Function3
        public /* bridge */ /* synthetic */ FragmentIpad10Binding invoke(LayoutInflater layoutInflater, ViewGroup viewGroup, Boolean bool) {
            return invoke(layoutInflater, viewGroup, bool.booleanValue());
        }
    }

    public Ipad_10_Fragment() {
        super(AnonymousClass1.INSTANCE);
    }

    /* JADX INFO: compiled from: Ipad_10_Fragment.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0003\u001a\u00020\u0004¨\u0006\u0005"}, d2 = {"Lcom/yd/android_brand_mvp/landscape/ipad/Ipad_10_Fragment$Companion;", "", "()V", "newInstance", "Lcom/yd/android_brand_mvp/landscape/ipad/Ipad_10_Fragment;", "app_commonRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final Ipad_10_Fragment newInstance() {
            return new Ipad_10_Fragment();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        this.viewModel = (Ipad10ViewModel) new ViewModelProvider(this).get(Ipad10ViewModel.class);
        initView();
    }

    @Override // com.yd.android_brand_mvp.base.KTBaseFragment, com.yd.android_brand_mvp.base.BaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        initView();
    }

    private final void initView() {
        FragmentTransaction fragmentTransactionBeginTransaction = getChildFragmentManager().beginTransaction();
        Intrinsics.checkNotNullExpressionValue(fragmentTransactionBeginTransaction, "childFragmentManager.beginTransaction()");
        fragmentTransactionBeginTransaction.replace(getBinding().constraintLayout.getId(), UniversityReservationFragment.INSTANCE.newInstance("hbreservation_machine_54"));
        fragmentTransactionBeginTransaction.replace(getBinding().constraintLayout2.getId(), HomeReservation36Fragment.INSTANCE.newInstance());
        fragmentTransactionBeginTransaction.replace(getBinding().constraintLayout3.getId(), UniversityInternetFragment.Companion.newInstance$default(UniversityInternetFragment.INSTANCE, "hbwl_machine_52", 0, 2, null));
        fragmentTransactionBeginTransaction.commit();
    }
}
