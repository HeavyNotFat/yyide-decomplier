package com.yd.android_brand_mvp.mqtt;

import android.app.Application;
import android.content.Context;
import android.os.Handler;
import android.util.Log;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.work.Data;
import androidx.work.WorkRequest;
import com.blankj.utilcode.util.LogUtils;
import com.blankj.utilcode.util.Utils;
import com.yd.android_brand_mvp.BaseApplication;
import com.yd.android_brand_mvp.utils.Base64Utils;
import com.yd.android_brand_mvp.utils.SpData;
import com.yd.android_brand_mvp.utils.view.net.GsonUtils;
import java.util.Timer;
import java.util.TimerTask;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.DelayKt;
import kotlinx.coroutines.Dispatchers;
import org.eclipse.paho.android.service.MqttAndroidClient;
import org.eclipse.paho.android.service.MqttServiceConstants;
import org.eclipse.paho.android.service.MqttTraceHandler;
import org.eclipse.paho.client.mqttv3.IMqttActionListener;
import org.eclipse.paho.client.mqttv3.IMqttDeliveryToken;
import org.eclipse.paho.client.mqttv3.IMqttToken;
import org.eclipse.paho.client.mqttv3.MqttCallback;
import org.eclipse.paho.client.mqttv3.MqttCallbackExtended;
import org.eclipse.paho.client.mqttv3.MqttConnectOptions;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.MqttMessage;

