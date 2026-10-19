package com.yd.android_brand_mvp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.yd.android_brand_mvp.R;

/* JADX INFO: loaded from: classes4.dex */
public final class FragmentUniversityNextTableBinding implements ViewBinding {
    public final ConstraintLayout constraintLayout;
    private final ConstraintLayout rootView;
    public final TextView textView3;
    public final TextView tvNames;
    public final TextView tvSubjectName;
    public final TextView tvSubjectTime;

    private FragmentUniversityNextTableBinding(ConstraintLayout constraintLayout, ConstraintLayout constraintLayout2, TextView textView, TextView textView2, TextView textView3, TextView textView4) {
        this.rootView = constraintLayout;
        this.constraintLayout = constraintLayout2;
        this.textView3 = textView;
        this.tvNames = textView2;
        this.tvSubjectName = textView3;
        this.tvSubjectTime = textView4;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static FragmentUniversityNextTableBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static FragmentUniversityNextTableBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.fragment_university_next_table, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static FragmentUniversityNextTableBinding bind(View view) {
        ConstraintLayout constraintLayout = (ConstraintLayout) view;
        int i = R.id.textView3;
        TextView textView = (TextView) view.findViewById(R.id.textView3);
        if (textView != null) {
            i = R.id.tv_names;
            TextView textView2 = (TextView) view.findViewById(R.id.tv_names);
            if (textView2 != null) {
                i = R.id.tv_subjectName;
                TextView textView3 = (TextView) view.findViewById(R.id.tv_subjectName);
                if (textView3 != null) {
                    i = R.id.tv_subjectTime;
                    TextView textView4 = (TextView) view.findViewById(R.id.tv_subjectTime);
                    if (textView4 != null) {
                        return new FragmentUniversityNextTableBinding(constraintLayout, constraintLayout, textView, textView2, textView3, textView4);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
