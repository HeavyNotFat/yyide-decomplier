package com.yd.android_brand_mvp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import com.to.aboomy.pager2banner.Banner;
import com.yd.android_brand_mvp.R;

/* JADX INFO: loaded from: classes4.dex */
public final class StudentProductionPage44Binding implements ViewBinding {
    public final Banner banner;
    public final ImageView ivHeadPortrait;
    public final LinearLayout llIndicator;
    public final RelativeLayout rlHead;
    private final LinearLayout rootView;
    public final TextView tvName;
    public final TextView tvPersonalMotto;
    public final View vIsFine;

    private StudentProductionPage44Binding(LinearLayout linearLayout, Banner banner, ImageView imageView, LinearLayout linearLayout2, RelativeLayout relativeLayout, TextView textView, TextView textView2, View view) {
        this.rootView = linearLayout;
        this.banner = banner;
        this.ivHeadPortrait = imageView;
        this.llIndicator = linearLayout2;
        this.rlHead = relativeLayout;
        this.tvName = textView;
        this.tvPersonalMotto = textView2;
        this.vIsFine = view;
    }

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static StudentProductionPage44Binding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static StudentProductionPage44Binding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.student_production_page_44, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static StudentProductionPage44Binding bind(View view) {
        int i = R.id.banner;
        Banner banner = (Banner) view.findViewById(R.id.banner);
        if (banner != null) {
            i = R.id.iv_head_portrait;
            ImageView imageView = (ImageView) view.findViewById(R.id.iv_head_portrait);
            if (imageView != null) {
                i = R.id.ll_indicator;
                LinearLayout linearLayout = (LinearLayout) view.findViewById(R.id.ll_indicator);
                if (linearLayout != null) {
                    i = R.id.rl_head;
                    RelativeLayout relativeLayout = (RelativeLayout) view.findViewById(R.id.rl_head);
                    if (relativeLayout != null) {
                        i = R.id.tv_name;
                        TextView textView = (TextView) view.findViewById(R.id.tv_name);
                        if (textView != null) {
                            i = R.id.tv_personal_motto;
                            TextView textView2 = (TextView) view.findViewById(R.id.tv_personal_motto);
                            if (textView2 != null) {
                                i = R.id.v_is_fine;
                                View viewFindViewById = view.findViewById(R.id.v_is_fine);
                                if (viewFindViewById != null) {
                                    return new StudentProductionPage44Binding((LinearLayout) view, banner, imageView, linearLayout, relativeLayout, textView, textView2, viewFindViewById);
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
