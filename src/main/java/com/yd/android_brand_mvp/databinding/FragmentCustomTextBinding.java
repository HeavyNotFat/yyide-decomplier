package com.yd.android_brand_mvp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.yd.android_brand_mvp.R;

/* JADX INFO: loaded from: classes4.dex */
public final class FragmentCustomTextBinding implements ViewBinding {
    public final ConstraintLayout clFragmentCustomText;
    private final ConstraintLayout rootView;
    public final LayoutHeadTitle2Binding topFragmentTitle;
    public final TextView tvFragmentCustomTextDesc;

    private FragmentCustomTextBinding(ConstraintLayout constraintLayout, ConstraintLayout constraintLayout2, LayoutHeadTitle2Binding layoutHeadTitle2Binding, TextView textView) {
        this.rootView = constraintLayout;
        this.clFragmentCustomText = constraintLayout2;
        this.topFragmentTitle = layoutHeadTitle2Binding;
        this.tvFragmentCustomTextDesc = textView;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static FragmentCustomTextBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static FragmentCustomTextBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.fragment_custom_text, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static FragmentCustomTextBinding bind(View view) {
        ConstraintLayout constraintLayout = (ConstraintLayout) view;
        int i = R.id.top_fragment_title;
        View viewFindViewById = view.findViewById(R.id.top_fragment_title);
        if (viewFindViewById != null) {
            LayoutHeadTitle2Binding layoutHeadTitle2BindingBind = LayoutHeadTitle2Binding.bind(viewFindViewById);
            TextView textView = (TextView) view.findViewById(R.id.tv_fragment_custom_text_desc);
            if (textView != null) {
                return new FragmentCustomTextBinding(constraintLayout, constraintLayout, layoutHeadTitle2BindingBind, textView);
            }
            i = R.id.tv_fragment_custom_text_desc;
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
