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
public final class GankItemHonerWallBinding implements ViewBinding {
    public final ImageView ivItemHonerWallTemplate;
    private final ConstraintLayout rootView;
    public final TextView tvItemHonerWallGetClass;
    public final TextView tvItemHonerWallTime;
    public final TextView tvItemHonerWallTitle;
    public final TextView tvItemHonerWallType;

    private GankItemHonerWallBinding(ConstraintLayout constraintLayout, ImageView imageView, TextView textView, TextView textView2, TextView textView3, TextView textView4) {
        this.rootView = constraintLayout;
        this.ivItemHonerWallTemplate = imageView;
        this.tvItemHonerWallGetClass = textView;
        this.tvItemHonerWallTime = textView2;
        this.tvItemHonerWallTitle = textView3;
        this.tvItemHonerWallType = textView4;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static GankItemHonerWallBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static GankItemHonerWallBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.gank_item_honer_wall, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static GankItemHonerWallBinding bind(View view) {
        int i = R.id.iv_item_honer_wall_template;
        ImageView imageView = (ImageView) view.findViewById(R.id.iv_item_honer_wall_template);
        if (imageView != null) {
            i = R.id.tv_item_honer_wall_getClass;
            TextView textView = (TextView) view.findViewById(R.id.tv_item_honer_wall_getClass);
            if (textView != null) {
                i = R.id.tv_item_honer_wall_time;
                TextView textView2 = (TextView) view.findViewById(R.id.tv_item_honer_wall_time);
                if (textView2 != null) {
                    i = R.id.tv_item_honer_wall_title;
                    TextView textView3 = (TextView) view.findViewById(R.id.tv_item_honer_wall_title);
                    if (textView3 != null) {
                        i = R.id.tv_item_honer_wall_type;
                        TextView textView4 = (TextView) view.findViewById(R.id.tv_item_honer_wall_type);
                        if (textView4 != null) {
                            return new GankItemHonerWallBinding((ConstraintLayout) view, imageView, textView, textView2, textView3, textView4);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
