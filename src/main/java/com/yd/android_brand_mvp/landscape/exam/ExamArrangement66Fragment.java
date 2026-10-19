package com.yd.android_brand_mvp.landscape.exam;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.TextView;
import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.blankj.utilcode.util.SizeUtils;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.listener.OnItemClickListener;
import com.xiaomi.mipush.sdk.Constants;
import com.yd.android_brand_mvp.R;
import com.yd.android_brand_mvp.activity.exam.ExamArrangementActivity;
import com.yd.android_brand_mvp.base.BaseBindingAdapter;
import com.yd.android_brand_mvp.base.KTBaseFragment;
import com.yd.android_brand_mvp.base.MinaConstants;
import com.yd.android_brand_mvp.base.ResultCodeStr;
import com.yd.android_brand_mvp.base.VBViewHolder;
import com.yd.android_brand_mvp.databinding.FragmentHomeExamArrangement66Binding;
import com.yd.android_brand_mvp.databinding.ItemExamArrangement66CourseBinding;
import com.yd.android_brand_mvp.databinding.ItemExamArrangement66SeatBinding;
import com.yd.android_brand_mvp.landscape.exam.viewmodel.ExamArrangementViewModel;
import com.yd.android_brand_mvp.model.exam.ExamGroupItem;
import com.yd.android_brand_mvp.model.exam.ExamInvigilatorBean;
import com.yd.android_brand_mvp.model.exam.ExamPersonSeatBean;
import com.yd.android_brand_mvp.model.exam.ExamPlanItem;
import com.yd.android_brand_mvp.model.task.TaskVerifyBean;
import com.yd.android_brand_mvp.observer.MinaEventManager;
import com.yd.android_brand_mvp.utils.DateUtils;
import com.yd.android_brand_mvp.utils.OrderUtils;
import com.yd.android_brand_mvp.utils.SimpleUtilsKt;
import com.yd.android_brand_mvp.utils.TimeUtil;
import com.yd.android_brand_mvp.utils.ToastUtil;
import com.yd.android_brand_mvp.verfity.StudentCheackActivity;
import com.yyide.facepass.AppExtKt;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import kotlin.KotlinNothingValueException;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.MutableSharedFlow;

