package com.yd.android_brand_mvp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextClock;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.yd.android_brand_mvp.R;

/* JADX INFO: loaded from: classes4.dex */
public final class FragmentUniversityDateBinding implements ViewBinding {
    private final ConstraintLayout rootView;
    public final TextClock textClock;
    public final TextClock textClock2;
    public final TextClock textClock3;
    public final TextView textView4;

    private FragmentUniversityDateBinding(ConstraintLayout constraintLayout, TextClock textClock, TextClock textClock2, TextClock textClock3, TextView textView) {
        this.rootView = constraintLayout;
        this.textClock = textClock;
        this.textClock2 = textClock2;
        this.textClock3 = textClock3;
        this.textView4 = textView;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static FragmentUniversityDateBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static FragmentUniversityDateBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.fragment_university_date, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static FragmentUniversityDateBinding bind(View view) {
        int i = R.id.textClock;
        TextClock textClock = (TextClock) view.findViewById(R.id.textClock);
        if (textClock != null) {
            i = R.id.textClock2;
            TextClock textClock2 = (TextClock) view.findViewById(R.id.textClock2);
            if (textClock2 != null) {
                i = R.id.textClock3;
                TextClock textClock3 = (TextClock) view.findViewById(R.id.textClock3);
                if (textClock3 != null) {
                    i = R.id.textView4;
                    TextView textView = (TextView) view.findViewById(R.id.textView4);
                    if (textView != null) {
                        return new FragmentUniversityDateBinding((ConstraintLayout) view, textClock, textClock2, textClock3, textView);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
