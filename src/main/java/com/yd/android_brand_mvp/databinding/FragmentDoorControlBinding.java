package com.yd.android_brand_mvp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Group;
import androidx.viewbinding.ViewBinding;
import com.yd.android_brand_mvp.R;
import com.yd.android_brand_mvp.widget.FaceView;
import com.yd.android_brand_mvp.widget.YDEditText;

/* JADX INFO: loaded from: classes4.dex */
public final class FragmentDoorControlBinding implements ViewBinding {
    public final Button btnClose;
    public final Button btnFail;
    public final Button btnFragmentDoorControlAccount;
    public final Button btnFragmentDoorControlCard;
    public final Button btnFragmentDoorControlFace;
    public final ConstraintLayout clFragmentDoorControl;
    public final ConstraintLayout clFragmentDoorControlAccount;
    public final ConstraintLayout clLoginFail;
    public final ConstraintLayout clLoginSuccess;
    public final FaceView faceViewFragmentDoorControl;
    public final Group groupFragmentDoorControl;
    public final ImageView ivFragmentDoorControlCard;
    public final ImageView ivFragmentDoorControlTip;
    public final ImageView ivIcon;
    public final ImageView ivIconFail;
    public final LinearLayoutCompat llBtn;
    public final TextView login;
    public final LinearLayoutCompat previewParent;
    public final YDEditText pwd;
    private final ConstraintLayout rootView;
    public final TextView tvFragmentDoorControlTip;
    public final TextView tvReveal;
    public final TextView tvTip;
    public final TextView tvTipMessage;
    public final TextView tvTipMessageFail;
    public final YDEditText user;

