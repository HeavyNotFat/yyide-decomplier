package com.yd.android_brand_mvp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import com.necer.calendar.MonthCalendar;
import com.yd.android_brand_mvp.R;
import com.yd.android_brand_mvp.weight.MultiStateView;

/* JADX INFO: loaded from: classes4.dex */
public final class FragmentNcalendar25LBinding implements ViewBinding {
    public final MultiStateView allMu;
    public final RelativeLayout bg;
    public final MonthCalendar calendar;
    public final TextView leftMonth;
    public final ListView listview;
    public final TextView month;
    public final MultiStateView mu;
    public final TextView rightMonth;
    private final RelativeLayout rootView;
    public final TextView schoolyear;
    public final LinearLayout topLayout;

    private FragmentNcalendar25LBinding(RelativeLayout relativeLayout, MultiStateView multiStateView, RelativeLayout relativeLayout2, MonthCalendar monthCalendar, TextView textView, ListView listView, TextView textView2, MultiStateView multiStateView2, TextView textView3, TextView textView4, LinearLayout linearLayout) {
        this.rootView = relativeLayout;
        this.allMu = multiStateView;
        this.bg = relativeLayout2;
        this.calendar = monthCalendar;
        this.leftMonth = textView;
        this.listview = listView;
        this.month = textView2;
        this.mu = multiStateView2;
        this.rightMonth = textView3;
        this.schoolyear = textView4;
        this.topLayout = linearLayout;
    }

    @Override // androidx.viewbinding.ViewBinding
    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static FragmentNcalendar25LBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static FragmentNcalendar25LBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.fragment_ncalendar_2_5_l, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static FragmentNcalendar25LBinding bind(View view) {
        int i = R.id.all_mu;
        MultiStateView multiStateView = (MultiStateView) view.findViewById(R.id.all_mu);
        if (multiStateView != null) {
            i = R.id.bg;
            RelativeLayout relativeLayout = (RelativeLayout) view.findViewById(R.id.bg);
            if (relativeLayout != null) {
                i = R.id.calendar;
                MonthCalendar monthCalendar = (MonthCalendar) view.findViewById(R.id.calendar);
                if (monthCalendar != null) {
                    i = R.id.left_month;
                    TextView textView = (TextView) view.findViewById(R.id.left_month);
                    if (textView != null) {
                        i = R.id.listview;
                        ListView listView = (ListView) view.findViewById(R.id.listview);
                        if (listView != null) {
                            i = R.id.month;
                            TextView textView2 = (TextView) view.findViewById(R.id.month);
                            if (textView2 != null) {
                                i = R.id.mu;
                                MultiStateView multiStateView2 = (MultiStateView) view.findViewById(R.id.mu);
                                if (multiStateView2 != null) {
                                    i = R.id.right_month;
                                    TextView textView3 = (TextView) view.findViewById(R.id.right_month);
                                    if (textView3 != null) {
                                        i = R.id.schoolyear;
                                        TextView textView4 = (TextView) view.findViewById(R.id.schoolyear);
                                        if (textView4 != null) {
                                            i = R.id.top_layout;
                                            LinearLayout linearLayout = (LinearLayout) view.findViewById(R.id.top_layout);
                                            if (linearLayout != null) {
                                                return new FragmentNcalendar25LBinding((RelativeLayout) view, multiStateView, relativeLayout, monthCalendar, textView, listView, textView2, multiStateView2, textView3, textView4, linearLayout);
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
