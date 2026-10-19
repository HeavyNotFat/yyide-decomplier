package com.yd.android_brand_mvp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewpager.widget.ViewPager;
import com.yd.android_brand_mvp.R;
import com.yd.android_brand_mvp.view.ClearEditText;

/* JADX INFO: loaded from: classes4.dex */
public final class FragmentBookDetailBinding implements ViewBinding {
    public final FrameLayout cs;
    public final ClearEditText edit;
    public final ImageView left;
    public final TextView post;
    public final ImageView right;
    private final ConstraintLayout rootView;
    public final TextView search;
    public final ViewPager viewpager;

    private FragmentBookDetailBinding(ConstraintLayout constraintLayout, FrameLayout frameLayout, ClearEditText clearEditText, ImageView imageView, TextView textView, ImageView imageView2, TextView textView2, ViewPager viewPager) {
        this.rootView = constraintLayout;
        this.cs = frameLayout;
        this.edit = clearEditText;
        this.left = imageView;
        this.post = textView;
        this.right = imageView2;
        this.search = textView2;
        this.viewpager = viewPager;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static FragmentBookDetailBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static FragmentBookDetailBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.fragment_book_detail, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static FragmentBookDetailBinding bind(View view) {
        int i = R.id.cs;
        FrameLayout frameLayout = (FrameLayout) view.findViewById(R.id.cs);
        if (frameLayout != null) {
            i = R.id.edit;
            ClearEditText clearEditText = (ClearEditText) view.findViewById(R.id.edit);
            if (clearEditText != null) {
                i = R.id.left;
                ImageView imageView = (ImageView) view.findViewById(R.id.left);
                if (imageView != null) {
                    i = R.id.post;
                    TextView textView = (TextView) view.findViewById(R.id.post);
                    if (textView != null) {
                        i = R.id.right;
                        ImageView imageView2 = (ImageView) view.findViewById(R.id.right);
                        if (imageView2 != null) {
                            i = R.id.search;
                            TextView textView2 = (TextView) view.findViewById(R.id.search);
                            if (textView2 != null) {
                                i = R.id.viewpager;
                                ViewPager viewPager = (ViewPager) view.findViewById(R.id.viewpager);
                                if (viewPager != null) {
                                    return new FragmentBookDetailBinding((ConstraintLayout) view, frameLayout, clearEditText, imageView, textView, imageView2, textView2, viewPager);
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
