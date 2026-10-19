package com.yd.android_brand_mvp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.widget.NestedScrollView;
import androidx.viewbinding.ViewBinding;
import com.yd.android_brand_mvp.R;

/* JADX INFO: loaded from: classes4.dex */
public final class DialogReservationDetailBinding implements ViewBinding {
    public final ConstraintLayout clDialogReservationDetail;
    private final NestedScrollView rootView;
    public final TextView tvDialogReservationDetailParticipant;
    public final TextView tvDialogReservationDetailParticipantTip;
    public final TextView tvDialogReservationDetailPeople;
    public final TextView tvDialogReservationDetailPeopleTip;
    public final TextView tvDialogReservationDetailRemark;
    public final TextView tvDialogReservationDetailRemarkTip;
    public final TextView tvDialogReservationDetailSignStatus;
    public final TextView tvDialogReservationDetailSignStatusTip;
    public final TextView tvDialogReservationDetailSiteCapacity;
    public final TextView tvDialogReservationDetailSiteCapacityTip;
    public final TextView tvDialogReservationDetailSiteDevice;
    public final TextView tvDialogReservationDetailSiteDeviceTip;
    public final TextView tvDialogReservationDetailSiteLocation;
    public final TextView tvDialogReservationDetailSiteLocationTip;
    public final TextView tvDialogReservationDetailSiteName;
    public final TextView tvDialogReservationDetailSiteType;
    public final TextView tvDialogReservationDetailSiteTypeTip;
    public final TextView tvDialogReservationDetailTheme;
    public final TextView tvDialogReservationDetailTime;
    public final TextView tvDialogReservationDetailTimeTip;
    public final TextView tvDialogReservationDetailTitle;

    private DialogReservationDetailBinding(NestedScrollView nestedScrollView, ConstraintLayout constraintLayout, TextView textView, TextView textView2, TextView textView3, TextView textView4, TextView textView5, TextView textView6, TextView textView7, TextView textView8, TextView textView9, TextView textView10, TextView textView11, TextView textView12, TextView textView13, TextView textView14, TextView textView15, TextView textView16, TextView textView17, TextView textView18, TextView textView19, TextView textView20, TextView textView21) {
        this.rootView = nestedScrollView;
        this.clDialogReservationDetail = constraintLayout;
        this.tvDialogReservationDetailParticipant = textView;
        this.tvDialogReservationDetailParticipantTip = textView2;
        this.tvDialogReservationDetailPeople = textView3;
        this.tvDialogReservationDetailPeopleTip = textView4;
        this.tvDialogReservationDetailRemark = textView5;
        this.tvDialogReservationDetailRemarkTip = textView6;
        this.tvDialogReservationDetailSignStatus = textView7;
        this.tvDialogReservationDetailSignStatusTip = textView8;
        this.tvDialogReservationDetailSiteCapacity = textView9;
        this.tvDialogReservationDetailSiteCapacityTip = textView10;
        this.tvDialogReservationDetailSiteDevice = textView11;
        this.tvDialogReservationDetailSiteDeviceTip = textView12;
        this.tvDialogReservationDetailSiteLocation = textView13;
        this.tvDialogReservationDetailSiteLocationTip = textView14;
        this.tvDialogReservationDetailSiteName = textView15;
        this.tvDialogReservationDetailSiteType = textView16;
        this.tvDialogReservationDetailSiteTypeTip = textView17;
        this.tvDialogReservationDetailTheme = textView18;
        this.tvDialogReservationDetailTime = textView19;
        this.tvDialogReservationDetailTimeTip = textView20;
        this.tvDialogReservationDetailTitle = textView21;
    }

    @Override // androidx.viewbinding.ViewBinding
    public NestedScrollView getRoot() {
        return this.rootView;
    }

