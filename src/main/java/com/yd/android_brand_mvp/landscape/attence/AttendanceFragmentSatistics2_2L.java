package com.yd.android_brand_mvp.landscape.attence;

import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.fragment.app.FragmentManager;
import androidx.viewpager.widget.ViewPager;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import com.alibaba.fastjson.JSON;
import com.blankj.utilcode.util.LogUtils;
import com.blankj.utilcode.util.SPUtils;
import com.blankj.utilcode.util.ScreenUtils;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.gson.Gson;
import com.orhanobut.hawk.Hawk;
import com.yd.android_brand_mvp.R;
import com.yd.android_brand_mvp.adapter.ViewPagerFragmentAdapter;
import com.yd.android_brand_mvp.adapter.attence.RuleUtils;
import com.yd.android_brand_mvp.base.BaseHawk;
import com.yd.android_brand_mvp.base.BaseMvpFragment;
import com.yd.android_brand_mvp.base.MinaConstants;
import com.yd.android_brand_mvp.db.DataBaseInstance;
import com.yd.android_brand_mvp.db.User;
import com.yd.android_brand_mvp.db.UserDao;
import com.yd.android_brand_mvp.model.AttanceTodatDetailsRsp;
import com.yd.android_brand_mvp.model.AttenceListBean;
import com.yd.android_brand_mvp.model.AttenceNewListBean;
import com.yd.android_brand_mvp.model.AttencelistRsp;
import com.yd.android_brand_mvp.model.KBRsp2;
import com.yd.android_brand_mvp.presenter.AttcencesPresenter;
import com.yd.android_brand_mvp.user.AttenceActivity;
import com.yd.android_brand_mvp.utils.SpData;
import com.yd.android_brand_mvp.utils.view.net.GsonUtils;
import com.yd.android_brand_mvp.view.AttencesView;
import com.yd.android_brand_mvp.weight.MultiStateView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public class AttendanceFragmentSatistics2_2L extends BaseMvpFragment<AttcencesPresenter> implements AttencesView {
    int layout;

    @BindView(R.id.ll_indicator)
    LinearLayout llIndicator;

    @BindView(R.id.mu)
    MultiStateView mu;

    @BindView(R.id.pager)
    ViewPager pager;
    private ImageView[] tips;

    @BindView(R.id.title)
    TextView title;
    Unbinder unbinder;
    private String TAG = AttendanceFragmentSatistics2_2L.class.getSimpleName();
    public int data1 = 0;
    public int data2 = 0;
    private final int timerTime = 60000;
    private String json = "";
    List<User> listp1 = new ArrayList();
    List<User> listp2 = new ArrayList();
    List<User> listp3 = new ArrayList();
    List<User> listp4 = new ArrayList();
    List<User> listAll = new ArrayList();
    List<AttenceListBean.DataDTO.CourseListDTO> courseListDTO = new ArrayList();
    List<AttenceListBean.DataDTO.EventListDTO> eventListDTO = new ArrayList();
    List<AttenceNewListBean.DataDTO> mListDTO = new ArrayList();
    Handler handler = new Handler() { // from class: com.yd.android_brand_mvp.landscape.attence.AttendanceFragmentSatistics2_2L.1
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message.what == 3) {
                AttendanceFragmentSatistics2_2L.this.handler.postDelayed(AttendanceFragmentSatistics2_2L.this.attendanceRunnable, 60000L);
            }
            super.handleMessage(message);
        }
    };
    private final Runnable attendanceRunnable = new Runnable() { // from class: com.yd.android_brand_mvp.landscape.attence.-$$Lambda$AttendanceFragmentSatistics2_2L$2ijNWge2SXQYh2xjDmUwP_pRjFs
        @Override // java.lang.Runnable
        public final void run() {
            this.f$0.lambda$new$0$AttendanceFragmentSatistics2_2L();
        }
    };
    int count = 0;

    @Override // com.yd.android_brand_mvp.view.AttencesView
    public void getAttenceListSuccess(AttenceListBean attenceListBean) {
    }

    @Override // com.yd.android_brand_mvp.view.AttencesView
    public void getToadyAttenceListFails(String str) {
    }

    @Override // com.yd.android_brand_mvp.view.AttencesView
    public void getToadyAttenceListSuccess(KBRsp2 kBRsp2) {
    }

    @Override // com.yd.android_brand_mvp.view.AttencesView
    public void getToadyListSuccess(AttanceTodatDetailsRsp attanceTodatDetailsRsp) {
    }

    public /* synthetic */ void lambda$new$0$AttendanceFragmentSatistics2_2L() {
        if (RuleUtils.getInstance().isRefreshAttendance(this.mListDTO)) {
            ((AttcencesPresenter) this.mvpPresenter).getAttencelist("");
        }
        Message message = new Message();
        message.what = 3;
        this.handler.sendMessage(message);
    }

    private void judgeLandscape() {
        if (ScreenUtils.isLandscape()) {
            this.layout = R.layout.fragment_attence_l2x2_list;
        } else {
            this.layout = R.layout.fragment_attence_p2x2_list;
        }
    }

    @Override // com.yd.android_brand_mvp.base.BaseFragment, com.yd.android_brand_mvp.observer.MinaListener
    public void UpdataEvent(int i) {
        super.UpdataEvent(i);
        if (i == MinaConstants.ATTENCE_MODULE || i == MinaConstants.CODE_ATTENCE) {
            ((AttcencesPresenter) this.mvpPresenter).getAttencelist("");
        }
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        judgeLandscape();
        View viewInflate = layoutInflater.inflate(this.layout, viewGroup, false);
        this.unbinder = ButterKnife.bind(this, viewInflate);
        return viewInflate;
    }

    @Override // com.yd.android_brand_mvp.base.BaseMvpFragment, com.yd.android_brand_mvp.base.BaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        this.mu.setViewState(2);
        this.llIndicator.setVisibility(0);
        this.title.setText("考勤");
        this.title.setOnClickListener(new View.OnClickListener() { // from class: com.yd.android_brand_mvp.landscape.attence.-$$Lambda$AttendanceFragmentSatistics2_2L$S8P7-eQ_nYexnU-AoMqlKVUcfpQ
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                this.f$0.lambda$onViewCreated$1$AttendanceFragmentSatistics2_2L(view2);
            }
        });
        this.mu.setOnErrorClicklistener(new MultiStateView.OnErrorClicklistener() { // from class: com.yd.android_brand_mvp.landscape.attence.-$$Lambda$AttendanceFragmentSatistics2_2L$ZLdTogvR0nPzOhwM6d_1JuiD1sc
            @Override // com.yd.android_brand_mvp.weight.MultiStateView.OnErrorClicklistener
            public final void reload() {
                this.f$0.lambda$onViewCreated$2$AttendanceFragmentSatistics2_2L();
            }
        });
        KBRsp2.DataDTO.TimetableListDTO timetableListDTOIsTable = RuleUtils.getInstance().isTable();
        List<String> attendanceIds = RuleUtils.getInstance().getAttendanceIds();
        if (timetableListDTOIsTable == null && attendanceIds.size() == 0) {
            this.mu.setViewState(2);
        }
        this.handler.postDelayed(this.attendanceRunnable, 60000L);
    }

    public /* synthetic */ void lambda$onViewCreated$1$AttendanceFragmentSatistics2_2L(View view) {
        goPermissionsActivity(AttenceActivity.class);
    }

    public /* synthetic */ void lambda$onViewCreated$2$AttendanceFragmentSatistics2_2L() {
        ((AttcencesPresenter) this.mvpPresenter).getAttencelist("");
    }

    void getAttendanceCache() {
        AttenceNewListBean attenceNewListBean = (AttenceNewListBean) Hawk.get(BaseHawk.NEWATTENCE);
        this.mListDTO.clear();
        if (attenceNewListBean == null || attenceNewListBean.data == null) {
            this.mu.setViewState(2);
            this.llIndicator.setVisibility(8);
        } else {
            this.mListDTO.addAll(attenceNewListBean.data);
            this.mu.setViewState(0);
            initFragmist();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        ((AttcencesPresenter) this.mvpPresenter).getAttencelist("");
        SPUtils.getInstance().put(SpData.AttenceEnable, "1");
        String strIsAttenceEnable = SpData.isAttenceEnable();
        Log.e(this.TAG, "onResume: " + strIsAttenceEnable);
        new Handler().postDelayed(new Runnable() { // from class: com.yd.android_brand_mvp.landscape.attence.-$$Lambda$AttendanceFragmentSatistics2_2L$-op63ls3g3N7QJcKNh2NpqXQv0M
            @Override // java.lang.Runnable
            public final void run() {
                AttendanceFragmentSatistics2_2L.lambda$onResume$3();
            }
        }, 5000L);
    }

    static /* synthetic */ void lambda$onResume$3() {
        SPUtils.getInstance().put(SpData.AttenceEnable, "2");
        Log.e("TAG", "AttendanceFragment2_2_2L====》onResume: " + JSON.toJSONString(SpData.isAttenceEnable()));
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
    }

    public void initFragmist() {
        int size = this.mListDTO.size();
        this.count = size;
        if (size == 0) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        FragmentManager childFragmentManager = getChildFragmentManager();
        for (int i = 0; i < this.count; i++) {
            Bundle bundle = new Bundle();
            bundle.putInt(FirebaseAnalytics.Param.INDEX, i);
            AttenceNewListBean.DataDTO dataDTO = this.mListDTO.get(i);
            if (this.mListDTO.get(i) != null) {
                bundle.putString("bean", new Gson().toJson(dataDTO));
                bundle.putString("attendanceTimeId", dataDTO.attendanceTimeId);
                bundle.putString("attendanceId", dataDTO.attendanceId);
                bundle.putString("type", String.valueOf(dataDTO.type));
                NewAttencesFragment newAttencesFragment = new NewAttencesFragment();
                newAttencesFragment.setArguments(bundle);
                arrayList.add(newAttencesFragment);
            }
        }
        this.pager.setOffscreenPageLimit(0);
        this.pager.setAdapter(new ViewPagerFragmentAdapter(childFragmentManager, arrayList));
        this.pager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() { // from class: com.yd.android_brand_mvp.landscape.attence.AttendanceFragmentSatistics2_2L.2
            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageScrollStateChanged(int i2) {
            }

            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageScrolled(int i2, float f, int i3) {
            }

            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageSelected(int i2) {
                AttendanceFragmentSatistics2_2L.this.setImageBackground(i2);
            }
        });
        this.llIndicator.setVisibility(0);
        setIndicator();
    }

    @Override // com.yd.android_brand_mvp.view.AttencesView
    public void getAttenceNewListSuccess(AttenceNewListBean attenceNewListBean) {
        this.mListDTO.clear();
        if (attenceNewListBean.data != null && attenceNewListBean.data.size() > 0) {
            this.mu.setViewState(0);
            Hawk.delete(BaseHawk.NEWATTENCE);
            Hawk.put(BaseHawk.NEWATTENCE, attenceNewListBean);
            this.mListDTO.addAll(attenceNewListBean.data);
            this.json = GsonUtils.toJson(attenceNewListBean.data);
            initFragmist();
            return;
        }
        Hawk.delete(BaseHawk.NEWATTENCE);
        this.mu.setViewState(2);
        this.llIndicator.setVisibility(8);
    }

    @Override // com.yd.android_brand_mvp.view.AttencesView
    public void getAttenceListSuccessFail(String str) {
        LogUtils.i("获取考勤数据异常： " + str);
        getAttendanceCache();
    }

    void setData(AttenceListBean attenceListBean) {
        this.courseListDTO.clear();
        this.eventListDTO.clear();
        if (attenceListBean == null || attenceListBean.data == null) {
            this.mu.setViewState(2);
            return;
        }
        this.mu.setViewState(0);
        if (attenceListBean.data.teacherCourseList != null) {
            this.courseListDTO.addAll(attenceListBean.data.teacherCourseList);
        }
        if (attenceListBean.data.studentCourseList != null) {
            this.courseListDTO.addAll(attenceListBean.data.studentCourseList);
        }
        if (attenceListBean.data.teacherEventList != null) {
            this.eventListDTO.addAll(attenceListBean.data.teacherEventList);
        }
        if (attenceListBean.data.studentEventList != null) {
            this.eventListDTO.addAll(attenceListBean.data.studentEventList);
        }
        if (this.eventListDTO.size() + this.courseListDTO.size() == 0) {
            this.mu.setViewState(2);
        } else if (this.courseListDTO.size() + this.eventListDTO.size() == 0) {
            this.mu.setViewState(2);
        } else {
            Hawk.delete(BaseHawk.ATTENCE);
            Hawk.put(BaseHawk.ATTENCE, attenceListBean);
        }
    }

    private class UpdateAsyncTask2 extends AsyncTask<UserDao, User, Void> {
        private long id;
        private long timeid;
        private UserDao toDoDao;

        UpdateAsyncTask2(UserDao userDao, long j, long j2) {
            this.toDoDao = userDao;
            this.id = j;
            this.timeid = j2;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        public Void doInBackground(UserDao... userDaoArr) {
            int i;
            List<User> listFindById = this.toDoDao.findById(this.id);
            Log.e("TAG", "doInBackground: " + this.id + "==》" + JSON.toJSONString(Integer.valueOf(listFindById.size())));
            AttendanceFragmentSatistics2_2L.this.listAll = this.toDoDao.getAll();
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            ArrayList arrayList3 = new ArrayList();
            ArrayList arrayList4 = new ArrayList();
            Iterator<User> it2 = listFindById.iterator();
            while (true) {
                i = 4;
                if (!it2.hasNext()) {
                    break;
                }
                User next = it2.next();
                if (next.type == 1 && next.Timeid == this.timeid) {
                    arrayList.add(next);
                } else if (next.type == 2 && next.Timeid == this.timeid) {
                    arrayList2.add(next);
                } else if (next.type == 3 && next.Timeid == this.timeid) {
                    arrayList3.add(next);
                } else if (next.type == 4 && next.Timeid == this.timeid) {
                    arrayList4.add(next);
                }
            }
            if (arrayList.size() > 0) {
                AttendanceFragmentSatistics2_2L.this.listp1.add((User) arrayList.get(0));
                i = 1;
            } else if (arrayList2.size() > 0 && arrayList.size() == 0) {
                AttendanceFragmentSatistics2_2L.this.listp2.add((User) arrayList2.get(0));
                i = 2;
            } else if (arrayList3.size() > 0) {
                AttendanceFragmentSatistics2_2L.this.listp3.add((User) arrayList3.get(arrayList3.size() - 1));
                i = 3;
            } else if (arrayList4.size() <= 0 || arrayList3.size() != 0) {
                i = -1;
            } else {
                AttendanceFragmentSatistics2_2L.this.listp4.add((User) arrayList4.get(0));
            }
            Message message = new Message();
            message.arg1 = i;
            message.what = 1;
            AttendanceFragmentSatistics2_2L.this.handler.sendMessage(message);
            return null;
        }
    }

    void seacherDB(long j, long j2) {
        new UpdateAsyncTask2(DataBaseInstance.getInstance(this.mActivity).userDao(), j, j2).execute(new UserDao[0]);
    }

    void setAttenceData(int i, long j) {
        ArrayList arrayList = new ArrayList();
        Iterator<AttencelistRsp.DataDTO.AttendanceListDTO.PeoplesDTO> it2 = SpData.getAttenceRule().data.attendanceList.get(i).peopleList.iterator();
        while (it2.hasNext()) {
            arrayList.add(it2.next());
        }
        Iterator it3 = arrayList.iterator();
        while (it3.hasNext()) {
            seacherDB(((AttencelistRsp.DataDTO.AttendanceListDTO.PeoplesDTO) it3.next()).id, j);
        }
    }

    @Override // com.yd.android_brand_mvp.base.BaseMvpFragment, androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        this.handler.removeCallbacks(this.attendanceRunnable);
        this.handler.removeCallbacksAndMessages(null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setImageBackground(int i) {
        int i2 = 0;
        while (true) {
            ImageView[] imageViewArr = this.tips;
            if (i2 >= imageViewArr.length) {
                return;
            }
            if (i2 == i) {
                imageViewArr[i2].setBackgroundResource(R.drawable.bg_img_indicator2);
            } else {
                imageViewArr[i2].setBackgroundResource(R.drawable.bg_img_indicator1);
            }
            i2++;
        }
    }

    private void setIndicator() {
        this.llIndicator.removeAllViews();
        int i = this.count;
        if (i == 1) {
            return;
        }
        this.tips = new ImageView[i];
        for (int i2 = 0; i2 < this.count; i2++) {
            ImageView imageView = new ImageView(this.mActivity);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(8, 8);
            layoutParams.setMargins(14, 0, 0, 0);
            imageView.setLayoutParams(layoutParams);
            imageView.setLeft(30);
            ImageView[] imageViewArr = this.tips;
            imageViewArr[i2] = imageView;
            if (i2 == 0) {
                imageViewArr[i2].setBackgroundResource(R.drawable.bg_img_indicator2);
            } else {
                imageViewArr[i2].setBackgroundResource(R.drawable.bg_img_indicator1);
            }
            this.llIndicator.addView(imageView);
        }
    }
}
