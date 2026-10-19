package com.yd.android_brand_mvp.landscape.attence;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;
import com.blankj.utilcode.util.LogUtils;
import com.blankj.utilcode.util.SPUtils;
import com.lxj.xpopup.XPopup;
import com.orhanobut.hawk.Hawk;
import com.yd.android_brand_mvp.R;
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
import com.yd.android_brand_mvp.utils.ToastUtil;
import com.yd.android_brand_mvp.view.AttencesView;
import com.yd.android_brand_mvp.weight.AttencesExcPopup;
import com.yd.android_brand_mvp.weight.MultiStateView;
import com.yd.android_brand_mvp.weight.recycleview.PagingScrollHelper;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public class AttendanceFragment2_2_2L extends BaseMvpFragment<AttcencesPresenter> implements AttencesView, PagingScrollHelper.onPageChangeListener {
    private NewAttenceAdapter mAdapter;

    @BindView(R.id.mu)
    MultiStateView mu;

    @BindView(R.id.rl_attence)
    RecyclerView rl_attence;

    @BindView(R.id.title)
    TextView title;

    @BindView(R.id.tv_att)
    TextView tv_att;
    Unbinder unbinder;
    private final List<AttenceNewListBean.DataDTO> mListDTO = new ArrayList();
    private final int timerTime = 60000;
    private Handler handler = new Handler(Looper.myLooper()) { // from class: com.yd.android_brand_mvp.landscape.attence.AttendanceFragment2_2_2L.1
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message.what == 3) {
                AttendanceFragment2_2_2L.this.handler.postDelayed(AttendanceFragment2_2_2L.this.attendanceRunnable, 60000L);
            }
            super.handleMessage(message);
        }
    };
    private final Runnable attendanceRunnable = new Runnable() { // from class: com.yd.android_brand_mvp.landscape.attence.-$$Lambda$AttendanceFragment2_2_2L$06vFBweoW5WKYuBmvoMjTSmgcSg
        @Override // java.lang.Runnable
        public final void run() {
            this.f$0.lambda$new$0$AttendanceFragment2_2_2L();
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

    @Override // com.yd.android_brand_mvp.weight.recycleview.PagingScrollHelper.onPageChangeListener
    public void onPageChange(int i) {
    }

    public /* synthetic */ void lambda$new$0$AttendanceFragment2_2_2L() {
        if (RuleUtils.getInstance().isRefreshAttendance(this.mListDTO)) {
            ((AttcencesPresenter) this.mvpPresenter).getAttencelist("");
        }
        Message message = new Message();
        message.what = 3;
        this.handler.sendMessage(message);
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View viewInflate = layoutInflater.inflate(R.layout.fragment_attence_2_2_2, viewGroup, false);
        this.unbinder = ButterKnife.bind(this, viewInflate);
        return viewInflate;
    }

    @Override // com.yd.android_brand_mvp.base.BaseMvpFragment, com.yd.android_brand_mvp.base.BaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        initView();
        this.handler.postDelayed(this.attendanceRunnable, 60000L);
    }

    @Override // com.yd.android_brand_mvp.base.BaseFragment, com.yd.android_brand_mvp.observer.MinaListener
    public void UpdataEvent(int i) {
        super.UpdataEvent(i);
        if (i == MinaConstants.ATTENCE_MODULE || i == MinaConstants.CODE_ATTENCE) {
            ((AttcencesPresenter) this.mvpPresenter).getAttencelist("");
        }
    }

    private void initView() {
        this.title.setText("考勤");
        this.mAdapter = new NewAttenceAdapter(this.mActivity, this.mListDTO);
        this.mu.setViewState(2);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        linearLayoutManager.setOrientation(0);
        this.rl_attence.setLayoutManager(linearLayoutManager);
        this.rl_attence.setAdapter(this.mAdapter);
        this.mu.setOnErrorClicklistener(new MultiStateView.OnErrorClicklistener() { // from class: com.yd.android_brand_mvp.landscape.attence.AttendanceFragment2_2_2L.2
            @Override // com.yd.android_brand_mvp.weight.MultiStateView.OnErrorClicklistener
            public void reload() {
                ((AttcencesPresenter) AttendanceFragment2_2_2L.this.mvpPresenter).getAttencelist("");
            }
        });
        this.mAdapter.addOnclick(new NewAttenceAdapter.Onclick() { // from class: com.yd.android_brand_mvp.landscape.attence.AttendanceFragment2_2_2L.3
            @Override // com.yd.android_brand_mvp.landscape.attence.NewAttenceAdapter.Onclick
            public void setOnAttClickListener(String str, String str2, String str3) {
                AttendanceFragment2_2_2L.this.bookLoadingDiallog.show();
                ((AttcencesPresenter) AttendanceFragment2_2_2L.this.mvpPresenter).getAttenceTodayList(str, str2, str3);
            }
        });
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        ((AttcencesPresenter) this.mvpPresenter).getAttencelist("");
        SPUtils.getInstance().put(SpData.AttenceEnable, "1");
        new Handler().postDelayed(new Runnable() { // from class: com.yd.android_brand_mvp.landscape.attence.AttendanceFragment2_2_2L.4
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
        if (attenceNewListBean.code == 0) {
            setNewData(attenceNewListBean);
            Hawk.delete(BaseHawk.NEWATTENCE);
            Hawk.put(BaseHawk.NEWATTENCE, attenceNewListBean);
            if (attenceNewListBean.data.size() == 0) {
                Hawk.delete(BaseHawk.NEWATTENCE);
                return;
            }
            return;
        }
        this.mu.setViewState(2);
        this.tv_att.setVisibility(8);
    }

    void setNewData(AttenceNewListBean attenceNewListBean) {
        this.mListDTO.clear();
        if (attenceNewListBean.data != null && !attenceNewListBean.data.isEmpty()) {
            this.mu.setViewState(0);
            this.tv_att.setVisibility(0);
            this.mListDTO.addAll(attenceNewListBean.data);
            this.mAdapter.addCourseListDTO(this.mListDTO);
            return;
        }
        this.mu.setViewState(2);
        this.tv_att.setVisibility(8);
    }

    @Override // com.yd.android_brand_mvp.view.AttencesView
    public void getAttenceListSuccessFail(String str) {
        LogUtils.i("获取考勤数据失败 = " + str);
        AttenceNewListBean attenceNewListBean = (AttenceNewListBean) Hawk.get(BaseHawk.NEWATTENCE);
        if (attenceNewListBean == null || attenceNewListBean.data == null) {
            this.mu.setViewState(2);
        } else {
            setNewData(attenceNewListBean);
        }
    }

    @Override // com.yd.android_brand_mvp.view.AttencesView
    public void getToadyListSuccess(AttanceTodatDetailsRsp attanceTodatDetailsRsp) {
        this.bookLoadingDiallog.dismiss();
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

    @OnClick({R.id.tv_att, R.id.title})
    public void onClick(View view) {
        int id = view.getId();
        if (id == R.id.title) {
            goPermissionsActivity(AttenceActivity.class);
        } else {
            if (id != R.id.tv_att) {
                return;
            }
            startActivity(new Intent(this.mActivity, (Class<?>) CheckAttendanceActivity.class));
        }
    }
}
