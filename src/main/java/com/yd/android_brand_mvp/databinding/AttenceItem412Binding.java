package com.yd.android_brand_mvp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import com.yd.android_brand_mvp.R;

/* JADX INFO: loaded from: classes4.dex */
public final class AttenceItem412Binding implements ViewBinding {
    public final TextView leave;
    public final TextView name;
    public final TextView rate;
    public final RelativeLayout rlClick;
    private final LinearLayout rootView;
    public final TextView time;
    public final TextView tvTeacher;

    private AttenceItem412Binding(LinearLayout linearLayout, TextView textView, TextView textView2, TextView textView3, RelativeLayout relativeLayout, TextView textView4, TextView textView5) {
        this.rootView = linearLayout;
        this.leave = textView;
        this.name = textView2;
        this.rate = textView3;
        this.rlClick = relativeLayout;
        this.time = textView4;
        this.tvTeacher = textView5;
    }

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static AttenceItem412Binding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static AttenceItem412Binding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.attence_item_4_1_2, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static AttenceItem412Binding bind(View view) {
        int i = R.id.leave;
        TextView textView = (TextView) view.findViewById(R.id.leave);
        if (textView != null) {
            i = R.id.name;
            TextView textView2 = (TextView) view.findViewById(R.id.name);
            if (textView2 != null) {
                i = R.id.rate;
                TextView textView3 = (TextView) view.findViewById(R.id.rate);
                if (textView3 != null) {
                    i = R.id.rl_click;
                    RelativeLayout relativeLayout = (RelativeLayout) view.findViewById(R.id.rl_click);
                    if (relativeLayout != null) {
                        i = R.id.time;
                        TextView textView4 = (TextView) view.findViewById(R.id.time);
                        if (textView4 != null) {
                            i = R.id.tv_teacher;
                            TextView textView5 = (TextView) view.findViewById(R.id.tv_teacher);
                            if (textView5 != null) {
                                return new AttenceItem412Binding((LinearLayout) view, textView, textView2, textView3, relativeLayout, textView4, textView5);
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
