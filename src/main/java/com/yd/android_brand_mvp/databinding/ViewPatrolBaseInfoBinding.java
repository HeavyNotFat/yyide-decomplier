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
public final class ViewPatrolBaseInfoBinding implements ViewBinding {
    public final ImageView ivViewPatrolBaseInfoStatus;
    private final ConstraintLayout rootView;
    public final TextView tvViewPatrolBaseInfoDesc;
    public final TextView tvViewPatrolBaseInfoFormTitle;
    public final TextView tvViewPatrolBaseInfoPeople;
    public final TextView tvViewPatrolBaseInfoSubmitTime;
    public final TextView tvViewPatrolBaseInfoTime;
    public final TextView tvViewPatrolBaseInfoTitle;

    private ViewPatrolBaseInfoBinding(ConstraintLayout constraintLayout, ImageView imageView, TextView textView, TextView textView2, TextView textView3, TextView textView4, TextView textView5, TextView textView6) {
        this.rootView = constraintLayout;
        this.ivViewPatrolBaseInfoStatus = imageView;
        this.tvViewPatrolBaseInfoDesc = textView;
        this.tvViewPatrolBaseInfoFormTitle = textView2;
        this.tvViewPatrolBaseInfoPeople = textView3;
        this.tvViewPatrolBaseInfoSubmitTime = textView4;
        this.tvViewPatrolBaseInfoTime = textView5;
        this.tvViewPatrolBaseInfoTitle = textView6;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static ViewPatrolBaseInfoBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static ViewPatrolBaseInfoBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.view_patrol_base_info, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static ViewPatrolBaseInfoBinding bind(View view) {
        int i = R.id.iv_view_patrol_base_info_status;
        ImageView imageView = (ImageView) view.findViewById(R.id.iv_view_patrol_base_info_status);
        if (imageView != null) {
            i = R.id.tv_view_patrol_base_info_desc;
            TextView textView = (TextView) view.findViewById(R.id.tv_view_patrol_base_info_desc);
            if (textView != null) {
                i = R.id.tv_view_patrol_base_info_form_title;
                TextView textView2 = (TextView) view.findViewById(R.id.tv_view_patrol_base_info_form_title);
                if (textView2 != null) {
                    i = R.id.tv_view_patrol_base_info_people;
                    TextView textView3 = (TextView) view.findViewById(R.id.tv_view_patrol_base_info_people);
                    if (textView3 != null) {
                        i = R.id.tv_view_patrol_base_info_submit_time;
                        TextView textView4 = (TextView) view.findViewById(R.id.tv_view_patrol_base_info_submit_time);
                        if (textView4 != null) {
                            i = R.id.tv_view_patrol_base_info_time;
                            TextView textView5 = (TextView) view.findViewById(R.id.tv_view_patrol_base_info_time);
                            if (textView5 != null) {
                                i = R.id.tv_view_patrol_base_info_title;
                                TextView textView6 = (TextView) view.findViewById(R.id.tv_view_patrol_base_info_title);
                                if (textView6 != null) {
                                    return new ViewPatrolBaseInfoBinding((ConstraintLayout) view, imageView, textView, textView2, textView3, textView4, textView5, textView6);
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
