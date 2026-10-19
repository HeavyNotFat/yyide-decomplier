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
public final class ItemUserLeaveNodeBinding implements ViewBinding {
    public final Barrier barrierRvItemUserLeaveNode;
    public final ImageView ivItemUserLeaveNodeAdd;
    private final ConstraintLayout rootView;
    public final RecyclerView rvItemUserLeaveNodePeople;
    public final TextView tvItemUserLeaveNodeDesc;
    public final TextView tvItemUserLeaveNodeName;
    public final View viewRingGrey;
    public final View viewTopBottom;
    public final View viewTopLine;

    private ItemUserLeaveNodeBinding(ConstraintLayout constraintLayout, Barrier barrier, ImageView imageView, RecyclerView recyclerView, TextView textView, TextView textView2, View view, View view2, View view3) {
        this.rootView = constraintLayout;
        this.barrierRvItemUserLeaveNode = barrier;
        this.ivItemUserLeaveNodeAdd = imageView;
        this.rvItemUserLeaveNodePeople = recyclerView;
        this.tvItemUserLeaveNodeDesc = textView;
        this.tvItemUserLeaveNodeName = textView2;
        this.viewRingGrey = view;
        this.viewTopBottom = view2;
        this.viewTopLine = view3;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static ItemUserLeaveNodeBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static ItemUserLeaveNodeBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.item_user_leave_node, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static ItemUserLeaveNodeBinding bind(View view) {
        int i = R.id.barrier_rv_item_user_leave_node;
        Barrier barrier = (Barrier) view.findViewById(R.id.barrier_rv_item_user_leave_node);
        if (barrier != null) {
            i = R.id.iv_item_user_leave_node_add;
            ImageView imageView = (ImageView) view.findViewById(R.id.iv_item_user_leave_node_add);
            if (imageView != null) {
                i = R.id.rv_item_user_leave_node_people;
                RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.rv_item_user_leave_node_people);
                if (recyclerView != null) {
                    i = R.id.tv_item_user_leave_node_desc;
                    TextView textView = (TextView) view.findViewById(R.id.tv_item_user_leave_node_desc);
                    if (textView != null) {
                        i = R.id.tv_item_user_leave_node_name;
                        TextView textView2 = (TextView) view.findViewById(R.id.tv_item_user_leave_node_name);
                        if (textView2 != null) {
                            i = R.id.view_ring_grey;
                            View viewFindViewById = view.findViewById(R.id.view_ring_grey);
                            if (viewFindViewById != null) {
                                i = R.id.view_top_bottom;
                                View viewFindViewById2 = view.findViewById(R.id.view_top_bottom);
                                if (viewFindViewById2 != null) {
                                    i = R.id.view_top_line;
                                    View viewFindViewById3 = view.findViewById(R.id.view_top_line);
                                    if (viewFindViewById3 != null) {
                                        return new ItemUserLeaveNodeBinding((ConstraintLayout) view, barrier, imageView, recyclerView, textView, textView2, viewFindViewById, viewFindViewById2, viewFindViewById3);
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
