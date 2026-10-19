package com.yd.android_brand_mvp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import com.yd.android_brand_mvp.R;
import com.yd.android_brand_mvp.widget.YDWebView;

/* JADX INFO: loaded from: classes4.dex */
public final class FragmentSchoolInfo1PBinding implements ViewBinding {
    public final GridView grid;
    public final ImageView img;
    private final FrameLayout rootView;
    public final TextView schoolName;
    public final TextView tvSname;
    public final TextView tvTime;
    public final YDWebView webview;

    private FragmentSchoolInfo1PBinding(FrameLayout frameLayout, GridView gridView, ImageView imageView, TextView textView, TextView textView2, TextView textView3, YDWebView yDWebView) {
        this.rootView = frameLayout;
        this.grid = gridView;
        this.img = imageView;
        this.schoolName = textView;
        this.tvSname = textView2;
        this.tvTime = textView3;
        this.webview = yDWebView;
    }

    @Override // androidx.viewbinding.ViewBinding
    public FrameLayout getRoot() {
        return this.rootView;
    }

    public static FragmentSchoolInfo1PBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static FragmentSchoolInfo1PBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.fragment_school_info1_p, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static FragmentSchoolInfo1PBinding bind(View view) {
        int i = R.id.grid;
        GridView gridView = (GridView) view.findViewById(R.id.grid);
        if (gridView != null) {
            i = R.id.img;
            ImageView imageView = (ImageView) view.findViewById(R.id.img);
            if (imageView != null) {
                i = R.id.school_name;
                TextView textView = (TextView) view.findViewById(R.id.school_name);
                if (textView != null) {
                    i = R.id.tv_sname;
                    TextView textView2 = (TextView) view.findViewById(R.id.tv_sname);
                    if (textView2 != null) {
                        i = R.id.tv_time;
                        TextView textView3 = (TextView) view.findViewById(R.id.tv_time);
                        if (textView3 != null) {
                            i = R.id.webview;
                            YDWebView yDWebView = (YDWebView) view.findViewById(R.id.webview);
                            if (yDWebView != null) {
                                return new FragmentSchoolInfo1PBinding((FrameLayout) view, gridView, imageView, textView, textView2, textView3, yDWebView);
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
