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
public final class ViewCollectFormDateBinding implements ViewBinding {
    public final ConstraintLayout clViewCollectFormDate;
    public final ImageView ivViewCollectFormDate;
    public final ImageView ivViewCollectFormDateDel;
    private final ConstraintLayout rootView;
    public final TextView tvViewCollectFormDate;
    public final TextView tvViewCollectFormDateName;
    public final TextView tvViewCollectFormDateRequired;

    private ViewCollectFormDateBinding(ConstraintLayout constraintLayout, ConstraintLayout constraintLayout2, ImageView imageView, ImageView imageView2, TextView textView, TextView textView2, TextView textView3) {
        this.rootView = constraintLayout;
        this.clViewCollectFormDate = constraintLayout2;
        this.ivViewCollectFormDate = imageView;
        this.ivViewCollectFormDateDel = imageView2;
        this.tvViewCollectFormDate = textView;
        this.tvViewCollectFormDateName = textView2;
        this.tvViewCollectFormDateRequired = textView3;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static ViewCollectFormDateBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static ViewCollectFormDateBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.view_collect_form_date, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static ViewCollectFormDateBinding bind(View view) {
        int i = R.id.cl_view_collect_form_date;
        ConstraintLayout constraintLayout = (ConstraintLayout) view.findViewById(R.id.cl_view_collect_form_date);
        if (constraintLayout != null) {
            i = R.id.iv_view_collect_form_date;
            ImageView imageView = (ImageView) view.findViewById(R.id.iv_view_collect_form_date);
            if (imageView != null) {
                i = R.id.iv_view_collect_form_date_del;
                ImageView imageView2 = (ImageView) view.findViewById(R.id.iv_view_collect_form_date_del);
                if (imageView2 != null) {
                    i = R.id.tv_view_collect_form_date;
                    TextView textView = (TextView) view.findViewById(R.id.tv_view_collect_form_date);
                    if (textView != null) {
                        i = R.id.tv_view_collect_form_date_name;
                        TextView textView2 = (TextView) view.findViewById(R.id.tv_view_collect_form_date_name);
                        if (textView2 != null) {
                            i = R.id.tv_view_collect_form_date_required;
                            TextView textView3 = (TextView) view.findViewById(R.id.tv_view_collect_form_date_required);
                            if (textView3 != null) {
                                return new ViewCollectFormDateBinding((ConstraintLayout) view, constraintLayout, imageView, imageView2, textView, textView2, textView3);
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
