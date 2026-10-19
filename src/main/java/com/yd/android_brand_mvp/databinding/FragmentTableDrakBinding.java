package com.yd.android_brand_mvp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Group;
import androidx.viewbinding.ViewBinding;
import com.yd.android_brand_mvp.R;
import com.yd.android_brand_mvp.weight.MultiStateView;
import com.youth.banner.Banner;

/* JADX INFO: loaded from: classes4.dex */
public final class FragmentTableDrakBinding implements ViewBinding {
    public final ProgressBar absenceProgressBar;
    public final Banner bannerHead;
    public final CardView cardView2;
    public final ConstraintLayout constraintLayout;
    public final Group group;
    public final Group groupHead;
    public final ImageView imageView4;
    public final ImageView ivHead;
    public final ImageView ivSign;
    public final MultiStateView muCampus;
    public final ProgressBar progressBar;
    private final ConstraintLayout rootView;
    public final TextView textView2;
    public final TextView textView5;
    public final TextView textView6;
    public final TextView textView7;
    public final TextView tvAbsenceNumber;
    public final TextView tvAbsenceTotal;
    public final TextView tvName;
    public final TextView tvSignNumber;
    public final TextView tvSignTotal;
    public final TextView tvTableName;
    public final TextView tvTableTime;

    private FragmentTableDrakBinding(ConstraintLayout constraintLayout, ProgressBar progressBar, Banner banner, CardView cardView, ConstraintLayout constraintLayout2, Group group, Group group2, ImageView imageView, ImageView imageView2, ImageView imageView3, MultiStateView multiStateView, ProgressBar progressBar2, TextView textView, TextView textView2, TextView textView3, TextView textView4, TextView textView5, TextView textView6, TextView textView7, TextView textView8, TextView textView9, TextView textView10, TextView textView11) {
        this.rootView = constraintLayout;
        this.absenceProgressBar = progressBar;
        this.bannerHead = banner;
        this.cardView2 = cardView;
        this.constraintLayout = constraintLayout2;
        this.group = group;
        this.groupHead = group2;
        this.imageView4 = imageView;
        this.ivHead = imageView2;
        this.ivSign = imageView3;
        this.muCampus = multiStateView;
        this.progressBar = progressBar2;
        this.textView2 = textView;
        this.textView5 = textView2;
        this.textView6 = textView3;
        this.textView7 = textView4;
        this.tvAbsenceNumber = textView5;
        this.tvAbsenceTotal = textView6;
        this.tvName = textView7;
        this.tvSignNumber = textView8;
        this.tvSignTotal = textView9;
        this.tvTableName = textView10;
        this.tvTableTime = textView11;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static FragmentTableDrakBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static FragmentTableDrakBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.fragment_table_drak, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static FragmentTableDrakBinding bind(View view) {
        int i = R.id.absenceProgressBar;
        ProgressBar progressBar = (ProgressBar) view.findViewById(R.id.absenceProgressBar);
        if (progressBar != null) {
            i = R.id.banner_head;
            Banner banner = (Banner) view.findViewById(R.id.banner_head);
            if (banner != null) {
                i = R.id.cardView2;
                CardView cardView = (CardView) view.findViewById(R.id.cardView2);
                if (cardView != null) {
                    ConstraintLayout constraintLayout = (ConstraintLayout) view;
                    i = R.id.group;
                    Group group = (Group) view.findViewById(R.id.group);
                    if (group != null) {
                        i = R.id.groupHead;
                        Group group2 = (Group) view.findViewById(R.id.groupHead);
                        if (group2 != null) {
                            i = R.id.imageView4;
                            ImageView imageView = (ImageView) view.findViewById(R.id.imageView4);
                            if (imageView != null) {
                                i = R.id.iv_head;
                                ImageView imageView2 = (ImageView) view.findViewById(R.id.iv_head);
                                if (imageView2 != null) {
                                    i = R.id.iv_sign;
                                    ImageView imageView3 = (ImageView) view.findViewById(R.id.iv_sign);
                                    if (imageView3 != null) {
                                        i = R.id.mu_campus;
                                        MultiStateView multiStateView = (MultiStateView) view.findViewById(R.id.mu_campus);
                                        if (multiStateView != null) {
                                            i = R.id.progressBar;
                                            ProgressBar progressBar2 = (ProgressBar) view.findViewById(R.id.progressBar);
                                            if (progressBar2 != null) {
                                                i = R.id.textView2;
                                                TextView textView = (TextView) view.findViewById(R.id.textView2);
                                                if (textView != null) {
                                                    i = R.id.textView5;
                                                    TextView textView2 = (TextView) view.findViewById(R.id.textView5);
                                                    if (textView2 != null) {
                                                        i = R.id.textView6;
                                                        TextView textView3 = (TextView) view.findViewById(R.id.textView6);
                                                        if (textView3 != null) {
                                                            i = R.id.textView7;
                                                            TextView textView4 = (TextView) view.findViewById(R.id.textView7);
                                                            if (textView4 != null) {
                                                                i = R.id.tv_absence_number;
                                                                TextView textView5 = (TextView) view.findViewById(R.id.tv_absence_number);
                                                                if (textView5 != null) {
                                                                    i = R.id.tv_absence_total;
                                                                    TextView textView6 = (TextView) view.findViewById(R.id.tv_absence_total);
                                                                    if (textView6 != null) {
                                                                        i = R.id.tv_name;
                                                                        TextView textView7 = (TextView) view.findViewById(R.id.tv_name);
                                                                        if (textView7 != null) {
                                                                            i = R.id.tv_sign_number;
                                                                            TextView textView8 = (TextView) view.findViewById(R.id.tv_sign_number);
                                                                            if (textView8 != null) {
                                                                                i = R.id.tv_sign_total;
                                                                                TextView textView9 = (TextView) view.findViewById(R.id.tv_sign_total);
                                                                                if (textView9 != null) {
                                                                                    i = R.id.tv_tableName;
                                                                                    TextView textView10 = (TextView) view.findViewById(R.id.tv_tableName);
                                                                                    if (textView10 != null) {
                                                                                        i = R.id.tv_tableTime;
                                                                                        TextView textView11 = (TextView) view.findViewById(R.id.tv_tableTime);
                                                                                        if (textView11 != null) {
                                                                                            return new FragmentTableDrakBinding(constraintLayout, progressBar, banner, cardView, constraintLayout, group, group2, imageView, imageView2, imageView3, multiStateView, progressBar2, textView, textView2, textView3, textView4, textView5, textView6, textView7, textView8, textView9, textView10, textView11);
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
