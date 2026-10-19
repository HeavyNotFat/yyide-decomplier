package com.yd.android_brand_mvp.adapter.task;

import android.util.SparseArray;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import com.yd.android_brand_mvp.landscape.exam.comments.CommentsHomeFragment;
import com.yd.android_brand_mvp.landscape.task.EndTaskFragment;
import com.yd.android_brand_mvp.landscape.task.IngTaskFragment;
import com.yd.android_brand_mvp.landscape.task.NotStartTaskFragment;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: MyTaskPager.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0010\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\fH\u0016J\b\u0010\r\u001a\u00020\fH\u0016R\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lcom/yd/android_brand_mvp/adapter/task/MyTaskPager;", "Landroidx/viewpager2/adapter/FragmentStateAdapter;", "fragmentActivity", "Landroidx/fragment/app/FragmentActivity;", CommentsHomeFragment.TYPE_ID, "", "(Landroidx/fragment/app/FragmentActivity;Ljava/lang/String;)V", "fragments", "Landroid/util/SparseArray;", "Landroidx/fragment/app/Fragment;", "createFragment", "position", "", "getItemCount", "app_commonRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class MyTaskPager extends FragmentStateAdapter {
    private final SparseArray<Fragment> fragments;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MyTaskPager(FragmentActivity fragmentActivity, String studentId) {
        super(fragmentActivity);
        Intrinsics.checkNotNullParameter(fragmentActivity, "fragmentActivity");
        Intrinsics.checkNotNullParameter(studentId, "studentId");
        SparseArray<Fragment> sparseArray = new SparseArray<>();
        this.fragments = sparseArray;
        sparseArray.put(0, NotStartTaskFragment.INSTANCE.newInstance(studentId));
        this.fragments.put(1, IngTaskFragment.INSTANCE.newInstance(studentId));
        this.fragments.put(2, EndTaskFragment.INSTANCE.newInstance(studentId));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.fragments.size();
    }

    @Override // androidx.viewpager2.adapter.FragmentStateAdapter
    public Fragment createFragment(int position) {
        Fragment fragment = this.fragments.get(position);
        Intrinsics.checkNotNullExpressionValue(fragment, "fragments[position]");
        return fragment;
    }
}
