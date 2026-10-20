package com.yd.android_brand_mvp;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.os.Message;
import android.provider.Settings;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;
import androidx.work.PeriodicWorkRequest;
import androidx.work.WorkRequest;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import com.blankj.utilcode.util.ActivityUtils;
import com.blankj.utilcode.util.AppUtils;
import com.blankj.utilcode.util.LogUtils;
import com.blankj.utilcode.util.NetworkUtils;
import com.blankj.utilcode.util.SPUtils;
import com.blankj.utilcode.util.ScreenUtils;
import com.blankj.utilcode.util.StringUtils;
import com.blankj.utilcode.util.ToastUtils;
import com.blankj.utilcode.util.Utils;
import com.blankj.utilcode.util.ZipUtils;
import com.example.mtreader.MT3NativeFunc;
import com.google.android.exoplayer2.C;
import com.google.android.exoplayer2.ExoPlayer;
import com.google.gson.reflect.TypeToken;
import com.orhanobut.hawk.Hawk;
import com.paradoxie.autoscrolltextview.VerticalTextview;
import com.shuyu.gsyvideoplayer.GSYVideoADManager;
import com.shuyu.gsyvideoplayer.GSYVideoManager;
import com.shuyu.gsyvideoplayer.model.GSYModel;
import com.shuyu.gsyvideoplayer.player.IPlayerInitSuccessListener;
import com.tencent.mmkv.MMKV;
import com.yaoxiaowen.download.DownloadConstant;
import com.yaoxiaowen.download.DownloadHelper;
import com.yaoxiaowen.download.FileInfo;
import com.yd.android_brand_mvp.activity.FaceSyncActivity;
import com.yd.android_brand_mvp.activity.SchoolInfoActivity;
import com.yd.android_brand_mvp.activity.home.viewmodel.FaceSyncStatusViewModel;
import com.yd.android_brand_mvp.activity.home.viewmodel.HomeViewModel;
import com.yd.android_brand_mvp.adapter.RecyleviewIndexAdapter;
import com.yd.android_brand_mvp.adapter.ViewPagerFragmentAdapter;
import com.yd.android_brand_mvp.adapter.attence.PostAttenceBean;
import com.yd.android_brand_mvp.adapter.attence.RuleUtils;
import com.yd.android_brand_mvp.base.BaseConstant;
import com.yd.android_brand_mvp.base.BaseHawk;
import com.yd.android_brand_mvp.base.BaseMvpActivity;
import com.yd.android_brand_mvp.base.MMKVConstant;
import com.yd.android_brand_mvp.base.MinaConstants;
import com.yd.android_brand_mvp.brand.BrandConfig;
import com.yd.android_brand_mvp.brand.BrandModelEnum;
import com.yd.android_brand_mvp.brand.BroCast;
import com.yd.android_brand_mvp.dialog.BrandConfigDialog;
import com.yd.android_brand_mvp.dialog.DeviceBootTipDialog;
import com.yd.android_brand_mvp.dialog.NomalLoadingDiallog;
import com.yd.android_brand_mvp.dialog.TimeDialog;
import com.yd.android_brand_mvp.dialog.UpdataInfoDiallog;
import com.yd.android_brand_mvp.dialog.WeatherDiallog;
import com.yd.android_brand_mvp.landscape.SiteFullScreenFragment;
import com.yd.android_brand_mvp.landscape.blackboard.BlackBoardModel;
import com.yd.android_brand_mvp.landscape.blackboard.BlackBoardViewModel;
import com.yd.android_brand_mvp.model.AdbShellBean;
import com.yd.android_brand_mvp.model.AllstudentRsp;
import com.yd.android_brand_mvp.model.AttenceUser;
import com.yd.android_brand_mvp.model.AttencelistRsp2;
import com.yd.android_brand_mvp.model.BrandConfigBean;
import com.yd.android_brand_mvp.model.DominateDetailLevelBean;
import com.yd.android_brand_mvp.model.EventBean;
import com.yd.android_brand_mvp.model.FaceActiveConfigBean;
import com.yd.android_brand_mvp.model.GeneralBean2;
import com.yd.android_brand_mvp.model.KBRsp2;
import com.yd.android_brand_mvp.model.LayoutListRsp;
import com.yd.android_brand_mvp.model.MessageCaptionBean;
import com.yd.android_brand_mvp.model.MessageItemBean;
import com.yd.android_brand_mvp.model.NewBrandLoginRsp;
import com.yd.android_brand_mvp.model.NewLoginRsp;
import com.yd.android_brand_mvp.model.NewRemindRsp;
import com.yd.android_brand_mvp.model.NewWeatherBean;
import com.yd.android_brand_mvp.model.NewWeatherListBean;
import com.yd.android_brand_mvp.model.SchoolStytleRsp;
import com.yd.android_brand_mvp.model.SiteAttendanceBean;
import com.yd.android_brand_mvp.model.StudentCenterRsp;
import com.yd.android_brand_mvp.model.StudentMsgBean;
import com.yd.android_brand_mvp.model.UnreadMsgNum;
import com.yd.android_brand_mvp.model.UploadFileBean;
import com.yd.android_brand_mvp.model.WebSocketDominateParamBean;
import com.yd.android_brand_mvp.model.getNewestVersionRsp;
import com.yd.android_brand_mvp.model.home.DominateScreenBean;
import com.yd.android_brand_mvp.model.home.DominateStartBean;
import com.yd.android_brand_mvp.model.selectTeacherByClassesIdRsp;
import com.yd.android_brand_mvp.model.switchlistRsp;
import com.yd.android_brand_mvp.mqtt.MQTTClient;
import com.yd.android_brand_mvp.mqtt.MQTTConstant;
import com.yd.android_brand_mvp.mqtt.MQTTEventBean;
import com.yd.android_brand_mvp.network.base.BaseResponse;
import com.yd.android_brand_mvp.observer.MinaEventManager;
import com.yd.android_brand_mvp.observer.MinaListener;
import com.yd.android_brand_mvp.observer.NetWorkManager;
import com.yd.android_brand_mvp.observer.ObserverManager;
import com.yd.android_brand_mvp.observer.observer2.TimeManager;
import com.yd.android_brand_mvp.presenter.HomePresenter;
import com.yd.android_brand_mvp.socket.ClientCallback;
import com.yd.android_brand_mvp.socket.SocketClient;
import com.yd.android_brand_mvp.utils.AESEncryptUtils;
import com.yd.android_brand_mvp.utils.ActivityTool;
import com.yd.android_brand_mvp.utils.AttendanceUtils;
import com.yd.android_brand_mvp.utils.Base64Utils;
import com.yd.android_brand_mvp.utils.ConversionUtil;
import com.yd.android_brand_mvp.utils.DominateScreenUtil;
import com.yd.android_brand_mvp.utils.FileUtils;
import com.yd.android_brand_mvp.utils.GlideUtil;
import com.yd.android_brand_mvp.utils.LayoutUtils;
import com.yd.android_brand_mvp.utils.MMKVUtil;
import com.yd.android_brand_mvp.utils.MMKVUtils;
import com.yd.android_brand_mvp.utils.NumberUtils;
import com.yd.android_brand_mvp.utils.OpenAndCloseTimeUtils;
import com.yd.android_brand_mvp.utils.RemindUtils;
import com.yd.android_brand_mvp.utils.SDcarfile;
import com.yd.android_brand_mvp.utils.SpData;
import com.yd.android_brand_mvp.utils.SpaceItemDecoration;
import com.yd.android_brand_mvp.utils.TimeUtil;
import com.yd.android_brand_mvp.utils.ToastUtil;
import com.yd.android_brand_mvp.utils.Tool;
import com.yd.android_brand_mvp.utils.VideoUtils;
import com.yd.android_brand_mvp.utils.WeatherUtils;
import com.yd.android_brand_mvp.utils.view.net.GsonUtils;
import com.yd.android_brand_mvp.utils.view.net.NetworkChangeReceiver;
import com.yd.android_brand_mvp.verfity.StudentCheackActivity;
import com.yd.android_brand_mvp.verfity.TeacherCheackActivity;
import com.yd.android_brand_mvp.view.HomeView;
import com.yd.android_brand_mvp.view.ScrollTextView;
import com.yd.android_brand_mvp.websocket.WebSocketEventBean;
import com.yd.android_brand_mvp.widget.YDViewPager;
import com.ys.rkapi.MyManager;
import com.yyide.facepass.FaceManager;
import com.yyide.facepass.OnAuthCallback;
import com.yyide.facepass.SettingVar;
import com.yyide.facepass.bean.FaceSyncBean;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.lang.ref.WeakReference;
import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;
import master.flame.danmaku.danmaku.parser.IDataSource;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import org.greenrobot.eventbus.EventBus;
import tv.danmaku.ijk.media.player.IMediaPlayer;

/* JADX INFO: loaded from: classes4.dex */
public class MainActivity extends BaseMvpActivity<HomePresenter> implements HomeView, MinaListener, NetworkChangeReceiver.NetStateChangeObserver, MQTTClient.OnMessageCallBack {
    private static final long CLICK_INTERVAL = 500;
    private static final String FILE_SEP = System.getProperty("file.separator");
    private static final String FIRST_ACTION = "download_helper_first_action";
    private View TopCouseview;
    private int VoiceNum;

    @BindView(R.id.bg)
    ImageView bg;
    private BlackBoardViewModel blackBoardViewModel;

    @BindView(R.id.calendar_layout)
    LinearLayout calendarLayout;
    private DominateStartBean currentDominateBean;
    private File dir;

    @BindView(R.id.download_msg)
    TextView download_msg;
    private File firstFile;
    private String imSign;

    @BindView(R.id.img_set)
    ImageView imgSet;
    RecyleviewIndexAdapter indexAdapter;

    @BindView(R.id.layout_setting)
    LinearLayout layout_setting;
    private MediaPlayer localMediaPlayer;

    @BindView(R.id.lock)
    TextView lock;

    @BindView(R.id.logo)
    ImageView logo;
    private DownloadHelper mDownloadHelper;
    private LayoutInflater mlayoutinflater;
    private long msgTimes;
    private String musicUrl;
    private View mwindowview;
    private WindowManager mwm;
    private MyHandler netWorkHandler;
    private NomalLoadingDiallog nomalLoadingDiallog;

    @BindView(R.id.officename)
    TextView officename;
    private MediaPlayer onlineMediaPlayer;

    @BindView(R.id.pager)
    YDViewPager pager;

    @BindView(R.id.recyleview)
    RecyclerView recyleview;
    private MessageCaptionBean rollTextBean;
    private FaceSyncStatusViewModel syncStatusViewModel;

    @BindView(R.id.text)
    VerticalTextview textView;
    private View tipCountdownView;
    private View tipMarqueeView;

    @BindView(R.id.top_hint)
    FrameLayout top_hint;
    private FrameLayout toplayout;
    private TextView tvTipCountdown;

    @BindView(R.id.tv_text)
    TextView tv_text;
    private HomeViewModel viewModel;

    @BindView(R.id.vsname)
    TextView vsname;

    @BindView(R.id.wd)
    TextView wd;

    @BindView(R.id.weathericon)
    ImageView weathericon;

    @BindView(R.id.weatherlayout)
    LinearLayout weatherlayout;

    @BindView(R.id.weathertext)
    TextView weathertext;

    @BindView(R.id.wifi)
    ImageView wifi;

