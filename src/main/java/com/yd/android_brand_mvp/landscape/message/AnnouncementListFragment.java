package com.yd.android_brand_mvp.landscape.message;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Base64;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.ImageView;
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
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
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
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.google.android.exoplayer2.text.ttml.TtmlNode;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.lxj.xpopup.XPopup;
import com.yd.android_brand_mvp.R;
import com.yd.android_brand_mvp.activity.TBSWebViewActivity;
import com.yd.android_brand_mvp.adapter.AnnouncementListAdapter;
import com.yd.android_brand_mvp.base.BaseBindingAdapter;
import com.yd.android_brand_mvp.base.BaseConstant;
import com.yd.android_brand_mvp.base.KTBaseFragment;
import com.yd.android_brand_mvp.base.VBViewHolder;
import com.yd.android_brand_mvp.databinding.FragmentAnnouncementListBinding;
import com.yd.android_brand_mvp.databinding.ItemMessageDocumentBinding;
import com.yd.android_brand_mvp.landscape.message.viewmodel.MessageHomeNewViewModel;
import com.yd.android_brand_mvp.landscape.message.viewmodel.MessageViewModel;
import com.yd.android_brand_mvp.model.MessageDetail;
import com.yd.android_brand_mvp.model.MessageItemBean;
import com.yd.android_brand_mvp.model.message.DocumentBean;
import com.yd.android_brand_mvp.model.message.MessageReceiveBean;
import com.yd.android_brand_mvp.network.base.BasePageResponse;
import com.yd.android_brand_mvp.network.base.SingleLiveEvent;
import com.yd.android_brand_mvp.repository.DownRepository;
import com.yd.android_brand_mvp.user.AnnouncementListActivity;
import com.yd.android_brand_mvp.utils.DateUtils;
import com.yd.android_brand_mvp.utils.GlideUtil;
import com.yd.android_brand_mvp.utils.PageUtils;
import com.yd.android_brand_mvp.utils.StringUtils;
import com.yd.android_brand_mvp.utils.TimeUtil;
import com.yd.android_brand_mvp.utils.ToastUtil;
import com.yd.android_brand_mvp.utils.TransUtils;
import com.yd.android_brand_mvp.utils.view.net.GsonUtils;
import com.yd.android_brand_mvp.weight.ImageShowPopup;
import com.yd.android_brand_mvp.weight.MultiStateView;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
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
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import org.eclipse.paho.android.service.MqttServiceConstants;
import skin.support.content.res.SkinCompatResources;

