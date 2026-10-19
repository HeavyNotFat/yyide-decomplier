package com.yd.android_brand_mvp.landscape.library.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.yd.android_brand_mvp.base.KTBaseFragment;
import com.yd.android_brand_mvp.databinding.FragmentLibraryHomeBinding;
import kotlin.Metadata;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: LibraryHomeFragment.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \r2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\rB\u0005¢\u0006\u0002\u0010\u0003J\u0006\u0010\u0006\u001a\u00020\u0007J\b\u0010\b\u001a\u00020\u0007H\u0002J\u0012\u0010\t\u001a\u00020\u00072\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0016J\u0010\u0010\f\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u0005H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lcom/yd/android_brand_mvp/landscape/library/fragment/LibraryHomeFragment;", "Lcom/yd/android_brand_mvp/base/KTBaseFragment;", "Lcom/yd/android_brand_mvp/databinding/FragmentLibraryHomeBinding;", "()V", FirebaseAnalytics.Param.INDEX, "", "clearFragment", "", "initView", "onActivityCreated", "savedInstanceState", "Landroid/os/Bundle;", "setFragment", "Companion", "app_commonRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class LibraryHomeFragment extends KTBaseFragment<FragmentLibraryHomeBinding> {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private int index;

    /* JADX INFO: renamed from: com.yd.android_brand_mvp.landscape.library.fragment.LibraryHomeFragment$1, reason: invalid class name */
    /* JADX INFO: compiled from: LibraryHomeFragment.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements Function3<LayoutInflater, ViewGroup, Boolean, FragmentLibraryHomeBinding> {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        AnonymousClass1() {
            super(3, FragmentLibraryHomeBinding.class, "inflate", "inflate(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Z)Lcom/yd/android_brand_mvp/databinding/FragmentLibraryHomeBinding;", 0);
        }

        public final FragmentLibraryHomeBinding invoke(LayoutInflater p0, ViewGroup viewGroup, boolean z) {
            Intrinsics.checkNotNullParameter(p0, "p0");
            return FragmentLibraryHomeBinding.inflate(p0, viewGroup, z);
        }

        @Override // kotlin.jvm.functions.Function3
        public /* bridge */ /* synthetic */ FragmentLibraryHomeBinding invoke(LayoutInflater layoutInflater, ViewGroup viewGroup, Boolean bool) {
            return invoke(layoutInflater, viewGroup, bool.booleanValue());
        }
    }

    public LibraryHomeFragment() {
        super(AnonymousClass1.INSTANCE);
    }

    /* JADX INFO: compiled from: LibraryHomeFragment.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\u0007"}, d2 = {"Lcom/yd/android_brand_mvp/landscape/library/fragment/LibraryHomeFragment$Companion;", "", "()V", "newInstance", "Lcom/yd/android_brand_mvp/landscape/library/fragment/LibraryHomeFragment;", FirebaseAnalytics.Param.INDEX, "", "app_commonRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final LibraryHomeFragment newInstance(int index) {
            LibraryHomeFragment libraryHomeFragment = new LibraryHomeFragment();
            Bundle bundle = new Bundle();
            bundle.putInt(FirebaseAnalytics.Param.INDEX, index);
            libraryHomeFragment.setArguments(bundle);
            return libraryHomeFragment;
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initView();
    }

    private final void initView() {
        getBinding().tvTab1.setOnClickListener(new View.OnClickListener() { // from class: com.yd.android_brand_mvp.landscape.library.fragment.-$$Lambda$LibraryHomeFragment$4F65mR8dPrpeRbtUs2KslRlSRuM
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                LibraryHomeFragment.initView$lambda$0(this.f$0, view);
            }
        });
        getBinding().tvTab2.setOnClickListener(new View.OnClickListener() { // from class: com.yd.android_brand_mvp.landscape.library.fragment.-$$Lambda$LibraryHomeFragment$Y_2nMCC9FTB9Y3J9n6L0d6Y80FE
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                LibraryHomeFragment.initView$lambda$1(this.f$0, view);
            }
        });
        getBinding().tvTab3.setOnClickListener(new View.OnClickListener() { // from class: com.yd.android_brand_mvp.landscape.library.fragment.-$$Lambda$LibraryHomeFragment$xDZCiwtfT8_AlK6y6e8ucargnnU
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                LibraryHomeFragment.initView$lambda$2(this.f$0, view);
            }
        });
        Bundle arguments = getArguments();
        if (arguments != null) {
            setFragment(arguments.getInt(FirebaseAnalytics.Param.INDEX));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$0(LibraryHomeFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.setFragment(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$1(LibraryHomeFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.setFragment(1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$2(LibraryHomeFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.setFragment(2);
    }

    public final void clearFragment() {
        setFragment(this.index);
    }

    private final void setFragment(int index) {
        getBinding().tvTab1.setChecked(index == 0);
        getBinding().tvTab2.setChecked(index == 1);
        getBinding().tvTab3.setChecked(index == 2);
        FragmentManager childFragmentManager = getChildFragmentManager();
        Intrinsics.checkNotNullExpressionValue(childFragmentManager, "childFragmentManager");
        FragmentTransaction fragmentTransactionBeginTransaction = childFragmentManager.beginTransaction();
        Intrinsics.checkNotNullExpressionValue(fragmentTransactionBeginTransaction, "fm.beginTransaction()");
        Fragment fragmentFindFragmentByTag = childFragmentManager.findFragmentByTag("1");
        Fragment fragmentFindFragmentByTag2 = childFragmentManager.findFragmentByTag("2");
        Fragment fragmentFindFragmentByTag3 = childFragmentManager.findFragmentByTag("3");
        if (fragmentFindFragmentByTag != null) {
            fragmentTransactionBeginTransaction.hide(fragmentFindFragmentByTag);
        }
        if (fragmentFindFragmentByTag2 != null) {
            fragmentTransactionBeginTransaction.hide(fragmentFindFragmentByTag2);
        }
        if (fragmentFindFragmentByTag3 != null) {
            fragmentTransactionBeginTransaction.hide(fragmentFindFragmentByTag3);
        }
        if (index != 0) {
            if (index != 1) {
                if (index == 2) {
                    if (fragmentFindFragmentByTag3 == null) {
                        fragmentTransactionBeginTransaction.add(getBinding().content.getId(), LibraryNewFragment.INSTANCE.newInstance(), "3");
                    } else {
                        fragmentTransactionBeginTransaction.show(fragmentFindFragmentByTag3);
                    }
                }
            } else if (fragmentFindFragmentByTag2 == null) {
                fragmentTransactionBeginTransaction.add(getBinding().content.getId(), LibraryHotFragment.INSTANCE.newInstance(), "2");
            } else {
                fragmentTransactionBeginTransaction.show(fragmentFindFragmentByTag2);
            }
        } else if (fragmentFindFragmentByTag == null) {
            fragmentTransactionBeginTransaction.add(getBinding().content.getId(), LibrarySearchFragment.INSTANCE.newInstance(), "1");
        } else {
            fragmentTransactionBeginTransaction.show(fragmentFindFragmentByTag);
        }
        fragmentTransactionBeginTransaction.commitAllowingStateLoss();
    }
}
