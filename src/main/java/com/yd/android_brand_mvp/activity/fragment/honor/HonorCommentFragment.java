package com.yd.android_brand_mvp.activity.fragment.honor;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.yd.android_brand_mvp.R;
import com.yd.android_brand_mvp.activity.fragment.model.HonorCommentViewModel;
import com.yd.android_brand_mvp.base.KTBaseFragment;
import com.yd.android_brand_mvp.databinding.HonorCommentFragmentBinding;
import com.yd.android_brand_mvp.dialog.DialogBean;
import com.yd.android_brand_mvp.dialog.TableClassPopUp;
import com.yd.android_brand_mvp.dialog.TableGradePopUp;
import com.yd.android_brand_mvp.dialog.TableStudentPopUp;
import com.yd.android_brand_mvp.landscape.exam.comments.CommentsHomeFragment;
import com.yd.android_brand_mvp.model.honor.HonorActiveDetailBean;
import com.yd.android_brand_mvp.model.honor.HonorCanScoreClass;
import com.yd.android_brand_mvp.model.honor.HonorCanScoreGrade;
import com.yd.android_brand_mvp.model.honor.HonorCanScoreStudent;
import com.yd.android_brand_mvp.model.honor.HonorScoreListBean;
import com.yd.android_brand_mvp.model.honor.RuleOptionBean;
import com.yd.android_brand_mvp.network.base.SingleLiveEvent;
import com.yd.android_brand_mvp.utils.SpData;
import com.yd.android_brand_mvp.utils.ToastUtil;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;

