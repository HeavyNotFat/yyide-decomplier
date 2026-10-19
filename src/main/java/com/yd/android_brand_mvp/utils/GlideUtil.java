package com.yd.android_brand_mvp.utils;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.os.Build;
import android.text.TextUtils;
import android.util.Log;
import android.widget.ImageView;
import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestManager;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.resource.bitmap.CenterCrop;
import com.bumptech.glide.load.resource.bitmap.CircleCrop;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions;
import com.bumptech.glide.request.BaseRequestOptions;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.RequestOptions;
import com.yd.android_brand_mvp.BaseApplication;
import com.yd.android_brand_mvp.R;
import master.flame.danmaku.danmaku.parser.IDataSource;
import net.lucode.hackware.magicindicator.buildins.UIUtil;

/* JADX INFO: loaded from: classes4.dex */
public class GlideUtil {
    private static final int LOAD_CIRCLE = 1;
    private static final int LOAD_CORNER = 2;
    private static final int LOAD_SOURCE = 3;

    public static String imageUrl() {
        return "http://";
    }

    public static String DataUrl(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        if (str.startsWith(IDataSource.SCHEME_HTTP_TAG)) {
            return str;
        }
        return imageUrl() + str;
    }

    public static void loadNormalImg(ImageView imageView, String str) {
        loadImage(imageView, str, 0, 0, null);
    }

    public static void loadNormalImg(ImageView imageView, String str, RequestListener<Bitmap> requestListener) {
        loadImage(imageView, str, 0, 0, requestListener);
    }

    public static void loadCircleImg(ImageView imageView, String str) {
        loadImage(imageView, str, 1, 0, null);
    }

    public static void loadCircleImg(ImageView imageView, String str, RequestListener<Bitmap> requestListener) {
        loadImage(imageView, str, 1, 0, requestListener);
    }

    public static void loadCornerImg(ImageView imageView, String str, int i) {
        loadImage(imageView, str, 2, i, null);
    }

    public static void loadImage(Context context, String str, ImageView imageView) {
        if (isDestroy((Activity) context)) {
            return;
        }
        Glide.with(context).load(str).error(R.drawable.defualt_placeholderl).centerCrop().into(imageView);
    }

    public static void loadAIImage(Context context, String str, ImageView imageView, int i) {
        if (isDestroy((Activity) context)) {
            return;
        }
        Glide.with(context).load(str).centerCrop().apply((BaseRequestOptions<?>) new RequestOptions().error(R.drawable.icon_ai_head).transform(new RoundedCorners(i))).into(imageView);
    }

    public static void loadImageCenterInsideType(Context context, String str, ImageView imageView) {
        if (isDestroy((Activity) context)) {
            return;
        }
        Glide.with(context).load(str).error(R.drawable.defualt_placeholderl).centerInside().into(imageView);
    }

    public static void loadImage(Context context, int i, ImageView imageView) {
        if (isDestroy((Activity) context)) {
            return;
        }
        Glide.with(context).load(Integer.valueOf(i)).centerCrop().into(imageView);
    }

    public static void loadPlaceholderImage(Context context, String str, ImageView imageView) {
        RequestOptions requestOptionsError = new RequestOptions().placeholder(R.drawable.defualt_placeholderl).error(R.drawable.defualt_placeholderl);
        if (isDestroy((Activity) context)) {
            return;
        }
        Glide.with(context).load(DataUrl(str)).apply((BaseRequestOptions<?>) requestOptionsError).into(imageView);
    }

    public static void loadCircleImage(Context context, String str, ImageView imageView) {
        RequestOptions requestOptionsError = new RequestOptions().circleCrop().placeholder(R.drawable.default_head).error(R.drawable.default_head);
        if (isDestroy((Activity) context)) {
            return;
        }
        Glide.with(context).load(DataUrl(str)).apply((BaseRequestOptions<?>) requestOptionsError).into(imageView);
    }

    public static void loadCircleImage1(Context context, String str, ImageView imageView) {
        RequestOptions requestOptionsError = new RequestOptions().circleCrop().placeholder(R.drawable.default_img3).error(R.drawable.default_img3);
        if (isDestroy((Activity) context)) {
            return;
        }
        Glide.with(context).load(DataUrl(str)).apply((BaseRequestOptions<?>) requestOptionsError).into(imageView);
    }

    public static void loadCircleImage2(Context context, String str, ImageView imageView) {
        RequestOptions requestOptionsError = new RequestOptions().circleCrop().placeholder(R.drawable.logo).error(R.drawable.logo);
        if (isDestroy((Activity) context)) {
            return;
        }
        Glide.with(context).load(DataUrl(str)).apply((BaseRequestOptions<?>) requestOptionsError).into(imageView);
    }

    public static void loadClassImage(Context context, String str, ImageView imageView) {
        RequestOptions requestOptionsError = new RequestOptions().circleCrop().placeholder(R.drawable.icon_item_class_head).error(R.drawable.icon_item_class_head);
        if (isDestroy((Activity) context)) {
            return;
        }
        Glide.with(context).load(DataUrl(str)).apply((BaseRequestOptions<?>) requestOptionsError).into(imageView);
    }

    public static void loadCircleHeadImage(Context context, String str, ImageView imageView) {
        RequestOptions requestOptionsError = new RequestOptions().circleCrop().placeholder(R.drawable.default_head).error(R.drawable.default_head);
        if (isDestroy((Activity) context)) {
            return;
        }
        Glide.with(context).load(DataUrl(str)).apply((BaseRequestOptions<?>) requestOptionsError).into(imageView);
    }

