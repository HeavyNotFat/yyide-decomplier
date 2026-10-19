package com.yd.android_brand_mvp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.yd.android_brand_mvp.R;
import com.youth.banner.Banner;

/* JADX INFO: loaded from: classes4.dex */
public final class FragmentConsultDetailsBinding implements ViewBinding {
    public final Banner bannerDetails;
    public final TextView btnConsultSign;
    public final LinearLayoutCompat linearLayout;
    private final ConstraintLayout rootView;
    public final TextView tvConsultDate;
    public final TextView tvConsultStatus;
    public final TextView tvConsultTitle;
    public final TextView tvEndHours1;
    public final TextView tvEndHours2;
    public final TextView tvEndMinutes1;
    public final TextView tvEndMinutes2;
    public final TextView tvStartHours1;
    public final TextView tvStartHours2;
    public final TextView tvStartMinutes1;
    public final TextView tvStartMinutes2;

    private FragmentConsultDetailsBinding(ConstraintLayout constraintLayout, Banner banner, TextView textView, LinearLayoutCompat linearLayoutCompat, TextView textView2, TextView textView3, TextView textView4, TextView textView5, TextView textView6, TextView textView7, TextView textView8, TextView textView9, TextView textView10, TextView textView11, TextView textView12) {
        this.rootView = constraintLayout;
        this.bannerDetails = banner;
        this.btnConsultSign = textView;
        this.linearLayout = linearLayoutCompat;
        this.tvConsultDate = textView2;
        this.tvConsultStatus = textView3;
        this.tvConsultTitle = textView4;
        this.tvEndHours1 = textView5;
        this.tvEndHours2 = textView6;
        this.tvEndMinutes1 = textView7;
        this.tvEndMinutes2 = textView8;
        this.tvStartHours1 = textView9;
        this.tvStartHours2 = textView10;
        this.tvStartMinutes1 = textView11;
        this.tvStartMinutes2 = textView12;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static FragmentConsultDetailsBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static FragmentConsultDetailsBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.fragment_consult_details, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static FragmentConsultDetailsBinding bind(View view) {
        int i = R.id.banner_details;
        Banner banner = (Banner) view.findViewById(R.id.banner_details);
        if (banner != null) {
            i = R.id.btn_consult_sign;
            TextView textView = (TextView) view.findViewById(R.id.btn_consult_sign);
            if (textView != null) {
                i = R.id.linearLayout;
                LinearLayoutCompat linearLayoutCompat = (LinearLayoutCompat) view.findViewById(R.id.linearLayout);
                if (linearLayoutCompat != null) {
                    i = R.id.tv_consult_date;
                    TextView textView2 = (TextView) view.findViewById(R.id.tv_consult_date);
                    if (textView2 != null) {
                        i = R.id.tv_consult_status;
                        TextView textView3 = (TextView) view.findViewById(R.id.tv_consult_status);
                        if (textView3 != null) {
                            i = R.id.tv_consult_title;
                            TextView textView4 = (TextView) view.findViewById(R.id.tv_consult_title);
                            if (textView4 != null) {
                                i = R.id.tv_end_hours1;
                                TextView textView5 = (TextView) view.findViewById(R.id.tv_end_hours1);
                                if (textView5 != null) {
                                    i = R.id.tv_end_hours2;
                                    TextView textView6 = (TextView) view.findViewById(R.id.tv_end_hours2);
                                    if (textView6 != null) {
                                        i = R.id.tv_end_minutes1;
                                        TextView textView7 = (TextView) view.findViewById(R.id.tv_end_minutes1);
                                        if (textView7 != null) {
                                            i = R.id.tv_end_minutes2;
                                            TextView textView8 = (TextView) view.findViewById(R.id.tv_end_minutes2);
                                            if (textView8 != null) {
                                                i = R.id.tv_start_hours1;
                                                TextView textView9 = (TextView) view.findViewById(R.id.tv_start_hours1);
                                                if (textView9 != null) {
                                                    i = R.id.tv_start_hours2;
                                                    TextView textView10 = (TextView) view.findViewById(R.id.tv_start_hours2);
                                                    if (textView10 != null) {
                                                        i = R.id.tv_start_minutes1;
                                                        TextView textView11 = (TextView) view.findViewById(R.id.tv_start_minutes1);
                                                        if (textView11 != null) {
                                                            i = R.id.tv_start_minutes2;
                                                            TextView textView12 = (TextView) view.findViewById(R.id.tv_start_minutes2);
                                                            if (textView12 != null) {
                                                                return new FragmentConsultDetailsBinding((ConstraintLayout) view, banner, textView, linearLayoutCompat, textView2, textView3, textView4, textView5, textView6, textView7, textView8, textView9, textView10, textView11, textView12);
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
