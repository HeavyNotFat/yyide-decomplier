package com.yd.android_brand_mvp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import com.yd.android_brand_mvp.R;
import com.yd.android_brand_mvp.view.TagTextView;

/* JADX INFO: loaded from: classes4.dex */
public final class ActivityTaskDetailBinding implements ViewBinding {
    public final Button btnActivitySignTaskSign;
    public final ConstraintLayout clActivitySignTaskBtn;
    public final ConstraintLayout clActivityTaskDetailInfo;
    public final ConstraintLayout clActivityTaskDetailTop;
    public final ConstraintLayout clTaskDetailSingle;
    public final ImageView ivTaskDetailRangeLogo;
    public final ImageView ivTaskDetailSingleImage1;
    public final ImageView ivTaskDetailSingleImage2;
    public final ImageView ivTaskDetailSingleImage3;
    public final ImageView ivTaskDetailTimeLogo;
    private final ConstraintLayout rootView;
    public final RecyclerView rvTaskDetailUpImage;
    public final TitleLayoutBinding topActivityTaskDetail;
    public final TextView tvTaskDetailDesc;
    public final TextView tvTaskDetailEndTime;
    public final TextView tvTaskDetailEndTimeTitle;
    public final TextView tvTaskDetailRange;
    public final TextView tvTaskDetailRangeTitle;
    public final TextView tvTaskDetailRate;
    public final TextView tvTaskDetailRateTitle;
    public final TextView tvTaskDetailRequire;
    public final TextView tvTaskDetailRequireTitle;
    public final TextView tvTaskDetailSignCount;
    public final TextView tvTaskDetailSignCountTitle;
    public final TextView tvTaskDetailSingleTitle;
    public final TextView tvTaskDetailStartTime;
    public final TextView tvTaskDetailStartTimeTitle;
    public final TagTextView tvTaskDetailTitle;
    public final TextView tvTaskDetailUpImageTitle;

