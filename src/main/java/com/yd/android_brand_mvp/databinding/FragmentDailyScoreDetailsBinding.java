package com.yd.android_brand_mvp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import com.yd.android_brand_mvp.R;

/* JADX INFO: loaded from: classes4.dex */
public final class FragmentDailyScoreDetailsBinding implements ViewBinding {
    public final ConstraintLayout clScoringDetail;
    public final RadioButton rbFriday;
    public final RadioButton rbMonday;
    public final RadioButton rbSaturday;
    public final RadioButton rbSunday;
    public final RadioButton rbThursday;
    public final RadioButton rbTuesday;
    public final RadioButton rbWednesday;
    public final RadioGroup rgWeek;
    private final ConstraintLayout rootView;
    public final RecyclerView rvScoringDetails;
    public final TextView tvBonusPointsForTheDay;
    public final TextView tvBonusPointsForTheDayLabel;
    public final TextView tvFirstIndex;
    public final TextView tvMinusPointsForTheDay;
    public final TextView tvMinusPointsForTheDayLabel;
    public final TextView tvScore;
    public final TextView tvScoreRemarks;
    public final TextView tvScoringCriteria;
    public final TextView tvSecondIndex;
    public final TextView tvSerialNumber;
    public final TextView tvTime;
    public final TextView tvTotalPoints;
    public final TextView tvTotalPointsLabel;

