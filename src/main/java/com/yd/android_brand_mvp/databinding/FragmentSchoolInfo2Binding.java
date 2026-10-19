package com.yd.android_brand_mvp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckedTextView;
import android.widget.GridView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import com.yd.android_brand_mvp.R;

/* JADX INFO: loaded from: classes4.dex */
public final class FragmentSchoolInfo2Binding implements ViewBinding {
    public final CheckedTextView down;
    public final GridView grid;
    public final TextView index;
    public final LinearLayout rgCheck;
    private final LinearLayout rootView;
    public final CheckedTextView up;

    private FragmentSchoolInfo2Binding(LinearLayout linearLayout, CheckedTextView checkedTextView, GridView gridView, TextView textView, LinearLayout linearLayout2, CheckedTextView checkedTextView2) {
        this.rootView = linearLayout;
        this.down = checkedTextView;
        this.grid = gridView;
        this.index = textView;
        this.rgCheck = linearLayout2;
        this.up = checkedTextView2;
    }

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static FragmentSchoolInfo2Binding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static FragmentSchoolInfo2Binding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.fragment_school_info2, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static FragmentSchoolInfo2Binding bind(View view) {
        int i = R.id.down;
        CheckedTextView checkedTextView = (CheckedTextView) view.findViewById(R.id.down);
        if (checkedTextView != null) {
            i = R.id.grid;
            GridView gridView = (GridView) view.findViewById(R.id.grid);
            if (gridView != null) {
                i = R.id.index;
                TextView textView = (TextView) view.findViewById(R.id.index);
                if (textView != null) {
                    i = R.id.rg_check;
                    LinearLayout linearLayout = (LinearLayout) view.findViewById(R.id.rg_check);
                    if (linearLayout != null) {
                        i = R.id.up;
                        CheckedTextView checkedTextView2 = (CheckedTextView) view.findViewById(R.id.up);
                        if (checkedTextView2 != null) {
                            return new FragmentSchoolInfo2Binding((LinearLayout) view, checkedTextView, gridView, textView, linearLayout, checkedTextView2);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
