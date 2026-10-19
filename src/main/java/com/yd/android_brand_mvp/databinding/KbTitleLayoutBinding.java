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
public final class KbTitleLayoutBinding implements ViewBinding {
    public final FrameLayout backLayout;
    public final TextView checkbox;
    public final Button rbTrimester;
    public final Button rbWeek;
    public final LinearLayout rgCheck;
    public final RelativeLayout rlCheck;
    public final RelativeLayout rlRb;
    private final LinearLayout rootView;
    public final TextView titleName;
    public final TextView week;

    private KbTitleLayoutBinding(LinearLayout linearLayout, FrameLayout frameLayout, TextView textView, Button button, Button button2, LinearLayout linearLayout2, RelativeLayout relativeLayout, RelativeLayout relativeLayout2, TextView textView2, TextView textView3) {
        this.rootView = linearLayout;
        this.backLayout = frameLayout;
        this.checkbox = textView;
        this.rbTrimester = button;
        this.rbWeek = button2;
        this.rgCheck = linearLayout2;
        this.rlCheck = relativeLayout;
        this.rlRb = relativeLayout2;
        this.titleName = textView2;
        this.week = textView3;
    }

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static KbTitleLayoutBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static KbTitleLayoutBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.kb_title_layout, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static KbTitleLayoutBinding bind(View view) {
        int i = R.id.back_layout;
        FrameLayout frameLayout = (FrameLayout) view.findViewById(R.id.back_layout);
        if (frameLayout != null) {
            i = R.id.checkbox;
            TextView textView = (TextView) view.findViewById(R.id.checkbox);
            if (textView != null) {
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
                                    TextView textView2 = (TextView) view.findViewById(R.id.title_Name);
                                    if (textView2 != null) {
                                        i = R.id.week;
                                        TextView textView3 = (TextView) view.findViewById(R.id.week);
                                        if (textView3 != null) {
                                            return new KbTitleLayoutBinding((LinearLayout) view, frameLayout, textView, button, button2, linearLayout, relativeLayout, relativeLayout2, textView2, textView3);
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
