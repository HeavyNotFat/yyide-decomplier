package com.yd.android_brand_mvp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import com.necer.calendar.WeekCalendar;
import com.yd.android_brand_mvp.R;

/* JADX INFO: loaded from: classes4.dex */
public final class FragmentHomeReservation36Binding implements ViewBinding {
    public final WeekCalendar calendar;
    public final RecyclerView recyclerView;
    private final ConstraintLayout rootView;

    private FragmentHomeReservation36Binding(ConstraintLayout constraintLayout, WeekCalendar weekCalendar, RecyclerView recyclerView) {
        this.rootView = constraintLayout;
        this.calendar = weekCalendar;
        this.recyclerView = recyclerView;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static FragmentHomeReservation36Binding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static FragmentHomeReservation36Binding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.fragment_home_reservation36, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static FragmentHomeReservation36Binding bind(View view) {
        int i = R.id.calendar;
        WeekCalendar weekCalendar = (WeekCalendar) view.findViewById(R.id.calendar);
        if (weekCalendar != null) {
            i = R.id.recyclerView;
            RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.recyclerView);
            if (recyclerView != null) {
                return new FragmentHomeReservation36Binding((ConstraintLayout) view, weekCalendar, recyclerView);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
