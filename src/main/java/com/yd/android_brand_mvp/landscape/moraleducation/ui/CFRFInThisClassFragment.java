package com.yd.android_brand_mvp.landscape.moraleducation.ui;

import android.content.Context;
import android.graphics.Rect;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.yd.android_brand_mvp.base.KTBaseFragment;
import com.yd.android_brand_mvp.databinding.FragmentCfrfInThisClassBinding;
import com.yd.android_brand_mvp.landscape.moraleducation.model.CurrentMEModel;
import com.yd.android_brand_mvp.landscape.moraleducation.ui.adapter.CFRFITCAdapter;
import java.util.ArrayList;
import java.util.Collection;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: CFRFInThisClassFragment.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \n2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\nB\u0005¢\u0006\u0002\u0010\u0003J\u001a\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0016¨\u0006\u000b"}, d2 = {"Lcom/yd/android_brand_mvp/landscape/moraleducation/ui/CFRFInThisClassFragment;", "Lcom/yd/android_brand_mvp/base/KTBaseFragment;", "Lcom/yd/android_brand_mvp/databinding/FragmentCfrfInThisClassBinding;", "()V", "onViewCreated", "", "view", "Landroid/view/View;", "savedInstanceState", "Landroid/os/Bundle;", "Companion", "app_commonRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class CFRFInThisClassFragment extends KTBaseFragment<FragmentCfrfInThisClassBinding> {
    private static final String ARG_PARAM1 = "data";

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    @JvmStatic
    public static final CFRFInThisClassFragment newInstance(ArrayList<CurrentMEModel> arrayList) {
        return INSTANCE.newInstance(arrayList);
    }

    /* JADX INFO: renamed from: com.yd.android_brand_mvp.landscape.moraleducation.ui.CFRFInThisClassFragment$1, reason: invalid class name */
    /* JADX INFO: compiled from: CFRFInThisClassFragment.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements Function3<LayoutInflater, ViewGroup, Boolean, FragmentCfrfInThisClassBinding> {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        AnonymousClass1() {
            super(3, FragmentCfrfInThisClassBinding.class, "inflate", "inflate(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Z)Lcom/yd/android_brand_mvp/databinding/FragmentCfrfInThisClassBinding;", 0);
        }

        public final FragmentCfrfInThisClassBinding invoke(LayoutInflater p0, ViewGroup viewGroup, boolean z) {
            Intrinsics.checkNotNullParameter(p0, "p0");
            return FragmentCfrfInThisClassBinding.inflate(p0, viewGroup, z);
        }

        @Override // kotlin.jvm.functions.Function3
        public /* bridge */ /* synthetic */ FragmentCfrfInThisClassBinding invoke(LayoutInflater layoutInflater, ViewGroup viewGroup, Boolean bool) {
            return invoke(layoutInflater, viewGroup, bool.booleanValue());
        }
    }

    public CFRFInThisClassFragment() {
        super(AnonymousClass1.INSTANCE);
    }

    @Override // com.yd.android_brand_mvp.base.KTBaseFragment, com.yd.android_brand_mvp.base.BaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        if (getArguments() != null) {
            ArrayList parcelableArrayList = requireArguments().getParcelableArrayList("data");
            Context contextRequireContext = requireContext();
            Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext()");
            Intrinsics.checkNotNull(parcelableArrayList);
            CFRFITCAdapter cFRFITCAdapter = new CFRFITCAdapter(contextRequireContext, CollectionsKt.toMutableList((Collection) parcelableArrayList));
            getBinding().rvCfrfInThisClass.setLayoutManager(new GridLayoutManager(requireContext(), 6));
            getBinding().rvCfrfInThisClass.setAdapter(cFRFITCAdapter);
            getBinding().rvCfrfInThisClass.addItemDecoration(new RecyclerView.ItemDecoration() { // from class: com.yd.android_brand_mvp.landscape.moraleducation.ui.CFRFInThisClassFragment$onViewCreated$1$1
                @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
                public void getItemOffsets(Rect outRect, View view2, RecyclerView parent, RecyclerView.State state) {
                    Intrinsics.checkNotNullParameter(outRect, "outRect");
                    Intrinsics.checkNotNullParameter(view2, "view");
                    Intrinsics.checkNotNullParameter(parent, "parent");
                    Intrinsics.checkNotNullParameter(state, "state");
                    super.getItemOffsets(outRect, view2, parent, state);
                    outRect.bottom = 60;
                    outRect.right = 91;
                }
            });
            cFRFITCAdapter.notifyDataSetChanged();
        }
    }

    /* JADX INFO: compiled from: CFRFInThisClassFragment.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J$\u0010\u0005\u001a\u00020\u00062\u001a\u0010\u0007\u001a\u0016\u0012\u0004\u0012\u00020\t\u0018\u00010\bj\n\u0012\u0004\u0012\u00020\t\u0018\u0001`\nH\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lcom/yd/android_brand_mvp/landscape/moraleducation/ui/CFRFInThisClassFragment$Companion;", "", "()V", "ARG_PARAM1", "", "newInstance", "Lcom/yd/android_brand_mvp/landscape/moraleducation/ui/CFRFInThisClassFragment;", "data", "Ljava/util/ArrayList;", "Lcom/yd/android_brand_mvp/landscape/moraleducation/model/CurrentMEModel;", "Lkotlin/collections/ArrayList;", "app_commonRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final CFRFInThisClassFragment newInstance(ArrayList<CurrentMEModel> data) {
            CFRFInThisClassFragment cFRFInThisClassFragment = new CFRFInThisClassFragment();
            Bundle bundle = new Bundle();
            bundle.putParcelableArrayList("data", data);
            cFRFInThisClassFragment.setArguments(bundle);
            return cFRFInThisClassFragment;
        }
    }
}
