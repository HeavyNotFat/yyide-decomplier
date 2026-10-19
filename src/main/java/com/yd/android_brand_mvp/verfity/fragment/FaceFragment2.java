package com.yd.android_brand_mvp.verfity.fragment;

import android.os.Bundle;
import android.os.Handler;
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
import com.yd.android_brand_mvp.R;
import com.yd.android_brand_mvp.base.BaseFragment;
import com.yd.android_brand_mvp.model.GeneralBean;
import com.yd.android_brand_mvp.utils.AttendanceUtils;
import com.yd.android_brand_mvp.utils.SpData;
import com.yd.android_brand_mvp.utils.ToastUtil;
import com.yd.android_brand_mvp.utils.view.net.GsonUtils;
import com.yd.android_brand_mvp.verfity.FaceMsg;
import com.yd.android_brand_mvp.widget.FaceView;
import com.yyide.facepass.FaceManager;
import com.yyide.facepass.OnRecognizeCallback;
import com.yyide.facepass.bean.RecognizeResultBean;
import com.yyide.facepass.camera.CameraPreview;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import mcv.facepass.types.FacePassFace;

/* JADX INFO: loaded from: classes4.dex */
public class FaceFragment2 extends BaseFragment {
    private CameraPreview cameraPreview;

    @BindView(R.id.faceView)
    FaceView faceView;

    @BindView(R.id.preview_parent)
    LinearLayout previewView;
    public GeneralBean databean = new GeneralBean();
    private final Handler mHandler = new Handler();
    private final List<Long> traceIds = new ArrayList();
    private boolean isFace = true;

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        if (ScreenUtils.isLandscape()) {
            return layoutInflater.inflate(R.layout.fragment_face_no_tip, viewGroup, false);
        }
        return layoutInflater.inflate(R.layout.fragment_face2_p, viewGroup, false);
    }

    @Override // com.yd.android_brand_mvp.base.BaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        ButterKnife.bind(this.mActivity);
        this.cameraPreview = new CameraPreview(getActivity());
        this.cameraPreview.setLayoutParams(new LinearLayout.LayoutParams(-1, -1));
        Log.e("TAG", "注册人脸功能: ");
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

    @Override // com.yd.android_brand_mvp.base.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
    }

    private void initFace() {
        try {
            this.previewView.removeView(this.cameraPreview);
            this.previewView.addView(this.cameraPreview);
            FaceManager.INSTANCE.initFaceHandler(requireActivity(), this.cameraPreview, new AnonymousClass1());
        } catch (Exception e) {
            LogUtils.i("initFace init:" + e.getMessage());
            e.printStackTrace();
        }
    }

    /* JADX INFO: renamed from: com.yd.android_brand_mvp.verfity.fragment.FaceFragment2$1, reason: invalid class name */
    class AnonymousClass1 implements OnRecognizeCallback {
        @Override // com.yyide.facepass.OnRecognizeCallback
        public void onFaceRecognitionStatus(long j, int i) {
        }

        @Override // com.yyide.facepass.OnRecognizeCallback
        public void onFaceRecognizeError(String str) {
        }

        AnonymousClass1() {
        }

        @Override // com.yyide.facepass.OnRecognizeCallback
        public void onFaceRecognizeSimple(final RecognizeResultBean recognizeResultBean) {
            if (SpData.isFaceEnable()) {
                if (FaceFragment2.this.isFace) {
                    FaceFragment2.this.mHandler.postDelayed(new Runnable() { // from class: com.yd.android_brand_mvp.verfity.fragment.-$$Lambda$FaceFragment2$1$pspUh9Vczr_hLXnZ-h9qZYiYINQ
                        @Override // java.lang.Runnable
                        public final void run() {
                            this.f$0.lambda$onFaceRecognizeSimple$0$FaceFragment2$1(recognizeResultBean);
                        }
                    }, 1000L);
                    return;
                }
                return;
            }
            ToastUtil.showView(FaceFragment2.this.mActivity, FaceMsg.FaceEnable);
        }

        public /* synthetic */ void lambda$onFaceRecognizeSimple$0$FaceFragment2$1(RecognizeResultBean recognizeResultBean) {
            LogUtils.i("考勤 = " + GsonUtils.toJson(recognizeResultBean));
            if (TextUtils.isEmpty(recognizeResultBean.getUserId())) {
                ToastUtil.showView(FaceFragment2.this.mActivity, FaceMsg.FaceNO);
            } else {
                AttendanceUtils.INSTANCE.attendance(FaceFragment2.this.mActivity, recognizeResultBean.getUserId(), 1);
            }
        }

        @Override // com.yyide.facepass.OnRecognizeCallback
        public void onFaceDismiss() {
            FaceFragment2.this.traceIds.clear();
            FaceFragment2.this.faceView.clear();
            FaceFragment2.this.faceView.invalidate();
        }

        @Override // com.yyide.facepass.OnRecognizeCallback
        public void onFaceDetect(List<FacePassFace> list) {
            Iterator<FacePassFace> it2 = list.iterator();
            while (it2.hasNext()) {
                if (it2.next().facePassFeedFrameErrorCode == 7) {
                    ToastUtil.showView(FaceFragment2.this.mActivity, FaceMsg.FaceLight);
                }
            }
            FaceFragment2.this.faceView.showFacePassFace(list, FaceFragment2.this.cameraPreview, FaceFragment2.this.traceIds);
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
}
