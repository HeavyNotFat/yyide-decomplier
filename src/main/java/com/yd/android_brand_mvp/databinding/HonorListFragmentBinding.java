package com.yd.android_brand_mvp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import com.yd.android_brand_mvp.R;

/* JADX INFO: loaded from: classes4.dex */
public final class HonorListFragmentBinding implements ViewBinding {
    public final ConstraintLayout constraintlayout;
    public final RecyclerView recyclerView;
    private final ConstraintLayout rootView;
    public final TextView tvHonorClass;
    public final TextView tvHonorStudent;
    public final TextView tvNext;
    public final TextView tvPageNumber;
    public final TextView tvUpPage;

    private HonorListFragmentBinding(ConstraintLayout constraintLayout, ConstraintLayout constraintLayout2, RecyclerView recyclerView, TextView textView, TextView textView2, TextView textView3, TextView textView4, TextView textView5) {
        this.rootView = constraintLayout;
        this.constraintlayout = constraintLayout2;
        this.recyclerView = recyclerView;
        this.tvHonorClass = textView;
        this.tvHonorStudent = textView2;
        this.tvNext = textView3;
        this.tvPageNumber = textView4;
        this.tvUpPage = textView5;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static HonorListFragmentBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static HonorListFragmentBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.honor_list_fragment, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static HonorListFragmentBinding bind(View view) {
        int i = R.id.constraintlayout;
        ConstraintLayout constraintLayout = (ConstraintLayout) view.findViewById(R.id.constraintlayout);
        if (constraintLayout != null) {
            i = R.id.recyclerView;
            RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.recyclerView);
            if (recyclerView != null) {
                i = R.id.tvHonorClass;
                TextView textView = (TextView) view.findViewById(R.id.tvHonorClass);
                if (textView != null) {
                    i = R.id.tvHonorStudent;
                    TextView textView2 = (TextView) view.findViewById(R.id.tvHonorStudent);
                    if (textView2 != null) {
                        i = R.id.tvNext;
                        TextView textView3 = (TextView) view.findViewById(R.id.tvNext);
                        if (textView3 != null) {
                            i = R.id.tvPageNumber;
                            TextView textView4 = (TextView) view.findViewById(R.id.tvPageNumber);
                            if (textView4 != null) {
                                i = R.id.tvUpPage;
                                TextView textView5 = (TextView) view.findViewById(R.id.tvUpPage);
                                if (textView5 != null) {
                                    return new HonorListFragmentBinding((ConstraintLayout) view, constraintLayout, recyclerView, textView, textView2, textView3, textView4, textView5);
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
