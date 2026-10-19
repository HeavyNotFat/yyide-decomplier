package com.yd.android_brand_mvp.portrait.fragment;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;
import com.alibaba.fastjson.JSON;
import com.blankj.utilcode.util.SPUtils;
import com.tencent.smtt.sdk.TbsListener;
import com.yd.android_brand_mvp.R;
import com.yd.android_brand_mvp.base.BaseMvpFragment;
import com.yd.android_brand_mvp.base.MinaConstants;
import com.yd.android_brand_mvp.model.SemesterTimeRsp;
import com.yd.android_brand_mvp.model.getNoticeRsp;
import com.yd.android_brand_mvp.network.base.BaseResponse;
import com.yd.android_brand_mvp.presenter.AnnouncementPresenter;
import com.yd.android_brand_mvp.user.AnnouncementListActivity;
import com.yd.android_brand_mvp.utils.AnncouncementUtils;
import com.yd.android_brand_mvp.utils.GlideUtil;
import com.yd.android_brand_mvp.utils.SpData;
import com.yd.android_brand_mvp.view.AnnouncementView;
import com.yd.android_brand_mvp.weight.MultiStateView;
import java.util.ArrayList;
import java.util.List;
import org.eclipse.paho.client.mqttv3.MqttTopic;
import skin.support.content.res.SkinCompatResources;

/* JADX INFO: loaded from: classes4.dex */
public class AnnouncementFragment4_2P extends BaseMvpFragment<AnnouncementPresenter> implements AnnouncementView {

    @BindView(R.id.content)
    LinearLayout content;

    @BindView(R.id.img)
    ImageView img;
    int index = 0;
    int layout;
    List<getNoticeRsp.DataDTO.RecordsDTO> list;

    @BindView(R.id.ll_content)
    LinearLayout llContent;

    @BindView(R.id.msglayout)
    RelativeLayout msglayout;

    @BindView(R.id.mu)
    MultiStateView mu;

    @BindView(R.id.title)
    TextView title;

    @BindView(R.id.tv_ann_title)
    TextView tvAnnTitle;

    @BindView(R.id.tv_content)
    TextView tvContent;

    @BindView(R.id.tv_count)
    TextView tvCount;

    @BindView(R.id.tv_issue_name)
    TextView tvIssueName;

    @BindView(R.id.tv_issue_time)
    TextView tvIssueTime;

    @BindView(R.id.tv_next_reference)
    TextView tvNextReference;

    @BindView(R.id.tv_previous_record)
    TextView tvPreviousRecord;
    String type;
    Unbinder unbinder;

    @Override // com.yd.android_brand_mvp.view.AnnouncementView
    public void getSemesterTimeFail(String str) {
    }

    @Override // com.yd.android_brand_mvp.view.AnnouncementView
    public void getSemesterTimeSuccess(BaseResponse<SemesterTimeRsp> baseResponse) {
    }

    public static AnnouncementFragment4_2P newInstance(String str) {
        return new AnnouncementFragment4_2P(str);
    }

    public AnnouncementFragment4_2P(String str) {
        this.type = str;
    }

    public AnnouncementFragment4_2P() {
    }

    private void setView(getNoticeRsp.DataDTO.RecordsDTO recordsDTO) {
        this.tvAnnTitle.setText(recordsDTO.title);
        this.tvIssueName.setText(recordsDTO.identityUserName);
        this.tvIssueTime.setText(recordsDTO.timerDate);
        if (recordsDTO.contentType == 0) {
            AnncouncementUtils.setHtmlToTextView(this.tvContent, recordsDTO.content);
            this.img.setVisibility(8);
            this.tvContent.setVisibility(0);
            this.msglayout.setVisibility(0);
            this.tvAnnTitle.setVisibility(0);
        } else {
            this.tvAnnTitle.setVisibility(8);
            this.msglayout.setVisibility(8);
            this.img.setVisibility(0);
            this.tvContent.setVisibility(8);
            GlideUtil.loadNomalImage(this.mActivity, recordsDTO.details.get(0).coverImg, this.img);
        }
        this.tvCount.setText((this.index + 1) + MqttTopic.TOPIC_LEVEL_SEPARATOR + this.list.size());
        if (this.list.size() > 1) {
            this.tvNextReference.setTextColor(SkinCompatResources.getInstance().getColor(R.color.purple2));
        }
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
        if (i == MinaConstants.Notice) {
            ((AnnouncementPresenter) this.mvpPresenter).getMyAnnouncement2("announcement ", 1);
        }
        this.index = 0;
    }

    private void judgeLandscape() {
        this.layout = R.layout.fragment_announcement4_2p;
    }

