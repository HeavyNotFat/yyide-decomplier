package com.yd.android_brand_mvp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextClock;
import android.widget.TextView;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.yd.android_brand_mvp.R;

/* JADX INFO: loaded from: classes4.dex */
public final class FragmentSiteFullScreenBinding implements ViewBinding {
    public final TextClock hh;
    public final ImageView imageView5;
    public final ImageView ivBtn;
    public final ImageView ivLogo;
    public final LinearLayoutCompat linearLayoutCompat2;
    public final LinearLayoutCompat linearLayoutCompat3;
    public final LinearLayoutCompat linearLayoutCompat4;
    private final ConstraintLayout rootView;
    public final TextClock textClock4;
    public final TextClock textClock5;
    public final TextClock textClock6;
    public final TextView tvSchoolName;
    public final TextView tvSiteName;

    private FragmentSiteFullScreenBinding(ConstraintLayout constraintLayout, TextClock textClock, ImageView imageView, ImageView imageView2, ImageView imageView3, LinearLayoutCompat linearLayoutCompat, LinearLayoutCompat linearLayoutCompat2, LinearLayoutCompat linearLayoutCompat3, TextClock textClock2, TextClock textClock3, TextClock textClock4, TextView textView, TextView textView2) {
        this.rootView = constraintLayout;
        this.hh = textClock;
        this.imageView5 = imageView;
        this.ivBtn = imageView2;
        this.ivLogo = imageView3;
        this.linearLayoutCompat2 = linearLayoutCompat;
        this.linearLayoutCompat3 = linearLayoutCompat2;
        this.linearLayoutCompat4 = linearLayoutCompat3;
        this.textClock4 = textClock2;
        this.textClock5 = textClock3;
        this.textClock6 = textClock4;
        this.tvSchoolName = textView;
        this.tvSiteName = textView2;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static FragmentSiteFullScreenBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static FragmentSiteFullScreenBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.fragment_site_full_screen, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static FragmentSiteFullScreenBinding bind(View view) {
        int i = R.id.hh;
        TextClock textClock = (TextClock) view.findViewById(R.id.hh);
        if (textClock != null) {
            i = R.id.imageView5;
            ImageView imageView = (ImageView) view.findViewById(R.id.imageView5);
            if (imageView != null) {
                i = R.id.ivBtn;
                ImageView imageView2 = (ImageView) view.findViewById(R.id.ivBtn);
                if (imageView2 != null) {
                    i = R.id.ivLogo;
                    ImageView imageView3 = (ImageView) view.findViewById(R.id.ivLogo);
                    if (imageView3 != null) {
                        i = R.id.linearLayoutCompat2;
                        LinearLayoutCompat linearLayoutCompat = (LinearLayoutCompat) view.findViewById(R.id.linearLayoutCompat2);
                        if (linearLayoutCompat != null) {
                            i = R.id.linearLayoutCompat3;
                            LinearLayoutCompat linearLayoutCompat2 = (LinearLayoutCompat) view.findViewById(R.id.linearLayoutCompat3);
                            if (linearLayoutCompat2 != null) {
                                i = R.id.linearLayoutCompat4;
                                LinearLayoutCompat linearLayoutCompat3 = (LinearLayoutCompat) view.findViewById(R.id.linearLayoutCompat4);
                                if (linearLayoutCompat3 != null) {
                                    i = R.id.textClock4;
                                    TextClock textClock2 = (TextClock) view.findViewById(R.id.textClock4);
                                    if (textClock2 != null) {
                                        i = R.id.textClock5;
                                        TextClock textClock3 = (TextClock) view.findViewById(R.id.textClock5);
                                        if (textClock3 != null) {
                                            i = R.id.textClock6;
                                            TextClock textClock4 = (TextClock) view.findViewById(R.id.textClock6);
                                            if (textClock4 != null) {
                                                i = R.id.tvSchoolName;
                                                TextView textView = (TextView) view.findViewById(R.id.tvSchoolName);
                                                if (textView != null) {
                                                    i = R.id.tvSiteName;
                                                    TextView textView2 = (TextView) view.findViewById(R.id.tvSiteName);
                                                    if (textView2 != null) {
                                                        return new FragmentSiteFullScreenBinding((ConstraintLayout) view, textClock, imageView, imageView2, imageView3, linearLayoutCompat, linearLayoutCompat2, linearLayoutCompat3, textClock2, textClock3, textClock4, textView, textView2);
                                                    }
                                                }
                                            }
                                        }
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
