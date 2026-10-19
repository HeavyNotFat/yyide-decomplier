package com.yd.android_brand_mvp.activity.fragment.honor;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.app.NotificationCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import com.alibaba.fastjson.JSON;
import com.flyco.tablayout.SlidingTabLayout;
import com.yd.android_brand_mvp.R;
import com.yd.android_brand_mvp.activity.fragment.model.HonorActiveDetailViewModel;
import com.yd.android_brand_mvp.activity.honor.HonorCommentActivity;
import com.yd.android_brand_mvp.base.KTBaseFragment;
import com.yd.android_brand_mvp.base.ValidationConstant;
import com.yd.android_brand_mvp.databinding.HonorActiveDetailFragmentBinding;
import com.yd.android_brand_mvp.model.IdentityBean;
import com.yd.android_brand_mvp.model.honor.HonorActiveDetailBean;
import com.yd.android_brand_mvp.model.honor.HonorGoCommentBean;
import com.yd.android_brand_mvp.model.honor.HonorRuleGroup;
import com.yd.android_brand_mvp.network.base.SingleLiveEvent;
import com.yd.android_brand_mvp.utils.GlideUtil;
import com.yd.android_brand_mvp.utils.SpData;
import com.yd.android_brand_mvp.utils.ToastUtil;
import com.yd.android_brand_mvp.verfity.TeacherCheackActivity2;
import com.yyide.facepass.AppExtKt;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

