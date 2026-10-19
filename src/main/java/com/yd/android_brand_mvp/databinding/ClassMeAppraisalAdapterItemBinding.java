package com.yd.android_brand_mvp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.yd.android_brand_mvp.R;

/* JADX INFO: loaded from: classes4.dex */
public final class ClassMeAppraisalAdapterItemBinding implements ViewBinding {
    public final EditText etRemarks;
    public final EditText etScore;
    public final ImageView ivAddScore;
    public final ImageView ivMinusScore;
    private final ConstraintLayout rootView;
    public final TextView tvAppraisalTitle;
    public final TextView tvRemarks;
    public final TextView tvScore;

    private ClassMeAppraisalAdapterItemBinding(ConstraintLayout constraintLayout, EditText editText, EditText editText2, ImageView imageView, ImageView imageView2, TextView textView, TextView textView2, TextView textView3) {
        this.rootView = constraintLayout;
        this.etRemarks = editText;
        this.etScore = editText2;
        this.ivAddScore = imageView;
        this.ivMinusScore = imageView2;
        this.tvAppraisalTitle = textView;
        this.tvRemarks = textView2;
        this.tvScore = textView3;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static ClassMeAppraisalAdapterItemBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static ClassMeAppraisalAdapterItemBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.class_me_appraisal_adapter_item, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static ClassMeAppraisalAdapterItemBinding bind(View view) {
        int i = R.id.et_remarks;
        EditText editText = (EditText) view.findViewById(R.id.et_remarks);
        if (editText != null) {
            i = R.id.et_score;
            EditText editText2 = (EditText) view.findViewById(R.id.et_score);
            if (editText2 != null) {
                i = R.id.iv_add_score;
                ImageView imageView = (ImageView) view.findViewById(R.id.iv_add_score);
                if (imageView != null) {
                    i = R.id.iv_minus_score;
                    ImageView imageView2 = (ImageView) view.findViewById(R.id.iv_minus_score);
                    if (imageView2 != null) {
                        i = R.id.tv_appraisal_title;
                        TextView textView = (TextView) view.findViewById(R.id.tv_appraisal_title);
                        if (textView != null) {
                            i = R.id.tv_remarks;
                            TextView textView2 = (TextView) view.findViewById(R.id.tv_remarks);
                            if (textView2 != null) {
                                i = R.id.tv_score;
                                TextView textView3 = (TextView) view.findViewById(R.id.tv_score);
                                if (textView3 != null) {
                                    return new ClassMeAppraisalAdapterItemBinding((ConstraintLayout) view, editText, editText2, imageView, imageView2, textView, textView2, textView3);
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
