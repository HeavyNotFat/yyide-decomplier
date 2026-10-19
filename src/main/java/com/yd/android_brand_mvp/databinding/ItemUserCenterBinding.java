package com.yd.android_brand_mvp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckedTextView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.yd.android_brand_mvp.R;

/* JADX INFO: loaded from: classes4.dex */
public final class ItemUserCenterBinding implements ViewBinding {
    public final CheckedTextView check;
    public final CheckedTextView checkImg;
    public final ConstraintLayout clTab;
    public final TextView line;
    private final ConstraintLayout rootView;
    public final TextView textView30;

    private ItemUserCenterBinding(ConstraintLayout constraintLayout, CheckedTextView checkedTextView, CheckedTextView checkedTextView2, ConstraintLayout constraintLayout2, TextView textView, TextView textView2) {
        this.rootView = constraintLayout;
        this.check = checkedTextView;
        this.checkImg = checkedTextView2;
        this.clTab = constraintLayout2;
        this.line = textView;
        this.textView30 = textView2;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static ItemUserCenterBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static ItemUserCenterBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.item_user_center, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static ItemUserCenterBinding bind(View view) {
        int i = R.id.check;
        CheckedTextView checkedTextView = (CheckedTextView) view.findViewById(R.id.check);
        if (checkedTextView != null) {
            i = R.id.checkImg;
            CheckedTextView checkedTextView2 = (CheckedTextView) view.findViewById(R.id.checkImg);
            if (checkedTextView2 != null) {
                ConstraintLayout constraintLayout = (ConstraintLayout) view;
                i = R.id.line;
                TextView textView = (TextView) view.findViewById(R.id.line);
                if (textView != null) {
                    i = R.id.textView30;
                    TextView textView2 = (TextView) view.findViewById(R.id.textView30);
                    if (textView2 != null) {
                        return new ItemUserCenterBinding(constraintLayout, checkedTextView, checkedTextView2, constraintLayout, textView, textView2);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
