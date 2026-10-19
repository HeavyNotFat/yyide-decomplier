package com.yd.android_brand_mvp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.yd.android_brand_mvp.R;

/* JADX INFO: loaded from: classes4.dex */
public final class GankDialogHomeTaskDetailBinding implements ViewBinding {
    public final Button btnActivitySignTaskSign;
    public final ConstraintLayout clActivitySignTaskBtn;
    private final ConstraintLayout rootView;
    public final TextView tvDialogHomeTaskDetailDesc;
    public final TextView tvDialogHomeTaskDetailRange;
    public final TextView tvDialogHomeTaskDetailSubTitle;
    public final TextView tvDialogHomeTaskDetailTitle;
    public final TextView tvDialogHomeTaskTitle;
    public final TextView tvDialogTaskDetailEndDate;
    public final TextView tvDialogTaskDetailRate;
    public final TextView tvDialogTaskDetailRequire;
    public final TextView tvDialogTaskDetailStartDate;
    public final TextView tvTaskDetailEndDateTitle;
    public final TextView tvTaskDetailRangeTitle;
    public final TextView tvTaskDetailRateTitle;
    public final TextView tvTaskDetailRequireTitle;
    public final TextView tvTaskDetailStartDateTitle;

    private GankDialogHomeTaskDetailBinding(ConstraintLayout constraintLayout, Button button, ConstraintLayout constraintLayout2, TextView textView, TextView textView2, TextView textView3, TextView textView4, TextView textView5, TextView textView6, TextView textView7, TextView textView8, TextView textView9, TextView textView10, TextView textView11, TextView textView12, TextView textView13, TextView textView14) {
        this.rootView = constraintLayout;
        this.btnActivitySignTaskSign = button;
        this.clActivitySignTaskBtn = constraintLayout2;
        this.tvDialogHomeTaskDetailDesc = textView;
        this.tvDialogHomeTaskDetailRange = textView2;
        this.tvDialogHomeTaskDetailSubTitle = textView3;
        this.tvDialogHomeTaskDetailTitle = textView4;
        this.tvDialogHomeTaskTitle = textView5;
        this.tvDialogTaskDetailEndDate = textView6;
        this.tvDialogTaskDetailRate = textView7;
        this.tvDialogTaskDetailRequire = textView8;
        this.tvDialogTaskDetailStartDate = textView9;
        this.tvTaskDetailEndDateTitle = textView10;
        this.tvTaskDetailRangeTitle = textView11;
        this.tvTaskDetailRateTitle = textView12;
        this.tvTaskDetailRequireTitle = textView13;
        this.tvTaskDetailStartDateTitle = textView14;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static GankDialogHomeTaskDetailBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static GankDialogHomeTaskDetailBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.gank_dialog_home_task_detail, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static GankDialogHomeTaskDetailBinding bind(View view) {
        int i = R.id.btn_activity_sign_task_sign;
        Button button = (Button) view.findViewById(R.id.btn_activity_sign_task_sign);
        if (button != null) {
            i = R.id.cl_activity_sign_task_btn;
            ConstraintLayout constraintLayout = (ConstraintLayout) view.findViewById(R.id.cl_activity_sign_task_btn);
            if (constraintLayout != null) {
                i = R.id.tv_dialog_home_task_detail_desc;
                TextView textView = (TextView) view.findViewById(R.id.tv_dialog_home_task_detail_desc);
                if (textView != null) {
                    i = R.id.tv_dialog_home_task_detail_range;
                    TextView textView2 = (TextView) view.findViewById(R.id.tv_dialog_home_task_detail_range);
                    if (textView2 != null) {
                        i = R.id.tv_dialog_home_task_detail_subTitle;
                        TextView textView3 = (TextView) view.findViewById(R.id.tv_dialog_home_task_detail_subTitle);
                        if (textView3 != null) {
                            i = R.id.tv_dialog_home_task_detail_title;
                            TextView textView4 = (TextView) view.findViewById(R.id.tv_dialog_home_task_detail_title);
                            if (textView4 != null) {
                                i = R.id.tv_dialog_home_task_title;
                                TextView textView5 = (TextView) view.findViewById(R.id.tv_dialog_home_task_title);
                                if (textView5 != null) {
                                    i = R.id.tv_dialog_task_detail_endDate;
                                    TextView textView6 = (TextView) view.findViewById(R.id.tv_dialog_task_detail_endDate);
                                    if (textView6 != null) {
                                        i = R.id.tv_dialog_task_detail_rate;
                                        TextView textView7 = (TextView) view.findViewById(R.id.tv_dialog_task_detail_rate);
                                        if (textView7 != null) {
                                            i = R.id.tv_dialog_task_detail_require;
                                            TextView textView8 = (TextView) view.findViewById(R.id.tv_dialog_task_detail_require);
                                            if (textView8 != null) {
                                                i = R.id.tv_dialog_task_detail_startDate;
                                                TextView textView9 = (TextView) view.findViewById(R.id.tv_dialog_task_detail_startDate);
                                                if (textView9 != null) {
                                                    i = R.id.tv_task_detail_endDate_title;
                                                    TextView textView10 = (TextView) view.findViewById(R.id.tv_task_detail_endDate_title);
                                                    if (textView10 != null) {
                                                        i = R.id.tv_task_detail_range_title;
                                                        TextView textView11 = (TextView) view.findViewById(R.id.tv_task_detail_range_title);
                                                        if (textView11 != null) {
                                                            i = R.id.tv_task_detail_rate_title;
                                                            TextView textView12 = (TextView) view.findViewById(R.id.tv_task_detail_rate_title);
                                                            if (textView12 != null) {
                                                                i = R.id.tv_task_detail_require_title;
                                                                TextView textView13 = (TextView) view.findViewById(R.id.tv_task_detail_require_title);
                                                                if (textView13 != null) {
                                                                    i = R.id.tv_task_detail_startDate_title;
                                                                    TextView textView14 = (TextView) view.findViewById(R.id.tv_task_detail_startDate_title);
                                                                    if (textView14 != null) {
                                                                        return new GankDialogHomeTaskDetailBinding((ConstraintLayout) view, button, constraintLayout, textView, textView2, textView3, textView4, textView5, textView6, textView7, textView8, textView9, textView10, textView11, textView12, textView13, textView14);
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
