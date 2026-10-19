package com.yd.android_brand_mvp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.FragmentContainerView;
import androidx.viewbinding.ViewBinding;
import com.yd.android_brand_mvp.R;
import com.yd.android_brand_mvp.view.ScrollTextView;

/* JADX INFO: loaded from: classes4.dex */
public final class FragmentCustomHomeBinding implements ViewBinding {
    public final FragmentContainerView fragmentContainerAttendance;
    public final FragmentContainerView fragmentContainerSensor;
    public final FragmentContainerView fragmentContainerSite;
    public final FragmentContainerView fragmentContainerTable;
    public final FragmentContainerView fragmentContainerWarning;
    public final ImageView ivAttendance;
    public final ImageView ivNotice;
    public final ImageView ivOpen;
    private final ConstraintLayout rootView;
    public final ScrollTextView tvNotice;
    public final TextView tvNoticeHint;

    private FragmentCustomHomeBinding(ConstraintLayout constraintLayout, FragmentContainerView fragmentContainerView, FragmentContainerView fragmentContainerView2, FragmentContainerView fragmentContainerView3, FragmentContainerView fragmentContainerView4, FragmentContainerView fragmentContainerView5, ImageView imageView, ImageView imageView2, ImageView imageView3, ScrollTextView scrollTextView, TextView textView) {
        this.rootView = constraintLayout;
        this.fragmentContainerAttendance = fragmentContainerView;
        this.fragmentContainerSensor = fragmentContainerView2;
        this.fragmentContainerSite = fragmentContainerView3;
        this.fragmentContainerTable = fragmentContainerView4;
        this.fragmentContainerWarning = fragmentContainerView5;
        this.ivAttendance = imageView;
        this.ivNotice = imageView2;
        this.ivOpen = imageView3;
        this.tvNotice = scrollTextView;
        this.tvNoticeHint = textView;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static FragmentCustomHomeBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static FragmentCustomHomeBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.fragment_custom_home, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static FragmentCustomHomeBinding bind(View view) {
        int i = R.id.fragment_container_attendance;
        FragmentContainerView fragmentContainerView = (FragmentContainerView) view.findViewById(R.id.fragment_container_attendance);
        if (fragmentContainerView != null) {
            i = R.id.fragment_container_sensor;
            FragmentContainerView fragmentContainerView2 = (FragmentContainerView) view.findViewById(R.id.fragment_container_sensor);
            if (fragmentContainerView2 != null) {
                i = R.id.fragment_container_site;
                FragmentContainerView fragmentContainerView3 = (FragmentContainerView) view.findViewById(R.id.fragment_container_site);
                if (fragmentContainerView3 != null) {
                    i = R.id.fragment_container_table;
                    FragmentContainerView fragmentContainerView4 = (FragmentContainerView) view.findViewById(R.id.fragment_container_table);
                    if (fragmentContainerView4 != null) {
                        i = R.id.fragment_container_warning;
                        FragmentContainerView fragmentContainerView5 = (FragmentContainerView) view.findViewById(R.id.fragment_container_warning);
                        if (fragmentContainerView5 != null) {
                            i = R.id.iv_attendance;
                            ImageView imageView = (ImageView) view.findViewById(R.id.iv_attendance);
                            if (imageView != null) {
                                i = R.id.iv_notice;
                                ImageView imageView2 = (ImageView) view.findViewById(R.id.iv_notice);
                                if (imageView2 != null) {
                                    i = R.id.iv_open;
                                    ImageView imageView3 = (ImageView) view.findViewById(R.id.iv_open);
                                    if (imageView3 != null) {
                                        i = R.id.tv_notice;
                                        ScrollTextView scrollTextView = (ScrollTextView) view.findViewById(R.id.tv_notice);
                                        if (scrollTextView != null) {
                                            i = R.id.tv_notice_hint;
                                            TextView textView = (TextView) view.findViewById(R.id.tv_notice_hint);
                                            if (textView != null) {
                                                return new FragmentCustomHomeBinding((ConstraintLayout) view, fragmentContainerView, fragmentContainerView2, fragmentContainerView3, fragmentContainerView4, fragmentContainerView5, imageView, imageView2, imageView3, scrollTextView, textView);
                                            }
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
