package com.yd.android_brand_mvp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.yd.android_brand_mvp.R;
import com.yd.android_brand_mvp.view.TagTextView;

/* JADX INFO: loaded from: classes4.dex */
public final class ItemPunch23FragmentBinding implements ViewBinding {
    public final ImageView gankImageview5;
    private final ConstraintLayout rootView;
    public final TextView title;
    public final TagTextView tvItemPunchDesc;
    public final TextView tvItemPunchEndTime;

    private ItemPunch23FragmentBinding(ConstraintLayout constraintLayout, ImageView imageView, TextView textView, TagTextView tagTextView, TextView textView2) {
        this.rootView = constraintLayout;
        this.gankImageview5 = imageView;
        this.title = textView;
        this.tvItemPunchDesc = tagTextView;
        this.tvItemPunchEndTime = textView2;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static ItemPunch23FragmentBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static ItemPunch23FragmentBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.item_punch23_fragment, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static ItemPunch23FragmentBinding bind(View view) {
        int i = R.id.gank_imageview5;
        ImageView imageView = (ImageView) view.findViewById(R.id.gank_imageview5);
        if (imageView != null) {
            i = R.id.title;
            TextView textView = (TextView) view.findViewById(R.id.title);
            if (textView != null) {
                i = R.id.tv_item_punch_desc;
                TagTextView tagTextView = (TagTextView) view.findViewById(R.id.tv_item_punch_desc);
                if (tagTextView != null) {
                    i = R.id.tv_item_punch_endTime;
                    TextView textView2 = (TextView) view.findViewById(R.id.tv_item_punch_endTime);
                    if (textView2 != null) {
                        return new ItemPunch23FragmentBinding((ConstraintLayout) view, imageView, textView, tagTextView, textView2);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
