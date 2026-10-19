package com.yd.android_brand_mvp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import com.paradoxie.autoscrolltextview.VerticalTextview;
import com.yd.android_brand_mvp.R;
import com.yd.android_brand_mvp.widget.YDViewPager;

/* JADX INFO: loaded from: classes4.dex */
public final class ActivityMainPBinding implements ViewBinding {
    public final ImageView bg;
    public final TextView downloadMsg;
    public final FrameLayout flContent;
    public final ImageView imgSet;
    public final LinearLayout layoutSetting;
    public final TextView lock;
    public final YDViewPager pager;
    public final RecyclerView recyleview;
    private final FrameLayout rootView;
    public final VerticalTextview text;
    public final FrameLayout topHint;
    public final TextView vsname;
    public final ImageView xx;

    private ActivityMainPBinding(FrameLayout frameLayout, ImageView imageView, TextView textView, FrameLayout frameLayout2, ImageView imageView2, LinearLayout linearLayout, TextView textView2, YDViewPager yDViewPager, RecyclerView recyclerView, VerticalTextview verticalTextview, FrameLayout frameLayout3, TextView textView3, ImageView imageView3) {
        this.rootView = frameLayout;
        this.bg = imageView;
        this.downloadMsg = textView;
        this.flContent = frameLayout2;
        this.imgSet = imageView2;
        this.layoutSetting = linearLayout;
        this.lock = textView2;
        this.pager = yDViewPager;
        this.recyleview = recyclerView;
        this.text = verticalTextview;
        this.topHint = frameLayout3;
        this.vsname = textView3;
        this.xx = imageView3;
    }

    @Override // androidx.viewbinding.ViewBinding
    public FrameLayout getRoot() {
        return this.rootView;
    }

    public static ActivityMainPBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static ActivityMainPBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.activity_main_p, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static ActivityMainPBinding bind(View view) {
        int i = R.id.bg;
        ImageView imageView = (ImageView) view.findViewById(R.id.bg);
        if (imageView != null) {
            i = R.id.download_msg;
            TextView textView = (TextView) view.findViewById(R.id.download_msg);
            if (textView != null) {
                i = R.id.flContent;
                FrameLayout frameLayout = (FrameLayout) view.findViewById(R.id.flContent);
                if (frameLayout != null) {
                    i = R.id.img_set;
                    ImageView imageView2 = (ImageView) view.findViewById(R.id.img_set);
                    if (imageView2 != null) {
                        i = R.id.layout_setting;
                        LinearLayout linearLayout = (LinearLayout) view.findViewById(R.id.layout_setting);
                        if (linearLayout != null) {
                            i = R.id.lock;
                            TextView textView2 = (TextView) view.findViewById(R.id.lock);
                            if (textView2 != null) {
                                i = R.id.pager;
                                YDViewPager yDViewPager = (YDViewPager) view.findViewById(R.id.pager);
                                if (yDViewPager != null) {
                                    i = R.id.recyleview;
                                    RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.recyleview);
                                    if (recyclerView != null) {
                                        i = R.id.text;
                                        VerticalTextview verticalTextview = (VerticalTextview) view.findViewById(R.id.text);
                                        if (verticalTextview != null) {
                                            i = R.id.top_hint;
                                            FrameLayout frameLayout2 = (FrameLayout) view.findViewById(R.id.top_hint);
                                            if (frameLayout2 != null) {
                                                i = R.id.vsname;
                                                TextView textView3 = (TextView) view.findViewById(R.id.vsname);
                                                if (textView3 != null) {
                                                    i = R.id.xx;
                                                    ImageView imageView3 = (ImageView) view.findViewById(R.id.xx);
                                                    if (imageView3 != null) {
                                                        return new ActivityMainPBinding((FrameLayout) view, imageView, textView, frameLayout, imageView2, linearLayout, textView2, yDViewPager, recyclerView, verticalTextview, frameLayout2, textView3, imageView3);
                                                    }
                                                }
                                            }
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
