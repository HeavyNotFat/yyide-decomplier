package com.yd.android_brand_mvp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import com.yd.android_brand_mvp.R;

/* JADX INFO: loaded from: classes4.dex */
public final class ActivityReservationFullBinding implements ViewBinding {
    public final TextView btnActivityReservationFullSign;
    public final ConstraintLayout clActivityReservationFull;
    public final ConstraintLayout clActivityReservationFullDetail;
    public final ConstraintLayout clActivityReservationFullNextDetail;
    public final ConstraintLayout clActivityReservationFullScreenContent;
    public final ConstraintLayout clTopActivityReservationFullScreenContent;
    public final ImageView ivActivityReservationFullScreenReturnBottom;
    public final ImageView ivFragmentReservationFullReturn;
    private final ConstraintLayout rootView;
    public final RecyclerView rvActivityReservationFullPeople;
    public final TopLayoutBinding topActivityReservationFull;
    public final TextView tvActivityReservationFullExplain;
    public final TextView tvActivityReservationFullNextTheme;
    public final TextView tvActivityReservationFullNextTime;
    public final TextView tvActivityReservationFullNextType;
    public final TextView tvActivityReservationFullPeopleCount;
    public final TextView tvActivityReservationFullPeopleTip;
    public final TextView tvActivityReservationFullTheme;
    public final TextView tvActivityReservationFullTime;
    public final TextView tvActivityReservationFullTitle;
    public final TextView tvFragmentReservationFullScreen;

