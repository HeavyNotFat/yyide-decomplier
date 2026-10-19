package com.yd.android_brand_mvp.landscape.exam;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
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
import com.blankj.utilcode.util.SizeUtils;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.listener.OnItemClickListener;
import com.tencent.smtt.sdk.TbsListener;
import com.xiaomi.mipush.sdk.Constants;
import com.yd.android_brand_mvp.R;
import com.yd.android_brand_mvp.activity.exam.ExamArrangementActivity;
import com.yd.android_brand_mvp.base.BaseBindingAdapter;
import com.yd.android_brand_mvp.base.KTBaseFragment;
import com.yd.android_brand_mvp.base.MinaConstants;
import com.yd.android_brand_mvp.base.ResultCodeStr;
import com.yd.android_brand_mvp.base.VBViewHolder;
import com.yd.android_brand_mvp.databinding.FragmentHomeExamArrangement44Binding;
import com.yd.android_brand_mvp.databinding.ItemExamArranement44WeekBinding;
import com.yd.android_brand_mvp.databinding.ItemExamArrangement44CourseBinding;
import com.yd.android_brand_mvp.dialog.exam.ExamDetailDialog;
import com.yd.android_brand_mvp.landscape.exam.viewmodel.ExamArrangementViewModel;
import com.yd.android_brand_mvp.model.exam.ExamArrangementBean;
import com.yd.android_brand_mvp.model.exam.ExamGroupItem;
import com.yd.android_brand_mvp.model.exam.ExamPlanItem;
import com.yd.android_brand_mvp.model.exam.ExamWeekBean;
import com.yd.android_brand_mvp.model.task.TaskVerifyBean;
import com.yd.android_brand_mvp.observer.MinaEventManager;
import com.yd.android_brand_mvp.utils.DateUtils;
import com.yd.android_brand_mvp.utils.SimpleUtilsKt;
import com.yd.android_brand_mvp.utils.TimeUtil;
import com.yd.android_brand_mvp.utils.ToastUtil;
import com.yd.android_brand_mvp.verfity.StudentCheackActivity;
import com.yd.android_brand_mvp.weight.recycleview.MyGirdItemDecoration;
import com.yyide.facepass.AppExtKt;
import java.util.ArrayList;
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
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.MutableSharedFlow;

