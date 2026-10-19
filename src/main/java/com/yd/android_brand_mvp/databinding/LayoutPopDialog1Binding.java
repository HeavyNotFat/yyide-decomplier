package com.yd.android_brand_mvp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ListView;
import androidx.viewbinding.ViewBinding;
import com.yd.android_brand_mvp.R;

/* JADX INFO: loaded from: classes4.dex */
public final class LayoutPopDialog1Binding implements ViewBinding {
    public final FrameLayout layout;
    public final ListView list;
    private final FrameLayout rootView;

    private LayoutPopDialog1Binding(FrameLayout frameLayout, FrameLayout frameLayout2, ListView listView) {
        this.rootView = frameLayout;
        this.layout = frameLayout2;
        this.list = listView;
    }

    @Override // androidx.viewbinding.ViewBinding
    public FrameLayout getRoot() {
        return this.rootView;
    }

    public static LayoutPopDialog1Binding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static LayoutPopDialog1Binding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.layout_pop_dialog1, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static LayoutPopDialog1Binding bind(View view) {
        int i = R.id.layout;
        FrameLayout frameLayout = (FrameLayout) view.findViewById(R.id.layout);
        if (frameLayout != null) {
            i = R.id.list;
            ListView listView = (ListView) view.findViewById(R.id.list);
            if (listView != null) {
                return new LayoutPopDialog1Binding((FrameLayout) view, frameLayout, listView);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