    private FragmentDailyScoreDetailsBinding(ConstraintLayout constraintLayout, ConstraintLayout constraintLayout2, RadioButton radioButton, RadioButton radioButton2, RadioButton radioButton3, RadioButton radioButton4, RadioButton radioButton5, RadioButton radioButton6, RadioButton radioButton7, RadioGroup radioGroup, RecyclerView recyclerView, TextView textView, TextView textView2, TextView textView3, TextView textView4, TextView textView5, TextView textView6, TextView textView7, TextView textView8, TextView textView9, TextView textView10, TextView textView11, TextView textView12, TextView textView13) {
        this.rootView = constraintLayout;
        this.clScoringDetail = constraintLayout2;
        this.rbFriday = radioButton;
        this.rbMonday = radioButton2;
        this.rbSaturday = radioButton3;
        this.rbSunday = radioButton4;
        this.rbThursday = radioButton5;
        this.rbTuesday = radioButton6;
        this.rbWednesday = radioButton7;
        this.rgWeek = radioGroup;
        this.rvScoringDetails = recyclerView;
        this.tvBonusPointsForTheDay = textView;
        this.tvBonusPointsForTheDayLabel = textView2;
        this.tvFirstIndex = textView3;
        this.tvMinusPointsForTheDay = textView4;
        this.tvMinusPointsForTheDayLabel = textView5;
        this.tvScore = textView6;
        this.tvScoreRemarks = textView7;
        this.tvScoringCriteria = textView8;
        this.tvSecondIndex = textView9;
        this.tvSerialNumber = textView10;
        this.tvTime = textView11;
        this.tvTotalPoints = textView12;
        this.tvTotalPointsLabel = textView13;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static FragmentDailyScoreDetailsBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static FragmentDailyScoreDetailsBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.fragment_daily_score_details, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static FragmentDailyScoreDetailsBinding bind(View view) {
        int i = R.id.cl_scoring_detail;
        ConstraintLayout constraintLayout = (ConstraintLayout) view.findViewById(R.id.cl_scoring_detail);
        if (constraintLayout != null) {
            i = R.id.rb_friday;
            RadioButton radioButton = (RadioButton) view.findViewById(R.id.rb_friday);
            if (radioButton != null) {
                i = R.id.rb_monday;
                RadioButton radioButton2 = (RadioButton) view.findViewById(R.id.rb_monday);
                if (radioButton2 != null) {
                    i = R.id.rb_saturday;
                    RadioButton radioButton3 = (RadioButton) view.findViewById(R.id.rb_saturday);
                    if (radioButton3 != null) {
                        i = R.id.rb_sunday;
                        RadioButton radioButton4 = (RadioButton) view.findViewById(R.id.rb_sunday);
                        if (radioButton4 != null) {
                            i = R.id.rb_thursday;
                            RadioButton radioButton5 = (RadioButton) view.findViewById(R.id.rb_thursday);
                            if (radioButton5 != null) {
                                i = R.id.rb_tuesday;
                                RadioButton radioButton6 = (RadioButton) view.findViewById(R.id.rb_tuesday);
                                if (radioButton6 != null) {
                                    i = R.id.rb_wednesday;
                                    RadioButton radioButton7 = (RadioButton) view.findViewById(R.id.rb_wednesday);
                                    if (radioButton7 != null) {
                                        i = R.id.rg_week;
                                        RadioGroup radioGroup = (RadioGroup) view.findViewById(R.id.rg_week);
                                        if (radioGroup != null) {
                                            i = R.id.rv_scoring_details;
                                            RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.rv_scoring_details);
                                            if (recyclerView != null) {
                                                i = R.id.tv_bonus_points_for_the_day;
                                                TextView textView = (TextView) view.findViewById(R.id.tv_bonus_points_for_the_day);
                                                if (textView != null) {
                                                    i = R.id.tv_bonus_points_for_the_day_label;
                                                    TextView textView2 = (TextView) view.findViewById(R.id.tv_bonus_points_for_the_day_label);
                                                    if (textView2 != null) {
                                                        i = R.id.tv_first_index;
                                                        TextView textView3 = (TextView) view.findViewById(R.id.tv_first_index);
                                                        if (textView3 != null) {
                                                            i = R.id.tv_minus_points_for_the_day;
                                                            TextView textView4 = (TextView) view.findViewById(R.id.tv_minus_points_for_the_day);
                                                            if (textView4 != null) {
                                                                i = R.id.tv_minus_points_for_the_day_label;
                                                                TextView textView5 = (TextView) view.findViewById(R.id.tv_minus_points_for_the_day_label);
                                                                if (textView5 != null) {
                                                                    i = R.id.tv_score;
                                                                    TextView textView6 = (TextView) view.findViewById(R.id.tv_score);
                                                                    if (textView6 != null) {
                                                                        i = R.id.tv_score_remarks;
                                                                        TextView textView7 = (TextView) view.findViewById(R.id.tv_score_remarks);
                                                                        if (textView7 != null) {
                                                                            i = R.id.tv_scoring_criteria;
                                                                            TextView textView8 = (TextView) view.findViewById(R.id.tv_scoring_criteria);
                                                                            if (textView8 != null) {
                                                                                i = R.id.tv_second_index;
                                                                                TextView textView9 = (TextView) view.findViewById(R.id.tv_second_index);
                                                                                if (textView9 != null) {
                                                                                    i = R.id.tv_serial_number;
                                                                                    TextView textView10 = (TextView) view.findViewById(R.id.tv_serial_number);
                                                                                    if (textView10 != null) {
                                                                                        i = R.id.tv_time;
                                                                                        TextView textView11 = (TextView) view.findViewById(R.id.tv_time);
                                                                                        if (textView11 != null) {
                                                                                            i = R.id.tv_total_points;
                                                                                            TextView textView12 = (TextView) view.findViewById(R.id.tv_total_points);
                                                                                            if (textView12 != null) {
                                                                                                i = R.id.tv_total_points_label;
                                                                                                TextView textView13 = (TextView) view.findViewById(R.id.tv_total_points_label);
                                                                                                if (textView13 != null) {
                                                                                                    return new FragmentDailyScoreDetailsBinding((ConstraintLayout) view, constraintLayout, radioButton, radioButton2, radioButton3, radioButton4, radioButton5, radioButton6, radioButton7, radioGroup, recyclerView, textView, textView2, textView3, textView4, textView5, textView6, textView7, textView8, textView9, textView10, textView11, textView12, textView13);
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
