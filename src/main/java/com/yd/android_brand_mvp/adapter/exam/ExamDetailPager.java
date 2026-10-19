package com.yd.android_brand_mvp.adapter.exam;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import com.yd.android_brand_mvp.activity.exam.fragment.ExamCourseDetailFragment;
import com.yd.android_brand_mvp.activity.exam.fragment.ExamSeatDetailFragment;
import com.yd.android_brand_mvp.model.exam.ExamPlanItem;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ExamDetailPager.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0010\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J\b\u0010\u0010\u001a\u00020\u000fH\u0016R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u000b¨\u0006\u0011"}, d2 = {"Lcom/yd/android_brand_mvp/adapter/exam/ExamDetailPager;", "Landroidx/viewpager2/adapter/FragmentStateAdapter;", "fragmentActivity", "Landroidx/fragment/app/FragmentActivity;", "data", "Lcom/yd/android_brand_mvp/model/exam/ExamPlanItem;", "isPortrait", "", "(Landroidx/fragment/app/FragmentActivity;Lcom/yd/android_brand_mvp/model/exam/ExamPlanItem;Z)V", "getData", "()Lcom/yd/android_brand_mvp/model/exam/ExamPlanItem;", "()Z", "createFragment", "Landroidx/fragment/app/Fragment;", "position", "", "getItemCount", "app_commonRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class ExamDetailPager extends FragmentStateAdapter {
    private final ExamPlanItem data;
    private final boolean isPortrait;

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return 2;
    }

    public /* synthetic */ ExamDetailPager(FragmentActivity fragmentActivity, ExamPlanItem examPlanItem, boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(fragmentActivity, examPlanItem, (i & 4) != 0 ? false : z);
    }

    public final ExamPlanItem getData() {
        return this.data;
    }

    /* JADX INFO: renamed from: isPortrait, reason: from getter */
    public final boolean getIsPortrait() {
        return this.isPortrait;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ExamDetailPager(FragmentActivity fragmentActivity, ExamPlanItem data, boolean z) {
        super(fragmentActivity);
        Intrinsics.checkNotNullParameter(fragmentActivity, "fragmentActivity");
        Intrinsics.checkNotNullParameter(data, "data");
        this.data = data;
        this.isPortrait = z;
    }

    @Override // androidx.viewpager2.adapter.FragmentStateAdapter
    public Fragment createFragment(int position) {
        if (position == 0) {
            return ExamCourseDetailFragment.INSTANCE.newInstance(this.data);
        }
        if (position == 1) {
            return ExamSeatDetailFragment.INSTANCE.newInstance(this.data);
        }
        return ExamCourseDetailFragment.INSTANCE.newInstance(this.data);
    }
}
