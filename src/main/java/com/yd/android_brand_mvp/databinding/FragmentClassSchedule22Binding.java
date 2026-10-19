package com.yd.android_brand_mvp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckedTextView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import com.yd.android_brand_mvp.R;
import com.yd.android_brand_mvp.utils.view.MyGridView;
import com.yd.android_brand_mvp.weight.MultiStateView;

/* JADX INFO: loaded from: classes4.dex */
public final class FragmentClassSchedule22Binding implements ViewBinding {
    public final TextView checkbox;
    public final MyGridView gvList1;
    public final MyGridView gvList2;
    public final MyGridView gvList3;
    public final MyGridView gvList4;
    public final LinearLayout llAfternoon;
    public final LinearLayout llContent;
    public final LinearLayout llForenoon;
    public final LinearLayout llLab;
    public final LinearLayout llMorningReading;
    public final LinearLayout llNight;
    public final MultiStateView mu;
    public final Button rbMonth;
    public final CheckedTextView rbTrimester;
    public final CheckedTextView rbWeek;
    public final LinearLayout rgCheck;
    public final RelativeLayout rlCheck;
    public final RelativeLayout rlRb;
    private final LinearLayout rootView;
    public final TextView titleName;
    public final TextView tvSaturday;
    public final TextView tvSunday;
    public final View v1;
    public final View v2;
    public final View v3;
    public final TextView week;

