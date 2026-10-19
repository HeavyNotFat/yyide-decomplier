package com.yd.android_brand_mvp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import com.yd.android_brand_mvp.R;

/* JADX INFO: loaded from: classes4.dex */
public final class FragmentDutyFragment2x3Binding implements ViewBinding {
    public final ConstraintLayout clAllDay;
    public final ConstraintLayout clContent;
    public final LinearLayoutCompat clTime;
    public final ImageView imageView7;
    public final ConstraintLayout linearLayoutCompat;
    public final RecyclerView recyclerView;
    private final ConstraintLayout rootView;
    public final TextView textView17;
    public final TextView tvWeek;

    private FragmentDutyFragment2x3Binding(ConstraintLayout constraintLayout, ConstraintLayout constraintLayout2, ConstraintLayout constraintLayout3, LinearLayoutCompat linearLayoutCompat, ImageView imageView, ConstraintLayout constraintLayout4, RecyclerView recyclerView, TextView textView, TextView textView2) {
        this.rootView = constraintLayout;
        this.clAllDay = constraintLayout2;
        this.clContent = constraintLayout3;
        this.clTime = linearLayoutCompat;
        this.imageView7 = imageView;
        this.linearLayoutCompat = constraintLayout4;
        this.recyclerView = recyclerView;
        this.textView17 = textView;
        this.tvWeek = textView2;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static FragmentDutyFragment2x3Binding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static FragmentDutyFragment2x3Binding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.fragment_duty_fragment2x3, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static FragmentDutyFragment2x3Binding bind(View view) {
        int i = R.id.clAllDay;
        ConstraintLayout constraintLayout = (ConstraintLayout) view.findViewById(R.id.clAllDay);
        if (constraintLayout != null) {
            ConstraintLayout constraintLayout2 = (ConstraintLayout) view;
            i = R.id.clTime;
            LinearLayoutCompat linearLayoutCompat = (LinearLayoutCompat) view.findViewById(R.id.clTime);
            if (linearLayoutCompat != null) {
                i = R.id.imageView7;
                ImageView imageView = (ImageView) view.findViewById(R.id.imageView7);
                if (imageView != null) {
                    i = R.id.linearLayoutCompat;
                    ConstraintLayout constraintLayout3 = (ConstraintLayout) view.findViewById(R.id.linearLayoutCompat);
                    if (constraintLayout3 != null) {
                        i = R.id.recyclerView;
                        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.recyclerView);
                        if (recyclerView != null) {
                            i = R.id.textView17;
                            TextView textView = (TextView) view.findViewById(R.id.textView17);
                            if (textView != null) {
                                i = R.id.tvWeek;
                                TextView textView2 = (TextView) view.findViewById(R.id.tvWeek);
                                if (textView2 != null) {
                                    return new FragmentDutyFragment2x3Binding(constraintLayout2, constraintLayout, constraintLayout2, linearLayoutCompat, imageView, constraintLayout3, recyclerView, textView, textView2);
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
