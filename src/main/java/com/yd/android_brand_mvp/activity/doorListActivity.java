package com.yd.android_brand_mvp.activity;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.alibaba.fastjson.JSON;
import com.google.android.exoplayer2.ExoPlayer;
import com.google.gson.reflect.TypeToken;
import com.tencent.qcloud.tim.uikit.utils.TUIKitConstants;
import com.ttlock.bl.sdk.api.ExtendedBluetoothDevice;
import com.ttlock.bl.sdk.api.TTLockClient;
import com.ttlock.bl.sdk.callback.InitLockCallback;
import com.ttlock.bl.sdk.callback.ScanLockCallback;
import com.ttlock.bl.sdk.callback.SetNBServerCallback;
import com.ttlock.bl.sdk.constant.Feature;
import com.ttlock.bl.sdk.entity.LockError;
import com.ttlock.bl.sdk.util.GsonUtil;
import com.ttlock.bl.sdk.util.SpecialValueUtil;
import com.yd.android_brand_mvp.BaseApplication;
import com.yd.android_brand_mvp.R;
import com.yd.android_brand_mvp.adapter.LockListAdapter;
import com.yd.android_brand_mvp.base.BaseMvpActivity;
import com.yd.android_brand_mvp.brand.BroCast;
import com.yd.android_brand_mvp.dialog.MsgDiallog2;
import com.yd.android_brand_mvp.model.listSwkRsp;
import com.yd.android_brand_mvp.model.saveSwkRsp;
import com.yd.android_brand_mvp.presenter.LockPresenter;
import com.yd.android_brand_mvp.utils.SDcarfile;
import com.yd.android_brand_mvp.utils.SpData;
import com.yd.android_brand_mvp.view.LockView;
import demo.lock.model.LockInitResultObj;
import demo.model.LockObj;
import demo.retrofit.ApiResponse;
import demo.retrofit.ApiResult;
import demo.retrofit.ApiService;
import demo.retrofit.RetrofitAPIManager;
import java.util.ArrayList;
import org.json.JSONException;
import org.json.JSONObject;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/* JADX INFO: loaded from: classes4.dex */
public class doorListActivity extends BaseMvpActivity<LockPresenter> implements LockView, LockListAdapter.onLockItemClick {
    public boolean isshow;

    @BindView(R.id.list_device)
    RecyclerView listDevice;

    @BindView(R.id.ll_back)
    LinearLayout llBack;
    private LockListAdapter mListApapter;

