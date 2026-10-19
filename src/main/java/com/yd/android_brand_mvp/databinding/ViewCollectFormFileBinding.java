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
public final class ViewCollectFormFileBinding implements ViewBinding {
    public final ConstraintLayout clViewCollectForFileUp;
    public final ImageView ivItemFormFile;
    private final ConstraintLayout rootView;
    public final RecyclerView rvViewCollectFormFile;
    public final TextView tvItemFormFileName;
    public final TextView tvViewCollectFormFileName;
    public final TextView tvViewCollectFormFileRequired;

    private ViewCollectFormFileBinding(ConstraintLayout constraintLayout, ConstraintLayout constraintLayout2, ImageView imageView, RecyclerView recyclerView, TextView textView, TextView textView2, TextView textView3) {
        this.rootView = constraintLayout;
        this.clViewCollectForFileUp = constraintLayout2;
        this.ivItemFormFile = imageView;
        this.rvViewCollectFormFile = recyclerView;
        this.tvItemFormFileName = textView;
        this.tvViewCollectFormFileName = textView2;
        this.tvViewCollectFormFileRequired = textView3;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static ViewCollectFormFileBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static ViewCollectFormFileBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.view_collect_form_file, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static ViewCollectFormFileBinding bind(View view) {
        int i = R.id.cl_view_collect_for_file_up;
        ConstraintLayout constraintLayout = (ConstraintLayout) view.findViewById(R.id.cl_view_collect_for_file_up);
        if (constraintLayout != null) {
            i = R.id.iv_item_form_file;
            ImageView imageView = (ImageView) view.findViewById(R.id.iv_item_form_file);
            if (imageView != null) {
                i = R.id.rv_view_collect_form_file;
                RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.rv_view_collect_form_file);
                if (recyclerView != null) {
                    i = R.id.tv_item_form_file_name;
                    TextView textView = (TextView) view.findViewById(R.id.tv_item_form_file_name);
                    if (textView != null) {
                        i = R.id.tv_view_collect_form_file_name;
                        TextView textView2 = (TextView) view.findViewById(R.id.tv_view_collect_form_file_name);
                        if (textView2 != null) {
                            i = R.id.tv_view_collect_form_file_required;
                            TextView textView3 = (TextView) view.findViewById(R.id.tv_view_collect_form_file_required);
                            if (textView3 != null) {
                                return new ViewCollectFormFileBinding((ConstraintLayout) view, constraintLayout, imageView, recyclerView, textView, textView2, textView3);
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