/* JADX INFO: compiled from: HonorActiveDetailFragment.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000  2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001 B\u0005¢\u0006\u0002\u0010\u0003J\u0012\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0007H\u0007J\b\u0010\u0016\u001a\u00020\u0014H\u0002J\b\u0010\u0017\u001a\u00020\u0014H\u0002J\b\u0010\u0018\u001a\u00020\u0014H\u0002J\u0012\u0010\u0019\u001a\u00020\u00142\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bH\u0016J\b\u0010\u001c\u001a\u00020\u0014H\u0016J\b\u0010\u001d\u001a\u00020\u0014H\u0016J\u0010\u0010\u001e\u001a\u00020\u00142\u0006\u0010\u001f\u001a\u00020\u0005H\u0002R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00100\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082.¢\u0006\u0002\n\u0000¨\u0006!"}, d2 = {"Lcom/yd/android_brand_mvp/activity/fragment/honor/HonorActiveDetailFragment;", "Lcom/yd/android_brand_mvp/base/KTBaseFragment;", "Lcom/yd/android_brand_mvp/databinding/HonorActiveDetailFragmentBinding;", "()V", "detailBean", "Lcom/yd/android_brand_mvp/model/honor/HonorActiveDetailBean;", "identityBean", "Lcom/yd/android_brand_mvp/model/IdentityBean;", "mFragments", "", "Landroidx/fragment/app/Fragment;", "mHonorResultFragment", "Lcom/yd/android_brand_mvp/activity/fragment/honor/HonorResultFragment;", "mHonorRuleFragment", "Lcom/yd/android_brand_mvp/activity/fragment/honor/HonorRuleFragment;", "mTitles", "", "viewModel", "Lcom/yd/android_brand_mvp/activity/fragment/model/HonorActiveDetailViewModel;", NotificationCompat.CATEGORY_EVENT, "", "mIdentityBean", "initView", "initViewModel", "initViewPager", "onActivityCreated", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onResume", "setData", "data", "Companion", "app_commonRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class HonorActiveDetailFragment extends KTBaseFragment<HonorActiveDetailFragmentBinding> {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private HonorActiveDetailBean detailBean;
    private IdentityBean identityBean;
    private final List<Fragment> mFragments;
    private final HonorResultFragment mHonorResultFragment;
    private final HonorRuleFragment mHonorRuleFragment;
    private List<String> mTitles;
    private HonorActiveDetailViewModel viewModel;

    /* JADX INFO: renamed from: com.yd.android_brand_mvp.activity.fragment.honor.HonorActiveDetailFragment$1, reason: invalid class name */
    /* JADX INFO: compiled from: HonorActiveDetailFragment.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements Function3<LayoutInflater, ViewGroup, Boolean, HonorActiveDetailFragmentBinding> {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        AnonymousClass1() {
            super(3, HonorActiveDetailFragmentBinding.class, "inflate", "inflate(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Z)Lcom/yd/android_brand_mvp/databinding/HonorActiveDetailFragmentBinding;", 0);
        }

        public final HonorActiveDetailFragmentBinding invoke(LayoutInflater p0, ViewGroup viewGroup, boolean z) {
            Intrinsics.checkNotNullParameter(p0, "p0");
            return HonorActiveDetailFragmentBinding.inflate(p0, viewGroup, z);
        }

        @Override // kotlin.jvm.functions.Function3
        public /* bridge */ /* synthetic */ HonorActiveDetailFragmentBinding invoke(LayoutInflater layoutInflater, ViewGroup viewGroup, Boolean bool) {
            return invoke(layoutInflater, viewGroup, bool.booleanValue());
        }
    }

    public HonorActiveDetailFragment() {
        super(AnonymousClass1.INSTANCE);
        this.mTitles = new ArrayList();
        this.mFragments = new ArrayList();
        this.mHonorRuleFragment = HonorRuleFragment.INSTANCE.newInstance();
        this.mHonorResultFragment = HonorResultFragment.INSTANCE.newInstance();
    }

    /* JADX INFO: compiled from: HonorActiveDetailFragment.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¨\u0006\u0007"}, d2 = {"Lcom/yd/android_brand_mvp/activity/fragment/honor/HonorActiveDetailFragment$Companion;", "", "()V", "newInstance", "Lcom/yd/android_brand_mvp/activity/fragment/honor/HonorActiveDetailFragment;", "id", "", "app_commonRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final HonorActiveDetailFragment newInstance(String id) {
            HonorActiveDetailFragment honorActiveDetailFragment = new HonorActiveDetailFragment();
            Bundle bundle = new Bundle();
            bundle.putString(HonorActiveDetailFragmentKt.PARAMS_ID, id);
            honorActiveDetailFragment.setArguments(bundle);
            return honorActiveDetailFragment;
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        this.viewModel = (HonorActiveDetailViewModel) new ViewModelProvider(this).get(HonorActiveDetailViewModel.class);
        initView();
        EventBus.getDefault().register(this);
        getBinding().ctContent.setVisibility(4);
    }

    private final void initView() {
        initViewPager();
        initViewModel();
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        Bundle arguments = getArguments();
        if (arguments != null) {
            showProgressDialog();
            HonorActiveDetailViewModel honorActiveDetailViewModel = this.viewModel;
            if (honorActiveDetailViewModel == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewModel");
                honorActiveDetailViewModel = null;
            }
            honorActiveDetailViewModel.requestActiveDetail(arguments.getString(HonorActiveDetailFragmentKt.PARAMS_ID));
        }
    }

    private final void initViewPager() {
        List<String> list = this.mTitles;
        String string = getString(R.string.honor_detail_result_tab);
        Intrinsics.checkNotNullExpressionValue(string, "getString(R.string.honor_detail_result_tab)");
        list.add(string);
        List<String> list2 = this.mTitles;
        String string2 = getString(R.string.honor_detail_rule_tab);
        Intrinsics.checkNotNullExpressionValue(string2, "getString(R.string.honor_detail_rule_tab)");
        list2.add(string2);
        this.mFragments.add(this.mHonorResultFragment);
        this.mFragments.add(this.mHonorRuleFragment);
        getBinding().viewpager.setOffscreenPageLimit(this.mFragments.size());
        getBinding().viewpager.setAdapter(new FragmentStatePagerAdapter(getChildFragmentManager()) { // from class: com.yd.android_brand_mvp.activity.fragment.honor.HonorActiveDetailFragment.initViewPager.1
            @Override // androidx.fragment.app.FragmentStatePagerAdapter
            public Fragment getItem(int position) {
                return (Fragment) HonorActiveDetailFragment.this.mFragments.get(position);
            }

            @Override // androidx.viewpager.widget.PagerAdapter
            public int getCount() {
                return HonorActiveDetailFragment.this.mTitles.size();
            }

            @Override // androidx.viewpager.widget.PagerAdapter
            public CharSequence getPageTitle(int position) {
                return (CharSequence) HonorActiveDetailFragment.this.mTitles.get(position);
            }
        });
        SlidingTabLayout slidingTabLayout = getBinding().slidingTabLayout;
        SpData.isNight();
        slidingTabLayout.setTextSelectColor(getResources().getColor(R.color.purple2));
        SlidingTabLayout slidingTabLayout2 = getBinding().slidingTabLayout;
        SpData.isNight();
        slidingTabLayout2.setIndicatorColor(getResources().getColor(R.color.purple2));
        getBinding().slidingTabLayout.setViewPager(getBinding().viewpager);
        getBinding().slidingTabLayout.setCurrentTab(0);
        getBinding().slidingTabLayout.notifyDataSetChanged();
    }

    private final void initViewModel() {
        HonorActiveDetailViewModel honorActiveDetailViewModel = this.viewModel;
        HonorActiveDetailViewModel honorActiveDetailViewModel2 = null;
        if (honorActiveDetailViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            honorActiveDetailViewModel = null;
        }
        SingleLiveEvent<Result<HonorActiveDetailBean>> honorActiveDetailLiveData = honorActiveDetailViewModel.getHonorActiveDetailLiveData();
        HonorActiveDetailFragment honorActiveDetailFragment = this;
        final Function1<Result<? extends HonorActiveDetailBean>, Unit> function1 = new Function1<Result<? extends HonorActiveDetailBean>, Unit>() { // from class: com.yd.android_brand_mvp.activity.fragment.honor.HonorActiveDetailFragment.initViewModel.1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Result<? extends HonorActiveDetailBean> result) {
                invoke2(result);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Result<? extends HonorActiveDetailBean> it2) {
                HonorActiveDetailFragment.this.dismissProgressDialog();
                Intrinsics.checkNotNullExpressionValue(it2, "it");
                if (Result.m598isSuccessimpl(it2.getValue())) {
                    Object value = it2.getValue();
                    if (Result.m597isFailureimpl(value)) {
                        value = null;
                    }
                    HonorActiveDetailBean honorActiveDetailBean = (HonorActiveDetailBean) value;
                    if (honorActiveDetailBean != null) {
                        HonorActiveDetailFragment.this.setData(honorActiveDetailBean);
                        return;
                    }
                    return;
                }
                Result.m594exceptionOrNullimpl(it2.getValue());
            }
        };
        honorActiveDetailLiveData.observe(honorActiveDetailFragment, new Observer() { // from class: com.yd.android_brand_mvp.activity.fragment.honor.-$$Lambda$HonorActiveDetailFragment$ZWOKi0sRjtZWyEiFJY1FLqnMKv4
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                HonorActiveDetailFragment.initViewModel$lambda$1(function1, obj);
            }
        });
        HonorActiveDetailViewModel honorActiveDetailViewModel3 = this.viewModel;
        if (honorActiveDetailViewModel3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        } else {
            honorActiveDetailViewModel2 = honorActiveDetailViewModel3;
        }
        SingleLiveEvent<Result<HonorGoCommentBean>> honorGoCommentLiveData = honorActiveDetailViewModel2.getHonorGoCommentLiveData();
        final Function1<Result<? extends HonorGoCommentBean>, Unit> function2 = new Function1<Result<? extends HonorGoCommentBean>, Unit>() { // from class: com.yd.android_brand_mvp.activity.fragment.honor.HonorActiveDetailFragment.initViewModel.2
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Result<? extends HonorGoCommentBean> result) {
                invoke2(result);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Result<? extends HonorGoCommentBean> it2) {
                String message;
                HonorActiveDetailBean honorActiveDetailBean;
                HonorActiveDetailFragment.this.dismissProgressDialog();
                Intrinsics.checkNotNullExpressionValue(it2, "it");
                if (Result.m598isSuccessimpl(it2.getValue())) {
                    Object value = it2.getValue();
                    if (Result.m597isFailureimpl(value)) {
                        value = null;
                    }
                    HonorGoCommentBean honorGoCommentBean = (HonorGoCommentBean) value;
                    if (honorGoCommentBean != null) {
                        HonorActiveDetailFragment honorActiveDetailFragment2 = HonorActiveDetailFragment.this;
                        if (honorGoCommentBean.getCanScore()) {
                            IdentityBean identityBean = honorActiveDetailFragment2.identityBean;
                            if (identityBean == null || (honorActiveDetailBean = honorActiveDetailFragment2.detailBean) == null) {
                                return;
                            }
                            honorActiveDetailBean.setCanScoreStudent(honorGoCommentBean.getCanScoreStudent());
                            honorActiveDetailBean.setGradeList(honorGoCommentBean.getCanScoreGrade());
                            String jSONString = JSON.toJSONString(identityBean.getIdentityId());
                            Intrinsics.checkNotNullExpressionValue(jSONString, "toJSONString(identity.identityId)");
                            AppExtKt.loge(honorActiveDetailFragment2, jSONString);
                            HonorCommentActivity.Companion companion = HonorCommentActivity.INSTANCE;
                            Context contextRequireContext = honorActiveDetailFragment2.requireContext();
                            Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext()");
                            companion.start(contextRequireContext, honorActiveDetailBean, identityBean.getIdentityId(), identityBean.getIdentityName());
                            return;
                        }
                        ToastUtil.showBottomView((Activity) honorActiveDetailFragment2.getActivity(), "当前人员无法评分");
                        return;
                    }
                    return;
                }
                FragmentActivity activity = HonorActiveDetailFragment.this.getActivity();
                Throwable thM594exceptionOrNullimpl = Result.m594exceptionOrNullimpl(it2.getValue());
                if (thM594exceptionOrNullimpl == null || (message = thM594exceptionOrNullimpl.getMessage()) == null) {
                    message = "服务接口异常";
                }
                ToastUtil.showBottomView((Activity) activity, message);
            }
        };
        honorGoCommentLiveData.observe(honorActiveDetailFragment, new Observer() { // from class: com.yd.android_brand_mvp.activity.fragment.honor.-$$Lambda$HonorActiveDetailFragment$qB_Qa0wIGD5CBPbaOUUrvY38QNc
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                HonorActiveDetailFragment.initViewModel$lambda$2(function2, obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initViewModel$lambda$1(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initViewModel$lambda$2(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public final void event(IdentityBean mIdentityBean) {
        this.identityBean = mIdentityBean;
        String jSONString = JSON.toJSONString(mIdentityBean);
        Intrinsics.checkNotNullExpressionValue(jSONString, "toJSONString(mIdentityBean)");
        AppExtKt.loge(this, jSONString);
        showProgressDialog();
        HonorActiveDetailViewModel honorActiveDetailViewModel = this.viewModel;
        if (honorActiveDetailViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            honorActiveDetailViewModel = null;
        }
        HonorActiveDetailBean honorActiveDetailBean = this.detailBean;
        honorActiveDetailViewModel.requestGoToScore(honorActiveDetailBean != null ? honorActiveDetailBean.getId() : null, SpData.getSchoolId(), SpData.getClassesId(), mIdentityBean != null ? mIdentityBean.getIdentityId() : null);
    }

    @Override // com.yd.android_brand_mvp.base.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void setData(HonorActiveDetailBean data) {
        this.detailBean = data;
        getBinding().ctContent.setVisibility(0);
        getBinding().tvConfirm.setVisibility(0);
        getBinding().tvConfirm.setOnClickListener(new View.OnClickListener() { // from class: com.yd.android_brand_mvp.activity.fragment.honor.-$$Lambda$HonorActiveDetailFragment$ueFSkvZQGyr2hLHPJ1MYQT0bzjs
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                HonorActiveDetailFragment.setData$lambda$3(this.f$0, view);
            }
        });
        getBinding().tvTitle.setText(data.getTitle());
        getBinding().tvTiem.setText(data.getActivityTime());
        getBinding().tvActiveContent.setText(data.getDescription());
        GlideUtil.loadRadiusImage(getContext(), data.getPromotionalImage(), getBinding().ivCover, 20);
        ArrayList<HonorRuleGroup> ruleList = data.getRuleList();
        if (ruleList != null) {
            this.mHonorRuleFragment.setRuleList(ruleList);
        }
        this.mHonorResultFragment.setData(data.getId(), data.getScoringMethod());
        int status = data.getStatus();
        if (status == 0) {
            getBinding().cardViewState.setCardBackgroundColor(getResources().getColor(R.color.color_ffc328));
            getBinding().tvState.setText("未开始");
            getBinding().tvConfirm.setEnabled(false);
            getBinding().tvConfirm.setVisibility(0);
            return;
        }
        if (status != 1) {
            if (status != 3) {
                return;
            }
            getBinding().cardViewState.setCardBackgroundColor(getResources().getColor(R.color.color_595959));
            getBinding().constraintLayout.setVisibility(8);
            getBinding().tvState.setText("已结束");
            return;
        }
        getBinding().cardViewState.setCardBackgroundColor(getResources().getColor(R.color.color_11c685));
        getBinding().tvState.setText("进行中");
        getBinding().tvConfirm.setVisibility(0);
        getBinding().tvConfirm.setEnabled(true);
        getBinding().tvConfirm.setBackgroundResource(R.drawable.bg_comment_bt_40);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setData$lambda$3(HonorActiveDetailFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        TeacherCheackActivity2.start(this$0.getActivity(), ValidationConstant.STUDENT_COMMENT);
    }
}
