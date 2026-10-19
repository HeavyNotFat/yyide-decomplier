package com.yd.android_brand_mvp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.widget.NestedScrollView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import com.yd.android_brand_mvp.R;

/* JADX INFO: loaded from: classes4.dex */
public final class DialogLeaveDetailBinding implements ViewBinding {
    public final Button btnDialogLeaveDetailRevoke;
    public final ImageView ivCancel;
    public final ImageView ivOriginal;
    public final ImageView ivUpdate;
    public final LinearLayoutCompat llCancelProcess;
    public final LinearLayoutCompat llOriginalProcess;
    public final LinearLayoutCompat llUpdateProcess;
    private final ConstraintLayout rootView;
    public final RecyclerView rvDialogLeaveCancelDetailProcess;
    public final RecyclerView rvDialogLeaveDetailContent;
    public final RecyclerView rvDialogLeaveDetailProcess;
    public final RecyclerView rvDialogLeaveUpdateDetailProcess;
    public final NestedScrollView svDialogLeaveDetail;
    public final TextView tvDialogLeaveDetailName;
    public final TextView tvDialogLeaveDetailProcessTitle;
    public final TextView tvDialogLeaveDetailStatus;
    public final TextView tvDialogLeaveDetailSubmitTime;
    public final TextView tvDialogLeaveDetailTitle;
    public final View view;

    private DialogLeaveDetailBinding(ConstraintLayout constraintLayout, Button button, ImageView imageView, ImageView imageView2, ImageView imageView3, LinearLayoutCompat linearLayoutCompat, LinearLayoutCompat linearLayoutCompat2, LinearLayoutCompat linearLayoutCompat3, RecyclerView recyclerView, RecyclerView recyclerView2, RecyclerView recyclerView3, RecyclerView recyclerView4, NestedScrollView nestedScrollView, TextView textView, TextView textView2, TextView textView3, TextView textView4, TextView textView5, View view) {
        this.rootView = constraintLayout;
        this.btnDialogLeaveDetailRevoke = button;
        this.ivCancel = imageView;
        this.ivOriginal = imageView2;
        this.ivUpdate = imageView3;
        this.llCancelProcess = linearLayoutCompat;
        this.llOriginalProcess = linearLayoutCompat2;
        this.llUpdateProcess = linearLayoutCompat3;
        this.rvDialogLeaveCancelDetailProcess = recyclerView;
        this.rvDialogLeaveDetailContent = recyclerView2;
        this.rvDialogLeaveDetailProcess = recyclerView3;
        this.rvDialogLeaveUpdateDetailProcess = recyclerView4;
        this.svDialogLeaveDetail = nestedScrollView;
        this.tvDialogLeaveDetailName = textView;
        this.tvDialogLeaveDetailProcessTitle = textView2;
        this.tvDialogLeaveDetailStatus = textView3;
        this.tvDialogLeaveDetailSubmitTime = textView4;
        this.tvDialogLeaveDetailTitle = textView5;
        this.view = view;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static DialogLeaveDetailBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static DialogLeaveDetailBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.dialog_leave_detail, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static DialogLeaveDetailBinding bind(View view) {
        int i = R.id.btn_dialog_leave_detail_revoke;
        Button button = (Button) view.findViewById(R.id.btn_dialog_leave_detail_revoke);
        if (button != null) {
            i = R.id.ivCancel;
            ImageView imageView = (ImageView) view.findViewById(R.id.ivCancel);
            if (imageView != null) {
                i = R.id.ivOriginal;
                ImageView imageView2 = (ImageView) view.findViewById(R.id.ivOriginal);
                if (imageView2 != null) {
                    i = R.id.ivUpdate;
                    ImageView imageView3 = (ImageView) view.findViewById(R.id.ivUpdate);
                    if (imageView3 != null) {
                        i = R.id.llCancelProcess;
                        LinearLayoutCompat linearLayoutCompat = (LinearLayoutCompat) view.findViewById(R.id.llCancelProcess);
                        if (linearLayoutCompat != null) {
                            i = R.id.llOriginalProcess;
                            LinearLayoutCompat linearLayoutCompat2 = (LinearLayoutCompat) view.findViewById(R.id.llOriginalProcess);
                            if (linearLayoutCompat2 != null) {
                                i = R.id.llUpdateProcess;
                                LinearLayoutCompat linearLayoutCompat3 = (LinearLayoutCompat) view.findViewById(R.id.llUpdateProcess);
                                if (linearLayoutCompat3 != null) {
                                    i = R.id.rv_dialog_leave_cancel_detail_process;
                                    RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.rv_dialog_leave_cancel_detail_process);
                                    if (recyclerView != null) {
                                        i = R.id.rv_dialog_leave_detail_content;
                                        RecyclerView recyclerView2 = (RecyclerView) view.findViewById(R.id.rv_dialog_leave_detail_content);
                                        if (recyclerView2 != null) {
                                            i = R.id.rv_dialog_leave_detail_process;
                                            RecyclerView recyclerView3 = (RecyclerView) view.findViewById(R.id.rv_dialog_leave_detail_process);
                                            if (recyclerView3 != null) {
                                                i = R.id.rv_dialog_leave_update_detail_process;
                                                RecyclerView recyclerView4 = (RecyclerView) view.findViewById(R.id.rv_dialog_leave_update_detail_process);
                                                if (recyclerView4 != null) {
                                                    i = R.id.sv_dialog_leave_detail;
                                                    NestedScrollView nestedScrollView = (NestedScrollView) view.findViewById(R.id.sv_dialog_leave_detail);
                                                    if (nestedScrollView != null) {
                                                        i = R.id.tv_dialog_leave_detail_name;
                                                        TextView textView = (TextView) view.findViewById(R.id.tv_dialog_leave_detail_name);
                                                        if (textView != null) {
                                                            i = R.id.tv_dialog_leave_detail_process_title;
                                                            TextView textView2 = (TextView) view.findViewById(R.id.tv_dialog_leave_detail_process_title);
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
                                                                                return new DialogLeaveDetailBinding((ConstraintLayout) view, button, imageView, imageView2, imageView3, linearLayoutCompat, linearLayoutCompat2, linearLayoutCompat3, recyclerView, recyclerView2, recyclerView3, recyclerView4, nestedScrollView, textView, textView2, textView3, textView4, textView5, viewFindViewById);
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
