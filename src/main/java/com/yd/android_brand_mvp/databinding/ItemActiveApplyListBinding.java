package com.yd.android_brand_mvp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.yd.android_brand_mvp.R;

/* JADX INFO: loaded from: classes4.dex */
public final class ItemActiveApplyListBinding implements ViewBinding {
    public final ConstraintLayout clContent;
    public final ImageView ivCover;
    private final LinearLayoutCompat rootView;
    public final TextView tvActiveApplyDate;
    public final TextView tvActiveDate;
    public final TextView tvActiveObject;
    public final TextView tvActivePeopleNumber;
    public final TextView tvActiveStatus;
    public final TextView tvActiveTitle;
    public final TextView tvActiveTotalNumber;

    private ItemActiveApplyListBinding(LinearLayoutCompat linearLayoutCompat, ConstraintLayout constraintLayout, ImageView imageView, TextView textView, TextView textView2, TextView textView3, TextView textView4, TextView textView5, TextView textView6, TextView textView7) {
        this.rootView = linearLayoutCompat;
        this.clContent = constraintLayout;
        this.ivCover = imageView;
        this.tvActiveApplyDate = textView;
        this.tvActiveDate = textView2;
        this.tvActiveObject = textView3;
        this.tvActivePeopleNumber = textView4;
        this.tvActiveStatus = textView5;
        this.tvActiveTitle = textView6;
        this.tvActiveTotalNumber = textView7;
    }

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayoutCompat getRoot() {
        return this.rootView;
    }

    public static ItemActiveApplyListBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static ItemActiveApplyListBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.item_active_apply_list, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static ItemActiveApplyListBinding bind(View view) {
        int i = R.id.cl_content;
        ConstraintLayout constraintLayout = (ConstraintLayout) view.findViewById(R.id.cl_content);
        if (constraintLayout != null) {
            ImageView imageView = (ImageView) view.findViewById(R.id.iv_cover);
            i = R.id.tv_active_apply_date;
            TextView textView = (TextView) view.findViewById(R.id.tv_active_apply_date);
            if (textView != null) {
                i = R.id.tv_active_date;
                TextView textView2 = (TextView) view.findViewById(R.id.tv_active_date);
                if (textView2 != null) {
                    i = R.id.tv_active_object;
                    TextView textView3 = (TextView) view.findViewById(R.id.tv_active_object);
                    if (textView3 != null) {
                        i = R.id.tv_active_people_number;
                        TextView textView4 = (TextView) view.findViewById(R.id.tv_active_people_number);
                        if (textView4 != null) {
                            i = R.id.tv_active_status;
                            TextView textView5 = (TextView) view.findViewById(R.id.tv_active_status);
                            if (textView5 != null) {
                                i = R.id.tv_active_title;
                                TextView textView6 = (TextView) view.findViewById(R.id.tv_active_title);
                                if (textView6 != null) {
                                    i = R.id.tv_active_total_number;
                                    TextView textView7 = (TextView) view.findViewById(R.id.tv_active_total_number);
                                    if (textView7 != null) {
                                        return new ItemActiveApplyListBinding((LinearLayoutCompat) view, constraintLayout, imageView, textView, textView2, textView3, textView4, textView5, textView6, textView7);
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
