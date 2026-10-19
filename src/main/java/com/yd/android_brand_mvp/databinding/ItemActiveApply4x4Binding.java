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
public final class ItemActiveApply4x4Binding implements ViewBinding {
    public final ConstraintLayout clContent;
    public final ImageView ivCover;
    private final ConstraintLayout rootView;
    public final TextView tvActiveAlreadyRegisteredNumber;
    public final TextView tvActiveApplyDate;
    public final TextView tvActiveDate;
    public final TextView tvActiveObject;
    public final TextView tvActiveStatus;
    public final TextView tvActiveTitle;
    public final TextView tvActiveTotal;

    private ItemActiveApply4x4Binding(ConstraintLayout constraintLayout, ConstraintLayout constraintLayout2, ImageView imageView, TextView textView, TextView textView2, TextView textView3, TextView textView4, TextView textView5, TextView textView6, TextView textView7) {
        this.rootView = constraintLayout;
        this.clContent = constraintLayout2;
        this.ivCover = imageView;
        this.tvActiveAlreadyRegisteredNumber = textView;
        this.tvActiveApplyDate = textView2;
        this.tvActiveDate = textView3;
        this.tvActiveObject = textView4;
        this.tvActiveStatus = textView5;
        this.tvActiveTitle = textView6;
        this.tvActiveTotal = textView7;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static ItemActiveApply4x4Binding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static ItemActiveApply4x4Binding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.item_active_apply_4x4, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static ItemActiveApply4x4Binding bind(View view) {
        ConstraintLayout constraintLayout = (ConstraintLayout) view;
        ImageView imageView = (ImageView) view.findViewById(R.id.iv_cover);
        TextView textView = (TextView) view.findViewById(R.id.tv_active_already_registered_number);
        int i = R.id.tv_active_apply_date;
        TextView textView2 = (TextView) view.findViewById(R.id.tv_active_apply_date);
        if (textView2 != null) {
            i = R.id.tv_active_date;
            TextView textView3 = (TextView) view.findViewById(R.id.tv_active_date);
            if (textView3 != null) {
                i = R.id.tv_active_object;
                TextView textView4 = (TextView) view.findViewById(R.id.tv_active_object);
                if (textView4 != null) {
                    i = R.id.tv_active_status;
                    TextView textView5 = (TextView) view.findViewById(R.id.tv_active_status);
                    if (textView5 != null) {
                        i = R.id.tv_active_title;
                        TextView textView6 = (TextView) view.findViewById(R.id.tv_active_title);
                        if (textView6 != null) {
                            return new ItemActiveApply4x4Binding(constraintLayout, constraintLayout, imageView, textView, textView2, textView3, textView4, textView5, textView6, (TextView) view.findViewById(R.id.tv_active_total));
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
