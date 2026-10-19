package com.yd.android_brand_mvp.queue;

import android.app.Application;
import android.text.TextUtils;
import android.util.Log;
import com.blankj.utilcode.util.LogUtils;
import com.blankj.utilcode.util.Utils;
import com.yd.android_brand_mvp.base.MinaConstants;
import com.yd.android_brand_mvp.observer.MinaEventManager;
import com.yyide.facepass.AppExtKt;
import com.yyide.facepass.FaceManager;
import com.yyide.facepass.OnExtractFeatureCallback;
import com.yyide.facepass.OnFaceAddCallBack;
import com.yyide.facepass.bean.FaceAddBean;
import com.yyide.facepass.bean.FaceExtractBean;
import com.yyide.facepass.database.DatabaseUtil;
import com.yyide.facepass.util.GsonUtils;
import java.util.concurrent.ConcurrentLinkedQueue;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: compiled from: FaceExtractQueueThread.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001:\u0001\u0014B\u0005¢\u0006\u0002\u0010\u0002J\u0006\u0010\r\u001a\u00020\u000eJ\u000e\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\nJ\u0006\u0010\u0005\u001a\u00020\u0004J\b\u0010\u0011\u001a\u00020\u000eH\u0016J\u000e\u0010\u0012\u001a\u00020\u000e2\u0006\u0010\u000b\u001a\u00020\fJ\u0006\u0010\u0013\u001a\u00020\u000eR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Lcom/yd/android_brand_mvp/queue/FaceExtractQueueThread;", "Ljava/lang/Thread;", "()V", "isProcess", "", "isRunning", "lock", "", "mQueue", "Ljava/util/concurrent/ConcurrentLinkedQueue;", "Lcom/yyide/facepass/bean/FaceExtractBean;", "onFaceExtractCallback", "Lcom/yd/android_brand_mvp/queue/FaceExtractQueueThread$OnFaceExtractCallback;", "awake", "", "enqueue", "bean", "run", "setOnFaceExtractCallback", "startProcess", "OnFaceExtractCallback", "app_commonRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class FaceExtractQueueThread extends Thread {
    private OnFaceExtractCallback onFaceExtractCallback;
    private final Object lock = new Object();
    private final ConcurrentLinkedQueue<FaceExtractBean> mQueue = new ConcurrentLinkedQueue<>();
    private boolean isProcess = true;
    private boolean isRunning = true;

    /* JADX INFO: compiled from: FaceExtractQueueThread.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0006"}, d2 = {"Lcom/yd/android_brand_mvp/queue/FaceExtractQueueThread$OnFaceExtractCallback;", "", "onExtractFeature", "", "faces", "Lcom/yyide/facepass/bean/FaceExtractBean;", "app_commonRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public interface OnFaceExtractCallback {
        void onExtractFeature(FaceExtractBean faces);
    }

    public final void setOnFaceExtractCallback(OnFaceExtractCallback onFaceExtractCallback) {
        Intrinsics.checkNotNullParameter(onFaceExtractCallback, "onFaceExtractCallback");
        this.onFaceExtractCallback = onFaceExtractCallback;
    }

    public final void enqueue(FaceExtractBean bean) {
        Intrinsics.checkNotNullParameter(bean, "bean");
        this.mQueue.add(bean);
        if (getIsRunning()) {
            return;
        }
        Log.i("FaceExtractQueueThread", "awake");
        awake();
    }

    /* JADX INFO: renamed from: isRunning, reason: from getter */
    public final boolean getIsRunning() {
        return this.isRunning;
    }

    public final void awake() {
        synchronized (this.lock) {
            this.lock.notify();
            Unit unit = Unit.INSTANCE;
        }
    }

    public final void startProcess() {
        this.isProcess = true;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        final FaceExtractBean faceExtractBeanPoll;
        while (true) {
            synchronized (this.lock) {
                this.isRunning = true;
                while (!this.mQueue.isEmpty()) {
                    if (this.isProcess && (faceExtractBeanPoll = this.mQueue.poll()) != null) {
                        try {
                            this.isProcess = false;
                            BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getMain()), null, null, new FaceExtractQueueThread$run$1$1(null), 3, null);
                            if (!TextUtils.isEmpty(faceExtractBeanPoll.getImgPath())) {
                                FaceManager faceManager = FaceManager.INSTANCE;
                                Application app = Utils.getApp();
                                Intrinsics.checkNotNullExpressionValue(app, "getApp()");
                                faceManager.extractFeature(app, faceExtractBeanPoll, true, new OnExtractFeatureCallback() { // from class: com.yd.android_brand_mvp.queue.FaceExtractQueueThread$run$1$2
                                    @Override // com.yyide.facepass.OnExtractFeatureCallback
                                    public void onExtractFeature(FaceExtractBean faces) {
                                        Intrinsics.checkNotNullParameter(faces, "faces");
                                        Log.i("FaceExtractQueueThread", "提取成功 = " + GsonUtils.toJson(faces));
                                        DatabaseUtil databaseUtil = DatabaseUtil.INSTANCE;
                                        Application app2 = Utils.getApp();
                                        Intrinsics.checkNotNullExpressionValue(app2, "getApp()");
                                        Application application = app2;
                                        String userId = faceExtractBeanPoll.getUserId();
                                        if (userId == null) {
                                            userId = "";
                                        }
                                        databaseUtil.deleteRecords(application, userId);
                                        faces.setStatus("success");
                                        FaceExtractQueueThread.OnFaceExtractCallback onFaceExtractCallback = this.onFaceExtractCallback;
                                        if (onFaceExtractCallback != null) {
                                            onFaceExtractCallback.onExtractFeature(faces);
                                        }
                                        this.isProcess = true;
                                    }

                                    @Override // com.yyide.facepass.OnExtractFeatureCallback
                                    public void onExtractFeatureError(String error) {
                                        Intrinsics.checkNotNullParameter(error, "error");
                                        Log.i("FaceExtractQueueThread", "onExtractFeatureError = " + error);
                                        DatabaseUtil databaseUtil = DatabaseUtil.INSTANCE;
                                        Application app2 = Utils.getApp();
                                        Intrinsics.checkNotNullExpressionValue(app2, "getApp()");
                                        Application application = app2;
                                        String userId = faceExtractBeanPoll.getUserId();
                                        if (userId == null) {
                                            userId = "";
                                        }
                                        databaseUtil.updateRecordsType(application, userId, -1, error);
                                        faceExtractBeanPoll.setErrorMsg(error);
                                        faceExtractBeanPoll.setStatus("failure");
                                        FaceExtractQueueThread.OnFaceExtractCallback onFaceExtractCallback = this.onFaceExtractCallback;
                                        if (onFaceExtractCallback != null) {
                                            FaceExtractBean bean = faceExtractBeanPoll;
                                            Intrinsics.checkNotNullExpressionValue(bean, "bean");
                                            onFaceExtractCallback.onExtractFeature(bean);
                                        }
                                        this.isProcess = true;
                                    }
                                });
                            } else {
                                FaceAddBean faceAddBean = new FaceAddBean(faceExtractBeanPoll.getName(), faceExtractBeanPoll.getUserId(), faceExtractBeanPoll.getCardNumber(), faceExtractBeanPoll.getUserType(), null, null, null, 112, null);
                                FaceManager faceManager2 = FaceManager.INSTANCE;
                                Application app2 = Utils.getApp();
                                Intrinsics.checkNotNullExpressionValue(app2, "getApp()");
                                faceManager2.addFace(app2, faceAddBean, new OnFaceAddCallBack() { // from class: com.yd.android_brand_mvp.queue.FaceExtractQueueThread$run$1$3
                                    @Override // com.yyide.facepass.OnFaceAddCallBack
                                    public void onFaceAddSuccess(FaceAddBean data) {
                                        Intrinsics.checkNotNullParameter(data, "data");
                                        AppExtKt.logd(this, "faceAddSuccess=" + GsonUtils.toJson(data));
                                        faceExtractBeanPoll.setStatus("success");
                                        this.isProcess = true;
                                        DatabaseUtil databaseUtil = DatabaseUtil.INSTANCE;
                                        Application app3 = Utils.getApp();
                                        Intrinsics.checkNotNullExpressionValue(app3, "getApp()");
                                        Application application = app3;
                                        String userId = faceExtractBeanPoll.getUserId();
                                        if (userId == null) {
                                            userId = "";
                                        }
                                        databaseUtil.deleteRecords(application, userId);
                                        FaceExtractQueueThread.OnFaceExtractCallback onFaceExtractCallback = this.onFaceExtractCallback;
                                        if (onFaceExtractCallback != null) {
                                            FaceExtractBean bean = faceExtractBeanPoll;
                                            Intrinsics.checkNotNullExpressionValue(bean, "bean");
                                            onFaceExtractCallback.onExtractFeature(bean);
                                        }
                                    }

                                    @Override // com.yyide.facepass.OnFaceAddCallBack
                                    public void onFaceAddFailed(String msg) {
                                        Intrinsics.checkNotNullParameter(msg, "msg");
                                        AppExtKt.logd(this, "onFaceExtractFailed=" + msg);
                                        DatabaseUtil databaseUtil = DatabaseUtil.INSTANCE;
                                        Application app3 = Utils.getApp();
                                        Intrinsics.checkNotNullExpressionValue(app3, "getApp()");
                                        Application application = app3;
                                        String userId = faceExtractBeanPoll.getUserId();
                                        if (userId == null) {
                                            userId = "";
                                        }
                                        databaseUtil.updateRecordsType(application, userId, -1, msg);
                                        faceExtractBeanPoll.setErrorMsg(msg);
                                        faceExtractBeanPoll.setStatus("failure");
                                        this.isProcess = true;
                                        FaceExtractQueueThread.OnFaceExtractCallback onFaceExtractCallback = this.onFaceExtractCallback;
                                        if (onFaceExtractCallback != null) {
                                            FaceExtractBean bean = faceExtractBeanPoll;
                                            Intrinsics.checkNotNullExpressionValue(bean, "bean");
                                            onFaceExtractCallback.onExtractFeature(bean);
                                        }
                                    }
                                });
                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                            this.isProcess = true;
                            this.isRunning = false;
                            LogUtils.i("处理人脸入库异常 = " + e.getMessage());
                            try {
                                this.lock.wait();
                            } catch (InterruptedException e2) {
                                e2.printStackTrace();
                            }
                        }
                    }
                }
                this.isRunning = false;
                try {
                    Log.i("FaceExtractQueueThread", "wait");
                    MinaEventManager.getInstance().notifyObserver(MinaConstants.PhotoVideo);
                    this.lock.wait();
                } catch (InterruptedException e3) {
                    e3.printStackTrace();
                }
                Unit unit = Unit.INSTANCE;
            }
        }
    }
}
