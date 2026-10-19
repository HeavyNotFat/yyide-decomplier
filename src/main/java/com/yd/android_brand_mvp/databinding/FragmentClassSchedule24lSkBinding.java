package com.yd.android_brand_mvp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import com.yd.android_brand_mvp.R;
import com.yd.android_brand_mvp.weight.MultiStateView;

/* JADX INFO: loaded from: classes4.dex */
public final class FragmentClassSchedule24lSkBinding implements ViewBinding {
    public final FrameLayout contentLayout;
    public final ListView listview;
    public final MultiStateView mu;
    private final LinearLayout rootView;
    public final TextView title;
    public final TextView tvWeek;

    private FragmentClassSchedule24lSkBinding(LinearLayout linearLayout, FrameLayout frameLayout, ListView listView, MultiStateView multiStateView, TextView textView, TextView textView2) {
        this.rootView = linearLayout;
        this.contentLayout = frameLayout;
        this.listview = listView;
        this.mu = multiStateView;
        this.title = textView;
        this.tvWeek = textView2;
    }

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static FragmentClassSchedule24lSkBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static FragmentClassSchedule24lSkBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.fragment_class_schedule2_4l_sk, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static FragmentClassSchedule24lSkBinding bind(View view) {
        int i = R.id.content_layout;
        FrameLayout frameLayout = (FrameLayout) view.findViewById(R.id.content_layout);
        if (frameLayout != null) {
            i = R.id.listview;
            ListView listView = (ListView) view.findViewById(R.id.listview);
            if (listView != null) {
                i = R.id.mu;
                MultiStateView multiStateView = (MultiStateView) view.findViewById(R.id.mu);
                if (multiStateView != null) {
                    i = R.id.title;
                    TextView textView = (TextView) view.findViewById(R.id.title);
                    if (textView != null) {
                        i = R.id.tv_week;
                        TextView textView2 = (TextView) view.findViewById(R.id.tv_week);
                        if (textView2 != null) {
                            return new FragmentClassSchedule24lSkBinding((LinearLayout) view, frameLayout, listView, multiStateView, textView, textView2);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
