package com.yd.android_brand_mvp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.yd.android_brand_mvp.R;

/* JADX INFO: loaded from: classes4.dex */
public final class DialogLayoutConsultDetailsBinding implements ViewBinding {
    public final ImageView ivClose;
    public final ImageView ivHead;
    private final ConstraintLayout rootView;
    public final TextView tvDesc;
    public final TextView tvHeadName;
    public final TextView tvHeadTitle;
    public final TextView tvIntro;
    public final TextView tvSendWord;
    public final TextView tvSendWordTip;

    private DialogLayoutConsultDetailsBinding(ConstraintLayout constraintLayout, ImageView imageView, ImageView imageView2, TextView textView, TextView textView2, TextView textView3, TextView textView4, TextView textView5, TextView textView6) {
        this.rootView = constraintLayout;
        this.ivClose = imageView;
        this.ivHead = imageView2;
        this.tvDesc = textView;
        this.tvHeadName = textView2;
        this.tvHeadTitle = textView3;
        this.tvIntro = textView4;
        this.tvSendWord = textView5;
        this.tvSendWordTip = textView6;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static DialogLayoutConsultDetailsBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static DialogLayoutConsultDetailsBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.dialog_layout_consult_details, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static DialogLayoutConsultDetailsBinding bind(View view) {
        int i = R.id.iv_close;
        ImageView imageView = (ImageView) view.findViewById(R.id.iv_close);
        if (imageView != null) {
            i = R.id.iv_head;
            ImageView imageView2 = (ImageView) view.findViewById(R.id.iv_head);
            if (imageView2 != null) {
                i = R.id.tv_desc;
                TextView textView = (TextView) view.findViewById(R.id.tv_desc);
                if (textView != null) {
                    i = R.id.tv_head_name;
                    TextView textView2 = (TextView) view.findViewById(R.id.tv_head_name);
                    if (textView2 != null) {
                        i = R.id.tv_head_title;
                        TextView textView3 = (TextView) view.findViewById(R.id.tv_head_title);
                        if (textView3 != null) {
                            i = R.id.tv_intro;
                            TextView textView4 = (TextView) view.findViewById(R.id.tv_intro);
                            if (textView4 != null) {
                                i = R.id.tv_send_word;
                                TextView textView5 = (TextView) view.findViewById(R.id.tv_send_word);
                                if (textView5 != null) {
                                    i = R.id.tv_send_word_tip;
                                    TextView textView6 = (TextView) view.findViewById(R.id.tv_send_word_tip);
                                    if (textView6 != null) {
                                        return new DialogLayoutConsultDetailsBinding((ConstraintLayout) view, imageView, imageView2, textView, textView2, textView3, textView4, textView5, textView6);
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
