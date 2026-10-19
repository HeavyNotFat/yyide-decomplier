package com.yd.android_brand_mvp.verfity.fragment;

import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.blankj.utilcode.util.LogUtils;
import com.yd.android_brand_mvp.R;
import com.yd.android_brand_mvp.base.BaseConstant;
import com.yd.android_brand_mvp.base.BaseMvpFragment;
import com.yd.android_brand_mvp.model.EventBean;
import com.yd.android_brand_mvp.model.UserIcCardBean;
import com.yd.android_brand_mvp.model.selectNewStudentByIcCardRsp;
import com.yd.android_brand_mvp.model.selectTeacherByIcCardRsp;
import com.yd.android_brand_mvp.presenter.CheackMsgPresenter;
import com.yd.android_brand_mvp.utils.ToastUtil;
import com.yd.android_brand_mvp.utils.view.net.GsonUtils;
import com.yd.android_brand_mvp.verfity.CheackNomalActivity;
import com.yd.android_brand_mvp.verfity.FaceMsg;
import com.yd.android_brand_mvp.view.CheackMsgView;
import com.yd.android_brand_mvp.widget.FaceView;
import com.yyide.facepass.FaceManager;
import com.yyide.facepass.OnRecognizeCallback;
import com.yyide.facepass.bean.RecognizeResultBean;
import com.yyide.facepass.camera.CameraPreview;
import com.yyide.facepass.database.DatabaseUtil;
import com.yyide.facepass.database.FacePeople;
import java.util.Iterator;
import java.util.List;
import mcv.facepass.types.FacePassFace;
import org.greenrobot.eventbus.EventBus;

/* JADX INFO: loaded from: classes4.dex */
public class FaceFragmentNomal extends BaseMvpFragment<CheackMsgPresenter> implements CheackMsgView {
    CheackNomalActivity activity;

    @BindView(R.id.camera)
    CameraPreview camera;

    @BindView(R.id.faceView)
    FaceView faceView;
    private final OnRecognizeCallback mOnRecognizeCallback = new OnRecognizeCallback() { // from class: com.yd.android_brand_mvp.verfity.fragment.FaceFragmentNomal.2
        @Override // com.yyide.facepass.OnRecognizeCallback
        public void onFaceRecognitionStatus(long j, int i) {
        }

        @Override // com.yyide.facepass.OnRecognizeCallback
        public void onFaceRecognizeError(String str) {
        }

        @Override // com.yyide.facepass.OnRecognizeCallback
        public void onFaceRecognizeSimple(RecognizeResultBean recognizeResultBean) {
            if (FaceFragmentNomal.this.activity.getIndex() == 1) {
                Log.e("TAG", "FACE_RECOGNITION_SIMPLE: ");
                LogUtils.i(GsonUtils.toJson(recognizeResultBean));
                if (TextUtils.isEmpty(recognizeResultBean.getUserId())) {
                    ToastUtil.showBottomView(FaceFragmentNomal.this.mActivity, FaceMsg.FaceNO);
                    return;
                }
                if (!FaceFragmentNomal.this.nomalLoadingDiallog.isShowing()) {
                    FacePeople faceByUserId = DatabaseUtil.INSTANCE.getFaceByUserId(FaceFragmentNomal.this.mActivity, recognizeResultBean.getUserId() + "");
                    if (faceByUserId != null) {
                        if ("3".equals(faceByUserId.getUserType())) {
                            ToastUtil.showBottomView(FaceFragmentNomal.this.requireContext(), FaceMsg.FaceExternalPersonnel);
                            return;
                        }
                        FaceFragmentNomal.this.showLoading();
                        if ("1".equals(faceByUserId.getUserType())) {
                            ((CheackMsgPresenter) FaceFragmentNomal.this.mvpPresenter).selectUserInfoByFace(faceByUserId.getUserType(), String.valueOf(recognizeResultBean.getUserId()));
                            return;
                        } else {
                            if ("2".equals(faceByUserId.getUserType())) {
                                ((CheackMsgPresenter) FaceFragmentNomal.this.mvpPresenter).selectTeacherByFace(faceByUserId.getUserType(), String.valueOf(recognizeResultBean.getUserId()));
                                return;
                            }
                            return;
                        }
                    }
                    return;
                }
                ToastUtil.showBottomView(FaceFragmentNomal.this.mActivity, FaceMsg.FaceWait);
            }
        }

        @Override // com.yyide.facepass.OnRecognizeCallback
        public void onFaceDismiss() {
            FaceFragmentNomal.this.faceView.clear();
            FaceFragmentNomal.this.faceView.invalidate();
        }

        @Override // com.yyide.facepass.OnRecognizeCallback
        public void onFaceDetect(List<FacePassFace> list) {
            Iterator<FacePassFace> it2 = list.iterator();
            while (it2.hasNext()) {
                if (it2.next().facePassFeedFrameErrorCode == 7) {
                    ToastUtil.showBottomView(FaceFragmentNomal.this.mActivity, FaceMsg.FaceLight);
                }
            }
            FaceFragmentNomal.this.faceView.showFacePassFace(list, FaceFragmentNomal.this.camera);
        }
    };

