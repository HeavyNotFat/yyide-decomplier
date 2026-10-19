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
import androidx.recyclerview.widget.GridLayoutManager;
import com.blankj.utilcode.util.LogUtils;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.google.gson.reflect.TypeToken;
import com.yd.android_brand_mvp.R;
import com.yd.android_brand_mvp.base.KTBaseFragment;
import com.yd.android_brand_mvp.base.MMKVConstant;
import com.yd.android_brand_mvp.databinding.FragmentClassInfo86Binding;
import com.yd.android_brand_mvp.databinding.ItemClassesWordBinding;
import com.yd.android_brand_mvp.model.NewClassInfoRsp;
import com.yd.android_brand_mvp.model.NewWatchWordRsp;
import com.yd.android_brand_mvp.utils.GlideUtil;
import com.yd.android_brand_mvp.utils.MMKVUtils;
import com.yd.android_brand_mvp.utils.SpData;
import com.yd.android_brand_mvp.utils.view.net.GsonUtils;
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

/* JADX INFO: compiled from: ClassInfoFragment8x6.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000+\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0005\u0018\u0000 \r2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\rB\u0005¢\u0006\u0002\u0010\u0003J\u0012\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0016J\b\u0010\u0007\u001a\u00020\nH\u0002R\u0010\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0006R\u000e\u0010\u0007\u001a\u00020\bX\u0082.¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lcom/yd/android_brand_mvp/landscape/classes/ClassInfoFragment8x6;", "Lcom/yd/android_brand_mvp/base/KTBaseFragment;", "Lcom/yd/android_brand_mvp/databinding/FragmentClassInfo86Binding;", "()V", "adapter", "com/yd/android_brand_mvp/landscape/classes/ClassInfoFragment8x6$adapter$1", "Lcom/yd/android_brand_mvp/landscape/classes/ClassInfoFragment8x6$adapter$1;", "viewModel", "Lcom/yd/android_brand_mvp/landscape/classes/ClassInfoViewModel;", "onActivityCreated", "", "savedInstanceState", "Landroid/os/Bundle;", "Companion", "app_commonRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class ClassInfoFragment8x6 extends KTBaseFragment<FragmentClassInfo86Binding> {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final ClassInfoFragment8x6$adapter$1 adapter;
    private ClassInfoViewModel viewModel;

    /* JADX INFO: renamed from: com.yd.android_brand_mvp.landscape.classes.ClassInfoFragment8x6$1, reason: invalid class name */
    /* JADX INFO: compiled from: ClassInfoFragment8x6.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements Function3<LayoutInflater, ViewGroup, Boolean, FragmentClassInfo86Binding> {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        AnonymousClass1() {
            super(3, FragmentClassInfo86Binding.class, "inflate", "inflate(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Z)Lcom/yd/android_brand_mvp/databinding/FragmentClassInfo86Binding;", 0);
        }

        public final FragmentClassInfo86Binding invoke(LayoutInflater p0, ViewGroup viewGroup, boolean z) {
            Intrinsics.checkNotNullParameter(p0, "p0");
            return FragmentClassInfo86Binding.inflate(p0, viewGroup, z);
        }

        @Override // kotlin.jvm.functions.Function3
        public /* bridge */ /* synthetic */ FragmentClassInfo86Binding invoke(LayoutInflater layoutInflater, ViewGroup viewGroup, Boolean bool) {
            return invoke(layoutInflater, viewGroup, bool.booleanValue());
        }
    }

    /* JADX WARN: Type inference failed for: r0v2, types: [com.yd.android_brand_mvp.landscape.classes.ClassInfoFragment8x6$adapter$1] */
    public ClassInfoFragment8x6() {
        super(AnonymousClass1.INSTANCE);
        this.adapter = new BaseQuickAdapter<NewWatchWordRsp.DataDTO, BaseViewHolder>() { // from class: com.yd.android_brand_mvp.landscape.classes.ClassInfoFragment8x6$adapter$1
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.chad.library.adapter.base.BaseQuickAdapter
            public void convert(BaseViewHolder holder, NewWatchWordRsp.DataDTO item) {
                Intrinsics.checkNotNullParameter(holder, "holder");
                Intrinsics.checkNotNullParameter(item, "item");
                ItemClassesWordBinding itemClassesWordBindingBind = ItemClassesWordBinding.bind(holder.itemView);
                Intrinsics.checkNotNullExpressionValue(itemClassesWordBindingBind, "bind(holder.itemView)");
                itemClassesWordBindingBind.tvTitle.setText(item.project + ':');
                itemClassesWordBindingBind.tvClassMotto.setText(item.projectValue);
            }
        };
    }

    public static final /* synthetic */ FragmentClassInfo86Binding access$getBinding(ClassInfoFragment8x6 classInfoFragment8x6) {
        return classInfoFragment8x6.getBinding();
    }

    /* JADX INFO: compiled from: ClassInfoFragment8x6.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0003\u001a\u00020\u0004¨\u0006\u0005"}, d2 = {"Lcom/yd/android_brand_mvp/landscape/classes/ClassInfoFragment8x6$Companion;", "", "()V", "newInstance", "Lcom/yd/android_brand_mvp/landscape/classes/ClassInfoFragment8x6;", "app_commonRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final ClassInfoFragment8x6 newInstance() {
            return new ClassInfoFragment8x6();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        this.viewModel = (ClassInfoViewModel) new ViewModelProvider(this).get(ClassInfoViewModel.class);
        getBinding().recyclerView.setLayoutManager(new GridLayoutManager(requireContext(), 2));
        getBinding().recyclerView.setAdapter(this.adapter);
        setEmptyView(R.layout.item_null_layout_4);
        viewModel();
        ClassInfoViewModel classInfoViewModel = this.viewModel;
        ClassInfoViewModel classInfoViewModel2 = null;
        if (classInfoViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            classInfoViewModel = null;
        }
        classInfoViewModel.getClassesInfo();
        if (SpData.NewUser() != null && SpData.NewUser().data != null) {
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
        NewClassInfoRsp.DataDTO dataDTO = (NewClassInfoRsp.DataDTO) GsonUtils.fromJson(MMKVUtils.INSTANCE.getString(MMKVConstant.CLASS_INFO_86), NewClassInfoRsp.DataDTO.class);
        if (dataDTO != null) {
            TextView textView = getBinding().tvTitle;
            String str = dataDTO.classesName;
            textView.setText(str != null ? str : "暂无班级");
            getBinding().tvTeacherName.setText(dataDTO.f2016master);
            GlideUtil.loadCircleImage2(requireContext(), dataDTO.classesIcon, getBinding().ivHead);
        } else {
            getBinding().tvTitle.setText("暂无班级");
            getBinding().tvTeacherName.setText("");
            getBinding().ivHead.setImageDrawable(SkinCompatResources.getInstance().getDrawable(R.drawable.duty_defualt_logo));
        }
        setList((List) GsonUtils.fromJson(MMKVUtils.INSTANCE.getString(MMKVConstant.CLASS_INFO_86_LIST), new TypeToken<List<? extends NewWatchWordRsp.DataDTO>>() { // from class: com.yd.android_brand_mvp.landscape.classes.ClassInfoFragment8x6$onActivityCreated$list$1
        }.getType()));
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
        final Function1<Result<? extends NewClassInfoRsp.DataDTO>, Unit> function1 = new Function1<Result<? extends NewClassInfoRsp.DataDTO>, Unit>() { // from class: com.yd.android_brand_mvp.landscape.classes.ClassInfoFragment8x6.viewModel.1
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
                Object[] objArr = new Object[1];
                StringBuilder sb = new StringBuilder();
                sb.append("8x6班级信息 = ");
                Intrinsics.checkNotNullExpressionValue(it2, "it");
                Object value = it2.getValue();
                if (Result.m597isFailureimpl(value)) {
                    value = null;
                }
                sb.append(GsonUtils.toJson(value));
                objArr[0] = sb.toString();
                LogUtils.i(objArr);
                if (Result.m598isSuccessimpl(it2.getValue())) {
                    MMKVUtils mMKVUtils = MMKVUtils.INSTANCE;
                    Object value2 = it2.getValue();
                    if (Result.m597isFailureimpl(value2)) {
                        value2 = null;
                    }
                    mMKVUtils.put(MMKVConstant.CLASS_INFO_86, GsonUtils.toJson(value2));
                    Object value3 = it2.getValue();
                    if (Result.m597isFailureimpl(value3)) {
                        value3 = null;
                    }
                    if (value3 != null) {
                        TextView textView = ClassInfoFragment8x6.access$getBinding(ClassInfoFragment8x6.this).tvTitle;
                        Object value4 = it2.getValue();
                        if (Result.m597isFailureimpl(value4)) {
                            value4 = null;
                        }
                        NewClassInfoRsp.DataDTO dataDTO = (NewClassInfoRsp.DataDTO) value4;
                        if (dataDTO == null || (str = dataDTO.classesName) == null) {
                            str = "暂无班级";
                        }
                        textView.setText(str);
                        TextView textView2 = ClassInfoFragment8x6.access$getBinding(ClassInfoFragment8x6.this).tvTeacherName;
                        Object value5 = it2.getValue();
                        if (Result.m597isFailureimpl(value5)) {
                            value5 = null;
                        }
                        NewClassInfoRsp.DataDTO dataDTO2 = (NewClassInfoRsp.DataDTO) value5;
                        textView2.setText(dataDTO2 != null ? dataDTO2.f2016master : null);
                        Context contextRequireContext = ClassInfoFragment8x6.this.requireContext();
                        Object value6 = it2.getValue();
                        if (Result.m597isFailureimpl(value6)) {
                            value6 = null;
                        }
                        NewClassInfoRsp.DataDTO dataDTO3 = (NewClassInfoRsp.DataDTO) value6;
                        GlideUtil.loadCircleImage2(contextRequireContext, dataDTO3 != null ? dataDTO3.classesIcon : null, ClassInfoFragment8x6.access$getBinding(ClassInfoFragment8x6.this).ivHead);
                    }
                }
            }
        };
        classInfoLiveData.observe(viewLifecycleOwner, new Observer() { // from class: com.yd.android_brand_mvp.landscape.classes.-$$Lambda$ClassInfoFragment8x6$DU6Sa6CEuiN6qKkpOdTyHHGXdJs
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                ClassInfoFragment8x6.viewModel$lambda$0(function1, obj);
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
        final Function1<Result<? extends List<? extends NewWatchWordRsp.DataDTO>>, Unit> function2 = new Function1<Result<? extends List<? extends NewWatchWordRsp.DataDTO>>, Unit>() { // from class: com.yd.android_brand_mvp.landscape.classes.ClassInfoFragment8x6.viewModel.2
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
                Object[] objArr = new Object[1];
                StringBuilder sb = new StringBuilder();
                sb.append("watchWordLiveData = ");
                Intrinsics.checkNotNullExpressionValue(it2, "it");
                Object value = it2.getValue();
                if (Result.m597isFailureimpl(value)) {
                    value = null;
                }
                sb.append(GsonUtils.toJson(value));
                objArr[0] = sb.toString();
                LogUtils.i(objArr);
                if (Result.m598isSuccessimpl(it2.getValue())) {
                    Object value2 = it2.getValue();
                    List list = (List) (Result.m597isFailureimpl(value2) ? null : value2);
                    MMKVUtils.INSTANCE.put(MMKVConstant.CLASS_INFO_86_LIST, GsonUtils.toJson(list));
                    setList(list);
                }
            }
        };
        watchWordLiveData.observe(viewLifecycleOwner2, new Observer() { // from class: com.yd.android_brand_mvp.landscape.classes.-$$Lambda$ClassInfoFragment8x6$rRKVn59otGyoyw7jL_nlGM1SJdI
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                ClassInfoFragment8x6.viewModel$lambda$1(function2, obj);
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
