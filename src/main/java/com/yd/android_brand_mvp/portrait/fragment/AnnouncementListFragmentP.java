package com.yd.android_brand_mvp.portrait.fragment;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.HasDefaultViewModelProviderFactory;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.lifecycle.viewmodel.CreationExtras;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import butterknife.Unbinder;
import com.bigkoo.pickerview.builder.TimePickerBuilder;
import com.bigkoo.pickerview.listener.CustomListener;
import com.bigkoo.pickerview.listener.OnTimeSelectListener;
import com.bigkoo.pickerview.utils.LunarCalendar;
import com.bigkoo.pickerview.view.TimePickerView;
import com.blankj.utilcode.util.ScreenUtils;
import com.blankj.utilcode.util.SizeUtils;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.listener.OnItemClickListener;
import com.chad.library.adapter.base.listener.OnLoadMoreListener;
import com.chad.library.adapter.base.module.BaseLoadMoreModule;
import com.chad.library.adapter.base.module.LoadMoreModule;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.google.android.exoplayer2.text.ttml.TtmlNode;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.lxj.xpopup.XPopup;
import com.tencent.qcloud.tim.uikit.utils.TUIKitConstants;
import com.yd.android_brand_mvp.R;
import com.yd.android_brand_mvp.adapter.AnnouncementListAdapter;
import com.yd.android_brand_mvp.base.KTBaseFragment;
import com.yd.android_brand_mvp.databinding.FragmentAnnouncementListPBinding;
import com.yd.android_brand_mvp.landscape.message.viewmodel.MessageHomeNewViewModel;
import com.yd.android_brand_mvp.model.MessageDetail;
import com.yd.android_brand_mvp.model.MessageItemBean;
import com.yd.android_brand_mvp.network.base.BasePageResponse;
import com.yd.android_brand_mvp.network.base.SingleLiveEvent;
import com.yd.android_brand_mvp.portrait.activity.MessageDetailsPActivity;
import com.yd.android_brand_mvp.user.AnnouncementListActivity;
import com.yd.android_brand_mvp.utils.DateUtils;
import com.yd.android_brand_mvp.utils.GlideUtil;
import com.yd.android_brand_mvp.utils.PageUtils;
import com.yd.android_brand_mvp.utils.TransUtils;
import com.yd.android_brand_mvp.weight.ImageShowPopup;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.StringCompanionObject;
import org.eclipse.paho.android.service.MqttServiceConstants;

