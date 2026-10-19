package com.yd.android_brand_mvp.landscape.duty;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.blankj.utilcode.util.SizeUtils;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.yd.android_brand_mvp.R;
import com.yd.android_brand_mvp.base.KTBaseFragment;
import com.yd.android_brand_mvp.base.MinaConstants;
import com.yd.android_brand_mvp.databinding.FragmentDutyFragment2x3Binding;
import com.yd.android_brand_mvp.databinding.ItemCircleTextBinding;
import com.yd.android_brand_mvp.databinding.ItemDutyChildNameBinding;
import com.yd.android_brand_mvp.databinding.ItemDutyText2x2Binding;
import com.yd.android_brand_mvp.model.duty.DutyInfo;
import com.yd.android_brand_mvp.model.duty.DutyModel;
import com.yd.android_brand_mvp.model.duty.DutyStudent;
import com.yd.android_brand_mvp.utils.TimeUtil;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: DutyFragment2x3.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0002\u0005\b\u0018\u0000 \u00162\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0016B\u0005¢\u0006\u0002\u0010\u0003J\u0010\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J\b\u0010\u0010\u001a\u00020\rH\u0002J\b\u0010\u0011\u001a\u00020\rH\u0002J\b\u0010\u0012\u001a\u00020\rH\u0016J\u0012\u0010\u0013\u001a\u00020\r2\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0016R\u0010\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0006R\u0010\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\tR\u000e\u0010\n\u001a\u00020\u000bX\u0082.¢\u0006\u0002\n\u0000¨\u0006\u0017"}, d2 = {"Lcom/yd/android_brand_mvp/landscape/duty/DutyFragment2x3;", "Lcom/yd/android_brand_mvp/base/KTBaseFragment;", "Lcom/yd/android_brand_mvp/databinding/FragmentDutyFragment2x3Binding;", "()V", "adapter", "com/yd/android_brand_mvp/landscape/duty/DutyFragment2x3$adapter$1", "Lcom/yd/android_brand_mvp/landscape/duty/DutyFragment2x3$adapter$1;", "itemAdapter", "com/yd/android_brand_mvp/landscape/duty/DutyFragment2x3$itemAdapter$1", "Lcom/yd/android_brand_mvp/landscape/duty/DutyFragment2x3$itemAdapter$1;", "viewModel", "Lcom/yd/android_brand_mvp/landscape/duty/DutyFragmentViewModel;", "UpdataEvent", "", "id", "", "initView", "initViewModel", "networkReconnection", "onActivityCreated", "savedInstanceState", "Landroid/os/Bundle;", "Companion", "app_commonRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class DutyFragment2x3 extends KTBaseFragment<FragmentDutyFragment2x3Binding> {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final String LAYOUT_TAG = "layoutTag";
    private final DutyFragment2x3$adapter$1 adapter;
    private final DutyFragment2x3$itemAdapter$1 itemAdapter;
    private DutyFragmentViewModel viewModel;

    /* JADX INFO: renamed from: com.yd.android_brand_mvp.landscape.duty.DutyFragment2x3$1, reason: invalid class name */
    /* JADX INFO: compiled from: DutyFragment2x3.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements Function3<LayoutInflater, ViewGroup, Boolean, FragmentDutyFragment2x3Binding> {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        AnonymousClass1() {
            super(3, FragmentDutyFragment2x3Binding.class, "inflate", "inflate(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Z)Lcom/yd/android_brand_mvp/databinding/FragmentDutyFragment2x3Binding;", 0);
        }

        public final FragmentDutyFragment2x3Binding invoke(LayoutInflater p0, ViewGroup viewGroup, boolean z) {
            Intrinsics.checkNotNullParameter(p0, "p0");
            return FragmentDutyFragment2x3Binding.inflate(p0, viewGroup, z);
        }

        @Override // kotlin.jvm.functions.Function3
        public /* bridge */ /* synthetic */ FragmentDutyFragment2x3Binding invoke(LayoutInflater layoutInflater, ViewGroup viewGroup, Boolean bool) {
            return invoke(layoutInflater, viewGroup, bool.booleanValue());
        }
    }

    /* JADX WARN: Type inference failed for: r0v2, types: [com.yd.android_brand_mvp.landscape.duty.DutyFragment2x3$itemAdapter$1] */
    /* JADX WARN: Type inference failed for: r0v3, types: [com.yd.android_brand_mvp.landscape.duty.DutyFragment2x3$adapter$1] */
    public DutyFragment2x3() {
        super(AnonymousClass1.INSTANCE);
        this.itemAdapter = new BaseQuickAdapter<DutyInfo, BaseViewHolder>() { // from class: com.yd.android_brand_mvp.landscape.duty.DutyFragment2x3$itemAdapter$1
            {
                super(R.layout.item_duty_text_2x2, null, 2, null);
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.chad.library.adapter.base.BaseQuickAdapter
            public void convert(BaseViewHolder holder, DutyInfo item) {
                Intrinsics.checkNotNullParameter(holder, "holder");
                Intrinsics.checkNotNullParameter(item, "item");
                ItemDutyText2x2Binding itemDutyText2x2BindingBind = ItemDutyText2x2Binding.bind(holder.itemView);
                Intrinsics.checkNotNullExpressionValue(itemDutyText2x2BindingBind, "bind(holder.itemView)");
                String targetTime = TimeUtil.getTargetTime(item.getBeginTime(), "HH:mm:ss", "HH:mm");
                String targetTime2 = TimeUtil.getTargetTime(item.getEndTime(), "HH:mm:ss", "HH:mm");
                itemDutyText2x2BindingBind.tvTime.setText(targetTime + '-' + targetTime2);
                itemDutyText2x2BindingBind.recyclerView.setLayoutManager(new LinearLayoutManager(this.this$0.requireContext(), 0, false));
                RecyclerView recyclerView = itemDutyText2x2BindingBind.recyclerView;
                final List<DutyStudent> students = item.getStudents();
                recyclerView.setAdapter(new BaseQuickAdapter<DutyStudent, BaseViewHolder>(students) { // from class: com.yd.android_brand_mvp.landscape.duty.DutyFragment2x3$itemAdapter$1$convert$1
                    /* JADX INFO: Access modifiers changed from: protected */
                    @Override // com.chad.library.adapter.base.BaseQuickAdapter
                    public void convert(BaseViewHolder holder2, DutyStudent item2) {
                        Intrinsics.checkNotNullParameter(holder2, "holder");
                        Intrinsics.checkNotNullParameter(item2, "item");
                        ItemDutyChildNameBinding itemDutyChildNameBindingBind = ItemDutyChildNameBinding.bind(holder2.itemView);
                        Intrinsics.checkNotNullExpressionValue(itemDutyChildNameBindingBind, "bind(holder.itemView)");
                        itemDutyChildNameBindingBind.tvName.setText(item2.getStudentName());
                    }
                });
            }
        };
        this.adapter = new BaseQuickAdapter<DutyStudent, BaseViewHolder>() { // from class: com.yd.android_brand_mvp.landscape.duty.DutyFragment2x3$adapter$1
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.chad.library.adapter.base.BaseQuickAdapter
            public void convert(BaseViewHolder holder, DutyStudent item) {
                Intrinsics.checkNotNullParameter(holder, "holder");
                Intrinsics.checkNotNullParameter(item, "item");
                ItemCircleTextBinding itemCircleTextBindingBind = ItemCircleTextBinding.bind(holder.itemView);
                Intrinsics.checkNotNullExpressionValue(itemCircleTextBindingBind, "bind(holder.itemView)");
                itemCircleTextBindingBind.tvName.setText(item.getStudentName());
                itemCircleTextBindingBind.tvCircleName.setText4CircleImage(item.getStudentName());
            }
        };
    }

    public static final /* synthetic */ FragmentDutyFragment2x3Binding access$getBinding(DutyFragment2x3 dutyFragment2x3) {
        return dutyFragment2x3.getBinding();
    }

    /* JADX INFO: compiled from: DutyFragment2x3.kt */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0004R\u0014\u0010\u0003\u001a\u00020\u0004X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\n"}, d2 = {"Lcom/yd/android_brand_mvp/landscape/duty/DutyFragment2x3$Companion;", "", "()V", "LAYOUT_TAG", "", "getLAYOUT_TAG", "()Ljava/lang/String;", "newInstance", "Lcom/yd/android_brand_mvp/landscape/duty/DutyFragment2x3;", "layoutTag", "app_commonRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final String getLAYOUT_TAG() {
            return DutyFragment2x3.LAYOUT_TAG;
        }

        public final DutyFragment2x3 newInstance(String layoutTag) {
            Intrinsics.checkNotNullParameter(layoutTag, "layoutTag");
            DutyFragment2x3 dutyFragment2x3 = new DutyFragment2x3();
            Bundle bundle = new Bundle();
            bundle.putString(DutyFragment2x3.INSTANCE.getLAYOUT_TAG(), layoutTag);
            dutyFragment2x3.setArguments(bundle);
            return dutyFragment2x3;
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        this.viewModel = (DutyFragmentViewModel) new ViewModelProvider(this).get(DutyFragmentViewModel.class);
        initView();
        initViewModel();
    }

    @Override // com.yd.android_brand_mvp.base.BaseFragment
    public void networkReconnection() {
        super.networkReconnection();
        DutyFragmentViewModel dutyFragmentViewModel = this.viewModel;
        if (dutyFragmentViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            dutyFragmentViewModel = null;
        }
        dutyFragmentViewModel.getDutyWeekList();
    }

    @Override // com.yd.android_brand_mvp.base.BaseFragment, com.yd.android_brand_mvp.observer.MinaListener
    public void UpdataEvent(int id) {
        super.UpdataEvent(id);
        if (id == MinaConstants.Duty) {
            DutyFragmentViewModel dutyFragmentViewModel = this.viewModel;
            if (dutyFragmentViewModel == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewModel");
                dutyFragmentViewModel = null;
            }
            dutyFragmentViewModel.getDutyWeekList();
        }
    }

    private final void initView() {
        Bundle arguments = getArguments();
        Object obj = arguments != null ? arguments.get(LAYOUT_TAG) : null;
        if (Intrinsics.areEqual(obj, "hbzrs24")) {
            getBinding().clContent.getLayoutParams().width = SizeUtils.px2dp(444.0f);
            getBinding().clContent.getLayoutParams().height = SizeUtils.px2dp(604.0f);
        } else if (Intrinsics.areEqual(obj, "sbzrs42")) {
            getBinding().clContent.getLayoutParams().width = SizeUtils.px2dp(660.0f);
            getBinding().clContent.getLayoutParams().height = SizeUtils.px2dp(424.0f);
        }
        getBinding().recyclerView.setLayoutManager(new LinearLayoutManager(requireContext()));
        getBinding().recyclerView.setAdapter(this.itemAdapter);
        setEmptyView(R.layout.item_min_null_layout_2_2);
    }

    private final void initViewModel() {
        DutyFragmentViewModel dutyFragmentViewModel = this.viewModel;
        DutyFragmentViewModel dutyFragmentViewModel2 = null;
        if (dutyFragmentViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            dutyFragmentViewModel = null;
        }
        LiveData<List<DutyModel>> dutyListLiveData = dutyFragmentViewModel.getDutyListLiveData();
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        final Function1<List<DutyModel>, Unit> function1 = new Function1<List<DutyModel>, Unit>() { // from class: com.yd.android_brand_mvp.landscape.duty.DutyFragment2x3.initViewModel.1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(List<DutyModel> list) {
                invoke2(list);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(List<DutyModel> list) {
                if (list == null || list.size() <= 0) {
                    return;
                }
                if (list.get(0).getDutyType() == 1) {
                    DutyFragment2x3.access$getBinding(DutyFragment2x3.this).clTime.setVisibility(0);
                    DutyFragment2x3.access$getBinding(DutyFragment2x3.this).clAllDay.setVisibility(8);
                    setList(list.get(0).getInfoList());
                    return;
                }
                Bundle arguments = DutyFragment2x3.this.getArguments();
                Object obj = arguments != null ? arguments.get(DutyFragment2x3.INSTANCE.getLAYOUT_TAG()) : null;
                int i = 3;
                if (Intrinsics.areEqual(obj, "hbzrs24")) {
                    DutyFragment2x3.access$getBinding(DutyFragment2x3.this).clTime.setBackground(DutyFragment2x3.this.getResources().getDrawable(R.drawable.icon_duty_hb_bg_24));
                } else if (Intrinsics.areEqual(obj, "sbzrs42")) {
                    i = 5;
                    DutyFragment2x3.access$getBinding(DutyFragment2x3.this).clTime.setBackground(DutyFragment2x3.this.getResources().getDrawable(R.drawable.icon_duty_sb_bg_42));
                } else if (Intrinsics.areEqual(obj, "hbzrs23")) {
                    DutyFragment2x3.access$getBinding(DutyFragment2x3.this).clTime.setBackground(DutyFragment2x3.this.getResources().getDrawable(R.drawable.icon_duty_hb_bg_24));
                }
                DutyFragment2x3.access$getBinding(DutyFragment2x3.this).clTime.setVisibility(8);
                DutyFragment2x3.access$getBinding(DutyFragment2x3.this).clAllDay.setVisibility(0);
                DutyFragment2x3.access$getBinding(DutyFragment2x3.this).tvWeek.setText(TimeUtil.getWeekStr(System.currentTimeMillis()));
                DutyFragment2x3.access$getBinding(DutyFragment2x3.this).recyclerView.setLayoutManager(new GridLayoutManager(DutyFragment2x3.this.requireContext(), i));
                DutyFragment2x3.access$getBinding(DutyFragment2x3.this).recyclerView.setAdapter(DutyFragment2x3.this.adapter);
                DutyFragment2x3.access$getBinding(DutyFragment2x3.this).recyclerView.setBackgroundResource(R.drawable.duty_bg_border_check_1dp);
                setEmptyView(R.layout.item_min_null_layout_2_2);
                setList(list.get(0).getStudents());
            }
        };
        dutyListLiveData.observe(viewLifecycleOwner, new Observer() { // from class: com.yd.android_brand_mvp.landscape.duty.-$$Lambda$DutyFragment2x3$BzNy2cCPY0iXcLT2RJe6JUL_4yQ
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                DutyFragment2x3.initViewModel$lambda$0(function1, obj);
            }
        });
        DutyFragmentViewModel dutyFragmentViewModel3 = this.viewModel;
        if (dutyFragmentViewModel3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        } else {
            dutyFragmentViewModel2 = dutyFragmentViewModel3;
        }
        dutyFragmentViewModel2.getDutyWeekList();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initViewModel$lambda$0(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }
}
