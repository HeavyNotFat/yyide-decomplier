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
public final class ItemAskForLeaveFlowBinding implements ViewBinding {
    public final ImageView ivFlowChecked;
    public final ImageView ivUp;
    public final ImageView ivUserHead;
    public final RecyclerView recyclerView;
    private final ConstraintLayout rootView;
    public final TextView tvComment;
    public final TextView tvFlowContent;
    public final TextView tvFlowTitle;
    public final TextView tvName;
    public final TextView tvTime;
    public final View vEnd;

    private ItemAskForLeaveFlowBinding(ConstraintLayout constraintLayout, ImageView imageView, ImageView imageView2, ImageView imageView3, RecyclerView recyclerView, TextView textView, TextView textView2, TextView textView3, TextView textView4, TextView textView5, View view) {
        this.rootView = constraintLayout;
        this.ivFlowChecked = imageView;
        this.ivUp = imageView2;
        this.ivUserHead = imageView3;
        this.recyclerView = recyclerView;
        this.tvComment = textView;
        this.tvFlowContent = textView2;
        this.tvFlowTitle = textView3;
        this.tvName = textView4;
        this.tvTime = textView5;
        this.vEnd = view;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static ItemAskForLeaveFlowBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static ItemAskForLeaveFlowBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.item_ask_for_leave_flow, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static ItemAskForLeaveFlowBinding bind(View view) {
        int i = R.id.iv_flow_checked;
        ImageView imageView = (ImageView) view.findViewById(R.id.iv_flow_checked);
        if (imageView != null) {
            i = R.id.ivUp;
            ImageView imageView2 = (ImageView) view.findViewById(R.id.ivUp);
            if (imageView2 != null) {
                i = R.id.iv_user_head;
                ImageView imageView3 = (ImageView) view.findViewById(R.id.iv_user_head);
                if (imageView3 != null) {
                    i = R.id.recyclerView;
                    RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.recyclerView);
                    if (recyclerView != null) {
                        i = R.id.tvComment;
                        TextView textView = (TextView) view.findViewById(R.id.tvComment);
                        if (textView != null) {
                            i = R.id.tv_flow_content;
                            TextView textView2 = (TextView) view.findViewById(R.id.tv_flow_content);
                            if (textView2 != null) {
                                i = R.id.tv_flow_title;
                                TextView textView3 = (TextView) view.findViewById(R.id.tv_flow_title);
                                if (textView3 != null) {
                                    i = R.id.tvName;
                                    TextView textView4 = (TextView) view.findViewById(R.id.tvName);
                                    if (textView4 != null) {
                                        i = R.id.tvTime;
                                        TextView textView5 = (TextView) view.findViewById(R.id.tvTime);
                                        if (textView5 != null) {
                                            i = R.id.vEnd;
                                            View viewFindViewById = view.findViewById(R.id.vEnd);
                                            if (viewFindViewById != null) {
                                                return new ItemAskForLeaveFlowBinding((ConstraintLayout) view, imageView, imageView2, imageView3, recyclerView, textView, textView2, textView3, textView4, textView5, viewFindViewById);
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
