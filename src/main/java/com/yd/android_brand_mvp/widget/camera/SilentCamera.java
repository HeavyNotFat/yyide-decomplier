package com.yd.android_brand_mvp.widget.camera;

import android.content.Context;
import android.hardware.Camera;

/* JADX INFO: loaded from: classes4.dex */
public class SilentCamera {
    static Camera camera;

    public static void openCamera(Context context, Camera.AutoFocusCallback autoFocusCallback) {
        Camera.CameraInfo cameraInfo = new Camera.CameraInfo();
        int numberOfCameras = Camera.getNumberOfCameras();
        for (int i = 0; i < numberOfCameras; i++) {
            Camera.getCameraInfo(i, cameraInfo);
            if (cameraInfo.facing == 1) {
                try {
                    camera = Camera.open(i);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        if (camera == null) {
            for (int i2 = 0; i2 < numberOfCameras; i2++) {
                Camera.getCameraInfo(i2, cameraInfo);
                if (cameraInfo.facing == 0) {
                    try {
                        camera = Camera.open(i2);
                    } catch (Exception e2) {
                        e2.printStackTrace();
                    }
                }
            }
        }
        try {
            if (camera != null) {
                camera.startPreview();
                camera.autoFocus(new SilentAutoFocusCallback());
            }
        } catch (Exception e3) {
            e3.printStackTrace();
        }
    }
}
