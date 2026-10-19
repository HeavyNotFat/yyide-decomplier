package com.yd.android_brand_mvp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.yd.android_brand_mvp.R;

/* JADX INFO: loaded from: classes4.dex */
public final class ItemSelectExamineBinding implements ViewBinding {
    public final ConstraintLayout appItemview;
    public final CheckBox cbCheck;
    public final ImageView ivHead;
    private final ConstraintLayout rootView;
    public final TextView tvDesc;
    public final TextView tvName;
    public final View viewLine;

    private ItemSelectExamineBinding(ConstraintLayout constraintLayout, ConstraintLayout constraintLayout2, CheckBox checkBox, ImageView imageView, TextView textView, TextView textView2, View view) {
        this.rootView = constraintLayout;
        this.appItemview = constraintLayout2;
        this.cbCheck = checkBox;
        this.ivHead = imageView;
        this.tvDesc = textView;
        this.tvName = textView2;
        this.viewLine = view;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static ItemSelectExamineBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static ItemSelectExamineBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.item_select_examine, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static ItemSelectExamineBinding bind(View view) {
        ConstraintLayout constraintLayout = (ConstraintLayout) view;
        int i = R.id.cbCheck;
        CheckBox checkBox = (CheckBox) view.findViewById(R.id.cbCheck);
        if (checkBox != null) {
            i = R.id.ivHead;
            ImageView imageView = (ImageView) view.findViewById(R.id.ivHead);
            if (imageView != null) {
                i = R.id.tvDesc;
                TextView textView = (TextView) view.findViewById(R.id.tvDesc);
                if (textView != null) {
                    i = R.id.tvName;
                    TextView textView2 = (TextView) view.findViewById(R.id.tvName);
                    if (textView2 != null) {
                        i = R.id.viewLine;
                        View viewFindViewById = view.findViewById(R.id.viewLine);
                        if (viewFindViewById != null) {
                            return new ItemSelectExamineBinding(constraintLayout, constraintLayout, checkBox, imageView, textView, textView2, viewFindViewById);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