    @BindView(R.id.pm)
    TextView pm;

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return layoutInflater.inflate(R.layout.fragment_face, viewGroup, false);
    }

    @Override // com.yd.android_brand_mvp.base.BaseMvpFragment, com.yd.android_brand_mvp.base.BaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        ButterKnife.bind(this.mActivity);
        FaceManager.INSTANCE.initFaceHandler(this.mActivity, this.camera, this.mOnRecognizeCallback);
        Log.e("TAG", "注册人脸功能: ");
        this.pm.setVisibility(0);
        if (this.mActivity != null && !this.mActivity.isDestroyed()) {
            this.nomalLoadingDiallog.show();
        }
        new Handler().postDelayed(new Runnable() { // from class: com.yd.android_brand_mvp.verfity.fragment.FaceFragmentNomal.1
            @Override // java.lang.Runnable
            public void run() {
                FaceFragmentNomal.this.pm.setVisibility(8);
                if (FaceFragmentNomal.this.mActivity == null || FaceFragmentNomal.this.mActivity.isDestroyed()) {
                    return;
                }
                FaceFragmentNomal.this.nomalLoadingDiallog.dismiss();
            }
        }, 1500L);
        this.activity = (CheackNomalActivity) this.mActivity;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.yd.android_brand_mvp.base.BaseMvpFragment
    public CheackMsgPresenter createPresenter() {
        return new CheackMsgPresenter(this);
    }

    @Override // com.yd.android_brand_mvp.base.BaseMvpFragment, com.yd.android_brand_mvp.base.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        FaceManager.INSTANCE.onDestroyCamera();
        super.onDestroy();
    }

    @Override // com.yd.android_brand_mvp.view.CheackMsgView
    public void selectUserInfoByIcCard(UserIcCardBean userIcCardBean) {
        hideLoading();
        if (userIcCardBean.code == 0) {
            EventBus.getDefault().post(new EventBean(BaseConstant.CheackMsg, userIcCardBean.data.id, userIcCardBean.data.name, this.activity.type, this.activity.productionId, userIcCardBean.data.isStudent, userIcCardBean.data.identityId));
            getActivity().finish();
        } else {
            ToastUtil.showBottomView(this.mActivity, userIcCardBean.msg);
        }
    }

    @Override // com.yd.android_brand_mvp.view.CheackMsgView
    public void selectUserInfoByIcFace(selectNewStudentByIcCardRsp selectnewstudentbyiccardrsp) {
        hideLoading();
        if (selectnewstudentbyiccardrsp.code == 0) {
            EventBus.getDefault().post(new EventBean(BaseConstant.CheackMsg, selectnewstudentbyiccardrsp.data.id, selectnewstudentbyiccardrsp.data.name, this.activity.type, this.activity.productionId, selectnewstudentbyiccardrsp.data.isStudent, selectnewstudentbyiccardrsp.data.identityId));
            getActivity().finish();
        } else {
            ToastUtil.showBottomView(this.mActivity, selectnewstudentbyiccardrsp.message);
        }
    }

    @Override // com.yd.android_brand_mvp.view.CheackMsgView
    public void selectUserInfoByIcFace(selectTeacherByIcCardRsp selectteacherbyiccardrsp) {
        hideLoading();
        if (selectteacherbyiccardrsp.code.intValue() == 0 && selectteacherbyiccardrsp.data != null) {
            EventBus.getDefault().post(new EventBean(BaseConstant.CheackMsg, selectteacherbyiccardrsp.data.id + "", selectteacherbyiccardrsp.data.name, this.activity.type, this.activity.productionId, false, selectteacherbyiccardrsp.data.identityId));
            getActivity().finish();
            return;
        }
        ToastUtil.showBottomView(this.mActivity, selectteacherbyiccardrsp.message);
    }

    @Override // com.yd.android_brand_mvp.view.CheackMsgView
    public void selectUserInfoByIcCardFail(String str) {
        hideLoading();
        ToastUtil.showBottomView(this.mActivity, "服务异常 " + str);
    }
}
