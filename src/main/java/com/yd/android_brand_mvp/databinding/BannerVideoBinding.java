package com.yd.android_brand_mvp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.yd.android_brand_mvp.R;
import com.yd.android_brand_mvp.banner.manager.YDVideo;

/* JADX INFO: loaded from: classes4.dex */
public final class BannerVideoBinding implements ViewBinding {
    public final CheckBox check;
    public final YDVideo player;
    private final ConstraintLayout rootView;
    public final TextView tm;

    private BannerVideoBinding(ConstraintLayout constraintLayout, CheckBox checkBox, YDVideo yDVideo, TextView textView) {
        this.rootView = constraintLayout;
        this.check = checkBox;
        this.player = yDVideo;
        this.tm = textView;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static BannerVideoBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static BannerVideoBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.banner_video, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static BannerVideoBinding bind(View view) {
        int i = R.id.check;
        CheckBox checkBox = (CheckBox) view.findViewById(R.id.check);
        if (checkBox != null) {
            i = R.id.player;
            YDVideo yDVideo = (YDVideo) view.findViewById(R.id.player);
            if (yDVideo != null) {
                i = R.id.tm;
                TextView textView = (TextView) view.findViewById(R.id.tm);
                if (textView != null) {
                    return new BannerVideoBinding((ConstraintLayout) view, checkBox, yDVideo, textView);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
