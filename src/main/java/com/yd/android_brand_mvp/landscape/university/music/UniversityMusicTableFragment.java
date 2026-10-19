package com.yd.android_brand_mvp.landscape.university.music;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.HasDefaultViewModelProviderFactory;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.lifecycle.viewmodel.CreationExtras;
import com.blankj.utilcode.util.SizeUtils;
import com.contrarywind.adapter.WheelAdapter;
import com.contrarywind.listener.OnItemSelectedListener;
import com.contrarywind.view.WheelView;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.yd.android_brand_mvp.R;
import com.yd.android_brand_mvp.activity.KBActivity;
import com.yd.android_brand_mvp.activity.SiteKBActivity;
import com.yd.android_brand_mvp.base.KTBaseFragment;
import com.yd.android_brand_mvp.base.MinaConstants;
import com.yd.android_brand_mvp.databinding.FragmentUniversityMusicTableBinding;
import com.yd.android_brand_mvp.landscape.university.viewmodel.UniversityMusicTableViewModel;
import com.yd.android_brand_mvp.model.KBRsp2;
import com.yd.android_brand_mvp.model.TableDataBean;
import com.yd.android_brand_mvp.utils.TimeUtil;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: compiled from: UniversityMusicTableFragment.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u001f2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0002\u001f B\u0005¢\u0006\u0002\u0010\u0003J\u0010\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0005H\u0016J\b\u0010\u0015\u001a\u00020\u0013H\u0002J\b\u0010\u0016\u001a\u00020\u0013H\u0002J\u001a\u0010\u0017\u001a\u00020\u00132\u0006\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bH\u0016J\u0010\u0010\u001c\u001a\u00020\u00132\u0006\u0010\u001d\u001a\u00020\nH\u0002J\b\u0010\u001e\u001a\u00020\u0013H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\f\u001a\u00020\r8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u000e\u0010\u000f¨\u0006!"}, d2 = {"Lcom/yd/android_brand_mvp/landscape/university/music/UniversityMusicTableFragment;", "Lcom/yd/android_brand_mvp/base/KTBaseFragment;", "Lcom/yd/android_brand_mvp/databinding/FragmentUniversityMusicTableBinding;", "()V", "KBType", "", "isHaveClass", "", "tableList", "", "Lcom/yd/android_brand_mvp/model/KBRsp2$DataDTO$TimetableListDTO;", "timetable", "viewModel", "Lcom/yd/android_brand_mvp/landscape/university/viewmodel/UniversityMusicTableViewModel;", "getViewModel", "()Lcom/yd/android_brand_mvp/landscape/university/viewmodel/UniversityMusicTableViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "UpdataEvent", "", "id", "initModel", "initView", "onViewCreated", "view", "Landroid/view/View;", "savedInstanceState", "Landroid/os/Bundle;", "setData", "dto", "setTable", "Companion", "TableClassWheelAdapter", "app_commonRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class UniversityMusicTableFragment extends KTBaseFragment<FragmentUniversityMusicTableBinding> {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private int KBType;
    private boolean isHaveClass;
    private final List<KBRsp2.DataDTO.TimetableListDTO> tableList;
    private KBRsp2.DataDTO.TimetableListDTO timetable;

    /* JADX INFO: renamed from: viewModel$delegate, reason: from kotlin metadata */
    private final Lazy viewModel;

    /* JADX INFO: renamed from: com.yd.android_brand_mvp.landscape.university.music.UniversityMusicTableFragment$1, reason: invalid class name */
    /* JADX INFO: compiled from: UniversityMusicTableFragment.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements Function3<LayoutInflater, ViewGroup, Boolean, FragmentUniversityMusicTableBinding> {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        AnonymousClass1() {
            super(3, FragmentUniversityMusicTableBinding.class, "inflate", "inflate(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Z)Lcom/yd/android_brand_mvp/databinding/FragmentUniversityMusicTableBinding;", 0);
        }

        public final FragmentUniversityMusicTableBinding invoke(LayoutInflater p0, ViewGroup viewGroup, boolean z) {
            Intrinsics.checkNotNullParameter(p0, "p0");
            return FragmentUniversityMusicTableBinding.inflate(p0, viewGroup, z);
        }

        @Override // kotlin.jvm.functions.Function3
        public /* bridge */ /* synthetic */ FragmentUniversityMusicTableBinding invoke(LayoutInflater layoutInflater, ViewGroup viewGroup, Boolean bool) {
            return invoke(layoutInflater, viewGroup, bool.booleanValue());
        }
    }

    public UniversityMusicTableFragment() {
        super(AnonymousClass1.INSTANCE);
        final UniversityMusicTableFragment universityMusicTableFragment = this;
        final Function0<Fragment> function0 = new Function0<Fragment>() { // from class: com.yd.android_brand_mvp.landscape.university.music.UniversityMusicTableFragment$special$$inlined$viewModels$default$1
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Fragment invoke() {
                return universityMusicTableFragment;
            }
        };
        final Lazy lazy = LazyKt.lazy(LazyThreadSafetyMode.NONE, (Function0) new Function0<ViewModelStoreOwner>() { // from class: com.yd.android_brand_mvp.landscape.university.music.UniversityMusicTableFragment$special$$inlined$viewModels$default$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelStoreOwner invoke() {
                return (ViewModelStoreOwner) function0.invoke();
            }
        });
        final Function0 function1 = null;
        this.viewModel = FragmentViewModelLazyKt.createViewModelLazy(universityMusicTableFragment, Reflection.getOrCreateKotlinClass(UniversityMusicTableViewModel.class), new Function0<ViewModelStore>() { // from class: com.yd.android_brand_mvp.landscape.university.music.UniversityMusicTableFragment$special$$inlined$viewModels$default$3
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelStore invoke() {
                ViewModelStore viewModelStore = FragmentViewModelLazyKt.m19viewModels$lambda1(lazy).getViewModelStore();
                Intrinsics.checkNotNullExpressionValue(viewModelStore, "owner.viewModelStore");
                return viewModelStore;
            }
        }, new Function0<CreationExtras>() { // from class: com.yd.android_brand_mvp.landscape.university.music.UniversityMusicTableFragment$special$$inlined$viewModels$default$4
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final CreationExtras invoke() {
                CreationExtras creationExtras;
                Function0 function2 = function1;
                if (function2 != null && (creationExtras = (CreationExtras) function2.invoke()) != null) {
                    return creationExtras;
                }
                ViewModelStoreOwner viewModelStoreOwnerM19viewModels$lambda1 = FragmentViewModelLazyKt.m19viewModels$lambda1(lazy);
                HasDefaultViewModelProviderFactory hasDefaultViewModelProviderFactory = viewModelStoreOwnerM19viewModels$lambda1 instanceof HasDefaultViewModelProviderFactory ? (HasDefaultViewModelProviderFactory) viewModelStoreOwnerM19viewModels$lambda1 : null;
                CreationExtras defaultViewModelCreationExtras = hasDefaultViewModelProviderFactory != null ? hasDefaultViewModelProviderFactory.getDefaultViewModelCreationExtras() : null;
                return defaultViewModelCreationExtras == null ? CreationExtras.Empty.INSTANCE : defaultViewModelCreationExtras;
            }
        }, new Function0<ViewModelProvider.Factory>() { // from class: com.yd.android_brand_mvp.landscape.university.music.UniversityMusicTableFragment$special$$inlined$viewModels$default$5
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelProvider.Factory invoke() {
                ViewModelProvider.Factory defaultViewModelProviderFactory;
                ViewModelStoreOwner viewModelStoreOwnerM19viewModels$lambda1 = FragmentViewModelLazyKt.m19viewModels$lambda1(lazy);
                HasDefaultViewModelProviderFactory hasDefaultViewModelProviderFactory = viewModelStoreOwnerM19viewModels$lambda1 instanceof HasDefaultViewModelProviderFactory ? (HasDefaultViewModelProviderFactory) viewModelStoreOwnerM19viewModels$lambda1 : null;
                if (hasDefaultViewModelProviderFactory == null || (defaultViewModelProviderFactory = hasDefaultViewModelProviderFactory.getDefaultViewModelProviderFactory()) == null) {
                    defaultViewModelProviderFactory = universityMusicTableFragment.getDefaultViewModelProviderFactory();
                }
                Intrinsics.checkNotNullExpressionValue(defaultViewModelProviderFactory, "(owner as? HasDefaultVie…tViewModelProviderFactory");
                return defaultViewModelProviderFactory;
            }
        });
        this.KBType = 1;
        this.tableList = new ArrayList();
    }

    public static final /* synthetic */ FragmentUniversityMusicTableBinding access$getBinding(UniversityMusicTableFragment universityMusicTableFragment) {
        return universityMusicTableFragment.getBinding();
    }

    /* JADX INFO: compiled from: UniversityMusicTableFragment.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0003\u001a\u00020\u0004¨\u0006\u0005"}, d2 = {"Lcom/yd/android_brand_mvp/landscape/university/music/UniversityMusicTableFragment$Companion;", "", "()V", "newInstance", "Lcom/yd/android_brand_mvp/landscape/university/music/UniversityMusicTableFragment;", "app_commonRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final UniversityMusicTableFragment newInstance() {
            return new UniversityMusicTableFragment();
        }
    }

    private final UniversityMusicTableViewModel getViewModel() {
        return (UniversityMusicTableViewModel) this.viewModel.getValue();
    }

    @Override // com.yd.android_brand_mvp.base.KTBaseFragment, com.yd.android_brand_mvp.base.BaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        initView();
        initModel();
        setTable();
    }

    /* JADX INFO: renamed from: com.yd.android_brand_mvp.landscape.university.music.UniversityMusicTableFragment$initView$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: UniversityMusicTableFragment.kt */
    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016¨\u0006\u0004"}, d2 = {"com/yd/android_brand_mvp/landscape/university/music/UniversityMusicTableFragment$initView$1", "Ljava/util/TimerTask;", "run", "", "app_commonRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class C05381 extends TimerTask {
        C05381() {
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            FragmentActivity activity = UniversityMusicTableFragment.this.getActivity();
            if (activity != null) {
                final UniversityMusicTableFragment universityMusicTableFragment = UniversityMusicTableFragment.this;
                activity.runOnUiThread(new Runnable() { // from class: com.yd.android_brand_mvp.landscape.university.music.-$$Lambda$UniversityMusicTableFragment$initView$1$u9r-Qqoxaeftm70llPAgBJo7fPo
                    @Override // java.lang.Runnable
                    public final void run() {
                        UniversityMusicTableFragment.C05381.run$lambda$0(universityMusicTableFragment);
                    }
                });
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void run$lambda$0(UniversityMusicTableFragment this$0) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            this$0.setTable();
        }
    }

    private final void initView() {
        new Timer().schedule(new C05381(), new Date(), 30000L);
        getBinding().imageView3.setOnClickListener(new View.OnClickListener() { // from class: com.yd.android_brand_mvp.landscape.university.music.-$$Lambda$UniversityMusicTableFragment$PLK08wMV6GymSwwzKCLxSlmPIgg
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                UniversityMusicTableFragment.initView$lambda$0(this.f$0, view);
            }
        });
        getBinding().wheelView.setCyclic(false);
        getBinding().wheelView.setDividerColor(0);
        getBinding().wheelView.setDividerType(WheelView.DividerType.WRAP);
        getBinding().wheelView.setLineSpacingMultiplier(1.8f);
        getBinding().wheelView.setItemsVisibleCount(3);
        getBinding().wheelView.setTextSize(SizeUtils.px2sp(20.0f));
        getBinding().wheelView.setTextColorOut(Color.parseColor("#8577AB"));
        getBinding().wheelView.setTextColorCenter(-1);
        getBinding().wheelView.setOnItemSelectedListener(new OnItemSelectedListener() { // from class: com.yd.android_brand_mvp.landscape.university.music.-$$Lambda$UniversityMusicTableFragment$LwHM9c7iVNgdKgyW4DuH9kGs_ig
            @Override // com.contrarywind.listener.OnItemSelectedListener
            public final void onItemSelected(int i) {
                UniversityMusicTableFragment.initView$lambda$1(this.f$0, i);
            }
        });
        getBinding().ivLeft.setOnClickListener(new View.OnClickListener() { // from class: com.yd.android_brand_mvp.landscape.university.music.-$$Lambda$UniversityMusicTableFragment$o5FNZ_Z0a8S5VdVmheyFGN578qQ
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                UniversityMusicTableFragment.initView$lambda$2(this.f$0, view);
            }
        });
        getBinding().ivRight.setOnClickListener(new View.OnClickListener() { // from class: com.yd.android_brand_mvp.landscape.university.music.-$$Lambda$UniversityMusicTableFragment$zxFkkCDviLJqBn5kZ_NX-Xn8oTA
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                UniversityMusicTableFragment.initView$lambda$3(this.f$0, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$0(UniversityMusicTableFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (this$0.KBType == 2) {
            this$0.goPermissionsActivity(KBActivity.class);
            return;
        }
        Intent intent = new Intent(this$0.getActivity(), (Class<?>) SiteKBActivity.class);
        intent.putExtra("drak", "music");
        this$0.goPermissionsActivity(intent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$1(UniversityMusicTableFragment this$0, int i) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.setData(this$0.tableList.get(i));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$2(UniversityMusicTableFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.getBinding().wheelView.setCurrentItem(this$0.getBinding().wheelView.getCurrentItem() + (-1) == 0 ? 0 : this$0.getBinding().wheelView.getCurrentItem() - 1);
        this$0.getBinding().wheelView.onItemSelected();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$3(UniversityMusicTableFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.getBinding().wheelView.setCurrentItem(this$0.getBinding().wheelView.getCurrentItem() + 1 > this$0.tableList.size() ? 0 : this$0.getBinding().wheelView.getCurrentItem() + 1);
        this$0.getBinding().wheelView.onItemSelected();
    }

    private final void setData(KBRsp2.DataDTO.TimetableListDTO dto) {
        getBinding().tvTableName.setText(dto.subjectName);
        getBinding().tvTime.setText(getString(R.string.left_right, dto.startTime, dto.endTime));
        getBinding().tvStartTime.setText(dto.startTime);
        getBinding().tvEndTime.setText(dto.endTime);
        KBRsp2.DataDTO.TimetableListDTO timetableListDTO = this.timetable;
        if (Intrinsics.areEqual(timetableListDTO != null ? timetableListDTO.id : null, dto.id)) {
            getBinding().tvTableName.setTextColor(getResources().getColor(R.color.yellow5));
            getBinding().tvTime.setTextColor(getResources().getColor(R.color.yellow5));
        } else {
            getBinding().tvTableName.setTextColor(-1);
            getBinding().tvTime.setTextColor(-1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void setTable() {
        getViewModel().getKbData();
    }

    private final void initModel() {
        LiveData<TableDataBean> kbRspData = getViewModel().getKbRspData();
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        final Function1<TableDataBean, Unit> function1 = new Function1<TableDataBean, Unit>() { // from class: com.yd.android_brand_mvp.landscape.university.music.UniversityMusicTableFragment.initModel.1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(TableDataBean tableDataBean) {
                invoke2(tableDataBean);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(TableDataBean tableDataBean) {
                KBRsp2.DataDTO.TimetableListDTO timetableListDTO;
                KBRsp2.DataDTO dataDTO;
                KBRsp2.DataDTO dataDTO2;
                List<KBRsp2.DataDTO.TimetableListDTO> list;
                UniversityMusicTableFragment.this.tableList.clear();
                int intWeekDay = TimeUtil.getIntWeekDay(System.currentTimeMillis());
                KBRsp2 data = tableDataBean.getData();
                if (data == null || (dataDTO2 = data.data) == null || (list = dataDTO2.timetableList) == null) {
                    timetableListDTO = null;
                } else {
                    UniversityMusicTableFragment universityMusicTableFragment = UniversityMusicTableFragment.this;
                    timetableListDTO = null;
                    for (KBRsp2.DataDTO.TimetableListDTO item : list) {
                        if (item.week == intWeekDay && TimeUtil.forRemindTime(item.startTime, item.endTime)) {
                            universityMusicTableFragment.isHaveClass = true;
                            timetableListDTO = item;
                        }
                        if (item.week == intWeekDay) {
                            List list2 = universityMusicTableFragment.tableList;
                            Intrinsics.checkNotNullExpressionValue(item, "item");
                            list2.add(item);
                        }
                    }
                }
                if (timetableListDTO == null) {
                    if (((data == null || (dataDTO = data.data) == null) ? null : dataDTO.timetableList) != null) {
                        KBRsp2.DataDTO dataDTO3 = data.data;
                        List<KBRsp2.DataDTO.TimetableListDTO> list3 = dataDTO3 != null ? dataDTO3.timetableList : null;
                        Intrinsics.checkNotNull(list3);
                        for (KBRsp2.DataDTO.TimetableListDTO timetableListDTO2 : list3) {
                            if (timetableListDTO2.week == intWeekDay && TimeUtil.isTable(timetableListDTO2.startTime, timetableListDTO2.endTime)) {
                                UniversityMusicTableFragment.this.isHaveClass = false;
                                timetableListDTO = timetableListDTO2;
                                break;
                            }
                        }
                    }
                }
                String str = timetableListDTO != null ? timetableListDTO.id : null;
                KBRsp2.DataDTO.TimetableListDTO timetableListDTO3 = UniversityMusicTableFragment.this.timetable;
                if (!Intrinsics.areEqual(str, timetableListDTO3 != null ? timetableListDTO3.id : null)) {
                    ArrayList arrayList = new ArrayList();
                    int i = 0;
                    int i2 = 0;
                    for (Object obj : UniversityMusicTableFragment.this.tableList) {
                        int i3 = i2 + 1;
                        if (i2 < 0) {
                            CollectionsKt.throwIndexOverflow();
                        }
                        KBRsp2.DataDTO.TimetableListDTO timetableListDTO4 = (KBRsp2.DataDTO.TimetableListDTO) obj;
                        if (Intrinsics.areEqual(timetableListDTO != null ? timetableListDTO.id : null, timetableListDTO4.id)) {
                            i = i2;
                        }
                        String str2 = timetableListDTO4.subjectName;
                        Intrinsics.checkNotNullExpressionValue(str2, "children.subjectName");
                        arrayList.add(str2);
                        i2 = i3;
                    }
                    UniversityMusicTableFragment.access$getBinding(UniversityMusicTableFragment.this).wheelView.setAdapter(new TableClassWheelAdapter(UniversityMusicTableFragment.this, arrayList));
                    UniversityMusicTableFragment.access$getBinding(UniversityMusicTableFragment.this).wheelView.setCurrentItem(i);
                    UniversityMusicTableFragment.access$getBinding(UniversityMusicTableFragment.this).wheelView.onItemSelected();
                }
                if (timetableListDTO != null) {
                    UniversityMusicTableFragment.this.timetable = timetableListDTO;
                    if (UniversityMusicTableFragment.this.isHaveClass) {
                        UniversityMusicTableFragment.access$getBinding(UniversityMusicTableFragment.this).tvTableName.setTextColor(UniversityMusicTableFragment.this.getResources().getColor(R.color.yellow5));
                        UniversityMusicTableFragment.access$getBinding(UniversityMusicTableFragment.this).tvTime.setTextColor(UniversityMusicTableFragment.this.getResources().getColor(R.color.yellow5));
                    } else {
                        UniversityMusicTableFragment.access$getBinding(UniversityMusicTableFragment.this).tvTableName.setTextColor(-1);
                        UniversityMusicTableFragment.access$getBinding(UniversityMusicTableFragment.this).tvTime.setTextColor(-1);
                    }
                    TextView textView = UniversityMusicTableFragment.access$getBinding(UniversityMusicTableFragment.this).tvTableName;
                    KBRsp2.DataDTO.TimetableListDTO timetableListDTO5 = UniversityMusicTableFragment.this.timetable;
                    textView.setText(timetableListDTO5 != null ? timetableListDTO5.subjectName : null);
                    TextView textView2 = UniversityMusicTableFragment.access$getBinding(UniversityMusicTableFragment.this).tvTime;
                    UniversityMusicTableFragment universityMusicTableFragment2 = UniversityMusicTableFragment.this;
                    Object[] objArr = new Object[2];
                    KBRsp2.DataDTO.TimetableListDTO timetableListDTO6 = universityMusicTableFragment2.timetable;
                    objArr[0] = timetableListDTO6 != null ? timetableListDTO6.startTime : null;
                    KBRsp2.DataDTO.TimetableListDTO timetableListDTO7 = UniversityMusicTableFragment.this.timetable;
                    objArr[1] = timetableListDTO7 != null ? timetableListDTO7.endTime : null;
                    textView2.setText(universityMusicTableFragment2.getString(R.string.left_right, objArr));
                    TextView textView3 = UniversityMusicTableFragment.access$getBinding(UniversityMusicTableFragment.this).tvStartTime;
                    KBRsp2.DataDTO.TimetableListDTO timetableListDTO8 = UniversityMusicTableFragment.this.timetable;
                    textView3.setText(timetableListDTO8 != null ? timetableListDTO8.startTime : null);
                    TextView textView4 = UniversityMusicTableFragment.access$getBinding(UniversityMusicTableFragment.this).tvEndTime;
                    KBRsp2.DataDTO.TimetableListDTO timetableListDTO9 = UniversityMusicTableFragment.this.timetable;
                    textView4.setText(timetableListDTO9 != null ? timetableListDTO9.endTime : null);
                    return;
                }
                UniversityMusicTableFragment.access$getBinding(UniversityMusicTableFragment.this).tvTableName.setText("");
                UniversityMusicTableFragment.access$getBinding(UniversityMusicTableFragment.this).tvStartTime.setText("");
                UniversityMusicTableFragment.access$getBinding(UniversityMusicTableFragment.this).tvEndTime.setText("");
                UniversityMusicTableFragment.access$getBinding(UniversityMusicTableFragment.this).tvTime.setText("");
            }
        };
        kbRspData.observe(viewLifecycleOwner, new Observer() { // from class: com.yd.android_brand_mvp.landscape.university.music.-$$Lambda$UniversityMusicTableFragment$9L6lME98xWCfN1BIftPFgSS2nXk
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                UniversityMusicTableFragment.initModel$lambda$4(function1, obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initModel$lambda$4(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    @Override // com.yd.android_brand_mvp.base.BaseFragment, com.yd.android_brand_mvp.observer.MinaListener
    public void UpdataEvent(int id) {
        super.UpdataEvent(id);
        if (id == MinaConstants.TABLE_CODE) {
            setTable();
        }
    }

    /* JADX INFO: compiled from: UniversityMusicTableFragment.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010!\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0004\b\u0086\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0013\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0010\u0010\n\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\fH\u0016J\b\u0010\r\u001a\u00020\fH\u0016J\u0010\u0010\u000e\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u0002H\u0016R\u0017\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\u0010"}, d2 = {"Lcom/yd/android_brand_mvp/landscape/university/music/UniversityMusicTableFragment$TableClassWheelAdapter;", "Lcom/contrarywind/adapter/WheelAdapter;", "", "listData", "", "(Lcom/yd/android_brand_mvp/landscape/university/music/UniversityMusicTableFragment;Ljava/util/List;)V", "data", "", "getData", "()Ljava/util/List;", "getItem", FirebaseAnalytics.Param.INDEX, "", "getItemsCount", "indexOf", "o", "app_commonRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public final class TableClassWheelAdapter implements WheelAdapter<String> {
        private final List<String> data;
        final /* synthetic */ UniversityMusicTableFragment this$0;

        public TableClassWheelAdapter(UniversityMusicTableFragment universityMusicTableFragment, List<String> listData) {
            Intrinsics.checkNotNullParameter(listData, "listData");
            this.this$0 = universityMusicTableFragment;
            ArrayList arrayList = new ArrayList();
            this.data = arrayList;
            arrayList.clear();
            this.data.addAll(listData);
        }

        public final List<String> getData() {
            return this.data;
        }

        @Override // com.contrarywind.adapter.WheelAdapter
        public int getItemsCount() {
            return this.data.size();
        }

        @Override // com.contrarywind.adapter.WheelAdapter
        public String getItem(int index) {
            return this.data.get(index);
        }

        @Override // com.contrarywind.adapter.WheelAdapter
        public int indexOf(String o) {
            Intrinsics.checkNotNullParameter(o, "o");
            return this.data.indexOf(o);
        }
    }
}
