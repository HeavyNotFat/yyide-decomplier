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
public final class DialogEvaluationMedalDetailsBinding implements ViewBinding {
    public final ImageView ivImg;
    private final ConstraintLayout rootView;
    public final TextView textView22;
    public final TextView textView23;
    public final TextView textView24;
    public final TextView textView25;
    public final TextView textView26;
    public final TextView tvClassesName;
    public final TextView tvConfirm;
    public final TextView tvDate;
    public final TextView tvPoint;
    public final TextView tvRelease;
    public final TextView tvStudentName;
    public final TextView tvTitle;

    private DialogEvaluationMedalDetailsBinding(ConstraintLayout constraintLayout, ImageView imageView, TextView textView, TextView textView2, TextView textView3, TextView textView4, TextView textView5, TextView textView6, TextView textView7, TextView textView8, TextView textView9, TextView textView10, TextView textView11, TextView textView12) {
        this.rootView = constraintLayout;
        this.ivImg = imageView;
        this.textView22 = textView;
        this.textView23 = textView2;
        this.textView24 = textView3;
        this.textView25 = textView4;
        this.textView26 = textView5;
        this.tvClassesName = textView6;
        this.tvConfirm = textView7;
        this.tvDate = textView8;
        this.tvPoint = textView9;
        this.tvRelease = textView10;
        this.tvStudentName = textView11;
        this.tvTitle = textView12;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static DialogEvaluationMedalDetailsBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static DialogEvaluationMedalDetailsBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.dialog_evaluation_medal_details, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static DialogEvaluationMedalDetailsBinding bind(View view) {
        int i = R.id.ivImg;
        ImageView imageView = (ImageView) view.findViewById(R.id.ivImg);
        if (imageView != null) {
            i = R.id.textView22;
            TextView textView = (TextView) view.findViewById(R.id.textView22);
            if (textView != null) {
                i = R.id.textView23;
                TextView textView2 = (TextView) view.findViewById(R.id.textView23);
                if (textView2 != null) {
                    i = R.id.textView24;
                    TextView textView3 = (TextView) view.findViewById(R.id.textView24);
                    if (textView3 != null) {
                        i = R.id.textView25;
                        TextView textView4 = (TextView) view.findViewById(R.id.textView25);
                        if (textView4 != null) {
                            i = R.id.textView26;
                            TextView textView5 = (TextView) view.findViewById(R.id.textView26);
                            if (textView5 != null) {
                                i = R.id.tvClassesName;
                                TextView textView6 = (TextView) view.findViewById(R.id.tvClassesName);
                                if (textView6 != null) {
                                    i = R.id.tvConfirm;
                                    TextView textView7 = (TextView) view.findViewById(R.id.tvConfirm);
                                    if (textView7 != null) {
                                        i = R.id.tvDate;
                                        TextView textView8 = (TextView) view.findViewById(R.id.tvDate);
                                        if (textView8 != null) {
                                            i = R.id.tvPoint;
                                            TextView textView9 = (TextView) view.findViewById(R.id.tvPoint);
                                            if (textView9 != null) {
                                                i = R.id.tvRelease;
                                                TextView textView10 = (TextView) view.findViewById(R.id.tvRelease);
                                                if (textView10 != null) {
                                                    i = R.id.tvStudentName;
                                                    TextView textView11 = (TextView) view.findViewById(R.id.tvStudentName);
                                                    if (textView11 != null) {
                                                        i = R.id.tvTitle;
                                                        TextView textView12 = (TextView) view.findViewById(R.id.tvTitle);
                                                        if (textView12 != null) {
                                                            return new DialogEvaluationMedalDetailsBinding((ConstraintLayout) view, imageView, textView, textView2, textView3, textView4, textView5, textView6, textView7, textView8, textView9, textView10, textView11, textView12);
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
