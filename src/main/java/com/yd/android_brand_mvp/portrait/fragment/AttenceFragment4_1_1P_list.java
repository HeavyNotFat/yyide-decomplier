package com.yd.android_brand_mvp.portrait.fragment;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
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
import com.alibaba.fastjson.JSON;
import com.blankj.utilcode.util.SPUtils;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.listener.OnItemClickListener;
import com.lxj.xpopup.XPopup;
import com.yd.android_brand_mvp.R;
import com.yd.android_brand_mvp.adapter.AttenceAdapter;
import com.yd.android_brand_mvp.base.BaseMvpFragment;
import com.yd.android_brand_mvp.base.MinaConstants;
import com.yd.android_brand_mvp.model.AttenceBean;
import com.yd.android_brand_mvp.model.AttenceExcBean;
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
public class AttenceFragment4_1_1P_list extends BaseMvpFragment<AttcenceListPresenter> implements AttenceListView, PagingScrollHelper.onPageChangeListener {
    AttenceAdapter attenceAdapter;
    AttenceBean attenceBean;
    Handler handler = new Handler(Looper.myLooper()) { // from class: com.yd.android_brand_mvp.portrait.fragment.AttenceFragment4_1_1P_list.1
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message.what != 0) {
                return;
            }
            AttenceFragment4_1_1P_list.this.list = (List) message.obj;
            new XPopup.Builder(AttenceFragment4_1_1P_list.this.mActivity).asCustom(new AttenceExcPopup(AttenceFragment4_1_1P_list.this.mActivity, AttenceFragment4_1_1P_list.this.list, AttenceFragment4_1_1P_list.this.titles)).show();
            AttenceFragment4_1_1P_list.this.nomalLoadingDiallog.dismiss();
        }
    };
    int index = 0;
    List<AttenceExcBean> list;

    @BindView(R.id.mu)
    MultiStateView mu;
    List<AttenceBean.DataBean.StudentsBean.PeopleBean> peopleList;

    @BindView(R.id.rl_attence)
    RecyclerView rl_attence;
    PagingScrollHelper scrollHelper;

    @BindView(R.id.title)
    TextView title;
    String titles;
    Unbinder unbinder;

    @Override // com.yd.android_brand_mvp.weight.recycleview.PagingScrollHelper.onPageChangeListener
    public void onPageChange(int i) {
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View viewInflate = layoutInflater.inflate(R.layout.fragment_attence_4_1_p, viewGroup, false);
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
        this.mu.setViewState(2);
    }

    @OnClick({R.id.tv_att, R.id.title})
    public void onClick(View view) {
        int id = view.getId();
        if (id == R.id.title || id == R.id.tv_att) {
            goPermissionsActivity(AttenceActivity.class);
        }
    }

    void setData(AttenceBean attenceBean) {
        this.attenceAdapter = new AttenceAdapter(R.layout.attence_item_4_1_2);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        linearLayoutManager.setOrientation(0);
        this.rl_attence.setLayoutManager(linearLayoutManager);
        this.rl_attence.setAdapter(this.attenceAdapter);
        this.mu.setOnErrorClicklistener(new MultiStateView.OnErrorClicklistener() { // from class: com.yd.android_brand_mvp.portrait.fragment.AttenceFragment4_1_1P_list.2
            @Override // com.yd.android_brand_mvp.weight.MultiStateView.OnErrorClicklistener
            public void reload() {
                ((AttcenceListPresenter) AttenceFragment4_1_1P_list.this.mvpPresenter).getAttencelist(SpData.getClassesId() + "");
            }
        });
        this.mu.setViewState(attenceBean.data.size() <= 0 ? 2 : 0);
        this.attenceAdapter.setNewData(attenceBean.data);
        this.attenceAdapter.setOnItemClickListener(new OnItemClickListener() { // from class: com.yd.android_brand_mvp.portrait.fragment.AttenceFragment4_1_1P_list.3
            /* JADX WARN: Type inference failed for: r1v6, types: [com.yd.android_brand_mvp.portrait.fragment.AttenceFragment4_1_1P_list$3$1] */
            @Override // com.chad.library.adapter.base.listener.OnItemClickListener
            public void onItemClick(BaseQuickAdapter<?, ?> baseQuickAdapter, View view, final int i) {
                if (AttenceFragment4_1_1P_list.this.attenceBean == null) {
                    return;
                }
                if (!AttenceFragment4_1_1P_list.this.getActivity().isDestroyed()) {
                    AttenceFragment4_1_1P_list.this.nomalLoadingDiallog.show();
                }
                new Thread() { // from class: com.yd.android_brand_mvp.portrait.fragment.AttenceFragment4_1_1P_list.3.1
                    @Override // java.lang.Thread, java.lang.Runnable
                    public void run() {
                        Message message = new Message();
                        message.obj = AttenceUtil.getAttenceExcBean(AttenceFragment4_1_1P_list.this.attenceBean.data.get(i));
                        message.what = 0;
                        AttenceFragment4_1_1P_list.this.titles = AttenceUtil.getTitle(AttenceFragment4_1_1P_list.this.attenceBean.data.get(i));
                        AttenceFragment4_1_1P_list.this.handler.sendMessage(message);
                    }
                }.start();
            }
        });
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        ((AttcenceListPresenter) this.mvpPresenter).getAttencelist(SpData.getClassesId() + "");
        SPUtils.getInstance().put(SpData.AttenceEnable, "1");
        new Handler().postDelayed(new Runnable() { // from class: com.yd.android_brand_mvp.portrait.fragment.AttenceFragment4_1_1P_list.4
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
        Log.e("TAG", "getAttenceSuccess: " + JSON.toJSONString(attenceBean));
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
        Log.e("TAG", "getAttenceSuccessFail: " + str);
    }
}
