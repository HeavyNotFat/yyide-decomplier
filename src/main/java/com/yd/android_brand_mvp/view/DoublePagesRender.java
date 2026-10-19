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
public class DoublePagesRender extends PageRender {
    @Override // com.eschao.android.widget.pageflip.OnPageFlipListener
    public boolean canFlipBackward() {
        return false;
    }

    public DoublePagesRender(Context context, PageFlip pageFlip, Handler handler, int i) {
        super(context, pageFlip, handler, i);
    }

    @Override // com.yd.android_brand_mvp.view.PageRender
    public void onDrawFrame() {
        this.mPageFlip.deleteUnusedTextures();
        Page firstPage = this.mPageFlip.getFirstPage();
        Page secondPage = this.mPageFlip.getSecondPage();
        if (!firstPage.isFirstTextureSet()) {
            drawPage(firstPage.isLeftPage() ? this.mPageNo : this.mPageNo + 1);
            firstPage.setFirstTexture(this.mBitmap);
        }
        if (!secondPage.isFirstTextureSet()) {
            drawPage(secondPage.isLeftPage() ? this.mPageNo : this.mPageNo + 1);
            secondPage.setFirstTexture(this.mBitmap);
        }
        if (this.mDrawCommand == 0 || this.mDrawCommand == 1) {
            if (!firstPage.isBackTextureSet()) {
                drawPage(firstPage.isLeftPage() ? this.mPageNo - 1 : this.mPageNo + 2);
                firstPage.setBackTexture(this.mBitmap);
            }
            if (!firstPage.isSecondTextureSet()) {
                drawPage(firstPage.isLeftPage() ? this.mPageNo - 2 : this.mPageNo + 3);
                firstPage.setSecondTexture(this.mBitmap);
            }
            this.mPageFlip.drawFlipFrame();
        } else if (this.mDrawCommand == 2) {
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
        int iWidth = (int) firstPage.width();
        int iHeight = (int) firstPage.height();
        this.mBitmap = Bitmap.createBitmap(iWidth, iHeight, Bitmap.Config.ARGB_8888);
        this.mCanvas.setBitmap(this.mBitmap);
        LoadBitmapTask.get(this.mContext).set(iWidth, iHeight, 2);
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
        if (this.mPageFlip.getFlipState() == PageFlipState.END_WITH_FORWARD) {
            Page firstPage = this.mPageFlip.getFirstPage();
            this.mPageFlip.getSecondPage().swapTexturesWithPage(firstPage);
            if (firstPage.isLeftPage()) {
                this.mPageNo -= 2;
            } else {
                this.mPageNo += 2;
            }
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
        Rect rect = new Rect(0, 0, width, height);
        if (width > height) {
            this.mCanvas.rotate(90.0f);
            this.mCanvas.drawBitmap(bitmap, (Rect) null, rect, paint);
            this.mCanvas.rotate(-90.0f);
        } else {
            this.mCanvas.drawBitmap(bitmap, (Rect) null, rect, paint);
        }
        bitmap.recycle();
        int i2 = (int) (this.mContext.getResources().getDisplayMetrics().scaledDensity * 80.0f);
        paint.setColor(-1);
        paint.setStrokeWidth(1.0f);
        paint.setAntiAlias(true);
        paint.setShadowLayer(5.0f, 8.0f, 8.0f, -16777216);
        paint.setTextSize(i2);
        String strValueOf = String.valueOf(i);
        if (i < 1) {
            strValueOf = "Preface";
        } else if (i > 30) {
            strValueOf = "End";
        }
        float fMeasureText = paint.measureText(strValueOf);
        float textSize = (height - paint.getTextSize()) - 20.0f;
        float f = width;
        this.mCanvas.drawText(strValueOf, (f - fMeasureText) / 2.0f, textSize, paint);
        if (i == 1) {
            paint.setTextSize(calcFontSize(16));
            this.mCanvas.drawText("The First Page", (f - paint.measureText("The First Page")) / 2.0f, textSize + 5.0f + paint.getTextSize(), paint);
            return;
        }
        if (i == 30) {
            paint.setTextSize(calcFontSize(16));
            this.mCanvas.drawText("The Last Page", (f - paint.measureText("The Last Page")) / 2.0f, textSize + 5.0f + paint.getTextSize(), paint);
        }
    }

    @Override // com.eschao.android.widget.pageflip.OnPageFlipListener
    public boolean canFlipForward() {
        if (this.mPageFlip.getFirstPage().isLeftPage()) {
            return this.mPageNo > 1;
        }
        return this.mPageNo + 2 <= 30;
    }
}
