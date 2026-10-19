package com.yd.android_brand_mvp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.Barrier;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import com.yd.android_brand_mvp.R;

/* JADX INFO: loaded from: classes4.dex */
public final class FragmentHomeVote46Binding implements ViewBinding {
    public final Barrier barrierFragmentVote46Detail;
    public final TextView btnFragmentHomeVote46;
    public final ConstraintLayout clFragmentHomeVote46;
    public final ImageView ivFragmentHomeVote46Cover;
    public final ImageView ivFragmentHomeVote46Time;
    private final ConstraintLayout rootView;
    public final RecyclerView rvFragmentVote46;
    public final LayoutHeadTitleBinding topFragmentHomeVote46;
    public final TextView tvFragmentHomeVote46CountDown;
    public final TextView tvFragmentHomeVote46Day;
    public final TextView tvFragmentHomeVote46DayTip;
    public final TextView tvFragmentHomeVote46Hours;
    public final TextView tvFragmentHomeVote46HoursTip;
    public final TextView tvFragmentHomeVote46Min;
    public final TextView tvFragmentHomeVote46MinTip;
    public final TextView tvFragmentHomeVote46Prize;
    public final TextView tvFragmentHomeVote46PrizeTip;
    public final TextView tvFragmentHomeVote46Range;
    public final TextView tvFragmentHomeVote46RangeTip;
    public final TextView tvFragmentHomeVote46Rule;
    public final TextView tvFragmentHomeVote46RuleTip;
    public final TextView tvFragmentHomeVote46Time;
    public final TextView tvFragmentHomeVote46TimeTip;
    public final TextView tvFragmentHomeVote46Title;
    public final View viewLine;

