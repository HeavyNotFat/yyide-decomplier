package com.yd.android_brand_mvp.utils;

import android.graphics.Matrix;
import android.graphics.RectF;
import com.yd.android_brand_mvp.widget.FaceView;
import com.yyide.facepass.FaceManager;
import com.yyide.facepass.SettingVar;
import com.yyide.facepass.camera.CameraManager;
import com.yyide.facepass.camera.CameraPreview;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mcv.facepass.types.FacePassFace;

/* JADX INFO: compiled from: FaceUtil.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J$\u0010\u0003\u001a\u00020\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b¨\u0006\f"}, d2 = {"Lcom/yd/android_brand_mvp/utils/FaceUtil;", "", "()V", "showFacePassFace", "", "detectResult", "", "Lmcv/facepass/types/FacePassFace;", "faceView", "Lcom/yd/android_brand_mvp/widget/FaceView;", "cameraView", "Lcom/yyide/facepass/camera/CameraPreview;", "app_commonRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class FaceUtil {
    public static final FaceUtil INSTANCE = new FaceUtil();

    private FaceUtil() {
    }

    public final void showFacePassFace(List<? extends FacePassFace> detectResult, FaceView faceView, CameraPreview cameraView) {
        float f;
        float f2;
        float f3;
        int i;
        Intrinsics.checkNotNullParameter(detectResult, "detectResult");
        Intrinsics.checkNotNullParameter(faceView, "faceView");
        Intrinsics.checkNotNullParameter(cameraView, "cameraView");
        faceView.clear();
        for (FacePassFace facePassFace : detectResult) {
            boolean z = !SettingVar.INSTANCE.getCameraFacingFront();
            Matrix matrix = new Matrix();
            int measuredWidth = cameraView.getMeasuredWidth();
            int measuredHeight = cameraView.getMeasuredHeight();
            CameraManager manager = FaceManager.INSTANCE.getManager();
            int cameraHeight = manager != null ? manager.getCameraHeight() : 0;
            CameraManager manager2 = FaceManager.INSTANCE.getManager();
            int cameraWidth = manager2 != null ? manager2.getCameraWidth() : 0;
            int i2 = z ? -1 : 1;
            int faceRotation = SettingVar.INSTANCE.getFaceRotation();
            float f4 = 0.0f;
            if (faceRotation == 0) {
                float f5 = facePassFace.rect.left;
                float f6 = facePassFace.rect.top;
                float f7 = facePassFace.rect.right;
                f = facePassFace.rect.bottom;
                matrix.setScale(i2, 1.0f);
                matrix.postTranslate(z ? cameraWidth : 0.0f, 0.0f);
                matrix.postScale(measuredWidth / cameraWidth, measuredHeight / cameraHeight);
                f2 = f7;
                f4 = f5;
                f3 = f6;
            } else if (faceRotation != 90) {
                if (faceRotation == 180) {
                    matrix.setScale(1.0f, i2);
                    matrix.postTranslate(0.0f, z ? cameraHeight : 0.0f);
                    matrix.postScale(measuredWidth / cameraWidth, measuredHeight / cameraHeight);
                    f4 = facePassFace.rect.right;
                    f3 = facePassFace.rect.bottom;
                    f2 = facePassFace.rect.left;
                    i = facePassFace.rect.top;
                } else if (faceRotation != 270) {
                    f = 0.0f;
                    f3 = 0.0f;
                    f2 = 0.0f;
                } else {
                    matrix.setScale(i2, 1.0f);
                    matrix.postTranslate(z ? cameraHeight : 0.0f, 0.0f);
                    matrix.postScale(measuredWidth / cameraHeight, measuredHeight / cameraWidth);
                    f4 = cameraHeight - facePassFace.rect.bottom;
                    f3 = facePassFace.rect.left;
                    f2 = cameraHeight - facePassFace.rect.top;
                    i = facePassFace.rect.right;
                }
                f = i;
            } else {
                matrix.setScale(i2, 1.0f);
                matrix.postTranslate(z ? cameraHeight : 0.0f, 0.0f);
                matrix.postScale(measuredWidth / cameraHeight, measuredHeight / cameraWidth);
                f4 = facePassFace.rect.top;
                f3 = cameraWidth - facePassFace.rect.right;
                f2 = facePassFace.rect.bottom;
                f = cameraWidth - facePassFace.rect.left;
            }
            RectF rectF = new RectF();
            matrix.mapRect(rectF, new RectF(f4, f3, f2, f));
            faceView.addRect(rectF, false, measuredWidth);
        }
        faceView.invalidate();
    }
}
