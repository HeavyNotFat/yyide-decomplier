package com.yd.android_brand_mvp.verfity.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.blankj.utilcode.util.LogUtils;
import com.blankj.utilcode.util.ScreenUtils;
import com.blankj.utilcode.util.ToastUtils;
import com.yd.android_brand_mvp.R;
import com.yd.android_brand_mvp.SettingActivity;
import com.yd.android_brand_mvp.base.BaseConstant;
import com.yd.android_brand_mvp.base.BaseMvpFragment;
import com.yd.android_brand_mvp.model.EventBean;
import com.yd.android_brand_mvp.model.selectTeacherByClassesIdRsp;
import com.yd.android_brand_mvp.portrait.activity.SettingPActivity;
import com.yd.android_brand_mvp.presenter.TeacherToSettingPresenter;
import com.yd.android_brand_mvp.utils.SettingPermision;
import com.yd.android_brand_mvp.utils.SpData;
import com.yd.android_brand_mvp.utils.ToastUtil;
import com.yd.android_brand_mvp.utils.view.net.GsonUtils;
import com.yd.android_brand_mvp.verfity.FaceMsg;
import com.yd.android_brand_mvp.verfity.TeacherCheackActivity;
import com.yd.android_brand_mvp.view.TeacherToSettingCardView;
import com.yd.android_brand_mvp.widget.FaceView;
import com.yyide.facepass.FaceManager;
import com.yyide.facepass.OnRecognizeCallback;
import com.yyide.facepass.bean.RecognizeResultBean;
import com.yyide.facepass.camera.CameraPreview;
import java.util.Iterator;
import java.util.List;
import mcv.facepass.types.FacePassFace;
import org.greenrobot.eventbus.EventBus;

/* JADX INFO: loaded from: classes4.dex */
public class FaceFragment3 extends BaseMvpFragment<TeacherToSettingPresenter> implements TeacherToSettingCardView {
    TeacherCheackActivity activity;
    private CameraPreview cameraPreview;
    private String faceId;

    @BindView(R.id.faceView)
    FaceView faceView;
    private boolean isFace = true;

