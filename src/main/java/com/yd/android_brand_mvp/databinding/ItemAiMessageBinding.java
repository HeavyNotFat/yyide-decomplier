package com.yd.android_brand_mvp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckedTextView;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Group;
import androidx.viewbinding.ViewBinding;
import com.yd.android_brand_mvp.R;

/* JADX INFO: loaded from: classes4.dex */
public final class ItemAiMessageBinding implements ViewBinding {
    public final CheckedTextView ctCopy;
    public final CheckedTextView ctGive;
    public final CheckedTextView ctStep;
    public final CardView cvItem;
    public final Group groupView;
    public final ImageView ivIcon;
    public final ProgressBar loadingProgressBar;
    public final ProgressBar progressBar;
    private final ConstraintLayout rootView;
    public final TextView tvMessage;
    public final TextView tvTextCount;
    public final TextView tvTitle;

    private ItemAiMessageBinding(ConstraintLayout constraintLayout, CheckedTextView checkedTextView, CheckedTextView checkedTextView2, CheckedTextView checkedTextView3, CardView cardView, Group group, ImageView imageView, ProgressBar progressBar, ProgressBar progressBar2, TextView textView, TextView textView2, TextView textView3) {
        this.rootView = constraintLayout;
        this.ctCopy = checkedTextView;
        this.ctGive = checkedTextView2;
        this.ctStep = checkedTextView3;
        this.cvItem = cardView;
        this.groupView = group;
        this.ivIcon = imageView;
        this.loadingProgressBar = progressBar;
        this.progressBar = progressBar2;
        this.tvMessage = textView;
        this.tvTextCount = textView2;
        this.tvTitle = textView3;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static ItemAiMessageBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static ItemAiMessageBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.item_ai_message, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static ItemAiMessageBinding bind(View view) {
        int i = R.id.ct_copy;
        CheckedTextView checkedTextView = (CheckedTextView) view.findViewById(R.id.ct_copy);
        if (checkedTextView != null) {
            i = R.id.ct_give;
            CheckedTextView checkedTextView2 = (CheckedTextView) view.findViewById(R.id.ct_give);
            if (checkedTextView2 != null) {
                i = R.id.ct_step;
                CheckedTextView checkedTextView3 = (CheckedTextView) view.findViewById(R.id.ct_step);
                if (checkedTextView3 != null) {
                    i = R.id.cv_item;
                    CardView cardView = (CardView) view.findViewById(R.id.cv_item);
                    if (cardView != null) {
                        i = R.id.group_view;
                        Group group = (Group) view.findViewById(R.id.group_view);
                        if (group != null) {
                            i = R.id.iv_icon;
                            ImageView imageView = (ImageView) view.findViewById(R.id.iv_icon);
                            if (imageView != null) {
                                i = R.id.loadingProgressBar;
                                ProgressBar progressBar = (ProgressBar) view.findViewById(R.id.loadingProgressBar);
                                if (progressBar != null) {
                                    i = R.id.progressBar;
                                    ProgressBar progressBar2 = (ProgressBar) view.findViewById(R.id.progressBar);
                                    if (progressBar2 != null) {
                                        i = R.id.tvMessage;
                                        TextView textView = (TextView) view.findViewById(R.id.tvMessage);
                                        if (textView != null) {
                                            i = R.id.tv_text_count;
                                            TextView textView2 = (TextView) view.findViewById(R.id.tv_text_count);
                                            if (textView2 != null) {
                                                i = R.id.tv_title;
                                                TextView textView3 = (TextView) view.findViewById(R.id.tv_title);
                                                if (textView3 != null) {
                                                    return new ItemAiMessageBinding((ConstraintLayout) view, checkedTextView, checkedTextView2, checkedTextView3, cardView, group, imageView, progressBar, progressBar2, textView, textView2, textView3);
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
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
