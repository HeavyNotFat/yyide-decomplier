package com.yd.android_brand_mvp.activity.exam;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import com.yd.android_brand_mvp.activity.exam.fragment.ExamDetailFragment;
import com.yd.android_brand_mvp.base.BaseLayoutActivity;
import com.yd.android_brand_mvp.model.exam.ExamPlanItem;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ExamArrangementDetailActivity.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u000f2\u00020\u0001:\u0001\u000fB\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0007\u001a\u00020\bH\u0016J\b\u0010\t\u001a\u00020\nH\u0016J\u0012\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0014R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lcom/yd/android_brand_mvp/activity/exam/ExamArrangementDetailActivity;", "Lcom/yd/android_brand_mvp/base/BaseLayoutActivity;", "()V", "dataBean", "Lcom/yd/android_brand_mvp/model/exam/ExamPlanItem;", "isPort", "", "getFragment", "Landroidx/fragment/app/Fragment;", "getName", "", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "Companion", "app_commonRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class ExamArrangementDetailActivity extends BaseLayoutActivity {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private ExamPlanItem dataBean = new ExamPlanItem(null, null, 0, null, 0, null, 0, null, 0, null, false, false, null, 0, null, 0, null, null, null, null, 0, 0, 0, false, 16777215, null);
    private boolean isPort;

    @Override // com.yd.android_brand_mvp.base.BaseLayoutActivity
    public String getName() {
        return "考试安排";
    }

    /* JADX INFO: compiled from: ExamArrangementDetailActivity.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n¨\u0006\u000b"}, d2 = {"Lcom/yd/android_brand_mvp/activity/exam/ExamArrangementDetailActivity$Companion;", "", "()V", "startGo", "", "context", "Landroid/content/Context;", "isPortrait", "", "data", "Lcom/yd/android_brand_mvp/model/exam/ExamPlanItem;", "app_commonRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final void startGo(Context context, boolean isPortrait, ExamPlanItem data) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(data, "data");
            Intent intent = new Intent(context, (Class<?>) ExamArrangementDetailActivity.class);
            intent.putExtra("isPortrait", isPortrait);
            intent.putExtra("data", data);
            context.startActivity(intent);
        }
    }

    @Override // com.yd.android_brand_mvp.base.BaseLayoutActivity, com.yd.android_brand_mvp.base.BaseActivity, skin.support.app.SkinCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        this.isPort = getIntent().getBooleanExtra("isPortrait", false);
        ExamPlanItem examPlanItem = (ExamPlanItem) getIntent().getParcelableExtra("data");
        if (examPlanItem == null) {
            examPlanItem = new ExamPlanItem(null, null, 0, null, 0, null, 0, null, 0, null, false, false, null, 0, null, 0, null, null, null, null, 0, 0, 0, false, 16777215, null);
        }
        this.dataBean = examPlanItem;
        super.onCreate(savedInstanceState);
    }

    @Override // com.yd.android_brand_mvp.base.BaseLayoutActivity
    public Fragment getFragment() {
        return ExamDetailFragment.INSTANCE.newInstance(this.isPort, this.dataBean);
    }
}
