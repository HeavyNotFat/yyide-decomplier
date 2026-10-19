package com.yd.android_brand_mvp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import com.yd.android_brand_mvp.R;

/* JADX INFO: loaded from: classes4.dex */
public final class LayoutTableItemSkBinding implements ViewBinding {
    public final TextView eTime;
    public final FrameLayout flContent;
    public final ImageView ivImg;

    /* JADX INFO: renamed from: no, reason: collision with root package name */
    public final TextView f2011no;
    private final LinearLayout rootView;
    public final TextView subjectName;
    public final TextView time;

    private LayoutTableItemSkBinding(LinearLayout linearLayout, TextView textView, FrameLayout frameLayout, ImageView imageView, TextView textView2, TextView textView3, TextView textView4) {
        this.rootView = linearLayout;
        this.eTime = textView;
        this.flContent = frameLayout;
        this.ivImg = imageView;
        this.f2011no = textView2;
        this.subjectName = textView3;
        this.time = textView4;
    }

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static LayoutTableItemSkBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static LayoutTableItemSkBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.layout_table_item_sk, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static LayoutTableItemSkBinding bind(View view) {
        int i = R.id.e_time;
        TextView textView = (TextView) view.findViewById(R.id.e_time);
        if (textView != null) {
            i = R.id.fl_content;
            FrameLayout frameLayout = (FrameLayout) view.findViewById(R.id.fl_content);
            if (frameLayout != null) {
                i = R.id.iv_img;
                ImageView imageView = (ImageView) view.findViewById(R.id.iv_img);
                if (imageView != null) {
                    i = R.id.no;
                    TextView textView2 = (TextView) view.findViewById(R.id.no);
                    if (textView2 != null) {
                        i = R.id.subjectName;
                        TextView textView3 = (TextView) view.findViewById(R.id.subjectName);
                        if (textView3 != null) {
                            i = R.id.time;
                            TextView textView4 = (TextView) view.findViewById(R.id.time);
                            if (textView4 != null) {
                                return new LayoutTableItemSkBinding((LinearLayout) view, textView, frameLayout, imageView, textView2, textView3, textView4);
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
