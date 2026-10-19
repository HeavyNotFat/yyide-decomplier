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
public final class ItemUpImageListBinding implements ViewBinding {
    public final ImageView ivItemUpImageListLogo;
    public final ImageView ivItemUpImageListLogo2;
    public final View lineBottom;
    public final View lineCenter;
    public final View lineTop;
    private final ConstraintLayout rootView;
    public final RecyclerView rvItemTaskImageList;
    public final TextView tvItemUpImageListTitle;

    private ItemUpImageListBinding(ConstraintLayout constraintLayout, ImageView imageView, ImageView imageView2, View view, View view2, View view3, RecyclerView recyclerView, TextView textView) {
        this.rootView = constraintLayout;
        this.ivItemUpImageListLogo = imageView;
        this.ivItemUpImageListLogo2 = imageView2;
        this.lineBottom = view;
        this.lineCenter = view2;
        this.lineTop = view3;
        this.rvItemTaskImageList = recyclerView;
        this.tvItemUpImageListTitle = textView;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static ItemUpImageListBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static ItemUpImageListBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.item_up_image_list, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static ItemUpImageListBinding bind(View view) {
        int i = R.id.iv_item_upImage_list_logo;
        ImageView imageView = (ImageView) view.findViewById(R.id.iv_item_upImage_list_logo);
        if (imageView != null) {
            i = R.id.iv_item_upImage_list_logo2;
            ImageView imageView2 = (ImageView) view.findViewById(R.id.iv_item_upImage_list_logo2);
            if (imageView2 != null) {
                i = R.id.line_bottom;
                View viewFindViewById = view.findViewById(R.id.line_bottom);
                if (viewFindViewById != null) {
                    i = R.id.line_center;
                    View viewFindViewById2 = view.findViewById(R.id.line_center);
                    if (viewFindViewById2 != null) {
                        i = R.id.line_top;
                        View viewFindViewById3 = view.findViewById(R.id.line_top);
                        if (viewFindViewById3 != null) {
                            i = R.id.rv_item_task_image_list;
                            RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.rv_item_task_image_list);
                            if (recyclerView != null) {
                                i = R.id.tv_item_upImage_list_title;
                                TextView textView = (TextView) view.findViewById(R.id.tv_item_upImage_list_title);
                                if (textView != null) {
                                    return new ItemUpImageListBinding((ConstraintLayout) view, imageView, imageView2, viewFindViewById, viewFindViewById2, viewFindViewById3, recyclerView, textView);
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
