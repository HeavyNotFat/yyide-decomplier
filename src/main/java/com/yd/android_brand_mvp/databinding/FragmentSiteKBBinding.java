package com.yd.android_brand_mvp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import com.yd.android_brand_mvp.R;
import com.yd.android_brand_mvp.utils.view.MyGridView;
import com.yd.android_brand_mvp.weight.MultiStateView;

/* JADX INFO: loaded from: classes4.dex */
public final class FragmentSiteKBBinding implements ViewBinding {
    public final MyGridView gvList1;
    public final MyGridView gvList2;
    public final MyGridView gvList3;
    public final MyGridView gvList4;
    public final MyGridView gvList5;
    public final LinearLayout llAfternoon;
    public final LinearLayout llContent;
    public final LinearLayout llForenoon;
    public final LinearLayout llLab;
    public final LinearLayout llMorningReading;
    public final LinearLayout llNight;
    public final LinearLayout llNightWs;
    public final MultiStateView mu;
    public final Button rbMonth;
    public final Button rbTrimester;
    public final Button rbWeek;
    public final LinearLayout rgCheck;
    public final RelativeLayout rlCheck;
    private final LinearLayout rootView;
    public final View v1;
    public final View v2;
    public final View v3;
    public final View v4;
    public final RecyclerView weekRecyclerView;

    private FragmentSiteKBBinding(LinearLayout linearLayout, MyGridView myGridView, MyGridView myGridView2, MyGridView myGridView3, MyGridView myGridView4, MyGridView myGridView5, LinearLayout linearLayout2, LinearLayout linearLayout3, LinearLayout linearLayout4, LinearLayout linearLayout5, LinearLayout linearLayout6, LinearLayout linearLayout7, LinearLayout linearLayout8, MultiStateView multiStateView, Button button, Button button2, Button button3, LinearLayout linearLayout9, RelativeLayout relativeLayout, View view, View view2, View view3, View view4, RecyclerView recyclerView) {
        this.rootView = linearLayout;
        this.gvList1 = myGridView;
        this.gvList2 = myGridView2;
        this.gvList3 = myGridView3;
        this.gvList4 = myGridView4;
        this.gvList5 = myGridView5;
        this.llAfternoon = linearLayout2;
        this.llContent = linearLayout3;
        this.llForenoon = linearLayout4;
        this.llLab = linearLayout5;
        this.llMorningReading = linearLayout6;
        this.llNight = linearLayout7;
        this.llNightWs = linearLayout8;
        this.mu = multiStateView;
        this.rbMonth = button;
        this.rbTrimester = button2;
        this.rbWeek = button3;
        this.rgCheck = linearLayout9;
        this.rlCheck = relativeLayout;
        this.v1 = view;
        this.v2 = view2;
        this.v3 = view3;
        this.v4 = view4;
        this.weekRecyclerView = recyclerView;
    }

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static FragmentSiteKBBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static FragmentSiteKBBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.fragment_site_k_b, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static FragmentSiteKBBinding bind(View view) {
        int i = R.id.gv_list1;
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
                        i = R.id.gv_list5;
                        MyGridView myGridView5 = (MyGridView) view.findViewById(R.id.gv_list5);
                        if (myGridView5 != null) {
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
                                                    i = R.id.ll_night_ws;
                                                    LinearLayout linearLayout7 = (LinearLayout) view.findViewById(R.id.ll_night_ws);
                                                    if (linearLayout7 != null) {
                                                        i = R.id.mu;
                                                        MultiStateView multiStateView = (MultiStateView) view.findViewById(R.id.mu);
                                                        if (multiStateView != null) {
                                                            i = R.id.rb_month;
                                                            Button button = (Button) view.findViewById(R.id.rb_month);
                                                            if (button != null) {
                                                                i = R.id.rb_trimester;
                                                                Button button2 = (Button) view.findViewById(R.id.rb_trimester);
                                                                if (button2 != null) {
                                                                    i = R.id.rb_week;
                                                                    Button button3 = (Button) view.findViewById(R.id.rb_week);
                                                                    if (button3 != null) {
                                                                        i = R.id.rg_check;
                                                                        LinearLayout linearLayout8 = (LinearLayout) view.findViewById(R.id.rg_check);
                                                                        if (linearLayout8 != null) {
                                                                            i = R.id.rl_check;
                                                                            RelativeLayout relativeLayout = (RelativeLayout) view.findViewById(R.id.rl_check);
                                                                            if (relativeLayout != null) {
                                                                                i = R.id.v1;
                                                                                View viewFindViewById = view.findViewById(R.id.v1);
                                                                                if (viewFindViewById != null) {
                                                                                    i = R.id.v2;
                                                                                    View viewFindViewById2 = view.findViewById(R.id.v2);
                                                                                    if (viewFindViewById2 != null) {
                                                                                        i = R.id.v3;
                                                                                        View viewFindViewById3 = view.findViewById(R.id.v3);
                                                                                        if (viewFindViewById3 != null) {
                                                                                            i = R.id.v4;
                                                                                            View viewFindViewById4 = view.findViewById(R.id.v4);
                                                                                            if (viewFindViewById4 != null) {
                                                                                                i = R.id.weekRecyclerView;
                                                                                                RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.weekRecyclerView);
                                                                                                if (recyclerView != null) {
                                                                                                    return new FragmentSiteKBBinding((LinearLayout) view, myGridView, myGridView2, myGridView3, myGridView4, myGridView5, linearLayout, linearLayout2, linearLayout3, linearLayout4, linearLayout5, linearLayout6, linearLayout7, multiStateView, button, button2, button3, linearLayout8, relativeLayout, viewFindViewById, viewFindViewById2, viewFindViewById3, viewFindViewById4, recyclerView);
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
