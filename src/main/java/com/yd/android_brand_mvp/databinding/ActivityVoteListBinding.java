package com.yd.android_brand_mvp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import com.yd.android_brand_mvp.R;

/* JADX INFO: loaded from: classes4.dex */
public final class ActivityVoteListBinding implements ViewBinding {
    public final ConstraintLayout clActivityVoteListNav;
    private final ConstraintLayout rootView;
    public final RecyclerView rvActivityVoteListList;
    public final TextView tvActivityVoteListEnd;
    public final TextView tvActivityVoteListIng;
    public final TextView tvActivityVoteListNext;
    public final TextView tvActivityVoteListPre;

    private ActivityVoteListBinding(ConstraintLayout constraintLayout, ConstraintLayout constraintLayout2, RecyclerView recyclerView, TextView textView, TextView textView2, TextView textView3, TextView textView4) {
        this.rootView = constraintLayout;
        this.clActivityVoteListNav = constraintLayout2;
        this.rvActivityVoteListList = recyclerView;
        this.tvActivityVoteListEnd = textView;
        this.tvActivityVoteListIng = textView2;
        this.tvActivityVoteListNext = textView3;
        this.tvActivityVoteListPre = textView4;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static ActivityVoteListBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static ActivityVoteListBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.activity_vote_list, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static ActivityVoteListBinding bind(View view) {
        int i = R.id.cl_activity_vote_list_nav;
        ConstraintLayout constraintLayout = (ConstraintLayout) view.findViewById(R.id.cl_activity_vote_list_nav);
        if (constraintLayout != null) {
            i = R.id.rv_activity_vote_list_list;
            RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.rv_activity_vote_list_list);
            if (recyclerView != null) {
                i = R.id.tv_activity_vote_list_end;
                TextView textView = (TextView) view.findViewById(R.id.tv_activity_vote_list_end);
                if (textView != null) {
                    i = R.id.tv_activity_vote_list_ing;
                    TextView textView2 = (TextView) view.findViewById(R.id.tv_activity_vote_list_ing);
                    if (textView2 != null) {
                        i = R.id.tv_activity_vote_list_next;
                        TextView textView3 = (TextView) view.findViewById(R.id.tv_activity_vote_list_next);
                        if (textView3 != null) {
                            i = R.id.tv_activity_vote_list_pre;
                            TextView textView4 = (TextView) view.findViewById(R.id.tv_activity_vote_list_pre);
                            if (textView4 != null) {
                                return new ActivityVoteListBinding((ConstraintLayout) view, constraintLayout, recyclerView, textView, textView2, textView3, textView4);
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
