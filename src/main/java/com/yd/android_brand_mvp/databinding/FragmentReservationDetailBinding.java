package com.yd.android_brand_mvp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import com.yd.android_brand_mvp.R;
import com.yd.android_brand_mvp.widget.FaceView;
import com.yyide.facepass.camera.CameraPreview;

/* JADX INFO: loaded from: classes4.dex */
public final class FragmentReservationDetailBinding implements ViewBinding {
    public final Button btnFragmentReservationDetailCard;
    public final Button btnFragmentReservationDetailFace;
    public final CameraPreview cameraFragmentReservationDetailFace;
    public final ConstraintLayout clFragmentReservationDetailSign;
    public final ConstraintLayout clFragmentReservationDetailSignTop;
    public final ConstraintLayout clFragmentReservationDetailVerify;
    public final FaceView faceViewFragmentReservationDetailFace;
    public final ImageView ivCard;
    private final ConstraintLayout rootView;
    public final RecyclerView rvFragmentReservationDetailSign;
    public final TextView tvFragmentReservationDetailCount;
    public final TextView tvFragmentReservationDetailNotSign;
    public final TextView tvFragmentReservationDetailSign;
    public final TextView tvFragmentReservationDetailTheme;
    public final TextView tvFragmentReservationDetailTime;

    private FragmentReservationDetailBinding(ConstraintLayout constraintLayout, Button button, Button button2, CameraPreview cameraPreview, ConstraintLayout constraintLayout2, ConstraintLayout constraintLayout3, ConstraintLayout constraintLayout4, FaceView faceView, ImageView imageView, RecyclerView recyclerView, TextView textView, TextView textView2, TextView textView3, TextView textView4, TextView textView5) {
        this.rootView = constraintLayout;
        this.btnFragmentReservationDetailCard = button;
        this.btnFragmentReservationDetailFace = button2;
        this.cameraFragmentReservationDetailFace = cameraPreview;
        this.clFragmentReservationDetailSign = constraintLayout2;
        this.clFragmentReservationDetailSignTop = constraintLayout3;
        this.clFragmentReservationDetailVerify = constraintLayout4;
        this.faceViewFragmentReservationDetailFace = faceView;
        this.ivCard = imageView;
        this.rvFragmentReservationDetailSign = recyclerView;
        this.tvFragmentReservationDetailCount = textView;
        this.tvFragmentReservationDetailNotSign = textView2;
        this.tvFragmentReservationDetailSign = textView3;
        this.tvFragmentReservationDetailTheme = textView4;
        this.tvFragmentReservationDetailTime = textView5;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static FragmentReservationDetailBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static FragmentReservationDetailBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.fragment_reservation_detail, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static FragmentReservationDetailBinding bind(View view) {
        int i = R.id.btn_fragment_reservation_detail_card;
        Button button = (Button) view.findViewById(R.id.btn_fragment_reservation_detail_card);
        if (button != null) {
            i = R.id.btn_fragment_reservation_detail_face;
            Button button2 = (Button) view.findViewById(R.id.btn_fragment_reservation_detail_face);
            if (button2 != null) {
                i = R.id.camera_fragment_reservation_detail_face;
                CameraPreview cameraPreview = (CameraPreview) view.findViewById(R.id.camera_fragment_reservation_detail_face);
                if (cameraPreview != null) {
                    i = R.id.cl_fragment_reservation_detail_sign;
                    ConstraintLayout constraintLayout = (ConstraintLayout) view.findViewById(R.id.cl_fragment_reservation_detail_sign);
                    if (constraintLayout != null) {
                        i = R.id.cl_fragment_reservation_detail_sign_top;
                        ConstraintLayout constraintLayout2 = (ConstraintLayout) view.findViewById(R.id.cl_fragment_reservation_detail_sign_top);
                        if (constraintLayout2 != null) {
                            i = R.id.cl_fragment_reservation_detail_verify;
                            ConstraintLayout constraintLayout3 = (ConstraintLayout) view.findViewById(R.id.cl_fragment_reservation_detail_verify);
                            if (constraintLayout3 != null) {
                                i = R.id.faceView_fragment_reservation_detail_face;
                                FaceView faceView = (FaceView) view.findViewById(R.id.faceView_fragment_reservation_detail_face);
                                if (faceView != null) {
                                    i = R.id.ivCard;
                                    ImageView imageView = (ImageView) view.findViewById(R.id.ivCard);
                                    if (imageView != null) {
                                        i = R.id.rv_fragment_reservation_detail_sign;
                                        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.rv_fragment_reservation_detail_sign);
                                        if (recyclerView != null) {
                                            i = R.id.tv_fragment_reservation_detail_count;
                                            TextView textView = (TextView) view.findViewById(R.id.tv_fragment_reservation_detail_count);
                                            if (textView != null) {
                                                i = R.id.tv_fragment_reservation_detail_not_sign;
                                                TextView textView2 = (TextView) view.findViewById(R.id.tv_fragment_reservation_detail_not_sign);
                                                if (textView2 != null) {
                                                    i = R.id.tv_fragment_reservation_detail_sign;
                                                    TextView textView3 = (TextView) view.findViewById(R.id.tv_fragment_reservation_detail_sign);
                                                    if (textView3 != null) {
                                                        i = R.id.tv_fragment_reservation_detail_theme;
                                                        TextView textView4 = (TextView) view.findViewById(R.id.tv_fragment_reservation_detail_theme);
                                                        if (textView4 != null) {
                                                            i = R.id.tv_fragment_reservation_detail_time;
                                                            TextView textView5 = (TextView) view.findViewById(R.id.tv_fragment_reservation_detail_time);
                                                            if (textView5 != null) {
                                                                return new FragmentReservationDetailBinding((ConstraintLayout) view, button, button2, cameraPreview, constraintLayout, constraintLayout2, constraintLayout3, faceView, imageView, recyclerView, textView, textView2, textView3, textView4, textView5);
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
