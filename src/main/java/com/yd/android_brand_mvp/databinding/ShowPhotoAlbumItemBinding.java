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
public final class ShowPhotoAlbumItemBinding implements ViewBinding {
    public final ImageView idImg;
    private final LinearLayout rootView;
    public final TextView tvLab;

    private ShowPhotoAlbumItemBinding(LinearLayout linearLayout, ImageView imageView, TextView textView) {
        this.rootView = linearLayout;
        this.idImg = imageView;
        this.tvLab = textView;
    }

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static ShowPhotoAlbumItemBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static ShowPhotoAlbumItemBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.show_photo_album_item, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static ShowPhotoAlbumItemBinding bind(View view) {
        int i = R.id.id_img;
        ImageView imageView = (ImageView) view.findViewById(R.id.id_img);
        if (imageView != null) {
            i = R.id.tv_lab;
            TextView textView = (TextView) view.findViewById(R.id.tv_lab);
            if (textView != null) {
                return new ShowPhotoAlbumItemBinding((LinearLayout) view, imageView, textView);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
