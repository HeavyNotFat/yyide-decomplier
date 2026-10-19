package com.yd.android_brand_mvp.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Paint;
import android.graphics.Rect;
import android.os.Handler;
import android.os.Message;
import com.eschao.android.widget.pageflip.Page;
import com.eschao.android.widget.pageflip.PageFlip;
import com.eschao.android.widget.pageflip.PageFlipState;

/* JADX INFO: loaded from: classes4.dex */
public class SinglePageRender extends PageRender {
    public SinglePageRender(Context context, PageFlip pageFlip, Handler handler, int i) {
        super(context, pageFlip, handler, i);
    }

    @Override // com.yd.android_brand_mvp.view.PageRender
    public void onDrawFrame() {
        this.mPageFlip.deleteUnusedTextures();
        Page firstPage = this.mPageFlip.getFirstPage();
        if (this.mDrawCommand == 0 || this.mDrawCommand == 1) {
            if (this.mPageFlip.getFlipState() == PageFlipState.FORWARD_FLIP) {
                if (!firstPage.isSecondTextureSet()) {
                    drawPage(this.mPageNo + 1);
                    firstPage.setSecondTexture(this.mBitmap);
                }
            } else if (!firstPage.isFirstTextureSet()) {
                int i = this.mPageNo - 1;
                this.mPageNo = i;
                drawPage(i);
                firstPage.setFirstTexture(this.mBitmap);
            }
            this.mPageFlip.drawFlipFrame();
        } else if (this.mDrawCommand == 2) {
            if (!firstPage.isFirstTextureSet()) {
                drawPage(this.mPageNo);
                firstPage.setFirstTexture(this.mBitmap);
            }
            this.mPageFlip.drawPageFrame();
        }
        Message messageObtain = Message.obtain();
        messageObtain.what = 1;
        messageObtain.arg1 = this.mDrawCommand;
        this.mHandler.sendMessage(messageObtain);
    }

    @Override // com.yd.android_brand_mvp.view.PageRender
    public void onSurfaceChanged(int i, int i2) {
        if (this.mBackgroundBitmap != null) {
            this.mBackgroundBitmap.recycle();
        }
        if (this.mBitmap != null) {
            this.mBitmap.recycle();
        }
        Page firstPage = this.mPageFlip.getFirstPage();
        this.mBitmap = Bitmap.createBitmap((int) firstPage.width(), (int) firstPage.height(), Bitmap.Config.ARGB_8888);
        this.mCanvas.setBitmap(this.mBitmap);
        LoadBitmapTask.get(this.mContext).set(i, i2, 1);
    }

    @Override // com.yd.android_brand_mvp.view.PageRender
    public boolean onEndedDrawing(int i) {
        if (i != 1) {
            return false;
        }
        if (this.mPageFlip.animating()) {
            this.mDrawCommand = 1;
            return true;
        }
        PageFlipState flipState = this.mPageFlip.getFlipState();
        if (flipState != PageFlipState.END_WITH_BACKWARD && flipState == PageFlipState.END_WITH_FORWARD) {
            this.mPageFlip.getFirstPage().setFirstTextureWithSecond();
            this.mPageNo++;
        }
        this.mDrawCommand = 2;
        return true;
    }

    private void drawPage(int i) {
        int width = this.mCanvas.getWidth();
        int height = this.mCanvas.getHeight();
        Paint paint = new Paint();
        paint.setFilterBitmap(true);
        Bitmap bitmap = LoadBitmapTask.get(this.mContext).getBitmap();
        this.mCanvas.drawBitmap(bitmap, (Rect) null, new Rect(0, 0, width, height), paint);
        bitmap.recycle();
        int iCalcFontSize = calcFontSize(80);
        paint.setColor(-1);
        paint.setStrokeWidth(1.0f);
        paint.setAntiAlias(true);
        paint.setShadowLayer(5.0f, 8.0f, 8.0f, -16777216);
        paint.setTextSize(iCalcFontSize);
        String strValueOf = String.valueOf(i);
        float fMeasureText = paint.measureText(strValueOf);
        float textSize = (height - paint.getTextSize()) - 20.0f;
        float f = width;
        this.mCanvas.drawText(strValueOf, (f - fMeasureText) / 2.0f, textSize, paint);
        if (i <= 1) {
            paint.setTextSize(calcFontSize(16));
            this.mCanvas.drawText("The First Page", (f - paint.measureText("The First Page")) / 2.0f, textSize + 5.0f + paint.getTextSize(), paint);
            return;
        }
        if (i >= 30) {
            paint.setTextSize(calcFontSize(16));
            this.mCanvas.drawText("The Last Page", (f - paint.measureText("The Last Page")) / 2.0f, textSize + 5.0f + paint.getTextSize(), paint);
        }
    }

    @Override // com.eschao.android.widget.pageflip.OnPageFlipListener
    public boolean canFlipForward() {
        return this.mPageNo < 30;
    }

    @Override // com.eschao.android.widget.pageflip.OnPageFlipListener
    public boolean canFlipBackward() {
        if (this.mPageNo <= 1) {
            return false;
        }
        this.mPageFlip.getFirstPage().setSecondTextureWithFirst();
        return true;
    }
}
