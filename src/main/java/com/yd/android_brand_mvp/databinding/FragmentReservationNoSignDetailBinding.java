package com.yd.android_brand_mvp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import com.yd.android_brand_mvp.R;

/* JADX INFO: loaded from: classes4.dex */
public final class FragmentReservationNoSignDetailBinding implements ViewBinding {
    private final ConstraintLayout rootView;
    public final RecyclerView rvFragmentReservationNoSignDetailSign;
    public final TextView tvFragmentReservationNoSignDetailCount;

    private FragmentReservationNoSignDetailBinding(ConstraintLayout constraintLayout, RecyclerView recyclerView, TextView textView) {
        this.rootView = constraintLayout;
        this.rvFragmentReservationNoSignDetailSign = recyclerView;
        this.tvFragmentReservationNoSignDetailCount = textView;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static FragmentReservationNoSignDetailBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static FragmentReservationNoSignDetailBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.fragment_reservation_no_sign_detail, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static FragmentReservationNoSignDetailBinding bind(View view) {
        int i = R.id.rv_fragment_reservation__noSign_detail_sign;
        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.rv_fragment_reservation__noSign_detail_sign);
        if (recyclerView != null) {
            i = R.id.tv_fragment_reservation_noSign_detail_count;
            TextView textView = (TextView) view.findViewById(R.id.tv_fragment_reservation_noSign_detail_count);
            if (textView != null) {
                return new FragmentReservationNoSignDetailBinding((ConstraintLayout) view, recyclerView, textView);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
