package com.yd.android_brand_mvp.verfity.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.blankj.utilcode.util.LogUtils;
import com.yd.android_brand_mvp.R;
import com.yd.android_brand_mvp.activity.YDWebViewActivity;
import com.yd.android_brand_mvp.base.BaseFragment;
import com.yd.android_brand_mvp.observer.ObserverListener;
import com.yd.android_brand_mvp.observer.ObserverManager;
import com.yd.android_brand_mvp.utils.ToastUtil;
import com.yd.android_brand_mvp.verfity.VerificationExternalActivity;
import com.yyide.facepass.database.DatabaseUtil;
import com.yyide.facepass.database.FacePeople;

/* JADX INFO: loaded from: classes4.dex */
public class CardFragment5 extends BaseFragment implements ObserverListener {
    VerificationExternalActivity activity;
    String cardNo;
    private String URL = "url";
    private String TITLE = "title";
    private String IDENTITY = "identity";

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return layoutInflater.inflate(R.layout.fragment_card, viewGroup, false);
    }

    @Override // com.yd.android_brand_mvp.base.BaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        this.activity = (VerificationExternalActivity) getActivity();
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        ObserverManager.getInstance().add(this);
    }

    @Override // androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        ObserverManager.getInstance().remove(this);
    }

    @Override // com.yd.android_brand_mvp.observer.ObserverListener
    public void observerUpData(String str) {
        String string;
        if (this.activity.getIndex() == 0) {
            this.cardNo = str;
            FacePeople facePeopleCard = DatabaseUtil.INSTANCE.getFacePeopleCard(this.mActivity, str);
            String string2 = "";
            if (getArguments() != null) {
                string2 = getArguments().getString("url");
                string = getArguments().getString("title");
            } else {
                string = "";
            }
            if (facePeopleCard != null) {
                LogUtils.i("TeacherCard 验证成功 " + str);
                Intent intent = new Intent(this.activity, (Class<?>) YDWebViewActivity.class);
                intent.putExtra(this.URL, string2);
                intent.putExtra(this.TITLE, string);
                intent.putExtra(this.IDENTITY, str);
                goPermissionsActivity(intent);
                getActivity().finish();
                return;
            }
            ToastUtil.showBottomView(this.mActivity, "未找到相应人员 " + str);
            LogUtils.e("TeacherCard 验证成功 " + str);
        }
    }
}
