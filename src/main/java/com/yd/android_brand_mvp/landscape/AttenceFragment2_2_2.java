package com.yd.android_brand_mvp.landscape;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
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
import com.blankj.utilcode.util.SPUtils;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.listener.OnItemClickListener;
import com.lxj.xpopup.XPopup;
import com.yd.android_brand_mvp.R;
import com.yd.android_brand_mvp.adapter.AttenceAdapter;
import com.yd.android_brand_mvp.base.BaseMvpFragment;
import com.yd.android_brand_mvp.base.MinaConstants;
import com.yd.android_brand_mvp.model.AttenceBean;
import com.yd.android_brand_mvp.presenter.AttcenceListPresenter;
import com.yd.android_brand_mvp.user.AttenceActivity;
import com.yd.android_brand_mvp.utils.AttenceUtil;
import com.yd.android_brand_mvp.utils.SpData;
import com.yd.android_brand_mvp.view.AttenceListView;
import com.yd.android_brand_mvp.weight.AttenceExcPopup;
import com.yd.android_brand_mvp.weight.MultiStateView;
import com.yd.android_brand_mvp.weight.recycleview.PagingScrollHelper;
import java.util.List;
import org.greenrobot.eventbus.EventBus;

/* JADX INFO: loaded from: classes4.dex */
public class AttenceFragment2_2_2 extends BaseMvpFragment<AttcenceListPresenter> implements AttenceListView, PagingScrollHelper.onPageChangeListener {
    AttenceAdapter attenceAdapter;
    AttenceBean attenceBean;

    @BindView(R.id.mu)
    MultiStateView mu;
    List<AttenceBean.DataBean.StudentsBean.PeopleBean> peopleList;

    @BindView(R.id.rl_attence)
    RecyclerView rl_attence;
    PagingScrollHelper scrollHelper;

    @BindView(R.id.title)
    TextView title;

    @BindView(R.id.tv_att)
    TextView tv_att;
    Unbinder unbinder;
    int index = 0;
    Handler handler = new Handler() { // from class: com.yd.android_brand_mvp.landscape.AttenceFragment2_2_2.4
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            super.handleMessage(message);
        }
    };

    @Override // com.yd.android_brand_mvp.weight.recycleview.PagingScrollHelper.onPageChangeListener
    public void onPageChange(int i) {
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
        EventBus.getDefault().register(this);
        initView();
    }

    @Override // com.yd.android_brand_mvp.base.BaseFragment, com.yd.android_brand_mvp.observer.MinaListener
    public void UpdataEvent(int i) {
        super.UpdataEvent(i);
        if (i == MinaConstants.ATTENCE_MODULE) {
            ((AttcenceListPresenter) this.mvpPresenter).getAttencelist(SpData.getClassesId() + "");
        }
    }

    void initView() {
        this.title.setText("考勤");
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
            goPermissionsActivity(AttenceActivity.class);
        }
    }

    void setData(AttenceBean attenceBean) {
        this.attenceAdapter = new AttenceAdapter(R.layout.attence_item_2_2);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        linearLayoutManager.setOrientation(0);
        this.rl_attence.setLayoutManager(linearLayoutManager);
        this.rl_attence.setAdapter(this.attenceAdapter);
        this.mu.setOnErrorClicklistener(new MultiStateView.OnErrorClicklistener() { // from class: com.yd.android_brand_mvp.landscape.AttenceFragment2_2_2.1
            @Override // com.yd.android_brand_mvp.weight.MultiStateView.OnErrorClicklistener
            public void reload() {
                ((AttcenceListPresenter) AttenceFragment2_2_2.this.mvpPresenter).getAttencelist(SpData.getClassesId() + "");
            }
        });
        this.mu.setViewState(attenceBean.data.size() <= 0 ? 2 : 0);
        this.attenceAdapter.setNewData(attenceBean.data);
        this.attenceAdapter.setOnItemClickListener(new OnItemClickListener() { // from class: com.yd.android_brand_mvp.landscape.AttenceFragment2_2_2.2
            @Override // com.chad.library.adapter.base.listener.OnItemClickListener
            public void onItemClick(BaseQuickAdapter<?, ?> baseQuickAdapter, View view, int i) {
                if (AttenceFragment2_2_2.this.attenceBean == null) {
                    return;
                }
                if (!AttenceFragment2_2_2.this.getActivity().isDestroyed()) {
                    AttenceFragment2_2_2.this.nomalLoadingDiallog.show();
                }
                Log.e("TAG", "onItemClick: ");
                AttenceExcPopup attenceExcPopup = new AttenceExcPopup(AttenceFragment2_2_2.this.mActivity, AttenceUtil.getAttenceExcBean(AttenceFragment2_2_2.this.attenceBean.data.get(i)), AttenceUtil.getTitle(AttenceFragment2_2_2.this.attenceBean.data.get(i)));
                attenceExcPopup.setOnStartLister(new AttenceExcPopup.OnStartLister() { // from class: com.yd.android_brand_mvp.landscape.AttenceFragment2_2_2.2.1
                    @Override // com.yd.android_brand_mvp.weight.AttenceExcPopup.OnStartLister
                    public void onstart() {
                        Log.e("TAG", "onstart: ");
                    }
                });
                new XPopup.Builder(AttenceFragment2_2_2.this.mActivity).asCustom(attenceExcPopup).show();
                if (AttenceFragment2_2_2.this.getActivity().isDestroyed()) {
                    return;
                }
                AttenceFragment2_2_2.this.nomalLoadingDiallog.dismiss();
            }
        });
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        ((AttcenceListPresenter) this.mvpPresenter).getAttencelist(SpData.getClassesId() + "");
        SPUtils.getInstance().put(SpData.AttenceEnable, "1");
        Log.e("AttenceFragment2_2_2", "onResume: " + SpData.isAttenceEnable());
        new Handler().postDelayed(new Runnable() { // from class: com.yd.android_brand_mvp.landscape.AttenceFragment2_2_2.3
            @Override // java.lang.Runnable
            public void run() {
                SPUtils.getInstance().put(SpData.AttenceEnable, "2");
            }
        }, 5000L);
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
        EventBus.getDefault().unregister(this);
    }

    @Override // com.yd.android_brand_mvp.base.BaseMvpFragment, androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
    }

    @Override // com.yd.android_brand_mvp.view.AttenceListView
    public void getAttenceSuccess(AttenceBean attenceBean) {
        if (attenceBean == null || attenceBean.data == null || attenceBean.data.size() == 0) {
            this.mu.setViewState(2);
            return;
        }
        this.attenceBean = attenceBean;
        this.mu.setViewState(0);
        setData(attenceBean);
    }

    @Override // com.yd.android_brand_mvp.view.AttenceListView
    public void getAttenceSuccessFail(String str) {
        Log.e("TAG", "AttenceFragment2_2_2_getAttenceSuccessFail: " + str);
    }
}
