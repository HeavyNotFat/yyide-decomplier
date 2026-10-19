package com.yd.android_brand_mvp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Group;
import androidx.viewbinding.ViewBinding;
import com.yd.android_brand_mvp.R;

/* JADX INFO: loaded from: classes4.dex */
public final class ItemVoteListBinding implements ViewBinding {
    public final Group groupItemVoteListIngTime;
    public final ImageView ivItemVoteCover;
    public final ImageView ivItemVoteTime;
    private final ConstraintLayout rootView;
    public final TextView tvItemVoteCountDown;
    public final TextView tvItemVoteDay;
    public final TextView tvItemVoteDayTip;
    public final TextView tvItemVoteHours;
    public final TextView tvItemVoteHoursTip;
    public final TextView tvItemVoteListEndTime;
    public final TextView tvItemVoteMin;
    public final TextView tvItemVoteMinTip;
    public final TextView tvItemVoteStatus;
    public final TextView tvItemVoteTitle;

    private ItemVoteListBinding(ConstraintLayout constraintLayout, Group group, ImageView imageView, ImageView imageView2, TextView textView, TextView textView2, TextView textView3, TextView textView4, TextView textView5, TextView textView6, TextView textView7, TextView textView8, TextView textView9, TextView textView10) {
        this.rootView = constraintLayout;
        this.groupItemVoteListIngTime = group;
        this.ivItemVoteCover = imageView;
        this.ivItemVoteTime = imageView2;
        this.tvItemVoteCountDown = textView;
        this.tvItemVoteDay = textView2;
        this.tvItemVoteDayTip = textView3;
        this.tvItemVoteHours = textView4;
        this.tvItemVoteHoursTip = textView5;
        this.tvItemVoteListEndTime = textView6;
        this.tvItemVoteMin = textView7;
        this.tvItemVoteMinTip = textView8;
        this.tvItemVoteStatus = textView9;
        this.tvItemVoteTitle = textView10;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static ItemVoteListBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static ItemVoteListBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.item_vote_list, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static ItemVoteListBinding bind(View view) {
        int i = R.id.group_item_vote_list_ing_time;
        Group group = (Group) view.findViewById(R.id.group_item_vote_list_ing_time);
        if (group != null) {
            i = R.id.iv_item_vote_cover;
            ImageView imageView = (ImageView) view.findViewById(R.id.iv_item_vote_cover);
            if (imageView != null) {
                i = R.id.iv_item_vote_time;
                ImageView imageView2 = (ImageView) view.findViewById(R.id.iv_item_vote_time);
                if (imageView2 != null) {
                    i = R.id.tv_item_vote_countDown;
                    TextView textView = (TextView) view.findViewById(R.id.tv_item_vote_countDown);
                    if (textView != null) {
                        i = R.id.tv_item_vote_day;
                        TextView textView2 = (TextView) view.findViewById(R.id.tv_item_vote_day);
                        if (textView2 != null) {
                            i = R.id.tv_item_vote_day_tip;
                            TextView textView3 = (TextView) view.findViewById(R.id.tv_item_vote_day_tip);
                            if (textView3 != null) {
                                i = R.id.tv_item_vote_hours;
                                TextView textView4 = (TextView) view.findViewById(R.id.tv_item_vote_hours);
                                if (textView4 != null) {
                                    i = R.id.tv_item_vote_hours_tip;
                                    TextView textView5 = (TextView) view.findViewById(R.id.tv_item_vote_hours_tip);
                                    if (textView5 != null) {
                                        i = R.id.tv_item_vote_list_end_time;
                                        TextView textView6 = (TextView) view.findViewById(R.id.tv_item_vote_list_end_time);
                                        if (textView6 != null) {
                                            i = R.id.tv_item_vote_min;
                                            TextView textView7 = (TextView) view.findViewById(R.id.tv_item_vote_min);
                                            if (textView7 != null) {
                                                i = R.id.tv_item_vote_min_tip;
                                                TextView textView8 = (TextView) view.findViewById(R.id.tv_item_vote_min_tip);
                                                if (textView8 != null) {
                                                    i = R.id.tv_item_vote_status;
                                                    TextView textView9 = (TextView) view.findViewById(R.id.tv_item_vote_status);
                                                    if (textView9 != null) {
                                                        i = R.id.tv_item_vote_title;
                                                        TextView textView10 = (TextView) view.findViewById(R.id.tv_item_vote_title);
                                                        if (textView10 != null) {
                                                            return new ItemVoteListBinding((ConstraintLayout) view, group, imageView, imageView2, textView, textView2, textView3, textView4, textView5, textView6, textView7, textView8, textView9, textView10);
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
