package com.yd.android_brand_mvp.landscape.classes;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.yd.android_brand_mvp.R;
import com.yd.android_brand_mvp.base.KTBaseFragment;
import com.yd.android_brand_mvp.databinding.FragmentClassInfo2Binding;
import com.yd.android_brand_mvp.databinding.ItemClassesWordBinding;
import com.yd.android_brand_mvp.model.NewClassInfoRsp;
import com.yd.android_brand_mvp.model.NewWatchWordRsp;
import com.yd.android_brand_mvp.utils.GlideUtil;
import com.yd.android_brand_mvp.utils.SpData;
import java.util.List;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import skin.support.content.res.SkinCompatResources;

/* JADX INFO: compiled from: ClassInfoFragment4x2.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000+\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0005\u0018\u0000 \r2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\rB\u0005¢\u0006\u0002\u0010\u0003J\u0012\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0016J\b\u0010\u0007\u001a\u00020\nH\u0002R\u0010\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0006R\u000e\u0010\u0007\u001a\u00020\bX\u0082.¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lcom/yd/android_brand_mvp/landscape/classes/ClassInfoFragment4x2;", "Lcom/yd/android_brand_mvp/base/KTBaseFragment;", "Lcom/yd/android_brand_mvp/databinding/FragmentClassInfo2Binding;", "()V", "adapter", "com/yd/android_brand_mvp/landscape/classes/ClassInfoFragment4x2$adapter$1", "Lcom/yd/android_brand_mvp/landscape/classes/ClassInfoFragment4x2$adapter$1;", "viewModel", "Lcom/yd/android_brand_mvp/landscape/classes/ClassInfoViewModel;", "onActivityCreated", "", "savedInstanceState", "Landroid/os/Bundle;", "Companion", "app_commonRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class ClassInfoFragment4x2 extends KTBaseFragment<FragmentClassInfo2Binding> {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final ClassInfoFragment4x2$adapter$1 adapter;
    private ClassInfoViewModel viewModel;

    /* JADX INFO: renamed from: com.yd.android_brand_mvp.landscape.classes.ClassInfoFragment4x2$1, reason: invalid class name */
    /* JADX INFO: compiled from: ClassInfoFragment4x2.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements Function3<LayoutInflater, ViewGroup, Boolean, FragmentClassInfo2Binding> {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        AnonymousClass1() {
            super(3, FragmentClassInfo2Binding.class, "inflate", "inflate(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Z)Lcom/yd/android_brand_mvp/databinding/FragmentClassInfo2Binding;", 0);
        }

        public final FragmentClassInfo2Binding invoke(LayoutInflater p0, ViewGroup viewGroup, boolean z) {
            Intrinsics.checkNotNullParameter(p0, "p0");
            return FragmentClassInfo2Binding.inflate(p0, viewGroup, z);
        }

        @Override // kotlin.jvm.functions.Function3
        public /* bridge */ /* synthetic */ FragmentClassInfo2Binding invoke(LayoutInflater layoutInflater, ViewGroup viewGroup, Boolean bool) {
            return invoke(layoutInflater, viewGroup, bool.booleanValue());
        }
    }

    /* JADX WARN: Type inference failed for: r0v2, types: [com.yd.android_brand_mvp.landscape.classes.ClassInfoFragment4x2$adapter$1] */
    public ClassInfoFragment4x2() {
        super(AnonymousClass1.INSTANCE);
        this.adapter = new BaseQuickAdapter<NewWatchWordRsp.DataDTO, BaseViewHolder>() { // from class: com.yd.android_brand_mvp.landscape.classes.ClassInfoFragment4x2$adapter$1
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.chad.library.adapter.base.BaseQuickAdapter
            public void convert(BaseViewHolder holder, NewWatchWordRsp.DataDTO item) {
                Intrinsics.checkNotNullParameter(holder, "holder");
                Intrinsics.checkNotNullParameter(item, "item");
                ItemClassesWordBinding itemClassesWordBindingBind = ItemClassesWordBinding.bind(holder.itemView);
                Intrinsics.checkNotNullExpressionValue(itemClassesWordBindingBind, "bind(holder.itemView)");
                itemClassesWordBindingBind.tvTitle.setText(item.project + (char) 65306);
                itemClassesWordBindingBind.tvClassMotto.setText(item.projectValue);
            }
        };
    }

    public static final /* synthetic */ FragmentClassInfo2Binding access$getBinding(ClassInfoFragment4x2 classInfoFragment4x2) {
        return classInfoFragment4x2.getBinding();
    }

    /* JADX INFO: compiled from: ClassInfoFragment4x2.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0003\u001a\u00020\u0004¨\u0006\u0005"}, d2 = {"Lcom/yd/android_brand_mvp/landscape/classes/ClassInfoFragment4x2$Companion;", "", "()V", "newInstance", "Lcom/yd/android_brand_mvp/landscape/classes/ClassInfoFragment4x2;", "app_commonRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final ClassInfoFragment4x2 newInstance() {
            return new ClassInfoFragment4x2();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        this.viewModel = (ClassInfoViewModel) new ViewModelProvider(this).get(ClassInfoViewModel.class);
        getBinding().recyclerView.setLayoutManager(new LinearLayoutManager(requireContext()));
        getBinding().recyclerView.setAdapter(this.adapter);
        viewModel();
        ClassInfoViewModel classInfoViewModel = this.viewModel;
        ClassInfoViewModel classInfoViewModel2 = null;
        if (classInfoViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            classInfoViewModel = null;
        }
        classInfoViewModel.getClassesInfo();
        if (SpData.NewUser() == null || SpData.NewUser().data == null) {
            return;
        }
        ClassInfoViewModel classInfoViewModel3 = this.viewModel;
        if (classInfoViewModel3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        } else {
            classInfoViewModel2 = classInfoViewModel3;
        }
        String classesId = SpData.getClassesId();
        Intrinsics.checkNotNullExpressionValue(classesId, "getClassesId()");
        classInfoViewModel2.getWatchWord(classesId);
    }

    private final void viewModel() {
        ClassInfoViewModel classInfoViewModel = this.viewModel;
        ClassInfoViewModel classInfoViewModel2 = null;
        if (classInfoViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            classInfoViewModel = null;
        }
        MutableLiveData<Result<NewClassInfoRsp.DataDTO>> classInfoLiveData = classInfoViewModel.getClassInfoLiveData();
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        final Function1<Result<? extends NewClassInfoRsp.DataDTO>, Unit> function1 = new Function1<Result<? extends NewClassInfoRsp.DataDTO>, Unit>() { // from class: com.yd.android_brand_mvp.landscape.classes.ClassInfoFragment4x2.viewModel.1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Result<? extends NewClassInfoRsp.DataDTO> result) {
                invoke2(result);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Result<? extends NewClassInfoRsp.DataDTO> it2) {
                String str;
                Intrinsics.checkNotNullExpressionValue(it2, "it");
                if (Result.m598isSuccessimpl(it2.getValue())) {
                    Object value = it2.getValue();
                    if (Result.m597isFailureimpl(value)) {
                        value = null;
                    }
                    if (value != null) {
                        TextView textView = ClassInfoFragment4x2.access$getBinding(ClassInfoFragment4x2.this).tvTitle;
                        Object value2 = it2.getValue();
                        if (Result.m597isFailureimpl(value2)) {
                            value2 = null;
                        }
                        NewClassInfoRsp.DataDTO dataDTO = (NewClassInfoRsp.DataDTO) value2;
                        textView.setText((dataDTO == null || (str = dataDTO.classesName) == null) ? "暂无班级" : str);
                        Context contextRequireContext = ClassInfoFragment4x2.this.requireContext();
                        Object value3 = it2.getValue();
                        if (Result.m597isFailureimpl(value3)) {
                            value3 = null;
                        }
                        NewClassInfoRsp.DataDTO dataDTO2 = (NewClassInfoRsp.DataDTO) value3;
                        GlideUtil.loadCircleImage(contextRequireContext, dataDTO2 != null ? dataDTO2.classesIcon : null, ClassInfoFragment4x2.access$getBinding(ClassInfoFragment4x2.this).ivHead);
                        return;
                    }
                }
                ClassInfoFragment4x2.access$getBinding(ClassInfoFragment4x2.this).tvTitle.setText("暂无班级");
                ClassInfoFragment4x2.access$getBinding(ClassInfoFragment4x2.this).ivHead.setImageDrawable(SkinCompatResources.getInstance().getDrawable(R.drawable.duty_defualt_logo));
            }
        };
        classInfoLiveData.observe(viewLifecycleOwner, new Observer() { // from class: com.yd.android_brand_mvp.landscape.classes.-$$Lambda$ClassInfoFragment4x2$vYfUp0mK0_tucm0pPtUVMgWkHJ4
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                ClassInfoFragment4x2.viewModel$lambda$0(function1, obj);
            }
        });
        ClassInfoViewModel classInfoViewModel3 = this.viewModel;
        if (classInfoViewModel3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        } else {
            classInfoViewModel2 = classInfoViewModel3;
        }
        MutableLiveData<Result<List<NewWatchWordRsp.DataDTO>>> watchWordLiveData = classInfoViewModel2.getWatchWordLiveData();
        LifecycleOwner viewLifecycleOwner2 = getViewLifecycleOwner();
        final Function1<Result<? extends List<? extends NewWatchWordRsp.DataDTO>>, Unit> function2 = new Function1<Result<? extends List<? extends NewWatchWordRsp.DataDTO>>, Unit>() { // from class: com.yd.android_brand_mvp.landscape.classes.ClassInfoFragment4x2.viewModel.2
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Result<? extends List<? extends NewWatchWordRsp.DataDTO>> result) {
                invoke2(result);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Result<? extends List<? extends NewWatchWordRsp.DataDTO>> it2) {
                Intrinsics.checkNotNullExpressionValue(it2, "it");
                if (Result.m598isSuccessimpl(it2.getValue())) {
                    Object value = it2.getValue();
                    if (Result.m597isFailureimpl(value)) {
                        value = null;
                    }
                    setList((List) value);
                }
            }
        };
        watchWordLiveData.observe(viewLifecycleOwner2, new Observer() { // from class: com.yd.android_brand_mvp.landscape.classes.-$$Lambda$ClassInfoFragment4x2$UKjaqh6c-R1xeNrLeH-xCqn4Quk
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                ClassInfoFragment4x2.viewModel$lambda$1(function2, obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void viewModel$lambda$0(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void viewModel$lambda$1(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }
}
