package com.yd.android_brand_mvp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.yd.android_brand_mvp.R;

/* JADX INFO: loaded from: classes4.dex */
public final class FragmentPunchBinding implements ViewBinding {
    public final Button btnSign;
    public final ConstraintLayout clSite;
    public final ImageView gankImageview3;
    private final ConstraintLayout rootView;
    public final LayoutHeadTitleBinding top;
    public final TextView tvSiteName;

    private FragmentPunchBinding(ConstraintLayout constraintLayout, Button button, ConstraintLayout constraintLayout2, ImageView imageView, LayoutHeadTitleBinding layoutHeadTitleBinding, TextView textView) {
        this.rootView = constraintLayout;
        this.btnSign = button;
        this.clSite = constraintLayout2;
        this.gankImageview3 = imageView;
        this.top = layoutHeadTitleBinding;
        this.tvSiteName = textView;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static FragmentPunchBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static FragmentPunchBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.fragment_punch, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static FragmentPunchBinding bind(View view) {
        int i = R.id.btnSign;
        Button button = (Button) view.findViewById(R.id.btnSign);
        if (button != null) {
            i = R.id.cl_site;
            ConstraintLayout constraintLayout = (ConstraintLayout) view.findViewById(R.id.cl_site);
            if (constraintLayout != null) {
                i = R.id.gank_imageview3;
                ImageView imageView = (ImageView) view.findViewById(R.id.gank_imageview3);
                if (imageView != null) {
                    i = R.id.top;
                    View viewFindViewById = view.findViewById(R.id.top);
                    if (viewFindViewById != null) {
                        LayoutHeadTitleBinding layoutHeadTitleBindingBind = LayoutHeadTitleBinding.bind(viewFindViewById);
                        i = R.id.tv_site_name;
                        TextView textView = (TextView) view.findViewById(R.id.tv_site_name);
                        if (textView != null) {
                            return new FragmentPunchBinding((ConstraintLayout) view, button, constraintLayout, imageView, layoutHeadTitleBindingBind, textView);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
