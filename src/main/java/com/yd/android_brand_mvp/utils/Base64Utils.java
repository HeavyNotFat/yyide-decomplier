package com.yd.android_brand_mvp.utils;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Rect;
import android.os.Environment;
import android.util.Base64;
import android.util.Log;
import android.view.Display;
import android.view.View;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.lifecycle.MutableLiveData;
import com.blankj.utilcode.util.ImageUtils;
import com.blankj.utilcode.util.ScreenUtils;
import com.heytap.mcssdk.a.a;
import com.meizu.cloud.pushsdk.constants.PushConstants;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: compiled from: Base64Utils.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0012\u0010\r\u001a\u0004\u0018\u00010\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0005J\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0011\u001a\u00020\u0005J\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0011\u001a\u00020\u0005J\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u0014\u001a\u00020\u0015J\u0018\u0010\u0016\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\tJ\u0012\u0010\u001a\u001a\u0004\u0018\u00010\u00152\b\u0010\u001b\u001a\u0004\u0018\u00010\u000eJ\b\u0010\u001c\u001a\u00020\u0005H\u0002J\u000e\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u0017\u001a\u00020\u0018J\u000e\u0010\u001f\u001a\u00020\u001e2\u0006\u0010 \u001a\u00020\u0005J\u0012\u0010!\u001a\u0004\u0018\u00010\u000e2\b\u0010\"\u001a\u0004\u0018\u00010\u0005R\u0017\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u000e\u0010\b\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\n\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006#"}, d2 = {"Lcom/yd/android_brand_mvp/utils/Base64Utils;", "", "()V", "base64LiveData", "Landroidx/lifecycle/MutableLiveData;", "", "getBase64LiveData", "()Landroidx/lifecycle/MutableLiveData;", "isEncoding", "", "screenShotPath", "getScreenShotPath", "()Ljava/lang/String;", "base642Bitmap", "Landroid/graphics/Bitmap;", "base64String", "base64Decode", "content", "base64Encode", "byteToBitmap", "byteArray", "", "captureWindow", PushConstants.INTENT_ACTIVITY_NAME, "Landroid/app/Activity;", "isShowStatusBar", "getBitmapByte", "bitmap", "getScreenShotByAdb", "imageToBase64", "", "runAdbCommand", a.k, "stringToBitmap", TypedValues.Custom.S_STRING, "app_commonRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class Base64Utils {
    private static boolean isEncoding;
    public static final Base64Utils INSTANCE = new Base64Utils();
    private static final String screenShotPath = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES).getAbsolutePath() + "/screenShot.png";
    private static final MutableLiveData<String> base64LiveData = new MutableLiveData<>();

    private Base64Utils() {
    }

    public final String getScreenShotPath() {
        return screenShotPath;
    }

    public final MutableLiveData<String> getBase64LiveData() {
        return base64LiveData;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String getScreenShotByAdb() {
        runAdbCommand("screencap -p " + screenShotPath);
        File file = new File(screenShotPath);
        if (!file.exists()) {
            return "";
        }
        String absolutePath = file.getAbsolutePath();
        Intrinsics.checkNotNullExpressionValue(absolutePath, "shotFile.absolutePath");
        return absolutePath;
    }

    public final void runAdbCommand(String command) {
        Intrinsics.checkNotNullParameter(command, "command");
        try {
            Process processExec = Runtime.getRuntime().exec("su");
            DataOutputStream dataOutputStream = new DataOutputStream(processExec.getOutputStream());
            dataOutputStream.writeBytes(command);
            dataOutputStream.flush();
            dataOutputStream.close();
            processExec.waitFor();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* JADX WARN: Type inference failed for: r13v5, types: [T, android.graphics.Bitmap] */
    public final void imageToBase64(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        if (isEncoding) {
            return;
        }
        long jCurrentTimeMillis = System.currentTimeMillis();
        Ref.ObjectRef objectRef = new Ref.ObjectRef();
        View decorView = activity.getWindow().getDecorView();
        Intrinsics.checkNotNullExpressionValue(decorView, "activity.window.decorView");
        decorView.setDrawingCacheEnabled(false);
        decorView.buildDrawingCache();
        objectRef.element = Bitmap.createBitmap(decorView.getDrawingCache());
        BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), null, null, new AnonymousClass1(objectRef, jCurrentTimeMillis, decorView, null), 3, null);
    }

    /* JADX INFO: renamed from: com.yd.android_brand_mvp.utils.Base64Utils$imageToBase64$1, reason: invalid class name */
    /* JADX INFO: compiled from: Base64Utils.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "com.yd.android_brand_mvp.utils.Base64Utils$imageToBase64$1", f = "Base64Utils.kt", i = {}, l = {94}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Ref.ObjectRef<Bitmap> $bitmap;
        final /* synthetic */ View $dView;
        final /* synthetic */ long $start;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(Ref.ObjectRef<Bitmap> objectRef, long j, View view, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$bitmap = objectRef;
            this.$start = j;
            this.$dView = view;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass1(this.$bitmap, this.$start, this.$dView, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Type inference failed for: r1v8, types: [T, android.graphics.Bitmap] */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Bitmap bitmapCreateScaledBitmap;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                Base64Utils base64Utils = Base64Utils.INSTANCE;
                Base64Utils.isEncoding = true;
                if (this.$bitmap.element == null) {
                    this.$bitmap.element = ImageUtils.getBitmap(Base64Utils.INSTANCE.getScreenShotByAdb());
                }
                if (this.$bitmap.element != null) {
                    if (ScreenUtils.isLandscape()) {
                        Bitmap bitmap = this.$bitmap.element;
                        Intrinsics.checkNotNull(bitmap);
                        bitmapCreateScaledBitmap = Bitmap.createScaledBitmap(bitmap, 960, 540, true);
                    } else {
                        Bitmap bitmap2 = this.$bitmap.element;
                        Intrinsics.checkNotNull(bitmap2);
                        bitmapCreateScaledBitmap = Bitmap.createScaledBitmap(bitmap2, 540, 960, true);
                    }
                    ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                    bitmapCreateScaledBitmap.compress(Bitmap.CompressFormat.JPEG, 50, byteArrayOutputStream);
                    String strEncodeToString = Base64.encodeToString(byteArrayOutputStream.toByteArray(), 16);
                    this.label = 1;
                    if (BuildersKt.withContext(Dispatchers.getMain(), new C01881(strEncodeToString, this.$start, this.$dView, null), this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else {
                    Base64Utils base64Utils2 = Base64Utils.INSTANCE;
                    Base64Utils.isEncoding = false;
                    Log.i("imageToBase64", "图片地址为NUll");
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            return Unit.INSTANCE;
        }

        /* JADX INFO: renamed from: com.yd.android_brand_mvp.utils.Base64Utils$imageToBase64$1$1, reason: invalid class name and collision with other inner class name */
        /* JADX INFO: compiled from: Base64Utils.kt */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
        @DebugMetadata(c = "com.yd.android_brand_mvp.utils.Base64Utils$imageToBase64$1$1", f = "Base64Utils.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
        static final class C01881 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            final /* synthetic */ String $base64;
            final /* synthetic */ View $dView;
            final /* synthetic */ long $start;
            int label;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            C01881(String str, long j, View view, Continuation<? super C01881> continuation) {
                super(2, continuation);
                this.$base64 = str;
                this.$start = j;
                this.$dView = view;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                return new C01881(this.$base64, this.$start, this.$dView, continuation);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                return ((C01881) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (this.label != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                Base64Utils base64Utils = Base64Utils.INSTANCE;
                Base64Utils.isEncoding = false;
                Base64Utils.INSTANCE.getBase64LiveData().setValue(this.$base64);
                StringBuilder sb = new StringBuilder();
                sb.append("base64 = ");
                String str = this.$base64;
                sb.append(str != null ? Boxing.boxInt(str.length() / 1024) : null);
                sb.append(" kb");
                Log.i("imageToBase64", sb.toString());
                Log.i("imageToBase64", "end = " + (System.currentTimeMillis() - this.$start) + " mm");
                this.$dView.setDrawingCacheEnabled(false);
                this.$dView.destroyDrawingCache();
                return Unit.INSTANCE;
            }
        }
    }

    public final Bitmap base642Bitmap(String base64String) {
        if (base64String == null) {
            return null;
        }
        try {
            byte[] bArrDecode = Base64.decode(base64String, 0);
            Intrinsics.checkNotNullExpressionValue(bArrDecode, "decode(base64String, Base64.DEFAULT)");
            return BitmapFactory.decodeByteArray(bArrDecode, 0, bArrDecode.length);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public final byte[] getBitmapByte(Bitmap bitmap) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        if (bitmap != null) {
            bitmap.compress(Bitmap.CompressFormat.JPEG, 100, byteArrayOutputStream);
        }
        return byteArrayOutputStream.toByteArray();
    }

    public final Bitmap byteToBitmap(byte[] byteArray) {
        Intrinsics.checkNotNullParameter(byteArray, "byteArray");
        return BitmapFactory.decodeByteArray(byteArray, 0, byteArray.length);
    }

    public final Bitmap stringToBitmap(String string) {
        try {
            byte[] bArrDecode = Base64.decode(string != null ? StringsKt.replace$default(string, "data:image/png;base64,", "", false, 4, (Object) null) : null, 0);
            Intrinsics.checkNotNullExpressionValue(bArrDecode, "decode(str, Base64.DEFAULT)");
            return BitmapFactory.decodeByteArray(bArrDecode, 0, bArrDecode.length);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public final String base64Encode(String content) {
        Intrinsics.checkNotNullParameter(content, "content");
        try {
            Charset charsetForName = Charset.forName("UTF-8");
            Intrinsics.checkNotNullExpressionValue(charsetForName, "forName(charsetName)");
            byte[] bytes = content.getBytes(charsetForName);
            Intrinsics.checkNotNullExpressionValue(bytes, "this as java.lang.String).getBytes(charset)");
            return Base64.encodeToString(bytes, 0);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            return "";
        }
    }

    public final String base64Decode(String content) {
        Intrinsics.checkNotNullParameter(content, "content");
        byte[] contentByte = Base64.decode(content, 0);
        try {
            Intrinsics.checkNotNullExpressionValue(contentByte, "contentByte");
            Charset charsetForName = Charset.forName("UTF-8");
            Intrinsics.checkNotNullExpressionValue(charsetForName, "forName(\"UTF-8\")");
            return new String(contentByte, charsetForName);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            return "";
        }
    }

    public final Bitmap captureWindow(Activity activity, boolean isShowStatusBar) {
        Bitmap bitmapCreateBitmap;
        Intrinsics.checkNotNullParameter(activity, "activity");
        View decorView = activity.getWindow().getDecorView();
        Intrinsics.checkNotNullExpressionValue(decorView, "activity.window.decorView");
        decorView.setDrawingCacheEnabled(true);
        decorView.buildDrawingCache();
        if (isShowStatusBar) {
            bitmapCreateBitmap = Bitmap.createBitmap(decorView.getDrawingCache(), 0, 0, decorView.getMeasuredWidth(), decorView.getMeasuredHeight());
        } else {
            Rect rect = new Rect();
            decorView.getWindowVisibleDisplayFrame(rect);
            Display defaultDisplay = activity.getWindowManager().getDefaultDisplay();
            bitmapCreateBitmap = Bitmap.createBitmap(decorView.getDrawingCache(), 0, rect.top, defaultDisplay.getWidth(), defaultDisplay.getHeight() - rect.top);
        }
        decorView.setDrawingCacheEnabled(false);
        decorView.destroyDrawingCache();
        return bitmapCreateBitmap;
    }
}
