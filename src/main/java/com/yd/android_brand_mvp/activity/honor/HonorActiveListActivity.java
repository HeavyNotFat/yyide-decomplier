package com.yd.android_brand_mvp.activity.honor;

import androidx.fragment.app.Fragment;
import com.yd.android_brand_mvp.activity.fragment.honor.HonorActiveListFragment;
import com.yd.android_brand_mvp.base.BaseLayoutActivity;
import kotlin.Metadata;

/* JADX INFO: compiled from: HonorActiveListActivity.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016J\b\u0010\u0005\u001a\u00020\u0006H\u0016¨\u0006\u0007"}, d2 = {"Lcom/yd/android_brand_mvp/activity/honor/HonorActiveListActivity;", "Lcom/yd/android_brand_mvp/base/BaseLayoutActivity;", "()V", "getFragment", "Landroidx/fragment/app/Fragment;", "getName", "", "app_commonRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class HonorActiveListActivity extends BaseLayoutActivity {
    @Override // com.yd.android_brand_mvp.base.BaseLayoutActivity
    /* JADX INFO: renamed from: getName */
    public String getTitleName() {
        return "学生评价活动列表";
    }

    @Override // com.yd.android_brand_mvp.base.BaseLayoutActivity
    public Fragment getFragment() {
        return HonorActiveListFragment.INSTANCE.newInstance();
    }
}
