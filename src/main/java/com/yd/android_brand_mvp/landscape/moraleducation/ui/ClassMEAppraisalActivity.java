package com.yd.android_brand_mvp.landscape.moraleducation.ui;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import com.blankj.utilcode.util.ActivityUtils;
import com.blankj.utilcode.util.LogUtils;
import com.google.android.exoplayer2.text.ttml.TtmlNode;
import com.vivo.push.PushClientConstants;
import com.yd.android_brand_mvp.base.BaseLayoutActivity;
import com.yd.android_brand_mvp.landscape.exam.comments.CommentsHomeFragment;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ClassMEAppraisalActivity.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u000b2\u00020\u0001:\u0001\u000bB\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016J\b\u0010\u0005\u001a\u00020\u0006H\u0016J\u0012\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0014¨\u0006\f"}, d2 = {"Lcom/yd/android_brand_mvp/landscape/moraleducation/ui/ClassMEAppraisalActivity;", "Lcom/yd/android_brand_mvp/base/BaseLayoutActivity;", "()V", "getFragment", "Landroidx/fragment/app/Fragment;", "getName", "", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "Companion", "app_commonRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class ClassMEAppraisalActivity extends BaseLayoutActivity {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final String PARAMS = "data";
    private static String mTitle = "";

    @Override // com.yd.android_brand_mvp.base.BaseLayoutActivity, com.yd.android_brand_mvp.base.BaseActivity, skin.support.app.SkinCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        LogUtils.i(ClassMEAppraisalActivity.class.getName(), "onCreate...");
    }

    /* JADX INFO: compiled from: ClassMEAppraisalActivity.kt */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0090\u0001\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u00042\b\u0010\u0010\u001a\u0004\u0018\u00010\u00042\b\u0010\u0011\u001a\u0004\u0018\u00010\u00042\b\u0010\u0012\u001a\u0004\u0018\u00010\u00042\b\u0010\u0013\u001a\u0004\u0018\u00010\u00042\b\u0010\u0014\u001a\u0004\u0018\u00010\u00042\b\u0010\u0015\u001a\u0004\u0018\u00010\u00042\b\u0010\u0016\u001a\u0004\u0018\u00010\u00042\b\u0010\u0017\u001a\u0004\u0018\u00010\u00042\b\u0010\u0018\u001a\u0004\u0018\u00010\u00042\b\u0010\u0019\u001a\u0004\u0018\u00010\u00042\b\u0010\u001a\u001a\u0004\u0018\u00010\u00042\b\u0010\u001b\u001a\u0004\u0018\u00010\u0004R\u0014\u0010\u0003\u001a\u00020\u0004X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\u0007\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\u0006\"\u0004\b\t\u0010\n¨\u0006\u001c"}, d2 = {"Lcom/yd/android_brand_mvp/landscape/moraleducation/ui/ClassMEAppraisalActivity$Companion;", "", "()V", "PARAMS", "", "getPARAMS", "()Ljava/lang/String;", "mTitle", "getMTitle", "setMTitle", "(Ljava/lang/String;)V", TtmlNode.START, "", "context", "Landroid/content/Context;", "title", "userName", PushClientConstants.TAG_CLASS_NAME, "cycle", "schoolId", "activityId", "cycleId", "fromGroupId", "fromPersonId", "toObjId", "toObjName", "teacherId", CommentsHomeFragment.TYPE_ID, "app_commonRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final String getPARAMS() {
            return ClassMEAppraisalActivity.PARAMS;
        }

        public final String getMTitle() {
            return ClassMEAppraisalActivity.mTitle;
        }

        public final void setMTitle(String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            ClassMEAppraisalActivity.mTitle = str;
        }

        public final void start(Context context, String title, String userName, String className, String cycle, String schoolId, String activityId, String cycleId, String fromGroupId, String fromPersonId, String toObjId, String toObjName, String teacherId, String studentId) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intent intent = new Intent(context, (Class<?>) ClassMEAppraisalActivity.class);
            setMTitle(title == null ? "" : title);
            intent.putExtra("userName", userName);
            intent.putExtra(PushClientConstants.TAG_CLASS_NAME, className);
            intent.putExtra("cycle", cycle);
            intent.putExtra("schoolId", schoolId);
            intent.putExtra("activityId", activityId);
            intent.putExtra("cycleId", cycleId);
            intent.putExtra("fromGroupId", fromGroupId);
            intent.putExtra("fromPersonId", fromPersonId);
            intent.putExtra("toObjId", toObjId);
            intent.putExtra("toObjName", toObjName);
            intent.putExtra("teacherId", teacherId);
            intent.putExtra(CommentsHomeFragment.TYPE_ID, studentId);
            ActivityUtils.startActivity(intent);
        }
    }

    @Override // com.yd.android_brand_mvp.base.BaseLayoutActivity
    public Fragment getFragment() {
        return ClassMEAppraisalFragment.INSTANCE.newInstance(getIntent().getStringExtra("userName"), getIntent().getStringExtra(PushClientConstants.TAG_CLASS_NAME), getIntent().getStringExtra("cycle"), getIntent().getStringExtra("schoolId"), getIntent().getStringExtra("activityId"), getIntent().getStringExtra("cycleId"), getIntent().getStringExtra("fromGroupId"), getIntent().getStringExtra("fromPersonId"), getIntent().getStringExtra("toObjId"), getIntent().getStringExtra("toObjName"), getIntent().getStringExtra("teacherId"), getIntent().getStringExtra(CommentsHomeFragment.TYPE_ID));
    }

    @Override // com.yd.android_brand_mvp.base.BaseLayoutActivity
    /* JADX INFO: renamed from: getName */
    public String getTitleName() {
        return mTitle;
    }
}
