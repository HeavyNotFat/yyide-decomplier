package com.yd.android_brand_mvp.brand.device;

import android.content.Context;
import android.util.Log;
import com.dk.usbNfc.Card.Mifare;
import com.dk.usbNfc.DeviceManager.DeviceManagerCallback;
import com.dk.usbNfc.DeviceManager.UsbNfcDevice;
import com.dk.usbNfc.Exception.DeviceNoResponseException;
import com.yd.android_brand_mvp.BaseApplication;
import com.yd.android_brand_mvp.utils.Tool;
import java.math.BigInteger;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: SMTDevices.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\u0007"}, d2 = {"Lcom/yd/android_brand_mvp/brand/device/SMTDevices;", "", "()V", "initUSB", "", "context", "Landroid/content/Context;", "app_commonRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class SMTDevices {
    public static final SMTDevices INSTANCE = new SMTDevices();

    private SMTDevices() {
    }

    /* JADX INFO: renamed from: com.yd.android_brand_mvp.brand.device.SMTDevices$initUSB$1, reason: invalid class name */
    /* JADX INFO: compiled from: SMTDevices.kt */
    @Metadata(d1 = {"\u0000'\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J,\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0016¨\u0006\r"}, d2 = {"com/yd/android_brand_mvp/brand/device/SMTDevices$initUSB$1", "Lcom/dk/usbNfc/DeviceManager/DeviceManagerCallback;", "onReceiveConnectionStatus", "", "blnIsConnection", "", "onReceiveRfnSearchCard", "blnIsSus", "cardType", "", "bytCardSn", "", "bytCarATS", "app_commonRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class AnonymousClass1 extends DeviceManagerCallback {
        final /* synthetic */ UsbNfcDevice $usbNfcDevice;

        AnonymousClass1(UsbNfcDevice usbNfcDevice) {
            this.$usbNfcDevice = usbNfcDevice;
        }

        @Override // com.dk.usbNfc.DeviceManager.DeviceManagerCallback
        public void onReceiveConnectionStatus(boolean blnIsConnection) {
            super.onReceiveConnectionStatus(blnIsConnection);
            if (blnIsConnection) {
                Log.i("SMTDevices", "USB连接成功！");
                final UsbNfcDevice usbNfcDevice = this.$usbNfcDevice;
                new Thread(new Runnable() { // from class: com.yd.android_brand_mvp.brand.device.-$$Lambda$SMTDevices$initUSB$1$O3E210KWv5-h3YPnhGqt1aCvVEQ
                    @Override // java.lang.Runnable
                    public final void run() {
                        SMTDevices.AnonymousClass1.onReceiveConnectionStatus$lambda$0(usbNfcDevice);
                    }
                }).start();
                return;
            }
            Log.i("SMTDevices", "USB连接断开！");
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void onReceiveConnectionStatus$lambda$0(UsbNfcDevice usbNfcDevice) {
            Intrinsics.checkNotNullParameter(usbNfcDevice, "$usbNfcDevice");
            try {
                Log.i("SMTDevices", "版本 = " + ((int) usbNfcDevice.getDeviceVersions()));
                try {
                    usbNfcDevice.openBeep(50, 50, 3);
                } catch (DeviceNoResponseException e) {
                    e.printStackTrace();
                }
            } catch (DeviceNoResponseException e2) {
                e2.printStackTrace();
            }
        }

        @Override // com.dk.usbNfc.DeviceManager.DeviceManagerCallback
        public void onReceiveRfnSearchCard(boolean blnIsSus, final int cardType, byte[] bytCardSn, byte[] bytCarATS) {
            super.onReceiveRfnSearchCard(blnIsSus, cardType, bytCardSn, bytCarATS);
            final UsbNfcDevice usbNfcDevice = this.$usbNfcDevice;
            new Thread(new Runnable() { // from class: com.yd.android_brand_mvp.brand.device.-$$Lambda$SMTDevices$initUSB$1$XzWIAMJNq_fZEXuw3B4jBzxkBpA
                @Override // java.lang.Runnable
                public final void run() {
                    SMTDevices.AnonymousClass1.onReceiveRfnSearchCard$lambda$1(cardType, usbNfcDevice);
                }
            }).start();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void onReceiveRfnSearchCard$lambda$1(int i, UsbNfcDevice usbNfcDevice) {
            Intrinsics.checkNotNullParameter(usbNfcDevice, "$usbNfcDevice");
            if (((byte) i) == 4) {
                try {
                    Object card = usbNfcDevice.getCard();
                    Intrinsics.checkNotNull(card, "null cannot be cast to non-null type com.dk.usbNfc.Card.Mifare");
                    Mifare mifare = (Mifare) card;
                    if (mifare.uid.length > 3) {
                        BaseApplication.getInstance().sendCard(new StringBuilder(new BigInteger(Tool.bytesToHex(new byte[]{mifare.uid[3], mifare.uid[2], mifare.uid[1], mifare.uid[0]}), 16).toString()).toString());
                    }
                    Log.i("SMTDevices", "mifare = " + mifare.uidToString());
                } catch (DeviceNoResponseException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public final void initUSB(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        UsbNfcDevice usbNfcDevice = new UsbNfcDevice(context);
        usbNfcDevice.setCallBack(new AnonymousClass1(usbNfcDevice));
    }
}
