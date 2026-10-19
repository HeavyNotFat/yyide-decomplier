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
public final class AttParentItem2Binding implements ViewBinding {
    public final TextView lab1;
    private final LinearLayout rootView;
    public final RecyclerView rv1;
    public final TextView tvCount;

    private AttParentItem2Binding(LinearLayout linearLayout, TextView textView, RecyclerView recyclerView, TextView textView2) {
        this.rootView = linearLayout;
        this.lab1 = textView;
        this.rv1 = recyclerView;
        this.tvCount = textView2;
    }

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static AttParentItem2Binding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static AttParentItem2Binding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.att_parent_item2, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static AttParentItem2Binding bind(View view) {
        int i = R.id.lab1;
        TextView textView = (TextView) view.findViewById(R.id.lab1);
        if (textView != null) {
            i = R.id.rv1;
            RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.rv1);
            if (recyclerView != null) {
                i = R.id.tv_count;
                TextView textView2 = (TextView) view.findViewById(R.id.tv_count);
                if (textView2 != null) {
                    return new AttParentItem2Binding((LinearLayout) view, textView, recyclerView, textView2);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
