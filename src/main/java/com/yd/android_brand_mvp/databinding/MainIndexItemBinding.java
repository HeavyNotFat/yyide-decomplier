package com.yd.android_brand_mvp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckedTextView;
import android.widget.LinearLayout;
import androidx.viewbinding.ViewBinding;
import com.yd.android_brand_mvp.R;

/* JADX INFO: loaded from: classes4.dex */
public final class MainIndexItemBinding implements ViewBinding {
    public final CheckedTextView item;
    private final LinearLayout rootView;

    private MainIndexItemBinding(LinearLayout linearLayout, CheckedTextView checkedTextView) {
        this.rootView = linearLayout;
        this.item = checkedTextView;
    }

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static MainIndexItemBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static MainIndexItemBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.main_index_item, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static MainIndexItemBinding bind(View view) {
        CheckedTextView checkedTextView = (CheckedTextView) view.findViewById(R.id.item);
        if (checkedTextView != null) {
            return new MainIndexItemBinding((LinearLayout) view, checkedTextView);
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(R.id.item)));
    }
}
