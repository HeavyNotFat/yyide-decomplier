package com.yd.android_brand_mvp.landscape.exam.comments;

import android.app.Activity;
import android.os.Bundle;
import android.text.Html;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import com.yd.android_brand_mvp.R;
import com.yd.android_brand_mvp.base.KTBaseFragment;
import com.yd.android_brand_mvp.databinding.CommentsDetailFragmentBinding;
import com.yd.android_brand_mvp.dialog.MessageTipDialog;
import com.yd.android_brand_mvp.model.comments.CommentsDetailBean;
import com.yd.android_brand_mvp.utils.GlideUtil;
import com.yd.android_brand_mvp.utils.ToastUtil;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: CommentsDetailFragment.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \u00152\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0002\u0014\u0015B\u0005¢\u0006\u0002\u0010\u0003J\b\u0010\n\u001a\u00020\u000bH\u0002J\b\u0010\f\u001a\u00020\u000bH\u0002J\u0012\u0010\r\u001a\u00020\u000b2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0016J\u0010\u0010\u0010\u001a\u00020\u000b2\u0006\u0010\u0011\u001a\u00020\u0012H\u0002J\u000e\u0010\u0013\u001a\u00020\u000b2\u0006\u0010\u0006\u001a\u00020\u0007R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082.¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"Lcom/yd/android_brand_mvp/landscape/exam/comments/CommentsDetailFragment;", "Lcom/yd/android_brand_mvp/base/KTBaseFragment;", "Lcom/yd/android_brand_mvp/databinding/CommentsDetailFragmentBinding;", "()V", "id", "", "mCommentsListener", "Lcom/yd/android_brand_mvp/landscape/exam/comments/CommentsDetailFragment$CommentsListener;", "viewModel", "Lcom/yd/android_brand_mvp/landscape/exam/comments/CommentsViewModel;", "initModel", "", "initView", "onActivityCreated", "savedInstanceState", "Landroid/os/Bundle;", "setData", "item", "Lcom/yd/android_brand_mvp/model/comments/CommentsDetailBean;", "setOnCommentsListener", "CommentsListener", "Companion", "app_commonRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class CommentsDetailFragment extends KTBaseFragment<CommentsDetailFragmentBinding> {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final String TYPE_ID = "id";
    private String id;
    private CommentsListener mCommentsListener;
    private CommentsViewModel viewModel;

    /* JADX INFO: compiled from: CommentsDetailFragment.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0003H&¨\u0006\u0005"}, d2 = {"Lcom/yd/android_brand_mvp/landscape/exam/comments/CommentsDetailFragment$CommentsListener;", "", "onClose", "", "onRefresh", "app_commonRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public interface CommentsListener {
        void onClose();

        void onRefresh();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$1(View view) {
    }

    /* JADX INFO: renamed from: com.yd.android_brand_mvp.landscape.exam.comments.CommentsDetailFragment$1, reason: invalid class name */
    /* JADX INFO: compiled from: CommentsDetailFragment.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements Function3<LayoutInflater, ViewGroup, Boolean, CommentsDetailFragmentBinding> {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        AnonymousClass1() {
            super(3, CommentsDetailFragmentBinding.class, "inflate", "inflate(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Z)Lcom/yd/android_brand_mvp/databinding/CommentsDetailFragmentBinding;", 0);
        }

        public final CommentsDetailFragmentBinding invoke(LayoutInflater p0, ViewGroup viewGroup, boolean z) {
            Intrinsics.checkNotNullParameter(p0, "p0");
            return CommentsDetailFragmentBinding.inflate(p0, viewGroup, z);
        }

        @Override // kotlin.jvm.functions.Function3
        public /* bridge */ /* synthetic */ CommentsDetailFragmentBinding invoke(LayoutInflater layoutInflater, ViewGroup viewGroup, Boolean bool) {
            return invoke(layoutInflater, viewGroup, bool.booleanValue());
        }
    }

    public static final /* synthetic */ CommentsDetailFragmentBinding access$getBinding(CommentsDetailFragment commentsDetailFragment) {
        return commentsDetailFragment.getBinding();
    }

    public CommentsDetailFragment() {
        super(AnonymousClass1.INSTANCE);
        this.id = "";
    }

    /* JADX INFO: compiled from: CommentsDetailFragment.kt */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0004R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Lcom/yd/android_brand_mvp/landscape/exam/comments/CommentsDetailFragment$Companion;", "", "()V", "TYPE_ID", "", "newInstance", "Lcom/yd/android_brand_mvp/landscape/exam/comments/CommentsDetailFragment;", "id", "app_commonRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final CommentsDetailFragment newInstance(String id) {
            Intrinsics.checkNotNullParameter(id, "id");
            CommentsDetailFragment commentsDetailFragment = new CommentsDetailFragment();
            Bundle bundle = new Bundle();
            bundle.putString("id", id);
            commentsDetailFragment.setArguments(bundle);
            return commentsDetailFragment;
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        this.viewModel = (CommentsViewModel) new ViewModelProvider(this).get(CommentsViewModel.class);
        initView();
        initModel();
        getBinding().mu.setViewState(3);
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.id = String.valueOf(arguments.getString("id"));
            CommentsViewModel commentsViewModel = this.viewModel;
            if (commentsViewModel == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewModel");
                commentsViewModel = null;
            }
            commentsViewModel.commentsDetail(this.id);
        }
    }

    private final void initView() {
        getBinding().getRoot().setOnClickListener(new View.OnClickListener() { // from class: com.yd.android_brand_mvp.landscape.exam.comments.-$$Lambda$CommentsDetailFragment$o_Dez2ELRRRBq4KUYKXpumPQZlk
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                CommentsDetailFragment.initView$lambda$1(view);
            }
        });
        getBinding().top.backLayout.setOnClickListener(new View.OnClickListener() { // from class: com.yd.android_brand_mvp.landscape.exam.comments.-$$Lambda$CommentsDetailFragment$xETnLeTZ4YzEQTkEwTJptZzDca4
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                CommentsDetailFragment.initView$lambda$2(this.f$0, view);
            }
        });
        getBinding().top.ivEdit.setImageResource(R.mipmap.icon_del);
        getBinding().top.ivEdit.setVisibility(0);
        getBinding().top.ivEdit.setOnClickListener(new View.OnClickListener() { // from class: com.yd.android_brand_mvp.landscape.exam.comments.-$$Lambda$CommentsDetailFragment$dWhTlyg3UybECslYhr5T5Eey4I4
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                CommentsDetailFragment.initView$lambda$3(this.f$0, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$2(CommentsDetailFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        CommentsListener commentsListener = this$0.mCommentsListener;
        if (commentsListener != null) {
            commentsListener.onClose();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$3(final CommentsDetailFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        MessageTipDialog messageTipDialog = new MessageTipDialog("确定删除留言吗？");
        messageTipDialog.setCallBack(new MessageTipDialog.CallBack() { // from class: com.yd.android_brand_mvp.landscape.exam.comments.CommentsDetailFragment$initView$3$1
            @Override // com.yd.android_brand_mvp.dialog.MessageTipDialog.CallBack
            public void clickSubmit() {
                this.this$0.showProgressDialog();
                CommentsViewModel commentsViewModel = this.this$0.viewModel;
                if (commentsViewModel == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("viewModel");
                    commentsViewModel = null;
                }
                commentsViewModel.commentsDelete(this.this$0.id);
            }
        });
        messageTipDialog.show(this$0.getParentFragmentManager(), "messageTip");
    }

    private final void initModel() {
        CommentsViewModel commentsViewModel = this.viewModel;
        CommentsViewModel commentsViewModel2 = null;
        if (commentsViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            commentsViewModel = null;
        }
        LiveData<Result<CommentsDetailBean>> commentsDetailLiveData = commentsViewModel.getCommentsDetailLiveData();
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        final Function1<Result<? extends CommentsDetailBean>, Unit> function1 = new Function1<Result<? extends CommentsDetailBean>, Unit>() { // from class: com.yd.android_brand_mvp.landscape.exam.comments.CommentsDetailFragment.initModel.1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Result<? extends CommentsDetailBean> result) {
                invoke2(result);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Result<? extends CommentsDetailBean> it2) {
                Intrinsics.checkNotNullExpressionValue(it2, "it");
                if (Result.m598isSuccessimpl(it2.getValue())) {
                    Object value = it2.getValue();
                    if (Result.m597isFailureimpl(value)) {
                        value = null;
                    }
                    CommentsDetailBean commentsDetailBean = (CommentsDetailBean) value;
                    if (commentsDetailBean != null) {
                        CommentsDetailFragment.this.setData(commentsDetailBean);
                        return;
                    }
                    return;
                }
                Log.e("initModel", "获取留言详情失败");
                CommentsDetailFragment.access$getBinding(CommentsDetailFragment.this).mu.setViewState(2);
            }
        };
        commentsDetailLiveData.observe(viewLifecycleOwner, new Observer() { // from class: com.yd.android_brand_mvp.landscape.exam.comments.-$$Lambda$CommentsDetailFragment$qDwDQvF8YQao_Wbu9VpusVxdyow
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                CommentsDetailFragment.initModel$lambda$4(function1, obj);
            }
        });
        CommentsViewModel commentsViewModel3 = this.viewModel;
        if (commentsViewModel3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        } else {
            commentsViewModel2 = commentsViewModel3;
        }
        LiveData<Result<String>> commentsDeleteLiveData = commentsViewModel2.getCommentsDeleteLiveData();
        LifecycleOwner viewLifecycleOwner2 = getViewLifecycleOwner();
        final Function1<Result<? extends String>, Unit> function2 = new Function1<Result<? extends String>, Unit>() { // from class: com.yd.android_brand_mvp.landscape.exam.comments.CommentsDetailFragment.initModel.2
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
                CommentsDetailFragment.this.dismissProgressDialog();
                Intrinsics.checkNotNullExpressionValue(it2, "it");
                if (Result.m598isSuccessimpl(it2.getValue())) {
                    ToastUtil.showBottomView((Activity) CommentsDetailFragment.this.requireActivity(), "删除留言成功");
                    CommentsListener commentsListener = CommentsDetailFragment.this.mCommentsListener;
                    if (commentsListener != null) {
                        commentsListener.onRefresh();
                        return;
                    }
                    return;
                }
                Log.e("initModel", "删除留言失败");
            }
        };
        commentsDeleteLiveData.observe(viewLifecycleOwner2, new Observer() { // from class: com.yd.android_brand_mvp.landscape.exam.comments.-$$Lambda$CommentsDetailFragment$B_fb0P9Gg9kOI1GYmkY5eAvcUtk
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                CommentsDetailFragment.initModel$lambda$5(function2, obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initModel$lambda$4(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initModel$lambda$5(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void setData(CommentsDetailBean item) {
        getBinding().mu.setViewState(0);
        getBinding().tvName.setText(item.getUserName());
        getBinding().tvContent.setText(item.getContent());
        getBinding().tvTime.setText(item.getCreateTime());
        GlideUtil.loadCircleImage(getContext(), item.getUserAvatar(), getBinding().ivImg);
        if (item.getStatus() == 0) {
            getBinding().tvReply.setVisibility(0);
            getBinding().tvReply.setText(Html.fromHtml("<font color='#999999'> 回复：</font>" + item.getReplyContent()));
            getBinding().tvReplyTime.setText(item.getReplyTime());
            return;
        }
        getBinding().tvReply.setVisibility(8);
    }

    public final void setOnCommentsListener(CommentsListener mCommentsListener) {
        Intrinsics.checkNotNullParameter(mCommentsListener, "mCommentsListener");
        this.mCommentsListener = mCommentsListener;
    }
}
