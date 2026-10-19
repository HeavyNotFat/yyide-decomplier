package com.yd.android_brand_mvp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.widget.NestedScrollView;
import androidx.viewbinding.ViewBinding;
import com.yd.android_brand_mvp.R;

/* JADX INFO: loaded from: classes4.dex */
public final class ActivityCollectFormDetailBinding implements ViewBinding {
    public final TextView btnActivityCollectFormDetail;
    public final ConstraintLayout clActivityCollectFormDetail;
    public final ConstraintLayout clActivityCollectFormDetailBtn;
    public final ConstraintLayout clActivityCollectFormDetailContent;
    public final ConstraintLayout clActivityCollectFormTop;
    public final ImageView ivActivityCollectFormBottomReturn;
    public final ImageView ivActivityCollectFormTopReturn;
    public final LinearLayout llActivityCollectFormDetailContainer;
    private final ConstraintLayout rootView;
    public final NestedScrollView scrollViewActivityFormDetail;
    public final TopLayoutBinding topActivityCollectForm;
    public final TextView tvActivityCollectFormTopTitle;
    public final ViewCollectFormHeadBinding viewActivityCollectFormHead;

    private ActivityCollectFormDetailBinding(ConstraintLayout constraintLayout, TextView textView, ConstraintLayout constraintLayout2, ConstraintLayout constraintLayout3, ConstraintLayout constraintLayout4, ConstraintLayout constraintLayout5, ImageView imageView, ImageView imageView2, LinearLayout linearLayout, NestedScrollView nestedScrollView, TopLayoutBinding topLayoutBinding, TextView textView2, ViewCollectFormHeadBinding viewCollectFormHeadBinding) {
        this.rootView = constraintLayout;
        this.btnActivityCollectFormDetail = textView;
        this.clActivityCollectFormDetail = constraintLayout2;
        this.clActivityCollectFormDetailBtn = constraintLayout3;
        this.clActivityCollectFormDetailContent = constraintLayout4;
        this.clActivityCollectFormTop = constraintLayout5;
        this.ivActivityCollectFormBottomReturn = imageView;
        this.ivActivityCollectFormTopReturn = imageView2;
        this.llActivityCollectFormDetailContainer = linearLayout;
        this.scrollViewActivityFormDetail = nestedScrollView;
        this.topActivityCollectForm = topLayoutBinding;
        this.tvActivityCollectFormTopTitle = textView2;
        this.viewActivityCollectFormHead = viewCollectFormHeadBinding;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static ActivityCollectFormDetailBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static ActivityCollectFormDetailBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.activity_collect_form_detail, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static ActivityCollectFormDetailBinding bind(View view) {
        int i = R.id.btn_activity_collect_form_detail;
        TextView textView = (TextView) view.findViewById(R.id.btn_activity_collect_form_detail);
        if (textView != null) {
            ConstraintLayout constraintLayout = (ConstraintLayout) view;
            i = R.id.cl_activity_collect_form_detail_btn;
            ConstraintLayout constraintLayout2 = (ConstraintLayout) view.findViewById(R.id.cl_activity_collect_form_detail_btn);
            if (constraintLayout2 != null) {
                i = R.id.cl_activity_collect_form_detail_content;
                ConstraintLayout constraintLayout3 = (ConstraintLayout) view.findViewById(R.id.cl_activity_collect_form_detail_content);
                if (constraintLayout3 != null) {
                    i = R.id.cl_activity_collect_form_top;
                    ConstraintLayout constraintLayout4 = (ConstraintLayout) view.findViewById(R.id.cl_activity_collect_form_top);
                    if (constraintLayout4 != null) {
                        i = R.id.iv_activity_collect_form_bottom_return;
                        ImageView imageView = (ImageView) view.findViewById(R.id.iv_activity_collect_form_bottom_return);
                        if (imageView != null) {
                            i = R.id.iv_activity_collect_form_top_return;
                            ImageView imageView2 = (ImageView) view.findViewById(R.id.iv_activity_collect_form_top_return);
                            if (imageView2 != null) {
                                i = R.id.ll_activity_collect_form_detail_container;
                                LinearLayout linearLayout = (LinearLayout) view.findViewById(R.id.ll_activity_collect_form_detail_container);
                                if (linearLayout != null) {
                                    i = R.id.scrollView_activity_form_detail;
                                    NestedScrollView nestedScrollView = (NestedScrollView) view.findViewById(R.id.scrollView_activity_form_detail);
                                    if (nestedScrollView != null) {
                                        i = R.id.top_activity_collect_form;
                                        View viewFindViewById = view.findViewById(R.id.top_activity_collect_form);
                                        if (viewFindViewById != null) {
                                            TopLayoutBinding topLayoutBindingBind = TopLayoutBinding.bind(viewFindViewById);
                                            i = R.id.tv_activity_collect_form_top_title;
                                            TextView textView2 = (TextView) view.findViewById(R.id.tv_activity_collect_form_top_title);
                                            if (textView2 != null) {
                                                i = R.id.view_activity_collect_form_head;
                                                View viewFindViewById2 = view.findViewById(R.id.view_activity_collect_form_head);
                                                if (viewFindViewById2 != null) {
                                                    return new ActivityCollectFormDetailBinding(constraintLayout, textView, constraintLayout, constraintLayout2, constraintLayout3, constraintLayout4, imageView, imageView2, linearLayout, nestedScrollView, topLayoutBindingBind, textView2, ViewCollectFormHeadBinding.bind(viewFindViewById2));
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
