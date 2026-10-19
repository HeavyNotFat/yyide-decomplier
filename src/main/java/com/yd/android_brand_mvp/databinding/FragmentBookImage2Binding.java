package com.yd.android_brand_mvp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import com.yd.android_brand_mvp.R;
import com.yd.android_brand_mvp.view.HackyViewPager2;

/* JADX INFO: loaded from: classes4.dex */
public final class FragmentBookImage2Binding implements ViewBinding {
    public final TextView back;
    public final FrameLayout backLayout;
    public final FrameLayout layout;
    public final FrameLayout layoutLl;
    public final FrameLayout page;
    public final HackyViewPager2 pager;
    private final FrameLayout rootView;
    public final TextView setting;
    public final TextView title;
    public final FrameLayout toplayout;

    private FragmentBookImage2Binding(FrameLayout frameLayout, TextView textView, FrameLayout frameLayout2, FrameLayout frameLayout3, FrameLayout frameLayout4, FrameLayout frameLayout5, HackyViewPager2 hackyViewPager2, TextView textView2, TextView textView3, FrameLayout frameLayout6) {
        this.rootView = frameLayout;
        this.back = textView;
        this.backLayout = frameLayout2;
        this.layout = frameLayout3;
        this.layoutLl = frameLayout4;
        this.page = frameLayout5;
        this.pager = hackyViewPager2;
        this.setting = textView2;
        this.title = textView3;
        this.toplayout = frameLayout6;
    }

    @Override // androidx.viewbinding.ViewBinding
    public FrameLayout getRoot() {
        return this.rootView;
    }

    public static FragmentBookImage2Binding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static FragmentBookImage2Binding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.fragment_book_image2, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static FragmentBookImage2Binding bind(View view) {
        int i = R.id.back;
        TextView textView = (TextView) view.findViewById(R.id.back);
        if (textView != null) {
            i = R.id.back_layout;
            FrameLayout frameLayout = (FrameLayout) view.findViewById(R.id.back_layout);
            if (frameLayout != null) {
                FrameLayout frameLayout2 = (FrameLayout) view;
                i = R.id.layout_ll;
                FrameLayout frameLayout3 = (FrameLayout) view.findViewById(R.id.layout_ll);
                if (frameLayout3 != null) {
                    i = R.id.page;
                    FrameLayout frameLayout4 = (FrameLayout) view.findViewById(R.id.page);
                    if (frameLayout4 != null) {
                        i = R.id.pager;
                        HackyViewPager2 hackyViewPager2 = (HackyViewPager2) view.findViewById(R.id.pager);
                        if (hackyViewPager2 != null) {
                            i = R.id.setting;
                            TextView textView2 = (TextView) view.findViewById(R.id.setting);
                            if (textView2 != null) {
                                i = R.id.title;
                                TextView textView3 = (TextView) view.findViewById(R.id.title);
                                if (textView3 != null) {
                                    i = R.id.toplayout;
                                    FrameLayout frameLayout5 = (FrameLayout) view.findViewById(R.id.toplayout);
                                    if (frameLayout5 != null) {
                                        return new FragmentBookImage2Binding(frameLayout2, textView, frameLayout, frameLayout2, frameLayout3, frameLayout4, hackyViewPager2, textView2, textView3, frameLayout5);
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
