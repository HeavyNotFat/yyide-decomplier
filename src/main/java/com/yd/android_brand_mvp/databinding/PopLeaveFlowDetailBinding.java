package com.yd.android_brand_mvp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.widget.NestedScrollView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import com.yd.android_brand_mvp.R;

/* JADX INFO: loaded from: classes4.dex */
public final class PopLeaveFlowDetailBinding implements ViewBinding {
    public final Button btnEdit;
    public final Button btnPass;
    public final ConstraintLayout clContent;
    public final ConstraintLayout clFlow;
    public final LinearLayout clRepeal;
    public final View line1;
    public final View line2;
    public final NestedScrollView nestedScrollView;
    public final RecyclerView recyclerviewFlow;
    private final LinearLayout rootView;
    public final TextView tvContentClass;
    public final TextView tvContentClassDetail;
    public final TextView tvContentReason;
    public final TextView tvContentReasonDetail;
    public final TextView tvContentTime;
    public final TextView tvContentTimeDetail;
    public final TextView tvFlow;
    public final TextView tvTitle;
    public final TextView tvTopBtn;
    public final TextView tvTopTime;
    public final TextView tvTopTitle;

    private PopLeaveFlowDetailBinding(LinearLayout linearLayout, Button button, Button button2, ConstraintLayout constraintLayout, ConstraintLayout constraintLayout2, LinearLayout linearLayout2, View view, View view2, NestedScrollView nestedScrollView, RecyclerView recyclerView, TextView textView, TextView textView2, TextView textView3, TextView textView4, TextView textView5, TextView textView6, TextView textView7, TextView textView8, TextView textView9, TextView textView10, TextView textView11) {
        this.rootView = linearLayout;
        this.btnEdit = button;
        this.btnPass = button2;
        this.clContent = constraintLayout;
        this.clFlow = constraintLayout2;
        this.clRepeal = linearLayout2;
        this.line1 = view;
        this.line2 = view2;
        this.nestedScrollView = nestedScrollView;
        this.recyclerviewFlow = recyclerView;
        this.tvContentClass = textView;
        this.tvContentClassDetail = textView2;
        this.tvContentReason = textView3;
        this.tvContentReasonDetail = textView4;
        this.tvContentTime = textView5;
        this.tvContentTimeDetail = textView6;
        this.tvFlow = textView7;
        this.tvTitle = textView8;
        this.tvTopBtn = textView9;
        this.tvTopTime = textView10;
        this.tvTopTitle = textView11;
    }

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static PopLeaveFlowDetailBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static PopLeaveFlowDetailBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.pop_leave_flow_detail, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static PopLeaveFlowDetailBinding bind(View view) {
        int i = R.id.btn_edit;
        Button button = (Button) view.findViewById(R.id.btn_edit);
        if (button != null) {
            i = R.id.btn_pass;
            Button button2 = (Button) view.findViewById(R.id.btn_pass);
            if (button2 != null) {
                i = R.id.cl_content;
                ConstraintLayout constraintLayout = (ConstraintLayout) view.findViewById(R.id.cl_content);
                if (constraintLayout != null) {
                    i = R.id.cl_flow;
                    ConstraintLayout constraintLayout2 = (ConstraintLayout) view.findViewById(R.id.cl_flow);
                    if (constraintLayout2 != null) {
                        i = R.id.cl_repeal;
                        LinearLayout linearLayout = (LinearLayout) view.findViewById(R.id.cl_repeal);
                        if (linearLayout != null) {
                            i = R.id.line1;
                            View viewFindViewById = view.findViewById(R.id.line1);
                            if (viewFindViewById != null) {
                                i = R.id.line2;
                                View viewFindViewById2 = view.findViewById(R.id.line2);
                                if (viewFindViewById2 != null) {
                                    i = R.id.nestedScrollView;
                                    NestedScrollView nestedScrollView = (NestedScrollView) view.findViewById(R.id.nestedScrollView);
                                    if (nestedScrollView != null) {
                                        i = R.id.recyclerview_flow;
                                        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.recyclerview_flow);
                                        if (recyclerView != null) {
                                            i = R.id.tv_content_class;
                                            TextView textView = (TextView) view.findViewById(R.id.tv_content_class);
                                            if (textView != null) {
                                                i = R.id.tv_content_class_detail;
                                                TextView textView2 = (TextView) view.findViewById(R.id.tv_content_class_detail);
                                                if (textView2 != null) {
                                                    i = R.id.tv_content_reason;
                                                    TextView textView3 = (TextView) view.findViewById(R.id.tv_content_reason);
                                                    if (textView3 != null) {
                                                        i = R.id.tv_content_reason_detail;
                                                        TextView textView4 = (TextView) view.findViewById(R.id.tv_content_reason_detail);
                                                        if (textView4 != null) {
                                                            i = R.id.tv_content_time;
                                                            TextView textView5 = (TextView) view.findViewById(R.id.tv_content_time);
                                                            if (textView5 != null) {
                                                                i = R.id.tv_content_time_detail;
                                                                TextView textView6 = (TextView) view.findViewById(R.id.tv_content_time_detail);
                                                                if (textView6 != null) {
                                                                    i = R.id.tv_flow;
                                                                    TextView textView7 = (TextView) view.findViewById(R.id.tv_flow);
                                                                    if (textView7 != null) {
                                                                        i = R.id.tv_title;
                                                                        TextView textView8 = (TextView) view.findViewById(R.id.tv_title);
                                                                        if (textView8 != null) {
                                                                            i = R.id.tv_top_btn;
                                                                            TextView textView9 = (TextView) view.findViewById(R.id.tv_top_btn);
                                                                            if (textView9 != null) {
                                                                                i = R.id.tv_top_time;
                                                                                TextView textView10 = (TextView) view.findViewById(R.id.tv_top_time);
                                                                                if (textView10 != null) {
                                                                                    i = R.id.tv_top_title;
                                                                                    TextView textView11 = (TextView) view.findViewById(R.id.tv_top_title);
                                                                                    if (textView11 != null) {
                                                                                        return new PopLeaveFlowDetailBinding((LinearLayout) view, button, button2, constraintLayout, constraintLayout2, linearLayout, viewFindViewById, viewFindViewById2, nestedScrollView, recyclerView, textView, textView2, textView3, textView4, textView5, textView6, textView7, textView8, textView9, textView10, textView11);
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
