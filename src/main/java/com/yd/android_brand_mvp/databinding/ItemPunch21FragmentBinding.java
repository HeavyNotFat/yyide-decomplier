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
public final class ItemPunch21FragmentBinding implements ViewBinding {
    public final LayoutHeadTitleBinding gankInclude;
    public final ImageView ivItemPunchLogo;
    private final ConstraintLayout rootView;
    public final TagTextView tvItemPunchDesc;
    public final TextView tvItemPunchEndTime;

    private ItemPunch21FragmentBinding(ConstraintLayout constraintLayout, LayoutHeadTitleBinding layoutHeadTitleBinding, ImageView imageView, TagTextView tagTextView, TextView textView) {
        this.rootView = constraintLayout;
        this.gankInclude = layoutHeadTitleBinding;
        this.ivItemPunchLogo = imageView;
        this.tvItemPunchDesc = tagTextView;
        this.tvItemPunchEndTime = textView;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static ItemPunch21FragmentBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static ItemPunch21FragmentBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.item_punch21_fragment, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static ItemPunch21FragmentBinding bind(View view) {
        int i = R.id.gank_include;
        View viewFindViewById = view.findViewById(R.id.gank_include);
        if (viewFindViewById != null) {
            LayoutHeadTitleBinding layoutHeadTitleBindingBind = LayoutHeadTitleBinding.bind(viewFindViewById);
            i = R.id.iv_item_punch_logo;
            ImageView imageView = (ImageView) view.findViewById(R.id.iv_item_punch_logo);
            if (imageView != null) {
                i = R.id.tv_item_punch_desc;
                TagTextView tagTextView = (TagTextView) view.findViewById(R.id.tv_item_punch_desc);
                if (tagTextView != null) {
                    i = R.id.tv_item_punch_endTime;
                    TextView textView = (TextView) view.findViewById(R.id.tv_item_punch_endTime);
                    if (textView != null) {
                        return new ItemPunch21FragmentBinding((ConstraintLayout) view, layoutHeadTitleBindingBind, imageView, tagTextView, textView);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
