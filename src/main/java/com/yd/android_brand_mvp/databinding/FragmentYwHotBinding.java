package com.yd.android_brand_mvp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import com.yd.android_brand_mvp.R;

/* JADX INFO: loaded from: classes4.dex */
public final class FragmentYwHotBinding implements ViewBinding {
    public final TextView flag;
    public final TextView flag2;
    public final FrameLayout flaglayout2;
    public final TextView language;
    public final RecyclerView recyclerView;
    private final LinearLayout rootView;
    public final LinearLayout s1;
    public final TextView time;
    public final TextView type;
    public final FrameLayout typelayout;
    public final FrameLayout yzLayout;

    private FragmentYwHotBinding(LinearLayout linearLayout, TextView textView, TextView textView2, FrameLayout frameLayout, TextView textView3, RecyclerView recyclerView, LinearLayout linearLayout2, TextView textView4, TextView textView5, FrameLayout frameLayout2, FrameLayout frameLayout3) {
        this.rootView = linearLayout;
        this.flag = textView;
        this.flag2 = textView2;
        this.flaglayout2 = frameLayout;
        this.language = textView3;
        this.recyclerView = recyclerView;
        this.s1 = linearLayout2;
        this.time = textView4;
        this.type = textView5;
        this.typelayout = frameLayout2;
        this.yzLayout = frameLayout3;
    }

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static FragmentYwHotBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static FragmentYwHotBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.fragment_yw_hot, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static FragmentYwHotBinding bind(View view) {
        int i = R.id.flag;
        TextView textView = (TextView) view.findViewById(R.id.flag);
        if (textView != null) {
            i = R.id.flag2;
            TextView textView2 = (TextView) view.findViewById(R.id.flag2);
            if (textView2 != null) {
                i = R.id.flaglayout2;
                FrameLayout frameLayout = (FrameLayout) view.findViewById(R.id.flaglayout2);
                if (frameLayout != null) {
                    i = R.id.language;
                    TextView textView3 = (TextView) view.findViewById(R.id.language);
                    if (textView3 != null) {
                        i = R.id.recyclerView;
                        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.recyclerView);
                        if (recyclerView != null) {
                            i = R.id.s1;
                            LinearLayout linearLayout = (LinearLayout) view.findViewById(R.id.s1);
                            if (linearLayout != null) {
                                i = R.id.time;
                                TextView textView4 = (TextView) view.findViewById(R.id.time);
                                if (textView4 != null) {
                                    i = R.id.type;
                                    TextView textView5 = (TextView) view.findViewById(R.id.type);
                                    if (textView5 != null) {
                                        i = R.id.typelayout;
                                        FrameLayout frameLayout2 = (FrameLayout) view.findViewById(R.id.typelayout);
                                        if (frameLayout2 != null) {
                                            i = R.id.yz_layout;
                                            FrameLayout frameLayout3 = (FrameLayout) view.findViewById(R.id.yz_layout);
                                            if (frameLayout3 != null) {
                                                return new FragmentYwHotBinding((LinearLayout) view, textView, textView2, frameLayout, textView3, recyclerView, linearLayout, textView4, textView5, frameLayout2, frameLayout3);
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
