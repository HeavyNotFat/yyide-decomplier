package com.yd.android_brand_mvp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import com.github.mikephil.charting.charts.PieChart;
import com.yd.android_brand_mvp.R;

/* JADX INFO: loaded from: classes4.dex */
public final class FragmentAttenceL2x2Binding implements ViewBinding {
    public final LinearLayout content;
    public final LinearLayout llItem;
    public final PieChart piechart;
    public final TextView post;
    public final RelativeLayout rlItem;
    private final FrameLayout rootView;
    public final TextView s1;
    public final TextView s2;
    public final TextView s3;
    public final TextView s4;
    public final TextView tv1;
    public final TextView tv2;
    public final TextView tv3;
    public final TextView tv4;
    public final TextView tvName;
    public final TextView tvTime;
    public final TextView y1;
    public final TextView y2;
    public final TextView y3;
    public final TextView y4;

    private FragmentAttenceL2x2Binding(FrameLayout frameLayout, LinearLayout linearLayout, LinearLayout linearLayout2, PieChart pieChart, TextView textView, RelativeLayout relativeLayout, TextView textView2, TextView textView3, TextView textView4, TextView textView5, TextView textView6, TextView textView7, TextView textView8, TextView textView9, TextView textView10, TextView textView11, TextView textView12, TextView textView13, TextView textView14, TextView textView15) {
        this.rootView = frameLayout;
        this.content = linearLayout;
        this.llItem = linearLayout2;
        this.piechart = pieChart;
        this.post = textView;
        this.rlItem = relativeLayout;
        this.s1 = textView2;
        this.s2 = textView3;
        this.s3 = textView4;
        this.s4 = textView5;
        this.tv1 = textView6;
        this.tv2 = textView7;
        this.tv3 = textView8;
        this.tv4 = textView9;
        this.tvName = textView10;
        this.tvTime = textView11;
        this.y1 = textView12;
        this.y2 = textView13;
        this.y3 = textView14;
        this.y4 = textView15;
    }

    @Override // androidx.viewbinding.ViewBinding
    public FrameLayout getRoot() {
        return this.rootView;
    }

    public static FragmentAttenceL2x2Binding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static FragmentAttenceL2x2Binding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.fragment_attence_l2x2, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static FragmentAttenceL2x2Binding bind(View view) {
        int i = R.id.content;
        LinearLayout linearLayout = (LinearLayout) view.findViewById(R.id.content);
        if (linearLayout != null) {
            i = R.id.ll_item;
            LinearLayout linearLayout2 = (LinearLayout) view.findViewById(R.id.ll_item);
            if (linearLayout2 != null) {
                i = R.id.piechart;
                PieChart pieChart = (PieChart) view.findViewById(R.id.piechart);
                if (pieChart != null) {
                    i = R.id.post;
                    TextView textView = (TextView) view.findViewById(R.id.post);
                    if (textView != null) {
                        i = R.id.rl_item;
                        RelativeLayout relativeLayout = (RelativeLayout) view.findViewById(R.id.rl_item);
                        if (relativeLayout != null) {
                            i = R.id.s1;
                            TextView textView2 = (TextView) view.findViewById(R.id.s1);
                            if (textView2 != null) {
                                i = R.id.s2;
                                TextView textView3 = (TextView) view.findViewById(R.id.s2);
                                if (textView3 != null) {
                                    i = R.id.s3;
                                    TextView textView4 = (TextView) view.findViewById(R.id.s3);
                                    if (textView4 != null) {
                                        i = R.id.s4;
                                        TextView textView5 = (TextView) view.findViewById(R.id.s4);
                                        if (textView5 != null) {
                                            i = R.id.tv1;
                                            TextView textView6 = (TextView) view.findViewById(R.id.tv1);
                                            if (textView6 != null) {
                                                i = R.id.tv2;
                                                TextView textView7 = (TextView) view.findViewById(R.id.tv2);
                                                if (textView7 != null) {
                                                    i = R.id.tv3;
                                                    TextView textView8 = (TextView) view.findViewById(R.id.tv3);
                                                    if (textView8 != null) {
                                                        i = R.id.tv4;
                                                        TextView textView9 = (TextView) view.findViewById(R.id.tv4);
                                                        if (textView9 != null) {
                                                            i = R.id.tv_name;
                                                            TextView textView10 = (TextView) view.findViewById(R.id.tv_name);
                                                            if (textView10 != null) {
                                                                i = R.id.tv_time;
                                                                TextView textView11 = (TextView) view.findViewById(R.id.tv_time);
                                                                if (textView11 != null) {
                                                                    i = R.id.y1;
                                                                    TextView textView12 = (TextView) view.findViewById(R.id.y1);
                                                                    if (textView12 != null) {
                                                                        i = R.id.y2;
                                                                        TextView textView13 = (TextView) view.findViewById(R.id.y2);
                                                                        if (textView13 != null) {
                                                                            i = R.id.y3;
                                                                            TextView textView14 = (TextView) view.findViewById(R.id.y3);
                                                                            if (textView14 != null) {
                                                                                i = R.id.y4;
                                                                                TextView textView15 = (TextView) view.findViewById(R.id.y4);
                                                                                if (textView15 != null) {
                                                                                    return new FragmentAttenceL2x2Binding((FrameLayout) view, linearLayout, linearLayout2, pieChart, textView, relativeLayout, textView2, textView3, textView4, textView5, textView6, textView7, textView8, textView9, textView10, textView11, textView12, textView13, textView14, textView15);
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
