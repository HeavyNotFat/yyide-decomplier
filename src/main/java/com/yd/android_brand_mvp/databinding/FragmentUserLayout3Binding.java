package com.yd.android_brand_mvp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import com.yd.android_brand_mvp.R;

/* JADX INFO: loaded from: classes4.dex */
public final class FragmentUserLayout3Binding implements ViewBinding {
    public final TextView btnBack;
    public final FrameLayout content;
    public final ImageView img;
    public final LinearLayout llTop;
    public final TextView name;
    public final RecyclerView recyclerView;
    private final FrameLayout rootView;
    public final TextView teacherName;
    public final TextView tvClassName;

    private FragmentUserLayout3Binding(FrameLayout frameLayout, TextView textView, FrameLayout frameLayout2, ImageView imageView, LinearLayout linearLayout, TextView textView2, RecyclerView recyclerView, TextView textView3, TextView textView4) {
        this.rootView = frameLayout;
        this.btnBack = textView;
        this.content = frameLayout2;
        this.img = imageView;
        this.llTop = linearLayout;
        this.name = textView2;
        this.recyclerView = recyclerView;
        this.teacherName = textView3;
        this.tvClassName = textView4;
    }

    @Override // androidx.viewbinding.ViewBinding
    public FrameLayout getRoot() {
        return this.rootView;
    }

    public static FragmentUserLayout3Binding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static FragmentUserLayout3Binding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.fragment_user_layout3, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static FragmentUserLayout3Binding bind(View view) {
        int i = R.id.btn_back;
        TextView textView = (TextView) view.findViewById(R.id.btn_back);
        if (textView != null) {
            i = R.id.content;
            FrameLayout frameLayout = (FrameLayout) view.findViewById(R.id.content);
            if (frameLayout != null) {
                i = R.id.img;
                ImageView imageView = (ImageView) view.findViewById(R.id.img);
                if (imageView != null) {
                    i = R.id.ll_top;
                    LinearLayout linearLayout = (LinearLayout) view.findViewById(R.id.ll_top);
                    if (linearLayout != null) {
                        i = R.id.name;
                        TextView textView2 = (TextView) view.findViewById(R.id.name);
                        if (textView2 != null) {
                            i = R.id.recyclerView;
                            RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.recyclerView);
                            if (recyclerView != null) {
                                i = R.id.teacherName;
                                TextView textView3 = (TextView) view.findViewById(R.id.teacherName);
                                if (textView3 != null) {
                                    i = R.id.tv_class_name;
                                    TextView textView4 = (TextView) view.findViewById(R.id.tv_class_name);
                                    if (textView4 != null) {
                                        return new FragmentUserLayout3Binding((FrameLayout) view, textView, frameLayout, imageView, linearLayout, textView2, recyclerView, textView3, textView4);
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
