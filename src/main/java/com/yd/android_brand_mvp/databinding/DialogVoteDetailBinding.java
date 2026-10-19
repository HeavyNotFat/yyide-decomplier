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
public final class DialogVoteDetailBinding implements ViewBinding {
    public final Barrier barrierFragmentVote46Detail;
    public final TextView btnDialogVoteDetail;
    public final ImageView ivDialogVoteDetailCover;
    public final ImageView ivDialogVoteDetailTime;
    private final ConstraintLayout rootView;
    public final RecyclerView rvDialogVoteDetail;
    public final TextView topDialogVoteDetail;
    public final TextView tvDialogVoteDetailCountDown;
    public final TextView tvDialogVoteDetailDay;
    public final TextView tvDialogVoteDetailDayTip;
    public final TextView tvDialogVoteDetailDesc;
    public final TextView tvDialogVoteDetailHours;
    public final TextView tvDialogVoteDetailHoursTip;
    public final TextView tvDialogVoteDetailMin;
    public final TextView tvDialogVoteDetailMinTip;
    public final TextView tvDialogVoteDetailPrize;
    public final TextView tvDialogVoteDetailPrizeTip;
    public final TextView tvDialogVoteDetailRange;
    public final TextView tvDialogVoteDetailRangeTip;
    public final TextView tvDialogVoteDetailRule;
    public final TextView tvDialogVoteDetailRuleTip;
    public final TextView tvDialogVoteDetailTime;
    public final TextView tvDialogVoteDetailTimeTip;
    public final TextView tvDialogVoteDetailTitle;
    public final View viewLine;

