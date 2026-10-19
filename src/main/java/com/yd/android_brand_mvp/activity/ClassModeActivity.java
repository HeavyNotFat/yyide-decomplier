package com.yd.android_brand_mvp.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import androidx.fragment.app.Fragment;
import com.blankj.utilcode.util.ActivityUtils;
import com.google.android.exoplayer2.text.ttml.TtmlNode;
import com.yd.android_brand_mvp.activity.fragment.ClassModeFragment;
import com.yd.android_brand_mvp.base.BaseConstant;
import com.yd.android_brand_mvp.base.BaseLayoutActivity;
import com.yd.android_brand_mvp.model.KBRsp2;
import com.yd.android_brand_mvp.utils.SimpleUtilsKt;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ClassModeActivity.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \r2\u00020\u0001:\u0001\rB\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0014J\b\u0010\u0005\u001a\u00020\u0006H\u0016J\b\u0010\u0007\u001a\u00020\bH\u0016J\b\u0010\t\u001a\u00020\u0004H\u0016J\u0012\u0010\n\u001a\u00020\u00042\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0014¨\u0006\u000e"}, d2 = {"Lcom/yd/android_brand_mvp/activity/ClassModeActivity;", "Lcom/yd/android_brand_mvp/base/BaseLayoutActivity;", "()V", "clickFinish", "", "getFragment", "Landroidx/fragment/app/Fragment;", "getName", "", "onBackPressed", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "Companion", "app_commonRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class ClassModeActivity extends BaseLayoutActivity {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final String PARAMS = "data";

    @Override // com.yd.android_brand_mvp.base.BaseLayoutActivity
    /* JADX INFO: renamed from: getName */
    public String getTitleName() {
        return "";
    }

    /* JADX INFO: compiled from: ClassModeActivity.kt */
    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J'\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e¢\u0006\u0002\u0010\u000fR\u0014\u0010\u0003\u001a\u00020\u0004X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0010"}, d2 = {"Lcom/yd/android_brand_mvp/activity/ClassModeActivity$Companion;", "", "()V", "PARAMS", "", "getPARAMS", "()Ljava/lang/String;", TtmlNode.START, "", "context", "Landroid/content/Context;", "timeTable", "Lcom/yd/android_brand_mvp/model/KBRsp2$DataDTO$TimetableListDTO;", "isShow", "", "(Landroid/content/Context;Lcom/yd/android_brand_mvp/model/KBRsp2$DataDTO$TimetableListDTO;Ljava/lang/Boolean;)V", "app_commonRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final String getPARAMS() {
            return ClassModeActivity.PARAMS;
        }

        public static /* synthetic */ void start$default(Companion companion, Context context, KBRsp2.DataDTO.TimetableListDTO timetableListDTO, Boolean bool, int i, Object obj) {
            if ((i & 4) != 0) {
                bool = false;
            }
            companion.start(context, timetableListDTO, bool);
        }

        public final void start(Context context, KBRsp2.DataDTO.TimetableListDTO timeTable, Boolean isShow) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(timeTable, "timeTable");
            Intent intent = new Intent(context, (Class<?>) ClassModeActivity.class);
            intent.putExtra(getPARAMS(), timeTable);
            intent.putExtra("isShow", isShow);
            ActivityUtils.startActivity(intent);
        }
    }

    @Override // com.yd.android_brand_mvp.base.BaseLayoutActivity, com.yd.android_brand_mvp.base.BaseActivity, skin.support.app.SkinCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getIntent().getBooleanExtra("isShow", false)) {
            FrameLayout back_layout = this.back_layout;
            Intrinsics.checkNotNullExpressionValue(back_layout, "back_layout");
            SimpleUtilsKt.hide(back_layout);
            RelativeLayout relativeLayout = this.rlBack;
            if (relativeLayout != null) {
                SimpleUtilsKt.hide(relativeLayout);
                return;
            }
            return;
        }
        FrameLayout back_layout2 = this.back_layout;
        Intrinsics.checkNotNullExpressionValue(back_layout2, "back_layout");
        SimpleUtilsKt.show(back_layout2);
        RelativeLayout relativeLayout2 = this.rlBack;
        if (relativeLayout2 != null) {
            SimpleUtilsKt.show(relativeLayout2);
        }
    }

    @Override // com.yd.android_brand_mvp.base.BaseLayoutActivity
    public Fragment getFragment() {
        this.isAutoClose = false;
        return ClassModeFragment.INSTANCE.newInstance((KBRsp2.DataDTO.TimetableListDTO) getIntent().getSerializableExtra(PARAMS));
    }

    @Override // com.yd.android_brand_mvp.base.BaseLayoutActivity
    protected void clickFinish() {
        super.clickFinish();
        BaseConstant.DOMINATE_CLOSE = true;
    }

    @Override // com.yd.android_brand_mvp.base.BaseLayoutActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        super.onBackPressed();
        BaseConstant.DOMINATE_CLOSE = true;
    }
}