    private FragmentDoorControlBinding(ConstraintLayout constraintLayout, Button button, Button button2, Button button3, Button button4, Button button5, ConstraintLayout constraintLayout2, ConstraintLayout constraintLayout3, ConstraintLayout constraintLayout4, ConstraintLayout constraintLayout5, FaceView faceView, Group group, ImageView imageView, ImageView imageView2, ImageView imageView3, ImageView imageView4, LinearLayoutCompat linearLayoutCompat, TextView textView, LinearLayoutCompat linearLayoutCompat2, YDEditText yDEditText, TextView textView2, TextView textView3, TextView textView4, TextView textView5, TextView textView6, YDEditText yDEditText2) {
        this.rootView = constraintLayout;
        this.btnClose = button;
        this.btnFail = button2;
        this.btnFragmentDoorControlAccount = button3;
        this.btnFragmentDoorControlCard = button4;
        this.btnFragmentDoorControlFace = button5;
        this.clFragmentDoorControl = constraintLayout2;
        this.clFragmentDoorControlAccount = constraintLayout3;
        this.clLoginFail = constraintLayout4;
        this.clLoginSuccess = constraintLayout5;
        this.faceViewFragmentDoorControl = faceView;
        this.groupFragmentDoorControl = group;
        this.ivFragmentDoorControlCard = imageView;
        this.ivFragmentDoorControlTip = imageView2;
        this.ivIcon = imageView3;
        this.ivIconFail = imageView4;
        this.llBtn = linearLayoutCompat;
        this.login = textView;
        this.previewParent = linearLayoutCompat2;
        this.pwd = yDEditText;
        this.tvFragmentDoorControlTip = textView2;
        this.tvReveal = textView3;
        this.tvTip = textView4;
        this.tvTipMessage = textView5;
        this.tvTipMessageFail = textView6;
        this.user = yDEditText2;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static FragmentDoorControlBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static FragmentDoorControlBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.fragment_door_control, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static FragmentDoorControlBinding bind(View view) {
        int i = R.id.btnClose;
        Button button = (Button) view.findViewById(R.id.btnClose);
        if (button != null) {
            i = R.id.btnFail;
            Button button2 = (Button) view.findViewById(R.id.btnFail);
            if (button2 != null) {
                i = R.id.btn_fragment_door_control_account;
                Button button3 = (Button) view.findViewById(R.id.btn_fragment_door_control_account);
                if (button3 != null) {
                    i = R.id.btn_fragment_door_control_card;
                    Button button4 = (Button) view.findViewById(R.id.btn_fragment_door_control_card);
                    if (button4 != null) {
                        i = R.id.btn_fragment_door_control_face;
                        Button button5 = (Button) view.findViewById(R.id.btn_fragment_door_control_face);
                        if (button5 != null) {
                            i = R.id.cl_fragment_door_control;
                            ConstraintLayout constraintLayout = (ConstraintLayout) view.findViewById(R.id.cl_fragment_door_control);
                            if (constraintLayout != null) {
                                i = R.id.cl_fragment_door_control_account;
                                ConstraintLayout constraintLayout2 = (ConstraintLayout) view.findViewById(R.id.cl_fragment_door_control_account);
                                if (constraintLayout2 != null) {
                                    i = R.id.clLoginFail;
                                    ConstraintLayout constraintLayout3 = (ConstraintLayout) view.findViewById(R.id.clLoginFail);
                                    if (constraintLayout3 != null) {
                                        i = R.id.clLoginSuccess;
                                        ConstraintLayout constraintLayout4 = (ConstraintLayout) view.findViewById(R.id.clLoginSuccess);
                                        if (constraintLayout4 != null) {
                                            i = R.id.faceView_fragment_door_control;
                                            FaceView faceView = (FaceView) view.findViewById(R.id.faceView_fragment_door_control);
                                            if (faceView != null) {
                                                i = R.id.group_fragment_door_control;
                                                Group group = (Group) view.findViewById(R.id.group_fragment_door_control);
                                                if (group != null) {
                                                    i = R.id.iv_fragment_door_control_card;
                                                    ImageView imageView = (ImageView) view.findViewById(R.id.iv_fragment_door_control_card);
                                                    if (imageView != null) {
                                                        i = R.id.iv_fragment_door_control_tip;
                                                        ImageView imageView2 = (ImageView) view.findViewById(R.id.iv_fragment_door_control_tip);
                                                        if (imageView2 != null) {
                                                            i = R.id.ivIcon;
                                                            ImageView imageView3 = (ImageView) view.findViewById(R.id.ivIcon);
                                                            if (imageView3 != null) {
                                                                i = R.id.ivIconFail;
                                                                ImageView imageView4 = (ImageView) view.findViewById(R.id.ivIconFail);
                                                                if (imageView4 != null) {
                                                                    i = R.id.llBtn;
                                                                    LinearLayoutCompat linearLayoutCompat = (LinearLayoutCompat) view.findViewById(R.id.llBtn);
                                                                    if (linearLayoutCompat != null) {
                                                                        i = R.id.login;
                                                                        TextView textView = (TextView) view.findViewById(R.id.login);
                                                                        if (textView != null) {
                                                                            i = R.id.preview_parent;
                                                                            LinearLayoutCompat linearLayoutCompat2 = (LinearLayoutCompat) view.findViewById(R.id.preview_parent);
                                                                            if (linearLayoutCompat2 != null) {
                                                                                i = R.id.pwd;
                                                                                YDEditText yDEditText = (YDEditText) view.findViewById(R.id.pwd);
                                                                                if (yDEditText != null) {
                                                                                    i = R.id.tv_fragment_door_control_tip;
                                                                                    TextView textView2 = (TextView) view.findViewById(R.id.tv_fragment_door_control_tip);
                                                                                    if (textView2 != null) {
                                                                                        i = R.id.tvReveal;
                                                                                        TextView textView3 = (TextView) view.findViewById(R.id.tvReveal);
                                                                                        if (textView3 != null) {
                                                                                            i = R.id.tvTip;
                                                                                            TextView textView4 = (TextView) view.findViewById(R.id.tvTip);
                                                                                            if (textView4 != null) {
                                                                                                i = R.id.tvTipMessage;
                                                                                                TextView textView5 = (TextView) view.findViewById(R.id.tvTipMessage);
                                                                                                if (textView5 != null) {
                                                                                                    i = R.id.tvTipMessageFail;
                                                                                                    TextView textView6 = (TextView) view.findViewById(R.id.tvTipMessageFail);
                                                                                                    if (textView6 != null) {
                                                                                                        i = R.id.user;
                                                                                                        YDEditText yDEditText2 = (YDEditText) view.findViewById(R.id.user);
                                                                                                        if (yDEditText2 != null) {
                                                                                                            return new FragmentDoorControlBinding((ConstraintLayout) view, button, button2, button3, button4, button5, constraintLayout, constraintLayout2, constraintLayout3, constraintLayout4, faceView, group, imageView, imageView2, imageView3, imageView4, linearLayoutCompat, textView, linearLayoutCompat2, yDEditText, textView2, textView3, textView4, textView5, textView6, yDEditText2);
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
