package com.yd.android_brand_mvp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.GridView;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import com.yd.android_brand_mvp.R;

/* JADX INFO: loaded from: classes4.dex */
public final class LayoutDialogWeatherBinding implements ViewBinding {
    public final TextView close;
    public final GridView grid;
    public final TextView info;
    private final FrameLayout rootView;
    public final TextView wd;

    private LayoutDialogWeatherBinding(FrameLayout frameLayout, TextView textView, GridView gridView, TextView textView2, TextView textView3) {
        this.rootView = frameLayout;
        this.close = textView;
        this.grid = gridView;
        this.info = textView2;
        this.wd = textView3;
    }

    @Override // androidx.viewbinding.ViewBinding
    public FrameLayout getRoot() {
        return this.rootView;
    }

    public static LayoutDialogWeatherBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static LayoutDialogWeatherBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.layout_dialog_weather, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static LayoutDialogWeatherBinding bind(View view) {
        int i = R.id.close;
        TextView textView = (TextView) view.findViewById(R.id.close);
        if (textView != null) {
            i = R.id.grid;
            GridView gridView = (GridView) view.findViewById(R.id.grid);
            if (gridView != null) {
                i = R.id.info;
                TextView textView2 = (TextView) view.findViewById(R.id.info);
                if (textView2 != null) {
                    i = R.id.wd;
                    TextView textView3 = (TextView) view.findViewById(R.id.wd);
                    if (textView3 != null) {
                        return new LayoutDialogWeatherBinding((FrameLayout) view, textView, gridView, textView2, textView3);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
