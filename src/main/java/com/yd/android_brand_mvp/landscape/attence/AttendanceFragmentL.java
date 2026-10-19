package com.yd.android_brand_mvp.landscape.attence;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;
import com.blankj.utilcode.util.SPUtils;
import com.google.android.exoplayer2.ExoPlayer;
import com.lxj.xpopup.XPopup;
import com.orhanobut.hawk.Hawk;
import com.yd.android_brand_mvp.ClassCardPermisson;
import com.yd.android_brand_mvp.R;
import com.yd.android_brand_mvp.adapter.HasClockAdapter;
import com.yd.android_brand_mvp.adapter.attence.CardFragment2;
import com.yd.android_brand_mvp.adapter.attence.RuleUtils;
import com.yd.android_brand_mvp.base.BaseHawk;
import com.yd.android_brand_mvp.base.BaseMvpFragment;
import com.yd.android_brand_mvp.base.MinaConstants;
import com.yd.android_brand_mvp.brand.BrandConfig;
import com.yd.android_brand_mvp.db.Attendance;
import com.yd.android_brand_mvp.db.DataBaseInstance;
import com.yd.android_brand_mvp.db.User;
import com.yd.android_brand_mvp.model.AttanceTodatDetailsRsp;
import com.yd.android_brand_mvp.model.AttenceExcBean;
import com.yd.android_brand_mvp.model.AttenceListBean;
import com.yd.android_brand_mvp.model.AttenceNewListBean;
import com.yd.android_brand_mvp.model.KBRsp2;
import com.yd.android_brand_mvp.observer.MinaEventManager;
import com.yd.android_brand_mvp.presenter.AttcencesPresenter;
import com.yd.android_brand_mvp.user.AttenceActivity;
import com.yd.android_brand_mvp.utils.Sort;
import com.yd.android_brand_mvp.utils.SpData;
import com.yd.android_brand_mvp.utils.TimeUtil;
import com.yd.android_brand_mvp.utils.ToastUtil;
import com.yd.android_brand_mvp.verfity.fragment.FaceFragment2;
import com.yd.android_brand_mvp.view.AttencesView;
import com.yd.android_brand_mvp.weight.AttenceExcPopup;
import com.yd.android_brand_mvp.weight.AttencesExcPopup;
import com.yd.android_brand_mvp.weight.MultiStateView;
import com.yyide.facepass.FaceManager;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executors;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;
import skin.support.content.res.SkinCompatResources;

/* JADX INFO: loaded from: classes4.dex */
public class AttendanceFragmentL extends BaseMvpFragment<AttcencesPresenter> implements AttencesView {
    AttenceActivity attenceActivity;

    @BindView(R.id.fl_layout)
    FrameLayout flLayout;
    HasClockAdapter hasClockAdapter;
    List<AttenceExcBean> list;
    NewAttenceAdapter mAdapter;

    @BindView(R.id.mu)
    MultiStateView mu;

    @BindView(R.id.mu1)
    MultiStateView mu1;

    @BindView(R.id.rl_attence)
    RecyclerView rl_attence;

    @BindView(R.id.rl_has_clock)
    RecyclerView rl_has_clock;
    String title;

    @BindView(R.id.tvTip)
    TextView tvTip;

    @BindView(R.id.tv_swiping_card)
    TextView tvcard;