    @BindView(R.id.title)
    TextView title;
    private int pageNo = 1;
    private int pageSize = 100;
    Handler handler = new Handler() { // from class: com.yd.android_brand_mvp.activity.doorListActivity.7
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message.what == 0 && !doorListActivity.this.isDestroyed()) {
                new MsgDiallog2(doorListActivity.this, "连接成功").show();
            }
            super.handleMessage(message);
        }
    };

    static /* synthetic */ void lambda$upload2Server$2(Throwable th) {
    }

    @Override // com.yd.android_brand_mvp.view.LockView
    public void listLockFail(String str) {
    }

    @Override // com.yd.android_brand_mvp.view.LockView
    public void listLockSuccues(listSwkRsp listswkrsp) {
    }

    @Override // com.yd.android_brand_mvp.view.LockView
    public void saveLockFail(String str) {
    }

    @Override // com.yd.android_brand_mvp.view.LockView
    public void saveLockSuccues(saveSwkRsp saveswkrsp) {
    }

    @Override // com.yd.android_brand_mvp.base.BaseView
    public void showError() {
    }

    @Override // com.yd.android_brand_mvp.base.BaseMvpActivity, com.yd.android_brand_mvp.base.BaseActivity, skin.support.app.SkinCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_door_list);
        ButterKnife.bind(this);
        initList();
        getScanLockCallback();
        this.llBack.setOnClickListener(new View.OnClickListener() { // from class: com.yd.android_brand_mvp.activity.-$$Lambda$doorListActivity$dWXCiq6HDzRE5DzxdqQV9D_h6Us
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$onCreate$0$doorListActivity(view);
            }
        });
    }

    public /* synthetic */ void lambda$onCreate$0$doorListActivity(View view) {
        finish();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.yd.android_brand_mvp.base.BaseMvpActivity
    public LockPresenter createPresenter() {
        return new LockPresenter(this);
    }

    private void initList() {
        LockListAdapter lockListAdapter = new LockListAdapter(this);
        this.mListApapter = lockListAdapter;
        this.listDevice.setAdapter(lockListAdapter);
        this.listDevice.setLayoutManager(new LinearLayoutManager(this));
        this.mListApapter.setOnLockItemClick(this);
    }

    @Override // com.yd.android_brand_mvp.base.BaseMvpActivity, com.yd.android_brand_mvp.base.BaseActivity, skin.support.app.SkinCompatActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
    }

    private void getScanLockCallback() {
        Log.i("TAG", "getScanLockCallback: ");
        TTLockClient.getDefault().startScanLock(new ScanLockCallback() { // from class: com.yd.android_brand_mvp.activity.doorListActivity.1
            @Override // com.ttlock.bl.sdk.callback.ScanLockCallback
            public void onScanLockSuccess(ExtendedBluetoothDevice extendedBluetoothDevice) {
                if (doorListActivity.this.mListApapter != null) {
                    doorListActivity.this.mListApapter.updateData(extendedBluetoothDevice);
                }
            }

            @Override // com.ttlock.bl.sdk.callback.ScanLockCallback, com.ttlock.bl.sdk.callback.LockCallback
            public void onFail(LockError lockError) {
                Log.i("TAG", "onFail: " + lockError);
            }
        });
    }

    @Override // com.yd.android_brand_mvp.adapter.LockListAdapter.onLockItemClick
    public void onClick(final ExtendedBluetoothDevice extendedBluetoothDevice) {
        if (BaseApplication.getInstance().getChoosedLock() != null) {
            BroCast.reset(this);
            new Handler().postDelayed(new Runnable() { // from class: com.yd.android_brand_mvp.activity.doorListActivity.2
                @Override // java.lang.Runnable
                public void run() {
                    TTLockClient.getDefault().initLock(extendedBluetoothDevice, new InitLockCallback() { // from class: com.yd.android_brand_mvp.activity.doorListActivity.2.1
                        @Override // com.ttlock.bl.sdk.callback.InitLockCallback
                        public void onInitLockSuccess(String str, int i) {
                            if (SpecialValueUtil.isSupportFeature(i, Feature.NB_LOCK)) {
                                doorListActivity.this.setNBServerForNBLock(str, extendedBluetoothDevice.getAddress());
                            } else {
                                doorListActivity.this.makeToast("初始化锁成功");
                                doorListActivity.this.upload2Server(str, extendedBluetoothDevice.getAddress());
                            }
                        }

                        @Override // com.ttlock.bl.sdk.callback.InitLockCallback, com.ttlock.bl.sdk.callback.LockCallback
                        public void onFail(LockError lockError) {
                            doorListActivity.this.makeErrorToast(lockError);
                        }
                    });
                }
            }, ExoPlayer.DEFAULT_DETACH_SURFACE_TIMEOUT_MS);
        } else {
            TTLockClient.getDefault().initLock(extendedBluetoothDevice, new InitLockCallback() { // from class: com.yd.android_brand_mvp.activity.doorListActivity.3
                @Override // com.ttlock.bl.sdk.callback.InitLockCallback
                public void onInitLockSuccess(String str, int i) {
                    if (SpecialValueUtil.isSupportFeature(i, Feature.NB_LOCK)) {
                        doorListActivity.this.setNBServerForNBLock(str, extendedBluetoothDevice.getAddress());
                    } else {
                        doorListActivity.this.makeToast("初始化锁成功");
                        doorListActivity.this.llBack.setEnabled(false);
                        doorListActivity.this.upload2Server(str, extendedBluetoothDevice.getAddress());
                    }
                    Log.i("TAG", "onInitLockSuccess: " + str);
                    doorListActivity.this.getlockList2();
                }

                @Override // com.ttlock.bl.sdk.callback.InitLockCallback, com.ttlock.bl.sdk.callback.LockCallback
                public void onFail(LockError lockError) {
                    doorListActivity.this.makeErrorToast(lockError);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setNBServerForNBLock(final String str, final String str2) {
        TTLockClient.getDefault().setNBServerInfo((short) 8011, "192.127.123.11", str, str2, new SetNBServerCallback() { // from class: com.yd.android_brand_mvp.activity.doorListActivity.4
            @Override // com.ttlock.bl.sdk.callback.SetNBServerCallback
            public void onSetNBServerSuccess(int i) {
                doorListActivity.this.makeToast("设置服务成功");
                doorListActivity.this.upload2Server(str, str2);
            }

            @Override // com.ttlock.bl.sdk.callback.SetNBServerCallback, com.ttlock.bl.sdk.callback.LockCallback
            public void onFail(LockError lockError) {
                doorListActivity.this.makeErrorToast(lockError);
                doorListActivity.this.upload2Server(str, str2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void upload2Server(String str, final String str2) {
        RetrofitAPIManager.enqueue(RetrofitAPIManager.provideClientApi().lockInit(ApiService.CLIENT_ID, BaseApplication.getInstance().getAccountInfo().getAccess_token(), str, SpData.getSchoolName() + "_" + SpData.getSchoolId() + "_" + BaseApplication.getInstance().getMac(), System.currentTimeMillis()), new TypeToken<LockInitResultObj>() { // from class: com.yd.android_brand_mvp.activity.doorListActivity.5
        }, new ApiResponse.Listener() { // from class: com.yd.android_brand_mvp.activity.-$$Lambda$doorListActivity$-E9E8rDLlQo3uCYCvAuh2_5bs3k
            @Override // demo.retrofit.ApiResponse.Listener
            public final void onResponse(Object obj) {
                this.f$0.lambda$upload2Server$1$doorListActivity(str2, (ApiResult) obj);
            }
        }, new ApiResponse.ErrorListener() { // from class: com.yd.android_brand_mvp.activity.-$$Lambda$doorListActivity$9w9OZUqMgMrXo7oRr-k0iOSdRiA
            @Override // demo.retrofit.ApiResponse.ErrorListener
            public final void onErrorResponse(Throwable th) {
                doorListActivity.lambda$upload2Server$2(th);
            }
        });
    }

    public /* synthetic */ void lambda$upload2Server$1$doorListActivity(String str, ApiResult apiResult) {
        if (!apiResult.success.booleanValue()) {
            makeToast("上传到服务失败" + apiResult.getMsg());
            return;
        }
        SDcarfile.save("lockMac", str);
        this.handler.sendEmptyMessage(0);
        this.llBack.setEnabled(true);
        makeToast("锁初始化成功");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void getlockList2() {
        Log.i("TAG", "lockList==> ");
        RetrofitAPIManager.provideClientApi().getLockList(ApiService.CLIENT_ID, BaseApplication.getInstance().getAccountInfo().getAccess_token(), this.pageNo, this.pageSize, System.currentTimeMillis()).enqueue(new Callback<String>() { // from class: com.yd.android_brand_mvp.activity.doorListActivity.6
            @Override // retrofit2.Callback
            public void onFailure(Call<String> call, Throwable th) {
            }

            @Override // retrofit2.Callback
            public void onResponse(Call<String> call, Response<String> response) {
                String strBody = response.body();
                if (strBody.contains(TUIKitConstants.Selection.LIST)) {
                    try {
                        ArrayList arrayList = (ArrayList) GsonUtil.toObject(new JSONObject(strBody).getJSONArray(TUIKitConstants.Selection.LIST).toString(), new TypeToken<ArrayList<LockObj>>() { // from class: com.yd.android_brand_mvp.activity.doorListActivity.6.1
                        });
                        Log.i("TAG", "lockObjs.size==>" + arrayList.size());
                        Log.i("TAG", "getlockList2: " + JSON.toJSONString(arrayList));
                        arrayList.size();
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
    }

    public void makeToast(String str) {
        Toast.makeText(this, str, 1).show();
    }

    public void makeErrorToast(LockError lockError) {
        Toast.makeText(this, lockError.getDescription(), 1).show();
    }
}
