package com.yd.android_brand_mvp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.yd.android_brand_mvp.R;

/* JADX INFO: loaded from: classes4.dex */
public final class FragmentCustomizedTextBinding implements ViewBinding {
    public final ConstraintLayout clFragmentCustomText;
    private final ConstraintLayout rootView;
    public final LayoutCustomHeadTitleBinding topFragmentTitle;
    public final TextView tvFragmentCustomTextDesc;

    private FragmentCustomizedTextBinding(ConstraintLayout constraintLayout, ConstraintLayout constraintLayout2, LayoutCustomHeadTitleBinding layoutCustomHeadTitleBinding, TextView textView) {
        this.rootView = constraintLayout;
        this.clFragmentCustomText = constraintLayout2;
        this.topFragmentTitle = layoutCustomHeadTitleBinding;
        this.tvFragmentCustomTextDesc = textView;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static FragmentCustomizedTextBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static FragmentCustomizedTextBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.fragment_customized_text, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static FragmentCustomizedTextBinding bind(View view) {
        ConstraintLayout constraintLayout = (ConstraintLayout) view;
        int i = R.id.top_fragment_title;
        View viewFindViewById = view.findViewById(R.id.top_fragment_title);
        if (viewFindViewById != null) {
            LayoutCustomHeadTitleBinding layoutCustomHeadTitleBindingBind = LayoutCustomHeadTitleBinding.bind(viewFindViewById);
            TextView textView = (TextView) view.findViewById(R.id.tv_fragment_custom_text_desc);
            if (textView != null) {
                return new FragmentCustomizedTextBinding(constraintLayout, constraintLayout, layoutCustomHeadTitleBindingBind, textView);
            }
            i = R.id.tv_fragment_custom_text_desc;
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
