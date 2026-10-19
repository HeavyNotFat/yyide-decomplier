package com.yd.android_brand_mvp.activity;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.yd.android_brand_mvp.base.KTBaseActivity;
import com.yd.android_brand_mvp.databinding.ActivityFaceListBinding;
import com.yd.android_brand_mvp.databinding.ItemFaceValueBinding;
import com.yyide.facepass.database.DatabaseUtil;
import com.yyide.facepass.database.FacePeople;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.GlobalScope;

/* JADX INFO: compiled from: FaceListActivity.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000#\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0005\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0003J\u0012\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0014R\u0010\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0006R\u000e\u0010\u0007\u001a\u00020\u0002X\u0082.¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/yd/android_brand_mvp/activity/FaceListActivity;", "Lcom/yd/android_brand_mvp/base/KTBaseActivity;", "Lcom/yd/android_brand_mvp/databinding/ActivityFaceListBinding;", "()V", "mAdapter", "com/yd/android_brand_mvp/activity/FaceListActivity$mAdapter$1", "Lcom/yd/android_brand_mvp/activity/FaceListActivity$mAdapter$1;", "viewBinding", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "app_commonRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class FaceListActivity extends KTBaseActivity<ActivityFaceListBinding> {
    private final FaceListActivity$mAdapter$1 mAdapter;
    private ActivityFaceListBinding viewBinding;

    /* JADX INFO: renamed from: com.yd.android_brand_mvp.activity.FaceListActivity$1, reason: invalid class name */
    /* JADX INFO: compiled from: FaceListActivity.kt */
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

    /* JADX WARN: Type inference failed for: r0v2, types: [com.yd.android_brand_mvp.activity.FaceListActivity$mAdapter$1] */
    public FaceListActivity() {
        super(AnonymousClass1.INSTANCE);
        this.mAdapter = new BaseQuickAdapter<FacePeople, BaseViewHolder>() { // from class: com.yd.android_brand_mvp.activity.FaceListActivity$mAdapter$1
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.chad.library.adapter.base.BaseQuickAdapter
            public void convert(BaseViewHolder holder, FacePeople item) {
                Intrinsics.checkNotNullParameter(holder, "holder");
                Intrinsics.checkNotNullParameter(item, "item");
                ItemFaceValueBinding itemFaceValueBindingBind = ItemFaceValueBinding.bind(holder.itemView);
                Intrinsics.checkNotNullExpressionValue(itemFaceValueBindingBind, "bind(holder.itemView)");
                itemFaceValueBindingBind.tvName.setText(item.getName());
                itemFaceValueBindingBind.tvDesc.setText(item.getFaceToken());
            }
        };
    }

    @Override // com.yd.android_brand_mvp.base.KTBaseActivity, com.yd.android_brand_mvp.base.BaseActivity, skin.support.app.SkinCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityFaceListBinding activityFaceListBindingInflate = ActivityFaceListBinding.inflate(getLayoutInflater());
        Intrinsics.checkNotNullExpressionValue(activityFaceListBindingInflate, "inflate(layoutInflater)");
        this.viewBinding = activityFaceListBindingInflate;
        if (activityFaceListBindingInflate == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
            activityFaceListBindingInflate = null;
        }
        setContentView(activityFaceListBindingInflate.getRoot());
        ActivityFaceListBinding activityFaceListBinding = this.viewBinding;
        if (activityFaceListBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
            activityFaceListBinding = null;
        }
        activityFaceListBinding.top.titleName.setText("人脸同步列表");
        ActivityFaceListBinding activityFaceListBinding2 = this.viewBinding;
        if (activityFaceListBinding2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
            activityFaceListBinding2 = null;
        }
        activityFaceListBinding2.top.flTitle.setOnClickListener(new View.OnClickListener() { // from class: com.yd.android_brand_mvp.activity.-$$Lambda$FaceListActivity$wDQTRsvEhAhb7KYkWOrLBElwVxU
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                FaceListActivity.onCreate$lambda$0(this.f$0, view);
            }
        });
        ActivityFaceListBinding activityFaceListBinding3 = this.viewBinding;
        if (activityFaceListBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
            activityFaceListBinding3 = null;
        }
        activityFaceListBinding3.recyclerView.setLayoutManager(new LinearLayoutManager(this));
        ActivityFaceListBinding activityFaceListBinding4 = this.viewBinding;
        if (activityFaceListBinding4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
            activityFaceListBinding4 = null;
        }
        activityFaceListBinding4.recyclerView.setAdapter(this.mAdapter);
        BuildersKt__Builders_commonKt.launch$default(GlobalScope.INSTANCE, Dispatchers.getIO(), null, new AnonymousClass2(null), 2, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreate$lambda$0(FaceListActivity this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.finish();
    }

    /* JADX INFO: renamed from: com.yd.android_brand_mvp.activity.FaceListActivity$onCreate$2, reason: invalid class name */
    /* JADX INFO: compiled from: FaceListActivity.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "com.yd.android_brand_mvp.activity.FaceListActivity$onCreate$2", f = "FaceListActivity.kt", i = {}, l = {36}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        AnonymousClass2(Continuation<? super AnonymousClass2> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return FaceListActivity.this.new AnonymousClass2(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                List<FacePeople> allFace = DatabaseUtil.INSTANCE.getAllFace(FaceListActivity.this);
                List<FacePeople> allFace2 = DatabaseUtil.INSTANCE.getAllFace(FaceListActivity.this);
                this.label = 1;
                if (BuildersKt.withContext(Dispatchers.getMain(), new AnonymousClass1(FaceListActivity.this, allFace, allFace2, null), this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            return Unit.INSTANCE;
        }

        /* JADX INFO: renamed from: com.yd.android_brand_mvp.activity.FaceListActivity$onCreate$2$1, reason: invalid class name */
        /* JADX INFO: compiled from: FaceListActivity.kt */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
        @DebugMetadata(c = "com.yd.android_brand_mvp.activity.FaceListActivity$onCreate$2$1", f = "FaceListActivity.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
        static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            final /* synthetic */ List<FacePeople> $allFace;
            final /* synthetic */ List<FacePeople> $allPeople;
            int label;
            final /* synthetic */ FaceListActivity this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            AnonymousClass1(FaceListActivity faceListActivity, List<FacePeople> list, List<FacePeople> list2, Continuation<? super AnonymousClass1> continuation) {
                super(2, continuation);
                this.this$0 = faceListActivity;
                this.$allFace = list;
                this.$allPeople = list2;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                return new AnonymousClass1(this.this$0, this.$allFace, this.$allPeople, continuation);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (this.label == 0) {
                    ResultKt.throwOnFailure(obj);
                    ActivityFaceListBinding activityFaceListBinding = this.this$0.viewBinding;
                    if (activityFaceListBinding == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
                        activityFaceListBinding = null;
                    }
                    TextView textView = activityFaceListBinding.tvFaveNumber;
                    StringBuilder sb = new StringBuilder();
                    sb.append("人脸人数:");
                    sb.append(this.$allFace.size());
                    sb.append("\n 同步人员：");
                    List<FacePeople> list = this.$allPeople;
                    sb.append(list != null ? Boxing.boxInt(list.size()) : null);
                    textView.setText(sb.toString());
                    setList(this.$allFace);
                    return Unit.INSTANCE;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }
    }
}
