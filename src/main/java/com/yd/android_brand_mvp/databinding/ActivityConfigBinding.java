package com.yd.android_brand_mvp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.yd.android_brand_mvp.R;
import com.yd.android_brand_mvp.widget.YDEditText;

/* JADX INFO: loaded from: classes4.dex */
public final class ActivityConfigBinding implements ViewBinding {
    public final YDEditText etFile;
    public final YDEditText etHttp;
    public final YDEditText etMqtt;
    public final ImageView imageView6;
    private final ConstraintLayout rootView;
    public final TextView textView12;
    public final TextView textView13;
    public final TextView textView14;

    private ActivityConfigBinding(ConstraintLayout constraintLayout, YDEditText yDEditText, YDEditText yDEditText2, YDEditText yDEditText3, ImageView imageView, TextView textView, TextView textView2, TextView textView3) {
        this.rootView = constraintLayout;
        this.etFile = yDEditText;
        this.etHttp = yDEditText2;
        this.etMqtt = yDEditText3;
        this.imageView6 = imageView;
        this.textView12 = textView;
        this.textView13 = textView2;
        this.textView14 = textView3;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static ActivityConfigBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static ActivityConfigBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.activity_config, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static ActivityConfigBinding bind(View view) {
        int i = R.id.etFile;
        YDEditText yDEditText = (YDEditText) view.findViewById(R.id.etFile);
        if (yDEditText != null) {
            i = R.id.etHttp;
            YDEditText yDEditText2 = (YDEditText) view.findViewById(R.id.etHttp);
            if (yDEditText2 != null) {
                i = R.id.etMqtt;
                YDEditText yDEditText3 = (YDEditText) view.findViewById(R.id.etMqtt);
                if (yDEditText3 != null) {
                    i = R.id.imageView6;
                    ImageView imageView = (ImageView) view.findViewById(R.id.imageView6);
                    if (imageView != null) {
                        i = R.id.textView12;
                        TextView textView = (TextView) view.findViewById(R.id.textView12);
                        if (textView != null) {
                            i = R.id.textView13;
                            TextView textView2 = (TextView) view.findViewById(R.id.textView13);
                            if (textView2 != null) {
                                i = R.id.textView14;
                                TextView textView3 = (TextView) view.findViewById(R.id.textView14);
                                if (textView3 != null) {
                                    return new ActivityConfigBinding((ConstraintLayout) view, yDEditText, yDEditText2, yDEditText3, imageView, textView, textView2, textView3);
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
