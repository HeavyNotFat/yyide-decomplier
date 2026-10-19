package com.yd.android_brand_mvp.widget;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import com.blankj.utilcode.util.SizeUtils;
import com.yd.android_brand_mvp.R;
import com.yyide.facepass.FaceManager;
import com.yyide.facepass.SettingVar;
import com.yyide.facepass.camera.CameraPreview;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import mcv.facepass.types.FacePassFace;
import tv.danmaku.ijk.media.player.IjkMediaMeta;

/* JADX INFO: loaded from: classes4.dex */
public class FaceView extends View {
    private Bitmap bitmap;
    private final List<Boolean> faces;
    private final Paint paint;
    private final List<Paint> paintList;
    private final List<Paint> paintTextList;
    private final RectF r2;
    private List<RectF> rect;

    private void initData() {
        this.rect = new ArrayList();
        this.bitmap = BitmapFactory.decodeResource(getResources(), R.mipmap.face_pass);
    }

    public FaceView(Context context) {
        super(context);
        this.paintList = new ArrayList();
        this.paintTextList = new ArrayList();
        this.faces = new ArrayList();
        this.r2 = new RectF();
        this.paint = new Paint();
        initData();
    }

    public FaceView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.paintList = new ArrayList();
        this.paintTextList = new ArrayList();
        this.faces = new ArrayList();
        this.r2 = new RectF();
        this.paint = new Paint();
        initData();
    }

    public FaceView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.paintList = new ArrayList();
        this.paintTextList = new ArrayList();
        this.faces = new ArrayList();
        this.r2 = new RectF();
        this.paint = new Paint();
        initData();
    }

    public void addRect(RectF rectF, boolean z, int i) {
        if (Build.VERSION.SDK_INT >= 23) {
            RectF rectF2 = new RectF();
            float f = i;
            rectF2.left = (int) (f - rectF.left);
            rectF2.top = ((int) rectF.top) - 10;
            rectF2.right = (int) (f - rectF.right);
            rectF2.bottom = (int) rectF.bottom;
            this.rect.add(rectF2);
        } else {
            this.rect.add(rectF);
        }
        Paint paint = new Paint();
        if (z) {
            paint.setARGB(100, 103, 71, 211);
        } else {
            paint.setARGB(255, 100, IjkMediaMeta.FF_PROFILE_H264_HIGH_444_PREDICTIVE, 163);
        }
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(3.0f);
        this.paintList.add(paint);
        Paint paint2 = new Paint();
        paint2.setAntiAlias(true);
        paint2.setStrokeWidth(2.0f);
        paint2.setColor(-1);
        paint2.setTextSize(SizeUtils.px2sp(14.0f));
        paint2.setTypeface(Typeface.DEFAULT_BOLD);
        this.paintTextList.add(paint2);
        this.faces.add(Boolean.valueOf(z));
    }

    public void clear() {
        this.rect.clear();
        this.faces.clear();
        this.paintList.clear();
        this.paintTextList.clear();
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        for (int i = 0; i < this.rect.size(); i++) {
            RectF rectF = this.rect.get(i);
            canvas.drawRect(rectF, this.paintList.get(i));
            if (this.faces.size() > 0 && this.faces.get(i).booleanValue()) {
                this.r2.left = rectF.left + 10.0f;
                this.r2.right = rectF.right - 5.0f;
                this.r2.top = rectF.top - 26.0f;
                this.r2.bottom = rectF.top - 3.0f;
                this.paint.setARGB(100, 103, 71, 211);
                this.paint.setStyle(Paint.Style.FILL);
                canvas.drawRoundRect(this.r2, 50.0f, 50.0f, this.paint);
                canvas.drawBitmap(this.bitmap, rectF.left - 105.0f, rectF.top - 24.0f, (Paint) null);
                canvas.drawText("识别成功", rectF.left - 80.0f, rectF.top - 10.0f, this.paintTextList.get(i));
            }
        }
        clear();
    }

    public void showFacePassFace(List<FacePassFace> list, CameraPreview cameraPreview) {
        showFacePassFace(list, cameraPreview, null);
    }

    public void showFacePassFace(List<FacePassFace> list, CameraPreview cameraPreview, List<Long> list2) {
        float f;
        float f2;
        float f3;
        int i;
        clear();
        for (FacePassFace facePassFace : list) {
            boolean z = false;
            if (list2 != null) {
                Iterator<Long> it2 = list2.iterator();
                while (it2.hasNext()) {
                    if (facePassFace.trackId == it2.next().longValue()) {
                        z = true;
                        break;
                    }
                }
            }
            boolean cameraFacingFront = true ^ SettingVar.INSTANCE.getCameraFacingFront();
            Matrix matrix = new Matrix();
            int measuredWidth = cameraPreview.getMeasuredWidth();
            int measuredHeight = cameraPreview.getMeasuredHeight();
            int cameraHeight = FaceManager.INSTANCE.getManager().getCameraHeight();
            int cameraWidth = FaceManager.INSTANCE.getManager().getCameraWidth();
            int faceRotation = SettingVar.INSTANCE.getFaceRotation();
            float f4 = 0.0f;
            if (faceRotation == 0) {
                float f5 = facePassFace.rect.left;
                float f6 = facePassFace.rect.top;
                float f7 = facePassFace.rect.right;
                float f8 = facePassFace.rect.bottom;
                matrix.setScale(cameraFacingFront ? -1.0f : 1.0f, 1.0f);
                matrix.postTranslate(cameraFacingFront ? cameraWidth : 0.0f, 0.0f);
                matrix.postScale(measuredWidth / cameraWidth, measuredHeight / cameraHeight);
                f4 = f5;
                f = f6;
                f2 = f7;
                f3 = f8;
            } else if (faceRotation != 90) {
                if (faceRotation == 180) {
                    matrix.setScale(1.0f, cameraFacingFront ? -1.0f : 1.0f);
                    matrix.postTranslate(0.0f, cameraFacingFront ? cameraHeight : 0.0f);
                    matrix.postScale(measuredWidth / cameraWidth, measuredHeight / cameraHeight);
                    f4 = facePassFace.rect.right;
                    f = facePassFace.rect.bottom;
                    f2 = facePassFace.rect.left;
                    i = facePassFace.rect.top;
                } else if (faceRotation != 270) {
                    f = 0.0f;
                    f2 = 0.0f;
                    f3 = 0.0f;
                } else {
                    matrix.setScale(cameraFacingFront ? -1.0f : 1.0f, 1.0f);
                    matrix.postTranslate(cameraFacingFront ? cameraHeight : 0.0f, 0.0f);
                    matrix.postScale(measuredWidth / cameraHeight, measuredHeight / cameraWidth);
                    f4 = cameraHeight - facePassFace.rect.bottom;
                    f = facePassFace.rect.left;
                    f2 = cameraHeight - facePassFace.rect.top;
                    i = facePassFace.rect.right;
                }
                f3 = i;
            } else {
                matrix.setScale(cameraFacingFront ? -1.0f : 1.0f, 1.0f);
                matrix.postTranslate(cameraFacingFront ? cameraHeight : 0.0f, 0.0f);
                matrix.postScale(measuredWidth / cameraHeight, measuredHeight / cameraWidth);
                f4 = facePassFace.rect.top;
                f = cameraWidth - facePassFace.rect.right;
                f2 = facePassFace.rect.bottom;
                f3 = cameraWidth - facePassFace.rect.left;
            }
            RectF rectF = new RectF();
            matrix.mapRect(rectF, new RectF(f4, f, f2, f3));
            Log.d("showFacePassFace", "face.trackId= " + facePassFace.trackId);
            addRect(rectF, z, measuredWidth);
        }
        invalidate();
    }
}
