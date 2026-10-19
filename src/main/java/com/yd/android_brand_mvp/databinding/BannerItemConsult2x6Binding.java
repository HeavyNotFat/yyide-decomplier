package com.yd.android_brand_mvp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.viewbinding.ViewBinding;
import com.yd.android_brand_mvp.R;

/* JADX INFO: loaded from: classes4.dex */
public final class BannerItemConsult2x6Binding implements ViewBinding {
    public final TextView btnFragmentHomeChemistryCourse;
    public final ImageView ivHead;
    private final LinearLayoutCompat rootView;
    public final TextView tvConsultCreateName;
    public final TextView tvConsultDate;
    public final TextView tvConsultName;
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

    private BannerItemConsult2x6Binding(LinearLayoutCompat linearLayoutCompat, TextView textView, ImageView imageView, TextView textView2, TextView textView3, TextView textView4, TextView textView5, TextView textView6, TextView textView7, TextView textView8, TextView textView9, TextView textView10, TextView textView11, TextView textView12, TextView textView13, TextView textView14) {
        this.rootView = linearLayoutCompat;
        this.btnFragmentHomeChemistryCourse = textView;
        this.ivHead = imageView;
        this.tvConsultCreateName = textView2;
        this.tvConsultDate = textView3;
        this.tvConsultName = textView4;
        this.tvConsultStatus = textView5;
        this.tvConsultTitle = textView6;
        this.tvEndHours1 = textView7;
        this.tvEndHours2 = textView8;
        this.tvEndMinutes1 = textView9;
        this.tvEndMinutes2 = textView10;
        this.tvStartHours1 = textView11;
        this.tvStartHours2 = textView12;
        this.tvStartMinutes1 = textView13;
        this.tvStartMinutes2 = textView14;
    }

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayoutCompat getRoot() {
        return this.rootView;
    }

    public static BannerItemConsult2x6Binding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static BannerItemConsult2x6Binding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.banner_item_consult_2x6, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static BannerItemConsult2x6Binding bind(View view) {
        int i = R.id.btn_fragment_home_chemistry_course;
        TextView textView = (TextView) view.findViewById(R.id.btn_fragment_home_chemistry_course);
        if (textView != null) {
            i = R.id.iv_head;
            ImageView imageView = (ImageView) view.findViewById(R.id.iv_head);
            if (imageView != null) {
                i = R.id.tv_consult_create_name;
                TextView textView2 = (TextView) view.findViewById(R.id.tv_consult_create_name);
                if (textView2 != null) {
                    i = R.id.tv_consult_date;
                    TextView textView3 = (TextView) view.findViewById(R.id.tv_consult_date);
                    if (textView3 != null) {
                        i = R.id.tv_consult_name;
                        TextView textView4 = (TextView) view.findViewById(R.id.tv_consult_name);
                        if (textView4 != null) {
                            i = R.id.tv_consult_status;
                            TextView textView5 = (TextView) view.findViewById(R.id.tv_consult_status);
                            if (textView5 != null) {
                                i = R.id.tv_consult_title;
                                TextView textView6 = (TextView) view.findViewById(R.id.tv_consult_title);
                                if (textView6 != null) {
                                    i = R.id.tv_end_hours1;
                                    TextView textView7 = (TextView) view.findViewById(R.id.tv_end_hours1);
                                    if (textView7 != null) {
                                        i = R.id.tv_end_hours2;
                                        TextView textView8 = (TextView) view.findViewById(R.id.tv_end_hours2);
                                        if (textView8 != null) {
                                            i = R.id.tv_end_minutes1;
                                            TextView textView9 = (TextView) view.findViewById(R.id.tv_end_minutes1);
                                            if (textView9 != null) {
                                                i = R.id.tv_end_minutes2;
                                                TextView textView10 = (TextView) view.findViewById(R.id.tv_end_minutes2);
                                                if (textView10 != null) {
                                                    i = R.id.tv_start_hours1;
                                                    TextView textView11 = (TextView) view.findViewById(R.id.tv_start_hours1);
                                                    if (textView11 != null) {
                                                        i = R.id.tv_start_hours2;
                                                        TextView textView12 = (TextView) view.findViewById(R.id.tv_start_hours2);
                                                        if (textView12 != null) {
                                                            i = R.id.tv_start_minutes1;
                                                            TextView textView13 = (TextView) view.findViewById(R.id.tv_start_minutes1);
                                                            if (textView13 != null) {
                                                                i = R.id.tv_start_minutes2;
                                                                TextView textView14 = (TextView) view.findViewById(R.id.tv_start_minutes2);
                                                                if (textView14 != null) {
                                                                    return new BannerItemConsult2x6Binding((LinearLayoutCompat) view, textView, imageView, textView2, textView3, textView4, textView5, textView6, textView7, textView8, textView9, textView10, textView11, textView12, textView13, textView14);
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