    private ActivityReservationFullBinding(ConstraintLayout constraintLayout, TextView textView, ConstraintLayout constraintLayout2, ConstraintLayout constraintLayout3, ConstraintLayout constraintLayout4, ConstraintLayout constraintLayout5, ConstraintLayout constraintLayout6, ImageView imageView, ImageView imageView2, RecyclerView recyclerView, TopLayoutBinding topLayoutBinding, TextView textView2, TextView textView3, TextView textView4, TextView textView5, TextView textView6, TextView textView7, TextView textView8, TextView textView9, TextView textView10, TextView textView11) {
        this.rootView = constraintLayout;
        this.btnActivityReservationFullSign = textView;
        this.clActivityReservationFull = constraintLayout2;
        this.clActivityReservationFullDetail = constraintLayout3;
        this.clActivityReservationFullNextDetail = constraintLayout4;
        this.clActivityReservationFullScreenContent = constraintLayout5;
        this.clTopActivityReservationFullScreenContent = constraintLayout6;
        this.ivActivityReservationFullScreenReturnBottom = imageView;
        this.ivFragmentReservationFullReturn = imageView2;
        this.rvActivityReservationFullPeople = recyclerView;
        this.topActivityReservationFull = topLayoutBinding;
        this.tvActivityReservationFullExplain = textView2;
        this.tvActivityReservationFullNextTheme = textView3;
        this.tvActivityReservationFullNextTime = textView4;
        this.tvActivityReservationFullNextType = textView5;
        this.tvActivityReservationFullPeopleCount = textView6;
        this.tvActivityReservationFullPeopleTip = textView7;
        this.tvActivityReservationFullTheme = textView8;
        this.tvActivityReservationFullTime = textView9;
        this.tvActivityReservationFullTitle = textView10;
        this.tvFragmentReservationFullScreen = textView11;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static ActivityReservationFullBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static ActivityReservationFullBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.activity_reservation_full, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static ActivityReservationFullBinding bind(View view) {
        int i = R.id.btn_activity_reservation_full_sign;
        TextView textView = (TextView) view.findViewById(R.id.btn_activity_reservation_full_sign);
        if (textView != null) {
            ConstraintLayout constraintLayout = (ConstraintLayout) view;
            i = R.id.cl_activity_reservation_full_detail;
            ConstraintLayout constraintLayout2 = (ConstraintLayout) view.findViewById(R.id.cl_activity_reservation_full_detail);
            if (constraintLayout2 != null) {
                i = R.id.cl_activity_reservation_full_next_detail;
                ConstraintLayout constraintLayout3 = (ConstraintLayout) view.findViewById(R.id.cl_activity_reservation_full_next_detail);
                if (constraintLayout3 != null) {
                    i = R.id.cl_activity_reservation_full_screen_content;
                    ConstraintLayout constraintLayout4 = (ConstraintLayout) view.findViewById(R.id.cl_activity_reservation_full_screen_content);
                    if (constraintLayout4 != null) {
                        i = R.id.cl_top_activity_reservation_full_screen_content;
                        ConstraintLayout constraintLayout5 = (ConstraintLayout) view.findViewById(R.id.cl_top_activity_reservation_full_screen_content);
                        if (constraintLayout5 != null) {
                            i = R.id.iv_activity_reservation_full_screen_return_bottom;
                            ImageView imageView = (ImageView) view.findViewById(R.id.iv_activity_reservation_full_screen_return_bottom);
                            if (imageView != null) {
                                i = R.id.iv_fragment_reservation_full_return;
                                ImageView imageView2 = (ImageView) view.findViewById(R.id.iv_fragment_reservation_full_return);
                                if (imageView2 != null) {
                                    i = R.id.rv_activity_reservation_full_people;
                                    RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.rv_activity_reservation_full_people);
                                    if (recyclerView != null) {
                                        i = R.id.top_activity_reservation_full;
                                        View viewFindViewById = view.findViewById(R.id.top_activity_reservation_full);
                                        if (viewFindViewById != null) {
                                            TopLayoutBinding topLayoutBindingBind = TopLayoutBinding.bind(viewFindViewById);
                                            i = R.id.tv_activity_reservation_full_explain;
                                            TextView textView2 = (TextView) view.findViewById(R.id.tv_activity_reservation_full_explain);
                                            if (textView2 != null) {
                                                i = R.id.tv_activity_reservation_full_next_theme;
                                                TextView textView3 = (TextView) view.findViewById(R.id.tv_activity_reservation_full_next_theme);
                                                if (textView3 != null) {
                                                    i = R.id.tv_activity_reservation_full_next_time;
                                                    TextView textView4 = (TextView) view.findViewById(R.id.tv_activity_reservation_full_next_time);
                                                    if (textView4 != null) {
                                                        i = R.id.tv_activity_reservation_full_next_type;
                                                        TextView textView5 = (TextView) view.findViewById(R.id.tv_activity_reservation_full_next_type);
                                                        if (textView5 != null) {
                                                            i = R.id.tv_activity_reservation_full_people_count;
                                                            TextView textView6 = (TextView) view.findViewById(R.id.tv_activity_reservation_full_people_count);
                                                            if (textView6 != null) {
                                                                i = R.id.tv_activity_reservation_full_people_tip;
                                                                TextView textView7 = (TextView) view.findViewById(R.id.tv_activity_reservation_full_people_tip);
                                                                if (textView7 != null) {
                                                                    i = R.id.tv_activity_reservation_full_theme;
                                                                    TextView textView8 = (TextView) view.findViewById(R.id.tv_activity_reservation_full_theme);
                                                                    if (textView8 != null) {
                                                                        i = R.id.tv_activity_reservation_full_time;
                                                                        TextView textView9 = (TextView) view.findViewById(R.id.tv_activity_reservation_full_time);
                                                                        if (textView9 != null) {
                                                                            i = R.id.tv_activity_reservation_full_title;
                                                                            TextView textView10 = (TextView) view.findViewById(R.id.tv_activity_reservation_full_title);
                                                                            if (textView10 != null) {
                                                                                i = R.id.tv_fragment_reservation_full_screen;
                                                                                TextView textView11 = (TextView) view.findViewById(R.id.tv_fragment_reservation_full_screen);
                                                                                if (textView11 != null) {
                                                                                    return new ActivityReservationFullBinding(constraintLayout, textView, constraintLayout, constraintLayout2, constraintLayout3, constraintLayout4, constraintLayout5, imageView, imageView2, recyclerView, topLayoutBindingBind, textView2, textView3, textView4, textView5, textView6, textView7, textView8, textView9, textView10, textView11);
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
