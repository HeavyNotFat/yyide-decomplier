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
public final class ItemVoteDetailBinding implements ViewBinding {
    public final Group groupItemVoteDetailSelection;
    public final ImageView ivItemVoteDetail;
    public final ImageView ivItemVoteDetailSelect;
    public final ImageView ivItemVoteDetailVoteNumberAdd;
    public final ImageView ivItemVoteDetailVoteNumberReduce;
    private final ConstraintLayout rootView;
    public final TextView tvItemVoteDetailCount;
    public final TextView tvItemVoteDetailDesc;
    public final TextView tvItemVoteDetailName;
    public final TextView tvItemVoteDetailNumber;
    public final TextView tvItemVoteDetailVoteNumber;

    private ItemVoteDetailBinding(ConstraintLayout constraintLayout, Group group, ImageView imageView, ImageView imageView2, ImageView imageView3, ImageView imageView4, TextView textView, TextView textView2, TextView textView3, TextView textView4, TextView textView5) {
        this.rootView = constraintLayout;
        this.groupItemVoteDetailSelection = group;
        this.ivItemVoteDetail = imageView;
        this.ivItemVoteDetailSelect = imageView2;
        this.ivItemVoteDetailVoteNumberAdd = imageView3;
        this.ivItemVoteDetailVoteNumberReduce = imageView4;
        this.tvItemVoteDetailCount = textView;
        this.tvItemVoteDetailDesc = textView2;
        this.tvItemVoteDetailName = textView3;
        this.tvItemVoteDetailNumber = textView4;
        this.tvItemVoteDetailVoteNumber = textView5;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static ItemVoteDetailBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static ItemVoteDetailBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.item_vote_detail, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static ItemVoteDetailBinding bind(View view) {
        int i = R.id.group_item_vote_detail_Selection;
        Group group = (Group) view.findViewById(R.id.group_item_vote_detail_Selection);
        if (group != null) {
            i = R.id.iv_item_vote_detail;
            ImageView imageView = (ImageView) view.findViewById(R.id.iv_item_vote_detail);
            if (imageView != null) {
                i = R.id.iv_item_vote_detail_select;
                ImageView imageView2 = (ImageView) view.findViewById(R.id.iv_item_vote_detail_select);
                if (imageView2 != null) {
                    i = R.id.iv_item_vote_detail_vote_number_add;
                    ImageView imageView3 = (ImageView) view.findViewById(R.id.iv_item_vote_detail_vote_number_add);
                    if (imageView3 != null) {
                        i = R.id.iv_item_vote_detail_vote_number_reduce;
                        ImageView imageView4 = (ImageView) view.findViewById(R.id.iv_item_vote_detail_vote_number_reduce);
                        if (imageView4 != null) {
                            i = R.id.tv_item_vote_detail_count;
                            TextView textView = (TextView) view.findViewById(R.id.tv_item_vote_detail_count);
                            if (textView != null) {
                                i = R.id.tv_item_vote_detail_desc;
                                TextView textView2 = (TextView) view.findViewById(R.id.tv_item_vote_detail_desc);
                                if (textView2 != null) {
                                    i = R.id.tv_item_vote_detail_name;
                                    TextView textView3 = (TextView) view.findViewById(R.id.tv_item_vote_detail_name);
                                    if (textView3 != null) {
                                        i = R.id.tv_item_vote_detail_number;
                                        TextView textView4 = (TextView) view.findViewById(R.id.tv_item_vote_detail_number);
                                        if (textView4 != null) {
                                            i = R.id.tv_item_vote_detail_vote_number;
                                            TextView textView5 = (TextView) view.findViewById(R.id.tv_item_vote_detail_vote_number);
                                            if (textView5 != null) {
                                                return new ItemVoteDetailBinding((ConstraintLayout) view, group, imageView, imageView2, imageView3, imageView4, textView, textView2, textView3, textView4, textView5);
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
