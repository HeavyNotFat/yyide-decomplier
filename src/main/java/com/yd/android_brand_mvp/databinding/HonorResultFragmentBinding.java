package com.yd.android_brand_mvp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import com.yd.android_brand_mvp.R;

/* JADX INFO: loaded from: classes4.dex */
public final class HonorResultFragmentBinding implements ViewBinding {
    public final CardView cardView;
    public final TextView gankTextview;
    public final RecyclerView recyclerView;
    private final ConstraintLayout rootView;
    public final TextView tv1;

    private HonorResultFragmentBinding(ConstraintLayout constraintLayout, CardView cardView, TextView textView, RecyclerView recyclerView, TextView textView2) {
        this.rootView = constraintLayout;
        this.cardView = cardView;
        this.gankTextview = textView;
        this.recyclerView = recyclerView;
        this.tv1 = textView2;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static HonorResultFragmentBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static HonorResultFragmentBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.honor_result_fragment, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static HonorResultFragmentBinding bind(View view) {
        int i = R.id.cardView;
        CardView cardView = (CardView) view.findViewById(R.id.cardView);
        if (cardView != null) {
            i = R.id.gank_textview;
            TextView textView = (TextView) view.findViewById(R.id.gank_textview);
            if (textView != null) {
                i = R.id.recyclerView;
                RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.recyclerView);
                if (recyclerView != null) {
                    i = R.id.tv1;
                    TextView textView2 = (TextView) view.findViewById(R.id.tv1);
                    if (textView2 != null) {
                        return new HonorResultFragmentBinding((ConstraintLayout) view, cardView, textView, recyclerView, textView2);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
