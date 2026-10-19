package com.yd.android_brand_mvp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import com.yd.android_brand_mvp.R;
import com.yd.android_brand_mvp.landscape.video.SampleCoverVideo;
import com.yd.android_brand_mvp.widget.YDWebView;

/* JADX INFO: loaded from: classes4.dex */
public final class ItemBannerCustomBinding implements ViewBinding {
    public final ImageView ivBk;
    public final ImageView ivItemBannerCustom;
    public final ImageView ivSchoolLogo;
    public final LinearLayout linearLayout;
    public final RecyclerView recyclerView;
    private final ConstraintLayout rootView;
    public final TextView tvSchoolName;
    public final TextView tvText;
    public final SampleCoverVideo videoItemPlayer;
    public final YDWebView wvItemBannerCustom;

    private ItemBannerCustomBinding(ConstraintLayout constraintLayout, ImageView imageView, ImageView imageView2, ImageView imageView3, LinearLayout linearLayout, RecyclerView recyclerView, TextView textView, TextView textView2, SampleCoverVideo sampleCoverVideo, YDWebView yDWebView) {
        this.rootView = constraintLayout;
        this.ivBk = imageView;
        this.ivItemBannerCustom = imageView2;
        this.ivSchoolLogo = imageView3;
        this.linearLayout = linearLayout;
        this.recyclerView = recyclerView;
        this.tvSchoolName = textView;
        this.tvText = textView2;
        this.videoItemPlayer = sampleCoverVideo;
        this.wvItemBannerCustom = yDWebView;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static ItemBannerCustomBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static ItemBannerCustomBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.item_banner_custom, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static ItemBannerCustomBinding bind(View view) {
        int i = R.id.ivBk;
        ImageView imageView = (ImageView) view.findViewById(R.id.ivBk);
        if (imageView != null) {
            i = R.id.iv_item_banner_custom;
            ImageView imageView2 = (ImageView) view.findViewById(R.id.iv_item_banner_custom);
            if (imageView2 != null) {
                i = R.id.ivSchoolLogo;
                ImageView imageView3 = (ImageView) view.findViewById(R.id.ivSchoolLogo);
                if (imageView3 != null) {
                    i = R.id.linearLayout;
                    LinearLayout linearLayout = (LinearLayout) view.findViewById(R.id.linearLayout);
                    if (linearLayout != null) {
                        i = R.id.recyclerView;
                        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.recyclerView);
                        if (recyclerView != null) {
                            i = R.id.tvSchoolName;
                            TextView textView = (TextView) view.findViewById(R.id.tvSchoolName);
                            if (textView != null) {
                                i = R.id.tv_text;
                                TextView textView2 = (TextView) view.findViewById(R.id.tv_text);
                                if (textView2 != null) {
                                    i = R.id.video_item_player;
                                    SampleCoverVideo sampleCoverVideo = (SampleCoverVideo) view.findViewById(R.id.video_item_player);
                                    if (sampleCoverVideo != null) {
                                        i = R.id.wv_item_banner_custom;
                                        YDWebView yDWebView = (YDWebView) view.findViewById(R.id.wv_item_banner_custom);
                                        if (yDWebView != null) {
                                            return new ItemBannerCustomBinding((ConstraintLayout) view, imageView, imageView2, imageView3, linearLayout, recyclerView, textView, textView2, sampleCoverVideo, yDWebView);
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