    public static DialogReservationDetailBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static DialogReservationDetailBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.dialog_reservation_detail, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static DialogReservationDetailBinding bind(View view) {
        int i = R.id.cl_dialog_reservation_detail;
        ConstraintLayout constraintLayout = (ConstraintLayout) view.findViewById(R.id.cl_dialog_reservation_detail);
        if (constraintLayout != null) {
            i = R.id.tv_dialog_reservation_detail_participant;
            TextView textView = (TextView) view.findViewById(R.id.tv_dialog_reservation_detail_participant);
            if (textView != null) {
                i = R.id.tv_dialog_reservation_detail_participant_tip;
                TextView textView2 = (TextView) view.findViewById(R.id.tv_dialog_reservation_detail_participant_tip);
                if (textView2 != null) {
                    i = R.id.tv_dialog_reservation_detail_people;
                    TextView textView3 = (TextView) view.findViewById(R.id.tv_dialog_reservation_detail_people);
                    if (textView3 != null) {
                        i = R.id.tv_dialog_reservation_detail_people_tip;
                        TextView textView4 = (TextView) view.findViewById(R.id.tv_dialog_reservation_detail_people_tip);
                        if (textView4 != null) {
                            i = R.id.tv_dialog_reservation_detail_remark;
                            TextView textView5 = (TextView) view.findViewById(R.id.tv_dialog_reservation_detail_remark);
                            if (textView5 != null) {
                                i = R.id.tv_dialog_reservation_detail_remark_tip;
                                TextView textView6 = (TextView) view.findViewById(R.id.tv_dialog_reservation_detail_remark_tip);
                                if (textView6 != null) {
                                    i = R.id.tv_dialog_reservation_detail_sign_status;
                                    TextView textView7 = (TextView) view.findViewById(R.id.tv_dialog_reservation_detail_sign_status);
                                    if (textView7 != null) {
                                        i = R.id.tv_dialog_reservation_detail_sign_status_tip;
                                        TextView textView8 = (TextView) view.findViewById(R.id.tv_dialog_reservation_detail_sign_status_tip);
                                        if (textView8 != null) {
                                            i = R.id.tv_dialog_reservation_detail_site_capacity;
                                            TextView textView9 = (TextView) view.findViewById(R.id.tv_dialog_reservation_detail_site_capacity);
                                            if (textView9 != null) {
                                                i = R.id.tv_dialog_reservation_detail_site_capacity_tip;
                                                TextView textView10 = (TextView) view.findViewById(R.id.tv_dialog_reservation_detail_site_capacity_tip);
                                                if (textView10 != null) {
                                                    i = R.id.tv_dialog_reservation_detail_site_device;
                                                    TextView textView11 = (TextView) view.findViewById(R.id.tv_dialog_reservation_detail_site_device);
                                                    if (textView11 != null) {
                                                        i = R.id.tv_dialog_reservation_detail_site_device_tip;
                                                        TextView textView12 = (TextView) view.findViewById(R.id.tv_dialog_reservation_detail_site_device_tip);
                                                        if (textView12 != null) {
                                                            i = R.id.tv_dialog_reservation_detail_site_location;
                                                            TextView textView13 = (TextView) view.findViewById(R.id.tv_dialog_reservation_detail_site_location);
                                                            if (textView13 != null) {
                                                                i = R.id.tv_dialog_reservation_detail_site_location_tip;
                                                                TextView textView14 = (TextView) view.findViewById(R.id.tv_dialog_reservation_detail_site_location_tip);
                                                                if (textView14 != null) {
                                                                    i = R.id.tv_dialog_reservation_detail_site_name;
                                                                    TextView textView15 = (TextView) view.findViewById(R.id.tv_dialog_reservation_detail_site_name);
                                                                    if (textView15 != null) {
                                                                        i = R.id.tv_dialog_reservation_detail_site_type;
                                                                        TextView textView16 = (TextView) view.findViewById(R.id.tv_dialog_reservation_detail_site_type);
                                                                        if (textView16 != null) {
                                                                            i = R.id.tv_dialog_reservation_detail_site_type_tip;
                                                                            TextView textView17 = (TextView) view.findViewById(R.id.tv_dialog_reservation_detail_site_type_tip);
                                                                            if (textView17 != null) {
                                                                                i = R.id.tv_dialog_reservation_detail_theme;
                                                                                TextView textView18 = (TextView) view.findViewById(R.id.tv_dialog_reservation_detail_theme);
                                                                                if (textView18 != null) {
                                                                                    i = R.id.tv_dialog_reservation_detail_time;
                                                                                    TextView textView19 = (TextView) view.findViewById(R.id.tv_dialog_reservation_detail_time);
                                                                                    if (textView19 != null) {
                                                                                        i = R.id.tv_dialog_reservation_detail_time_tip;
                                                                                        TextView textView20 = (TextView) view.findViewById(R.id.tv_dialog_reservation_detail_time_tip);
                                                                                        if (textView20 != null) {
                                                                                            i = R.id.tv_dialog_reservation_detail_title;
                                                                                            TextView textView21 = (TextView) view.findViewById(R.id.tv_dialog_reservation_detail_title);
                                                                                            if (textView21 != null) {
                                                                                                return new DialogReservationDetailBinding((NestedScrollView) view, constraintLayout, textView, textView2, textView3, textView4, textView5, textView6, textView7, textView8, textView9, textView10, textView11, textView12, textView13, textView14, textView15, textView16, textView17, textView18, textView19, textView20, textView21);
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
