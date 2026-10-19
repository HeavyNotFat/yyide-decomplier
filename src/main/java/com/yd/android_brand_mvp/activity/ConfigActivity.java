package com.yd.android_brand_mvp.activity;

import android.view.LayoutInflater;
import com.yd.android_brand_mvp.base.KTBaseActivity;
import com.yd.android_brand_mvp.databinding.ActivityConfigBinding;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ConfigActivity.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0014¨\u0006\u0006"}, d2 = {"Lcom/yd/android_brand_mvp/activity/ConfigActivity;", "Lcom/yd/android_brand_mvp/base/KTBaseActivity;", "Lcom/yd/android_brand_mvp/databinding/ActivityConfigBinding;", "()V", "initView", "", "app_commonRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class ConfigActivity extends KTBaseActivity<ActivityConfigBinding> {

    /* JADX INFO: renamed from: com.yd.android_brand_mvp.activity.ConfigActivity$1, reason: invalid class name */
    /* JADX INFO: compiled from: ConfigActivity.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements Function1<LayoutInflater, ActivityConfigBinding> {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        AnonymousClass1() {
            super(1, ActivityConfigBinding.class, "inflate", "inflate(Landroid/view/LayoutInflater;)Lcom/yd/android_brand_mvp/databinding/ActivityConfigBinding;", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public final ActivityConfigBinding invoke(LayoutInflater p0) {
            Intrinsics.checkNotNullParameter(p0, "p0");
            return ActivityConfigBinding.inflate(p0);
        }
    }

    public ConfigActivity() {
        super(AnonymousClass1.INSTANCE);
    }

    @Override // com.yd.android_brand_mvp.base.KTBaseActivity
    protected void initView() {
        super.initView();
    }
}
