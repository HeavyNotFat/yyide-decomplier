package com.yd.android_brand_mvp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Group;
import androidx.viewbinding.ViewBinding;
import com.yd.android_brand_mvp.R;

/* JADX INFO: loaded from: classes4.dex */
public final class ViewCollectFormSignBinding implements ViewBinding {
    public final ConstraintLayout clViewCollectFormSign;
    public final Group groupViewCollectFormSign;
    public final ImageView ivViewCollectFormSign;
    public final ImageView ivViewCollectFormSignDelete;
    private final ConstraintLayout rootView;
    public final TextView tvViewCollectFormSign;
    public final TextView tvViewCollectFormSignName;
    public final TextView tvViewCollectFormSignRequired;

    private ViewCollectFormSignBinding(ConstraintLayout constraintLayout, ConstraintLayout constraintLayout2, Group group, ImageView imageView, ImageView imageView2, TextView textView, TextView textView2, TextView textView3) {
        this.rootView = constraintLayout;
        this.clViewCollectFormSign = constraintLayout2;
        this.groupViewCollectFormSign = group;
        this.ivViewCollectFormSign = imageView;
        this.ivViewCollectFormSignDelete = imageView2;
        this.tvViewCollectFormSign = textView;
        this.tvViewCollectFormSignName = textView2;
        this.tvViewCollectFormSignRequired = textView3;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static ViewCollectFormSignBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static ViewCollectFormSignBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.view_collect_form_sign, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static ViewCollectFormSignBinding bind(View view) {
        int i = R.id.cl_view_collect_form_sign;
        ConstraintLayout constraintLayout = (ConstraintLayout) view.findViewById(R.id.cl_view_collect_form_sign);
        if (constraintLayout != null) {
            i = R.id.group_view_collect_form_sign;
            Group group = (Group) view.findViewById(R.id.group_view_collect_form_sign);
            if (group != null) {
                i = R.id.iv_view_collect_form_sign;
                ImageView imageView = (ImageView) view.findViewById(R.id.iv_view_collect_form_sign);
                if (imageView != null) {
                    i = R.id.iv_view_collect_form_sign_delete;
                    ImageView imageView2 = (ImageView) view.findViewById(R.id.iv_view_collect_form_sign_delete);
                    if (imageView2 != null) {
                        i = R.id.tv_view_collect_form_sign;
                        TextView textView = (TextView) view.findViewById(R.id.tv_view_collect_form_sign);
                        if (textView != null) {
                            i = R.id.tv_view_collect_form_sign_name;
                            TextView textView2 = (TextView) view.findViewById(R.id.tv_view_collect_form_sign_name);
                            if (textView2 != null) {
                                i = R.id.tv_view_collect_form_sign_required;
                                TextView textView3 = (TextView) view.findViewById(R.id.tv_view_collect_form_sign_required);
                                if (textView3 != null) {
                                    return new ViewCollectFormSignBinding((ConstraintLayout) view, constraintLayout, group, imageView, imageView2, textView, textView2, textView3);
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