    private FragmentClassSchedule22Binding(LinearLayout linearLayout, TextView textView, MyGridView myGridView, MyGridView myGridView2, MyGridView myGridView3, MyGridView myGridView4, LinearLayout linearLayout2, LinearLayout linearLayout3, LinearLayout linearLayout4, LinearLayout linearLayout5, LinearLayout linearLayout6, LinearLayout linearLayout7, MultiStateView multiStateView, Button button, CheckedTextView checkedTextView, CheckedTextView checkedTextView2, LinearLayout linearLayout8, RelativeLayout relativeLayout, RelativeLayout relativeLayout2, TextView textView2, TextView textView3, TextView textView4, View view, View view2, View view3, TextView textView5) {
        this.rootView = linearLayout;
        this.checkbox = textView;
        this.gvList1 = myGridView;
        this.gvList2 = myGridView2;
        this.gvList3 = myGridView3;
        this.gvList4 = myGridView4;
        this.llAfternoon = linearLayout2;
        this.llContent = linearLayout3;
        this.llForenoon = linearLayout4;
        this.llLab = linearLayout5;
        this.llMorningReading = linearLayout6;
        this.llNight = linearLayout7;
        this.mu = multiStateView;
        this.rbMonth = button;
        this.rbTrimester = checkedTextView;
        this.rbWeek = checkedTextView2;
        this.rgCheck = linearLayout8;
        this.rlCheck = relativeLayout;
        this.rlRb = relativeLayout2;
        this.titleName = textView2;
        this.tvSaturday = textView3;
        this.tvSunday = textView4;
        this.v1 = view;
        this.v2 = view2;
        this.v3 = view3;
        this.week = textView5;
    }

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static FragmentClassSchedule22Binding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static FragmentClassSchedule22Binding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.fragment_class_schedule22, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static FragmentClassSchedule22Binding bind(View view) {
        int i = R.id.checkbox;
        TextView textView = (TextView) view.findViewById(R.id.checkbox);
        if (textView != null) {
            i = R.id.gv_list1;
            MyGridView myGridView = (MyGridView) view.findViewById(R.id.gv_list1);
            if (myGridView != null) {
                i = R.id.gv_list2;
                MyGridView myGridView2 = (MyGridView) view.findViewById(R.id.gv_list2);
                if (myGridView2 != null) {
                    i = R.id.gv_list3;
                    MyGridView myGridView3 = (MyGridView) view.findViewById(R.id.gv_list3);
                    if (myGridView3 != null) {
                        i = R.id.gv_list4;
                        MyGridView myGridView4 = (MyGridView) view.findViewById(R.id.gv_list4);
                        if (myGridView4 != null) {
                            i = R.id.ll_afternoon;
                            LinearLayout linearLayout = (LinearLayout) view.findViewById(R.id.ll_afternoon);
                            if (linearLayout != null) {
                                i = R.id.ll_content;
                                LinearLayout linearLayout2 = (LinearLayout) view.findViewById(R.id.ll_content);
                                if (linearLayout2 != null) {
                                    i = R.id.ll_forenoon;
                                    LinearLayout linearLayout3 = (LinearLayout) view.findViewById(R.id.ll_forenoon);
                                    if (linearLayout3 != null) {
                                        i = R.id.ll_lab;
                                        LinearLayout linearLayout4 = (LinearLayout) view.findViewById(R.id.ll_lab);
                                        if (linearLayout4 != null) {
                                            i = R.id.ll_morning_reading;
                                            LinearLayout linearLayout5 = (LinearLayout) view.findViewById(R.id.ll_morning_reading);
                                            if (linearLayout5 != null) {
                                                i = R.id.ll_night;
                                                LinearLayout linearLayout6 = (LinearLayout) view.findViewById(R.id.ll_night);
                                                if (linearLayout6 != null) {
                                                    i = R.id.mu;
                                                    MultiStateView multiStateView = (MultiStateView) view.findViewById(R.id.mu);
                                                    if (multiStateView != null) {
                                                        i = R.id.rb_month;
                                                        Button button = (Button) view.findViewById(R.id.rb_month);
                                                        if (button != null) {
                                                            i = R.id.rb_trimester;
                                                            CheckedTextView checkedTextView = (CheckedTextView) view.findViewById(R.id.rb_trimester);
                                                            if (checkedTextView != null) {
                                                                i = R.id.rb_week;
                                                                CheckedTextView checkedTextView2 = (CheckedTextView) view.findViewById(R.id.rb_week);
                                                                if (checkedTextView2 != null) {
                                                                    i = R.id.rg_check;
                                                                    LinearLayout linearLayout7 = (LinearLayout) view.findViewById(R.id.rg_check);
                                                                    if (linearLayout7 != null) {
                                                                        i = R.id.rl_check;
                                                                        RelativeLayout relativeLayout = (RelativeLayout) view.findViewById(R.id.rl_check);
                                                                        if (relativeLayout != null) {
                                                                            i = R.id.rl_rb;
                                                                            RelativeLayout relativeLayout2 = (RelativeLayout) view.findViewById(R.id.rl_rb);
                                                                            if (relativeLayout2 != null) {
                                                                                i = R.id.title_Name;
                                                                                TextView textView2 = (TextView) view.findViewById(R.id.title_Name);
                                                                                if (textView2 != null) {
                                                                                    i = R.id.tv_saturday;
                                                                                    TextView textView3 = (TextView) view.findViewById(R.id.tv_saturday);
                                                                                    if (textView3 != null) {
                                                                                        i = R.id.tv_sunday;
                                                                                        TextView textView4 = (TextView) view.findViewById(R.id.tv_sunday);
                                                                                        if (textView4 != null) {
                                                                                            i = R.id.v1;
                                                                                            View viewFindViewById = view.findViewById(R.id.v1);
                                                                                            if (viewFindViewById != null) {
                                                                                                i = R.id.v2;
                                                                                                View viewFindViewById2 = view.findViewById(R.id.v2);
                                                                                                if (viewFindViewById2 != null) {
                                                                                                    i = R.id.v3;
                                                                                                    View viewFindViewById3 = view.findViewById(R.id.v3);
                                                                                                    if (viewFindViewById3 != null) {
                                                                                                        i = R.id.week;
                                                                                                        TextView textView5 = (TextView) view.findViewById(R.id.week);
                                                                                                        if (textView5 != null) {
                                                                                                            return new FragmentClassSchedule22Binding((LinearLayout) view, textView, myGridView, myGridView2, myGridView3, myGridView4, linearLayout, linearLayout2, linearLayout3, linearLayout4, linearLayout5, linearLayout6, multiStateView, button, checkedTextView, checkedTextView2, linearLayout7, relativeLayout, relativeLayout2, textView2, textView3, textView4, viewFindViewById, viewFindViewById2, viewFindViewById3, textView5);
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
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
