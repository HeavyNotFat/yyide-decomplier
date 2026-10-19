package com.yd.android_brand_mvp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import com.yd.android_brand_mvp.R;
import com.yd.android_brand_mvp.widget.YDEditText;

/* JADX INFO: loaded from: classes4.dex */
public final class FragmentYwSearchBinding implements ViewBinding {
    public final YDEditText edit;
    public final LinearLayout layoutInfo;
    public final TextView msg;
    public final RecyclerView recyclerView;
    private final LinearLayout rootView;
    public final LinearLayout s1;
    public final FrameLayout seach;
    public final TextView tj;

    private FragmentYwSearchBinding(LinearLayout linearLayout, YDEditText yDEditText, LinearLayout linearLayout2, TextView textView, RecyclerView recyclerView, LinearLayout linearLayout3, FrameLayout frameLayout, TextView textView2) {
        this.rootView = linearLayout;
        this.edit = yDEditText;
        this.layoutInfo = linearLayout2;
        this.msg = textView;
        this.recyclerView = recyclerView;
        this.s1 = linearLayout3;
        this.seach = frameLayout;
        this.tj = textView2;
    }

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static FragmentYwSearchBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static FragmentYwSearchBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.fragment_yw_search, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static FragmentYwSearchBinding bind(View view) {
        int i = R.id.edit;
        YDEditText yDEditText = (YDEditText) view.findViewById(R.id.edit);
        if (yDEditText != null) {
            i = R.id.layout_info;
            LinearLayout linearLayout = (LinearLayout) view.findViewById(R.id.layout_info);
            if (linearLayout != null) {
                i = R.id.msg;
                TextView textView = (TextView) view.findViewById(R.id.msg);
                if (textView != null) {
                    i = R.id.recyclerView;
                    RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.recyclerView);
                    if (recyclerView != null) {
                        i = R.id.s1;
                        LinearLayout linearLayout2 = (LinearLayout) view.findViewById(R.id.s1);
                        if (linearLayout2 != null) {
                            i = R.id.seach;
                            FrameLayout frameLayout = (FrameLayout) view.findViewById(R.id.seach);
                            if (frameLayout != null) {
                                i = R.id.tj;
                                TextView textView2 = (TextView) view.findViewById(R.id.tj);
                                if (textView2 != null) {
                                    return new FragmentYwSearchBinding((LinearLayout) view, yDEditText, linearLayout, textView, recyclerView, linearLayout2, frameLayout, textView2);
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
