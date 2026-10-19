package com.yd.android_brand_mvp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import com.yd.android_brand_mvp.R;
import com.yd.android_brand_mvp.widget.YDWebView;

/* JADX INFO: loaded from: classes4.dex */
public final class LayoutListAnnouncementBinding implements ViewBinding {
    public final ConstraintLayout clActivityMessageContent;
    public final ConstraintLayout clActivityMessageContentReceiveResume;
    public final ImageView img;
    public final TextView lab1;
    public final ConstraintLayout llContent;
    public final RelativeLayout msglayout;
    public final RelativeLayout rlBt;
    private final ConstraintLayout rootView;
    public final RecyclerView rvActivityMessageContentDoc;
    public final TextView tvActivityMessageContentReceiveResumeAddress;
    public final TextView tvActivityMessageContentReceiveResumeAddressTip;
    public final TextView tvActivityMessageContentReceiveResumeContact;
    public final TextView tvActivityMessageContentReceiveResumeContactTip;
    public final TextView tvActivityMessageContentReceiveResumePhone;
    public final TextView tvActivityMessageContentReceiveResumePhoneTip;
    public final TextView tvActivityMessageContentReceiveResumeThing;
    public final TextView tvActivityMessageContentReceiveResumeThingTip;
    public final TextView tvActivityMessageContentReceiveResumeTime;
    public final TextView tvActivityMessageContentReceiveResumeTimeTip;
    public final TextView tvAnnTitle;
    public final TextView tvContent;
    public final TextView tvCount;
    public final TextView tvIssueName;
    public final TextView tvIssueTime;
    public final TextView tvNextReference;
    public final TextView tvPreviousRecord;
    public final TextView tvSendTime;
    public final YDWebView webView;

