package com.yd.android_brand_mvp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import com.yd.android_brand_mvp.R;

/* JADX INFO: loaded from: classes4.dex */
public final class LayoutMytableItemH1Binding implements ViewBinding {
    public final ImageView ivD;
    public final LinearLayout llTwo;
    public final RelativeLayout rlBg;
    private final LinearLayout rootView;
    public final TextView seletion;
    public final TextView subjectName;
    public final TextView teacherName;
    public final TextView time;
    public final TextView tvTableTip;

    private LayoutMytableItemH1Binding(LinearLayout linearLayout, ImageView imageView, LinearLayout linearLayout2, RelativeLayout relativeLayout, TextView textView, TextView textView2, TextView textView3, TextView textView4, TextView textView5) {
        this.rootView = linearLayout;
        this.ivD = imageView;
        this.llTwo = linearLayout2;
        this.rlBg = relativeLayout;
        this.seletion = textView;
        this.subjectName = textView2;
        this.teacherName = textView3;
        this.time = textView4;
        this.tvTableTip = textView5;
    }

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static LayoutMytableItemH1Binding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static LayoutMytableItemH1Binding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.layout_mytable_item_h1, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static LayoutMytableItemH1Binding bind(View view) {
        int i = R.id.iv_d;
        ImageView imageView = (ImageView) view.findViewById(R.id.iv_d);
        if (imageView != null) {
            i = R.id.ll_two;
            LinearLayout linearLayout = (LinearLayout) view.findViewById(R.id.ll_two);
            if (linearLayout != null) {
                i = R.id.rl_bg;
                RelativeLayout relativeLayout = (RelativeLayout) view.findViewById(R.id.rl_bg);
                if (relativeLayout != null) {
                    i = R.id.seletion;
                    TextView textView = (TextView) view.findViewById(R.id.seletion);
                    if (textView != null) {
                        i = R.id.subjectName;
                        TextView textView2 = (TextView) view.findViewById(R.id.subjectName);
                        if (textView2 != null) {
                            i = R.id.teacherName;
                            TextView textView3 = (TextView) view.findViewById(R.id.teacherName);
                            if (textView3 != null) {
                                i = R.id.time;
                                TextView textView4 = (TextView) view.findViewById(R.id.time);
                                if (textView4 != null) {
                                    i = R.id.tv_table_tip;
                                    TextView textView5 = (TextView) view.findViewById(R.id.tv_table_tip);
                                    if (textView5 != null) {
                                        return new LayoutMytableItemH1Binding((LinearLayout) view, imageView, linearLayout, relativeLayout, textView, textView2, textView3, textView4, textView5);
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
