package com.yd.android_brand_mvp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RadioGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import com.yd.android_brand_mvp.R;
import com.yd.android_brand_mvp.utils.view.DrawableCenterRadioButton;

/* JADX INFO: loaded from: classes4.dex */
public final class FragmentAssignmentWeekPBinding implements ViewBinding {
    public final DrawableCenterRadioButton rbFri;
    public final DrawableCenterRadioButton rbMonday;
    public final DrawableCenterRadioButton rbSat;
    public final DrawableCenterRadioButton rbThursday;
    public final DrawableCenterRadioButton rbTuesday;
    public final DrawableCenterRadioButton rbWednesday;
    public final DrawableCenterRadioButton rbWeek;
    public final RadioGroup rgCheck;
    public final RecyclerView rlList;
    private final LinearLayout rootView;
    public final TextView tvNull;

    private FragmentAssignmentWeekPBinding(LinearLayout linearLayout, DrawableCenterRadioButton drawableCenterRadioButton, DrawableCenterRadioButton drawableCenterRadioButton2, DrawableCenterRadioButton drawableCenterRadioButton3, DrawableCenterRadioButton drawableCenterRadioButton4, DrawableCenterRadioButton drawableCenterRadioButton5, DrawableCenterRadioButton drawableCenterRadioButton6, DrawableCenterRadioButton drawableCenterRadioButton7, RadioGroup radioGroup, RecyclerView recyclerView, TextView textView) {
        this.rootView = linearLayout;
        this.rbFri = drawableCenterRadioButton;
        this.rbMonday = drawableCenterRadioButton2;
        this.rbSat = drawableCenterRadioButton3;
        this.rbThursday = drawableCenterRadioButton4;
        this.rbTuesday = drawableCenterRadioButton5;
        this.rbWednesday = drawableCenterRadioButton6;
        this.rbWeek = drawableCenterRadioButton7;
        this.rgCheck = radioGroup;
        this.rlList = recyclerView;
        this.tvNull = textView;
    }

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static FragmentAssignmentWeekPBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static FragmentAssignmentWeekPBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.fragment_assignment_week_p, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static FragmentAssignmentWeekPBinding bind(View view) {
        int i = R.id.rb_fri;
        DrawableCenterRadioButton drawableCenterRadioButton = (DrawableCenterRadioButton) view.findViewById(R.id.rb_fri);
        if (drawableCenterRadioButton != null) {
            i = R.id.rb_monday;
            DrawableCenterRadioButton drawableCenterRadioButton2 = (DrawableCenterRadioButton) view.findViewById(R.id.rb_monday);
            if (drawableCenterRadioButton2 != null) {
                i = R.id.rb_sat;
                DrawableCenterRadioButton drawableCenterRadioButton3 = (DrawableCenterRadioButton) view.findViewById(R.id.rb_sat);
                if (drawableCenterRadioButton3 != null) {
                    i = R.id.rb_thursday;
                    DrawableCenterRadioButton drawableCenterRadioButton4 = (DrawableCenterRadioButton) view.findViewById(R.id.rb_thursday);
                    if (drawableCenterRadioButton4 != null) {
                        i = R.id.rb_tuesday;
                        DrawableCenterRadioButton drawableCenterRadioButton5 = (DrawableCenterRadioButton) view.findViewById(R.id.rb_tuesday);
                        if (drawableCenterRadioButton5 != null) {
                            i = R.id.rb_wednesday;
                            DrawableCenterRadioButton drawableCenterRadioButton6 = (DrawableCenterRadioButton) view.findViewById(R.id.rb_wednesday);
                            if (drawableCenterRadioButton6 != null) {
                                i = R.id.rb_week;
                                DrawableCenterRadioButton drawableCenterRadioButton7 = (DrawableCenterRadioButton) view.findViewById(R.id.rb_week);
                                if (drawableCenterRadioButton7 != null) {
                                    i = R.id.rg_check;
                                    RadioGroup radioGroup = (RadioGroup) view.findViewById(R.id.rg_check);
                                    if (radioGroup != null) {
                                        i = R.id.rl_list;
                                        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.rl_list);
                                        if (recyclerView != null) {
                                            i = R.id.tv_null;
                                            TextView textView = (TextView) view.findViewById(R.id.tv_null);
                                            if (textView != null) {
                                                return new FragmentAssignmentWeekPBinding((LinearLayout) view, drawableCenterRadioButton, drawableCenterRadioButton2, drawableCenterRadioButton3, drawableCenterRadioButton4, drawableCenterRadioButton5, drawableCenterRadioButton6, drawableCenterRadioButton7, radioGroup, recyclerView, textView);
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
