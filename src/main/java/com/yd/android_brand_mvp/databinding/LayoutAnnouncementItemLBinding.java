package com.yd.android_brand_mvp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import com.yd.android_brand_mvp.R;

/* JADX INFO: loaded from: classes4.dex */
public final class LayoutAnnouncementItemLBinding implements ViewBinding {
    private final LinearLayout rootView;
    public final TextView tvContent;
    public final TextView tvCreatePeople;
    public final TextView tvSubject;
    public final TextView tvTime;

    private LayoutAnnouncementItemLBinding(LinearLayout linearLayout, TextView textView, TextView textView2, TextView textView3, TextView textView4) {
        this.rootView = linearLayout;
        this.tvContent = textView;
        this.tvCreatePeople = textView2;
        this.tvSubject = textView3;
        this.tvTime = textView4;
    }

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static LayoutAnnouncementItemLBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static LayoutAnnouncementItemLBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.layout_announcement_item_l, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static LayoutAnnouncementItemLBinding bind(View view) {
        int i = R.id.tv_content;
        TextView textView = (TextView) view.findViewById(R.id.tv_content);
        if (textView != null) {
            i = R.id.tv_create_people;
            TextView textView2 = (TextView) view.findViewById(R.id.tv_create_people);
            if (textView2 != null) {
                i = R.id.tv_subject;
                TextView textView3 = (TextView) view.findViewById(R.id.tv_subject);
                if (textView3 != null) {
                    i = R.id.tv_time;
                    TextView textView4 = (TextView) view.findViewById(R.id.tv_time);
                    if (textView4 != null) {
                        return new LayoutAnnouncementItemLBinding((LinearLayout) view, textView, textView2, textView3, textView4);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
