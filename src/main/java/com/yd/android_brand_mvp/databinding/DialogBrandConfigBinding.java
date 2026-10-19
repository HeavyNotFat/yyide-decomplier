package com.yd.android_brand_mvp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.yd.android_brand_mvp.R;

/* JADX INFO: loaded from: classes4.dex */
public final class DialogBrandConfigBinding implements ViewBinding {
    private final ConstraintLayout rootView;
    public final TextView textView16;
    public final TextView tvBrand;
    public final TextView tvBrandModel;
    public final TextView tvCard;
    public final TextView tvFrequency;
    public final TextView tvPreviewRotation;
    public final TextView tvRotation;
    public final TextView tvSerial;

    private DialogBrandConfigBinding(ConstraintLayout constraintLayout, TextView textView, TextView textView2, TextView textView3, TextView textView4, TextView textView5, TextView textView6, TextView textView7, TextView textView8) {
        this.rootView = constraintLayout;
        this.textView16 = textView;
        this.tvBrand = textView2;
        this.tvBrandModel = textView3;
        this.tvCard = textView4;
        this.tvFrequency = textView5;
        this.tvPreviewRotation = textView6;
        this.tvRotation = textView7;
        this.tvSerial = textView8;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static DialogBrandConfigBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static DialogBrandConfigBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.dialog_brand_config, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static DialogBrandConfigBinding bind(View view) {
        int i = R.id.textView16;
        TextView textView = (TextView) view.findViewById(R.id.textView16);
        if (textView != null) {
            i = R.id.tvBrand;
            TextView textView2 = (TextView) view.findViewById(R.id.tvBrand);
            if (textView2 != null) {
                i = R.id.tvBrandModel;
                TextView textView3 = (TextView) view.findViewById(R.id.tvBrandModel);
                if (textView3 != null) {
                    i = R.id.tvCard;
                    TextView textView4 = (TextView) view.findViewById(R.id.tvCard);
                    if (textView4 != null) {
                        i = R.id.tvFrequency;
                        TextView textView5 = (TextView) view.findViewById(R.id.tvFrequency);
                        if (textView5 != null) {
                            i = R.id.tvPreviewRotation;
                            TextView textView6 = (TextView) view.findViewById(R.id.tvPreviewRotation);
                            if (textView6 != null) {
                                i = R.id.tvRotation;
                                TextView textView7 = (TextView) view.findViewById(R.id.tvRotation);
                                if (textView7 != null) {
                                    i = R.id.tvSerial;
                                    TextView textView8 = (TextView) view.findViewById(R.id.tvSerial);
                                    if (textView8 != null) {
                                        return new DialogBrandConfigBinding((ConstraintLayout) view, textView, textView2, textView3, textView4, textView5, textView6, textView7, textView8);
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
