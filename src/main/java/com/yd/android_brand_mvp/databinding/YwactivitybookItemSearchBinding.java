package com.yd.android_brand_mvp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import com.yd.android_brand_mvp.R;

/* JADX INFO: loaded from: classes4.dex */
public final class YwactivitybookItemSearchBinding implements ViewBinding {
    public final TextView booktitle;
    public final TextView clik;
    public final ImageView img;
    public final TextView msg2;
    public final TextView msg3;
    public final TextView msg4;
    private final FrameLayout rootView;

    private YwactivitybookItemSearchBinding(FrameLayout frameLayout, TextView textView, TextView textView2, ImageView imageView, TextView textView3, TextView textView4, TextView textView5) {
        this.rootView = frameLayout;
        this.booktitle = textView;
        this.clik = textView2;
        this.img = imageView;
        this.msg2 = textView3;
        this.msg3 = textView4;
        this.msg4 = textView5;
    }

    @Override // androidx.viewbinding.ViewBinding
    public FrameLayout getRoot() {
        return this.rootView;
    }

    public static YwactivitybookItemSearchBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static YwactivitybookItemSearchBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.ywactivitybook_item_search, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static YwactivitybookItemSearchBinding bind(View view) {
        int i = R.id.booktitle;
        TextView textView = (TextView) view.findViewById(R.id.booktitle);
        if (textView != null) {
            i = R.id.clik;
            TextView textView2 = (TextView) view.findViewById(R.id.clik);
            if (textView2 != null) {
                i = R.id.img;
                ImageView imageView = (ImageView) view.findViewById(R.id.img);
                if (imageView != null) {
                    i = R.id.msg2;
                    TextView textView3 = (TextView) view.findViewById(R.id.msg2);
                    if (textView3 != null) {
                        i = R.id.msg3;
                        TextView textView4 = (TextView) view.findViewById(R.id.msg3);
                        if (textView4 != null) {
                            i = R.id.msg4;
                            TextView textView5 = (TextView) view.findViewById(R.id.msg4);
                            if (textView5 != null) {
                                return new YwactivitybookItemSearchBinding((FrameLayout) view, textView, textView2, imageView, textView3, textView4, textView5);
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
