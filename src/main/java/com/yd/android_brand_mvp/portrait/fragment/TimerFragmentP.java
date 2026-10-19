package com.yd.android_brand_mvp.portrait.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import android.widget.ListView;
import butterknife.BindView;
import com.yd.android_brand_mvp.R;
import com.yd.android_brand_mvp.adapter.TimerAdapter;
import com.yd.android_brand_mvp.base.BaseMvpFragment;
import com.yd.android_brand_mvp.model.TimelistRsp;
import com.yd.android_brand_mvp.presenter.TimerPresenter;
import com.yd.android_brand_mvp.view.TimelistView;
import com.yd.android_brand_mvp.weight.MultiStateView;

/* JADX INFO: loaded from: classes4.dex */
public class TimerFragmentP extends BaseMvpFragment<TimerPresenter> implements TimelistView {

    @BindView(R.id.lvlist)
    ListView lvlist;

    @BindView(R.id.mu)
    MultiStateView mu;
    TimerAdapter timerAdapter;
    View view;

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View viewInflate = layoutInflater.inflate(R.layout.fragment_timer_p, viewGroup, false);
        this.view = viewInflate;
        return viewInflate;
    }

    @Override // com.yd.android_brand_mvp.base.BaseMvpFragment, com.yd.android_brand_mvp.base.BaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        ((TimerPresenter) this.mvpPresenter).getTimelist();
        if (!this.mActivity.isDestroyed()) {
            this.bookLoadingDiallog.show();
        }
        TimerAdapter timerAdapter = new TimerAdapter(this.mActivity, R.layout.timer_item_p);
        this.timerAdapter = timerAdapter;
        this.lvlist.setAdapter((ListAdapter) timerAdapter);
        this.mu.setOnErrorClicklistener(new MultiStateView.OnErrorClicklistener() { // from class: com.yd.android_brand_mvp.portrait.fragment.TimerFragmentP.1
            @Override // com.yd.android_brand_mvp.weight.MultiStateView.OnErrorClicklistener
            public void reload() {
                ((TimerPresenter) TimerFragmentP.this.mvpPresenter).getTimelist();
                if (TimerFragmentP.this.mActivity.isDestroyed()) {
                    return;
                }
                TimerFragmentP.this.bookLoadingDiallog.show();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.yd.android_brand_mvp.base.BaseMvpFragment
    public TimerPresenter createPresenter() {
        return new TimerPresenter(this);
    }

    @Override // com.yd.android_brand_mvp.base.BaseMvpFragment, androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
    }

    @Override // com.yd.android_brand_mvp.view.TimelistView
    public void getDataSuccess(TimelistRsp timelistRsp) {
        if (!this.mActivity.isDestroyed()) {
            this.bookLoadingDiallog.dismiss();
        }
        if (timelistRsp.code == 0) {
            this.timerAdapter.notifyData(timelistRsp.data);
            if (timelistRsp.data == null || timelistRsp.data.size() == 0) {
                this.mu.setViewState(2);
            } else {
                this.mu.setViewState(0);
            }
        }
    }

    @Override // com.yd.android_brand_mvp.view.TimelistView
    public void getFail(String str) {
        this.mu.setViewState(1);
        if (this.mActivity.isDestroyed()) {
            return;
        }
        this.bookLoadingDiallog.dismiss();
    }

    @Override // com.yd.android_brand_mvp.base.BaseMvpFragment, com.yd.android_brand_mvp.base.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
    }
}
