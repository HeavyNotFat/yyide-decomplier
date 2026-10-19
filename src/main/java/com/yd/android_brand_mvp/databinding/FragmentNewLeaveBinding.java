package com.yd.android_brand_mvp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import com.yd.android_brand_mvp.R;
import com.yd.android_brand_mvp.widget.YDEditText;

/* JADX INFO: loaded from: classes4.dex */
public final class FragmentNewLeaveBinding implements ViewBinding {
    public final View appLine;
    public final RecyclerView approvalList;
    public final View ccLine;
    public final RecyclerView ccList;
    public final ConstraintLayout clFlow;
    public final ConstraintLayout ctProcess;
    public final YDEditText etContent;
    public final ImageView ivAddApproval;
    public final ImageView ivAddStaff;
    private final LinearLayout rootView;
    public final TextView tvApprover;
    public final TextView tvApproverPrompt;
    public final TextView tvClass;
    public final TextView tvCopyPeople;
    public final TextView tvCopyPrompt;
    public final TextView tvEndTime;
    public final TextView tvFlow;
    public final TextView tvStartTime;
    public final TextView tvSubmit;
    public final View viewCode;
    public final View viewLine;
    public final View viewLine2;
    public final View viewTop;

    private FragmentNewLeaveBinding(LinearLayout linearLayout, View view, RecyclerView recyclerView, View view2, RecyclerView recyclerView2, ConstraintLayout constraintLayout, ConstraintLayout constraintLayout2, YDEditText yDEditText, ImageView imageView, ImageView imageView2, TextView textView, TextView textView2, TextView textView3, TextView textView4, TextView textView5, TextView textView6, TextView textView7, TextView textView8, TextView textView9, View view3, View view4, View view5, View view6) {
        this.rootView = linearLayout;
        this.appLine = view;
        this.approvalList = recyclerView;
        this.ccLine = view2;
        this.ccList = recyclerView2;
        this.clFlow = constraintLayout;
        this.ctProcess = constraintLayout2;
        this.etContent = yDEditText;
        this.ivAddApproval = imageView;
        this.ivAddStaff = imageView2;
        this.tvApprover = textView;
        this.tvApproverPrompt = textView2;
        this.tvClass = textView3;
        this.tvCopyPeople = textView4;
        this.tvCopyPrompt = textView5;
        this.tvEndTime = textView6;
        this.tvFlow = textView7;
        this.tvStartTime = textView8;
        this.tvSubmit = textView9;
        this.viewCode = view3;
        this.viewLine = view4;
        this.viewLine2 = view5;
        this.viewTop = view6;
    }

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static FragmentNewLeaveBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static FragmentNewLeaveBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.fragment_new_leave, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static FragmentNewLeaveBinding bind(View view) {
        int i = R.id.appLine;
        View viewFindViewById = view.findViewById(R.id.appLine);
        if (viewFindViewById != null) {
            i = R.id.approvalList;
            RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.approvalList);
            if (recyclerView != null) {
                i = R.id.ccLine;
                View viewFindViewById2 = view.findViewById(R.id.ccLine);
                if (viewFindViewById2 != null) {
                    i = R.id.ccList;
                    RecyclerView recyclerView2 = (RecyclerView) view.findViewById(R.id.ccList);
                    if (recyclerView2 != null) {
                        i = R.id.cl_flow;
                        ConstraintLayout constraintLayout = (ConstraintLayout) view.findViewById(R.id.cl_flow);
                        if (constraintLayout != null) {
                            i = R.id.ctProcess;
                            ConstraintLayout constraintLayout2 = (ConstraintLayout) view.findViewById(R.id.ctProcess);
                            if (constraintLayout2 != null) {
                                i = R.id.et_content;
                                YDEditText yDEditText = (YDEditText) view.findViewById(R.id.et_content);
                                if (yDEditText != null) {
                                    i = R.id.iv_add_approval;
                                    ImageView imageView = (ImageView) view.findViewById(R.id.iv_add_approval);
                                    if (imageView != null) {
                                        i = R.id.iv_add_staff;
                                        ImageView imageView2 = (ImageView) view.findViewById(R.id.iv_add_staff);
                                        if (imageView2 != null) {
                                            i = R.id.tv_approver;
                                            TextView textView = (TextView) view.findViewById(R.id.tv_approver);
                                            if (textView != null) {
                                                i = R.id.tv_approver_prompt;
                                                TextView textView2 = (TextView) view.findViewById(R.id.tv_approver_prompt);
                                                if (textView2 != null) {
                                                    i = R.id.tv_class;
                                                    TextView textView3 = (TextView) view.findViewById(R.id.tv_class);
                                                    if (textView3 != null) {
                                                        i = R.id.tv_copy_people;
                                                        TextView textView4 = (TextView) view.findViewById(R.id.tv_copy_people);
                                                        if (textView4 != null) {
                                                            i = R.id.tv_copy_prompt;
                                                            TextView textView5 = (TextView) view.findViewById(R.id.tv_copy_prompt);
                                                            if (textView5 != null) {
                                                                i = R.id.tv_end_time;
                                                                TextView textView6 = (TextView) view.findViewById(R.id.tv_end_time);
                                                                if (textView6 != null) {
                                                                    i = R.id.tv_flow;
                                                                    TextView textView7 = (TextView) view.findViewById(R.id.tv_flow);
                                                                    if (textView7 != null) {
                                                                        i = R.id.tv_start_time;
                                                                        TextView textView8 = (TextView) view.findViewById(R.id.tv_start_time);
                                                                        if (textView8 != null) {
                                                                            i = R.id.tv_submit;
                                                                            TextView textView9 = (TextView) view.findViewById(R.id.tv_submit);
                                                                            if (textView9 != null) {
                                                                                i = R.id.viewCode;
                                                                                View viewFindViewById3 = view.findViewById(R.id.viewCode);
                                                                                if (viewFindViewById3 != null) {
                                                                                    i = R.id.viewLine;
                                                                                    View viewFindViewById4 = view.findViewById(R.id.viewLine);
                                                                                    if (viewFindViewById4 != null) {
                                                                                        i = R.id.viewLine2;
                                                                                        View viewFindViewById5 = view.findViewById(R.id.viewLine2);
                                                                                        if (viewFindViewById5 != null) {
                                                                                            i = R.id.viewTop;
                                                                                            View viewFindViewById6 = view.findViewById(R.id.viewTop);
                                                                                            if (viewFindViewById6 != null) {
                                                                                                return new FragmentNewLeaveBinding((LinearLayout) view, viewFindViewById, recyclerView, viewFindViewById2, recyclerView2, constraintLayout, constraintLayout2, yDEditText, imageView, imageView2, textView, textView2, textView3, textView4, textView5, textView6, textView7, textView8, textView9, viewFindViewById3, viewFindViewById4, viewFindViewById5, viewFindViewById6);
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
