package com.yd.android_brand_mvp.user.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;
import com.yd.android_brand_mvp.adapter.userspace.StudentLeaveAdapter;
import com.yd.android_brand_mvp.base.KTBaseFragment;
import com.yd.android_brand_mvp.databinding.ActivityMyTaskBinding;
import com.yd.android_brand_mvp.landscape.exam.comments.CommentsHomeFragment;
import com.yd.android_brand_mvp.model.EventBean;
import kotlin.Metadata;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

/* JADX INFO: compiled from: StudentLeaveFragment.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u00142\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0014B\u0005¢\u0006\u0002\u0010\u0003J\b\u0010\t\u001a\u00020\nH\u0002J\b\u0010\u000b\u001a\u00020\nH\u0016J\u001a\u0010\f\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0016J\u0010\u0010\u0011\u001a\u00020\n2\u0006\u0010\u0012\u001a\u00020\u0013H\u0007R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Lcom/yd/android_brand_mvp/user/fragment/StudentLeaveFragment;", "Lcom/yd/android_brand_mvp/base/KTBaseFragment;", "Lcom/yd/android_brand_mvp/databinding/ActivityMyTaskBinding;", "()V", "mLayoutMediator", "Lcom/google/android/material/tabs/TabLayoutMediator;", CommentsHomeFragment.TYPE_ID, "", "studentName", "initView", "", "onDestroyView", "onViewCreated", "view", "Landroid/view/View;", "savedInstanceState", "Landroid/os/Bundle;", "parseEventBean", "data", "Lcom/yd/android_brand_mvp/model/EventBean;", "Companion", "app_commonRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class StudentLeaveFragment extends KTBaseFragment<ActivityMyTaskBinding> {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final int PAGE_APPLY_LEAVE = 0;
    public static final int PAGE_LEAVE_RECORD = 1;
    private TabLayoutMediator mLayoutMediator;
    private String studentId;
    private String studentName;

    /* JADX INFO: renamed from: com.yd.android_brand_mvp.user.fragment.StudentLeaveFragment$1, reason: invalid class name */
    /* JADX INFO: compiled from: StudentLeaveFragment.kt */
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

    public StudentLeaveFragment() {
        super(AnonymousClass1.INSTANCE);
        this.studentId = "-1";
        this.studentName = "";
    }

    /* JADX INFO: compiled from: StudentLeaveFragment.kt */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\tR\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lcom/yd/android_brand_mvp/user/fragment/StudentLeaveFragment$Companion;", "", "()V", "PAGE_APPLY_LEAVE", "", "PAGE_LEAVE_RECORD", "newInstance", "Lcom/yd/android_brand_mvp/user/fragment/StudentLeaveFragment;", "id", "", "studentName", "app_commonRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final StudentLeaveFragment newInstance(String id, String studentName) {
            Intrinsics.checkNotNullParameter(id, "id");
            Intrinsics.checkNotNullParameter(studentName, "studentName");
            StudentLeaveFragment studentLeaveFragment = new StudentLeaveFragment();
            Bundle bundle = new Bundle();
            bundle.putString("id", id);
            bundle.putString(AppMeasurementSdk.ConditionalUserProperty.NAME, studentName);
            studentLeaveFragment.setArguments(bundle);
            return studentLeaveFragment;
        }
    }

    @Override // com.yd.android_brand_mvp.base.KTBaseFragment, com.yd.android_brand_mvp.base.BaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        EventBus.getDefault().register(this);
        initView();
    }

    private final void initView() {
        Bundle arguments = getArguments();
        String string = arguments != null ? arguments.getString("id") : null;
        if (string == null) {
            string = "-1";
        }
        this.studentId = string;
        Bundle arguments2 = getArguments();
        String string2 = arguments2 != null ? arguments2.getString(AppMeasurementSdk.ConditionalUserProperty.NAME) : null;
        if (string2 == null) {
            string2 = "";
        }
        this.studentName = string2;
        getBinding().vpActivityMyTask.setAdapter(new StudentLeaveAdapter(this, this.studentId, string2));
        TabLayoutMediator tabLayoutMediator = new TabLayoutMediator(getBinding().tlActivityMyTask, getBinding().vpActivityMyTask, true, false, new TabLayoutMediator.TabConfigurationStrategy() { // from class: com.yd.android_brand_mvp.user.fragment.-$$Lambda$StudentLeaveFragment$MyfBltVgX2_EFRss8KZ9_lQsbcg
            @Override // com.google.android.material.tabs.TabLayoutMediator.TabConfigurationStrategy
            public final void onConfigureTab(TabLayout.Tab tab, int i) {
                StudentLeaveFragment.initView$lambda$0(tab, i);
            }
        });
        this.mLayoutMediator = tabLayoutMediator;
        if (tabLayoutMediator != null) {
            tabLayoutMediator.attach();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$0(TabLayout.Tab tab, int i) {
        Intrinsics.checkNotNullParameter(tab, "tab");
        if (i == 0) {
            tab.setText("我要请假");
        } else {
            if (i != 1) {
                return;
            }
            tab.setText("请假记录");
        }
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public final void parseEventBean(EventBean data) {
        Intrinsics.checkNotNullParameter(data, "data");
        if (data.Event == 10002) {
            getBinding().vpActivityMyTask.setCurrentItem(1, true);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        EventBus.getDefault().unregister(this);
        TabLayoutMediator tabLayoutMediator = this.mLayoutMediator;
        if (tabLayoutMediator != null) {
            tabLayoutMediator.detach();
        }
    }
}
