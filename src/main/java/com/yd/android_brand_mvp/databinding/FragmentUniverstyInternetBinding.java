package com.yd.android_brand_mvp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.yd.android_brand_mvp.R;

/* JADX INFO: loaded from: classes4.dex */
public final class FragmentUniverstyInternetBinding implements ViewBinding {
    public final ConstraintLayout cl25;
    public final ConstraintLayout constraintLayout;
    public final ConstraintLayout constraintLayout3;
    public final ImageView ivApp2;
    public final ImageView ivApp21;
    public final ImageView ivApp3;
    public final ImageView ivApp31;
    public final ImageView ivApp4;
    public final ImageView ivApp41;
    public final ImageView ivMsg;
    public final ImageView ivMsg0;
    public final ImageView ivMsg1;
    private final ConstraintLayout rootView;
    public final TextView textView;
    public final TextView textView0;
    public final TextView textView1;
    public final TextView textView10;
    public final TextView textView101;
    public final TextView textView2;
    public final TextView textView21;
    public final TextView textView3;
    public final TextView textView31;
    public final TextView textView4;
    public final TextView textView41;

    private FragmentUniverstyInternetBinding(ConstraintLayout constraintLayout, ConstraintLayout constraintLayout2, ConstraintLayout constraintLayout3, ConstraintLayout constraintLayout4, ImageView imageView, ImageView imageView2, ImageView imageView3, ImageView imageView4, ImageView imageView5, ImageView imageView6, ImageView imageView7, ImageView imageView8, ImageView imageView9, TextView textView, TextView textView2, TextView textView3, TextView textView4, TextView textView5, TextView textView6, TextView textView7, TextView textView8, TextView textView9, TextView textView10, TextView textView11) {
        this.rootView = constraintLayout;
        this.cl25 = constraintLayout2;
        this.constraintLayout = constraintLayout3;
        this.constraintLayout3 = constraintLayout4;
        this.ivApp2 = imageView;
        this.ivApp21 = imageView2;
        this.ivApp3 = imageView3;
        this.ivApp31 = imageView4;
        this.ivApp4 = imageView5;
        this.ivApp41 = imageView6;
        this.ivMsg = imageView7;
        this.ivMsg0 = imageView8;
        this.ivMsg1 = imageView9;
        this.textView = textView;
        this.textView0 = textView2;
        this.textView1 = textView3;
        this.textView10 = textView4;
        this.textView101 = textView5;
        this.textView2 = textView6;
        this.textView21 = textView7;
        this.textView3 = textView8;
        this.textView31 = textView9;
        this.textView4 = textView10;
        this.textView41 = textView11;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static FragmentUniverstyInternetBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static FragmentUniverstyInternetBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.fragment_universty_internet, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static FragmentUniverstyInternetBinding bind(View view) {
        int i = R.id.cl_25;
        ConstraintLayout constraintLayout = (ConstraintLayout) view.findViewById(R.id.cl_25);
        if (constraintLayout != null) {
            ConstraintLayout constraintLayout2 = (ConstraintLayout) view;
            i = R.id.constraintLayout3;
            ConstraintLayout constraintLayout3 = (ConstraintLayout) view.findViewById(R.id.constraintLayout3);
            if (constraintLayout3 != null) {
                i = R.id.iv_app2;
                ImageView imageView = (ImageView) view.findViewById(R.id.iv_app2);
                if (imageView != null) {
                    i = R.id.iv_app21;
                    ImageView imageView2 = (ImageView) view.findViewById(R.id.iv_app21);
                    if (imageView2 != null) {
                        i = R.id.iv_app3;
                        ImageView imageView3 = (ImageView) view.findViewById(R.id.iv_app3);
                        if (imageView3 != null) {
                            i = R.id.iv_app31;
                            ImageView imageView4 = (ImageView) view.findViewById(R.id.iv_app31);
                            if (imageView4 != null) {
                                i = R.id.iv_app4;
                                ImageView imageView5 = (ImageView) view.findViewById(R.id.iv_app4);
                                if (imageView5 != null) {
                                    i = R.id.iv_app41;
                                    ImageView imageView6 = (ImageView) view.findViewById(R.id.iv_app41);
                                    if (imageView6 != null) {
                                        i = R.id.iv_msg;
                                        ImageView imageView7 = (ImageView) view.findViewById(R.id.iv_msg);
                                        if (imageView7 != null) {
                                            i = R.id.iv_msg0;
                                            ImageView imageView8 = (ImageView) view.findViewById(R.id.iv_msg0);
                                            if (imageView8 != null) {
                                                i = R.id.iv_msg1;
                                                ImageView imageView9 = (ImageView) view.findViewById(R.id.iv_msg1);
                                                if (imageView9 != null) {
                                                    i = R.id.textView;
                                                    TextView textView = (TextView) view.findViewById(R.id.textView);
                                                    if (textView != null) {
                                                        i = R.id.textView0;
                                                        TextView textView2 = (TextView) view.findViewById(R.id.textView0);
                                                        if (textView2 != null) {
                                                            i = R.id.textView1;
                                                            TextView textView3 = (TextView) view.findViewById(R.id.textView1);
                                                            if (textView3 != null) {
                                                                i = R.id.textView10;
                                                                TextView textView4 = (TextView) view.findViewById(R.id.textView10);
                                                                if (textView4 != null) {
                                                                    i = R.id.textView101;
                                                                    TextView textView5 = (TextView) view.findViewById(R.id.textView101);
                                                                    if (textView5 != null) {
                                                                        i = R.id.textView2;
                                                                        TextView textView6 = (TextView) view.findViewById(R.id.textView2);
                                                                        if (textView6 != null) {
                                                                            i = R.id.textView21;
                                                                            TextView textView7 = (TextView) view.findViewById(R.id.textView21);
                                                                            if (textView7 != null) {
                                                                                i = R.id.textView3;
                                                                                TextView textView8 = (TextView) view.findViewById(R.id.textView3);
                                                                                if (textView8 != null) {
                                                                                    i = R.id.textView31;
                                                                                    TextView textView9 = (TextView) view.findViewById(R.id.textView31);
                                                                                    if (textView9 != null) {
                                                                                        i = R.id.textView4;
                                                                                        TextView textView10 = (TextView) view.findViewById(R.id.textView4);
                                                                                        if (textView10 != null) {
                                                                                            i = R.id.textView41;
                                                                                            TextView textView11 = (TextView) view.findViewById(R.id.textView41);
                                                                                            if (textView11 != null) {
                                                                                                return new FragmentUniverstyInternetBinding(constraintLayout2, constraintLayout, constraintLayout2, constraintLayout3, imageView, imageView2, imageView3, imageView4, imageView5, imageView6, imageView7, imageView8, imageView9, textView, textView2, textView3, textView4, textView5, textView6, textView7, textView8, textView9, textView10, textView11);
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
