package com.yd.android_brand_mvp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.viewbinding.ViewBinding;
import com.necer.calendar.MonthCalendar;
import com.yd.android_brand_mvp.R;

/* JADX INFO: loaded from: classes4.dex */
public final class NcListLayoutBinding implements ViewBinding {
    public final MonthCalendar calendar;
    public final LinearLayout llTitle;
    private final LinearLayout rootView;

    private NcListLayoutBinding(LinearLayout linearLayout, MonthCalendar monthCalendar, LinearLayout linearLayout2) {
        this.rootView = linearLayout;
        this.calendar = monthCalendar;
        this.llTitle = linearLayout2;
    }

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static NcListLayoutBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static NcListLayoutBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.nc_list_layout, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static NcListLayoutBinding bind(View view) {
        MonthCalendar monthCalendar = (MonthCalendar) view.findViewById(R.id.calendar);
        if (monthCalendar != null) {
            LinearLayout linearLayout = (LinearLayout) view;
            return new NcListLayoutBinding(linearLayout, monthCalendar, linearLayout);
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(R.id.calendar)));
    }
}
