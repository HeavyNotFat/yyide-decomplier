package com.yd.android_brand_mvp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import androidx.viewbinding.ViewBinding;
import com.yd.android_brand_mvp.R;
import com.yd.android_brand_mvp.weight.MultiStateView;

/* JADX INFO: loaded from: classes4.dex */
public final class FragmentMessageListBinding implements ViewBinding {
    public final LayoutListAnnouncementBinding content;
    public final LinearLayout llBottom;
    public final LinearLayout llContent;
    public final MultiStateView mu;
    private final FrameLayout rootView;

    private FragmentMessageListBinding(FrameLayout frameLayout, LayoutListAnnouncementBinding layoutListAnnouncementBinding, LinearLayout linearLayout, LinearLayout linearLayout2, MultiStateView multiStateView) {
        this.rootView = frameLayout;
        this.content = layoutListAnnouncementBinding;
        this.llBottom = linearLayout;
        this.llContent = linearLayout2;
        this.mu = multiStateView;
    }

    @Override // androidx.viewbinding.ViewBinding
    public FrameLayout getRoot() {
        return this.rootView;
    }

    public static FragmentMessageListBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static FragmentMessageListBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.fragment_message_list, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static FragmentMessageListBinding bind(View view) {
        int i = R.id.content;
        View viewFindViewById = view.findViewById(R.id.content);
        if (viewFindViewById != null) {
            LayoutListAnnouncementBinding layoutListAnnouncementBindingBind = LayoutListAnnouncementBinding.bind(viewFindViewById);
            i = R.id.ll_bottom;
            LinearLayout linearLayout = (LinearLayout) view.findViewById(R.id.ll_bottom);
            if (linearLayout != null) {
                i = R.id.llContent;
                LinearLayout linearLayout2 = (LinearLayout) view.findViewById(R.id.llContent);
                if (linearLayout2 != null) {
                    i = R.id.mu;
                    MultiStateView multiStateView = (MultiStateView) view.findViewById(R.id.mu);
                    if (multiStateView != null) {
                        return new FragmentMessageListBinding((FrameLayout) view, layoutListAnnouncementBindingBind, linearLayout, linearLayout2, multiStateView);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
