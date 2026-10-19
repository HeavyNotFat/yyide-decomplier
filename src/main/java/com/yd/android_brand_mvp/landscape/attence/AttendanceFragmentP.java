package com.yd.android_brand_mvp.landscape.attence;

import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
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
import com.alibaba.fastjson.JSON;
import com.blankj.utilcode.util.SPUtils;
import com.google.android.exoplayer2.ExoPlayer;
import com.lxj.xpopup.XPopup;
import com.orhanobut.hawk.Hawk;
import com.yd.android_brand_mvp.R;
import com.yd.android_brand_mvp.adapter.HasClockAdapter;
import com.yd.android_brand_mvp.adapter.attence.CardFragment2;
import com.yd.android_brand_mvp.adapter.attence.RuleUtils;
import com.yd.android_brand_mvp.base.BaseHawk;
import com.yd.android_brand_mvp.base.BaseMvpFragment;
import com.yd.android_brand_mvp.base.MinaConstants;
import com.yd.android_brand_mvp.db.Attendance;
import com.yd.android_brand_mvp.db.DataBaseInstance;
import com.yd.android_brand_mvp.db.User;
import com.yd.android_brand_mvp.db.UserDao;
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
import java.util.Iterator;
import java.util.List;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;
import skin.support.content.res.SkinCompatResources;

/* JADX INFO: loaded from: classes4.dex */
public class AttendanceFragmentP extends BaseMvpFragment<AttcencesPresenter> implements AttencesView {
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

    @BindView(R.id.tv_swiping_card)
    TextView tvcard;

