package com.yd.android_brand_mvp.landscape.customized.tianjin;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.fragment.app.FragmentContainerView;
import androidx.fragment.app.FragmentTransaction;
import com.tencent.mmkv.MMKV;
import com.yd.android_brand_mvp.R;
import com.yd.android_brand_mvp.activity.iotControl.DoorControlActivity;
import com.yd.android_brand_mvp.adapter.attence.CheckAttendanceActivity;
import com.yd.android_brand_mvp.base.BaseFragment;
import com.yd.android_brand_mvp.base.KTBaseFragment;
import com.yd.android_brand_mvp.base.MMKVConstant;
import com.yd.android_brand_mvp.base.MinaConstants;
import com.yd.android_brand_mvp.databinding.FragmentCustomHomeBinding;
import com.yd.android_brand_mvp.model.MessageCaptionBean;
import com.yd.android_brand_mvp.user.AnnouncementListActivity;
import com.yd.android_brand_mvp.utils.SimpleUtilsKt;
import com.yd.android_brand_mvp.utils.view.net.GsonUtils;
import com.yd.android_brand_mvp.view.ScrollTextView;
import kotlin.Metadata;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: compiled from: CustomHomeFragment.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \u00122\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003:\u0001\u0012B\u0005¢\u0006\u0002\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016J\b\u0010\t\u001a\u00020\u0006H\u0002J\u0012\u0010\n\u001a\u00020\u00062\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0016J\u001a\u0010\r\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\f2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0016J\b\u0010\u0011\u001a\u00020\u0006H\u0002¨\u0006\u0013"}, d2 = {"Lcom/yd/android_brand_mvp/landscape/customized/tianjin/CustomHomeFragment;", "Lcom/yd/android_brand_mvp/base/KTBaseFragment;", "Lcom/yd/android_brand_mvp/databinding/FragmentCustomHomeBinding;", "Landroid/view/View$OnClickListener;", "()V", "UpdataEvent", "", "id", "", "initView", "onClick", "v", "Landroid/view/View;", "onViewCreated", "view", "savedInstanceState", "Landroid/os/Bundle;", "setNoticeData", "Companion", "app_commonRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class CustomHomeFragment extends KTBaseFragment<FragmentCustomHomeBinding> implements View.OnClickListener {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* JADX INFO: renamed from: com.yd.android_brand_mvp.landscape.customized.tianjin.CustomHomeFragment$1, reason: invalid class name */
    /* JADX INFO: compiled from: CustomHomeFragment.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements Function3<LayoutInflater, ViewGroup, Boolean, FragmentCustomHomeBinding> {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        AnonymousClass1() {
            super(3, FragmentCustomHomeBinding.class, "inflate", "inflate(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Z)Lcom/yd/android_brand_mvp/databinding/FragmentCustomHomeBinding;", 0);
        }

        public final FragmentCustomHomeBinding invoke(LayoutInflater p0, ViewGroup viewGroup, boolean z) {
            Intrinsics.checkNotNullParameter(p0, "p0");
            return FragmentCustomHomeBinding.inflate(p0, viewGroup, z);
        }

        @Override // kotlin.jvm.functions.Function3
        public /* bridge */ /* synthetic */ FragmentCustomHomeBinding invoke(LayoutInflater layoutInflater, ViewGroup viewGroup, Boolean bool) {
            return invoke(layoutInflater, viewGroup, bool.booleanValue());
        }
    }

    public CustomHomeFragment() {
        super(AnonymousClass1.INSTANCE);
    }

    /* JADX INFO: compiled from: CustomHomeFragment.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0003\u001a\u00020\u0004¨\u0006\u0005"}, d2 = {"Lcom/yd/android_brand_mvp/landscape/customized/tianjin/CustomHomeFragment$Companion;", "", "()V", "newInstance", "Lcom/yd/android_brand_mvp/landscape/customized/tianjin/CustomHomeFragment;", "app_commonRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final CustomHomeFragment newInstance() {
            return new CustomHomeFragment();
        }
    }

    @Override // com.yd.android_brand_mvp.base.KTBaseFragment, com.yd.android_brand_mvp.base.BaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        initView();
    }

    private final void initView() {
        SensorInfoFragment sensorInfoFragmentNewInstance = SensorInfoFragment.INSTANCE.newInstance();
        SiteTableFragment siteTableFragment = new SiteTableFragment();
        CustomAttendanceFragment customAttendanceFragment = new CustomAttendanceFragment();
        sensorInfoFragmentNewInstance.setOnFragmentDataListener(new BaseFragment.OnFragmentDataListener() { // from class: com.yd.android_brand_mvp.landscape.customized.tianjin.-$$Lambda$CustomHomeFragment$y21Y6hK7J4TPC7eows9LAd2fipE
            @Override // com.yd.android_brand_mvp.base.BaseFragment.OnFragmentDataListener
            public final void onFragmentData(boolean z) {
                CustomHomeFragment.initView$lambda$0(this.f$0, z);
            }
        });
        siteTableFragment.setOnFragmentDataListener(new BaseFragment.OnFragmentDataListener() { // from class: com.yd.android_brand_mvp.landscape.customized.tianjin.-$$Lambda$CustomHomeFragment$y9TfiW4PzYsuYUJ6nAAmbbkpMlM
            @Override // com.yd.android_brand_mvp.base.BaseFragment.OnFragmentDataListener
            public final void onFragmentData(boolean z) {
                CustomHomeFragment.initView$lambda$1(this.f$0, z);
            }
        });
        customAttendanceFragment.setOnFragmentDataListener(new BaseFragment.OnFragmentDataListener() { // from class: com.yd.android_brand_mvp.landscape.customized.tianjin.-$$Lambda$CustomHomeFragment$dM-Eq1wOssvlf9ZbYiK8Zrvkq30
            @Override // com.yd.android_brand_mvp.base.BaseFragment.OnFragmentDataListener
            public final void onFragmentData(boolean z) {
                CustomHomeFragment.initView$lambda$2(this.f$0, z);
            }
        });
        FragmentTransaction fragmentTransactionBeginTransaction = getChildFragmentManager().beginTransaction();
        Intrinsics.checkNotNullExpressionValue(fragmentTransactionBeginTransaction, "childFragmentManager.beginTransaction()");
        fragmentTransactionBeginTransaction.replace(getBinding().fragmentContainerSite.getId(), SiteInfoFragment.INSTANCE.newInstance());
        fragmentTransactionBeginTransaction.replace(getBinding().fragmentContainerWarning.getId(), WarningInfoFragment.INSTANCE.newInstance());
        fragmentTransactionBeginTransaction.replace(getBinding().fragmentContainerSensor.getId(), sensorInfoFragmentNewInstance);
        fragmentTransactionBeginTransaction.replace(getBinding().fragmentContainerTable.getId(), siteTableFragment);
        fragmentTransactionBeginTransaction.replace(getBinding().fragmentContainerAttendance.getId(), customAttendanceFragment);
        fragmentTransactionBeginTransaction.commit();
        CustomHomeFragment customHomeFragment = this;
        getBinding().ivOpen.setOnClickListener(customHomeFragment);
        getBinding().ivAttendance.setOnClickListener(customHomeFragment);
        getBinding().ivNotice.setOnClickListener(customHomeFragment);
        setNoticeData();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$0(CustomHomeFragment this$0, boolean z) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (z) {
            FragmentContainerView fragmentContainerView = this$0.getBinding().fragmentContainerSensor;
            Intrinsics.checkNotNullExpressionValue(fragmentContainerView, "binding.fragmentContainerSensor");
            SimpleUtilsKt.hide(fragmentContainerView);
        } else {
            FragmentContainerView fragmentContainerView2 = this$0.getBinding().fragmentContainerSensor;
            Intrinsics.checkNotNullExpressionValue(fragmentContainerView2, "binding.fragmentContainerSensor");
            SimpleUtilsKt.show(fragmentContainerView2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$1(CustomHomeFragment this$0, boolean z) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (z) {
            FragmentContainerView fragmentContainerView = this$0.getBinding().fragmentContainerTable;
            Intrinsics.checkNotNullExpressionValue(fragmentContainerView, "binding.fragmentContainerTable");
            SimpleUtilsKt.hide(fragmentContainerView);
        } else {
            FragmentContainerView fragmentContainerView2 = this$0.getBinding().fragmentContainerTable;
            Intrinsics.checkNotNullExpressionValue(fragmentContainerView2, "binding.fragmentContainerTable");
            SimpleUtilsKt.show(fragmentContainerView2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$2(CustomHomeFragment this$0, boolean z) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (z) {
            FragmentContainerView fragmentContainerView = this$0.getBinding().fragmentContainerAttendance;
            Intrinsics.checkNotNullExpressionValue(fragmentContainerView, "binding.fragmentContainerAttendance");
            SimpleUtilsKt.hide(fragmentContainerView);
        } else {
            FragmentContainerView fragmentContainerView2 = this$0.getBinding().fragmentContainerAttendance;
            Intrinsics.checkNotNullExpressionValue(fragmentContainerView2, "binding.fragmentContainerAttendance");
            SimpleUtilsKt.show(fragmentContainerView2);
        }
    }

    private final void setNoticeData() {
        MessageCaptionBean messageCaptionBean = (MessageCaptionBean) GsonUtils.fromJson(MMKV.defaultMMKV().getString(MMKVConstant.HOME_MARQUEE_TEXT, ""), MessageCaptionBean.class);
        if (messageCaptionBean != null) {
            ScrollTextView scrollTextView = getBinding().tvNotice;
            String content = messageCaptionBean.getContent();
            scrollTextView.setText(content != null ? content : "暂无通知");
            getBinding().tvNotice.setPauseScroll(false);
            TextView textView = getBinding().tvNoticeHint;
            Intrinsics.checkNotNullExpressionValue(textView, "binding.tvNoticeHint");
            SimpleUtilsKt.hide(textView);
            getBinding().tvNotice.setBackgroundResource(R.drawable.bg_white_transparency_65);
            ScrollTextView scrollTextView2 = getBinding().tvNotice;
            Intrinsics.checkNotNullExpressionValue(scrollTextView2, "binding.tvNotice");
            SimpleUtilsKt.show(scrollTextView2);
        } else {
            getBinding().tvNotice.setText("暂无通知");
            getBinding().tvNotice.setPauseScroll(true);
            TextView textView2 = getBinding().tvNoticeHint;
            Intrinsics.checkNotNullExpressionValue(textView2, "binding.tvNoticeHint");
            SimpleUtilsKt.hide(textView2);
            getBinding().tvNotice.setBackgroundResource(R.color.transparent);
        }
        if (messageCaptionBean != null) {
            int circulationMode = messageCaptionBean.getCirculationMode();
            if (circulationMode == 1) {
                getBinding().tvNotice.setScrollCount(true);
                getBinding().tvNotice.setCount(1);
            } else if (circulationMode == 2) {
                getBinding().tvNotice.setScrollCount(true);
                getBinding().tvNotice.setCount(messageCaptionBean.getPlayCount());
                if (messageCaptionBean.getIntervalTime() > 0) {
                    getBinding().tvNotice.setIntervalTime(((long) messageCaptionBean.getIntervalTime()) * 1000);
                }
            } else if (circulationMode == 3) {
                getBinding().tvNotice.setTimes((int) (((long) messageCaptionBean.getPlayTime()) * 1000));
                if (messageCaptionBean.getIntervalTime() > 0) {
                    getBinding().tvNotice.setIntervalTime(((long) messageCaptionBean.getIntervalTime()) * 1000);
                }
                BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getMain()), null, null, new CustomHomeFragment$setNoticeData$1$1(messageCaptionBean, this, null), 3, null);
            }
            if (messageCaptionBean.getRollSpeed() > 0) {
                ScrollTextView scrollTextView3 = getBinding().tvNotice;
                int rollSpeed = messageCaptionBean.getRollSpeed() - 1;
                int rollSpeed2 = messageCaptionBean.getRollSpeed();
                if (rollSpeed > 0) {
                    rollSpeed2--;
                }
                scrollTextView3.setSpeed(rollSpeed2);
            }
        }
    }

    @Override // com.yd.android_brand_mvp.base.BaseFragment, com.yd.android_brand_mvp.observer.MinaListener
    public void UpdataEvent(int id) {
        super.UpdataEvent(id);
        if (id == MinaConstants.NOTICE_SUBTITLE) {
            setNoticeData();
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v) {
        Integer numValueOf = v != null ? Integer.valueOf(v.getId()) : null;
        if (numValueOf != null && numValueOf.intValue() == R.id.iv_open) {
            DoorControlActivity.Companion companion = DoorControlActivity.INSTANCE;
            Context contextRequireContext = requireContext();
            Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext()");
            companion.startGo(contextRequireContext, 60);
            return;
        }
        if (numValueOf != null && numValueOf.intValue() == R.id.iv_attendance) {
            startActivity(new Intent(this.mActivity, (Class<?>) CheckAttendanceActivity.class));
        } else if (numValueOf != null && numValueOf.intValue() == R.id.iv_notice) {
            Intent intent = new Intent(getContext(), (Class<?>) AnnouncementListActivity.class);
            intent.putExtra("type", AnnouncementListActivity.TYPE_ANNOUNCEMENT);
            goPermissionsActivity(intent);
        }
    }
}
