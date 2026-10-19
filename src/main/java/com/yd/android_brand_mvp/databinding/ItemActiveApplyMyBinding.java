package com.yd.android_brand_mvp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.viewbinding.ViewBinding;
import com.yd.android_brand_mvp.R;

/* JADX INFO: loaded from: classes4.dex */
public final class ItemActiveApplyMyBinding implements ViewBinding {
    private final LinearLayoutCompat rootView;
    public final TextView tvActiveName;
    public final TextView tvChildProject;
    public final TextView tvRegistrationStatus;
    public final TextView tvRegistrationTime;
    public final TextView tvSerialNumber;

    private ItemActiveApplyMyBinding(LinearLayoutCompat linearLayoutCompat, TextView textView, TextView textView2, TextView textView3, TextView textView4, TextView textView5) {
        this.rootView = linearLayoutCompat;
        this.tvActiveName = textView;
        this.tvChildProject = textView2;
        this.tvRegistrationStatus = textView3;
        this.tvRegistrationTime = textView4;
        this.tvSerialNumber = textView5;
    }

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayoutCompat getRoot() {
        return this.rootView;
    }

    public static ItemActiveApplyMyBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static ItemActiveApplyMyBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.item_active_apply_my, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static ItemActiveApplyMyBinding bind(View view) {
        int i = R.id.tv_active_name;
        TextView textView = (TextView) view.findViewById(R.id.tv_active_name);
        if (textView != null) {
            i = R.id.tv_child_project;
            TextView textView2 = (TextView) view.findViewById(R.id.tv_child_project);
            if (textView2 != null) {
                i = R.id.tv_registration_status;
                TextView textView3 = (TextView) view.findViewById(R.id.tv_registration_status);
                if (textView3 != null) {
                    i = R.id.tv_registration_time;
                    TextView textView4 = (TextView) view.findViewById(R.id.tv_registration_time);
                    if (textView4 != null) {
                        i = R.id.tv_serial_number;
                        TextView textView5 = (TextView) view.findViewById(R.id.tv_serial_number);
                        if (textView5 != null) {
                            return new ItemActiveApplyMyBinding((LinearLayoutCompat) view, textView, textView2, textView3, textView4, textView5);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
