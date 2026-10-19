package com.yd.android_brand_mvp.adapter.comments;

import android.util.SparseArray;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: CommentsPager.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u001b\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0002\u0010\u0007J\u0010\u0010\b\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\nH\u0016J\b\u0010\u000b\u001a\u00020\nH\u0016R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/yd/android_brand_mvp/adapter/comments/CommentsPager;", "Landroidx/viewpager2/adapter/FragmentStateAdapter;", "fragmentActivity", "Landroidx/fragment/app/FragmentActivity;", "fragments", "Landroid/util/SparseArray;", "Landroidx/fragment/app/Fragment;", "(Landroidx/fragment/app/FragmentActivity;Landroid/util/SparseArray;)V", "createFragment", "position", "", "getItemCount", "app_commonRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class CommentsPager extends FragmentStateAdapter {
    private SparseArray<Fragment> fragments;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CommentsPager(FragmentActivity fragmentActivity, SparseArray<Fragment> fragments) {
        super(fragmentActivity);
        Intrinsics.checkNotNullParameter(fragmentActivity, "fragmentActivity");
        Intrinsics.checkNotNullParameter(fragments, "fragments");
        this.fragments = new SparseArray<>();
        this.fragments = fragments;
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
