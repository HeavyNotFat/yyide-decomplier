package com.yd.android_brand_mvp.landscape;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import com.orhanobut.hawk.Hawk;
import com.xiaomi.mipush.sdk.Constants;
import com.yd.android_brand_mvp.R;
import com.yd.android_brand_mvp.base.BaseHawk;
import com.yd.android_brand_mvp.base.KTBaseFragment;
import com.yd.android_brand_mvp.databinding.LayoutSiteMessageSk24Binding;
import com.yd.android_brand_mvp.databinding.LayoutSiteMusicBinding;
import com.yd.android_brand_mvp.databinding.SiteInfoFragmentBinding;
import com.yd.android_brand_mvp.landscape.viewmodel.SiteInfoViewModel;
import com.yd.android_brand_mvp.model.SiteInfoBean;
import com.yd.android_brand_mvp.model.SiteTeacherBean;
import com.yd.android_brand_mvp.utils.SpData;
import com.yyide.facepass.AppExtKt;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: SiteInfoFragment.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u000f2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u000fB\u0005¢\u0006\u0002\u0010\u0003J\b\u0010\u0006\u001a\u00020\u0007H\u0002J\b\u0010\b\u001a\u00020\u0007H\u0002J\u0012\u0010\t\u001a\u00020\u00072\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0016J\u0012\u0010\f\u001a\u00020\u00072\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082.¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lcom/yd/android_brand_mvp/landscape/SiteInfoFragment;", "Lcom/yd/android_brand_mvp/base/KTBaseFragment;", "Lcom/yd/android_brand_mvp/databinding/SiteInfoFragmentBinding;", "()V", "viewModel", "Lcom/yd/android_brand_mvp/landscape/viewmodel/SiteInfoViewModel;", "initView", "", "initViewModel", "onActivityCreated", "savedInstanceState", "Landroid/os/Bundle;", "setData", "data", "Lcom/yd/android_brand_mvp/model/SiteInfoBean;", "Companion", "app_commonRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class SiteInfoFragment extends KTBaseFragment<SiteInfoFragmentBinding> {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final String PARAMS_TAG = "PARAMS_TAG";
    private SiteInfoViewModel viewModel;

    /* JADX INFO: renamed from: com.yd.android_brand_mvp.landscape.SiteInfoFragment$1, reason: invalid class name */
    /* JADX INFO: compiled from: SiteInfoFragment.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements Function3<LayoutInflater, ViewGroup, Boolean, SiteInfoFragmentBinding> {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        AnonymousClass1() {
            super(3, SiteInfoFragmentBinding.class, "inflate", "inflate(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Z)Lcom/yd/android_brand_mvp/databinding/SiteInfoFragmentBinding;", 0);
        }

        public final SiteInfoFragmentBinding invoke(LayoutInflater p0, ViewGroup viewGroup, boolean z) {
            Intrinsics.checkNotNullParameter(p0, "p0");
            return SiteInfoFragmentBinding.inflate(p0, viewGroup, z);
        }

        @Override // kotlin.jvm.functions.Function3
        public /* bridge */ /* synthetic */ SiteInfoFragmentBinding invoke(LayoutInflater layoutInflater, ViewGroup viewGroup, Boolean bool) {
            return invoke(layoutInflater, viewGroup, bool.booleanValue());
        }
    }

    public SiteInfoFragment() {
        super(AnonymousClass1.INSTANCE);
    }

    /* JADX INFO: compiled from: SiteInfoFragment.kt */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\u0004R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Lcom/yd/android_brand_mvp/landscape/SiteInfoFragment$Companion;", "", "()V", SiteInfoFragment.PARAMS_TAG, "", "newInstance", "Landroidx/fragment/app/Fragment;", "type", "app_commonRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final Fragment newInstance(String type) {
            SiteInfoFragment siteInfoFragment = new SiteInfoFragment();
            Bundle bundle = new Bundle();
            bundle.putString(SiteInfoFragment.PARAMS_TAG, type);
            siteInfoFragment.setArguments(bundle);
            return siteInfoFragment;
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        this.viewModel = (SiteInfoViewModel) new ViewModelProvider(this).get(SiteInfoViewModel.class);
        initView();
        initViewModel();
        if (SpData.NewUser() == null || SpData.NewUser().data == null || TextUtils.isEmpty(SpData.getSiteId())) {
            return;
        }
        SiteInfoViewModel siteInfoViewModel = this.viewModel;
        if (siteInfoViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            siteInfoViewModel = null;
        }
        String siteId = SpData.getSiteId();
        Intrinsics.checkNotNullExpressionValue(siteId, "getSiteId()");
        siteInfoViewModel.getSiteInfo(siteId);
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    private final void initView() {
        ConstraintLayout constraintLayout;
        ConstraintLayout constraintLayout2;
        ConstraintLayout constraintLayout3;
        ConstraintLayout constraintLayout4;
        ConstraintLayout constraintLayout5;
        ConstraintLayout constraintLayout6;
        ConstraintLayout constraintLayout7;
        ConstraintLayout constraintLayout8;
        ConstraintLayout root;
        ConstraintLayout constraintLayout9 = getBinding().clHB21;
        if (constraintLayout9 != null) {
            constraintLayout9.setVisibility(8);
        }
        ConstraintLayout constraintLayout10 = getBinding().clHB22;
        if (constraintLayout10 != null) {
            constraintLayout10.setVisibility(8);
        }
        ConstraintLayout constraintLayout11 = getBinding().clHB24;
        if (constraintLayout11 != null) {
            constraintLayout11.setVisibility(8);
        }
        ConstraintLayout constraintLayout12 = getBinding().clHB42;
        if (constraintLayout12 != null) {
            constraintLayout12.setVisibility(8);
        }
        ConstraintLayout constraintLayout13 = getBinding().clSB21;
        if (constraintLayout13 != null) {
            constraintLayout13.setVisibility(8);
        }
        ConstraintLayout constraintLayout14 = getBinding().clSB22;
        if (constraintLayout14 != null) {
            constraintLayout14.setVisibility(8);
        }
        ConstraintLayout constraintLayout15 = getBinding().clSB41;
        if (constraintLayout15 != null) {
            constraintLayout15.setVisibility(8);
        }
        getBinding().clSB26.setVisibility(8);
        LayoutSiteMusicBinding layoutSiteMusicBinding = getBinding().music;
        ConstraintLayout root2 = layoutSiteMusicBinding != null ? layoutSiteMusicBinding.getRoot() : null;
        if (root2 != null) {
            root2.setVisibility(8);
        }
        LayoutSiteMessageSk24Binding layoutSiteMessageSk24Binding = getBinding().sk;
        ConstraintLayout root3 = layoutSiteMessageSk24Binding != null ? layoutSiteMessageSk24Binding.getRoot() : null;
        if (root3 != null) {
            root3.setVisibility(8);
        }
        Bundle arguments = getArguments();
        String string = arguments != null ? arguments.getString(PARAMS_TAG) : null;
        AppExtKt.logd(this, "tag =" + string);
        if (string != null) {
            switch (string.hashCode()) {
                case -1728896977:
                    if (string.equals("sbcdxx21") && (constraintLayout = getBinding().clSB21) != null) {
                        constraintLayout.setVisibility(0);
                    }
                    break;
                case -1728896976:
                    if (string.equals("sbcdxx22") && (constraintLayout2 = getBinding().clSB22) != null) {
                        constraintLayout2.setVisibility(0);
                    }
                    break;
                case -1728896915:
                    if (string.equals("sbcdxx41") && (constraintLayout3 = getBinding().clSB41) != null) {
                        constraintLayout3.setVisibility(0);
                    }
                    break;
                case -1728896846:
                    if (string.equals("sbcdxx68") && (constraintLayout4 = getBinding().clSB41) != null) {
                        constraintLayout4.setVisibility(0);
                    }
                    break;
                case -1505986659:
                    if (string.equals("hbsite__drak26")) {
                        getBinding().clSB26.setVisibility(0);
                        getBinding().clSB26.setBackgroundResource(R.drawable.bg_dark50);
                        getBinding().ivLogo.setImageResource(R.drawable.icon_drak_site_head1);
                        getBinding().gankTextview19.setTextColor(-1);
                        getBinding().gankTextview21.setTextColor(-1);
                        getBinding().gankTextview18.setTextColor(-1);
                        getBinding().gankTextview20.setTextColor(-1);
                        getBinding().gankTextview22.setTextColor(-1);
                        getBinding().textview23.setTextColor(-1);
                        getBinding().tvSiteName26.setTextColor(-1);
                        getBinding().tvSiteType26.setTextColor(-1);
                        getBinding().tvSiteNumber26.setTextColor(-1);
                        getBinding().tvSiteAdmin26.setTextColor(-1);
                        getBinding().tvSiteFloor26.setTextColor(-1);
                        getBinding().tvSiteCapacity26.setTextColor(-1);
                        getBinding().tvSiteArea26.setTextColor(-1);
                        TextView textView = getBinding().tvSiteType262;
                        if (textView != null) {
                            textView.setTextColor(-1);
                        }
                        getBinding().ivDrakImg.setVisibility(0);
                        break;
                    }
                    break;
                case 575025818:
                    if (string.equals("hbcdxx21") && (constraintLayout5 = getBinding().clHB21) != null) {
                        constraintLayout5.setVisibility(0);
                    }
                    break;
                case 575025819:
                    if (string.equals("hbcdxx22") && (constraintLayout6 = getBinding().clHB22) != null) {
                        constraintLayout6.setVisibility(0);
                    }
                    break;
                case 575025821:
                    if (string.equals("hbcdxx24") && (constraintLayout7 = getBinding().clHB24) != null) {
                        constraintLayout7.setVisibility(0);
                    }
                    break;
                case 575025823:
                    if (string.equals("hbcdxx26")) {
                        getBinding().clSB26.setVisibility(0);
                        break;
                    }
                    break;
                case 575025881:
                    if (string.equals("hbcdxx42") && (constraintLayout8 = getBinding().clHB42) != null) {
                        constraintLayout8.setVisibility(0);
                    }
                    break;
                case 1038912053:
                    if (string.equals("hbskcd24")) {
                        LayoutSiteMessageSk24Binding layoutSiteMessageSk24Binding2 = getBinding().sk;
                        root = layoutSiteMessageSk24Binding2 != null ? layoutSiteMessageSk24Binding2.clHBsk24 : null;
                        if (root != null) {
                            root.setVisibility(0);
                            break;
                        }
                    }
                    break;
                case 1863841674:
                    if (string.equals("hbmusic_drak86")) {
                        LayoutSiteMusicBinding layoutSiteMusicBinding2 = getBinding().music;
                        root = layoutSiteMusicBinding2 != null ? layoutSiteMusicBinding2.getRoot() : null;
                        if (root != null) {
                            root.setVisibility(0);
                            break;
                        }
                    }
                    break;
            }
        }
    }

    private final void initViewModel() {
        SiteInfoViewModel siteInfoViewModel = this.viewModel;
        if (siteInfoViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            siteInfoViewModel = null;
        }
        LiveData<Result<SiteInfoBean>> siteInfo = siteInfoViewModel.getSiteInfo();
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        final Function1<Result<? extends SiteInfoBean>, Unit> function1 = new Function1<Result<? extends SiteInfoBean>, Unit>() { // from class: com.yd.android_brand_mvp.landscape.SiteInfoFragment.initViewModel.1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Result<? extends SiteInfoBean> result) {
                invoke2(result);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Result<? extends SiteInfoBean> it2) {
                String message;
                Intrinsics.checkNotNullExpressionValue(it2, "it");
                if (!Result.m598isSuccessimpl(it2.getValue())) {
                    SiteInfoFragment.this.setData((SiteInfoBean) Hawk.get(BaseHawk.SITE_INFO));
                    SiteInfoFragment siteInfoFragment = SiteInfoFragment.this;
                    Throwable thM594exceptionOrNullimpl = Result.m594exceptionOrNullimpl(it2.getValue());
                    if (thM594exceptionOrNullimpl == null || (message = thM594exceptionOrNullimpl.getMessage()) == null) {
                        message = "";
                    }
                    AppExtKt.loge(siteInfoFragment, message);
                    return;
                }
                Object value = it2.getValue();
                if (Result.m597isFailureimpl(value)) {
                    value = null;
                }
                SiteInfoFragment.this.setData((SiteInfoBean) value);
            }
        };
        siteInfo.observe(viewLifecycleOwner, new Observer() { // from class: com.yd.android_brand_mvp.landscape.-$$Lambda$SiteInfoFragment$zcQvazxXA00JUUj37_NmRAebRZc
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                SiteInfoFragment.initViewModel$lambda$0(function1, obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initViewModel$lambda$0(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void setData(SiteInfoBean data) {
        if (data != null) {
            Hawk.put(BaseHawk.SITE_INFO, data);
            getBinding().tvSiteName21.setText(data.getName());
            TextView textView = getBinding().tvSiteName22;
            if (textView != null) {
                textView.setText(data.getName());
            }
            getBinding().tvSiteName24.setText(data.getName());
            getBinding().tvSiteName42.setText(data.getName());
            getBinding().tvSiteName26.setText(data.getName());
            LayoutSiteMusicBinding layoutSiteMusicBinding = getBinding().music;
            TextView textView2 = layoutSiteMusicBinding != null ? layoutSiteMusicBinding.tvSiteName24 : null;
            if (textView2 != null) {
                textView2.setText(data.getName());
            }
            LayoutSiteMessageSk24Binding layoutSiteMessageSk24Binding = getBinding().sk;
            TextView textView3 = layoutSiteMessageSk24Binding != null ? layoutSiteMessageSk24Binding.tvSiteNameSk24 : null;
            if (textView3 != null) {
                textView3.setText(data.getName());
            }
            if (!TextUtils.isEmpty(data.getSiteTypeName())) {
                getBinding().tvSiteType.setText(data.getSiteTypeName());
                TextView textView4 = getBinding().tvSiteType24;
                if (textView4 != null) {
                    textView4.setText(data.getSiteTypeName());
                }
                LayoutSiteMusicBinding layoutSiteMusicBinding2 = getBinding().music;
                TextView textView5 = layoutSiteMusicBinding2 != null ? layoutSiteMusicBinding2.tvSiteType26 : null;
                if (textView5 != null) {
                    textView5.setText(data.getSiteTypeName());
                }
                LayoutSiteMessageSk24Binding layoutSiteMessageSk24Binding2 = getBinding().sk;
                TextView textView6 = layoutSiteMessageSk24Binding2 != null ? layoutSiteMessageSk24Binding2.tvSiteTypeSk26 : null;
                if (textView6 != null) {
                    textView6.setText(data.getSiteTypeName());
                }
                TextView textView7 = getBinding().tvSiteType22;
                if (textView7 != null) {
                    textView7.setText(data.getSiteTypeName());
                }
                getBinding().tvSiteType26.setText(data.getSiteTypeName());
                TextView textView8 = getBinding().tvSiteType262;
                if (textView8 != null) {
                    textView8.setText(data.getSiteTypeName());
                }
            }
            if (!TextUtils.isEmpty(data.getRoomNum())) {
                TextView textView9 = getBinding().tvSiteNumber;
                if (textView9 != null) {
                    String roomNum = data.getRoomNum();
                    textView9.setText(roomNum != null ? roomNum : Constants.ACCEPT_TIME_SEPARATOR_SERVER);
                }
                TextView textView10 = getBinding().tvSiteNumber22;
                String roomNum2 = data.getRoomNum();
                textView10.setText(roomNum2 != null ? roomNum2 : Constants.ACCEPT_TIME_SEPARATOR_SERVER);
                TextView textView11 = getBinding().tvSiteNumber24;
                if (textView11 != null) {
                    String roomNum3 = data.getRoomNum();
                    textView11.setText(roomNum3 != null ? roomNum3 : Constants.ACCEPT_TIME_SEPARATOR_SERVER);
                }
                LayoutSiteMusicBinding layoutSiteMusicBinding3 = getBinding().music;
                TextView textView12 = layoutSiteMusicBinding3 != null ? layoutSiteMusicBinding3.tvSiteNumber24 : null;
                if (textView12 != null) {
                    String roomNum4 = data.getRoomNum();
                    textView12.setText(roomNum4 != null ? roomNum4 : Constants.ACCEPT_TIME_SEPARATOR_SERVER);
                }
                LayoutSiteMessageSk24Binding layoutSiteMessageSk24Binding3 = getBinding().sk;
                TextView textView13 = layoutSiteMessageSk24Binding3 != null ? layoutSiteMessageSk24Binding3.tvSiteNumberSk24 : null;
                if (textView13 != null) {
                    String roomNum5 = data.getRoomNum();
                    textView13.setText(roomNum5 != null ? roomNum5 : Constants.ACCEPT_TIME_SEPARATOR_SERVER);
                }
                TextView textView14 = getBinding().tvSiteNumber41;
                if (textView14 != null) {
                    String roomNum6 = data.getRoomNum();
                    textView14.setText(roomNum6 != null ? roomNum6 : Constants.ACCEPT_TIME_SEPARATOR_SERVER);
                }
                TextView textView15 = getBinding().tvSiteNumber26;
                String roomNum7 = data.getRoomNum();
                textView15.setText(roomNum7 != null ? roomNum7 : Constants.ACCEPT_TIME_SEPARATOR_SERVER);
            }
            if (data.getFloor() > 0) {
                TextView textView16 = getBinding().tvSiteFloor22;
                StringBuilder sb = new StringBuilder();
                sb.append(data.getFloor());
                sb.append((char) 27004);
                textView16.setText(sb.toString());
                TextView textView17 = getBinding().tvSiteFloor24;
                if (textView17 != null) {
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append(data.getFloor());
                    sb2.append((char) 27004);
                    textView17.setText(sb2.toString());
                }
                LayoutSiteMusicBinding layoutSiteMusicBinding4 = getBinding().music;
                TextView textView18 = layoutSiteMusicBinding4 != null ? layoutSiteMusicBinding4.tvSiteFloor24 : null;
                if (textView18 != null) {
                    StringBuilder sb3 = new StringBuilder();
                    sb3.append(data.getFloor());
                    sb3.append((char) 27004);
                    textView18.setText(sb3.toString());
                }
                TextView textView19 = getBinding().tvSiteFloor26;
                StringBuilder sb4 = new StringBuilder();
                sb4.append(data.getFloor());
                sb4.append((char) 27004);
                textView19.setText(sb4.toString());
                LayoutSiteMessageSk24Binding layoutSiteMessageSk24Binding4 = getBinding().sk;
                TextView textView20 = layoutSiteMessageSk24Binding4 != null ? layoutSiteMessageSk24Binding4.tvSiteFloorSk24 : null;
                if (textView20 != null) {
                    StringBuilder sb5 = new StringBuilder();
                    sb5.append(data.getFloor());
                    sb5.append((char) 27004);
                    textView20.setText(sb5.toString());
                }
            }
            if (data.getPeppleNum() > 0) {
                TextView textView21 = getBinding().tvSiteCapacity24;
                if (textView21 != null) {
                    textView21.setText(String.valueOf(data.getPeppleNum()));
                }
                TextView textView22 = getBinding().tvSiteCapacity22;
                if (textView22 != null) {
                    textView22.setText(String.valueOf(data.getPeppleNum()));
                }
                TextView textView23 = getBinding().tvSiteCapacityNumber24;
                if (textView23 != null) {
                    textView23.setText(String.valueOf(data.getPeppleNum()));
                }
                LayoutSiteMusicBinding layoutSiteMusicBinding5 = getBinding().music;
                TextView textView24 = layoutSiteMusicBinding5 != null ? layoutSiteMusicBinding5.tvSiteCapacityNumber24 : null;
                if (textView24 != null) {
                    textView24.setText(String.valueOf(data.getPeppleNum()));
                }
                LayoutSiteMessageSk24Binding layoutSiteMessageSk24Binding5 = getBinding().sk;
                TextView textView25 = layoutSiteMessageSk24Binding5 != null ? layoutSiteMessageSk24Binding5.tvSiteCapacityNumberSk24 : null;
                if (textView25 != null) {
                    textView25.setText(String.valueOf(data.getPeppleNum()));
                }
                getBinding().tvSiteCapacity26.setText(String.valueOf(data.getPeppleNum()));
            }
            if (data.getSpace() > 0) {
                TextView textView26 = getBinding().tvSiteArea24;
                if (textView26 != null) {
                    textView26.setText(String.valueOf(data.getSpace()));
                }
                LayoutSiteMusicBinding layoutSiteMusicBinding6 = getBinding().music;
                TextView textView27 = layoutSiteMusicBinding6 != null ? layoutSiteMusicBinding6.tvSiteArea24 : null;
                if (textView27 != null) {
                    textView27.setText(String.valueOf(data.getSpace()));
                }
                LayoutSiteMessageSk24Binding layoutSiteMessageSk24Binding6 = getBinding().sk;
                TextView textView28 = layoutSiteMessageSk24Binding6 != null ? layoutSiteMessageSk24Binding6.tvSiteAreaSk24 : null;
                if (textView28 != null) {
                    textView28.setText(String.valueOf(data.getSpace()));
                }
                getBinding().tvSiteArea26.setText(String.valueOf(data.getSpace()));
            }
            if (!TextUtils.isEmpty(data.getClassesName())) {
                TextView textView29 = getBinding().tvSiteClass24;
                if (textView29 != null) {
                    textView29.setText(data.getClassesName());
                }
                LayoutSiteMusicBinding layoutSiteMusicBinding7 = getBinding().music;
                TextView textView30 = layoutSiteMusicBinding7 != null ? layoutSiteMusicBinding7.tvSiteClass24 : null;
                if (textView30 != null) {
                    textView30.setText(data.getClassesName());
                }
            }
            StringBuilder sb6 = new StringBuilder();
            Iterator<T> it2 = data.getList().iterator();
            while (it2.hasNext()) {
                sb6.append(((SiteTeacherBean) it2.next()).getName());
                sb6.append(Constants.ACCEPT_TIME_SEPARATOR_SP);
            }
            if (TextUtils.isEmpty(sb6.toString())) {
                return;
            }
            TextView textView31 = getBinding().tvSiteAdmin24;
            String string = sb6.toString();
            Intrinsics.checkNotNullExpressionValue(string, "adminNames.toString()");
            String strDropLast = StringsKt.dropLast(string, 1);
            textView31.setText(strDropLast != null ? strDropLast : Constants.ACCEPT_TIME_SEPARATOR_SERVER);
            LayoutSiteMusicBinding layoutSiteMusicBinding8 = getBinding().music;
            TextView textView32 = layoutSiteMusicBinding8 != null ? layoutSiteMusicBinding8.tvSiteAdmin24 : null;
            if (textView32 != null) {
                String string2 = sb6.toString();
                Intrinsics.checkNotNullExpressionValue(string2, "adminNames.toString()");
                String strDropLast2 = StringsKt.dropLast(string2, 1);
                textView32.setText(strDropLast2 != null ? strDropLast2 : Constants.ACCEPT_TIME_SEPARATOR_SERVER);
            }
            LayoutSiteMessageSk24Binding layoutSiteMessageSk24Binding7 = getBinding().sk;
            TextView textView33 = layoutSiteMessageSk24Binding7 != null ? layoutSiteMessageSk24Binding7.tvSiteAdminSk24 : null;
            if (textView33 != null) {
                String string3 = sb6.toString();
                Intrinsics.checkNotNullExpressionValue(string3, "adminNames.toString()");
                String strDropLast3 = StringsKt.dropLast(string3, 1);
                textView33.setText(strDropLast3 != null ? strDropLast3 : Constants.ACCEPT_TIME_SEPARATOR_SERVER);
            }
            TextView textView34 = getBinding().tvAdminName;
            if (textView34 != null) {
                String string4 = sb6.toString();
                Intrinsics.checkNotNullExpressionValue(string4, "adminNames.toString()");
                String strDropLast4 = StringsKt.dropLast(string4, 1);
                textView34.setText(strDropLast4 != null ? strDropLast4 : Constants.ACCEPT_TIME_SEPARATOR_SERVER);
            }
            TextView textView35 = getBinding().tvSiteAdmin26;
            String string5 = sb6.toString();
            Intrinsics.checkNotNullExpressionValue(string5, "adminNames.toString()");
            String strDropLast5 = StringsKt.dropLast(string5, 1);
            textView35.setText(strDropLast5 != null ? strDropLast5 : Constants.ACCEPT_TIME_SEPARATOR_SERVER);
        }
    }
}
