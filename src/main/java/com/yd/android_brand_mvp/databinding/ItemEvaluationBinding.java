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
public final class ItemEvaluationBinding implements ViewBinding {
    public final ConstraintLayout clStart;
    public final ImageView imageView10;
    public final ImageView imageView8;
    public final ImageView imageView9;
    public final ImageView ivHead;
    public final ImageView ivMedal;
    public final View line;
    public final View line2;
    public final View line3;
    public final ConstraintLayout llCentent;
    public final ConstraintLayout llCenter;
    public final ConstraintLayout llEnd;
    private final ConstraintLayout rootView;
    public final TextView textView19;
    public final TextView textView20;
    public final TextView textView21;
    public final TextView tvMedal;
    public final TextView tvPointCard;
    public final TextView tvPointTotal;
    public final TextView tvSort;
    public final TextView tvStudentName;

    private ItemEvaluationBinding(ConstraintLayout constraintLayout, ConstraintLayout constraintLayout2, ImageView imageView, ImageView imageView2, ImageView imageView3, ImageView imageView4, ImageView imageView5, View view, View view2, View view3, ConstraintLayout constraintLayout3, ConstraintLayout constraintLayout4, ConstraintLayout constraintLayout5, TextView textView, TextView textView2, TextView textView3, TextView textView4, TextView textView5, TextView textView6, TextView textView7, TextView textView8) {
        this.rootView = constraintLayout;
        this.clStart = constraintLayout2;
        this.imageView10 = imageView;
        this.imageView8 = imageView2;
        this.imageView9 = imageView3;
        this.ivHead = imageView4;
        this.ivMedal = imageView5;
        this.line = view;
        this.line2 = view2;
        this.line3 = view3;
        this.llCentent = constraintLayout3;
        this.llCenter = constraintLayout4;
        this.llEnd = constraintLayout5;
        this.textView19 = textView;
        this.textView20 = textView2;
        this.textView21 = textView3;
        this.tvMedal = textView4;
        this.tvPointCard = textView5;
        this.tvPointTotal = textView6;
        this.tvSort = textView7;
        this.tvStudentName = textView8;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static ItemEvaluationBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static ItemEvaluationBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.item_evaluation, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static ItemEvaluationBinding bind(View view) {
        int i = R.id.clStart;
        ConstraintLayout constraintLayout = (ConstraintLayout) view.findViewById(R.id.clStart);
        if (constraintLayout != null) {
            i = R.id.imageView10;
            ImageView imageView = (ImageView) view.findViewById(R.id.imageView10);
            if (imageView != null) {
                i = R.id.imageView8;
                ImageView imageView2 = (ImageView) view.findViewById(R.id.imageView8);
                if (imageView2 != null) {
                    i = R.id.imageView9;
                    ImageView imageView3 = (ImageView) view.findViewById(R.id.imageView9);
                    if (imageView3 != null) {
                        i = R.id.ivHead;
                        ImageView imageView4 = (ImageView) view.findViewById(R.id.ivHead);
                        if (imageView4 != null) {
                            i = R.id.ivMedal;
                            ImageView imageView5 = (ImageView) view.findViewById(R.id.ivMedal);
                            if (imageView5 != null) {
                                i = R.id.line;
                                View viewFindViewById = view.findViewById(R.id.line);
                                if (viewFindViewById != null) {
                                    i = R.id.line2;
                                    View viewFindViewById2 = view.findViewById(R.id.line2);
                                    if (viewFindViewById2 != null) {
                                        i = R.id.line3;
                                        View viewFindViewById3 = view.findViewById(R.id.line3);
                                        if (viewFindViewById3 != null) {
                                            ConstraintLayout constraintLayout2 = (ConstraintLayout) view;
                                            i = R.id.llCenter;
                                            ConstraintLayout constraintLayout3 = (ConstraintLayout) view.findViewById(R.id.llCenter);
                                            if (constraintLayout3 != null) {
                                                i = R.id.llEnd;
                                                ConstraintLayout constraintLayout4 = (ConstraintLayout) view.findViewById(R.id.llEnd);
                                                if (constraintLayout4 != null) {
                                                    i = R.id.textView19;
                                                    TextView textView = (TextView) view.findViewById(R.id.textView19);
                                                    if (textView != null) {
                                                        i = R.id.textView20;
                                                        TextView textView2 = (TextView) view.findViewById(R.id.textView20);
                                                        if (textView2 != null) {
                                                            i = R.id.textView21;
                                                            TextView textView3 = (TextView) view.findViewById(R.id.textView21);
                                                            if (textView3 != null) {
                                                                i = R.id.tvMedal;
                                                                TextView textView4 = (TextView) view.findViewById(R.id.tvMedal);
                                                                if (textView4 != null) {
                                                                    i = R.id.tvPointCard;
                                                                    TextView textView5 = (TextView) view.findViewById(R.id.tvPointCard);
                                                                    if (textView5 != null) {
                                                                        i = R.id.tvPointTotal;
                                                                        TextView textView6 = (TextView) view.findViewById(R.id.tvPointTotal);
                                                                        if (textView6 != null) {
                                                                            i = R.id.tvSort;
                                                                            TextView textView7 = (TextView) view.findViewById(R.id.tvSort);
                                                                            if (textView7 != null) {
                                                                                i = R.id.tvStudentName;
                                                                                TextView textView8 = (TextView) view.findViewById(R.id.tvStudentName);
                                                                                if (textView8 != null) {
                                                                                    return new ItemEvaluationBinding(constraintLayout2, constraintLayout, imageView, imageView2, imageView3, imageView4, imageView5, viewFindViewById, viewFindViewById2, viewFindViewById3, constraintLayout2, constraintLayout3, constraintLayout4, textView, textView2, textView3, textView4, textView5, textView6, textView7, textView8);
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
