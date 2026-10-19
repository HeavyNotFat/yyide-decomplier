package com.yd.android_brand_mvp.landscape.university;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.FragmentActivity;
import androidx.work.WorkRequest;
import com.blankj.utilcode.util.SizeUtils;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.yd.android_brand_mvp.R;
import com.yd.android_brand_mvp.base.KTBaseFragment;
import com.yd.android_brand_mvp.databinding.FragmentUniversityNextReservationBinding;
import com.yd.android_brand_mvp.model.reservation.ReservationRecordBean;
import com.yd.android_brand_mvp.utils.SpData;
import com.yd.android_brand_mvp.utils.TimeUtil;
import com.yd.android_brand_mvp.utils.TransUtils;
import java.util.Date;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;

/* JADX INFO: compiled from: UniversityNextReservationFragment.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \u00112\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0011B\u0005¢\u0006\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0002J\u001a\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\t2\b\u0010\n\u001a\u0004\u0018\u00010\tJ\u001a\u0010\u000b\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0016J\b\u0010\u0010\u001a\u00020\u0005H\u0002¨\u0006\u0012"}, d2 = {"Lcom/yd/android_brand_mvp/landscape/university/UniversityNextReservationFragment;", "Lcom/yd/android_brand_mvp/base/KTBaseFragment;", "Lcom/yd/android_brand_mvp/databinding/FragmentUniversityNextReservationBinding;", "()V", "initView", "", "isTable", "", "startTime", "", "endTime", "onViewCreated", "view", "Landroid/view/View;", "savedInstanceState", "Landroid/os/Bundle;", "setTable", "Companion", "app_commonRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class UniversityNextReservationFragment extends KTBaseFragment<FragmentUniversityNextReservationBinding> {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$0(View view) {
    }

    @JvmStatic
    public static final UniversityNextReservationFragment newInstance(String str) {
        return INSTANCE.newInstance(str);
    }

    /* JADX INFO: renamed from: com.yd.android_brand_mvp.landscape.university.UniversityNextReservationFragment$1, reason: invalid class name */
    /* JADX INFO: compiled from: UniversityNextReservationFragment.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements Function3<LayoutInflater, ViewGroup, Boolean, FragmentUniversityNextReservationBinding> {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        AnonymousClass1() {
            super(3, FragmentUniversityNextReservationBinding.class, "inflate", "inflate(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Z)Lcom/yd/android_brand_mvp/databinding/FragmentUniversityNextReservationBinding;", 0);
        }

        public final FragmentUniversityNextReservationBinding invoke(LayoutInflater p0, ViewGroup viewGroup, boolean z) {
            Intrinsics.checkNotNullParameter(p0, "p0");
            return FragmentUniversityNextReservationBinding.inflate(p0, viewGroup, z);
        }

        @Override // kotlin.jvm.functions.Function3
        public /* bridge */ /* synthetic */ FragmentUniversityNextReservationBinding invoke(LayoutInflater layoutInflater, ViewGroup viewGroup, Boolean bool) {
            return invoke(layoutInflater, viewGroup, bool.booleanValue());
        }
    }

    public UniversityNextReservationFragment() {
        super(AnonymousClass1.INSTANCE);
    }

    @Override // com.yd.android_brand_mvp.base.KTBaseFragment, com.yd.android_brand_mvp.base.BaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        initView();
    }

    private final void initView() {
        String string;
        Bundle arguments = getArguments();
        if (arguments == null || (string = arguments.getString("type")) == null) {
            string = "hbreservation24";
        }
        if (string.hashCode() == 983425170 && string.equals("hbreservation44")) {
            getBinding().constraintLayout.getLayoutParams().width = SizeUtils.dp2px(908.0f);
            getBinding().constraintLayout.getLayoutParams().height = SizeUtils.dp2px(604.0f);
            getBinding().constraintLayout.setBackgroundResource(R.drawable.icon_next_table_44_bg);
        }
        new Timer().schedule(new C05301(), new Date(), WorkRequest.MIN_BACKOFF_MILLIS);
        getBinding().constraintLayout.setOnClickListener(new View.OnClickListener() { // from class: com.yd.android_brand_mvp.landscape.university.-$$Lambda$UniversityNextReservationFragment$6dx9z-eic4CFakcwq736jiXNegQ
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                UniversityNextReservationFragment.initView$lambda$0(view);
            }
        });
    }

    /* JADX INFO: renamed from: com.yd.android_brand_mvp.landscape.university.UniversityNextReservationFragment$initView$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: UniversityNextReservationFragment.kt */
    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016¨\u0006\u0004"}, d2 = {"com/yd/android_brand_mvp/landscape/university/UniversityNextReservationFragment$initView$1", "Ljava/util/TimerTask;", "run", "", "app_commonRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class C05301 extends TimerTask {
        C05301() {
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            FragmentActivity activity = UniversityNextReservationFragment.this.getActivity();
            if (activity != null) {
                final UniversityNextReservationFragment universityNextReservationFragment = UniversityNextReservationFragment.this;
                activity.runOnUiThread(new Runnable() { // from class: com.yd.android_brand_mvp.landscape.university.-$$Lambda$UniversityNextReservationFragment$initView$1$PYiE4tmdUsTl-2HKhAChZOZSL6s
                    @Override // java.lang.Runnable
                    public final void run() {
                        UniversityNextReservationFragment.C05301.run$lambda$0(universityNextReservationFragment);
                    }
                });
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void run$lambda$0(UniversityNextReservationFragment this$0) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            this$0.setTable();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void setTable() {
        String string;
        String str;
        List<ReservationRecordBean> reservationToDayList = SpData.getReservationToDayList();
        if (reservationToDayList != null) {
            for (ReservationRecordBean reservationRecordBean : reservationToDayList) {
                if (isTable(reservationRecordBean.getStartTimeStr(), reservationRecordBean.getEndTimeStr())) {
                    if (reservationRecordBean != null) {
                        getBinding().tvTitle.setText("即将开始的" + reservationRecordBean.getSiteBookingTypeName());
                        Bundle arguments = getArguments();
                        if (arguments == null || (string = arguments.getString("type")) == null) {
                            string = "hbreservation24";
                        }
                        if (string.hashCode() == 983425170 && string.equals("hbreservation44")) {
                            getBinding().constraintLayout.setBackgroundResource(TransUtils.INSTANCE.transSiteBookingTypeCodeToBackgroundMax(reservationRecordBean.getSiteBookingTypeCode()));
                        } else {
                            getBinding().constraintLayout.setBackgroundResource(TransUtils.INSTANCE.transSiteBookingTypeCodeToBackground24(reservationRecordBean.getSiteBookingTypeCode()));
                        }
                        getBinding().tvName.setText(reservationRecordBean.getName());
                        String bookingTime = reservationRecordBean.getBookingTime();
                        List<String> listSplit = bookingTime != null ? new Regex("\\s+").split(bookingTime, 0) : null;
                        getBinding().tvTime.setText((listSplit == null || (str = listSplit.get(1)) == null) ? "" : str);
                        return;
                    }
                    return;
                }
            }
        }
        getBinding().tvTitle.setText("暂无预约");
        getBinding().tvTime.setText("");
        getBinding().tvName.setText("");
    }

    public final boolean isTable(String startTime, String endTime) {
        long j = TimeUtil.gettime(startTime);
        TimeUtil.gettime(endTime);
        return j >= TimeUtil.gettime(TimeUtil.stampToDate8(System.currentTimeMillis()));
    }

    /* JADX INFO: compiled from: UniversityNextReservationFragment.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0007¨\u0006\u0007"}, d2 = {"Lcom/yd/android_brand_mvp/landscape/university/UniversityNextReservationFragment$Companion;", "", "()V", "newInstance", "Lcom/yd/android_brand_mvp/landscape/university/UniversityNextReservationFragment;", RemoteMessageConst.Notification.TAG, "", "app_commonRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final UniversityNextReservationFragment newInstance(String tag) {
            UniversityNextReservationFragment universityNextReservationFragment = new UniversityNextReservationFragment();
            Bundle bundle = new Bundle();
            bundle.putString("type", tag);
            universityNextReservationFragment.setArguments(bundle);
            return universityNextReservationFragment;
        }
    }
}
