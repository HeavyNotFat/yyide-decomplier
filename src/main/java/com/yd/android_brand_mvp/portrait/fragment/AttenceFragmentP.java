package com.yd.android_brand_mvp.portrait.fragment;

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
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;
import com.alibaba.fastjson.JSON;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.listener.OnItemClickListener;
import com.google.android.exoplayer2.ExoPlayer;
import com.lxj.xpopup.XPopup;
import com.yd.android_brand_mvp.R;
import com.yd.android_brand_mvp.adapter.AttenceAdapter;
import com.yd.android_brand_mvp.adapter.HasClockAdapter;
import com.yd.android_brand_mvp.adapter.attence.CardFragment2;
import com.yd.android_brand_mvp.base.BaseMvpFragment;
import com.yd.android_brand_mvp.base.MinaConstants;
import com.yd.android_brand_mvp.db.Attendance;
import com.yd.android_brand_mvp.db.DataBaseInstance;
import com.yd.android_brand_mvp.db.User;
import com.yd.android_brand_mvp.db.UserDao;
import com.yd.android_brand_mvp.model.AttenceBean;
import com.yd.android_brand_mvp.model.AttenceExcBean;
import com.yd.android_brand_mvp.observer.MinaEventManager;
import com.yd.android_brand_mvp.presenter.AttcenceListPresenter;
import com.yd.android_brand_mvp.user.AttenceActivity;
import com.yd.android_brand_mvp.utils.AttenceUtil;
import com.yd.android_brand_mvp.utils.Sort;
import com.yd.android_brand_mvp.utils.SpData;
import com.yd.android_brand_mvp.utils.TimeUtil;
import com.yd.android_brand_mvp.verfity.fragment.FaceFragment2;
import com.yd.android_brand_mvp.view.AttenceListView;
import com.yd.android_brand_mvp.weight.AttenceExcPopup;
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
public class AttenceFragmentP extends BaseMvpFragment<AttcenceListPresenter> implements AttenceListView {
    AttenceActivity attenceActivity;
    AttenceAdapter attenceAdapter;
    AttenceBean attenceBean;

