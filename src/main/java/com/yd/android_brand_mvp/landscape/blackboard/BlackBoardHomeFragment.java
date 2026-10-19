package com.yd.android_brand_mvp.landscape.blackboard;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentPagerAdapter;
import com.yd.android_brand_mvp.base.KTBaseFragment;
import com.yd.android_brand_mvp.databinding.FragmentBlackBoardHomeBinding;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: BlackBoardHomeFragment.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \r2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\rB\u0005¢\u0006\u0002\u0010\u0003J\b\u0010\b\u001a\u00020\tH\u0002J\u0012\u0010\n\u001a\u00020\t2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0016R\u001e\u0010\u0004\u001a\u0012\u0012\u0004\u0012\u00020\u00060\u0005j\b\u0012\u0004\u0012\u00020\u0006`\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lcom/yd/android_brand_mvp/landscape/blackboard/BlackBoardHomeFragment;", "Lcom/yd/android_brand_mvp/base/KTBaseFragment;", "Lcom/yd/android_brand_mvp/databinding/FragmentBlackBoardHomeBinding;", "()V", "fragments", "Ljava/util/ArrayList;", "Landroidx/fragment/app/Fragment;", "Lkotlin/collections/ArrayList;", "initView", "", "onActivityCreated", "savedInstanceState", "Landroid/os/Bundle;", "Companion", "app_commonRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class BlackBoardHomeFragment extends KTBaseFragment<FragmentBlackBoardHomeBinding> {
    private final ArrayList<Fragment> fragments;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final String BEAN = "bean";

    /* JADX INFO: renamed from: com.yd.android_brand_mvp.landscape.blackboard.BlackBoardHomeFragment$1, reason: invalid class name */
    /* JADX INFO: compiled from: BlackBoardHomeFragment.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements Function3<LayoutInflater, ViewGroup, Boolean, FragmentBlackBoardHomeBinding> {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        AnonymousClass1() {
            super(3, FragmentBlackBoardHomeBinding.class, "inflate", "inflate(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Z)Lcom/yd/android_brand_mvp/databinding/FragmentBlackBoardHomeBinding;", 0);
        }

        public final FragmentBlackBoardHomeBinding invoke(LayoutInflater p0, ViewGroup viewGroup, boolean z) {
            Intrinsics.checkNotNullParameter(p0, "p0");
            return FragmentBlackBoardHomeBinding.inflate(p0, viewGroup, z);
        }

        @Override // kotlin.jvm.functions.Function3
        public /* bridge */ /* synthetic */ FragmentBlackBoardHomeBinding invoke(LayoutInflater layoutInflater, ViewGroup viewGroup, Boolean bool) {
            return invoke(layoutInflater, viewGroup, bool.booleanValue());
        }
    }

    public BlackBoardHomeFragment() {
        super(AnonymousClass1.INSTANCE);
        this.fragments = new ArrayList<>();
    }

    /* JADX INFO: compiled from: BlackBoardHomeFragment.kt */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\u0004R\u0014\u0010\u0003\u001a\u00020\u0004X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\n"}, d2 = {"Lcom/yd/android_brand_mvp/landscape/blackboard/BlackBoardHomeFragment$Companion;", "", "()V", "BEAN", "", "getBEAN", "()Ljava/lang/String;", "newInstance", "Lcom/yd/android_brand_mvp/landscape/blackboard/BlackBoardHomeFragment;", "bean", "app_commonRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final String getBEAN() {
            return BlackBoardHomeFragment.BEAN;
        }

        public final BlackBoardHomeFragment newInstance(String bean) {
            BlackBoardHomeFragment blackBoardHomeFragment = new BlackBoardHomeFragment();
            Bundle bundle = new Bundle();
            bundle.putString(BlackBoardHomeFragment.INSTANCE.getBEAN(), bean);
            blackBoardHomeFragment.setArguments(bundle);
            return blackBoardHomeFragment;
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initView();
    }

    private final void initView() {
        ArrayList<Fragment> arrayList = this.fragments;
        BlackBoardTodayFragment.Companion companion = BlackBoardTodayFragment.INSTANCE;
        Bundle arguments = getArguments();
        arrayList.add(companion.newInstance(arguments != null ? arguments.getString(BEAN) : null));
        ArrayList<Fragment> arrayList2 = this.fragments;
        BlackBoardHistoryFragment.Companion companion2 = BlackBoardHistoryFragment.INSTANCE;
        Bundle arguments2 = getArguments();
        arrayList2.add(companion2.newInstance(arguments2 != null ? arguments2.getString(BEAN) : null));
        getBinding().tablayout.addTab(getBinding().tablayout.newTab().setText("今日截图"));
        getBinding().tablayout.addTab(getBinding().tablayout.newTab().setText("历史截图"));
        getBinding().viewPager.setAdapter(new FragmentPagerAdapter(getChildFragmentManager()) { // from class: com.yd.android_brand_mvp.landscape.blackboard.BlackBoardHomeFragment.initView.1
            @Override // androidx.viewpager.widget.PagerAdapter
            public int getCount() {
                return BlackBoardHomeFragment.this.fragments.size();
            }

            @Override // androidx.fragment.app.FragmentPagerAdapter
            public Fragment getItem(int position) {
                Object obj = BlackBoardHomeFragment.this.fragments.get(position);
                Intrinsics.checkNotNullExpressionValue(obj, "fragments[position]");
                return (Fragment) obj;
            }

            @Override // androidx.viewpager.widget.PagerAdapter
            public CharSequence getPageTitle(int position) {
                return position == 0 ? "今日截图" : "历史截图";
            }
        });
        getBinding().tablayout.setupWithViewPager(getBinding().viewPager, false);
    }
}
