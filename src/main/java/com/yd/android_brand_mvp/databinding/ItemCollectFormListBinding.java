package com.yd.android_brand_mvp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.yd.android_brand_mvp.R;

/* JADX INFO: loaded from: classes4.dex */
public final class ItemCollectFormListBinding implements ViewBinding {
    public final TextView btnItemCollectFormList;
    private final ConstraintLayout rootView;
    public final TextView tvItemCollectFormListDesc;
    public final TextView tvItemCollectFormListSponsor;
    public final TextView tvItemCollectFormListTitle;
    public final TextView tvItemCollectFormListWatch;
    public final TextView tvItemCollectFormListWatchTip;

    private ItemCollectFormListBinding(ConstraintLayout constraintLayout, TextView textView, TextView textView2, TextView textView3, TextView textView4, TextView textView5, TextView textView6) {
        this.rootView = constraintLayout;
        this.btnItemCollectFormList = textView;
        this.tvItemCollectFormListDesc = textView2;
        this.tvItemCollectFormListSponsor = textView3;
        this.tvItemCollectFormListTitle = textView4;
        this.tvItemCollectFormListWatch = textView5;
        this.tvItemCollectFormListWatchTip = textView6;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static ItemCollectFormListBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static ItemCollectFormListBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.item_collect_form_list, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static ItemCollectFormListBinding bind(View view) {
        int i = R.id.btn_item_collect_form_list;
        TextView textView = (TextView) view.findViewById(R.id.btn_item_collect_form_list);
        if (textView != null) {
            i = R.id.tv_item_collect_form_list_desc;
            TextView textView2 = (TextView) view.findViewById(R.id.tv_item_collect_form_list_desc);
            if (textView2 != null) {
                i = R.id.tv_item_collect_form_list_sponsor;
                TextView textView3 = (TextView) view.findViewById(R.id.tv_item_collect_form_list_sponsor);
                if (textView3 != null) {
                    i = R.id.tv_item_collect_form_list_title;
                    TextView textView4 = (TextView) view.findViewById(R.id.tv_item_collect_form_list_title);
                    if (textView4 != null) {
                        i = R.id.tv_item_collect_form_list_watch;
                        TextView textView5 = (TextView) view.findViewById(R.id.tv_item_collect_form_list_watch);
                        if (textView5 != null) {
                            i = R.id.tv_item_collect_form_list_watch_tip;
                            TextView textView6 = (TextView) view.findViewById(R.id.tv_item_collect_form_list_watch_tip);
                            if (textView6 != null) {
                                return new ItemCollectFormListBinding((ConstraintLayout) view, textView, textView2, textView3, textView4, textView5, textView6);
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
