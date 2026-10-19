package com.yd.android_brand_mvp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import com.yd.android_brand_mvp.R;

/* JADX INFO: loaded from: classes4.dex */
public final class ItemLeaveDetailProcessBinding implements ViewBinding {
    public final ImageView ivItemLeaveDetailProcess;
    public final ImageView ivItemLeaveDetailProcessStatusTip;
    private final ConstraintLayout rootView;
    public final RecyclerView rvItemLeaveDetailProcessPeople;
    public final TextView tvItemLeaveDetailProcessName;
    public final TextView tvItemLeaveDetailProcessNameStatus;
    public final TextView tvItemLeaveDetailProcessNodeName;
    public final TextView tvItemLeaveDetailProcessNodeTime;
    public final TextView tvItemLeaveDetailProcessReason;
    public final View viewLineBottom;
    public final View viewLineTop;

    private ItemLeaveDetailProcessBinding(ConstraintLayout constraintLayout, ImageView imageView, ImageView imageView2, RecyclerView recyclerView, TextView textView, TextView textView2, TextView textView3, TextView textView4, TextView textView5, View view, View view2) {
        this.rootView = constraintLayout;
        this.ivItemLeaveDetailProcess = imageView;
        this.ivItemLeaveDetailProcessStatusTip = imageView2;
        this.rvItemLeaveDetailProcessPeople = recyclerView;
        this.tvItemLeaveDetailProcessName = textView;
        this.tvItemLeaveDetailProcessNameStatus = textView2;
        this.tvItemLeaveDetailProcessNodeName = textView3;
        this.tvItemLeaveDetailProcessNodeTime = textView4;
        this.tvItemLeaveDetailProcessReason = textView5;
        this.viewLineBottom = view;
        this.viewLineTop = view2;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static ItemLeaveDetailProcessBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static ItemLeaveDetailProcessBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.item_leave_detail_process, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static ItemLeaveDetailProcessBinding bind(View view) {
        int i = R.id.iv_item_leave_detail_process;
        ImageView imageView = (ImageView) view.findViewById(R.id.iv_item_leave_detail_process);
        if (imageView != null) {
            i = R.id.iv_item_leave_detail_process_status_tip;
            ImageView imageView2 = (ImageView) view.findViewById(R.id.iv_item_leave_detail_process_status_tip);
            if (imageView2 != null) {
                i = R.id.rv_item_leave_detail_process_people;
                RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.rv_item_leave_detail_process_people);
                if (recyclerView != null) {
                    i = R.id.tv_item_leave_detail_process_name;
                    TextView textView = (TextView) view.findViewById(R.id.tv_item_leave_detail_process_name);
                    if (textView != null) {
                        i = R.id.tv_item_leave_detail_process_name_status;
                        TextView textView2 = (TextView) view.findViewById(R.id.tv_item_leave_detail_process_name_status);
                        if (textView2 != null) {
                            i = R.id.tv_item_leave_detail_process_node_name;
                            TextView textView3 = (TextView) view.findViewById(R.id.tv_item_leave_detail_process_node_name);
                            if (textView3 != null) {
                                i = R.id.tv_item_leave_detail_process_node_time;
                                TextView textView4 = (TextView) view.findViewById(R.id.tv_item_leave_detail_process_node_time);
                                if (textView4 != null) {
                                    i = R.id.tv_item_leave_detail_process_reason;
                                    TextView textView5 = (TextView) view.findViewById(R.id.tv_item_leave_detail_process_reason);
                                    if (textView5 != null) {
                                        i = R.id.view_line_bottom;
                                        View viewFindViewById = view.findViewById(R.id.view_line_bottom);
                                        if (viewFindViewById != null) {
                                            i = R.id.view_line_top;
                                            View viewFindViewById2 = view.findViewById(R.id.view_line_top);
                                            if (viewFindViewById2 != null) {
                                                return new ItemLeaveDetailProcessBinding((ConstraintLayout) view, imageView, imageView2, recyclerView, textView, textView2, textView3, textView4, textView5, viewFindViewById, viewFindViewById2);
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
