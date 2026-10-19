package com.yd.android_brand_mvp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import com.yd.android_brand_mvp.R;

/* JADX INFO: loaded from: classes4.dex */
public final class ScheduleTitleLayoutBinding implements ViewBinding {
    public final FrameLayout backLayout;
    public final TextView checkbox;
    public final FrameLayout layoutTop;
    public final TextView left;
    public final Button rbTrimester;
    public final Button rbWeek;
    public final LinearLayout rgCheck;
    public final RelativeLayout rlCheck;
    public final RelativeLayout rlRb;
    private final LinearLayout rootView;
    public final TextView titleName;
    public final TextView week;

    private ScheduleTitleLayoutBinding(LinearLayout linearLayout, FrameLayout frameLayout, TextView textView, FrameLayout frameLayout2, TextView textView2, Button button, Button button2, LinearLayout linearLayout2, RelativeLayout relativeLayout, RelativeLayout relativeLayout2, TextView textView3, TextView textView4) {
        this.rootView = linearLayout;
        this.backLayout = frameLayout;
        this.checkbox = textView;
        this.layoutTop = frameLayout2;
        this.left = textView2;
        this.rbTrimester = button;
        this.rbWeek = button2;
        this.rgCheck = linearLayout2;
        this.rlCheck = relativeLayout;
        this.rlRb = relativeLayout2;
        this.titleName = textView3;
        this.week = textView4;
    }

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static ScheduleTitleLayoutBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static ScheduleTitleLayoutBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.schedule_title_layout, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static ScheduleTitleLayoutBinding bind(View view) {
        int i = R.id.back_layout;
        FrameLayout frameLayout = (FrameLayout) view.findViewById(R.id.back_layout);
        if (frameLayout != null) {
            i = R.id.checkbox;
            TextView textView = (TextView) view.findViewById(R.id.checkbox);
            if (textView != null) {
                i = R.id.layoutTop;
                FrameLayout frameLayout2 = (FrameLayout) view.findViewById(R.id.layoutTop);
                if (frameLayout2 != null) {
                    i = R.id.left;
                    TextView textView2 = (TextView) view.findViewById(R.id.left);
                    if (textView2 != null) {
                        i = R.id.rb_trimester;
                        Button button = (Button) view.findViewById(R.id.rb_trimester);
                        if (button != null) {
                            i = R.id.rb_week;
                            Button button2 = (Button) view.findViewById(R.id.rb_week);
                            if (button2 != null) {
                                i = R.id.rg_check;
                                LinearLayout linearLayout = (LinearLayout) view.findViewById(R.id.rg_check);
                                if (linearLayout != null) {
                                    i = R.id.rl_check;
                                    RelativeLayout relativeLayout = (RelativeLayout) view.findViewById(R.id.rl_check);
                                    if (relativeLayout != null) {
                                        i = R.id.rl_rb;
                                        RelativeLayout relativeLayout2 = (RelativeLayout) view.findViewById(R.id.rl_rb);
                                        if (relativeLayout2 != null) {
                                            i = R.id.title_Name;
                                            TextView textView3 = (TextView) view.findViewById(R.id.title_Name);
                                            if (textView3 != null) {
                                                i = R.id.week;
                                                TextView textView4 = (TextView) view.findViewById(R.id.week);
                                                if (textView4 != null) {
                                                    return new ScheduleTitleLayoutBinding((LinearLayout) view, frameLayout, textView, frameLayout2, textView2, button, button2, linearLayout, relativeLayout, relativeLayout2, textView3, textView4);
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
