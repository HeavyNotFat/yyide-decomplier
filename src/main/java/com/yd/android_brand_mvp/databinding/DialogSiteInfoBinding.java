package com.yd.android_brand_mvp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.constraintlayout.widget.Barrier;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.yd.android_brand_mvp.R;

/* JADX INFO: loaded from: classes4.dex */
public final class DialogSiteInfoBinding implements ViewBinding {
    public final Barrier barrierDialogSiteInfoName;
    private final ConstraintLayout rootView;
    public final TextView tvDialogSiteInfoCapacity;
    public final TextView tvDialogSiteInfoCapacityContent;
    public final TextView tvDialogSiteInfoFloor;
    public final TextView tvDialogSiteInfoFloorContent;
    public final TextView tvDialogSiteInfoManager;
    public final TextView tvDialogSiteInfoManagerContent;
    public final TextView tvDialogSiteInfoName;
    public final TextView tvDialogSiteInfoRoomNum;
    public final TextView tvDialogSiteInfoRoomNumContent;
    public final TextView tvDialogSiteInfoSize;
    public final TextView tvDialogSiteInfoSizeContent;
    public final TextView tvDialogSiteInfoTitle;
    public final TextView tvDialogSiteInfoType;
    public final TextView tvDialogSiteInfoTypeContent;

    private DialogSiteInfoBinding(ConstraintLayout constraintLayout, Barrier barrier, TextView textView, TextView textView2, TextView textView3, TextView textView4, TextView textView5, TextView textView6, TextView textView7, TextView textView8, TextView textView9, TextView textView10, TextView textView11, TextView textView12, TextView textView13, TextView textView14) {
        this.rootView = constraintLayout;
        this.barrierDialogSiteInfoName = barrier;
        this.tvDialogSiteInfoCapacity = textView;
        this.tvDialogSiteInfoCapacityContent = textView2;
        this.tvDialogSiteInfoFloor = textView3;
        this.tvDialogSiteInfoFloorContent = textView4;
        this.tvDialogSiteInfoManager = textView5;
        this.tvDialogSiteInfoManagerContent = textView6;
        this.tvDialogSiteInfoName = textView7;
        this.tvDialogSiteInfoRoomNum = textView8;
        this.tvDialogSiteInfoRoomNumContent = textView9;
        this.tvDialogSiteInfoSize = textView10;
        this.tvDialogSiteInfoSizeContent = textView11;
        this.tvDialogSiteInfoTitle = textView12;
        this.tvDialogSiteInfoType = textView13;
        this.tvDialogSiteInfoTypeContent = textView14;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static DialogSiteInfoBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static DialogSiteInfoBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.dialog_site_info, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static DialogSiteInfoBinding bind(View view) {
        int i = R.id.barrier_dialog_site_info_name;
        Barrier barrier = (Barrier) view.findViewById(R.id.barrier_dialog_site_info_name);
        if (barrier != null) {
            i = R.id.tv_dialog_site_info_capacity;
            TextView textView = (TextView) view.findViewById(R.id.tv_dialog_site_info_capacity);
            if (textView != null) {
                i = R.id.tv_dialog_site_info_capacity_content;
                TextView textView2 = (TextView) view.findViewById(R.id.tv_dialog_site_info_capacity_content);
                if (textView2 != null) {
                    i = R.id.tv_dialog_site_info_floor;
                    TextView textView3 = (TextView) view.findViewById(R.id.tv_dialog_site_info_floor);
                    if (textView3 != null) {
                        i = R.id.tv_dialog_site_info_floor_content;
                        TextView textView4 = (TextView) view.findViewById(R.id.tv_dialog_site_info_floor_content);
                        if (textView4 != null) {
                            i = R.id.tv_dialog_site_info_manager;
                            TextView textView5 = (TextView) view.findViewById(R.id.tv_dialog_site_info_manager);
                            if (textView5 != null) {
                                i = R.id.tv_dialog_site_info_manager_content;
                                TextView textView6 = (TextView) view.findViewById(R.id.tv_dialog_site_info_manager_content);
                                if (textView6 != null) {
                                    i = R.id.tv_dialog_site_info_name;
                                    TextView textView7 = (TextView) view.findViewById(R.id.tv_dialog_site_info_name);
                                    if (textView7 != null) {
                                        i = R.id.tv_dialog_site_info_roomNum;
                                        TextView textView8 = (TextView) view.findViewById(R.id.tv_dialog_site_info_roomNum);
                                        if (textView8 != null) {
                                            i = R.id.tv_dialog_site_info_roomNum_content;
                                            TextView textView9 = (TextView) view.findViewById(R.id.tv_dialog_site_info_roomNum_content);
                                            if (textView9 != null) {
                                                i = R.id.tv_dialog_site_info_size;
                                                TextView textView10 = (TextView) view.findViewById(R.id.tv_dialog_site_info_size);
                                                if (textView10 != null) {
                                                    i = R.id.tv_dialog_site_info_size_content;
                                                    TextView textView11 = (TextView) view.findViewById(R.id.tv_dialog_site_info_size_content);
                                                    if (textView11 != null) {
                                                        i = R.id.tv_dialog_site_info_title;
                                                        TextView textView12 = (TextView) view.findViewById(R.id.tv_dialog_site_info_title);
                                                        if (textView12 != null) {
                                                            i = R.id.tv_dialog_site_info_type;
                                                            TextView textView13 = (TextView) view.findViewById(R.id.tv_dialog_site_info_type);
                                                            if (textView13 != null) {
                                                                i = R.id.tv_dialog_site_info_type_content;
                                                                TextView textView14 = (TextView) view.findViewById(R.id.tv_dialog_site_info_type_content);
                                                                if (textView14 != null) {
                                                                    return new DialogSiteInfoBinding((ConstraintLayout) view, barrier, textView, textView2, textView3, textView4, textView5, textView6, textView7, textView8, textView9, textView10, textView11, textView12, textView13, textView14);
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
