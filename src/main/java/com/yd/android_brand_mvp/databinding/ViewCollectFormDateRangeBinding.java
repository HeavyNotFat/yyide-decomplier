package com.yd.android_brand_mvp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.yd.android_brand_mvp.R;

/* JADX INFO: loaded from: classes4.dex */
public final class ViewCollectFormDateRangeBinding implements ViewBinding {
    public final ConstraintLayout clViewCollectFormDate;
    public final ConstraintLayout clViewCollectFormDate2;
    public final ImageView ivViewCollectFormDate;
    public final ImageView ivViewCollectFormDate2;
    public final ImageView ivViewCollectFormDateDel;
    public final ImageView ivViewCollectFormDateDel2;
    private final ConstraintLayout rootView;
    public final TextView tvViewCollectFormDate;
    public final TextView tvViewCollectFormDate2;
    public final TextView tvViewCollectFormDateLengthContent;
    public final TextView tvViewCollectFormDateName;
    public final TextView tvViewCollectFormDateName2;
    public final TextView tvViewCollectFormDateName3;
    public final TextView tvViewCollectFormDateRequired;
    public final TextView tvViewCollectFormDateRequired2;
    public final TextView tvViewCollectFormDateRequired3;

    private ViewCollectFormDateRangeBinding(ConstraintLayout constraintLayout, ConstraintLayout constraintLayout2, ConstraintLayout constraintLayout3, ImageView imageView, ImageView imageView2, ImageView imageView3, ImageView imageView4, TextView textView, TextView textView2, TextView textView3, TextView textView4, TextView textView5, TextView textView6, TextView textView7, TextView textView8, TextView textView9) {
        this.rootView = constraintLayout;
        this.clViewCollectFormDate = constraintLayout2;
        this.clViewCollectFormDate2 = constraintLayout3;
        this.ivViewCollectFormDate = imageView;
        this.ivViewCollectFormDate2 = imageView2;
        this.ivViewCollectFormDateDel = imageView3;
        this.ivViewCollectFormDateDel2 = imageView4;
        this.tvViewCollectFormDate = textView;
        this.tvViewCollectFormDate2 = textView2;
        this.tvViewCollectFormDateLengthContent = textView3;
        this.tvViewCollectFormDateName = textView4;
        this.tvViewCollectFormDateName2 = textView5;
        this.tvViewCollectFormDateName3 = textView6;
        this.tvViewCollectFormDateRequired = textView7;
        this.tvViewCollectFormDateRequired2 = textView8;
        this.tvViewCollectFormDateRequired3 = textView9;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static ViewCollectFormDateRangeBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static ViewCollectFormDateRangeBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.view_collect_form_date_range, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static ViewCollectFormDateRangeBinding bind(View view) {
        int i = R.id.cl_view_collect_form_date;
        ConstraintLayout constraintLayout = (ConstraintLayout) view.findViewById(R.id.cl_view_collect_form_date);
        if (constraintLayout != null) {
            i = R.id.cl_view_collect_form_date2;
            ConstraintLayout constraintLayout2 = (ConstraintLayout) view.findViewById(R.id.cl_view_collect_form_date2);
            if (constraintLayout2 != null) {
                i = R.id.iv_view_collect_form_date;
                ImageView imageView = (ImageView) view.findViewById(R.id.iv_view_collect_form_date);
                if (imageView != null) {
                    i = R.id.iv_view_collect_form_date2;
                    ImageView imageView2 = (ImageView) view.findViewById(R.id.iv_view_collect_form_date2);
                    if (imageView2 != null) {
                        i = R.id.iv_view_collect_form_date_del;
                        ImageView imageView3 = (ImageView) view.findViewById(R.id.iv_view_collect_form_date_del);
                        if (imageView3 != null) {
                            i = R.id.iv_view_collect_form_date_del2;
                            ImageView imageView4 = (ImageView) view.findViewById(R.id.iv_view_collect_form_date_del2);
                            if (imageView4 != null) {
                                i = R.id.tv_view_collect_form_date;
                                TextView textView = (TextView) view.findViewById(R.id.tv_view_collect_form_date);
                                if (textView != null) {
                                    i = R.id.tv_view_collect_form_date2;
                                    TextView textView2 = (TextView) view.findViewById(R.id.tv_view_collect_form_date2);
                                    if (textView2 != null) {
                                        i = R.id.tv_view_collect_form_date_length_content;
                                        TextView textView3 = (TextView) view.findViewById(R.id.tv_view_collect_form_date_length_content);
                                        if (textView3 != null) {
                                            i = R.id.tv_view_collect_form_date_name;
                                            TextView textView4 = (TextView) view.findViewById(R.id.tv_view_collect_form_date_name);
                                            if (textView4 != null) {
                                                i = R.id.tv_view_collect_form_date_name2;
                                                TextView textView5 = (TextView) view.findViewById(R.id.tv_view_collect_form_date_name2);
                                                if (textView5 != null) {
                                                    i = R.id.tv_view_collect_form_date_name3;
                                                    TextView textView6 = (TextView) view.findViewById(R.id.tv_view_collect_form_date_name3);
                                                    if (textView6 != null) {
                                                        i = R.id.tv_view_collect_form_date_required;
                                                        TextView textView7 = (TextView) view.findViewById(R.id.tv_view_collect_form_date_required);
                                                        if (textView7 != null) {
                                                            i = R.id.tv_view_collect_form_date_required2;
                                                            TextView textView8 = (TextView) view.findViewById(R.id.tv_view_collect_form_date_required2);
                                                            if (textView8 != null) {
                                                                i = R.id.tv_view_collect_form_date_required3;
                                                                TextView textView9 = (TextView) view.findViewById(R.id.tv_view_collect_form_date_required3);
                                                                if (textView9 != null) {
                                                                    return new ViewCollectFormDateRangeBinding((ConstraintLayout) view, constraintLayout, constraintLayout2, imageView, imageView2, imageView3, imageView4, textView, textView2, textView3, textView4, textView5, textView6, textView7, textView8, textView9);
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
