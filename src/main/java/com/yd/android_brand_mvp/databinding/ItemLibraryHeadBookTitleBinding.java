package com.yd.android_brand_mvp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckedTextView;
import android.widget.LinearLayout;
import androidx.viewbinding.ViewBinding;
import com.yd.android_brand_mvp.R;

/* JADX INFO: loaded from: classes4.dex */
public final class ItemLibraryHeadBookTitleBinding implements ViewBinding {
    public final LinearLayout llTitle;
    private final LinearLayout rootView;
    public final CheckedTextView tvTabName;

    private ItemLibraryHeadBookTitleBinding(LinearLayout linearLayout, LinearLayout linearLayout2, CheckedTextView checkedTextView) {
        this.rootView = linearLayout;
        this.llTitle = linearLayout2;
        this.tvTabName = checkedTextView;
    }

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static ItemLibraryHeadBookTitleBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static ItemLibraryHeadBookTitleBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.item_library_head_book_title, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static ItemLibraryHeadBookTitleBinding bind(View view) {
        LinearLayout linearLayout = (LinearLayout) view;
        CheckedTextView checkedTextView = (CheckedTextView) view.findViewById(R.id.tv_tab_name);
        if (checkedTextView != null) {
            return new ItemLibraryHeadBookTitleBinding(linearLayout, linearLayout, checkedTextView);
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(R.id.tv_tab_name)));
    }
}
