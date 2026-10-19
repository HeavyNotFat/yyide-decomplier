package com.yd.android_brand_mvp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.viewbinding.ViewBinding;
import com.yd.android_brand_mvp.R;

/* JADX INFO: loaded from: classes4.dex */
public final class ItemLibraryFragment4x4Binding implements ViewBinding {
    public final LinearLayoutCompat clContent;
    public final ImageView ivCover;
    private final LinearLayoutCompat rootView;
    public final TextView tvLibraryTitle;

    private ItemLibraryFragment4x4Binding(LinearLayoutCompat linearLayoutCompat, LinearLayoutCompat linearLayoutCompat2, ImageView imageView, TextView textView) {
        this.rootView = linearLayoutCompat;
        this.clContent = linearLayoutCompat2;
        this.ivCover = imageView;
        this.tvLibraryTitle = textView;
    }

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayoutCompat getRoot() {
        return this.rootView;
    }

    public static ItemLibraryFragment4x4Binding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static ItemLibraryFragment4x4Binding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.item_library_fragment4x4, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static ItemLibraryFragment4x4Binding bind(View view) {
        LinearLayoutCompat linearLayoutCompat = (LinearLayoutCompat) view;
        int i = R.id.iv_cover;
        ImageView imageView = (ImageView) view.findViewById(R.id.iv_cover);
        if (imageView != null) {
            i = R.id.tv_library_title;
            TextView textView = (TextView) view.findViewById(R.id.tv_library_title);
            if (textView != null) {
                return new ItemLibraryFragment4x4Binding(linearLayoutCompat, linearLayoutCompat, imageView, textView);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
