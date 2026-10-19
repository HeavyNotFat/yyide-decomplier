package com.yd.android_brand_mvp.adapter.userspace;

import androidx.fragment.app.Fragment;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import com.yd.android_brand_mvp.landscape.exam.comments.CommentsHomeFragment;
import com.yd.android_brand_mvp.user.fragment.StudentApplyLeaveFragment;
import com.yd.android_brand_mvp.user.fragment.StudentLeaveRecordFragment;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: StudentLeaveAdapter.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0002\u0010\u0007J\u0010\u0010\u000b\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\rH\u0016J\b\u0010\u000e\u001a\u00020\rH\u0016R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\t¨\u0006\u000f"}, d2 = {"Lcom/yd/android_brand_mvp/adapter/userspace/StudentLeaveAdapter;", "Landroidx/viewpager2/adapter/FragmentStateAdapter;", "fragment", "Landroidx/fragment/app/Fragment;", CommentsHomeFragment.TYPE_ID, "", "studentName", "(Landroidx/fragment/app/Fragment;Ljava/lang/String;Ljava/lang/String;)V", "getStudentId", "()Ljava/lang/String;", "getStudentName", "createFragment", "position", "", "getItemCount", "app_commonRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class StudentLeaveAdapter extends FragmentStateAdapter {
    private final String studentId;
    private final String studentName;

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return 2;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StudentLeaveAdapter(Fragment fragment, String studentId, String studentName) {
        super(fragment);
        Intrinsics.checkNotNullParameter(fragment, "fragment");
        Intrinsics.checkNotNullParameter(studentId, "studentId");
        Intrinsics.checkNotNullParameter(studentName, "studentName");
        this.studentId = studentId;
        this.studentName = studentName;
    }

    public final String getStudentId() {
        return this.studentId;
    }

    public final String getStudentName() {
        return this.studentName;
    }

    @Override // androidx.viewpager2.adapter.FragmentStateAdapter
    public Fragment createFragment(int position) {
        if (position == 0) {
            return StudentApplyLeaveFragment.INSTANCE.newInstance(this.studentId, this.studentName);
        }
        return StudentLeaveRecordFragment.INSTANCE.newInstance(this.studentId, this.studentName);
    }
}
