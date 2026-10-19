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
public final class ItemLibraryListBinding implements ViewBinding {
    public final ImageView ivCover;
    private final ConstraintLayout rootView;
    public final TextView tvLibraryAuthor;
    public final TextView tvLibraryLoanable;
    public final TextView tvLibraryNumber;
    public final TextView tvLibraryTip;
    public final TextView tvLibraryTitle;

    private ItemLibraryListBinding(ConstraintLayout constraintLayout, ImageView imageView, TextView textView, TextView textView2, TextView textView3, TextView textView4, TextView textView5) {
        this.rootView = constraintLayout;
        this.ivCover = imageView;
        this.tvLibraryAuthor = textView;
        this.tvLibraryLoanable = textView2;
        this.tvLibraryNumber = textView3;
        this.tvLibraryTip = textView4;
        this.tvLibraryTitle = textView5;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static ItemLibraryListBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static ItemLibraryListBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.item_library_list, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static ItemLibraryListBinding bind(View view) {
        int i = R.id.iv_cover;
        ImageView imageView = (ImageView) view.findViewById(R.id.iv_cover);
        if (imageView != null) {
            i = R.id.tv_library_author;
            TextView textView = (TextView) view.findViewById(R.id.tv_library_author);
            if (textView != null) {
                i = R.id.tv_library_loanable;
                TextView textView2 = (TextView) view.findViewById(R.id.tv_library_loanable);
                if (textView2 != null) {
                    i = R.id.tv_library_number;
                    TextView textView3 = (TextView) view.findViewById(R.id.tv_library_number);
                    if (textView3 != null) {
                        i = R.id.tv_library_tip;
                        TextView textView4 = (TextView) view.findViewById(R.id.tv_library_tip);
                        if (textView4 != null) {
                            i = R.id.tv_library_title;
                            TextView textView5 = (TextView) view.findViewById(R.id.tv_library_title);
                            if (textView5 != null) {
                                return new ItemLibraryListBinding((ConstraintLayout) view, imageView, textView, textView2, textView3, textView4, textView5);
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
