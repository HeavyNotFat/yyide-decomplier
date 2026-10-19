package com.yd.android_brand_mvp.queue;

import com.yd.android_brand_mvp.mqtt.MQTTClient;
import com.yd.android_brand_mvp.mqtt.MQTTEventBean;
import java.util.concurrent.ConcurrentLinkedQueue;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: compiled from: FaceQueueThread.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0006\u0010\r\u001a\u00020\u000eJ\u000e\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\fJ\b\u0010\u0011\u001a\u00020\u000eH\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0004@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lcom/yd/android_brand_mvp/queue/FaceQueueThread;", "Ljava/lang/Thread;", "()V", "isProcess", "", "<set-?>", "isRunning", "()Z", "lock", "", "mQueue", "Ljava/util/concurrent/ConcurrentLinkedQueue;", "Lcom/yd/android_brand_mvp/mqtt/MQTTEventBean;", "awake", "", "enqueue", "bean", "run", "app_commonRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class FaceQueueThread extends Thread {
    private final Object lock = new Object();
    private final ConcurrentLinkedQueue<MQTTEventBean> mQueue = new ConcurrentLinkedQueue<>();
    private boolean isProcess = true;
    private boolean isRunning = true;

    /* JADX INFO: renamed from: isRunning, reason: from getter */
    public final boolean getIsRunning() {
        return this.isRunning;
    }

    public final void enqueue(MQTTEventBean bean) {
        Intrinsics.checkNotNullParameter(bean, "bean");
        this.mQueue.add(bean);
        if (this.isRunning) {
            return;
        }
        awake();
    }

    public final void awake() {
        synchronized (this.lock) {
            this.lock.notify();
            Unit unit = Unit.INSTANCE;
        }
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        MQTTEventBean mQTTEventBeanPoll;
        while (true) {
            synchronized (this.lock) {
                this.isRunning = true;
                while (!this.mQueue.isEmpty()) {
                    Ref.ObjectRef objectRef = new Ref.ObjectRef();
                    if (this.isProcess && (mQTTEventBeanPoll = this.mQueue.poll()) != null) {
                        try {
                            this.isProcess = false;
                            BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), null, null, new FaceQueueThread$run$1$1(mQTTEventBeanPoll, objectRef, this, null), 3, null);
                        } catch (Exception e) {
                            e.printStackTrace();
                            this.isRunning = false;
                            this.isProcess = true;
                            if (mQTTEventBeanPoll != null) {
                                MQTTClient.INSTANCE.publishFail(mQTTEventBeanPoll.getId(), "添加失败：" + e.getMessage());
                            }
                        }
                    }
                }
                this.isRunning = false;
                try {
                    this.lock.wait();
                } catch (InterruptedException e2) {
                    this.isProcess = true;
                    e2.printStackTrace();
                }
                Unit unit = Unit.INSTANCE;
            }
        }
    }
}
