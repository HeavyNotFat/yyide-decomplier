package com.yd.android_brand_mvp.utils.image;

import android.content.Context;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.BaseRequestOptions;
import com.bumptech.glide.request.RequestOptions;
import com.bumptech.glide.request.target.CustomTarget;
import com.bumptech.glide.request.transition.Transition;
import com.lxj.xpopup.interfaces.XPopupImageLoader;
import java.io.File;

/* JADX INFO: loaded from: classes4.dex */
public class ImageLoader implements XPopupImageLoader {
    RequestOptions options = new RequestOptions();

    /* JADX INFO: Access modifiers changed from: private */
    public RequestOptions buildOptions() {
        return new RequestOptions().dontAnimate().apply(this.options).dontTransform().skipMemoryCache(true).diskCacheStrategy(DiskCacheStrategy.NONE);
    }

    @Override // com.lxj.xpopup.interfaces.XPopupImageLoader
    public void loadImage(int i, final Object obj, final ImageView imageView) {
        Glide.with(imageView).load(obj).apply((BaseRequestOptions<?>) new RequestOptions()).into(new CustomTarget<Drawable>() { // from class: com.yd.android_brand_mvp.utils.image.ImageLoader.1
            @Override // com.bumptech.glide.request.target.Target
            public void onLoadCleared(Drawable drawable) {
            }

            @Override // com.bumptech.glide.request.target.Target
            public /* bridge */ /* synthetic */ void onResourceReady(Object obj2, Transition transition) {
                onResourceReady((Drawable) obj2, (Transition<? super Drawable>) transition);
            }

            public void onResourceReady(Drawable drawable, Transition<? super Drawable> transition) {
                if (drawable != null && (drawable instanceof BitmapDrawable)) {
                    int byteCount = ((BitmapDrawable) drawable).getBitmap().getByteCount() / 10485760;
                    if (byteCount >= 1) {
                        Glide.with(imageView).load(obj).apply((BaseRequestOptions<?>) ImageLoader.this.buildOptions().override(drawable.getIntrinsicWidth() / byteCount, drawable.getIntrinsicHeight() / byteCount)).into(imageView);
                        return;
                    }
                    imageView.setImageDrawable(drawable);
                    return;
                }
                imageView.setImageDrawable(drawable);
            }
        });
    }

    @Override // com.lxj.xpopup.interfaces.XPopupImageLoader
    public File getImageFile(Context context, Object obj) {
        try {
            return Glide.with(context).downloadOnly().load(obj).submit().get();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
