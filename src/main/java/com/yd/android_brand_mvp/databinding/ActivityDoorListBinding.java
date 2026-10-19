package com.yd.android_brand_mvp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import com.yd.android_brand_mvp.R;

/* JADX INFO: loaded from: classes4.dex */
public final class ActivityDoorListBinding implements ViewBinding {
    public final TextView back;
    public final RecyclerView listDevice;
    public final LinearLayout llBack;
    private final LinearLayout rootView;
    public final TextView title;

    private ActivityDoorListBinding(LinearLayout linearLayout, TextView textView, RecyclerView recyclerView, LinearLayout linearLayout2, TextView textView2) {
        this.rootView = linearLayout;
        this.back = textView;
        this.listDevice = recyclerView;
        this.llBack = linearLayout2;
        this.title = textView2;
    }

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static ActivityDoorListBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static ActivityDoorListBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.activity_door_list, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static ActivityDoorListBinding bind(View view) {
        int i = R.id.back;
        TextView textView = (TextView) view.findViewById(R.id.back);
        if (textView != null) {
            i = R.id.list_device;
            RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.list_device);
            if (recyclerView != null) {
                i = R.id.ll_back;
                LinearLayout linearLayout = (LinearLayout) view.findViewById(R.id.ll_back);
                if (linearLayout != null) {
                    i = R.id.title;
                    TextView textView2 = (TextView) view.findViewById(R.id.title);
                    if (textView2 != null) {
                        return new ActivityDoorListBinding((LinearLayout) view, textView, recyclerView, linearLayout, textView2);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
