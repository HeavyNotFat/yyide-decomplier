package com.yd.android_brand_mvp.portrait.fragment;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Base64;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.HasDefaultViewModelProviderFactory;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.lifecycle.viewmodel.CreationExtras;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.listener.OnItemClickListener;
import com.yd.android_brand_mvp.activity.TBSWebViewActivity;
import com.yd.android_brand_mvp.base.BaseBindingAdapter;
import com.yd.android_brand_mvp.base.BaseConstant;
import com.yd.android_brand_mvp.base.KTBaseFragment;
import com.yd.android_brand_mvp.base.VBViewHolder;
import com.yd.android_brand_mvp.databinding.FragmentMessageListBinding;
import com.yd.android_brand_mvp.databinding.ItemMessageDocumentBinding;
import com.yd.android_brand_mvp.landscape.message.viewmodel.MessageViewModel;
import com.yd.android_brand_mvp.model.getNoticeRsp;
import com.yd.android_brand_mvp.model.message.DocumentBean;
import com.yd.android_brand_mvp.model.message.MessageReceiveBean;
import com.yd.android_brand_mvp.repository.DownRepository;
import com.yd.android_brand_mvp.utils.DateUtils;
import com.yd.android_brand_mvp.utils.GlideUtil;
import com.yd.android_brand_mvp.utils.SimpleUtilsKt;
import com.yd.android_brand_mvp.utils.StringUtils;
import com.yd.android_brand_mvp.utils.TimeUtil;
import com.yd.android_brand_mvp.utils.ToastUtil;
import com.yd.android_brand_mvp.utils.TransUtils;
import com.yd.android_brand_mvp.utils.view.net.GsonUtils;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: compiled from: MessageDetailsFragment.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \u00182\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0018B\u0005¢\u0006\u0002\u0010\u0003J\u0010\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0002J\u001a\u0010\u0012\u001a\u00020\u000f2\u0006\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0016J\b\u0010\u0017\u001a\u00020\u000fH\u0002R\u001a\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\b\u001a\u00020\t8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\n\u0010\u000b¨\u0006\u0019"}, d2 = {"Lcom/yd/android_brand_mvp/portrait/fragment/MessageDetailsFragment;", "Lcom/yd/android_brand_mvp/base/KTBaseFragment;", "Lcom/yd/android_brand_mvp/databinding/FragmentMessageListBinding;", "()V", "docAdapter", "Lcom/yd/android_brand_mvp/base/BaseBindingAdapter;", "Lcom/yd/android_brand_mvp/databinding/ItemMessageDocumentBinding;", "Lcom/yd/android_brand_mvp/model/message/DocumentBean;", "viewModel", "Lcom/yd/android_brand_mvp/landscape/message/viewmodel/MessageViewModel;", "getViewModel", "()Lcom/yd/android_brand_mvp/landscape/message/viewmodel/MessageViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "loadWebView", "", "url", "", "onViewCreated", "view", "Landroid/view/View;", "savedInstanceState", "Landroid/os/Bundle;", "setDataView", "Companion", "app_commonRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class MessageDetailsFragment extends KTBaseFragment<FragmentMessageListBinding> {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final BaseBindingAdapter<ItemMessageDocumentBinding, DocumentBean> docAdapter;

    /* JADX INFO: renamed from: viewModel$delegate, reason: from kotlin metadata */
    private final Lazy viewModel;

    /* JADX INFO: renamed from: com.yd.android_brand_mvp.portrait.fragment.MessageDetailsFragment$1, reason: invalid class name */
    /* JADX INFO: compiled from: MessageDetailsFragment.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements Function3<LayoutInflater, ViewGroup, Boolean, FragmentMessageListBinding> {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        AnonymousClass1() {
            super(3, FragmentMessageListBinding.class, "inflate", "inflate(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Z)Lcom/yd/android_brand_mvp/databinding/FragmentMessageListBinding;", 0);
        }

        public final FragmentMessageListBinding invoke(LayoutInflater p0, ViewGroup viewGroup, boolean z) {
            Intrinsics.checkNotNullParameter(p0, "p0");
            return FragmentMessageListBinding.inflate(p0, viewGroup, z);
        }

        @Override // kotlin.jvm.functions.Function3
        public /* bridge */ /* synthetic */ FragmentMessageListBinding invoke(LayoutInflater layoutInflater, ViewGroup viewGroup, Boolean bool) {
            return invoke(layoutInflater, viewGroup, bool.booleanValue());
        }
    }

    public MessageDetailsFragment() {
        super(AnonymousClass1.INSTANCE);
        final MessageDetailsFragment messageDetailsFragment = this;
        final Function0<Fragment> function0 = new Function0<Fragment>() { // from class: com.yd.android_brand_mvp.portrait.fragment.MessageDetailsFragment$special$$inlined$viewModels$default$1
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Fragment invoke() {
                return messageDetailsFragment;
            }
        };
        final Lazy lazy = LazyKt.lazy(LazyThreadSafetyMode.NONE, (Function0) new Function0<ViewModelStoreOwner>() { // from class: com.yd.android_brand_mvp.portrait.fragment.MessageDetailsFragment$special$$inlined$viewModels$default$2
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
        this.viewModel = FragmentViewModelLazyKt.createViewModelLazy(messageDetailsFragment, Reflection.getOrCreateKotlinClass(MessageViewModel.class), new Function0<ViewModelStore>() { // from class: com.yd.android_brand_mvp.portrait.fragment.MessageDetailsFragment$special$$inlined$viewModels$default$3
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
        }, new Function0<CreationExtras>() { // from class: com.yd.android_brand_mvp.portrait.fragment.MessageDetailsFragment$special$$inlined$viewModels$default$4
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
        }, new Function0<ViewModelProvider.Factory>() { // from class: com.yd.android_brand_mvp.portrait.fragment.MessageDetailsFragment$special$$inlined$viewModels$default$5
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
                    defaultViewModelProviderFactory = messageDetailsFragment.getDefaultViewModelProviderFactory();
                }
                Intrinsics.checkNotNullExpressionValue(defaultViewModelProviderFactory, "(owner as? HasDefaultVie…tViewModelProviderFactory");
                return defaultViewModelProviderFactory;
            }
        });
        this.docAdapter = new BaseBindingAdapter<ItemMessageDocumentBinding, DocumentBean>() { // from class: com.yd.android_brand_mvp.portrait.fragment.MessageDetailsFragment$docAdapter$1
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
                TextView textView = itemMessageDocumentBinding != null ? itemMessageDocumentBinding.tvItemMessageDocument : null;
                if (textView == null) {
                    return;
                }
                textView.setText(item.getName());
            }
        };
    }

    /* JADX INFO: compiled from: MessageDetailsFragment.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0003\u001a\u00020\u0004¨\u0006\u0005"}, d2 = {"Lcom/yd/android_brand_mvp/portrait/fragment/MessageDetailsFragment$Companion;", "", "()V", "newInstance", "Lcom/yd/android_brand_mvp/portrait/fragment/MessageDetailsFragment;", "app_commonRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final MessageDetailsFragment newInstance() {
            return new MessageDetailsFragment();
        }
    }

    private final MessageViewModel getViewModel() {
        return (MessageViewModel) this.viewModel.getValue();
    }

    @Override // com.yd.android_brand_mvp.base.KTBaseFragment, com.yd.android_brand_mvp.base.BaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        setDataView();
    }

    /* JADX WARN: Code duplicated, block: B:25:0x01a8  */
    private final void setDataView() {
        String stringExtra;
        Intent intent;
        FragmentActivity activity = getActivity();
        if (activity == null || (intent = activity.getIntent()) == null || (stringExtra = intent.getStringExtra("data")) == null) {
            stringExtra = "";
        }
        Log.i("MessageDetailsFragment", "data = " + stringExtra);
        getNoticeRsp.DataDTO.RecordsDTO recordsDTO = (getNoticeRsp.DataDTO.RecordsDTO) GsonUtils.fromJson(stringExtra, getNoticeRsp.DataDTO.RecordsDTO.class);
        RelativeLayout relativeLayout = getBinding().content.rlBt;
        Intrinsics.checkNotNullExpressionValue(relativeLayout, "binding.content.rlBt");
        SimpleUtilsKt.remove(relativeLayout);
        if (recordsDTO != null) {
            getBinding().content.tvAnnTitle.setText(recordsDTO.title);
            getBinding().content.tvIssueName.setText(recordsDTO.identityUserName);
            getBinding().content.tvIssueTime.setText(DateUtils.formatTime(recordsDTO.timerDate, "yyyy-MM-dd HH:mm:ss", "yyyy-MM-dd HH:mm"));
            if (recordsDTO.messType == 3) {
                MessageReceiveBean messageReceiveBean = (MessageReceiveBean) GsonUtils.fromJson(recordsDTO.messJson, MessageReceiveBean.class);
                if (messageReceiveBean != null) {
                    ConstraintLayout constraintLayout = getBinding().content.clActivityMessageContentReceiveResume;
                    Intrinsics.checkNotNullExpressionValue(constraintLayout, "binding.content.clActivi…ssageContentReceiveResume");
                    SimpleUtilsKt.show(constraintLayout);
                    getBinding().content.tvActivityMessageContentReceiveResumeAddress.setText(messageReceiveBean.getLossLocation());
                    getBinding().content.tvActivityMessageContentReceiveResumeContact.setText(messageReceiveBean.getContactPerson());
                    getBinding().content.tvActivityMessageContentReceiveResumePhone.setText(messageReceiveBean.getContactPhone());
                    getBinding().content.tvActivityMessageContentReceiveResumeThing.setText(messageReceiveBean.getLossItems());
                    getBinding().content.tvActivityMessageContentReceiveResumeTime.setText(TimeUtil.stampToDate8(messageReceiveBean.getLossTime()));
                }
            } else {
                ConstraintLayout constraintLayout2 = getBinding().content.clActivityMessageContentReceiveResume;
                Intrinsics.checkNotNullExpressionValue(constraintLayout2, "binding.content.clActivi…ssageContentReceiveResume");
                SimpleUtilsKt.remove(constraintLayout2);
            }
            getBinding().content.rvActivityMessageContentDoc.setLayoutManager(new LinearLayoutManager(requireContext()));
            getBinding().content.rvActivityMessageContentDoc.setAdapter(this.docAdapter);
            this.docAdapter.setOnItemClickListener(new OnItemClickListener() { // from class: com.yd.android_brand_mvp.portrait.fragment.-$$Lambda$MessageDetailsFragment$3YYSamlo8XVJW_aqLJY-TvFpQh4
                @Override // com.chad.library.adapter.base.listener.OnItemClickListener
                public final void onItemClick(BaseQuickAdapter baseQuickAdapter, View view, int i) {
                    MessageDetailsFragment.setDataView$lambda$0(this.f$0, baseQuickAdapter, view, i);
                }
            });
            getViewModel().getDownloadState().observe(getViewLifecycleOwner(), new Observer() { // from class: com.yd.android_brand_mvp.portrait.fragment.-$$Lambda$MessageDetailsFragment$rwk4Lti5lB44yasrRpwfDjeN0Cs
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    MessageDetailsFragment.setDataView$lambda$1(this.f$0, (DownRepository.DownloadStatus) obj);
                }
            });
            if (recordsDTO.attachments != null) {
                List<DocumentBean> list = recordsDTO.attachments;
                Intrinsics.checkNotNullExpressionValue(list, "dataBean.attachments");
                if (!list.isEmpty()) {
                    int size = recordsDTO.attachments.size();
                    for (int i = 0; i < size; i++) {
                        DocumentBean documentBean = recordsDTO.attachments.get(i);
                        documentBean.setSuffix(TransUtils.INSTANCE.getFileTypeByName(documentBean.getName()));
                    }
                    this.docAdapter.setList(recordsDTO.attachments);
                } else {
                    this.docAdapter.setList(null);
                }
            } else {
                this.docAdapter.setList(null);
            }
            if (recordsDTO.contentType == 0) {
                if (recordsDTO.messType == 6) {
                    getBinding().content.tvAnnTitle.setVisibility(8);
                    getBinding().content.msglayout.setVisibility(8);
                    getBinding().content.img.setVisibility(0);
                    getBinding().content.webView.setVisibility(8);
                    GlideUtil.loadNomalImage(this.mActivity, recordsDTO.contentImg, getBinding().content.img);
                    return;
                }
                String str = recordsDTO.content;
                Intrinsics.checkNotNullExpressionValue(str, "dataBean.content");
                loadWebView(str);
                getBinding().content.img.setVisibility(8);
                getBinding().content.webView.setVerticalScrollBarEnabled(false);
                getBinding().content.webView.setVisibility(0);
                getBinding().content.msglayout.setVisibility(0);
                getBinding().content.tvAnnTitle.setVisibility(0);
                return;
            }
            getBinding().content.tvAnnTitle.setVisibility(8);
            getBinding().content.msglayout.setVisibility(8);
            getBinding().content.img.setVisibility(0);
            getBinding().content.webView.setVisibility(8);
            GlideUtil.loadNomalImage(this.mActivity, recordsDTO.details.get(0).coverImg, getBinding().content.img);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setDataView$lambda$0(MessageDetailsFragment this$0, BaseQuickAdapter baseQuickAdapter, View view, int i) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        DocumentBean item = this$0.docAdapter.getItem(i);
        String attachment = item.getAttachment();
        Charset UTF_8 = StandardCharsets.UTF_8;
        Intrinsics.checkNotNullExpressionValue(UTF_8, "UTF_8");
        byte[] bytes = attachment.getBytes(UTF_8);
        Intrinsics.checkNotNullExpressionValue(bytes, "this as java.lang.String).getBytes(charset)");
        String strEncodeToString = Base64.encodeToString(bytes, 2);
        Intrinsics.checkNotNullExpressionValue(strEncodeToString, "encodeToString(item.atta…s.UTF_8), Base64.NO_WRAP)");
        TBSWebViewActivity.Companion companion = TBSWebViewActivity.INSTANCE;
        Context contextRequireContext = this$0.requireContext();
        Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext()");
        companion.startGo(contextRequireContext, BaseConstant.HTTP_BROWSE_DOCUMENT + Uri.encode(strEncodeToString), item.getName(), "web");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setDataView$lambda$1(MessageDetailsFragment this$0, DownRepository.DownloadStatus downloadStatus) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.dismissProgressDialog();
        if ((downloadStatus instanceof DownRepository.DownloadStatus.Complete) || !(downloadStatus instanceof DownRepository.DownloadStatus.Error)) {
            return;
        }
        DownRepository.DownloadStatus.Error error = (DownRepository.DownloadStatus.Error) downloadStatus;
        ToastUtil.showBottomView(this$0.requireContext(), error.getThrowable().getMessage() != null ? error.getThrowable().getMessage() : "下载失败");
    }

    private final void loadWebView(String url) {
        getBinding().content.webView.loadDataWithBaseURL(null, StringUtils.formatHtmlData(url), "text/html", "utf-8", null);
    }
}
