package com.yd.android_brand_mvp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.yd.android_brand_mvp.R;

/* JADX INFO: loaded from: classes4.dex */
public final class ItemClassesWord86Binding implements ViewBinding {
    private final ConstraintLayout rootView;
    public final TextView tvClassMotto;
    public final TextView tvTitle;

    private ItemClassesWord86Binding(ConstraintLayout constraintLayout, TextView textView, TextView textView2) {
        this.rootView = constraintLayout;
        this.tvClassMotto = textView;
        this.tvTitle = textView2;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static ItemClassesWord86Binding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static ItemClassesWord86Binding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.item_classes_word_86, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static ItemClassesWord86Binding bind(View view) {
        int i = R.id.tvClassMotto;
        TextView textView = (TextView) view.findViewById(R.id.tvClassMotto);
        if (textView != null) {
            i = R.id.tvTitle;
            TextView textView2 = (TextView) view.findViewById(R.id.tvTitle);
            if (textView2 != null) {
                return new ItemClassesWord86Binding((ConstraintLayout) view, textView, textView2);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
