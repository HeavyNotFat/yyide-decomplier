package com.yd.android_brand_mvp.db;

import android.app.Activity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.listener.OnItemClickListener;
import com.tencent.qcloud.tim.uikit.modules.chat.base.ChatInfo;
import com.yd.android_brand_mvp.R;
import com.yd.android_brand_mvp.adapter.BookAddressAdapter;
import com.yd.android_brand_mvp.base.KTBaseFragment;
import com.yd.android_brand_mvp.databinding.FragmentAddressBookBinding;
import com.yd.android_brand_mvp.landscape.task.viewmodel.TaskDetailViewModel;
import com.yd.android_brand_mvp.model.selectNewStudentByIcCardRsp;
import com.yd.android_brand_mvp.model.task.AddressBookBean;
import com.yd.android_brand_mvp.utils.SpData;
import com.yd.android_brand_mvp.utils.ToastUtil;
import java.util.ArrayList;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import org.greenrobot.eventbus.EventBus;

/* JADX INFO: compiled from: AddressBookFragment.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 (2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001(B\u0005¢\u0006\u0002\u0010\u0003J\u0012\u0010\u001e\u001a\u00020\u001f2\b\u0010 \u001a\u0004\u0018\u00010!H\u0002J\b\u0010\"\u001a\u00020\u001fH\u0002J\u001a\u0010#\u001a\u00020\u001f2\u0006\u0010$\u001a\u00020%2\b\u0010&\u001a\u0004\u0018\u00010'H\u0016R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R \u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00100\u000fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R#\u0010\u0015\u001a\n \u0017*\u0004\u0018\u00010\u00160\u00168BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u0018\u0010\u0019R\u000e\u0010\u001c\u001a\u00020\u001dX\u0082.¢\u0006\u0002\n\u0000¨\u0006)"}, d2 = {"Lcom/yd/android_brand_mvp/db/AddressBookFragment;", "Lcom/yd/android_brand_mvp/base/KTBaseFragment;", "Lcom/yd/android_brand_mvp/databinding/FragmentAddressBookBinding;", "()V", "chatFragment3", "Lcom/yd/android_brand_mvp/db/ChatFragment3;", "getChatFragment3", "()Lcom/yd/android_brand_mvp/db/ChatFragment3;", "setChatFragment3", "(Lcom/yd/android_brand_mvp/db/ChatFragment3;)V", "isShowCurrent", "", "mBookAddressAdapter", "Lcom/yd/android_brand_mvp/adapter/BookAddressAdapter;", "mList", "", "Lcom/yd/android_brand_mvp/model/task/AddressBookBean;", "getMList", "()Ljava/util/List;", "setMList", "(Ljava/util/List;)V", "userInfo", "Lcom/yd/android_brand_mvp/model/selectNewStudentByIcCardRsp$DataBean;", "kotlin.jvm.PlatformType", "getUserInfo", "()Lcom/yd/android_brand_mvp/model/selectNewStudentByIcCardRsp$DataBean;", "userInfo$delegate", "Lkotlin/Lazy;", "viewModel", "Lcom/yd/android_brand_mvp/landscape/task/viewmodel/TaskDetailViewModel;", "addFragment", "", "chatInfo", "Lcom/tencent/qcloud/tim/uikit/modules/chat/base/ChatInfo;", "initView", "onViewCreated", "view", "Landroid/view/View;", "savedInstanceState", "Landroid/os/Bundle;", "Companion", "app_commonRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class AddressBookFragment extends KTBaseFragment<FragmentAddressBookBinding> {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private ChatFragment3 chatFragment3;
    private boolean isShowCurrent;
    private BookAddressAdapter mBookAddressAdapter;
    private List<AddressBookBean> mList;

    /* JADX INFO: renamed from: userInfo$delegate, reason: from kotlin metadata */
    private final Lazy userInfo;
    private TaskDetailViewModel viewModel;

    /* JADX INFO: renamed from: com.yd.android_brand_mvp.db.AddressBookFragment$1, reason: invalid class name */
    /* JADX INFO: compiled from: AddressBookFragment.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements Function3<LayoutInflater, ViewGroup, Boolean, FragmentAddressBookBinding> {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        AnonymousClass1() {
            super(3, FragmentAddressBookBinding.class, "inflate", "inflate(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Z)Lcom/yd/android_brand_mvp/databinding/FragmentAddressBookBinding;", 0);
        }

        public final FragmentAddressBookBinding invoke(LayoutInflater p0, ViewGroup viewGroup, boolean z) {
            Intrinsics.checkNotNullParameter(p0, "p0");
            return FragmentAddressBookBinding.inflate(p0, viewGroup, z);
        }

        @Override // kotlin.jvm.functions.Function3
        public /* bridge */ /* synthetic */ FragmentAddressBookBinding invoke(LayoutInflater layoutInflater, ViewGroup viewGroup, Boolean bool) {
            return invoke(layoutInflater, viewGroup, bool.booleanValue());
        }
    }

    public AddressBookFragment() {
        super(AnonymousClass1.INSTANCE);
        this.mList = new ArrayList();
        this.isShowCurrent = true;
        this.userInfo = LazyKt.lazy(new Function0<selectNewStudentByIcCardRsp.DataBean>() { // from class: com.yd.android_brand_mvp.db.AddressBookFragment$userInfo$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final selectNewStudentByIcCardRsp.DataBean invoke() {
                return SpData.USERCENTINFO2().data;
            }
        });
    }

    public final List<AddressBookBean> getMList() {
        return this.mList;
    }

    public final void setMList(List<AddressBookBean> list) {
        Intrinsics.checkNotNullParameter(list, "<set-?>");
        this.mList = list;
    }

    private final selectNewStudentByIcCardRsp.DataBean getUserInfo() {
        return (selectNewStudentByIcCardRsp.DataBean) this.userInfo.getValue();
    }

    /* JADX INFO: compiled from: AddressBookFragment.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0003\u001a\u00020\u0004¨\u0006\u0005"}, d2 = {"Lcom/yd/android_brand_mvp/db/AddressBookFragment$Companion;", "", "()V", "newInstance", "Lcom/yd/android_brand_mvp/db/AddressBookFragment;", "app_commonRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final AddressBookFragment newInstance() {
            return new AddressBookFragment();
        }
    }

    @Override // com.yd.android_brand_mvp.base.KTBaseFragment, com.yd.android_brand_mvp.base.BaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        initView();
    }

    private final void initView() {
        this.viewModel = (TaskDetailViewModel) new ViewModelProvider(this).get(TaskDetailViewModel.class);
        getBinding().recycler.setLayoutManager(new LinearLayoutManager(requireContext()));
        this.mBookAddressAdapter = new BookAddressAdapter();
        TaskDetailViewModel taskDetailViewModel = this.viewModel;
        TaskDetailViewModel taskDetailViewModel2 = null;
        if (taskDetailViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            taskDetailViewModel = null;
        }
        taskDetailViewModel.getAddressBookList(getUserInfo().id);
        getBinding().recycler.setAdapter(this.mBookAddressAdapter);
        TaskDetailViewModel taskDetailViewModel3 = this.viewModel;
        if (taskDetailViewModel3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        } else {
            taskDetailViewModel2 = taskDetailViewModel3;
        }
        LiveData<Result<List<AddressBookBean>>> addressDetail = taskDetailViewModel2.getAddressDetail();
        FragmentActivity fragmentActivityRequireActivity = requireActivity();
        final Function1<Result<? extends List<? extends AddressBookBean>>, Unit> function1 = new Function1<Result<? extends List<? extends AddressBookBean>>, Unit>() { // from class: com.yd.android_brand_mvp.db.AddressBookFragment.initView.1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Result<? extends List<? extends AddressBookBean>> result) {
                invoke2(result);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Result<? extends List<? extends AddressBookBean>> result) {
                String message;
                if (result == null) {
                    return;
                }
                if (Result.m598isSuccessimpl(result.getValue())) {
                    AddressBookFragment.this.getMList().clear();
                    Object objM600unboximpl = result.getValue();
                    if (Result.m597isFailureimpl(objM600unboximpl)) {
                        objM600unboximpl = null;
                    }
                    List list = (List) objM600unboximpl;
                    if (list == null) {
                        return;
                    }
                    AddressBookFragment.this.getMList().addAll(list);
                    BookAddressAdapter bookAddressAdapter = AddressBookFragment.this.mBookAddressAdapter;
                    Intrinsics.checkNotNull(bookAddressAdapter);
                    bookAddressAdapter.setList(AddressBookFragment.this.getMList());
                    return;
                }
                Activity activity = AddressBookFragment.this.mActivity;
                Throwable thM594exceptionOrNullimpl = Result.m594exceptionOrNullimpl(result.getValue());
                if (thM594exceptionOrNullimpl == null || (message = thM594exceptionOrNullimpl.getMessage()) == null) {
                    message = "获取失败";
                }
                ToastUtil.showBottomView(activity, message);
                BookAddressAdapter bookAddressAdapter2 = AddressBookFragment.this.mBookAddressAdapter;
                Intrinsics.checkNotNull(bookAddressAdapter2);
                bookAddressAdapter2.setEmptyView(R.layout.item_min_null_layout_2_2);
            }
        };
        addressDetail.observe(fragmentActivityRequireActivity, new Observer() { // from class: com.yd.android_brand_mvp.db.-$$Lambda$AddressBookFragment$ZlOakSIUg3Kf7tre8mADUWsDtc0
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                AddressBookFragment.initView$lambda$0(function1, obj);
            }
        });
        BookAddressAdapter bookAddressAdapter = this.mBookAddressAdapter;
        Intrinsics.checkNotNull(bookAddressAdapter);
        bookAddressAdapter.setOnItemClickListener(new OnItemClickListener() { // from class: com.yd.android_brand_mvp.db.-$$Lambda$AddressBookFragment$TKptXwMPIfzeFr_cP-oxDrlnvMU
            @Override // com.chad.library.adapter.base.listener.OnItemClickListener
            public final void onItemClick(BaseQuickAdapter baseQuickAdapter, View view, int i) {
                AddressBookFragment.initView$lambda$1(this.f$0, baseQuickAdapter, view, i);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$0(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$1(AddressBookFragment this$0, BaseQuickAdapter adapter, View view, int i) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(adapter, "adapter");
        Intrinsics.checkNotNullParameter(view, "view");
        ChatInfo chatInfo = new ChatInfo();
        chatInfo.setType(1);
        chatInfo.setId(this$0.mList.get(i).getId());
        String id = this$0.mList.get(i).getId();
        if (!TextUtils.isEmpty(this$0.mList.get(i).getName())) {
            id = this$0.mList.get(i).getName();
        } else if (!TextUtils.isEmpty(this$0.mList.get(i).getId())) {
            id = this$0.mList.get(i).getId();
        }
        chatInfo.setChatName(id);
        EventBus eventBus = EventBus.getDefault();
        int type = chatInfo.getType();
        String id2 = chatInfo.getId();
        Intrinsics.checkNotNullExpressionValue(id2, "chatInfo.id");
        String chatName = chatInfo.getChatName();
        Intrinsics.checkNotNullExpressionValue(chatName, "chatInfo.chatName");
        eventBus.post(new ChatEventBean(5, type, id2, chatName));
    }

    public final ChatFragment3 getChatFragment3() {
        return this.chatFragment3;
    }

    public final void setChatFragment3(ChatFragment3 chatFragment3) {
        this.chatFragment3 = chatFragment3;
    }

    private final void addFragment(ChatInfo chatInfo) {
        FragmentTransaction fragmentTransactionBeginTransaction = requireFragmentManager().beginTransaction();
        Intrinsics.checkNotNullExpressionValue(fragmentTransactionBeginTransaction, "requireFragmentManager().beginTransaction()");
        fragmentTransactionBeginTransaction.setTransition(4097);
        fragmentTransactionBeginTransaction.addToBackStack(null);
        if (this.chatFragment3 == null) {
            this.chatFragment3 = new ChatFragment3();
        }
        ChatFragment3 chatFragment3 = this.chatFragment3;
        Intrinsics.checkNotNull(chatFragment3);
        fragmentTransactionBeginTransaction.replace(R.id.content, chatFragment3);
        Bundle bundle = new Bundle();
        bundle.putSerializable("chatInfo", chatInfo);
        ChatFragment3 chatFragment4 = this.chatFragment3;
        Intrinsics.checkNotNull(chatFragment4);
        chatFragment4.setArguments(bundle);
        fragmentTransactionBeginTransaction.commit();
    }
}
