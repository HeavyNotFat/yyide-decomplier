package com.yd.android_brand_mvp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import com.yd.android_brand_mvp.R;

/* JADX INFO: loaded from: classes4.dex */
public final class ItemFormProcessBinding implements ViewBinding {
    public final ImageView ivOriginal;
    public final LinearLayoutCompat llOriginalProcess;
    private final ConstraintLayout rootView;
    public final RecyclerView rvDialogLeaveDetailProcess;
    public final TextView tvDialogLeaveDetailProcessTitle;

    private ItemFormProcessBinding(ConstraintLayout constraintLayout, ImageView imageView, LinearLayoutCompat linearLayoutCompat, RecyclerView recyclerView, TextView textView) {
        this.rootView = constraintLayout;
        this.ivOriginal = imageView;
        this.llOriginalProcess = linearLayoutCompat;
        this.rvDialogLeaveDetailProcess = recyclerView;
        this.tvDialogLeaveDetailProcessTitle = textView;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static ItemFormProcessBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static ItemFormProcessBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.item_form_process, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static ItemFormProcessBinding bind(View view) {
        int i = R.id.ivOriginal;
        ImageView imageView = (ImageView) view.findViewById(R.id.ivOriginal);
        if (imageView != null) {
            i = R.id.llOriginalProcess;
            LinearLayoutCompat linearLayoutCompat = (LinearLayoutCompat) view.findViewById(R.id.llOriginalProcess);
            if (linearLayoutCompat != null) {
                i = R.id.rv_dialog_leave_detail_process;
                RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.rv_dialog_leave_detail_process);
                if (recyclerView != null) {
                    i = R.id.tv_dialog_leave_detail_process_title;
                    TextView textView = (TextView) view.findViewById(R.id.tv_dialog_leave_detail_process_title);
                    if (textView != null) {
                        return new ItemFormProcessBinding((ConstraintLayout) view, imageView, linearLayoutCompat, recyclerView, textView);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
