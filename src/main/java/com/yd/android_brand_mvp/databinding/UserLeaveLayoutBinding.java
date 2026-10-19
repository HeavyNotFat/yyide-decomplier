package com.yd.android_brand_mvp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckedTextView;
import android.widget.LinearLayout;
import androidx.viewbinding.ViewBinding;
import com.yd.android_brand_mvp.R;
import com.yd.android_brand_mvp.widget.YDEditText;

/* JADX INFO: loaded from: classes4.dex */
public final class UserLeaveLayoutBinding implements ViewBinding {
    public final YDEditText edit;
    private final LinearLayout rootView;
    public final CheckedTextView tab1;
    public final CheckedTextView tab2;
    public final CheckedTextView tab3;

    private UserLeaveLayoutBinding(LinearLayout linearLayout, YDEditText yDEditText, CheckedTextView checkedTextView, CheckedTextView checkedTextView2, CheckedTextView checkedTextView3) {
        this.rootView = linearLayout;
        this.edit = yDEditText;
        this.tab1 = checkedTextView;
        this.tab2 = checkedTextView2;
        this.tab3 = checkedTextView3;
    }

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static UserLeaveLayoutBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static UserLeaveLayoutBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.user_leave_layout, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static UserLeaveLayoutBinding bind(View view) {
        int i = R.id.edit;
        YDEditText yDEditText = (YDEditText) view.findViewById(R.id.edit);
        if (yDEditText != null) {
            i = R.id.tab1;
            CheckedTextView checkedTextView = (CheckedTextView) view.findViewById(R.id.tab1);
            if (checkedTextView != null) {
                i = R.id.tab2;
                CheckedTextView checkedTextView2 = (CheckedTextView) view.findViewById(R.id.tab2);
                if (checkedTextView2 != null) {
                    i = R.id.tab3;
                    CheckedTextView checkedTextView3 = (CheckedTextView) view.findViewById(R.id.tab3);
                    if (checkedTextView3 != null) {
                        return new UserLeaveLayoutBinding((LinearLayout) view, yDEditText, checkedTextView, checkedTextView2, checkedTextView3);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