    private ActivityTaskDetailBinding(ConstraintLayout constraintLayout, Button button, ConstraintLayout constraintLayout2, ConstraintLayout constraintLayout3, ConstraintLayout constraintLayout4, ConstraintLayout constraintLayout5, ImageView imageView, ImageView imageView2, ImageView imageView3, ImageView imageView4, ImageView imageView5, RecyclerView recyclerView, TitleLayoutBinding titleLayoutBinding, TextView textView, TextView textView2, TextView textView3, TextView textView4, TextView textView5, TextView textView6, TextView textView7, TextView textView8, TextView textView9, TextView textView10, TextView textView11, TextView textView12, TextView textView13, TextView textView14, TagTextView tagTextView, TextView textView15) {
        this.rootView = constraintLayout;
        this.btnActivitySignTaskSign = button;
        this.clActivitySignTaskBtn = constraintLayout2;
        this.clActivityTaskDetailInfo = constraintLayout3;
        this.clActivityTaskDetailTop = constraintLayout4;
        this.clTaskDetailSingle = constraintLayout5;
        this.ivTaskDetailRangeLogo = imageView;
        this.ivTaskDetailSingleImage1 = imageView2;
        this.ivTaskDetailSingleImage2 = imageView3;
        this.ivTaskDetailSingleImage3 = imageView4;
        this.ivTaskDetailTimeLogo = imageView5;
        this.rvTaskDetailUpImage = recyclerView;
        this.topActivityTaskDetail = titleLayoutBinding;
        this.tvTaskDetailDesc = textView;
        this.tvTaskDetailEndTime = textView2;
        this.tvTaskDetailEndTimeTitle = textView3;
        this.tvTaskDetailRange = textView4;
        this.tvTaskDetailRangeTitle = textView5;
        this.tvTaskDetailRate = textView6;
        this.tvTaskDetailRateTitle = textView7;
        this.tvTaskDetailRequire = textView8;
        this.tvTaskDetailRequireTitle = textView9;
        this.tvTaskDetailSignCount = textView10;
        this.tvTaskDetailSignCountTitle = textView11;
        this.tvTaskDetailSingleTitle = textView12;
        this.tvTaskDetailStartTime = textView13;
        this.tvTaskDetailStartTimeTitle = textView14;
        this.tvTaskDetailTitle = tagTextView;
        this.tvTaskDetailUpImageTitle = textView15;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static ActivityTaskDetailBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static ActivityTaskDetailBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.activity_task_detail, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static ActivityTaskDetailBinding bind(View view) {
        int i = R.id.btn_activity_sign_task_sign;
        Button button = (Button) view.findViewById(R.id.btn_activity_sign_task_sign);
        if (button != null) {
            i = R.id.cl_activity_sign_task_btn;
            ConstraintLayout constraintLayout = (ConstraintLayout) view.findViewById(R.id.cl_activity_sign_task_btn);
            if (constraintLayout != null) {
                i = R.id.cl_activity_task_detail_info;
                ConstraintLayout constraintLayout2 = (ConstraintLayout) view.findViewById(R.id.cl_activity_task_detail_info);
                if (constraintLayout2 != null) {
                    i = R.id.cl_activity_task_detail_top;
                    ConstraintLayout constraintLayout3 = (ConstraintLayout) view.findViewById(R.id.cl_activity_task_detail_top);
                    if (constraintLayout3 != null) {
                        i = R.id.cl_task_detail_single;
                        ConstraintLayout constraintLayout4 = (ConstraintLayout) view.findViewById(R.id.cl_task_detail_single);
                        if (constraintLayout4 != null) {
                            i = R.id.iv_task_detail_range_logo;
                            ImageView imageView = (ImageView) view.findViewById(R.id.iv_task_detail_range_logo);
                            if (imageView != null) {
                                i = R.id.iv_task_detail_single_image1;
                                ImageView imageView2 = (ImageView) view.findViewById(R.id.iv_task_detail_single_image1);
                                if (imageView2 != null) {
                                    i = R.id.iv_task_detail_single_image2;
                                    ImageView imageView3 = (ImageView) view.findViewById(R.id.iv_task_detail_single_image2);
                                    if (imageView3 != null) {
                                        i = R.id.iv_task_detail_single_image3;
                                        ImageView imageView4 = (ImageView) view.findViewById(R.id.iv_task_detail_single_image3);
                                        if (imageView4 != null) {
                                            i = R.id.iv_task_detail_time_logo;
                                            ImageView imageView5 = (ImageView) view.findViewById(R.id.iv_task_detail_time_logo);
                                            if (imageView5 != null) {
                                                i = R.id.rv_task_detail_upImage;
                                                RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.rv_task_detail_upImage);
                                                if (recyclerView != null) {
                                                    i = R.id.top_activity_task_detail;
                                                    View viewFindViewById = view.findViewById(R.id.top_activity_task_detail);
                                                    if (viewFindViewById != null) {
                                                        TitleLayoutBinding titleLayoutBindingBind = TitleLayoutBinding.bind(viewFindViewById);
                                                        i = R.id.tv_task_detail_desc;
                                                        TextView textView = (TextView) view.findViewById(R.id.tv_task_detail_desc);
                                                        if (textView != null) {
                                                            i = R.id.tv_task_detail_EndTime;
                                                            TextView textView2 = (TextView) view.findViewById(R.id.tv_task_detail_EndTime);
                                                            if (textView2 != null) {
                                                                i = R.id.tv_task_detail_EndTime_title;
                                                                TextView textView3 = (TextView) view.findViewById(R.id.tv_task_detail_EndTime_title);
                                                                if (textView3 != null) {
                                                                    i = R.id.tv_task_detail_range;
                                                                    TextView textView4 = (TextView) view.findViewById(R.id.tv_task_detail_range);
                                                                    if (textView4 != null) {
                                                                        i = R.id.tv_task_detail_range_title;
                                                                        TextView textView5 = (TextView) view.findViewById(R.id.tv_task_detail_range_title);
                                                                        if (textView5 != null) {
                                                                            i = R.id.tv_task_detail_rate;
                                                                            TextView textView6 = (TextView) view.findViewById(R.id.tv_task_detail_rate);
                                                                            if (textView6 != null) {
                                                                                i = R.id.tv_task_detail_rate_title;
                                                                                TextView textView7 = (TextView) view.findViewById(R.id.tv_task_detail_rate_title);
                                                                                if (textView7 != null) {
                                                                                    i = R.id.tv_task_detail_require;
                                                                                    TextView textView8 = (TextView) view.findViewById(R.id.tv_task_detail_require);
                                                                                    if (textView8 != null) {
                                                                                        i = R.id.tv_task_detail_require_title;
                                                                                        TextView textView9 = (TextView) view.findViewById(R.id.tv_task_detail_require_title);
                                                                                        if (textView9 != null) {
                                                                                            i = R.id.tv_task_detail_sign_count;
                                                                                            TextView textView10 = (TextView) view.findViewById(R.id.tv_task_detail_sign_count);
                                                                                            if (textView10 != null) {
                                                                                                i = R.id.tv_task_detail_sign_count_title;
                                                                                                TextView textView11 = (TextView) view.findViewById(R.id.tv_task_detail_sign_count_title);
                                                                                                if (textView11 != null) {
                                                                                                    i = R.id.tv_task_detail_single_title;
                                                                                                    TextView textView12 = (TextView) view.findViewById(R.id.tv_task_detail_single_title);
                                                                                                    if (textView12 != null) {
                                                                                                        i = R.id.tv_task_detail_startTime;
                                                                                                        TextView textView13 = (TextView) view.findViewById(R.id.tv_task_detail_startTime);
                                                                                                        if (textView13 != null) {
                                                                                                            i = R.id.tv_task_detail_startTime_title;
                                                                                                            TextView textView14 = (TextView) view.findViewById(R.id.tv_task_detail_startTime_title);
                                                                                                            if (textView14 != null) {
                                                                                                                i = R.id.tv_task_detail_title;
                                                                                                                TagTextView tagTextView = (TagTextView) view.findViewById(R.id.tv_task_detail_title);
                                                                                                                if (tagTextView != null) {
                                                                                                                    i = R.id.tv_task_detail_upImage_title;
                                                                                                                    TextView textView15 = (TextView) view.findViewById(R.id.tv_task_detail_upImage_title);
                                                                                                                    if (textView15 != null) {
                                                                                                                        return new ActivityTaskDetailBinding((ConstraintLayout) view, button, constraintLayout, constraintLayout2, constraintLayout3, constraintLayout4, imageView, imageView2, imageView3, imageView4, imageView5, recyclerView, titleLayoutBindingBind, textView, textView2, textView3, textView4, textView5, textView6, textView7, textView8, textView9, textView10, textView11, textView12, textView13, textView14, tagTextView, textView15);
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
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
