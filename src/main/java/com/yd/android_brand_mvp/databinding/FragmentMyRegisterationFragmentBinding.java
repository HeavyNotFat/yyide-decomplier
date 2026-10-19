package com.yd.android_brand_mvp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import com.yd.android_brand_mvp.R;

/* JADX INFO: loaded from: classes4.dex */
public final class FragmentMyRegisterationFragmentBinding implements ViewBinding {
    public final EditText etSearch;
    public final LinearLayoutCompat llQuery;
    public final LinearLayoutCompat llReset;
    public final LinearLayoutCompat llSort;
    public final RecyclerView recyclerView;
    private final LinearLayoutCompat rootView;

    private FragmentMyRegisterationFragmentBinding(LinearLayoutCompat linearLayoutCompat, EditText editText, LinearLayoutCompat linearLayoutCompat2, LinearLayoutCompat linearLayoutCompat3, LinearLayoutCompat linearLayoutCompat4, RecyclerView recyclerView) {
        this.rootView = linearLayoutCompat;
        this.etSearch = editText;
        this.llQuery = linearLayoutCompat2;
        this.llReset = linearLayoutCompat3;
        this.llSort = linearLayoutCompat4;
        this.recyclerView = recyclerView;
    }

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayoutCompat getRoot() {
        return this.rootView;
    }

    public static FragmentMyRegisterationFragmentBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static FragmentMyRegisterationFragmentBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.fragment_my_registeration_fragment, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static FragmentMyRegisterationFragmentBinding bind(View view) {
        int i = R.id.et_search;
        EditText editText = (EditText) view.findViewById(R.id.et_search);
        if (editText != null) {
            i = R.id.ll_query;
            LinearLayoutCompat linearLayoutCompat = (LinearLayoutCompat) view.findViewById(R.id.ll_query);
            if (linearLayoutCompat != null) {
                i = R.id.ll_reset;
                LinearLayoutCompat linearLayoutCompat2 = (LinearLayoutCompat) view.findViewById(R.id.ll_reset);
                if (linearLayoutCompat2 != null) {
                    i = R.id.ll_sort;
                    LinearLayoutCompat linearLayoutCompat3 = (LinearLayoutCompat) view.findViewById(R.id.ll_sort);
                    if (linearLayoutCompat3 != null) {
                        i = R.id.recyclerView;
                        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.recyclerView);
                        if (recyclerView != null) {
                            return new FragmentMyRegisterationFragmentBinding((LinearLayoutCompat) view, editText, linearLayoutCompat, linearLayoutCompat2, linearLayoutCompat3, recyclerView);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
