package com.yd.android_brand_mvp.base;

import android.os.Bundle;
import android.view.LayoutInflater;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewbinding.ViewBinding;
import com.blankj.utilcode.util.ScreenUtils;
import com.yd.android_brand_mvp.dialog.NomalLoadingDiallog;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import me.jessyan.autosize.internal.CustomAdapt;

/* JADX INFO: compiled from: BaseDominateActivity.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0016\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\u00020\u00032\u00020\u0004B\u0019\u0012\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00028\u00000\u0006¢\u0006\u0002\u0010\bJ\b\u0010\u0016\u001a\u00020\u0017H\u0016J\u0006\u0010\u0018\u001a\u00020\u0019J\b\u0010\u001a\u001a\u00020\u0019H\u0014J\b\u0010\u001b\u001a\u00020\u001cH\u0016J\u0012\u0010\u001d\u001a\u00020\u00192\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fH\u0014J\u0006\u0010 \u001a\u00020\u0019R\u001b\u0010\t\u001a\u00028\u00008DX\u0084\u0084\u0002¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\n\u0010\u000bR \u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00028\u00000\u0006X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015¨\u0006!"}, d2 = {"Lcom/yd/android_brand_mvp/base/BaseDominateActivity;", "VB", "Landroidx/viewbinding/ViewBinding;", "Landroidx/appcompat/app/AppCompatActivity;", "Lme/jessyan/autosize/internal/CustomAdapt;", "block", "Lkotlin/Function1;", "Landroid/view/LayoutInflater;", "(Lkotlin/jvm/functions/Function1;)V", "binding", "getBinding", "()Landroidx/viewbinding/ViewBinding;", "binding$delegate", "Lkotlin/Lazy;", "getBlock", "()Lkotlin/jvm/functions/Function1;", "loadingDialog", "Lcom/yd/android_brand_mvp/dialog/NomalLoadingDiallog;", "getLoadingDialog", "()Lcom/yd/android_brand_mvp/dialog/NomalLoadingDiallog;", "setLoadingDialog", "(Lcom/yd/android_brand_mvp/dialog/NomalLoadingDiallog;)V", "getSizeInDp", "", "hideLoading", "", "initView", "isBaseOnWidth", "", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "showLoading", "app_commonRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public class BaseDominateActivity<VB extends ViewBinding> extends AppCompatActivity implements CustomAdapt {

    /* JADX INFO: renamed from: binding$delegate, reason: from kotlin metadata */
    private final Lazy binding;
    private final Function1<LayoutInflater, VB> block;
    private NomalLoadingDiallog loadingDialog;

    protected void initView() {
    }

    @Override // me.jessyan.autosize.internal.CustomAdapt
    public boolean isBaseOnWidth() {
        return true;
    }

    public Function1<LayoutInflater, VB> getBlock() {
        return this.block;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public BaseDominateActivity(Function1<? super LayoutInflater, ? extends VB> block) {
        Intrinsics.checkNotNullParameter(block, "block");
        this.block = block;
        this.binding = LazyKt.lazy(new Function0<VB>(this) { // from class: com.yd.android_brand_mvp.base.BaseDominateActivity$binding$2
            final /* synthetic */ BaseDominateActivity<VB> this$0;

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

    public final NomalLoadingDiallog getLoadingDialog() {
        return this.loadingDialog;
    }

    public final void setLoadingDialog(NomalLoadingDiallog nomalLoadingDiallog) {
        this.loadingDialog = nomalLoadingDiallog;
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getBinding().getRoot());
        this.loadingDialog = new NomalLoadingDiallog(this);
        initView();
    }

    @Override // me.jessyan.autosize.internal.CustomAdapt
    public float getSizeInDp() {
        return ScreenUtils.isLandscape() ? 1920.0f : 1080.0f;
    }

    public final void showLoading() {
        NomalLoadingDiallog nomalLoadingDiallog = this.loadingDialog;
        if (nomalLoadingDiallog != null) {
            nomalLoadingDiallog.show();
        }
    }

    public final void hideLoading() {
        NomalLoadingDiallog nomalLoadingDiallog = this.loadingDialog;
        if (nomalLoadingDiallog == null || !nomalLoadingDiallog.isShowing()) {
            return;
        }
        nomalLoadingDiallog.dismiss();
    }
}
