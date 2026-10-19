package com.yd.android_brand_mvp.utils.view.net;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.util.Log;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public class NetworkChangeReceiver extends BroadcastReceiver {
    private static boolean isRegister = false;
    private final List<NetStateChangeObserver> mObservers = new ArrayList();

    public interface NetStateChangeObserver {
        void onDisconnect();

        void onMobileConnect();

        void onReticleConnect();

        void onWifiConnect();
    }

    private static class InstanceHolder {
        private static final NetworkChangeReceiver INSTANCE = new NetworkChangeReceiver();

        private InstanceHolder() {
        }
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        if ("android.net.conn.CONNECTIVITY_CHANGE".equals(intent.getAction())) {
            int connectivityStatus = NetWorkUtil.getConnectivityStatus(context, intent);
            Log.d("NetworkChangeReceiver", "onReceive: " + connectivityStatus);
            notifyObservers(connectivityStatus);
        }
    }

    public static void registerReceiver(Context context) {
        context.registerReceiver(InstanceHolder.INSTANCE, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
        isRegister = true;
    }

    public static void unRegisterReceiver(Context context) {
        if (isRegister) {
            context.unregisterReceiver(InstanceHolder.INSTANCE);
        }
    }

    public static void registerObserver(NetStateChangeObserver netStateChangeObserver) {
        if (netStateChangeObserver == null || InstanceHolder.INSTANCE.mObservers.contains(netStateChangeObserver)) {
            return;
        }
        InstanceHolder.INSTANCE.mObservers.add(netStateChangeObserver);
    }

    public static void unRegisterObserver(NetStateChangeObserver netStateChangeObserver) {
        if (netStateChangeObserver == null || InstanceHolder.INSTANCE.mObservers.isEmpty()) {
            return;
        }
        Log.d("NetworkChangeReceiver", "unRegisterObserver: remove");
        InstanceHolder.INSTANCE.mObservers.remove(netStateChangeObserver);
    }

    private void notifyObservers(int i) {
        if (i == 2) {
            Iterator<NetStateChangeObserver> it2 = this.mObservers.iterator();
            while (it2.hasNext()) {
                it2.next().onMobileConnect();
            }
        } else if (i == 1) {
            Iterator<NetStateChangeObserver> it3 = this.mObservers.iterator();
            while (it3.hasNext()) {
                it3.next().onWifiConnect();
            }
        } else if (i == 3) {
            Iterator<NetStateChangeObserver> it4 = this.mObservers.iterator();
            while (it4.hasNext()) {
                it4.next().onReticleConnect();
            }
        } else {
            Iterator<NetStateChangeObserver> it5 = this.mObservers.iterator();
            while (it5.hasNext()) {
                it5.next().onDisconnect();
            }
        }
    }
}