/* JADX INFO: compiled from: AnnouncementListFragmentP.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000|\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0018\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003:\u0001NB\u0005¢\u0006\u0002\u0010\u0004J\b\u0010>\u001a\u00020?H\u0002J\u0010\u0010@\u001a\u00020?2\u0006\u0010A\u001a\u00020BH\u0002J\b\u0010C\u001a\u00020?H\u0002J\u0010\u0010D\u001a\u00020?2\u0006\u0010E\u001a\u00020FH\u0016J\b\u0010G\u001a\u00020?H\u0016J\u001a\u0010H\u001a\u00020?2\u0006\u0010I\u001a\u00020F2\b\u0010J\u001a\u0004\u0018\u00010KH\u0016J\b\u0010L\u001a\u00020?H\u0002J\b\u0010M\u001a\u00020\fH\u0002R\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u000e\u0010\u000b\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u000f\u001a\u00020\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001a\u0010\u0014\u001a\u00020\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0011\"\u0004\b\u0016\u0010\u0013R\"\u0010\u0017\u001a\n\u0012\u0004\u0012\u00020\u0019\u0018\u00010\u0018X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u000e\u0010\u001e\u001a\u00020\u001fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010 \u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010!\u001a\u00020\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010\u0011\"\u0004\b#\u0010\u0013R\u001a\u0010$\u001a\u00020\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010\u0011\"\u0004\b&\u0010\u0013R\u001a\u0010'\u001a\u00020\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b(\u0010\u0011\"\u0004\b)\u0010\u0013R\u0010\u0010*\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010+\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010,\u001a\u0004\u0018\u00010-X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010.\u001a\u0004\u0018\u00010-X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010/\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u00100\u001a\u0004\u0018\u000101X\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u00102\u001a\u0004\u0018\u000103X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b4\u00105\"\u0004\b6\u00107R\u001b\u00108\u001a\u0002098BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b<\u0010=\u001a\u0004\b:\u0010;¨\u0006O"}, d2 = {"Lcom/yd/android_brand_mvp/portrait/fragment/AnnouncementListFragmentP;", "Lcom/yd/android_brand_mvp/base/KTBaseFragment;", "Lcom/yd/android_brand_mvp/databinding/FragmentAnnouncementListPBinding;", "Landroid/view/View$OnClickListener;", "()V", "adapter", "Lcom/yd/android_brand_mvp/adapter/AnnouncementListAdapter;", "getAdapter", "()Lcom/yd/android_brand_mvp/adapter/AnnouncementListAdapter;", "setAdapter", "(Lcom/yd/android_brand_mvp/adapter/AnnouncementListAdapter;)V", "currentClickType", "", "endDate", "", FirebaseAnalytics.Param.INDEX, "getIndex", "()I", "setIndex", "(I)V", TtmlNode.TAG_LAYOUT, "getLayout", "setLayout", TUIKitConstants.Selection.LIST, "", "Lcom/yd/android_brand_mvp/model/MessageItemBean;", "getList", "()Ljava/util/List;", "setList", "(Ljava/util/List;)V", "mPosterAdapter", "Lcom/yd/android_brand_mvp/portrait/fragment/AnnouncementListFragmentP$PosterAdapter;", MqttServiceConstants.MESSAGE_ID, "pagTotal", "getPagTotal", "setPagTotal", "pageNo", "getPageNo", "setPageNo", "pageSize", "getPageSize", "setPageSize", "requestType", "searchKey", "selectEndTime", "Ljava/util/Date;", "selectStartTime", "startDate", "timeView", "Lcom/bigkoo/pickerview/view/TimePickerView;", "unbinder", "Lbutterknife/Unbinder;", "getUnbinder", "()Lbutterknife/Unbinder;", "setUnbinder", "(Lbutterknife/Unbinder;)V", "viewModel", "Lcom/yd/android_brand_mvp/landscape/message/viewmodel/MessageHomeNewViewModel;", "getViewModel", "()Lcom/yd/android_brand_mvp/landscape/message/viewmodel/MessageHomeNewViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "initModel", "", "initTimeSelectView", "type", "", "initView", "onClick", "v", "Landroid/view/View;", "onDestroy", "onViewCreated", "view", "savedInstanceState", "Landroid/os/Bundle;", "requestList", "setSelectPosition", "PosterAdapter", "app_commonRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class AnnouncementListFragmentP extends KTBaseFragment<FragmentAnnouncementListPBinding> implements View.OnClickListener {
    private AnnouncementListAdapter adapter;
    private int currentClickType;
    private String endDate;
    private int index;
    private int layout;
    private List<MessageItemBean> list;
    private final PosterAdapter mPosterAdapter;
    private String messageId;
    private int pagTotal;
    private int pageNo;
    private int pageSize;
    private String requestType;
    private String searchKey;
    private Date selectEndTime;
    private Date selectStartTime;
    private String startDate;
    private TimePickerView timeView;
    private Unbinder unbinder;

    /* JADX INFO: renamed from: viewModel$delegate, reason: from kotlin metadata */
    private final Lazy viewModel;

    /* JADX INFO: renamed from: com.yd.android_brand_mvp.portrait.fragment.AnnouncementListFragmentP$1, reason: invalid class name */
    /* JADX INFO: compiled from: AnnouncementListFragmentP.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements Function3<LayoutInflater, ViewGroup, Boolean, FragmentAnnouncementListPBinding> {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        AnonymousClass1() {
            super(3, FragmentAnnouncementListPBinding.class, "inflate", "inflate(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Z)Lcom/yd/android_brand_mvp/databinding/FragmentAnnouncementListPBinding;", 0);
        }

        public final FragmentAnnouncementListPBinding invoke(LayoutInflater p0, ViewGroup viewGroup, boolean z) {
            Intrinsics.checkNotNullParameter(p0, "p0");
            return FragmentAnnouncementListPBinding.inflate(p0, viewGroup, z);
        }

        @Override // kotlin.jvm.functions.Function3
        public /* bridge */ /* synthetic */ FragmentAnnouncementListPBinding invoke(LayoutInflater layoutInflater, ViewGroup viewGroup, Boolean bool) {
            return invoke(layoutInflater, viewGroup, bool.booleanValue());
        }
    }

    public AnnouncementListFragmentP() {
        super(AnonymousClass1.INSTANCE);
        this.pageNo = 1;
        this.pageSize = 30;
        this.requestType = AnnouncementListActivity.TYPE_ANNOUNCEMENT;
        this.searchKey = "";
        this.startDate = "";
        this.endDate = "";
        final AnnouncementListFragmentP announcementListFragmentP = this;
        final Function0<Fragment> function0 = new Function0<Fragment>() { // from class: com.yd.android_brand_mvp.portrait.fragment.AnnouncementListFragmentP$special$$inlined$viewModels$default$1
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Fragment invoke() {
                return announcementListFragmentP;
            }
        };
        final Lazy lazy = LazyKt.lazy(LazyThreadSafetyMode.NONE, (Function0) new Function0<ViewModelStoreOwner>() { // from class: com.yd.android_brand_mvp.portrait.fragment.AnnouncementListFragmentP$special$$inlined$viewModels$default$2
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
        this.viewModel = FragmentViewModelLazyKt.createViewModelLazy(announcementListFragmentP, Reflection.getOrCreateKotlinClass(MessageHomeNewViewModel.class), new Function0<ViewModelStore>() { // from class: com.yd.android_brand_mvp.portrait.fragment.AnnouncementListFragmentP$special$$inlined$viewModels$default$3
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
        }, new Function0<CreationExtras>() { // from class: com.yd.android_brand_mvp.portrait.fragment.AnnouncementListFragmentP$special$$inlined$viewModels$default$4
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
        }, new Function0<ViewModelProvider.Factory>() { // from class: com.yd.android_brand_mvp.portrait.fragment.AnnouncementListFragmentP$special$$inlined$viewModels$default$5
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
                    defaultViewModelProviderFactory = announcementListFragmentP.getDefaultViewModelProviderFactory();
                }
                Intrinsics.checkNotNullExpressionValue(defaultViewModelProviderFactory, "(owner as? HasDefaultVie…tViewModelProviderFactory");
                return defaultViewModelProviderFactory;
            }
        });
        this.messageId = "";
        this.mPosterAdapter = new PosterAdapter(R.layout.item_message_poster_detail);
    }

    public static final /* synthetic */ FragmentAnnouncementListPBinding access$getBinding(AnnouncementListFragmentP announcementListFragmentP) {
        return announcementListFragmentP.getBinding();
    }

    public final Unbinder getUnbinder() {
        return this.unbinder;
    }

    public final void setUnbinder(Unbinder unbinder) {
        this.unbinder = unbinder;
    }

    public final List<MessageItemBean> getList() {
        return this.list;
    }

    public final void setList(List<MessageItemBean> list) {
        this.list = list;
    }

    public final AnnouncementListAdapter getAdapter() {
        return this.adapter;
    }

    public final void setAdapter(AnnouncementListAdapter announcementListAdapter) {
        this.adapter = announcementListAdapter;
    }

    public final int getIndex() {
        return this.index;
    }

    public final void setIndex(int i) {
        this.index = i;
    }

    public final int getLayout() {
        return this.layout;
    }

    public final void setLayout(int i) {
        this.layout = i;
    }

    public final int getPageNo() {
        return this.pageNo;
    }

    public final void setPageNo(int i) {
        this.pageNo = i;
    }

    public final int getPageSize() {
        return this.pageSize;
    }

    public final void setPageSize(int i) {
        this.pageSize = i;
    }

    public final int getPagTotal() {
        return this.pagTotal;
    }

    public final void setPagTotal(int i) {
        this.pagTotal = i;
    }

    private final MessageHomeNewViewModel getViewModel() {
        return (MessageHomeNewViewModel) this.viewModel.getValue();
    }

    @Override // com.yd.android_brand_mvp.base.KTBaseFragment, com.yd.android_brand_mvp.base.BaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        String string = requireArguments().getString("type");
        if (!TextUtils.isEmpty(string)) {
            this.requestType = string;
        }
        this.messageId = requireArguments().getString("id");
        initModel();
        initView();
        initTimeSelectView(TransUtils.INSTANCE.getShowTimeTypeArray("YYYY-MM-DD"));
        requestList();
    }

    private final void requestList() {
        if (!this.mActivity.isDestroyed()) {
            this.bookLoadingDiallog.show();
        }
        MessageHomeNewViewModel viewModel = getViewModel();
        String str = this.searchKey;
        String str2 = this.requestType;
        Intrinsics.checkNotNull(str2);
        viewModel.requestMessageHome(str, str2, this.pageNo, this.pageSize, this.startDate, this.endDate);
    }

    private final void initView() {
        ArrayList arrayList = new ArrayList();
        this.list = arrayList;
        this.adapter = new AnnouncementListAdapter(arrayList);
        if (Intrinsics.areEqual(this.requestType, AnnouncementListActivity.TYPE_POSTER)) {
            getBinding().rvList.setLayoutManager(new GridLayoutManager(requireContext(), 3));
            getBinding().rvList.setAdapter(this.mPosterAdapter);
            this.mPosterAdapter.setEmptyView(R.layout.item_null_layout_4);
        } else {
            LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
            linearLayoutManager.setOrientation(1);
            getBinding().rvList.setLayoutManager(linearLayoutManager);
            getBinding().rvList.setAdapter(this.adapter);
            AnnouncementListAdapter announcementListAdapter = this.adapter;
            Intrinsics.checkNotNull(announcementListAdapter);
            announcementListAdapter.setEmptyView(R.layout.item_null_layout_4);
        }
        AnnouncementListAdapter announcementListAdapter2 = this.adapter;
        Intrinsics.checkNotNull(announcementListAdapter2);
        announcementListAdapter2.getLoadMoreModule().setEnableLoadMore(true);
        AnnouncementListAdapter announcementListAdapter3 = this.adapter;
        Intrinsics.checkNotNull(announcementListAdapter3);
        announcementListAdapter3.getLoadMoreModule().setOnLoadMoreListener(new OnLoadMoreListener() { // from class: com.yd.android_brand_mvp.portrait.fragment.-$$Lambda$AnnouncementListFragmentP$MX46AFwNfVxwa7-l-yGV0-0lJrU
            @Override // com.chad.library.adapter.base.listener.OnLoadMoreListener
            public final void onLoadMore() {
                AnnouncementListFragmentP.initView$lambda$0(this.f$0);
            }
        });
        AnnouncementListAdapter announcementListAdapter4 = this.adapter;
        Intrinsics.checkNotNull(announcementListAdapter4);
        announcementListAdapter4.getLoadMoreModule().setAutoLoadMore(true);
        AnnouncementListAdapter announcementListAdapter5 = this.adapter;
        Intrinsics.checkNotNull(announcementListAdapter5);
        announcementListAdapter5.getLoadMoreModule().setEnableLoadMoreIfNotFullPage(false);
        AnnouncementListAdapter announcementListAdapter6 = this.adapter;
        Intrinsics.checkNotNull(announcementListAdapter6);
        announcementListAdapter6.setOnItemClickListener(new OnItemClickListener() { // from class: com.yd.android_brand_mvp.portrait.fragment.-$$Lambda$AnnouncementListFragmentP$ff6yHUhQ3Whenzfb0VHUt2iSOms
            @Override // com.chad.library.adapter.base.listener.OnItemClickListener
            public final void onItemClick(BaseQuickAdapter baseQuickAdapter, View view, int i) {
                AnnouncementListFragmentP.initView$lambda$2(this.f$0, baseQuickAdapter, view, i);
            }
        });
        this.mPosterAdapter.getLoadMoreModule().setEnableLoadMore(true);
        this.mPosterAdapter.getLoadMoreModule().setOnLoadMoreListener(new OnLoadMoreListener() { // from class: com.yd.android_brand_mvp.portrait.fragment.-$$Lambda$AnnouncementListFragmentP$YqJjA7gJ14NNrqHLb6wcnq4A2pY
            @Override // com.chad.library.adapter.base.listener.OnLoadMoreListener
            public final void onLoadMore() {
                AnnouncementListFragmentP.initView$lambda$3(this.f$0);
            }
        });
        this.mPosterAdapter.getLoadMoreModule().setAutoLoadMore(true);
        this.mPosterAdapter.getLoadMoreModule().setEnableLoadMoreIfNotFullPage(false);
        this.mPosterAdapter.setOnItemClickListener(new OnItemClickListener() { // from class: com.yd.android_brand_mvp.portrait.fragment.-$$Lambda$AnnouncementListFragmentP$xsg4372xK0wxAZRKpX4vLxAEm6U
            @Override // com.chad.library.adapter.base.listener.OnItemClickListener
            public final void onItemClick(BaseQuickAdapter baseQuickAdapter, View view, int i) {
                AnnouncementListFragmentP.initView$lambda$5(this.f$0, baseQuickAdapter, view, i);
            }
        });
        this.mPosterAdapter.setOnItemClickListener(new OnItemClickListener() { // from class: com.yd.android_brand_mvp.portrait.fragment.-$$Lambda$AnnouncementListFragmentP$8EC_3JKOJR8Llu4Uuf8SU8XkVIM
            @Override // com.chad.library.adapter.base.listener.OnItemClickListener
            public final void onItemClick(BaseQuickAdapter baseQuickAdapter, View view, int i) {
                AnnouncementListFragmentP.initView$lambda$7(this.f$0, baseQuickAdapter, view, i);
            }
        });
        AnnouncementListFragmentP announcementListFragmentP = this;
        getBinding().tvSearch.setOnClickListener(announcementListFragmentP);
        getBinding().tvReset.setOnClickListener(announcementListFragmentP);
        getBinding().tvStartTime.setOnClickListener(announcementListFragmentP);
        getBinding().tvEndTime.setOnClickListener(announcementListFragmentP);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$0(AnnouncementListFragmentP this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.pageNo++;
        AnnouncementListAdapter announcementListAdapter = this$0.adapter;
        Intrinsics.checkNotNull(announcementListAdapter);
        announcementListAdapter.getLoadMoreModule().setEnableLoadMore(true);
        this$0.requestList();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$2(AnnouncementListFragmentP this$0, BaseQuickAdapter bAdapter, View view, int i) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(bAdapter, "bAdapter");
        Intrinsics.checkNotNullParameter(view, "view");
        this$0.index = i;
        AnnouncementListAdapter announcementListAdapter = this$0.adapter;
        Intrinsics.checkNotNull(announcementListAdapter);
        announcementListAdapter.setIndex(this$0.index);
        List<MessageItemBean> list = this$0.list;
        if (list != null) {
            MessageDetailsPActivity.Companion companion = MessageDetailsPActivity.INSTANCE;
            Context contextRequireContext = this$0.requireContext();
            Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext()");
            companion.start(contextRequireContext, this$0.requestType, list.get(i));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$3(AnnouncementListFragmentP this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.pageNo++;
        this$0.mPosterAdapter.getLoadMoreModule().setEnableLoadMore(true);
        this$0.requestList();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$5(AnnouncementListFragmentP this$0, BaseQuickAdapter baseQuickAdapter, View view, int i) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.index = i;
        AnnouncementListAdapter announcementListAdapter = this$0.adapter;
        Intrinsics.checkNotNull(announcementListAdapter);
        announcementListAdapter.setIndex(this$0.index);
        List<MessageItemBean> list = this$0.list;
        if (list != null) {
            MessageDetailsPActivity.Companion companion = MessageDetailsPActivity.INSTANCE;
            Context contextRequireContext = this$0.requireContext();
            Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext()");
            companion.start(contextRequireContext, this$0.requestType, list.get(i));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$7(AnnouncementListFragmentP this$0, BaseQuickAdapter baseQuickAdapter, View view, int i) {
        String coverImg;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        MessageItemBean item = this$0.mPosterAdapter.getItem(i);
        List<MessageDetail> details = item.getDetails();
        String contentImg = "";
        if (details != null) {
            if (ScreenUtils.isLandscape()) {
                if ((!details.isEmpty()) && details.size() > 1) {
                    coverImg = details.get(1).getCoverImg();
                    contentImg = coverImg;
                }
            } else if (!details.isEmpty()) {
                coverImg = details.get(0).getCoverImg();
                contentImg = coverImg;
            }
        }
        if (TextUtils.isEmpty(contentImg)) {
            contentImg = item.getContentImg();
        }
        new XPopup.Builder(this$0.mActivity).asCustom(new ImageShowPopup(this$0.mActivity, contentImg)).show();
    }

    private final void initTimeSelectView(boolean[] type) {
        Calendar calendar = Calendar.getInstance();
        Calendar calendar2 = Calendar.getInstance();
        calendar.set(LunarCalendar.MIN_YEAR, 0, 1);
        calendar2.set(2119, 11, 31);
        final String str = "yyyy-MM-dd";
        this.timeView = new TimePickerBuilder(requireContext(), new OnTimeSelectListener() { // from class: com.yd.android_brand_mvp.portrait.fragment.-$$Lambda$AnnouncementListFragmentP$QPie7HW6uvHT81_iAwpGqdXnQcY
            @Override // com.bigkoo.pickerview.listener.OnTimeSelectListener
            public final void onTimeSelect(Date date, View view) {
                AnnouncementListFragmentP.initTimeSelectView$lambda$8(this.f$0, str, date, view);
            }
        }).setDate(Calendar.getInstance()).setType(type).setRangDate(calendar, calendar2).setTextColorCenter(getResources().getColor(R.color.purple2)).setDividerColor(getResources().getColor(R.color.purple2)).setLabel("年", "月", "日", "时", "分", "秒").setLayoutRes(R.layout.time_select, new CustomListener() { // from class: com.yd.android_brand_mvp.portrait.fragment.-$$Lambda$AnnouncementListFragmentP$9H5RApM8s4-tv958sZh5_WBrOdg
            @Override // com.bigkoo.pickerview.listener.CustomListener
            public final void customLayout(View view) {
                AnnouncementListFragmentP.initTimeSelectView$lambda$11(this.f$0, view);
            }
        }).isCenterLabel(false).isDialog(true).build();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initTimeSelectView$lambda$8(AnnouncementListFragmentP this$0, String timeFormat, Date date, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(timeFormat, "$timeFormat");
        Calendar.getInstance().setTime(date);
        int i = this$0.currentClickType;
        if (i == 0) {
            this$0.selectStartTime = date;
            this$0.getBinding().tvStartTime.setText(DateUtils.getDate(date, timeFormat));
        } else if (i == 1) {
            this$0.selectEndTime = date;
            this$0.getBinding().tvEndTime.setText(DateUtils.getDate(date, timeFormat));
        }
        String string = this$0.getBinding().tvStartTime.getText().toString();
        String string2 = this$0.getBinding().tvEndTime.getText().toString();
        if (!TextUtils.isEmpty(string) && !TextUtils.isEmpty(string2)) {
            this$0.startDate = string + " 00:00:00";
            this$0.endDate = string2 + " 23:59:59";
        }
        TimePickerView timePickerView = this$0.timeView;
        Intrinsics.checkNotNull(timePickerView);
        timePickerView.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initTimeSelectView$lambda$11(final AnnouncementListFragmentP this$0, View v) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(v, "v");
        Button button = (Button) v.findViewById(R.id.btnCancel);
        Button button2 = (Button) v.findViewById(R.id.btnSubmit);
        button.setOnClickListener(new View.OnClickListener() { // from class: com.yd.android_brand_mvp.portrait.fragment.-$$Lambda$AnnouncementListFragmentP$F1TFvK6SQgB3cLneI1hPMNfgQ8s
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                AnnouncementListFragmentP.initTimeSelectView$lambda$11$lambda$9(this.f$0, view);
            }
        });
        button2.setOnClickListener(new View.OnClickListener() { // from class: com.yd.android_brand_mvp.portrait.fragment.-$$Lambda$AnnouncementListFragmentP$KPv1p-fGfe8jZrBVS8HTvHQGv9E
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                AnnouncementListFragmentP.initTimeSelectView$lambda$11$lambda$10(this.f$0, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initTimeSelectView$lambda$11$lambda$9(AnnouncementListFragmentP this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        TimePickerView timePickerView = this$0.timeView;
        Intrinsics.checkNotNull(timePickerView);
        timePickerView.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initTimeSelectView$lambda$11$lambda$10(AnnouncementListFragmentP this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        TimePickerView timePickerView = this$0.timeView;
        Intrinsics.checkNotNull(timePickerView);
        timePickerView.returnData();
    }

    private final void initModel() {
        SingleLiveEvent<Result<BasePageResponse<List<MessageItemBean>>>> messageListLiveData = getViewModel().getMessageListLiveData();
        FragmentActivity fragmentActivityRequireActivity = requireActivity();
        Intrinsics.checkNotNullExpressionValue(fragmentActivityRequireActivity, "requireActivity()");
        final Function1<Result<? extends BasePageResponse<List<MessageItemBean>>>, Unit> function1 = new Function1<Result<? extends BasePageResponse<List<MessageItemBean>>>, Unit>() { // from class: com.yd.android_brand_mvp.portrait.fragment.AnnouncementListFragmentP.initModel.1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Result<? extends BasePageResponse<List<MessageItemBean>>> result) {
                invoke2(result);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Result<? extends BasePageResponse<List<MessageItemBean>>> it2) {
                if (!AnnouncementListFragmentP.this.mActivity.isDestroyed()) {
                    AnnouncementListFragmentP.this.bookLoadingDiallog.dismiss();
                }
                Intrinsics.checkNotNullExpressionValue(it2, "it");
                if (Result.m598isSuccessimpl(it2.getValue())) {
                    Object value = it2.getValue();
                    if (Result.m597isFailureimpl(value)) {
                        value = null;
                    }
                    BasePageResponse basePageResponse = (BasePageResponse) value;
                    if (basePageResponse != null) {
                        AnnouncementListFragmentP announcementListFragmentP = AnnouncementListFragmentP.this;
                        TextView textView = AnnouncementListFragmentP.access$getBinding(announcementListFragmentP).tvCount;
                        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
                        String str = String.format("共%d条", Arrays.copyOf(new Object[]{Integer.valueOf(basePageResponse.getTotal())}, 1));
                        Intrinsics.checkNotNullExpressionValue(str, "format(format, *args)");
                        textView.setText(str);
                        if (basePageResponse.getList() == null || ((List) basePageResponse.getList()).size() <= 0) {
                            return;
                        }
                        if (announcementListFragmentP.getPageNo() == 1) {
                            List<MessageItemBean> list = announcementListFragmentP.getList();
                            Intrinsics.checkNotNull(list);
                            list.clear();
                        }
                        List<MessageItemBean> list2 = announcementListFragmentP.getList();
                        Intrinsics.checkNotNull(list2);
                        list2.addAll((Collection) basePageResponse.getList());
                        if (Intrinsics.areEqual(announcementListFragmentP.requestType, AnnouncementListActivity.TYPE_POSTER)) {
                            if (basePageResponse.getTotal() > 0) {
                                announcementListFragmentP.setPagTotal(PageUtils.INSTANCE.doCalculatePageNumber(18, Integer.valueOf(basePageResponse.getTotal())));
                                if (announcementListFragmentP.getPagTotal() <= 0) {
                                    announcementListFragmentP.setPagTotal(1);
                                }
                            }
                            if (announcementListFragmentP.getPageNo() == 1) {
                                announcementListFragmentP.mPosterAdapter.setList((Collection) basePageResponse.getList());
                            } else {
                                announcementListFragmentP.mPosterAdapter.addData((Collection) basePageResponse.getList());
                            }
                        } else {
                            AnnouncementListFragmentP.access$getBinding(announcementListFragmentP).rvList.setVisibility(0);
                            if (announcementListFragmentP.getPageNo() == 1) {
                                AnnouncementListAdapter adapter = announcementListFragmentP.getAdapter();
                                Intrinsics.checkNotNull(adapter);
                                adapter.setList((Collection) basePageResponse.getList());
                            } else {
                                AnnouncementListAdapter adapter2 = announcementListFragmentP.getAdapter();
                                Intrinsics.checkNotNull(adapter2);
                                adapter2.addData((Collection) basePageResponse.getList());
                            }
                            announcementListFragmentP.setIndex(announcementListFragmentP.setSelectPosition());
                            AnnouncementListAdapter adapter3 = announcementListFragmentP.getAdapter();
                            Intrinsics.checkNotNull(adapter3);
                            adapter3.setIndex(announcementListFragmentP.getIndex());
                        }
                        if (((List) basePageResponse.getList()).size() >= announcementListFragmentP.getPageSize()) {
                            AnnouncementListAdapter adapter4 = announcementListFragmentP.getAdapter();
                            Intrinsics.checkNotNull(adapter4);
                            adapter4.getLoadMoreModule().loadMoreComplete();
                            announcementListFragmentP.mPosterAdapter.getLoadMoreModule().loadMoreComplete();
                            return;
                        }
                        AnnouncementListAdapter adapter5 = announcementListFragmentP.getAdapter();
                        Intrinsics.checkNotNull(adapter5);
                        BaseLoadMoreModule.loadMoreEnd$default(adapter5.getLoadMoreModule(), false, 1, null);
                        BaseLoadMoreModule.loadMoreEnd$default(announcementListFragmentP.mPosterAdapter.getLoadMoreModule(), false, 1, null);
                    }
                }
            }
        };
        messageListLiveData.observe(fragmentActivityRequireActivity, new Observer() { // from class: com.yd.android_brand_mvp.portrait.fragment.-$$Lambda$AnnouncementListFragmentP$awquqSudQzZZSjVUL38Tzh03GAU
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                AnnouncementListFragmentP.initModel$lambda$12(function1, obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initModel$lambda$12(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: compiled from: AnnouncementListFragmentP.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0002\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00012\u00020\u0004B\r\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\u0018\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\u0002H\u0014¨\u0006\f"}, d2 = {"Lcom/yd/android_brand_mvp/portrait/fragment/AnnouncementListFragmentP$PosterAdapter;", "Lcom/chad/library/adapter/base/BaseQuickAdapter;", "Lcom/yd/android_brand_mvp/model/MessageItemBean;", "Lcom/chad/library/adapter/base/viewholder/BaseViewHolder;", "Lcom/chad/library/adapter/base/module/LoadMoreModule;", "layoutResId", "", "(I)V", "convert", "", "holder", "item", "app_commonRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
    private static final class PosterAdapter extends BaseQuickAdapter<MessageItemBean, BaseViewHolder> implements LoadMoreModule {
        public PosterAdapter(int i) {
            super(i, null, 2, null);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.chad.library.adapter.base.BaseQuickAdapter
        public void convert(BaseViewHolder holder, MessageItemBean item) {
            Intrinsics.checkNotNullParameter(holder, "holder");
            Intrinsics.checkNotNullParameter(item, "item");
            ImageView imageView = (ImageView) holder.getView(R.id.ivImg);
            if (item.getDetails() != null) {
                List<MessageDetail> details = item.getDetails();
                Intrinsics.checkNotNull(details);
                if (!details.isEmpty()) {
                    Context context = getContext();
                    List<MessageDetail> details2 = item.getDetails();
                    Intrinsics.checkNotNull(details2);
                    GlideUtil.loadImageRadius(context, details2.get(0).getCoverImg(), imageView, -1, SizeUtils.dp2px(10.0f));
                    return;
                }
            }
            GlideUtil.loadImageRadius(getContext(), item.getContentImg(), imageView, -1, SizeUtils.dp2px(10.0f));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final int setSelectPosition() {
        List<MessageItemBean> list = this.list;
        if (list == null) {
            return 0;
        }
        Intrinsics.checkNotNull(list);
        if (!(!list.isEmpty())) {
            return 0;
        }
        List<MessageItemBean> list2 = this.list;
        Intrinsics.checkNotNull(list2);
        int size = list2.size();
        for (int i = 0; i < size; i++) {
            List<MessageItemBean> list3 = this.list;
            Intrinsics.checkNotNull(list3);
            if (Intrinsics.areEqual(this.messageId, list3.get(i).getId())) {
                return i;
            }
        }
        return 0;
    }

    @Override // com.yd.android_brand_mvp.base.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        Unbinder unbinder = this.unbinder;
        if (unbinder != null) {
            Intrinsics.checkNotNull(unbinder);
            unbinder.unbind();
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v) {
        Intrinsics.checkNotNullParameter(v, "v");
        switch (v.getId()) {
            case R.id.tvEndTime /* 2131364030 */:
                this.currentClickType = 1;
                TimePickerView timePickerView = this.timeView;
                Intrinsics.checkNotNull(timePickerView);
                timePickerView.show();
                break;
            case R.id.tvReset /* 2131364074 */:
                this.searchKey = "";
                this.startDate = "";
                this.endDate = "";
                getBinding().etSearchTitle.setText("");
                getBinding().tvStartTime.setText("开始日期");
                getBinding().tvEndTime.setText("结束日期");
                this.selectStartTime = null;
                this.selectEndTime = null;
                requestList();
                break;
            case R.id.tvSearch /* 2131364082 */:
                String string = getBinding().etSearchTitle.getText().toString();
                int length = string.length() - 1;
                int i = 0;
                boolean z = false;
                while (i <= length) {
                    boolean z2 = Intrinsics.compare((int) string.charAt(!z ? i : length), 32) <= 0;
                    if (z) {
                        if (!z2) {
                            this.searchKey = string.subSequence(i, length + 1).toString();
                            getBinding().tvStartTime.getText().toString();
                            getBinding().tvEndTime.getText().toString();
                            this.pageNo = 1;
                            requestList();
                        } else {
                            length--;
                        }
                        break;
                    } else if (z2) {
                        i++;
                    } else {
                        z = true;
                    }
                }
                this.searchKey = string.subSequence(i, length + 1).toString();
                getBinding().tvStartTime.getText().toString();
                getBinding().tvEndTime.getText().toString();
                this.pageNo = 1;
                requestList();
                break;
            case R.id.tvStartTime /* 2131364092 */:
                this.currentClickType = 0;
                TimePickerView timePickerView2 = this.timeView;
                Intrinsics.checkNotNull(timePickerView2);
                timePickerView2.show();
                break;
        }
    }
}
