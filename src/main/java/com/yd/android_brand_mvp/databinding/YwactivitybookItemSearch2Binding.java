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
public final class YwactivitybookItemSearch2Binding implements ViewBinding {
    public final TextView bookname;
    public final TextView bookname2;
    public final TextView booktitle;
    public final TextView clik;
    public final ImageView img;
    public final TextView msg2;
    public final TextView msg3;
    public final TextView msg4;
    private final FrameLayout rootView;

    private YwactivitybookItemSearch2Binding(FrameLayout frameLayout, TextView textView, TextView textView2, TextView textView3, TextView textView4, ImageView imageView, TextView textView5, TextView textView6, TextView textView7) {
        this.rootView = frameLayout;
        this.bookname = textView;
        this.bookname2 = textView2;
        this.booktitle = textView3;
        this.clik = textView4;
        this.img = imageView;
        this.msg2 = textView5;
        this.msg3 = textView6;
        this.msg4 = textView7;
    }

    @Override // androidx.viewbinding.ViewBinding
    public FrameLayout getRoot() {
        return this.rootView;
    }

    public static YwactivitybookItemSearch2Binding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static YwactivitybookItemSearch2Binding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.ywactivitybook_item_search2, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static YwactivitybookItemSearch2Binding bind(View view) {
        int i = R.id.bookname;
        TextView textView = (TextView) view.findViewById(R.id.bookname);
        if (textView != null) {
            i = R.id.bookname2;
            TextView textView2 = (TextView) view.findViewById(R.id.bookname2);
            if (textView2 != null) {
                i = R.id.booktitle;
                TextView textView3 = (TextView) view.findViewById(R.id.booktitle);
                if (textView3 != null) {
                    i = R.id.clik;
                    TextView textView4 = (TextView) view.findViewById(R.id.clik);
                    if (textView4 != null) {
                        i = R.id.img;
                        ImageView imageView = (ImageView) view.findViewById(R.id.img);
                        if (imageView != null) {
                            i = R.id.msg2;
                            TextView textView5 = (TextView) view.findViewById(R.id.msg2);
                            if (textView5 != null) {
                                i = R.id.msg3;
                                TextView textView6 = (TextView) view.findViewById(R.id.msg3);
                                if (textView6 != null) {
                                    i = R.id.msg4;
                                    TextView textView7 = (TextView) view.findViewById(R.id.msg4);
                                    if (textView7 != null) {
                                        return new YwactivitybookItemSearch2Binding((FrameLayout) view, textView, textView2, textView3, textView4, imageView, textView5, textView6, textView7);
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
