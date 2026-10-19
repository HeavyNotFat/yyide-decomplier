package com.yd.android_brand_mvp.verfity.fragment;

import android.app.Activity;
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
import com.alibaba.fastjson.JSON;
import com.blankj.utilcode.util.LogUtils;
import com.blankj.utilcode.util.SPUtils;
import com.blankj.utilcode.util.ScreenUtils;
import com.yd.android_brand_mvp.R;
import com.yd.android_brand_mvp.base.BaseMvpFragment;
import com.yd.android_brand_mvp.base.ResultCodeStr;
import com.yd.android_brand_mvp.model.selectNewStudentByIcCardRsp;
import com.yd.android_brand_mvp.model.task.TaskVerifyBean;
import com.yd.android_brand_mvp.presenter.StudentToUserPresenter;
import com.yd.android_brand_mvp.user.UserCenterActivity;
import com.yd.android_brand_mvp.utils.SpData;
import com.yd.android_brand_mvp.utils.ToastUtil;
import com.yd.android_brand_mvp.utils.view.net.GsonUtils;
import com.yd.android_brand_mvp.verfity.FaceMsg;
import com.yd.android_brand_mvp.verfity.StudentCheackActivity;
import com.yd.android_brand_mvp.view.StudentToUserCardView;
import com.yd.android_brand_mvp.widget.FaceView;
import com.yyide.facepass.FaceManager;
import com.yyide.facepass.OnRecognizeCallback;
import com.yyide.facepass.bean.RecognizeResultBean;
import com.yyide.facepass.camera.CameraPreview;
import java.util.Iterator;
import java.util.List;
import mcv.facepass.types.FacePassFace;

/* JADX INFO: loaded from: classes4.dex */
public class FaceFragment extends BaseMvpFragment<StudentToUserPresenter> implements StudentToUserCardView {
    private static final String TAG = FaceFragment.class.getSimpleName();
    StudentCheackActivity activity;
    private CameraPreview cameraPreview;

    @BindView(R.id.faceView)
    FaceView faceView;

    @BindView(R.id.preview_parent)
    LinearLayout previewView;
    private Boolean isNeedJump = true;
    private boolean isFace = true;

    public static FaceFragment newInstance(Boolean bool) {
        FaceFragment faceFragment = new FaceFragment();
        Bundle bundle = new Bundle();
        bundle.putBoolean("needJump", bool.booleanValue());
        faceFragment.setArguments(bundle);
        return faceFragment;
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return ScreenUtils.isLandscape() ? layoutInflater.inflate(R.layout.fragment_face2, viewGroup, false) : layoutInflater.inflate(R.layout.fragment_face2_p, viewGroup, false);
    }

