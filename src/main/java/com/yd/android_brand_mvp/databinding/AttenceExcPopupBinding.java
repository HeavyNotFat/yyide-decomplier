package com.yd.android_brand_mvp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import com.yd.android_brand_mvp.R;

/* JADX INFO: loaded from: classes4.dex */
public final class AttenceExcPopupBinding implements ViewBinding {
    public final RelativeLayout rl;
    private final RelativeLayout rootView;
    public final RecyclerView rv;
    public final TextView tvTitle;

    private AttenceExcPopupBinding(RelativeLayout relativeLayout, RelativeLayout relativeLayout2, RecyclerView recyclerView, TextView textView) {
        this.rootView = relativeLayout;
        this.rl = relativeLayout2;
        this.rv = recyclerView;
        this.tvTitle = textView;
    }

    @Override // androidx.viewbinding.ViewBinding
    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static AttenceExcPopupBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static AttenceExcPopupBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.attence_exc_popup, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static AttenceExcPopupBinding bind(View view) {
        RelativeLayout relativeLayout = (RelativeLayout) view;
        int i = R.id.rv;
        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.rv);
        if (recyclerView != null) {
            i = R.id.tv_title;
            TextView textView = (TextView) view.findViewById(R.id.tv_title);
            if (textView != null) {
                return new AttenceExcPopupBinding(relativeLayout, relativeLayout, recyclerView, textView);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
