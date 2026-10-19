package com.yd.android_brand_mvp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import com.yd.android_brand_mvp.R;

/* JADX INFO: loaded from: classes4.dex */
public final class CourseCardType2Binding implements ViewBinding {
    public final LinearLayout layout;
    private final LinearLayout rootView;
    public final TextView textView;

    private CourseCardType2Binding(LinearLayout linearLayout, LinearLayout linearLayout2, TextView textView) {
        this.rootView = linearLayout;
        this.layout = linearLayout2;
        this.textView = textView;
    }

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static CourseCardType2Binding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static CourseCardType2Binding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.course_card_type2, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static CourseCardType2Binding bind(View view) {
        LinearLayout linearLayout = (LinearLayout) view;
        TextView textView = (TextView) view.findViewById(R.id.text_view);
        if (textView != null) {
            return new CourseCardType2Binding(linearLayout, linearLayout, textView);
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(R.id.text_view)));
    }
}
