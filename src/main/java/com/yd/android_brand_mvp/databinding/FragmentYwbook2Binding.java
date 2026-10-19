package com.yd.android_brand_mvp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.GridView;
import android.widget.RelativeLayout;
import androidx.viewbinding.ViewBinding;
import com.yd.android_brand_mvp.R;

/* JADX INFO: loaded from: classes4.dex */
public final class FragmentYwbook2Binding implements ViewBinding {
    public final FrameLayout content;
    public final GridView grid;
    public final RelativeLayout layoutBg;
    private final RelativeLayout rootView;
    public final LayoutHeadTitleBinding top;

    private FragmentYwbook2Binding(RelativeLayout relativeLayout, FrameLayout frameLayout, GridView gridView, RelativeLayout relativeLayout2, LayoutHeadTitleBinding layoutHeadTitleBinding) {
        this.rootView = relativeLayout;
        this.content = frameLayout;
        this.grid = gridView;
        this.layoutBg = relativeLayout2;
        this.top = layoutHeadTitleBinding;
    }

    @Override // androidx.viewbinding.ViewBinding
    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static FragmentYwbook2Binding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static FragmentYwbook2Binding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.fragment_ywbook2, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static FragmentYwbook2Binding bind(View view) {
        int i = R.id.content;
        FrameLayout frameLayout = (FrameLayout) view.findViewById(R.id.content);
        if (frameLayout != null) {
            i = R.id.grid;
            GridView gridView = (GridView) view.findViewById(R.id.grid);
            if (gridView != null) {
                i = R.id.layout_bg;
                RelativeLayout relativeLayout = (RelativeLayout) view.findViewById(R.id.layout_bg);
                if (relativeLayout != null) {
                    i = R.id.top;
                    View viewFindViewById = view.findViewById(R.id.top);
                    if (viewFindViewById != null) {
                        return new FragmentYwbook2Binding((RelativeLayout) view, frameLayout, gridView, relativeLayout, LayoutHeadTitleBinding.bind(viewFindViewById));
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
