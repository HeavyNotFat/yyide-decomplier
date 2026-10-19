package com.yd.android_brand_mvp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.Button;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.yd.android_brand_mvp.R;

/* JADX INFO: loaded from: classes4.dex */
public final class FragmentHomeExamArrangementBinding implements ViewBinding {
    public final Button btnFragmentExamSign;
    public final ConstraintLayout clFragmentExamArrangement;
    public final ViewStub emptyView;
    private final ConstraintLayout rootView;
    public final LayoutHeadTitleBinding topFragmentExamArrangement;
    public final View topFragmentExamArrangementContent;
    public final TextView tvFragmentExamArrangementAddress;
    public final TextView tvFragmentExamArrangementAddressTip;
    public final TextView tvFragmentExamArrangementNext;
    public final TextView tvFragmentExamArrangementNumber;
    public final TextView tvFragmentExamArrangementNumberTip;
    public final TextView tvFragmentExamArrangementPage;
    public final TextView tvFragmentExamArrangementPre;
    public final TextView tvFragmentExamArrangementSubject;
    public final TextView tvFragmentExamArrangementTeacher;
    public final TextView tvFragmentExamArrangementTeacherTip;
    public final TextView tvFragmentExamArrangementTime;
    public final TextView tvFragmentExamArrangementTimeTip;

    private FragmentHomeExamArrangementBinding(ConstraintLayout constraintLayout, Button button, ConstraintLayout constraintLayout2, ViewStub viewStub, LayoutHeadTitleBinding layoutHeadTitleBinding, View view, TextView textView, TextView textView2, TextView textView3, TextView textView4, TextView textView5, TextView textView6, TextView textView7, TextView textView8, TextView textView9, TextView textView10, TextView textView11, TextView textView12) {
        this.rootView = constraintLayout;
        this.btnFragmentExamSign = button;
        this.clFragmentExamArrangement = constraintLayout2;
        this.emptyView = viewStub;
        this.topFragmentExamArrangement = layoutHeadTitleBinding;
        this.topFragmentExamArrangementContent = view;
        this.tvFragmentExamArrangementAddress = textView;
        this.tvFragmentExamArrangementAddressTip = textView2;
        this.tvFragmentExamArrangementNext = textView3;
        this.tvFragmentExamArrangementNumber = textView4;
        this.tvFragmentExamArrangementNumberTip = textView5;
        this.tvFragmentExamArrangementPage = textView6;
        this.tvFragmentExamArrangementPre = textView7;
        this.tvFragmentExamArrangementSubject = textView8;
        this.tvFragmentExamArrangementTeacher = textView9;
        this.tvFragmentExamArrangementTeacherTip = textView10;
        this.tvFragmentExamArrangementTime = textView11;
        this.tvFragmentExamArrangementTimeTip = textView12;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static FragmentHomeExamArrangementBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static FragmentHomeExamArrangementBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.fragment_home_exam_arrangement, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static FragmentHomeExamArrangementBinding bind(View view) {
        int i = R.id.btn_fragment_exam_sign;
        Button button = (Button) view.findViewById(R.id.btn_fragment_exam_sign);
        if (button != null) {
            ConstraintLayout constraintLayout = (ConstraintLayout) view;
            i = R.id.empty_view;
            ViewStub viewStub = (ViewStub) view.findViewById(R.id.empty_view);
            if (viewStub != null) {
                i = R.id.top_fragment_exam_arrangement;
                View viewFindViewById = view.findViewById(R.id.top_fragment_exam_arrangement);
                if (viewFindViewById != null) {
                    LayoutHeadTitleBinding layoutHeadTitleBindingBind = LayoutHeadTitleBinding.bind(viewFindViewById);
                    i = R.id.top_fragment_exam_arrangement_content;
                    View viewFindViewById2 = view.findViewById(R.id.top_fragment_exam_arrangement_content);
                    if (viewFindViewById2 != null) {
                        i = R.id.tv_fragment_exam_arrangement_address;
                        TextView textView = (TextView) view.findViewById(R.id.tv_fragment_exam_arrangement_address);
                        if (textView != null) {
                            i = R.id.tv_fragment_exam_arrangement_address_tip;
                            TextView textView2 = (TextView) view.findViewById(R.id.tv_fragment_exam_arrangement_address_tip);
                            if (textView2 != null) {
                                i = R.id.tv_fragment_exam_arrangement_next;
                                TextView textView3 = (TextView) view.findViewById(R.id.tv_fragment_exam_arrangement_next);
                                if (textView3 != null) {
                                    i = R.id.tv_fragment_exam_arrangement_number;
                                    TextView textView4 = (TextView) view.findViewById(R.id.tv_fragment_exam_arrangement_number);
                                    if (textView4 != null) {
                                        i = R.id.tv_fragment_exam_arrangement_number_tip;
                                        TextView textView5 = (TextView) view.findViewById(R.id.tv_fragment_exam_arrangement_number_tip);
                                        if (textView5 != null) {
                                            i = R.id.tv_fragment_exam_arrangement_page;
                                            TextView textView6 = (TextView) view.findViewById(R.id.tv_fragment_exam_arrangement_page);
                                            if (textView6 != null) {
                                                i = R.id.tv_fragment_exam_arrangement_pre;
                                                TextView textView7 = (TextView) view.findViewById(R.id.tv_fragment_exam_arrangement_pre);
                                                if (textView7 != null) {
                                                    i = R.id.tv_fragment_exam_arrangement_subject;
                                                    TextView textView8 = (TextView) view.findViewById(R.id.tv_fragment_exam_arrangement_subject);
                                                    if (textView8 != null) {
                                                        i = R.id.tv_fragment_exam_arrangement_teacher;
                                                        TextView textView9 = (TextView) view.findViewById(R.id.tv_fragment_exam_arrangement_teacher);
                                                        if (textView9 != null) {
                                                            i = R.id.tv_fragment_exam_arrangement_teacher_tip;
                                                            TextView textView10 = (TextView) view.findViewById(R.id.tv_fragment_exam_arrangement_teacher_tip);
                                                            if (textView10 != null) {
                                                                i = R.id.tv_fragment_exam_arrangement_time;
                                                                TextView textView11 = (TextView) view.findViewById(R.id.tv_fragment_exam_arrangement_time);
                                                                if (textView11 != null) {
                                                                    i = R.id.tv_fragment_exam_arrangement_time_tip;
                                                                    TextView textView12 = (TextView) view.findViewById(R.id.tv_fragment_exam_arrangement_time_tip);
                                                                    if (textView12 != null) {
                                                                        return new FragmentHomeExamArrangementBinding(constraintLayout, button, constraintLayout, viewStub, layoutHeadTitleBindingBind, viewFindViewById2, textView, textView2, textView3, textView4, textView5, textView6, textView7, textView8, textView9, textView10, textView11, textView12);
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
