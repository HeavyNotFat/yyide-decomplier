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
public final class ItemPeopleBinding implements ViewBinding {
    public final ImageView ivItemPeople;
    public final ImageView ivItemPeopleTip;
    private final ConstraintLayout rootView;
    public final TextView tvItemPeopleName;

    private ItemPeopleBinding(ConstraintLayout constraintLayout, ImageView imageView, ImageView imageView2, TextView textView) {
        this.rootView = constraintLayout;
        this.ivItemPeople = imageView;
        this.ivItemPeopleTip = imageView2;
        this.tvItemPeopleName = textView;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static ItemPeopleBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static ItemPeopleBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.item_people, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static ItemPeopleBinding bind(View view) {
        int i = R.id.iv_item_people;
        ImageView imageView = (ImageView) view.findViewById(R.id.iv_item_people);
        if (imageView != null) {
            i = R.id.iv_item_people_tip;
            ImageView imageView2 = (ImageView) view.findViewById(R.id.iv_item_people_tip);
            if (imageView2 != null) {
                i = R.id.tv_item_people_name;
                TextView textView = (TextView) view.findViewById(R.id.tv_item_people_name);
                if (textView != null) {
                    return new ItemPeopleBinding((ConstraintLayout) view, imageView, imageView2, textView);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
