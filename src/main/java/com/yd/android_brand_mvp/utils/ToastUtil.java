package com.yd.android_brand_mvp.utils;

import android.app.Activity;
import android.content.Context;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.alibaba.fastjson.JSON;
import com.bumptech.glide.Glide;
import com.yd.android_brand_mvp.R;
import com.yd.android_brand_mvp.model.GeneralBean;
import java.io.File;

/* JADX INFO: loaded from: classes4.dex */
public class ToastUtil {
    private static Toast sToast;
    private static final Handler HANDLER = new Handler(Looper.getMainLooper());
    private static int sLayoutId = -1;
    private static int gravity = 81;
    private static int xOffset = 0;
    private static int yOffset = (int) (((double) (com.blankj.utilcode.util.Utils.getApp().getResources().getDisplayMetrics().density * 64.0f)) + 0.5d);
    private static final int COLOR_DEFAULT = -268435456;
    private static int bgColor = COLOR_DEFAULT;
    private static int bgResource = -1;
    private static int msgColor = COLOR_DEFAULT;

    public static void cancel() {
        Toast toast = sToast;
        if (toast != null) {
            toast.cancel();
            sToast = null;
        }
    }

    private static void setBgAndGravity() {
        View view = sToast.getView();
        int i = bgResource;
        if (i != -1) {
            view.setBackgroundResource(i);
        } else if (bgColor != COLOR_DEFAULT) {
            view.getBackground().setColorFilter(new PorterDuffColorFilter(bgColor, PorterDuff.Mode.SRC_IN));
        }
        sToast.setGravity(gravity, xOffset, yOffset);
    }

    public static void showView(Activity activity, GeneralBean.DataBean dataBean, String str) {
        if (activity.isFinishing()) {
            return;
        }
        final View viewInflate = activity.getLayoutInflater().inflate(R.layout.punch_card_toast, (ViewGroup) null);
        ImageView imageView = (ImageView) viewInflate.findViewById(R.id.iv_img);
        TextView textView = (TextView) viewInflate.findViewById(R.id.tv_name);
        TextView textView2 = (TextView) viewInflate.findViewById(R.id.tv_time);
        TextView textView3 = (TextView) viewInflate.findViewById(R.id.tv_msg);
        Log.e("TAG", "showView: " + JSON.toJSONString(dataBean));
        if (dataBean != null) {
            textView.setText(dataBean.peopleName + "");
            textView2.setText(dataBean.createdDateTime + "");
            if (!com.blankj.utilcode.util.StringUtils.isEmpty(str)) {
                Glide.with(activity).load(new File(str)).into(imageView);
            } else if (!TextUtils.isEmpty(dataBean.path)) {
                new File(dataBean.path);
                GlideUtil.loadCircleHeadImage(activity, " ", imageView);
            }
            textView3.setText(dataBean.message + "");
        }
        HANDLER.post(new Runnable() { // from class: com.yd.android_brand_mvp.utils.ToastUtil.1
            @Override // java.lang.Runnable
            public void run() {
                ToastUtil.cancel();
                Toast unused = ToastUtil.sToast = new Toast(com.blankj.utilcode.util.Utils.getApp());
                ToastUtil.sToast.setView(viewInflate);
                ToastUtil.sToast.setGravity(119, 0, 0);
                ToastUtil.sToast.getView().setSystemUiVisibility(1024);
                ToastUtil.sToast.setDuration(1);
                ToastUtil.sToast.show();
            }
        });
    }

    public static void showView(Activity activity, String str) {
        if (com.blankj.utilcode.util.StringUtils.isEmpty(str) || activity.isFinishing()) {
            return;
        }
        final View viewInflate = activity.getLayoutInflater().inflate(R.layout.punch_card_toast_error, (ViewGroup) null);
        ((TextView) viewInflate.findViewById(R.id.tv_msg)).setText(str);
        HANDLER.post(new Runnable() { // from class: com.yd.android_brand_mvp.utils.ToastUtil.2
            @Override // java.lang.Runnable
            public void run() {
                ToastUtil.cancel();
                Toast unused = ToastUtil.sToast = new Toast(com.blankj.utilcode.util.Utils.getApp());
                ToastUtil.sToast.setView(viewInflate);
                ToastUtil.sToast.setGravity(119, 0, 0);
                ToastUtil.sToast.getView().setSystemUiVisibility(1024);
                ToastUtil.sToast.setDuration(1);
                ToastUtil.sToast.show();
            }
        });
    }

