package com.yd.android_brand_mvp.landscape.task;

import android.app.Activity;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.bumptech.glide.Glide;
import com.yd.android_brand_mvp.R;
import com.yd.android_brand_mvp.base.BaseBindingAdapter;
import com.yd.android_brand_mvp.base.KTBaseFragment;
import com.yd.android_brand_mvp.base.VBViewHolder;
import com.yd.android_brand_mvp.databinding.ActivityTaskDetailBinding;
import com.yd.android_brand_mvp.databinding.ItemTaskImageListBinding;
import com.yd.android_brand_mvp.databinding.ItemUpImageListBinding;
import com.yd.android_brand_mvp.dialog.MessageTipDialog;
import com.yd.android_brand_mvp.landscape.task.viewmodel.TaskDetailViewModel;
import com.yd.android_brand_mvp.model.selectNewStudentByIcCardRsp;
import com.yd.android_brand_mvp.model.task.EventTaskBean;
import com.yd.android_brand_mvp.model.task.SignTaskRecordListItem;
import com.yd.android_brand_mvp.model.task.TaskDetailBean;
import com.yd.android_brand_mvp.utils.DateUtils;
import com.yd.android_brand_mvp.utils.SimpleUtilsKt;
import com.yd.android_brand_mvp.utils.SpData;
import com.yd.android_brand_mvp.utils.ToastUtil;
import com.yd.android_brand_mvp.utils.TransUtils;
import com.yd.android_brand_mvp.view.TagTextView;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.text.StringsKt;
import org.eclipse.paho.client.mqttv3.MqttTopic;
import org.greenrobot.eventbus.EventBus;

