package com.yd.android_brand_mvp.landscape;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.work.WorkRequest;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import com.alibaba.fastjson.JSON;
import com.yd.android_brand_mvp.ClassStudentMsg;
import com.yd.android_brand_mvp.R;
import com.yd.android_brand_mvp.adapter.BannerStudentMessageAdapter;
import com.yd.android_brand_mvp.base.BaseMvpFragment;
import com.yd.android_brand_mvp.base.MinaConstants;
import com.yd.android_brand_mvp.model.StudentCenterRsp;
import com.yd.android_brand_mvp.model.StudentMsgBean;
import com.yd.android_brand_mvp.presenter.StudenCenterPresenter;
import com.yd.android_brand_mvp.verfity.StudentCheackActivity;
import com.yd.android_brand_mvp.view.StudenCenterView;
import com.yd.android_brand_mvp.weight.MultiStateView;
import com.youth.banner.Banner;
import com.youth.banner.indicator.CircleIndicator;
import com.youth.banner.listener.OnBannerListener;
import com.youth.banner.util.BannerUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import skin.support.content.res.SkinCompatResources;

/* JADX INFO: loaded from: classes4.dex */
public class StudentCenter2_2L extends BaseMvpFragment<StudenCenterPresenter> implements StudenCenterView {
    Handler handler = new AnonymousClass4();

    @BindView(R.id.banner_fragment)
    Banner mBanner;
    BannerStudentMessageAdapter mBannerStudentMessageAdapter;

    @BindView(R.id.mu)
    MultiStateView mu;

    @BindView(R.id.title)
    TextView title;
    Unbinder unbinder;

    @Override // com.yd.android_brand_mvp.view.StudenCenterView
    public void getFail(String str) {
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View viewInflate = layoutInflater.inflate(R.layout.fragment_studentcenter_l2x2, viewGroup, false);
        this.unbinder = ButterKnife.bind(this, viewInflate);
        return viewInflate;
    }

    @Override // com.yd.android_brand_mvp.base.BaseMvpFragment, com.yd.android_brand_mvp.base.BaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        this.title.setText(R.string.st_class_center);
        this.mu.setViewState(2);
        this.mu.findViewById(R.id.retry).setOnClickListener(new View.OnClickListener() { // from class: com.yd.android_brand_mvp.landscape.StudentCenter2_2L.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
            }
        });
        this.mBanner.setOnBannerListener(new OnBannerListener() { // from class: com.yd.android_brand_mvp.landscape.StudentCenter2_2L.2
            @Override // com.youth.banner.listener.OnBannerListener
            public void OnBannerClick(Object obj, int i) {
                StudentCenter2_2L.this.goPermissionsActivity(StudentCheackActivity.class);
            }
        });
        this.title.setOnClickListener(new View.OnClickListener() { // from class: com.yd.android_brand_mvp.landscape.StudentCenter2_2L.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                StudentCenter2_2L.this.goPermissionsActivity(StudentCheackActivity.class);
            }
        });
        this.mBannerStudentMessageAdapter = new BannerStudentMessageAdapter(getContext(), 4, null);
        this.mBanner.addBannerLifecycleObserver(this).setStartPosition(1).setAdapter(this.mBannerStudentMessageAdapter).isAutoLoop(true).setLoopTime(WorkRequest.MIN_BACKOFF_MILLIS).setIndicator(new CircleIndicator(requireContext())).setIndicatorGravity(1).setIndicatorSpace(BannerUtils.dp2px(10.0f)).setIndicatorNormalColor(SkinCompatResources.getInstance().getColor(R.color.gray)).setIndicatorSelectedColor(SkinCompatResources.getInstance().getColor(R.color.blue12)).setIndicatorWidth(BannerUtils.dp2px(10.0f), BannerUtils.dp2px(10.0f)).setIndicatorHeight(BannerUtils.dp2px(10.0f));
    }

    public static List<List<StudentMsgBean.Data0>> splitList(List<StudentMsgBean.Data0> list, int i) {
        int size = list.size();
        int i2 = ((size + i) - 1) / i;
        ArrayList arrayList = new ArrayList(i2);
        int i3 = 0;
        while (i3 < i2) {
            int i4 = i3 * i;
            i3++;
            arrayList.add(list.subList(i4, Math.min(i3 * i, size)));
        }
        return arrayList;
    }

    @Override // com.yd.android_brand_mvp.base.BaseFragment, com.yd.android_brand_mvp.observer.MinaListener
    public void UpdataEvent(int i) {
        super.UpdataEvent(i);
        if (i == MinaConstants.StudentMsg) {
            Log.e("StudentCenter2_2L", "StudentMsg: ");
            Message message = new Message();
            message.what = 1;
            this.handler.sendMessage(message);
        }
    }

    /* JADX INFO: renamed from: com.yd.android_brand_mvp.landscape.StudentCenter2_2L$4, reason: invalid class name */
    class AnonymousClass4 extends Handler {
        AnonymousClass4() {
        }

        @Override // android.os.Handler
        public void handleMessage(final Message message) {
            super.handleMessage(message);
            StudentCenter2_2L.this.mActivity.runOnUiThread(new Runnable() { // from class: com.yd.android_brand_mvp.landscape.-$$Lambda$StudentCenter2_2L$4$mOsadj94gbsEFdNH1v4oPRzOhPg
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$handleMessage$0$StudentCenter2_2L$4(message);
                }
            });
        }

        public /* synthetic */ void lambda$handleMessage$0$StudentCenter2_2L$4(Message message) {
            if (message.what == 1) {
                StudentCenter2_2L.this.setStudentData();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setStudentData() {
        List<StudentMsgBean.Data0> list = ClassStudentMsg.getInstance().list;
        if (list.size() > 0) {
            ArrayList arrayList = new ArrayList();
            for (StudentMsgBean.Data0 data0 : list) {
                if (data0.msgNum != 0 && !isHaveId(data0.id, arrayList)) {
                    arrayList.add(data0);
                }
            }
            this.mBanner.setDatas(splitList(arrayList, 8));
            this.mu.setViewState(0);
            if (arrayList.size() == 0) {
                this.mu.setViewState(2);
                return;
            }
            return;
        }
        this.mu.setViewState(2);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.yd.android_brand_mvp.base.BaseMvpFragment
    public StudenCenterPresenter createPresenter() {
        return new StudenCenterPresenter(this);
    }

    @Override // com.yd.android_brand_mvp.view.StudenCenterView
    public void getDataSuccess(StudentCenterRsp studentCenterRsp) {
        Log.e("TAG", "StudentCenterRsp: " + JSON.toJSONString(studentCenterRsp));
    }

    boolean isHaveId(long j, List<StudentMsgBean.Data0> list) {
        Iterator<StudentMsgBean.Data0> it2 = list.iterator();
        while (it2.hasNext()) {
            if (it2.next().id == j) {
                return true;
            }
        }
        return false;
    }

    @Override // com.yd.android_brand_mvp.base.BaseMvpFragment, com.yd.android_brand_mvp.base.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
    }
}
