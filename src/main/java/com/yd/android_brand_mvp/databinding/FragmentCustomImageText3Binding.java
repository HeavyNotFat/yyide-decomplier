package com.yd.android_brand_mvp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.yd.android_brand_mvp.R;
import com.youth.banner.Banner;

/* JADX INFO: loaded from: classes4.dex */
public final class FragmentCustomImageText3Binding implements ViewBinding {
    public final Banner bannerFragmentCustomImageText;
    public final ConstraintLayout clFragmentCustomImageText3;
    private final ConstraintLayout rootView;
    public final LayoutHeadTitle2Binding topFragmentTitle;
    public final TextView tvFragmentCustomImageTextDesc;

    private FragmentCustomImageText3Binding(ConstraintLayout constraintLayout, Banner banner, ConstraintLayout constraintLayout2, LayoutHeadTitle2Binding layoutHeadTitle2Binding, TextView textView) {
        this.rootView = constraintLayout;
        this.bannerFragmentCustomImageText = banner;
        this.clFragmentCustomImageText3 = constraintLayout2;
        this.topFragmentTitle = layoutHeadTitle2Binding;
        this.tvFragmentCustomImageTextDesc = textView;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static FragmentCustomImageText3Binding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static FragmentCustomImageText3Binding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.fragment_custom_image_text3, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static FragmentCustomImageText3Binding bind(View view) {
        int i = R.id.banner_fragment_custom_image_text;
        Banner banner = (Banner) view.findViewById(R.id.banner_fragment_custom_image_text);
        if (banner != null) {
            ConstraintLayout constraintLayout = (ConstraintLayout) view;
            i = R.id.top_fragment_title;
            View viewFindViewById = view.findViewById(R.id.top_fragment_title);
            if (viewFindViewById != null) {
                LayoutHeadTitle2Binding layoutHeadTitle2BindingBind = LayoutHeadTitle2Binding.bind(viewFindViewById);
                i = R.id.tv_fragment_custom_image_text_desc;
                TextView textView = (TextView) view.findViewById(R.id.tv_fragment_custom_image_text_desc);
                if (textView != null) {
                    return new FragmentCustomImageText3Binding(constraintLayout, banner, constraintLayout, layoutHeadTitle2BindingBind, textView);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
