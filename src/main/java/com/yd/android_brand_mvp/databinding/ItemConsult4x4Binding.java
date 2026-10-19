package com.yd.android_brand_mvp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.yd.android_brand_mvp.R;

/* JADX INFO: loaded from: classes4.dex */
public final class ItemConsult4x4Binding implements ViewBinding {
    public final ConstraintLayout clContent;
    public final ImageView ivHead;
    private final ConstraintLayout rootView;
    public final TextView tvConsultDate;
    public final TextView tvConsultName;
    public final TextView tvConsultNameMore;
    public final TextView tvConsultTitle;
    public final TextView tvHeadName;
    public final TextView tvWeek;

    private ItemConsult4x4Binding(ConstraintLayout constraintLayout, ConstraintLayout constraintLayout2, ImageView imageView, TextView textView, TextView textView2, TextView textView3, TextView textView4, TextView textView5, TextView textView6) {
        this.rootView = constraintLayout;
        this.clContent = constraintLayout2;
        this.ivHead = imageView;
        this.tvConsultDate = textView;
        this.tvConsultName = textView2;
        this.tvConsultNameMore = textView3;
        this.tvConsultTitle = textView4;
        this.tvHeadName = textView5;
        this.tvWeek = textView6;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static ItemConsult4x4Binding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static ItemConsult4x4Binding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.item_consult_4x4, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static ItemConsult4x4Binding bind(View view) {
        ConstraintLayout constraintLayout = (ConstraintLayout) view;
        int i = R.id.iv_head;
        ImageView imageView = (ImageView) view.findViewById(R.id.iv_head);
        if (imageView != null) {
            i = R.id.tv_consult_date;
            TextView textView = (TextView) view.findViewById(R.id.tv_consult_date);
            if (textView != null) {
                i = R.id.tv_consult_name;
                TextView textView2 = (TextView) view.findViewById(R.id.tv_consult_name);
                if (textView2 != null) {
                    i = R.id.tv_consult_name_more;
                    TextView textView3 = (TextView) view.findViewById(R.id.tv_consult_name_more);
                    if (textView3 != null) {
                        i = R.id.tv_consult_title;
                        TextView textView4 = (TextView) view.findViewById(R.id.tv_consult_title);
                        if (textView4 != null) {
                            i = R.id.tv_head_name;
                            TextView textView5 = (TextView) view.findViewById(R.id.tv_head_name);
                            if (textView5 != null) {
                                i = R.id.tv_week;
                                TextView textView6 = (TextView) view.findViewById(R.id.tv_week);
                                if (textView6 != null) {
                                    return new ItemConsult4x4Binding(constraintLayout, constraintLayout, imageView, textView, textView2, textView3, textView4, textView5, textView6);
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
