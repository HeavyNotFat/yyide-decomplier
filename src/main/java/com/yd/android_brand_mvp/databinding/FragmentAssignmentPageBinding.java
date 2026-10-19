package com.yd.android_brand_mvp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import com.yd.android_brand_mvp.R;

/* JADX INFO: loaded from: classes4.dex */
public final class FragmentAssignmentPageBinding implements ViewBinding {
    public final TextView lab1;
    private final LinearLayout rootView;
    public final TextView tvContent;
    public final TextView tvCreatePeople;
    public final TextView tvSubject;
    public final TextView tvTime;

    private FragmentAssignmentPageBinding(LinearLayout linearLayout, TextView textView, TextView textView2, TextView textView3, TextView textView4, TextView textView5) {
        this.rootView = linearLayout;
        this.lab1 = textView;
        this.tvContent = textView2;
        this.tvCreatePeople = textView3;
        this.tvSubject = textView4;
        this.tvTime = textView5;
    }

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static FragmentAssignmentPageBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static FragmentAssignmentPageBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.fragment_assignment_page, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static FragmentAssignmentPageBinding bind(View view) {
        int i = R.id.lab1;
        TextView textView = (TextView) view.findViewById(R.id.lab1);
        if (textView != null) {
            i = R.id.tv_content;
            TextView textView2 = (TextView) view.findViewById(R.id.tv_content);
            if (textView2 != null) {
                i = R.id.tv_create_people;
                TextView textView3 = (TextView) view.findViewById(R.id.tv_create_people);
                if (textView3 != null) {
                    i = R.id.tv_subject;
                    TextView textView4 = (TextView) view.findViewById(R.id.tv_subject);
                    if (textView4 != null) {
                        i = R.id.tv_time;
                        TextView textView5 = (TextView) view.findViewById(R.id.tv_time);
                        if (textView5 != null) {
                            return new FragmentAssignmentPageBinding((LinearLayout) view, textView, textView2, textView3, textView4, textView5);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
