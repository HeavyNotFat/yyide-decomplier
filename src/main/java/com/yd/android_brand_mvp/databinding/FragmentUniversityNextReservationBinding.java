package com.yd.android_brand_mvp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.yd.android_brand_mvp.R;

/* JADX INFO: loaded from: classes4.dex */
public final class FragmentUniversityNextReservationBinding implements ViewBinding {
    public final ConstraintLayout constraintLayout;
    private final ConstraintLayout rootView;
    public final TextView tvName;
    public final TextView tvTime;
    public final TextView tvTitle;

    private FragmentUniversityNextReservationBinding(ConstraintLayout constraintLayout, ConstraintLayout constraintLayout2, TextView textView, TextView textView2, TextView textView3) {
        this.rootView = constraintLayout;
        this.constraintLayout = constraintLayout2;
        this.tvName = textView;
        this.tvTime = textView2;
        this.tvTitle = textView3;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static FragmentUniversityNextReservationBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static FragmentUniversityNextReservationBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.fragment_university_next_reservation, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static FragmentUniversityNextReservationBinding bind(View view) {
        ConstraintLayout constraintLayout = (ConstraintLayout) view;
        int i = R.id.tv_name;
        TextView textView = (TextView) view.findViewById(R.id.tv_name);
        if (textView != null) {
            i = R.id.tv_time;
            TextView textView2 = (TextView) view.findViewById(R.id.tv_time);
            if (textView2 != null) {
                i = R.id.tv_title;
                TextView textView3 = (TextView) view.findViewById(R.id.tv_title);
                if (textView3 != null) {
                    return new FragmentUniversityNextReservationBinding(constraintLayout, constraintLayout, textView, textView2, textView3);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
