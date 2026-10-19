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
import com.yd.android_brand_mvp.weight.MultiStateView;

/* JADX INFO: loaded from: classes4.dex */
public final class FragmentSchoolInfo2PBinding implements ViewBinding {
    public final CheckedTextView down;
    public final GridView grid;
    public final TextView index;
    public final MultiStateView mu;
    public final TextView rbTab1;
    public final LinearLayout rgCheck;
    private final LinearLayout rootView;
    public final CheckedTextView up;

    private FragmentSchoolInfo2PBinding(LinearLayout linearLayout, CheckedTextView checkedTextView, GridView gridView, TextView textView, MultiStateView multiStateView, TextView textView2, LinearLayout linearLayout2, CheckedTextView checkedTextView2) {
        this.rootView = linearLayout;
        this.down = checkedTextView;
        this.grid = gridView;
        this.index = textView;
        this.mu = multiStateView;
        this.rbTab1 = textView2;
        this.rgCheck = linearLayout2;
        this.up = checkedTextView2;
    }

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static FragmentSchoolInfo2PBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static FragmentSchoolInfo2PBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.fragment_school_info2_p, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static FragmentSchoolInfo2PBinding bind(View view) {
        int i = R.id.down;
        CheckedTextView checkedTextView = (CheckedTextView) view.findViewById(R.id.down);
        if (checkedTextView != null) {
            i = R.id.grid;
            GridView gridView = (GridView) view.findViewById(R.id.grid);
            if (gridView != null) {
                i = R.id.index;
                TextView textView = (TextView) view.findViewById(R.id.index);
                if (textView != null) {
                    i = R.id.mu;
                    MultiStateView multiStateView = (MultiStateView) view.findViewById(R.id.mu);
                    if (multiStateView != null) {
                        i = R.id.rb_tab1;
                        TextView textView2 = (TextView) view.findViewById(R.id.rb_tab1);
                        if (textView2 != null) {
                            i = R.id.rg_check;
                            LinearLayout linearLayout = (LinearLayout) view.findViewById(R.id.rg_check);
                            if (linearLayout != null) {
                                i = R.id.up;
                                CheckedTextView checkedTextView2 = (CheckedTextView) view.findViewById(R.id.up);
                                if (checkedTextView2 != null) {
                                    return new FragmentSchoolInfo2PBinding((LinearLayout) view, checkedTextView, gridView, textView, multiStateView, textView2, linearLayout, checkedTextView2);
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
