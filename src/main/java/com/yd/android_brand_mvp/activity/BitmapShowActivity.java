package com.yd.android_brand_mvp.activity;

import android.content.Context;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import com.google.android.exoplayer2.text.ttml.TtmlNode;
import com.yd.android_brand_mvp.base.KTBaseActivity;
import com.yd.android_brand_mvp.databinding.ActivityBitmapShowBinding;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: BitmapShowActivity.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u0000 \u00062\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0006B\u0005¢\u0006\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0014¨\u0006\u0007"}, d2 = {"Lcom/yd/android_brand_mvp/activity/BitmapShowActivity;", "Lcom/yd/android_brand_mvp/base/KTBaseActivity;", "Lcom/yd/android_brand_mvp/databinding/ActivityBitmapShowBinding;", "()V", "initView", "", "Companion", "app_commonRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class BitmapShowActivity extends KTBaseActivity<ActivityBitmapShowBinding> {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* JADX INFO: renamed from: com.yd.android_brand_mvp.activity.BitmapShowActivity$1, reason: invalid class name */
    /* JADX INFO: compiled from: BitmapShowActivity.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements Function1<LayoutInflater, ActivityBitmapShowBinding> {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        AnonymousClass1() {
            super(1, ActivityBitmapShowBinding.class, "inflate", "inflate(Landroid/view/LayoutInflater;)Lcom/yd/android_brand_mvp/databinding/ActivityBitmapShowBinding;", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public final ActivityBitmapShowBinding invoke(LayoutInflater p0) {
            Intrinsics.checkNotNullParameter(p0, "p0");
            return ActivityBitmapShowBinding.inflate(p0);
        }
    }

    public BitmapShowActivity() {
        super(AnonymousClass1.INSTANCE);
    }

    /* JADX INFO: compiled from: BitmapShowActivity.kt */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\b¨\u0006\t"}, d2 = {"Lcom/yd/android_brand_mvp/activity/BitmapShowActivity$Companion;", "", "()V", TtmlNode.START, "", "context", "Landroid/content/Context;", "byteArray", "", "app_commonRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final void start(Context context, String byteArray) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intent intent = new Intent(context, (Class<?>) BitmapShowActivity.class);
            intent.putExtra("bitmapByte", byteArray);
            context.startActivity(intent);
        }
    }

    @Override // com.yd.android_brand_mvp.base.KTBaseActivity
    protected void initView() {
        super.initView();
        ImageView imageView = getBinding().ivIcon;
        String stringExtra = getIntent().getStringExtra("bitmapByte");
        imageView.setImageBitmap(stringExtra != null ? BitmapFactory.decodeFile(stringExtra) : null);
        getBinding().ivIcon.setOnClickListener(new View.OnClickListener() { // from class: com.yd.android_brand_mvp.activity.-$$Lambda$BitmapShowActivity$nsEdIgUkwHBQHhb-8IadNG36bwM
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                BitmapShowActivity.initView$lambda$1(this.f$0, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$1(BitmapShowActivity this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.finish();
    }
}
