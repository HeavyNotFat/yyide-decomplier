package com.yd.android_brand_mvp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.yd.android_brand_mvp.R;
import com.yd.android_brand_mvp.widget.YDWebView;

/* JADX INFO: loaded from: classes4.dex */
public final class ItemAnnouncementCartoonBinding implements ViewBinding {
    public final ConstraintLayout gankConstraintlayout;
    public final ImageView img;
    private final ConstraintLayout rootView;
    public final TextView textHtml;
    public final TextView tvPublishName;
    public final TextView tvPublishTime;
    public final TextView tvPublishTitle;
    public final YDWebView webview;

    private ItemAnnouncementCartoonBinding(ConstraintLayout constraintLayout, ConstraintLayout constraintLayout2, ImageView imageView, TextView textView, TextView textView2, TextView textView3, TextView textView4, YDWebView yDWebView) {
        this.rootView = constraintLayout;
        this.gankConstraintlayout = constraintLayout2;
        this.img = imageView;
        this.textHtml = textView;
        this.tvPublishName = textView2;
        this.tvPublishTime = textView3;
        this.tvPublishTitle = textView4;
        this.webview = yDWebView;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static ItemAnnouncementCartoonBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static ItemAnnouncementCartoonBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.item_announcement_cartoon, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static ItemAnnouncementCartoonBinding bind(View view) {
        int i = R.id.gank_constraintlayout;
        ConstraintLayout constraintLayout = (ConstraintLayout) view.findViewById(R.id.gank_constraintlayout);
        if (constraintLayout != null) {
            i = R.id.img;
            ImageView imageView = (ImageView) view.findViewById(R.id.img);
            if (imageView != null) {
                i = R.id.textHtml;
                TextView textView = (TextView) view.findViewById(R.id.textHtml);
                if (textView != null) {
                    i = R.id.tv_publish_name;
                    TextView textView2 = (TextView) view.findViewById(R.id.tv_publish_name);
                    if (textView2 != null) {
                        i = R.id.tv_publish_time;
                        TextView textView3 = (TextView) view.findViewById(R.id.tv_publish_time);
                        if (textView3 != null) {
                            i = R.id.tv_publish_title;
                            TextView textView4 = (TextView) view.findViewById(R.id.tv_publish_title);
                            if (textView4 != null) {
                                i = R.id.webview;
                                YDWebView yDWebView = (YDWebView) view.findViewById(R.id.webview);
                                if (yDWebView != null) {
                                    return new ItemAnnouncementCartoonBinding((ConstraintLayout) view, constraintLayout, imageView, textView, textView2, textView3, textView4, yDWebView);
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
