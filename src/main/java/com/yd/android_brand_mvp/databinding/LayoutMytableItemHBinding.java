package com.yd.android_brand_mvp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import com.yd.android_brand_mvp.R;

/* JADX INFO: loaded from: classes4.dex */
public final class LayoutMytableItemHBinding implements ViewBinding {
    public final LinearLayout llTwo;
    public final TextView otherClassesTeacher;
    public final TextView otherSubjectName;
    public final RelativeLayout rlBg;
    private final LinearLayout rootView;
    public final TextView seletion;
    public final TextView subjectName;
    public final TextView teacherName;
    public final TextView time;
    public final TextView time1;

    private LayoutMytableItemHBinding(LinearLayout linearLayout, LinearLayout linearLayout2, TextView textView, TextView textView2, RelativeLayout relativeLayout, TextView textView3, TextView textView4, TextView textView5, TextView textView6, TextView textView7) {
        this.rootView = linearLayout;
        this.llTwo = linearLayout2;
        this.otherClassesTeacher = textView;
        this.otherSubjectName = textView2;
        this.rlBg = relativeLayout;
        this.seletion = textView3;
        this.subjectName = textView4;
        this.teacherName = textView5;
        this.time = textView6;
        this.time1 = textView7;
    }

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static LayoutMytableItemHBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static LayoutMytableItemHBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.layout_mytable_item_h, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static LayoutMytableItemHBinding bind(View view) {
        int i = R.id.ll_two;
        LinearLayout linearLayout = (LinearLayout) view.findViewById(R.id.ll_two);
        if (linearLayout != null) {
            i = R.id.otherClassesTeacher;
            TextView textView = (TextView) view.findViewById(R.id.otherClassesTeacher);
            if (textView != null) {
                i = R.id.otherSubjectName;
                TextView textView2 = (TextView) view.findViewById(R.id.otherSubjectName);
                if (textView2 != null) {
                    i = R.id.rl_bg;
                    RelativeLayout relativeLayout = (RelativeLayout) view.findViewById(R.id.rl_bg);
                    if (relativeLayout != null) {
                        i = R.id.seletion;
                        TextView textView3 = (TextView) view.findViewById(R.id.seletion);
                        if (textView3 != null) {
                            i = R.id.subjectName;
                            TextView textView4 = (TextView) view.findViewById(R.id.subjectName);
                            if (textView4 != null) {
                                i = R.id.teacherName;
                                TextView textView5 = (TextView) view.findViewById(R.id.teacherName);
                                if (textView5 != null) {
                                    i = R.id.time;
                                    TextView textView6 = (TextView) view.findViewById(R.id.time);
                                    if (textView6 != null) {
                                        i = R.id.time1;
                                        TextView textView7 = (TextView) view.findViewById(R.id.time1);
                                        if (textView7 != null) {
                                            return new LayoutMytableItemHBinding((LinearLayout) view, linearLayout, textView, textView2, relativeLayout, textView3, textView4, textView5, textView6, textView7);
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
