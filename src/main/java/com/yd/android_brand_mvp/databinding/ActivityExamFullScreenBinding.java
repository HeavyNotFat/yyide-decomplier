package com.yd.android_brand_mvp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.FragmentContainerView;
import androidx.viewbinding.ViewBinding;
import com.yd.android_brand_mvp.R;

/* JADX INFO: loaded from: classes4.dex */
public final class ActivityExamFullScreenBinding implements ViewBinding {
    public final ConstraintLayout clActivityExamFull;
    public final ConstraintLayout clActivityExamFullScreenContent;
    public final ConstraintLayout clTopActivityExamFullScreenContent;
    public final FragmentContainerView fragmentExamFullContent;
    public final ImageView ivActivityExamFullScreenReturnBottom;
    public final ImageView ivFragmentExamFullReturn;
    public final ImageView ivFragmentExamFullSwitch;
    private final ConstraintLayout rootView;
    public final TopLayoutBinding topActivityExamFull;
    public final TextView tvFragmentExamFullScreen;
    public final TextView tvFragmentExamFullSwitch;

    private ActivityExamFullScreenBinding(ConstraintLayout constraintLayout, ConstraintLayout constraintLayout2, ConstraintLayout constraintLayout3, ConstraintLayout constraintLayout4, FragmentContainerView fragmentContainerView, ImageView imageView, ImageView imageView2, ImageView imageView3, TopLayoutBinding topLayoutBinding, TextView textView, TextView textView2) {
        this.rootView = constraintLayout;
        this.clActivityExamFull = constraintLayout2;
        this.clActivityExamFullScreenContent = constraintLayout3;
        this.clTopActivityExamFullScreenContent = constraintLayout4;
        this.fragmentExamFullContent = fragmentContainerView;
        this.ivActivityExamFullScreenReturnBottom = imageView;
        this.ivFragmentExamFullReturn = imageView2;
        this.ivFragmentExamFullSwitch = imageView3;
        this.topActivityExamFull = topLayoutBinding;
        this.tvFragmentExamFullScreen = textView;
        this.tvFragmentExamFullSwitch = textView2;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static ActivityExamFullScreenBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static ActivityExamFullScreenBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.activity_exam_full_screen, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static ActivityExamFullScreenBinding bind(View view) {
        ConstraintLayout constraintLayout = (ConstraintLayout) view;
        int i = R.id.cl_activity_exam_full_screen_content;
        ConstraintLayout constraintLayout2 = (ConstraintLayout) view.findViewById(R.id.cl_activity_exam_full_screen_content);
        if (constraintLayout2 != null) {
            i = R.id.cl_top_activity_exam_full_screen_content;
            ConstraintLayout constraintLayout3 = (ConstraintLayout) view.findViewById(R.id.cl_top_activity_exam_full_screen_content);
            if (constraintLayout3 != null) {
                i = R.id.fragment_exam_full_content;
                FragmentContainerView fragmentContainerView = (FragmentContainerView) view.findViewById(R.id.fragment_exam_full_content);
                if (fragmentContainerView != null) {
                    i = R.id.iv_activity_exam_full_screen_return_bottom;
                    ImageView imageView = (ImageView) view.findViewById(R.id.iv_activity_exam_full_screen_return_bottom);
                    if (imageView != null) {
                        i = R.id.iv_fragment_exam_full_return;
                        ImageView imageView2 = (ImageView) view.findViewById(R.id.iv_fragment_exam_full_return);
                        if (imageView2 != null) {
                            i = R.id.iv_fragment_exam_full_switch;
                            ImageView imageView3 = (ImageView) view.findViewById(R.id.iv_fragment_exam_full_switch);
                            if (imageView3 != null) {
                                i = R.id.top_activity_exam_full;
                                View viewFindViewById = view.findViewById(R.id.top_activity_exam_full);
                                if (viewFindViewById != null) {
                                    TopLayoutBinding topLayoutBindingBind = TopLayoutBinding.bind(viewFindViewById);
                                    i = R.id.tv_fragment_exam_full_screen;
                                    TextView textView = (TextView) view.findViewById(R.id.tv_fragment_exam_full_screen);
                                    if (textView != null) {
                                        i = R.id.tv_fragment_exam_full_switch;
                                        TextView textView2 = (TextView) view.findViewById(R.id.tv_fragment_exam_full_switch);
                                        if (textView2 != null) {
                                            return new ActivityExamFullScreenBinding(constraintLayout, constraintLayout, constraintLayout2, constraintLayout3, fragmentContainerView, imageView, imageView2, imageView3, topLayoutBindingBind, textView, textView2);
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
