package com.yd.android_brand_mvp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import com.yd.android_brand_mvp.R;

/* JADX INFO: loaded from: classes4.dex */
public final class FragmentUniversityTrainingDeviceBinding implements ViewBinding {
    public final LinearLayoutCompat linearLayoutCompat;
    public final RecyclerView recyclerView;
    private final ConstraintLayout rootView;

    private FragmentUniversityTrainingDeviceBinding(ConstraintLayout constraintLayout, LinearLayoutCompat linearLayoutCompat, RecyclerView recyclerView) {
        this.rootView = constraintLayout;
        this.linearLayoutCompat = linearLayoutCompat;
        this.recyclerView = recyclerView;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static FragmentUniversityTrainingDeviceBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static FragmentUniversityTrainingDeviceBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.fragment_university_training_device, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static FragmentUniversityTrainingDeviceBinding bind(View view) {
        int i = R.id.linearLayoutCompat;
        LinearLayoutCompat linearLayoutCompat = (LinearLayoutCompat) view.findViewById(R.id.linearLayoutCompat);
        if (linearLayoutCompat != null) {
            i = R.id.recyclerView;
            RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.recyclerView);
            if (recyclerView != null) {
                return new FragmentUniversityTrainingDeviceBinding((ConstraintLayout) view, linearLayoutCompat, recyclerView);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
