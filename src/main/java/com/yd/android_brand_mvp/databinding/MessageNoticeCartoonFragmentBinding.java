package com.yd.android_brand_mvp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.yd.android_brand_mvp.R;
import com.yd.android_brand_mvp.weight.MultiStateView;
import com.youth.banner.Banner;

/* JADX INFO: loaded from: classes4.dex */
public final class MessageNoticeCartoonFragmentBinding implements ViewBinding {
    public final ImageView gankImageview4;
    public final TextView gankTextview4;
    public final MultiStateView mu;
    public final Banner noticeBanner;
    private final ConstraintLayout rootView;

    private MessageNoticeCartoonFragmentBinding(ConstraintLayout constraintLayout, ImageView imageView, TextView textView, MultiStateView multiStateView, Banner banner) {
        this.rootView = constraintLayout;
        this.gankImageview4 = imageView;
        this.gankTextview4 = textView;
        this.mu = multiStateView;
        this.noticeBanner = banner;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static MessageNoticeCartoonFragmentBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static MessageNoticeCartoonFragmentBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.message_notice_cartoon_fragment, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static MessageNoticeCartoonFragmentBinding bind(View view) {
        int i = R.id.gank_imageview4;
        ImageView imageView = (ImageView) view.findViewById(R.id.gank_imageview4);
        if (imageView != null) {
            i = R.id.gank_textview4;
            TextView textView = (TextView) view.findViewById(R.id.gank_textview4);
            if (textView != null) {
                i = R.id.mu;
                MultiStateView multiStateView = (MultiStateView) view.findViewById(R.id.mu);
                if (multiStateView != null) {
                    i = R.id.notice_banner;
                    Banner banner = (Banner) view.findViewById(R.id.notice_banner);
                    if (banner != null) {
                        return new MessageNoticeCartoonFragmentBinding((ConstraintLayout) view, imageView, textView, multiStateView, banner);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
