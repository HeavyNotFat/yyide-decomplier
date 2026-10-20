package com.yd.android_brand_mvp;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.text.TextUtils;
import android.util.Log;
import android.widget.Toast;
import com.alibaba.fastjson.JSON;
import com.google.android.exoplayer2.text.ttml.TtmlNode;
import com.google.gson.reflect.TypeToken;
import com.tencent.qcloud.tim.uikit.utils.TUIKitConstants;
import com.ttlock.bl.sdk.api.TTLockClient;
import com.ttlock.bl.sdk.callback.ControlLockCallback;
import com.ttlock.bl.sdk.callback.ResetLockCallback;
import com.ttlock.bl.sdk.entity.LockError;
import com.ttlock.bl.sdk.util.DigitUtil;
import com.ttlock.bl.sdk.util.GsonUtil;
import com.yd.android_brand_mvp.base.BaseConstant;
import com.yd.android_brand_mvp.mina.MinaEventType;
import com.yd.android_brand_mvp.utils.SDcarfile;
import com.yd.android_brand_mvp.utils.SpData;
import demo.lock.model.KeyListObj;
import demo.lock.model.KeyObj;
import demo.model.AccountInfo;
import demo.model.LockObj;
import demo.retrofit.ApiResponse;
import demo.retrofit.ApiResult;
import demo.retrofit.ApiService;
import demo.retrofit.RetrofitAPIManager;
import java.util.ArrayList;
import java.util.HashMap;
import org.greenrobot.eventbus.EventBus;
import org.json.JSONException;
import org.json.JSONObject;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/* JADX INFO: loaded from: classes4.dex */
public class BluetoothService extends Service {
    protected static final int REQUEST_PERMISSION_REQ_CODE = 11;
    public AccountInfo accountInfo;
    LockObj mCurrentLock;
    KeyObj mMyTestLockEKey;
    public String account = "15920012647";
    public String password = "dingchao110";
    private String TAG = BluetoothService.class.getSimpleName();
    private int pageNo = 1;
    private int pageSize = 100;