    private DialogVoteDetailBinding(ConstraintLayout constraintLayout, Barrier barrier, TextView textView, ImageView imageView, ImageView imageView2, RecyclerView recyclerView, TextView textView2, TextView textView3, TextView textView4, TextView textView5, TextView textView6, TextView textView7, TextView textView8, TextView textView9, TextView textView10, TextView textView11, TextView textView12, TextView textView13, TextView textView14, TextView textView15, TextView textView16, TextView textView17, TextView textView18, TextView textView19, View view) {
        this.rootView = constraintLayout;
        this.barrierFragmentVote46Detail = barrier;
        this.btnDialogVoteDetail = textView;
        this.ivDialogVoteDetailCover = imageView;
        this.ivDialogVoteDetailTime = imageView2;
        this.rvDialogVoteDetail = recyclerView;
        this.topDialogVoteDetail = textView2;
        this.tvDialogVoteDetailCountDown = textView3;
        this.tvDialogVoteDetailDay = textView4;
        this.tvDialogVoteDetailDayTip = textView5;
        this.tvDialogVoteDetailDesc = textView6;
        this.tvDialogVoteDetailHours = textView7;
        this.tvDialogVoteDetailHoursTip = textView8;
        this.tvDialogVoteDetailMin = textView9;
        this.tvDialogVoteDetailMinTip = textView10;
        this.tvDialogVoteDetailPrize = textView11;
        this.tvDialogVoteDetailPrizeTip = textView12;
        this.tvDialogVoteDetailRange = textView13;
        this.tvDialogVoteDetailRangeTip = textView14;
        this.tvDialogVoteDetailRule = textView15;
        this.tvDialogVoteDetailRuleTip = textView16;
        this.tvDialogVoteDetailTime = textView17;
        this.tvDialogVoteDetailTimeTip = textView18;
        this.tvDialogVoteDetailTitle = textView19;
        this.viewLine = view;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static DialogVoteDetailBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static DialogVoteDetailBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.dialog_vote_detail, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static DialogVoteDetailBinding bind(View view) {
        int i = R.id.barrier_fragment_vote46_detail;
        Barrier barrier = (Barrier) view.findViewById(R.id.barrier_fragment_vote46_detail);
        if (barrier != null) {
            i = R.id.btn_dialog_vote_detail;
            TextView textView = (TextView) view.findViewById(R.id.btn_dialog_vote_detail);
            if (textView != null) {
                i = R.id.iv_dialog_vote_detail_cover;
                ImageView imageView = (ImageView) view.findViewById(R.id.iv_dialog_vote_detail_cover);
                if (imageView != null) {
                    i = R.id.iv_dialog_vote_detail_time;
                    ImageView imageView2 = (ImageView) view.findViewById(R.id.iv_dialog_vote_detail_time);
                    if (imageView2 != null) {
                        i = R.id.rv_dialog_vote_detail;
                        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.rv_dialog_vote_detail);
                        if (recyclerView != null) {
                            i = R.id.top_dialog_vote_detail;
                            TextView textView2 = (TextView) view.findViewById(R.id.top_dialog_vote_detail);
                            if (textView2 != null) {
                                i = R.id.tv_dialog_vote_detail_countDown;
                                TextView textView3 = (TextView) view.findViewById(R.id.tv_dialog_vote_detail_countDown);
                                if (textView3 != null) {
                                    i = R.id.tv_dialog_vote_detail_day;
                                    TextView textView4 = (TextView) view.findViewById(R.id.tv_dialog_vote_detail_day);
                                    if (textView4 != null) {
                                        i = R.id.tv_dialog_vote_detail_day_tip;
                                        TextView textView5 = (TextView) view.findViewById(R.id.tv_dialog_vote_detail_day_tip);
                                        if (textView5 != null) {
                                            i = R.id.tv_dialog_vote_detail_desc;
                                            TextView textView6 = (TextView) view.findViewById(R.id.tv_dialog_vote_detail_desc);
                                            if (textView6 != null) {
                                                i = R.id.tv_dialog_vote_detail_hours;
                                                TextView textView7 = (TextView) view.findViewById(R.id.tv_dialog_vote_detail_hours);
                                                if (textView7 != null) {
                                                    i = R.id.tv_dialog_vote_detail_hours_tip;
                                                    TextView textView8 = (TextView) view.findViewById(R.id.tv_dialog_vote_detail_hours_tip);
                                                    if (textView8 != null) {
                                                        i = R.id.tv_dialog_vote_detail_min;
                                                        TextView textView9 = (TextView) view.findViewById(R.id.tv_dialog_vote_detail_min);
                                                        if (textView9 != null) {
                                                            i = R.id.tv_dialog_vote_detail_min_tip;
                                                            TextView textView10 = (TextView) view.findViewById(R.id.tv_dialog_vote_detail_min_tip);
                                                            if (textView10 != null) {
                                                                i = R.id.tv_dialog_vote_detail_prize;
                                                                TextView textView11 = (TextView) view.findViewById(R.id.tv_dialog_vote_detail_prize);
                                                                if (textView11 != null) {
                                                                    i = R.id.tv_dialog_vote_detail_prize_tip;
                                                                    TextView textView12 = (TextView) view.findViewById(R.id.tv_dialog_vote_detail_prize_tip);
                                                                    if (textView12 != null) {
                                                                        i = R.id.tv_dialog_vote_detail_range;
                                                                        TextView textView13 = (TextView) view.findViewById(R.id.tv_dialog_vote_detail_range);
                                                                        if (textView13 != null) {
                                                                            i = R.id.tv_dialog_vote_detail_range_tip;
                                                                            TextView textView14 = (TextView) view.findViewById(R.id.tv_dialog_vote_detail_range_tip);
                                                                            if (textView14 != null) {
                                                                                i = R.id.tv_dialog_vote_detail_rule;
                                                                                TextView textView15 = (TextView) view.findViewById(R.id.tv_dialog_vote_detail_rule);
                                                                                if (textView15 != null) {
                                                                                    i = R.id.tv_dialog_vote_detail_rule_tip;
                                                                                    TextView textView16 = (TextView) view.findViewById(R.id.tv_dialog_vote_detail_rule_tip);
                                                                                    if (textView16 != null) {
                                                                                        i = R.id.tv_dialog_vote_detail_time;
                                                                                        TextView textView17 = (TextView) view.findViewById(R.id.tv_dialog_vote_detail_time);
                                                                                        if (textView17 != null) {
                                                                                            i = R.id.tv_dialog_vote_detail_time_tip;
                                                                                            TextView textView18 = (TextView) view.findViewById(R.id.tv_dialog_vote_detail_time_tip);
                                                                                            if (textView18 != null) {
                                                                                                i = R.id.tv_dialog_vote_detail_title;
                                                                                                TextView textView19 = (TextView) view.findViewById(R.id.tv_dialog_vote_detail_title);
                                                                                                if (textView19 != null) {
                                                                                                    i = R.id.view_line;
                                                                                                    View viewFindViewById = view.findViewById(R.id.view_line);
                                                                                                    if (viewFindViewById != null) {
                                                                                                        return new DialogVoteDetailBinding((ConstraintLayout) view, barrier, textView, imageView, imageView2, recyclerView, textView2, textView3, textView4, textView5, textView6, textView7, textView8, textView9, textView10, textView11, textView12, textView13, textView14, textView15, textView16, textView17, textView18, textView19, viewFindViewById);
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
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
