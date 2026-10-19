package com.yd.android_brand_mvp.verfity.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.blankj.utilcode.util.LogUtils;
import com.blankj.utilcode.util.ScreenUtils;
import com.yd.android_brand_mvp.R;
import com.yd.android_brand_mvp.SettingActivity;
import com.yd.android_brand_mvp.activity.YDWebViewActivity;
import com.yd.android_brand_mvp.base.BaseFragment;
import com.yd.android_brand_mvp.portrait.activity.SettingPActivity;
import com.yd.android_brand_mvp.utils.ToastUtil;
import com.yd.android_brand_mvp.utils.view.net.GsonUtils;
import com.yd.android_brand_mvp.verfity.FaceMsg;
import com.yd.android_brand_mvp.verfity.VerificationExternalActivity;
import com.yd.android_brand_mvp.widget.FaceView;
import com.yyide.facepass.FaceManager;
import com.yyide.facepass.OnRecognizeCallback;
import com.yyide.facepass.bean.RecognizeResultBean;
import com.yyide.facepass.camera.CameraPreview;
import java.util.Iterator;
import java.util.List;
import mcv.facepass.types.FacePassFace;

/* JADX INFO: loaded from: classes4.dex */
public class FaceFragment5 extends BaseFragment {
    VerificationExternalActivity activity;
    private CameraPreview cameraPreview;
    String faceId;

    @BindView(R.id.faceView)
    FaceView faceView;

    @BindView(R.id.pm)
    TextView pm;

    @BindView(R.id.preview_parent)
    LinearLayout previewView;
    private String URL = "url";
    private String TITLE = "title";
    private String IDENTITY = "identity";

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        if (ScreenUtils.isLandscape()) {
            return layoutInflater.inflate(R.layout.fragment_face2, viewGroup, false);
        }
        return layoutInflater.inflate(R.layout.fragment_face2_p, viewGroup, false);
    }

    @Override // com.yd.android_brand_mvp.base.BaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        ButterKnife.bind(this.mActivity);
        this.cameraPreview = new CameraPreview(getActivity());
        this.activity = (VerificationExternalActivity) getActivity();
    }

    void startAc() {
        if (ScreenUtils.isLandscape()) {
            startActivity(new Intent(this.mActivity, (Class<?>) SettingActivity.class));
        } else {
            startActivity(new Intent(this.mActivity, (Class<?>) SettingPActivity.class));
        }
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
            FaceManager.INSTANCE.initFaceHandler(getActivity(), this.cameraPreview, new OnRecognizeCallback() { // from class: com.yd.android_brand_mvp.verfity.fragment.FaceFragment5.1
                @Override // com.yyide.facepass.OnRecognizeCallback
                public void onFaceRecognitionStatus(long j, int i) {
                }

                @Override // com.yyide.facepass.OnRecognizeCallback
                public void onFaceRecognizeError(String str) {
                }

                @Override // com.yyide.facepass.OnRecognizeCallback
                public void onFaceRecognizeSimple(RecognizeResultBean recognizeResultBean) {
                    String string;
                    if (FaceFragment5.this.activity.getIndex() == 1) {
                        LogUtils.i(GsonUtils.toJson(recognizeResultBean));
                        if (TextUtils.isEmpty(recognizeResultBean.getUserId())) {
                            ToastUtil.showBottomView(FaceFragment5.this.mActivity, FaceMsg.FaceNO);
                            return;
                        }
                        String string2 = "";
                        if (FaceFragment5.this.getArguments() != null) {
                            string2 = FaceFragment5.this.getArguments().getString("url");
                            string = FaceFragment5.this.getArguments().getString("title");
                        } else {
                            string = "";
                        }
                        Intent intent = new Intent(FaceFragment5.this.activity, (Class<?>) YDWebViewActivity.class);
                        intent.putExtra(FaceFragment5.this.URL, string2);
                        intent.putExtra(FaceFragment5.this.TITLE, string);
                        intent.putExtra(FaceFragment5.this.IDENTITY, recognizeResultBean.getUserId());
                        FaceFragment5.this.goPermissionsActivity(intent);
                        FaceFragment5.this.activity.finish();
                    }
                }

                @Override // com.yyide.facepass.OnRecognizeCallback
                public void onFaceDismiss() {
                    FaceFragment5.this.faceView.clear();
                    FaceFragment5.this.faceView.invalidate();
                }

                @Override // com.yyide.facepass.OnRecognizeCallback
                public void onFaceDetect(List<FacePassFace> list) {
                    Iterator<FacePassFace> it2 = list.iterator();
                    while (it2.hasNext()) {
                        if (it2.next().facePassFeedFrameErrorCode == 7) {
                            ToastUtil.showBottomView(FaceFragment5.this.mActivity, FaceMsg.FaceLight);
                        }
                    }
                    FaceFragment5.this.faceView.showFacePassFace(list, FaceFragment5.this.cameraPreview);
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
}
