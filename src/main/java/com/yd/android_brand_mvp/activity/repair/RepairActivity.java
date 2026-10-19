package com.yd.android_brand_mvp.activity.repair;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import com.google.android.exoplayer2.text.ttml.TtmlNode;
import com.yd.android_brand_mvp.base.BaseLayoutActivity;
import com.yd.android_brand_mvp.model.collect.UserVerifyBean;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: RepairActivity.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u00122\u00020\u0001:\u0001\u0012B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u000b\u001a\u00020\fH\u0016J\b\u0010\r\u001a\u00020\u0006H\u0016J\u0012\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0014R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lcom/yd/android_brand_mvp/activity/repair/RepairActivity;", "Lcom/yd/android_brand_mvp/base/BaseLayoutActivity;", "()V", "data", "Lcom/yd/android_brand_mvp/model/collect/UserVerifyBean;", "formContent", "", "formKey", "modifyFormId", "reason", "titleName", "getFragment", "Landroidx/fragment/app/Fragment;", "getName", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "Companion", "app_commonRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class RepairActivity extends BaseLayoutActivity {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private UserVerifyBean data;
    private String titleName = "报修";
    private String formContent = "";
    private String formKey = "";
    private String reason = "";
    private String modifyFormId = "";

    @JvmStatic
    public static final void start(Context context, UserVerifyBean userVerifyBean, String str) {
        INSTANCE.start(context, userVerifyBean, str);
    }

    @JvmStatic
    public static final void startFromModify(Context context, UserVerifyBean userVerifyBean, String str, String str2, String str3, String str4) {
        INSTANCE.startFromModify(context, userVerifyBean, str, str2, str3, str4);
    }

    /* JADX INFO: compiled from: RepairActivity.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\"\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\nH\u0007J8\u0010\u000b\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\n2\u0006\u0010\u000f\u001a\u00020\nH\u0007¨\u0006\u0010"}, d2 = {"Lcom/yd/android_brand_mvp/activity/repair/RepairActivity$Companion;", "", "()V", TtmlNode.START, "", "context", "Landroid/content/Context;", "verifyBean", "Lcom/yd/android_brand_mvp/model/collect/UserVerifyBean;", "titleName", "", "startFromModify", "formJsonStr", "formKey", "formId", "modifyReason", "app_commonRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public static /* synthetic */ void start$default(Companion companion, Context context, UserVerifyBean userVerifyBean, String str, int i, Object obj) {
            if ((i & 4) != 0) {
                str = "报修";
            }
            companion.start(context, userVerifyBean, str);
        }

        @JvmStatic
        public final void start(Context context, UserVerifyBean verifyBean, String titleName) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(verifyBean, "verifyBean");
            Intrinsics.checkNotNullParameter(titleName, "titleName");
            Intent intentPutExtra = new Intent(context, (Class<?>) RepairActivity.class).putExtra("verifyData", verifyBean).putExtra("activityName", titleName);
            Intrinsics.checkNotNullExpressionValue(intentPutExtra, "Intent(context, RepairAc…activityName\", titleName)");
            context.startActivity(intentPutExtra);
        }

        @JvmStatic
        public final void startFromModify(Context context, UserVerifyBean verifyBean, String formJsonStr, String formKey, String formId, String modifyReason) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(verifyBean, "verifyBean");
            Intrinsics.checkNotNullParameter(formJsonStr, "formJsonStr");
            Intrinsics.checkNotNullParameter(formKey, "formKey");
            Intrinsics.checkNotNullParameter(formId, "formId");
            Intrinsics.checkNotNullParameter(modifyReason, "modifyReason");
            Intent intentPutExtra = new Intent(context, (Class<?>) RepairActivity.class).putExtra("verifyData", verifyBean).putExtra("activityName", "报修(修改)").putExtra("formContent", formJsonStr).putExtra("formKey", formKey).putExtra("modifyFormId", formId).putExtra("reason", modifyReason);
            Intrinsics.checkNotNullExpressionValue(intentPutExtra, "Intent(context, RepairAc…a(\"reason\", modifyReason)");
            context.startActivity(intentPutExtra);
        }
    }

    @Override // com.yd.android_brand_mvp.base.BaseLayoutActivity, com.yd.android_brand_mvp.base.BaseActivity, skin.support.app.SkinCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        UserVerifyBean userVerifyBean = (UserVerifyBean) getIntent().getParcelableExtra("verifyData");
        if (userVerifyBean == null) {
            userVerifyBean = new UserVerifyBean(false, null, null, null, 15, null);
        }
        this.data = userVerifyBean;
        String stringExtra = getIntent().getStringExtra("activityName");
        if (stringExtra == null) {
            stringExtra = "报修";
        }
        this.titleName = stringExtra;
        String stringExtra2 = getIntent().getStringExtra("formContent");
        if (stringExtra2 == null) {
            stringExtra2 = "";
        }
        this.formContent = stringExtra2;
        String stringExtra3 = getIntent().getStringExtra("formKey");
        if (stringExtra3 == null) {
            stringExtra3 = "";
        }
        this.formKey = stringExtra3;
        String stringExtra4 = getIntent().getStringExtra("reason");
        if (stringExtra4 == null) {
            stringExtra4 = "";
        }
        this.reason = stringExtra4;
        String stringExtra5 = getIntent().getStringExtra("modifyFormId");
        this.modifyFormId = stringExtra5 != null ? stringExtra5 : "";
        super.onCreate(savedInstanceState);
    }

    @Override // com.yd.android_brand_mvp.base.BaseLayoutActivity
    public Fragment getFragment() {
        if (this.formKey.length() == 0) {
            RepairFragment.Companion companion = RepairFragment.INSTANCE;
            UserVerifyBean userVerifyBean = this.data;
            Intrinsics.checkNotNull(userVerifyBean);
            return companion.newInstance(userVerifyBean);
        }
        RepairFragment.Companion companion2 = RepairFragment.INSTANCE;
        UserVerifyBean userVerifyBean2 = this.data;
        Intrinsics.checkNotNull(userVerifyBean2);
        return companion2.newInstance(userVerifyBean2, this.formContent, this.formKey, this.reason, this.modifyFormId);
    }

    @Override // com.yd.android_brand_mvp.base.BaseLayoutActivity
    /* JADX INFO: renamed from: getName, reason: from getter */
    public String getTitleName() {
        return this.titleName;
    }
}
