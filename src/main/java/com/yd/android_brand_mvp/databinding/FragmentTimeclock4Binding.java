package com.yd.android_brand_mvp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextClock;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.yd.android_brand_mvp.R;

/* JADX INFO: loaded from: classes4.dex */
public final class FragmentTimeclock4Binding implements ViewBinding {
    public final ConstraintLayout constraintlayout;
    public final ConstraintLayout content;
    public final ImageView iv1;
    public final ImageView iv2;
    private final ConstraintLayout rootView;
    public final TextClock tcWeek;

    private FragmentTimeclock4Binding(ConstraintLayout constraintLayout, ConstraintLayout constraintLayout2, ConstraintLayout constraintLayout3, ImageView imageView, ImageView imageView2, TextClock textClock) {
        this.rootView = constraintLayout;
        this.constraintlayout = constraintLayout2;
        this.content = constraintLayout3;
        this.iv1 = imageView;
        this.iv2 = imageView2;
        this.tcWeek = textClock;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static FragmentTimeclock4Binding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static FragmentTimeclock4Binding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.fragment_timeclock4, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static FragmentTimeclock4Binding bind(View view) {
        int i = R.id.constraintlayout;
        ConstraintLayout constraintLayout = (ConstraintLayout) view.findViewById(R.id.constraintlayout);
        if (constraintLayout != null) {
            i = R.id.content;
            ConstraintLayout constraintLayout2 = (ConstraintLayout) view.findViewById(R.id.content);
            if (constraintLayout2 != null) {
                i = R.id.iv1;
                ImageView imageView = (ImageView) view.findViewById(R.id.iv1);
                if (imageView != null) {
                    i = R.id.iv2;
                    ImageView imageView2 = (ImageView) view.findViewById(R.id.iv2);
                    if (imageView2 != null) {
                        i = R.id.tc_week;
                        TextClock textClock = (TextClock) view.findViewById(R.id.tc_week);
                        if (textClock != null) {
                            return new FragmentTimeclock4Binding((ConstraintLayout) view, constraintLayout, constraintLayout2, imageView, imageView2, textClock);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
