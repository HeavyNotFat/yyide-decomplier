package com.yd.android_brand_mvp.landscape;

import android.content.DialogInterface;
import android.content.Intent;
import android.media.AudioManager;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.Process;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import butterknife.BindView;
import butterknife.OnClick;
import com.alibaba.fastjson.JSON;
import com.blankj.utilcode.util.AppUtils;
import com.blankj.utilcode.util.LogUtils;
import com.blankj.utilcode.util.SPUtils;
import com.blankj.utilcode.util.ScreenUtils;
import com.blankj.utilcode.util.ToastUtils;
import com.google.android.exoplayer2.C;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.orhanobut.hawk.Hawk;
import com.yd.android_brand_mvp.BaseApplication;
import com.yd.android_brand_mvp.R;
import com.yd.android_brand_mvp.activity.ConfigActivity;
import com.yd.android_brand_mvp.activity.doorControlActivity;
import com.yd.android_brand_mvp.base.BaseConstant;
import com.yd.android_brand_mvp.base.BaseMvpFragment;
import com.yd.android_brand_mvp.base.MMKVConstant;
import com.yd.android_brand_mvp.base.MinaConstants;
import com.yd.android_brand_mvp.brand.BrandConfig;
import com.yd.android_brand_mvp.brand.BroCast;
import com.yd.android_brand_mvp.db.AppDatabase;
import com.yd.android_brand_mvp.db.AttendanceDao;
import com.yd.android_brand_mvp.db.DataBaseInstance;
import com.yd.android_brand_mvp.db.User;
import com.yd.android_brand_mvp.db.UserDao;
import com.yd.android_brand_mvp.dialog.ActivationFaceDialog;
import com.yd.android_brand_mvp.dialog.CheackLongDiallog;
import com.yd.android_brand_mvp.dialog.ExitSystemDiallog;
import com.yd.android_brand_mvp.dialog.MessageDialog;
import com.yd.android_brand_mvp.dialog.PowerDiallog;
import com.yd.android_brand_mvp.dialog.RebootDiallog;
import com.yd.android_brand_mvp.dialog.TimeDialog;
import com.yd.android_brand_mvp.dialog.UpdataBestDiallog;
import com.yd.android_brand_mvp.dialog.UpdataInfoDiallog;
import com.yd.android_brand_mvp.dialog.UpdataIngDiallog;
import com.yd.android_brand_mvp.model.BrandConfigBean;
import com.yd.android_brand_mvp.model.NetWorkCheckBean;
import com.yd.android_brand_mvp.model.UpdateDialogIsTimeEventBean;
import com.yd.android_brand_mvp.model.getNewestVersionRsp;
import com.yd.android_brand_mvp.model.insetVersionUpdatedSchoolRsp;
import com.yd.android_brand_mvp.model.manageListRsp;
import com.yd.android_brand_mvp.model.queryClassificListRsp;
import com.yd.android_brand_mvp.observer.MinaEventManager;
import com.yd.android_brand_mvp.presenter.SettingPresenter;
import com.yd.android_brand_mvp.utils.ActivityTool;
import com.yd.android_brand_mvp.utils.AudioUtil;
import com.yd.android_brand_mvp.utils.FontsUtils;
import com.yd.android_brand_mvp.utils.GPIOUtils;
import com.yd.android_brand_mvp.utils.LongClickUtils;
import com.yd.android_brand_mvp.utils.MMKVUtils;
import com.yd.android_brand_mvp.utils.SPUtil;
import com.yd.android_brand_mvp.utils.SpData;
import com.yd.android_brand_mvp.utils.Tool;
import com.yd.android_brand_mvp.utils.view.net.GsonUtils;
import com.yd.android_brand_mvp.view.SettingView;
import com.ys.rkapi.MyManager;
import com.yyide.facepass.FaceManager;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;
import skin.support.SkinCompatManager;

/* JADX INFO: loaded from: classes4.dex */
public class SettingFragment extends BaseMvpFragment<SettingPresenter> implements SettingView {
    private int NetType;
    public AudioManager audiomanage;

    @BindView(R.id.bg)
    FrameLayout bg;
    private int currentVolume;
    UpdataIngDiallog dialog;

    @BindView(R.id.down)
    ImageView down;
    EtherNetFragment etherNetFragment;
    private FragmentTransaction fm;

