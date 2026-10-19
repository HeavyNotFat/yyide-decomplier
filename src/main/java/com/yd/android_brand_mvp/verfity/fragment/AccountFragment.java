package com.yd.android_brand_mvp.verfity.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;
import butterknife.BindView;
import com.blankj.utilcode.util.ScreenUtils;
import com.yd.android_brand_mvp.R;
import com.yd.android_brand_mvp.SettingActivity;
import com.yd.android_brand_mvp.base.BaseFragment;
import com.yd.android_brand_mvp.portrait.activity.SettingPActivity;
import com.yd.android_brand_mvp.utils.ToastUtil;
import java.text.SimpleDateFormat;
import java.util.Date;

/* JADX INFO: loaded from: classes4.dex */
public class AccountFragment extends BaseFragment {

    @BindView(R.id.edit)
    EditText edit;

    @BindView(R.id.qd)
    TextView qd;

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return layoutInflater.inflate(R.layout.fragment_account, viewGroup, false);
    }

    @Override // com.yd.android_brand_mvp.base.BaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        this.qd.setOnClickListener(new View.OnClickListener() { // from class: com.yd.android_brand_mvp.verfity.fragment.-$$Lambda$AccountFragment$96v97KktGNJK4VNsvxi7Zc8vnVE
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                this.f$0.lambda$onViewCreated$0$AccountFragment(view2);
            }
        });
    }

    public /* synthetic */ void lambda$onViewCreated$0$AccountFragment(View view) {
        Identy();
    }

    void Identy() {
        if (TextUtils.isEmpty(this.edit.getText().toString())) {
            ToastUtil.showBottomView(this.mActivity, "请输入密码");
            return;
        }
        if (this.edit.getText().toString().equals("zhbp" + time())) {
            if (ScreenUtils.isLandscape()) {
                startActivity(new Intent(this.mActivity, (Class<?>) SettingActivity.class));
            } else {
                startActivity(new Intent(this.mActivity, (Class<?>) SettingPActivity.class));
            }
            getActivity().finish();
            return;
        }
        ToastUtil.showBottomView(this.mActivity, "密码不正确");
    }

    private String time() {
        return new SimpleDateFormat("yyyyMMdd").format(new Date(System.currentTimeMillis()));
    }
}