/* JADX INFO: compiled from: ExamArrangement44Fragment.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0002\u0005\u001a\u0018\u0000 -2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001-B\u0005¢\u0006\u0002\u0010\u0003J\u0010\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\u0012H\u0016J\b\u0010!\u001a\u00020\u0012H\u0002J\b\u0010\"\u001a\u00020\u001fH\u0002J\u001a\u0010#\u001a\u00020\u001f2\u0006\u0010$\u001a\u00020%2\b\u0010&\u001a\u0004\u0018\u00010'H\u0016J\u0010\u0010(\u001a\u00020\u001f2\u0006\u0010)\u001a\u00020*H\u0002J\b\u0010+\u001a\u00020\u001fH\u0002J\b\u0010,\u001a\u00020\u001fH\u0002R\u001b\u0010\u0004\u001a\u00020\u00058BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\u0006\u0010\u0007R\u001c\u0010\n\u001a\u0010\u0012\f\u0012\n \r*\u0004\u0018\u00010\f0\f0\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u000fX\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u000fX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082.¢\u0006\u0002\n\u0000R\u0016\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u000f0\u0017X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0018R\u001b\u0010\u0019\u001a\u00020\u001a8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001d\u0010\t\u001a\u0004\b\u001b\u0010\u001c¨\u0006."}, d2 = {"Lcom/yd/android_brand_mvp/landscape/exam/ExamArrangement44Fragment;", "Lcom/yd/android_brand_mvp/base/KTBaseFragment;", "Lcom/yd/android_brand_mvp/databinding/FragmentHomeExamArrangement44Binding;", "()V", "courseAdapter", "com/yd/android_brand_mvp/landscape/exam/ExamArrangement44Fragment$courseAdapter$2$1", "getCourseAdapter", "()Lcom/yd/android_brand_mvp/landscape/exam/ExamArrangement44Fragment$courseAdapter$2$1;", "courseAdapter$delegate", "Lkotlin/Lazy;", "jumpActivityWithResult", "Landroidx/activity/result/ActivityResultLauncher;", "Landroid/content/Intent;", "kotlin.jvm.PlatformType", "sourceTimeFormat", "", "targetTimeFormat", "timerTimeSecond", "", "type", "viewModel", "Lcom/yd/android_brand_mvp/landscape/exam/viewmodel/ExamArrangementViewModel;", "week7", "", "[Ljava/lang/String;", "weekAdapter", "com/yd/android_brand_mvp/landscape/exam/ExamArrangement44Fragment$weekAdapter$2$1", "getWeekAdapter", "()Lcom/yd/android_brand_mvp/landscape/exam/ExamArrangement44Fragment$weekAdapter$2$1;", "weekAdapter$delegate", "UpdataEvent", "", "id", "getHighLightIndex", "initView", "onViewCreated", "view", "Landroid/view/View;", "savedInstanceState", "Landroid/os/Bundle;", "parserLastActivityData", "result", "Landroidx/activity/result/ActivityResult;", "request", "setHighLightItem", "Companion", "app_commonRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class ExamArrangement44Fragment extends KTBaseFragment<FragmentHomeExamArrangement44Binding> {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* JADX INFO: renamed from: courseAdapter$delegate, reason: from kotlin metadata */
    private final Lazy courseAdapter;
    private final ActivityResultLauncher<Intent> jumpActivityWithResult;
    private final String sourceTimeFormat;
    private final String targetTimeFormat;
    private final int timerTimeSecond;
    private String type;
    private ExamArrangementViewModel viewModel;
    private final String[] week7;

    /* JADX INFO: renamed from: weekAdapter$delegate, reason: from kotlin metadata */
    private final Lazy weekAdapter;

    /* JADX INFO: renamed from: com.yd.android_brand_mvp.landscape.exam.ExamArrangement44Fragment$1, reason: invalid class name */
    /* JADX INFO: compiled from: ExamArrangement44Fragment.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements Function3<LayoutInflater, ViewGroup, Boolean, FragmentHomeExamArrangement44Binding> {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        AnonymousClass1() {
            super(3, FragmentHomeExamArrangement44Binding.class, "inflate", "inflate(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Z)Lcom/yd/android_brand_mvp/databinding/FragmentHomeExamArrangement44Binding;", 0);
        }

        public final FragmentHomeExamArrangement44Binding invoke(LayoutInflater p0, ViewGroup viewGroup, boolean z) {
            Intrinsics.checkNotNullParameter(p0, "p0");
            return FragmentHomeExamArrangement44Binding.inflate(p0, viewGroup, z);
        }

        @Override // kotlin.jvm.functions.Function3
        public /* bridge */ /* synthetic */ FragmentHomeExamArrangement44Binding invoke(LayoutInflater layoutInflater, ViewGroup viewGroup, Boolean bool) {
            return invoke(layoutInflater, viewGroup, bool.booleanValue());
        }
    }

    public static final /* synthetic */ FragmentHomeExamArrangement44Binding access$getBinding(ExamArrangement44Fragment examArrangement44Fragment) {
        return examArrangement44Fragment.getBinding();
    }

    public ExamArrangement44Fragment() {
        super(AnonymousClass1.INSTANCE);
        this.week7 = new String[]{"星期日", "星期一", "星期二", "星期三", "星期四", "星期五", "星期六"};
        this.sourceTimeFormat = "yyyy-MM-dd HH:mm:ss";
        this.targetTimeFormat = "HH:mm";
        this.timerTimeSecond = 120;
        ActivityResultLauncher<Intent> activityResultLauncherRegisterForActivityResult = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback() { // from class: com.yd.android_brand_mvp.landscape.exam.-$$Lambda$ExamArrangement44Fragment$huM9qaO9CnQ5L5NrXVus73rYC0s
            @Override // androidx.activity.result.ActivityResultCallback
            public final void onActivityResult(Object obj) {
                ExamArrangement44Fragment.jumpActivityWithResult$lambda$0(this.f$0, (ActivityResult) obj);
            }
        });
        Intrinsics.checkNotNullExpressionValue(activityResultLauncherRegisterForActivityResult, "registerForActivityResul…ityData(result)\n        }");
        this.jumpActivityWithResult = activityResultLauncherRegisterForActivityResult;
        this.weekAdapter = LazyKt.lazy(new Function0<ExamArrangement44Fragment$weekAdapter$2.AnonymousClass1>() { // from class: com.yd.android_brand_mvp.landscape.exam.ExamArrangement44Fragment$weekAdapter$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            /* JADX WARN: Type inference failed for: r0v0, types: [com.yd.android_brand_mvp.landscape.exam.ExamArrangement44Fragment$weekAdapter$2$1] */
            @Override // kotlin.jvm.functions.Function0
            public final AnonymousClass1 invoke() {
                final ExamArrangement44Fragment examArrangement44Fragment = this.this$0;
                return new BaseBindingAdapter<ItemExamArranement44WeekBinding, ExamWeekBean>() { // from class: com.yd.android_brand_mvp.landscape.exam.ExamArrangement44Fragment$weekAdapter$2.1
                    {
                        super(null, 1, null);
                    }

                    @Override // com.yd.android_brand_mvp.base.BaseBindingAdapter
                    public /* bridge */ /* synthetic */ void convertPlus(VBViewHolder vBViewHolder, ExamWeekBean examWeekBean) {
                        convertPlus2((VBViewHolder<ItemExamArranement44WeekBinding>) vBViewHolder, examWeekBean);
                    }

                    /* JADX INFO: renamed from: convertPlus, reason: avoid collision after fix types in other method */
                    public void convertPlus2(VBViewHolder<ItemExamArranement44WeekBinding> holder, ExamWeekBean item) {
                        Intrinsics.checkNotNullParameter(holder, "holder");
                        Intrinsics.checkNotNullParameter(item, "item");
                        ItemExamArranement44WeekBinding itemExamArranement44WeekBinding = (ItemExamArranement44WeekBinding) holder.getBinding();
                        if (itemExamArranement44WeekBinding != null) {
                            itemExamArranement44WeekBinding.tvItemExamArrangement44WeekName.setText(examArrangement44Fragment.week7[item.getWeekIndex()]);
                            itemExamArranement44WeekBinding.tvItemExamArrangement44WeekTime.setText(item.getTime());
                        }
                    }

                    @Override // com.yd.android_brand_mvp.base.BaseBindingAdapter
                    public ItemExamArranement44WeekBinding createViewBinding(LayoutInflater inflater, ViewGroup parent) {
                        Intrinsics.checkNotNullParameter(inflater, "inflater");
                        Intrinsics.checkNotNullParameter(parent, "parent");
                        ItemExamArranement44WeekBinding itemExamArranement44WeekBindingInflate = ItemExamArranement44WeekBinding.inflate(inflater, parent, false);
                        Intrinsics.checkNotNullExpressionValue(itemExamArranement44WeekBindingInflate, "inflate(inflater, parent, false)");
                        return itemExamArranement44WeekBindingInflate;
                    }
                };
            }
        });
        this.courseAdapter = LazyKt.lazy(new Function0<ExamArrangement44Fragment$courseAdapter$2.AnonymousClass1>() { // from class: com.yd.android_brand_mvp.landscape.exam.ExamArrangement44Fragment$courseAdapter$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            /* JADX WARN: Type inference failed for: r0v0, types: [com.yd.android_brand_mvp.landscape.exam.ExamArrangement44Fragment$courseAdapter$2$1] */
            @Override // kotlin.jvm.functions.Function0
            public final AnonymousClass1 invoke() {
                final ExamArrangement44Fragment examArrangement44Fragment = this.this$0;
                return new BaseBindingAdapter<ItemExamArrangement44CourseBinding, ExamPlanItem>() { // from class: com.yd.android_brand_mvp.landscape.exam.ExamArrangement44Fragment$courseAdapter$2.1
                    {
                        super(null, 1, null);
                    }

                    @Override // com.yd.android_brand_mvp.base.BaseBindingAdapter
                    public /* bridge */ /* synthetic */ void convertPlus(VBViewHolder vBViewHolder, ExamPlanItem examPlanItem) {
                        convertPlus2((VBViewHolder<ItemExamArrangement44CourseBinding>) vBViewHolder, examPlanItem);
                    }

                    /* JADX INFO: renamed from: convertPlus, reason: avoid collision after fix types in other method */
                    public void convertPlus2(VBViewHolder<ItemExamArrangement44CourseBinding> holder, ExamPlanItem item) {
                        Intrinsics.checkNotNullParameter(holder, "holder");
                        Intrinsics.checkNotNullParameter(item, "item");
                        ItemExamArrangement44CourseBinding itemExamArrangement44CourseBinding = (ItemExamArrangement44CourseBinding) holder.getBinding();
                        if (itemExamArrangement44CourseBinding != null) {
                            ExamArrangement44Fragment examArrangement44Fragment2 = examArrangement44Fragment;
                            if (item.isSelect()) {
                                int adapterPosition = holder.getAdapterPosition();
                                if (adapterPosition == CollectionsKt.getLastIndex(getData())) {
                                    itemExamArrangement44CourseBinding.clItemExamArrangement44Course.setBackground(SimpleUtilsKt.asDrawable(R.drawable.bg_right_bottom_r20));
                                } else if (adapterPosition == CollectionsKt.getLastIndex(getData()) - 6) {
                                    itemExamArrangement44CourseBinding.clItemExamArrangement44Course.setBackground(SimpleUtilsKt.asDrawable(R.drawable.bg_left_bottom_r20));
                                } else {
                                    itemExamArrangement44CourseBinding.clItemExamArrangement44Course.setBackgroundColor(SimpleUtilsKt.asColor(R.color.co_e9));
                                }
                                itemExamArrangement44CourseBinding.tvItemExamArrangement44CourseName.setTextColor(SimpleUtilsKt.asColor(R.color.purple2));
                                itemExamArrangement44CourseBinding.tvItemExamArrangement44CourseClass.setTextColor(SimpleUtilsKt.asColor(R.color.purple2));
                                itemExamArrangement44CourseBinding.tvItemExamArrangement44CourseTime.setTextColor(SimpleUtilsKt.asColor(R.color.purple2));
                            } else {
                                itemExamArrangement44CourseBinding.clItemExamArrangement44Course.setBackgroundColor(SimpleUtilsKt.asColor(R.color.transparent));
                                itemExamArrangement44CourseBinding.tvItemExamArrangement44CourseName.setTextColor(SimpleUtilsKt.asColor(R.color.black13));
                                itemExamArrangement44CourseBinding.tvItemExamArrangement44CourseClass.setTextColor(SimpleUtilsKt.asColor(R.color.black16));
                                itemExamArrangement44CourseBinding.tvItemExamArrangement44CourseTime.setTextColor(SimpleUtilsKt.asColor(R.color.black16));
                            }
                            itemExamArrangement44CourseBinding.tvItemExamArrangement44CourseName.setText(item.getSubjectName());
                            if (!item.getGroup().isEmpty()) {
                                itemExamArrangement44CourseBinding.tvItemExamArrangement44CourseClass.setText(((ExamGroupItem) CollectionsKt.first((List) item.getGroup())).getObjectName());
                            } else {
                                itemExamArrangement44CourseBinding.tvItemExamArrangement44CourseClass.setText("");
                            }
                            String str = TimeUtil.formatTime(item.getExamStartTime(), examArrangement44Fragment2.sourceTimeFormat, examArrangement44Fragment2.targetTimeFormat) + '-' + TimeUtil.formatTime(item.getExamEndTime(), examArrangement44Fragment2.sourceTimeFormat, examArrangement44Fragment2.targetTimeFormat);
                            if (Intrinsics.areEqual(str, Constants.ACCEPT_TIME_SEPARATOR_SERVER)) {
                                itemExamArrangement44CourseBinding.tvItemExamArrangement44CourseTime.setText("");
                            } else {
                                itemExamArrangement44CourseBinding.tvItemExamArrangement44CourseTime.setText(str);
                            }
                        }
                    }

                    @Override // com.yd.android_brand_mvp.base.BaseBindingAdapter
                    public ItemExamArrangement44CourseBinding createViewBinding(LayoutInflater inflater, ViewGroup parent) {
                        Intrinsics.checkNotNullParameter(inflater, "inflater");
                        Intrinsics.checkNotNullParameter(parent, "parent");
                        ItemExamArrangement44CourseBinding itemExamArrangement44CourseBindingInflate = ItemExamArrangement44CourseBinding.inflate(inflater, parent, false);
                        Intrinsics.checkNotNullExpressionValue(itemExamArrangement44CourseBindingInflate, "inflate(inflater, parent, false)");
                        return itemExamArrangement44CourseBindingInflate;
                    }
                };
            }
        });
    }

    /* JADX INFO: compiled from: ExamArrangement44Fragment.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¨\u0006\u0007"}, d2 = {"Lcom/yd/android_brand_mvp/landscape/exam/ExamArrangement44Fragment$Companion;", "", "()V", "newInstance", "Landroidx/fragment/app/Fragment;", "type", "", "app_commonRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final Fragment newInstance(String type) {
            ExamArrangement44Fragment examArrangement44Fragment = new ExamArrangement44Fragment();
            Bundle bundle = new Bundle();
            bundle.putString("type", type);
            examArrangement44Fragment.setArguments(bundle);
            return examArrangement44Fragment;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void jumpActivityWithResult$lambda$0(ExamArrangement44Fragment this$0, ActivityResult result) {
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
        Intrinsics.checkNotNullExpressionValue(taskVerifyBean, "resultData.getParcelable…                ?: return");
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
        if (examPlanItem == null) {
            return;
        }
        ExamArrangementViewModel examArrangementViewModel2 = this.viewModel;
        if (examArrangementViewModel2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        } else {
            examArrangementViewModel = examArrangementViewModel2;
        }
        examArrangementViewModel.signInExam(taskVerifyBean.getUserId(), examPlanItem.getSiteId(), examPlanItem.getSubjectId(), examPlanItem.getExaminationId());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ExamArrangement44Fragment$weekAdapter$2.AnonymousClass1 getWeekAdapter() {
        return (ExamArrangement44Fragment$weekAdapter$2.AnonymousClass1) this.weekAdapter.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ExamArrangement44Fragment$courseAdapter$2.AnonymousClass1 getCourseAdapter() {
        return (ExamArrangement44Fragment$courseAdapter$2.AnonymousClass1) this.courseAdapter.getValue();
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
            string = "hbksgl44";
        }
        this.type = string;
        if (string == null) {
            Intrinsics.throwUninitializedPropertyAccessException("type");
        } else {
            str = string;
        }
        if (Intrinsics.areEqual(str, "hbksgl44")) {
            getBinding().clFragmentExamArrangement.getLayoutParams().width = SizeUtils.dp2px(908.0f);
            getBinding().clFragmentExamArrangement.getLayoutParams().height = SizeUtils.dp2px(604.0f);
        } else if (Intrinsics.areEqual(str, "sbksgl63")) {
            getBinding().clFragmentExamArrangement.getLayoutParams().width = SizeUtils.dp2px(1000.0f);
            getBinding().clFragmentExamArrangement.getLayoutParams().height = SizeUtils.dp2px(646.0f);
        }
        initView();
        request();
    }

    private final void initView() {
        getBinding().topFragmentExamArrangement.title.setText("考试安排");
        getBinding().topFragmentExamArrangement.llTitle.setOnClickListener(new View.OnClickListener() { // from class: com.yd.android_brand_mvp.landscape.exam.-$$Lambda$ExamArrangement44Fragment$9qvJvfzTUr8qQuVgkkTjBRziO8Y
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ExamArrangement44Fragment.initView$lambda$3(this.f$0, view);
            }
        });
        getBinding().rvFragmentExamArrangementWeek.setLayoutManager(new GridLayoutManager(requireContext(), 7));
        getBinding().rvFragmentExamArrangementWeek.setAdapter(getWeekAdapter());
        getBinding().rvFragmentExamArrangementCourse.setLayoutManager(new GridLayoutManager(requireContext(), 7));
        getBinding().rvFragmentExamArrangementCourse.setAdapter(getCourseAdapter());
        getBinding().rvFragmentExamArrangementCourse.addItemDecoration(new MyGirdItemDecoration(requireContext(), SimpleUtilsKt.asColor(R.color.black21), SizeUtils.dp2px(1.0f)));
        getCourseAdapter().setOnItemClickListener(new OnItemClickListener() { // from class: com.yd.android_brand_mvp.landscape.exam.-$$Lambda$ExamArrangement44Fragment$DdE8xMkk7BdUclN0FUKVjEDtAbQ
            @Override // com.chad.library.adapter.base.listener.OnItemClickListener
            public final void onItemClick(BaseQuickAdapter baseQuickAdapter, View view, int i) {
                ExamArrangement44Fragment.initView$lambda$4(this.f$0, baseQuickAdapter, view, i);
            }
        });
        getBinding().btnFragmentExamSign.setOnClickListener(new View.OnClickListener() { // from class: com.yd.android_brand_mvp.landscape.exam.-$$Lambda$ExamArrangement44Fragment$z5LZ2kTXNy7Ro8hKO_nPR4KdYz8
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ExamArrangement44Fragment.initView$lambda$7(this.f$0, view);
            }
        });
        ExamArrangementViewModel examArrangementViewModel = this.viewModel;
        if (examArrangementViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            examArrangementViewModel = null;
        }
        LiveData<Result<Boolean>> signInExam = examArrangementViewModel.getSignInExam();
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        final Function1<Result<? extends Boolean>, Unit> function1 = new Function1<Result<? extends Boolean>, Unit>() { // from class: com.yd.android_brand_mvp.landscape.exam.ExamArrangement44Fragment.initView.4
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
                ToastUtil.showBottomView((Activity) ExamArrangement44Fragment.this.requireActivity(), "签到成功");
                MinaEventManager.getInstance().notifyObserver(MinaConstants.CODE_EXAM);
            }
        };
        signInExam.observe(viewLifecycleOwner, new Observer() { // from class: com.yd.android_brand_mvp.landscape.exam.-$$Lambda$ExamArrangement44Fragment$8wzX51rszxZ4FcP7W-b_Ftve4y0
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                ExamArrangement44Fragment.initView$lambda$8(function1, obj);
            }
        });
        ExamArrangementViewModel examArrangementViewModel2 = this.viewModel;
        if (examArrangementViewModel2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            examArrangementViewModel2 = null;
        }
        LiveData<Result<List<ExamArrangementBean>>> weekExam = examArrangementViewModel2.getWeekExam();
        LifecycleOwner viewLifecycleOwner2 = getViewLifecycleOwner();
        final Function1<Result<? extends List<? extends ExamArrangementBean>>, Unit> function2 = new Function1<Result<? extends List<? extends ExamArrangementBean>>, Unit>() { // from class: com.yd.android_brand_mvp.landscape.exam.ExamArrangement44Fragment.initView.5
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Result<? extends List<? extends ExamArrangementBean>> result) {
                invoke2(result);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Result<? extends List<? extends ExamArrangementBean>> it2) {
                Intrinsics.checkNotNullExpressionValue(it2, "it");
                Object value = it2.getValue();
                if (Result.m597isFailureimpl(value)) {
                    value = null;
                }
                List list = (List) value;
                List list2 = list;
                if (list2 == null || list2.isEmpty()) {
                    ViewStub viewStub = ExamArrangement44Fragment.access$getBinding(ExamArrangement44Fragment.this).emptyView2;
                    Intrinsics.checkNotNullExpressionValue(viewStub, "binding.emptyView2");
                    viewStub.setVisibility(0);
                    return;
                }
                ViewStub viewStub2 = ExamArrangement44Fragment.access$getBinding(ExamArrangement44Fragment.this).emptyView2;
                Intrinsics.checkNotNullExpressionValue(viewStub2, "binding.emptyView2");
                viewStub2.setVisibility(8);
                ArrayList arrayList = new ArrayList();
                List<ExamArrangementBean> list3 = list;
                int size = 0;
                for (ExamArrangementBean examArrangementBean : list3) {
                    String time = TimeUtil.formatTime(examArrangementBean.getDateTime(), TimeUtil.dateYMDFormat, TimeUtil.chDateMDFormat);
                    Intrinsics.checkNotNullExpressionValue(time, "time");
                    arrayList.add(new ExamWeekBean(time, examArrangementBean.getWeekDay() - 1));
                    if (examArrangementBean.getExamPlan().size() > size) {
                        size = examArrangementBean.getExamPlan().size();
                    }
                }
                if (size == 0) {
                    ExamArrangement44Fragment.this.getWeekAdapter().setList(arrayList);
                    TextView textView = ExamArrangement44Fragment.access$getBinding(ExamArrangement44Fragment.this).btnFragmentExamSign;
                    Intrinsics.checkNotNullExpressionValue(textView, "binding.btnFragmentExamSign");
                    SimpleUtilsKt.remove(textView);
                    ViewStub viewStub3 = ExamArrangement44Fragment.access$getBinding(ExamArrangement44Fragment.this).emptyView;
                    Intrinsics.checkNotNullExpressionValue(viewStub3, "binding.emptyView");
                    viewStub3.setVisibility(0);
                    return;
                }
                ViewStub viewStub4 = ExamArrangement44Fragment.access$getBinding(ExamArrangement44Fragment.this).emptyView;
                Intrinsics.checkNotNullExpressionValue(viewStub4, "binding.emptyView");
                viewStub4.setVisibility(8);
                TextView textView2 = ExamArrangement44Fragment.access$getBinding(ExamArrangement44Fragment.this).btnFragmentExamSign;
                Intrinsics.checkNotNullExpressionValue(textView2, "binding.btnFragmentExamSign");
                SimpleUtilsKt.show(textView2);
                int i = size * 7;
                ArrayList arrayList2 = new ArrayList(i);
                for (int i2 = 0; i2 < i; i2++) {
                    arrayList2.add(new ExamPlanItem(null, null, 0, null, 0, null, 0, null, 0, null, false, false, null, 0, null, 0, null, null, null, null, 0, 0, 0, false, 16777215, null));
                }
                ArrayList arrayList3 = arrayList2;
                int i3 = 0;
                for (Object obj : list3) {
                    int i4 = i3 + 1;
                    if (i3 < 0) {
                        CollectionsKt.throwIndexOverflow();
                    }
                    ExamArrangementBean examArrangementBean2 = (ExamArrangementBean) obj;
                    int i5 = 0;
                    for (Object obj2 : examArrangementBean2.getExamPlan()) {
                        int i6 = i5 + 1;
                        if (i5 < 0) {
                            CollectionsKt.throwIndexOverflow();
                        }
                        ExamPlanItem examPlanItem = (ExamPlanItem) obj2;
                        examPlanItem.setWeekDay(examArrangementBean2.getWeekDay());
                        arrayList3.set((i5 * 7) + i3, examPlanItem);
                        i5 = i6;
                    }
                    i3 = i4;
                }
                ExamArrangement44Fragment.this.getWeekAdapter().setList(arrayList);
                ExamArrangement44Fragment.this.getCourseAdapter().setList(arrayList3);
                ExamArrangement44Fragment.this.setHighLightItem();
            }
        };
        weekExam.observe(viewLifecycleOwner2, new Observer() { // from class: com.yd.android_brand_mvp.landscape.exam.-$$Lambda$ExamArrangement44Fragment$dZhh8_sd5b3wyaBc9lRAnPYxQp0
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                ExamArrangement44Fragment.initView$lambda$9(function2, obj);
            }
        });
        BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), null, null, new AnonymousClass6(null), 3, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$3(ExamArrangement44Fragment this$0, View view) {
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
    public static final void initView$lambda$4(ExamArrangement44Fragment this$0, BaseQuickAdapter adapter, View view, int i) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(adapter, "adapter");
        Intrinsics.checkNotNullParameter(view, "view");
        ExamPlanItem item = this$0.getCourseAdapter().getItem(i);
        String str = this$0.type;
        if (str == null) {
            Intrinsics.throwUninitializedPropertyAccessException("type");
            str = null;
        }
        new ExamDetailDialog(item, StringsKt.startsWith$default(str, "sb", false, 2, (Object) null)).show(this$0.getChildFragmentManager(), "examDetailDialog");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$7(ExamArrangement44Fragment this$0, View view) {
        Object next;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (this$0.getCourseAdapter().getData().isEmpty()) {
            Context contextRequireContext = this$0.requireContext();
            Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext()");
            SimpleUtilsKt.showLongToast(contextRequireContext, "没有考试安排");
            return;
        }
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
            Context contextRequireContext2 = this$0.requireContext();
            Intrinsics.checkNotNullExpressionValue(contextRequireContext2, "requireContext()");
            String string = this$0.getString(R.string.not_need_sign_in);
            Intrinsics.checkNotNullExpressionValue(string, "getString(R.string.not_need_sign_in)");
            SimpleUtilsKt.showShotToast(contextRequireContext2, string);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$8(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$9(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: renamed from: com.yd.android_brand_mvp.landscape.exam.ExamArrangement44Fragment$initView$6, reason: invalid class name */
    /* JADX INFO: compiled from: ExamArrangement44Fragment.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "com.yd.android_brand_mvp.landscape.exam.ExamArrangement44Fragment$initView$6", f = "ExamArrangement44Fragment.kt", i = {0}, l = {TbsListener.ErrorCode.ERROR_QBSDK_INIT_RETCODE_ERROR, TbsListener.ErrorCode.ERROR_SDKENGINE_INIT_THROWABLE}, m = "invokeSuspend", n = {"$this$launch"}, s = {"L$0"})
    static final class AnonymousClass6 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        private /* synthetic */ Object L$0;
        int label;

        AnonymousClass6(Continuation<? super AnonymousClass6> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            AnonymousClass6 anonymousClass6 = ExamArrangement44Fragment.this.new AnonymousClass6(continuation);
            anonymousClass6.L$0 = obj;
            return anonymousClass6;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass6) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
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
            ExamArrangementViewModel examArrangementViewModel = ExamArrangement44Fragment.this.viewModel;
            if (examArrangementViewModel == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewModel");
                examArrangementViewModel = null;
            }
            this.L$0 = coroutineScope;
            this.label = 1;
            if (examArrangementViewModel.startTimer(ExamArrangement44Fragment.this.timerTimeSecond, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
            ExamArrangementViewModel examArrangementViewModel2 = ExamArrangement44Fragment.this.viewModel;
            if (examArrangementViewModel2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewModel");
                examArrangementViewModel2 = null;
            }
            MutableSharedFlow<String> timeSharedFlow = examArrangementViewModel2.getTimeSharedFlow();
            final ExamArrangement44Fragment examArrangement44Fragment = ExamArrangement44Fragment.this;
            this.L$0 = null;
            this.label = 2;
            if (timeSharedFlow.collect(new FlowCollector() { // from class: com.yd.android_brand_mvp.landscape.exam.ExamArrangement44Fragment.initView.6.1
                @Override // kotlinx.coroutines.flow.FlowCollector
                public /* bridge */ /* synthetic */ Object emit(Object obj2, Continuation continuation) {
                    return emit((String) obj2, (Continuation<? super Unit>) continuation);
                }

                public final Object emit(String str, Continuation<? super Unit> continuation) {
                    AppExtKt.logd(coroutineScope, "44 收到定时器");
                    examArrangement44Fragment.setHighLightItem();
                    return Unit.INSTANCE;
                }
            }, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
            throw new KotlinNothingValueException();
        }
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
        } else {
            getCourseAdapter().getData().get(highLightIndex).setSelect(true);
            getCourseAdapter().notifyDataSetChanged();
        }
    }

    private final void request() {
        ExamArrangementViewModel examArrangementViewModel = this.viewModel;
        if (examArrangementViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            examArrangementViewModel = null;
        }
        examArrangementViewModel.m339getWeekExam();
    }

    @Override // com.yd.android_brand_mvp.base.BaseFragment, com.yd.android_brand_mvp.observer.MinaListener
    public void UpdataEvent(int id) {
        super.UpdataEvent(id);
        if (MinaConstants.CODE_EXAM == id) {
            request();
        }
    }
}
