package com.yd.android_brand_mvp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Guideline;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import com.yd.android_brand_mvp.R;

/* JADX INFO: loaded from: classes4.dex */
public final class SelectExamineDialogBinding implements ViewBinding {
    public final ConstraintLayout btoomly;
    public final RecyclerView dlRecycler;
    public final Guideline guiLine;
    private final ConstraintLayout rootView;
    public final TextView tvAmount;
    public final TextView tvCommit;
    public final TextView tvDismiss;
    public final TextView tvTitle;

    private SelectExamineDialogBinding(ConstraintLayout constraintLayout, ConstraintLayout constraintLayout2, RecyclerView recyclerView, Guideline guideline, TextView textView, TextView textView2, TextView textView3, TextView textView4) {
        this.rootView = constraintLayout;
        this.btoomly = constraintLayout2;
        this.dlRecycler = recyclerView;
        this.guiLine = guideline;
        this.tvAmount = textView;
        this.tvCommit = textView2;
        this.tvDismiss = textView3;
        this.tvTitle = textView4;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static SelectExamineDialogBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static SelectExamineDialogBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.select_examine_dialog, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static SelectExamineDialogBinding bind(View view) {
        int i = R.id.btoomly;
        ConstraintLayout constraintLayout = (ConstraintLayout) view.findViewById(R.id.btoomly);
        if (constraintLayout != null) {
            i = R.id.dl_recycler;
            RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.dl_recycler);
            if (recyclerView != null) {
                i = R.id.gui_line;
                Guideline guideline = (Guideline) view.findViewById(R.id.gui_line);
                if (guideline != null) {
                    i = R.id.tv_amount;
                    TextView textView = (TextView) view.findViewById(R.id.tv_amount);
                    if (textView != null) {
                        i = R.id.tv_commit;
                        TextView textView2 = (TextView) view.findViewById(R.id.tv_commit);
                        if (textView2 != null) {
                            i = R.id.tv_dismiss;
                            TextView textView3 = (TextView) view.findViewById(R.id.tv_dismiss);
                            if (textView3 != null) {
                                i = R.id.tv_title;
                                TextView textView4 = (TextView) view.findViewById(R.id.tv_title);
                                if (textView4 != null) {
                                    return new SelectExamineDialogBinding((ConstraintLayout) view, constraintLayout, recyclerView, guideline, textView, textView2, textView3, textView4);
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