    public static void loadRadiusHeadImage(Context context, String str, ImageView imageView, int i) {
        Glide.with(context).load(DataUrl(str)).apply((BaseRequestOptions<?>) new RequestOptions().transform(new RoundedCorners(i)).placeholder(R.drawable.default_head).error(R.drawable.default_head)).into(imageView);
    }

    public static void loadRadiusImage(Context context, String str, ImageView imageView, int i) {
        Glide.with(context).load(str).apply((BaseRequestOptions<?>) new RequestOptions().transform(new RoundedCorners(i))).into(imageView);
    }

    public static void loadRadiusImage(Context context, String str, ImageView imageView, int i, int i2) {
        Glide.with(context).load(str).apply((BaseRequestOptions<?>) new RequestOptions().placeholder(i).error(i).transform(new RoundedCorners(i2))).into(imageView);
    }

    public static int dip2px(Context context, float f) {
        return (int) ((f * context.getResources().getDisplayMetrics().density) + 0.5f);
    }

    public static void loadCornerImg(ImageView imageView, String str, int i, RequestListener<Bitmap> requestListener) {
        loadImage(imageView, str, 2, i, requestListener);
    }

    private static void loadImage(ImageView imageView, String str, int i, int i2, RequestListener<Bitmap> requestListener) {
        if (TextUtils.isEmpty(str)) {
            imageView.setImageResource(R.mipmap.de1);
            return;
        }
        RequestManager requestManagerWith = Glide.with(BaseApplication.getInstance());
        if (requestListener != null) {
            requestManagerWith.asBitmap().listener(requestListener).load(str).apply((BaseRequestOptions<?>) getRequestOptions(imageView.getContext(), i, i2)).into(imageView);
        } else {
            if (isDestroy((Activity) imageView.getContext())) {
                return;
            }
            requestManagerWith.load(str).transition(DrawableTransitionOptions.withCrossFade()).apply((BaseRequestOptions<?>) getRequestOptions(imageView.getContext(), i, i2)).into(imageView);
        }
    }

    public static void loadStudent(Context context, String str, ImageView imageView) {
        RequestOptions requestOptionsError = new RequestOptions().placeholder(R.drawable.icon_student_duty).fallback(R.drawable.icon_student_duty).error(R.drawable.icon_student_duty);
        if (isDestroy((Activity) context)) {
            return;
        }
        Glide.with(context).load(str).apply((BaseRequestOptions<?>) requestOptionsError).into(imageView);
    }

    public static void loadBook(Context context, String str, ImageView imageView) {
        RequestOptions requestOptionsError = new RequestOptions().placeholder(R.drawable.book_loading).fallback(R.drawable.book_nomal).error(R.drawable.book_nomal);
        if (isDestroy((Activity) context)) {
            return;
        }
        Glide.with(context).load(str).apply((BaseRequestOptions<?>) requestOptionsError).into(imageView);
    }

    public static void loadBook2(Context context, String str, ImageView imageView) {
        RequestOptions requestOptionsError = new RequestOptions().placeholder(R.drawable.book_loading).fallback(R.drawable.book_nomal2).error(R.drawable.book_nomal2);
        if (isDestroy((Activity) context)) {
            return;
        }
        Glide.with(context).load(str).apply((BaseRequestOptions<?>) requestOptionsError).into(imageView);
    }

    private static RequestOptions getRequestOptions(Context context, int i, int i2) {
        if (i == 1) {
            return RequestOptions.bitmapTransform(new CircleCrop()).error(R.mipmap.de1);
        }
        if (i == 2) {
            return new RequestOptions().error(R.mipmap.de1).transform(new CenterCrop(), new RoundedCorners(UIUtil.dip2px(context, i2)));
        }
        if (i == 3) {
            return new RequestOptions().diskCacheStrategy(DiskCacheStrategy.RESOURCE).error(R.mipmap.de1);
        }
        return new RequestOptions().error(R.mipmap.de1);
    }

    public static void loadImageRadius(Context context, String str, ImageView imageView, int i, int i2) {
        if (isDestroy((Activity) context)) {
            return;
        }
        Glide.with(context).load(str).placeholder(i).error(i).apply((BaseRequestOptions<?>) new RequestOptions().transforms(new CenterCrop(), new RoundedCorners(i2))).into(imageView);
    }

    public static void loadNomalImage(Context context, String str, ImageView imageView) {
        RequestOptions requestOptions = new RequestOptions();
        Log.i("TAG", "loadNomalImage: " + str);
        if (isDestroy((Activity) context)) {
            return;
        }
        Glide.with(context).load(DataUrl(str)).apply((BaseRequestOptions<?>) requestOptions).into(imageView);
    }

    public static void loadRoundedImage(ImageView imageView, String str) {
        new RequestOptions().error(R.mipmap.de1);
        Glide.with(imageView.getContext()).load(DataUrl(str)).apply((BaseRequestOptions<?>) RequestOptions.bitmapTransform(new RoundedCorners(25))).into(imageView);
    }

    public static boolean isDestroy(Activity activity) {
        if (activity == null || activity.isFinishing()) {
            return true;
        }
        return Build.VERSION.SDK_INT >= 17 && activity.isDestroyed();
    }
}
