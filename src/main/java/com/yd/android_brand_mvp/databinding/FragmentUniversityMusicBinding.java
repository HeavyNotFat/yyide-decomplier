package com.yd.android_brand_mvp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.FragmentContainerView;
import androidx.viewbinding.ViewBinding;
import com.yd.android_brand_mvp.R;

/* JADX INFO: loaded from: classes4.dex */
public final class FragmentUniversityMusicBinding implements ViewBinding {
    public final FragmentContainerView containerView1;
    public final FragmentContainerView containerView2;
    public final FragmentContainerView containerView3;
    private final ConstraintLayout rootView;

    private FragmentUniversityMusicBinding(ConstraintLayout constraintLayout, FragmentContainerView fragmentContainerView, FragmentContainerView fragmentContainerView2, FragmentContainerView fragmentContainerView3) {
        this.rootView = constraintLayout;
        this.containerView1 = fragmentContainerView;
        this.containerView2 = fragmentContainerView2;
        this.containerView3 = fragmentContainerView3;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static FragmentUniversityMusicBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static FragmentUniversityMusicBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.fragment_university_music, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static FragmentUniversityMusicBinding bind(View view) {
        int i = R.id.containerView1;
        FragmentContainerView fragmentContainerView = (FragmentContainerView) view.findViewById(R.id.containerView1);
        if (fragmentContainerView != null) {
            i = R.id.containerView2;
            FragmentContainerView fragmentContainerView2 = (FragmentContainerView) view.findViewById(R.id.containerView2);
            if (fragmentContainerView2 != null) {
                i = R.id.containerView3;
                FragmentContainerView fragmentContainerView3 = (FragmentContainerView) view.findViewById(R.id.containerView3);
                if (fragmentContainerView3 != null) {
                    return new FragmentUniversityMusicBinding((ConstraintLayout) view, fragmentContainerView, fragmentContainerView2, fragmentContainerView3);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