/* JADX INFO: compiled from: HonorCommentFragment.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u0085\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0006\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0013\u0018\u0000 32\b\u0012\u0004\u0012\u00020\u00020\u0001:\u00013B\u0005¢\u0006\u0002\u0010\u0003J \u0010!\u001a\u00020\"2\u0016\u0010#\u001a\u0012\u0012\u0004\u0012\u00020%0$j\b\u0012\u0004\u0012\u00020%`&H\u0002J \u0010'\u001a\u00020\"2\u0016\u0010#\u001a\u0012\u0012\u0004\u0012\u00020%0$j\b\u0012\u0004\u0012\u00020%`&H\u0002J\b\u0010(\u001a\u00020\"H\u0002J\u001e\u0010)\u001a\b\u0012\u0004\u0012\u00020\u00160\b2\u0006\u0010*\u001a\u00020+2\u0006\u0010,\u001a\u00020+H\u0002J\b\u0010-\u001a\u00020\"H\u0002J\b\u0010.\u001a\u00020\"H\u0002J\u0012\u0010/\u001a\u00020\"2\b\u00100\u001a\u0004\u0018\u000101H\u0016J\b\u00102\u001a\u00020\"H\u0002R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u00020\u0013X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0014R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0017\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u001bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001d\u001a\u0004\u0018\u00010\u001eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020 X\u0082.¢\u0006\u0002\n\u0000¨\u00064"}, d2 = {"Lcom/yd/android_brand_mvp/activity/fragment/honor/HonorCommentFragment;", "Lcom/yd/android_brand_mvp/base/KTBaseFragment;", "Lcom/yd/android_brand_mvp/databinding/HonorCommentFragmentBinding;", "()V", "activeId", "", "classId", "classList", "", "Lcom/yd/android_brand_mvp/model/honor/HonorCanScoreClass;", "classPopUp", "Lcom/yd/android_brand_mvp/dialog/TableClassPopUp;", "data", "Lcom/yd/android_brand_mvp/model/honor/HonorActiveDetailBean;", "gradePopUp", "Lcom/yd/android_brand_mvp/dialog/TableGradePopUp;", "identity", "identityId", "mAdapter", "com/yd/android_brand_mvp/activity/fragment/honor/HonorCommentFragment$mAdapter$1", "Lcom/yd/android_brand_mvp/activity/fragment/honor/HonorCommentFragment$mAdapter$1;", "select", "Lcom/yd/android_brand_mvp/dialog/DialogBean;", "selectClass", "selectGrade", "Lcom/yd/android_brand_mvp/model/honor/HonorCanScoreGrade;", "selectStudent", "Lcom/yd/android_brand_mvp/model/honor/HonorCanScoreStudent;", CommentsHomeFragment.TYPE_ID, "studentPopUp", "Lcom/yd/android_brand_mvp/dialog/TableStudentPopUp;", "viewModel", "Lcom/yd/android_brand_mvp/activity/fragment/model/HonorCommentViewModel;", "commentClass", "", "ruleList", "Ljava/util/ArrayList;", "Lcom/yd/android_brand_mvp/model/honor/RuleOptionBean;", "Lkotlin/collections/ArrayList;", "commentStudent", "getOptionList", "getValue", FirebaseAnalytics.Param.SCORE, "", "maxScore", "initView", "initViewModel", "onActivityCreated", "savedInstanceState", "Landroid/os/Bundle;", "setData", "Companion", "app_commonRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class HonorCommentFragment extends KTBaseFragment<HonorCommentFragmentBinding> {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private String activeId;
    private String classId;
    private List<HonorCanScoreClass> classList;
    private TableClassPopUp classPopUp;
    private HonorActiveDetailBean data;
    private TableGradePopUp gradePopUp;
    private String identity;
    private String identityId;
    private final HonorCommentFragment$mAdapter$1 mAdapter;
    private DialogBean select;
    private HonorCanScoreClass selectClass;
    private HonorCanScoreGrade selectGrade;
    private HonorCanScoreStudent selectStudent;
    private String studentId;
    private TableStudentPopUp studentPopUp;
    private HonorCommentViewModel viewModel;

    /* JADX INFO: renamed from: com.yd.android_brand_mvp.activity.fragment.honor.HonorCommentFragment$1, reason: invalid class name */
    /* JADX INFO: compiled from: HonorCommentFragment.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements Function3<LayoutInflater, ViewGroup, Boolean, HonorCommentFragmentBinding> {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        AnonymousClass1() {
            super(3, HonorCommentFragmentBinding.class, "inflate", "inflate(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Z)Lcom/yd/android_brand_mvp/databinding/HonorCommentFragmentBinding;", 0);
        }

        public final HonorCommentFragmentBinding invoke(LayoutInflater p0, ViewGroup viewGroup, boolean z) {
            Intrinsics.checkNotNullParameter(p0, "p0");
            return HonorCommentFragmentBinding.inflate(p0, viewGroup, z);
        }

        @Override // kotlin.jvm.functions.Function3
        public /* bridge */ /* synthetic */ HonorCommentFragmentBinding invoke(LayoutInflater layoutInflater, ViewGroup viewGroup, Boolean bool) {
            return invoke(layoutInflater, viewGroup, bool.booleanValue());
        }
    }

    public static final /* synthetic */ HonorCommentFragmentBinding access$getBinding(HonorCommentFragment honorCommentFragment) {
        return honorCommentFragment.getBinding();
    }

    public HonorCommentFragment() {
        super(AnonymousClass1.INSTANCE);
        this.classId = "";
        this.studentId = "";
        this.activeId = "";
        this.classList = new ArrayList();
        this.identityId = "";
        this.identity = "";
        this.mAdapter = new HonorCommentFragment$mAdapter$1(this);
    }

    /* JADX INFO: compiled from: HonorCommentFragment.kt */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J$\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\u0010\t\u001a\u0004\u0018\u00010\b¨\u0006\n"}, d2 = {"Lcom/yd/android_brand_mvp/activity/fragment/honor/HonorCommentFragment$Companion;", "", "()V", "newInstance", "Lcom/yd/android_brand_mvp/activity/fragment/honor/HonorCommentFragment;", "data", "Lcom/yd/android_brand_mvp/model/honor/HonorActiveDetailBean;", "identityId", "", "identity", "app_commonRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final HonorCommentFragment newInstance(HonorActiveDetailBean data, String identityId, String identity) {
            HonorCommentFragment honorCommentFragment = new HonorCommentFragment();
            Bundle bundle = new Bundle();
            bundle.putSerializable(HonorCommentFragmentKt.PARAMS_DATA, data);
            bundle.putString(HonorCommentFragmentKt.PARAMS_IDENTITY_ID, identityId);
            bundle.putString(HonorCommentFragmentKt.PARAMS_IDENTITY, identity);
            honorCommentFragment.setArguments(bundle);
            return honorCommentFragment;
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        this.viewModel = (HonorCommentViewModel) new ViewModelProvider(this).get(HonorCommentViewModel.class);
        initView();
    }

    private final void initView() {
        Bundle arguments = getArguments();
        if (arguments != null) {
            String string = arguments.getString(HonorCommentFragmentKt.PARAMS_IDENTITY_ID);
            if (string == null) {
                string = "";
            }
            this.identityId = string;
            String string2 = arguments.getString(HonorCommentFragmentKt.PARAMS_IDENTITY);
            this.identity = string2 != null ? string2 : "";
        }
        getBinding().recyclerView.setLayoutManager(new LinearLayoutManager(requireContext()));
        getBinding().recyclerView.setAdapter(this.mAdapter);
        this.mAdapter.setEmptyView(R.layout.layout_empty);
        Context contextRequireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext()");
        TableStudentPopUp tableStudentPopUp = new TableStudentPopUp(contextRequireContext);
        this.studentPopUp = tableStudentPopUp;
        Intrinsics.checkNotNull(tableStudentPopUp);
        tableStudentPopUp.setPopupGravity(80);
        TableStudentPopUp tableStudentPopUp2 = this.studentPopUp;
        Intrinsics.checkNotNull(tableStudentPopUp2);
        tableStudentPopUp2.setSubmitCallBack(new TableStudentPopUp.SubmitCallBack() { // from class: com.yd.android_brand_mvp.activity.fragment.honor.HonorCommentFragment.initView.2
            @Override // com.yd.android_brand_mvp.dialog.TableStudentPopUp.SubmitCallBack
            public void getSubmitData(HonorCanScoreStudent data) {
                Intrinsics.checkNotNullParameter(data, "data");
                HonorCommentFragment.this.selectStudent = data;
                HonorCommentFragment.access$getBinding(HonorCommentFragment.this).layoutSelect.tvOneName.setText(data.getStudentName());
                HonorCommentFragment.this.getOptionList();
            }
        });
        Context contextRequireContext2 = requireContext();
        Intrinsics.checkNotNullExpressionValue(contextRequireContext2, "requireContext()");
        TableGradePopUp tableGradePopUp = new TableGradePopUp(contextRequireContext2);
        this.gradePopUp = tableGradePopUp;
        Intrinsics.checkNotNull(tableGradePopUp);
        tableGradePopUp.setPopupGravity(80);
        TableGradePopUp tableGradePopUp2 = this.gradePopUp;
        Intrinsics.checkNotNull(tableGradePopUp2);
        tableGradePopUp2.setSubmitCallBack(new TableGradePopUp.SubmitCallBack() { // from class: com.yd.android_brand_mvp.activity.fragment.honor.HonorCommentFragment.initView.3
            @Override // com.yd.android_brand_mvp.dialog.TableGradePopUp.SubmitCallBack
            public void getSubmitData(HonorCanScoreGrade data) {
                Intrinsics.checkNotNullParameter(data, "data");
                HonorCommentFragment.access$getBinding(HonorCommentFragment.this).layoutSelect.tvOneName.setText(data.getGradeName());
                HonorCommentFragment.this.selectGrade = data;
                if (!data.getClassList().isEmpty()) {
                    HonorCanScoreClass honorCanScoreClass = data.getClassList().get(0);
                    HonorCommentFragment.access$getBinding(HonorCommentFragment.this).layoutSelect.tvTwoName.setText(honorCanScoreClass.getClassName());
                    HonorCommentFragment.this.classId = honorCanScoreClass.getClassId();
                    HonorCommentFragment.this.selectClass = honorCanScoreClass;
                    HonorCommentFragment.this.classList = data.getClassList();
                }
                HonorCommentFragment.this.getOptionList();
            }
        });
        Context contextRequireContext3 = requireContext();
        Intrinsics.checkNotNullExpressionValue(contextRequireContext3, "requireContext()");
        TableClassPopUp tableClassPopUp = new TableClassPopUp(contextRequireContext3);
        this.classPopUp = tableClassPopUp;
        Intrinsics.checkNotNull(tableClassPopUp);
        tableClassPopUp.setPopupGravity(80);
        TableClassPopUp tableClassPopUp2 = this.classPopUp;
        Intrinsics.checkNotNull(tableClassPopUp2);
        tableClassPopUp2.setSubmitCallBack(new TableClassPopUp.SubmitCallBack() { // from class: com.yd.android_brand_mvp.activity.fragment.honor.HonorCommentFragment.initView.4
            @Override // com.yd.android_brand_mvp.dialog.TableClassPopUp.SubmitCallBack
            public void getSubmitData(HonorCanScoreClass data) {
                Intrinsics.checkNotNullParameter(data, "data");
                HonorCommentFragment.this.selectClass = data;
                HonorCommentFragment.this.classId = data.getClassId();
                HonorCommentFragment.access$getBinding(HonorCommentFragment.this).layoutSelect.tvTwoName.setText(data.getClassName());
                HonorCommentFragment.this.getOptionList();
            }
        });
        initViewModel();
        setData();
    }

    private final void setData() {
        Bundle arguments = getArguments();
        if (arguments != null) {
            Serializable serializable = arguments.getSerializable(HonorCommentFragmentKt.PARAMS_DATA);
            Intrinsics.checkNotNull(serializable, "null cannot be cast to non-null type com.yd.android_brand_mvp.model.honor.HonorActiveDetailBean");
            HonorActiveDetailBean honorActiveDetailBean = (HonorActiveDetailBean) serializable;
            this.data = honorActiveDetailBean;
            if (honorActiveDetailBean != null) {
                Intrinsics.checkNotNull(honorActiveDetailBean);
                this.activeId = honorActiveDetailBean.getId();
                HonorActiveDetailBean honorActiveDetailBean2 = this.data;
                Intrinsics.checkNotNull(honorActiveDetailBean2);
                if (honorActiveDetailBean2.getScoringMethod() == 2) {
                    TextView textView = getBinding().tvActiveTitle;
                    HonorActiveDetailBean honorActiveDetailBean3 = this.data;
                    Intrinsics.checkNotNull(honorActiveDetailBean3);
                    textView.setText(honorActiveDetailBean3.getTitle());
                    getBinding().layoutSelect.tvSelectDesc.setText("选择班级：");
                    HonorActiveDetailBean honorActiveDetailBean4 = this.data;
                    Intrinsics.checkNotNull(honorActiveDetailBean4);
                    ArrayList<HonorCanScoreGrade> gradeList = honorActiveDetailBean4.getGradeList();
                    if (gradeList != null && gradeList.size() > 0) {
                        if (gradeList.size() > 1) {
                            getBinding().layoutSelect.tvOneName.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
                        }
                        if (true ^ gradeList.get(0).getClassList().isEmpty()) {
                            List<HonorCanScoreClass> classList = gradeList.get(0).getClassList();
                            Intrinsics.checkNotNull(classList, "null cannot be cast to non-null type kotlin.collections.MutableList<com.yd.android_brand_mvp.model.honor.HonorCanScoreClass>");
                            this.classList = TypeIntrinsics.asMutableList(classList);
                            getBinding().layoutSelect.tvOneName.setText(gradeList.get(0).getGradeName());
                            getBinding().layoutSelect.tvTwoName.setText(gradeList.get(0).getClassList().get(0).getClassName());
                            this.selectGrade = gradeList.get(0);
                            this.selectClass = gradeList.get(0).getClassList().get(0);
                            this.classId = String.valueOf(gradeList.get(0).getClassList().get(0).getClassId());
                            getOptionList();
                        }
                    }
                } else {
                    TextView textView2 = getBinding().tvActiveTitle;
                    HonorActiveDetailBean honorActiveDetailBean5 = this.data;
                    Intrinsics.checkNotNull(honorActiveDetailBean5);
                    textView2.setText(honorActiveDetailBean5.getTitle());
                    getBinding().layoutSelect.tvSelectDesc.setText("选择学生：");
                    HonorActiveDetailBean honorActiveDetailBean6 = this.data;
                    Intrinsics.checkNotNull(honorActiveDetailBean6);
                    ArrayList<HonorCanScoreStudent> canScoreStudent = honorActiveDetailBean6.getCanScoreStudent();
                    if (canScoreStudent != null && canScoreStudent.size() > 0) {
                        if (canScoreStudent.size() > 1) {
                            getBinding().layoutSelect.tvOneName.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
                        }
                        this.selectStudent = canScoreStudent.get(0);
                        getBinding().layoutSelect.tvOneName.setText(canScoreStudent.get(0).getStudentName());
                        getBinding().layoutSelect.tvTwoName.setVisibility(4);
                        this.classId = String.valueOf(canScoreStudent.get(0).getClassId());
                        this.studentId = String.valueOf(canScoreStudent.get(0).getStudentId());
                        getOptionList();
                    }
                }
                HonorActiveDetailBean honorActiveDetailBean7 = this.data;
                Intrinsics.checkNotNull(honorActiveDetailBean7);
                if (honorActiveDetailBean7.getScoringMethod() != 2) {
                    getBinding().layoutSelect.tvTwoName.setVisibility(4);
                    getBinding().layoutSelect.tvOneName.setOnClickListener(new View.OnClickListener() { // from class: com.yd.android_brand_mvp.activity.fragment.honor.-$$Lambda$HonorCommentFragment$bAdS_6hrvA1BIxKQun6XPvYDYqw
                        @Override // android.view.View.OnClickListener
                        public final void onClick(View view) {
                            HonorCommentFragment.setData$lambda$10$lambda$4(this.f$0, view);
                        }
                    });
                } else {
                    getBinding().layoutSelect.tvOneName.setOnClickListener(new View.OnClickListener() { // from class: com.yd.android_brand_mvp.activity.fragment.honor.-$$Lambda$HonorCommentFragment$SMts_ueSWalnT2U8e8TyGfxQoOA
                        @Override // android.view.View.OnClickListener
                        public final void onClick(View view) {
                            HonorCommentFragment.setData$lambda$10$lambda$6(this.f$0, view);
                        }
                    });
                    getBinding().layoutSelect.tvTwoName.setOnClickListener(new View.OnClickListener() { // from class: com.yd.android_brand_mvp.activity.fragment.honor.-$$Lambda$HonorCommentFragment$zBHxdXd5f8eyuI-VfYai5utn11Q
                        @Override // android.view.View.OnClickListener
                        public final void onClick(View view) {
                            HonorCommentFragment.setData$lambda$10$lambda$7(this.f$0, view);
                        }
                    });
                }
                getBinding().tvConfirm.setOnClickListener(new View.OnClickListener() { // from class: com.yd.android_brand_mvp.activity.fragment.honor.-$$Lambda$HonorCommentFragment$xTLrp-8AdY7LRs8DeGecEt_-Itc
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        HonorCommentFragment.setData$lambda$10$lambda$9(this.f$0, view);
                    }
                });
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setData$lambda$10$lambda$4(HonorCommentFragment this$0, View view) {
        TableStudentPopUp tableStudentPopUp;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        HonorActiveDetailBean honorActiveDetailBean = this$0.data;
        Intrinsics.checkNotNull(honorActiveDetailBean);
        ArrayList<HonorCanScoreStudent> canScoreStudent = honorActiveDetailBean.getCanScoreStudent();
        if (canScoreStudent != null && (tableStudentPopUp = this$0.studentPopUp) != null) {
            tableStudentPopUp.setData(canScoreStudent, this$0.selectStudent);
        }
        TableStudentPopUp tableStudentPopUp2 = this$0.studentPopUp;
        Intrinsics.checkNotNull(tableStudentPopUp2);
        if (tableStudentPopUp2.isShowing()) {
            TableStudentPopUp tableStudentPopUp3 = this$0.studentPopUp;
            Intrinsics.checkNotNull(tableStudentPopUp3);
            tableStudentPopUp3.dismiss();
        } else {
            TableStudentPopUp tableStudentPopUp4 = this$0.studentPopUp;
            Intrinsics.checkNotNull(tableStudentPopUp4);
            tableStudentPopUp4.showPopupWindow(this$0.getBinding().layoutSelect.tvOneName);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setData$lambda$10$lambda$6(HonorCommentFragment this$0, View view) {
        TableGradePopUp tableGradePopUp;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        HonorActiveDetailBean honorActiveDetailBean = this$0.data;
        Intrinsics.checkNotNull(honorActiveDetailBean);
        ArrayList<HonorCanScoreGrade> gradeList = honorActiveDetailBean.getGradeList();
        if (gradeList != null && (tableGradePopUp = this$0.gradePopUp) != null) {
            tableGradePopUp.setData(gradeList, this$0.selectGrade);
        }
        TableGradePopUp tableGradePopUp2 = this$0.gradePopUp;
        Intrinsics.checkNotNull(tableGradePopUp2);
        if (tableGradePopUp2.isShowing()) {
            TableGradePopUp tableGradePopUp3 = this$0.gradePopUp;
            Intrinsics.checkNotNull(tableGradePopUp3);
            tableGradePopUp3.dismiss();
        } else {
            TableGradePopUp tableGradePopUp4 = this$0.gradePopUp;
            Intrinsics.checkNotNull(tableGradePopUp4);
            tableGradePopUp4.showPopupWindow(this$0.getBinding().layoutSelect.tvOneName);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setData$lambda$10$lambda$7(HonorCommentFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (this$0.classList.size() > 0) {
            TableClassPopUp tableClassPopUp = this$0.classPopUp;
            if (tableClassPopUp != null) {
                tableClassPopUp.setData(this$0.classList, this$0.selectClass);
            }
            TableClassPopUp tableClassPopUp2 = this$0.classPopUp;
            Intrinsics.checkNotNull(tableClassPopUp2);
            if (tableClassPopUp2.isShowing()) {
                TableClassPopUp tableClassPopUp3 = this$0.classPopUp;
                Intrinsics.checkNotNull(tableClassPopUp3);
                tableClassPopUp3.dismiss();
            } else {
                TableClassPopUp tableClassPopUp4 = this$0.classPopUp;
                Intrinsics.checkNotNull(tableClassPopUp4);
                tableClassPopUp4.showPopupWindow(this$0.getBinding().layoutSelect.tvTwoName);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setData$lambda$10$lambda$9(HonorCommentFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        ArrayList<RuleOptionBean> arrayList = new ArrayList<>();
        for (HonorScoreListBean honorScoreListBean : this$0.mAdapter.getData()) {
            if (honorScoreListBean.getWriteScore() != null) {
                arrayList.add(new RuleOptionBean(honorScoreListBean.getWriteScore(), honorScoreListBean.getRuleId()));
            }
        }
        if (arrayList.size() == 0) {
            ToastUtil.showBottomView(this$0.mActivity, "未选择评分项");
            return;
        }
        if (this$0.mAdapter.getData().size() != arrayList.size()) {
            ToastUtil.showBottomView(this$0.mActivity, "请填写完评分项");
            return;
        }
        this$0.getBinding().tvConfirm.setEnabled(false);
        HonorActiveDetailBean honorActiveDetailBean = this$0.data;
        Intrinsics.checkNotNull(honorActiveDetailBean);
        if (honorActiveDetailBean.getScoringMethod() == 2) {
            this$0.commentClass(arrayList);
        } else {
            this$0.commentStudent(arrayList);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void getOptionList() {
        showProgressDialog();
        HonorCommentViewModel honorCommentViewModel = null;
        this.mAdapter.setList(null);
        HonorCommentViewModel honorCommentViewModel2 = this.viewModel;
        if (honorCommentViewModel2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        } else {
            honorCommentViewModel = honorCommentViewModel2;
        }
        honorCommentViewModel.requestClassScoreResult(this.activeId, this.classId, this.identityId);
    }

    private final void commentClass(ArrayList<RuleOptionBean> ruleList) {
        HonorCommentViewModel honorCommentViewModel;
        HonorCommentViewModel honorCommentViewModel2 = this.viewModel;
        if (honorCommentViewModel2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            honorCommentViewModel = null;
        } else {
            honorCommentViewModel = honorCommentViewModel2;
        }
        String schoolId = SpData.getSchoolId();
        String str = this.identityId;
        String str2 = this.identity;
        String str3 = this.activeId;
        HonorCanScoreClass honorCanScoreClass = this.selectClass;
        String classId = honorCanScoreClass != null ? honorCanScoreClass.getClassId() : null;
        HonorCanScoreClass honorCanScoreClass2 = this.selectClass;
        String className = honorCanScoreClass2 != null ? honorCanScoreClass2.getClassName() : null;
        HonorCanScoreGrade honorCanScoreGrade = this.selectGrade;
        String gradeId = honorCanScoreGrade != null ? honorCanScoreGrade.getGradeId() : null;
        HonorCanScoreGrade honorCanScoreGrade2 = this.selectGrade;
        honorCommentViewModel.requestClassScoreComment(schoolId, str, str2, str3, classId, className, gradeId, honorCanScoreGrade2 != null ? honorCanScoreGrade2.getGradeName() : null, ruleList);
    }

    private final void commentStudent(ArrayList<RuleOptionBean> ruleList) {
        HonorCommentViewModel honorCommentViewModel;
        HonorCommentViewModel honorCommentViewModel2 = this.viewModel;
        if (honorCommentViewModel2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            honorCommentViewModel = null;
        } else {
            honorCommentViewModel = honorCommentViewModel2;
        }
        String schoolId = SpData.getSchoolId();
        String str = this.identityId;
        String str2 = this.identity;
        String str3 = this.activeId;
        HonorCanScoreStudent honorCanScoreStudent = this.selectStudent;
        String studentId = honorCanScoreStudent != null ? honorCanScoreStudent.getStudentId() : null;
        HonorCanScoreStudent honorCanScoreStudent2 = this.selectStudent;
        String studentName = honorCanScoreStudent2 != null ? honorCanScoreStudent2.getStudentName() : null;
        HonorCanScoreStudent honorCanScoreStudent3 = this.selectStudent;
        String classId = honorCanScoreStudent3 != null ? honorCanScoreStudent3.getClassId() : null;
        HonorCanScoreStudent honorCanScoreStudent4 = this.selectStudent;
        String className = honorCanScoreStudent4 != null ? honorCanScoreStudent4.getClassName() : null;
        HonorCanScoreStudent honorCanScoreStudent5 = this.selectStudent;
        String gradeId = honorCanScoreStudent5 != null ? honorCanScoreStudent5.getGradeId() : null;
        HonorCanScoreStudent honorCanScoreStudent6 = this.selectStudent;
        honorCommentViewModel.requestStudentScoreComment(schoolId, str, str2, str3, studentId, studentName, classId, className, gradeId, honorCanScoreStudent6 != null ? honorCanScoreStudent6.getGradeName() : null, ruleList);
    }

    private final void initViewModel() {
        HonorCommentViewModel honorCommentViewModel = this.viewModel;
        HonorCommentViewModel honorCommentViewModel2 = null;
        if (honorCommentViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            honorCommentViewModel = null;
        }
        SingleLiveEvent<Result<List<HonorScoreListBean>>> optionListLiveData = honorCommentViewModel.getOptionListLiveData();
        HonorCommentFragment honorCommentFragment = this;
        final Function1<Result<? extends List<HonorScoreListBean>>, Unit> function1 = new Function1<Result<? extends List<HonorScoreListBean>>, Unit>() { // from class: com.yd.android_brand_mvp.activity.fragment.honor.HonorCommentFragment.initViewModel.1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Result<? extends List<HonorScoreListBean>> result) {
                invoke2(result);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Result<? extends List<HonorScoreListBean>> it2) {
                HonorCommentFragment.this.dismissProgressDialog();
                Intrinsics.checkNotNullExpressionValue(it2, "it");
                if (Result.m598isSuccessimpl(it2.getValue())) {
                    HonorCommentFragment$mAdapter$1 honorCommentFragment$mAdapter$1 = HonorCommentFragment.this.mAdapter;
                    Object value = it2.getValue();
                    if (Result.m597isFailureimpl(value)) {
                        value = null;
                    }
                    honorCommentFragment$mAdapter$1.setList((Collection) value);
                    return;
                }
                Result.m594exceptionOrNullimpl(it2.getValue());
            }
        };
        optionListLiveData.observe(honorCommentFragment, new Observer() { // from class: com.yd.android_brand_mvp.activity.fragment.honor.-$$Lambda$HonorCommentFragment$WPRcQVON5dCmDgGds0Qp72rKCLk
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                HonorCommentFragment.initViewModel$lambda$11(function1, obj);
            }
        });
        HonorCommentViewModel honorCommentViewModel3 = this.viewModel;
        if (honorCommentViewModel3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        } else {
            honorCommentViewModel2 = honorCommentViewModel3;
        }
        SingleLiveEvent<Result<String>> commentListLiveData = honorCommentViewModel2.getCommentListLiveData();
        final Function1<Result<? extends String>, Unit> function2 = new Function1<Result<? extends String>, Unit>() { // from class: com.yd.android_brand_mvp.activity.fragment.honor.HonorCommentFragment.initViewModel.2
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
                String message;
                HonorCommentFragment.access$getBinding(HonorCommentFragment.this).tvConfirm.setEnabled(true);
                Intrinsics.checkNotNullExpressionValue(it2, "it");
                if (Result.m598isSuccessimpl(it2.getValue())) {
                    ToastUtil.showBottomView(HonorCommentFragment.this.mActivity, "评分成功");
                    HonorCommentFragment.this.requireActivity().finish();
                    return;
                }
                Result.m594exceptionOrNullimpl(it2.getValue());
                Activity activity = HonorCommentFragment.this.mActivity;
                Throwable thM594exceptionOrNullimpl = Result.m594exceptionOrNullimpl(it2.getValue());
                if (thM594exceptionOrNullimpl == null || (message = thM594exceptionOrNullimpl.getMessage()) == null) {
                    message = "评分异常";
                }
                ToastUtil.showBottomView(activity, message);
            }
        };
        commentListLiveData.observe(honorCommentFragment, new Observer() { // from class: com.yd.android_brand_mvp.activity.fragment.honor.-$$Lambda$HonorCommentFragment$e7bPYppeGxVWAVcMpNrazM0wveI
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                HonorCommentFragment.initViewModel$lambda$12(function2, obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initViewModel$lambda$11(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initViewModel$lambda$12(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final List<DialogBean> getValue(double score, double maxScore) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new DialogBean("", Double.valueOf(score)));
        while (true) {
            if (score == maxScore) {
                return arrayList;
            }
            score += 0.5d;
            arrayList.add(new DialogBean("", Double.valueOf(score)));
        }
    }
}