/* JADX INFO: compiled from: MQTTClient.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0010\bÆ\u0002\u0018\u00002\u00020\u0001:\u0002HIB\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001e\u00100\u001a\u0002012\u0006\u00102\u001a\u0002032\u0006\u0010$\u001a\u00020\u00042\u0006\u0010\u001f\u001a\u00020\u0004J\u0006\u00104\u001a\u000201J\b\u00105\u001a\u000201H\u0002J*\u00106\u001a\u0002012\u0006\u00107\u001a\u00020\u00042\u0006\u00108\u001a\u00020\u00042\b\b\u0002\u00109\u001a\u00020:2\b\b\u0002\u0010;\u001a\u00020\u0015J\u0018\u0010<\u001a\u0002012\b\u0010=\u001a\u0004\u0018\u00010\u00042\u0006\u0010>\u001a\u00020\u0004J\u0010\u0010?\u001a\u0002012\b\u0010=\u001a\u0004\u0018\u00010\u0004J\u0018\u0010@\u001a\u0002012\b\u0010=\u001a\u0004\u0018\u00010\u00042\u0006\u0010>\u001a\u00020\u0004J\u0016\u0010A\u001a\u0002012\u0006\u00107\u001a\u00020\u00042\u0006\u0010B\u001a\u00020\u0004J\b\u0010C\u001a\u000201H\u0002J\b\u0010D\u001a\u000201H\u0002J\u000e\u0010E\u001a\u0002012\u0006\u0010\u0019\u001a\u00020\u001aJ\u0018\u0010F\u001a\u0002012\u0006\u00107\u001a\u00020\u00042\b\b\u0002\u00109\u001a\u00020:J\u000e\u0010G\u001a\u0002012\u0006\u00107\u001a\u00020\u0004R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u001a\u0010\u0006\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001a\u0010\u000b\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\b\"\u0004\b\r\u0010\nR\u0014\u0010\u000e\u001a\u00020\u0004X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\bR\u000e\u0010\u0010\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u0011\u0010\u0012\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\bR\u001a\u0010\u0014\u001a\u00020\u0015X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u001c\u0010\u0019\u001a\u0004\u0018\u00010\u001aX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\u000e\u0010\u001f\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010 \u001a\u0004\u0018\u00010!X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\"\u001a\u00020\u0004X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b#\u0010\bR\u000e\u0010$\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010%\u001a\u0004\u0018\u00010&X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010'\u001a\u00020(X\u0082T¢\u0006\u0002\n\u0000R\u0010\u0010)\u001a\u0004\u0018\u00010*X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010+\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010,\u001a\u00020\u0004X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b-\u0010\bR\u0014\u0010.\u001a\u00020\u0004X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b/\u0010\b¨\u0006J"}, d2 = {"Lcom/yd/android_brand_mvp/mqtt/MQTTClient;", "", "()V", "BIZ_SYNC_DEVICE_INFORMATION", "", "BIZ_SYS_DEVICE_RUNNING_STATE", "REPORT_CURRENT_PICTURE", "getREPORT_CURRENT_PICTURE", "()Ljava/lang/String;", "setREPORT_CURRENT_PICTURE", "(Ljava/lang/String;)V", "Receive_WEB", "getReceive_WEB", "setReceive_WEB", "TAG", "getTAG", "TOPIC", "TOPIC_LOG", "TOPIC_SYNC", "getTOPIC_SYNC", "isConnection", "", "()Z", "setConnection", "(Z)V", "mOnMessageCallBack", "Lcom/yd/android_brand_mvp/mqtt/MQTTClient$OnMessageCallBack;", "getMOnMessageCallBack", "()Lcom/yd/android_brand_mvp/mqtt/MQTTClient$OnMessageCallBack;", "setMOnMessageCallBack", "(Lcom/yd/android_brand_mvp/mqtt/MQTTClient$OnMessageCallBack;)V", "mac", "mqttClient", "Lorg/eclipse/paho/android/service/MqttAndroidClient;", "password", "getPassword", "schoolId", "task", "Ljava/util/TimerTask;", "time", "", "timer", "Ljava/util/Timer;", "topicHead", "uat_password", "getUat_password", "username", "getUsername", "connect", "", "context", "Landroid/content/Context;", "disconnect", "initEvent", "publish", "topic", "msg", MqttServiceConstants.QOS, "", MqttServiceConstants.RETAINED, "publishFail", "id", "remake", "publishReceive", "publishSuccess", "publishTopic", "message", "pushAppRunStatus", "reReconnect", "setOnMessageCallBack", MqttServiceConstants.SUBSCRIBE_ACTION, MqttServiceConstants.UNSUBSCRIBE_ACTION, "OnMessageCallBack", "QosEnum", "app_commonRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class MQTTClient {
    public static final String BIZ_SYNC_DEVICE_INFORMATION = "/biz/sync/device/system/information";
    public static final String BIZ_SYS_DEVICE_RUNNING_STATE = "/biz/sync/device/running/state";
    public static final String TOPIC_LOG = "upload/log/message";
    private static boolean isConnection = false;
    private static OnMessageCallBack mOnMessageCallBack = null;
    private static MqttAndroidClient mqttClient = null;
    private static TimerTask task = null;
    private static final long time = 900000;
    private static Timer timer;
    public static final MQTTClient INSTANCE = new MQTTClient();
    private static final String TAG = "MQTTClient";
    private static final String username = "yide";
    private static final String password = "m8IFxdsRMkEFfaO1";
    private static final String uat_password = "yide123456";
    private static String schoolId = "";
    private static String mac = "";
    private static String topicHead = "brand";
    private static String TOPIC = "";
    private static final String TOPIC_SYNC = topicHead + "/sync/message/status";
    private static String REPORT_CURRENT_PICTURE = "";
    private static String Receive_WEB = "";

    /* JADX INFO: compiled from: MQTTClient.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H&¨\u0006\u0006"}, d2 = {"Lcom/yd/android_brand_mvp/mqtt/MQTTClient$OnMessageCallBack;", "", "onMessage", "", "bean", "Lcom/yd/android_brand_mvp/mqtt/MQTTEventBean;", "app_commonRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public interface OnMessageCallBack {
        void onMessage(MQTTEventBean bean);
    }

    private MQTTClient() {
    }

    public final String getTAG() {
        return TAG;
    }

    public final String getUsername() {
        return username;
    }

    public final String getPassword() {
        return password;
    }

    public final String getUat_password() {
        return uat_password;
    }

    public final boolean isConnection() {
        return isConnection;
    }

    public final void setConnection(boolean z) {
        isConnection = z;
    }

    public final String getTOPIC_SYNC() {
        return TOPIC_SYNC;
    }

    public final String getREPORT_CURRENT_PICTURE() {
        return REPORT_CURRENT_PICTURE;
    }

    public final void setREPORT_CURRENT_PICTURE(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        REPORT_CURRENT_PICTURE = str;
    }

    public final String getReceive_WEB() {
        return Receive_WEB;
    }

    public final void setReceive_WEB(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        Receive_WEB = str;
    }

    public final void connect(Context context, String schoolId2, String mac2) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(schoolId2, "schoolId");
        Intrinsics.checkNotNullParameter(mac2, "mac");
        schoolId = schoolId2;
        mac = mac2;
        TOPIC = topicHead + '/' + schoolId2 + '/' + mac2;
        StringBuilder sb = new StringBuilder();
        sb.append("Connection MAC = ");
        sb.append(mac2);
        LogUtils.d(sb.toString());
        LogUtils.d("Connection URL = tcp://116.63.71.76:1883");
        REPORT_CURRENT_PICTURE = "device_web/deviceImages/" + mac2;
        Receive_WEB = "device_web/push/" + mac2;
        if (mqttClient == null) {
            mqttClient = new MqttAndroidClient(context, "tcp://116.63.71.76:1883", TOPIC);
        }
        MqttAndroidClient mqttAndroidClient = mqttClient;
        if (mqttAndroidClient != null) {
            mqttAndroidClient.setTraceEnabled(true);
        }
        MqttAndroidClient mqttAndroidClient2 = mqttClient;
        if (mqttAndroidClient2 != null) {
            mqttAndroidClient2.setTraceCallback(new MqttTraceHandler() { // from class: com.yd.android_brand_mvp.mqtt.MQTTClient.connect.1
                @Override // org.eclipse.paho.android.service.MqttTraceHandler
                public void traceDebug(String tag, String message) {
                }

                @Override // org.eclipse.paho.android.service.MqttTraceHandler
                public void traceError(String tag, String message) {
                    LogUtils.e("traceError: " + message);
                    if (!(message != null && StringsKt.contains$default((CharSequence) message, (CharSequence) "connect fail", false, 2, (Object) null))) {
                        if (!(message != null && StringsKt.contains$default((CharSequence) message, (CharSequence) "call connect to reconnect.reason", false, 2, (Object) null))) {
                            return;
                        }
                    }
                    MQTTClient.INSTANCE.reReconnect();
                }

                @Override // org.eclipse.paho.android.service.MqttTraceHandler
                public void traceException(String tag, String message, Exception e) {
                    Object[] objArr = new Object[1];
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("traceException: ");
                    sb2.append(message);
                    sb2.append(" 异常：");
                    sb2.append(e != null ? e.getMessage() : null);
                    objArr[0] = sb2.toString();
                    LogUtils.e(objArr);
                }
            });
        }
        MqttAndroidClient mqttAndroidClient3 = mqttClient;
        if (mqttAndroidClient3 != null) {
            mqttAndroidClient3.setCallback(new AnonymousClass2());
        }
        MqttConnectOptions mqttConnectOptions = new MqttConnectOptions();
        mqttConnectOptions.setAutomaticReconnect(true);
        mqttConnectOptions.setKeepAliveInterval(10);
        mqttConnectOptions.setConnectionTimeout(10);
        mqttConnectOptions.setMaxReconnectDelay(10000);
        mqttConnectOptions.setCleanSession(true);
        mqttConnectOptions.setUserName(username);
        char[] charArray = password.toCharArray();
        Intrinsics.checkNotNullExpressionValue(charArray, "this as java.lang.String).toCharArray()");
        mqttConnectOptions.setPassword(charArray);
        mqttConnectOptions.setMaxInflight(Data.MAX_DATA_BYTES);
        try {
            MqttAndroidClient mqttAndroidClient4 = mqttClient;
            if (mqttAndroidClient4 != null) {
                mqttAndroidClient4.connect(mqttConnectOptions, null, new IMqttActionListener() { // from class: com.yd.android_brand_mvp.mqtt.MQTTClient.connect.3
                    @Override // org.eclipse.paho.client.mqttv3.IMqttActionListener
                    public void onSuccess(IMqttToken asyncActionToken) {
                        LogUtils.i("Connection success");
                        MQTTClient.INSTANCE.publishTopic(MQTTClient.BIZ_SYNC_DEVICE_INFORMATION, AppUtil.INSTANCE.getDeviceInfo());
                        MQTTClient.INSTANCE.setConnection(true);
                        MQTTClient.INSTANCE.initEvent();
                    }

                    @Override // org.eclipse.paho.client.mqttv3.IMqttActionListener
                    public void onFailure(IMqttToken asyncActionToken, Throwable exception) {
                        LogUtils.e("Connection onFailure 异常:" + exception);
                        MQTTClient.INSTANCE.setConnection(false);
                    }
                });
            }
        } catch (MqttException e) {
            e.printStackTrace();
        }
    }

    /* JADX INFO: renamed from: com.yd.android_brand_mvp.mqtt.MQTTClient$connect$2, reason: invalid class name */
    /* JADX INFO: compiled from: MQTTClient.kt */
    @Metadata(d1 = {"\u00009\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u00012\u00020\u0002J\u001a\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0016J\u0012\u0010\t\u001a\u00020\u00042\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0016J\u0012\u0010\f\u001a\u00020\u00042\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0016J\u001c\u0010\u000f\u001a\u00020\u00042\b\u0010\u0010\u001a\u0004\u0018\u00010\b2\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0016¨\u0006\u0013"}, d2 = {"com/yd/android_brand_mvp/mqtt/MQTTClient$connect$2", "Lorg/eclipse/paho/client/mqttv3/MqttCallback;", "Lorg/eclipse/paho/client/mqttv3/MqttCallbackExtended;", "connectComplete", "", "reconnect", "", "serverURI", "", "connectionLost", "cause", "", "deliveryComplete", "token", "Lorg/eclipse/paho/client/mqttv3/IMqttDeliveryToken;", MqttServiceConstants.MESSAGE_ARRIVED_ACTION, "topic", "message", "Lorg/eclipse/paho/client/mqttv3/MqttMessage;", "app_commonRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class AnonymousClass2 implements MqttCallback, MqttCallbackExtended {
        AnonymousClass2() {
        }

        @Override // org.eclipse.paho.client.mqttv3.MqttCallback
        public void messageArrived(String topic, MqttMessage message) {
            LogUtils.i("Receive message: " + message);
            MQTTEventBean mQTTEventBean = (MQTTEventBean) GsonUtils.fromJson(String.valueOf(message), MQTTEventBean.class);
            if (mQTTEventBean != null) {
                MQTTClient.INSTANCE.publishReceive(mQTTEventBean.getId());
                OnMessageCallBack mOnMessageCallBack = MQTTClient.INSTANCE.getMOnMessageCallBack();
                if (mOnMessageCallBack != null) {
                    mOnMessageCallBack.onMessage(mQTTEventBean);
                }
            }
        }

        @Override // org.eclipse.paho.client.mqttv3.MqttCallback
        public void connectionLost(Throwable cause) {
            LogUtils.e("连接丢失 ConnectionLost：" + cause);
            MQTTClient.INSTANCE.reReconnect();
        }

        @Override // org.eclipse.paho.client.mqttv3.MqttCallback
        public void deliveryComplete(IMqttDeliveryToken token) {
            LogUtils.i("deliveryComplete");
        }

        @Override // org.eclipse.paho.client.mqttv3.MqttCallbackExtended
        public void connectComplete(boolean reconnect, String serverURI) {
            if (reconnect) {
                LogUtils.i("重连成功 " + serverURI);
            } else {
                LogUtils.i("初次连接成功 " + serverURI);
            }
            MQTTClient.INSTANCE.setConnection(true);
            MQTTClient.subscribe$default(MQTTClient.INSTANCE, MQTTClient.TOPIC, 0, 2, null);
            MQTTClient.subscribe$default(MQTTClient.INSTANCE, MQTTClient.INSTANCE.getReceive_WEB(), 0, 2, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void initEvent() {
        pushAppRunStatus();
        MutableLiveData<String> base64LiveData = Base64Utils.INSTANCE.getBase64LiveData();
        final C05461 c05461 = new Function1<String, Unit>() { // from class: com.yd.android_brand_mvp.mqtt.MQTTClient.initEvent.1
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(String str) {
                invoke2(str);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(String it2) {
                MQTTClient mQTTClient = MQTTClient.INSTANCE;
                String report_current_picture = MQTTClient.INSTANCE.getREPORT_CURRENT_PICTURE();
                Intrinsics.checkNotNullExpressionValue(it2, "it");
                mQTTClient.publishTopic(report_current_picture, it2);
            }
        };
        base64LiveData.observeForever(new Observer() { // from class: com.yd.android_brand_mvp.mqtt.-$$Lambda$MQTTClient$AnhVtUa981V3QT8PQ8L74Ia51sk
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                MQTTClient.initEvent$lambda$0(c05461, obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initEvent$lambda$0(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: renamed from: com.yd.android_brand_mvp.mqtt.MQTTClient$reReconnect$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: MQTTClient.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "com.yd.android_brand_mvp.mqtt.MQTTClient$reReconnect$1", f = "MQTTClient.kt", i = {}, l = {185}, m = "invokeSuspend", n = {}, s = {})
    static final class C05491 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        C05491(Continuation<? super C05491> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new C05491(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C05491) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                this.label = 1;
                if (DelayKt.delay(WorkRequest.MIN_BACKOFF_MILLIS, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            LogUtils.i("reReconnect MQTT重连");
            MqttAndroidClient mqttAndroidClient = MQTTClient.mqttClient;
            if ((mqttAndroidClient == null || mqttAndroidClient.isConnected()) ? false : true) {
                try {
                    MQTTClient mQTTClient = MQTTClient.INSTANCE;
                    Application app = Utils.getApp();
                    Intrinsics.checkNotNullExpressionValue(app, "getApp()");
                    String schoolId = SpData.getSchoolId();
                    Intrinsics.checkNotNullExpressionValue(schoolId, "getSchoolId()");
                    String mac = BaseApplication.getInstance().getMac();
                    Intrinsics.checkNotNullExpressionValue(mac, "getInstance().mac");
                    mQTTClient.connect(app, schoolId, mac);
                } catch (MqttException e) {
                    LogUtils.i("重连失败: " + e.getMessage());
                }
            }
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void reReconnect() {
        try {
            BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getMain()), null, null, new C05491(null), 3, null);
        } catch (MqttException e) {
            e.printStackTrace();
        }
    }

    private final void pushAppRunStatus() {
        timer = new Timer();
        TimerTask timerTask = new TimerTask() { // from class: com.yd.android_brand_mvp.mqtt.MQTTClient.pushAppRunStatus.1
            @Override // java.util.TimerTask, java.lang.Runnable
            public void run() {
                if (MQTTClient.INSTANCE.isConnection()) {
                    MQTTClient.INSTANCE.publishTopic(MQTTClient.BIZ_SYS_DEVICE_RUNNING_STATE, AppUtil.INSTANCE.getDeviceRunStatusInfo());
                }
            }
        };
        task = timerTask;
        Timer timer2 = timer;
        if (timer2 != null) {
            timer2.schedule(timerTask, 900000L, 900000L);
        }
    }

    public final void disconnect() {
        try {
            if (mqttClient != null) {
                Thread.sleep(50L);
                MqttAndroidClient mqttAndroidClient = mqttClient;
                if (mqttAndroidClient != null) {
                    mqttAndroidClient.disconnect(null, new IMqttActionListener() { // from class: com.yd.android_brand_mvp.mqtt.MQTTClient.disconnect.1
                        @Override // org.eclipse.paho.client.mqttv3.IMqttActionListener
                        public void onSuccess(IMqttToken asyncActionToken) {
                            LogUtils.i("Disconnected");
                        }

                        @Override // org.eclipse.paho.client.mqttv3.IMqttActionListener
                        public void onFailure(IMqttToken asyncActionToken, Throwable exception) {
                            Object[] objArr = new Object[1];
                            StringBuilder sb = new StringBuilder();
                            sb.append("Failed to disconnect 异常 ");
                            sb.append(exception != null ? exception.getMessage() : null);
                            objArr[0] = sb.toString();
                            LogUtils.e(objArr);
                        }
                    });
                }
            }
            MqttAndroidClient mqttAndroidClient2 = mqttClient;
            if (mqttAndroidClient2 != null) {
                mqttAndroidClient2.unregisterResources();
            }
            mqttClient = null;
            Timer timer2 = timer;
            if (timer2 != null) {
                timer2.cancel();
            }
        } catch (MqttException e) {
            e.printStackTrace();
        }
    }

    public static /* synthetic */ void subscribe$default(MQTTClient mQTTClient, String str, int i, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = 2;
        }
        mQTTClient.subscribe(str, i);
    }

    /* JADX INFO: renamed from: com.yd.android_brand_mvp.mqtt.MQTTClient$subscribe$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: MQTTClient.kt */
    @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001c\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016J\u0012\u0010\b\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016¨\u0006\t"}, d2 = {"com/yd/android_brand_mvp/mqtt/MQTTClient$subscribe$1", "Lorg/eclipse/paho/client/mqttv3/IMqttActionListener;", "onFailure", "", "asyncActionToken", "Lorg/eclipse/paho/client/mqttv3/IMqttToken;", MqttServiceConstants.TRACE_EXCEPTION, "", "onSuccess", "app_commonRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class C05501 implements IMqttActionListener {
        final /* synthetic */ String $topic;

        C05501(String str) {
            this.$topic = str;
        }

        @Override // org.eclipse.paho.client.mqttv3.IMqttActionListener
        public void onSuccess(IMqttToken asyncActionToken) {
            LogUtils.i("Subscribed to " + this.$topic);
        }

        @Override // org.eclipse.paho.client.mqttv3.IMqttActionListener
        public void onFailure(IMqttToken asyncActionToken, Throwable exception) {
            Object[] objArr = new Object[1];
            StringBuilder sb = new StringBuilder();
            sb.append("Failed to subscribe ");
            sb.append(this.$topic);
            sb.append(" 订阅异常：");
            sb.append(exception != null ? exception.getMessage() : null);
            objArr[0] = sb.toString();
            LogUtils.i(objArr);
            Handler handler = new Handler();
            final String str = this.$topic;
            handler.postDelayed(new Runnable() { // from class: com.yd.android_brand_mvp.mqtt.-$$Lambda$MQTTClient$subscribe$1$l9Lvn3-yapsCRwEA55pX_Bhc_aE
                @Override // java.lang.Runnable
                public final void run() {
                    MQTTClient.C05501.onFailure$lambda$0(str);
                }
            }, 5000L);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void onFailure$lambda$0(String topic) {
            Intrinsics.checkNotNullParameter(topic, "$topic");
            MQTTClient.subscribe$default(MQTTClient.INSTANCE, topic, 0, 2, null);
        }
    }

    public final void subscribe(String topic, int qos) {
        MqttAndroidClient mqttAndroidClient;
        Intrinsics.checkNotNullParameter(topic, "topic");
        try {
            if (mqttClient == null || (mqttAndroidClient = mqttClient) == null) {
                return;
            }
            mqttAndroidClient.subscribe(topic, qos, (Object) null, new C05501(topic));
        } catch (MqttException e) {
            LogUtils.i("subscribe crash = " + e.getMessage());
            e.printStackTrace();
        }
    }

    public final void unsubscribe(final String topic) {
        MqttAndroidClient mqttAndroidClient;
        Intrinsics.checkNotNullParameter(topic, "topic");
        try {
            if (mqttClient == null || (mqttAndroidClient = mqttClient) == null) {
                return;
            }
            mqttAndroidClient.unsubscribe(topic, (Object) null, new IMqttActionListener() { // from class: com.yd.android_brand_mvp.mqtt.MQTTClient.unsubscribe.1
                @Override // org.eclipse.paho.client.mqttv3.IMqttActionListener
                public void onSuccess(IMqttToken asyncActionToken) {
                    Log.d(MQTTClient.INSTANCE.getTAG(), "Unsubscribed to " + topic);
                }

                @Override // org.eclipse.paho.client.mqttv3.IMqttActionListener
                public void onFailure(IMqttToken asyncActionToken, Throwable exception) {
                    Log.d(MQTTClient.INSTANCE.getTAG(), "Failed to unsubscribe " + topic);
                }
            });
        } catch (MqttException e) {
            e.printStackTrace();
        }
    }

    public static /* synthetic */ void publish$default(MQTTClient mQTTClient, String str, String str2, int i, boolean z, int i2, Object obj) {
        if ((i2 & 4) != 0) {
            i = 2;
        }
        if ((i2 & 8) != 0) {
            z = false;
        }
        mQTTClient.publish(str, str2, i, z);
    }

    public final void publish(final String topic, final String msg, int qos, boolean retained) {
        MqttAndroidClient mqttAndroidClient;
        Intrinsics.checkNotNullParameter(topic, "topic");
        Intrinsics.checkNotNullParameter(msg, "msg");
        try {
            MqttMessage mqttMessage = new MqttMessage();
            byte[] bytes = msg.getBytes(Charsets.UTF_8);
            Intrinsics.checkNotNullExpressionValue(bytes, "this as java.lang.String).getBytes(charset)");
            mqttMessage.setPayload(bytes);
            mqttMessage.setQos(qos);
            mqttMessage.setRetained(retained);
            if (mqttClient != null) {
                MqttAndroidClient mqttAndroidClient2 = mqttClient;
                boolean z = true;
                if (mqttAndroidClient2 == null || !mqttAndroidClient2.isConnected()) {
                    z = false;
                }
                if (!z || (mqttAndroidClient = mqttClient) == null) {
                    return;
                }
                mqttAndroidClient.publish(topic, mqttMessage, (Object) null, new IMqttActionListener() { // from class: com.yd.android_brand_mvp.mqtt.MQTTClient.publish.1
                    @Override // org.eclipse.paho.client.mqttv3.IMqttActionListener
                    public void onSuccess(IMqttToken asyncActionToken) {
                        Log.d(MQTTClient.INSTANCE.getTAG(), msg + " published to " + topic);
                    }

                    @Override // org.eclipse.paho.client.mqttv3.IMqttActionListener
                    public void onFailure(IMqttToken asyncActionToken, Throwable exception) {
                        Object[] objArr = new Object[1];
                        StringBuilder sb = new StringBuilder();
                        sb.append("Failed to publish to ");
                        sb.append(topic);
                        sb.append(' ');
                        sb.append(exception != null ? exception.getMessage() : null);
                        objArr[0] = sb.toString();
                        LogUtils.i(objArr);
                    }
                });
            }
        } catch (MqttException e) {
            e.printStackTrace();
        }
    }

    public final void publishTopic(String topic, String message) {
        Intrinsics.checkNotNullParameter(topic, "topic");
        Intrinsics.checkNotNullParameter(message, "message");
        publish(topic, message, QosEnum.QOS_TWO.value(), false);
    }

    public final void publishSuccess(String id, String remake) {
        Intrinsics.checkNotNullParameter(remake, "remake");
        if (id != null) {
            MessageSyncBean messageSyncBean = new MessageSyncBean(id, StatusEnum.STATUS_SUCCESS.value(), remake, mac);
            MQTTClient mQTTClient = INSTANCE;
            String str = TOPIC_SYNC;
            String json = GsonUtils.toJson(messageSyncBean);
            Intrinsics.checkNotNullExpressionValue(json, "toJson(message)");
            publish$default(mQTTClient, str, json, QosEnum.QOS_TWO.value(), false, 8, null);
        }
    }

    public final void publishFail(String id, String remake) {
        Intrinsics.checkNotNullParameter(remake, "remake");
        if (id != null) {
            MessageSyncBean messageSyncBean = new MessageSyncBean(id, StatusEnum.STATUS_FAIL.value(), remake, mac);
            MQTTClient mQTTClient = INSTANCE;
            String str = TOPIC_SYNC;
            String json = GsonUtils.toJson(messageSyncBean);
            Intrinsics.checkNotNullExpressionValue(json, "toJson(message)");
            publish$default(mQTTClient, str, json, QosEnum.QOS_TWO.value(), false, 8, null);
        }
    }

    public final void publishReceive(String id) {
        if (id != null) {
            MessageSyncBean messageSyncBean = new MessageSyncBean(id, StatusEnum.STATUS_RECEIVE.value(), "", mac);
            MQTTClient mQTTClient = INSTANCE;
            String str = TOPIC_SYNC;
            String json = GsonUtils.toJson(messageSyncBean);
            Intrinsics.checkNotNullExpressionValue(json, "toJson(message)");
            publish$default(mQTTClient, str, json, QosEnum.QOS_TWO.value(), false, 8, null);
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* JADX INFO: compiled from: MQTTClient.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H&j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/yd/android_brand_mvp/mqtt/MQTTClient$QosEnum;", "", "(Ljava/lang/String;I)V", "value", "", "QOS_ZERO", "QOS_ONE", "QOS_TWO", "app_commonRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class QosEnum {
        public static final QosEnum QOS_ZERO = new QOS_ZERO("QOS_ZERO", 0);
        public static final QosEnum QOS_ONE = new QOS_ONE("QOS_ONE", 1);
        public static final QosEnum QOS_TWO = new QOS_TWO("QOS_TWO", 2);
        private static final /* synthetic */ QosEnum[] $VALUES = $values();

        private static final /* synthetic */ QosEnum[] $values() {
            return new QosEnum[]{QOS_ZERO, QOS_ONE, QOS_TWO};
        }

        public /* synthetic */ QosEnum(String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(str, i);
        }

        public static QosEnum valueOf(String str) {
            return (QosEnum) Enum.valueOf(QosEnum.class, str);
        }

        public static QosEnum[] values() {
            return (QosEnum[]) $VALUES.clone();
        }

        public abstract int value();

        /* JADX INFO: compiled from: MQTTClient.kt */
        @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\bÆ\u0001\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016¨\u0006\u0004"}, d2 = {"Lcom/yd/android_brand_mvp/mqtt/MQTTClient$QosEnum$QOS_ZERO;", "Lcom/yd/android_brand_mvp/mqtt/MQTTClient$QosEnum;", "value", "", "app_commonRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
        static final class QOS_ZERO extends QosEnum {
            @Override // com.yd.android_brand_mvp.mqtt.MQTTClient.QosEnum
            public int value() {
                return 0;
            }

            QOS_ZERO(String str, int i) {
                super(str, i, null);
            }
        }

        private QosEnum(String str, int i) {
            super(str, i);
        }

        /* JADX INFO: compiled from: MQTTClient.kt */
        @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\bÆ\u0001\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016¨\u0006\u0004"}, d2 = {"Lcom/yd/android_brand_mvp/mqtt/MQTTClient$QosEnum$QOS_ONE;", "Lcom/yd/android_brand_mvp/mqtt/MQTTClient$QosEnum;", "value", "", "app_commonRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
        static final class QOS_ONE extends QosEnum {
            @Override // com.yd.android_brand_mvp.mqtt.MQTTClient.QosEnum
            public int value() {
                return 1;
            }

            QOS_ONE(String str, int i) {
                super(str, i, null);
            }
        }

        /* JADX INFO: compiled from: MQTTClient.kt */
        @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\bÆ\u0001\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016¨\u0006\u0004"}, d2 = {"Lcom/yd/android_brand_mvp/mqtt/MQTTClient$QosEnum$QOS_TWO;", "Lcom/yd/android_brand_mvp/mqtt/MQTTClient$QosEnum;", "value", "", "app_commonRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
        static final class QOS_TWO extends QosEnum {
            @Override // com.yd.android_brand_mvp.mqtt.MQTTClient.QosEnum
            public int value() {
                return 2;
            }

            QOS_TWO(String str, int i) {
                super(str, i, null);
            }
        }
    }

    public final OnMessageCallBack getMOnMessageCallBack() {
        return mOnMessageCallBack;
    }

    public final void setMOnMessageCallBack(OnMessageCallBack onMessageCallBack) {
        mOnMessageCallBack = onMessageCallBack;
    }

    public final void setOnMessageCallBack(OnMessageCallBack mOnMessageCallBack2) {
        Intrinsics.checkNotNullParameter(mOnMessageCallBack2, "mOnMessageCallBack");
        mOnMessageCallBack = mOnMessageCallBack2;
    }
}
