package com.yd.android_brand_mvp.landscape.moraleducation.ui;

import android.content.Context;
import android.graphics.Rect;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.blankj.utilcode.util.ScreenUtils;
import com.yd.android_brand_mvp.R;
import com.yd.android_brand_mvp.base.KTBaseFragment;
import com.yd.android_brand_mvp.databinding.FragmentRoepInThisClassBinding;
import com.yd.android_brand_mvp.landscape.moraleducation.model.CurrentMEModel;
import com.yd.android_brand_mvp.landscape.moraleducation.ui.adapter.ROEPITCAdapter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;

/* JADX INFO: compiled from: ROEPInThisClassFragment.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u000b2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u000bB\u0005¢\u0006\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0002J\u001a\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0016¨\u0006\f"}, d2 = {"Lcom/yd/android_brand_mvp/landscape/moraleducation/ui/ROEPInThisClassFragment;", "Lcom/yd/android_brand_mvp/base/KTBaseFragment;", "Lcom/yd/android_brand_mvp/databinding/FragmentRoepInThisClassBinding;", "()V", "initView", "", "onViewCreated", "view", "Landroid/view/View;", "savedInstanceState", "Landroid/os/Bundle;", "Companion", "app_commonRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class ROEPInThisClassFragment extends KTBaseFragment<FragmentRoepInThisClassBinding> {
    private static final String ARG_PARAM1 = "data";

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    @JvmStatic
    public static final ROEPInThisClassFragment newInstance(String str, Long l, String str2, ArrayList<CurrentMEModel> arrayList) {
        return INSTANCE.newInstance(str, l, str2, arrayList);
    }

    /* JADX INFO: renamed from: com.yd.android_brand_mvp.landscape.moraleducation.ui.ROEPInThisClassFragment$1, reason: invalid class name */
    /* JADX INFO: compiled from: ROEPInThisClassFragment.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements Function3<LayoutInflater, ViewGroup, Boolean, FragmentRoepInThisClassBinding> {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        AnonymousClass1() {
            super(3, FragmentRoepInThisClassBinding.class, "inflate", "inflate(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Z)Lcom/yd/android_brand_mvp/databinding/FragmentRoepInThisClassBinding;", 0);
        }

        public final FragmentRoepInThisClassBinding invoke(LayoutInflater p0, ViewGroup viewGroup, boolean z) {
            Intrinsics.checkNotNullParameter(p0, "p0");
            return FragmentRoepInThisClassBinding.inflate(p0, viewGroup, z);
        }

        @Override // kotlin.jvm.functions.Function3
        public /* bridge */ /* synthetic */ FragmentRoepInThisClassBinding invoke(LayoutInflater layoutInflater, ViewGroup viewGroup, Boolean bool) {
            return invoke(layoutInflater, viewGroup, bool.booleanValue());
        }
    }

    public ROEPInThisClassFragment() {
        super(AnonymousClass1.INSTANCE);
    }

    @Override // com.yd.android_brand_mvp.base.KTBaseFragment, com.yd.android_brand_mvp.base.BaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        initView();
    }

    private final void initView() {
        final String string = requireArguments().getString("activityId");
        final long j = requireArguments().getLong("cycleId");
        getBinding().tvClassMoralEducationComparison.setText(requireArguments().getString("title", ""));
        final ArrayList parcelableArrayList = requireArguments().getParcelableArrayList("data");
        if (parcelableArrayList != null) {
            TextView textView = getBinding().tvFlowRedFlagCollectionNumber;
            StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
            String string2 = getResources().getString(R.string.flow_red_flag_collection_number);
            Intrinsics.checkNotNullExpressionValue(string2, "resources.getString(R.st…d_flag_collection_number)");
            Object[] objArr = new Object[1];
            ArrayList arrayList = parcelableArrayList;
            ArrayList arrayList2 = new ArrayList();
            for (Object obj : arrayList) {
                if (((CurrentMEModel) obj).getMWinPrize()) {
                    arrayList2.add(obj);
                }
            }
            objArr[0] = String.valueOf(arrayList2.size());
            String str = String.format(string2, Arrays.copyOf(objArr, 1));
            Intrinsics.checkNotNullExpressionValue(str, "format(format, *args)");
            textView.setText(str);
            getBinding().tvFlowRedFlagCollectionNumber.setOnClickListener(new View.OnClickListener() { // from class: com.yd.android_brand_mvp.landscape.moraleducation.ui.-$$Lambda$ROEPInThisClassFragment$3LrXrOEYYqK5e6OSk7f-QrpHVfI
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    ROEPInThisClassFragment.initView$lambda$4$lambda$2(this.f$0, parcelableArrayList, view);
                }
            });
            int i = 0;
            int i2 = 0;
            for (Object obj2 : arrayList) {
                int i3 = i2 + 1;
                if (i2 < 0) {
                    CollectionsKt.throwIndexOverflow();
                }
                if (Intrinsics.areEqual(((CurrentMEModel) obj2).getMRanking(), "待定")) {
                    i = i2;
                }
                i2 = i3;
            }
            ArrayList arrayList3 = parcelableArrayList;
            Collections.swap(arrayList3, 0, i);
            Context contextRequireContext = requireContext();
            Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext()");
            ROEPITCAdapter rOEPITCAdapter = new ROEPITCAdapter(contextRequireContext, arrayList3, new ROEPITCAdapter.OnItemClickListener() { // from class: com.yd.android_brand_mvp.landscape.moraleducation.ui.ROEPInThisClassFragment$initView$1$roepitcAdapter$1
                @Override // com.yd.android_brand_mvp.landscape.moraleducation.ui.adapter.ROEPITCAdapter.OnItemClickListener
                public void onItemClicked(View view, CurrentMEModel currentMEModel) {
                    Intrinsics.checkNotNullParameter(view, "view");
                    Intrinsics.checkNotNullParameter(currentMEModel, "currentMEModel");
                    DailyScoreDetailsActivity.Companion companion = DailyScoreDetailsActivity.Companion;
                    Context contextRequireContext2 = this.this$0.requireContext();
                    Intrinsics.checkNotNullExpressionValue(contextRequireContext2, "requireContext()");
                    companion.start(contextRequireContext2, string, Long.valueOf(j), currentMEModel);
                }
            });
            getBinding().rvThisClassRanking.setLayoutManager(new GridLayoutManager(requireContext(), ScreenUtils.isLandscape() ? 5 : 3));
            getBinding().rvThisClassRanking.setAdapter(rOEPITCAdapter);
            getBinding().rvThisClassRanking.addItemDecoration(new RecyclerView.ItemDecoration() { // from class: com.yd.android_brand_mvp.landscape.moraleducation.ui.ROEPInThisClassFragment$initView$1$4
                @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
                public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
                    Intrinsics.checkNotNullParameter(outRect, "outRect");
                    Intrinsics.checkNotNullParameter(view, "view");
                    Intrinsics.checkNotNullParameter(parent, "parent");
                    Intrinsics.checkNotNullParameter(state, "state");
                    super.getItemOffsets(outRect, view, parent, state);
                    outRect.bottom = 30;
                    outRect.left = 30;
                }
            });
            rOEPITCAdapter.notifyDataSetChanged();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$4$lambda$2(ROEPInThisClassFragment this$0, ArrayList arrayList, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        CFRFInThisClassActivity.Companion companion = CFRFInThisClassActivity.INSTANCE;
        Context contextRequireContext = this$0.requireContext();
        Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext()");
        ArrayList arrayList2 = new ArrayList();
        for (Object obj : arrayList) {
            if (((CurrentMEModel) obj).getMWinPrize()) {
                arrayList2.add(obj);
            }
        }
        companion.start(contextRequireContext, CollectionsKt.toMutableList((Collection) arrayList2));
    }

    /* JADX INFO: compiled from: ROEPInThisClassFragment.kt */
    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002JC\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\u00042\b\u0010\b\u001a\u0004\u0018\u00010\t2\b\u0010\n\u001a\u0004\u0018\u00010\u00042\u0016\u0010\u000b\u001a\u0012\u0012\u0004\u0012\u00020\r0\fj\b\u0012\u0004\u0012\u00020\r`\u000eH\u0007¢\u0006\u0002\u0010\u000fR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lcom/yd/android_brand_mvp/landscape/moraleducation/ui/ROEPInThisClassFragment$Companion;", "", "()V", "ARG_PARAM1", "", "newInstance", "Lcom/yd/android_brand_mvp/landscape/moraleducation/ui/ROEPInThisClassFragment;", "activityId", "cycleId", "", "title", "data", "Ljava/util/ArrayList;", "Lcom/yd/android_brand_mvp/landscape/moraleducation/model/CurrentMEModel;", "Lkotlin/collections/ArrayList;", "(Ljava/lang/String;Ljava/lang/Long;Ljava/lang/String;Ljava/util/ArrayList;)Lcom/yd/android_brand_mvp/landscape/moraleducation/ui/ROEPInThisClassFragment;", "app_commonRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final ROEPInThisClassFragment newInstance(String activityId, Long cycleId, String title, ArrayList<CurrentMEModel> data) {
            Intrinsics.checkNotNullParameter(data, "data");
            ROEPInThisClassFragment rOEPInThisClassFragment = new ROEPInThisClassFragment();
            Bundle bundle = new Bundle();
            bundle.putString("activityId", activityId);
            bundle.putLong("cycleId", cycleId != null ? cycleId.longValue() : 0L);
            bundle.putString("title", title);
            bundle.putParcelableArrayList("data", data);
            rOEPInThisClassFragment.setArguments(bundle);
            return rOEPInThisClassFragment;
        }
    }
}
