package com.yd.android_brand_mvp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.viewbinding.ViewBinding;
import androidx.viewpager2.widget.ViewPager2;
import com.google.android.material.tabs.TabLayout;
import com.yd.android_brand_mvp.R;
import com.yd.android_brand_mvp.view.ListenerConstraint;

/* JADX INFO: loaded from: classes4.dex */
public final class DialogVerifyUserBinding implements ViewBinding {
    private final ListenerConstraint rootView;
    public final TabLayout tlDialogVerifyUser;
    public final ViewPager2 vpDialogVerifyUser;

    private DialogVerifyUserBinding(ListenerConstraint listenerConstraint, TabLayout tabLayout, ViewPager2 viewPager2) {
        this.rootView = listenerConstraint;
        this.tlDialogVerifyUser = tabLayout;
        this.vpDialogVerifyUser = viewPager2;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ListenerConstraint getRoot() {
        return this.rootView;
    }

    public static DialogVerifyUserBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static DialogVerifyUserBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.dialog_verify_user, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static DialogVerifyUserBinding bind(View view) {
        int i = R.id.tl_dialog_verify_user;
        TabLayout tabLayout = (TabLayout) view.findViewById(R.id.tl_dialog_verify_user);
        if (tabLayout != null) {
            i = R.id.vp_dialog_verify_user;
            ViewPager2 viewPager2 = (ViewPager2) view.findViewById(R.id.vp_dialog_verify_user);
            if (viewPager2 != null) {
                return new DialogVerifyUserBinding((ListenerConstraint) view, tabLayout, viewPager2);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
