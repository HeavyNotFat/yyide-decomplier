package com.yd.android_brand_mvp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import com.yd.android_brand_mvp.R;

/* JADX INFO: loaded from: classes4.dex */
public final class PunchCardToastErrorBinding implements ViewBinding {
    public final RelativeLayout image;
    public final ImageView ivImg;
    private final RelativeLayout rootView;
    public final TextView tvClass;
    public final TextView tvMsg;
    public final TextView tvName;
    public final TextView tvTime;

    private PunchCardToastErrorBinding(RelativeLayout relativeLayout, RelativeLayout relativeLayout2, ImageView imageView, TextView textView, TextView textView2, TextView textView3, TextView textView4) {
        this.rootView = relativeLayout;
        this.image = relativeLayout2;
        this.ivImg = imageView;
        this.tvClass = textView;
        this.tvMsg = textView2;
        this.tvName = textView3;
        this.tvTime = textView4;
    }

    @Override // androidx.viewbinding.ViewBinding
    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static PunchCardToastErrorBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static PunchCardToastErrorBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.punch_card_toast_error, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static PunchCardToastErrorBinding bind(View view) {
        int i = R.id.image;
        RelativeLayout relativeLayout = (RelativeLayout) view.findViewById(R.id.image);
        if (relativeLayout != null) {
            i = R.id.iv_img;
            ImageView imageView = (ImageView) view.findViewById(R.id.iv_img);
            if (imageView != null) {
                i = R.id.tv_class;
                TextView textView = (TextView) view.findViewById(R.id.tv_class);
                if (textView != null) {
                    i = R.id.tv_msg;
                    TextView textView2 = (TextView) view.findViewById(R.id.tv_msg);
                    if (textView2 != null) {
                        i = R.id.tv_name;
                        TextView textView3 = (TextView) view.findViewById(R.id.tv_name);
                        if (textView3 != null) {
                            i = R.id.tv_time;
                            TextView textView4 = (TextView) view.findViewById(R.id.tv_time);
                            if (textView4 != null) {
                                return new PunchCardToastErrorBinding((RelativeLayout) view, relativeLayout, imageView, textView, textView2, textView3, textView4);
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