    @BindView(R.id.xx)
    ImageView xx;
    private final String TAG = MainActivity.class.getSimpleName();
    private int updateNum = 0;
    private int updateNumMax = 5;
    private boolean isDonwLoad = false;
    private int TimeContrNum = 0;
    private int TimeContrMax = 5;
    private final List<AttenceUser.DataDTO> listAttenceUser = new ArrayList();
    private boolean attendanceTable = false;
    private boolean attendanceRule = false;
    private boolean schoolInfo = false;
    private boolean screenTypeList = false;
    private boolean screenDataList = false;
    public boolean Voicing = false;
    public boolean BGMing = false;
    private boolean isShow = true;
    private int playCount = 0;
    private long sigTime = System.currentTimeMillis();
    private int time = 60000;
    private int stuas = 0;
    private final OkHttpClient mOkHttpClient = new OkHttpClient();
    private final List<StudentMsgBean.Data0> list = new ArrayList();
    private final Runnable btnRunnable = new Runnable() { // from class: com.yd.android_brand_mvp.MainActivity.1
        @Override // java.lang.Runnable
        public void run() {
            MainActivity.this.imgSet.setEnabled(true);
            MainActivity.this.xx.setEnabled(true);
            MainActivity.this.wifi.setEnabled(true);
        }
    };
    private Handler handler = new Handler();
    private final Handler setHandler = new Handler();
    private final Runnable runnable = new Runnable() { // from class: com.yd.android_brand_mvp.MainActivity.2
        @Override // java.lang.Runnable
        public void run() {
            NetWorkManager.getInstance().notifyObserver(NetworkUtils.isConnected());
            MainActivity.this.postData();
            TimeManager.getInstance().notifyObserver(System.currentTimeMillis() / 1000);
            MainActivity.this.handler.postDelayed(this, WorkRequest.MIN_BACKOFF_MILLIS);
        }
    };
    private final Runnable imMessageRunnable = new Runnable() { // from class: com.yd.android_brand_mvp.MainActivity.3
        @Override // java.lang.Runnable
        public void run() {
            if (System.currentTimeMillis() - MainActivity.this.sigTime >= new Random().nextInt(300000) + 120000 && Tool.isNetworkAvailable(MainActivity.this)) {
                MainActivity.this.sigTime = System.currentTimeMillis();
                Log.i(MainActivity.this.TAG, "学生空间未读消息刷新");
                MainActivity.this.handler.postDelayed(MainActivity.this.messageGetRunnable, WorkRequest.MIN_BACKOFF_MILLIS);
            }
            MainActivity.this.handler.postDelayed(this, 20000L);
        }
    };
    private final Runnable updateRunnable = new Runnable() { // from class: com.yd.android_brand_mvp.MainActivity.4
        @Override // java.lang.Runnable
        public void run() {
            if (MainActivity.this.updateNum <= MainActivity.this.updateNumMax) {
                MainActivity.access$508(MainActivity.this);
            }
            if (MainActivity.this.TimeContrNum <= MainActivity.this.TimeContrMax) {
                ((HomePresenter) MainActivity.this.mvpPresenter).switchlist();
                MainActivity.access$708(MainActivity.this);
            }
            MainActivity.this.handler.postDelayed(this, 300000L);
        }
    };
    private int index = 0;
    private final Runnable messageGetRunnable = new Runnable() { // from class: com.yd.android_brand_mvp.MainActivity.5
        @Override // java.lang.Runnable
        public void run() {
            if (System.currentTimeMillis() - MainActivity.this.msgTimes > WorkRequest.MIN_BACKOFF_MILLIS) {
                Log.i(MainActivity.this.TAG, "messageGetRunnable setStudentMsg");
                MainActivity.this.index = 0;
                MainActivity.this.list.clear();
                MainActivity.this.setStudentMsg();
            }
        }
    };
    private final Runnable initFaceSdkRunnable = new Runnable() { // from class: com.yd.android_brand_mvp.-$$Lambda$MainActivity$OZrUnS6upr7v6tEhBxDTb38uBeQ
        @Override // java.lang.Runnable
        public final void run() {
            this.f$0.lambda$new$0$MainActivity();
        }
    };
    private final Runnable remindVoice = new Runnable() { // from class: com.yd.android_brand_mvp.MainActivity.6
        @Override // java.lang.Runnable
        public void run() {
            NewRemindRsp.DataDTO remindData = RemindUtils.INSTANCE.getRemindData();
            Log.i(MainActivity.this.TAG, "remindVoice：" + GsonUtils.toJson(remindData));
            Log.i(MainActivity.this.TAG, "提醒播放状态 Voicing：" + MainActivity.this.Voicing + " BGMing：" + MainActivity.this.BGMing);
            if (remindData != null) {
                MainActivity.this.VoiceNum = remindData.number;
                MainActivity.this.musicUrl = remindData.musicUrl;
                if (!MainActivity.this.Voicing && !MainActivity.this.BGMing) {
                    if (remindData.remindMode.equals("1") || remindData.remindMode.equals("2")) {
                        MainActivity.this.setHomeTopViewVisibility(0, remindData.type);
                    } else {
                        MainActivity.this.setHomeTopViewVisibility(8, remindData.type);
                    }
                    if (remindData.remindMode.equals("1") || remindData.remindMode.equals("3")) {
                        if (MainActivity.this.playCount < MainActivity.this.VoiceNum) {
                            MainActivity.this.setupLocalMediaPlayer(remindData.type);
                        } else {
                            MainActivity.this.setupOnlineMediaPlayer(remindData.musicUrl);
                        }
                    }
                }
            } else {
                MainActivity.this.setHomeTopViewVisibility(8, "2");
                MainActivity.this.stopAllVoice();
            }
            MainActivity.this.handler.postDelayed(this, 5000L);
        }
    };
    private final String firstName = "6.0YideBp.apk";
    private final Handler timeOutHandler = new Handler();
    private final Runnable timeOutRunnable = new Runnable() { // from class: com.yd.android_brand_mvp.-$$Lambda$MainActivity$77N3CoNa9QHenuAAPPoC_rEuR44
        @Override // java.lang.Runnable
        public final void run() {
            this.f$0.lambda$new$1$MainActivity();
        }
    };
    private final Handler timeOutHandler1 = new Handler();
    private final Runnable timeOutRunnable1 = new Runnable() { // from class: com.yd.android_brand_mvp.MainActivity.7
        @Override // java.lang.Runnable
        public void run() {
            MainActivity.this.timeOutHandler1.postDelayed(MainActivity.this.timeOutRunnable1, WorkRequest.MIN_BACKOFF_MILLIS);
            MainActivity.this.messageDominate();
        }
    };
    private final BroadcastReceiver receiver = new BroadcastReceiver() { // from class: com.yd.android_brand_mvp.MainActivity.8
        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if (intent == null || !MainActivity.FIRST_ACTION.equals(intent.getAction())) {
                return;
            }
            FileInfo fileInfo = (FileInfo) intent.getSerializableExtra(DownloadConstant.EXTRA_INTENT_DOWNLOAD);
            MainActivity mainActivity = MainActivity.this;
            mainActivity.updateTextview(mainActivity.download_msg, fileInfo);
        }
    };
    private String mfirstFile = "";
    private final Runnable downLoadRunnable = new Runnable() { // from class: com.yd.android_brand_mvp.MainActivity.9
        @Override // java.lang.Runnable
        public void run() {
            MainActivity.this.handler.postDelayed(this, C.DEFAULT_SEEK_FORWARD_INCREMENT_MS);
        }
    };
    private String date = "";
    private final Runnable attendanceRunnable = new Runnable() { // from class: com.yd.android_brand_mvp.MainActivity.10
        @Override // java.lang.Runnable
        public void run() {
            if (BaseApplication.isNetworkAvailable(MainActivity.this.mActivity)) {
                if ((TimeUtil.isAfterSpecificTimeOfToday(3, 10) && !MainActivity.this.date.equals(TimeUtil.getCurrentTime())) || !MainActivity.this.attendanceRule) {
                    LogUtils.i("通知更新考勤规则");
                    MainActivity.this.date = TimeUtil.getCurrentTime();
                    ((HomePresenter) MainActivity.this.mvpPresenter).Attencelist();
                    ((HomePresenter) MainActivity.this.mvpPresenter).allStudents(SpData.getClassesId());
                }
                if (RuleUtils.getInstance().isCurrentTimeAttendance()) {
                    LogUtils.i("通知更新考勤数据");
                    MinaEventManager.getInstance().notifyObserver(MinaConstants.ATTENCE_MODULE);
                }
                if (!MainActivity.this.attendanceTable && !TextUtils.isEmpty(SpData.getClassesId())) {
                    LogUtils.i("通知更新考勤课表");
                    ((HomePresenter) MainActivity.this.mvpPresenter).getCDKB(SpData.getClassesId());
                }
                if (!MainActivity.this.schoolInfo) {
                    ((HomePresenter) MainActivity.this.mvpPresenter).SchoolStyle();
                }
                if (!MainActivity.this.screenTypeList) {
                    ((HomePresenter) MainActivity.this.mvpPresenter).requestDominateLevel();
                }
                if (!MainActivity.this.screenDataList) {
                    MainActivity.this.viewModel.getCustomDominateData();
                }
            }
            MainActivity.this.handler.postDelayed(this, 30000L);
        }
    };
    private final List<DominateScreenBean> dominateScreenList = new ArrayList();
    private boolean isFirstStatTimer = true;
    private final BroadcastReceiver nfcReceiver = new BroadcastReceiver() { // from class: com.yd.android_brand_mvp.MainActivity.11
        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if (intent != null) {
                int intExtra = intent.getIntExtra("cardid", 0);
                LogUtils.i("nfc = " + intExtra);
                ObserverManager.getInstance().notifyObserver(intExtra + "");
            }
        }
    };
    private UploadAPPLogHandler mUploadAPPHandler = null;
    boolean show = true;
    Runnable showRunnable = new Runnable() { // from class: com.yd.android_brand_mvp.MainActivity.14
        @Override // java.lang.Runnable
        public void run() {
            if (MainActivity.this.tipMarqueeView != null) {
                MainActivity.this.tipMarqueeView.setVisibility(8);
                if (MainActivity.this.rollTextBean != null) {
                    MainActivity.this.rollTextBean.setPlaySuccess(true);
                    MMKV.defaultMMKV().putString(MMKVConstant.HOME_MARQUEE_TEXT, GsonUtils.toJson(MainActivity.this.rollTextBean));
                }
            }
        }
    };
    private final Timer rebootTimer = new Timer();
    TimerTask timerTask = new TimerTask() { // from class: com.yd.android_brand_mvp.MainActivity.15
        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            int countdownBootTime = OpenAndCloseTimeUtils.getInstance().getCountdownBootTime();
            if (countdownBootTime > 120 || countdownBootTime <= 0 || MainActivity.this.tvTipCountdown == null || MainActivity.this.mActivity.isFinishing()) {
                if (countdownBootTime > 0 || !MainActivity.this.tipCountdownView.isShown()) {
                    return;
                }
                Message message = new Message();
                message.what = 103;
                MainActivity.this.netWorkHandler.sendMessage(message);
                return;
            }
            Message message2 = new Message();
            message2.what = 102;
            message2.obj = Integer.valueOf(countdownBootTime);
            MainActivity.this.netWorkHandler.sendMessage(message2);
        }
    };
    private final OnAuthCallback mOnAuthCallback = new AnonymousClass16();
    Runnable MTrunnable = new Runnable() { // from class: com.yd.android_brand_mvp.MainActivity.17
        @Override // java.lang.Runnable
        public void run() {
            String strReadMtskCard = mtread.getInstance().ReadMtskCard();
            Log.i(MainActivity.this.TAG, "UID: " + strReadMtskCard);
            if (!TextUtils.isEmpty(strReadMtskCard)) {
                try {
                    MT3NativeFunc.devbeep(1, 2, 3);
                    BaseApplication.getInstance().sendCard(new BigInteger(strReadMtskCard.substring(0, 8), 16).toString());
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            MainActivity.this.handler.postDelayed(this, 1000L);
        }
    };
    private boolean isSite = false;
    private boolean isRebootTime = true;
    private long lastClickTime = 0;

    private int getWifiDrawableByLevel(int i) {
        if (i == 2) {
            return R.drawable.wifi2;
        }
        if (i != 3) {
            return (i == 4 || i == 5) ? R.drawable.wifi4 : R.drawable.wifi1;
        }
        return R.drawable.wifi3;
    }

    @Override // com.yd.android_brand_mvp.view.HomeView
    public void StudentCenterRsp(StudentCenterRsp studentCenterRsp) {
    }

    @Override // com.yd.android_brand_mvp.view.HomeView
    public void allStudentsFail(String str) {
    }

    @Override // com.yd.android_brand_mvp.view.HomeView
    public void getBrandLoginFails(String str) {
    }

    @Override // com.yd.android_brand_mvp.view.HomeView
    public void getDataAttenceUserFail(String str) {
    }

    @Override // com.yd.android_brand_mvp.view.HomeView
    public void getMessageDominateFail(String str) {
    }

    @Override // com.yd.android_brand_mvp.view.HomeView
    public void getNewTokenFails(String str) {
    }

    @Override // com.yd.android_brand_mvp.view.HomeView
    public void getSystemSigFail(String str) {
    }

    @Override // com.yd.android_brand_mvp.base.BaseActivity, com.yd.android_brand_mvp.utils.view.net.NetworkChangeReceiver.NetStateChangeObserver
    public void onDisconnect() {
    }

    @Override // com.yd.android_brand_mvp.view.HomeView
    public void selectTeacherByClassesIdRspFail(String str) {
    }

    @Override // com.yd.android_brand_mvp.base.BaseView
    public void showError() {
    }

    static /* synthetic */ int access$1108(MainActivity mainActivity) {
        int i = mainActivity.index;
        mainActivity.index = i + 1;
        return i;
    }

    static /* synthetic */ int access$1508(MainActivity mainActivity) {
        int i = mainActivity.playCount;
        mainActivity.playCount = i + 1;
        return i;
    }

    static /* synthetic */ int access$508(MainActivity mainActivity) {
        int i = mainActivity.updateNum;
        mainActivity.updateNum = i + 1;
        return i;
    }

    static /* synthetic */ int access$708(MainActivity mainActivity) {
        int i = mainActivity.TimeContrNum;
        mainActivity.TimeContrNum = i + 1;
        return i;
    }

    public /* synthetic */ void lambda$new$0$MainActivity() {
        Log.i(this.TAG, "initFaceSdkRunnable");
        activeFace();
    }

    public /* synthetic */ void lambda$new$1$MainActivity() {
        BaseConstant.DOMINATE_CLOSE = false;
        this.timeOutHandler.removeCallbacksAndMessages(null);
        messageDominate();
        dominate();
    }

    @Override // com.yd.android_brand_mvp.base.BaseActivity, android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        dominateStart();
        return super.dispatchTouchEvent(motionEvent);
    }

    private void dominateStart() {
        if (BaseConstant.DOMINATE_CLOSE) {
            this.currentDominateBean = null;
            this.timeOutHandler1.removeCallbacksAndMessages(null);
            this.timeOutHandler.removeCallbacksAndMessages(null);
            this.timeOutHandler.postDelayed(this.timeOutRunnable, this.time);
            return;
        }
        dominate();
    }

    private void dominate() {
        int i;
        this.timeOutHandler1.removeCallbacksAndMessages(null);
        if (this.isFirstStatTimer) {
            this.isFirstStatTimer = false;
            i = 30000;
        } else {
            i = 10000;
        }
        this.timeOutHandler1.postDelayed(this.timeOutRunnable1, i);
    }

    @Override // com.yd.android_brand_mvp.base.BaseMvpActivity, com.yd.android_brand_mvp.base.BaseActivity, skin.support.app.SkinCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.viewModel = (HomeViewModel) new ViewModelProvider(this).get(HomeViewModel.class);
        this.blackBoardViewModel = (BlackBoardViewModel) new ViewModelProvider(this).get(BlackBoardViewModel.class);
        this.syncStatusViewModel = (FaceSyncStatusViewModel) new ViewModelProvider(this).get(FaceSyncStatusViewModel.class);
        this.blackBoardViewModel.clearTimeoutCache();
        if (ScreenUtils.isLandscape()) {
            setContentView(R.layout.activity_main);
            this.stuas = 0;
        } else {
            setContentView(R.layout.activity_main_p);
            this.stuas = 1;
        }
        this.date = TimeUtil.getCurrentTime();
        LogUtils.i("Android app open onCreate");
        ButterKnife.bind(this);
        GSYVideoManager.instance().setPlayerInitSuccessListener(new IPlayerInitSuccessListener() { // from class: com.yd.android_brand_mvp.-$$Lambda$MainActivity$EgluKuWAWvLImoSKeptJc9xyeeE
            @Override // com.shuyu.gsyvideoplayer.player.IPlayerInitSuccessListener
            public final void onPlayerInitSuccess(IMediaPlayer iMediaPlayer, GSYModel gSYModel) {
                this.f$0.lambda$onCreate$2$MainActivity(iMediaPlayer, gSYModel);
            }
        });
        NetworkChangeReceiver.registerReceiver(this);
        NetworkChangeReceiver.registerObserver(this);
        GSYVideoADManager.instance().setNeedMute(true);
        this.handler.postDelayed(new Runnable() { // from class: com.yd.android_brand_mvp.-$$Lambda$MainActivity$LXmz51NyeYxw-PmnryVAVAYycjA
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$onCreate$3$MainActivity();
            }
        }, WorkRequest.MIN_BACKOFF_MILLIS);
        setInfo();
        this.netWorkHandler = new MyHandler(this);
        this.mUploadAPPHandler = new UploadAPPLogHandler(this);
        setAutoClose(false);
        if (Build.VERSION.SDK_INT >= 23) {
            askForPermission();
        } else {
            initWindView();
            SetWindView();
            SetTopWindView();
            setTopCountdownTimeReboot();
            initTimer();
        }
        ((HomePresenter) this.mvpPresenter).newBrandLogin(SPUtils.getInstance().getString(BaseConstant.LOGINNAME, ""), BaseApplication.getInstance().getMac(), String.valueOf(this.stuas));
        ((HomePresenter) this.mvpPresenter).getSystemSig();
        ((HomePresenter) this.mvpPresenter).layoutList(SpData.getBrandId());
        ((HomePresenter) this.mvpPresenter).switchlist();
        ((HomePresenter) this.mvpPresenter).SchoolStyle();
        ((HomePresenter) this.mvpPresenter).getToken();
        Log.i(this.TAG, "token == " + SpData.getToken());
        Log.i(this.TAG, "brand_info == " + GsonUtils.toJson(SpData.NewUser()));
        this.vsname.setText("版本v" + AppUtils.getAppVersionName());
        this.indexAdapter = new RecyleviewIndexAdapter();
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(0);
        this.recyleview.setLayoutManager(linearLayoutManager);
        this.recyleview.addItemDecoration(new SpaceItemDecoration(8));
        this.recyleview.setAdapter(this.indexAdapter);
        this.officename.setOnClickListener(new View.OnClickListener() { // from class: com.yd.android_brand_mvp.-$$Lambda$MainActivity$huxrk1DaWgfOTNfuCCovgmYOthM
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$onCreate$4$MainActivity(view);
            }
        });
        this.imgSet.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.yd.android_brand_mvp.-$$Lambda$MainActivity$VRh_7OzELrA18uKE9anLNONw2Ss
            @Override // android.view.View.OnLongClickListener
            public final boolean onLongClick(View view) {
                return this.f$0.lambda$onCreate$5$MainActivity(view);
            }
        });
        initData();
        deleteAllFile();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(FIRST_ACTION);
        registerReceiver(this.receiver, intentFilter);
        MMKV.defaultMMKV().encode("token", SpData.getToken());
        SettingVar.INSTANCE.setMAX_FACE_ENABLED(!BrandConfig.INSTANCE.isFaceMore());
        SettingVar.INSTANCE.setLogcatLogger(true);
        setFaceRotation();
        if (SpData.NewUser().data.isMessage.booleanValue()) {
            this.textView.setVisibility(0);
            this.xx.setVisibility(0);
        } else {
            this.textView.setVisibility(8);
            this.xx.setVisibility(8);
        }
        this.textView.setText(20.0f, 0, -1);
        this.textView.setTextStillTime(C.DEFAULT_MAX_SEEK_TO_PREVIOUS_POSITION_MS);
        this.textView.setAnimTime(300L);
        MinaEventManager.getInstance().add(this);
        if (!BaseConstant.MNQ) {
            this.handler.postDelayed(this.initFaceSdkRunnable, C.DEFAULT_MAX_SEEK_TO_PREVIOUS_POSITION_MS);
        }
        this.handler.postDelayed(this.runnable, C.DEFAULT_MAX_SEEK_TO_PREVIOUS_POSITION_MS);
        this.handler.postDelayed(this.downLoadRunnable, 5000L);
        this.handler.post(this.imMessageRunnable);
        this.handler.postDelayed(this.attendanceRunnable, 30000L);
        this.handler.postDelayed(this.updateRunnable, 60000L);
        this.handler.postDelayed(this.remindVoice, C.DEFAULT_SEEK_FORWARD_INCREMENT_MS);
        new Handler().postDelayed(new Runnable() { // from class: com.yd.android_brand_mvp.-$$Lambda$MainActivity$gJxoVGlTAjJc-V6CI9SqsN2ivEo
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$onCreate$6$MainActivity();
            }
        }, PeriodicWorkRequest.MIN_PERIODIC_INTERVAL_MILLIS);
        new Handler().postDelayed(new Runnable() { // from class: com.yd.android_brand_mvp.-$$Lambda$MainActivity$Yskf3SouVkR7sVL71e-Bt-BA0HQ
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$onCreate$7$MainActivity();
            }
        }, 5000L);
        if (BaseConstant.BlueToothLock) {
            BroCast.start(this);
        }
        initDevice();
        SPUtils.getInstance().remove(SpData.historyNum);
        NomalLoadingDiallog nomalLoadingDiallog = new NomalLoadingDiallog(this.mActivity);
        this.nomalLoadingDiallog = nomalLoadingDiallog;
        nomalLoadingDiallog.show();
        if (!ScreenUtils.isLandscape()) {
            this.tv_text.setVisibility(8);
        }
        if (BaseConstant.MTSK) {
            if (mtread.getInstance().ConnectDevice(this) != -1) {
                this.handler.postDelayed(this.MTrunnable, 1000L);
                Log.i(this.TAG, "刷卡器连接成功 ");
            } else {
                Log.i(this.TAG, "刷卡器连接失败 ");
            }
        }
        initViewModel();
        if (BaseConstant.YS || BrandModelEnum.LG_RK3566 == BrandConfig.brandModelEnum) {
            MyManager myManager = MyManager.getInstance(BaseApplication.getInstance());
            myManager.bindAIDLService(BaseApplication.getInstance());
            myManager.setConnectClickInterface(new MyManager.ServiceConnectedInterface() { // from class: com.yd.android_brand_mvp.-$$Lambda$MainActivity$kpNOJRK7cYuGphx42qjgVMwvZbU
                @Override // com.ys.rkapi.MyManager.ServiceConnectedInterface
                public final void onConnect() {
                    this.f$0.lambda$onCreate$8$MainActivity();
                }
            });
        }
        IntentFilter intentFilter2 = new IntentFilter();
        intentFilter2.addAction("android.intent.action.cardid");
        registerReceiver(this.nfcReceiver, intentFilter2);
        ((HomePresenter) this.mvpPresenter).selectTeacherByClassesId(null, null);
    }

    public /* synthetic */ void lambda$onCreate$2$MainActivity(IMediaPlayer iMediaPlayer, GSYModel gSYModel) {
        if (this.isShow) {
            GSYVideoManager.instance().setNeedMute(true);
        }
    }

    public /* synthetic */ void lambda$onCreate$3$MainActivity() {
        MQTTClient.INSTANCE.connect(this, SpData.getSchoolId(), BaseApplication.getInstance().getMac());
        MQTTClient.INSTANCE.setOnMessageCallBack(this);
    }

    public /* synthetic */ void lambda$onCreate$4$MainActivity(View view) {
        goActivity(SchoolInfoActivity.class);
    }

    public /* synthetic */ boolean lambda$onCreate$5$MainActivity(View view) {
        startActivity(new Intent(this.mActivity, (Class<?>) FaceSyncActivity.class));
        return false;
    }

    public /* synthetic */ void lambda$onCreate$6$MainActivity() {
        switchlistRsp time = SpData.getTime();
        if (time != null && time.data != null) {
            if (time.data.switchList.size() > 0) {
                OpenAndCloseTimeUtils.getInstance().setTimePower(this, time);
                return;
            } else {
                ((HomePresenter) this.mvpPresenter).switchlist();
                return;
            }
        }
        ((HomePresenter) this.mvpPresenter).switchlist();
    }

    public /* synthetic */ void lambda$onCreate$7$MainActivity() {
        socketConnect();
        updateVersion();
        ((HomePresenter) this.mvpPresenter).getHomeCaptionsNoticeInfo();
    }

    public /* synthetic */ void lambda$onCreate$8$MainActivity() {
        Log.d(this.TAG, "onCreate: MyManager ");
        BroCast.hidebar(this);
    }

    private static String getDefaultDir() {
        String str;
        if ("mounted".equals(Environment.getExternalStorageState()) && Utils.getApp().getExternalCacheDir() != null) {
            str = Utils.getApp().getExternalCacheDir() + FILE_SEP + "log";
        } else {
            str = Utils.getApp().getCacheDir() + FILE_SEP + "log";
        }
        LogUtils.i("getDefaultDir:" + str);
        return str;
    }

    private void socketConnect() {
        String string = MMKVUtils.INSTANCE.getString(MMKVConstant.SOCKET_IP);
        LogUtils.d("socket_ip：" + string);
        if (TextUtils.isEmpty(string)) {
            return;
        }
        SocketClient.connectServer(string, Integer.valueOf(SocketClient.SOCKET_PORT), new AnonymousClass12());
    }

    /* JADX INFO: renamed from: com.yd.android_brand_mvp.MainActivity$12, reason: invalid class name */
    class AnonymousClass12 implements ClientCallback {
        @Override // com.yd.android_brand_mvp.socket.ClientCallback
        public void otherMsg(String str) {
        }

        AnonymousClass12() {
        }

        @Override // com.yd.android_brand_mvp.socket.ClientCallback
        public void receiveServerMsg(final String str) {
            MainActivity.this.runOnUiThread(new Runnable() { // from class: com.yd.android_brand_mvp.-$$Lambda$MainActivity$12$2cICR_mCSovdWWRslCZyvKX5Vvw
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$receiveServerMsg$0$MainActivity$12(str);
                }
            });
        }

        public /* synthetic */ void lambda$receiveServerMsg$0$MainActivity$12(String str) {
            String strReplace;
            String strReplace2;
            Log.d("TAG", "收到信息： $message");
            List listAsList = Arrays.asList(str.split("#"));
            if (listAsList.isEmpty()) {
                strReplace = "";
            } else {
                strReplace = ((String) listAsList.get(0)).replace(SocketClient.SUBJECT_START, "");
                Log.d("TAG", "课程： " + strReplace);
            }
            if (listAsList.size() > 1) {
                strReplace2 = ((String) listAsList.get(1)).replace(SocketClient.TIME_START, "");
                Log.d("TAG", "日期：" + strReplace2);
            } else {
                strReplace2 = "";
            }
            String strReplace3 = listAsList.size() > 2 ? ((String) listAsList.get(2)).replace(SocketClient.IMAGE_START, "") : "";
            String string = MMKVUtils.INSTANCE.getString(MMKVConstant.BLACK_BROAD);
            if (TextUtils.isEmpty(strReplace) || TextUtils.isEmpty(strReplace2) || TextUtils.isEmpty(strReplace3)) {
                return;
            }
            List list = (List) GsonUtils.fromJson(string, new TypeToken<List<BlackBoardModel>>() { // from class: com.yd.android_brand_mvp.MainActivity.12.1
            }.getType());
            BlackBoardModel blackBoardModel = new BlackBoardModel();
            blackBoardModel.setSubjectName(strReplace);
            blackBoardModel.setTime(strReplace2);
            Bitmap bitmapBase642Bitmap = Base64Utils.INSTANCE.base642Bitmap(strReplace3);
            if (bitmapBase642Bitmap != null) {
                blackBoardModel.setFilePath(FileUtils.saveBitmapFile(bitmapBase642Bitmap, strReplace + "_" + strReplace2));
            }
            list.add(blackBoardModel);
            MMKVUtils.INSTANCE.put(MMKVConstant.BLACK_BROAD, GsonUtils.toJson(list));
            EventBus.getDefault().post(new EventBean(10003, "", ""));
        }
    }

    private static void setFaceRotation() {
        if (ScreenUtils.isPortrait()) {
            if (BaseConstant.YS) {
                SettingVar.INSTANCE.setFaceRotation(270);
                SettingVar.INSTANCE.setCameraPreviewRotation(270);
            } else if (BaseConstant.LC) {
                SettingVar.INSTANCE.setFaceRotation(180);
            } else if (BrandConfig.brandModelEnum == BrandModelEnum.LG_RK3568) {
                SettingVar.INSTANCE.setFaceRotation(90);
                SettingVar.INSTANCE.setCameraPreviewRotation(90);
            } else {
                SettingVar.INSTANCE.setFaceRotation(270);
                SettingVar.INSTANCE.setCameraPreviewRotation(90);
            }
        } else if (BaseConstant.SX || BaseConstant.NEW_LG) {
            SettingVar.INSTANCE.setFaceRotation(180);
        }
        if (BrandConfig.INSTANCE.getFacePreviewRotation() >= 0) {
            SettingVar.INSTANCE.setFaceRotation(BrandConfig.INSTANCE.getFacePreviewRotation());
        }
        if (BrandConfig.INSTANCE.getCameraRotation() >= 0) {
            SettingVar.INSTANCE.setCameraPreviewRotation(BrandConfig.INSTANCE.getCameraRotation());
        }
    }

    private static class UploadAPPLogHandler extends Handler {
        private final WeakReference<MainActivity> mWeakReference;

        public UploadAPPLogHandler(MainActivity mainActivity) {
            this.mWeakReference = new WeakReference<>(mainActivity);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            File fileByPath = com.blankj.utilcode.util.FileUtils.getFileByPath(BaseConstant.logPathZip);
            Log.i("UploadHandler", "上传日志文件= " + fileByPath.getPath());
            ((HomePresenter) this.mWeakReference.get().mvpPresenter).uploadLog(fileByPath);
        }
    }

    /* JADX WARN: Type inference failed for: r2v3, types: [com.yd.android_brand_mvp.MainActivity$13] */
    private void uploadAppLog() {
        final File fileByPath = com.blankj.utilcode.util.FileUtils.getFileByPath(BaseConstant.logFilePath);
        Log.i(IDataSource.SCHEME_FILE_TAG, "文件是否存在 = " + fileByPath.exists());
        final File fileByPath2 = com.blankj.utilcode.util.FileUtils.getFileByPath(BaseConstant.logPathZip);
        new Thread() { // from class: com.yd.android_brand_mvp.MainActivity.13
            @Override // java.lang.Thread, java.lang.Runnable
            public void run() {
                super.run();
                try {
                    ZipUtils.zipFile(fileByPath, fileByPath2);
                    MainActivity.this.mUploadAPPHandler.sendMessage(new Message());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }.start();
        Log.d(this.TAG, "onCreate: 上传应用日志文件");
    }

    private void initViewModel() {
        parseDominateInfo();
        ((HomePresenter) this.mvpPresenter).requestDominateLevel();
        this.viewModel.getCustomDominateData();
        this.viewModel.getDominateCustomDataResult().observe(this, new Observer() { // from class: com.yd.android_brand_mvp.-$$Lambda$MainActivity$SLoe5Rd1RJ6Ieu2q0PNTQgYu-kk
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                this.f$0.lambda$initViewModel$9$MainActivity((Boolean) obj);
            }
        });
        this.viewModel.getReservationSignList().observe(this, new Observer() { // from class: com.yd.android_brand_mvp.-$$Lambda$MainActivity$NvklA4gQ9Yrnj_wG19kM-Rkxic4
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                this.f$0.lambda$initViewModel$10$MainActivity((List) obj);
            }
        });
        this.viewModel.getHomeDeviceConfig().observe(this, new Observer() { // from class: com.yd.android_brand_mvp.-$$Lambda$MainActivity$3BO1_ZbASQV1MZz4CT53BZ14nBk
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                this.f$0.lambda$initViewModel$11$MainActivity((BrandConfigBean) obj);
            }
        });
    }

    public /* synthetic */ void lambda$initViewModel$9$MainActivity(Boolean bool) {
        this.screenDataList = bool.booleanValue();
    }

    public /* synthetic */ void lambda$initViewModel$10$MainActivity(List list) {
        this.viewModel.uploadReservationData(list);
    }

    public /* synthetic */ void lambda$initViewModel$11$MainActivity(BrandConfigBean brandConfigBean) {
        BaseApplication.getInstance().initDevice();
        BroCast.hidebar(this);
        setSwitch();
        setFaceRotation();
        SettingVar.INSTANCE.setMAX_FACE_ENABLED(!BrandConfig.INSTANCE.isFaceMore());
    }

    private void initDevice() {
        if (BaseConstant.MY) {
            SettingVar.INSTANCE.setSettingAvailable(true);
            SettingVar.INSTANCE.setCameraPreviewRotation(0);
        }
    }

    public void askForPermission() {
        if (!Settings.canDrawOverlays(this)) {
            Toast.makeText(this, "当前无权限，请授权！", 0).show();
            startActivityForResult(new Intent("android.settings.action.MANAGE_OVERLAY_PERMISSION", Uri.parse("package:" + getPackageName())), 10);
            return;
        }
        initWindView();
        SetWindView();
        SetTopWindView();
        setTopCountdownTimeReboot();
        initTimer();
    }

    private void initWindView() {
        this.mwm = (WindowManager) getSystemService("window");
        this.mlayoutinflater = LayoutInflater.from(this);
    }

    void SetWindView() {
        this.mwindowview = this.mlayoutinflater.inflate(R.layout.layout_homebtn, (ViewGroup) null);
        WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams(-2, -2, 2002, 0, -2);
        if (Build.VERSION.SDK_INT >= 26) {
            layoutParams.type = 2038;
        } else {
            layoutParams.type = 2003;
        }
        layoutParams.flags = 524328;
        layoutParams.gravity = 80;
        this.mwindowview.setOnClickListener(new View.OnClickListener() { // from class: com.yd.android_brand_mvp.-$$Lambda$MainActivity$oROsIAItNa-eFBHiYdeH8Q9Cttk
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$SetWindView$12$MainActivity(view);
            }
        });
        this.mwm.addView(this.mwindowview, layoutParams);
    }

    public /* synthetic */ void lambda$SetWindView$12$MainActivity(View view) {
        LogUtils.i(new Object[]{"mwindowview"});
        ActivityUtils.finishToActivity((Class<? extends Activity>) MainActivity.class, false);
        if (this.pager.getCurrentItem() != 0) {
            this.pager.setCurrentItem(0);
        }
    }

    void SetTopWindView() {
        if (this.mActivity.isFinishing()) {
            return;
        }
        this.TopCouseview = this.mlayoutinflater.inflate(R.layout.layout_hometopview, (ViewGroup) null);
        WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams(-2, -2, 2002, 0, -2);
        if (Build.VERSION.SDK_INT >= 26) {
            layoutParams.type = 2038;
        } else {
            layoutParams.type = 2003;
        }
        layoutParams.flags = 524328;
        layoutParams.gravity = 1;
        layoutParams.gravity = 48;
        this.toplayout = (FrameLayout) this.TopCouseview.findViewById(R.id.toplayout);
        this.mwm.addView(this.TopCouseview, layoutParams);
        this.TopCouseview.setVisibility(8);
    }

    private void setTopCountdownTimeReboot() {
        if (this.mActivity.isFinishing()) {
            return;
        }
        this.tipCountdownView = this.mlayoutinflater.inflate(R.layout.layout_tip_countdown, (ViewGroup) null);
        WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams(-2, -2, 2002, 0, -2);
        if (Build.VERSION.SDK_INT >= 26) {
            layoutParams.type = 2038;
        } else {
            layoutParams.type = 2003;
        }
        layoutParams.flags = 524328;
        layoutParams.gravity = 1;
        layoutParams.gravity = 48;
        this.mwm.addView(this.tipCountdownView, layoutParams);
        this.tvTipCountdown = (TextView) this.tipCountdownView.findViewById(R.id.tvTipCountdown);
        this.tipCountdownView.setVisibility(8);
    }

    private void setTipMarqueeText(final MessageCaptionBean messageCaptionBean) {
        this.rollTextBean = messageCaptionBean;
        runOnUiThread(new Runnable() { // from class: com.yd.android_brand_mvp.-$$Lambda$MainActivity$pICM8_sOFVGxMvHwjtAChipsbHU
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$setTipMarqueeText$16$MainActivity(messageCaptionBean);
            }
        });
    }

    public /* synthetic */ void lambda$setTipMarqueeText$16$MainActivity(final MessageCaptionBean messageCaptionBean) {
        View view;
        if (!this.mActivity.isFinishing() && messageCaptionBean != null && !TextUtils.isEmpty(messageCaptionBean.getContent())) {
            WindowManager windowManager = this.mwm;
            if (windowManager != null && (view = this.tipMarqueeView) != null) {
                windowManager.removeViewImmediate(view);
            }
            this.handler.removeCallbacks(this.showRunnable);
            this.tipMarqueeView = this.mlayoutinflater.inflate(R.layout.layout_marquee_text_view, (ViewGroup) null);
            WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams(-1, -2, 2002, 0, -2);
            if (Build.VERSION.SDK_INT >= 26) {
                layoutParams.type = 2038;
            } else {
                layoutParams.type = 2003;
            }
            layoutParams.flags = 524328;
            final ScrollTextView scrollTextView = (ScrollTextView) this.tipMarqueeView.findViewById(R.id.tvMarquee);
            LinearLayoutCompat linearLayoutCompat = (LinearLayoutCompat) this.tipMarqueeView.findViewById(R.id.llShow);
            final TextView textView = (TextView) this.tipMarqueeView.findViewById(R.id.tvExpend);
            final ImageView imageView = (ImageView) this.tipMarqueeView.findViewById(R.id.ivIcon);
            if (messageCaptionBean.getPosition() == 1) {
                layoutParams.gravity = 48;
            } else if (messageCaptionBean.getPosition() == 2) {
                layoutParams.gravity = 17;
            } else {
                layoutParams.gravity = 80;
            }
            linearLayoutCompat.setOnClickListener(new View.OnClickListener() { // from class: com.yd.android_brand_mvp.-$$Lambda$MainActivity$pVf30eQ2YfZqz36YokvlzH1De_g
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    this.f$0.lambda$setTipMarqueeText$13$MainActivity(imageView, textView, scrollTextView, view2);
                }
            });
            linearLayoutCompat.setVisibility(messageCaptionBean.isShowBtn() ? 0 : 8);
            int circulationMode = messageCaptionBean.getCirculationMode();
            if (circulationMode == 1) {
                scrollTextView.setScrollCount(true);
                scrollTextView.setCount(1);
            } else if (circulationMode == 2) {
                scrollTextView.setScrollCount(true);
                scrollTextView.setCount(messageCaptionBean.getPlayCount());
                if (messageCaptionBean.getIntervalTime() > 0) {
                    scrollTextView.setIntervalTime(((long) messageCaptionBean.getIntervalTime()) * 1000);
                }
            } else if (circulationMode == 3) {
                scrollTextView.setTimes((int) (((long) messageCaptionBean.getPlayTime()) * 1000));
                if (messageCaptionBean.getIntervalTime() > 0) {
                    scrollTextView.setIntervalTime(((long) messageCaptionBean.getIntervalTime()) * 1000);
                }
                this.handler.postDelayed(this.showRunnable, (int) (((long) messageCaptionBean.getPlayTime()) * 1000));
            }
            this.mwm.addView(this.tipMarqueeView, layoutParams);
            scrollTextView.setText(messageCaptionBean.getContent());
            scrollTextView.setMarqueeTextCallBack(new ScrollTextView.MarqueeTextCallBack() { // from class: com.yd.android_brand_mvp.-$$Lambda$MainActivity$cjpJLvV8FDguZbWaCmSyuNhk1Bg
                @Override // com.yd.android_brand_mvp.view.ScrollTextView.MarqueeTextCallBack
                public final void end() {
                    this.f$0.lambda$setTipMarqueeText$15$MainActivity(messageCaptionBean);
                }
            });
            if (!TextUtils.isEmpty(messageCaptionBean.getTextColor())) {
                scrollTextView.setTextColor(Color.parseColor(messageCaptionBean.getTextColor()));
            }
            if (messageCaptionBean.getFontSize() > 0) {
                scrollTextView.setTextSize(messageCaptionBean.getFontSize());
            }
            if (!TextUtils.isEmpty(messageCaptionBean.getBackgroundColor())) {
                scrollTextView.setBackgroundColor(Color.parseColor(messageCaptionBean.getBackgroundColor()));
                if (messageCaptionBean.getBackgroundTransparency() > 0) {
                    scrollTextView.getBackground().setAlpha(255 - ((int) (messageCaptionBean.getBackgroundTransparency() * 2.55f)));
                } else {
                    scrollTextView.getBackground().setAlpha(255);
                }
            }
            if (messageCaptionBean.getRollSpeed() > 0) {
                scrollTextView.setSpeed(messageCaptionBean.getRollSpeed());
                return;
            }
            return;
        }
        View view2 = this.tipMarqueeView;
        if (view2 == null || !view2.isShown()) {
            return;
        }
        this.tipMarqueeView.setVisibility(8);
    }

    public /* synthetic */ void lambda$setTipMarqueeText$13$MainActivity(ImageView imageView, TextView textView, ScrollTextView scrollTextView, View view) {
        boolean z = !this.show;
        this.show = z;
        imageView.setImageResource(z ? R.mipmap.icon_show_marquee : R.mipmap.icon_hide_marquee);
        textView.setText(this.show ? "收起" : "展开");
        scrollTextView.setVisibility(this.show ? 0 : 8);
    }

    public /* synthetic */ void lambda$setTipMarqueeText$15$MainActivity(final MessageCaptionBean messageCaptionBean) {
        Log.e(this.TAG, "setMarqueeTextCallBack ");
        runOnUiThread(new Runnable() { // from class: com.yd.android_brand_mvp.-$$Lambda$MainActivity$7PBz-qDYIdavKb_FTmey9qQIy6M
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$setTipMarqueeText$14$MainActivity(messageCaptionBean);
            }
        });
    }

    public /* synthetic */ void lambda$setTipMarqueeText$14$MainActivity(MessageCaptionBean messageCaptionBean) {
        this.tipMarqueeView.setVisibility(8);
        messageCaptionBean.setPlaySuccess(true);
        MMKV.defaultMMKV().putString(MMKVConstant.HOME_MARQUEE_TEXT, GsonUtils.toJson(messageCaptionBean));
    }

    private void initTimer() {
        if (OpenAndCloseTimeUtils.getInstance().isShowTip()) {
            new DeviceBootTipDialog(this).show();
            this.isRebootTime = false;
            BroCast.getPowerOffTime(this);
            OpenAndCloseTimeUtils.getInstance().setRetryTime(this);
        }
        this.rebootTimer.schedule(this.timerTask, C.DEFAULT_MAX_SEEK_TO_PREVIOUS_POSITION_MS, 1000L);
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    public void setHomeTopViewVisibility(int i, String str) {
        View view = this.TopCouseview;
        if (view == null) {
            return;
        }
        view.setVisibility(i);
        byte b = -1;
        switch (str.hashCode()) {
            case 49:
                if (str.equals("1")) {
                    b = 0;
                }
                break;
            case 50:
                if (str.equals("2")) {
                    b = 1;
                }
                break;
            case 51:
                if (str.equals("3")) {
                    b = 2;
                }
                break;
            case 52:
                if (str.equals("4")) {
                    b = 3;
                }
                break;
            case 53:
                if (str.equals(ConversionUtil.conditionWithSeriesName)) {
                    b = 4;
                }
                break;
            case 54:
                if (str.equals(ConversionUtil.conditionWithCallNumber)) {
                    b = 5;
                }
                break;
        }
        if (b == 0) {
            this.toplayout.setBackground(getResources().getDrawable(R.drawable.sk));
            return;
        }
        if (b == 1) {
            this.toplayout.setBackground(getResources().getDrawable(R.drawable.xk));
            return;
        }
        if (b == 2) {
            this.toplayout.setBackground(getResources().getDrawable(R.drawable.qc_bg));
            return;
        }
        if (b == 3) {
            this.toplayout.setBackground(getResources().getDrawable(R.drawable.sleep_bg));
        } else if (b == 4) {
            this.toplayout.setBackground(getResources().getDrawable(R.drawable.wx1_bg));
        } else {
            if (b != 5) {
                return;
            }
            this.toplayout.setBackground(getResources().getDrawable(R.drawable.wx2_bg));
        }
    }

    private String getTxtFromAssets() {
        String str = "";
        try {
            String str2 = SDcarfile.read(SDcarfile.FACE_CODE_TYPE);
            LogUtils.i("getTxtFromAssets: type = " + str2);
            InputStream inputStreamOpen = getAssets().open("CBG_Android_Face_Reco-two-stage.cert");
            if ("2".equals(str2)) {
                LogUtils.i("getTxtFromAssets: CBG_Android_Face_Reco-two-stage_JW");
                inputStreamOpen = getAssets().open("CBG_Android_Face_Reco-two-stage_JW.cert");
            }
            byte[] bArr = new byte[inputStreamOpen.available()];
            inputStreamOpen.read(bArr);
            String str3 = new String(bArr, StandardCharsets.UTF_8);
            try {
                LogUtils.i("certFace: " + str3);
                return str3;
            } catch (Exception e) {
                e = e;
                str = str3;
                e.printStackTrace();
                return str;
            }
        } catch (Exception e2) {
            e = e2;
        }
    }

    private void activeFace() {
        final String str = SDcarfile.read(SDcarfile.FACE_CODE);
        final String txtFromAssets = getTxtFromAssets();
        String str2 = SDcarfile.read(SDcarfile.FACE_CODE_TYPE);
        LogUtils.i("newCert 新版本cert证书 = " + str);
        LogUtils.i("oldCert 旧版本SRP cert证书 = " + txtFromAssets);
        LogUtils.i("FACE_CODE_TYPE 激活码类型 = " + str2);
        if (TextUtils.isEmpty(str)) {
            ToastUtil.showBottomView(this.mActivity, "人脸未授权激活");
            return;
        }
        if (!TextUtils.isEmpty(str2) && str2.equals("3")) {
            this.handler.post(new Runnable() { // from class: com.yd.android_brand_mvp.-$$Lambda$MainActivity$PSAwSFK63_w8F7Z8fP4iEYybIRM
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$activeFace$17$MainActivity(str);
                }
            });
            return;
        }
        String string = MMKVUtils.INSTANCE.getString(MMKVConstant.FACE_ACTIVE_CONFIG);
        FaceActiveConfigBean faceActiveConfigBean = (FaceActiveConfigBean) GsonUtils.fromJson(string, FaceActiveConfigBean.class);
        if (faceActiveConfigBean != null && !TextUtils.isEmpty(faceActiveConfigBean.getContent())) {
            LogUtils.i("FaceActiveConfigBean = " + string);
            FaceManager.INSTANCE.initSrpFaceSDK(this.mActivity, txtFromAssets, faceActiveConfigBean.getContent(), this.mOnAuthCallback);
            return;
        }
        this.viewModel.getFaceActiveConfig().observe(this, new Observer() { // from class: com.yd.android_brand_mvp.-$$Lambda$MainActivity$sOLm5h3PYe802tcOFfJdEP-Y_GU
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                this.f$0.lambda$activeFace$18$MainActivity(txtFromAssets, (FaceActiveConfigBean) obj);
            }
        });
        this.viewModel.getFaceConfig();
    }

    public /* synthetic */ void lambda$activeFace$17$MainActivity(String str) {
        FaceManager.INSTANCE.initFacePassSDK(this.mActivity, str, this.mOnAuthCallback);
    }

    public /* synthetic */ void lambda$activeFace$18$MainActivity(String str, FaceActiveConfigBean faceActiveConfigBean) {
        FaceActiveConfigBean faceActiveConfigBean2 = (FaceActiveConfigBean) GsonUtils.fromJson(MMKVUtils.INSTANCE.getString(MMKVConstant.FACE_ACTIVE_CONFIG), FaceActiveConfigBean.class);
        if (faceActiveConfigBean2 != null) {
            FaceManager.INSTANCE.initSrpFaceSDK(this.mActivity, str, faceActiveConfigBean2.getContent(), this.mOnAuthCallback);
        }
    }

    /* JADX INFO: renamed from: com.yd.android_brand_mvp.MainActivity$16, reason: invalid class name */
    class AnonymousClass16 implements OnAuthCallback {
        AnonymousClass16() {
        }

        @Override // com.yyide.facepass.OnAuthCallback
        public void onAuthSuccess() {
            ToastUtils.showLong("人脸激活成功");
            LogUtils.i("人脸激活成功");
            SPUtils.getInstance().put(SpData.isFaceEnable, true);
            new Handler().postDelayed(new Runnable() { // from class: com.yd.android_brand_mvp.-$$Lambda$MainActivity$16$2yV8iNyijCpKLlECWXW9ixSc6J4
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$onAuthSuccess$0$MainActivity$16();
                }
            }, 5000L);
        }

        public /* synthetic */ void lambda$onAuthSuccess$0$MainActivity$16() {
            FaceManager.INSTANCE.initFaceSyncConfig(MainActivity.this, AppUtils.getAppVersionName(), "https://api.yyide.com", SpData.getSchoolId(), BaseApplication.getInstance().getMac());
        }

        @Override // com.yyide.facepass.OnAuthCallback
        public void onAuthError(int i, String str) {
            ToastUtils.showLong(str + " errorCode = " + i);
            LogUtils.i("人脸激活失败: " + str + " errorCode = " + i);
            SPUtils.getInstance().put(SpData.isFaceEnable, false);
        }
    }

    void updateVersion() {
        ((HomePresenter) this.mvpPresenter).updateAppVersionNumber();
        ((HomePresenter) this.mvpPresenter).getNewestVersion(SpData.getSchoolId());
    }

    @Override // com.yd.android_brand_mvp.base.BaseMvpActivity, com.yd.android_brand_mvp.base.BaseActivity, skin.support.app.SkinCompatActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        BaseConstant.DOMINATE_CLOSE = false;
        unregisterReceiver(this.receiver);
        unregisterReceiver(this.nfcReceiver);
        this.rebootTimer.cancel();
        this.timerTask.cancel();
        SocketClient.INSTANCE.closeConnect();
        NetworkChangeReceiver.unRegisterObserver(this);
        NetworkChangeReceiver.unRegisterReceiver(this);
        LogUtils.i("Android app close onDestroy");
        MQTTClient.INSTANCE.disconnect();
        mtread.getInstance().unUsbDevPermission();
        SPUtils.getInstance().remove(SpData.LASTATTENCEID);
        MinaEventManager.getInstance().remove(this);
        VideoUtils.setVideoState(this, "1");
        GSYVideoManager.releaseAllVideos();
        stopAllVoice();
        this.handler.removeCallbacks(this.runnable);
        this.timeOutHandler.removeCallbacksAndMessages(null);
        this.timeOutHandler1.removeCallbacksAndMessages(null);
        this.handler.removeCallbacks(this.remindVoice);
        this.handler.removeCallbacks(this.downLoadRunnable);
        this.handler.removeCallbacks(this.attendanceRunnable);
        this.handler.removeCallbacks(this.imMessageRunnable);
        this.handler.removeCallbacks(this.messageGetRunnable);
        this.handler.removeCallbacks(this.btnRunnable);
        this.handler.removeCallbacks(this.initFaceSdkRunnable);
        this.handler.removeCallbacks(this.updateRunnable);
        this.handler.removeCallbacks(this.MTrunnable);
        this.handler.removeCallbacksAndMessages(null);
        this.handler = null;
        FaceManager.INSTANCE.onDestroyFacePassHandler();
        if (BaseConstant.BlueToothLock) {
            stopService(new Intent(this, (Class<?>) BluetoothService.class));
        }
        WindowManager windowManager = this.mwm;
        if (windowManager != null) {
            windowManager.removeViewImmediate(this.TopCouseview);
            this.mwm.removeViewImmediate(this.mwindowview);
            this.mwm.removeViewImmediate(this.tipCountdownView);
            View view = this.tipMarqueeView;
            if (view != null) {
                this.mwm.removeViewImmediate(view);
            }
        }
        AppUtils.exitApp();
    }

    @Override // com.yd.android_brand_mvp.observer.MinaListener
    public void UpdataEvent(int i) {
        Log.i(this.TAG, "UpdataEventId = " + i);
        if (i == MinaConstants.PostFace) {
            postData();
            return;
        }
        if (i == MinaConstants.update) {
            updateVersion();
            return;
        }
        if (i == MinaConstants.FACE_ACTIVE) {
            this.handler.postDelayed(this.initFaceSdkRunnable, CLICK_INTERVAL);
            return;
        }
        if (i == MinaConstants.photoAndvideo) {
            sendBroadcast(new Intent("VideoBanner"));
            return;
        }
        if (i == MinaConstants.THEME_BG) {
            startActivity(new Intent(this, (Class<?>) WelcomeActivity.class));
            return;
        }
        if (i == MinaConstants.CODE_EXAM) {
            this.viewModel.getHomeExamListData();
        } else if (i == MinaConstants.SOCKET_IP) {
            SocketClient.INSTANCE.closeConnect();
            socketConnect();
        }
    }

    private void parseDominateInfo() {
        this.dominateScreenList.clear();
        WebSocketDominateParamBean webSocketDominateParamBean = (WebSocketDominateParamBean) GsonUtils.fromJson(MMKVUtil.INSTANCE.getDominateLevel(), WebSocketDominateParamBean.class);
        if (webSocketDominateParamBean == null) {
            return;
        }
        List<DominateDetailLevelBean> details = webSocketDominateParamBean.getDetails();
        Log.d(this.TAG, "parseDominateInfo: " + details);
        if (details.isEmpty()) {
            return;
        }
        for (int i = 0; i < details.size(); i++) {
            DominateDetailLevelBean dominateDetailLevelBean = details.get(i);
            if (dominateDetailLevelBean.getType() > 0) {
                dominateDetailLevelBean.setModeType("4");
            }
            this.dominateScreenList.add(new DominateScreenBean(dominateDetailLevelBean.getModeType(), dominateDetailLevelBean.getLevel(), dominateDetailLevelBean.isForceExit()));
            orderDominateCodeToRequest(dominateDetailLevelBean.getModeType());
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:18:0x0037  */
    /* JADX WARN: Failed to clean up code after switch over string restore
    jadx.core.utils.exceptions.JadxRuntimeException: Can't remove SSA var: r0v0 int, still in use, count: 1, list:
  (r0v0 int) from 0x0009: IF  (r0v0 int) != (-1563081780 int)  -> B:4:0x000b A[HIDDEN]
    	at jadx.core.utils.InsnRemover.removeSsaVar(InsnRemover.java:164)
    	at jadx.core.utils.InsnRemover.unbindResult(InsnRemover.java:129)
    	at jadx.core.utils.InsnRemover.unbindInsn(InsnRemover.java:93)
    	at jadx.core.utils.InsnRemover.remove(InsnRemover.java:226)
    	at jadx.core.utils.InsnRemover.remove(InsnRemover.java:215)
    	at jadx.core.dex.visitors.regions.SwitchOverStringVisitor.replaceWithMergedSwitch(SwitchOverStringVisitor.java:355)
    	at jadx.core.dex.visitors.regions.SwitchOverStringVisitor.restoreSwitchOverString(SwitchOverStringVisitor.java:111)
    	at jadx.core.dex.visitors.regions.SwitchOverStringVisitor.visitRegion(SwitchOverStringVisitor.java:72)
    	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterativeStepInternal(DepthRegionTraversal.java:140)
    	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterative(DepthRegionTraversal.java:47)
    	at jadx.core.dex.visitors.regions.SwitchOverStringVisitor.visit(SwitchOverStringVisitor.java:66)
     */
    private void orderDominateCodeToRequest(String str) {
        byte b;
        if (str.hashCode() != -1563081780) {
            switch (str) {
                case "2":
                    b = 2;
                    break;
                case "3":
                    b = 0;
                    break;
                case "4":
                    b = 3;
                    break;
                default:
                    b = -1;
                    break;
            }
        } else if (str.equals(DominateScreenUtil.TYPE_RESERVATION)) {
            b = 1;
        } else {
            b = -1;
        }
        if (b == 0) {
            this.viewModel.getHomeExamListData();
            return;
        }
        if (b == 1) {
            this.viewModel.getTodayReservationList(SpData.getSiteId());
        } else {
            if (b != 2) {
                return;
            }
            ((HomePresenter) this.mvpPresenter).getMessageDominateList();
        }
    }

    @Override // com.yd.android_brand_mvp.base.BaseActivity, skin.support.app.SkinCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
        this.isShow = true;
        silentSwitch(true);
        postData();
        VerticalTextview verticalTextview = this.textView;
        if (verticalTextview != null) {
            verticalTextview.startAutoScroll();
        }
        BroCast.hidebar(this);
        View view = this.mwindowview;
        if (view != null && !this.isSite) {
            view.setVisibility(0);
        }
        if (SpData.isRefreash()) {
            this.sigTime = System.currentTimeMillis() / 1000;
            SPUtils.getInstance().put(SpData.Refresh, false);
        }
        setBtnEnable(true);
        dominateStart();
    }

    @Override // com.yd.android_brand_mvp.base.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onPause() {
        super.onPause();
        this.isShow = false;
        silentSwitch(false);
        Log.i(this.TAG, "main - pause");
        View view = this.mwindowview;
        if (view != null) {
            view.setVisibility(8);
        }
        VerticalTextview verticalTextview = this.textView;
        if (verticalTextview != null) {
            verticalTextview.stopAutoScroll();
        }
    }

    void setBg() {
        String str;
        boolean z = SPUtils.getInstance().getBoolean(SpData.SKIN);
        LayoutListRsp layoutListRspHomeIndexData = SpData.HomeIndexData();
        if (BaseConstant.APP_VERSION_TYPE == BaseConstant.UNIVERSITY_VERSION) {
            this.bg.setImageResource(R.drawable.bp_univerity_bg);
            return;
        }
        if (z) {
            this.bg.setImageResource(R.drawable.bp_bg);
            this.bg.setImageResource(R.drawable.bp_bg);
            return;
        }
        if (layoutListRspHomeIndexData == null || layoutListRspHomeIndexData.data == null || layoutListRspHomeIndexData.data.size() <= 0) {
            return;
        }
        String json = GsonUtils.toJson(layoutListRspHomeIndexData.data.get(0));
        LayoutListRsp.DataBean dataBean = layoutListRspHomeIndexData.data.get(0);
        if (dataBean.layoutClassSignDetailsEntityList.isEmpty()) {
            return;
        }
        LayoutListRsp.DataBean.LayoutClassSignDetailsEntityListBean layoutClassSignDetailsEntityListBean = dataBean.layoutClassSignDetailsEntityList.get(0);
        if (!TextUtils.isEmpty(json) && json.contains("music")) {
            this.bg.setImageResource(R.drawable.icon_drak_music_bg);
            return;
        }
        if (!TextUtils.isEmpty(json) && json.contains("drak")) {
            this.bg.setImageResource(R.drawable.icon_drak_bp_bg);
            return;
        }
        if (!TextUtils.isEmpty(json) && json.contains("machine")) {
            this.bg.setImageResource(R.drawable.bp_univerity_bg);
            return;
        }
        if (layoutClassSignDetailsEntityListBean.tag.contains("chemistry")) {
            this.bg.setImageResource(R.drawable.bg_module_chemistry);
            return;
        }
        if (json.contains("hbtjcustom8x5")) {
            this.bg.setImageResource(R.drawable.icon_customized_home_bg);
            return;
        }
        String str2 = null;
        if (dataBean.layoutClassSignDetailsEntityList == null || dataBean.layoutClassSignDetailsEntityList.size() <= 0) {
            str = null;
        } else {
            str2 = layoutClassSignDetailsEntityListBean.backgropPhoto;
            str = layoutClassSignDetailsEntityListBean.backgropColour;
        }
        if (!TextUtils.isEmpty(str2)) {
            GlideUtil.loadNomalImage(this, str2, this.bg);
        } else {
            if (TextUtils.isEmpty(str)) {
                return;
            }
            this.bg.setBackgroundColor(Color.parseColor(str));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.yd.android_brand_mvp.base.BaseMvpActivity
    public HomePresenter createPresenter() {
        return new HomePresenter(this);
    }

    void silentSwitch(boolean z) {
        final AudioManager audioManager = (AudioManager) getSystemService("audio");
        if (!z) {
            if (Build.VERSION.SDK_INT >= 23) {
                this.handler.postDelayed(new Runnable() { // from class: com.yd.android_brand_mvp.-$$Lambda$MainActivity$sMNDtjBFbSCmnAWFGWrNp3BKFR8
                    @Override // java.lang.Runnable
                    public final void run() {
                        audioManager.adjustStreamVolume(3, 100, 0);
                    }
                }, 1500L);
            }
        } else {
            GSYVideoManager.instance().setNeedMute(true);
            if (Build.VERSION.SDK_INT >= 23) {
                audioManager.adjustStreamVolume(3, -100, 0);
                this.handler.postDelayed(new Runnable() { // from class: com.yd.android_brand_mvp.-$$Lambda$MainActivity$3324MaBW0bPS_EKbpxclOM71J_0
                    @Override // java.lang.Runnable
                    public final void run() {
                        audioManager.adjustStreamVolume(3, 100, 0);
                    }
                }, WorkRequest.MIN_BACKOFF_MILLIS);
            }
        }
    }

    @Override // com.yd.android_brand_mvp.view.HomeView
    public void getMessageDominate(BaseResponse<List<MessageItemBean>> baseResponse) {
        if (baseResponse == null || baseResponse.getCode() != 0) {
            return;
        }
        if (baseResponse.getData() != null) {
            SPUtils.getInstance().put(SpData.MESSAGE_DOMINATE, JSON.toJSONString(baseResponse.getData()));
        } else {
            SPUtils.getInstance().remove(SpData.MESSAGE_DOMINATE);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void messageDominate() {
        if (BaseConstant.DOMINATE_CLOSE) {
            return;
        }
        Log.d(this.TAG, "messageDominate: size =" + this.dominateScreenList.size());
        DominateStartBean dominateStartBeanIsNeedStart = DominateScreenUtil.INSTANCE.isNeedStart(this.dominateScreenList);
        Log.d(this.TAG, "messageDominate: " + dominateStartBeanIsNeedStart.getType());
        if (!TextUtils.isEmpty(dominateStartBeanIsNeedStart.getType()) && dominateStartBeanIsNeedStart.getListIndex() != -1) {
            boolean zDealWithCurrentDominate = DominateScreenUtil.INSTANCE.dealWithCurrentDominate(dominateStartBeanIsNeedStart, this.currentDominateBean);
            Log.d(this.TAG, "messageDominate: 是否更换" + zDealWithCurrentDominate);
            if (zDealWithCurrentDominate) {
                this.currentDominateBean = dominateStartBeanIsNeedStart;
                DominateScreenUtil.INSTANCE.startGoTypeActivity(this, this.dominateScreenList.get(dominateStartBeanIsNeedStart.getListIndex()), dominateStartBeanIsNeedStart.getItemDataIndex());
                return;
            }
            return;
        }
        if (this.currentDominateBean != null) {
            DominateScreenUtil.INSTANCE.finishTypeActivity(this.currentDominateBean.getType());
            this.currentDominateBean = null;
        }
    }

    @Override // com.yd.android_brand_mvp.view.HomeView
    public void getDataSuccess(LayoutListRsp layoutListRsp) {
        LogUtils.i("首页布局获取成功 = " + GsonUtils.toJson(layoutListRsp));
        this.nomalLoadingDiallog.dismiss();
        if (layoutListRsp.code == 0) {
            SPUtils.getInstance().put(SpData.HomeData, JSON.toJSONString(layoutListRsp));
            setBg();
        } else if (layoutListRsp.code == 401) {
            ((HomePresenter) this.mvpPresenter).getToken();
        }
        setLayoutCache();
    }

    @Override // com.yd.android_brand_mvp.view.HomeView
    public void getDominateLevelFail(String str) {
        LogUtils.i(str);
    }

    @Override // com.yd.android_brand_mvp.view.HomeView
    public void getHomeNoticeFail(String str) {
        LogUtils.i("首页字幕=" + str);
    }

    @Override // com.yd.android_brand_mvp.view.HomeView
    public void getFail(String str) {
        LogUtils.i(str);
        this.nomalLoadingDiallog.dismiss();
        setInfo();
        setBg();
        setLayoutCache();
    }

    void setLayoutCache() {
        LayoutListRsp layoutListRspHomeIndexData = SpData.HomeIndexData();
        if (layoutListRspHomeIndexData == null || layoutListRspHomeIndexData.data == null || layoutListRspHomeIndexData.data.size() <= 0) {
            return;
        }
        LogUtils.i("加载缓存布局: ");
        initFragment(SpData.HomeIndexData().data);
    }

    void setInfo() {
        SchoolStytleRsp schoolInfo2 = SpData.getSchoolInfo2();
        if (schoolInfo2.data != null) {
            GlideUtil.loadCircleImage2(this, schoolInfo2.data.schoolLogo, this.logo);
            this.officename.setText(schoolInfo2.data.schoolName);
            this.tv_text.setText(schoolInfo2.data.englishName);
            this.tv_text.setVisibility(!TextUtils.isEmpty(schoolInfo2.data.englishName) ? 0 : 8);
            if (!ScreenUtils.isLandscape()) {
                this.tv_text.setVisibility(8);
            }
        }
        NewWeatherBean newWeatherBean = (NewWeatherBean) MMKV.defaultMMKV().decodeParcelable(MMKVConstant.WEATHER_NEW, NewWeatherBean.class);
        if (newWeatherBean != null) {
            this.weathericon.setImageDrawable(WeatherUtils.imgCode_y(this, newWeatherBean.getWeather()));
            this.weathertext.setText(newWeatherBean.getArea() + " " + newWeatherBean.getWeather());
            this.wd.setText(newWeatherBean.getReal());
        }
    }

    private void initFragment(final List<LayoutListRsp.DataBean> list) {
        ArrayList arrayList = new ArrayList();
        FragmentManager supportFragmentManager = getSupportFragmentManager();
        if (list == null) {
            return;
        }
        LogUtils.i("初始化首页布局");
        String json = GsonUtils.toJson(list);
        if (!TextUtils.isEmpty(json) && json.contains("sbsitefullScreen")) {
            View view = this.mwindowview;
            if (view != null) {
                view.setVisibility(8);
            }
            this.isSite = true;
            getSupportFragmentManager().beginTransaction().replace(R.id.flContent, SiteFullScreenFragment.INSTANCE.newInstance()).commit();
            return;
        }
        if (list.isEmpty()) {
            return;
        }
        int size = list.size();
        View view2 = this.mwindowview;
        if (view2 != null) {
            view2.setVisibility(0);
        }
        if (size <= 1) {
            this.recyleview.setVisibility(8);
        } else {
            this.indexAdapter.notifydata(size);
            this.indexAdapter.setPosition(0);
            this.recyleview.setVisibility(0);
        }
        this.pager.setOffscreenPageLimit(size);
        for (LayoutListRsp.DataBean dataBean : list) {
            Bundle bundle = new Bundle();
            bundle.putString("HomeInfo", dataBean.pagination);
            HomeFragment homeFragment = new HomeFragment();
            homeFragment.setArguments(bundle);
            if (!homeFragment.isAdded()) {
                arrayList.add(homeFragment);
            }
        }
        this.pager.setAdapter(new ViewPagerFragmentAdapter(supportFragmentManager, arrayList));
        this.pager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() { // from class: com.yd.android_brand_mvp.MainActivity.18
            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageScrollStateChanged(int i) {
            }

            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageScrolled(int i, float f, int i2) {
            }

            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageSelected(int i) {
                BaseConstant.homeIndex = i;
                EventBus.getDefault().post(new EventBean(i, "", "homeVideo"));
                MainActivity.this.indexAdapter.setPosition(i);
                if (i < list.size()) {
                    LayoutListRsp.DataBean dataBean2 = (LayoutListRsp.DataBean) list.get(i);
                    if (dataBean2.layoutClassSignDetailsEntityList.isEmpty()) {
                        return;
                    }
                    LayoutListRsp.DataBean.LayoutClassSignDetailsEntityListBean layoutClassSignDetailsEntityListBean = dataBean2.layoutClassSignDetailsEntityList.get(0);
                    String json2 = GsonUtils.toJson(dataBean2.layoutClassSignDetailsEntityList);
                    if (TextUtils.isEmpty(json2)) {
                        return;
                    }
                    if (json2.contains("music")) {
                        MainActivity.this.bg.setImageResource(R.drawable.icon_drak_music_bg);
                        return;
                    }
                    if (json2.contains("drak")) {
                        MainActivity.this.bg.setImageResource(R.drawable.icon_drak_bp_bg);
                    } else if (json2.contains("machine")) {
                        MainActivity.this.bg.setImageResource(R.drawable.bp_univerity_bg);
                    } else if (layoutClassSignDetailsEntityListBean.tag.contains("chemistry")) {
                        MainActivity.this.bg.setImageResource(R.drawable.bg_module_chemistry);
                    }
                }
            }
        });
    }

    @Override // com.yd.android_brand_mvp.view.HomeView
    public void getWeatherFail(String str) {
        LogUtils.d("getWeatherFail: " + str);
    }

    @Override // com.yd.android_brand_mvp.view.HomeView
    public void getWeatherSuccess(BaseResponse<NewWeatherListBean> baseResponse) {
        if (baseResponse == null || baseResponse.getData() == null) {
            return;
        }
        MMKV.defaultMMKV().encode(MMKVConstant.WEATHER_LIST_NEW, baseResponse.getData());
    }

    @Override // com.yd.android_brand_mvp.view.HomeView
    public void getWeatherDaySuccess(BaseResponse<NewWeatherBean> baseResponse) {
        if (baseResponse != null && baseResponse.getData() != null) {
            MMKV.defaultMMKV().encode(MMKVConstant.WEATHER_NEW, baseResponse.getData());
        }
        setInfo();
    }

    @Override // com.yd.android_brand_mvp.view.HomeView
    public void SchoolSytlSuccess(SchoolStytleRsp schoolStytleRsp) {
        this.schoolInfo = true;
        LogUtils.i("SchoolSytlSuccess: " + JSON.toJSONString(schoolStytleRsp));
        if (schoolStytleRsp.code.intValue() == 0) {
            SPUtils.getInstance().put(SpData.SCHOOLINFO2, JSON.toJSONString(schoolStytleRsp));
            setInfo();
        }
    }

    @Override // com.yd.android_brand_mvp.view.HomeView
    public void SchoolSytlFail(String str) {
        LogUtils.i("SchoolSytlFail: " + str);
    }

    @Override // com.yd.android_brand_mvp.view.HomeView
    public void switchlist(switchlistRsp switchlistrsp) {
        LogUtils.i("switchlist = " + GsonUtils.toJson(switchlistrsp));
        if (switchlistrsp.code.intValue() == 0) {
            this.TimeContrNum = 6;
            SPUtils.getInstance().put(SpData.Time, JSON.toJSONString(switchlistrsp));
        }
        setSwitch();
    }

    @Override // com.yd.android_brand_mvp.view.HomeView
    public void switchlistFail(String str) {
        this.TimeContrNum = 0;
    }

    private void setSwitch() {
        switchlistRsp time = SpData.getTime();
        if (this.isRebootTime) {
            if (time != null && time.data != null && time.data.switchList.size() > 0) {
                LogUtils.i("获取缓存开关机时间");
                OpenAndCloseTimeUtils.getInstance().setTimePower(this, time);
            } else {
                BroCast.clearPowerOnOffTime(this);
            }
        }
    }

    @Override // com.yd.android_brand_mvp.view.HomeView
    public void NewestVersionSuccess(getNewestVersionRsp getnewestversionrsp) {
        LogUtils.i("NewestVersionSuccess: " + JSON.toJSONString(getnewestversionrsp));
        if (getnewestversionrsp.code == 0) {
            setApkData(getnewestversionrsp);
        } else {
            ToastUtils.showShort(getnewestversionrsp.message);
        }
    }

    @Override // com.yd.android_brand_mvp.view.HomeView
    public void NewestVersionFail(String str) {
        ToastUtils.showShort(str);
    }

    void setAutoScrollData(List<StudentMsgBean.Data0> list) {
        MinaEventManager.getInstance().notifyObserver(MinaConstants.StudentMsg);
        ArrayList<StudentMsgBean.Data0> arrayList = new ArrayList();
        for (StudentMsgBean.Data0 data0 : list) {
            if (data0.msgNum != 0) {
                arrayList.add(data0);
            }
        }
        final ArrayList arrayList2 = new ArrayList();
        for (StudentMsgBean.Data0 data1 : arrayList) {
            if (!StringUtils.isEmpty(data1.name) && data1.name.length() > 5) {
                arrayList2.add(data1.name.substring(0, 5) + "... 有" + data1.msgNum + "条未读消息");
            } else {
                arrayList2.add(data1.name + " 有" + data1.msgNum + "条未读消息");
            }
        }
        runOnUiThread(new Runnable() { // from class: com.yd.android_brand_mvp.-$$Lambda$MainActivity$PZlwrWwDTE9mElHtnm5Y40iR8i0
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$setAutoScrollData$21$MainActivity(arrayList2);
            }
        });
    }

    public /* synthetic */ void lambda$setAutoScrollData$21$MainActivity(ArrayList arrayList) {
        if (arrayList.size() != 0) {
            this.textView.setTextList(arrayList);
            this.textView.setVisibility(0);
        } else {
            this.textView.setVisibility(8);
        }
        NewBrandLoginRsp newBrandLoginRspNewUser = SpData.NewUser();
        if (newBrandLoginRspNewUser == null || newBrandLoginRspNewUser.data == null) {
            return;
        }
        if (newBrandLoginRspNewUser.data.isMessage.booleanValue()) {
            this.xx.setVisibility(0);
            if (arrayList.size() != 0) {
                this.textView.setVisibility(0);
                return;
            }
            return;
        }
        this.textView.setVisibility(8);
        this.xx.setVisibility(8);
    }

    @Override // com.yd.android_brand_mvp.view.HomeView
    public void getDataAttenceSuccess(AttencelistRsp2 attencelistRsp2) {
        this.attendanceRule = true;
        LogUtils.i("获取考勤规则列表：" + GsonUtils.toJson(attencelistRsp2));
        if (attencelistRsp2.code == 0) {
            SPUtils.getInstance().put(SpData.ATTENCERULE2, JSON.toJSONString(attencelistRsp2));
            Iterator<AttencelistRsp2.DataDTO.AttendanceListDTO> it2 = attencelistRsp2.data.attendanceList.iterator();
            while (it2.hasNext()) {
                ((HomePresenter) this.mvpPresenter).getBrandAttendanceUser(it2.next().id);
            }
        }
    }

    @Override // com.yd.android_brand_mvp.view.HomeView
    public void getDataAttenceSuccessFail(String str) {
        LogUtils.e("获取考勤规则列表失敗 " + str);
    }

    @Override // com.yd.android_brand_mvp.view.HomeView
    public void getAttendanceSuccess(GeneralBean2 generalBean2) {
        MinaEventManager.getInstance().notifyObserver(MinaConstants.CODE_UPDATA_ATTENCE_LIST);
        if (generalBean2.code.intValue() == 0) {
            LogUtils.i("考勤打卡成功: " + JSON.toJSONString(generalBean2));
            Iterator<Long> it2 = generalBean2.data.iterator();
            while (it2.hasNext()) {
                AttendanceUtils.INSTANCE.updateAttendancePeople(this, it2.next().longValue());
            }
        }
    }

    @Override // com.yd.android_brand_mvp.view.HomeView
    public void getAttendanceSuccessFail(String str) {
        LogUtils.e("getAttendanceSuccessFail: " + JSON.toJSONString(str));
    }

    @Override // com.yd.android_brand_mvp.view.HomeView
    public void uploadLogSuccess(BaseResponse<UploadFileBean> baseResponse) {
        baseResponse.getCode();
    }

    @Override // com.yd.android_brand_mvp.view.HomeView
    public void uploadLogFail(String str) {
        LogUtils.e("uploadLogSuccess: uploadLogFail");
    }

    @Override // com.yd.android_brand_mvp.view.HomeView
    public void selectTeacherByClassesIdRspSuccess(selectTeacherByClassesIdRsp selectteacherbyclassesidrsp) {
        if (selectteacherbyclassesidrsp.code.intValue() == 0) {
            SPUtils.getInstance().put(SpData.ClassPermision, JSON.toJSONString(selectteacherbyclassesidrsp));
        }
    }

    @Override // com.yd.android_brand_mvp.view.HomeView
    public void getSystemSigSuccess(BaseResponse<String> baseResponse) {
        if (baseResponse == null || baseResponse.getCode() != 0) {
            return;
        }
        this.imSign = AESEncryptUtils.decrypt(baseResponse.getData());
    }

    @Override // com.yd.android_brand_mvp.view.HomeView
    public void getremindSuccess(NewRemindRsp newRemindRsp) {
        LogUtils.i("getremindSuccess: " + JSON.toJSONString(newRemindRsp));
        if (newRemindRsp.code == 0) {
            SPUtils.getInstance().put(SpData.Voice, JSON.toJSONString(newRemindRsp));
        }
    }

    @Override // com.yd.android_brand_mvp.view.HomeView
    public void getremindFail(String str) {
        LogUtils.i(this.TAG, "getremindFail: " + JSON.toJSONString(str));
    }

    @Override // com.yd.android_brand_mvp.view.HomeView
    public void getDataAttenceUserSuccess(AttenceUser attenceUser) {
        LogUtils.i("获取考勤人员成功 = " + GsonUtils.toJson(attenceUser));
        if (attenceUser.code.intValue() != 0 || attenceUser.data == null) {
            return;
        }
        this.listAttenceUser.add(attenceUser.data);
        SPUtils.getInstance().put(SpData.ATTENCEPERSON, JSON.toJSONString(this.listAttenceUser));
    }

    @Override // com.yd.android_brand_mvp.view.HomeView
    public void getCDKBData(KBRsp2 kBRsp2) {
        LogUtils.i("获取考勤课表成功 = " + GsonUtils.toJson(kBRsp2));
        this.attendanceTable = true;
        if (kBRsp2 != null && kBRsp2.code != null && kBRsp2.code.intValue() == 0 && kBRsp2.data != null && kBRsp2.data.timetableList != null && kBRsp2.data.timetableList.size() > 0) {
            SPUtils.getInstance().put(SpData.AttenceKBData, GsonUtils.toJson(kBRsp2));
        }
        MinaEventManager.getInstance().notifyObserver(MinaConstants.ATTENCE_MODULE);
    }

    @Override // com.yd.android_brand_mvp.view.HomeView
    public void KBDataFail(String str) {
        LogUtils.e("KBDataFail: 获取考勤课表  失败");
    }

    @Override // com.yd.android_brand_mvp.view.HomeView
    public void allStudents(AllstudentRsp allstudentRsp) {
        LogUtils.i("allStudents = " + GsonUtils.toJson(allstudentRsp));
        if (allstudentRsp.code.intValue() == 0) {
            SPUtils.getInstance().put(SpData.allStudents, GsonUtils.toJson(allstudentRsp));
            this.list.clear();
            this.handler.postDelayed(this.messageGetRunnable, 5000L);
        }
    }

    @Override // com.yd.android_brand_mvp.view.HomeView
    public void getBrandLoginSuccess(NewBrandLoginRsp newBrandLoginRsp) {
        LogUtils.i("获取班牌登录信息= " + GsonUtils.toJson(newBrandLoginRsp));
        if (newBrandLoginRsp != null && newBrandLoginRsp.code == 0 && newBrandLoginRsp.data != null) {
            SPUtils.getInstance().put(BaseConstant.LOGINNAME, newBrandLoginRsp.data.loginName);
            SPUtils.getInstance().put(BaseConstant.PASSWORD, newBrandLoginRsp.data.plaintextPassword);
            SPUtils.getInstance().put(SpData.NewBrandUser, JSON.toJSONString(newBrandLoginRsp));
            SPUtils.getInstance().put(SpData.MSGTYPE, newBrandLoginRsp.data.isSecond);
            ((HomePresenter) this.mvpPresenter).getNewWeatherList();
            ((HomePresenter) this.mvpPresenter).getNewWeather();
            return;
        }
        if ((newBrandLoginRsp != null && newBrandLoginRsp.code == -1 && newBrandLoginRsp.message.contains("班牌状态出错")) || newBrandLoginRsp.message.contains("找不到场地信息") || newBrandLoginRsp.message.contains("密码不正确")) {
            SPUtils.getInstance().remove(SpData.RegCode);
            SPUtils.getInstance().remove(BaseConstant.LOGINNAME);
            SPUtils.getInstance().remove(BaseConstant.PASSWORD);
            ToastUtils.showShort(newBrandLoginRsp.message);
            finish();
            startActivity(new Intent(this, (Class<?>) LoginActivity.class));
        }
    }

    @Override // com.yd.android_brand_mvp.view.HomeView
    public void getNewTokenSuccess(NewLoginRsp newLoginRsp) {
        if (newLoginRsp.code == 0) {
            SPUtils.getInstance().put(SpData.TOKEN, newLoginRsp.data.tokenHead + newLoginRsp.data.accessToken);
            SPUtils.getInstance().put(SpData.REFRESHTOKEN, newLoginRsp.data.refreshToken);
        }
    }

    @Override // com.yd.android_brand_mvp.view.HomeView
    public void getClassKBSuccess(KBRsp2 kBRsp2) {
        if (kBRsp2.code.intValue() == 0) {
            SPUtils.getInstance().put(SpData.NEWKB, GsonUtils.toJson(kBRsp2));
            MinaEventManager.getInstance().notifyObserver(MinaConstants.TABLE_CODE);
        }
    }

    @Override // com.yd.android_brand_mvp.view.HomeView
    public void getSiteKBSuccess(KBRsp2 kBRsp2) {
        if (kBRsp2.code.intValue() == 0) {
            SPUtils.getInstance().put(SpData.SITEKB, GsonUtils.toJson(kBRsp2));
            ArrayList arrayList = new ArrayList();
            if (kBRsp2.data != null && kBRsp2.data.timetableList != null) {
                List<KBRsp2.DataDTO.TimetableListDTO> list = kBRsp2.data.timetableList;
                String week2 = Tool.getWeek2(System.currentTimeMillis());
                for (KBRsp2.DataDTO.TimetableListDTO timetableListDTO : list) {
                    if (!TextUtils.isEmpty(week2)) {
                        if (week2.equals(timetableListDTO.week + "")) {
                            arrayList.add(timetableListDTO.id);
                        }
                    }
                }
                MinaEventManager.getInstance().notifyObserver(MinaConstants.TABLE_CODE);
            }
            if (arrayList.isEmpty()) {
                return;
            }
            ((HomePresenter) this.mvpPresenter).getAttendanceSiteTimetable(arrayList);
        }
    }

    @Override // com.yd.android_brand_mvp.view.HomeView
    public void getSiteAttendanceSuccess(BaseResponse<List<SiteAttendanceBean>> baseResponse) {
        if (baseResponse.getCode() != 0 || baseResponse.getData() == null) {
            return;
        }
        Hawk.delete(BaseHawk.SITE_ATTENDANCE_PEOPLE);
        Hawk.put(BaseHawk.SITE_ATTENDANCE_PEOPLE, baseResponse.getData());
    }

    @Override // com.yd.android_brand_mvp.view.HomeView
    public void getDominateLevelSuccess(BaseResponse<List<DominateDetailLevelBean>> baseResponse) {
        int i = 0;
        LogUtils.i("获取霸屏类型列表 = " + GsonUtils.toJson(baseResponse));
        if (baseResponse.getCode() == 0) {
            this.screenTypeList = true;
            if (baseResponse.getData() != null) {
                List<DominateDetailLevelBean> data = baseResponse.getData();
                long schoolId = 0;
                if (!baseResponse.getData().isEmpty()) {
                    int duration = data.get(0).getDuration();
                    schoolId = data.get(0).getSchoolId();
                    i = duration;
                }
                MMKVUtil.INSTANCE.saveDominateLevel(GsonUtils.toJson(new WebSocketDominateParamBean(data, i, schoolId)));
                parseDominateInfo();
                MinaEventManager.getInstance().notifyObserver(MinaConstants.CODE_DOMINATE_LEVEL1);
            }
        }
    }

    @Override // com.yd.android_brand_mvp.view.HomeView
    public void getHomeNoticeSuccess(BaseResponse<MessageCaptionBean> baseResponse) {
        if (baseResponse.getCode() == 0) {
            String string = MMKV.defaultMMKV().getString(MMKVConstant.HOME_MARQUEE_TEXT, "");
            String json = GsonUtils.toJson(baseResponse.getData());
            LogUtils.d("字幕缓存数据 = " + string);
            LogUtils.d("字幕新数据 = " + json);
            LogUtils.d("字幕数据对比是否相等 = " + json.equals(string));
            MessageCaptionBean messageCaptionBean = (MessageCaptionBean) GsonUtils.fromJson(string, MessageCaptionBean.class);
            MessageCaptionBean data = baseResponse.getData();
            if (data == null) {
                return;
            }
            if (messageCaptionBean == null || TextUtils.isEmpty(messageCaptionBean.getId()) || !messageCaptionBean.getId().equals(data.getId()) || !messageCaptionBean.isPlaySuccess()) {
                MMKV.defaultMMKV().putString(MMKVConstant.HOME_MARQUEE_TEXT, json);
                MinaEventManager.getInstance().notifyObserver(MinaConstants.NOTICE_SUBTITLE);
                if (LayoutUtils.INSTANCE.isLayoutExist("hbtjcustom8x5")) {
                    return;
                }
                setTipMarqueeText(data);
            }
        }
    }

    private void getStudentMsg(String str, final long j, int i) {
        final String strValueOf = String.valueOf(j);
        HashMap map = new HashMap();
        map.put("To_Account", strValueOf);
        this.mOkHttpClient.newCall(new Request.Builder().url("https://console.tim.qq.com/v4/openim/get_c2c_unread_msg_num?" + str).post(RequestBody.create(MediaType.parse("application/json; charset=utf-8"), JSON.toJSONString((Object) map, true))).build()).enqueue(new Callback() { // from class: com.yd.android_brand_mvp.MainActivity.19
            @Override // okhttp3.Callback
            public void onFailure(Call call, IOException iOException) {
                Log.e(MainActivity.this.TAG, "getStudentMsg onFailure: " + iOException.toString());
                StudentMsgBean.Data0 data0 = new StudentMsgBean.Data0();
                data0.id = j;
                data0.msgNum = 0;
                MainActivity.this.list.add(data0);
                Log.e(MainActivity.this.TAG, "list.size: " + MainActivity.this.list.size());
                MainActivity.access$1108(MainActivity.this);
                if (MainActivity.this.list.size() >= SpData.getAllStudents().data.size()) {
                    StudentMsgBean studentMsgBean = new StudentMsgBean();
                    new ArrayList();
                    studentMsgBean.data = MainActivity.this.list;
                    MainActivity.this.setAutoScrollData(ClassStudentMsg.getInstance().getStudentMsg(studentMsgBean));
                    return;
                }
                MainActivity.this.setStudentMsg();
            }

            @Override // okhttp3.Callback
            public void onResponse(Call call, Response response) throws IOException {
                String strString = response.body().string();
                Log.i(MainActivity.this.TAG, "getStudentMsg data: " + strString + " 学生ID = " + strValueOf);
                UnreadMsgNum unreadMsgNum = (UnreadMsgNum) JSON.parseObject(strString, UnreadMsgNum.class);
                if ("sdkappid and RESTful API is blocked by quota".equals(unreadMsgNum.errorInfo)) {
                    Log.e(MainActivity.this.TAG, "腾讯API配额不够");
                }
                if ("OK".equals(unreadMsgNum.actionStatus)) {
                    StudentMsgBean.Data0 data0 = new StudentMsgBean.Data0();
                    data0.id = j;
                    data0.msgNum = unreadMsgNum.allC2CUnreadMsgNum;
                    MainActivity.this.list.add(data0);
                } else {
                    StudentMsgBean.Data0 data1 = new StudentMsgBean.Data0();
                    data1.id = j;
                    data1.msgNum = 0;
                    MainActivity.this.list.add(data1);
                }
                MainActivity.access$1108(MainActivity.this);
                AllstudentRsp allStudents = SpData.getAllStudents();
                if (allStudents == null || allStudents.data == null) {
                    return;
                }
                if (MainActivity.this.list.size() >= allStudents.data.size()) {
                    StudentMsgBean studentMsgBean = new StudentMsgBean();
                    studentMsgBean.data = MainActivity.this.list;
                    MainActivity.this.setAutoScrollData(ClassStudentMsg.getInstance().getStudentMsg(studentMsgBean));
                    return;
                }
                MainActivity.this.setStudentMsg();
            }
        });
    }

    @OnClick({R.id.layout_setting, R.id.weatherlayout, R.id.img_set, R.id.xx, R.id.lock, R.id.logo, R.id.ivTiming, R.id.ivBlank})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.img_set /* 2131362850 */:
                startActivity(new Intent(this.mActivity, (Class<?>) TeacherCheackActivity.class));
                setBtnEnable(false);
                break;
            case R.id.ivBlank /* 2131362886 */:
                new BrandConfigDialog(this.mActivity, R.style.shareDialog).show();
                break;
            case R.id.ivTiming /* 2131362909 */:
                new TimeDialog(this.mActivity, "").show();
                break;
            case R.id.layout_setting /* 2131363108 */:
                if (this.imgSet.isShown()) {
                    startActivity(new Intent(this.mActivity, (Class<?>) TeacherCheackActivity.class));
                } else {
                    this.imgSet.setVisibility(0);
                    this.vsname.setVisibility(0);
                    this.setHandler.postDelayed(new Runnable() { // from class: com.yd.android_brand_mvp.-$$Lambda$MainActivity$zQK1oCJ-6TJkOJOjOHzIsi2bmLs
                        @Override // java.lang.Runnable
                        public final void run() {
                            this.f$0.lambda$onViewClicked$22$MainActivity();
                        }
                    }, 30000L);
                }
                break;
            case R.id.logo /* 2131363272 */:
                goActivity(SchoolInfoActivity.class);
                break;
            case R.id.weatherlayout /* 2131365022 */:
                new WeatherDiallog(this).show();
                break;
            case R.id.xx /* 2131365056 */:
                startActivity(new Intent(this, (Class<?>) StudentCheackActivity.class));
                setBtnEnable(false);
                break;
        }
    }

    public /* synthetic */ void lambda$onViewClicked$22$MainActivity() {
        this.vsname.setVisibility(8);
        this.imgSet.setVisibility(8);
    }

    void setBtnEnable(boolean z) {
        if (ClassCardPermisson.getInstance().Cheack("刷卡验证")) {
            this.imgSet.setEnabled(z);
            this.xx.setEnabled(z);
            this.wifi.setEnabled(z);
        } else {
            if (z) {
                this.handler.postDelayed(this.btnRunnable, ExoPlayer.DEFAULT_DETACH_SURFACE_TIMEOUT_MS);
                return;
            }
            this.imgSet.setEnabled(z);
            this.xx.setEnabled(z);
            this.wifi.setEnabled(z);
        }
    }

    @Override // com.yd.android_brand_mvp.base.BaseActivity, com.yd.android_brand_mvp.observer.NetWorkStaus
    public void getWork(boolean z) {
        super.getWork(z);
        if (!z) {
            this.wifi.setImageResource(R.drawable.wifi_false);
            return;
        }
        NetworkInfo networkAvailableTypeName = Tool.getNetworkAvailableTypeName(this);
        if (networkAvailableTypeName == null) {
            this.wifi.setImageResource(R.drawable.wifi_false);
            return;
        }
        String typeName = networkAvailableTypeName.getTypeName();
        if (!TextUtils.isEmpty(typeName) && "Ethernet".equals(typeName)) {
            this.wifi.setImageResource(R.drawable.network_intneter);
        } else {
            this.wifi.setImageResource(getWifiDrawableByLevel(Tool.obtainWifiInfo(this)));
        }
    }

    @Override // com.yd.android_brand_mvp.base.BaseActivity, com.yd.android_brand_mvp.utils.view.net.NetworkChangeReceiver.NetStateChangeObserver
    public void onMobileConnect() {
        if (TextUtils.isEmpty(this.mfirstFile)) {
            return;
        }
        download(this.mfirstFile);
    }

    @Override // com.yd.android_brand_mvp.base.BaseActivity, com.yd.android_brand_mvp.utils.view.net.NetworkChangeReceiver.NetStateChangeObserver
    public void onWifiConnect() {
        Log.d(this.TAG, "onWifiConnect");
        networkRequest();
    }

    @Override // com.yd.android_brand_mvp.base.BaseActivity, com.yd.android_brand_mvp.utils.view.net.NetworkChangeReceiver.NetStateChangeObserver
    public void onReticleConnect() {
        Log.d(this.TAG, "onReticleConnect");
        networkRequest();
    }

    private void networkRequest() {
        if (!TextUtils.isEmpty(this.mfirstFile)) {
            download(this.mfirstFile);
        }
        ((HomePresenter) this.mvpPresenter).getToken();
        ((HomePresenter) this.mvpPresenter).getSystemSig();
        ((HomePresenter) this.mvpPresenter).getSiteKB(SpData.getSiteId());
        ((HomePresenter) this.mvpPresenter).getCDKB(SpData.getClassesId());
        ((HomePresenter) this.mvpPresenter).getKB(SpData.getClassesId());
        ((HomePresenter) this.mvpPresenter).allStudents(SpData.getClassesId());
        ((HomePresenter) this.mvpPresenter).Attencelist();
        ((HomePresenter) this.mvpPresenter).remind();
        this.viewModel.getNotUploadReservationSignData();
        ((HomePresenter) this.mvpPresenter).requestDominateLevel();
        this.viewModel.getCustomDominateData();
        this.viewModel.getDeviceConfig();
        MinaEventManager.getInstance().notifyObserver(BaseConstant.CCTV);
        MinaEventManager.getInstance().notifyObserver(MinaConstants.CODE_ATTENCE);
        MinaEventManager.getInstance().notifyObserver(MinaConstants.netWork);
        MinaEventManager.getInstance().notifyObserver(MinaConstants.Notice);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void postData() {
        AttendanceUtils.INSTANCE.pushAttendanceSubmit(this, new AttendanceUtils.OnPushAttendanceData() { // from class: com.yd.android_brand_mvp.MainActivity.20
            @Override // com.yd.android_brand_mvp.utils.AttendanceUtils.OnPushAttendanceData
            public void callbackData(List<PostAttenceBean> list) {
                ((HomePresenter) MainActivity.this.mvpPresenter).attendance3(list);
            }
        });
    }

    void setStudentMsg() {
        AllstudentRsp allStudents = SpData.getAllStudents();
        if (allStudents == null || allStudents.data == null || allStudents.data.size() <= 0) {
            return;
        }
        if (this.index <= allStudents.data.size() - 1) {
            getStudentMsg(this.imSign, allStudents.data.get(this.index).id, allStudents.data.size());
            return;
        }
        this.msgTimes = System.currentTimeMillis();
        Log.e(this.TAG, "setStudentMsg: " + this.index);
        Log.e(this.TAG, "bean.data.size: " + allStudents.data.size());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void stopAllVoice() {
        this.Voicing = false;
        this.BGMing = false;
        this.playCount = 0;
        releaseLocalMediaPlayer();
        releaseOnlineMediaPlayer();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    public void setupLocalMediaPlayer(final String str) {
        releaseLocalMediaPlayer();
        Log.i(this.TAG, "voiceNative：" + str + " VoiceNum = " + this.VoiceNum + " Voicing = " + this.Voicing + " BGMing =" + this.BGMing);
        byte b = -1;
        try {
            switch (str.hashCode()) {
                case 49:
                    if (str.equals("1")) {
                        b = 0;
                    }
                    break;
                case 50:
                    if (str.equals("2")) {
                        b = 1;
                    }
                    break;
                case 51:
                    if (str.equals("3")) {
                        b = 2;
                    }
                    break;
                case 52:
                    if (str.equals("4")) {
                        b = 3;
                    }
                    break;
                case 53:
                    if (str.equals(ConversionUtil.conditionWithSeriesName)) {
                        b = 4;
                    }
                    break;
                case 54:
                    if (str.equals(ConversionUtil.conditionWithCallNumber)) {
                        b = 5;
                    }
                    break;
            }
            if (b == 0) {
                this.localMediaPlayer = MediaPlayer.create(this, R.raw.up);
            } else if (b == 1) {
                this.localMediaPlayer = MediaPlayer.create(this, R.raw.down);
            } else if (b == 2) {
                this.localMediaPlayer = MediaPlayer.create(this, R.raw.qc);
            } else if (b == 3) {
                this.localMediaPlayer = MediaPlayer.create(this, R.raw.sleep);
            } else if (b == 4) {
                this.localMediaPlayer = MediaPlayer.create(this, R.raw.wx1);
            } else if (b == 5) {
                this.localMediaPlayer = MediaPlayer.create(this, R.raw.wx2);
            }
            if (this.localMediaPlayer != null) {
                this.localMediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() { // from class: com.yd.android_brand_mvp.MainActivity.21
                    @Override // android.media.MediaPlayer.OnCompletionListener
                    public void onCompletion(MediaPlayer mediaPlayer) {
                        MainActivity.access$1508(MainActivity.this);
                        Log.i(MainActivity.this.TAG, "onCompletion：" + MainActivity.this.playCount);
                        if (MainActivity.this.playCount < MainActivity.this.VoiceNum) {
                            Log.i(MainActivity.this.TAG, "playCount 重播");
                            MainActivity.this.setupLocalMediaPlayer(str);
                        } else {
                            MainActivity.this.Voicing = false;
                            MainActivity.this.releaseLocalMediaPlayer();
                            MainActivity mainActivity = MainActivity.this;
                            mainActivity.setupOnlineMediaPlayer(mainActivity.musicUrl);
                        }
                    }
                });
                this.localMediaPlayer.setOnErrorListener(new MediaPlayer.OnErrorListener() { // from class: com.yd.android_brand_mvp.MainActivity.22
                    @Override // android.media.MediaPlayer.OnErrorListener
                    public boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
                        MainActivity.this.Voicing = false;
                        Log.i(MainActivity.this.TAG, "localMediaPlayer：播放异常 what=" + i + " extra = " + i2);
                        MainActivity.this.releaseLocalMediaPlayer();
                        return false;
                    }
                });
                this.localMediaPlayer.start();
                this.Voicing = true;
            }
        } catch (Exception e) {
            this.Voicing = false;
            LogUtils.i("voiceNative exception：" + e.getMessage());
            e.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void releaseLocalMediaPlayer() {
        MediaPlayer mediaPlayer = this.localMediaPlayer;
        if (mediaPlayer != null) {
            mediaPlayer.stop();
            this.localMediaPlayer.release();
            this.localMediaPlayer = null;
        }
    }

    private void releaseOnlineMediaPlayer() {
        MediaPlayer mediaPlayer = this.onlineMediaPlayer;
        if (mediaPlayer != null) {
            mediaPlayer.stop();
            this.onlineMediaPlayer.release();
            this.onlineMediaPlayer = null;
        }
    }

    public void setupOnlineMediaPlayer(String str) {
        releaseOnlineMediaPlayer();
        Log.i(this.TAG, "setupOnlineMediaPlayer：播放在线音频");
        if (TextUtils.isEmpty(str)) {
            Log.i(this.TAG, "提醒播放音频地址为空");
            return;
        }
        try {
            MediaPlayer mediaPlayer = new MediaPlayer();
            this.onlineMediaPlayer = mediaPlayer;
            mediaPlayer.setDataSource(str);
            if (!this.onlineMediaPlayer.isPlaying()) {
                LogUtils.i("voiceUrl:= prepareAsync");
                this.onlineMediaPlayer.prepareAsync();
            }
            this.BGMing = true;
            this.onlineMediaPlayer.setOnPreparedListener(new MediaPlayer.OnPreparedListener() { // from class: com.yd.android_brand_mvp.-$$Lambda$MainActivity$Vf7bjgOQKP3mjQx7VeGELN4CB_8
                @Override // android.media.MediaPlayer.OnPreparedListener
                public final void onPrepared(MediaPlayer mediaPlayer2) {
                    this.f$0.lambda$setupOnlineMediaPlayer$23$MainActivity(mediaPlayer2);
                }
            });
            this.onlineMediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() { // from class: com.yd.android_brand_mvp.-$$Lambda$MainActivity$sX3BngzsWyIdLVyBidIQ-OF8TgI
                @Override // android.media.MediaPlayer.OnCompletionListener
                public final void onCompletion(MediaPlayer mediaPlayer2) {
                    this.f$0.lambda$setupOnlineMediaPlayer$24$MainActivity(mediaPlayer2);
                }
            });
            this.onlineMediaPlayer.setOnErrorListener(new MediaPlayer.OnErrorListener() { // from class: com.yd.android_brand_mvp.-$$Lambda$MainActivity$D5x5ID6YNa9UZxnu-n3RGbFFCqk
                @Override // android.media.MediaPlayer.OnErrorListener
                public final boolean onError(MediaPlayer mediaPlayer2, int i, int i2) {
                    return this.f$0.lambda$setupOnlineMediaPlayer$25$MainActivity(mediaPlayer2, i, i2);
                }
            });
        } catch (Exception e) {
            this.BGMing = false;
            LogUtils.i(this.TAG, "playMedia Exception=" + e.getMessage());
            e.printStackTrace();
        }
    }

    public /* synthetic */ void lambda$setupOnlineMediaPlayer$23$MainActivity(MediaPlayer mediaPlayer) {
        LogUtils.i("voiceUrl:= setOnPreparedListener");
        if (this.onlineMediaPlayer != null) {
            Log.e(this.TAG, "voiceUrl:= start");
            this.onlineMediaPlayer.start();
        }
    }

    public /* synthetic */ void lambda$setupOnlineMediaPlayer$24$MainActivity(MediaPlayer mediaPlayer) {
        LogUtils.i("voiceUrl:= setOnCompletionListener");
        this.BGMing = false;
    }

    public /* synthetic */ boolean lambda$setupOnlineMediaPlayer$25$MainActivity(MediaPlayer mediaPlayer, int i, int i2) {
        LogUtils.e("playMedia onError what=" + i + ",extra=" + i2);
        this.BGMing = false;
        return false;
    }

    private File getDir() {
        File file = this.dir;
        if (file != null && file.exists()) {
            return this.dir;
        }
        File file2 = new File(getExternalCacheDir(), "download");
        this.dir = file2;
        if (!file2.exists()) {
            this.dir.mkdirs();
        }
        return this.dir;
    }

    private void initData() {
        if (BaseConstant.RRKJ) {
            this.firstFile = new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS), "6.0YideBp.apk");
            Log.d(this.TAG, "initData: " + this.firstFile.getAbsolutePath());
        } else {
            this.firstFile = new File(getDir(), "6.0YideBp.apk");
        }
        this.mDownloadHelper = DownloadHelper.getInstance();
    }

    void download(String str) {
        this.mDownloadHelper.addTask(str, this.firstFile, FIRST_ACTION).submit(this);
        this.mfirstFile = str;
    }

    private void deleteAllFile() {
        File file = this.firstFile;
        if (file == null || !file.exists()) {
            return;
        }
        this.firstFile.delete();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateTextview(TextView textView, FileInfo fileInfo) {
        int downloadLocation = (int) (((float) ((fileInfo.getDownloadLocation() * 1.0d) / fileInfo.getSize())) * 100.0f);
        textView.setVisibility(0);
        textView.setText(downloadLocation + "%\n更新中");
        this.isDonwLoad = true;
        if (fileInfo.getDownloadStatus() == 46 && this.isDonwLoad) {
            textView.setText("100%\n更新中");
            textView.setVisibility(8);
            BroCast.InstallAPK(this, this.firstFile);
        }
    }

    void setApkData(final getNewestVersionRsp getnewestversionrsp) {
        if (AppUtils.getAppVersionName().compareTo(getnewestversionrsp.data.versionCode) < 0) {
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
                download(getnewestversionrsp.data.filePath);
                return;
            }
            final UpdataInfoDiallog updataInfoDiallog = new UpdataInfoDiallog(this.mActivity, getnewestversionrsp.data.versionCode + "");
            updataInfoDiallog.setonclickListener(new UpdataInfoDiallog.OnclickListener() { // from class: com.yd.android_brand_mvp.-$$Lambda$MainActivity$2Bg1O-AUcKsgUb1KYl4C9mSm-BM
                @Override // com.yd.android_brand_mvp.dialog.UpdataInfoDiallog.OnclickListener
                public final void onclick() {
                    this.f$0.lambda$setApkData$26$MainActivity(getnewestversionrsp, updataInfoDiallog);
                }
            });
            updataInfoDiallog.show();
            return;
        }
        ToastUtil.showBottomView(this.mActivity, "已是最新版本");
    }

    public /* synthetic */ void lambda$setApkData$26$MainActivity(getNewestVersionRsp getnewestversionrsp, UpdataInfoDiallog updataInfoDiallog) {
        download(getnewestversionrsp.data.filePath);
        updataInfoDiallog.cancel();
    }

    @Override // com.yd.android_brand_mvp.mqtt.MQTTClient.OnMessageCallBack
    public void onMessage(MQTTEventBean mQTTEventBean) {
        if (mQTTEventBean == null) {
            return;
        }
        String eventCode = mQTTEventBean.getEventCode();
        Log.i(this.TAG, eventCode);
        if (MQTTConstant.FACE_ADD.equals(eventCode)) {
            FaceManager.INSTANCE.faceSynchronization(this);
            return;
        }
        if (MQTTConstant.FACE_DEL.equals(eventCode)) {
            List<FaceSyncBean> list = (List) GsonUtils.fromJson(mQTTEventBean.getParam(), new TypeReference<List<FaceSyncBean>>() { // from class: com.yd.android_brand_mvp.MainActivity.23
            }.getType());
            if (list == null || list.isEmpty()) {
                return;
            }
            for (FaceSyncBean faceSyncBean : list) {
                if (faceSyncBean != null && !TextUtils.isEmpty(faceSyncBean.getUserId())) {
                    FaceManager.INSTANCE.faceQueueProcessDel(this, faceSyncBean);
                }
            }
            return;
        }
        if (MQTTConstant.FACE_ClEAR_ALL.equals(eventCode)) {
            FaceManager.INSTANCE.clearAllFace(this, null);
            LogUtils.i("FaceManager.clearAllFace 清空人脸库");
            MQTTClient.INSTANCE.publishSuccess(mQTTEventBean.getId(), "清空人脸库");
        } else if (MQTTConstant.SYSTEM_LOG_OPEN.equals(eventCode)) {
            LogUtils.i("Android 系统日志 开");
            BroCast.execRootCmd(this, "setprop persist.sys.cat_log 1", true);
        } else if (MQTTConstant.SYSTEM_LOG_CLOSE.equals(eventCode)) {
            LogUtils.i("Android 系统日志 关");
            BroCast.execRootCmd(this, "setprop persist.sys.cat_log 0", true);
        } else if (MQTTConstant.SYSTEM_LOG_EXTRACT.equals(eventCode)) {
            LogUtils.i("提取 Android 系统日志 log_save");
            uploadAppLog();
        } else if (MQTTConstant.DEVICE_SHUTDOWN.equals(eventCode) || WebSocketEventBean.CODE_TURN_OFF.equals(eventCode)) {
            LogUtils.i("设备关机");
            MQTTClient.INSTANCE.publishSuccess(mQTTEventBean.getId(), "成功");
            new Handler().postDelayed(new Runnable() { // from class: com.yd.android_brand_mvp.-$$Lambda$MainActivity$Kz2XxcyX2TcUQ2EPC90bLy-l4EM
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$onMessage$27$MainActivity();
                }
            }, 1000L);
        } else if (MQTTConstant.DEVICE_REBOOT.equals(eventCode) || WebSocketEventBean.CODE_RESTART.equals(eventCode)) {
            LogUtils.d("设备重启");
            MQTTClient.INSTANCE.publishSuccess(mQTTEventBean.getId(), "成功");
            new Handler().postDelayed(new Runnable() { // from class: com.yd.android_brand_mvp.-$$Lambda$MainActivity$VhOyuxKO80_a-Q60W8az9ukXXFM
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$onMessage$28$MainActivity();
                }
            }, 1000L);
        } else if (MQTTConstant.SYSTEM_ADB_SHELL.equals(eventCode)) {
            LogUtils.d("执行命令 ADB shell " + mQTTEventBean.getParam());
            AdbShellBean adbShellBean = (AdbShellBean) GsonUtils.fromJson(mQTTEventBean.getParam(), AdbShellBean.class);
            BroCast.exe_cmd(this, adbShellBean.getShellargs(), adbShellBean.isReboot());
        } else if (MQTTConstant.HomeLayout.equals(eventCode)) {
            ((HomePresenter) this.mvpPresenter).layoutList(SpData.getBrandId());
        } else if ("1312".equals(eventCode)) {
            ((HomePresenter) this.mvpPresenter).switchlist();
        } else if (MQTTConstant.ATTENCE.equals(eventCode)) {
            ((HomePresenter) this.mvpPresenter).Attencelist();
        } else if ("1309".equals(eventCode)) {
            ((HomePresenter) this.mvpPresenter).remind();
        } else if ("1212".equals(eventCode)) {
            updateVersion();
        } else if ("1313".equals(eventCode) || MQTTConstant.Notice.equals(eventCode)) {
            this.screenTypeList = false;
            this.screenDataList = false;
            ((HomePresenter) this.mvpPresenter).getMessageDominateList();
            ((HomePresenter) this.mvpPresenter).getHomeCaptionsNoticeInfo();
        } else if (MQTTConstant.Table.equals(eventCode)) {
            ((HomePresenter) this.mvpPresenter).getCDKB(SpData.getClassesId());
            ((HomePresenter) this.mvpPresenter).getKB(SpData.getClassesId());
            if (!TextUtils.isEmpty(SpData.getSiteId())) {
                ((HomePresenter) this.mvpPresenter).getSiteKB(SpData.getSiteId());
            }
        } else if (MQTTConstant.CLASS_CUTOVER_LOGIN.equals(eventCode)) {
            SPUtils.getInstance().remove(SpData.NEWCLASSINFO);
            MQTTClient.INSTANCE.publishSuccess(mQTTEventBean.getId(), "成功");
            ActivityTool.relaunchApp(true, this);
        } else if (MQTTConstant.SchoolUpdateInfo.equals(eventCode)) {
            ((HomePresenter) this.mvpPresenter).SchoolStyle();
        } else if (MQTTConstant.CODE_EXAM.equals(eventCode)) {
            this.viewModel.getHomeExamListData();
        } else if (MQTTConstant.CODE_RESERVE.equals(eventCode)) {
            this.viewModel.getTodayReservationList(SpData.getSiteId());
        } else if ("1701".equals(eventCode) || MQTTConstant.CODE_DOMINATE_CUSTOM.equals(eventCode)) {
            ((HomePresenter) this.mvpPresenter).requestDominateLevel();
            this.viewModel.getCustomDominateData();
        } else if (MQTTConstant.WEB_10000.equals(eventCode)) {
            Base64Utils.INSTANCE.imageToBase64(ActivityUtils.getTopActivity());
        }
        if (eventCode == null || TextUtils.isEmpty(eventCode) || !NumberUtils.isNumeric(eventCode)) {
            return;
        }
        MinaEventManager.getInstance().notifyObserver(Integer.parseInt(eventCode));
        MQTTClient.INSTANCE.publishSuccess(mQTTEventBean.getId(), "成功");
    }

    public /* synthetic */ void lambda$onMessage$27$MainActivity() {
        BroCast.shutdown(this);
    }

    public /* synthetic */ void lambda$onMessage$28$MainActivity() {
        BroCast.reboot(this);
    }

    private static class MyHandler extends Handler {
        private final WeakReference<MainActivity> mWeakReference;

        public MyHandler(MainActivity mainActivity) {
            this.mWeakReference = new WeakReference<>(mainActivity);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            super.handleMessage(message);
            switch (message.what) {
                case 102:
                    if (this.mWeakReference.get() != null && BrandConfig.brandModelEnum != BrandModelEnum.SEEWO_SK03C_D && BrandConfig.brandModelEnum != BrandModelEnum.SEEWO_SK05 && BrandConfig.brandModelEnum != BrandModelEnum.SEEWO_SK06C_BON072A_E) {
                        this.mWeakReference.get().tipCountdownView.setVisibility(0);
                        this.mWeakReference.get().tvTipCountdown.setText(String.format("班牌将在%s秒后自动关机", message.obj));
                        break;
                    }
                    break;
                case 103:
                    if (this.mWeakReference.get() != null) {
                        this.mWeakReference.get().tipCountdownView.setVisibility(8);
                    }
                    break;
                case 104:
                    if (this.mWeakReference.get() != null) {
                        this.mWeakReference.get().tipMarqueeView.setVisibility(8);
                    }
                    break;
            }
        }
    }
}