/* JADX INFO: compiled from: ExamArrangement66Fragment.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\b\f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0002\f\u0017\u0018\u0000 72\b\u0012\u0004\u0012\u00020\u00020\u0001:\u00017B\u0005¢\u0006\u0002\u0010\u0003J\u0010\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020\nH\u0016J\b\u0010'\u001a\u00020\nH\u0002J\b\u0010(\u001a\u00020%H\u0002J\u001a\u0010)\u001a\u00020%2\u0006\u0010*\u001a\u00020+2\b\u0010,\u001a\u0004\u0018\u00010-H\u0016J\u0010\u0010.\u001a\u00020%2\u0006\u0010/\u001a\u000200H\u0002J\b\u00101\u001a\u00020%H\u0002J\b\u00102\u001a\u00020%H\u0002J\b\u00103\u001a\u00020%H\u0002J\u0010\u00104\u001a\u00020%2\u0006\u00105\u001a\u000206H\u0002R\u0019\u0010\u0004\u001a\n \u0006*\u0004\u0018\u00010\u00050\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u000e\u0010\t\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u000b\u001a\u00020\f8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\r\u0010\u000eR\u000e\u0010\u0011\u001a\u00020\u0012X\u0082.¢\u0006\u0002\n\u0000R\u001c\u0010\u0013\u001a\u0010\u0012\f\u0012\n \u0006*\u0004\u0018\u00010\u00150\u00150\u0014X\u0082\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\u0016\u001a\u00020\u00178BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001a\u0010\u0010\u001a\u0004\b\u0018\u0010\u0019R\u000e\u0010\u001b\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u0005X\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020\u0005X\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020\nX\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\u0005X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020#X\u0082.¢\u0006\u0002\n\u0000¨\u00068"}, d2 = {"Lcom/yd/android_brand_mvp/landscape/exam/ExamArrangement66Fragment;", "Lcom/yd/android_brand_mvp/base/KTBaseFragment;", "Lcom/yd/android_brand_mvp/databinding/FragmentHomeExamArrangement66Binding;", "()V", "TAG", "", "kotlin.jvm.PlatformType", "getTAG", "()Ljava/lang/String;", "arrangeType", "", "courseAdapter", "com/yd/android_brand_mvp/landscape/exam/ExamArrangement66Fragment$courseAdapter$2$1", "getCourseAdapter", "()Lcom/yd/android_brand_mvp/landscape/exam/ExamArrangement66Fragment$courseAdapter$2$1;", "courseAdapter$delegate", "Lkotlin/Lazy;", "courseManager", "Landroidx/recyclerview/widget/LinearLayoutManager;", "jumpActivityWithResult", "Landroidx/activity/result/ActivityResultLauncher;", "Landroid/content/Intent;", "seatAdapter", "com/yd/android_brand_mvp/landscape/exam/ExamArrangement66Fragment$seatAdapter$2$1", "getSeatAdapter", "()Lcom/yd/android_brand_mvp/landscape/exam/ExamArrangement66Fragment$seatAdapter$2$1;", "seatAdapter$delegate", "seatCell", "seatRow", "sourceTimeFormat", "spanCount", "targetTimeFormat", "timerTimeSecond", "type", "viewModel", "Lcom/yd/android_brand_mvp/landscape/exam/viewmodel/ExamArrangementViewModel;", "UpdataEvent", "", "id", "getHighLightIndex", "initView", "onViewCreated", "view", "Landroid/view/View;", "savedInstanceState", "Landroid/os/Bundle;", "parserLastActivityData", "result", "Landroidx/activity/result/ActivityResult;", "request", "resetUI", "setHighLightItem", "updateDataUi", "dataBean", "Lcom/yd/android_brand_mvp/model/exam/ExamPlanItem;", "Companion", "app_commonRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class ExamArrangement66Fragment extends KTBaseFragment<FragmentHomeExamArrangement66Binding> {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final String TAG;
    private int arrangeType;

    /* JADX INFO: renamed from: courseAdapter$delegate, reason: from kotlin metadata */
    private final Lazy courseAdapter;
    private LinearLayoutManager courseManager;
    private final ActivityResultLauncher<Intent> jumpActivityWithResult;

    /* JADX INFO: renamed from: seatAdapter$delegate, reason: from kotlin metadata */
    private final Lazy seatAdapter;
    private int seatCell;
    private int seatRow;
    private final String sourceTimeFormat;
    private int spanCount;
    private final String targetTimeFormat;
    private final int timerTimeSecond;
    private String type;
    private ExamArrangementViewModel viewModel;

    /* JADX INFO: renamed from: com.yd.android_brand_mvp.landscape.exam.ExamArrangement66Fragment$1, reason: invalid class name */
    /* JADX INFO: compiled from: ExamArrangement66Fragment.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements Function3<LayoutInflater, ViewGroup, Boolean, FragmentHomeExamArrangement66Binding> {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        AnonymousClass1() {
            super(3, FragmentHomeExamArrangement66Binding.class, "inflate", "inflate(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Z)Lcom/yd/android_brand_mvp/databinding/FragmentHomeExamArrangement66Binding;", 0);
        }

        public final FragmentHomeExamArrangement66Binding invoke(LayoutInflater p0, ViewGroup viewGroup, boolean z) {
            Intrinsics.checkNotNullParameter(p0, "p0");
            return FragmentHomeExamArrangement66Binding.inflate(p0, viewGroup, z);
        }

        @Override // kotlin.jvm.functions.Function3
        public /* bridge */ /* synthetic */ FragmentHomeExamArrangement66Binding invoke(LayoutInflater layoutInflater, ViewGroup viewGroup, Boolean bool) {
            return invoke(layoutInflater, viewGroup, bool.booleanValue());
        }
    }

    public static final /* synthetic */ FragmentHomeExamArrangement66Binding access$getBinding(ExamArrangement66Fragment examArrangement66Fragment) {
        return examArrangement66Fragment.getBinding();
    }

    public ExamArrangement66Fragment() {
        super(AnonymousClass1.INSTANCE);
        this.spanCount = 4;
        this.seatRow = 1;
        this.seatCell = 4;
        this.timerTimeSecond = 120;
        this.TAG = ExamArrangement66Fragment.class.getSimpleName();
        ActivityResultLauncher<Intent> activityResultLauncherRegisterForActivityResult = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback() { // from class: com.yd.android_brand_mvp.landscape.exam.-$$Lambda$ExamArrangement66Fragment$JY0INX1Ph1_nDDg8Q1fBfyhUK9g
            @Override // androidx.activity.result.ActivityResultCallback
            public final void onActivityResult(Object obj) {
                ExamArrangement66Fragment.jumpActivityWithResult$lambda$0(this.f$0, (ActivityResult) obj);
            }
        });
        Intrinsics.checkNotNullExpressionValue(activityResultLauncherRegisterForActivityResult, "registerForActivityResul…ityData(result)\n        }");
        this.jumpActivityWithResult = activityResultLauncherRegisterForActivityResult;
        this.seatAdapter = LazyKt.lazy(new Function0<ExamArrangement66Fragment$seatAdapter$2.AnonymousClass1>() { // from class: com.yd.android_brand_mvp.landscape.exam.ExamArrangement66Fragment$seatAdapter$2
            /* JADX WARN: Can't rename method to resolve collision */
            /* JADX WARN: Type inference failed for: r0v0, types: [com.yd.android_brand_mvp.landscape.exam.ExamArrangement66Fragment$seatAdapter$2$1] */
            @Override // kotlin.jvm.functions.Function0
            public final AnonymousClass1 invoke() {
                return new BaseBindingAdapter<ItemExamArrangement66SeatBinding, ExamPersonSeatBean>() { // from class: com.yd.android_brand_mvp.landscape.exam.ExamArrangement66Fragment$seatAdapter$2.1
                    @Override // com.yd.android_brand_mvp.base.BaseBindingAdapter
                    public /* bridge */ /* synthetic */ void convertPlus(VBViewHolder vBViewHolder, ExamPersonSeatBean examPersonSeatBean) {
                        convertPlus2((VBViewHolder<ItemExamArrangement66SeatBinding>) vBViewHolder, examPersonSeatBean);
                    }

                    /* JADX INFO: renamed from: convertPlus, reason: avoid collision after fix types in other method */
                    public void convertPlus2(VBViewHolder<ItemExamArrangement66SeatBinding> holder, ExamPersonSeatBean item) {
                        Intrinsics.checkNotNullParameter(holder, "holder");
                        Intrinsics.checkNotNullParameter(item, "item");
                        ItemExamArrangement66SeatBinding itemExamArrangement66SeatBinding = (ItemExamArrangement66SeatBinding) holder.getBinding();
                        if (itemExamArrangement66SeatBinding != null) {
                            itemExamArrangement66SeatBinding.tvItemExamArrangement66SeatNumber.setText(item.getSeat());
                            itemExamArrangement66SeatBinding.tvItemExamArrangement66Name.setText(item.getPersonName());
                            if (item.getSignInType() == 1) {
                                itemExamArrangement66SeatBinding.tvItemExamArrangement66SeatNumber.setTextColor(SimpleUtilsKt.asColor(R.color.white));
                                itemExamArrangement66SeatBinding.clItemExamArrangementSeatLeft.setBackground(SimpleUtilsKt.asDrawable(R.drawable.bg_purle_left_r10));
                            } else {
                                itemExamArrangement66SeatBinding.tvItemExamArrangement66SeatNumber.setTextColor(SimpleUtilsKt.asColor(R.color.black10));
                                itemExamArrangement66SeatBinding.clItemExamArrangementSeatLeft.setBackground(SimpleUtilsKt.asDrawable(R.drawable.bg_e5grey_left_r10));
                            }
                        }
                    }

                    @Override // com.yd.android_brand_mvp.base.BaseBindingAdapter
                    public ItemExamArrangement66SeatBinding createViewBinding(LayoutInflater inflater, ViewGroup parent) {
                        Intrinsics.checkNotNullParameter(inflater, "inflater");
                        Intrinsics.checkNotNullParameter(parent, "parent");
                        ItemExamArrangement66SeatBinding itemExamArrangement66SeatBindingInflate = ItemExamArrangement66SeatBinding.inflate(inflater, parent, false);
                        Intrinsics.checkNotNullExpressionValue(itemExamArrangement66SeatBindingInflate, "inflate(inflater, parent, false)");
                        return itemExamArrangement66SeatBindingInflate;
                    }
                };
            }
        });
        this.sourceTimeFormat = "yyyy-MM-dd HH:mm:ss";
        this.targetTimeFormat = "HH:mm";
        this.courseAdapter = LazyKt.lazy(new Function0<ExamArrangement66Fragment$courseAdapter$2.AnonymousClass1>() { // from class: com.yd.android_brand_mvp.landscape.exam.ExamArrangement66Fragment$courseAdapter$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            /* JADX WARN: Type inference failed for: r0v0, types: [com.yd.android_brand_mvp.landscape.exam.ExamArrangement66Fragment$courseAdapter$2$1] */
            @Override // kotlin.jvm.functions.Function0
            public final AnonymousClass1 invoke() {
                final ExamArrangement66Fragment examArrangement66Fragment = this.this$0;
                return new BaseBindingAdapter<ItemExamArrangement66CourseBinding, ExamPlanItem>() { // from class: com.yd.android_brand_mvp.landscape.exam.ExamArrangement66Fragment$courseAdapter$2.1
                    {
                        super(null, 1, null);
                    }

                    @Override // com.yd.android_brand_mvp.base.BaseBindingAdapter
                    public /* bridge */ /* synthetic */ void convertPlus(VBViewHolder vBViewHolder, ExamPlanItem examPlanItem) {
                        convertPlus2((VBViewHolder<ItemExamArrangement66CourseBinding>) vBViewHolder, examPlanItem);
                    }

                    /* JADX INFO: renamed from: convertPlus, reason: avoid collision after fix types in other method */
                    public void convertPlus2(VBViewHolder<ItemExamArrangement66CourseBinding> holder, ExamPlanItem item) {
                        Intrinsics.checkNotNullParameter(holder, "holder");
                        Intrinsics.checkNotNullParameter(item, "item");
                        ItemExamArrangement66CourseBinding itemExamArrangement66CourseBinding = (ItemExamArrangement66CourseBinding) holder.getBinding();
                        if (itemExamArrangement66CourseBinding != null) {
                            ExamArrangement66Fragment examArrangement66Fragment2 = examArrangement66Fragment;
                            if (item.isSelect()) {
                                itemExamArrangement66CourseBinding.clItemExamArrangement66Course.setBackground(SimpleUtilsKt.asDrawable(R.drawable.bg_purple20));
                                itemExamArrangement66CourseBinding.tvItemExamArrangement66CourseTime.setTextColor(SimpleUtilsKt.asColor(R.color.white));
                                itemExamArrangement66CourseBinding.tvItemExamArrangement66CourseClass.setTextColor(SimpleUtilsKt.asColor(R.color.white));
                                itemExamArrangement66CourseBinding.tvItemExamArrangement66CourseName.setTextColor(SimpleUtilsKt.asColor(R.color.white));
                            } else {
                                itemExamArrangement66CourseBinding.clItemExamArrangement66Course.setBackground(null);
                                itemExamArrangement66CourseBinding.tvItemExamArrangement66CourseTime.setTextColor(SimpleUtilsKt.asColor(R.color.black9));
                                itemExamArrangement66CourseBinding.tvItemExamArrangement66CourseClass.setTextColor(SimpleUtilsKt.asColor(R.color.black11));
                                itemExamArrangement66CourseBinding.tvItemExamArrangement66CourseName.setTextColor(SimpleUtilsKt.asColor(R.color.black9));
                            }
                            String str = TimeUtil.formatTime(item.getExamStartTime(), examArrangement66Fragment2.sourceTimeFormat, examArrangement66Fragment2.targetTimeFormat) + '-' + TimeUtil.formatTime(item.getExamEndTime(), examArrangement66Fragment2.sourceTimeFormat, examArrangement66Fragment2.targetTimeFormat);
                            itemExamArrangement66CourseBinding.tvItemExamArrangement66CourseName.setText(item.getSubjectName());
                            if (!item.getGroup().isEmpty()) {
                                TextView textView = itemExamArrangement66CourseBinding.tvItemExamArrangement66CourseClass;
                                StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
                                String str2 = String.format("（%s）", Arrays.copyOf(new Object[]{((ExamGroupItem) CollectionsKt.first((List) item.getGroup())).getObjectName()}, 1));
                                Intrinsics.checkNotNullExpressionValue(str2, "format(format, *args)");
                                textView.setText(str2);
                            } else {
                                itemExamArrangement66CourseBinding.tvItemExamArrangement66CourseClass.setText("");
                            }
                            if (Intrinsics.areEqual(str, Constants.ACCEPT_TIME_SEPARATOR_SERVER)) {
                                itemExamArrangement66CourseBinding.tvItemExamArrangement66CourseTime.setText("");
                            } else {
                                itemExamArrangement66CourseBinding.tvItemExamArrangement66CourseTime.setText(str);
                            }
                            if (holder.getAdapterPosition() == CollectionsKt.getLastIndex(getData())) {
                                View view = itemExamArrangement66CourseBinding.viewLine;
                                Intrinsics.checkNotNullExpressionValue(view, "it.viewLine");
                                SimpleUtilsKt.hide(view);
                            } else {
                                View view2 = itemExamArrangement66CourseBinding.viewLine;
                                Intrinsics.checkNotNullExpressionValue(view2, "it.viewLine");
                                SimpleUtilsKt.show(view2);
                            }
                        }
                    }

                    @Override // com.yd.android_brand_mvp.base.BaseBindingAdapter
                    public ItemExamArrangement66CourseBinding createViewBinding(LayoutInflater inflater, ViewGroup parent) {
                        Intrinsics.checkNotNullParameter(inflater, "inflater");
                        Intrinsics.checkNotNullParameter(parent, "parent");
                        ItemExamArrangement66CourseBinding itemExamArrangement66CourseBindingInflate = ItemExamArrangement66CourseBinding.inflate(inflater, parent, false);
                        Intrinsics.checkNotNullExpressionValue(itemExamArrangement66CourseBindingInflate, "inflate(inflater, parent, false)");
                        return itemExamArrangement66CourseBindingInflate;
                    }
                };
            }
        });
    }

    /* JADX INFO: compiled from: ExamArrangement66Fragment.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¨\u0006\u0007"}, d2 = {"Lcom/yd/android_brand_mvp/landscape/exam/ExamArrangement66Fragment$Companion;", "", "()V", "newInstance", "Landroidx/fragment/app/Fragment;", "type", "", "app_commonRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final Fragment newInstance(String type) {
            ExamArrangement66Fragment examArrangement66Fragment = new ExamArrangement66Fragment();
            Bundle bundle = new Bundle();
            bundle.putString("type", type);
            examArrangement66Fragment.setArguments(bundle);
            return examArrangement66Fragment;
        }
    }

    public final String getTAG() {
        return this.TAG;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void jumpActivityWithResult$lambda$0(ExamArrangement66Fragment this$0, ActivityResult result) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(result, "result");
        this$0.parserLastActivityData(result);
    }

    private final void parserLastActivityData(ActivityResult result) {
        Intent data;
        TaskVerifyBean taskVerifyBean;
        ExamArrangementViewModel examArrangementViewModel;
        Object next;
        if (result.getResultCode() != -1 || (data = result.getData()) == null) {
            return;
        }
        String stringExtra = data.getStringExtra(ResultCodeStr.NORMAL_TYPE_CODE);
        if (stringExtra == null) {
            stringExtra = "";
        }
        Intrinsics.checkNotNullExpressionValue(stringExtra, "resultData.getStringExtr…r.NORMAL_TYPE_CODE) ?: \"\"");
        if ((stringExtra.length() == 0) || !Intrinsics.areEqual(stringExtra, ResultCodeStr.TASK_SIGN_VERIFY) || (taskVerifyBean = (TaskVerifyBean) data.getParcelableExtra(ResultCodeStr.TASK_SIGN_VERIFY_SUCCESS)) == null) {
            return;
        }
        Intrinsics.checkNotNullExpressionValue(taskVerifyBean, "resultData.getParcelable…VERIFY_SUCCESS) ?: return");
        AppExtKt.logd(this, "验证成功");
        Iterator<T> it2 = getCourseAdapter().getData().iterator();
        do {
            examArrangementViewModel = null;
            if (!it2.hasNext()) {
                next = null;
                break;
            }
            next = it2.next();
        } while (!((ExamPlanItem) next).isSelect());
        ExamPlanItem examPlanItem = (ExamPlanItem) next;
        if (examPlanItem != null) {
            ExamArrangementViewModel examArrangementViewModel2 = this.viewModel;
            if (examArrangementViewModel2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            } else {
                examArrangementViewModel = examArrangementViewModel2;
            }
            examArrangementViewModel.signInExam(taskVerifyBean.getUserId(), examPlanItem.getSiteId(), examPlanItem.getSubjectId(), examPlanItem.getExaminationId());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ExamArrangement66Fragment$seatAdapter$2.AnonymousClass1 getSeatAdapter() {
        return (ExamArrangement66Fragment$seatAdapter$2.AnonymousClass1) this.seatAdapter.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ExamArrangement66Fragment$courseAdapter$2.AnonymousClass1 getCourseAdapter() {
        return (ExamArrangement66Fragment$courseAdapter$2.AnonymousClass1) this.courseAdapter.getValue();
    }

    @Override // com.yd.android_brand_mvp.base.KTBaseFragment, com.yd.android_brand_mvp.base.BaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        this.viewModel = (ExamArrangementViewModel) new ViewModelProvider(this).get(ExamArrangementViewModel.class);
        Bundle arguments = getArguments();
        String str = null;
        String string = arguments != null ? arguments.getString("type") : null;
        if (string == null) {
            string = "hbksgl66";
        }
        this.type = string;
        if (string == null) {
            Intrinsics.throwUninitializedPropertyAccessException("type");
        } else {
            str = string;
        }
        if (Intrinsics.areEqual(str, "hbksgl66")) {
            getBinding().clFragmentExamArrangement.getLayoutParams().width = SizeUtils.dp2px(1372.0f);
            getBinding().clFragmentExamArrangement.getLayoutParams().height = SizeUtils.dp2px(916.0f);
        } else if (Intrinsics.areEqual(str, "sbksgl66")) {
            getBinding().clFragmentExamArrangement.getLayoutParams().width = SizeUtils.dp2px(1000.0f);
            getBinding().clFragmentExamArrangement.getLayoutParams().height = SizeUtils.dp2px(1312.0f);
        }
        initView();
        request();
    }

    private final void initView() {
        getBinding().topFragmentExamArrangement.title.setText("今日考试");
        getBinding().topFragmentExamArrangement.llTitle.setOnClickListener(new View.OnClickListener() { // from class: com.yd.android_brand_mvp.landscape.exam.-$$Lambda$ExamArrangement66Fragment$3tEqVIiyN592Y-gfLUv7ctKnpGk
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ExamArrangement66Fragment.initView$lambda$4(this.f$0, view);
            }
        });
        this.courseManager = new LinearLayoutManager(requireContext(), 0, false);
        RecyclerView recyclerView = getBinding().rvFragmentExamArrangementCourse;
        LinearLayoutManager linearLayoutManager = this.courseManager;
        if (linearLayoutManager == null) {
            Intrinsics.throwUninitializedPropertyAccessException("courseManager");
            linearLayoutManager = null;
        }
        recyclerView.setLayoutManager(linearLayoutManager);
        getBinding().rvFragmentExamArrangementCourse.setAdapter(getCourseAdapter());
        getBinding().rvFragmentExamArrangementCourse.setItemAnimator(null);
        getCourseAdapter().setOnItemClickListener(new OnItemClickListener() { // from class: com.yd.android_brand_mvp.landscape.exam.-$$Lambda$ExamArrangement66Fragment$x9AH8BgCVHqtUfuMViOEtQkHeLE
            @Override // com.chad.library.adapter.base.listener.OnItemClickListener
            public final void onItemClick(BaseQuickAdapter baseQuickAdapter, View view, int i) {
                ExamArrangement66Fragment.initView$lambda$6(this.f$0, baseQuickAdapter, view, i);
            }
        });
        getBinding().btnFragmentExamSign.setOnClickListener(new View.OnClickListener() { // from class: com.yd.android_brand_mvp.landscape.exam.-$$Lambda$ExamArrangement66Fragment$mJDzM1sIZ7F3qjcxmSzRZOmKhwY
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ExamArrangement66Fragment.initView$lambda$9(this.f$0, view);
            }
        });
        ExamArrangementViewModel examArrangementViewModel = this.viewModel;
        if (examArrangementViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            examArrangementViewModel = null;
        }
        LiveData<Result<List<ExamPlanItem>>> todayExam = examArrangementViewModel.getTodayExam();
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        final Function1<Result<? extends List<? extends ExamPlanItem>>, Unit> function1 = new Function1<Result<? extends List<? extends ExamPlanItem>>, Unit>() { // from class: com.yd.android_brand_mvp.landscape.exam.ExamArrangement66Fragment.initView.4
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Result<? extends List<? extends ExamPlanItem>> result) {
                invoke2(result);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Result<? extends List<? extends ExamPlanItem>> it2) {
                Intrinsics.checkNotNullExpressionValue(it2, "it");
                Object value = it2.getValue();
                if (Result.m597isFailureimpl(value)) {
                    value = null;
                }
                List list = (List) value;
                if (list == null || list.isEmpty()) {
                    ViewStub viewStub = ExamArrangement66Fragment.access$getBinding(ExamArrangement66Fragment.this).emptyView;
                    Intrinsics.checkNotNullExpressionValue(viewStub, "binding.emptyView");
                    viewStub.setVisibility(0);
                } else {
                    ViewStub viewStub2 = ExamArrangement66Fragment.access$getBinding(ExamArrangement66Fragment.this).emptyView;
                    Intrinsics.checkNotNullExpressionValue(viewStub2, "binding.emptyView");
                    viewStub2.setVisibility(8);
                    ExamArrangement66Fragment.this.getCourseAdapter().setList(list);
                    ExamArrangement66Fragment.this.setHighLightItem();
                }
            }
        };
        todayExam.observe(viewLifecycleOwner, new Observer() { // from class: com.yd.android_brand_mvp.landscape.exam.-$$Lambda$ExamArrangement66Fragment$uzBjhDTtelutquVl75Lnbj-5Ojk
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                ExamArrangement66Fragment.initView$lambda$10(function1, obj);
            }
        });
        ExamArrangementViewModel examArrangementViewModel2 = this.viewModel;
        if (examArrangementViewModel2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            examArrangementViewModel2 = null;
        }
        LiveData<Result<List<ExamPersonSeatBean>>> seatInExam = examArrangementViewModel2.getSeatInExam();
        LifecycleOwner viewLifecycleOwner2 = getViewLifecycleOwner();
        final Function1<Result<? extends List<? extends ExamPersonSeatBean>>, Unit> function2 = new Function1<Result<? extends List<? extends ExamPersonSeatBean>>, Unit>() { // from class: com.yd.android_brand_mvp.landscape.exam.ExamArrangement66Fragment.initView.5
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Result<? extends List<? extends ExamPersonSeatBean>> result) {
                invoke2(result);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Result<? extends List<? extends ExamPersonSeatBean>> it2) {
                Intrinsics.checkNotNullExpressionValue(it2, "it");
                Object value = it2.getValue();
                Object obj = null;
                if (Result.m597isFailureimpl(value)) {
                    value = null;
                }
                List list = (List) value;
                for (Object obj2 : ExamArrangement66Fragment.this.getCourseAdapter().getData()) {
                    if (((ExamPlanItem) obj2).isSelect()) {
                        obj = obj2;
                        break;
                    }
                }
                ExamPlanItem examPlanItem = (ExamPlanItem) obj;
                int examinationPersonCount = ExamArrangement66Fragment.this.seatRow * ExamArrangement66Fragment.this.seatCell;
                if (examPlanItem != null && ((ExamGroupItem) CollectionsKt.first((List) examPlanItem.getGroup())).getExaminationArrange() == 2) {
                    examinationPersonCount = examPlanItem.getExaminationPersonCount();
                }
                Log.i(ExamArrangement66Fragment.this.getTAG(), "seat size = " + examinationPersonCount);
                if (examinationPersonCount == 0) {
                    return;
                }
                ArrayList arrayList = new ArrayList(examinationPersonCount);
                for (int i = 0; i < examinationPersonCount; i++) {
                    arrayList.add(new ExamPersonSeatBean(0, null, null, null, null, null, null, null, null, null, null, null, null, null, 16383, null));
                }
                ArrayList arrayList2 = arrayList;
                if (list != null) {
                    int i2 = 0;
                    for (Object obj3 : list) {
                        int i3 = i2 + 1;
                        if (i2 < 0) {
                            CollectionsKt.throwIndexOverflow();
                        }
                        ExamPersonSeatBean examPersonSeatBean = (ExamPersonSeatBean) obj3;
                        if (i2 < arrayList2.size()) {
                            arrayList2.set(i2, examPersonSeatBean);
                        }
                        i2 = i3;
                    }
                }
                int i4 = 0;
                for (Object obj4 : arrayList2) {
                    int i5 = i4 + 1;
                    if (i4 < 0) {
                        CollectionsKt.throwIndexOverflow();
                    }
                    ((ExamPersonSeatBean) obj4).setSeat(String.valueOf(i5));
                    i4 = i5;
                }
                Log.i(ExamArrangement66Fragment.this.getTAG(), "arrangeType = " + ExamArrangement66Fragment.this.arrangeType);
                int i6 = ExamArrangement66Fragment.this.arrangeType;
                if (i6 == 1) {
                    ExamArrangement66Fragment.this.getSeatAdapter().setList(OrderUtils.INSTANCE.printStudentsInOrder(arrayList2, ExamArrangement66Fragment.this.seatRow, ExamArrangement66Fragment.this.seatCell));
                } else if (i6 != 2) {
                    ExamArrangement66Fragment.this.getSeatAdapter().setList(arrayList2);
                } else {
                    ExamArrangement66Fragment.this.getSeatAdapter().setList(OrderUtils.INSTANCE.printStudentsInSShape(arrayList2, ExamArrangement66Fragment.this.seatRow, ExamArrangement66Fragment.this.seatCell));
                }
            }
        };
        seatInExam.observe(viewLifecycleOwner2, new Observer() { // from class: com.yd.android_brand_mvp.landscape.exam.-$$Lambda$ExamArrangement66Fragment$ip3aCK3BnjUK17yO8dxUNieooI8
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                ExamArrangement66Fragment.initView$lambda$11(function2, obj);
            }
        });
        ExamArrangementViewModel examArrangementViewModel3 = this.viewModel;
        if (examArrangementViewModel3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            examArrangementViewModel3 = null;
        }
        LiveData<Result<Boolean>> signInExam = examArrangementViewModel3.getSignInExam();
        LifecycleOwner viewLifecycleOwner3 = getViewLifecycleOwner();
        final Function1<Result<? extends Boolean>, Unit> function3 = new Function1<Result<? extends Boolean>, Unit>() { // from class: com.yd.android_brand_mvp.landscape.exam.ExamArrangement66Fragment.initView.6
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Result<? extends Boolean> result) {
                invoke2(result);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Result<? extends Boolean> it2) {
                Intrinsics.checkNotNullExpressionValue(it2, "it");
                Object value = it2.getValue();
                if (Result.m597isFailureimpl(value)) {
                    value = null;
                }
                Boolean bool = (Boolean) value;
                if (bool == null || !bool.booleanValue()) {
                    return;
                }
                ToastUtil.showBottomView((Activity) ExamArrangement66Fragment.this.requireActivity(), "签到成功");
                MinaEventManager.getInstance().notifyObserver(MinaConstants.CODE_EXAM);
            }
        };
        signInExam.observe(viewLifecycleOwner3, new Observer() { // from class: com.yd.android_brand_mvp.landscape.exam.-$$Lambda$ExamArrangement66Fragment$Fu7q5TDlhzwYM3n8XEpvrLz5Heg
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                ExamArrangement66Fragment.initView$lambda$12(function3, obj);
            }
        });
        BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), null, null, new AnonymousClass7(null), 3, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$4(ExamArrangement66Fragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intent intent = new Intent(this$0.getContext(), (Class<?>) ExamArrangementActivity.class);
        String str = this$0.type;
        if (str == null) {
            Intrinsics.throwUninitializedPropertyAccessException("type");
            str = null;
        }
        intent.putExtra("isPortrait", StringsKt.startsWith$default(str, "sb", false, 2, (Object) null));
        this$0.goPermissionsActivity(intent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$6(ExamArrangement66Fragment this$0, BaseQuickAdapter baseQuickAdapter, View view, int i) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(baseQuickAdapter, "<anonymous parameter 0>");
        Intrinsics.checkNotNullParameter(view, "<anonymous parameter 1>");
        ExamPlanItem examPlanItem = this$0.getCourseAdapter().getData().get(i);
        Iterator<T> it2 = this$0.getCourseAdapter().getData().iterator();
        while (it2.hasNext()) {
            ((ExamPlanItem) it2.next()).setSelect(false);
        }
        examPlanItem.setSelect(true);
        this$0.getCourseAdapter().notifyDataSetChanged();
        this$0.updateDataUi(examPlanItem);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$9(ExamArrangement66Fragment this$0, View view) {
        Object next;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Iterator<T> it2 = this$0.getCourseAdapter().getData().iterator();
        do {
            if (!it2.hasNext()) {
                next = null;
                break;
            }
            next = it2.next();
        } while (!((ExamPlanItem) next).isSelect());
        ExamPlanItem examPlanItem = (ExamPlanItem) next;
        if (examPlanItem != null) {
            if (examPlanItem.getSignIn()) {
                StudentCheackActivity.startGo(this$0.requireContext(), this$0.jumpActivityWithResult);
                return;
            }
            Context contextRequireContext = this$0.requireContext();
            Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext()");
            String string = this$0.getString(R.string.not_need_sign_in);
            Intrinsics.checkNotNullExpressionValue(string, "getString(R.string.not_need_sign_in)");
            SimpleUtilsKt.showShotToast(contextRequireContext, string);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$10(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$11(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$12(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: renamed from: com.yd.android_brand_mvp.landscape.exam.ExamArrangement66Fragment$initView$7, reason: invalid class name */
    /* JADX INFO: compiled from: ExamArrangement66Fragment.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "com.yd.android_brand_mvp.landscape.exam.ExamArrangement66Fragment$initView$7", f = "ExamArrangement66Fragment.kt", i = {0}, l = {305, 306}, m = "invokeSuspend", n = {"$this$launch"}, s = {"L$0"})
    static final class AnonymousClass7 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        private /* synthetic */ Object L$0;
        int label;

        AnonymousClass7(Continuation<? super AnonymousClass7> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            AnonymousClass7 anonymousClass7 = ExamArrangement66Fragment.this.new AnonymousClass7(continuation);
            anonymousClass7.L$0 = obj;
            return anonymousClass7;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass7) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            final CoroutineScope coroutineScope;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i != 0) {
                if (i == 1) {
                    coroutineScope = (CoroutineScope) this.L$0;
                    ResultKt.throwOnFailure(obj);
                } else {
                    if (i != 2) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                }
                throw new KotlinNothingValueException();
            }
            ResultKt.throwOnFailure(obj);
            coroutineScope = (CoroutineScope) this.L$0;
            ExamArrangementViewModel examArrangementViewModel = ExamArrangement66Fragment.this.viewModel;
            if (examArrangementViewModel == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewModel");
                examArrangementViewModel = null;
            }
            this.L$0 = coroutineScope;
            this.label = 1;
            if (examArrangementViewModel.startTimer(ExamArrangement66Fragment.this.timerTimeSecond, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
            ExamArrangementViewModel examArrangementViewModel2 = ExamArrangement66Fragment.this.viewModel;
            if (examArrangementViewModel2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewModel");
                examArrangementViewModel2 = null;
            }
            MutableSharedFlow<String> timeSharedFlow = examArrangementViewModel2.getTimeSharedFlow();
            final ExamArrangement66Fragment examArrangement66Fragment = ExamArrangement66Fragment.this;
            this.L$0 = null;
            this.label = 2;
            if (timeSharedFlow.collect(new FlowCollector() { // from class: com.yd.android_brand_mvp.landscape.exam.ExamArrangement66Fragment.initView.7.1
                @Override // kotlinx.coroutines.flow.FlowCollector
                public /* bridge */ /* synthetic */ Object emit(Object obj2, Continuation continuation) {
                    return emit((String) obj2, (Continuation<? super Unit>) continuation);
                }

                public final Object emit(String str, Continuation<? super Unit> continuation) {
                    AppExtKt.logd(coroutineScope, "66 收到定时器");
                    examArrangement66Fragment.setHighLightItem();
                    return Unit.INSTANCE;
                }
            }, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
            throw new KotlinNothingValueException();
        }
    }

    private final void updateDataUi(ExamPlanItem dataBean) {
        String str = this.type;
        ExamArrangementViewModel examArrangementViewModel = null;
        if (str == null) {
            Intrinsics.throwUninitializedPropertyAccessException("type");
            str = null;
        }
        if (StringsKt.startsWith$default(str, "sb", false, 2, (Object) null)) {
            this.spanCount = 3;
        }
        if (((ExamGroupItem) CollectionsKt.first((List) dataBean.getGroup())).getExaminationArrange() == 2) {
            this.seatCell = this.spanCount;
            int examinationPersonCount = dataBean.getExaminationPersonCount();
            int i = this.seatCell;
            int i2 = examinationPersonCount / i;
            if (i * i2 < dataBean.getExaminationPersonCount()) {
                i2++;
            }
            this.seatRow = i2;
        } else {
            this.seatRow = dataBean.getRow();
            int cell = dataBean.getCell();
            this.seatCell = cell;
            if (cell != 0) {
                this.spanCount = cell;
            }
        }
        getBinding().rvFragmentExamArrangementSeat.setLayoutManager(new GridLayoutManager(requireContext(), this.spanCount));
        getBinding().rvFragmentExamArrangementSeat.setAdapter(getSeatAdapter());
        getBinding().tvFragmentExamArrangementCourse.setText(dataBean.getSubjectName());
        getBinding().tvFragmentExamArrangementTime.setText(TimeUtil.formatTime(dataBean.getExamStartTime(), this.sourceTimeFormat, this.targetTimeFormat) + '-' + TimeUtil.formatTime(dataBean.getExamEndTime(), this.sourceTimeFormat, this.targetTimeFormat));
        if (!dataBean.getGroup().isEmpty()) {
            getBinding().tvFragmentExamArrangementTarget.setText(((ExamGroupItem) CollectionsKt.first((List) dataBean.getGroup())).getObjectName());
            this.arrangeType = ((ExamGroupItem) CollectionsKt.first((List) dataBean.getGroup())).getArrangeType();
        } else {
            getBinding().tvFragmentExamArrangementTarget.setText("");
        }
        StringBuilder sb = new StringBuilder();
        int i3 = 0;
        for (Object obj : dataBean.getInvigilators()) {
            int i4 = i3 + 1;
            if (i3 < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            sb.append(((ExamInvigilatorBean) obj).getPersonName());
            if (i3 != CollectionsKt.getLastIndex(dataBean.getInvigilators())) {
                sb.append("、");
            }
            i3 = i4;
        }
        StringBuilder sb2 = sb;
        if (sb2.length() == 0) {
            sb.append("无");
        }
        getBinding().tvFragmentExamArrangementTeacher.setText(sb2);
        ExamArrangementViewModel examArrangementViewModel2 = this.viewModel;
        if (examArrangementViewModel2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        } else {
            examArrangementViewModel = examArrangementViewModel2;
        }
        examArrangementViewModel.getExamSeat(dataBean.getSiteId(), dataBean.getSubjectId(), dataBean.getExaminationId());
    }

    private final int getHighLightIndex() {
        int i = -1;
        int i2 = 0;
        for (Object obj : getCourseAdapter().getData()) {
            int i3 = i2 + 1;
            if (i2 < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            ExamPlanItem examPlanItem = (ExamPlanItem) obj;
            if ((examPlanItem.getExamStartTime().length() > 0) && DateUtils.isTiming(examPlanItem.getExamStartTime(), examPlanItem.getExamEndTime(), examPlanItem.getStartMinute(), examPlanItem.getEndMinute())) {
                i = i2;
            }
            i2 = i3;
        }
        return i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void setHighLightItem() {
        int highLightIndex = getHighLightIndex();
        Iterator<T> it2 = getCourseAdapter().getData().iterator();
        while (it2.hasNext()) {
            ((ExamPlanItem) it2.next()).setSelect(false);
        }
        if (highLightIndex == -1) {
            getCourseAdapter().notifyDataSetChanged();
            resetUI();
            return;
        }
        ExamPlanItem examPlanItem = getCourseAdapter().getData().get(highLightIndex);
        examPlanItem.setSelect(true);
        if (true ^ examPlanItem.getGroup().isEmpty()) {
            this.arrangeType = examPlanItem.getGroup().get(0).getArrangeType();
        }
        LinearLayoutManager linearLayoutManager = this.courseManager;
        if (linearLayoutManager == null) {
            Intrinsics.throwUninitializedPropertyAccessException("courseManager");
            linearLayoutManager = null;
        }
        linearLayoutManager.scrollToPositionWithOffset(highLightIndex, 0);
        getCourseAdapter().notifyDataSetChanged();
        updateDataUi(examPlanItem);
    }

    private final void resetUI() {
        getSeatAdapter().setList(null);
        getBinding().tvFragmentExamArrangementCourse.setText("");
        getBinding().tvFragmentExamArrangementTime.setText("");
        getBinding().tvFragmentExamArrangementTarget.setText("");
        getBinding().tvFragmentExamArrangementTeacher.setText("");
    }

    private final void request() {
        ExamArrangementViewModel examArrangementViewModel = this.viewModel;
        if (examArrangementViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            examArrangementViewModel = null;
        }
        examArrangementViewModel.m338getTodayExam();
    }

    @Override // com.yd.android_brand_mvp.base.BaseFragment, com.yd.android_brand_mvp.observer.MinaListener
    public void UpdataEvent(int id) {
        super.UpdataEvent(id);
        if (MinaConstants.CODE_EXAM == id) {
            request();
        }
    }
}