    private FragmentHomeVote46Binding(ConstraintLayout constraintLayout, Barrier barrier, TextView textView, ConstraintLayout constraintLayout2, ImageView imageView, ImageView imageView2, RecyclerView recyclerView, LayoutHeadTitleBinding layoutHeadTitleBinding, TextView textView2, TextView textView3, TextView textView4, TextView textView5, TextView textView6, TextView textView7, TextView textView8, TextView textView9, TextView textView10, TextView textView11, TextView textView12, TextView textView13, TextView textView14, TextView textView15, TextView textView16, TextView textView17, View view) {
        this.rootView = constraintLayout;
        this.barrierFragmentVote46Detail = barrier;
        this.btnFragmentHomeVote46 = textView;
        this.clFragmentHomeVote46 = constraintLayout2;
        this.ivFragmentHomeVote46Cover = imageView;
        this.ivFragmentHomeVote46Time = imageView2;
        this.rvFragmentVote46 = recyclerView;
        this.topFragmentHomeVote46 = layoutHeadTitleBinding;
        this.tvFragmentHomeVote46CountDown = textView2;
        this.tvFragmentHomeVote46Day = textView3;
        this.tvFragmentHomeVote46DayTip = textView4;
        this.tvFragmentHomeVote46Hours = textView5;
        this.tvFragmentHomeVote46HoursTip = textView6;
        this.tvFragmentHomeVote46Min = textView7;
        this.tvFragmentHomeVote46MinTip = textView8;
        this.tvFragmentHomeVote46Prize = textView9;
        this.tvFragmentHomeVote46PrizeTip = textView10;
        this.tvFragmentHomeVote46Range = textView11;
        this.tvFragmentHomeVote46RangeTip = textView12;
        this.tvFragmentHomeVote46Rule = textView13;
        this.tvFragmentHomeVote46RuleTip = textView14;
        this.tvFragmentHomeVote46Time = textView15;
        this.tvFragmentHomeVote46TimeTip = textView16;
        this.tvFragmentHomeVote46Title = textView17;
        this.viewLine = view;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static FragmentHomeVote46Binding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static FragmentHomeVote46Binding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.fragment_home_vote46, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static FragmentHomeVote46Binding bind(View view) {
        int i = R.id.barrier_fragment_vote46_detail;
        Barrier barrier = (Barrier) view.findViewById(R.id.barrier_fragment_vote46_detail);
        if (barrier != null) {
            i = R.id.btn_fragment_home_vote46;
            TextView textView = (TextView) view.findViewById(R.id.btn_fragment_home_vote46);
            if (textView != null) {
                ConstraintLayout constraintLayout = (ConstraintLayout) view;
                i = R.id.iv_fragment_home_vote46_cover;
                ImageView imageView = (ImageView) view.findViewById(R.id.iv_fragment_home_vote46_cover);
                if (imageView != null) {
                    i = R.id.iv_fragment_home_vote46_time;
                    ImageView imageView2 = (ImageView) view.findViewById(R.id.iv_fragment_home_vote46_time);
                    if (imageView2 != null) {
                        i = R.id.rv_fragment_vote46;
                        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.rv_fragment_vote46);
                        if (recyclerView != null) {
                            i = R.id.top_fragment_home_vote46;
                            View viewFindViewById = view.findViewById(R.id.top_fragment_home_vote46);
                            if (viewFindViewById != null) {
                                LayoutHeadTitleBinding layoutHeadTitleBindingBind = LayoutHeadTitleBinding.bind(viewFindViewById);
                                i = R.id.tv_fragment_home_vote46_countDown;
                                TextView textView2 = (TextView) view.findViewById(R.id.tv_fragment_home_vote46_countDown);
                                if (textView2 != null) {
                                    i = R.id.tv_fragment_home_vote46_day;
                                    TextView textView3 = (TextView) view.findViewById(R.id.tv_fragment_home_vote46_day);
                                    if (textView3 != null) {
                                        i = R.id.tv_fragment_home_vote46_day_tip;
                                        TextView textView4 = (TextView) view.findViewById(R.id.tv_fragment_home_vote46_day_tip);
                                        if (textView4 != null) {
                                            i = R.id.tv_fragment_home_vote46_hours;
                                            TextView textView5 = (TextView) view.findViewById(R.id.tv_fragment_home_vote46_hours);
                                            if (textView5 != null) {
                                                i = R.id.tv_fragment_home_vote46_hours_tip;
                                                TextView textView6 = (TextView) view.findViewById(R.id.tv_fragment_home_vote46_hours_tip);
                                                if (textView6 != null) {
                                                    i = R.id.tv_fragment_home_vote46_min;
                                                    TextView textView7 = (TextView) view.findViewById(R.id.tv_fragment_home_vote46_min);
                                                    if (textView7 != null) {
                                                        i = R.id.tv_fragment_home_vote46_min_tip;
                                                        TextView textView8 = (TextView) view.findViewById(R.id.tv_fragment_home_vote46_min_tip);
                                                        if (textView8 != null) {
                                                            i = R.id.tv_fragment_home_vote46_prize;
                                                            TextView textView9 = (TextView) view.findViewById(R.id.tv_fragment_home_vote46_prize);
                                                            if (textView9 != null) {
                                                                i = R.id.tv_fragment_home_vote46_prize_tip;
                                                                TextView textView10 = (TextView) view.findViewById(R.id.tv_fragment_home_vote46_prize_tip);
                                                                if (textView10 != null) {
                                                                    i = R.id.tv_fragment_home_vote46_range;
                                                                    TextView textView11 = (TextView) view.findViewById(R.id.tv_fragment_home_vote46_range);
                                                                    if (textView11 != null) {
                                                                        i = R.id.tv_fragment_home_vote46_range_tip;
                                                                        TextView textView12 = (TextView) view.findViewById(R.id.tv_fragment_home_vote46_range_tip);
                                                                        if (textView12 != null) {
                                                                            i = R.id.tv_fragment_home_vote46_rule;
                                                                            TextView textView13 = (TextView) view.findViewById(R.id.tv_fragment_home_vote46_rule);
                                                                            if (textView13 != null) {
                                                                                i = R.id.tv_fragment_home_vote46_rule_tip;
                                                                                TextView textView14 = (TextView) view.findViewById(R.id.tv_fragment_home_vote46_rule_tip);
                                                                                if (textView14 != null) {
                                                                                    i = R.id.tv_fragment_home_vote46_time;
                                                                                    TextView textView15 = (TextView) view.findViewById(R.id.tv_fragment_home_vote46_time);
                                                                                    if (textView15 != null) {
                                                                                        i = R.id.tv_fragment_home_vote46_time_tip;
                                                                                        TextView textView16 = (TextView) view.findViewById(R.id.tv_fragment_home_vote46_time_tip);
                                                                                        if (textView16 != null) {
                                                                                            i = R.id.tv_fragment_home_vote46_title;
                                                                                            TextView textView17 = (TextView) view.findViewById(R.id.tv_fragment_home_vote46_title);
                                                                                            if (textView17 != null) {
                                                                                                i = R.id.view_line;
                                                                                                View viewFindViewById2 = view.findViewById(R.id.view_line);
                                                                                                if (viewFindViewById2 != null) {
                                                                                                    return new FragmentHomeVote46Binding(constraintLayout, barrier, textView, constraintLayout, imageView, imageView2, recyclerView, layoutHeadTitleBindingBind, textView2, textView3, textView4, textView5, textView6, textView7, textView8, textView9, textView10, textView11, textView12, textView13, textView14, textView15, textView16, textView17, viewFindViewById2);
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