    @BindView(R.id.preview_parent)
    LinearLayout previewView;
    private String userName;

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        if (ScreenUtils.isLandscape()) {
            return layoutInflater.inflate(R.layout.fragment_face2, viewGroup, false);
        }
        return layoutInflater.inflate(R.layout.fragment_face2_p, viewGroup, false);
    }

    @Override // com.yd.android_brand_mvp.base.BaseMvpFragment, com.yd.android_brand_mvp.base.BaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        ButterKnife.bind(this.mActivity);
        Log.e("TAG", "注册人脸功能: ");
        this.cameraPreview = new CameraPreview(getActivity());
        this.cameraPreview.setLayoutParams(new LinearLayout.LayoutParams(-1, -1));
        this.activity = (TeacherCheackActivity) getActivity();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.yd.android_brand_mvp.base.BaseMvpFragment
    public TeacherToSettingPresenter createPresenter() {
        return new TeacherToSettingPresenter(this);
    }

    void startAc() {
        if (ScreenUtils.isLandscape()) {
            startActivity(new Intent(this.mActivity, (Class<?>) SettingActivity.class));
        } else {
            startActivity(new Intent(this.mActivity, (Class<?>) SettingPActivity.class));
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onHiddenChanged(boolean z) {
        super.onHiddenChanged(z);
        this.isFace = !z;
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        initFace();
    }

    @Override // androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        stopFace();
    }

    private void initFace() {
        try {
            this.previewView.removeView(this.cameraPreview);
            this.previewView.addView(this.cameraPreview);
            FaceManager.INSTANCE.initFaceHandler(getActivity(), this.cameraPreview, new OnRecognizeCallback() { // from class: com.yd.android_brand_mvp.verfity.fragment.FaceFragment3.1
                @Override // com.yyide.facepass.OnRecognizeCallback
                public void onFaceRecognitionStatus(long j, int i) {
                }

                @Override // com.yyide.facepass.OnRecognizeCallback
                public void onFaceRecognizeError(String str) {
                }

                @Override // com.yyide.facepass.OnRecognizeCallback
                public void onFaceRecognizeSimple(RecognizeResultBean recognizeResultBean) {
                    if (SpData.isFaceEnable()) {
                        if (FaceFragment3.this.activity.getIndex() == 1) {
                            LogUtils.i("Fragment3 = " + GsonUtils.toJson(recognizeResultBean));
                            FaceFragment3.this.faceId = String.valueOf(recognizeResultBean.getUserId());
                            FaceFragment3.this.userName = recognizeResultBean.getUserName();
                            if (TextUtils.isEmpty(recognizeResultBean.getUserId())) {
                                ToastUtil.showBottomView(FaceFragment3.this.mActivity, FaceMsg.FaceNO);
                                return;
                            } else {
                                FaceFragment3.this.showLoading();
                                ((TeacherToSettingPresenter) FaceFragment3.this.mvpPresenter).selectTeacherByClassesId(FaceFragment3.this.faceId, "");
                                return;
                            }
                        }
                        return;
                    }
                    ToastUtil.showBottomView(FaceFragment3.this.mActivity, FaceMsg.FaceEnable);
                }

                @Override // com.yyide.facepass.OnRecognizeCallback
                public void onFaceDismiss() {
                    FaceFragment3.this.faceView.clear();
                    FaceFragment3.this.faceView.invalidate();
                }

                @Override // com.yyide.facepass.OnRecognizeCallback
                public void onFaceDetect(List<FacePassFace> list) {
                    Iterator<FacePassFace> it2 = list.iterator();
                    while (it2.hasNext()) {
                        if (it2.next().facePassFeedFrameErrorCode == 7) {
                            ToastUtil.showBottomView(FaceFragment3.this.mActivity, FaceMsg.FaceLight);
                        }
                    }
                    FaceFragment3.this.faceView.showFacePassFace(list, FaceFragment3.this.cameraPreview);
                }
            });
        } catch (Exception e) {
            LogUtils.i("initFace init:" + e.getMessage());
            e.printStackTrace();
        }
    }

    private void stopFace() {
        try {
            this.previewView.removeView(this.cameraPreview);
            FaceManager.INSTANCE.onDestroyCamera();
        } catch (Exception e) {
            LogUtils.i("initFace stop:" + e.getMessage());
        }
    }

    @Override // com.yd.android_brand_mvp.view.TeacherToSettingCardView
    public void selectTeacherByClassesIdRspSuccess(selectTeacherByClassesIdRsp selectteacherbyclassesidrsp) {
        hideLoading();
        if (selectteacherbyclassesidrsp.code.intValue() == 0) {
            if (!selectteacherbyclassesidrsp.data.isEmpty()) {
                int intExtra = getActivity().getIntent().getIntExtra("type", 0);
                if (intExtra == BaseConstant.homeOver) {
                    EventBus.getDefault().post(new EventBean(intExtra, selectteacherbyclassesidrsp.data.get(0).id, selectteacherbyclassesidrsp.data.get(0).name));
                    getActivity().finish();
                    return;
                } else {
                    startAc();
                    getActivity().finish();
                    return;
                }
            }
            ToastUtil.showBottomView(this.mActivity, FaceMsg.no_permission);
            return;
        }
        ToastUtils.showShort("验证失败");
    }

    @Override // com.yd.android_brand_mvp.view.TeacherToSettingCardView
    public void selectTeacherByClassesIdRspFail(String str) {
        hideLoading();
        onlineVerify(str);
    }

    private void onlineVerify(String str) {
        if (SettingPermision.getInstance().isHavePermissionByFace(this.faceId)) {
            selectTeacherByClassesIdRsp.DataDTO dataDTO = SettingPermision.getInstance().mDataDTO;
            int intExtra = getActivity().getIntent().getIntExtra("type", 0);
            if (intExtra != BaseConstant.homeOver) {
                startAc();
                getActivity().finish();
                return;
            } else if (dataDTO != null) {
                EventBus.getDefault().post(new EventBean(intExtra, dataDTO.id, dataDTO.name));
                getActivity().finish();
                return;
            } else {
                ToastUtil.showBottomView(this.mActivity, FaceMsg.no_permission);
                return;
            }
        }
        ToastUtils.showShort(str);
    }
}
