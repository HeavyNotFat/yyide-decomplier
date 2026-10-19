package com.yd.android_brand_mvp.landscape.exam.comments;

import android.content.Context;
import android.os.Bundle;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.widget.ViewPager2;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;
import com.yd.android_brand_mvp.adapter.comments.CommentsPager;
import com.yd.android_brand_mvp.base.KTBaseFragment;
import com.yd.android_brand_mvp.databinding.MessageBoardHomeFragmentBinding;
import com.yd.android_brand_mvp.dialog.SelectPopUp;
import com.yd.android_brand_mvp.model.SelectPopBean;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: CommentsHomeFragment.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u00192\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0019B\u0005¢\u0006\u0002\u0010\u0003J\b\u0010\u0012\u001a\u00020\u0013H\u0002J\u001a\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001a"}, d2 = {"Lcom/yd/android_brand_mvp/landscape/exam/comments/CommentsHomeFragment;", "Lcom/yd/android_brand_mvp/base/KTBaseFragment;", "Lcom/yd/android_brand_mvp/databinding/MessageBoardHomeFragmentBinding;", "()V", "classesIdId", "", "dataSelect", "", "Lcom/yd/android_brand_mvp/model/SelectPopBean;", "fragments", "Landroid/util/SparseArray;", "Landroidx/fragment/app/Fragment;", "mLayoutMediator", "Lcom/google/android/material/tabs/TabLayoutMediator;", "selectBean", CommentsHomeFragment.TYPE_ID, "studentPopUp", "Lcom/yd/android_brand_mvp/dialog/SelectPopUp;", "initView", "", "onViewCreated", "view", "Landroid/view/View;", "savedInstanceState", "Landroid/os/Bundle;", "Companion", "app_commonRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class CommentsHomeFragment extends KTBaseFragment<MessageBoardHomeFragmentBinding> {
    public static final int PAGE_ING = 1;
    public static final int PAGE_NOT_START = 0;
    public static final String TYPE_CLASSESID = "classesId";
    public static final String TYPE_ID = "studentId";
    private String classesIdId;
    private final List<SelectPopBean> dataSelect;
    private final SparseArray<Fragment> fragments;
    private TabLayoutMediator mLayoutMediator;
    private SelectPopBean selectBean;
    private String studentId;
    private SelectPopUp studentPopUp;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static String type = "1";

    /* JADX INFO: renamed from: com.yd.android_brand_mvp.landscape.exam.comments.CommentsHomeFragment$1, reason: invalid class name */
    /* JADX INFO: compiled from: CommentsHomeFragment.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements Function3<LayoutInflater, ViewGroup, Boolean, MessageBoardHomeFragmentBinding> {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        AnonymousClass1() {
            super(3, MessageBoardHomeFragmentBinding.class, "inflate", "inflate(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Z)Lcom/yd/android_brand_mvp/databinding/MessageBoardHomeFragmentBinding;", 0);
        }

        public final MessageBoardHomeFragmentBinding invoke(LayoutInflater p0, ViewGroup viewGroup, boolean z) {
            Intrinsics.checkNotNullParameter(p0, "p0");
            return MessageBoardHomeFragmentBinding.inflate(p0, viewGroup, z);
        }

        @Override // kotlin.jvm.functions.Function3
        public /* bridge */ /* synthetic */ MessageBoardHomeFragmentBinding invoke(LayoutInflater layoutInflater, ViewGroup viewGroup, Boolean bool) {
            return invoke(layoutInflater, viewGroup, bool.booleanValue());
        }
    }

    public static final /* synthetic */ MessageBoardHomeFragmentBinding access$getBinding(CommentsHomeFragment commentsHomeFragment) {
        return commentsHomeFragment.getBinding();
    }

    public CommentsHomeFragment() {
        super(AnonymousClass1.INSTANCE);
        this.fragments = new SparseArray<>();
        this.dataSelect = new ArrayList();
        this.studentId = "";
        this.classesIdId = "";
    }

    /* JADX INFO: compiled from: CommentsHomeFragment.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001a\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u00072\b\u0010\u0011\u001a\u0004\u0018\u00010\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u001a\u0010\t\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\r¨\u0006\u0012"}, d2 = {"Lcom/yd/android_brand_mvp/landscape/exam/comments/CommentsHomeFragment$Companion;", "", "()V", "PAGE_ING", "", "PAGE_NOT_START", "TYPE_CLASSESID", "", "TYPE_ID", "type", "getType", "()Ljava/lang/String;", "setType", "(Ljava/lang/String;)V", "newInstance", "Lcom/yd/android_brand_mvp/landscape/exam/comments/CommentsHomeFragment;", CommentsHomeFragment.TYPE_ID, CommentsHomeFragment.TYPE_CLASSESID, "app_commonRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final String getType() {
            return CommentsHomeFragment.type;
        }

        public final void setType(String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            CommentsHomeFragment.type = str;
        }

        public final CommentsHomeFragment newInstance(String studentId, String classesId) {
            CommentsHomeFragment commentsHomeFragment = new CommentsHomeFragment();
            Bundle bundle = new Bundle();
            bundle.putString(CommentsHomeFragment.TYPE_ID, studentId);
            bundle.putString(CommentsHomeFragment.TYPE_CLASSESID, classesId);
            commentsHomeFragment.setArguments(bundle);
            return commentsHomeFragment;
        }
    }

    @Override // com.yd.android_brand_mvp.base.KTBaseFragment, com.yd.android_brand_mvp.base.BaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.studentId = String.valueOf(arguments.getString(TYPE_ID));
            this.classesIdId = String.valueOf(arguments.getString(TYPE_CLASSESID));
        }
        initView();
    }

    private final void initView() {
        final MyCommentsFragment myCommentsFragmentNewInstance = MyCommentsFragment.INSTANCE.newInstance(this.studentId, this.classesIdId);
        final CommentsListFragment commentsListFragmentNewInstance = CommentsListFragment.INSTANCE.newInstance(this.studentId, this.classesIdId);
        this.fragments.put(0, myCommentsFragmentNewInstance);
        this.fragments.put(1, commentsListFragmentNewInstance);
        FragmentActivity fragmentActivityRequireActivity = requireActivity();
        Intrinsics.checkNotNullExpressionValue(fragmentActivityRequireActivity, "requireActivity()");
        getBinding().viewPager2.setAdapter(new CommentsPager(fragmentActivityRequireActivity, this.fragments));
        TabLayoutMediator tabLayoutMediator = new TabLayoutMediator(getBinding().tlMessageBoard, getBinding().viewPager2, true, false, new TabLayoutMediator.TabConfigurationStrategy() { // from class: com.yd.android_brand_mvp.landscape.exam.comments.-$$Lambda$CommentsHomeFragment$kk2SSPfpfasAqsyoBvyadqwXefU
            @Override // com.google.android.material.tabs.TabLayoutMediator.TabConfigurationStrategy
            public final void onConfigureTab(TabLayout.Tab tab, int i) {
                CommentsHomeFragment.initView$lambda$1(tab, i);
            }
        });
        this.mLayoutMediator = tabLayoutMediator;
        if (tabLayoutMediator != null) {
            tabLayoutMediator.attach();
        }
        getBinding().viewPager2.post(new Runnable() { // from class: com.yd.android_brand_mvp.landscape.exam.comments.-$$Lambda$CommentsHomeFragment$VAbmV8UONOX62_EZBq4lfCPMYAk
            @Override // java.lang.Runnable
            public final void run() {
                CommentsHomeFragment.initView$lambda$2(this.f$0);
            }
        });
        getBinding().viewPager2.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() { // from class: com.yd.android_brand_mvp.landscape.exam.comments.CommentsHomeFragment.initView.3
            @Override // androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
            public void onPageScrollStateChanged(int state) {
                super.onPageScrollStateChanged(state);
            }

            @Override // androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                super.onPageScrolled(position, positionOffset, positionOffsetPixels);
            }

            @Override // androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
            public void onPageSelected(int position) {
                super.onPageSelected(position);
                if (position == 0) {
                    CommentsHomeFragment.access$getBinding(CommentsHomeFragment.this).viewPager2.setCurrentItem(0, false);
                } else {
                    CommentsHomeFragment.access$getBinding(CommentsHomeFragment.this).viewPager2.setCurrentItem(1, false);
                }
            }
        });
        this.selectBean = new SelectPopBean("1", "班主任信箱");
        TextView textView = getBinding().tvOneName;
        SelectPopBean selectPopBean = this.selectBean;
        Intrinsics.checkNotNull(selectPopBean);
        textView.setText(selectPopBean.getName());
        this.dataSelect.add(new SelectPopBean("1", "班主任信箱"));
        this.dataSelect.add(new SelectPopBean("2", "校领导信箱"));
        Context contextRequireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext()");
        SelectPopUp selectPopUp = new SelectPopUp(contextRequireContext);
        this.studentPopUp = selectPopUp;
        Intrinsics.checkNotNull(selectPopUp);
        selectPopUp.setPopupGravity(80);
        SelectPopUp selectPopUp2 = this.studentPopUp;
        Intrinsics.checkNotNull(selectPopUp2);
        selectPopUp2.setSubmitCallBack(new SelectPopUp.SubmitCallBack() { // from class: com.yd.android_brand_mvp.landscape.exam.comments.CommentsHomeFragment.initView.4
            @Override // com.yd.android_brand_mvp.dialog.SelectPopUp.SubmitCallBack
            public void getSubmitData(SelectPopBean data) {
                Intrinsics.checkNotNullParameter(data, "data");
                CommentsHomeFragment.access$getBinding(CommentsHomeFragment.this).tvOneName.setText(data.getName());
                CommentsHomeFragment.this.selectBean = data;
                CommentsHomeFragment.INSTANCE.setType(data.getId());
                if (commentsListFragmentNewInstance.isResumed()) {
                    commentsListFragmentNewInstance.requestData();
                } else {
                    commentsListFragmentNewInstance.setRefresh(true);
                }
                if (myCommentsFragmentNewInstance.isAdded()) {
                    myCommentsFragmentNewInstance.requestData(data.getId());
                }
            }
        });
        getBinding().tvOneName.setOnClickListener(new View.OnClickListener() { // from class: com.yd.android_brand_mvp.landscape.exam.comments.-$$Lambda$CommentsHomeFragment$ffD596IF30Y4Fdn-kaTgAlrhxWY
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                CommentsHomeFragment.initView$lambda$3(this.f$0, view);
            }
        });
        myCommentsFragmentNewInstance.setOnCommitListener(new MyCommentsFragment.CommitListener() { // from class: com.yd.android_brand_mvp.landscape.exam.comments.CommentsHomeFragment.initView.6
            @Override // com.yd.android_brand_mvp.landscape.exam.comments.MyCommentsFragment.CommitListener
            public void onCommitCall() {
                CommentsHomeFragment.access$getBinding(CommentsHomeFragment.this).viewPager2.setCurrentItem(1, false);
                if (commentsListFragmentNewInstance.getIsShow()) {
                    commentsListFragmentNewInstance.requestData();
                }
            }
        });
        commentsListFragmentNewInstance.setOnCommentsDetail(new CommentsListFragment.CommentsDetail() { // from class: com.yd.android_brand_mvp.landscape.exam.comments.CommentsHomeFragment.initView.7
            @Override // com.yd.android_brand_mvp.landscape.exam.comments.CommentsListFragment.CommentsDetail
            public void onDetail(String id) {
                Intrinsics.checkNotNullParameter(id, "id");
                CommentsDetailFragment commentsDetailFragmentNewInstance = CommentsDetailFragment.INSTANCE.newInstance(id);
                CommentsHomeFragment.access$getBinding(CommentsHomeFragment.this).container.setVisibility(0);
                CommentsHomeFragment.this.getChildFragmentManager().beginTransaction().replace(CommentsHomeFragment.access$getBinding(CommentsHomeFragment.this).container.getId(), commentsDetailFragmentNewInstance).addToBackStack(null).commit();
                final CommentsHomeFragment commentsHomeFragment = CommentsHomeFragment.this;
                final CommentsListFragment commentsListFragment = commentsListFragmentNewInstance;
                commentsDetailFragmentNewInstance.setOnCommentsListener(new CommentsDetailFragment.CommentsListener() { // from class: com.yd.android_brand_mvp.landscape.exam.comments.CommentsHomeFragment$initView$7$onDetail$1
                    @Override // com.yd.android_brand_mvp.landscape.exam.comments.CommentsDetailFragment.CommentsListener
                    public void onClose() {
                        commentsHomeFragment.getChildFragmentManager().popBackStack();
                    }

                    @Override // com.yd.android_brand_mvp.landscape.exam.comments.CommentsDetailFragment.CommentsListener
                    public void onRefresh() {
                        commentsHomeFragment.getChildFragmentManager().popBackStack();
                        if (commentsListFragment.isResumed()) {
                            commentsListFragment.requestData();
                        }
                    }
                });
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$1(TabLayout.Tab tab, int i) {
        Intrinsics.checkNotNullParameter(tab, "tab");
        if (i == 0) {
            tab.setText("我要留言");
        } else {
            if (i != 1) {
                return;
            }
            tab.setText("留言记录");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$2(CommentsHomeFragment this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.getBinding().viewPager2.setCurrentItem(0, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$3(CommentsHomeFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        SelectPopUp selectPopUp = this$0.studentPopUp;
        if (selectPopUp != null) {
            selectPopUp.setData(this$0.dataSelect, this$0.selectBean);
        }
        SelectPopUp selectPopUp2 = this$0.studentPopUp;
        Intrinsics.checkNotNull(selectPopUp2);
        if (selectPopUp2.isShowing()) {
            SelectPopUp selectPopUp3 = this$0.studentPopUp;
            Intrinsics.checkNotNull(selectPopUp3);
            selectPopUp3.dismiss();
        } else {
            SelectPopUp selectPopUp4 = this$0.studentPopUp;
            Intrinsics.checkNotNull(selectPopUp4);
            selectPopUp4.showPopupWindow(this$0.getBinding().tvOneName);
        }
    }
}
