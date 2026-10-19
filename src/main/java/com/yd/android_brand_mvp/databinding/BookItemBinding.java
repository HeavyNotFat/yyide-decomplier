package com.yd.android_brand_mvp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.viewbinding.ViewBinding;
import com.yd.android_brand_mvp.R;
import com.yd.android_brand_mvp.view.RoundImageView;

/* JADX INFO: loaded from: classes4.dex */
public final class BookItemBinding implements ViewBinding {
    public final RoundImageView item;
    private final LinearLayout rootView;

    private BookItemBinding(LinearLayout linearLayout, RoundImageView roundImageView) {
        this.rootView = linearLayout;
        this.item = roundImageView;
    }

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static BookItemBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static BookItemBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.book_item, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static BookItemBinding bind(View view) {
        RoundImageView roundImageView = (RoundImageView) view.findViewById(R.id.item);
        if (roundImageView != null) {
            return new BookItemBinding((LinearLayout) view, roundImageView);
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(R.id.item)));
    }
}
