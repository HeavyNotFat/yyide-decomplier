package com.yd.android_brand_mvp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import com.yd.android_brand_mvp.R;

/* JADX INFO: loaded from: classes4.dex */
public final class FragmentHomeExamArrangement44Binding implements ViewBinding {
    public final TextView btnFragmentExamSign;
    public final ConstraintLayout clFragmentExamArrangement;
    public final ViewStub emptyView;
    public final ViewStub emptyView2;
    private final ConstraintLayout rootView;
    public final RecyclerView rvFragmentExamArrangementCourse;
    public final RecyclerView rvFragmentExamArrangementWeek;
    public final LayoutHeadTitleBinding topFragmentExamArrangement;

    private FragmentHomeExamArrangement44Binding(ConstraintLayout constraintLayout, TextView textView, ConstraintLayout constraintLayout2, ViewStub viewStub, ViewStub viewStub2, RecyclerView recyclerView, RecyclerView recyclerView2, LayoutHeadTitleBinding layoutHeadTitleBinding) {
        this.rootView = constraintLayout;
        this.btnFragmentExamSign = textView;
        this.clFragmentExamArrangement = constraintLayout2;
        this.emptyView = viewStub;
        this.emptyView2 = viewStub2;
        this.rvFragmentExamArrangementCourse = recyclerView;
        this.rvFragmentExamArrangementWeek = recyclerView2;
        this.topFragmentExamArrangement = layoutHeadTitleBinding;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static FragmentHomeExamArrangement44Binding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static FragmentHomeExamArrangement44Binding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.fragment_home_exam_arrangement44, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static FragmentHomeExamArrangement44Binding bind(View view) {
        int i = R.id.btn_fragment_exam_sign;
        TextView textView = (TextView) view.findViewById(R.id.btn_fragment_exam_sign);
        if (textView != null) {
            ConstraintLayout constraintLayout = (ConstraintLayout) view;
            i = R.id.empty_view;
            ViewStub viewStub = (ViewStub) view.findViewById(R.id.empty_view);
            if (viewStub != null) {
                i = R.id.empty_view2;
                ViewStub viewStub2 = (ViewStub) view.findViewById(R.id.empty_view2);
                if (viewStub2 != null) {
                    i = R.id.rv_fragment_exam_arrangement_course;
                    RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.rv_fragment_exam_arrangement_course);
                    if (recyclerView != null) {
                        i = R.id.rv_fragment_exam_arrangement_week;
                        RecyclerView recyclerView2 = (RecyclerView) view.findViewById(R.id.rv_fragment_exam_arrangement_week);
                        if (recyclerView2 != null) {
                            i = R.id.top_fragment_exam_arrangement;
                            View viewFindViewById = view.findViewById(R.id.top_fragment_exam_arrangement);
                            if (viewFindViewById != null) {
                                return new FragmentHomeExamArrangement44Binding(constraintLayout, textView, constraintLayout, viewStub, viewStub2, recyclerView, recyclerView2, LayoutHeadTitleBinding.bind(viewFindViewById));
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
