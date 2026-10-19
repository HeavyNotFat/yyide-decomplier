package com.yd.android_brand_mvp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import com.yd.android_brand_mvp.R;

/* JADX INFO: loaded from: classes4.dex */
public final class AddressBookItemLayoutBinding implements ViewBinding {
    public final ImageView itemIconImg;
    public final TextView itemNameTv;
    public final ConstraintLayout itemView;
    public final RecyclerView recyclerViewLabs;
    private final ConstraintLayout rootView;

    private AddressBookItemLayoutBinding(ConstraintLayout constraintLayout, ImageView imageView, TextView textView, ConstraintLayout constraintLayout2, RecyclerView recyclerView) {
        this.rootView = constraintLayout;
        this.itemIconImg = imageView;
        this.itemNameTv = textView;
        this.itemView = constraintLayout2;
        this.recyclerViewLabs = recyclerView;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static AddressBookItemLayoutBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static AddressBookItemLayoutBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.address_book_item_layout, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static AddressBookItemLayoutBinding bind(View view) {
        int i = R.id.item_icon_img;
        ImageView imageView = (ImageView) view.findViewById(R.id.item_icon_img);
        if (imageView != null) {
            i = R.id.item_name_tv;
            TextView textView = (TextView) view.findViewById(R.id.item_name_tv);
            if (textView != null) {
                ConstraintLayout constraintLayout = (ConstraintLayout) view;
                i = R.id.recyclerViewLabs;
                RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.recyclerViewLabs);
                if (recyclerView != null) {
                    return new AddressBookItemLayoutBinding(constraintLayout, imageView, textView, constraintLayout, recyclerView);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