    @BindView(R.id.layout_get_face)
    LinearLayout getFaceCode;

    @BindView(R.id.layout1)
    LinearLayout layout1;

    @BindView(R.id.layout10)
    LinearLayout layout10;

    @BindView(R.id.layout3)
    LinearLayout layout3;

    @BindView(R.id.layout4)
    LinearLayout layout4;

    @BindView(R.id.layout5)
    LinearLayout layout5;

    @BindView(R.id.layout6)
    LinearLayout layout6;

    @BindView(R.id.layout7)
    LinearLayout layout7;

    @BindView(R.id.layout8)
    LinearLayout layout8;

    @BindView(R.id.layout88)
    LinearLayout layout88;

    @BindView(R.id.layout9)
    LinearLayout layout9;

    @BindView(R.id.layout99)
    LinearLayout layout99;

    @BindView(R.id.layout_close)
    LinearLayout layout_close;

    @BindView(R.id.layout_open)
    LinearLayout layout_open;

    @BindView(R.id.layout_screen)
    LinearLayout layout_screen;

    @BindView(R.id.layout_skin)
    LinearLayout layout_skin;

    @BindView(R.id.ll_back)
    LinearLayout llBack;
    PingNetworkFragment mPingNetworkFragment;

    @BindView(R.id.activation_textview)
    TextView mTvActivation;
    MyManager manager;
    private int maxVolume;

    @BindView(R.id.msg2)
    TextView msg2;
    NetWorkFragment netWorkFragment;

    @BindView(R.id.rl_bg)
    RelativeLayout rl_bg;
    SeekBar seekBar;

    @BindView(R.id.title)
    TextView title;

    @BindView(R.id.toplongview)
    TextView toplongview;

    @BindView(R.id.tv_lab3)
    TextView tvLab3;

    @BindView(R.id.tv_lab4)
    TextView tvLab4;

    @BindView(R.id.tvScreen)
    TextView tvScreen;

    @BindView(R.id.tvSkin)
    TextView tvSkin;

    @BindView(R.id.tv_bg_img)
    ImageView tv_bg_img;

    @BindView(R.id.tv_bg_img2)
    ImageView tv_bg_img2;
    TextView tv_currentVolume;

