package com.yd.android_brand_mvp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import com.yd.android_brand_mvp.R;
import com.yd.android_brand_mvp.widget.YDWebView;

/* JADX INFO: loaded from: classes4.dex */
public final class LayoutOneAnnouncementBinding implements ViewBinding {
    public final ImageView img;
    public final TextView lab1;
    public final LinearLayout llContent;
    public final RelativeLayout msglayout;
    public final RelativeLayout rlBt;
    private final LinearLayout rootView;
    public final TextView tvAnnTitle;
    public final TextView tvContent;
    public final TextView tvCount;
    public final TextView tvIssueName;
    public final TextView tvIssueTime;
    public final TextView tvNextReference;
    public final TextView tvPreviousRecord;
    public final TextView tvSendTime;
    public final YDWebView webview;

    private LayoutOneAnnouncementBinding(LinearLayout linearLayout, ImageView imageView, TextView textView, LinearLayout linearLayout2, RelativeLayout relativeLayout, RelativeLayout relativeLayout2, TextView textView2, TextView textView3, TextView textView4, TextView textView5, TextView textView6, TextView textView7, TextView textView8, TextView textView9, YDWebView yDWebView) {
        this.rootView = linearLayout;
        this.img = imageView;
        this.lab1 = textView;
        this.llContent = linearLayout2;
        this.msglayout = relativeLayout;
        this.rlBt = relativeLayout2;
        this.tvAnnTitle = textView2;
        this.tvContent = textView3;
        this.tvCount = textView4;
        this.tvIssueName = textView5;
        this.tvIssueTime = textView6;
        this.tvNextReference = textView7;
        this.tvPreviousRecord = textView8;
        this.tvSendTime = textView9;
        this.webview = yDWebView;
    }

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static LayoutOneAnnouncementBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static LayoutOneAnnouncementBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.layout_one_announcement, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static LayoutOneAnnouncementBinding bind(View view) {
        int i = R.id.img;
        ImageView imageView = (ImageView) view.findViewById(R.id.img);
        if (imageView != null) {
            i = R.id.lab1;
            TextView textView = (TextView) view.findViewById(R.id.lab1);
            if (textView != null) {
                LinearLayout linearLayout = (LinearLayout) view;
                i = R.id.msglayout;
                RelativeLayout relativeLayout = (RelativeLayout) view.findViewById(R.id.msglayout);
                if (relativeLayout != null) {
                    i = R.id.rl_bt;
                    RelativeLayout relativeLayout2 = (RelativeLayout) view.findViewById(R.id.rl_bt);
                    if (relativeLayout2 != null) {
                        i = R.id.tv_ann_title;
                        TextView textView2 = (TextView) view.findViewById(R.id.tv_ann_title);
                        if (textView2 != null) {
                            i = R.id.tv_content;
                            TextView textView3 = (TextView) view.findViewById(R.id.tv_content);
                            if (textView3 != null) {
                                i = R.id.tv_count;
                                TextView textView4 = (TextView) view.findViewById(R.id.tv_count);
                                if (textView4 != null) {
                                    i = R.id.tv_issue_name;
                                    TextView textView5 = (TextView) view.findViewById(R.id.tv_issue_name);
                                    if (textView5 != null) {
                                        i = R.id.tv_issue_time;
                                        TextView textView6 = (TextView) view.findViewById(R.id.tv_issue_time);
                                        if (textView6 != null) {
                                            i = R.id.tv_next_reference;
                                            TextView textView7 = (TextView) view.findViewById(R.id.tv_next_reference);
                                            if (textView7 != null) {
                                                i = R.id.tv_previous_record;
                                                TextView textView8 = (TextView) view.findViewById(R.id.tv_previous_record);
                                                if (textView8 != null) {
                                                    i = R.id.tv_send_time;
                                                    TextView textView9 = (TextView) view.findViewById(R.id.tv_send_time);
                                                    if (textView9 != null) {
                                                        i = R.id.webview;
                                                        YDWebView yDWebView = (YDWebView) view.findViewById(R.id.webview);
                                                        if (yDWebView != null) {
                                                            return new LayoutOneAnnouncementBinding(linearLayout, imageView, textView, linearLayout, relativeLayout, relativeLayout2, textView2, textView3, textView4, textView5, textView6, textView7, textView8, textView9, yDWebView);
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
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
