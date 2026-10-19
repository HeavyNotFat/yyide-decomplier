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
public final class FragmentDormitoryFragment2x6Binding implements ViewBinding {
    public final RecyclerView recyclerView;
    private final ConstraintLayout rootView;
    public final TextView tvLeader;
    public final TextView tvName;
    public final TextView tvNumberName;
    public final TextView tvPeopleList;
    public final TextView tvPeopleNumber;
    public final TextView tvRoundNumberName;
    public final TextView tvStatus;
    public final View view3;

    private FragmentDormitoryFragment2x6Binding(ConstraintLayout constraintLayout, RecyclerView recyclerView, TextView textView, TextView textView2, TextView textView3, TextView textView4, TextView textView5, TextView textView6, TextView textView7, View view) {
        this.rootView = constraintLayout;
        this.recyclerView = recyclerView;
        this.tvLeader = textView;
        this.tvName = textView2;
        this.tvNumberName = textView3;
        this.tvPeopleList = textView4;
        this.tvPeopleNumber = textView5;
        this.tvRoundNumberName = textView6;
        this.tvStatus = textView7;
        this.view3 = view;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static FragmentDormitoryFragment2x6Binding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static FragmentDormitoryFragment2x6Binding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.fragment_dormitory_fragment2x6, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static FragmentDormitoryFragment2x6Binding bind(View view) {
        int i = R.id.recyclerView;
        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.recyclerView);
        if (recyclerView != null) {
            i = R.id.tvLeader;
            TextView textView = (TextView) view.findViewById(R.id.tvLeader);
            if (textView != null) {
                i = R.id.tvName;
                TextView textView2 = (TextView) view.findViewById(R.id.tvName);
                if (textView2 != null) {
                    i = R.id.tvNumberName;
                    TextView textView3 = (TextView) view.findViewById(R.id.tvNumberName);
                    if (textView3 != null) {
                        i = R.id.tvPeopleList;
                        TextView textView4 = (TextView) view.findViewById(R.id.tvPeopleList);
                        if (textView4 != null) {
                            i = R.id.tvPeopleNumber;
                            TextView textView5 = (TextView) view.findViewById(R.id.tvPeopleNumber);
                            if (textView5 != null) {
                                i = R.id.tvRoundNumberName;
                                TextView textView6 = (TextView) view.findViewById(R.id.tvRoundNumberName);
                                if (textView6 != null) {
                                    i = R.id.tvStatus;
                                    TextView textView7 = (TextView) view.findViewById(R.id.tvStatus);
                                    if (textView7 != null) {
                                        i = R.id.view3;
                                        View viewFindViewById = view.findViewById(R.id.view3);
                                        if (viewFindViewById != null) {
                                            return new FragmentDormitoryFragment2x6Binding((ConstraintLayout) view, recyclerView, textView, textView2, textView3, textView4, textView5, textView6, textView7, viewFindViewById);
                                        }
                                    }
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