/* JADX INFO: compiled from: TaskDetailFragment.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 (2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001(B\u0005¢\u0006\u0002\u0010\u0003J\b\u0010\u001e\u001a\u00020\u001fH\u0002J\b\u0010 \u001a\u00020\u001fH\u0002J\u001a\u0010!\u001a\u00020\u001f2\u0006\u0010\"\u001a\u00020#2\b\u0010$\u001a\u0004\u0018\u00010%H\u0016J\b\u0010&\u001a\u00020\u001fH\u0002J\b\u0010'\u001a\u00020\u001fH\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R'\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u00078BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\n\u0010\u000bR\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082.¢\u0006\u0002\n\u0000R\u0014\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\t0\u0015X\u0082\u0004¢\u0006\u0002\n\u0000R#\u0010\u0016\u001a\n \u0018*\u0004\u0018\u00010\u00170\u00178BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001b\u0010\r\u001a\u0004\b\u0019\u0010\u001aR\u000e\u0010\u001c\u001a\u00020\u001dX\u0082.¢\u0006\u0002\n\u0000¨\u0006)"}, d2 = {"Lcom/yd/android_brand_mvp/landscape/task/TaskDetailFragment;", "Lcom/yd/android_brand_mvp/base/KTBaseFragment;", "Lcom/yd/android_brand_mvp/databinding/ActivityTaskDetailBinding;", "()V", "id", "", "imageAdapter", "Lcom/yd/android_brand_mvp/base/BaseBindingAdapter;", "Lcom/yd/android_brand_mvp/databinding/ItemUpImageListBinding;", "Lcom/yd/android_brand_mvp/model/task/SignTaskRecordListItem;", "getImageAdapter", "()Lcom/yd/android_brand_mvp/base/BaseBindingAdapter;", "imageAdapter$delegate", "Lkotlin/Lazy;", "imageListShowMode", "", "isFromEnd", "", "showData", "Lcom/yd/android_brand_mvp/model/task/TaskDetailBean;", "showImageList", "", "studentInfo", "Lcom/yd/android_brand_mvp/model/selectNewStudentByIcCardRsp$DataBean;", "kotlin.jvm.PlatformType", "getStudentInfo", "()Lcom/yd/android_brand_mvp/model/selectNewStudentByIcCardRsp$DataBean;", "studentInfo$delegate", "viewModel", "Lcom/yd/android_brand_mvp/landscape/task/viewmodel/TaskDetailViewModel;", "initListener", "", "initView", "onViewCreated", "view", "Landroid/view/View;", "savedInstanceState", "Landroid/os/Bundle;", "setContent", "setRvUI", "Companion", "app_commonRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class TaskDetailFragment extends KTBaseFragment<ActivityTaskDetailBinding> {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private String id;

    /* JADX INFO: renamed from: imageAdapter$delegate, reason: from kotlin metadata */
    private final Lazy imageAdapter;
    private int imageListShowMode;
    private boolean isFromEnd;
    private TaskDetailBean showData;
    private final List<SignTaskRecordListItem> showImageList;

    /* JADX INFO: renamed from: studentInfo$delegate, reason: from kotlin metadata */
    private final Lazy studentInfo;
    private TaskDetailViewModel viewModel;

    /* JADX INFO: renamed from: com.yd.android_brand_mvp.landscape.task.TaskDetailFragment$1, reason: invalid class name */
    /* JADX INFO: compiled from: TaskDetailFragment.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements Function3<LayoutInflater, ViewGroup, Boolean, ActivityTaskDetailBinding> {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        AnonymousClass1() {
            super(3, ActivityTaskDetailBinding.class, "inflate", "inflate(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Z)Lcom/yd/android_brand_mvp/databinding/ActivityTaskDetailBinding;", 0);
        }

        public final ActivityTaskDetailBinding invoke(LayoutInflater p0, ViewGroup viewGroup, boolean z) {
            Intrinsics.checkNotNullParameter(p0, "p0");
            return ActivityTaskDetailBinding.inflate(p0, viewGroup, z);
        }

        @Override // kotlin.jvm.functions.Function3
        public /* bridge */ /* synthetic */ ActivityTaskDetailBinding invoke(LayoutInflater layoutInflater, ViewGroup viewGroup, Boolean bool) {
            return invoke(layoutInflater, viewGroup, bool.booleanValue());
        }
    }

    public TaskDetailFragment() {
        super(AnonymousClass1.INSTANCE);
        this.showImageList = new ArrayList();
        this.imageListShowMode = 1;
        this.id = "-1";
        this.studentInfo = LazyKt.lazy(new Function0<selectNewStudentByIcCardRsp.DataBean>() { // from class: com.yd.android_brand_mvp.landscape.task.TaskDetailFragment$studentInfo$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final selectNewStudentByIcCardRsp.DataBean invoke() {
                return SpData.USERCENTINFO2().data;
            }
        });
        this.imageAdapter = LazyKt.lazy(new Function0<TaskDetailFragment$imageAdapter$2.AnonymousClass1>() { // from class: com.yd.android_brand_mvp.landscape.task.TaskDetailFragment$imageAdapter$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            /* JADX WARN: Type inference failed for: r0v0, types: [com.yd.android_brand_mvp.landscape.task.TaskDetailFragment$imageAdapter$2$1] */
            @Override // kotlin.jvm.functions.Function0
            public final AnonymousClass1 invoke() {
                final TaskDetailFragment taskDetailFragment = this.this$0;
                return new BaseBindingAdapter<ItemUpImageListBinding, SignTaskRecordListItem>() { // from class: com.yd.android_brand_mvp.landscape.task.TaskDetailFragment$imageAdapter$2.1
                    {
                        super(null, 1, null);
                    }

                    @Override // com.yd.android_brand_mvp.base.BaseBindingAdapter
                    public /* bridge */ /* synthetic */ void convertPlus(VBViewHolder vBViewHolder, SignTaskRecordListItem signTaskRecordListItem) {
                        convertPlus2((VBViewHolder<ItemUpImageListBinding>) vBViewHolder, signTaskRecordListItem);
                    }

                    /* JADX INFO: renamed from: convertPlus, reason: avoid collision after fix types in other method */
                    public void convertPlus2(VBViewHolder<ItemUpImageListBinding> holder, SignTaskRecordListItem item) {
                        Intrinsics.checkNotNullParameter(holder, "holder");
                        Intrinsics.checkNotNullParameter(item, "item");
                        ItemUpImageListBinding itemUpImageListBinding = (ItemUpImageListBinding) holder.getBinding();
                        if (itemUpImageListBinding != null) {
                            final TaskDetailFragment taskDetailFragment2 = taskDetailFragment;
                            if (holder.getAdapterPosition() == 0) {
                                View view = itemUpImageListBinding.lineTop;
                                Intrinsics.checkNotNullExpressionValue(view, "it.lineTop");
                                SimpleUtilsKt.remove(view);
                            } else {
                                View view2 = itemUpImageListBinding.lineTop;
                                Intrinsics.checkNotNullExpressionValue(view2, "it.lineTop");
                                SimpleUtilsKt.show(view2);
                            }
                            if (taskDetailFragment2.getImageAdapter().getData().size() == 1) {
                                if (!item.getFileUrlList().isEmpty()) {
                                    ImageView imageView = itemUpImageListBinding.ivItemUpImageListLogo2;
                                    Intrinsics.checkNotNullExpressionValue(imageView, "it.ivItemUpImageListLogo2");
                                    SimpleUtilsKt.show(imageView);
                                    View view3 = itemUpImageListBinding.lineCenter;
                                    Intrinsics.checkNotNullExpressionValue(view3, "it.lineCenter");
                                    SimpleUtilsKt.show(view3);
                                } else {
                                    ImageView imageView2 = itemUpImageListBinding.ivItemUpImageListLogo2;
                                    Intrinsics.checkNotNullExpressionValue(imageView2, "it.ivItemUpImageListLogo2");
                                    SimpleUtilsKt.remove(imageView2);
                                    View view4 = itemUpImageListBinding.lineCenter;
                                    Intrinsics.checkNotNullExpressionValue(view4, "it.lineCenter");
                                    SimpleUtilsKt.remove(view4);
                                }
                                View view5 = itemUpImageListBinding.lineBottom;
                                Intrinsics.checkNotNullExpressionValue(view5, "it.lineBottom");
                                SimpleUtilsKt.remove(view5);
                            } else {
                                ImageView imageView3 = itemUpImageListBinding.ivItemUpImageListLogo2;
                                Intrinsics.checkNotNullExpressionValue(imageView3, "it.ivItemUpImageListLogo2");
                                SimpleUtilsKt.remove(imageView3);
                                if (holder.getAdapterPosition() == taskDetailFragment2.getImageAdapter().getData().size() - 1) {
                                    View view6 = itemUpImageListBinding.lineCenter;
                                    Intrinsics.checkNotNullExpressionValue(view6, "it.lineCenter");
                                    SimpleUtilsKt.remove(view6);
                                    View view7 = itemUpImageListBinding.lineBottom;
                                    Intrinsics.checkNotNullExpressionValue(view7, "it.lineBottom");
                                    SimpleUtilsKt.remove(view7);
                                } else {
                                    View view8 = itemUpImageListBinding.lineCenter;
                                    Intrinsics.checkNotNullExpressionValue(view8, "it.lineCenter");
                                    SimpleUtilsKt.show(view8);
                                    View view9 = itemUpImageListBinding.lineBottom;
                                    Intrinsics.checkNotNullExpressionValue(view9, "it.lineBottom");
                                    SimpleUtilsKt.show(view9);
                                }
                            }
                            String time = DateUtils.formatTime(item.getSignTime(), "", "yyyy-MM-dd");
                            TextView textView = itemUpImageListBinding.tvItemUpImageListTitle;
                            StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
                            String string = taskDetailFragment2.getString(R.string.sign_time);
                            Intrinsics.checkNotNullExpressionValue(string, "getString(R.string.sign_time)");
                            String str = String.format(string, Arrays.copyOf(new Object[]{time}, 1));
                            Intrinsics.checkNotNullExpressionValue(str, "format(format, *args)");
                            textView.setText(str);
                            if (item.getFileUrlList().isEmpty()) {
                                RecyclerView recyclerView = itemUpImageListBinding.rvItemTaskImageList;
                                Intrinsics.checkNotNullExpressionValue(recyclerView, "it.rvItemTaskImageList");
                                SimpleUtilsKt.remove(recyclerView);
                            } else {
                                Lazy lazy = LazyKt.lazy(new Function0<TaskDetailFragment$imageAdapter$2$1$convertPlus$1$itemImageAdapter$2.AnonymousClass1>() { // from class: com.yd.android_brand_mvp.landscape.task.TaskDetailFragment$imageAdapter$2$1$convertPlus$1$itemImageAdapter$2
                                    {
                                        super(0);
                                    }

                                    /* JADX WARN: Can't rename method to resolve collision */
                                    /* JADX WARN: Type inference failed for: r0v0, types: [com.yd.android_brand_mvp.landscape.task.TaskDetailFragment$imageAdapter$2$1$convertPlus$1$itemImageAdapter$2$1] */
                                    @Override // kotlin.jvm.functions.Function0
                                    public final AnonymousClass1 invoke() {
                                        final TaskDetailFragment taskDetailFragment3 = taskDetailFragment2;
                                        return new BaseBindingAdapter<ItemTaskImageListBinding, String>() { // from class: com.yd.android_brand_mvp.landscape.task.TaskDetailFragment$imageAdapter$2$1$convertPlus$1$itemImageAdapter$2.1
                                            {
                                                super(null, 1, null);
                                            }

                                            @Override // com.yd.android_brand_mvp.base.BaseBindingAdapter
                                            public /* bridge */ /* synthetic */ void convertPlus(VBViewHolder vBViewHolder, String str2) {
                                                convertPlus2((VBViewHolder<ItemTaskImageListBinding>) vBViewHolder, str2);
                                            }

                                            /* JADX INFO: renamed from: convertPlus, reason: avoid collision after fix types in other method */
                                            public void convertPlus2(VBViewHolder<ItemTaskImageListBinding> holder2, String item2) {
                                                Intrinsics.checkNotNullParameter(holder2, "holder");
                                                Intrinsics.checkNotNullParameter(item2, "item");
                                                ItemTaskImageListBinding itemTaskImageListBinding = (ItemTaskImageListBinding) holder2.getBinding();
                                                if (itemTaskImageListBinding != null) {
                                                    Glide.with(taskDetailFragment3.requireContext()).load(item2).into(itemTaskImageListBinding.ivItemUpImageListImage);
                                                }
                                            }

                                            @Override // com.yd.android_brand_mvp.base.BaseBindingAdapter
                                            public ItemTaskImageListBinding createViewBinding(LayoutInflater inflater, ViewGroup parent) {
                                                Intrinsics.checkNotNullParameter(inflater, "inflater");
                                                Intrinsics.checkNotNullParameter(parent, "parent");
                                                ItemTaskImageListBinding itemTaskImageListBindingInflate = ItemTaskImageListBinding.inflate(inflater, parent, false);
                                                Intrinsics.checkNotNullExpressionValue(itemTaskImageListBindingInflate, "inflate(inflater, parent, false)");
                                                return itemTaskImageListBindingInflate;
                                            }
                                        };
                                    }
                                });
                                itemUpImageListBinding.rvItemTaskImageList.setLayoutManager(new LinearLayoutManager(taskDetailFragment2.requireContext(), 0, false));
                                itemUpImageListBinding.rvItemTaskImageList.setAdapter(convertPlus$lambda$1$lambda$0(lazy));
                                convertPlus$lambda$1$lambda$0(lazy).setList(item.getFileUrlList());
                            }
                        }
                    }

                    private static final BaseBindingAdapter<ItemTaskImageListBinding, String> convertPlus$lambda$1$lambda$0(Lazy<TaskDetailFragment$imageAdapter$2$1$convertPlus$1$itemImageAdapter$2.AnonymousClass1> lazy) {
                        return lazy.getValue();
                    }

                    @Override // com.yd.android_brand_mvp.base.BaseBindingAdapter
                    public ItemUpImageListBinding createViewBinding(LayoutInflater inflater, ViewGroup parent) {
                        Intrinsics.checkNotNullParameter(inflater, "inflater");
                        Intrinsics.checkNotNullParameter(parent, "parent");
                        ItemUpImageListBinding itemUpImageListBindingInflate = ItemUpImageListBinding.inflate(inflater, parent, false);
                        Intrinsics.checkNotNullExpressionValue(itemUpImageListBindingInflate, "inflate(inflater, parent, false)");
                        return itemUpImageListBindingInflate;
                    }
                };
            }
        });
    }

    /* JADX INFO: compiled from: TaskDetailFragment.kt */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\b¨\u0006\n"}, d2 = {"Lcom/yd/android_brand_mvp/landscape/task/TaskDetailFragment$Companion;", "", "()V", "newInstance", "Lcom/yd/android_brand_mvp/landscape/task/TaskDetailFragment;", "id", "", "alreadyEnd", "", "alreadyIng", "app_commonRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final TaskDetailFragment newInstance(String id, boolean alreadyEnd, boolean alreadyIng) {
            Intrinsics.checkNotNullParameter(id, "id");
            TaskDetailFragment taskDetailFragment = new TaskDetailFragment();
            Bundle bundle = new Bundle();
            bundle.putString("data", id);
            bundle.putBoolean("isEnd", alreadyEnd);
            bundle.putBoolean("isIng", alreadyIng);
            taskDetailFragment.setArguments(bundle);
            return taskDetailFragment;
        }
    }

    private final selectNewStudentByIcCardRsp.DataBean getStudentInfo() {
        return (selectNewStudentByIcCardRsp.DataBean) this.studentInfo.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final BaseBindingAdapter<ItemUpImageListBinding, SignTaskRecordListItem> getImageAdapter() {
        return (BaseBindingAdapter) this.imageAdapter.getValue();
    }

    @Override // com.yd.android_brand_mvp.base.KTBaseFragment, com.yd.android_brand_mvp.base.BaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        initView();
        initListener();
    }

    private final void initView() {
        this.viewModel = (TaskDetailViewModel) new ViewModelProvider(this).get(TaskDetailViewModel.class);
        getBinding().topActivityTaskDetail.titleName.setText("任务详情");
        Bundle arguments = getArguments();
        this.isFromEnd = arguments != null ? arguments.getBoolean("isEnd", false) : false;
        Bundle arguments2 = getArguments();
        if (arguments2 != null) {
            arguments2.getBoolean("isIng", false);
        }
        if (!this.isFromEnd) {
            TextView textView = getBinding().tvTaskDetailSignCountTitle;
            Intrinsics.checkNotNullExpressionValue(textView, "binding.tvTaskDetailSignCountTitle");
            SimpleUtilsKt.remove(textView);
            TextView textView2 = getBinding().tvTaskDetailSignCount;
            Intrinsics.checkNotNullExpressionValue(textView2, "binding.tvTaskDetailSignCount");
            SimpleUtilsKt.remove(textView2);
            TextView textView3 = getBinding().tvTaskDetailUpImageTitle;
            Intrinsics.checkNotNullExpressionValue(textView3, "binding.tvTaskDetailUpImageTitle");
            SimpleUtilsKt.remove(textView3);
            ImageView imageView = getBinding().ivTaskDetailTimeLogo;
            Intrinsics.checkNotNullExpressionValue(imageView, "binding.ivTaskDetailTimeLogo");
            SimpleUtilsKt.remove(imageView);
            RecyclerView recyclerView = getBinding().rvTaskDetailUpImage;
            Intrinsics.checkNotNullExpressionValue(recyclerView, "binding.rvTaskDetailUpImage");
            SimpleUtilsKt.remove(recyclerView);
        }
        Bundle arguments3 = getArguments();
        TaskDetailViewModel taskDetailViewModel = null;
        String string = arguments3 != null ? arguments3.getString("data") : null;
        if (string == null) {
            string = "-1";
        }
        this.id = string;
        if (!Intrinsics.areEqual(string, "-1") && getStudentInfo() != null) {
            TaskDetailViewModel taskDetailViewModel2 = this.viewModel;
            if (taskDetailViewModel2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewModel");
                taskDetailViewModel2 = null;
            }
            String str = this.id;
            String str2 = getStudentInfo().id;
            Intrinsics.checkNotNullExpressionValue(str2, "studentInfo.id");
            String str3 = getStudentInfo().schoolId;
            Intrinsics.checkNotNullExpressionValue(str3, "studentInfo.schoolId");
            taskDetailViewModel2.getTaskDetail(str, str2, str3, getStudentInfo().classesId);
        }
        TaskDetailViewModel taskDetailViewModel3 = this.viewModel;
        if (taskDetailViewModel3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            taskDetailViewModel3 = null;
        }
        LiveData<Result<String>> signResult = taskDetailViewModel3.getSignResult();
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        final Function1<Result<? extends String>, Unit> function1 = new Function1<Result<? extends String>, Unit>() { // from class: com.yd.android_brand_mvp.landscape.task.TaskDetailFragment.initView.1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Result<? extends String> result) {
                invoke2(result);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Result<? extends String> it2) {
                String message;
                TaskDetailFragment.this.dismissProgressDialog();
                Intrinsics.checkNotNullExpressionValue(it2, "it");
                if (Result.m598isSuccessimpl(it2.getValue())) {
                    MessageTipDialog messageTipDialog = new MessageTipDialog("打卡成功");
                    final TaskDetailFragment taskDetailFragment = TaskDetailFragment.this;
                    messageTipDialog.setCallBack(new MessageTipDialog.CallBack() { // from class: com.yd.android_brand_mvp.landscape.task.TaskDetailFragment.initView.1.1
                        @Override // com.yd.android_brand_mvp.dialog.MessageTipDialog.CallBack
                        public void clickSubmit() {
                            if (taskDetailFragment.isDetached()) {
                                return;
                            }
                            EventBus.getDefault().post(new EventTaskBean(1, "0"));
                            taskDetailFragment.getParentFragmentManager().popBackStack();
                        }
                    });
                    messageTipDialog.show(TaskDetailFragment.this.getParentFragmentManager(), "messageTip");
                    return;
                }
                FragmentActivity activity = TaskDetailFragment.this.getActivity();
                Throwable thM594exceptionOrNullimpl = Result.m594exceptionOrNullimpl(it2.getValue());
                if (thM594exceptionOrNullimpl == null || (message = thM594exceptionOrNullimpl.getMessage()) == null) {
                    message = "打卡失败";
                }
                ToastUtil.showBottomView((Activity) activity, message);
            }
        };
        signResult.observe(viewLifecycleOwner, new Observer() { // from class: com.yd.android_brand_mvp.landscape.task.-$$Lambda$TaskDetailFragment$IozfikgGVb6ZCnY7fHaT0nDk6h8
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                TaskDetailFragment.initView$lambda$0(function1, obj);
            }
        });
        TaskDetailViewModel taskDetailViewModel4 = this.viewModel;
        if (taskDetailViewModel4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        } else {
            taskDetailViewModel = taskDetailViewModel4;
        }
        LiveData<Result<TaskDetailBean>> detail = taskDetailViewModel.getDetail();
        LifecycleOwner viewLifecycleOwner2 = getViewLifecycleOwner();
        final Function1<Result<? extends TaskDetailBean>, Unit> function2 = new Function1<Result<? extends TaskDetailBean>, Unit>() { // from class: com.yd.android_brand_mvp.landscape.task.TaskDetailFragment.initView.2
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Result<? extends TaskDetailBean> result) {
                invoke2(result);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Result<? extends TaskDetailBean> it2) {
                Intrinsics.checkNotNullExpressionValue(it2, "it");
                Object value = it2.getValue();
                if (Result.m597isFailureimpl(value)) {
                    value = null;
                }
                TaskDetailBean taskDetailBean = (TaskDetailBean) value;
                if (taskDetailBean == null) {
                    return;
                }
                TaskDetailFragment.this.showData = taskDetailBean;
                TaskDetailFragment.this.setContent();
            }
        };
        detail.observe(viewLifecycleOwner2, new Observer() { // from class: com.yd.android_brand_mvp.landscape.task.-$$Lambda$TaskDetailFragment$Y6SrhI0F721dp2ZtheEFmFZSTnI
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                TaskDetailFragment.initView$lambda$1(function2, obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$0(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$1(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void setContent() {
        ImageView imageView;
        Object next;
        TaskDetailBean taskDetailBean = this.showData;
        TaskDetailBean taskDetailBean2 = null;
        if (taskDetailBean == null) {
            Intrinsics.throwUninitializedPropertyAccessException("showData");
            taskDetailBean = null;
        }
        if (taskDetailBean.getTodayCanSign()) {
            TaskDetailBean taskDetailBean3 = this.showData;
            if (taskDetailBean3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("showData");
                taskDetailBean3 = null;
            }
            if (!taskDetailBean3.getTodayHaveSign()) {
                ConstraintLayout constraintLayout = getBinding().clActivitySignTaskBtn;
                Intrinsics.checkNotNullExpressionValue(constraintLayout, "binding.clActivitySignTaskBtn");
                SimpleUtilsKt.show(constraintLayout);
            }
        }
        ArrayList arrayList = new ArrayList();
        TaskDetailBean taskDetailBean4 = this.showData;
        if (taskDetailBean4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("showData");
            taskDetailBean4 = null;
        }
        if (!taskDetailBean4.getSubjectList().isEmpty()) {
            TaskDetailBean taskDetailBean5 = this.showData;
            if (taskDetailBean5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("showData");
                taskDetailBean5 = null;
            }
            Iterator<T> it2 = taskDetailBean5.getSubjectList().iterator();
            do {
                if (!it2.hasNext()) {
                    next = null;
                    break;
                }
                next = it2.next();
            } while (!Intrinsics.areEqual((String) next, "不限"));
            if (next == null) {
                TaskDetailBean taskDetailBean6 = this.showData;
                if (taskDetailBean6 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("showData");
                    taskDetailBean6 = null;
                }
                Iterator<String> it3 = taskDetailBean6.getSubjectList().iterator();
                while (it3.hasNext()) {
                    arrayList.add('(' + it3.next() + ')');
                }
            }
        }
        TagTextView tagTextView = getBinding().tvTaskDetailTitle;
        TaskDetailBean taskDetailBean7 = this.showData;
        if (taskDetailBean7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("showData");
            taskDetailBean7 = null;
        }
        tagTextView.setContentAndTag(taskDetailBean7.getTaskName(), arrayList);
        TextView textView = getBinding().tvTaskDetailDesc;
        StringBuilder sb = new StringBuilder();
        sb.append("\u3000\u3000");
        TaskDetailBean taskDetailBean8 = this.showData;
        if (taskDetailBean8 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("showData");
            taskDetailBean8 = null;
        }
        sb.append(taskDetailBean8.getTaskDescription());
        textView.setText(sb.toString());
        StringBuilder sb2 = new StringBuilder();
        TaskDetailBean taskDetailBean9 = this.showData;
        if (taskDetailBean9 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("showData");
            taskDetailBean9 = null;
        }
        if (!taskDetailBean9.getPublishScopeObjList().isEmpty()) {
            TaskDetailBean taskDetailBean10 = this.showData;
            if (taskDetailBean10 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("showData");
                taskDetailBean10 = null;
            }
            int i = 0;
            for (Object obj : taskDetailBean10.getPublishScopeObjList()) {
                int i2 = i + 1;
                if (i < 0) {
                    CollectionsKt.throwIndexOverflow();
                }
                String str = (String) obj;
                TaskDetailBean taskDetailBean11 = this.showData;
                if (taskDetailBean11 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("showData");
                    taskDetailBean11 = null;
                }
                if (i == taskDetailBean11.getPublishScopeObjList().size() - 1) {
                    sb2.append(str);
                } else {
                    sb2.append(str);
                    sb2.append(MqttTopic.TOPIC_LEVEL_SEPARATOR);
                }
                i = i2;
            }
        }
        getBinding().tvTaskDetailRange.setText(sb2.toString());
        TextView textView2 = getBinding().tvTaskDetailStartTime;
        TaskDetailBean taskDetailBean12 = this.showData;
        if (taskDetailBean12 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("showData");
            taskDetailBean12 = null;
        }
        textView2.setText(taskDetailBean12.getPublishStart());
        TextView textView3 = getBinding().tvTaskDetailEndTime;
        TaskDetailBean taskDetailBean13 = this.showData;
        if (taskDetailBean13 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("showData");
            taskDetailBean13 = null;
        }
        textView3.setText(taskDetailBean13.getPublishEnd());
        TaskDetailBean taskDetailBean14 = this.showData;
        if (taskDetailBean14 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("showData");
            taskDetailBean14 = null;
        }
        if (Intrinsics.areEqual(taskDetailBean14.getFrequency(), "custom")) {
            TextView textView4 = getBinding().tvTaskDetailRate;
            TaskDetailBean taskDetailBean15 = this.showData;
            if (taskDetailBean15 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("showData");
                taskDetailBean15 = null;
            }
            textView4.setText(taskDetailBean15.getCustomerOption());
            if (this.isFromEnd) {
                setRvUI();
            }
        } else {
            TextView textView5 = getBinding().tvTaskDetailSignCountTitle;
            Intrinsics.checkNotNullExpressionValue(textView5, "binding.tvTaskDetailSignCountTitle");
            SimpleUtilsKt.remove(textView5);
            TextView textView6 = getBinding().tvTaskDetailSignCount;
            Intrinsics.checkNotNullExpressionValue(textView6, "binding.tvTaskDetailSignCount");
            SimpleUtilsKt.remove(textView6);
            TextView textView7 = getBinding().tvTaskDetailRate;
            TransUtils transUtils = TransUtils.INSTANCE;
            TaskDetailBean taskDetailBean16 = this.showData;
            if (taskDetailBean16 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("showData");
                taskDetailBean16 = null;
            }
            textView7.setText(transUtils.transTaskFrequencyToChinese(taskDetailBean16.getFrequency()));
            if (this.isFromEnd) {
                RecyclerView recyclerView = getBinding().rvTaskDetailUpImage;
                Intrinsics.checkNotNullExpressionValue(recyclerView, "binding.rvTaskDetailUpImage");
                SimpleUtilsKt.hide(recyclerView);
                TaskDetailBean taskDetailBean17 = this.showData;
                if (taskDetailBean17 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("showData");
                    taskDetailBean17 = null;
                }
                if (!taskDetailBean17.getSignTaskRecordList().isEmpty()) {
                    ConstraintLayout constraintLayout2 = getBinding().clTaskDetailSingle;
                    Intrinsics.checkNotNullExpressionValue(constraintLayout2, "binding.clTaskDetailSingle");
                    SimpleUtilsKt.show(constraintLayout2);
                    TaskDetailBean taskDetailBean18 = this.showData;
                    if (taskDetailBean18 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("showData");
                        taskDetailBean18 = null;
                    }
                    SignTaskRecordListItem signTaskRecordListItem = (SignTaskRecordListItem) CollectionsKt.first((List) taskDetailBean18.getSignTaskRecordList());
                    String time = DateUtils.formatTime(signTaskRecordListItem.getSignTime(), "", "yyyy-MM-dd");
                    TextView textView8 = getBinding().tvTaskDetailSingleTitle;
                    StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
                    String string = getString(R.string.single_sign_time);
                    Intrinsics.checkNotNullExpressionValue(string, "getString(R.string.single_sign_time)");
                    String str2 = String.format(string, Arrays.copyOf(new Object[]{time}, 1));
                    Intrinsics.checkNotNullExpressionValue(str2, "format(format, *args)");
                    textView8.setText(str2);
                    ImageView imageView2 = getBinding().ivTaskDetailTimeLogo;
                    Intrinsics.checkNotNullExpressionValue(imageView2, "binding.ivTaskDetailTimeLogo");
                    SimpleUtilsKt.remove(imageView2);
                    if (signTaskRecordListItem.getFileUrlList().isEmpty()) {
                        ImageView imageView3 = getBinding().ivTaskDetailSingleImage1;
                        Intrinsics.checkNotNullExpressionValue(imageView3, "binding.ivTaskDetailSingleImage1");
                        SimpleUtilsKt.remove(imageView3);
                        ImageView imageView4 = getBinding().ivTaskDetailSingleImage2;
                        Intrinsics.checkNotNullExpressionValue(imageView4, "binding.ivTaskDetailSingleImage2");
                        SimpleUtilsKt.remove(imageView4);
                        ImageView imageView5 = getBinding().ivTaskDetailSingleImage3;
                        Intrinsics.checkNotNullExpressionValue(imageView5, "binding.ivTaskDetailSingleImage3");
                        SimpleUtilsKt.remove(imageView5);
                    } else {
                        int i3 = 0;
                        for (Object obj2 : signTaskRecordListItem.getFileUrlList()) {
                            int i4 = i3 + 1;
                            if (i3 < 0) {
                                CollectionsKt.throwIndexOverflow();
                            }
                            String str3 = (String) obj2;
                            if (i3 < 3) {
                                if (i3 == 1) {
                                    ImageView imageView6 = getBinding().ivTaskDetailSingleImage2;
                                    Intrinsics.checkNotNullExpressionValue(imageView6, "binding.ivTaskDetailSingleImage2");
                                    SimpleUtilsKt.show(imageView6);
                                    imageView = getBinding().ivTaskDetailSingleImage2;
                                } else if (i3 == 2) {
                                    ImageView imageView7 = getBinding().ivTaskDetailSingleImage3;
                                    Intrinsics.checkNotNullExpressionValue(imageView7, "binding.ivTaskDetailSingleImage3");
                                    SimpleUtilsKt.show(imageView7);
                                    imageView = getBinding().ivTaskDetailSingleImage3;
                                } else {
                                    ImageView imageView8 = getBinding().ivTaskDetailSingleImage1;
                                    Intrinsics.checkNotNullExpressionValue(imageView8, "binding.ivTaskDetailSingleImage1");
                                    SimpleUtilsKt.show(imageView8);
                                    imageView = getBinding().ivTaskDetailSingleImage1;
                                }
                                Intrinsics.checkNotNullExpressionValue(imageView, "when (index) {\n         …                        }");
                                Glide.with(this).load(str3).into(imageView);
                            }
                            i3 = i4;
                        }
                    }
                } else {
                    TextView textView9 = getBinding().tvTaskDetailUpImageTitle;
                    Intrinsics.checkNotNullExpressionValue(textView9, "binding.tvTaskDetailUpImageTitle");
                    SimpleUtilsKt.remove(textView9);
                    ImageView imageView9 = getBinding().ivTaskDetailTimeLogo;
                    Intrinsics.checkNotNullExpressionValue(imageView9, "binding.ivTaskDetailTimeLogo");
                    SimpleUtilsKt.remove(imageView9);
                }
            }
        }
        StringCompanionObject stringCompanionObject2 = StringCompanionObject.INSTANCE;
        String string2 = getString(R.string.sign_count);
        Intrinsics.checkNotNullExpressionValue(string2, "getString(R.string.sign_count)");
        Object[] objArr = new Object[2];
        TaskDetailBean taskDetailBean19 = this.showData;
        if (taskDetailBean19 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("showData");
            taskDetailBean19 = null;
        }
        objArr[0] = Integer.valueOf(taskDetailBean19.getAlreadySignCount());
        TaskDetailBean taskDetailBean20 = this.showData;
        if (taskDetailBean20 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("showData");
            taskDetailBean20 = null;
        }
        objArr[1] = Integer.valueOf(taskDetailBean20.getTotalSignCount());
        String str4 = String.format(string2, Arrays.copyOf(objArr, 2));
        Intrinsics.checkNotNullExpressionValue(str4, "format(format, *args)");
        String str5 = str4;
        SpannableString spannableString = new SpannableString(str5);
        ForegroundColorSpan foregroundColorSpan = new ForegroundColorSpan(SimpleUtilsKt.asColor(R.color.purple2));
        TaskDetailBean taskDetailBean21 = this.showData;
        if (taskDetailBean21 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("showData");
            taskDetailBean21 = null;
        }
        spannableString.setSpan(foregroundColorSpan, StringsKt.indexOf$default((CharSequence) str5, String.valueOf(taskDetailBean21.getAlreadySignCount()), 0, false, 6, (Object) null), StringsKt.lastIndexOf$default((CharSequence) str5, MqttTopic.TOPIC_LEVEL_SEPARATOR, 0, false, 6, (Object) null), 33);
        getBinding().tvTaskDetailSignCount.setText(spannableString);
        TaskDetailBean taskDetailBean22 = this.showData;
        if (taskDetailBean22 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("showData");
        } else {
            taskDetailBean2 = taskDetailBean22;
        }
        if (!taskDetailBean2.getRequirementList().isEmpty()) {
            getBinding().tvTaskDetailRequire.setText("提交时必须包含图片");
            return;
        }
        TextView textView10 = getBinding().tvTaskDetailRequire;
        Intrinsics.checkNotNullExpressionValue(textView10, "binding.tvTaskDetailRequire");
        SimpleUtilsKt.remove(textView10);
        TextView textView11 = getBinding().tvTaskDetailRequireTitle;
        Intrinsics.checkNotNullExpressionValue(textView11, "binding.tvTaskDetailRequireTitle");
        SimpleUtilsKt.remove(textView11);
    }

    private final void setRvUI() {
        getBinding().rvTaskDetailUpImage.setLayoutManager(new LinearLayoutManager(requireContext()));
        getBinding().rvTaskDetailUpImage.setAdapter(getImageAdapter());
        TaskDetailBean taskDetailBean = this.showData;
        TaskDetailBean taskDetailBean2 = null;
        if (taskDetailBean == null) {
            Intrinsics.throwUninitializedPropertyAccessException("showData");
            taskDetailBean = null;
        }
        if (taskDetailBean.getSignTaskRecordList().isEmpty()) {
            TextView textView = getBinding().tvTaskDetailUpImageTitle;
            Intrinsics.checkNotNullExpressionValue(textView, "binding.tvTaskDetailUpImageTitle");
            SimpleUtilsKt.remove(textView);
            ImageView imageView = getBinding().ivTaskDetailTimeLogo;
            Intrinsics.checkNotNullExpressionValue(imageView, "binding.ivTaskDetailTimeLogo");
            SimpleUtilsKt.remove(imageView);
        } else {
            List<SignTaskRecordListItem> list = this.showImageList;
            TaskDetailBean taskDetailBean3 = this.showData;
            if (taskDetailBean3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("showData");
            } else {
                taskDetailBean2 = taskDetailBean3;
            }
            list.add((SignTaskRecordListItem) CollectionsKt.first((List) taskDetailBean2.getSignTaskRecordList()));
        }
        getImageAdapter().setList(this.showImageList);
    }

    private final void initListener() {
        getBinding().topActivityTaskDetail.backLayout.setOnClickListener(new View.OnClickListener() { // from class: com.yd.android_brand_mvp.landscape.task.-$$Lambda$TaskDetailFragment$EbTaKlRHQHBorcY5MtjilvB-sYI
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                TaskDetailFragment.initListener$lambda$5(this.f$0, view);
            }
        });
        getBinding().ivTaskDetailRangeLogo.setOnClickListener(new View.OnClickListener() { // from class: com.yd.android_brand_mvp.landscape.task.-$$Lambda$TaskDetailFragment$F1WIKVXe0UGcCL7K2cIk3lPcwBo
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                TaskDetailFragment.initListener$lambda$6(this.f$0, view);
            }
        });
        getBinding().ivTaskDetailTimeLogo.setOnClickListener(new View.OnClickListener() { // from class: com.yd.android_brand_mvp.landscape.task.-$$Lambda$TaskDetailFragment$vbkGJ8TvcGt_YVQ6O10E7ip7AWI
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                TaskDetailFragment.initListener$lambda$7(this.f$0, view);
            }
        });
        getBinding().btnActivitySignTaskSign.setOnClickListener(new View.OnClickListener() { // from class: com.yd.android_brand_mvp.landscape.task.-$$Lambda$TaskDetailFragment$35Ft5XUhzM7YKcPDPUCwH02J1CY
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                TaskDetailFragment.initListener$lambda$8(this.f$0, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initListener$lambda$5(TaskDetailFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.getParentFragmentManager().popBackStack();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initListener$lambda$6(TaskDetailFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (this$0.getBinding().tvTaskDetailRange.getMaxLines() != 2) {
            this$0.getBinding().ivTaskDetailRangeLogo.setImageResource(R.drawable.purple_icon_down);
            this$0.getBinding().tvTaskDetailRange.setMaxLines(2);
        } else {
            this$0.getBinding().ivTaskDetailRangeLogo.setImageResource(R.drawable.purple_icon_up);
            this$0.getBinding().tvTaskDetailRange.setMaxLines(100);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initListener$lambda$7(TaskDetailFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        TaskDetailBean taskDetailBean = this$0.showData;
        TaskDetailBean taskDetailBean2 = null;
        if (taskDetailBean == null) {
            Intrinsics.throwUninitializedPropertyAccessException("showData");
            taskDetailBean = null;
        }
        if (taskDetailBean.getSignTaskRecordList().isEmpty()) {
            return;
        }
        if (this$0.imageListShowMode == 0) {
            this$0.imageListShowMode = 1;
            this$0.getBinding().ivTaskDetailTimeLogo.setImageResource(R.drawable.purple_icon_down);
            this$0.showImageList.clear();
            List<SignTaskRecordListItem> list = this$0.showImageList;
            TaskDetailBean taskDetailBean3 = this$0.showData;
            if (taskDetailBean3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("showData");
            } else {
                taskDetailBean2 = taskDetailBean3;
            }
            list.add((SignTaskRecordListItem) CollectionsKt.first((List) taskDetailBean2.getSignTaskRecordList()));
        } else {
            this$0.imageListShowMode = 0;
            this$0.getBinding().ivTaskDetailTimeLogo.setImageResource(R.drawable.purple_icon_up);
            this$0.showImageList.clear();
            List<SignTaskRecordListItem> list2 = this$0.showImageList;
            TaskDetailBean taskDetailBean4 = this$0.showData;
            if (taskDetailBean4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("showData");
            } else {
                taskDetailBean2 = taskDetailBean4;
            }
            list2.addAll(taskDetailBean2.getSignTaskRecordList());
        }
        this$0.getImageAdapter().setList(this$0.showImageList);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initListener$lambda$8(TaskDetailFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.showProgressDialog();
        TaskDetailViewModel taskDetailViewModel = this$0.viewModel;
        if (taskDetailViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            taskDetailViewModel = null;
        }
        String str = this$0.id;
        String str2 = this$0.getStudentInfo().id;
        Intrinsics.checkNotNullExpressionValue(str2, "studentInfo.id");
        String str3 = this$0.getStudentInfo().schoolId;
        Intrinsics.checkNotNullExpressionValue(str3, "studentInfo.schoolId");
        taskDetailViewModel.signTask(str, str2, str3);
    }
}
