package com.yd.android_brand_mvp.widget;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.text.Html;
import android.widget.TextView;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.target.SimpleTarget;
import com.bumptech.glide.request.transition.Transition;

/* JADX INFO: loaded from: classes4.dex */
public class ImageGetterUtils {
    public static MyImageGetter getImageGetter(Context context, TextView textView) {
        return new MyImageGetter(context, textView);
    }

    public static class MyImageGetter implements Html.ImageGetter {
        private Context context;
        private TextView textView;
        private URLDrawable urlDrawable = null;

        public MyImageGetter(Context context, TextView textView) {
            this.textView = textView;
            this.context = context;
        }

        @Override // android.text.Html.ImageGetter
        public Drawable getDrawable(String str) {
            this.urlDrawable = new URLDrawable();
            Glide.with(this.context).asBitmap().load(str).into(new SimpleTarget<Bitmap>() { // from class: com.yd.android_brand_mvp.widget.ImageGetterUtils.MyImageGetter.1
                @Override // com.bumptech.glide.request.target.Target
                public /* bridge */ /* synthetic */ void onResourceReady(Object obj, Transition transition) {
                    onResourceReady((Bitmap) obj, (Transition<? super Bitmap>) transition);
                }

                public void onResourceReady(Bitmap bitmap, Transition<? super Bitmap> transition) {
                    MyImageGetter.this.urlDrawable.bitmap = MyImageGetter.this.changeBitmapSize(bitmap);
                    MyImageGetter.this.urlDrawable.setBounds(0, 0, MyImageGetter.this.changeBitmapSize(bitmap).getWidth(), MyImageGetter.this.changeBitmapSize(bitmap).getHeight());
                    MyImageGetter.this.textView.invalidate();
                    MyImageGetter.this.textView.setText(MyImageGetter.this.textView.getText());
                }
            });
            return this.urlDrawable;
        }

        public class URLDrawable extends BitmapDrawable {
            public Bitmap bitmap;

            public URLDrawable() {
            }

            @Override // android.graphics.drawable.BitmapDrawable, android.graphics.drawable.Drawable
            public void draw(Canvas canvas) {
                super.draw(canvas);
                Bitmap bitmap = this.bitmap;
                if (bitmap != null) {
                    canvas.drawBitmap(bitmap, 0.0f, 0.0f, getPaint());
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public Bitmap changeBitmapSize(Bitmap bitmap) {
            int width = bitmap.getWidth();
            int height = bitmap.getHeight();
            float f = width;
            float f2 = height;
            Matrix matrix = new Matrix();
            matrix.postScale(f / f, f2 / f2);
            Bitmap bitmapCreateBitmap = Bitmap.createBitmap(bitmap, 0, 0, width, height, matrix, true);
            bitmapCreateBitmap.getWidth();
            bitmapCreateBitmap.getHeight();
            return bitmapCreateBitmap;
        }
    }
}
