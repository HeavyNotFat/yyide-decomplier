package com.yd.android_brand_mvp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import com.yd.android_brand_mvp.R;

/* JADX INFO: loaded from: classes4.dex */
public final class ViewCollectFormImageBinding implements ViewBinding {
    private final ConstraintLayout rootView;
    public final RecyclerView rvViewCollectFormImage;
    public final TextView tvViewCollectFormImageName;
    public final TextView tvViewCollectFormImageRequired;

    private ViewCollectFormImageBinding(ConstraintLayout constraintLayout, RecyclerView recyclerView, TextView textView, TextView textView2) {
        this.rootView = constraintLayout;
        this.rvViewCollectFormImage = recyclerView;
        this.tvViewCollectFormImageName = textView;
        this.tvViewCollectFormImageRequired = textView2;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static ViewCollectFormImageBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static ViewCollectFormImageBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.view_collect_form_image, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static ViewCollectFormImageBinding bind(View view) {
        int i = R.id.rv_view_collect_form_image;
        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.rv_view_collect_form_image);
        if (recyclerView != null) {
            i = R.id.tv_view_collect_form_image_name;
            TextView textView = (TextView) view.findViewById(R.id.tv_view_collect_form_image_name);
            if (textView != null) {
                i = R.id.tv_view_collect_form_image_required;
                TextView textView2 = (TextView) view.findViewById(R.id.tv_view_collect_form_image_required);
                if (textView2 != null) {
                    return new ViewCollectFormImageBinding((ConstraintLayout) view, recyclerView, textView, textView2);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
