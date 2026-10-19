package com.yd.android_brand_mvp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.FragmentContainerView;
import androidx.viewbinding.ViewBinding;
import com.yd.android_brand_mvp.R;

/* JADX INFO: loaded from: classes4.dex */
public final class FragmentExamDetailBinding implements ViewBinding {
    public final ConstraintLayout clActivityVoteListNav;
    private final ConstraintLayout rootView;
    public final TextView tvActivityVoteListEnd;
    public final TextView tvActivityVoteListIng;
    public final FragmentContainerView vpFragmentDetail;

    private FragmentExamDetailBinding(ConstraintLayout constraintLayout, ConstraintLayout constraintLayout2, TextView textView, TextView textView2, FragmentContainerView fragmentContainerView) {
        this.rootView = constraintLayout;
        this.clActivityVoteListNav = constraintLayout2;
        this.tvActivityVoteListEnd = textView;
        this.tvActivityVoteListIng = textView2;
        this.vpFragmentDetail = fragmentContainerView;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static FragmentExamDetailBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static FragmentExamDetailBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.fragment_exam_detail, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static FragmentExamDetailBinding bind(View view) {
        int i = R.id.cl_activity_vote_list_nav;
        ConstraintLayout constraintLayout = (ConstraintLayout) view.findViewById(R.id.cl_activity_vote_list_nav);
        if (constraintLayout != null) {
            i = R.id.tv_activity_vote_list_end;
            TextView textView = (TextView) view.findViewById(R.id.tv_activity_vote_list_end);
            if (textView != null) {
                i = R.id.tv_activity_vote_list_ing;
                TextView textView2 = (TextView) view.findViewById(R.id.tv_activity_vote_list_ing);
                if (textView2 != null) {
                    i = R.id.vp_fragment_detail;
                    FragmentContainerView fragmentContainerView = (FragmentContainerView) view.findViewById(R.id.vp_fragment_detail);
                    if (fragmentContainerView != null) {
                        return new FragmentExamDetailBinding((ConstraintLayout) view, constraintLayout, textView, textView2, fragmentContainerView);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
