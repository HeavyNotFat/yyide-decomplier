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
public final class LayoutMytableItemLBinding implements ViewBinding {
    public final RelativeLayout rlBg;
    private final LinearLayout rootView;
    public final TextView seletion;
    public final TextView seletionEnglish;
    public final TextView subjectName;
    public final TextView teacherName;
    public final TextView time;

    private LayoutMytableItemLBinding(LinearLayout linearLayout, RelativeLayout relativeLayout, TextView textView, TextView textView2, TextView textView3, TextView textView4, TextView textView5) {
        this.rootView = linearLayout;
        this.rlBg = relativeLayout;
        this.seletion = textView;
        this.seletionEnglish = textView2;
        this.subjectName = textView3;
        this.teacherName = textView4;
        this.time = textView5;
    }

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static LayoutMytableItemLBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static LayoutMytableItemLBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.layout_mytable_item_l, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static LayoutMytableItemLBinding bind(View view) {
        int i = R.id.rl_bg;
        RelativeLayout relativeLayout = (RelativeLayout) view.findViewById(R.id.rl_bg);
        if (relativeLayout != null) {
            i = R.id.seletion;
            TextView textView = (TextView) view.findViewById(R.id.seletion);
            if (textView != null) {
                i = R.id.seletion_english;
                TextView textView2 = (TextView) view.findViewById(R.id.seletion_english);
                if (textView2 != null) {
                    i = R.id.subjectName;
                    TextView textView3 = (TextView) view.findViewById(R.id.subjectName);
                    if (textView3 != null) {
                        i = R.id.teacherName;
                        TextView textView4 = (TextView) view.findViewById(R.id.teacherName);
                        if (textView4 != null) {
                            i = R.id.time;
                            TextView textView5 = (TextView) view.findViewById(R.id.time);
                            if (textView5 != null) {
                                return new LayoutMytableItemLBinding((LinearLayout) view, relativeLayout, textView, textView2, textView3, textView4, textView5);
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
