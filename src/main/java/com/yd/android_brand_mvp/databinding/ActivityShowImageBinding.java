package com.yd.android_brand_mvp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import com.to.aboomy.pager2banner.Banner;
import com.yd.android_brand_mvp.R;

/* JADX INFO: loaded from: classes4.dex */
public final class ActivityShowImageBinding implements ViewBinding {
    public final Banner banner;
    private final RelativeLayout rootView;
    public final TextView tvIndex;

    private ActivityShowImageBinding(RelativeLayout relativeLayout, Banner banner, TextView textView) {
        this.rootView = relativeLayout;
        this.banner = banner;
        this.tvIndex = textView;
    }

    @Override // androidx.viewbinding.ViewBinding
    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static ActivityShowImageBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static ActivityShowImageBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.activity_show_image, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static ActivityShowImageBinding bind(View view) {
        int i = R.id.banner;
        Banner banner = (Banner) view.findViewById(R.id.banner);
        if (banner != null) {
            i = R.id.tv_index;
            TextView textView = (TextView) view.findViewById(R.id.tv_index);
            if (textView != null) {
                return new ActivityShowImageBinding((RelativeLayout) view, banner, textView);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
