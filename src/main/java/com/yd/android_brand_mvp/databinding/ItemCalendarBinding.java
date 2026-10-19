package com.yd.android_brand_mvp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import com.yd.android_brand_mvp.R;

/* JADX INFO: loaded from: classes4.dex */
public final class ItemCalendarBinding implements ViewBinding {
    public final TextView flag;
    public final LinearLayout llContent;
    private final LinearLayout rootView;
    public final TextView tvItem;
    public final TextView tvLunar;

    private ItemCalendarBinding(LinearLayout linearLayout, TextView textView, LinearLayout linearLayout2, TextView textView2, TextView textView3) {
        this.rootView = linearLayout;
        this.flag = textView;
        this.llContent = linearLayout2;
        this.tvItem = textView2;
        this.tvLunar = textView3;
    }

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static ItemCalendarBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static ItemCalendarBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.item_calendar, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static ItemCalendarBinding bind(View view) {
        int i = R.id.flag;
        TextView textView = (TextView) view.findViewById(R.id.flag);
        if (textView != null) {
            i = R.id.ll_content;
            LinearLayout linearLayout = (LinearLayout) view.findViewById(R.id.ll_content);
            if (linearLayout != null) {
                i = R.id.tv_item;
                TextView textView2 = (TextView) view.findViewById(R.id.tv_item);
                if (textView2 != null) {
                    i = R.id.tv_lunar;
                    TextView textView3 = (TextView) view.findViewById(R.id.tv_lunar);
                    if (textView3 != null) {
                        return new ItemCalendarBinding((LinearLayout) view, textView, linearLayout, textView2, textView3);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
