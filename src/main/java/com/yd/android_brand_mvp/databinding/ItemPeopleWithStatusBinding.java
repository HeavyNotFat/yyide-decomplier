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
public final class ItemPeopleWithStatusBinding implements ViewBinding {
    public final ImageView ivItemPeopleWithStatus;
    public final ImageView ivItemPeopleWithStatusTip;
    private final ConstraintLayout rootView;
    public final TextView tvItemPeopleWithStatusName;
    public final TextView tvItemPeopleWithStatusReason;
    public final TextView tvItemPeopleWithStatusTime;
    public final TextView tvItemPeopleWithStatusTip;

    private ItemPeopleWithStatusBinding(ConstraintLayout constraintLayout, ImageView imageView, ImageView imageView2, TextView textView, TextView textView2, TextView textView3, TextView textView4) {
        this.rootView = constraintLayout;
        this.ivItemPeopleWithStatus = imageView;
        this.ivItemPeopleWithStatusTip = imageView2;
        this.tvItemPeopleWithStatusName = textView;
        this.tvItemPeopleWithStatusReason = textView2;
        this.tvItemPeopleWithStatusTime = textView3;
        this.tvItemPeopleWithStatusTip = textView4;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static ItemPeopleWithStatusBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static ItemPeopleWithStatusBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.item_people_with_status, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static ItemPeopleWithStatusBinding bind(View view) {
        int i = R.id.iv_item_people_with_status;
        ImageView imageView = (ImageView) view.findViewById(R.id.iv_item_people_with_status);
        if (imageView != null) {
            i = R.id.iv_item_people_with_status_tip;
            ImageView imageView2 = (ImageView) view.findViewById(R.id.iv_item_people_with_status_tip);
            if (imageView2 != null) {
                i = R.id.tv_item_people_with_status_name;
                TextView textView = (TextView) view.findViewById(R.id.tv_item_people_with_status_name);
                if (textView != null) {
                    i = R.id.tv_item_people_with_status_reason;
                    TextView textView2 = (TextView) view.findViewById(R.id.tv_item_people_with_status_reason);
                    if (textView2 != null) {
                        i = R.id.tv_item_people_with_status_time;
                        TextView textView3 = (TextView) view.findViewById(R.id.tv_item_people_with_status_time);
                        if (textView3 != null) {
                            i = R.id.tv_item_people_with_status_tip;
                            TextView textView4 = (TextView) view.findViewById(R.id.tv_item_people_with_status_tip);
                            if (textView4 != null) {
                                return new ItemPeopleWithStatusBinding((ConstraintLayout) view, imageView, imageView2, textView, textView2, textView3, textView4);
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
