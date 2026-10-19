package com.yd.android_brand_mvp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import com.yd.android_brand_mvp.R;
import com.youth.banner.Banner;

/* JADX INFO: loaded from: classes4.dex */
public final class FragmentHomeChemistryBinding implements ViewBinding {
    public final Banner bannerFragmentChemistryCourseTeacher;
    public final TextView btnFragmentHomeChemistryCourse;
    public final ConstraintLayout clFragmentChemistryCourseTitle;
    public final ConstraintLayout clFragmentChemistryDeviceTitle;
    public final ConstraintLayout clFragmentHomeChemistryCourseList;
    public final ConstraintLayout clFragmentHomeChemistryDevices;
    public final ImageView ivFragmentChemistryCourseTitle;
    public final ImageView ivFragmentChemistryDeviceTitle;
    public final ImageView ivFragmentHomeChemistrySite;
    public final ProgressBar pbFragmentHomeChemistryCourseAbsence;
    public final ProgressBar pbFragmentHomeChemistryCourseSign;
    private final ConstraintLayout rootView;
    public final RecyclerView rvFragmentChemistryCourseList;
    public final RecyclerView rvFragmentChemistryDevice;
    public final TextView tvFragmentHomeChemistryCourseAbsenceNumber;
    public final TextView tvFragmentHomeChemistryCourseAbsenceTip;
    public final TextView tvFragmentHomeChemistryCourseAbsenceTotal;
    public final TextView tvFragmentHomeChemistryCourseSignNumber;
    public final TextView tvFragmentHomeChemistryCourseSignTip;
    public final TextView tvFragmentHomeChemistryCourseSignTotal;
    public final TextView tvFragmentHomeChemistryCourseTime;
    public final TextView tvFragmentHomeChemistryCourseTip;
    public final TextView tvFragmentHomeChemistryCourseTitle;
    public final TextView tvFragmentHomeChemistrySite;

