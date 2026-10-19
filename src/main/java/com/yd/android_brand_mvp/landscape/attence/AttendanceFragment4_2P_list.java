package com.yd.android_brand_mvp.landscape.attence;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.fragment.app.FragmentManager;
import androidx.viewpager.widget.ViewPager;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import com.blankj.utilcode.util.LogUtils;
import com.blankj.utilcode.util.SPUtils;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.gson.Gson;
import com.orhanobut.hawk.Hawk;
import com.yd.android_brand_mvp.R;
import com.yd.android_brand_mvp.adapter.ViewPagerFragmentAdapter;
import com.yd.android_brand_mvp.adapter.attence.CheckAttendanceActivity;
import com.yd.android_brand_mvp.adapter.attence.RuleUtils;
import com.yd.android_brand_mvp.base.BaseHawk;
import com.yd.android_brand_mvp.base.BaseMvpFragment;
import com.yd.android_brand_mvp.base.MinaConstants;
import com.yd.android_brand_mvp.model.AttanceTodatDetailsRsp;
import com.yd.android_brand_mvp.model.AttenceListBean;
import com.yd.android_brand_mvp.model.AttenceNewListBean;
import com.yd.android_brand_mvp.model.KBRsp2;
import com.yd.android_brand_mvp.presenter.AttcencesPresenter;
import com.yd.android_brand_mvp.user.AttenceActivity;
import com.yd.android_brand_mvp.utils.SpData;
import com.yd.android_brand_mvp.view.AttencesView;
import com.yd.android_brand_mvp.weight.MultiStateView;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public class AttendanceFragment4_2P_list extends BaseMvpFragment<AttcencesPresenter> implements AttencesView {
    int layout;

    @BindView(R.id.ll_indicator)
    LinearLayout llIndicator;

    @BindView(R.id.mu)
    MultiStateView mu;

    @BindView(R.id.pager)
    ViewPager pager;

    @BindView(R.id.post)
    TextView post;

    @BindView(R.id.rl_att)
    RelativeLayout rlAtt;
    private ImageView[] tips;

    @BindView(R.id.title)
    TextView title;
    Unbinder unbinder;
    public int data1 = 0;
    public int data2 = 0;
    public int data3 = 0;
    public int data4 = 0;
    List<AttenceListBean.DataDTO.CourseListDTO> courseListDTO = new ArrayList();
    List<AttenceListBean.DataDTO.EventListDTO> eventListDTO = new ArrayList();
    List<AttenceNewListBean.DataDTO> mListDTO = new ArrayList();
    int index = -1;
    private final int timerTime = 30000;
    Handler handler = new Handler(Looper.myLooper()) { // from class: com.yd.android_brand_mvp.landscape.attence.AttendanceFragment4_2P_list.1
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message.what == 3) {
                AttendanceFragment4_2P_list.this.handler.postDelayed(AttendanceFragment4_2P_list.this.attendanceRunnable, 30000L);
            }
            super.handleMessage(message);
        }
    };
    private final Runnable attendanceRunnable = new Runnable() { // from class: com.yd.android_brand_mvp.landscape.attence.-$$Lambda$AttendanceFragment4_2P_list$_ZJZ0ueiKG6TPg7q-DQcBs7DgH8
        @Override // java.lang.Runnable
        public final void run() {
            this.f$0.lambda$new$0$AttendanceFragment4_2P_list();
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

    private void judgeLandscape() {
        this.layout = R.layout.fragment_attence_p4_2_list;
    }

    public /* synthetic */ void lambda$new$0$AttendanceFragment4_2P_list() {
        if (RuleUtils.getInstance().isRefreshAttendance(this.mListDTO)) {
            ((AttcencesPresenter) this.mvpPresenter).getAttencelist("");
        }
        Message message = new Message();
        message.what = 3;
        this.handler.sendMessage(message);
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        judgeLandscape();
        View viewInflate = layoutInflater.inflate(this.layout, viewGroup, false);
        this.unbinder = ButterKnife.bind(this, viewInflate);
        return viewInflate;
    }

    @Override // com.yd.android_brand_mvp.base.BaseFragment, com.yd.android_brand_mvp.observer.MinaListener
    public void UpdataEvent(int i) {
        super.UpdataEvent(i);
        if (i == MinaConstants.ATTENCE_MODULE) {
            ((AttcencesPresenter) this.mvpPresenter).getAttencelist("");
        }
    }

    @Override // com.yd.android_brand_mvp.base.BaseMvpFragment, com.yd.android_brand_mvp.base.BaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        this.mu.setViewState(2);
        this.post.setOnClickListener(new View.OnClickListener() { // from class: com.yd.android_brand_mvp.landscape.attence.AttendanceFragment4_2P_list.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                AttendanceFragment4_2P_list.this.startActivity(new Intent(AttendanceFragment4_2P_list.this.mActivity, (Class<?>) CheckAttendanceActivity.class));
            }
        });
        this.llIndicator.setVisibility(0);
        this.title.setText("考勤");
        this.title.setOnClickListener(new View.OnClickListener() { // from class: com.yd.android_brand_mvp.landscape.attence.AttendanceFragment4_2P_list.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                AttendanceFragment4_2P_list.this.goPermissionsActivity(AttenceActivity.class);
            }
        });
        this.mu.setOnErrorClicklistener(new MultiStateView.OnErrorClicklistener() { // from class: com.yd.android_brand_mvp.landscape.attence.AttendanceFragment4_2P_list.4
            @Override // com.yd.android_brand_mvp.weight.MultiStateView.OnErrorClicklistener
            public void reload() {
                ((AttcencesPresenter) AttendanceFragment4_2P_list.this.mvpPresenter).getAttencelist("");
            }
        });
        this.handler.postDelayed(this.attendanceRunnable, 30000L);
    }

    void getAttenceCache() {
        AttenceNewListBean attenceNewListBean = (AttenceNewListBean) Hawk.get(BaseHawk.NEWATTENCE);
        if (attenceNewListBean == null || attenceNewListBean.data == null) {
            this.mu.setViewState(2);
            return;
        }
        this.mListDTO.clear();
        if (attenceNewListBean.data.size() > 0) {
            this.mu.setViewState(0);
            this.mListDTO.addAll(attenceNewListBean.data);
            initFragmist();
            return;
        }
        this.mu.setViewState(2);
    }

    public void initFragmist() {
        int i;
        int size = this.mListDTO.size();
        this.count = size;
        if (size == 0) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        FragmentManager childFragmentManager = getChildFragmentManager();
        int i2 = 0;
        while (true) {
            i = this.count;
            if (i2 >= i) {
                break;
            }
            Bundle bundle = new Bundle();
            bundle.putInt(FirebaseAnalytics.Param.INDEX, i2);
            AttenceNewListBean.DataDTO dataDTO = this.mListDTO.get(i2);
            if (this.mListDTO.get(i2) != null) {
                bundle.putString("bean", new Gson().toJson(dataDTO));
                bundle.putString("attendanceTimeId", dataDTO.attendanceTimeId);
                bundle.putString("attendanceId", dataDTO.attendanceId);
                bundle.putString("type", String.valueOf(dataDTO.type));
                NewAttencesFragment4_2P newAttencesFragment4_2P = new NewAttencesFragment4_2P();
                newAttencesFragment4_2P.setArguments(bundle);
                arrayList.add(newAttencesFragment4_2P);
            }
            i2++;
        }
        this.pager.setOffscreenPageLimit(i);
        this.pager.setAdapter(new ViewPagerFragmentAdapter(childFragmentManager, arrayList));
        this.pager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() { // from class: com.yd.android_brand_mvp.landscape.attence.AttendanceFragment4_2P_list.5
            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageScrollStateChanged(int i3) {
            }

            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageScrolled(int i3, float f, int i4) {
            }

            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageSelected(int i3) {
                AttendanceFragment4_2P_list.this.setImageBackground(i3);
            }
        });
        setIndicator();
        if (this.index != -1) {
            int size2 = arrayList.size();
            int i3 = this.index;
            if (size2 > i3) {
                this.pager.setCurrentItem(i3);
            }
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        ((AttcencesPresenter) this.mvpPresenter).getAttencelist("");
        SPUtils.getInstance().put(SpData.AttenceEnable, "1");
        new Handler().postDelayed(new Runnable() { // from class: com.yd.android_brand_mvp.landscape.attence.AttendanceFragment4_2P_list.6
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
        this.handler.removeCallbacks(this.attendanceRunnable);
    }

    @Override // com.yd.android_brand_mvp.view.AttencesView
    public void getAttenceNewListSuccess(AttenceNewListBean attenceNewListBean) {
        this.mListDTO.clear();
        if (attenceNewListBean.data.size() > 0) {
            this.mu.setViewState(0);
            this.mListDTO.addAll(attenceNewListBean.data);
            initFragmist();
            return;
        }
        this.mu.setViewState(2);
    }

    @Override // com.yd.android_brand_mvp.view.AttencesView
    public void getAttenceListSuccessFail(String str) {
        LogUtils.i("获取考勤数据异常 " + str);
        getAttenceCache();
    }

    @Override // com.yd.android_brand_mvp.base.BaseMvpFragment, androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
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
        this.rlAtt.setGravity(17);
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
        this.rlAtt.setGravity(5);
    }
}
