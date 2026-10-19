package com.yd.android_brand_mvp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.yd.android_brand_mvp.R;
import com.yd.android_brand_mvp.weight.MultiStateView;

/* JADX INFO: loaded from: classes4.dex */
public final class CommentsDetailFragmentBinding implements ViewBinding {
    public final ImageView ivImg;
    public final MultiStateView mu;
    private final ConstraintLayout rootView;
    public final TitleLayoutBinding top;
    public final TextView tvContent;
    public final TextView tvName;
    public final TextView tvReply;
    public final TextView tvReplyTime;
    public final TextView tvTime;

    private CommentsDetailFragmentBinding(ConstraintLayout constraintLayout, ImageView imageView, MultiStateView multiStateView, TitleLayoutBinding titleLayoutBinding, TextView textView, TextView textView2, TextView textView3, TextView textView4, TextView textView5) {
        this.rootView = constraintLayout;
        this.ivImg = imageView;
        this.mu = multiStateView;
        this.top = titleLayoutBinding;
        this.tvContent = textView;
        this.tvName = textView2;
        this.tvReply = textView3;
        this.tvReplyTime = textView4;
        this.tvTime = textView5;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static CommentsDetailFragmentBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static CommentsDetailFragmentBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.comments_detail_fragment, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static CommentsDetailFragmentBinding bind(View view) {
        int i = R.id.iv_img;
        ImageView imageView = (ImageView) view.findViewById(R.id.iv_img);
        if (imageView != null) {
            i = R.id.mu;
            MultiStateView multiStateView = (MultiStateView) view.findViewById(R.id.mu);
            if (multiStateView != null) {
                i = R.id.top;
                View viewFindViewById = view.findViewById(R.id.top);
                if (viewFindViewById != null) {
                    TitleLayoutBinding titleLayoutBindingBind = TitleLayoutBinding.bind(viewFindViewById);
                    i = R.id.tv_content;
                    TextView textView = (TextView) view.findViewById(R.id.tv_content);
                    if (textView != null) {
                        i = R.id.tv_name;
                        TextView textView2 = (TextView) view.findViewById(R.id.tv_name);
                        if (textView2 != null) {
                            i = R.id.tv_reply;
                            TextView textView3 = (TextView) view.findViewById(R.id.tv_reply);
                            if (textView3 != null) {
                                i = R.id.tv_reply_time;
                                TextView textView4 = (TextView) view.findViewById(R.id.tv_reply_time);
                                if (textView4 != null) {
                                    i = R.id.tv_time;
                                    TextView textView5 = (TextView) view.findViewById(R.id.tv_time);
                                    if (textView5 != null) {
                                        return new CommentsDetailFragmentBinding((ConstraintLayout) view, imageView, multiStateView, titleLayoutBindingBind, textView, textView2, textView3, textView4, textView5);
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
