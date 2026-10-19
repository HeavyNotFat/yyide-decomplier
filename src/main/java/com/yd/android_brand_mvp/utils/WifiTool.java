package com.yd.android_brand_mvp.utils;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiConfiguration;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.text.TextUtils;
import androidx.work.WorkRequest;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public class WifiTool {
    private Context mContext;
    private WifiManager mWifiManager;

    public WifiTool(Context context) {
        this.mContext = context;
        this.mWifiManager = (WifiManager) context.getSystemService("wifi");
    }

    public boolean isConnectWifi() {
        ConnectivityManager connectivityManager = (ConnectivityManager) this.mContext.getSystemService("connectivity");
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isAvailable() && connectivityManager.getNetworkInfo(1).getState() == NetworkInfo.State.CONNECTED;
    }

    public WifiInfo getCurrentWifiInfo() {
        return this.mWifiManager.getConnectionInfo();
    }

    public boolean addNetwork(WifiConfiguration wifiConfiguration) {
        return this.mWifiManager.enableNetwork(this.mWifiManager.addNetwork(wifiConfiguration), true);
    }

    public List<String> getScanSSIDsResult() {
        this.mWifiManager.startScan();
        List<ScanResult> scanResults = this.mWifiManager.getScanResults();
        ArrayList arrayList = new ArrayList();
        if (scanResults != null) {
            Iterator<ScanResult> it2 = scanResults.iterator();
            while (it2.hasNext()) {
                arrayList.add(it2.next().SSID);
            }
        }
        return arrayList;
    }

    public List<ScanResult> getScanSSIDsResult2() {
        this.mWifiManager.startScan();
        List<ScanResult> scanResults = this.mWifiManager.getScanResults();
        new ArrayList();
        return scanResults;
    }

    public List<String> accordSsid() {
        List<String> scanSSIDsResult = getScanSSIDsResult();
        ArrayList arrayList = new ArrayList();
        for (String str : scanSSIDsResult) {
            if (checkDssid(str, "1")) {
                arrayList.add(str);
            }
        }
        return arrayList;
    }

    private boolean checkDssid(String str, String str2) {
        return !TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2) && str.length() > 8 && str.substring(0, 8).equals(str2);
    }

    public boolean connectWifiTest(String str, String str2) {
        this.mWifiManager.disconnect();
        boolean z = false;
        if (!addNetwork(CreateWifiInfo(str, str2, 3))) {
            return false;
        }
        boolean z2 = false;
        while (!z && !z2) {
            try {
                Thread.sleep(WorkRequest.MIN_BACKOFF_MILLIS);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            String ssid = getCurrentWifiInfo().getSSID();
            if (ssid != null) {
                ssid = ssid.replace("\"", "");
            }
            int ipAddress = getCurrentWifiInfo().getIpAddress();
            if (ssid == null || !ssid.equals(str) || ipAddress == 0) {
                z = true;
            } else {
                z2 = true;
            }
        }
        return z2;
    }

    public WifiConfiguration CreateWifiInfo(String str, String str2, int i) {
        WifiConfiguration wifiConfiguration = new WifiConfiguration();
        wifiConfiguration.allowedAuthAlgorithms.clear();
        wifiConfiguration.allowedGroupCiphers.clear();
        wifiConfiguration.allowedKeyManagement.clear();
        wifiConfiguration.allowedPairwiseCiphers.clear();
        wifiConfiguration.allowedProtocols.clear();
        wifiConfiguration.SSID = "\"" + str + "\"";
        WifiConfiguration wifiConfigurationIsExsits = IsExsits(str);
        if (wifiConfigurationIsExsits != null) {
            this.mWifiManager.removeNetwork(wifiConfigurationIsExsits.networkId);
        }
        if (i == 1) {
            wifiConfiguration.wepKeys[0] = "";
            wifiConfiguration.allowedKeyManagement.set(0);
            wifiConfiguration.wepTxKeyIndex = 0;
        }
        if (i == 2) {
            wifiConfiguration.hiddenSSID = true;
            wifiConfiguration.wepKeys[0] = "\"" + str2 + "\"";
            wifiConfiguration.allowedAuthAlgorithms.set(1);
            wifiConfiguration.allowedGroupCiphers.set(3);
            wifiConfiguration.allowedGroupCiphers.set(2);
            wifiConfiguration.allowedGroupCiphers.set(0);
            wifiConfiguration.allowedGroupCiphers.set(1);
            wifiConfiguration.allowedKeyManagement.set(0);
            wifiConfiguration.wepTxKeyIndex = 0;
        }
        if (i == 3) {
            wifiConfiguration.preSharedKey = "\"" + str2 + "\"";
            wifiConfiguration.hiddenSSID = true;
            wifiConfiguration.allowedAuthAlgorithms.set(0);
            wifiConfiguration.allowedGroupCiphers.set(2);
            wifiConfiguration.allowedKeyManagement.set(1);
            wifiConfiguration.allowedPairwiseCiphers.set(1);
            wifiConfiguration.allowedGroupCiphers.set(3);
            wifiConfiguration.allowedPairwiseCiphers.set(2);
            wifiConfiguration.status = 2;
        }
        return wifiConfiguration;
    }

    public WifiConfiguration IsExsits(String str) {
        for (WifiConfiguration wifiConfiguration : this.mWifiManager.getConfiguredNetworks()) {
            if (wifiConfiguration.SSID.equals("\"" + str + "\"")) {
                return wifiConfiguration;
            }
        }
        return null;
    }
}
