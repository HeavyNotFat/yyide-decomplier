package com.yd.android_brand_mvp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.Button;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import com.yd.android_brand_mvp.R;

/* JADX INFO: loaded from: classes4.dex */
public final class FragmentExamArrangementBinding implements ViewBinding {
    public final Button btnFragmentExamSign;
    public final ViewStub emptyView;
    private final ConstraintLayout rootView;
    public final RecyclerView rvFragmentExamArrangementCourse;
    public final RecyclerView rvFragmentExamArrangementWeek;

    private FragmentExamArrangementBinding(ConstraintLayout constraintLayout, Button button, ViewStub viewStub, RecyclerView recyclerView, RecyclerView recyclerView2) {
        this.rootView = constraintLayout;
        this.btnFragmentExamSign = button;
        this.emptyView = viewStub;
        this.rvFragmentExamArrangementCourse = recyclerView;
        this.rvFragmentExamArrangementWeek = recyclerView2;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static FragmentExamArrangementBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static FragmentExamArrangementBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.fragment_exam_arrangement, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static FragmentExamArrangementBinding bind(View view) {
        int i = R.id.btn_fragment_exam_sign;
        Button button = (Button) view.findViewById(R.id.btn_fragment_exam_sign);
        if (button != null) {
            i = R.id.empty_view;
            ViewStub viewStub = (ViewStub) view.findViewById(R.id.empty_view);
            if (viewStub != null) {
                i = R.id.rv_fragment_exam_arrangement_course;
                RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.rv_fragment_exam_arrangement_course);
                if (recyclerView != null) {
                    i = R.id.rv_fragment_exam_arrangement_week;
                    RecyclerView recyclerView2 = (RecyclerView) view.findViewById(R.id.rv_fragment_exam_arrangement_week);
                    if (recyclerView2 != null) {
                        return new FragmentExamArrangementBinding((ConstraintLayout) view, button, viewStub, recyclerView, recyclerView2);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