    @BindView(R.id.tv_human_face)
    TextView tvface;
    Unbinder unbinder;
    List<Attendance> listdata = new ArrayList();
    public List<Attendance> listOnline = new ArrayList();
    public boolean isPost = false;
    List<AttenceNewListBean.DataDTO> mListDTO = new ArrayList();
    public Handler handler = new Handler() { // from class: com.yd.android_brand_mvp.landscape.attence.AttendanceFragmentP.1
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            super.handleMessage(message);
            AttendanceFragmentP.this.getDataOffLine();
            AttendanceFragmentP attendanceFragmentP = AttendanceFragmentP.this;
            attendanceFragmentP.setAttendanceData(attendanceFragmentP.listOnline, AttendanceFragmentP.this.listdata);
        }
    };
    Handler handler2 = new Handler() { // from class: com.yd.android_brand_mvp.landscape.attence.AttendanceFragmentP.2
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            int i = message.what;
            if (i == 0) {
                AttendanceFragmentP.this.list = (List) message.obj;
                new XPopup.Builder(AttendanceFragmentP.this.mActivity).asCustom(new AttenceExcPopup(AttendanceFragmentP.this.mActivity, AttendanceFragmentP.this.list, AttendanceFragmentP.this.title)).show();
                AttendanceFragmentP.this.nomalLoadingDiallog.dismiss();
            } else if (i == 1) {
                AttendanceFragmentP attendanceFragmentP = AttendanceFragmentP.this;
                attendanceFragmentP.setAttendanceData(attendanceFragmentP.listOnline, AttendanceFragmentP.this.listdata);
            }
            super.handleMessage(message);
        }
    };
    List<User> listAll = new ArrayList();
    Runnable runnable = new Runnable() { // from class: com.yd.android_brand_mvp.landscape.attence.-$$Lambda$AttendanceFragmentP$NNz3b7v8ejE33F135Xsoxo8epzk
        @Override // java.lang.Runnable
        public final void run() {
            this.f$0.lambda$new$0$AttendanceFragmentP();
        }
    };

    @Override // com.yd.android_brand_mvp.view.AttencesView
    public void getAttenceListSuccess(AttenceListBean attenceListBean) {
    }

    @Override // com.yd.android_brand_mvp.view.AttencesView
    public void getToadyAttenceListFails(String str) {
    }

    @Override // com.yd.android_brand_mvp.view.AttencesView
    public void getToadyAttenceListSuccess(KBRsp2 kBRsp2) {
    }

    void setAttendanceData(List<Attendance> list, List<Attendance> list2) {
        ArrayList arrayList = new ArrayList(list);
        long jCurrentTimeMillis = System.currentTimeMillis();
        for (Attendance attendance : list2) {
            if (jCurrentTimeMillis - attendance.getcreatedDateTime() <= 1800000) {
                arrayList.add(attendance);
            }
        }
        this.mu.setViewState(arrayList.size() == 0 ? 2 : 0);
        Sort.sort(arrayList, "getcreatedDateTime", "desc");
        Log.e("TAG", "setAttcenData: " + JSON.toJSONString(arrayList));
        this.hasClockAdapter.setList(arrayList);
        MinaEventManager.getInstance().notifyObserver(MinaConstants.PostFace);
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View viewInflate = layoutInflater.inflate(R.layout.fragment_attence_p, viewGroup, false);
        this.unbinder = ButterKnife.bind(this, viewInflate);
        return viewInflate;
    }

    @Override // com.yd.android_brand_mvp.base.BaseMvpFragment, com.yd.android_brand_mvp.base.BaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        EventBus.getDefault().register(this);
        initView();
        this.attenceActivity = (AttenceActivity) getActivity();
        setFragment(0);
        getDataOffLine();
        KBRsp2.DataDTO.TimetableListDTO timetableListDTOIsTable = RuleUtils.getInstance().isTable();
        List<String> attendanceIds = RuleUtils.getInstance().getAttendanceIds();
        if (timetableListDTOIsTable == null && attendanceIds.size() == 0) {
            this.mu1.setViewState(2);
        } else {
            getAttenceCache();
        }
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
        int i2 = R.drawable.bg_black20_stroke_f;
        textView.setBackgroundResource(i == 1 ? R.drawable.bg_black20_stroke_f : R.drawable.bg_black20_stroke_d);
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
            setofflineData();
        }
    }

    @Override // com.yd.android_brand_mvp.base.BaseFragment, com.yd.android_brand_mvp.observer.MinaListener
    public void UpdataEvent(int i) {
        super.UpdataEvent(i);
        if (i == MinaConstants.CODE_UPDATA_ATTENCE_LIST) {
            ((AttcencesPresenter) this.mvpPresenter).getAttencelist(SpData.getClassesId() + "");
        }
    }

    void initView() {
        ((AttcencesPresenter) this.mvpPresenter).getAttencelist("");
        this.hasClockAdapter = new HasClockAdapter(R.layout.has_clock_item);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getContext(), 5);
        gridLayoutManager.setOrientation(1);
        this.rl_has_clock.setLayoutManager(gridLayoutManager);
        this.rl_has_clock.setAdapter(this.hasClockAdapter);
        this.mAdapter = new NewAttenceAdapter(this.mActivity, this.mListDTO, R.layout.attence_item);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        linearLayoutManager.setOrientation(0);
        this.rl_attence.setLayoutManager(linearLayoutManager);
        this.rl_attence.setAdapter(this.mAdapter);
        this.mAdapter.addOnclick(new NewAttenceAdapter.Onclick() { // from class: com.yd.android_brand_mvp.landscape.attence.AttendanceFragmentP.3
            @Override // com.yd.android_brand_mvp.landscape.attence.NewAttenceAdapter.Onclick
            public void setOnAttClickListener(String str, String str2, String str3) {
                ((AttcencesPresenter) AttendanceFragmentP.this.mvpPresenter).getAttenceTodayList(str, str2, str3);
            }
        });
    }

    void setofflineData() {
        new UpdateAsyncTask2(DataBaseInstance.getInstance(this.mActivity).userDao()).execute(new UserDao[0]);
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
        new Handler().postDelayed(new Runnable() { // from class: com.yd.android_brand_mvp.landscape.attence.AttendanceFragmentP.4
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

    private class UpdateAsyncTask2 extends AsyncTask<UserDao, User, Void> {
        private UserDao toDoDao;

        UpdateAsyncTask2(UserDao userDao) {
            this.toDoDao = userDao;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        public Void doInBackground(UserDao... userDaoArr) {
            AttendanceFragmentP.this.listAll = this.toDoDao.getAll();
            AttendanceFragmentP.this.listdata.clear();
            long jCurrentTimeMillis = System.currentTimeMillis();
            for (User user : AttendanceFragmentP.this.listAll) {
                if (!AttendanceFragmentP.this.isHave(user) && jCurrentTimeMillis - TimeUtil.gettime999(user.time) <= 1800000) {
                    Attendance attendance = new Attendance();
                    attendance.peopleName = user.name;
                    attendance.type = String.valueOf(user.type);
                    attendance.path = user.photo;
                    attendance.iscard = user.isCard;
                    attendance.createdDateTime = TimeUtil.gettime999(user.time);
                    AttendanceFragmentP.this.listdata.add(attendance);
                }
            }
            Message message = new Message();
            message.what = 1;
            AttendanceFragmentP.this.handler2.sendMessage(message);
            MinaEventManager.getInstance().notifyObserver(MinaConstants.PostFace);
            return null;
        }
    }

    boolean isHave(User user) {
        Iterator<Attendance> it2 = this.listdata.iterator();
        boolean z = false;
        while (it2.hasNext()) {
            if (user.time.equals(TimeUtil.stampToDate9(it2.next().createdDateTime))) {
                z = true;
            }
        }
        return z;
    }

    void getDataOffLine() {
        new OffLineAsyncTask2(DataBaseInstance.getInstance(this.mActivity).userDao()).execute(new UserDao[0]);
    }

    private class OffLineAsyncTask2 extends AsyncTask<UserDao, User, Void> {
        private UserDao toDoDao;

        OffLineAsyncTask2(UserDao userDao) {
            this.toDoDao = userDao;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        public Void doInBackground(UserDao... userDaoArr) {
            AttendanceFragmentP.this.listAll = this.toDoDao.getAll();
            AttendanceFragmentP.this.listdata.clear();
            long jCurrentTimeMillis = System.currentTimeMillis();
            for (User user : AttendanceFragmentP.this.listAll) {
                if (!AttendanceFragmentP.this.isHave(user) && jCurrentTimeMillis - TimeUtil.gettime999(user.time) <= 1800000) {
                    Attendance attendance = new Attendance();
                    attendance.peopleName = user.name;
                    attendance.path = user.photo;
                    attendance.type = String.valueOf(user.type);
                    attendance.iscard = String.valueOf(user.isCard);
                    attendance.createdDateTime = TimeUtil.gettime999(user.time);
                    AttendanceFragmentP.this.listdata.add(attendance);
                }
            }
            return null;
        }
    }

    void setViewEnable(boolean z) {
        this.tvcard.setEnabled(z);
        this.tvface.setEnabled(z);
    }

    public /* synthetic */ void lambda$new$0$AttendanceFragmentP() {
        setViewEnable(true);
    }
}