    @Override // com.yd.android_brand_mvp.base.BaseMvpFragment, com.yd.android_brand_mvp.base.BaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        setLayout();
        initView();
        ((AnnouncementPresenter) this.mvpPresenter).getMyAnnouncement2("announcement ", 1);
        this.mu.setOnErrorClicklistener(new MultiStateView.OnErrorClicklistener() { // from class: com.yd.android_brand_mvp.portrait.fragment.AnnouncementFragment4_2P.1
            @Override // com.yd.android_brand_mvp.weight.MultiStateView.OnErrorClicklistener
            public void reload() {
                ((AnnouncementPresenter) AnnouncementFragment4_2P.this.mvpPresenter).getMyAnnouncement2("announcement ", 1);
            }
        });
    }

    private void initView() {
        this.title.setText(R.string.st_inform_announcement);
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
    }

    void setLayout() {
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.content.getLayoutParams();
        if ("sbtzgg63".equals(this.type)) {
            layoutParams.width = 1000;
            layoutParams.height = 646;
        } else if ("sbtzgg42".equals(this.type)) {
            layoutParams.width = TbsListener.ErrorCode.STATIC_TBS_INSTALL_HAS_INSTALLED_EXCEPTION;
            layoutParams.height = TypedValues.CycleType.TYPE_WAVE_OFFSET;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.yd.android_brand_mvp.base.BaseMvpFragment
    public AnnouncementPresenter createPresenter() {
        return new AnnouncementPresenter(this);
    }

    @Override // com.yd.android_brand_mvp.base.BaseMvpFragment, com.yd.android_brand_mvp.base.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        Unbinder unbinder = this.unbinder;
        if (unbinder != null) {
            unbinder.unbind();
        }
    }

    @OnClick({R.id.tv_previous_record, R.id.tv_next_reference, R.id.title})
    public void onClick(View view) {
        int id = view.getId();
        if (id == R.id.title) {
            goPermissionsActivity(AnnouncementListActivity.class);
            return;
        }
        if (id != R.id.tv_next_reference) {
            if (id != R.id.tv_previous_record) {
                return;
            }
            int i = this.index - 1;
            this.index = i;
            if (i >= 0) {
                setView(this.list.get(i));
                this.tvPreviousRecord.setTextColor(SkinCompatResources.getInstance().getColor(R.color.purple2));
            } else {
                this.tvPreviousRecord.setTextColor(SkinCompatResources.getInstance().getColor(R.color.black3));
                this.index = 0;
            }
            setTextViewColor();
            return;
        }
        int size = this.list.size() - 1;
        int i2 = this.index;
        if (size <= i2) {
            this.tvNextReference.setTextColor(SkinCompatResources.getInstance().getColor(R.color.black3));
            this.index = this.list.size() - 1;
        } else if (i2 <= 5) {
            int i3 = i2 + 1;
            this.index = i3;
            setView(this.list.get(i3));
            this.tvNextReference.setTextColor(SkinCompatResources.getInstance().getColor(R.color.purple2));
        }
        setTextViewColor();
    }

    @Override // com.yd.android_brand_mvp.view.AnnouncementView
    public void getNewNoticeSuccess(getNoticeRsp getnoticersp) {
        Log.i("TAG", "getNewNoticeSuccess: " + JSON.toJSONString(getnoticersp));
        this.index = 0;
        if (getnoticersp.code.intValue() == 0) {
            SPUtils.getInstance().put(SpData.Announcement3, JSON.toJSONString(getnoticersp));
            this.list = getnoticersp.data.list;
            if (getnoticersp.data.list.size() > 0) {
                this.mu.setViewState(0);
                setView(this.list.get(this.index));
            } else {
                this.list = new ArrayList();
                this.mu.setViewState(2);
            }
        }
        setTextViewColor();
    }

    @Override // com.yd.android_brand_mvp.view.AnnouncementView
    public void getNewNoticeFail(String str) {
        if (SpData.getAnnouncement3() != null) {
            this.index = 0;
            this.list = SpData.getAnnouncement3().data.list;
            if (SpData.getAnnouncement3().data.list.size() > 0) {
                this.mu.setViewState(0);
                setView(this.list.get(this.index));
                return;
            } else {
                this.mu.setViewState(2);
                return;
            }
        }
        this.mu.setViewState(1);
    }

    private void setTextViewColor() {
        if (this.index > 0) {
            this.tvPreviousRecord.setTextColor(SkinCompatResources.getInstance().getColor(R.color.purple2));
        } else {
            this.tvPreviousRecord.setTextColor(SkinCompatResources.getInstance().getColor(R.color.black3));
        }
        if (this.list.size() > 1 && this.index < this.list.size() - 1) {
            this.tvNextReference.setTextColor(SkinCompatResources.getInstance().getColor(R.color.purple2));
        } else {
            this.tvNextReference.setTextColor(SkinCompatResources.getInstance().getColor(R.color.black3));
        }
    }
}
