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
public final class ItemReservationSignBinding implements ViewBinding {
    public final ImageView ivItemReservationSignAvatar;
    private final ConstraintLayout rootView;
    public final TextView tvItemReservationSignName;
    public final TextView tvItemReservationSignTime;
    public final TextView tvItemReservationSignTip;

    private ItemReservationSignBinding(ConstraintLayout constraintLayout, ImageView imageView, TextView textView, TextView textView2, TextView textView3) {
        this.rootView = constraintLayout;
        this.ivItemReservationSignAvatar = imageView;
        this.tvItemReservationSignName = textView;
        this.tvItemReservationSignTime = textView2;
        this.tvItemReservationSignTip = textView3;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static ItemReservationSignBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static ItemReservationSignBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.item_reservation_sign, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static ItemReservationSignBinding bind(View view) {
        int i = R.id.iv_item_reservation_sign_avatar;
        ImageView imageView = (ImageView) view.findViewById(R.id.iv_item_reservation_sign_avatar);
        if (imageView != null) {
            i = R.id.tv_item_reservation_sign_name;
            TextView textView = (TextView) view.findViewById(R.id.tv_item_reservation_sign_name);
            if (textView != null) {
                i = R.id.tv_item_reservation_sign_time;
                TextView textView2 = (TextView) view.findViewById(R.id.tv_item_reservation_sign_time);
                if (textView2 != null) {
                    i = R.id.tv_item_reservation_sign_tip;
                    TextView textView3 = (TextView) view.findViewById(R.id.tv_item_reservation_sign_tip);
                    if (textView3 != null) {
                        return new ItemReservationSignBinding((ConstraintLayout) view, imageView, textView, textView2, textView3);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
