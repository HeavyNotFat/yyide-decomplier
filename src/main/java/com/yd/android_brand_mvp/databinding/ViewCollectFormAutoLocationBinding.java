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
public final class ViewCollectFormAutoLocationBinding implements ViewBinding {
    public final ConstraintLayout clViewCollectFormLocation;
    public final ImageView ivViewCollectFormLocation;
    public final ImageView ivViewCollectFormLocationDel;
    private final ConstraintLayout rootView;
    public final TextView tvViewCollectFormLocationAddress;
    public final TextView tvViewCollectFormLocationName;
    public final TextView tvViewCollectFormLocationRequired;

    private ViewCollectFormAutoLocationBinding(ConstraintLayout constraintLayout, ConstraintLayout constraintLayout2, ImageView imageView, ImageView imageView2, TextView textView, TextView textView2, TextView textView3) {
        this.rootView = constraintLayout;
        this.clViewCollectFormLocation = constraintLayout2;
        this.ivViewCollectFormLocation = imageView;
        this.ivViewCollectFormLocationDel = imageView2;
        this.tvViewCollectFormLocationAddress = textView;
        this.tvViewCollectFormLocationName = textView2;
        this.tvViewCollectFormLocationRequired = textView3;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static ViewCollectFormAutoLocationBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static ViewCollectFormAutoLocationBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.view_collect_form_auto_location, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static ViewCollectFormAutoLocationBinding bind(View view) {
        int i = R.id.cl_view_collect_form_location;
        ConstraintLayout constraintLayout = (ConstraintLayout) view.findViewById(R.id.cl_view_collect_form_location);
        if (constraintLayout != null) {
            i = R.id.iv_view_collect_form_location;
            ImageView imageView = (ImageView) view.findViewById(R.id.iv_view_collect_form_location);
            if (imageView != null) {
                i = R.id.iv_view_collect_form_location_del;
                ImageView imageView2 = (ImageView) view.findViewById(R.id.iv_view_collect_form_location_del);
                if (imageView2 != null) {
                    i = R.id.tv_view_collect_form_location_address;
                    TextView textView = (TextView) view.findViewById(R.id.tv_view_collect_form_location_address);
                    if (textView != null) {
                        i = R.id.tv_view_collect_form_location_name;
                        TextView textView2 = (TextView) view.findViewById(R.id.tv_view_collect_form_location_name);
                        if (textView2 != null) {
                            i = R.id.tv_view_collect_form_location_required;
                            TextView textView3 = (TextView) view.findViewById(R.id.tv_view_collect_form_location_required);
                            if (textView3 != null) {
                                return new ViewCollectFormAutoLocationBinding((ConstraintLayout) view, constraintLayout, imageView, imageView2, textView, textView2, textView3);
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
