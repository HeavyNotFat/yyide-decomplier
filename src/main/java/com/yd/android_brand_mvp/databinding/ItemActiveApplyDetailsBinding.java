package com.yd.android_brand_mvp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.yd.android_brand_mvp.R;

/* JADX INFO: loaded from: classes4.dex */
public final class ItemActiveApplyDetailsBinding implements ViewBinding {
    public final CheckBox checkbox;
    private final ConstraintLayout rootView;
    public final TextView tvActiveAlreadyNumber;
    public final TextView tvActiveAlreadyNumberTip;
    public final TextView tvActiveNumberRestrictTip;
    public final TextView tvActiveRestrictNumber;
    public final TextView tvActiveStatus;
    public final TextView tvActiveTitle;

    private ItemActiveApplyDetailsBinding(ConstraintLayout constraintLayout, CheckBox checkBox, TextView textView, TextView textView2, TextView textView3, TextView textView4, TextView textView5, TextView textView6) {
        this.rootView = constraintLayout;
        this.checkbox = checkBox;
        this.tvActiveAlreadyNumber = textView;
        this.tvActiveAlreadyNumberTip = textView2;
        this.tvActiveNumberRestrictTip = textView3;
        this.tvActiveRestrictNumber = textView4;
        this.tvActiveStatus = textView5;
        this.tvActiveTitle = textView6;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static ItemActiveApplyDetailsBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static ItemActiveApplyDetailsBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.item_active_apply_details, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static ItemActiveApplyDetailsBinding bind(View view) {
        int i = R.id.checkbox;
        CheckBox checkBox = (CheckBox) view.findViewById(R.id.checkbox);
        if (checkBox != null) {
            i = R.id.tv_active_already_number;
            TextView textView = (TextView) view.findViewById(R.id.tv_active_already_number);
            if (textView != null) {
                i = R.id.tv_active_already_number_tip;
                TextView textView2 = (TextView) view.findViewById(R.id.tv_active_already_number_tip);
                if (textView2 != null) {
                    i = R.id.tv_active_number_restrict_tip;
                    TextView textView3 = (TextView) view.findViewById(R.id.tv_active_number_restrict_tip);
                    if (textView3 != null) {
                        i = R.id.tv_active_restrict_number;
                        TextView textView4 = (TextView) view.findViewById(R.id.tv_active_restrict_number);
                        if (textView4 != null) {
                            i = R.id.tv_active_status;
                            TextView textView5 = (TextView) view.findViewById(R.id.tv_active_status);
                            if (textView5 != null) {
                                i = R.id.tv_active_title;
                                TextView textView6 = (TextView) view.findViewById(R.id.tv_active_title);
                                if (textView6 != null) {
                                    return new ItemActiveApplyDetailsBinding((ConstraintLayout) view, checkBox, textView, textView2, textView3, textView4, textView5, textView6);
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
