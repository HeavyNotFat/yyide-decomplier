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
import androidx.work.WorkRequest;
import com.blankj.utilcode.util.SizeUtils;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.yd.android_brand_mvp.R;
import com.yd.android_brand_mvp.base.KTBaseFragment;
import com.yd.android_brand_mvp.base.MinaConstants;
import com.yd.android_brand_mvp.databinding.FragmentDutyFragment2x2Binding;
import com.yd.android_brand_mvp.databinding.ItemCircleTextBinding;
import com.yd.android_brand_mvp.databinding.ItemDutyChildNameBinding;
import com.yd.android_brand_mvp.databinding.ItemDutyText2x2Binding;
import com.yd.android_brand_mvp.databinding.ItemListBinding;
import com.yd.android_brand_mvp.model.duty.DutyInfo;
import com.yd.android_brand_mvp.model.duty.DutyModel;
import com.yd.android_brand_mvp.model.duty.DutyStudent;
import com.yd.android_brand_mvp.utils.SimpleUtilsKt;
import com.yd.android_brand_mvp.utils.TimeUtil;
import com.youth.banner.Banner;
import com.youth.banner.adapter.BannerAdapter;
import com.youth.banner.indicator.CircleIndicator;
import com.youth.banner.util.BannerUtils;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: DutyFragment2x2.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0002\u0005\n\u0018\u0000 \u00192\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0002\u0018\u0019B\u0005¢\u0006\u0002\u0010\u0003J\u0010\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\bH\u0016J\b\u0010\u0012\u001a\u00020\u0010H\u0002J\b\u0010\u0013\u001a\u00020\u0010H\u0002J\b\u0010\u0014\u001a\u00020\u0010H\u0016J\u0012\u0010\u0015\u001a\u00020\u00102\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0016R\u0010\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0006R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u000bR\u000e\u0010\f\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082.¢\u0006\u0002\n\u0000¨\u0006\u001a"}, d2 = {"Lcom/yd/android_brand_mvp/landscape/duty/DutyFragment2x2;", "Lcom/yd/android_brand_mvp/base/KTBaseFragment;", "Lcom/yd/android_brand_mvp/databinding/FragmentDutyFragment2x2Binding;", "()V", "bannerAdapter", "com/yd/android_brand_mvp/landscape/duty/DutyFragment2x2$bannerAdapter$1", "Lcom/yd/android_brand_mvp/landscape/duty/DutyFragment2x2$bannerAdapter$1;", "gridCount", "", "itemAdapter", "com/yd/android_brand_mvp/landscape/duty/DutyFragment2x2$itemAdapter$1", "Lcom/yd/android_brand_mvp/landscape/duty/DutyFragment2x2$itemAdapter$1;", "splitCount", "viewModel", "Lcom/yd/android_brand_mvp/landscape/duty/DutyFragmentViewModel;", "UpdataEvent", "", "id", "initView", "initViewModel", "networkReconnection", "onActivityCreated", "savedInstanceState", "Landroid/os/Bundle;", "BannerViewHolder", "Companion", "app_commonRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class DutyFragment2x2 extends KTBaseFragment<FragmentDutyFragment2x2Binding> {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final String LAYOUT_TAG = "layoutTag";
    private final DutyFragment2x2$bannerAdapter$1 bannerAdapter;
    private int gridCount;
    private final DutyFragment2x2$itemAdapter$1 itemAdapter;
    private int splitCount;
    private DutyFragmentViewModel viewModel;

    /* JADX INFO: renamed from: com.yd.android_brand_mvp.landscape.duty.DutyFragment2x2$1, reason: invalid class name */
    /* JADX INFO: compiled from: DutyFragment2x2.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements Function3<LayoutInflater, ViewGroup, Boolean, FragmentDutyFragment2x2Binding> {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        AnonymousClass1() {
            super(3, FragmentDutyFragment2x2Binding.class, "inflate", "inflate(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Z)Lcom/yd/android_brand_mvp/databinding/FragmentDutyFragment2x2Binding;", 0);
        }

        public final FragmentDutyFragment2x2Binding invoke(LayoutInflater p0, ViewGroup viewGroup, boolean z) {
            Intrinsics.checkNotNullParameter(p0, "p0");
            return FragmentDutyFragment2x2Binding.inflate(p0, viewGroup, z);
        }

        @Override // kotlin.jvm.functions.Function3
        public /* bridge */ /* synthetic */ FragmentDutyFragment2x2Binding invoke(LayoutInflater layoutInflater, ViewGroup viewGroup, Boolean bool) {
            return invoke(layoutInflater, viewGroup, bool.booleanValue());
        }
    }

    /* JADX WARN: Type inference failed for: r0v3, types: [com.yd.android_brand_mvp.landscape.duty.DutyFragment2x2$itemAdapter$1] */
    /* JADX WARN: Type inference failed for: r0v4, types: [com.yd.android_brand_mvp.landscape.duty.DutyFragment2x2$bannerAdapter$1] */
    public DutyFragment2x2() {
        super(AnonymousClass1.INSTANCE);
        this.gridCount = 4;
        this.splitCount = 4;
        this.itemAdapter = new BaseQuickAdapter<DutyInfo, BaseViewHolder>() { // from class: com.yd.android_brand_mvp.landscape.duty.DutyFragment2x2$itemAdapter$1
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
                final List<DutyStudent> students = item.getStudents();
                itemDutyText2x2BindingBind.recyclerView.setAdapter(new BaseQuickAdapter<DutyStudent, BaseViewHolder>(students) { // from class: com.yd.android_brand_mvp.landscape.duty.DutyFragment2x2$itemAdapter$1$convert$1
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
        this.bannerAdapter = new BannerAdapter<List<DutyStudent>, BannerViewHolder>() { // from class: com.yd.android_brand_mvp.landscape.duty.DutyFragment2x2$bannerAdapter$1
            {
                super(null);
            }

            @Override // com.youth.banner.holder.IViewHolder
            public DutyFragment2x2.BannerViewHolder onCreateHolder(ViewGroup parent, int viewType) {
                ItemListBinding itemListBindingInflate = ItemListBinding.inflate(LayoutInflater.from(parent != null ? parent.getContext() : null), parent, false);
                Intrinsics.checkNotNullExpressionValue(itemListBindingInflate, "inflate(LayoutInflater.f….context), parent, false)");
                return new DutyFragment2x2.BannerViewHolder(this.this$0, itemListBindingInflate);
            }

            @Override // com.youth.banner.holder.IViewHolder
            public void onBindView(DutyFragment2x2.BannerViewHolder holder, final List<DutyStudent> data, int position, int size) {
                ItemListBinding binding;
                ItemListBinding binding2;
                RecyclerView recyclerView = null;
                RecyclerView recyclerView2 = (holder == null || (binding2 = holder.getBinding()) == null) ? null : binding2.recyclerView;
                if (recyclerView2 != null) {
                    recyclerView2.setLayoutManager(new GridLayoutManager(this.this$0.getContext(), this.this$0.gridCount));
                }
                if (holder != null && (binding = holder.getBinding()) != null) {
                    recyclerView = binding.recyclerView;
                }
                if (recyclerView == null) {
                    return;
                }
                recyclerView.setAdapter(new BaseQuickAdapter<DutyStudent, BaseViewHolder>(data) { // from class: com.yd.android_brand_mvp.landscape.duty.DutyFragment2x2$bannerAdapter$1$onBindView$1
                    /* JADX INFO: Access modifiers changed from: protected */
                    @Override // com.chad.library.adapter.base.BaseQuickAdapter
                    public void convert(BaseViewHolder holder2, DutyStudent item) {
                        Intrinsics.checkNotNullParameter(holder2, "holder");
                        Intrinsics.checkNotNullParameter(item, "item");
                        ItemCircleTextBinding itemCircleTextBindingBind = ItemCircleTextBinding.bind(holder2.itemView);
                        Intrinsics.checkNotNullExpressionValue(itemCircleTextBindingBind, "bind(holder.itemView)");
                        itemCircleTextBindingBind.tvName.setText(item.getStudentName());
                        itemCircleTextBindingBind.tvCircleName.setText4CircleImage(item.getStudentName());
                    }
                });
            }
        };
    }

    public static final /* synthetic */ FragmentDutyFragment2x2Binding access$getBinding(DutyFragment2x2 dutyFragment2x2) {
        return dutyFragment2x2.getBinding();
    }

    /* JADX INFO: compiled from: DutyFragment2x2.kt */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0004R\u0014\u0010\u0003\u001a\u00020\u0004X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\n"}, d2 = {"Lcom/yd/android_brand_mvp/landscape/duty/DutyFragment2x2$Companion;", "", "()V", "LAYOUT_TAG", "", "getLAYOUT_TAG", "()Ljava/lang/String;", "newInstance", "Lcom/yd/android_brand_mvp/landscape/duty/DutyFragment2x2;", "layoutTag", "app_commonRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final String getLAYOUT_TAG() {
            return DutyFragment2x2.LAYOUT_TAG;
        }

        public final DutyFragment2x2 newInstance(String layoutTag) {
            Intrinsics.checkNotNullParameter(layoutTag, "layoutTag");
            DutyFragment2x2 dutyFragment2x2 = new DutyFragment2x2();
            Bundle bundle = new Bundle();
            bundle.putString(DutyFragment2x2.INSTANCE.getLAYOUT_TAG(), layoutTag);
            dutyFragment2x2.setArguments(bundle);
            return dutyFragment2x2;
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
        Banner startPosition;
        Banner adapter;
        Banner bannerIsAutoLoop;
        Banner loopTime;
        Banner indicator;
        Banner indicatorGravity;
        Banner indicatorSpace;
        Banner indicatorNormalColor;
        Banner indicatorSelectedColor;
        Banner indicatorWidth;
        Bundle arguments = getArguments();
        if (Intrinsics.areEqual(arguments != null ? arguments.get(DutyFragment2x3.INSTANCE.getLAYOUT_TAG()) : null, "sbzrs22")) {
            this.gridCount = 3;
            this.splitCount = 9;
            getBinding().ivBack.setVisibility(8);
            getBinding().title.setVisibility(8);
            getBinding().clContent.getLayoutParams().width = SizeUtils.px2dp(320.0f);
            getBinding().clContent.getLayoutParams().height = SizeUtils.px2dp(424.0f);
        }
        getBinding().recyclerView.setLayoutManager(new LinearLayoutManager(requireContext()));
        getBinding().recyclerView.setAdapter(this.itemAdapter);
        setEmptyView(R.layout.item_min_null_layout_2_2);
        getBinding().tvWeek.setText(TimeUtil.getWeekStr(System.currentTimeMillis()));
        getBinding().mu.setViewState(2);
        Banner bannerAddBannerLifecycleObserver = getBinding().banner.addBannerLifecycleObserver(this);
        if (bannerAddBannerLifecycleObserver == null || (startPosition = bannerAddBannerLifecycleObserver.setStartPosition(1)) == null || (adapter = startPosition.setAdapter(this.bannerAdapter)) == null || (bannerIsAutoLoop = adapter.isAutoLoop(true)) == null || (loopTime = bannerIsAutoLoop.setLoopTime(WorkRequest.MIN_BACKOFF_MILLIS)) == null || (indicator = loopTime.setIndicator(new CircleIndicator(requireContext()))) == null || (indicatorGravity = indicator.setIndicatorGravity(1)) == null || (indicatorSpace = indicatorGravity.setIndicatorSpace(BannerUtils.dp2px(8.0f))) == null || (indicatorNormalColor = indicatorSpace.setIndicatorNormalColor(SimpleUtilsKt.asColor(R.color.gray))) == null || (indicatorSelectedColor = indicatorNormalColor.setIndicatorSelectedColor(SimpleUtilsKt.asColor(R.color.blue12))) == null || (indicatorWidth = indicatorSelectedColor.setIndicatorWidth(BannerUtils.dp2px(8.0f), BannerUtils.dp2px(8.0f))) == null) {
            return;
        }
        indicatorWidth.setIndicatorHeight(BannerUtils.dp2px(8.0f));
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
        final Function1<List<DutyModel>, Unit> function1 = new Function1<List<DutyModel>, Unit>() { // from class: com.yd.android_brand_mvp.landscape.duty.DutyFragment2x2.initViewModel.1
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
                    DutyFragment2x2.access$getBinding(DutyFragment2x2.this).clTime.setVisibility(0);
                    DutyFragment2x2.access$getBinding(DutyFragment2x2.this).clAllDay.setVisibility(8);
                    setList(list.get(0).getInfoList());
                    return;
                }
                DutyFragment2x2.access$getBinding(DutyFragment2x2.this).clTime.setVisibility(8);
                DutyFragment2x2.access$getBinding(DutyFragment2x2.this).clAllDay.setVisibility(0);
                List<DutyStudent> students = list.get(0).getStudents();
                if (students.size() > 0) {
                    Bundle arguments = DutyFragment2x2.this.getArguments();
                    if (arguments != null) {
                        arguments.get(DutyFragment2x3.INSTANCE.getLAYOUT_TAG());
                    }
                    DutyFragmentViewModel dutyFragmentViewModel3 = DutyFragment2x2.this.viewModel;
                    if (dutyFragmentViewModel3 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
                        dutyFragmentViewModel3 = null;
                    }
                    List<List<DutyStudent>> listSplitList = dutyFragmentViewModel3.splitList(students, DutyFragment2x2.this.splitCount);
                    DutyFragment2x2.access$getBinding(DutyFragment2x2.this).mu.setViewState(0);
                    DutyFragment2x2.access$getBinding(DutyFragment2x2.this).banner.setDatas(listSplitList);
                    return;
                }
                DutyFragment2x2.access$getBinding(DutyFragment2x2.this).mu.setViewState(2);
            }
        };
        dutyListLiveData.observe(viewLifecycleOwner, new Observer() { // from class: com.yd.android_brand_mvp.landscape.duty.-$$Lambda$DutyFragment2x2$SOzALGif_vP7kRVpt5ehqBGImZI
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                DutyFragment2x2.initViewModel$lambda$0(function1, obj);
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

    /* JADX INFO: compiled from: DutyFragment2x2.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/yd/android_brand_mvp/landscape/duty/DutyFragment2x2$BannerViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "binding", "Lcom/yd/android_brand_mvp/databinding/ItemListBinding;", "(Lcom/yd/android_brand_mvp/landscape/duty/DutyFragment2x2;Lcom/yd/android_brand_mvp/databinding/ItemListBinding;)V", "getBinding", "()Lcom/yd/android_brand_mvp/databinding/ItemListBinding;", "app_commonRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public final class BannerViewHolder extends RecyclerView.ViewHolder {
        private final ItemListBinding binding;
        final /* synthetic */ DutyFragment2x2 this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public BannerViewHolder(DutyFragment2x2 dutyFragment2x2, ItemListBinding binding) {
            super(binding.getRoot());
            Intrinsics.checkNotNullParameter(binding, "binding");
            this.this$0 = dutyFragment2x2;
            this.binding = binding;
        }

        public final ItemListBinding getBinding() {
            return this.binding;
        }
    }
}