    private FragmentHomeChemistryBinding(ConstraintLayout constraintLayout, Banner banner, TextView textView, ConstraintLayout constraintLayout2, ConstraintLayout constraintLayout3, ConstraintLayout constraintLayout4, ConstraintLayout constraintLayout5, ImageView imageView, ImageView imageView2, ImageView imageView3, ProgressBar progressBar, ProgressBar progressBar2, RecyclerView recyclerView, RecyclerView recyclerView2, TextView textView2, TextView textView3, TextView textView4, TextView textView5, TextView textView6, TextView textView7, TextView textView8, TextView textView9, TextView textView10, TextView textView11) {
        this.rootView = constraintLayout;
        this.bannerFragmentChemistryCourseTeacher = banner;
        this.btnFragmentHomeChemistryCourse = textView;
        this.clFragmentChemistryCourseTitle = constraintLayout2;
        this.clFragmentChemistryDeviceTitle = constraintLayout3;
        this.clFragmentHomeChemistryCourseList = constraintLayout4;
        this.clFragmentHomeChemistryDevices = constraintLayout5;
        this.ivFragmentChemistryCourseTitle = imageView;
        this.ivFragmentChemistryDeviceTitle = imageView2;
        this.ivFragmentHomeChemistrySite = imageView3;
        this.pbFragmentHomeChemistryCourseAbsence = progressBar;
        this.pbFragmentHomeChemistryCourseSign = progressBar2;
        this.rvFragmentChemistryCourseList = recyclerView;
        this.rvFragmentChemistryDevice = recyclerView2;
        this.tvFragmentHomeChemistryCourseAbsenceNumber = textView2;
        this.tvFragmentHomeChemistryCourseAbsenceTip = textView3;
        this.tvFragmentHomeChemistryCourseAbsenceTotal = textView4;
        this.tvFragmentHomeChemistryCourseSignNumber = textView5;
        this.tvFragmentHomeChemistryCourseSignTip = textView6;
        this.tvFragmentHomeChemistryCourseSignTotal = textView7;
        this.tvFragmentHomeChemistryCourseTime = textView8;
        this.tvFragmentHomeChemistryCourseTip = textView9;
        this.tvFragmentHomeChemistryCourseTitle = textView10;
        this.tvFragmentHomeChemistrySite = textView11;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static FragmentHomeChemistryBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static FragmentHomeChemistryBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.fragment_home_chemistry, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static FragmentHomeChemistryBinding bind(View view) {
        int i = R.id.banner_fragment_chemistry_course_teacher;
        Banner banner = (Banner) view.findViewById(R.id.banner_fragment_chemistry_course_teacher);
        if (banner != null) {
            i = R.id.btn_fragment_home_chemistry_course;
            TextView textView = (TextView) view.findViewById(R.id.btn_fragment_home_chemistry_course);
            if (textView != null) {
                i = R.id.cl_fragment_chemistry_course_title;
                ConstraintLayout constraintLayout = (ConstraintLayout) view.findViewById(R.id.cl_fragment_chemistry_course_title);
                if (constraintLayout != null) {
                    i = R.id.cl_fragment_chemistry_device_title;
                    ConstraintLayout constraintLayout2 = (ConstraintLayout) view.findViewById(R.id.cl_fragment_chemistry_device_title);
                    if (constraintLayout2 != null) {
                        i = R.id.cl_fragment_home_chemistry_course_list;
                        ConstraintLayout constraintLayout3 = (ConstraintLayout) view.findViewById(R.id.cl_fragment_home_chemistry_course_list);
                        if (constraintLayout3 != null) {
                            i = R.id.cl_fragment_home_chemistry_devices;
                            ConstraintLayout constraintLayout4 = (ConstraintLayout) view.findViewById(R.id.cl_fragment_home_chemistry_devices);
                            if (constraintLayout4 != null) {
                                i = R.id.iv_fragment_chemistry_course_title;
                                ImageView imageView = (ImageView) view.findViewById(R.id.iv_fragment_chemistry_course_title);
                                if (imageView != null) {
                                    i = R.id.iv_fragment_chemistry_device_title;
                                    ImageView imageView2 = (ImageView) view.findViewById(R.id.iv_fragment_chemistry_device_title);
                                    if (imageView2 != null) {
                                        i = R.id.iv_fragment_home_chemistry_site;
                                        ImageView imageView3 = (ImageView) view.findViewById(R.id.iv_fragment_home_chemistry_site);
                                        if (imageView3 != null) {
                                            i = R.id.pb_fragment_home_chemistry_course_absence;
                                            ProgressBar progressBar = (ProgressBar) view.findViewById(R.id.pb_fragment_home_chemistry_course_absence);
                                            if (progressBar != null) {
                                                i = R.id.pb_fragment_home_chemistry_course_sign;
                                                ProgressBar progressBar2 = (ProgressBar) view.findViewById(R.id.pb_fragment_home_chemistry_course_sign);
                                                if (progressBar2 != null) {
                                                    i = R.id.rv_fragment_chemistry_course_list;
                                                    RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.rv_fragment_chemistry_course_list);
                                                    if (recyclerView != null) {
                                                        i = R.id.rv_fragment_chemistry_device;
                                                        RecyclerView recyclerView2 = (RecyclerView) view.findViewById(R.id.rv_fragment_chemistry_device);
                                                        if (recyclerView2 != null) {
                                                            i = R.id.tv_fragment_home_chemistry_course_absence_number;
                                                            TextView textView2 = (TextView) view.findViewById(R.id.tv_fragment_home_chemistry_course_absence_number);
                                                            if (textView2 != null) {
                                                                i = R.id.tv_fragment_home_chemistry_course_absence_tip;
                                                                TextView textView3 = (TextView) view.findViewById(R.id.tv_fragment_home_chemistry_course_absence_tip);
                                                                if (textView3 != null) {
                                                                    i = R.id.tv_fragment_home_chemistry_course_absence_total;
                                                                    TextView textView4 = (TextView) view.findViewById(R.id.tv_fragment_home_chemistry_course_absence_total);
                                                                    if (textView4 != null) {
                                                                        i = R.id.tv_fragment_home_chemistry_course_sign_number;
                                                                        TextView textView5 = (TextView) view.findViewById(R.id.tv_fragment_home_chemistry_course_sign_number);
                                                                        if (textView5 != null) {
                                                                            i = R.id.tv_fragment_home_chemistry_course_sign_tip;
                                                                            TextView textView6 = (TextView) view.findViewById(R.id.tv_fragment_home_chemistry_course_sign_tip);
                                                                            if (textView6 != null) {
                                                                                i = R.id.tv_fragment_home_chemistry_course_sign_total;
                                                                                TextView textView7 = (TextView) view.findViewById(R.id.tv_fragment_home_chemistry_course_sign_total);
                                                                                if (textView7 != null) {
                                                                                    i = R.id.tv_fragment_home_chemistry_course_time;
                                                                                    TextView textView8 = (TextView) view.findViewById(R.id.tv_fragment_home_chemistry_course_time);
                                                                                    if (textView8 != null) {
                                                                                        i = R.id.tv_fragment_home_chemistry_course_tip;
                                                                                        TextView textView9 = (TextView) view.findViewById(R.id.tv_fragment_home_chemistry_course_tip);
                                                                                        if (textView9 != null) {
                                                                                            i = R.id.tv_fragment_home_chemistry_course_title;
                                                                                            TextView textView10 = (TextView) view.findViewById(R.id.tv_fragment_home_chemistry_course_title);
                                                                                            if (textView10 != null) {
                                                                                                i = R.id.tv_fragment_home_chemistry_site;
                                                                                                TextView textView11 = (TextView) view.findViewById(R.id.tv_fragment_home_chemistry_site);
                                                                                                if (textView11 != null) {
                                                                                                    return new FragmentHomeChemistryBinding((ConstraintLayout) view, banner, textView, constraintLayout, constraintLayout2, constraintLayout3, constraintLayout4, imageView, imageView2, imageView3, progressBar, progressBar2, recyclerView, recyclerView2, textView2, textView3, textView4, textView5, textView6, textView7, textView8, textView9, textView10, textView11);
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
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
