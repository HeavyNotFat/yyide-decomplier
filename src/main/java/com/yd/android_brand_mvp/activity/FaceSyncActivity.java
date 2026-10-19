package com.yd.android_brand_mvp.activity;

import android.app.Activity;
import android.app.Dialog;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.blankj.utilcode.util.SizeUtils;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.yd.android_brand_mvp.BaseApplication;
import com.yd.android_brand_mvp.R;
import com.yd.android_brand_mvp.base.KTBaseActivity;
import com.yd.android_brand_mvp.databinding.ActivityFaceListBinding;
import com.yd.android_brand_mvp.databinding.DialogFaceSyncBinding;
import com.yd.android_brand_mvp.databinding.ItemFaceValueBinding;
import com.yd.android_brand_mvp.utils.ToastUtil;
import com.yyide.facepass.FaceManager;
import com.yyide.facepass.database.DatabaseUtil;
import com.yyide.facepass.database.FacePeople;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import org.eclipse.paho.client.mqttv3.MqttTopic;
import skin.support.content.res.SkinCompatResources;

/* JADX INFO: compiled from: FaceSyncActivity.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000K\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002*\u0001\f\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0003J\b\u0010\u000f\u001a\u00020\u0010H\u0002J\b\u0010\u0011\u001a\u00020\u0010H\u0002J\u0012\u0010\u0012\u001a\u00020\u00102\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0014J\b\u0010\u0015\u001a\u00020\u0010H\u0014J\u0018\u0010\u0016\u001a\u00020\u00102\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001aH\u0002J\b\u0010\u001b\u001a\u00020\u0010H\u0002R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082.¢\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u00020\fX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\rR\u000e\u0010\u000e\u001a\u00020\u0002X\u0082.¢\u0006\u0002\n\u0000¨\u0006\u001c"}, d2 = {"Lcom/yd/android_brand_mvp/activity/FaceSyncActivity;", "Lcom/yd/android_brand_mvp/base/KTBaseActivity;", "Lcom/yd/android_brand_mvp/databinding/ActivityFaceListBinding;", "()V", "dialog", "Landroid/app/Dialog;", "dialogBinding", "Lcom/yd/android_brand_mvp/databinding/DialogFaceSyncBinding;", "faceList", "", "Lcom/yyide/facepass/database/FacePeople;", "mAdapter", "com/yd/android_brand_mvp/activity/FaceSyncActivity$mAdapter$1", "Lcom/yd/android_brand_mvp/activity/FaceSyncActivity$mAdapter$1;", "viewBinding", "getFacePassEvent", "", "initFace", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "setProgress", "msg", "", "progress", "", "showDialog", "app_commonRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class FaceSyncActivity extends KTBaseActivity<ActivityFaceListBinding> {
    private Dialog dialog;
    private DialogFaceSyncBinding dialogBinding;
    private final List<FacePeople> faceList;
    private final FaceSyncActivity$mAdapter$1 mAdapter;
    private ActivityFaceListBinding viewBinding;

    private final void getFacePassEvent() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean showDialog$lambda$5(View view, MotionEvent motionEvent) {
        return true;
    }

    /* JADX INFO: renamed from: com.yd.android_brand_mvp.activity.FaceSyncActivity$1, reason: invalid class name */
    /* JADX INFO: compiled from: FaceSyncActivity.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements Function1<LayoutInflater, ActivityFaceListBinding> {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        AnonymousClass1() {
            super(1, ActivityFaceListBinding.class, "inflate", "inflate(Landroid/view/LayoutInflater;)Lcom/yd/android_brand_mvp/databinding/ActivityFaceListBinding;", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public final ActivityFaceListBinding invoke(LayoutInflater p0) {
            Intrinsics.checkNotNullParameter(p0, "p0");
            return ActivityFaceListBinding.inflate(p0);
        }
    }

    /* JADX WARN: Type inference failed for: r0v4, types: [com.yd.android_brand_mvp.activity.FaceSyncActivity$mAdapter$1] */
    public FaceSyncActivity() {
        super(AnonymousClass1.INSTANCE);
        this.faceList = new ArrayList();
        this.mAdapter = new BaseQuickAdapter<FacePeople, BaseViewHolder>() { // from class: com.yd.android_brand_mvp.activity.FaceSyncActivity$mAdapter$1
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.chad.library.adapter.base.BaseQuickAdapter
            public void convert(BaseViewHolder holder, FacePeople item) {
                Intrinsics.checkNotNullParameter(holder, "holder");
                Intrinsics.checkNotNullParameter(item, "item");
                ItemFaceValueBinding itemFaceValueBindingBind = ItemFaceValueBinding.bind(holder.itemView);
                Intrinsics.checkNotNullExpressionValue(itemFaceValueBindingBind, "bind(holder.itemView)");
                itemFaceValueBindingBind.tvName.setText(item.getName());
                itemFaceValueBindingBind.tvStatus.setText("已同步");
                itemFaceValueBindingBind.tvDesc.setText("");
            }
        };
    }

    @Override // com.yd.android_brand_mvp.base.KTBaseActivity, com.yd.android_brand_mvp.base.BaseActivity, skin.support.app.SkinCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        this.isTheme = false;
        super.onCreate(savedInstanceState);
        ActivityFaceListBinding activityFaceListBindingInflate = ActivityFaceListBinding.inflate(getLayoutInflater());
        Intrinsics.checkNotNullExpressionValue(activityFaceListBindingInflate, "inflate(layoutInflater)");
        this.viewBinding = activityFaceListBindingInflate;
        ActivityFaceListBinding activityFaceListBinding = null;
        if (activityFaceListBindingInflate == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
            activityFaceListBindingInflate = null;
        }
        setContentView(activityFaceListBindingInflate.getRoot());
        FaceSyncActivity faceSyncActivity = this;
        Dialog dialog = new Dialog(faceSyncActivity, R.style.DialogTheme);
        this.dialog = dialog;
        Intrinsics.checkNotNull(dialog);
        DialogFaceSyncBinding dialogFaceSyncBindingInflate = DialogFaceSyncBinding.inflate(dialog.getLayoutInflater());
        Intrinsics.checkNotNullExpressionValue(dialogFaceSyncBindingInflate, "inflate(dialog!!.layoutInflater)");
        this.dialogBinding = dialogFaceSyncBindingInflate;
        ActivityFaceListBinding activityFaceListBinding2 = this.viewBinding;
        if (activityFaceListBinding2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
            activityFaceListBinding2 = null;
        }
        activityFaceListBinding2.top.titleName.setText("人脸同步");
        ActivityFaceListBinding activityFaceListBinding3 = this.viewBinding;
        if (activityFaceListBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
            activityFaceListBinding3 = null;
        }
        activityFaceListBinding3.top.flTitle.setOnClickListener(new View.OnClickListener() { // from class: com.yd.android_brand_mvp.activity.-$$Lambda$FaceSyncActivity$18tRknRBGgfl4ctobwx_eVjQhtw
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                FaceSyncActivity.onCreate$lambda$0(this.f$0, view);
            }
        });
        ActivityFaceListBinding activityFaceListBinding4 = this.viewBinding;
        if (activityFaceListBinding4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
            activityFaceListBinding4 = null;
        }
        activityFaceListBinding4.recyclerView.setLayoutManager(new LinearLayoutManager(faceSyncActivity));
        ActivityFaceListBinding activityFaceListBinding5 = this.viewBinding;
        if (activityFaceListBinding5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
            activityFaceListBinding5 = null;
        }
        activityFaceListBinding5.recyclerView.setAdapter(this.mAdapter);
        setEmptyView(R.layout.layout_face_empty);
        initFace();
        ActivityFaceListBinding activityFaceListBinding6 = this.viewBinding;
        if (activityFaceListBinding6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
            activityFaceListBinding6 = null;
        }
        activityFaceListBinding6.tvConfirm.setOnClickListener(new View.OnClickListener() { // from class: com.yd.android_brand_mvp.activity.-$$Lambda$FaceSyncActivity$9v7Ua9ull_5bebahmKSsmkS54Zg
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                FaceSyncActivity.onCreate$lambda$1(this.f$0, view);
            }
        });
        ActivityFaceListBinding activityFaceListBinding7 = this.viewBinding;
        if (activityFaceListBinding7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
            activityFaceListBinding7 = null;
        }
        activityFaceListBinding7.constraintlayout.setOnClickListener(new View.OnClickListener() { // from class: com.yd.android_brand_mvp.activity.-$$Lambda$FaceSyncActivity$ypvaaZrxYaxhCm5XStNV9ompdhg
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                FaceSyncActivity.onCreate$lambda$2(this.f$0, view);
            }
        });
        ActivityFaceListBinding activityFaceListBinding8 = this.viewBinding;
        if (activityFaceListBinding8 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
            activityFaceListBinding8 = null;
        }
        activityFaceListBinding8.gankTextview3.setOnClickListener(new View.OnClickListener() { // from class: com.yd.android_brand_mvp.activity.-$$Lambda$FaceSyncActivity$ElCTJM6XXHA2W_1XXo2cKMjMYxE
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                FaceSyncActivity.onCreate$lambda$3(this.f$0, view);
            }
        });
        ActivityFaceListBinding activityFaceListBinding9 = this.viewBinding;
        if (activityFaceListBinding9 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
        } else {
            activityFaceListBinding = activityFaceListBinding9;
        }
        activityFaceListBinding.tvDesc.setOnClickListener(new View.OnClickListener() { // from class: com.yd.android_brand_mvp.activity.-$$Lambda$FaceSyncActivity$Kgdc0LLYIJVzTQQ4XpXZG6HLn5c
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                FaceSyncActivity.onCreate$lambda$4(this.f$0, view);
            }
        });
        getFacePassEvent();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreate$lambda$0(FaceSyncActivity this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreate$lambda$1(FaceSyncActivity this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (!BaseApplication.isNetworkAvailable(this$0)) {
            ToastUtil.showBottomView((Activity) this$0, "网络异常，请检查网络");
        } else {
            this$0.showDialog();
            BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this$0), Dispatchers.getIO(), null, new FaceSyncActivity$onCreate$2$1(this$0, null), 2, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreate$lambda$2(FaceSyncActivity this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreate$lambda$3(FaceSyncActivity this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this$0), Dispatchers.getIO(), null, new FaceSyncActivity$onCreate$4$1(this$0, null), 2, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreate$lambda$4(FaceSyncActivity this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.initFace();
    }

    /* JADX INFO: renamed from: com.yd.android_brand_mvp.activity.FaceSyncActivity$initFace$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: FaceSyncActivity.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "com.yd.android_brand_mvp.activity.FaceSyncActivity$initFace$1", f = "FaceSyncActivity.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    static final class C03051 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        C03051(Continuation<? super C03051> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return FaceSyncActivity.this.new C03051(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C03051) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            int localGroupNum = FaceManager.INSTANCE.getLocalGroupNum();
            List<FacePeople> allFace = DatabaseUtil.INSTANCE.getAllFace(FaceSyncActivity.this);
            ArrayList arrayList = new ArrayList();
            if (allFace != null) {
                arrayList.addAll(allFace);
            }
            StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
            String string = FaceSyncActivity.this.getString(R.string.sign_count);
            Intrinsics.checkNotNullExpressionValue(string, "getString(R.string.sign_count)");
            String str = String.format(string, Arrays.copyOf(new Object[]{String.valueOf(localGroupNum), String.valueOf(allFace.size())}, 2));
            Intrinsics.checkNotNullExpressionValue(str, "format(format, *args)");
            String str2 = str;
            SpannableString spannableString = new SpannableString(str2);
            spannableString.setSpan(new ForegroundColorSpan(SkinCompatResources.getInstance().getColor(R.color.purple2)), StringsKt.indexOf$default((CharSequence) str2, String.valueOf(localGroupNum), 0, false, 6, (Object) null), StringsKt.lastIndexOf$default((CharSequence) str2, MqttTopic.TOPIC_LEVEL_SEPARATOR, 0, false, 6, (Object) null), 33);
            ActivityFaceListBinding activityFaceListBinding = FaceSyncActivity.this.viewBinding;
            if (activityFaceListBinding == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
                activityFaceListBinding = null;
            }
            activityFaceListBinding.tvFaveNumber.setText(spannableString);
            setList(arrayList);
            return Unit.INSTANCE;
        }
    }

    private final void initFace() {
        BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), null, null, new C03051(null), 3, null);
    }

    private final void showDialog() {
        Dialog dialog = this.dialog;
        Intrinsics.checkNotNull(dialog);
        DialogFaceSyncBinding dialogFaceSyncBinding = this.dialogBinding;
        if (dialogFaceSyncBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("dialogBinding");
            dialogFaceSyncBinding = null;
        }
        dialog.setContentView(dialogFaceSyncBinding.getRoot());
        Dialog dialog2 = this.dialog;
        Intrinsics.checkNotNull(dialog2);
        Window window = dialog2.getWindow();
        WindowManager.LayoutParams attributes = window != null ? window.getAttributes() : null;
        if (window != null) {
            window.setGravity(17);
        }
        DialogFaceSyncBinding dialogFaceSyncBinding2 = this.dialogBinding;
        if (dialogFaceSyncBinding2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("dialogBinding");
            dialogFaceSyncBinding2 = null;
        }
        dialogFaceSyncBinding2.seekBar.setOnTouchListener(new View.OnTouchListener() { // from class: com.yd.android_brand_mvp.activity.-$$Lambda$FaceSyncActivity$vhtDVt6HxEV9IheywwlJ8RDtTEw
            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                return FaceSyncActivity.showDialog$lambda$5(view, motionEvent);
            }
        });
        WindowManager windowManager = window != null ? window.getWindowManager() : null;
        if (windowManager != null) {
            windowManager.getDefaultDisplay();
        }
        if (attributes != null) {
            attributes.height = SizeUtils.dp2px(520.0f);
        }
        if (attributes != null) {
            attributes.width = SizeUtils.dp2px(490.0f);
        }
        if (window != null) {
            window.setAttributes(attributes);
        }
        Dialog dialog3 = this.dialog;
        Intrinsics.checkNotNull(dialog3);
        dialog3.show();
    }

    private final void setProgress(String msg, int progress) {
        DialogFaceSyncBinding dialogFaceSyncBinding = this.dialogBinding;
        DialogFaceSyncBinding dialogFaceSyncBinding2 = null;
        if (dialogFaceSyncBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("dialogBinding");
            dialogFaceSyncBinding = null;
        }
        TextView textView = dialogFaceSyncBinding.tvProgress;
        StringBuilder sb = new StringBuilder();
        sb.append(progress);
        sb.append('%');
        textView.setText(sb.toString());
        DialogFaceSyncBinding dialogFaceSyncBinding3 = this.dialogBinding;
        if (dialogFaceSyncBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("dialogBinding");
            dialogFaceSyncBinding3 = null;
        }
        dialogFaceSyncBinding3.tvStatus.setText(msg);
        DialogFaceSyncBinding dialogFaceSyncBinding4 = this.dialogBinding;
        if (dialogFaceSyncBinding4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("dialogBinding");
        } else {
            dialogFaceSyncBinding2 = dialogFaceSyncBinding4;
        }
        dialogFaceSyncBinding2.seekBar.setProgress(progress);
    }

    @Override // com.yd.android_brand_mvp.base.BaseActivity, skin.support.app.SkinCompatActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
    }
}