/* JADX INFO: compiled from: AnnouncementListFragment.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u0084\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0018\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003:\u0001PB\u0005¢\u0006\u0002\u0010\u0004J\u0010\u0010:\u001a\u00020;2\u0006\u0010<\u001a\u00020=H\u0002J\b\u0010>\u001a\u00020;H\u0002J\u0006\u0010?\u001a\u00020;J\u0010\u0010@\u001a\u00020;2\u0006\u0010A\u001a\u00020\u0012H\u0002J\u0010\u0010B\u001a\u00020;2\u0006\u0010C\u001a\u00020DH\u0016J\u001a\u0010E\u001a\u00020;2\u0006\u0010F\u001a\u00020D2\b\u0010G\u001a\u0004\u0018\u00010HH\u0016J\b\u0010I\u001a\u00020;H\u0002J\b\u0010J\u001a\u00020\fH\u0002J\b\u0010K\u001a\u00020;H\u0002J\b\u0010L\u001a\u00020;H\u0002J\u0012\u0010M\u001a\u00020;2\b\u0010N\u001a\u0004\u0018\u00010OH\u0002R\u001a\u0010\u0005\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u000e\u0010\u000b\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u00100\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0013\u001a\u00020\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001a\u0010\u0018\u001a\u00020\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u0015\"\u0004\b\u001a\u0010\u0017R\u000e\u0010\u001b\u001a\u00020\u001cX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u001d\u001a\u0004\u0018\u00010\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u001e\u001a\u00020\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\u0015\"\u0004\b \u0010\u0017R\u001a\u0010!\u001a\u00020\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010\u0015\"\u0004\b#\u0010\u0017R\u001a\u0010$\u001a\u00020\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010\u0015\"\u0004\b&\u0010\u0017R\u0010\u0010'\u001a\u0004\u0018\u00010\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010(\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010)\u001a\u0004\u0018\u00010*X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010+\u001a\u0004\u0018\u00010*X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010,\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010-\u001a\u0004\u0018\u00010.X\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010/\u001a\u0002008BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b3\u00104\u001a\u0004\b1\u00102R\u001b\u00105\u001a\u0002068BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b9\u00104\u001a\u0004\b7\u00108¨\u0006Q"}, d2 = {"Lcom/yd/android_brand_mvp/landscape/message/AnnouncementListFragment;", "Lcom/yd/android_brand_mvp/base/KTBaseFragment;", "Lcom/yd/android_brand_mvp/databinding/FragmentAnnouncementListBinding;", "Landroid/view/View$OnClickListener;", "()V", "adapter", "Lcom/yd/android_brand_mvp/adapter/AnnouncementListAdapter;", "getAdapter", "()Lcom/yd/android_brand_mvp/adapter/AnnouncementListAdapter;", "setAdapter", "(Lcom/yd/android_brand_mvp/adapter/AnnouncementListAdapter;)V", "currentClickType", "", "docAdapter", "Lcom/yd/android_brand_mvp/base/BaseBindingAdapter;", "Lcom/yd/android_brand_mvp/databinding/ItemMessageDocumentBinding;", "Lcom/yd/android_brand_mvp/model/message/DocumentBean;", "endDate", "", FirebaseAnalytics.Param.INDEX, "getIndex", "()I", "setIndex", "(I)V", TtmlNode.TAG_LAYOUT, "getLayout", "setLayout", "mPosterAdapter", "Lcom/yd/android_brand_mvp/landscape/message/AnnouncementListFragment$PosterAdapter;", MqttServiceConstants.MESSAGE_ID, "pagTotal", "getPagTotal", "setPagTotal", "pageNo", "getPageNo", "setPageNo", "pageSize", "getPageSize", "setPageSize", "requestType", "searchKey", "selectEndTime", "Ljava/util/Date;", "selectStartTime", "startDate", "timeView", "Lcom/bigkoo/pickerview/view/TimePickerView;", "viewDocumentModel", "Lcom/yd/android_brand_mvp/landscape/message/viewmodel/MessageViewModel;", "getViewDocumentModel", "()Lcom/yd/android_brand_mvp/landscape/message/viewmodel/MessageViewModel;", "viewDocumentModel$delegate", "Lkotlin/Lazy;", "viewModel", "Lcom/yd/android_brand_mvp/landscape/message/viewmodel/MessageHomeNewViewModel;", "getViewModel", "()Lcom/yd/android_brand_mvp/landscape/message/viewmodel/MessageHomeNewViewModel;", "viewModel$delegate", "initTimeSelectView", "", "type", "", "initView", "initViewModel", "loadWebView", "url", "onClick", "v", "Landroid/view/View;", "onViewCreated", "view", "savedInstanceState", "Landroid/os/Bundle;", "requestList", "setSelectPosition", "setTextView", "setTextViewColor", "setView", "dataBean", "Lcom/yd/android_brand_mvp/model/MessageItemBean;", "PosterAdapter", "app_commonRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class AnnouncementListFragment extends KTBaseFragment<FragmentAnnouncementListBinding> implements View.OnClickListener {
    private AnnouncementListAdapter adapter;
    private int currentClickType;
    private final BaseBindingAdapter<ItemMessageDocumentBinding, DocumentBean> docAdapter;
    private String endDate;
    private int index;
    private int layout;
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

    /* JADX INFO: renamed from: viewDocumentModel$delegate, reason: from kotlin metadata */
    private final Lazy viewDocumentModel;

    /* JADX INFO: renamed from: viewModel$delegate, reason: from kotlin metadata */
    private final Lazy viewModel;

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean initView$lambda$1(View view) {
        return true;
    }

    /* JADX INFO: renamed from: com.yd.android_brand_mvp.landscape.message.AnnouncementListFragment$1, reason: invalid class name */
    /* JADX INFO: compiled from: AnnouncementListFragment.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements Function3<LayoutInflater, ViewGroup, Boolean, FragmentAnnouncementListBinding> {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        AnonymousClass1() {
            super(3, FragmentAnnouncementListBinding.class, "inflate", "inflate(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Z)Lcom/yd/android_brand_mvp/databinding/FragmentAnnouncementListBinding;", 0);
        }

        public final FragmentAnnouncementListBinding invoke(LayoutInflater p0, ViewGroup viewGroup, boolean z) {
            Intrinsics.checkNotNullParameter(p0, "p0");
            return FragmentAnnouncementListBinding.inflate(p0, viewGroup, z);
        }

        @Override // kotlin.jvm.functions.Function3
        public /* bridge */ /* synthetic */ FragmentAnnouncementListBinding invoke(LayoutInflater layoutInflater, ViewGroup viewGroup, Boolean bool) {
            return invoke(layoutInflater, viewGroup, bool.booleanValue());
        }
    }

    public AnnouncementListFragment() {
        super(AnonymousClass1.INSTANCE);
        final Function0 function0 = null;
        this.adapter = new AnnouncementListAdapter(null);
        this.pageNo = 1;
        this.pageSize = 20;
        this.requestType = AnnouncementListActivity.TYPE_ANNOUNCEMENT;
        this.searchKey = "";
        this.startDate = "";
        this.endDate = "";
        this.messageId = "";
        final AnnouncementListFragment announcementListFragment = this;
        final Function0<Fragment> function1 = new Function0<Fragment>() { // from class: com.yd.android_brand_mvp.landscape.message.AnnouncementListFragment$special$$inlined$viewModels$default$1
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Fragment invoke() {
                return announcementListFragment;
            }
        };
        final Lazy lazy = LazyKt.lazy(LazyThreadSafetyMode.NONE, (Function0) new Function0<ViewModelStoreOwner>() { // from class: com.yd.android_brand_mvp.landscape.message.AnnouncementListFragment$special$$inlined$viewModels$default$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelStoreOwner invoke() {
                return (ViewModelStoreOwner) function1.invoke();
            }
        });
        this.viewModel = FragmentViewModelLazyKt.createViewModelLazy(announcementListFragment, Reflection.getOrCreateKotlinClass(MessageHomeNewViewModel.class), new Function0<ViewModelStore>() { // from class: com.yd.android_brand_mvp.landscape.message.AnnouncementListFragment$special$$inlined$viewModels$default$3
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
        }, new Function0<CreationExtras>() { // from class: com.yd.android_brand_mvp.landscape.message.AnnouncementListFragment$special$$inlined$viewModels$default$4
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final CreationExtras invoke() {
                CreationExtras creationExtras;
                Function0 function2 = function0;
                if (function2 != null && (creationExtras = (CreationExtras) function2.invoke()) != null) {
                    return creationExtras;
                }
                ViewModelStoreOwner viewModelStoreOwnerM19viewModels$lambda1 = FragmentViewModelLazyKt.m19viewModels$lambda1(lazy);
                HasDefaultViewModelProviderFactory hasDefaultViewModelProviderFactory = viewModelStoreOwnerM19viewModels$lambda1 instanceof HasDefaultViewModelProviderFactory ? (HasDefaultViewModelProviderFactory) viewModelStoreOwnerM19viewModels$lambda1 : null;
                CreationExtras defaultViewModelCreationExtras = hasDefaultViewModelProviderFactory != null ? hasDefaultViewModelProviderFactory.getDefaultViewModelCreationExtras() : null;
                return defaultViewModelCreationExtras == null ? CreationExtras.Empty.INSTANCE : defaultViewModelCreationExtras;
            }
        }, new Function0<ViewModelProvider.Factory>() { // from class: com.yd.android_brand_mvp.landscape.message.AnnouncementListFragment$special$$inlined$viewModels$default$5
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
                    defaultViewModelProviderFactory = announcementListFragment.getDefaultViewModelProviderFactory();
                }
                Intrinsics.checkNotNullExpressionValue(defaultViewModelProviderFactory, "(owner as? HasDefaultVie…tViewModelProviderFactory");
                return defaultViewModelProviderFactory;
            }
        });
        final Function0<Fragment> function2 = new Function0<Fragment>() { // from class: com.yd.android_brand_mvp.landscape.message.AnnouncementListFragment$special$$inlined$viewModels$default$6
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Fragment invoke() {
                return announcementListFragment;
            }
        };
        final Lazy lazy2 = LazyKt.lazy(LazyThreadSafetyMode.NONE, (Function0) new Function0<ViewModelStoreOwner>() { // from class: com.yd.android_brand_mvp.landscape.message.AnnouncementListFragment$special$$inlined$viewModels$default$7
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelStoreOwner invoke() {
                return (ViewModelStoreOwner) function2.invoke();
            }
        });
        this.viewDocumentModel = FragmentViewModelLazyKt.createViewModelLazy(announcementListFragment, Reflection.getOrCreateKotlinClass(MessageViewModel.class), new Function0<ViewModelStore>() { // from class: com.yd.android_brand_mvp.landscape.message.AnnouncementListFragment$special$$inlined$viewModels$default$8
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelStore invoke() {
                ViewModelStore viewModelStore = FragmentViewModelLazyKt.m19viewModels$lambda1(lazy2).getViewModelStore();
                Intrinsics.checkNotNullExpressionValue(viewModelStore, "owner.viewModelStore");
                return viewModelStore;
            }
        }, new Function0<CreationExtras>() { // from class: com.yd.android_brand_mvp.landscape.message.AnnouncementListFragment$special$$inlined$viewModels$default$9
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final CreationExtras invoke() {
                CreationExtras creationExtras;
                Function0 function3 = function0;
                if (function3 != null && (creationExtras = (CreationExtras) function3.invoke()) != null) {
                    return creationExtras;
                }
                ViewModelStoreOwner viewModelStoreOwnerM19viewModels$lambda1 = FragmentViewModelLazyKt.m19viewModels$lambda1(lazy2);
                HasDefaultViewModelProviderFactory hasDefaultViewModelProviderFactory = viewModelStoreOwnerM19viewModels$lambda1 instanceof HasDefaultViewModelProviderFactory ? (HasDefaultViewModelProviderFactory) viewModelStoreOwnerM19viewModels$lambda1 : null;
                CreationExtras defaultViewModelCreationExtras = hasDefaultViewModelProviderFactory != null ? hasDefaultViewModelProviderFactory.getDefaultViewModelCreationExtras() : null;
                return defaultViewModelCreationExtras == null ? CreationExtras.Empty.INSTANCE : defaultViewModelCreationExtras;
            }
        }, new Function0<ViewModelProvider.Factory>() { // from class: com.yd.android_brand_mvp.landscape.message.AnnouncementListFragment$special$$inlined$viewModels$default$10
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelProvider.Factory invoke() {
                ViewModelProvider.Factory defaultViewModelProviderFactory;
                ViewModelStoreOwner viewModelStoreOwnerM19viewModels$lambda1 = FragmentViewModelLazyKt.m19viewModels$lambda1(lazy2);
                HasDefaultViewModelProviderFactory hasDefaultViewModelProviderFactory = viewModelStoreOwnerM19viewModels$lambda1 instanceof HasDefaultViewModelProviderFactory ? (HasDefaultViewModelProviderFactory) viewModelStoreOwnerM19viewModels$lambda1 : null;
                if (hasDefaultViewModelProviderFactory == null || (defaultViewModelProviderFactory = hasDefaultViewModelProviderFactory.getDefaultViewModelProviderFactory()) == null) {
                    defaultViewModelProviderFactory = announcementListFragment.getDefaultViewModelProviderFactory();
                }
                Intrinsics.checkNotNullExpressionValue(defaultViewModelProviderFactory, "(owner as? HasDefaultVie…tViewModelProviderFactory");
                return defaultViewModelProviderFactory;
            }
        });
        this.docAdapter = new BaseBindingAdapter<ItemMessageDocumentBinding, DocumentBean>() { // from class: com.yd.android_brand_mvp.landscape.message.AnnouncementListFragment$docAdapter$1
            @Override // com.yd.android_brand_mvp.base.BaseBindingAdapter
            public /* bridge */ /* synthetic */ void convertPlus(VBViewHolder vBViewHolder, DocumentBean documentBean) {
                convertPlus2((VBViewHolder<ItemMessageDocumentBinding>) vBViewHolder, documentBean);
            }

            @Override // com.yd.android_brand_mvp.base.BaseBindingAdapter
            public ItemMessageDocumentBinding createViewBinding(LayoutInflater inflater, ViewGroup parent) {
                Intrinsics.checkNotNullParameter(inflater, "inflater");
                Intrinsics.checkNotNullParameter(parent, "parent");
                ItemMessageDocumentBinding itemMessageDocumentBindingInflate = ItemMessageDocumentBinding.inflate(inflater, parent, false);
                Intrinsics.checkNotNullExpressionValue(itemMessageDocumentBindingInflate, "inflate(inflater, parent, false)");
                return itemMessageDocumentBindingInflate;
            }

            /* JADX INFO: renamed from: convertPlus, reason: avoid collision after fix types in other method */
            public void convertPlus2(VBViewHolder<ItemMessageDocumentBinding> holder, DocumentBean item) {
                Intrinsics.checkNotNullParameter(holder, "holder");
                Intrinsics.checkNotNullParameter(item, "item");
                ItemMessageDocumentBinding itemMessageDocumentBinding = (ItemMessageDocumentBinding) holder.getBinding();
                if (itemMessageDocumentBinding != null) {
                    itemMessageDocumentBinding.tvItemMessageDocument.setText(item.getName());
                }
            }
        };
        this.mPosterAdapter = new PosterAdapter(R.layout.item_message_poster_detail);
    }

    public static final /* synthetic */ FragmentAnnouncementListBinding access$getBinding(AnnouncementListFragment announcementListFragment) {
        return announcementListFragment.getBinding();
    }

    public final AnnouncementListAdapter getAdapter() {
        return this.adapter;
    }

    public final void setAdapter(AnnouncementListAdapter announcementListAdapter) {
        Intrinsics.checkNotNullParameter(announcementListAdapter, "<set-?>");
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

    private final MessageViewModel getViewDocumentModel() {
        return (MessageViewModel) this.viewDocumentModel.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void setView(MessageItemBean dataBean) {
        MessageReceiveBean messageReceiveBean;
        if (dataBean != null) {
            getBinding().llContent.setVisibility(0);
            getBinding().layoutContent.tvAnnTitle.setText(dataBean.getTitle());
            getBinding().layoutContent.tvIssueName.setText(dataBean.getIdentityUserName());
            getBinding().layoutContent.tvIssueTime.setText(DateUtils.formatTime(dataBean.getTimerDate(), "yyyy-MM-dd HH:mm:ss", "yyyy-MM-dd HH:mm"));
            getBinding().layoutContent.clActivityMessageContentReceiveResume.setVisibility(8);
            if (dataBean.getMessType() == 3 && (messageReceiveBean = (MessageReceiveBean) GsonUtils.fromJson(dataBean.getMessJson(), MessageReceiveBean.class)) != null) {
                getBinding().layoutContent.clActivityMessageContentReceiveResume.setVisibility(0);
                getBinding().layoutContent.tvActivityMessageContentReceiveResumeAddress.setText(messageReceiveBean.getLossLocation());
                getBinding().layoutContent.tvActivityMessageContentReceiveResumeContact.setText(messageReceiveBean.getContactPerson());
                getBinding().layoutContent.tvActivityMessageContentReceiveResumePhone.setText(messageReceiveBean.getContactPhone());
                getBinding().layoutContent.tvActivityMessageContentReceiveResumeThing.setText(messageReceiveBean.getLossItems());
                getBinding().layoutContent.tvActivityMessageContentReceiveResumeTime.setText(TimeUtil.stampToDate8(messageReceiveBean.getLossTime()));
            }
            if (dataBean.getAttachments() != null && (!dataBean.getAttachments().isEmpty())) {
                int size = dataBean.getAttachments().size();
                for (int i = 0; i < size; i++) {
                    DocumentBean documentBean = dataBean.getAttachments().get(i);
                    documentBean.setSuffix(TransUtils.INSTANCE.getFileTypeByName(documentBean.getName()));
                }
                this.docAdapter.setList(dataBean.getAttachments());
            } else {
                this.docAdapter.setList(null);
            }
            if (dataBean.getContentType() == 0) {
                if (dataBean.getMessType() == 6) {
                    getBinding().layoutContent.tvAnnTitle.setVisibility(8);
                    getBinding().layoutContent.msglayout.setVisibility(8);
                    getBinding().layoutContent.img.setVisibility(0);
                    getBinding().layoutContent.webView.setVisibility(8);
                    GlideUtil.loadNomalImage(this.mActivity, dataBean.getContentImg(), getBinding().layoutContent.img);
                } else {
                    loadWebView(dataBean.getContent());
                    getBinding().layoutContent.img.setVisibility(8);
                    getBinding().layoutContent.webView.setVerticalScrollBarEnabled(false);
                    getBinding().layoutContent.webView.setVisibility(0);
                    getBinding().layoutContent.msglayout.setVisibility(0);
                    getBinding().layoutContent.tvAnnTitle.setVisibility(0);
                }
            } else {
                getBinding().layoutContent.tvAnnTitle.setVisibility(8);
                getBinding().layoutContent.msglayout.setVisibility(8);
                getBinding().layoutContent.img.setVisibility(0);
                getBinding().layoutContent.webView.setVisibility(8);
                List<MessageDetail> details = dataBean.getDetails();
                if (details != null && (!details.isEmpty())) {
                    if (ScreenUtils.isLandscape() && details.size() > 1) {
                        GlideUtil.loadNomalImage(this.mActivity, details.get(1).getCoverImg(), getBinding().layoutContent.img);
                    } else {
                        GlideUtil.loadNomalImage(this.mActivity, details.get(0).getCoverImg(), getBinding().layoutContent.img);
                    }
                }
            }
            TextView textView = getBinding().layoutContent.tvCount;
            StringBuilder sb = new StringBuilder();
            sb.append(this.index + 1);
            sb.append('/');
            sb.append(this.pagTotal);
            textView.setText(sb.toString());
            this.adapter.setIndex(this.index);
            return;
        }
        getBinding().llContent.setVisibility(4);
    }

    private final void loadWebView(String url) {
        getBinding().layoutContent.webView.loadDataWithBaseURL(null, StringUtils.formatHtmlData(url), "text/html", "utf-8", null);
    }

    @Override // com.yd.android_brand_mvp.base.KTBaseFragment, com.yd.android_brand_mvp.base.BaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        String string = requireArguments().getString("type");
        this.messageId = requireArguments().getString("id");
        if (!TextUtils.isEmpty(string)) {
            this.requestType = string;
        }
        getBinding().mu.setViewState(2);
        getBinding().llContent.setVisibility(8);
        initView();
        getBinding().layoutPoster.getRoot().setVisibility(8);
        initViewModel();
        requestList();
    }

    private final void requestList() {
        showProgressDialog();
        MessageHomeNewViewModel viewModel = getViewModel();
        String str = this.searchKey;
        String str2 = this.requestType;
        Intrinsics.checkNotNull(str2);
        viewModel.requestMessageHome(str, str2, this.pageNo, this.pageSize, this.startDate, this.endDate);
    }

    private final void initView() {
        getBinding().layoutContent.webView.setWebViewClient(new WebViewClient() { // from class: com.yd.android_brand_mvp.landscape.message.AnnouncementListFragment.initView.1
            @Override // android.webkit.WebViewClient
            public void onPageFinished(WebView view, String url) {
                Intrinsics.checkNotNullParameter(view, "view");
                Intrinsics.checkNotNullParameter(url, "url");
                super.onPageFinished(view, url);
            }
        });
        getBinding().layoutContent.webView.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.yd.android_brand_mvp.landscape.message.-$$Lambda$AnnouncementListFragment$9NO5AIuoCNssrz_dfiVli2oOdvA
            @Override // android.view.View.OnLongClickListener
            public final boolean onLongClick(View view) {
                return AnnouncementListFragment.initView$lambda$1(view);
            }
        });
        getBinding().mu.setOnErrorClicklistener(new MultiStateView.OnErrorClicklistener() { // from class: com.yd.android_brand_mvp.landscape.message.-$$Lambda$AnnouncementListFragment$kby5uhMJRqt7-g-bsMajCfb9RFw
            @Override // com.yd.android_brand_mvp.weight.MultiStateView.OnErrorClicklistener
            public final void reload() {
                AnnouncementListFragment.initView$lambda$2(this.f$0);
            }
        });
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        linearLayoutManager.setOrientation(1);
        getBinding().rvList.setLayoutManager(linearLayoutManager);
        getBinding().rvList.setAdapter(this.adapter);
        if (!ScreenUtils.isLandscape()) {
            this.adapter.setEmptyView(R.layout.layout_empty);
        }
        this.adapter.getLoadMoreModule().setOnLoadMoreListener(new OnLoadMoreListener() { // from class: com.yd.android_brand_mvp.landscape.message.-$$Lambda$AnnouncementListFragment$HepKe5YXBLV10iAL1IolSGBukD0
            @Override // com.chad.library.adapter.base.listener.OnLoadMoreListener
            public final void onLoadMore() {
                AnnouncementListFragment.initView$lambda$3(this.f$0);
            }
        });
        this.adapter.getLoadMoreModule().setAutoLoadMore(true);
        this.adapter.getLoadMoreModule().setEnableLoadMoreIfNotFullPage(false);
        this.adapter.setOnItemClickListener(new OnItemClickListener() { // from class: com.yd.android_brand_mvp.landscape.message.-$$Lambda$AnnouncementListFragment$78c_3QqvPXauQbYLQvAPUleJBk4
            @Override // com.chad.library.adapter.base.listener.OnItemClickListener
            public final void onItemClick(BaseQuickAdapter baseQuickAdapter, View view, int i) {
                AnnouncementListFragment.initView$lambda$4(this.f$0, baseQuickAdapter, view, i);
            }
        });
        getBinding().layoutContent.rvActivityMessageContentDoc.setLayoutManager(new LinearLayoutManager(requireContext()));
        getBinding().layoutContent.rvActivityMessageContentDoc.setAdapter(this.docAdapter);
        this.docAdapter.setOnItemClickListener(new OnItemClickListener() { // from class: com.yd.android_brand_mvp.landscape.message.-$$Lambda$AnnouncementListFragment$uqSeeWqZQcuFYKGzmUhZxEAtpnI
            @Override // com.chad.library.adapter.base.listener.OnItemClickListener
            public final void onItemClick(BaseQuickAdapter baseQuickAdapter, View view, int i) {
                AnnouncementListFragment.initView$lambda$5(this.f$0, baseQuickAdapter, view, i);
            }
        });
        LiveData<DownRepository.DownloadStatus> downloadState = getViewDocumentModel().getDownloadState();
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        final Function1<DownRepository.DownloadStatus, Unit> function1 = new Function1<DownRepository.DownloadStatus, Unit>() { // from class: com.yd.android_brand_mvp.landscape.message.AnnouncementListFragment.initView.7
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(DownRepository.DownloadStatus downloadStatus) {
                invoke2(downloadStatus);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(DownRepository.DownloadStatus downloadStatus) {
                AnnouncementListFragment.this.dismissProgressDialog();
                if ((downloadStatus instanceof DownRepository.DownloadStatus.Complete) || !(downloadStatus instanceof DownRepository.DownloadStatus.Error)) {
                    return;
                }
                DownRepository.DownloadStatus.Error error = (DownRepository.DownloadStatus.Error) downloadStatus;
                ToastUtil.showBottomView(AnnouncementListFragment.this.requireContext(), error.getThrowable().getMessage() != null ? error.getThrowable().getMessage() : "下载失败");
            }
        };
        downloadState.observe(viewLifecycleOwner, new Observer() { // from class: com.yd.android_brand_mvp.landscape.message.-$$Lambda$AnnouncementListFragment$KLu4ZAQ2x0D7zljaGu0qBTq2Z-Y
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                AnnouncementListFragment.initView$lambda$6(function1, obj);
            }
        });
        if (ScreenUtils.isLandscape()) {
            getBinding().layoutPoster.posterRecyclerView.setLayoutManager(new GridLayoutManager(getActivity(), 6));
        } else {
            getBinding().layoutPoster.posterRecyclerView.setLayoutManager(new GridLayoutManager(getActivity(), 3));
        }
        getBinding().layoutPoster.posterRecyclerView.setAdapter(this.mPosterAdapter);
        this.mPosterAdapter.setOnItemClickListener(new OnItemClickListener() { // from class: com.yd.android_brand_mvp.landscape.message.-$$Lambda$AnnouncementListFragment$ZDBJpA6BibzDUoR-sWjy9kHK0MQ
            @Override // com.chad.library.adapter.base.listener.OnItemClickListener
            public final void onItemClick(BaseQuickAdapter baseQuickAdapter, View view, int i) {
                AnnouncementListFragment.initView$lambda$8(this.f$0, baseQuickAdapter, view, i);
            }
        });
        initTimeSelectView(TransUtils.INSTANCE.getShowTimeTypeArray("YYYY-MM-DD"));
        AnnouncementListFragment announcementListFragment = this;
        getBinding().tvSearch.setOnClickListener(announcementListFragment);
        getBinding().tvReset.setOnClickListener(announcementListFragment);
        getBinding().tvStartTime.setOnClickListener(announcementListFragment);
        getBinding().tvEndTime.setOnClickListener(announcementListFragment);
        getBinding().layoutPoster.tvUpPage.setOnClickListener(announcementListFragment);
        getBinding().layoutPoster.tvNext.setOnClickListener(announcementListFragment);
        getBinding().layoutContent.tvPreviousRecord.setOnClickListener(announcementListFragment);
        getBinding().layoutContent.tvNextReference.setOnClickListener(announcementListFragment);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$2(AnnouncementListFragment this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.requestList();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$3(AnnouncementListFragment this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.pageNo++;
        this$0.adapter.getLoadMoreModule().setEnableLoadMore(true);
        this$0.requestList();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final void initView$lambda$4(AnnouncementListFragment this$0, BaseQuickAdapter baseQuickAdapter, View view, int i) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.index = i;
        this$0.adapter.setIndex(i);
        AnnouncementListAdapter announcementListAdapter = this$0.adapter;
        this$0.setView(announcementListAdapter != null ? (MessageItemBean) announcementListAdapter.getItem(i) : null);
        this$0.setTextViewColor();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$5(AnnouncementListFragment this$0, BaseQuickAdapter baseQuickAdapter, View view, int i) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        DocumentBean item = this$0.docAdapter.getItem(i);
        String attachment = item.getAttachment();
        Charset UTF_8 = StandardCharsets.UTF_8;
        Intrinsics.checkNotNullExpressionValue(UTF_8, "UTF_8");
        byte[] bytes = attachment.getBytes(UTF_8);
        Intrinsics.checkNotNullExpressionValue(bytes, "this as java.lang.String).getBytes(charset)");
        String strEncodeToString = Base64.encodeToString(bytes, 2);
        TBSWebViewActivity.Companion companion = TBSWebViewActivity.INSTANCE;
        Context contextRequireContext = this$0.requireContext();
        Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext()");
        companion.startGo(contextRequireContext, BaseConstant.HTTP_BROWSE_DOCUMENT + Uri.encode(strEncodeToString), item.getName(), "web");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$6(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$8(AnnouncementListFragment this$0, BaseQuickAdapter baseQuickAdapter, View view, int i) {
        String coverImg;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        MessageItemBean item = this$0.mPosterAdapter.getItem(i);
        List<MessageDetail> details = item.getDetails();
        String contentImg = "";
        if (details != null) {
            if (ScreenUtils.isLandscape()) {
                if (details.size() > 1) {
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

    /* JADX WARN: Code duplicated, block: B:10:0x0049  */
    /* JADX WARN: Multi-variable type inference failed */
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
            case R.id.tvNext /* 2131364048 */:
                int i = this.pageNo + 1;
                this.pageNo = i;
                int i2 = this.pagTotal;
                if (i > i2) {
                    this.pageNo = i2;
                }
                requestList();
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
                this.pageNo = 1;
                requestList();
                break;
            case R.id.tvSearch /* 2131364082 */:
                String string = getBinding().etSearchTitle.getText().toString();
                int length = string.length() - 1;
                int i3 = 0;
                boolean z = false;
                while (i3 <= length) {
                    boolean z2 = Intrinsics.compare((int) string.charAt(!z ? i3 : length), 32) <= 0;
                    if (z) {
                        if (!z2) {
                            this.searchKey = string.subSequence(i3, length + 1).toString();
                            getBinding().tvStartTime.getText().toString();
                            getBinding().tvEndTime.getText().toString();
                            this.pageNo = 1;
                            requestList();
                        } else {
                            length--;
                        }
                        break;
                    } else if (z2) {
                        i3++;
                    } else {
                        z = true;
                    }
                }
                this.searchKey = string.subSequence(i3, length + 1).toString();
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
            case R.id.tvUpPage /* 2131364115 */:
                int i4 = this.pageNo - 1;
                this.pageNo = i4;
                if (i4 <= 0) {
                    this.pageNo = 1;
                }
                requestList();
                break;
            case R.id.tv_next_reference /* 2131364666 */:
                this.index++;
                int itemCount = this.adapter.getItemCount();
                int i5 = this.index;
                if (itemCount > i5) {
                    setView((MessageItemBean) this.adapter.getItem(i5));
                    getBinding().layoutContent.tvNextReference.setTextColor(SkinCompatResources.getInstance().getColor(R.color.purple2));
                } else {
                    getBinding().layoutContent.tvNextReference.setTextColor(SkinCompatResources.getInstance().getColor(R.color.black9));
                    this.index = this.adapter.getItemCount();
                }
                getBinding().rvList.smoothScrollToPosition(this.index);
                setTextViewColor();
                break;
            case R.id.tv_previous_record /* 2131364684 */:
                int i6 = this.index - 1;
                this.index = i6;
                if (i6 >= 0) {
                    int itemCount2 = this.adapter.getItemCount();
                    int i7 = this.index;
                    if (itemCount2 < i7) {
                        setView((MessageItemBean) this.adapter.getItem(i7));
                        getBinding().layoutContent.tvPreviousRecord.setTextColor(SkinCompatResources.getInstance().getColor(R.color.purple2));
                    } else {
                        getBinding().layoutContent.tvPreviousRecord.setTextColor(SkinCompatResources.getInstance().getColor(R.color.black9));
                        this.index = 0;
                    }
                } else {
                    getBinding().layoutContent.tvPreviousRecord.setTextColor(SkinCompatResources.getInstance().getColor(R.color.black9));
                    this.index = 0;
                }
                getBinding().rvList.smoothScrollToPosition(this.index);
                setTextViewColor();
                break;
        }
    }

    private final void initTimeSelectView(boolean[] type) {
        Calendar calendar = Calendar.getInstance();
        Calendar calendar2 = Calendar.getInstance();
        calendar.set(LunarCalendar.MIN_YEAR, 0, 1);
        calendar2.set(2119, 11, 31);
        final String str = "yyyy-MM-dd";
        this.timeView = new TimePickerBuilder(requireContext(), new OnTimeSelectListener() { // from class: com.yd.android_brand_mvp.landscape.message.-$$Lambda$AnnouncementListFragment$o4bSASQbdsNHfs2fVEucI7-c304
            @Override // com.bigkoo.pickerview.listener.OnTimeSelectListener
            public final void onTimeSelect(Date date, View view) {
                AnnouncementListFragment.initTimeSelectView$lambda$10(this.f$0, str, date, view);
            }
        }).setDate(Calendar.getInstance()).setType(type).setRangDate(calendar, calendar2).setTextColorCenter(getResources().getColor(R.color.purple2)).setDividerColor(getResources().getColor(R.color.purple2)).setLabel("年", "月", "日", "时", "分", "秒").setLayoutRes(R.layout.time_select, new CustomListener() { // from class: com.yd.android_brand_mvp.landscape.message.-$$Lambda$AnnouncementListFragment$K-iW37-Fw3vTBWEpe7KBAwMrbQo
            @Override // com.bigkoo.pickerview.listener.CustomListener
            public final void customLayout(View view) {
                AnnouncementListFragment.initTimeSelectView$lambda$13(this.f$0, view);
            }
        }).isCenterLabel(false).isDialog(true).build();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initTimeSelectView$lambda$10(AnnouncementListFragment this$0, String timeFormat, Date date, View view) {
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
    public static final void initTimeSelectView$lambda$13(final AnnouncementListFragment this$0, View v) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(v, "v");
        Button button = (Button) v.findViewById(R.id.btnCancel);
        Button button2 = (Button) v.findViewById(R.id.btnSubmit);
        button.setOnClickListener(new View.OnClickListener() { // from class: com.yd.android_brand_mvp.landscape.message.-$$Lambda$AnnouncementListFragment$0z0DnQtZ5ETFQRZ2yMZfgmcW3o8
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                AnnouncementListFragment.initTimeSelectView$lambda$13$lambda$11(this.f$0, view);
            }
        });
        button2.setOnClickListener(new View.OnClickListener() { // from class: com.yd.android_brand_mvp.landscape.message.-$$Lambda$AnnouncementListFragment$sBVkFFcqUS0kL4QipdjJBhoOlxQ
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                AnnouncementListFragment.initTimeSelectView$lambda$13$lambda$12(this.f$0, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initTimeSelectView$lambda$13$lambda$11(AnnouncementListFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        TimePickerView timePickerView = this$0.timeView;
        Intrinsics.checkNotNull(timePickerView);
        timePickerView.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initTimeSelectView$lambda$13$lambda$12(AnnouncementListFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        TimePickerView timePickerView = this$0.timeView;
        Intrinsics.checkNotNull(timePickerView);
        timePickerView.returnData();
    }

    /* JADX INFO: compiled from: AnnouncementListFragment.kt */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0002\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\r\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0018\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u0002H\u0014¨\u0006\u000b"}, d2 = {"Lcom/yd/android_brand_mvp/landscape/message/AnnouncementListFragment$PosterAdapter;", "Lcom/chad/library/adapter/base/BaseQuickAdapter;", "Lcom/yd/android_brand_mvp/model/MessageItemBean;", "Lcom/chad/library/adapter/base/viewholder/BaseViewHolder;", "layoutResId", "", "(I)V", "convert", "", "holder", "item", "app_commonRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
    private static final class PosterAdapter extends BaseQuickAdapter<MessageItemBean, BaseViewHolder> {
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
                    List<MessageDetail> details2 = item.getDetails();
                    if (details2 != null) {
                        if (ScreenUtils.isLandscape()) {
                            if (details2.size() > 1) {
                                GlideUtil.loadImageRadius(getContext(), details2.get(1).getCoverImg(), imageView, -1, SizeUtils.dp2px(10.0f));
                                return;
                            }
                            return;
                        } else {
                            if (!details2.isEmpty()) {
                                GlideUtil.loadImageRadius(getContext(), details2.get(0).getCoverImg(), imageView, -1, SizeUtils.dp2px(10.0f));
                                return;
                            }
                            return;
                        }
                    }
                    return;
                }
            }
            GlideUtil.loadImageRadius(getContext(), item.getContentImg(), imageView, -1, SizeUtils.dp2px(10.0f));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initViewModel$lambda$14(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    public final void initViewModel() {
        SingleLiveEvent<Result<BasePageResponse<List<MessageItemBean>>>> messageListLiveData = getViewModel().getMessageListLiveData();
        FragmentActivity fragmentActivityRequireActivity = requireActivity();
        Intrinsics.checkNotNullExpressionValue(fragmentActivityRequireActivity, "requireActivity()");
        final Function1<Result<? extends BasePageResponse<List<MessageItemBean>>>, Unit> function1 = new Function1<Result<? extends BasePageResponse<List<MessageItemBean>>>, Unit>() { // from class: com.yd.android_brand_mvp.landscape.message.AnnouncementListFragment.initViewModel.1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Result<? extends BasePageResponse<List<MessageItemBean>>> result) {
                invoke2(result);
                return Unit.INSTANCE;
            }

            /* JADX WARN: Multi-variable type inference failed */
            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Result<? extends BasePageResponse<List<MessageItemBean>>> it2) {
                AnnouncementListFragment.this.dismissProgressDialog();
                Intrinsics.checkNotNullExpressionValue(it2, "it");
                if (Result.m598isSuccessimpl(it2.getValue())) {
                    Object value = it2.getValue();
                    if (Result.m597isFailureimpl(value)) {
                        value = null;
                    }
                    BasePageResponse basePageResponse = (BasePageResponse) value;
                    if (basePageResponse != null) {
                        AnnouncementListFragment announcementListFragment = AnnouncementListFragment.this;
                        if (basePageResponse.getList() != null && ((List) basePageResponse.getList()).size() > 0) {
                            if (Intrinsics.areEqual(announcementListFragment.requestType, AnnouncementListActivity.TYPE_POSTER)) {
                                if (basePageResponse.getTotal() > 0) {
                                    announcementListFragment.setPagTotal(PageUtils.INSTANCE.doCalculatePageNumber(18, Integer.valueOf(basePageResponse.getTotal())));
                                    if (announcementListFragment.getPagTotal() <= 0) {
                                        announcementListFragment.setPagTotal(1);
                                    }
                                    TextView textView = AnnouncementListFragment.access$getBinding(announcementListFragment).layoutPoster.tvPageNumber;
                                    StringBuilder sb = new StringBuilder();
                                    sb.append(announcementListFragment.getPageNo());
                                    sb.append('/');
                                    sb.append(announcementListFragment.getPagTotal());
                                    textView.setText(sb.toString());
                                }
                                AnnouncementListFragment.access$getBinding(announcementListFragment).layoutPoster.getRoot().setVisibility(0);
                                announcementListFragment.mPosterAdapter.setList((Collection) basePageResponse.getList());
                                AnnouncementListFragment.access$getBinding(announcementListFragment).viewLine.setVisibility(4);
                                AnnouncementListFragment.access$getBinding(announcementListFragment).llContent.setVisibility(8);
                                AnnouncementListFragment.access$getBinding(announcementListFragment).llContent.setVisibility(4);
                                announcementListFragment.setTextView();
                            } else {
                                announcementListFragment.setPagTotal(basePageResponse.getTotal());
                                TextView textView2 = AnnouncementListFragment.access$getBinding(announcementListFragment).tvNumber;
                                StringBuilder sb2 = new StringBuilder();
                                sb2.append((char) 20849);
                                sb2.append(basePageResponse.getTotal());
                                sb2.append((char) 26465);
                                textView2.setText(sb2.toString());
                                AnnouncementListFragment.access$getBinding(announcementListFragment).viewLine.setVisibility(0);
                                AnnouncementListFragment.access$getBinding(announcementListFragment).llContent.setVisibility(0);
                                AnnouncementListFragment.access$getBinding(announcementListFragment).layoutPoster.getRoot().setVisibility(8);
                                if (announcementListFragment.getPageNo() == 1) {
                                    announcementListFragment.getAdapter().setList((Collection) basePageResponse.getList());
                                } else {
                                    announcementListFragment.getAdapter().addData((Collection) basePageResponse.getList());
                                }
                                announcementListFragment.setIndex(announcementListFragment.setSelectPosition());
                                announcementListFragment.setView((MessageItemBean) announcementListFragment.getAdapter().getItem(announcementListFragment.getIndex()));
                            }
                            if (((List) basePageResponse.getList()).size() >= announcementListFragment.getPageSize()) {
                                announcementListFragment.getAdapter().getLoadMoreModule().loadMoreComplete();
                            } else {
                                BaseLoadMoreModule.loadMoreEnd$default(announcementListFragment.getAdapter().getLoadMoreModule(), false, 1, null);
                            }
                            announcementListFragment.setTextViewColor();
                            AnnouncementListFragment.access$getBinding(announcementListFragment).mu.setViewState(0);
                            return;
                        }
                        AnnouncementListFragment.access$getBinding(announcementListFragment).tvNumber.setText("");
                        announcementListFragment.mPosterAdapter.setList(null);
                        AnnouncementListFragment.access$getBinding(announcementListFragment).viewLine.setVisibility(8);
                        AnnouncementListFragment.access$getBinding(announcementListFragment).llContent.setVisibility(4);
                        announcementListFragment.getAdapter().setList(null);
                        announcementListFragment.setView(null);
                        AnnouncementListFragment.access$getBinding(announcementListFragment).mu.setViewState(2);
                    }
                }
            }
        };
        messageListLiveData.observe(fragmentActivityRequireActivity, new Observer() { // from class: com.yd.android_brand_mvp.landscape.message.-$$Lambda$AnnouncementListFragment$gw5SXbyk3ODWORXlGu_k9BwEvg4
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                AnnouncementListFragment.initViewModel$lambda$14(function1, obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final int setSelectPosition() {
        int i = 0;
        int i2 = 0;
        for (Object obj : this.adapter.getData()) {
            int i3 = i2 + 1;
            if (i2 < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            if (Intrinsics.areEqual(this.messageId, ((MessageItemBean) obj).getId())) {
                i = i2;
            }
            i2 = i3;
        }
        return i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void setTextView() {
        if (this.pageNo == 1) {
            getBinding().layoutPoster.tvUpPage.setClickable(false);
            getBinding().layoutPoster.tvUpPage.setTextColor(SkinCompatResources.getInstance().getColor(R.color.black9));
        } else {
            getBinding().layoutPoster.tvUpPage.setClickable(true);
            getBinding().layoutPoster.tvUpPage.setTextColor(SkinCompatResources.getInstance().getColor(R.color.purple2));
        }
        if (this.pagTotal > 1) {
            getBinding().layoutPoster.tvNext.setClickable(true);
            getBinding().layoutPoster.tvNext.setTextColor(SkinCompatResources.getInstance().getColor(R.color.purple2));
        } else {
            getBinding().layoutPoster.tvNext.setClickable(false);
            getBinding().layoutPoster.tvNext.setTextColor(SkinCompatResources.getInstance().getColor(R.color.black9));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void setTextViewColor() {
        if (this.index > 0) {
            getBinding().layoutContent.tvPreviousRecord.setTextColor(SkinCompatResources.getInstance().getColor(R.color.purple2));
        } else {
            getBinding().layoutContent.tvPreviousRecord.setTextColor(SkinCompatResources.getInstance().getColor(R.color.black9));
        }
        if (this.adapter.getItemCount() > 1 && this.index < this.adapter.getItemCount()) {
            getBinding().layoutContent.tvNextReference.setTextColor(SkinCompatResources.getInstance().getColor(R.color.purple2));
        } else {
            getBinding().layoutContent.tvNextReference.setTextColor(SkinCompatResources.getInstance().getColor(R.color.black9));
        }
    }
}
