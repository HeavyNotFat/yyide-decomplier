package com.yd.android_brand_mvp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import com.yd.android_brand_mvp.R;

/* JADX INFO: loaded from: classes4.dex */
public final class ItembookTmBinding implements ViewBinding {
    public final TextView adress;
    public final TextView dl;
    public final TextView jg;
    public final TextView lx;

    /* JADX INFO: renamed from: no, reason: collision with root package name */
    public final TextView f2008no;
    private final RelativeLayout rootView;
    public final TextView stuas;

    private ItembookTmBinding(RelativeLayout relativeLayout, TextView textView, TextView textView2, TextView textView3, TextView textView4, TextView textView5, TextView textView6) {
        this.rootView = relativeLayout;
        this.adress = textView;
        this.dl = textView2;
        this.jg = textView3;
        this.lx = textView4;
        this.f2008no = textView5;
        this.stuas = textView6;
    }

    @Override // androidx.viewbinding.ViewBinding
    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static ItembookTmBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static ItembookTmBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.itembook_tm, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static ItembookTmBinding bind(View view) {
        int i = R.id.adress;
        TextView textView = (TextView) view.findViewById(R.id.adress);
        if (textView != null) {
            i = R.id.dl;
            TextView textView2 = (TextView) view.findViewById(R.id.dl);
            if (textView2 != null) {
                i = R.id.jg;
                TextView textView3 = (TextView) view.findViewById(R.id.jg);
                if (textView3 != null) {
                    i = R.id.lx;
                    TextView textView4 = (TextView) view.findViewById(R.id.lx);
                    if (textView4 != null) {
                        i = R.id.no;
                        TextView textView5 = (TextView) view.findViewById(R.id.no);
                        if (textView5 != null) {
                            i = R.id.stuas;
                            TextView textView6 = (TextView) view.findViewById(R.id.stuas);
                            if (textView6 != null) {
                                return new ItembookTmBinding((RelativeLayout) view, textView, textView2, textView3, textView4, textView5, textView6);
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
