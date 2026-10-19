package com.yd.android_brand_mvp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import com.yd.android_brand_mvp.R;
import com.yd.android_brand_mvp.weight.MultiStateView;

/* JADX INFO: loaded from: classes4.dex */
public final class FragmentAssignmentWeekBinding implements ViewBinding {
    public final LinearLayout llIndicator;
    public final MultiStateView mu;
    public final RadioButton rbFri;
    public final RadioButton rbMonday;
    public final RadioButton rbSat;
    public final RadioButton rbThursday;
    public final RadioButton rbTuesday;
    public final RadioButton rbWednesday;
    public final RadioButton rbWeek;
    public final RadioGroup rgCheck;
    private final LinearLayout rootView;
    public final RecyclerView rvList;

    private FragmentAssignmentWeekBinding(LinearLayout linearLayout, LinearLayout linearLayout2, MultiStateView multiStateView, RadioButton radioButton, RadioButton radioButton2, RadioButton radioButton3, RadioButton radioButton4, RadioButton radioButton5, RadioButton radioButton6, RadioButton radioButton7, RadioGroup radioGroup, RecyclerView recyclerView) {
        this.rootView = linearLayout;
        this.llIndicator = linearLayout2;
        this.mu = multiStateView;
        this.rbFri = radioButton;
        this.rbMonday = radioButton2;
        this.rbSat = radioButton3;
        this.rbThursday = radioButton4;
        this.rbTuesday = radioButton5;
        this.rbWednesday = radioButton6;
        this.rbWeek = radioButton7;
        this.rgCheck = radioGroup;
        this.rvList = recyclerView;
    }

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static FragmentAssignmentWeekBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static FragmentAssignmentWeekBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.fragment_assignment_week, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static FragmentAssignmentWeekBinding bind(View view) {
        int i = R.id.ll_indicator;
        LinearLayout linearLayout = (LinearLayout) view.findViewById(R.id.ll_indicator);
        if (linearLayout != null) {
            i = R.id.mu;
            MultiStateView multiStateView = (MultiStateView) view.findViewById(R.id.mu);
            if (multiStateView != null) {
                i = R.id.rb_fri;
                RadioButton radioButton = (RadioButton) view.findViewById(R.id.rb_fri);
                if (radioButton != null) {
                    i = R.id.rb_monday;
                    RadioButton radioButton2 = (RadioButton) view.findViewById(R.id.rb_monday);
                    if (radioButton2 != null) {
                        i = R.id.rb_sat;
                        RadioButton radioButton3 = (RadioButton) view.findViewById(R.id.rb_sat);
                        if (radioButton3 != null) {
                            i = R.id.rb_thursday;
                            RadioButton radioButton4 = (RadioButton) view.findViewById(R.id.rb_thursday);
                            if (radioButton4 != null) {
                                i = R.id.rb_tuesday;
                                RadioButton radioButton5 = (RadioButton) view.findViewById(R.id.rb_tuesday);
                                if (radioButton5 != null) {
                                    i = R.id.rb_wednesday;
                                    RadioButton radioButton6 = (RadioButton) view.findViewById(R.id.rb_wednesday);
                                    if (radioButton6 != null) {
                                        i = R.id.rb_week;
                                        RadioButton radioButton7 = (RadioButton) view.findViewById(R.id.rb_week);
                                        if (radioButton7 != null) {
                                            i = R.id.rg_check;
                                            RadioGroup radioGroup = (RadioGroup) view.findViewById(R.id.rg_check);
                                            if (radioGroup != null) {
                                                i = R.id.rv_list;
                                                RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.rv_list);
                                                if (recyclerView != null) {
                                                    return new FragmentAssignmentWeekBinding((LinearLayout) view, linearLayout, multiStateView, radioButton, radioButton2, radioButton3, radioButton4, radioButton5, radioButton6, radioButton7, radioGroup, recyclerView);
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
