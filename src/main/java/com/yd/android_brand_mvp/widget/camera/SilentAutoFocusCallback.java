package com.yd.android_brand_mvp.widget.camera;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.hardware.Camera;
import android.text.format.DateFormat;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Calendar;
import java.util.Locale;

/* JADX INFO: loaded from: classes4.dex */
public class SilentAutoFocusCallback implements Camera.AutoFocusCallback {
    @Override // android.hardware.Camera.AutoFocusCallback
    public void onAutoFocus(boolean z, Camera camera) {
        processPoto(z, camera);
    }

    private void processPoto(boolean z, Camera camera) {
        if (z && camera != null) {
            savePoto(camera);
        } else {
            savePoto(camera);
        }
    }

    private void savePoto(Camera camera) {
        camera.takePicture(null, null, new Camera.PictureCallback() { // from class: com.yd.android_brand_mvp.widget.camera.SilentAutoFocusCallback.1
            @Override // android.hardware.Camera.PictureCallback
            public void onPictureTaken(byte[] bArr, Camera camera2) {
                String str = ((Object) DateFormat.format("yyyy_MM_dd_hhmmss", Calendar.getInstance(Locale.CHINA))) + ".jpg";
                File file = new File(Config4Camera.POTOPATH);
                file.mkdirs();
                String str2 = file.getPath() + File.separator + str;
                Bitmap bitmapDecodeByteArray = BitmapFactory.decodeByteArray(bArr, 0, bArr.length);
                try {
                    try {
                        FileOutputStream fileOutputStream = new FileOutputStream(str2);
                        bitmapDecodeByteArray.compress(Bitmap.CompressFormat.JPEG, 100, fileOutputStream);
                        fileOutputStream.flush();
                        fileOutputStream.close();
                        Config4Camera.silentPotoList.add(str2);
                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                    } catch (IOException e2) {
                        e2.printStackTrace();
                    }
                } finally {
                    SilentAutoFocusCallback.this.releaseCamera(camera2);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void releaseCamera(Camera camera) {
        if (camera != null) {
            try {
                camera.setPreviewDisplay(null);
                camera.stopPreview();
                camera.release();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
