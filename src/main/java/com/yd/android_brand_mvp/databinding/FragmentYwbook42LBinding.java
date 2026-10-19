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
public final class FragmentYwbook42LBinding implements ViewBinding {
    public final RelativeLayout bg;
    public final TextView booktitle;
    public final RecyclerView recyclerView;
    private final RelativeLayout rootView;

    private FragmentYwbook42LBinding(RelativeLayout relativeLayout, RelativeLayout relativeLayout2, TextView textView, RecyclerView recyclerView) {
        this.rootView = relativeLayout;
        this.bg = relativeLayout2;
        this.booktitle = textView;
        this.recyclerView = recyclerView;
    }

    @Override // androidx.viewbinding.ViewBinding
    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static FragmentYwbook42LBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static FragmentYwbook42LBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.fragment_ywbook4_2_l, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static FragmentYwbook42LBinding bind(View view) {
        int i = R.id.bg;
        RelativeLayout relativeLayout = (RelativeLayout) view.findViewById(R.id.bg);
        if (relativeLayout != null) {
            i = R.id.booktitle;
            TextView textView = (TextView) view.findViewById(R.id.booktitle);
            if (textView != null) {
                i = R.id.recyclerView;
                RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.recyclerView);
                if (recyclerView != null) {
                    return new FragmentYwbook42LBinding((RelativeLayout) view, relativeLayout, textView, recyclerView);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
