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
public final class ItemPatrolListBinding implements ViewBinding {
    public final TextView btnItemPatrolListDetail;
    public final ImageView ivItemPatrolListStatus;
    private final ConstraintLayout rootView;
    public final TextView tvItemPatrolListStatus;
    public final TextView tvItemPatrolListTime;
    public final TextView tvItemPatrolListTitle;

    private ItemPatrolListBinding(ConstraintLayout constraintLayout, TextView textView, ImageView imageView, TextView textView2, TextView textView3, TextView textView4) {
        this.rootView = constraintLayout;
        this.btnItemPatrolListDetail = textView;
        this.ivItemPatrolListStatus = imageView;
        this.tvItemPatrolListStatus = textView2;
        this.tvItemPatrolListTime = textView3;
        this.tvItemPatrolListTitle = textView4;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static ItemPatrolListBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static ItemPatrolListBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.item_patrol_list, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static ItemPatrolListBinding bind(View view) {
        int i = R.id.btn_item_patrol_list_detail;
        TextView textView = (TextView) view.findViewById(R.id.btn_item_patrol_list_detail);
        if (textView != null) {
            i = R.id.iv_item_patrol_list_status;
            ImageView imageView = (ImageView) view.findViewById(R.id.iv_item_patrol_list_status);
            if (imageView != null) {
                i = R.id.tv_item_patrol_list_status;
                TextView textView2 = (TextView) view.findViewById(R.id.tv_item_patrol_list_status);
                if (textView2 != null) {
                    i = R.id.tv_item_patrol_list_time;
                    TextView textView3 = (TextView) view.findViewById(R.id.tv_item_patrol_list_time);
                    if (textView3 != null) {
                        i = R.id.tv_item_patrol_list_title;
                        TextView textView4 = (TextView) view.findViewById(R.id.tv_item_patrol_list_title);
                        if (textView4 != null) {
                            return new ItemPatrolListBinding((ConstraintLayout) view, textView, imageView, textView2, textView3, textView4);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