    @BindView(R.id.tv_human_face)
    TextView tvface;
    Unbinder unbinder;
    List<AttenceNewListBean.DataDTO> mListDTO = new ArrayList();
    List<Attendance> listdata = new ArrayList();
    public List<Attendance> listOnline = new ArrayList();
    public boolean isPost = false;
    public Handler handler = new Handler() { // from class: com.yd.android_brand_mvp.landscape.attence.AttendanceFragmentL.1
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            super.handleMessage(message);
            AttendanceFragmentL.this.getAttendanceData();
            AttendanceFragmentL attendanceFragmentL = AttendanceFragmentL.this;
            attendanceFragmentL.setAttendanceData(attendanceFragmentL.listOnline, AttendanceFragmentL.this.listdata);
        }
    };
    Handler handler2 = new Handler() { // from class: com.yd.android_brand_mvp.landscape.attence.AttendanceFragmentL.2
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            int i = message.what;
            if (i == 1) {
                AttendanceFragmentL attendanceFragmentL = AttendanceFragmentL.this;
                attendanceFragmentL.setAttendanceData(attendanceFragmentL.listOnline, AttendanceFragmentL.this.listdata);
            } else if (i == 2) {
                AttendanceFragmentL.this.list = (List) message.obj;
                new XPopup.Builder(AttendanceFragmentL.this.mActivity).asCustom(new AttenceExcPopup(AttendanceFragmentL.this.mActivity, AttendanceFragmentL.this.list, AttendanceFragmentL.this.title)).show();
                AttendanceFragmentL.this.nomalLoadingDiallog.dismiss();
            }
            super.handleMessage(message);
        }
    };
    private final Runnable runnable = new Runnable() { // from class: com.yd.android_brand_mvp.landscape.attence.-$$Lambda$AttendanceFragmentL$3cbIXaD6cuMKNlgxGxxu7JT6gwY
        @Override // java.lang.Runnable
        public final void run() {
            this.f$0.lambda$new$2$AttendanceFragmentL();
        }
    };

    @Override // com.yd.android_brand_mvp.view.AttencesView
    public void getAttenceListSuccess(AttenceListBean attenceListBean) {
    }

    @Override // com.yd.android_brand_mvp.view.AttencesView
    public void getToadyAttenceListSuccess(KBRsp2 kBRsp2) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setAttendanceData(List<Attendance> list, List<Attendance> list2) {
        ArrayList arrayList = new ArrayList(list);
        long jCurrentTimeMillis = System.currentTimeMillis();
        if (list2 != null && list2.size() > 0) {
            for (Attendance attendance : list2) {
                if (jCurrentTimeMillis - attendance.getcreatedDateTime() <= 1800000) {
                    arrayList.add(attendance);
                }
            }
        }
        MultiStateView multiStateView = this.mu;
        if (multiStateView != null) {
            multiStateView.setViewState(arrayList.size() == 0 ? 2 : 0);
        }
        Sort.sort(arrayList, "getcreatedDateTime", "desc");
        this.hasClockAdapter.setList(arrayList);
        this.isPost = true;
        MinaEventManager.getInstance().notifyObserver(MinaConstants.PostFace);
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View viewInflate = layoutInflater.inflate(R.layout.fragment_attence_l, viewGroup, false);
        this.unbinder = ButterKnife.bind(this, viewInflate);
        return viewInflate;
    }

    @Override // com.yd.android_brand_mvp.base.BaseMvpFragment, com.yd.android_brand_mvp.base.BaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        EventBus.getDefault().register(this);
        initView();
        this.attenceActivity = (AttenceActivity) getActivity();
        this.tvcard.setVisibility(ClassCardPermisson.getInstance().Cheack("刷卡验证") ? 0 : 8);
        this.tvface.setVisibility(ClassCardPermisson.getInstance().Cheack("人脸验证") ? 0 : 8);
        this.tvTip.setVisibility(BrandConfig.INSTANCE.isFaceMore() ? 0 : 8);
        if (ClassCardPermisson.getInstance().Cheack("人脸验证")) {
            setFragment(1);
        } else if (ClassCardPermisson.getInstance().Cheack("刷卡验证")) {
            setFragment(0);
        }
        KBRsp2.DataDTO.TimetableListDTO timetableListDTOIsTable = RuleUtils.getInstance().isTable();
        List<String> attendanceIds = RuleUtils.getInstance().getAttendanceIds();
        if (timetableListDTOIsTable == null && attendanceIds.size() == 0) {
            this.mu1.setViewState(2);
        } else {
            getAttenceCache();
        }
        ((AttcencesPresenter) this.mvpPresenter).getAttencelist("");
    }

    private void setFragment(int i) {
        this.attenceActivity.setIndex(i);
        FragmentManager childFragmentManager = getChildFragmentManager();
        FragmentTransaction fragmentTransactionBeginTransaction = childFragmentManager.beginTransaction();
        Fragment fragmentFindFragmentByTag = childFragmentManager.findFragmentByTag("0");
        Fragment fragmentFindFragmentByTag2 = childFragmentManager.findFragmentByTag("1");
        if (fragmentFindFragmentByTag != null) {
            fragmentTransactionBeginTransaction.hide(fragmentFindFragmentByTag);
        }
        if (fragmentFindFragmentByTag2 != null) {
            fragmentTransactionBeginTransaction.hide(fragmentFindFragmentByTag2);
        }
        if (i != 0 && fragmentFindFragmentByTag != null && fragmentFindFragmentByTag.isAdded()) {
            fragmentTransactionBeginTransaction.remove(fragmentFindFragmentByTag);
            ((CardFragment2) fragmentFindFragmentByTag).releaseCamera();
        }
        if (i != 1 && fragmentFindFragmentByTag2 != null && fragmentFindFragmentByTag2.isAdded()) {
            fragmentTransactionBeginTransaction.remove(fragmentFindFragmentByTag2);
            FaceManager.INSTANCE.onDestroyCamera();
        }
        if (i == 0) {
            if (fragmentFindFragmentByTag == null) {
                fragmentTransactionBeginTransaction.add(R.id.fl_layout, new CardFragment2(), "0");
            } else {
                fragmentTransactionBeginTransaction.show(fragmentFindFragmentByTag);
            }
        } else if (i == 1) {
            if (fragmentFindFragmentByTag2 == null) {
                fragmentTransactionBeginTransaction.add(R.id.fl_layout, new FaceFragment2(), "1");
            } else {
                fragmentTransactionBeginTransaction.show(fragmentFindFragmentByTag2);
            }
        }
        TextView textView = this.tvface;
        int i2 = R.drawable.bg_comment_bt_30;
        textView.setBackgroundResource(i == 1 ? R.drawable.bg_comment_bt_30 : R.drawable.bg_black20_stroke_d);
        TextView textView2 = this.tvface;
        SkinCompatResources skinCompatResources = SkinCompatResources.getInstance();
        int i3 = R.color.white;
        textView2.setTextColor(skinCompatResources.getColor(i == 1 ? R.color.white : R.color.black10));
        TextView textView3 = this.tvcard;
        if (i == 1) {
            i2 = R.drawable.bg_black20_stroke_d;
        }
        textView3.setBackgroundResource(i2);
        TextView textView4 = this.tvcard;
        SkinCompatResources skinCompatResources2 = SkinCompatResources.getInstance();
        if (i == 1) {
            i3 = R.color.black10;
        }
        textView4.setTextColor(skinCompatResources2.getColor(i3));
        fragmentTransactionBeginTransaction.commitAllowingStateLoss();
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void refresh(String str) {
        if ("db".equals(str)) {
            getAttendanceData();
        }
    }

    @Override // com.yd.android_brand_mvp.base.BaseFragment, com.yd.android_brand_mvp.observer.MinaListener
    public void UpdataEvent(int i) {
        super.UpdataEvent(i);
        if (i == MinaConstants.CODE_UPDATA_ATTENCE_LIST) {
            ((AttcencesPresenter) this.mvpPresenter).getAttencelist("");
        }
    }

    void initView() {
        this.hasClockAdapter = new HasClockAdapter(R.layout.has_clock_item);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getContext(), 7);
        gridLayoutManager.setOrientation(1);
        this.rl_has_clock.setLayoutManager(gridLayoutManager);
        this.rl_has_clock.setAdapter(this.hasClockAdapter);
        this.mAdapter = new NewAttenceAdapter(this.mActivity, this.mListDTO, R.layout.attence_item);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        linearLayoutManager.setOrientation(0);
        this.rl_attence.setLayoutManager(linearLayoutManager);
        this.rl_attence.setAdapter(this.mAdapter);
        this.mAdapter.addOnclick(new NewAttenceAdapter.Onclick() { // from class: com.yd.android_brand_mvp.landscape.attence.AttendanceFragmentL.3
            @Override // com.yd.android_brand_mvp.landscape.attence.NewAttenceAdapter.Onclick
            public void setOnAttClickListener(String str, String str2, String str3) {
                ((AttcencesPresenter) AttendanceFragmentL.this.mvpPresenter).getAttenceTodayList(str, str2, str3);
            }
        });
        getAttendanceData();
    }

    @OnClick({R.id.tv_human_face, R.id.tv_swiping_card})
    public void onClick(View view) {
        int id = view.getId();
        if (id == R.id.tv_human_face) {
            setFragment(1);
            setViewEnable(false);
            this.handler.postDelayed(this.runnable, ExoPlayer.DEFAULT_DETACH_SURFACE_TIMEOUT_MS);
        } else {
            if (id != R.id.tv_swiping_card) {
                return;
            }
            setFragment(0);
            setViewEnable(false);
            this.handler.postDelayed(this.runnable, ExoPlayer.DEFAULT_DETACH_SURFACE_TIMEOUT_MS);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        SPUtils.getInstance().put(SpData.AttenceEnable, "1");
        new Handler().postDelayed(new Runnable() { // from class: com.yd.android_brand_mvp.landscape.attence.AttendanceFragmentL.4
            @Override // java.lang.Runnable
            public void run() {
                SPUtils.getInstance().put(SpData.AttenceEnable, "2");
            }
        }, 5000L);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.yd.android_brand_mvp.base.BaseMvpFragment
    public AttcencesPresenter createPresenter() {
        return new AttcencesPresenter(this);
    }

    @Override // com.yd.android_brand_mvp.base.BaseMvpFragment, com.yd.android_brand_mvp.base.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        Unbinder unbinder = this.unbinder;
        if (unbinder != null) {
            unbinder.unbind();
        }
        this.handler.removeCallbacks(this.runnable);
        this.handler.removeCallbacksAndMessages(null);
        EventBus.getDefault().unregister(this);
    }

    @Override // com.yd.android_brand_mvp.base.BaseMvpFragment, androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
    }

    @Override // com.yd.android_brand_mvp.view.AttencesView
    public void getAttenceNewListSuccess(AttenceNewListBean attenceNewListBean) {
        if (attenceNewListBean.code == 0) {
            Hawk.put(BaseHawk.NEWATTENCE, attenceNewListBean);
            setNewData(attenceNewListBean);
        } else {
            this.mu.setViewState(2);
            ToastUtil.showView(getActivity(), attenceNewListBean.message);
        }
    }

    void setNewData(AttenceNewListBean attenceNewListBean) {
        this.mListDTO.clear();
        if (attenceNewListBean.data.size() > 0) {
            this.mu.setViewState(0);
            this.mu1.setViewState(0);
            this.mListDTO.addAll(attenceNewListBean.data);
            this.mAdapter.addCourseListDTO(this.mListDTO);
            return;
        }
        this.mu.setViewState(2);
    }

    @Override // com.yd.android_brand_mvp.view.AttencesView
    public void getToadyListSuccess(AttanceTodatDetailsRsp attanceTodatDetailsRsp) {
        if (attanceTodatDetailsRsp.code == 0) {
            new XPopup.Builder(this.mActivity).asCustom(new AttencesExcPopup(this.mActivity, AttenceUtil.getNewAttenceCourseBean(attanceTodatDetailsRsp), "")).show();
            if (getActivity().isDestroyed()) {
                return;
            }
            this.nomalLoadingDiallog.dismiss();
            return;
        }
        ToastUtil.showView(getActivity(), attanceTodatDetailsRsp.message);
    }

    @Override // com.yd.android_brand_mvp.view.AttencesView
    public void getToadyAttenceListFails(String str) {
        ToastUtil.showView(getActivity(), str);
    }

    void getAttenceCache() {
        AttenceNewListBean attenceNewListBean = (AttenceNewListBean) Hawk.get(BaseHawk.NEWATTENCE);
        if (attenceNewListBean == null || attenceNewListBean.data == null) {
            this.mu1.setViewState(2);
        } else {
            setNewData(attenceNewListBean);
        }
    }

    @Override // com.yd.android_brand_mvp.view.AttencesView
    public void getAttenceListSuccessFail(String str) {
        getAttenceCache();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void getAttendanceData() {
        Executors.newSingleThreadExecutor().execute(new Runnable() { // from class: com.yd.android_brand_mvp.landscape.attence.-$$Lambda$AttendanceFragmentL$i7dwj0REHGkpuuM73Hwx1F_3Ehw
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$getAttendanceData$1$AttendanceFragmentL();
            }
        });
    }

    public /* synthetic */ void lambda$getAttendanceData$1$AttendanceFragmentL() {
        List<User> all = DataBaseInstance.getInstance(this.mActivity).userDao().getAll();
        long jCurrentTimeMillis = System.currentTimeMillis();
        final ArrayList arrayList = new ArrayList();
        for (User user : all) {
            if (jCurrentTimeMillis - TimeUtil.gettime999(user.time) <= 1800000) {
                Attendance attendance = new Attendance();
                attendance.peopleName = user.name;
                attendance.type = user.type + "";
                attendance.path = user.photo;
                attendance.createdDateTime = TimeUtil.gettime999(user.time);
                arrayList.add(attendance);
            }
        }
        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.yd.android_brand_mvp.landscape.attence.-$$Lambda$AttendanceFragmentL$P3JYlsOT7faZIT8FsjZVDElmOQQ
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$getAttendanceData$0$AttendanceFragmentL(arrayList);
            }
        });
    }

    public /* synthetic */ void lambda$getAttendanceData$0$AttendanceFragmentL(List list) {
        this.hasClockAdapter.setList(list);
    }

    private void setViewEnable(boolean z) {
        this.tvcard.setEnabled(z);
        this.tvface.setEnabled(z);
    }

    public /* synthetic */ void lambda$new$2$AttendanceFragmentL() {
        setViewEnable(true);
        getAttendanceData();
    }
}
