package com.yd.android_brand_mvp.base;

import android.os.Bundle;
import android.view.LayoutInflater;
import androidx.viewbinding.ViewBinding;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: KTBaseTimerActivity.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0016\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\u00020\u0003B\u0019\u0012\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00028\u00000\u0005¢\u0006\u0002\u0010\u0007J\b\u0010\u000f\u001a\u00020\u0010H\u0014J\u0012\u0010\u0011\u001a\u00020\u00102\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0014R\u001b\u0010\b\u001a\u00028\u00008DX\u0084\u0084\u0002¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\t\u0010\nR \u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00028\u00000\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u0014"}, d2 = {"Lcom/yd/android_brand_mvp/base/KTBaseTimerActivity;", "VB", "Landroidx/viewbinding/ViewBinding;", "Lcom/yd/android_brand_mvp/base/BaseTimerActivity;", "block", "Lkotlin/Function1;", "Landroid/view/LayoutInflater;", "(Lkotlin/jvm/functions/Function1;)V", "binding", "getBinding", "()Landroidx/viewbinding/ViewBinding;", "binding$delegate", "Lkotlin/Lazy;", "getBlock", "()Lkotlin/jvm/functions/Function1;", "initView", "", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "app_commonRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public class KTBaseTimerActivity<VB extends ViewBinding> extends BaseTimerActivity {

    /* JADX INFO: renamed from: binding$delegate, reason: from kotlin metadata */
    private final Lazy binding;
    private final Function1<LayoutInflater, VB> block;

    protected void initView() {
    }

    public Function1<LayoutInflater, VB> getBlock() {
        return this.block;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public KTBaseTimerActivity(Function1<? super LayoutInflater, ? extends VB> block) {
        Intrinsics.checkNotNullParameter(block, "block");
        this.block = block;
        this.binding = LazyKt.lazy(new Function0<VB>(this) { // from class: com.yd.android_brand_mvp.base.KTBaseTimerActivity$binding$2
            final /* synthetic */ KTBaseTimerActivity<VB> this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
                this.this$0 = this;
            }

            /* JADX WARN: Incorrect return type in method signature: ()TVB; */
            @Override // kotlin.jvm.functions.Function0
            public final ViewBinding invoke() {
                Function1<LayoutInflater, VB> block2 = this.this$0.getBlock();
                LayoutInflater layoutInflater = this.this$0.getLayoutInflater();
                Intrinsics.checkNotNullExpressionValue(layoutInflater, "layoutInflater");
                return (ViewBinding) block2.invoke(layoutInflater);
            }
        });
    }

    protected final VB getBinding() {
        return (VB) this.binding.getValue();
    }

    @Override // com.yd.android_brand_mvp.base.BaseTimerActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getBinding().getRoot());
        initView();
    }
}
