package com.yd.android_brand_mvp.verfity;

import android.content.Context;
import android.content.Intent;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import androidx.activity.result.ActivityResultLauncher;
import androidx.core.app.NotificationCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.yd.android_brand_mvp.ClassCardPermisson;
import com.yd.android_brand_mvp.R;
import com.yd.android_brand_mvp.base.KTBaseTimerActivity;
import com.yd.android_brand_mvp.databinding.ActivityStudentLoginBinding;
import com.yd.android_brand_mvp.net.FragmentEventListener;
import com.yd.android_brand_mvp.verfity.fragment.AllCardFragment;
import com.yd.android_brand_mvp.verfity.fragment.AllFaceFragment;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: AllCheckActivity.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\u0018\u0000 \u001b2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u001bB\u0005¢\u0006\u0002\u0010\u0003J\u0012\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0016J\r\u0010\u0006\u001a\u00020\u0005H\u0007¢\u0006\u0002\b\u0015J\b\u0010\u0016\u001a\u00020\u0017H\u0014J\u0015\u0010\b\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0005H\u0007¢\u0006\u0002\b\u0019J\u0010\u0010\u001a\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0005H\u0002R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001c\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u000e\u0010\u0010\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001c"}, d2 = {"Lcom/yd/android_brand_mvp/verfity/AllCheckActivity;", "Lcom/yd/android_brand_mvp/base/KTBaseTimerActivity;", "Lcom/yd/android_brand_mvp/databinding/ActivityStudentLoginBinding;", "()V", FirebaseAnalytics.Param.INDEX, "", "getIndex", "()I", "setIndex", "(I)V", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lcom/yd/android_brand_mvp/net/FragmentEventListener;", "getListener", "()Lcom/yd/android_brand_mvp/net/FragmentEventListener;", "setListener", "(Lcom/yd/android_brand_mvp/net/FragmentEventListener;)V", "toDoType", "dispatchKeyEvent", "", NotificationCompat.CATEGORY_EVENT, "Landroid/view/KeyEvent;", "getIndex1", "initView", "", "position", "setIndex1", "setTab", "Companion", "app_commonRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class AllCheckActivity extends KTBaseTimerActivity<ActivityStudentLoginBinding> {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private int index;
    private FragmentEventListener listener;
    private int toDoType;

    /* JADX INFO: renamed from: com.yd.android_brand_mvp.verfity.AllCheckActivity$1, reason: invalid class name */
    /* JADX INFO: compiled from: AllCheckActivity.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements Function1<LayoutInflater, ActivityStudentLoginBinding> {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        AnonymousClass1() {
            super(1, ActivityStudentLoginBinding.class, "inflate", "inflate(Landroid/view/LayoutInflater;)Lcom/yd/android_brand_mvp/databinding/ActivityStudentLoginBinding;", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public final ActivityStudentLoginBinding invoke(LayoutInflater p0) {
            Intrinsics.checkNotNullParameter(p0, "p0");
            return ActivityStudentLoginBinding.inflate(p0);
        }
    }

    public AllCheckActivity() {
        super(AnonymousClass1.INSTANCE);
        this.toDoType = -1;
        this.index = -1;
    }

    /* JADX INFO: compiled from: AllCheckActivity.kt */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\bJ*\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\b\u0002\u0010\u0007\u001a\u00020\b2\u000e\u0010\t\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\n¨\u0006\f"}, d2 = {"Lcom/yd/android_brand_mvp/verfity/AllCheckActivity$Companion;", "", "()V", "startGo", "", "context", "Landroid/content/Context;", "toDoType", "", "launcher", "Landroidx/activity/result/ActivityResultLauncher;", "Landroid/content/Intent;", "app_commonRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public static /* synthetic */ void startGo$default(Companion companion, Context context, int i, int i2, Object obj) {
            if ((i2 & 2) != 0) {
                i = 0;
            }
            companion.startGo(context, i);
        }

        public final void startGo(Context context, int toDoType) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intent intent = new Intent(context, (Class<?>) AllCheckActivity.class);
            intent.putExtra("toDoType", toDoType);
            context.startActivity(intent);
        }

        public static /* synthetic */ void startGo$default(Companion companion, Context context, int i, ActivityResultLauncher activityResultLauncher, int i2, Object obj) {
            if ((i2 & 2) != 0) {
                i = 0;
            }
            companion.startGo(context, i, activityResultLauncher);
        }

        public final void startGo(Context context, int toDoType, ActivityResultLauncher<Intent> launcher) {
            Intrinsics.checkNotNullParameter(launcher, "launcher");
            Intent intent = new Intent(context, (Class<?>) AllCheckActivity.class);
            intent.putExtra("toDoType", toDoType);
            launcher.launch(intent);
        }
    }

    @Override // com.yd.android_brand_mvp.base.KTBaseTimerActivity
    protected void initView() {
        super.initView();
        this.toDoType = getIntent().getIntExtra("toDoType", 0);
        getBinding().tab1.setVisibility(ClassCardPermisson.getInstance().Cheack("刷卡验证") ? 0 : 8);
        getBinding().tab2.setVisibility(ClassCardPermisson.getInstance().Cheack("人脸验证") ? 0 : 8);
        getBinding().tab3.setVisibility(ClassCardPermisson.getInstance().Cheack("扫码验证") ? 0 : 8);
        if (ClassCardPermisson.getInstance().Cheack("刷卡验证")) {
            setTab(0);
        } else if (ClassCardPermisson.getInstance().Cheack("人脸验证")) {
            setTab(1);
        }
        getBinding().tab1.setOnClickListener(new View.OnClickListener() { // from class: com.yd.android_brand_mvp.verfity.-$$Lambda$AllCheckActivity$pASfoK3Jdkkr-oIHMu8KuMxf3Eo
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                AllCheckActivity.initView$lambda$0(this.f$0, view);
            }
        });
        getBinding().tab2.setOnClickListener(new View.OnClickListener() { // from class: com.yd.android_brand_mvp.verfity.-$$Lambda$AllCheckActivity$NvKNXmW9NYQHwtL2sU2n93cNeAg
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                AllCheckActivity.initView$lambda$1(this.f$0, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$0(AllCheckActivity this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.setTab(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$1(AllCheckActivity this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.setTab(1);
    }

    public final int getIndex() {
        return this.index;
    }

    public final void setIndex(int i) {
        this.index = i;
    }

    public final int getIndex1() {
        return this.index;
    }

    public final void setIndex1(int position) {
        this.index = position;
    }

    public final FragmentEventListener getListener() {
        return this.listener;
    }

    public final void setListener(FragmentEventListener fragmentEventListener) {
        this.listener = fragmentEventListener;
    }

    @Override // com.yd.android_brand_mvp.base.BaseTimerActivity, androidx.appcompat.app.AppCompatActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.view.Window.Callback
    public boolean dispatchKeyEvent(KeyEvent event) {
        FragmentEventListener fragmentEventListener = this.listener;
        if (fragmentEventListener != null && this.index == 0) {
            Intrinsics.checkNotNull(fragmentEventListener);
            fragmentEventListener.OnFragmentEvent(event);
            return true;
        }
        return super.dispatchKeyEvent(event);
    }

    private final void setTab(int position) {
        getWindow().setDimAmount(position == 1 ? 0.0f : 0.3f);
        setIndex1(position);
        getBinding().btn1.setChecked(false);
        getBinding().btn2.setChecked(false);
        getBinding().btn3.setChecked(false);
        getBinding().btn4.setChecked(false);
        getBinding().line1.setVisibility(8);
        getBinding().line2.setVisibility(8);
        getBinding().line3.setVisibility(8);
        getBinding().line4.setVisibility(8);
        FragmentManager supportFragmentManager = getSupportFragmentManager();
        Intrinsics.checkNotNullExpressionValue(supportFragmentManager, "supportFragmentManager");
        FragmentTransaction fragmentTransactionBeginTransaction = supportFragmentManager.beginTransaction();
        Intrinsics.checkNotNullExpressionValue(fragmentTransactionBeginTransaction, "fm.beginTransaction()");
        Fragment fragmentFindFragmentByTag = supportFragmentManager.findFragmentByTag(String.valueOf(getBinding().btn1.getId()));
        Fragment fragmentFindFragmentByTag2 = supportFragmentManager.findFragmentByTag(String.valueOf(getBinding().btn2.getId()));
        Fragment fragmentFindFragmentByTag3 = supportFragmentManager.findFragmentByTag(String.valueOf(getBinding().btn3.getId()));
        Fragment fragmentFindFragmentByTag4 = supportFragmentManager.findFragmentByTag(String.valueOf(getBinding().btn4.getId()));
        if (fragmentFindFragmentByTag != null) {
            fragmentTransactionBeginTransaction.hide(fragmentFindFragmentByTag);
        }
        if (fragmentFindFragmentByTag2 != null) {
            fragmentTransactionBeginTransaction.hide(fragmentFindFragmentByTag2);
        }
        if (fragmentFindFragmentByTag3 != null) {
            fragmentTransactionBeginTransaction.hide(fragmentFindFragmentByTag3);
        }
        if (fragmentFindFragmentByTag4 != null) {
            fragmentTransactionBeginTransaction.hide(fragmentFindFragmentByTag4);
        }
        if (position == 0) {
            if (fragmentFindFragmentByTag == null) {
                fragmentTransactionBeginTransaction.add(R.id.content, AllCardFragment.INSTANCE.newInstance(this.toDoType), String.valueOf(getBinding().btn1.getId()));
            } else {
                fragmentTransactionBeginTransaction.show(fragmentFindFragmentByTag);
            }
            getBinding().btn1.setChecked(true);
            getBinding().line1.setVisibility(0);
        } else if (position == 1) {
            if (fragmentFindFragmentByTag2 == null) {
                fragmentTransactionBeginTransaction.add(R.id.content, AllFaceFragment.INSTANCE.newInstance(this.toDoType), String.valueOf(getBinding().btn2.getId()));
            } else {
                fragmentTransactionBeginTransaction.show(fragmentFindFragmentByTag2);
            }
            getBinding().btn2.setChecked(true);
            getBinding().line2.setVisibility(0);
        }
        fragmentTransactionBeginTransaction.commitAllowingStateLoss();
    }
}
