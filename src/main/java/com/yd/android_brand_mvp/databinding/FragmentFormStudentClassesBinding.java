package com.yd.android_brand_mvp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.viewbinding.ViewBinding;
import com.yd.android_brand_mvp.R;

/* JADX INFO: loaded from: classes4.dex */
public final class FragmentFormStudentClassesBinding implements ViewBinding {
    private final LinearLayoutCompat rootView;
    public final TextView tvStudentClassesTitle;
    public final TextView tvStudentClassesValue;
    public final TextView tvViewCollectFormDateRequired;

    private FragmentFormStudentClassesBinding(LinearLayoutCompat linearLayoutCompat, TextView textView, TextView textView2, TextView textView3) {
        this.rootView = linearLayoutCompat;
        this.tvStudentClassesTitle = textView;
        this.tvStudentClassesValue = textView2;
        this.tvViewCollectFormDateRequired = textView3;
    }

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayoutCompat getRoot() {
        return this.rootView;
    }

    public static FragmentFormStudentClassesBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static FragmentFormStudentClassesBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.fragment_form_student_classes, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static FragmentFormStudentClassesBinding bind(View view) {
        int i = R.id.tv_student_classes_title;
        TextView textView = (TextView) view.findViewById(R.id.tv_student_classes_title);
        if (textView != null) {
            i = R.id.tv_student_classes_value;
            TextView textView2 = (TextView) view.findViewById(R.id.tv_student_classes_value);
            if (textView2 != null) {
                i = R.id.tv_view_collect_form_date_required;
                TextView textView3 = (TextView) view.findViewById(R.id.tv_view_collect_form_date_required);
                if (textView3 != null) {
                    return new FragmentFormStudentClassesBinding((LinearLayoutCompat) view, textView, textView2, textView3);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
