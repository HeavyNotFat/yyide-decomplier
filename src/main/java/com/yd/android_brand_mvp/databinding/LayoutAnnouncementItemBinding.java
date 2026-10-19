package com.yd.android_brand_mvp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import com.yd.android_brand_mvp.R;

/* JADX INFO: loaded from: classes4.dex */
public final class LayoutAnnouncementItemBinding implements ViewBinding {
    public final TextView dian;
    public final LinearLayout llItem;
    public final LinearLayout llItem2;
    private final LinearLayout rootView;
    public final TextView tvTime;
    public final TextView tvTitle;

    private LayoutAnnouncementItemBinding(LinearLayout linearLayout, TextView textView, LinearLayout linearLayout2, LinearLayout linearLayout3, TextView textView2, TextView textView3) {
        this.rootView = linearLayout;
        this.dian = textView;
        this.llItem = linearLayout2;
        this.llItem2 = linearLayout3;
        this.tvTime = textView2;
        this.tvTitle = textView3;
    }

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static LayoutAnnouncementItemBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static LayoutAnnouncementItemBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.layout_announcement_item, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static LayoutAnnouncementItemBinding bind(View view) {
        int i = R.id.dian;
        TextView textView = (TextView) view.findViewById(R.id.dian);
        if (textView != null) {
            LinearLayout linearLayout = (LinearLayout) view;
            i = R.id.ll_item2;
            LinearLayout linearLayout2 = (LinearLayout) view.findViewById(R.id.ll_item2);
            if (linearLayout2 != null) {
                i = R.id.tv_time;
                TextView textView2 = (TextView) view.findViewById(R.id.tv_time);
                if (textView2 != null) {
                    i = R.id.tv_title;
                    TextView textView3 = (TextView) view.findViewById(R.id.tv_title);
                    if (textView3 != null) {
                        return new LayoutAnnouncementItemBinding(linearLayout, textView, linearLayout, linearLayout2, textView2, textView3);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
