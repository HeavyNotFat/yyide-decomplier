package com.yd.android_brand_mvp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Group;
import androidx.core.widget.NestedScrollView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import com.yd.android_brand_mvp.R;

/* JADX INFO: loaded from: classes4.dex */
public final class DialogFormDetailBinding implements ViewBinding {
    public final Button btnDialogFormDetailModify;
    public final Button btnDialogFormDetailRevoke;
    public final Button btnDialogLeaveDetailRevoke;
    public final Group groupButtonWithModify;
    private final ConstraintLayout rootView;
    public final RecyclerView rvDialogLeaveDetailContent;
    public final RecyclerView rvDialogLeaveDetailProcess;
    public final NestedScrollView svDialogLeaveDetail;
    public final TextView tvDialogLeaveDetailName;
    public final TextView tvDialogLeaveDetailNewStatus;
    public final TextView tvDialogLeaveDetailStatus;
    public final TextView tvDialogLeaveDetailSubmitTime;
    public final TextView tvDialogLeaveDetailTitle;
    public final View view;
    public final View viewLine1;

    private DialogFormDetailBinding(ConstraintLayout constraintLayout, Button button, Button button2, Button button3, Group group, RecyclerView recyclerView, RecyclerView recyclerView2, NestedScrollView nestedScrollView, TextView textView, TextView textView2, TextView textView3, TextView textView4, TextView textView5, View view, View view2) {
        this.rootView = constraintLayout;
        this.btnDialogFormDetailModify = button;
        this.btnDialogFormDetailRevoke = button2;
        this.btnDialogLeaveDetailRevoke = button3;
        this.groupButtonWithModify = group;
        this.rvDialogLeaveDetailContent = recyclerView;
        this.rvDialogLeaveDetailProcess = recyclerView2;
        this.svDialogLeaveDetail = nestedScrollView;
        this.tvDialogLeaveDetailName = textView;
        this.tvDialogLeaveDetailNewStatus = textView2;
        this.tvDialogLeaveDetailStatus = textView3;
        this.tvDialogLeaveDetailSubmitTime = textView4;
        this.tvDialogLeaveDetailTitle = textView5;
        this.view = view;
        this.viewLine1 = view2;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static DialogFormDetailBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static DialogFormDetailBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.dialog_form_detail, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static DialogFormDetailBinding bind(View view) {
        int i = R.id.btn_dialog_form_detail_modify;
        Button button = (Button) view.findViewById(R.id.btn_dialog_form_detail_modify);
        if (button != null) {
            i = R.id.btn_dialog_form_detail_revoke;
            Button button2 = (Button) view.findViewById(R.id.btn_dialog_form_detail_revoke);
            if (button2 != null) {
                i = R.id.btn_dialog_leave_detail_revoke;
                Button button3 = (Button) view.findViewById(R.id.btn_dialog_leave_detail_revoke);
                if (button3 != null) {
                    i = R.id.group_button_with_modify;
                    Group group = (Group) view.findViewById(R.id.group_button_with_modify);
                    if (group != null) {
                        i = R.id.rv_dialog_leave_detail_content;
                        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.rv_dialog_leave_detail_content);
                        if (recyclerView != null) {
                            i = R.id.rv_dialog_leave_detail_process;
                            RecyclerView recyclerView2 = (RecyclerView) view.findViewById(R.id.rv_dialog_leave_detail_process);
                            if (recyclerView2 != null) {
                                i = R.id.sv_dialog_leave_detail;
                                NestedScrollView nestedScrollView = (NestedScrollView) view.findViewById(R.id.sv_dialog_leave_detail);
                                if (nestedScrollView != null) {
                                    i = R.id.tv_dialog_leave_detail_name;
                                    TextView textView = (TextView) view.findViewById(R.id.tv_dialog_leave_detail_name);
                                    if (textView != null) {
                                        i = R.id.tv_dialog_leave_detail_new_status;
                                        TextView textView2 = (TextView) view.findViewById(R.id.tv_dialog_leave_detail_new_status);
                                        if (textView2 != null) {
                                            i = R.id.tv_dialog_leave_detail_status;
                                            TextView textView3 = (TextView) view.findViewById(R.id.tv_dialog_leave_detail_status);
                                            if (textView3 != null) {
                                                i = R.id.tv_dialog_leave_detail_submit_time;
                                                TextView textView4 = (TextView) view.findViewById(R.id.tv_dialog_leave_detail_submit_time);
                                                if (textView4 != null) {
                                                    i = R.id.tv_dialog_leave_detail_title;
                                                    TextView textView5 = (TextView) view.findViewById(R.id.tv_dialog_leave_detail_title);
                                                    if (textView5 != null) {
                                                        i = R.id.view;
                                                        View viewFindViewById = view.findViewById(R.id.view);
                                                        if (viewFindViewById != null) {
                                                            i = R.id.view_line1;
                                                            View viewFindViewById2 = view.findViewById(R.id.view_line1);
                                                            if (viewFindViewById2 != null) {
                                                                return new DialogFormDetailBinding((ConstraintLayout) view, button, button2, button3, group, recyclerView, recyclerView2, nestedScrollView, textView, textView2, textView3, textView4, textView5, viewFindViewById, viewFindViewById2);
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
