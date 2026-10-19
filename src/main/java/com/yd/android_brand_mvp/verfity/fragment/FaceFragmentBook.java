package com.yd.android_brand_mvp.verfity.fragment;

import android.content.Intent;
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
import com.alibaba.fastjson.JSON;
import com.blankj.utilcode.util.LogUtils;
import com.blankj.utilcode.util.ToastUtils;
import com.yd.android_brand_mvp.R;
import com.yd.android_brand_mvp.WebActivity;
import com.yd.android_brand_mvp.base.BaseMvpFragment;
import com.yd.android_brand_mvp.model.selectNewStudentByIcCardRsp;
import com.yd.android_brand_mvp.presenter.StudentToUserPresenter;
import com.yd.android_brand_mvp.utils.SpData;
import com.yd.android_brand_mvp.utils.ToastUtil;
import com.yd.android_brand_mvp.utils.view.net.GsonUtils;
import com.yd.android_brand_mvp.verfity.FaceMsg;
import com.yd.android_brand_mvp.verfity.StudentCheackActivity2;
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
public class FaceFragmentBook extends BaseMvpFragment<StudentToUserPresenter> implements StudentToUserCardView {
    private static final String TAG = "FaceFragment";
    StudentCheackActivity2 activity;

    @BindView(R.id.camera)
    CameraPreview camera;

    @BindView(R.id.faceView)
    FaceView faceView;

    @BindView(R.id.pm)
    TextView pm;
    String url = "https://scyd.flyread.com.cn/";
    private final OnRecognizeCallback mOnRecognizeCallback = new OnRecognizeCallback() { // from class: com.yd.android_brand_mvp.verfity.fragment.FaceFragmentBook.2
        @Override // com.yyide.facepass.OnRecognizeCallback
        public void onFaceRecognitionStatus(long j, int i) {
        }

        @Override // com.yyide.facepass.OnRecognizeCallback
        public void onFaceRecognizeError(String str) {
        }

        @Override // com.yyide.facepass.OnRecognizeCallback
        public void onFaceRecognizeSimple(RecognizeResultBean recognizeResultBean) {
            if (SpData.isFaceEnable()) {
                if (FaceFragmentBook.this.activity.getIndex() == 1) {
                    LogUtils.i(GsonUtils.toJson(recognizeResultBean));
                    if (TextUtils.isEmpty(recognizeResultBean.getUserId())) {
                        ToastUtil.showBottomView(FaceFragmentBook.this.mActivity, FaceMsg.FaceNO);
                        return;
                    } else if (FaceFragmentBook.this.nomalLoadingDiallog == null || !FaceFragmentBook.this.nomalLoadingDiallog.isShowing()) {
                        FaceFragmentBook.this.showLoading();
                        ((StudentToUserPresenter) FaceFragmentBook.this.mvpPresenter).StudentCardByFace(String.valueOf(recognizeResultBean.getUserId()));
                        return;
                    } else {
                        ToastUtil.showBottomView(FaceFragmentBook.this.mActivity, FaceMsg.FaceWait);
                        return;
                    }
                }
                return;
            }
            ToastUtil.showBottomView(FaceFragmentBook.this.mActivity, FaceMsg.FaceEnable);
        }

        @Override // com.yyide.facepass.OnRecognizeCallback
        public void onFaceDismiss() {
            FaceFragmentBook.this.faceView.clear();
            FaceFragmentBook.this.faceView.invalidate();
        }

        @Override // com.yyide.facepass.OnRecognizeCallback
        public void onFaceDetect(List<FacePassFace> list) {
            Iterator<FacePassFace> it2 = list.iterator();
            while (it2.hasNext()) {
                if (it2.next().facePassFeedFrameErrorCode == 7) {
                    ToastUtil.showBottomView(FaceFragmentBook.this.mActivity, FaceMsg.FaceLight);
                }
            }
            FaceFragmentBook.this.faceView.showFacePassFace(list, FaceFragmentBook.this.camera);
        }
    };

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return layoutInflater.inflate(R.layout.fragment_face, viewGroup, false);
    }

    @Override // com.yd.android_brand_mvp.base.BaseMvpFragment, com.yd.android_brand_mvp.base.BaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        ButterKnife.bind(this.mActivity);
        FaceManager.INSTANCE.initFaceHandler(this.mActivity, this.camera, this.mOnRecognizeCallback);
        Log.e(TAG, "--注册人脸功能--");
        this.pm.setVisibility(0);
        if (this.mActivity != null && !this.mActivity.isDestroyed()) {
            this.nomalLoadingDiallog.show();
        }
        new Handler().postDelayed(new Runnable() { // from class: com.yd.android_brand_mvp.verfity.fragment.FaceFragmentBook.1
            @Override // java.lang.Runnable
            public void run() {
                if (FaceFragmentBook.this.mActivity != null && !FaceFragmentBook.this.mActivity.isDestroyed()) {
                    FaceFragmentBook.this.nomalLoadingDiallog.dismiss();
                }
                FaceFragmentBook.this.pm.setVisibility(8);
            }
        }, 1500L);
        this.activity = (StudentCheackActivity2) getActivity();
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        Log.e(TAG, "onResume: ");
    }

    @Override // androidx.fragment.app.Fragment
    public void onHiddenChanged(boolean z) {
        super.onHiddenChanged(z);
        Log.e(TAG, "onHiddenChanged: " + z);
        if (!z) {
            FaceManager.INSTANCE.initFaceHandler(this.mActivity, this.camera, this.mOnRecognizeCallback);
            Log.e(TAG, "注册人脸功能");
        } else {
            FaceManager.INSTANCE.onDestroyCamera();
            this.camera.clearFocus();
            Log.e(TAG, "注销人脸功能");
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.yd.android_brand_mvp.base.BaseMvpFragment
    public StudentToUserPresenter createPresenter() {
        return new StudentToUserPresenter(this);
    }

    @Override // com.yd.android_brand_mvp.base.BaseMvpFragment, com.yd.android_brand_mvp.base.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        FaceManager.INSTANCE.onDestroyCamera();
        super.onDestroy();
    }

    @Override // com.yd.android_brand_mvp.view.StudentToUserCardView
    public void StudentCard(selectNewStudentByIcCardRsp selectnewstudentbyiccardrsp) {
        hideLoading();
        if (selectnewstudentbyiccardrsp.code == 0) {
            Log.e("TAG", "StudentCard: " + JSON.toJSONString(selectnewstudentbyiccardrsp));
            String strValueOf = String.valueOf(selectnewstudentbyiccardrsp.data.id);
            Intent intent = new Intent();
            intent.putExtra(WebActivity.URLEXTRA, this.url);
            intent.putExtra(WebActivity.ID, strValueOf);
            intent.putExtra(WebActivity.TITLEEXTRA, "");
            intent.setClass(this.mActivity, WebActivity.class);
            startActivity(intent);
            getActivity().finish();
            return;
        }
        ToastUtils.showShort("服务接口异常");
    }

    @Override // com.yd.android_brand_mvp.view.StudentToUserCardView
    public void StudentCardFail(String str) {
        hideLoading();
        ToastUtil.showBottomView(this.mActivity, "服务异常 " + str);
    }
}
