package com.yd.android_brand_mvp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import com.yd.android_brand_mvp.R;
import com.yd.android_brand_mvp.weight.MultiStateView;
import com.yd.android_brand_mvp.widget.YDViewPager;

/* JADX INFO: loaded from: classes4.dex */
public final class FragmentStudentProductionPBinding implements ViewBinding {
    public final MultiStateView mu;
    private final MultiStateView rootView;
    public final TextView tvLast;
    public final TextView tvNext;
    public final YDViewPager vpStuProduction;

    private FragmentStudentProductionPBinding(MultiStateView multiStateView, MultiStateView multiStateView2, TextView textView, TextView textView2, YDViewPager yDViewPager) {
        this.rootView = multiStateView;
        this.mu = multiStateView2;
        this.tvLast = textView;
        this.tvNext = textView2;
        this.vpStuProduction = yDViewPager;
    }

    @Override // androidx.viewbinding.ViewBinding
    public MultiStateView getRoot() {
        return this.rootView;
    }

    public static FragmentStudentProductionPBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static FragmentStudentProductionPBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.fragment_student_production_p, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static FragmentStudentProductionPBinding bind(View view) {
        MultiStateView multiStateView = (MultiStateView) view;
        int i = R.id.tv_last;
        TextView textView = (TextView) view.findViewById(R.id.tv_last);
        if (textView != null) {
            i = R.id.tv_next;
            TextView textView2 = (TextView) view.findViewById(R.id.tv_next);
            if (textView2 != null) {
                i = R.id.vp_stu_production;
                YDViewPager yDViewPager = (YDViewPager) view.findViewById(R.id.vp_stu_production);
                if (yDViewPager != null) {
                    return new FragmentStudentProductionPBinding(multiStateView, multiStateView, textView, textView2, yDViewPager);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