    @BindView(R.id.fl_layout)
    FrameLayout flLayout;
    HasClockAdapter hasClockAdapter;
    List<AttenceExcBean> list;

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
    List<AttenceBean.DataBean.StudentsBean.PeopleBean> peopleList = new ArrayList();
    List<Attendance> listdata = new ArrayList();
    public List<Attendance> listOnline = new ArrayList();
    public boolean isPost = false;
    private Handler handler = new Handler() { // from class: com.yd.android_brand_mvp.portrait.fragment.AttenceFragmentP.1
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            super.handleMessage(message);
            AttenceFragmentP.this.getDataOffLine();
            AttenceFragmentP attenceFragmentP = AttenceFragmentP.this;
            attenceFragmentP.setAttcenData(attenceFragmentP.listOnline, AttenceFragmentP.this.listdata);
        }
    };
    private Handler handler2 = new Handler() { // from class: com.yd.android_brand_mvp.portrait.fragment.AttenceFragmentP.2
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            int i = message.what;
            if (i == 0) {
                AttenceFragmentP.this.list = (List) message.obj;
                new XPopup.Builder(AttenceFragmentP.this.mActivity).asCustom(new AttenceExcPopup(AttenceFragmentP.this.mActivity, AttenceFragmentP.this.list, AttenceFragmentP.this.title)).show();
                AttenceFragmentP.this.nomalLoadingDiallog.dismiss();
            } else if (i == 1) {
                AttenceFragmentP attenceFragmentP = AttenceFragmentP.this;
                attenceFragmentP.setAttcenData(attenceFragmentP.listOnline, AttenceFragmentP.this.listdata);
            }
            super.handleMessage(message);
        }
    };
    List<User> listAll = new ArrayList();
    Runnable runnable = new Runnable() { // from class: com.yd.android_brand_mvp.portrait.fragment.AttenceFragmentP.4
        @Override // java.lang.Runnable
        public void run() {
            AttenceFragmentP.this.setViewEnable(true);
        }
    };
    Runnable postData = new Runnable() { // from class: com.yd.android_brand_mvp.portrait.fragment.AttenceFragmentP.5
        @Override // java.lang.Runnable
        public void run() {
            if (AttenceFragmentP.this.isPost) {
                MinaEventManager.getInstance().notifyObserver(MinaConstants.PostFace);
                AttenceFragmentP.this.isPost = false;
            }
            AttenceFragmentP.this.handler.postDelayed(this, 5000L);
        }
    };

    void setAttcenData(List<Attendance> list, List<Attendance> list2) {
        Log.e("TAG", "setAttcenData: " + JSON.toJSONString(list));
        Log.e("TAG", "setAttcenData: " + JSON.toJSONString(list2));
        ArrayList arrayList = new ArrayList();
        Iterator<Attendance> it2 = list.iterator();
        while (it2.hasNext()) {
            arrayList.add(it2.next());
        }
        long jCurrentTimeMillis = System.currentTimeMillis();
        for (Attendance attendance : list2) {
            if (jCurrentTimeMillis - attendance.getcreatedDateTime() <= 1800000) {
                arrayList.add(attendance);
            }
        }
        this.mu.setViewState(arrayList.size() == 0 ? 2 : 0);
        Sort.sort(arrayList, "getcreatedDateTime", "desc");
        Log.e("TAG", "newlist==>: " + JSON.toJSONString(arrayList));
        this.isPost = true;
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
        Log.e("TAG", "AttenceFragmentP: " + JSON.toJSONString("AttenceFragmentP"));
        this.handler.postDelayed(this.postData, 5000L);
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

    void initView() {
        this.hasClockAdapter = new HasClockAdapter(R.layout.has_clock_item);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getContext(), 5);
        gridLayoutManager.setOrientation(1);
        this.rl_has_clock.setLayoutManager(gridLayoutManager);
        this.rl_has_clock.setAdapter(this.hasClockAdapter);
        this.attenceAdapter = new AttenceAdapter(R.layout.attence_item);
        GridLayoutManager gridLayoutManager2 = new GridLayoutManager(getContext(), 4);
        gridLayoutManager2.setOrientation(1);
        this.rl_attence.setLayoutManager(gridLayoutManager2);
        this.rl_attence.setAdapter(this.attenceAdapter);
        this.attenceAdapter.setOnItemClickListener(new OnItemClickListener() { // from class: com.yd.android_brand_mvp.portrait.fragment.AttenceFragmentP.3
            /* JADX WARN: Type inference failed for: r1v6, types: [com.yd.android_brand_mvp.portrait.fragment.AttenceFragmentP$3$1] */
            @Override // com.chad.library.adapter.base.listener.OnItemClickListener
            public void onItemClick(BaseQuickAdapter<?, ?> baseQuickAdapter, View view, final int i) {
                if (AttenceFragmentP.this.attenceBean == null) {
                    return;
                }
                if (!AttenceFragmentP.this.mActivity.isDestroyed()) {
                    AttenceFragmentP.this.nomalLoadingDiallog.show();
                }
                new Thread() { // from class: com.yd.android_brand_mvp.portrait.fragment.AttenceFragmentP.3.1
                    @Override // java.lang.Thread, java.lang.Runnable
                    public void run() {
                        Message message = new Message();
                        message.obj = AttenceUtil.getAttenceExcBean(AttenceFragmentP.this.attenceBean.data.get(i));
                        message.what = 0;
                        AttenceFragmentP.this.title = AttenceUtil.getTitle(AttenceFragmentP.this.attenceBean.data.get(i));
                        AttenceFragmentP.this.handler2.sendMessage(message);
                    }
                }.start();
            }
        });
    }

    void setData(AttenceBean attenceBean) {
        this.peopleList = new ArrayList();
        Iterator<AttenceBean.DataBean> it2 = attenceBean.data.iterator();
        while (it2.hasNext()) {
            for (AttenceBean.DataBean.StudentsBean.PeopleBean peopleBean : it2.next().students.people) {
                if ((peopleBean != null && "0".equals(peopleBean.status)) || "2".equals(peopleBean.status) || "3".equals(peopleBean.status)) {
                    this.peopleList.add(peopleBean);
                }
            }
        }
        this.attenceAdapter.setNewData(attenceBean.data);
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
        ((AttcenceListPresenter) this.mvpPresenter).getAttencelist(SpData.getClassesId() + "");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.yd.android_brand_mvp.base.BaseMvpFragment
    public AttcenceListPresenter createPresenter() {
        return new AttcenceListPresenter(this);
    }

    @Override // com.yd.android_brand_mvp.base.BaseMvpFragment, com.yd.android_brand_mvp.base.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        Unbinder unbinder = this.unbinder;
        if (unbinder != null) {
            unbinder.unbind();
        }
        this.handler.removeCallbacks(this.runnable);
        this.handler.removeCallbacks(this.postData);
        this.handler.removeCallbacksAndMessages(null);
        EventBus.getDefault().unregister(this);
    }

    @Override // com.yd.android_brand_mvp.base.BaseMvpFragment, androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
    }

    @Override // com.yd.android_brand_mvp.view.AttenceListView
    public void getAttenceSuccess(AttenceBean attenceBean) {
        this.attenceBean = attenceBean;
        if (attenceBean == null || attenceBean.data == null || attenceBean.data.size() == 0) {
            this.mu1.setViewState(2);
            this.mu.setViewState(2);
        } else {
            this.mu1.setViewState(0);
            setData(attenceBean);
        }
    }

    @Override // com.yd.android_brand_mvp.view.AttenceListView
    public void getAttenceSuccessFail(String str) {
        Log.e("TAG", "getAttenceSuccessFail: ");
        setofflineData();
    }

    private class UpdateAsyncTask2 extends AsyncTask<UserDao, User, Void> {
        private UserDao toDoDao;

        UpdateAsyncTask2(UserDao userDao) {
            this.toDoDao = userDao;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        public Void doInBackground(UserDao... userDaoArr) {
            AttenceFragmentP.this.listAll = this.toDoDao.getAll();
            AttenceFragmentP.this.listdata.clear();
            long jCurrentTimeMillis = System.currentTimeMillis();
            for (User user : AttenceFragmentP.this.listAll) {
                if (!AttenceFragmentP.this.isHave(user) && jCurrentTimeMillis - TimeUtil.gettime999(user.time) <= 1800000) {
                    Attendance attendance = new Attendance();
                    attendance.peopleName = user.name;
                    attendance.type = String.valueOf(user.type);
                    attendance.path = user.photo;
                    attendance.iscard = user.isCard;
                    attendance.createdDateTime = TimeUtil.gettime999(user.time);
                    AttenceFragmentP.this.listdata.add(attendance);
                }
            }
            Message message = new Message();
            message.what = 1;
            AttenceFragmentP.this.handler2.sendMessage(message);
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
            AttenceFragmentP.this.listAll = this.toDoDao.getAll();
            AttenceFragmentP.this.listdata.clear();
            long jCurrentTimeMillis = System.currentTimeMillis();
            for (User user : AttenceFragmentP.this.listAll) {
                if (!AttenceFragmentP.this.isHave(user) && jCurrentTimeMillis - TimeUtil.gettime999(user.time) <= 1800000) {
                    Attendance attendance = new Attendance();
                    attendance.peopleName = user.name;
                    attendance.path = user.photo;
                    attendance.type = String.valueOf(user.type);
                    attendance.iscard = String.valueOf(user.isCard);
                    attendance.createdDateTime = TimeUtil.gettime999(user.time);
                    AttenceFragmentP.this.listdata.add(attendance);
                }
            }
            return null;
        }
    }

    void setViewEnable(boolean z) {
        this.tvcard.setEnabled(z);
        this.tvface.setEnabled(z);
    }
}