    @BindView(R.id.up)
    ImageView up;
    public String versioncode;
    WIfiFragment wIfiFragment;
    private Fragment[] fragments = new Fragment[1];
    Handler handler = new Handler(Looper.getMainLooper()) { // from class: com.yd.android_brand_mvp.landscape.SettingFragment.1
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            SettingFragment settingFragment = SettingFragment.this;
            settingFragment.audiomanage = (AudioManager) settingFragment.mActivity.getSystemService("audio");
            SettingFragment.this.seekBar.setMax(100);
            SettingFragment settingFragment2 = SettingFragment.this;
            settingFragment2.maxVolume = settingFragment2.audiomanage.getStreamMaxVolume(3);
            SettingFragment settingFragment3 = SettingFragment.this;
            settingFragment3.currentVolume = settingFragment3.audiomanage.getStreamVolume(3);
            Log.e("TAG", "currentVolume: " + SettingFragment.this.currentVolume);
            TextView textView = SettingFragment.this.tv_currentVolume;
            StringBuilder sb = new StringBuilder();
            SettingFragment settingFragment4 = SettingFragment.this;
            sb.append(settingFragment4.getVoice(settingFragment4.currentVolume));
            sb.append("%");
            textView.setText(sb.toString());
        }
    };

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return layoutInflater.inflate(R.layout.fragment_setting, viewGroup, false);
    }

    @Override // com.yd.android_brand_mvp.base.BaseMvpFragment, com.yd.android_brand_mvp.base.BaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        if (!EventBus.getDefault().isRegistered(this)) {
            EventBus.getDefault().register(this);
        }
        if (!ScreenUtils.isLandscape()) {
            this.rl_bg.setVisibility(8);
        }
        initData(view);
        this.title.setOnClickListener(new View.OnClickListener() { // from class: com.yd.android_brand_mvp.landscape.SettingFragment.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                new TimeDialog(SettingFragment.this.mActivity, "").show();
            }
        });
        if (BaseConstant.BlueToothLock) {
            this.layout88.setVisibility(0);
        } else {
            this.layout88.setVisibility(8);
        }
        LogUtils.i("进入设置页面");
        if ("isLogin".equals(getArguments().getString("type"))) {
            this.getFaceCode.setVisibility(8);
            this.layout1.setVisibility(8);
            this.layout6.setVisibility(8);
            this.layout88.setVisibility(8);
            this.layout_skin.setVisibility(8);
            this.layout_open.setVisibility(8);
            this.layout_close.setVisibility(8);
            this.layout_screen.setVisibility(8);
        }
        if (BrandConfig.isCustom) {
            this.layout_screen.setVisibility(8);
        }
        initActivationView();
        this.layout99.setOnClickListener(new View.OnClickListener() { // from class: com.yd.android_brand_mvp.landscape.SettingFragment.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
            }
        });
        LongClickUtils.setLongClick(new Handler(), this.toplongview, C.DEFAULT_MAX_SEEK_TO_PREVIOUS_POSITION_MS, new View.OnLongClickListener() { // from class: com.yd.android_brand_mvp.landscape.SettingFragment.4
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view2) {
                new CheackLongDiallog(SettingFragment.this.mActivity).show();
                return true;
            }
        });
        initData();
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.fm = getFragmentManager().beginTransaction();
    }

    private void initData(View view) {
        BrandConfigBean brandConfigBean = (BrandConfigBean) GsonUtils.fromJson(MMKVUtils.INSTANCE.getString(MMKVConstant.BRAND), BrandConfigBean.class);
        if (brandConfigBean != null) {
            String cardReaderSerialPortCode = brandConfigBean.getCardReaderSerialPortCode();
            TextView textView = this.tvLab4;
            if (TextUtils.isEmpty(cardReaderSerialPortCode)) {
                cardReaderSerialPortCode = BaseConstant.SPORT3;
            }
            textView.setText(cardReaderSerialPortCode);
        }
        getUpdateNetwork();
        TextView textView2 = (TextView) view.findViewById(R.id.msg2);
        this.msg2 = textView2;
        textView2.setText("V:" + AppUtils.getAppVersionName());
        ImageView imageView = (ImageView) this.layout4.findViewById(R.id.tv_bg_img);
        this.tv_bg_img = imageView;
        imageView.setVisibility(0);
        this.tv_bg_img2.setVisibility(8);
        this.layout9.setVisibility(8);
        this.seekBar = (SeekBar) view.findViewById(R.id.seekBar);
        this.handler.sendMessage(new Message());
        AudioManager audioManager = (AudioManager) this.mActivity.getSystemService("audio");
        this.audiomanage = audioManager;
        this.maxVolume = audioManager.getStreamMaxVolume(3);
        this.currentVolume = this.audiomanage.getStreamVolume(3);
        TextView textView3 = (TextView) view.findViewById(R.id.tv_currentVolume);
        this.tv_currentVolume = textView3;
        textView3.setText(((this.currentVolume * 100) / this.maxVolume) + " %");
        this.tvScreen.setText(MMKVUtils.INSTANCE.getBoolean(MMKVConstant.SCREEN_CODE) ? "是" : "否");
        this.seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() { // from class: com.yd.android_brand_mvp.landscape.SettingFragment.5
            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStopTrackingTouch(SeekBar seekBar) {
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
                Log.e("TAG", "onProgressChanged: " + i);
                SettingFragment.this.tv_currentVolume.setText(i + " %");
                SettingFragment.this.setVoice(i);
            }
        });
        int mediaMaxVolume = (int) ((AudioUtil.getInstance(this.mActivity).getMediaMaxVolume() / 100.0f) * AudioUtil.getInstance(this.mActivity).getMediaVolume());
        this.tv_currentVolume.setText(mediaMaxVolume + "");
        this.down.setOnClickListener(new View.OnClickListener() { // from class: com.yd.android_brand_mvp.landscape.-$$Lambda$SettingFragment$3Uhhqo90-v_BfX2j78BAtyqqePY
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                this.f$0.lambda$initData$0$SettingFragment(view2);
            }
        });
        this.up.setOnClickListener(new View.OnClickListener() { // from class: com.yd.android_brand_mvp.landscape.-$$Lambda$SettingFragment$nfwTwT3dqFyBcJNCBf7DEZoh0mc
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                this.f$0.lambda$initData$1$SettingFragment(view2);
            }
        });
    }

    public /* synthetic */ void lambda$initData$0$SettingFragment(View view) {
        if (this.seekBar.getProgress() != 0) {
            SeekBar seekBar = this.seekBar;
            seekBar.setProgress(seekBar.getProgress() - 1);
            TextView textView = this.tv_currentVolume;
            StringBuilder sb = new StringBuilder();
            sb.append(this.seekBar.getProgress() - 1);
            sb.append(" %");
            textView.setText(sb.toString());
        }
    }

    public /* synthetic */ void lambda$initData$1$SettingFragment(View view) {
        if (this.seekBar.getProgress() != 100) {
            SeekBar seekBar = this.seekBar;
            seekBar.setProgress(seekBar.getProgress() + 1);
            this.tv_currentVolume.setText((this.seekBar.getProgress() + 1) + " %");
        }
    }

    private void getUpdateNetwork() {
        if (Tool.getNetworkAvailableTypeName(this.mActivity) != null) {
            if (Tool.getNetworkAvailableTypeName(this.mActivity).getTypeName().equals("Ethernet")) {
                this.tvLab3.setText("以太网");
                return;
            } else {
                this.tvLab3.setText(Tool.getNetworkAvailableTypeName(this.mActivity).getExtraInfo());
                return;
            }
        }
        this.tvLab3.setText("未连接");
    }

    void setVoice(int i) {
        SPUtil.put("voice", Integer.valueOf(i));
        Log.e("TAG", "setVoice voice: " + i);
        int i2 = (int) ((((float) this.maxVolume) / 100.0f) * ((float) i));
        Log.e("TAG", "setStreamVolume: " + i2);
        AudioManager audioManager = this.audiomanage;
        if (audioManager != null) {
            audioManager.setStreamVolume(3, i2, 0);
        }
    }

    int getVoice(int i) {
        int i2 = (int) ((i / this.maxVolume) * 100.0f);
        Log.e("TAG", "getVoice voice: " + i);
        Log.e("TAG", "getVoice: " + i2);
        this.seekBar.setProgress(i2);
        return i2;
    }

    @Override // com.yd.android_brand_mvp.base.BaseFragment, com.yd.android_brand_mvp.observer.MinaListener
    public void UpdataEvent(int i) {
        if (i == MinaConstants.ActivationFaceCodeStatus) {
            initActivationView();
        }
    }

    private void initActivationView() {
        this.mActivity.runOnUiThread(new Runnable() { // from class: com.yd.android_brand_mvp.landscape.-$$Lambda$SettingFragment$RAW2yCzseFU3NlEarL81wuCVmG4
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$initActivationView$2$SettingFragment();
            }
        });
    }

    public /* synthetic */ void lambda$initActivationView$2$SettingFragment() {
        this.mTvActivation.setText(SpData.isFaceEnable() ? "已激活" : "未激活");
    }

    /* JADX WARN: Type inference failed for: r6v2, types: [com.yd.android_brand_mvp.landscape.SettingFragment$6] */
    @OnClick({R.id.layout_config, R.id.layout1, R.id.layout3, R.id.layout4, R.id.layout5, R.id.layout6, R.id.layout7, R.id.layout8, R.id.layout9, R.id.layout10, R.id.ll_back, R.id.layout11, R.id.layout88, R.id.layout_get_face, R.id.layout_skin, R.id.layout_open, R.id.layout_close, R.id.layout_screen, R.id.layout_network_test})
    public void onViewClicked(View view) {
        int id = view.getId();
        switch (id) {
            case R.id.layout1 /* 2131363071 */:
                new Thread() { // from class: com.yd.android_brand_mvp.landscape.SettingFragment.6
                    @Override // java.lang.Thread, java.lang.Runnable
                    public void run() {
                        Looper.prepare();
                        LogUtils.i("设置", "brand setting exit login");
                        FaceManager.INSTANCE.clearAllFace(SettingFragment.this.mActivity, null);
                        SPUtils.getInstance().clear(true);
                        Hawk.deleteAll();
                        MMKVUtils.INSTANCE.clearAll();
                        FaceManager.INSTANCE.onDestroyFacePassHandler();
                        SettingFragment.this.deleteData();
                        ActivityTool.relaunchApp(true, SettingFragment.this.getActivity());
                        Looper.loop();
                    }
                }.start();
                break;
            case R.id.layout10 /* 2131363072 */:
                checkEtherNetFragment();
                LogUtils.i("设置", "brand setting Ethernet");
                break;
            case R.id.layout11 /* 2131363073 */:
                LogUtils.i("设置", "brand setting Exit system");
                new ExitSystemDiallog(this.mActivity, new ExitSystemDiallog.OnExitSystem() { // from class: com.yd.android_brand_mvp.landscape.SettingFragment.7
                    @Override // com.yd.android_brand_mvp.dialog.ExitSystemDiallog.OnExitSystem
                    public void onExitSystem() {
                        ActivityTool.getInstance().finishAllActivity();
                    }
                }).show();
                break;
            case R.id.layout3 /* 2131363074 */:
                LogUtils.i("设置", "brand setting 网络设置");
                startActivity(new Intent("android.settings.SETTINGS"));
                BroCast.showBar(this.mActivity);
                break;
            case R.id.layout4 /* 2131363075 */:
                LogUtils.i("设置", "brand setting voice");
                if (this.layout9.isShown()) {
                    this.tv_bg_img.setVisibility(0);
                    this.tv_bg_img2.setVisibility(8);
                    this.layout9.setVisibility(8);
                } else {
                    this.tv_bg_img.setVisibility(8);
                    this.tv_bg_img2.setVisibility(0);
                    this.layout9.setVisibility(0);
                }
                break;
            case R.id.layout5 /* 2131363076 */:
                LogUtils.i("设置", "brand setting Serial");
                break;
            case R.id.layout6 /* 2131363077 */:
                LogUtils.i("设置", "brand setting check update");
                MinaEventManager.getInstance().notifyObserver(MinaConstants.update);
                getActivity().finish();
                break;
            case R.id.layout7 /* 2131363078 */:
                LogUtils.i("设置", "brand setting reboot");
                new RebootDiallog(this.mActivity).show();
                break;
            case R.id.layout8 /* 2131363079 */:
                LogUtils.i("设置", "brand setting reboot");
                new PowerDiallog(this.mActivity).show();
                break;
            case R.id.layout88 /* 2131363080 */:
                LogUtils.i("设置", "brand setting Bluetooth lock");
                if (BaseConstant.BlueToothLock) {
                    startActivity(new Intent(this.mActivity, (Class<?>) doorControlActivity.class));
                }
                break;
            default:
                switch (id) {
                    case R.id.layout_close /* 2131363091 */:
                        GPIOUtils.INSTANCE.close();
                        break;
                    case R.id.layout_config /* 2131363092 */:
                        startActivity(new Intent(getActivity(), (Class<?>) ConfigActivity.class));
                        break;
                    default:
                        switch (id) {
                            case R.id.layout_get_face /* 2131363094 */:
                                LogUtils.i("设置", "brand setting 人脸激活");
                                new ActivationFaceDialog().show(getParentFragmentManager(), "messageTip");
                                break;
                            case R.id.layout_screen /* 2131363105 */:
                                if (!MMKVUtils.INSTANCE.getBoolean(MMKVConstant.SCREEN_CODE)) {
                                    BroCast.setLauncher(getContext());
                                    MMKVUtils.INSTANCE.put(MMKVConstant.SCREEN_CODE, (Object) true);
                                    this.tvScreen.setText("是");
                                } else {
                                    BroCast.cancelLauncher(getContext());
                                    MMKVUtils.INSTANCE.put(MMKVConstant.SCREEN_CODE, (Object) false);
                                    this.tvScreen.setText("否");
                                }
                                break;
                            case R.id.layout_skin /* 2131363109 */:
                                LogUtils.i("设置", "layout_skin 皮肤切换");
                                MessageDialog messageDialog = new MessageDialog(this.mActivity);
                                messageDialog.show();
                                messageDialog.setOnCallBackListener(new MessageDialog.OnCallBackListener() { // from class: com.yd.android_brand_mvp.landscape.-$$Lambda$SettingFragment$tLOBGrniZvJPUapDkDbkZG4I-rY
                                    @Override // com.yd.android_brand_mvp.dialog.MessageDialog.OnCallBackListener
                                    public final void onClick() {
                                        this.f$0.lambda$onViewClicked$3$SettingFragment();
                                    }
                                });
                                break;
                            case R.id.ll_back /* 2131363194 */:
                                Log.e("TAG", "onViewClicked: ll_back");
                                try {
                                    this.mActivity.finish();
                                } catch (Exception unused) {
                                    System.out.print("退出异常");
                                    return;
                                }
                                break;
                            default:
                                switch (id) {
                                    case R.id.layout_network_test /* 2131363098 */:
                                        Bundle bundle = new Bundle();
                                        bundle.putString(FirebaseAnalytics.Param.INDEX, "2");
                                        bundle.putString("hide", "net");
                                        NetWorkFragment(bundle);
                                        break;
                                    case R.id.layout_open /* 2131363099 */:
                                        GPIOUtils.INSTANCE.open(requireContext());
                                        break;
                                }
                                break;
                        }
                        break;
                }
                break;
        }
    }

    public /* synthetic */ void lambda$onViewClicked$3$SettingFragment() {
        if (SPUtils.getInstance().getBoolean(SpData.SKIN)) {
            SPUtils.getInstance().put(SpData.SKIN, false);
            SkinCompatManager.getInstance().restoreDefaultTheme();
            FontsUtils.INSTANCE.typeFaceDefault();
            reStart();
        } else {
            SPUtils.getInstance().put(SpData.SKIN, true);
            SkinCompatManager.getInstance().loadSkin("animation.skin", 0);
            FontsUtils.INSTANCE.replaceSystemDefaultFont(this.mActivity, FontsUtils.fontPath);
        }
        MinaEventManager.getInstance().notifyObserver(MinaConstants.THEME_BG);
        this.mActivity.finish();
    }

    private void reStart() {
        LogUtils.i("设置", "brand setting reStart");
        new Handler().postDelayed(new Runnable() { // from class: com.yd.android_brand_mvp.landscape.-$$Lambda$SettingFragment$dOjcK9BERKu7efSnNaDdTMDMSfw
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$reStart$4$SettingFragment();
            }
        }, 500L);
    }

    public /* synthetic */ void lambda$reStart$4$SettingFragment() {
        Intent launchIntentForPackage = BaseApplication.getInstance().getPackageManager().getLaunchIntentForPackage(BaseApplication.getInstance().getPackageName());
        launchIntentForPackage.addFlags(67108864);
        startActivity(launchIntentForPackage);
        Process.killProcess(Process.myPid());
    }

    void deleteData() {
        AppDatabase dataBaseInstance = DataBaseInstance.getInstance(this.mActivity);
        new DeleteAsyncTask(dataBaseInstance.userDao(), dataBaseInstance.AttendanceDao()).execute(new UserDao[0]);
    }

    public static class DeleteAsyncTask extends AsyncTask<UserDao, User, Void> {
        private AttendanceDao attendanceDao;
        private UserDao toDoDao;

        DeleteAsyncTask(UserDao userDao, AttendanceDao attendanceDao) {
            this.toDoDao = userDao;
            this.attendanceDao = attendanceDao;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        public Void doInBackground(UserDao... userDaoArr) {
            this.toDoDao.deleteAll();
            this.attendanceDao.deleteAll();
            return null;
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onStop() {
        super.onStop();
        this.tv_bg_img.setVisibility(0);
        this.tv_bg_img2.setVisibility(8);
        hideLoading();
        this.layout9.setVisibility(8);
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onCheckNet(NetWorkCheckBean netWorkCheckBean) {
        getUpdateNetwork();
        if (netWorkCheckBean.type == 1) {
            Log.e("wick1", "wifi==>  ");
            checkWifiFragment();
        } else {
            Log.e("wick1", "以太網==>  ");
            checkEtherNetFragment();
        }
    }

    void checkEtherNetFragment() {
        FragmentTransaction fragmentTransactionBeginTransaction = getFragmentManager().beginTransaction();
        if (this.etherNetFragment == null) {
            this.etherNetFragment = new EtherNetFragment();
        }
        if (ScreenUtils.isLandscape()) {
            fragmentTransactionBeginTransaction.replace(R.id.fm_setting, this.etherNetFragment);
        } else {
            fragmentTransactionBeginTransaction.replace(R.id.content, this.etherNetFragment);
        }
        fragmentTransactionBeginTransaction.addToBackStack(null);
        fragmentTransactionBeginTransaction.commit();
    }

    void NetWorkFragment(Bundle bundle) {
        FragmentTransaction fragmentTransactionBeginTransaction = getFragmentManager().beginTransaction();
        if (this.netWorkFragment == null) {
            this.netWorkFragment = new NetWorkFragment();
        }
        if (ScreenUtils.isLandscape()) {
            fragmentTransactionBeginTransaction.replace(R.id.fm_setting, this.netWorkFragment);
        } else {
            fragmentTransactionBeginTransaction.replace(R.id.content, this.netWorkFragment);
        }
        fragmentTransactionBeginTransaction.addToBackStack(null);
        this.netWorkFragment.setArguments(bundle);
        fragmentTransactionBeginTransaction.commit();
    }

    private void initData() {
        MyManager myManager = MyManager.getInstance(this.mActivity);
        this.manager = myManager;
        myManager.bindAIDLService(this.mActivity);
        this.NetType = this.manager.getCurrentNetType();
    }

    void checkWifiFragment() {
        int i = this.NetType;
        if (i != 0) {
            if (i == 1) {
                Toast.makeText(this.mActivity, "当前网络是WIFI", 1).show();
            } else if (i == -100) {
                Toast.makeText(this.mActivity, "当前网络是未知网络", 1).show();
            }
        }
        FragmentTransaction fragmentTransactionBeginTransaction = getFragmentManager().beginTransaction();
        fragmentTransactionBeginTransaction.setCustomAnimations(R.anim.anim_from_right, R.anim.anim_out_left);
        fragmentTransactionBeginTransaction.setTransition(4097);
        if (this.wIfiFragment == null) {
            this.wIfiFragment = new WIfiFragment();
        }
        if (ScreenUtils.isLandscape()) {
            fragmentTransactionBeginTransaction.replace(R.id.fm_setting, this.wIfiFragment);
        } else {
            fragmentTransactionBeginTransaction.replace(R.id.content, this.wIfiFragment);
        }
        fragmentTransactionBeginTransaction.addToBackStack(null);
        fragmentTransactionBeginTransaction.commit();
    }

    @Override // com.yd.android_brand_mvp.base.BaseMvpFragment, com.yd.android_brand_mvp.base.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        if (EventBus.getDefault().isRegistered(this)) {
            EventBus.getDefault().unregister(this);
        }
        this.manager.unBindAIDLService(this.mActivity);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.yd.android_brand_mvp.base.BaseMvpFragment
    public SettingPresenter createPresenter() {
        return new SettingPresenter(this);
    }

    @Override // com.yd.android_brand_mvp.view.SettingView
    public void ManageListSuccess(manageListRsp managelistrsp) {
        if (managelistrsp.code.intValue() == BaseConstant.REQUEST_SUCCES2) {
            ((SettingPresenter) this.mvpPresenter).queryClassificList(Integer.valueOf(managelistrsp.data.size() > 0 ? managelistrsp.data.get(0).id.intValue() : 0));
            return;
        }
        ToastUtils.showShort(managelistrsp.msg);
        if (getActivity().isDestroyed()) {
            return;
        }
        this.nomalLoadingDiallog.dismiss();
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        BroCast.hidebar(this.mActivity);
    }

    @Override // com.yd.android_brand_mvp.view.SettingView
    public void ManageListFail(String str) {
        ToastUtils.showShort(str);
        if (getActivity().isDestroyed()) {
            return;
        }
        this.nomalLoadingDiallog.dismiss();
    }

    @Override // com.yd.android_brand_mvp.view.SettingView
    public void NewestVersionSuccess(final getNewestVersionRsp getnewestversionrsp) {
        Log.e("TAG", "NewestVersionSuccess: " + JSON.toJSONString(getnewestversionrsp));
        if (!getActivity().isDestroyed()) {
            this.nomalLoadingDiallog.dismiss();
        }
        if (getnewestversionrsp.code == BaseConstant.REQUEST_SUCCES2) {
            if (AppUtils.getAppVersionName().compareTo(getnewestversionrsp.data.versionCode) < 0) {
                this.versioncode = getnewestversionrsp.data.versionCode;
                String str = getnewestversionrsp.data.isCompulsory;
                byte b = -1;
                int iHashCode = str.hashCode();
                if (iHashCode != 48) {
                    if (iHashCode == 49 && str.equals("1")) {
                        b = 1;
                    }
                } else if (str.equals("0")) {
                    b = 0;
                }
                if (b != 0) {
                    if (b != 1) {
                        return;
                    }
                    downApk(getnewestversionrsp.data.filePath);
                    return;
                }
                UpdataInfoDiallog updataInfoDiallog = new UpdataInfoDiallog(this.mActivity, getnewestversionrsp.data.versionCode + "");
                updataInfoDiallog.setonclickListener(new UpdataInfoDiallog.OnclickListener() { // from class: com.yd.android_brand_mvp.landscape.SettingFragment.8
                    @Override // com.yd.android_brand_mvp.dialog.UpdataInfoDiallog.OnclickListener
                    public void onclick() {
                        SettingFragment.this.downApk(getnewestversionrsp.data.filePath);
                    }
                });
                updataInfoDiallog.show();
                return;
            }
            new UpdataBestDiallog(this.mActivity, "").show();
            return;
        }
        ToastUtils.showShort(getnewestversionrsp.message);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void downApk(String str) {
        UpdataIngDiallog updataIngDiallog = new UpdataIngDiallog(this.mActivity, str);
        this.dialog = updataIngDiallog;
        updataIngDiallog.setOnCancelListener(new DialogInterface.OnCancelListener() { // from class: com.yd.android_brand_mvp.landscape.SettingFragment.9
            @Override // android.content.DialogInterface.OnCancelListener
            public void onCancel(DialogInterface dialogInterface) {
                dialogInterface.cancel();
            }
        });
        this.dialog.setCanceledOnTouchOutside(false);
        this.dialog.setCancelable(false);
        this.dialog.show();
        this.dialog.setDownloadLister(new UpdataIngDiallog.DownLoadLister() { // from class: com.yd.android_brand_mvp.landscape.SettingFragment.10
            @Override // com.yd.android_brand_mvp.dialog.UpdataIngDiallog.DownLoadLister
            public void loadfinish() {
                ((SettingPresenter) SettingFragment.this.mvpPresenter).insetVersionUpdatedSchool(SpData.getSchoolId(), SettingFragment.this.versioncode);
            }
        });
        EventBus.getDefault().post(new UpdateDialogIsTimeEventBean(1));
    }

    @Override // com.yd.android_brand_mvp.view.SettingView
    public void NewestVersionFail(String str) {
        ToastUtils.showShort(str);
        if (getActivity().isDestroyed()) {
            return;
        }
        this.nomalLoadingDiallog.dismiss();
    }

    @Override // com.yd.android_brand_mvp.view.SettingView
    public void insetVersionUpdatedSchoolRsp(insetVersionUpdatedSchoolRsp insetversionupdatedschoolrsp) {
        if (insetversionupdatedschoolrsp.code.intValue() == BaseConstant.REQUEST_SUCCES2) {
            ToastUtils.showShort("已保存版本信息");
        }
    }

    @Override // com.yd.android_brand_mvp.view.SettingView
    public void insetVersionUpdatedSchoolFail(String str) {
        if (!getActivity().isDestroyed()) {
            this.nomalLoadingDiallog.dismiss();
        }
        ToastUtils.showShort(str);
    }

    @Override // com.yd.android_brand_mvp.view.SettingView
    public void queryClassificListRsp(queryClassificListRsp queryclassificlistrsp) {
        Log.e("TAG", "queryClassificListRsp: " + JSON.toJSONString(queryclassificlistrsp));
        if (queryclassificlistrsp.code.intValue() == BaseConstant.REQUEST_SUCCES2) {
            String strValueOf = null;
            for (queryClassificListRsp.DataDTO.DataDTO2 dataDTO2 : queryclassificlistrsp.data.data) {
                if (dataDTO2.versionName.equals(BaseConstant.VERSIONNAME)) {
                    strValueOf = String.valueOf(dataDTO2.id);
                }
            }
            if (!TextUtils.isEmpty(strValueOf) && SpData.NewUser().data != null) {
                ((SettingPresenter) this.mvpPresenter).getNewestVersion(SpData.getSchoolId());
                return;
            }
            ToastUtils.showShort("沒有划分版本类型");
            if (getActivity().isDestroyed()) {
                return;
            }
            this.nomalLoadingDiallog.dismiss();
            return;
        }
        ToastUtils.showShort(queryclassificlistrsp.msg);
        if (getActivity().isDestroyed()) {
            return;
        }
        this.nomalLoadingDiallog.dismiss();
    }

    @Override // com.yd.android_brand_mvp.view.SettingView
    public void queryClassificListFail(String str) {
        if (getActivity().isDestroyed()) {
            return;
        }
        this.nomalLoadingDiallog.dismiss();
    }
}