    public static void showViewCard(Activity activity) {
        final View viewInflate = activity.getLayoutInflater().inflate(R.layout.punch_card_toast_success, (ViewGroup) null);
        HANDLER.post(new Runnable() { // from class: com.yd.android_brand_mvp.utils.-$$Lambda$ToastUtil$QMFwqO1tBJpEY5F2ks0F9zwtFq0
            @Override // java.lang.Runnable
            public final void run() {
                ToastUtil.lambda$showViewCard$0(viewInflate);
            }
        });
    }

    static /* synthetic */ void lambda$showViewCard$0(View view) {
        cancel();
        Toast toast = new Toast(com.blankj.utilcode.util.Utils.getApp());
        sToast = toast;
        toast.setView(view);
        sToast.setGravity(119, 0, 0);
        sToast.getView().setSystemUiVisibility(1024);
        sToast.setDuration(1);
        sToast.show();
    }

    public static void showBottomView(Context context, String str) {
        if (com.blankj.utilcode.util.StringUtils.isEmpty(str)) {
            return;
        }
        final View viewInflate = LayoutInflater.from(context).inflate(R.layout.mytoast_layout, (ViewGroup) null);
        ((TextView) viewInflate.findViewById(R.id.tv_msg)).setText(str);
        HANDLER.post(new Runnable() { // from class: com.yd.android_brand_mvp.utils.ToastUtil.3
            @Override // java.lang.Runnable
            public void run() {
                ToastUtil.cancel();
                Toast unused = ToastUtil.sToast = new Toast(com.blankj.utilcode.util.Utils.getApp());
                ToastUtil.sToast.setView(viewInflate);
                ToastUtil.sToast.setGravity(119, 0, 0);
                ToastUtil.sToast.getView().setSystemUiVisibility(1024);
                ToastUtil.sToast.setDuration(1);
                ToastUtil.sToast.show();
            }
        });
    }

    public static void showBottomView(Activity activity, String str) {
        if (com.blankj.utilcode.util.StringUtils.isEmpty(str) || activity.isFinishing()) {
            return;
        }
        final View viewInflate = LayoutInflater.from(activity).inflate(R.layout.mytoast_layout, (ViewGroup) null);
        ((TextView) viewInflate.findViewById(R.id.tv_msg)).setText(str);
        HANDLER.removeCallbacks(null);
        HANDLER.post(new Runnable() { // from class: com.yd.android_brand_mvp.utils.-$$Lambda$ToastUtil$zi8cySfQCWkR_r0-Jl27Ig2mhqE
            @Override // java.lang.Runnable
            public final void run() {
                ToastUtil.lambda$showBottomView$1(viewInflate);
            }
        });
    }

    static /* synthetic */ void lambda$showBottomView$1(View view) {
        cancel();
        Toast toast = new Toast(com.blankj.utilcode.util.Utils.getApp());
        sToast = toast;
        toast.setView(view);
        sToast.setGravity(119, 0, 0);
        sToast.getView().setSystemUiVisibility(1024);
        sToast.setDuration(1);
        sToast.show();
    }

    public static void showFaceBottomView(Context context, String str) {
        if (com.blankj.utilcode.util.StringUtils.isEmpty(str)) {
            return;
        }
        final View viewInflate = LayoutInflater.from(context).inflate(R.layout.layout_face_hint, (ViewGroup) null);
        ((TextView) viewInflate.findViewById(R.id.tv_top_lint)).setText(str);
        HANDLER.post(new Runnable() { // from class: com.yd.android_brand_mvp.utils.ToastUtil.4
            @Override // java.lang.Runnable
            public void run() {
                ToastUtil.cancel();
                Toast unused = ToastUtil.sToast = new Toast(com.blankj.utilcode.util.Utils.getApp());
                ToastUtil.sToast.setView(viewInflate);
                ToastUtil.sToast.setGravity(119, 0, 0);
                ToastUtil.sToast.getView().setSystemUiVisibility(1024);
                ToastUtil.sToast.setDuration(1);
                ToastUtil.sToast.show();
            }
        });
    }
}
