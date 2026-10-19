package com.yd.android_brand_mvp.verfity.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.blankj.utilcode.util.LogUtils;
import com.blankj.utilcode.util.SPUtils;
import com.blankj.utilcode.util.ScreenUtils;
import com.blankj.utilcode.util.ToastUtils;
import com.yd.android_brand_mvp.R;
import com.yd.android_brand_mvp.SettingActivity;
import com.yd.android_brand_mvp.base.BaseConstant;
import com.yd.android_brand_mvp.base.BaseMvpFragment;
import com.yd.android_brand_mvp.base.ValidationConstant;
import com.yd.android_brand_mvp.brand.BroCast;
import com.yd.android_brand_mvp.landscape.Wlkz2_2L;
import com.yd.android_brand_mvp.model.EventBean;
import com.yd.android_brand_mvp.model.IdentityBean;
import com.yd.android_brand_mvp.model.selectTeacherByClassesIdRsp;
import com.yd.android_brand_mvp.portrait.activity.SettingPActivity;
import com.yd.android_brand_mvp.presenter.TeacherToSettingPresenter;
import com.yd.android_brand_mvp.utils.SettingPermision;
import com.yd.android_brand_mvp.utils.SpData;
import com.yd.android_brand_mvp.utils.StudentPermision;
import com.yd.android_brand_mvp.utils.ToastUtil;
import com.yd.android_brand_mvp.utils.view.net.GsonUtils;
import com.yd.android_brand_mvp.verfity.FaceMsg;
import com.yd.android_brand_mvp.verfity.TeacherCheackActivity2;
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
public class FaceFragment4 extends BaseMvpFragment<TeacherToSettingPresenter> implements TeacherToSettingCardView {
    TeacherCheackActivity2 activity;
    private CameraPreview cameraPreview;
    String faceId;

    @BindView(R.id.faceView)
    FaceView faceView;
    private boolean isFace = true;

    @BindView(R.id.preview_parent)
    LinearLayout previewView;

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
        this.cameraPreview = new CameraPreview(getActivity());
        this.cameraPreview = new CameraPreview(getActivity());
        this.cameraPreview.setLayoutParams(new LinearLayout.LayoutParams(-1, -1));
        this.activity = (TeacherCheackActivity2) getActivity();
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
            FaceManager.INSTANCE.initFaceHandler(getActivity(), this.cameraPreview, new OnRecognizeCallback() { // from class: com.yd.android_brand_mvp.verfity.fragment.FaceFragment4.1
                @Override // com.yyide.facepass.OnRecognizeCallback
                public void onFaceRecognitionStatus(long j, int i) {
                }

                @Override // com.yyide.facepass.OnRecognizeCallback
                public void onFaceRecognizeError(String str) {
                }

                @Override // com.yyide.facepass.OnRecognizeCallback
                public void onFaceRecognizeSimple(RecognizeResultBean recognizeResultBean) {
                    if (SpData.isFaceEnable()) {
                        if (FaceFragment4.this.activity.getIndex() == 1 && FaceFragment4.this.isFace) {
                            LogUtils.i(GsonUtils.toJson(recognizeResultBean));
                            FaceFragment4.this.faceId = String.valueOf(recognizeResultBean.getUserId());
                            if (TextUtils.isEmpty(recognizeResultBean.getUserId())) {
                                ToastUtil.showBottomView(FaceFragment4.this.mActivity, FaceMsg.FaceNO);
                                return;
                            }
                            if (BaseConstant.BlueToothLock) {
                                BroCast.open(FaceFragment4.this.mActivity);
                            }
                            if (SettingPermision.getInstance().isHavePermissionByFace(FaceFragment4.this.faceId) || StudentPermision.getInstance().isHavePermission("", FaceFragment4.this.faceId)) {
                                String string = SPUtils.getInstance().getString(SpData.VERTIFY_TYPE);
                                IdentityBean permissionIdentityInfo = SettingPermision.getInstance().getPermissionIdentityInfo(FaceFragment4.this.faceId);
                                if (ValidationConstant.STUDENT_COMMENT.equals(string)) {
                                    if (permissionIdentityInfo != null) {
                                        EventBus.getDefault().post(permissionIdentityInfo);
                                    }
                                } else if (!ValidationConstant.HTML_OPEN_API.equals(string)) {
                                    Intent intent = FaceFragment4.this.mActivity.getIntent();
                                    int intExtra = intent != null ? intent.getIntExtra("type", 0) : 0;
                                    Bundle bundle = new Bundle();
                                    bundle.putInt("type", intExtra);
                                    Intent intent2 = new Intent(Wlkz2_2L.SUO);
                                    intent2.putExtras(bundle);
                                    FaceFragment4.this.mActivity.sendBroadcast(intent2);
                                } else if (permissionIdentityInfo != null) {
                                    EventBus.getDefault().post(new EventBean(10001, permissionIdentityInfo.getIdentityId(), permissionIdentityInfo.getIdentityName()));
                                }
                                ToastUtil.showBottomView(FaceFragment4.this.mActivity, "识别成功");
                                FaceFragment4.this.getActivity().finish();
                                return;
                            }
                            ToastUtil.showBottomView(FaceFragment4.this.mActivity, FaceMsg.no_permission);
                            return;
                        }
                        return;
                    }
                    ToastUtil.showBottomView(FaceFragment4.this.mActivity, FaceMsg.FaceEnable);
                }

                @Override // com.yyide.facepass.OnRecognizeCallback
                public void onFaceDismiss() {
                    FaceFragment4.this.faceView.clear();
                    FaceFragment4.this.faceView.invalidate();
                }

                @Override // com.yyide.facepass.OnRecognizeCallback
                public void onFaceDetect(List<FacePassFace> list) {
                    Iterator<FacePassFace> it2 = list.iterator();
                    while (it2.hasNext()) {
                        if (it2.next().facePassFeedFrameErrorCode == 7) {
                            ToastUtil.showBottomView(FaceFragment4.this.mActivity, FaceMsg.FaceLight);
                        }
                    }
                    FaceFragment4.this.faceView.showFacePassFace(list, FaceFragment4.this.cameraPreview);
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
        if (selectteacherbyclassesidrsp.code.intValue() == BaseConstant.REQUEST_SUCCES2) {
            if (selectteacherbyclassesidrsp.data.size() > 0) {
                startAc();
                getActivity().finish();
                return;
            } else {
                ToastUtil.showBottomView(this.mActivity, "未找到相应人员");
                return;
            }
        }
        ToastUtils.showShort("验证失败");
    }

    @Override // com.yd.android_brand_mvp.view.TeacherToSettingCardView
    public void selectTeacherByClassesIdRspFail(String str) {
        hideLoading();
        if (SettingPermision.getInstance().isHavePermissionByFace(this.faceId)) {
            startAc();
            getActivity().finish();
            return;
        }
        ToastUtil.showBottomView(this.mActivity, "服务异常 " + str);
    }
}
