package com.yd.android_brand_mvp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import com.yd.android_brand_mvp.R;

/* JADX INFO: loaded from: classes4.dex */
public final class PhotoAlbumItemBinding implements ViewBinding {
    public final ImageView idImg;
    private final LinearLayout rootView;
    public final TextView tvCount;
    public final TextView tvLab;

    private PhotoAlbumItemBinding(LinearLayout linearLayout, ImageView imageView, TextView textView, TextView textView2) {
        this.rootView = linearLayout;
        this.idImg = imageView;
        this.tvCount = textView;
        this.tvLab = textView2;
    }

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static PhotoAlbumItemBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static PhotoAlbumItemBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.photo_album_item, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static PhotoAlbumItemBinding bind(View view) {
        int i = R.id.id_img;
        ImageView imageView = (ImageView) view.findViewById(R.id.id_img);
        if (imageView != null) {
            i = R.id.tv_count;
            TextView textView = (TextView) view.findViewById(R.id.tv_count);
            if (textView != null) {
                i = R.id.tv_lab;
                TextView textView2 = (TextView) view.findViewById(R.id.tv_lab);
                if (textView2 != null) {
                    return new PhotoAlbumItemBinding((LinearLayout) view, imageView, textView, textView2);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
