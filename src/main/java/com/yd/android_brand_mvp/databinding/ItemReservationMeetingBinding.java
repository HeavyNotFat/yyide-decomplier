package com.yd.android_brand_mvp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.yd.android_brand_mvp.R;

/* JADX INFO: loaded from: classes4.dex */
public final class ItemReservationMeetingBinding implements ViewBinding {
    public final ConstraintLayout clItemReservationMeeting;
    private final ConstraintLayout rootView;
    public final TextView tvItemReservationMeetingTheme;
    public final TextView tvItemReservationMeetingTime;

    private ItemReservationMeetingBinding(ConstraintLayout constraintLayout, ConstraintLayout constraintLayout2, TextView textView, TextView textView2) {
        this.rootView = constraintLayout;
        this.clItemReservationMeeting = constraintLayout2;
        this.tvItemReservationMeetingTheme = textView;
        this.tvItemReservationMeetingTime = textView2;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static ItemReservationMeetingBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static ItemReservationMeetingBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.item_reservation_meeting, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static ItemReservationMeetingBinding bind(View view) {
        ConstraintLayout constraintLayout = (ConstraintLayout) view;
        int i = R.id.tv_item_reservation_meeting_theme;
        TextView textView = (TextView) view.findViewById(R.id.tv_item_reservation_meeting_theme);
        if (textView != null) {
            i = R.id.tv_item_reservation_meeting_time;
            TextView textView2 = (TextView) view.findViewById(R.id.tv_item_reservation_meeting_time);
            if (textView2 != null) {
                return new ItemReservationMeetingBinding(constraintLayout, constraintLayout, textView, textView2);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
