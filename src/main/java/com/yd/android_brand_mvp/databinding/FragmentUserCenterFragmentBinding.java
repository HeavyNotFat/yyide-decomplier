package com.yd.android_brand_mvp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.FragmentContainerView;
import androidx.viewbinding.ViewBinding;
import com.makeramen.roundedimageview.RoundedImageView;
import com.yd.android_brand_mvp.R;
import com.youth.banner.Banner;

/* JADX INFO: loaded from: classes4.dex */
public final class FragmentUserCenterFragmentBinding implements ViewBinding {
    public final Banner banner;
    public final FragmentContainerView content;
    public final RoundedImageView img;
    public final TextView name;
    private final ConstraintLayout rootView;
    public final TextView teacherName;
    public final RelativeLayout top;
    public final TextView tvClassName;

    private FragmentUserCenterFragmentBinding(ConstraintLayout constraintLayout, Banner banner, FragmentContainerView fragmentContainerView, RoundedImageView roundedImageView, TextView textView, TextView textView2, RelativeLayout relativeLayout, TextView textView3) {
        this.rootView = constraintLayout;
        this.banner = banner;
        this.content = fragmentContainerView;
        this.img = roundedImageView;
        this.name = textView;
        this.teacherName = textView2;
        this.top = relativeLayout;
        this.tvClassName = textView3;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static FragmentUserCenterFragmentBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static FragmentUserCenterFragmentBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.fragment_user_center_fragment, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static FragmentUserCenterFragmentBinding bind(View view) {
        int i = R.id.banner;
        Banner banner = (Banner) view.findViewById(R.id.banner);
        if (banner != null) {
            i = R.id.content;
            FragmentContainerView fragmentContainerView = (FragmentContainerView) view.findViewById(R.id.content);
            if (fragmentContainerView != null) {
                i = R.id.img;
                RoundedImageView roundedImageView = (RoundedImageView) view.findViewById(R.id.img);
                if (roundedImageView != null) {
                    i = R.id.name;
                    TextView textView = (TextView) view.findViewById(R.id.name);
                    if (textView != null) {
                        i = R.id.teacherName;
                        TextView textView2 = (TextView) view.findViewById(R.id.teacherName);
                        if (textView2 != null) {
                            i = R.id.top;
                            RelativeLayout relativeLayout = (RelativeLayout) view.findViewById(R.id.top);
                            if (relativeLayout != null) {
                                i = R.id.tv_class_name;
                                TextView textView3 = (TextView) view.findViewById(R.id.tv_class_name);
                                if (textView3 != null) {
                                    return new FragmentUserCenterFragmentBinding((ConstraintLayout) view, banner, fragmentContainerView, roundedImageView, textView, textView2, relativeLayout, textView3);
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
