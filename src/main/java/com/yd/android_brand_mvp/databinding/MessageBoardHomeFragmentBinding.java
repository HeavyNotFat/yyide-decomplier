package com.yd.android_brand_mvp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.FragmentContainerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewpager2.widget.ViewPager2;
import com.google.android.material.tabs.TabLayout;
import com.yd.android_brand_mvp.R;

/* JADX INFO: loaded from: classes4.dex */
public final class MessageBoardHomeFragmentBinding implements ViewBinding {
    public final FragmentContainerView container;
    private final ConstraintLayout rootView;
    public final TabLayout tlMessageBoard;
    public final TextView tvOneName;
    public final TextView tvStartNewCall;
    public final View view;
    public final ViewPager2 viewPager2;

    private MessageBoardHomeFragmentBinding(ConstraintLayout constraintLayout, FragmentContainerView fragmentContainerView, TabLayout tabLayout, TextView textView, TextView textView2, View view, ViewPager2 viewPager2) {
        this.rootView = constraintLayout;
        this.container = fragmentContainerView;
        this.tlMessageBoard = tabLayout;
        this.tvOneName = textView;
        this.tvStartNewCall = textView2;
        this.view = view;
        this.viewPager2 = viewPager2;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static MessageBoardHomeFragmentBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static MessageBoardHomeFragmentBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.message_board_home_fragment, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static MessageBoardHomeFragmentBinding bind(View view) {
        int i = R.id.container;
        FragmentContainerView fragmentContainerView = (FragmentContainerView) view.findViewById(R.id.container);
        if (fragmentContainerView != null) {
            i = R.id.tl_message_board;
            TabLayout tabLayout = (TabLayout) view.findViewById(R.id.tl_message_board);
            if (tabLayout != null) {
                i = R.id.tvOneName;
                TextView textView = (TextView) view.findViewById(R.id.tvOneName);
                if (textView != null) {
                    i = R.id.tv_start_new_call;
                    TextView textView2 = (TextView) view.findViewById(R.id.tv_start_new_call);
                    if (textView2 != null) {
                        i = R.id.view;
                        View viewFindViewById = view.findViewById(R.id.view);
                        if (viewFindViewById != null) {
                            i = R.id.viewPager2;
                            ViewPager2 viewPager2 = (ViewPager2) view.findViewById(R.id.viewPager2);
                            if (viewPager2 != null) {
                                return new MessageBoardHomeFragmentBinding((ConstraintLayout) view, fragmentContainerView, tabLayout, textView, textView2, viewFindViewById, viewPager2);
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
