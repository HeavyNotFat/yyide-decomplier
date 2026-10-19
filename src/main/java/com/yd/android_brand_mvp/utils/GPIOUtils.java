package com.yd.android_brand_mvp.utils;

import android.content.Context;
import android.os.Handler;
import android.util.Log;
import androidx.core.app.NotificationCompat;
import com.yd.android_brand_mvp.brand.BroCast;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;

/* JADX INFO: compiled from: GPIOUtils.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\r\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0011\u001a\u00020\u0012J\u000e\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\u0015J\u000e\u0010\u0016\u001a\u00020\u00122\u0006\u0010\u0017\u001a\u00020\u0018J\u000e\u0010\u0016\u001a\u00020\u00122\u0006\u0010\u0019\u001a\u00020\u0004R\u0014\u0010\u0003\u001a\u00020\u0004X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0007\u001a\u00020\u0004X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0006R\u0014\u0010\t\u001a\u00020\u0004X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u0006R\u0014\u0010\u000b\u001a\u00020\u0004X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u0006R\u0014\u0010\r\u001a\u00020\u0004X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u0006R\u0014\u0010\u000f\u001a\u00020\u0004X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0006¨\u0006\u001a"}, d2 = {"Lcom/yd/android_brand_mvp/utils/GPIOUtils;", "", "()V", "GPIO_HIGH", "", "getGPIO_HIGH", "()Ljava/lang/String;", "GPIO_LOW", "getGPIO_LOW", "GPIO_MODE_GRENN", "getGPIO_MODE_GRENN", "GPIO_MODE_GRENN_CLOSE", "getGPIO_MODE_GRENN_CLOSE", "GPIO_MODE_RED", "getGPIO_MODE_RED", "GPIO_MODE_RED_CLOSE", "getGPIO_MODE_RED_CLOSE", "close", "", "open", "context", "Landroid/content/Context;", "set_oem_gpio", "value", "", "mode", "app_commonRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class GPIOUtils {
    public static final GPIOUtils INSTANCE = new GPIOUtils();
    private static final String GPIO_MODE_RED = "io21";
    private static final String GPIO_MODE_RED_CLOSE = "io20";
    private static final String GPIO_MODE_GRENN_CLOSE = "io30";
    private static final String GPIO_MODE_GRENN = "io31";
    private static final String GPIO_HIGH = "io51";
    private static final String GPIO_LOW = "io50";

    private GPIOUtils() {
    }

    public final String getGPIO_MODE_RED() {
        return GPIO_MODE_RED;
    }

    public final String getGPIO_MODE_RED_CLOSE() {
        return GPIO_MODE_RED_CLOSE;
    }

    public final String getGPIO_MODE_GRENN_CLOSE() {
        return GPIO_MODE_GRENN_CLOSE;
    }

    public final String getGPIO_MODE_GRENN() {
        return GPIO_MODE_GRENN;
    }

    public final String getGPIO_HIGH() {
        return GPIO_HIGH;
    }

    public final String getGPIO_LOW() {
        return GPIO_LOW;
    }

    public final void set_oem_gpio(String mode) {
        Intrinsics.checkNotNullParameter(mode, "mode");
        try {
            Log.d("liz", "mode===" + mode);
            FileOutputStream fileOutputStream = new FileOutputStream("/proc/oem_gpio");
            byte[] bytes = mode.getBytes(Charsets.UTF_8);
            Intrinsics.checkNotNullExpressionValue(bytes, "this as java.lang.String).getBytes(charset)");
            fileOutputStream.write(bytes);
            fileOutputStream.flush();
            fileOutputStream.close();
        } catch (FileNotFoundException unused) {
            Log.d(NotificationCompat.CATEGORY_ERROR, "found error");
        } catch (IOException unused2) {
            Log.d(NotificationCompat.CATEGORY_ERROR, "IO error");
        }
    }

    public final void set_oem_gpio(int value) {
        String str = "io11";
        if (value == 16) {
            str = "io10";
        } else if (value != 17) {
            if (value == 32) {
                str = "io20";
            } else if (value == 33) {
                str = "io21";
            } else if (value == 48) {
                str = "io30";
            } else if (value == 49) {
                str = "io31";
            } else if (value == 64) {
                str = "io40";
            } else if (value == 65) {
                str = "io41";
            } else if (value == 80) {
                str = "io50";
            } else if (value == 81) {
                str = "io51";
            } else if (value == 96) {
                str = "io60";
            } else if (value == 97) {
                str = "io61";
            } else if (value == 112) {
                str = "io70";
            } else if (value == 113) {
                str = "io71";
            } else if (value == 128) {
                str = "io80";
            } else if (value == 129) {
                str = "io81";
            } else if (value == 144) {
                str = "io90";
            } else if (value == 145) {
                str = "io91";
            }
        }
        try {
            Log.d("liz", "mode===" + str);
            FileOutputStream fileOutputStream = new FileOutputStream("/proc/oem_gpio");
            byte[] bytes = str.getBytes(Charsets.UTF_8);
            Intrinsics.checkNotNullExpressionValue(bytes, "this as java.lang.String).getBytes(charset)");
            fileOutputStream.write(bytes);
            fileOutputStream.flush();
            fileOutputStream.close();
        } catch (FileNotFoundException unused) {
            Log.d(NotificationCompat.CATEGORY_ERROR, "found error");
        } catch (IOException unused2) {
            Log.d(NotificationCompat.CATEGORY_ERROR, "IO error");
        }
    }

    public final void open(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        BroCast.openDoor(context);
        set_oem_gpio(17);
        set_oem_gpio(33);
        BroCast.open(context);
        new Handler().postDelayed(new Runnable() { // from class: com.yd.android_brand_mvp.utils.-$$Lambda$GPIOUtils$diOnNcPmYmA5VwS_NJjzrVMZndk
            @Override // java.lang.Runnable
            public final void run() {
                GPIOUtils.open$lambda$0();
            }
        }, 5000L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void open$lambda$0() {
        INSTANCE.close();
    }

    public final void close() {
        set_oem_gpio(16);
        set_oem_gpio(32);
        BroCast.closeDoor();
    }
}
