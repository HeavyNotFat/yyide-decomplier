package com.yd.android_brand_mvp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import com.yd.android_brand_mvp.R;
import com.yd.android_brand_mvp.widget.YDEditText;

/* JADX INFO: loaded from: classes4.dex */
public final class FragmentYwbook46LBinding implements ViewBinding {
    public final RelativeLayout bg;
    public final TextView booktitle;
    public final YDEditText edit;
    public final LinearLayout layoutInfo;
    public final TextView msg;
    public final RecyclerView recyclerView;
    private final RelativeLayout rootView;
    public final LinearLayout s1;
    public final FrameLayout seach;
    public final TextView tj;

    private FragmentYwbook46LBinding(RelativeLayout relativeLayout, RelativeLayout relativeLayout2, TextView textView, YDEditText yDEditText, LinearLayout linearLayout, TextView textView2, RecyclerView recyclerView, LinearLayout linearLayout2, FrameLayout frameLayout, TextView textView3) {
        this.rootView = relativeLayout;
        this.bg = relativeLayout2;
        this.booktitle = textView;
        this.edit = yDEditText;
        this.layoutInfo = linearLayout;
        this.msg = textView2;
        this.recyclerView = recyclerView;
        this.s1 = linearLayout2;
        this.seach = frameLayout;
        this.tj = textView3;
    }

    @Override // androidx.viewbinding.ViewBinding
    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static FragmentYwbook46LBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static FragmentYwbook46LBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.fragment_ywbook_4_6_l, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static FragmentYwbook46LBinding bind(View view) {
        int i = R.id.bg;
        RelativeLayout relativeLayout = (RelativeLayout) view.findViewById(R.id.bg);
        if (relativeLayout != null) {
            i = R.id.booktitle;
            TextView textView = (TextView) view.findViewById(R.id.booktitle);
            if (textView != null) {
                i = R.id.edit;
                YDEditText yDEditText = (YDEditText) view.findViewById(R.id.edit);
                if (yDEditText != null) {
                    i = R.id.layout_info;
                    LinearLayout linearLayout = (LinearLayout) view.findViewById(R.id.layout_info);
                    if (linearLayout != null) {
                        i = R.id.msg;
                        TextView textView2 = (TextView) view.findViewById(R.id.msg);
                        if (textView2 != null) {
                            i = R.id.recyclerView;
                            RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.recyclerView);
                            if (recyclerView != null) {
                                i = R.id.s1;
                                LinearLayout linearLayout2 = (LinearLayout) view.findViewById(R.id.s1);
                                if (linearLayout2 != null) {
                                    i = R.id.seach;
                                    FrameLayout frameLayout = (FrameLayout) view.findViewById(R.id.seach);
                                    if (frameLayout != null) {
                                        i = R.id.tj;
                                        TextView textView3 = (TextView) view.findViewById(R.id.tj);
                                        if (textView3 != null) {
                                            return new FragmentYwbook46LBinding((RelativeLayout) view, relativeLayout, textView, yDEditText, linearLayout, textView2, recyclerView, linearLayout2, frameLayout, textView3);
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
