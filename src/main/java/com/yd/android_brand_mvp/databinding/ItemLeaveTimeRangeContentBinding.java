package com.yd.android_brand_mvp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.yd.android_brand_mvp.R;

/* JADX INFO: loaded from: classes4.dex */
public final class ItemLeaveTimeRangeContentBinding implements ViewBinding {
    private final ConstraintLayout rootView;
    public final TextView tvItemLeaveTimeRangeEndTime;
    public final TextView tvItemLeaveTimeRangeEndTimeContent;
    public final TextView tvItemLeaveTimeRangeStartTime;
    public final TextView tvItemLeaveTimeRangeStartTimeContent;
    public final TextView tvItemLeaveTimeRangeTimeLength;
    public final TextView tvItemLeaveTimeRangeTimeLengthContent;

    private ItemLeaveTimeRangeContentBinding(ConstraintLayout constraintLayout, TextView textView, TextView textView2, TextView textView3, TextView textView4, TextView textView5, TextView textView6) {
        this.rootView = constraintLayout;
        this.tvItemLeaveTimeRangeEndTime = textView;
        this.tvItemLeaveTimeRangeEndTimeContent = textView2;
        this.tvItemLeaveTimeRangeStartTime = textView3;
        this.tvItemLeaveTimeRangeStartTimeContent = textView4;
        this.tvItemLeaveTimeRangeTimeLength = textView5;
        this.tvItemLeaveTimeRangeTimeLengthContent = textView6;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static ItemLeaveTimeRangeContentBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static ItemLeaveTimeRangeContentBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.item_leave_time_range_content, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static ItemLeaveTimeRangeContentBinding bind(View view) {
        int i = R.id.tv_item_leave_time_range_endTime;
        TextView textView = (TextView) view.findViewById(R.id.tv_item_leave_time_range_endTime);
        if (textView != null) {
            i = R.id.tv_item_leave_time_range_endTime_content;
            TextView textView2 = (TextView) view.findViewById(R.id.tv_item_leave_time_range_endTime_content);
            if (textView2 != null) {
                i = R.id.tv_item_leave_time_range_startTime;
                TextView textView3 = (TextView) view.findViewById(R.id.tv_item_leave_time_range_startTime);
                if (textView3 != null) {
                    i = R.id.tv_item_leave_time_range_startTime_content;
                    TextView textView4 = (TextView) view.findViewById(R.id.tv_item_leave_time_range_startTime_content);
                    if (textView4 != null) {
                        i = R.id.tv_item_leave_time_range_timeLength;
                        TextView textView5 = (TextView) view.findViewById(R.id.tv_item_leave_time_range_timeLength);
                        if (textView5 != null) {
                            i = R.id.tv_item_leave_time_range_timeLength_content;
                            TextView textView6 = (TextView) view.findViewById(R.id.tv_item_leave_time_range_timeLength_content);
                            if (textView6 != null) {
                                return new ItemLeaveTimeRangeContentBinding((ConstraintLayout) view, textView, textView2, textView3, textView4, textView5, textView6);
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
