package com.yd.android_brand_mvp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import com.contrarywind.view.WheelView;
import com.yd.android_brand_mvp.R;

/* JADX INFO: loaded from: classes4.dex */
public final class TimeSelectBinding implements ViewBinding {
    public final Button btnCancel;
    public final Button btnSubmit;
    public final WheelView day;
    public final WheelView hour;
    public final WheelView min;
    public final WheelView month;
    private final LinearLayout rootView;
    public final View rvTopbar;
    public final WheelView second;
    public final LinearLayout timepicker;
    public final TextView tvTitle;
    public final WheelView year;

    private TimeSelectBinding(LinearLayout linearLayout, Button button, Button button2, WheelView wheelView, WheelView wheelView2, WheelView wheelView3, WheelView wheelView4, View view, WheelView wheelView5, LinearLayout linearLayout2, TextView textView, WheelView wheelView6) {
        this.rootView = linearLayout;
        this.btnCancel = button;
        this.btnSubmit = button2;
        this.day = wheelView;
        this.hour = wheelView2;
        this.min = wheelView3;
        this.month = wheelView4;
        this.rvTopbar = view;
        this.second = wheelView5;
        this.timepicker = linearLayout2;
        this.tvTitle = textView;
        this.year = wheelView6;
    }

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static TimeSelectBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static TimeSelectBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.time_select, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static TimeSelectBinding bind(View view) {
        int i = R.id.btnCancel;
        Button button = (Button) view.findViewById(R.id.btnCancel);
        if (button != null) {
            i = R.id.btnSubmit;
            Button button2 = (Button) view.findViewById(R.id.btnSubmit);
            if (button2 != null) {
                i = R.id.day;
                WheelView wheelView = (WheelView) view.findViewById(R.id.day);
                if (wheelView != null) {
                    i = R.id.hour;
                    WheelView wheelView2 = (WheelView) view.findViewById(R.id.hour);
                    if (wheelView2 != null) {
                        i = R.id.min;
                        WheelView wheelView3 = (WheelView) view.findViewById(R.id.min);
                        if (wheelView3 != null) {
                            i = R.id.month;
                            WheelView wheelView4 = (WheelView) view.findViewById(R.id.month);
                            if (wheelView4 != null) {
                                i = R.id.rv_topbar;
                                View viewFindViewById = view.findViewById(R.id.rv_topbar);
                                if (viewFindViewById != null) {
                                    i = R.id.second;
                                    WheelView wheelView5 = (WheelView) view.findViewById(R.id.second);
                                    if (wheelView5 != null) {
                                        i = R.id.timepicker;
                                        LinearLayout linearLayout = (LinearLayout) view.findViewById(R.id.timepicker);
                                        if (linearLayout != null) {
                                            i = R.id.tvTitle;
                                            TextView textView = (TextView) view.findViewById(R.id.tvTitle);
                                            if (textView != null) {
                                                i = R.id.year;
                                                WheelView wheelView6 = (WheelView) view.findViewById(R.id.year);
                                                if (wheelView6 != null) {
                                                    return new TimeSelectBinding((LinearLayout) view, button, button2, wheelView, wheelView2, wheelView3, wheelView4, viewFindViewById, wheelView5, linearLayout, textView, wheelView6);
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
