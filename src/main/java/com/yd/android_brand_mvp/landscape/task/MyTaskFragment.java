package com.yd.android_brand_mvp.landscape.task;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.FragmentActivity;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;
import com.yd.android_brand_mvp.adapter.task.MyTaskPager;
import com.yd.android_brand_mvp.base.KTBaseFragment;
import com.yd.android_brand_mvp.databinding.ActivityMyTaskBinding;
import com.yd.android_brand_mvp.landscape.exam.comments.CommentsHomeFragment;
import kotlin.Metadata;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: MyTaskFragment.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u00102\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0010B\u0005¢\u0006\u0002\u0010\u0003J\b\u0010\b\u001a\u00020\tH\u0002J\b\u0010\n\u001a\u00020\tH\u0016J\u001a\u0010\u000b\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0016R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lcom/yd/android_brand_mvp/landscape/task/MyTaskFragment;", "Lcom/yd/android_brand_mvp/base/KTBaseFragment;", "Lcom/yd/android_brand_mvp/databinding/ActivityMyTaskBinding;", "()V", "mLayoutMediator", "Lcom/google/android/material/tabs/TabLayoutMediator;", CommentsHomeFragment.TYPE_ID, "", "initView", "", "onDestroyView", "onViewCreated", "view", "Landroid/view/View;", "savedInstanceState", "Landroid/os/Bundle;", "Companion", "app_commonRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class MyTaskFragment extends KTBaseFragment<ActivityMyTaskBinding> {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final int PAGE_END = 2;
    public static final int PAGE_ING = 1;
    public static final int PAGE_NOT_START = 0;
    private TabLayoutMediator mLayoutMediator;
    private String studentId;

    /* JADX INFO: renamed from: com.yd.android_brand_mvp.landscape.task.MyTaskFragment$1, reason: invalid class name */
    /* JADX INFO: compiled from: MyTaskFragment.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements Function3<LayoutInflater, ViewGroup, Boolean, ActivityMyTaskBinding> {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        AnonymousClass1() {
            super(3, ActivityMyTaskBinding.class, "inflate", "inflate(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Z)Lcom/yd/android_brand_mvp/databinding/ActivityMyTaskBinding;", 0);
        }

        public final ActivityMyTaskBinding invoke(LayoutInflater p0, ViewGroup viewGroup, boolean z) {
            Intrinsics.checkNotNullParameter(p0, "p0");
            return ActivityMyTaskBinding.inflate(p0, viewGroup, z);
        }

        @Override // kotlin.jvm.functions.Function3
        public /* bridge */ /* synthetic */ ActivityMyTaskBinding invoke(LayoutInflater layoutInflater, ViewGroup viewGroup, Boolean bool) {
            return invoke(layoutInflater, viewGroup, bool.booleanValue());
        }
    }

    public MyTaskFragment() {
        super(AnonymousClass1.INSTANCE);
        this.studentId = "0";
    }

    /* JADX INFO: compiled from: MyTaskFragment.kt */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nR\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lcom/yd/android_brand_mvp/landscape/task/MyTaskFragment$Companion;", "", "()V", "PAGE_END", "", "PAGE_ING", "PAGE_NOT_START", "newInstance", "Lcom/yd/android_brand_mvp/landscape/task/MyTaskFragment;", "id", "", "app_commonRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final MyTaskFragment newInstance(String id) {
            Intrinsics.checkNotNullParameter(id, "id");
            MyTaskFragment myTaskFragment = new MyTaskFragment();
            Bundle bundle = new Bundle();
            bundle.putString("id", id);
            myTaskFragment.setArguments(bundle);
            return myTaskFragment;
        }
    }

    @Override // com.yd.android_brand_mvp.base.KTBaseFragment, com.yd.android_brand_mvp.base.BaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        initView();
    }

    private final void initView() {
        Bundle arguments = getArguments();
        String string = arguments != null ? arguments.getString("id") : null;
        if (string == null) {
            string = "0";
        }
        this.studentId = string;
        FragmentActivity fragmentActivityRequireActivity = requireActivity();
        Intrinsics.checkNotNullExpressionValue(fragmentActivityRequireActivity, "requireActivity()");
        getBinding().vpActivityMyTask.setAdapter(new MyTaskPager(fragmentActivityRequireActivity, this.studentId));
        TabLayoutMediator tabLayoutMediator = new TabLayoutMediator(getBinding().tlActivityMyTask, getBinding().vpActivityMyTask, true, false, new TabLayoutMediator.TabConfigurationStrategy() { // from class: com.yd.android_brand_mvp.landscape.task.-$$Lambda$MyTaskFragment$PeQoKqpCaht-QwrPy7TmZ695YIg
            @Override // com.google.android.material.tabs.TabLayoutMediator.TabConfigurationStrategy
            public final void onConfigureTab(TabLayout.Tab tab, int i) {
                MyTaskFragment.initView$lambda$0(tab, i);
            }
        });
        this.mLayoutMediator = tabLayoutMediator;
        if (tabLayoutMediator != null) {
            tabLayoutMediator.attach();
        }
        getBinding().vpActivityMyTask.post(new Runnable() { // from class: com.yd.android_brand_mvp.landscape.task.-$$Lambda$MyTaskFragment$1ZJMSkGZDxnUd6AMnxrryrasyeY
            @Override // java.lang.Runnable
            public final void run() {
                MyTaskFragment.initView$lambda$1(this.f$0);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$0(TabLayout.Tab tab, int i) {
        Intrinsics.checkNotNullParameter(tab, "tab");
        if (i == 0) {
            tab.setText("未开始");
        } else if (i == 1) {
            tab.setText("进行中");
        } else {
            if (i != 2) {
                return;
            }
            tab.setText("已结束");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$1(MyTaskFragment this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.getBinding().vpActivityMyTask.setCurrentItem(1, false);
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        TabLayoutMediator tabLayoutMediator = this.mLayoutMediator;
        if (tabLayoutMediator != null) {
            tabLayoutMediator.detach();
        }
    }
}