    public void showConnectLockToast() {
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        throw new UnsupportedOperationException("Not yet implemented");
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        this.password = DigitUtil.getMD5(this.password);
        LockObj deviceMsg = SpData.getDeviceMsg();
        this.mCurrentLock = deviceMsg;
        if (deviceMsg == null) {
            this.mCurrentLock = BaseApplication.getInstance().getChoosedLock();
        }
        startApi();
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    @Override // android.app.Service
    public int onStartCommand(Intent intent, int i, int i2) {
        if (intent != null) {
            String stringExtra = intent.getStringExtra(BaseConstant.Command);
            if (!TextUtils.isEmpty(stringExtra)) {
                byte b = -1;
                switch (stringExtra.hashCode()) {
                    case 3417674:
                        if (stringExtra.equals("open")) {
                            b = 0;
                        }
                        break;
                    case 108404047:
                        if (stringExtra.equals("reset")) {
                            b = 1;
                        }
                        break;
                    case 109757538:
                        if (stringExtra.equals(TtmlNode.START)) {
                            b = 2;
                        }
                        break;
                    case 1085444827:
                        if (stringExtra.equals("refresh")) {
                            b = 3;
                        }
                        break;
                }
                if (b == 0) {
                    doUnlock();
                } else if (b == 1) {
                    resetLock();
                } else if (b == 2) {
                    startApi();
                } else if (b == 3) {
                    lockList();
                }
            }
        }
        return super.onStartCommand(intent, i, i2);
    }

    private void startApi() {
        Log.i("TAG", "startApi: ");
        RetrofitAPIManager.provideClientApi().auth(ApiService.CLIENT_ID, ApiService.CLIENT_SECRET, "password", this.account, this.password, ApiService.REDIRECT_URI).enqueue(new Callback<String>() { // from class: com.yd.android_brand_mvp.BluetoothService.1
            @Override // retrofit2.Callback
            public void onFailure(Call<String> call, Throwable th) {
            }

            @Override // retrofit2.Callback
            public void onResponse(Call<String> call, Response<String> response) {
                BluetoothService.this.accountInfo = (AccountInfo) GsonUtil.toObject(response.body(), AccountInfo.class);
                if (BluetoothService.this.accountInfo != null) {
                    Log.i(BluetoothService.this.TAG, "accountInfo: " + JSON.toJSONString(BluetoothService.this.accountInfo));
                    Log.i(BluetoothService.this.TAG, "onResponse: " + BluetoothService.this.accountInfo.toString());
                    if (BluetoothService.this.accountInfo.errcode != 0) {
                        Log.i(BluetoothService.this.TAG, "errmsgerrmsgerrmsg: " + BluetoothService.this.accountInfo.errmsg);
                        return;
                    }
                    BluetoothService.this.accountInfo.setMd5Pwd(BluetoothService.this.password);
                    BaseApplication.getInstance().setAccountInfo(BluetoothService.this.accountInfo);
                    Log.i(BluetoothService.this.TAG, "lockList: ");
                    BluetoothService.this.lockList();
                    return;
                }
                Log.i(BluetoothService.this.TAG, "accountInfonull: " + response.message());
                BluetoothService.this.makeToast(response.message());
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void lockList() {
        Log.i(this.TAG, "lockList==> ");
        RetrofitAPIManager.provideClientApi().getLockList(ApiService.CLIENT_ID, BaseApplication.getInstance().getAccountInfo().getAccess_token(), this.pageNo, this.pageSize, System.currentTimeMillis()).enqueue(new Callback<String>() { // from class: com.yd.android_brand_mvp.BluetoothService.2
            @Override // retrofit2.Callback
            public void onFailure(Call<String> call, Throwable th) {
            }

            @Override // retrofit2.Callback
            public void onResponse(Call<String> call, Response<String> response) {
                String strBody = response.body();
                Log.i(BluetoothService.this.TAG, "lockList333: " + strBody);
                if (TextUtils.isEmpty(strBody) || !strBody.contains(TUIKitConstants.Selection.LIST)) {
                    return;
                }
                try {
                    ArrayList<LockObj> arrayList = (ArrayList) GsonUtil.toObject(new JSONObject(strBody).getJSONArray(TUIKitConstants.Selection.LIST).toString(), new TypeToken<ArrayList<LockObj>>() { // from class: com.yd.android_brand_mvp.BluetoothService.2.1
                    });
                    Log.i(BluetoothService.this.TAG, "lockObjs.size==>" + arrayList.size());
                    if (arrayList.size() > 0) {
                        BluetoothService.this.setLocalData(arrayList);
                        BluetoothService.this.getUserKeyList();
                    } else {
                        BaseApplication.getInstance().saveChoosedLock(null);
                    }
                    BluetoothService.this.mCurrentLock = BaseApplication.getInstance().getChoosedLock();
                    MinaEventType minaEventType = new MinaEventType();
                    minaEventType.i = BaseConstant.lockList;
                    EventBus.getDefault().post(minaEventType);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        });
    }

    void setLocalData(ArrayList<LockObj> arrayList) {
        String str = SDcarfile.read("lockMac");
        if (!TextUtils.isEmpty(str)) {
            for (LockObj lockObj : arrayList) {
                if (lockObj.getLockMac().equals(str)) {
                    BaseApplication.getInstance().saveChoosedLock(lockObj);
                }
            }
            return;
        }
        Log.i(this.TAG, "没有绑定蓝牙锁设备");
    }

    public void makeToast(String str) {
        Toast.makeText(this, str, 1).show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void getUserKeyList() {
        ApiService apiServiceProvideClientApi = RetrofitAPIManager.provideClientApi();
        HashMap map = new HashMap(6);
        map.put("clientId", ApiService.CLIENT_ID);
        map.put("accessToken", BaseApplication.getInstance().getAccountInfo().getAccess_token());
        map.put("pageNo", "1");
        map.put("pageSize", "1000");
        map.put("date", String.valueOf(System.currentTimeMillis()));
        RetrofitAPIManager.enqueue(apiServiceProvideClientApi.getUserKeyList(map), new TypeToken<KeyListObj>() { // from class: com.yd.android_brand_mvp.BluetoothService.3
        }, new ApiResponse.Listener() { // from class: com.yd.android_brand_mvp.-$$Lambda$BluetoothService$J2vB-GSwu30hNTCpx7CdxIthWtU
            @Override // demo.retrofit.ApiResponse.Listener
            public final void onResponse(Object obj) {
                this.f$0.lambda$getUserKeyList$0$BluetoothService((ApiResult) obj);
            }
        }, new ApiResponse.ErrorListener() { // from class: com.yd.android_brand_mvp.-$$Lambda$BluetoothService$3Ha_YNqFK9ZLu8cBxadiYHpW2ro
            @Override // demo.retrofit.ApiResponse.ErrorListener
            public final void onErrorResponse(Throwable th) {
                this.f$0.lambda$getUserKeyList$1$BluetoothService(th);
            }
        });
    }

    public /* synthetic */ void lambda$getUserKeyList$0$BluetoothService(ApiResult apiResult) {
        if (!apiResult.success.booleanValue()) {
            makeToast("-获取密钥失败-" + apiResult.getMsg());
            return;
        }
        Log.d("OMG", "===result===" + apiResult.getResult() + "===" + apiResult);
        ArrayList<KeyObj> list = ((KeyListObj) apiResult.getResult()).getList();
        this.mCurrentLock = BaseApplication.getInstance().getChoosedLock();
        if (list.isEmpty() || this.mCurrentLock == null) {
            return;
        }
        for (KeyObj keyObj : list) {
            if (keyObj.getLockId() == this.mCurrentLock.getLockId()) {
                this.mMyTestLockEKey = keyObj;
            }
        }
    }

    public /* synthetic */ void lambda$getUserKeyList$1$BluetoothService(Throwable th) {
        makeToast("获取密钥失败" + th.getMessage());
    }

    public void doUnlock() {
        if (this.mCurrentLock == null) {
            MinaEventType minaEventType = new MinaEventType();
            minaEventType.i = 116;
            EventBus.getDefault().post(minaEventType);
        } else {
            ensureBluetoothIsEnabled();
            showConnectLockToast();
            TTLockClient.getDefault().controlLock(3, this.mCurrentLock.getLockData(), this.mCurrentLock.getLockMac(), new ControlLockCallback() { // from class: com.yd.android_brand_mvp.BluetoothService.4
                @Override // com.ttlock.bl.sdk.callback.ControlLockCallback
                public void onControlLockSuccess(int i, int i2, int i3) {
                    Log.e(BluetoothService.this.TAG, "doUnlock: 开锁成功");
                    MinaEventType minaEventType2 = new MinaEventType();
                    minaEventType2.i = 116;
                    EventBus.getDefault().post(minaEventType2);
                }

                @Override // com.ttlock.bl.sdk.callback.ControlLockCallback, com.ttlock.bl.sdk.callback.LockCallback
                public void onFail(LockError lockError) {
                    MinaEventType minaEventType2 = new MinaEventType();
                    minaEventType2.i = 116;
                    EventBus.getDefault().post(minaEventType2);
                    Log.e(BluetoothService.this.TAG, "LockError: " + lockError.getDescription() + lockError.getErrorCode() + lockError.getErrorCode());
                }
            });
        }
    }

    public void ensureBluetoothIsEnabled() {
        TTLockClient.getDefault().isBLEEnabled(this);
    }

    public void resetLock() {
        ensureBluetoothIsEnabled();
        showConnectLockToast();
        TTLockClient.getDefault().resetLock(this.mCurrentLock.getLockData(), this.mCurrentLock.getLockMac(), new ResetLockCallback() { // from class: com.yd.android_brand_mvp.BluetoothService.5
            @Override // com.ttlock.bl.sdk.callback.ResetLockCallback
            public void onResetLockSuccess() {
                BaseApplication.getInstance().saveChoosedLock(null);
                BluetoothService.this.makeToast("重置锁，上传服务器中。。");
                BluetoothService.this.uploadResetLock2Server();
                MinaEventType minaEventType = new MinaEventType();
                minaEventType.i = BaseConstant.lockList;
                EventBus.getDefault().post(minaEventType);
            }

            @Override // com.ttlock.bl.sdk.callback.ResetLockCallback, com.ttlock.bl.sdk.callback.LockCallback
            public void onFail(LockError lockError) {
                BluetoothService.this.makeErrorToast(lockError);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void uploadResetLock2Server() {
        RetrofitAPIManager.enqueue(RetrofitAPIManager.provideClientApi().deleteLock(ApiService.CLIENT_ID, BaseApplication.getInstance().getAccountInfo().getAccess_token(), this.mCurrentLock.getLockId(), System.currentTimeMillis()), new TypeToken<Object>() { // from class: com.yd.android_brand_mvp.BluetoothService.6
        }, new ApiResponse.Listener() { // from class: com.yd.android_brand_mvp.-$$Lambda$BluetoothService$E6zCsXLERD9erMU_GMyleAzun94
            @Override // demo.retrofit.ApiResponse.Listener
            public final void onResponse(Object obj) {
                this.f$0.lambda$uploadResetLock2Server$2$BluetoothService((ApiResult) obj);
            }
        }, new ApiResponse.ErrorListener() { // from class: com.yd.android_brand_mvp.-$$Lambda$BluetoothService$8gefKLh_fV3zpBqfFtbw-ujzTc8
            @Override // demo.retrofit.ApiResponse.ErrorListener
            public final void onErrorResponse(Throwable th) {
                this.f$0.lambda$uploadResetLock2Server$3$BluetoothService(th);
            }
        });
    }

    public /* synthetic */ void lambda$uploadResetLock2Server$2$BluetoothService(ApiResult apiResult) {
        if (!apiResult.success.booleanValue()) {
            makeToast("重置锁 " + apiResult.getMsg());
            return;
        }
        makeToast("重置锁，上传服务器中");
    }

    public /* synthetic */ void lambda$uploadResetLock2Server$3$BluetoothService(Throwable th) {
        makeToast(th.getMessage());
    }

    public void makeErrorToast(LockError lockError) {
        Toast.makeText(this, lockError.getDescription(), 1).show();
    }
}