    @Override // com.yd.android_brand_mvp.base.BaseMvpFragment, com.yd.android_brand_mvp.base.BaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        ButterKnife.bind(this.mActivity);
        if (getArguments() != null) {
            this.isNeedJump = Boolean.valueOf(getArguments().getBoolean("needJump", true));
        }
        this.cameraPreview = new CameraPreview(getActivity());
        this.cameraPreview.setLayoutParams(new LinearLayout.LayoutParams(-1, -1));
        this.activity = (StudentCheackActivity) getActivity();
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
            FaceManager.INSTANCE.initFaceHandler(this.mActivity, this.cameraPreview, new OnRecognizeCallback() { // from class: com.yd.android_brand_mvp.verfity.fragment.FaceFragment.1
                @Override // com.yyide.facepass.OnRecognizeCallback
                public void onFaceRecognitionStatus(long j, int i) {
                }

                @Override // com.yyide.facepass.OnRecognizeCallback
                public void onFaceRecognizeError(String str) {
                }

                @Override // com.yyide.facepass.OnRecognizeCallback
                public void onFaceRecognizeSimple(RecognizeResultBean recognizeResultBean) {
                    if (SpData.isFaceEnable()) {
                        if (FaceFragment.this.activity.getIndex() == 1 && FaceFragment.this.isFace) {
                            LogUtils.i(GsonUtils.toJson(recognizeResultBean));
                            if (TextUtils.isEmpty(recognizeResultBean.getUserId())) {
                                ToastUtil.showBottomView(FaceFragment.this.mActivity, FaceMsg.FaceNO);
                                return;
                            } else if (FaceFragment.this.nomalLoadingDiallog == null || !FaceFragment.this.nomalLoadingDiallog.isShowing()) {
                                FaceFragment.this.showLoading();
                                ((StudentToUserPresenter) FaceFragment.this.mvpPresenter).StudentCardByFace(String.valueOf(recognizeResultBean.getUserId()));
                                return;
                            } else {
                                ToastUtil.showBottomView(FaceFragment.this.mActivity, FaceMsg.FaceWait);
                                return;
                            }
                        }
                        return;
                    }
                    LogUtils.i(FaceMsg.FaceEnable + GsonUtils.toJson(recognizeResultBean));
                    ToastUtil.showBottomView(FaceFragment.this.mActivity, FaceMsg.FaceEnable);
                }

                @Override // com.yyide.facepass.OnRecognizeCallback
                public void onFaceDismiss() {
                    FaceFragment.this.faceView.clear();
                    FaceFragment.this.faceView.invalidate();
                }

                @Override // com.yyide.facepass.OnRecognizeCallback
                public void onFaceDetect(List<FacePassFace> list) {
                    Iterator<FacePassFace> it2 = list.iterator();
                    while (it2.hasNext()) {
                        if (it2.next().facePassFeedFrameErrorCode == 7) {
                            ToastUtil.showBottomView(FaceFragment.this.mActivity, FaceMsg.FaceLight);
                        }
                    }
                    FaceFragment.this.faceView.showFacePassFace(list, FaceFragment.this.cameraPreview);
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

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.yd.android_brand_mvp.base.BaseMvpFragment
    public StudentToUserPresenter createPresenter() {
        return new StudentToUserPresenter(this);
    }

    @Override // com.yd.android_brand_mvp.view.StudentToUserCardView
    public void StudentCard(selectNewStudentByIcCardRsp selectnewstudentbyiccardrsp) {
        hideLoading();
        if (selectnewstudentbyiccardrsp.code == 0) {
            Log.e("TAG", "StudentCard: " + JSON.toJSONString(selectnewstudentbyiccardrsp));
            SPUtils.getInstance().put(SpData.USERCENT2, JSON.toJSONString(selectnewstudentbyiccardrsp));
            if (this.isNeedJump.booleanValue()) {
                startActivity(new Intent(this.mActivity, (Class<?>) UserCenterActivity.class));
            } else {
                Intent intent = new Intent();
                intent.putExtra(ResultCodeStr.NORMAL_TYPE_CODE, ResultCodeStr.TASK_SIGN_VERIFY);
                TaskVerifyBean taskVerifyBean = new TaskVerifyBean();
                if (selectnewstudentbyiccardrsp.data != null) {
                    taskVerifyBean.setUserId(selectnewstudentbyiccardrsp.data.id);
                    taskVerifyBean.setSchoolId(selectnewstudentbyiccardrsp.data.schoolId);
                    taskVerifyBean.setClassesId(selectnewstudentbyiccardrsp.data.classesId);
                }
                intent.putExtra(ResultCodeStr.TASK_SIGN_VERIFY_SUCCESS, taskVerifyBean);
                requireActivity().setResult(-1, intent);
            }
            requireActivity().finish();
            return;
        }
        ToastUtil.showBottomView((Activity) this.activity, selectnewstudentbyiccardrsp.message);
    }

    @Override // com.yd.android_brand_mvp.view.StudentToUserCardView
    public void StudentCardFail(String str) {
        hideLoading();
        ToastUtil.showBottomView(this.mActivity, "服务异常 " + str);
    }
}
