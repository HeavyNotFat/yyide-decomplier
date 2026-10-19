package com.yd.android_brand_mvp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import com.yd.android_brand_mvp.R;

/* JADX INFO: loaded from: classes4.dex */
public final class YwbookItemBinding implements ViewBinding {
    public final TextView bookname;
    public final TextView bookname2;
    public final TextView booktitle;
    public final ImageView img;
    private final FrameLayout rootView;

    private YwbookItemBinding(FrameLayout frameLayout, TextView textView, TextView textView2, TextView textView3, ImageView imageView) {
        this.rootView = frameLayout;
        this.bookname = textView;
        this.bookname2 = textView2;
        this.booktitle = textView3;
        this.img = imageView;
    }

    @Override // androidx.viewbinding.ViewBinding
    public FrameLayout getRoot() {
        return this.rootView;
    }

    public static YwbookItemBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static YwbookItemBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.ywbook_item, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static YwbookItemBinding bind(View view) {
        int i = R.id.bookname;
        TextView textView = (TextView) view.findViewById(R.id.bookname);
        if (textView != null) {
            i = R.id.bookname2;
            TextView textView2 = (TextView) view.findViewById(R.id.bookname2);
            if (textView2 != null) {
                i = R.id.booktitle;
                TextView textView3 = (TextView) view.findViewById(R.id.booktitle);
                if (textView3 != null) {
                    i = R.id.img;
                    ImageView imageView = (ImageView) view.findViewById(R.id.img);
                    if (imageView != null) {
                        return new YwbookItemBinding((FrameLayout) view, textView, textView2, textView3, imageView);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
