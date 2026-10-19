package com.yd.android_brand_mvp.activity.exam.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import com.yd.android_brand_mvp.R;
import com.yd.android_brand_mvp.base.KTBaseFragment;
import com.yd.android_brand_mvp.databinding.FragmentExamDetailBinding;
import com.yd.android_brand_mvp.model.exam.ExamPlanItem;
import com.yd.android_brand_mvp.utils.SimpleUtilsKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ExamDetailFragment.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u000b2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u000bB\u0005¢\u0006\u0002\u0010\u0003J\u0006\u0010\u0004\u001a\u00020\u0005J\u001a\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0016¨\u0006\f"}, d2 = {"Lcom/yd/android_brand_mvp/activity/exam/fragment/ExamDetailFragment;", "Lcom/yd/android_brand_mvp/base/KTBaseFragment;", "Lcom/yd/android_brand_mvp/databinding/FragmentExamDetailBinding;", "()V", "initView", "", "onViewCreated", "view", "Landroid/view/View;", "savedInstanceState", "Landroid/os/Bundle;", "Companion", "app_commonRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class ExamDetailFragment extends KTBaseFragment<FragmentExamDetailBinding> {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* JADX INFO: renamed from: com.yd.android_brand_mvp.activity.exam.fragment.ExamDetailFragment$1, reason: invalid class name */
    /* JADX INFO: compiled from: ExamDetailFragment.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements Function3<LayoutInflater, ViewGroup, Boolean, FragmentExamDetailBinding> {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        AnonymousClass1() {
            super(3, FragmentExamDetailBinding.class, "inflate", "inflate(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Z)Lcom/yd/android_brand_mvp/databinding/FragmentExamDetailBinding;", 0);
        }

        public final FragmentExamDetailBinding invoke(LayoutInflater p0, ViewGroup viewGroup, boolean z) {
            Intrinsics.checkNotNullParameter(p0, "p0");
            return FragmentExamDetailBinding.inflate(p0, viewGroup, z);
        }

        @Override // kotlin.jvm.functions.Function3
        public /* bridge */ /* synthetic */ FragmentExamDetailBinding invoke(LayoutInflater layoutInflater, ViewGroup viewGroup, Boolean bool) {
            return invoke(layoutInflater, viewGroup, bool.booleanValue());
        }
    }

    public ExamDetailFragment() {
        super(AnonymousClass1.INSTANCE);
    }

    /* JADX INFO: compiled from: ExamDetailFragment.kt */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b¨\u0006\t"}, d2 = {"Lcom/yd/android_brand_mvp/activity/exam/fragment/ExamDetailFragment$Companion;", "", "()V", "newInstance", "Landroidx/fragment/app/Fragment;", "isPortrait", "", "data", "Lcom/yd/android_brand_mvp/model/exam/ExamPlanItem;", "app_commonRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public static /* synthetic */ Fragment newInstance$default(Companion companion, boolean z, ExamPlanItem examPlanItem, int i, Object obj) {
            if ((i & 1) != 0) {
                z = false;
            }
            return companion.newInstance(z, examPlanItem);
        }

        public final Fragment newInstance(boolean isPortrait, ExamPlanItem data) {
            Intrinsics.checkNotNullParameter(data, "data");
            ExamDetailFragment examDetailFragment = new ExamDetailFragment();
            Bundle bundle = new Bundle();
            bundle.putBoolean("isPortrait", isPortrait);
            bundle.putParcelable("data", data);
            examDetailFragment.setArguments(bundle);
            return examDetailFragment;
        }
    }

    @Override // com.yd.android_brand_mvp.base.KTBaseFragment, com.yd.android_brand_mvp.base.BaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        initView();
    }

    public final void initView() {
        Bundle arguments = getArguments();
        final ExamPlanItem examPlanItem = arguments != null ? (ExamPlanItem) arguments.getParcelable("data") : null;
        if (examPlanItem == null) {
            examPlanItem = new ExamPlanItem(null, null, 0, null, 0, null, 0, null, 0, null, false, false, null, 0, null, 0, null, null, null, null, 0, 0, 0, false, 16777215, null);
        }
        getChildFragmentManager().beginTransaction().replace(getBinding().vpFragmentDetail.getId(), ExamCourseDetailFragment.INSTANCE.newInstance(examPlanItem)).commit();
        getBinding().tvActivityVoteListIng.setOnClickListener(new View.OnClickListener() { // from class: com.yd.android_brand_mvp.activity.exam.fragment.-$$Lambda$ExamDetailFragment$Dl4YNHLPlHj-XDF-XbB8ultpkKk
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ExamDetailFragment.initView$lambda$0(this.f$0, examPlanItem, view);
            }
        });
        getBinding().tvActivityVoteListEnd.setOnClickListener(new View.OnClickListener() { // from class: com.yd.android_brand_mvp.activity.exam.fragment.-$$Lambda$ExamDetailFragment$z71204Y5jl1xU2wQjao-_qWtTak
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ExamDetailFragment.initView$lambda$1(this.f$0, examPlanItem, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$0(ExamDetailFragment this$0, ExamPlanItem dataBean, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(dataBean, "$dataBean");
        this$0.getBinding().tvActivityVoteListIng.setTextColor(SimpleUtilsKt.asColor(R.color.white));
        this$0.getBinding().tvActivityVoteListIng.setBackgroundResource(R.drawable.bg_purple23);
        this$0.getBinding().tvActivityVoteListEnd.setTextColor(SimpleUtilsKt.asColor(R.color.black16));
        this$0.getBinding().tvActivityVoteListEnd.setBackground(null);
        this$0.getChildFragmentManager().beginTransaction().replace(this$0.getBinding().vpFragmentDetail.getId(), ExamCourseDetailFragment.INSTANCE.newInstance(dataBean)).commit();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$1(ExamDetailFragment this$0, ExamPlanItem dataBean, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(dataBean, "$dataBean");
        this$0.getBinding().tvActivityVoteListEnd.setTextColor(SimpleUtilsKt.asColor(R.color.white));
        this$0.getBinding().tvActivityVoteListEnd.setBackgroundResource(R.drawable.bg_purple23);
        this$0.getBinding().tvActivityVoteListIng.setTextColor(SimpleUtilsKt.asColor(R.color.black16));
        this$0.getBinding().tvActivityVoteListIng.setBackground(null);
        this$0.getChildFragmentManager().beginTransaction().replace(this$0.getBinding().vpFragmentDetail.getId(), ExamSeatDetailFragment.INSTANCE.newInstance(dataBean)).commit();
    }
}
