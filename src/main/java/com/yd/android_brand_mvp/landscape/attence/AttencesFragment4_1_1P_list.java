package com.yd.android_brand_mvp.landscape.attence;

import android.os.Bundle;
import android.os.Handler;
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
import com.orhanobut.hawk.Hawk;
import com.yd.android_brand_mvp.R;
import com.yd.android_brand_mvp.base.BaseHawk;
import com.yd.android_brand_mvp.base.BaseMvpFragment;
import com.yd.android_brand_mvp.base.MinaConstants;
import com.yd.android_brand_mvp.model.AttanceTodatDetailsRsp;
import com.yd.android_brand_mvp.model.AttenceExcBean;
import com.yd.android_brand_mvp.model.AttenceListBean;
import com.yd.android_brand_mvp.model.AttenceNewListBean;
import com.yd.android_brand_mvp.model.KBRsp2;
import com.yd.android_brand_mvp.presenter.AttcencesPresenter;
import com.yd.android_brand_mvp.user.AttenceActivity;
import com.yd.android_brand_mvp.utils.SpData;
import com.yd.android_brand_mvp.view.AttencesView;
import com.yd.android_brand_mvp.weight.MultiStateView;
import com.yd.android_brand_mvp.weight.recycleview.PagingScrollHelper;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public class AttencesFragment4_1_1P_list extends BaseMvpFragment<AttcencesPresenter> implements AttencesView, PagingScrollHelper.onPageChangeListener {
    List<AttenceExcBean> list;
    NewAttenceAdapter mAdapter;
    List<AttenceNewListBean.DataDTO> mListDTO = new ArrayList();

    @BindView(R.id.mu)
    MultiStateView mu;

    @BindView(R.id.rl_attence)
    RecyclerView rl_attence;

    @BindView(R.id.title)
    TextView title;
    String titles;
    Unbinder unbinder;

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
        initView();
    }

    void getAttenceCache() {
        AttenceNewListBean attenceNewListBean = (AttenceNewListBean) Hawk.get(BaseHawk.NEWATTENCE);
        if (attenceNewListBean == null || attenceNewListBean.data == null) {
            this.mu.setViewState(2);
        } else {
            setNewData(attenceNewListBean);
        }
    }

    @Override // com.yd.android_brand_mvp.base.BaseFragment, com.yd.android_brand_mvp.observer.MinaListener
    public void UpdataEvent(int i) {
        super.UpdataEvent(i);
        if (i == MinaConstants.ATTENCE_MODULE) {
            ((AttcencesPresenter) this.mvpPresenter).getAttencelist("");
        }
    }

    void initView() {
        this.title.setText("考勤");
        this.mAdapter = new NewAttenceAdapter(this.mActivity, this.mListDTO, R.layout.attence_item_4_1_2);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        linearLayoutManager.setOrientation(0);
        this.rl_attence.setLayoutManager(linearLayoutManager);
        this.rl_attence.setAdapter(this.mAdapter);
        this.mu.setOnErrorClicklistener(new MultiStateView.OnErrorClicklistener() { // from class: com.yd.android_brand_mvp.landscape.attence.AttencesFragment4_1_1P_list.1
            @Override // com.yd.android_brand_mvp.weight.MultiStateView.OnErrorClicklistener
            public void reload() {
                ((AttcencesPresenter) AttencesFragment4_1_1P_list.this.mvpPresenter).getAttencelist("");
            }
        });
        this.mAdapter.addOnclick(new NewAttenceAdapter.Onclick() { // from class: com.yd.android_brand_mvp.landscape.attence.AttencesFragment4_1_1P_list.2
            @Override // com.yd.android_brand_mvp.landscape.attence.NewAttenceAdapter.Onclick
            public void setOnAttClickListener(String str, String str2, String str3) {
                ((AttcencesPresenter) AttencesFragment4_1_1P_list.this.mvpPresenter).getAttencelist("");
            }
        });
    }

    @OnClick({R.id.tv_att, R.id.title})
    public void onClick(View view) {
        int id = view.getId();
        if (id == R.id.title || id == R.id.tv_att) {
            goPermissionsActivity(AttenceActivity.class);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        ((AttcencesPresenter) this.mvpPresenter).getAttencelist("");
        SPUtils.getInstance().put(SpData.AttenceEnable, "1");
        new Handler().postDelayed(new Runnable() { // from class: com.yd.android_brand_mvp.landscape.attence.AttencesFragment4_1_1P_list.3
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
    }

    @Override // com.yd.android_brand_mvp.base.BaseMvpFragment, androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
    }

    @Override // com.yd.android_brand_mvp.view.AttencesView
    public void getAttenceNewListSuccess(AttenceNewListBean attenceNewListBean) {
        if (attenceNewListBean.code == 0) {
            Hawk.delete(BaseHawk.NEWATTENCE);
            Hawk.put(BaseHawk.NEWATTENCE, attenceNewListBean);
            setNewData(attenceNewListBean);
            return;
        }
        this.mu.setViewState(2);
    }

    void setNewData(AttenceNewListBean attenceNewListBean) {
        this.mListDTO.clear();
        if (attenceNewListBean.data != null && attenceNewListBean.data.size() > 0) {
            this.mu.setViewState(0);
            this.mListDTO.addAll(attenceNewListBean.data);
            this.mAdapter.addCourseListDTO(this.mListDTO);
            return;
        }
        this.mu.setViewState(2);
    }

    @Override // com.yd.android_brand_mvp.view.AttencesView
    public void getAttenceListSuccessFail(String str) {
        getAttenceCache();
    }
}
