package com.yd.android_brand_mvp.weight;

import android.app.Activity;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.SurfaceTexture;
import android.graphics.YuvImage;
import android.hardware.Camera;
import android.media.AudioManager;
import android.util.AttributeSet;
import android.util.Log;
import android.view.TextureView;
import android.view.WindowManager;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.OnLifecycleEvent;
import com.yd.android_brand_mvp.R;
import java.io.File;
import java.io.FileOutputStream;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public class CameraView extends TextureView implements TextureView.SurfaceTextureListener, Camera.PreviewCallback {
    public static final String FACE_LICENSE = "idl-license.face-android";
    public static final String FACE_LICENSE_ID = "bp-face-android";
    String CARD_TEMP;
    byte[] currentFrame;
    private AudioManager mAudioManager;
    private Camera mCamera;
    private int mCameraDegree;
    private int mCameraId;
    private Camera.CameraInfo mCameraInfo;
    private Rect mDetectRect;
    private boolean mEnableSound;
    private boolean mFaceEnable;
    private int mFaceType;
    private int mHeight;
    private Rect mPreviewRect;
    private int mWidth;
    int s;

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    public void onDestroy() {
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
        return true;
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
    }

    public CameraView(Context context) {
        this(context, null);
    }

    public CameraView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public CameraView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mFaceType = 0;
        this.mFaceEnable = false;
        this.CARD_TEMP = "CARD_TEMP.jpg";
        this.s = 0;
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.CameraView);
        this.mFaceType = typedArrayObtainStyledAttributes.getInt(0, 0);
        typedArrayObtainStyledAttributes.recycle();
        init();
    }

    private void init() {
        configCamera();
        setSurfaceTextureListener(this);
    }

    private void configCamera() {
        int numberOfCameras = Camera.getNumberOfCameras();
        this.mCameraInfo = new Camera.CameraInfo();
        for (int i = 0; i < numberOfCameras; i++) {
            Camera.getCameraInfo(i, this.mCameraInfo);
            if (this.mCameraInfo.facing == 1) {
                this.mCameraId = i;
                Log.e("TAG", "CAMERA_FACING_FRONT: ");
                break;
            }
        }
        Log.e("TAG", "configCamerasize: " + numberOfCameras);
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
        this.mWidth = i;
        this.mHeight = i2;
        initCamera();
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i2) {
        this.mWidth = i;
        this.mHeight = i2;
        initCamera();
    }

    @Override // android.hardware.Camera.PreviewCallback
    public void onPreviewFrame(byte[] bArr, Camera camera) {
        this.currentFrame = bArr;
        if (!this.mFaceEnable) {
        }
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    private void onResume() {
        if (isAvailable()) {
            initCamera();
        }
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
    public void onPause() {
        releaseCamera();
    }

    private Camera.Size getBestPreviewSize(Camera.Parameters parameters) {
        if (parameters.getSupportedPreviewSizes() == null || parameters.getSupportedPreviewSizes().size() == 0) {
            return null;
        }
        return getOptimalPreviewSize(parameters.getSupportedPreviewSizes(), this.mWidth, this.mHeight);
    }

    private Camera.Size getOptimalPreviewSize(List<Camera.Size> list, int i, int i2) {
        double d = ((double) i) / ((double) i2);
        Camera.Size size = null;
        if (list == null) {
            return null;
        }
        double dAbs = Double.MAX_VALUE;
        double dAbs2 = Double.MAX_VALUE;
        for (Camera.Size size2 : list) {
            if (Math.abs((((double) size2.width) / ((double) size2.height)) - d) <= 0.1d && Math.abs(size2.height - i2) < dAbs2) {
                dAbs2 = Math.abs(size2.height - i2);
                size = size2;
            }
        }
        if (size == null) {
            for (Camera.Size size3 : list) {
                if (Math.abs(size3.height - i2) < dAbs) {
                    size = size3;
                    dAbs = Math.abs(size3.height - i2);
                }
            }
        }
        return size;
    }

    private void initCamera() {
        float f;
        int i;
        releaseCamera();
        try {
            Camera cameraOpen = Camera.open(this.mCameraId);
            this.mCamera = cameraOpen;
            Camera.Parameters parameters = cameraOpen.getParameters();
            parameters.getSupportedPictureSizes();
            Camera.Size bestPreviewSize = getBestPreviewSize(parameters);
            Log.e("TAG", "initCamera: " + bestPreviewSize);
            if (bestPreviewSize == null) {
                releaseCamera();
                return;
            }
            int rotation = ((WindowManager) getContext().getSystemService("window")).getDefaultDisplay().getRotation();
            if (rotation == 0) {
                this.mCameraDegree = 0;
            } else if (rotation == 1) {
                this.mCameraDegree = 90;
            } else if (rotation == 2) {
                this.mCameraDegree = 180;
            } else if (rotation == 3) {
                this.mCameraDegree = 270;
            } else {
                this.mCameraDegree = 0;
            }
            if (this.mCameraInfo.facing == 1) {
                int i2 = (this.mCameraInfo.orientation + this.mCameraDegree) % 360;
                this.mCameraDegree = i2;
                this.mCameraDegree = (360 - i2) % 360;
            } else {
                this.mCameraDegree = ((this.mCameraInfo.orientation - this.mCameraDegree) + 360) % 360;
            }
            parameters.setPreviewSize(bestPreviewSize.width, bestPreviewSize.height);
            if (parameters.getSupportedFocusModes().contains("continuous-video")) {
                parameters.setFocusMode("continuous-video");
            }
            parameters.setRotation(this.mCameraDegree);
            Log.e("TAG", "mCameraDegree: " + this.mCameraDegree);
            if (this.mCameraDegree % 180 == 0) {
                f = bestPreviewSize.width;
                i = bestPreviewSize.height;
            } else {
                f = bestPreviewSize.height;
                i = bestPreviewSize.width;
            }
            float f2 = i;
            float f3 = this.mWidth / f;
            float f4 = this.mHeight / f2;
            Matrix matrix = new Matrix();
            if (f3 > f4) {
                int i3 = this.mHeight;
                matrix.postScale(1.0f, (f3 * f2) / i3, this.mWidth / 2.0f, i3 / 2.0f);
            } else {
                float f5 = f4 * f;
                int i4 = this.mWidth;
                matrix.postScale(f5 / i4, 1.0f, i4 / 2.0f, this.mHeight / 2.0f);
            }
            setTransform(matrix);
            this.mPreviewRect = new Rect(0, 0, bestPreviewSize.width, bestPreviewSize.height);
            if (this.mCameraDegree % 180 == 0) {
                float f6 = (bestPreviewSize.width * 1.0f) / this.mWidth;
                float f7 = (bestPreviewSize.height * 1.0f) / this.mHeight;
                if (f6 >= f7) {
                    f6 = f7;
                }
                float f8 = this.mWidth * f6;
                float f9 = this.mHeight * f6;
                float f10 = (bestPreviewSize.width - f8) / 2.0f;
                float f11 = (bestPreviewSize.height - f9) / 2.0f;
                this.mDetectRect = new Rect((int) f10, (int) f11, (int) (f10 + f8), (int) (f11 + f9));
            } else {
                float f12 = (bestPreviewSize.height * 1.0f) / this.mWidth;
                float f13 = (bestPreviewSize.width * 1.0f) / this.mHeight;
                if (f12 >= f13) {
                    f12 = f13;
                }
                float f14 = this.mWidth * f12;
                float f15 = this.mHeight * f12;
                float f16 = (bestPreviewSize.height - f14) / 2.0f;
                float f17 = (bestPreviewSize.width - f15) / 2.0f;
                this.mDetectRect = new Rect((int) f16, (int) f17, (int) (f16 + f14), (int) (f17 + f15));
            }
            try {
                this.mCamera.setParameters(parameters);
                this.mCamera.setDisplayOrientation(this.mCameraDegree);
                this.mCamera.setPreviewCallback(this);
                this.mCamera.setPreviewTexture(getSurfaceTexture());
                this.mCamera.startPreview();
            } catch (Exception unused) {
                releaseCamera();
            }
        } catch (Exception unused2) {
            releaseCamera();
        }
    }

    public static void setCameraDisplayOrientation(Activity activity, int i, Camera camera) {
        int i2;
        Camera.CameraInfo cameraInfo = new Camera.CameraInfo();
        Camera.getCameraInfo(i, cameraInfo);
        int rotation = activity.getWindowManager().getDefaultDisplay().getRotation();
        int i3 = 0;
        if (rotation != 0) {
            if (rotation == 1) {
                i3 = 90;
            } else if (rotation == 2) {
                i3 = 180;
            } else if (rotation == 3) {
                i3 = 270;
            }
        }
        if (cameraInfo.facing == 1) {
            i2 = (360 - ((cameraInfo.orientation + i3) % 360)) % 360;
        } else {
            i2 = ((cameraInfo.orientation - i3) + 360) % 360;
        }
        camera.setDisplayOrientation(i2);
    }

    public void releaseCamera() {
        try {
            this.mCamera.setPreviewCallback(null);
            this.mCamera.stopPreview();
            this.mCamera.release();
        } catch (Exception unused) {
        } finally {
            this.mCamera = null;
        }
    }

    public void releaseCamera2() {
        Camera camera = this.mCamera;
        if (camera != null) {
            try {
                camera.setPreviewCallback(null);
                this.mCamera.stopPreview();
                this.mCamera.release();
            } catch (Exception unused) {
            } finally {
                this.mCamera = null;
            }
        }
    }

    private String getResString(int i) {
        try {
            return getContext().getString(i);
        } catch (Exception unused) {
            return null;
        }
    }

    public void setFaceEnable(boolean z) {
        this.mFaceEnable = z;
    }

    public File nv21() {
        try {
            File file = new File(getContext().getExternalCacheDir(), System.currentTimeMillis() + ".jpg");
            Log.e("TAG", "nv21: " + file.getAbsolutePath());
            YuvImage yuvImage = new YuvImage(this.currentFrame, 17, getPreviewWidth(), getPreviewHeight(), null);
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            yuvImage.compressToJpeg(new Rect(0, 0, yuvImage.getWidth(), yuvImage.getHeight()), 50, fileOutputStream);
            fileOutputStream.close();
            return file;
        } catch (Exception unused) {
            return null;
        }
    }

    public int getPreviewWidth() {
        Rect rect = this.mPreviewRect;
        if (rect == null) {
            return 0;
        }
        return rect.width();
    }

    public int getPreviewHeight() {
        Rect rect = this.mPreviewRect;
        if (rect == null) {
            return 0;
        }
        return rect.height();
    }
}
