package com.yd.android_brand_mvp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Group;
import androidx.viewbinding.ViewBinding;
import com.yd.android_brand_mvp.R;

/* JADX INFO: loaded from: classes4.dex */
public final class FragmentReservationBinding implements ViewBinding {
    public final ConstraintLayout cl45;
    public final ConstraintLayout constraintLayout;
    public final Group group;
    public final Group group1;
    public final ImageView imageView4;
    public final ImageView imageView41;
    public final ImageView ivSign;
    public final ImageView ivSign1;
    private final ConstraintLayout rootView;
    public final TextView textView5;
    public final TextView textView51;
    public final TextView tvDescription;
    public final TextView tvDescription1;
    public final TextView tvTableName;
    public final TextView tvTableName1;
    public final TextView tvTableTime;
    public final TextView tvTableTime1;
    public final TextView tvTitle;
    public final TextView tvTitle1;

    private FragmentReservationBinding(ConstraintLayout constraintLayout, ConstraintLayout constraintLayout2, ConstraintLayout constraintLayout3, Group group, Group group2, ImageView imageView, ImageView imageView2, ImageView imageView3, ImageView imageView4, TextView textView, TextView textView2, TextView textView3, TextView textView4, TextView textView5, TextView textView6, TextView textView7, TextView textView8, TextView textView9, TextView textView10) {
        this.rootView = constraintLayout;
        this.cl45 = constraintLayout2;
        this.constraintLayout = constraintLayout3;
        this.group = group;
        this.group1 = group2;
        this.imageView4 = imageView;
        this.imageView41 = imageView2;
        this.ivSign = imageView3;
        this.ivSign1 = imageView4;
        this.textView5 = textView;
        this.textView51 = textView2;
        this.tvDescription = textView3;
        this.tvDescription1 = textView4;
        this.tvTableName = textView5;
        this.tvTableName1 = textView6;
        this.tvTableTime = textView7;
        this.tvTableTime1 = textView8;
        this.tvTitle = textView9;
        this.tvTitle1 = textView10;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static FragmentReservationBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static FragmentReservationBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.fragment_reservation, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static FragmentReservationBinding bind(View view) {
        int i = R.id.cl_45;
        ConstraintLayout constraintLayout = (ConstraintLayout) view.findViewById(R.id.cl_45);
        if (constraintLayout != null) {
            i = R.id.constraintLayout;
            ConstraintLayout constraintLayout2 = (ConstraintLayout) view.findViewById(R.id.constraintLayout);
            if (constraintLayout2 != null) {
                i = R.id.group;
                Group group = (Group) view.findViewById(R.id.group);
                if (group != null) {
                    i = R.id.group1;
                    Group group2 = (Group) view.findViewById(R.id.group1);
                    if (group2 != null) {
                        i = R.id.imageView4;
                        ImageView imageView = (ImageView) view.findViewById(R.id.imageView4);
                        if (imageView != null) {
                            i = R.id.imageView41;
                            ImageView imageView2 = (ImageView) view.findViewById(R.id.imageView41);
                            if (imageView2 != null) {
                                i = R.id.iv_sign;
                                ImageView imageView3 = (ImageView) view.findViewById(R.id.iv_sign);
                                if (imageView3 != null) {
                                    i = R.id.iv_sign1;
                                    ImageView imageView4 = (ImageView) view.findViewById(R.id.iv_sign1);
                                    if (imageView4 != null) {
                                        i = R.id.textView5;
                                        TextView textView = (TextView) view.findViewById(R.id.textView5);
                                        if (textView != null) {
                                            i = R.id.textView51;
                                            TextView textView2 = (TextView) view.findViewById(R.id.textView51);
                                            if (textView2 != null) {
                                                i = R.id.tv_description;
                                                TextView textView3 = (TextView) view.findViewById(R.id.tv_description);
                                                if (textView3 != null) {
                                                    i = R.id.tv_description1;
                                                    TextView textView4 = (TextView) view.findViewById(R.id.tv_description1);
                                                    if (textView4 != null) {
                                                        i = R.id.tv_tableName;
                                                        TextView textView5 = (TextView) view.findViewById(R.id.tv_tableName);
                                                        if (textView5 != null) {
                                                            i = R.id.tv_tableName1;
                                                            TextView textView6 = (TextView) view.findViewById(R.id.tv_tableName1);
                                                            if (textView6 != null) {
                                                                i = R.id.tv_tableTime;
                                                                TextView textView7 = (TextView) view.findViewById(R.id.tv_tableTime);
                                                                if (textView7 != null) {
                                                                    i = R.id.tv_tableTime1;
                                                                    TextView textView8 = (TextView) view.findViewById(R.id.tv_tableTime1);
                                                                    if (textView8 != null) {
                                                                        i = R.id.tv_title;
                                                                        TextView textView9 = (TextView) view.findViewById(R.id.tv_title);
                                                                        if (textView9 != null) {
                                                                            i = R.id.tv_title1;
                                                                            TextView textView10 = (TextView) view.findViewById(R.id.tv_title1);
                                                                            if (textView10 != null) {
                                                                                return new FragmentReservationBinding((ConstraintLayout) view, constraintLayout, constraintLayout2, group, group2, imageView, imageView2, imageView3, imageView4, textView, textView2, textView3, textView4, textView5, textView6, textView7, textView8, textView9, textView10);
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
