package com.yd.android_brand_mvp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckedTextView;
import android.widget.FrameLayout;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.yd.android_brand_mvp.R;

/* JADX INFO: loaded from: classes4.dex */
public final class FragmentLibraryHomeBinding implements ViewBinding {
    public final FrameLayout content;
    public final LinearLayoutCompat llTop;
    private final ConstraintLayout rootView;
    public final CheckedTextView tvTab1;
    public final CheckedTextView tvTab2;
    public final CheckedTextView tvTab3;

    private FragmentLibraryHomeBinding(ConstraintLayout constraintLayout, FrameLayout frameLayout, LinearLayoutCompat linearLayoutCompat, CheckedTextView checkedTextView, CheckedTextView checkedTextView2, CheckedTextView checkedTextView3) {
        this.rootView = constraintLayout;
        this.content = frameLayout;
        this.llTop = linearLayoutCompat;
        this.tvTab1 = checkedTextView;
        this.tvTab2 = checkedTextView2;
        this.tvTab3 = checkedTextView3;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static FragmentLibraryHomeBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static FragmentLibraryHomeBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.fragment_library_home, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static FragmentLibraryHomeBinding bind(View view) {
        int i = R.id.content;
        FrameLayout frameLayout = (FrameLayout) view.findViewById(R.id.content);
        if (frameLayout != null) {
            i = R.id.ll_top;
            LinearLayoutCompat linearLayoutCompat = (LinearLayoutCompat) view.findViewById(R.id.ll_top);
            if (linearLayoutCompat != null) {
                i = R.id.tv_tab_1;
                CheckedTextView checkedTextView = (CheckedTextView) view.findViewById(R.id.tv_tab_1);
                if (checkedTextView != null) {
                    i = R.id.tv_tab_2;
                    CheckedTextView checkedTextView2 = (CheckedTextView) view.findViewById(R.id.tv_tab_2);
                    if (checkedTextView2 != null) {
                        i = R.id.tv_tab_3;
                        CheckedTextView checkedTextView3 = (CheckedTextView) view.findViewById(R.id.tv_tab_3);
                        if (checkedTextView3 != null) {
                            return new FragmentLibraryHomeBinding((ConstraintLayout) view, frameLayout, linearLayoutCompat, checkedTextView, checkedTextView2, checkedTextView3);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
