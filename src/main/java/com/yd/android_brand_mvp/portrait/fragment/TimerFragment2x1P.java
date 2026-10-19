package com.yd.android_brand_mvp.portrait.fragment;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.alibaba.fastjson.JSON;
import com.blankj.utilcode.util.SPUtils;
import com.jude.rollviewpager.RollPagerView;
import com.jude.rollviewpager.hintview.ColorPointHintView;
import com.yd.android_brand_mvp.R;
import com.yd.android_brand_mvp.adapter.AnnounAdapter7;
import com.yd.android_brand_mvp.base.BaseMvpFragment;
import com.yd.android_brand_mvp.base.MinaConstants;
import com.yd.android_brand_mvp.model.TimelistRsp;
import com.yd.android_brand_mvp.presenter.TimerPresenter;
import com.yd.android_brand_mvp.user.TimerActivity;
import com.yd.android_brand_mvp.utils.SpData;
import com.yd.android_brand_mvp.view.TimelistView;
import com.yd.android_brand_mvp.weight.MultiStateView;
import skin.support.content.res.SkinCompatResources;

/* JADX INFO: loaded from: classes4.dex */
public class TimerFragment2x1P extends BaseMvpFragment<TimerPresenter> implements TimelistView {
    AnnounAdapter7 announAdapter;

    @BindView(R.id.announRoll)
    RollPagerView announRoll;

    @BindView(R.id.fitem)
    FrameLayout item;

    @BindView(R.id.iv_img)
    ImageView iv_img;

    @BindView(R.id.mu)
    MultiStateView mu;

    @BindView(R.id.title)
    TextView title;

    @BindView(R.id.tv_content)
    TextView tv_content;

    @BindView(R.id.tv_num)
    TextView tv_num;

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View viewInflate = layoutInflater.inflate(R.layout.fragment_timer_p2x21, viewGroup, false);
        ButterKnife.bind(this, viewInflate);
        return viewInflate;
    }

    @Override // com.yd.android_brand_mvp.base.BaseMvpFragment, com.yd.android_brand_mvp.base.BaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        this.title.setText(R.string.timer);
        ((TimerPresenter) this.mvpPresenter).getTimelist();
        AnnounAdapter7 announAdapter7 = new AnnounAdapter7(this.announRoll);
        this.announAdapter = announAdapter7;
        this.announRoll.setAdapter(announAdapter7);
        this.mu.findViewById(R.id.retry).setOnClickListener(new View.OnClickListener() { // from class: com.yd.android_brand_mvp.portrait.fragment.TimerFragment2x1P.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                ((TimerPresenter) TimerFragment2x1P.this.mvpPresenter).getTimelist();
            }
        });
        this.title.setOnClickListener(new View.OnClickListener() { // from class: com.yd.android_brand_mvp.portrait.fragment.TimerFragment2x1P.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                TimerFragment2x1P.this.goPermissionsActivity(TimerActivity.class);
            }
        });
        this.announRoll.setPlayDelay(10000);
    }

    @Override // com.yd.android_brand_mvp.base.BaseFragment, com.yd.android_brand_mvp.observer.MinaListener
    public void UpdataEvent(int i) {
        super.UpdataEvent(i);
        if (i == MinaConstants.Timer) {
            ((TimerPresenter) this.mvpPresenter).getTimelist();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        this.announRoll.pause();
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        this.announRoll.resume();
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
        Log.i("TAG", "TimelistRsp: " + JSON.toJSONString(timelistRsp));
        if (timelistRsp.code == 0) {
            if (timelistRsp.data.size() > 0) {
                SPUtils.getInstance().put(SpData.Timelist, JSON.toJSONString(timelistRsp));
                this.mu.setViewState(0);
                setView(timelistRsp);
                return;
            }
            this.mu.setViewState(2);
        }
    }

    @Override // com.yd.android_brand_mvp.view.TimelistView
    public void getFail(String str) {
        if (SpData.getTimelist() != null) {
            if (SpData.getTimelist().data.size() > 0) {
                this.mu.setViewState(0);
                setView(SpData.getTimelist());
                return;
            } else {
                this.mu.setViewState(2);
                return;
            }
        }
        this.mu.setViewState(1);
    }

    private void setView(TimelistRsp timelistRsp) {
        if (timelistRsp.data.size() > 1) {
            this.announAdapter.notifyData(timelistRsp.data);
            this.announRoll.setHintView(new ColorPointHintView(this.mActivity, SkinCompatResources.getInstance().getColor(R.color.blue3), SkinCompatResources.getInstance().getColor(R.color.black17)));
            this.item.setVisibility(8);
            this.announRoll.setVisibility(0);
            return;
        }
        if (timelistRsp.data.size() == 1) {
            this.item.setVisibility(0);
            this.announRoll.setVisibility(8);
            this.announRoll.setHintView(null);
            if (timelistRsp.data != null && timelistRsp.data.get(0) != null) {
                this.tv_content.setText("距离" + timelistRsp.data.get(0).activityTheme);
            }
            this.tv_num.setText(timelistRsp.data.get(0).countDown + "");
            if ("1".equals(timelistRsp.data.get(0).templateUrl)) {
                this.iv_img.setBackgroundResource(R.drawable.icon_timer_bg1);
            } else if ("2".equals(timelistRsp.data.get(0).templateUrl)) {
                this.iv_img.setBackgroundResource(R.drawable.icon_timer_bg2);
            } else if ("3".equals(timelistRsp.data.get(0).templateUrl)) {
                this.iv_img.setBackgroundResource(R.drawable.icon_timer_bg3);
            }
        }
    }
}
