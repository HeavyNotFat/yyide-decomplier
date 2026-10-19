package com.yd.android_brand_mvp.landscape.university;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import androidx.work.WorkRequest;
import com.yd.android_brand_mvp.activity.KBActivity;
import com.yd.android_brand_mvp.activity.SiteKBActivity;
import com.yd.android_brand_mvp.base.KTBaseFragment;
import com.yd.android_brand_mvp.base.MinaConstants;
import com.yd.android_brand_mvp.databinding.FragmentUniversityNextTableBinding;
import com.yd.android_brand_mvp.model.KBRsp2;
import com.yd.android_brand_mvp.utils.SpData;
import com.yd.android_brand_mvp.utils.TeacherNameUtils;
import com.yd.android_brand_mvp.utils.TimeUtil;
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

/* JADX INFO: compiled from: UniversityNextTableFragment.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \u00192\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0019B\u0005¢\u0006\u0002\u0010\u0003J\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u0005H\u0016J\b\u0010\r\u001a\u00020\u000bH\u0002J\u001a\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011J\u001a\u0010\u0013\u001a\u00020\u000b2\u0006\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0016J\b\u0010\u0018\u001a\u00020\u000bH\u0002R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\t¨\u0006\u001a"}, d2 = {"Lcom/yd/android_brand_mvp/landscape/university/UniversityNextTableFragment;", "Lcom/yd/android_brand_mvp/base/KTBaseFragment;", "Lcom/yd/android_brand_mvp/databinding/FragmentUniversityNextTableBinding;", "()V", "KBType", "", "getKBType", "()I", "setKBType", "(I)V", "UpdataEvent", "", "id", "initView", "isTable", "", "startTime", "", "endTime", "onViewCreated", "view", "Landroid/view/View;", "savedInstanceState", "Landroid/os/Bundle;", "setTable", "Companion", "app_commonRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class UniversityNextTableFragment extends KTBaseFragment<FragmentUniversityNextTableBinding> {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private int KBType;

    @JvmStatic
    public static final UniversityNextTableFragment newInstance() {
        return INSTANCE.newInstance();
    }

    /* JADX INFO: renamed from: com.yd.android_brand_mvp.landscape.university.UniversityNextTableFragment$1, reason: invalid class name */
    /* JADX INFO: compiled from: UniversityNextTableFragment.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements Function3<LayoutInflater, ViewGroup, Boolean, FragmentUniversityNextTableBinding> {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        AnonymousClass1() {
            super(3, FragmentUniversityNextTableBinding.class, "inflate", "inflate(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Z)Lcom/yd/android_brand_mvp/databinding/FragmentUniversityNextTableBinding;", 0);
        }

        public final FragmentUniversityNextTableBinding invoke(LayoutInflater p0, ViewGroup viewGroup, boolean z) {
            Intrinsics.checkNotNullParameter(p0, "p0");
            return FragmentUniversityNextTableBinding.inflate(p0, viewGroup, z);
        }

        @Override // kotlin.jvm.functions.Function3
        public /* bridge */ /* synthetic */ FragmentUniversityNextTableBinding invoke(LayoutInflater layoutInflater, ViewGroup viewGroup, Boolean bool) {
            return invoke(layoutInflater, viewGroup, bool.booleanValue());
        }
    }

    public UniversityNextTableFragment() {
        super(AnonymousClass1.INSTANCE);
        this.KBType = 1;
    }

    public final int getKBType() {
        return this.KBType;
    }

    public final void setKBType(int i) {
        this.KBType = i;
    }

    @Override // com.yd.android_brand_mvp.base.KTBaseFragment, com.yd.android_brand_mvp.base.BaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        initView();
    }

    /* JADX INFO: renamed from: com.yd.android_brand_mvp.landscape.university.UniversityNextTableFragment$initView$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: UniversityNextTableFragment.kt */
    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016¨\u0006\u0004"}, d2 = {"com/yd/android_brand_mvp/landscape/university/UniversityNextTableFragment$initView$1", "Ljava/util/TimerTask;", "run", "", "app_commonRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class C05311 extends TimerTask {
        C05311() {
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            FragmentActivity activity = UniversityNextTableFragment.this.getActivity();
            if (activity != null) {
                final UniversityNextTableFragment universityNextTableFragment = UniversityNextTableFragment.this;
                activity.runOnUiThread(new Runnable() { // from class: com.yd.android_brand_mvp.landscape.university.-$$Lambda$UniversityNextTableFragment$initView$1$H2L4wcMFipaWnwaRvUgfruqW8eg
                    @Override // java.lang.Runnable
                    public final void run() {
                        UniversityNextTableFragment.C05311.run$lambda$0(universityNextTableFragment);
                    }
                });
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void run$lambda$0(UniversityNextTableFragment this$0) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            this$0.setTable();
        }
    }

    private final void initView() {
        new Timer().schedule(new C05311(), new Date(), WorkRequest.MIN_BACKOFF_MILLIS);
        getBinding().constraintLayout.setOnClickListener(new View.OnClickListener() { // from class: com.yd.android_brand_mvp.landscape.university.-$$Lambda$UniversityNextTableFragment$jhQHXVzms8Cas78y0epeWn9PGbE
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                UniversityNextTableFragment.initView$lambda$0(this.f$0, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$0(UniversityNextTableFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (this$0.KBType == 2) {
            this$0.goPermissionsActivity(KBActivity.class);
        } else {
            this$0.goPermissionsActivity(SiteKBActivity.class);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void setTable() {
        KBRsp2.DataDTO dataDTO;
        List<KBRsp2.DataDTO.TimetableListDTO> list;
        String teacherNameByList;
        int intWeekDay = TimeUtil.getIntWeekDay(System.currentTimeMillis());
        KBRsp2 siteKBData = SpData.getSiteKBData();
        if (siteKBData == null && (siteKBData = SpData.KBData()) != null) {
            this.KBType = 2;
        }
        if (siteKBData != null && (dataDTO = siteKBData.data) != null && (list = dataDTO.timetableList) != null) {
            for (KBRsp2.DataDTO.TimetableListDTO timetableListDTO : list) {
                if (Intrinsics.areEqual(timetableListDTO.date, TimeUtil.getCurrentyyyyMMdd()) && timetableListDTO.week == intWeekDay && isTable(timetableListDTO.startTime, timetableListDTO.endTime)) {
                    if (timetableListDTO != null) {
                        getBinding().tvSubjectName.setText(timetableListDTO.subjectName);
                        getBinding().tvSubjectTime.setText(timetableListDTO.startTime + '-' + timetableListDTO.endTime);
                        TextView textView = getBinding().tvNames;
                        List<KBRsp2.DataDTO.TimetableListDTO.TeacherListDTO> teacherList = timetableListDTO.teacherList;
                        if (teacherList != null) {
                            Intrinsics.checkNotNullExpressionValue(teacherList, "teacherList");
                            teacherNameByList = TeacherNameUtils.INSTANCE.getTeacherNameByList(teacherList);
                        } else {
                            teacherNameByList = null;
                        }
                        textView.setText(teacherNameByList);
                        return;
                    }
                    return;
                }
            }
        }
        getBinding().tvSubjectName.setText("暂无课程");
        getBinding().tvSubjectTime.setText("");
        getBinding().tvNames.setText("");
    }

    public final boolean isTable(String startTime, String endTime) {
        long j = TimeUtil.gettime99(startTime);
        TimeUtil.gettime99(endTime);
        return j >= TimeUtil.gettime99(TimeUtil.stampToDate2(System.currentTimeMillis()));
    }

    @Override // com.yd.android_brand_mvp.base.BaseFragment, com.yd.android_brand_mvp.observer.MinaListener
    public void UpdataEvent(int id) {
        super.UpdataEvent(id);
        if (id == MinaConstants.TABLE_CODE) {
            setTable();
        }
    }

    /* JADX INFO: compiled from: UniversityNextTableFragment.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0007¨\u0006\u0005"}, d2 = {"Lcom/yd/android_brand_mvp/landscape/university/UniversityNextTableFragment$Companion;", "", "()V", "newInstance", "Lcom/yd/android_brand_mvp/landscape/university/UniversityNextTableFragment;", "app_commonRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final UniversityNextTableFragment newInstance() {
            UniversityNextTableFragment universityNextTableFragment = new UniversityNextTableFragment();
            universityNextTableFragment.setArguments(new Bundle());
            return universityNextTableFragment;
        }
    }
}
