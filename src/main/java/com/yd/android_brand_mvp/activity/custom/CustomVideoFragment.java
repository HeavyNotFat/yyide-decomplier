package com.yd.android_brand_mvp.activity.custom;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;
import com.shuyu.gsyvideoplayer.GSYVideoManager;
import com.tencent.qcloud.tim.uikit.utils.TUIKitConstants;
import com.yd.android_brand_mvp.R;
import com.yd.android_brand_mvp.base.KTBaseFragment;
import com.yd.android_brand_mvp.databinding.FragmentCustomVideoBinding;
import com.yd.android_brand_mvp.landscape.video.RecyclerItemNormalHolder;
import com.yd.android_brand_mvp.landscape.video.ViewPagerAdapter;
import com.yd.android_brand_mvp.model.VideoListBean;
import com.yd.android_brand_mvp.model.home.CustomItemBean;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: CustomVideoFragment.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\u0018\u0000 \u00172\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0017B\u0005¢\u0006\u0002\u0010\u0003J\b\u0010\u000b\u001a\u00020\fH\u0002J\u0012\u0010\r\u001a\u00020\f2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0016J\u0010\u0010\u0010\u001a\u00020\f2\u0006\u0010\u0011\u001a\u00020\u0012H\u0002J\u0010\u0010\u0013\u001a\u00020\f2\u0006\u0010\u0014\u001a\u00020\u0012H\u0002J\b\u0010\u0015\u001a\u00020\fH\u0002J\b\u0010\u0016\u001a\u00020\fH\u0002R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\b0\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"Lcom/yd/android_brand_mvp/activity/custom/CustomVideoFragment;", "Lcom/yd/android_brand_mvp/base/KTBaseFragment;", "Lcom/yd/android_brand_mvp/databinding/FragmentCustomVideoBinding;", "()V", "dataList", "", "Lcom/yd/android_brand_mvp/model/VideoListBean$DataBean;", "tips", "Landroid/widget/ImageView;", "viewPagerAdapter", "Lcom/yd/android_brand_mvp/landscape/video/ViewPagerAdapter;", "initView", "", "onActivityCreated", "savedInstanceState", "Landroid/os/Bundle;", "play", "position", "", "setImageBackground", "selectItems", "setIndicator", "updateData", "Companion", "app_commonRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class CustomVideoFragment extends KTBaseFragment<FragmentCustomVideoBinding> {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private List<VideoListBean.DataBean> dataList;
    private List<ImageView> tips;
    private ViewPagerAdapter viewPagerAdapter;

    /* JADX INFO: renamed from: com.yd.android_brand_mvp.activity.custom.CustomVideoFragment$1, reason: invalid class name */
    /* JADX INFO: compiled from: CustomVideoFragment.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements Function3<LayoutInflater, ViewGroup, Boolean, FragmentCustomVideoBinding> {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        AnonymousClass1() {
            super(3, FragmentCustomVideoBinding.class, "inflate", "inflate(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Z)Lcom/yd/android_brand_mvp/databinding/FragmentCustomVideoBinding;", 0);
        }

        public final FragmentCustomVideoBinding invoke(LayoutInflater p0, ViewGroup viewGroup, boolean z) {
            Intrinsics.checkNotNullParameter(p0, "p0");
            return FragmentCustomVideoBinding.inflate(p0, viewGroup, z);
        }

        @Override // kotlin.jvm.functions.Function3
        public /* bridge */ /* synthetic */ FragmentCustomVideoBinding invoke(LayoutInflater layoutInflater, ViewGroup viewGroup, Boolean bool) {
            return invoke(layoutInflater, viewGroup, bool.booleanValue());
        }
    }

    public CustomVideoFragment() {
        super(AnonymousClass1.INSTANCE);
        this.dataList = new ArrayList();
        this.tips = new ArrayList();
    }

    public static final /* synthetic */ FragmentCustomVideoBinding access$getBinding(CustomVideoFragment customVideoFragment) {
        return customVideoFragment.getBinding();
    }

    /* JADX INFO: compiled from: CustomVideoFragment.kt */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001e\u0010\u0003\u001a\u00020\u00042\u0016\u0010\u0005\u001a\u0012\u0012\u0004\u0012\u00020\u00070\u0006j\b\u0012\u0004\u0012\u00020\u0007`\b¨\u0006\t"}, d2 = {"Lcom/yd/android_brand_mvp/activity/custom/CustomVideoFragment$Companion;", "", "()V", "newInstance", "Lcom/yd/android_brand_mvp/activity/custom/CustomVideoFragment;", "dataList", "Ljava/util/ArrayList;", "Lcom/yd/android_brand_mvp/model/home/CustomItemBean;", "Lkotlin/collections/ArrayList;", "app_commonRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final CustomVideoFragment newInstance(ArrayList<CustomItemBean> dataList) {
            Intrinsics.checkNotNullParameter(dataList, "dataList");
            CustomVideoFragment customVideoFragment = new CustomVideoFragment();
            Bundle bundle = new Bundle();
            bundle.putParcelableArrayList(TUIKitConstants.Selection.LIST, dataList);
            customVideoFragment.setArguments(bundle);
            return customVideoFragment;
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initView();
    }

    private final void initView() {
        Bundle arguments = getArguments();
        ArrayList parcelableArrayList = arguments != null ? arguments.getParcelableArrayList(TUIKitConstants.Selection.LIST) : null;
        if (parcelableArrayList != null) {
            int i = 0;
            for (Object obj : parcelableArrayList) {
                int i2 = i + 1;
                if (i < 0) {
                    CollectionsKt.throwIndexOverflow();
                }
                VideoListBean.DataBean dataBean = new VideoListBean.DataBean();
                dataBean.url = ((CustomItemBean) obj).getContent();
                this.dataList.add(dataBean);
                i = i2;
            }
        }
        this.viewPagerAdapter = new ViewPagerAdapter(requireContext(), this.dataList, false);
        getBinding().viewPager2.setOrientation(0);
        getBinding().viewPager2.setOffscreenPageLimit(2);
        ViewPagerAdapter viewPagerAdapter = this.viewPagerAdapter;
        if (viewPagerAdapter != null) {
            viewPagerAdapter.setOnNext(new ViewPagerAdapter.OnNext() { // from class: com.yd.android_brand_mvp.activity.custom.-$$Lambda$CustomVideoFragment$3Aj9rZx-EwLPvZC4ApBLp0Ac0AU
                @Override // com.yd.android_brand_mvp.landscape.video.ViewPagerAdapter.OnNext
                public final void next(int i3) {
                    CustomVideoFragment.initView$lambda$1(this.f$0, i3);
                }
            });
        }
        getBinding().viewPager2.setAdapter(this.viewPagerAdapter);
        getBinding().viewPager2.registerOnPageChangeCallback(new AnonymousClass3());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$1(CustomVideoFragment this$0, int i) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        List<VideoListBean.DataBean> list = this$0.dataList;
        if (list != null && list.size() == 1 && i == 0) {
            this$0.updateData();
        } else {
            this$0.getBinding().viewPager2.setCurrentItem(i);
        }
    }

    /* JADX INFO: renamed from: com.yd.android_brand_mvp.activity.custom.CustomVideoFragment$initView$3, reason: invalid class name */
    /* JADX INFO: compiled from: CustomVideoFragment.kt */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, d2 = {"com/yd/android_brand_mvp/activity/custom/CustomVideoFragment$initView$3", "Landroidx/viewpager2/widget/ViewPager2$OnPageChangeCallback;", "onPageSelected", "", "position", "", "app_commonRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class AnonymousClass3 extends ViewPager2.OnPageChangeCallback {
        AnonymousClass3() {
        }

        @Override // androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
        public void onPageSelected(final int position) {
            super.onPageSelected(position);
            CustomVideoFragment.this.setImageBackground(position);
            ViewPager2 viewPager2 = CustomVideoFragment.access$getBinding(CustomVideoFragment.this).viewPager2;
            final CustomVideoFragment customVideoFragment = CustomVideoFragment.this;
            viewPager2.post(new Runnable() { // from class: com.yd.android_brand_mvp.activity.custom.-$$Lambda$CustomVideoFragment$initView$3$Tfm3tqeU5j0_6dlmmsO0LFDiWyg
                @Override // java.lang.Runnable
                public final void run() {
                    CustomVideoFragment.AnonymousClass3.onPageSelected$lambda$0(position, customVideoFragment);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void onPageSelected$lambda$0(int i, CustomVideoFragment this$0) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            int playPosition = GSYVideoManager.instance().getPlayPosition();
            if (playPosition < 0 || !Intrinsics.areEqual(GSYVideoManager.instance().getPlayTag(), "RecyclerView2List") || i == playPosition) {
                return;
            }
            GSYVideoManager.releaseAllVideos();
            this$0.play(i);
        }
    }

    private final void updateData() {
        Log.d("TAG", "VideoFragment==》updateData: ");
        setIndicator();
        ViewPagerAdapter viewPagerAdapter = this.viewPagerAdapter;
        if (viewPagerAdapter != null && viewPagerAdapter != null) {
            viewPagerAdapter.setListData(this.dataList);
        }
        getBinding().viewPager2.post(new Runnable() { // from class: com.yd.android_brand_mvp.activity.custom.-$$Lambda$CustomVideoFragment$eec_iVWKFYPrbWasUOdNw7TfeME
            @Override // java.lang.Runnable
            public final void run() {
                CustomVideoFragment.updateData$lambda$2(this.f$0);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void updateData$lambda$2(CustomVideoFragment this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.play(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void play(int position) {
        View childAt = getBinding().viewPager2.getChildAt(0);
        Intrinsics.checkNotNull(childAt, "null cannot be cast to non-null type androidx.recyclerview.widget.RecyclerView");
        RecyclerView.ViewHolder viewHolderFindViewHolderForAdapterPosition = ((RecyclerView) childAt).findViewHolderForAdapterPosition(position);
        if (viewHolderFindViewHolderForAdapterPosition != null) {
            ((RecyclerItemNormalHolder) viewHolderFindViewHolderForAdapterPosition).getPlayer().startPlayLogic();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void setImageBackground(int selectItems) {
        int size = this.tips.size();
        for (int i = 0; i < size; i++) {
            if (i == selectItems) {
                this.tips.get(i).setBackgroundResource(R.drawable.bg_img_indicator3);
            } else {
                this.tips.get(i).setBackgroundResource(R.drawable.bg_img_indicator1);
            }
        }
    }

    private final void setIndicator() {
        List<VideoListBean.DataBean> list = this.dataList;
        if (list == null || list.isEmpty()) {
            return;
        }
        getBinding().llIndicator.removeAllViews();
        this.tips = new ArrayList(this.dataList.size());
        int size = this.dataList.size();
        for (int i = 0; i < size; i++) {
            ImageView imageView = new ImageView(this.mActivity);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(6, 6);
            layoutParams.setMargins(8, 0, 0, 0);
            imageView.setLayoutParams(layoutParams);
            imageView.setLeft(20);
            this.tips.add(i, imageView);
            if (i == 0) {
                this.tips.get(i).setBackgroundResource(R.drawable.bg_img_indicator1);
            } else {
                this.tips.get(i).setBackgroundResource(R.drawable.bg_img_indicator3);
            }
            getBinding().llIndicator.addView(imageView);
        }
    }
}