    private LayoutListAnnouncementBinding(ConstraintLayout constraintLayout, ConstraintLayout constraintLayout2, ConstraintLayout constraintLayout3, ImageView imageView, TextView textView, ConstraintLayout constraintLayout4, RelativeLayout relativeLayout, RelativeLayout relativeLayout2, RecyclerView recyclerView, TextView textView2, TextView textView3, TextView textView4, TextView textView5, TextView textView6, TextView textView7, TextView textView8, TextView textView9, TextView textView10, TextView textView11, TextView textView12, TextView textView13, TextView textView14, TextView textView15, TextView textView16, TextView textView17, TextView textView18, TextView textView19, YDWebView yDWebView) {
        this.rootView = constraintLayout;
        this.clActivityMessageContent = constraintLayout2;
        this.clActivityMessageContentReceiveResume = constraintLayout3;
        this.img = imageView;
        this.lab1 = textView;
        this.llContent = constraintLayout4;
        this.msglayout = relativeLayout;
        this.rlBt = relativeLayout2;
        this.rvActivityMessageContentDoc = recyclerView;
        this.tvActivityMessageContentReceiveResumeAddress = textView2;
        this.tvActivityMessageContentReceiveResumeAddressTip = textView3;
        this.tvActivityMessageContentReceiveResumeContact = textView4;
        this.tvActivityMessageContentReceiveResumeContactTip = textView5;
        this.tvActivityMessageContentReceiveResumePhone = textView6;
        this.tvActivityMessageContentReceiveResumePhoneTip = textView7;
        this.tvActivityMessageContentReceiveResumeThing = textView8;
        this.tvActivityMessageContentReceiveResumeThingTip = textView9;
        this.tvActivityMessageContentReceiveResumeTime = textView10;
        this.tvActivityMessageContentReceiveResumeTimeTip = textView11;
        this.tvAnnTitle = textView12;
        this.tvContent = textView13;
        this.tvCount = textView14;
        this.tvIssueName = textView15;
        this.tvIssueTime = textView16;
        this.tvNextReference = textView17;
        this.tvPreviousRecord = textView18;
        this.tvSendTime = textView19;
        this.webView = yDWebView;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static LayoutListAnnouncementBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static LayoutListAnnouncementBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.layout_list_announcement, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static LayoutListAnnouncementBinding bind(View view) {
        int i = R.id.cl_activity_message_content;
        ConstraintLayout constraintLayout = (ConstraintLayout) view.findViewById(R.id.cl_activity_message_content);
        if (constraintLayout != null) {
            i = R.id.cl_activity_message_content_receive_resume;
            ConstraintLayout constraintLayout2 = (ConstraintLayout) view.findViewById(R.id.cl_activity_message_content_receive_resume);
            if (constraintLayout2 != null) {
                i = R.id.img;
                ImageView imageView = (ImageView) view.findViewById(R.id.img);
                if (imageView != null) {
                    i = R.id.lab1;
                    TextView textView = (TextView) view.findViewById(R.id.lab1);
                    if (textView != null) {
                        ConstraintLayout constraintLayout3 = (ConstraintLayout) view;
                        i = R.id.msglayout;
                        RelativeLayout relativeLayout = (RelativeLayout) view.findViewById(R.id.msglayout);
                        if (relativeLayout != null) {
                            i = R.id.rl_bt;
                            RelativeLayout relativeLayout2 = (RelativeLayout) view.findViewById(R.id.rl_bt);
                            if (relativeLayout2 != null) {
                                i = R.id.rv_activity_message_content_doc;
                                RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.rv_activity_message_content_doc);
                                if (recyclerView != null) {
                                    i = R.id.tv_activity_message_content_receive_resume_address;
                                    TextView textView2 = (TextView) view.findViewById(R.id.tv_activity_message_content_receive_resume_address);
                                    if (textView2 != null) {
                                        i = R.id.tv_activity_message_content_receive_resume_address_tip;
                                        TextView textView3 = (TextView) view.findViewById(R.id.tv_activity_message_content_receive_resume_address_tip);
                                        if (textView3 != null) {
                                            i = R.id.tv_activity_message_content_receive_resume_contact;
                                            TextView textView4 = (TextView) view.findViewById(R.id.tv_activity_message_content_receive_resume_contact);
                                            if (textView4 != null) {
                                                i = R.id.tv_activity_message_content_receive_resume_contact_tip;
                                                TextView textView5 = (TextView) view.findViewById(R.id.tv_activity_message_content_receive_resume_contact_tip);
                                                if (textView5 != null) {
                                                    i = R.id.tv_activity_message_content_receive_resume_phone;
                                                    TextView textView6 = (TextView) view.findViewById(R.id.tv_activity_message_content_receive_resume_phone);
                                                    if (textView6 != null) {
                                                        i = R.id.tv_activity_message_content_receive_resume_phone_tip;
                                                        TextView textView7 = (TextView) view.findViewById(R.id.tv_activity_message_content_receive_resume_phone_tip);
                                                        if (textView7 != null) {
                                                            i = R.id.tv_activity_message_content_receive_resume_thing;
                                                            TextView textView8 = (TextView) view.findViewById(R.id.tv_activity_message_content_receive_resume_thing);
                                                            if (textView8 != null) {
                                                                i = R.id.tv_activity_message_content_receive_resume_thing_tip;
                                                                TextView textView9 = (TextView) view.findViewById(R.id.tv_activity_message_content_receive_resume_thing_tip);
                                                                if (textView9 != null) {
                                                                    i = R.id.tv_activity_message_content_receive_resume_time;
                                                                    TextView textView10 = (TextView) view.findViewById(R.id.tv_activity_message_content_receive_resume_time);
                                                                    if (textView10 != null) {
                                                                        i = R.id.tv_activity_message_content_receive_resume_time_tip;
                                                                        TextView textView11 = (TextView) view.findViewById(R.id.tv_activity_message_content_receive_resume_time_tip);
                                                                        if (textView11 != null) {
                                                                            i = R.id.tv_ann_title;
                                                                            TextView textView12 = (TextView) view.findViewById(R.id.tv_ann_title);
                                                                            if (textView12 != null) {
                                                                                i = R.id.tv_content;
                                                                                TextView textView13 = (TextView) view.findViewById(R.id.tv_content);
                                                                                if (textView13 != null) {
                                                                                    i = R.id.tv_count;
                                                                                    TextView textView14 = (TextView) view.findViewById(R.id.tv_count);
                                                                                    if (textView14 != null) {
                                                                                        i = R.id.tv_issue_name;
                                                                                        TextView textView15 = (TextView) view.findViewById(R.id.tv_issue_name);
                                                                                        if (textView15 != null) {
                                                                                            i = R.id.tv_issue_time;
                                                                                            TextView textView16 = (TextView) view.findViewById(R.id.tv_issue_time);
                                                                                            if (textView16 != null) {
                                                                                                i = R.id.tv_next_reference;
                                                                                                TextView textView17 = (TextView) view.findViewById(R.id.tv_next_reference);
                                                                                                if (textView17 != null) {
                                                                                                    i = R.id.tv_previous_record;
                                                                                                    TextView textView18 = (TextView) view.findViewById(R.id.tv_previous_record);
                                                                                                    if (textView18 != null) {
                                                                                                        i = R.id.tv_send_time;
                                                                                                        TextView textView19 = (TextView) view.findViewById(R.id.tv_send_time);
                                                                                                        if (textView19 != null) {
                                                                                                            i = R.id.webView;
                                                                                                            YDWebView yDWebView = (YDWebView) view.findViewById(R.id.webView);
                                                                                                            if (yDWebView != null) {
                                                                                                                return new LayoutListAnnouncementBinding(constraintLayout3, constraintLayout, constraintLayout2, imageView, textView, constraintLayout3, relativeLayout, relativeLayout2, recyclerView, textView2, textView3, textView4, textView5, textView6, textView7, textView8, textView9, textView10, textView11, textView12, textView13, textView14, textView15, textView16, textView17, textView18, textView19, yDWebView);
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
