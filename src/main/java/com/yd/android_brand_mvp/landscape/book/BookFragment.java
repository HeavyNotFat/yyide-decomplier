package com.yd.android_brand_mvp.landscape.book;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import com.tencent.qcloud.tim.uikit.utils.SoftKeyBoardUtil;
import com.yd.android_brand_mvp.base.KTBaseFragment;
import com.yd.android_brand_mvp.databinding.FragmentBookDetailBinding;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: BookFragment.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \u001d2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u001dB\u0005¢\u0006\u0002\u0010\u0003J\b\u0010\u0014\u001a\u00020\u0015H\u0016J\u001a\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aH\u0016J\u000e\u0010\u001b\u001a\u00020\u00152\u0006\u0010\u001c\u001a\u00020\u0011R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\n\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001e"}, d2 = {"Lcom/yd/android_brand_mvp/landscape/book/BookFragment;", "Lcom/yd/android_brand_mvp/base/KTBaseFragment;", "Lcom/yd/android_brand_mvp/databinding/FragmentBookDetailBinding;", "()V", "adapter", "Lcom/yd/android_brand_mvp/landscape/book/ViewPagerBookAdapter;", "bookname", "", AppMeasurementSdk.ConditionalUserProperty.NAME, "pagenum", "times", "", "getTimes", "()J", "setTimes", "(J)V", "top", "", "type", "", "onDestroy", "", "onViewCreated", "view", "Landroid/view/View;", "savedInstanceState", "Landroid/os/Bundle;", "setPage", "i", "Companion", "app_commonRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class BookFragment extends KTBaseFragment<FragmentBookDetailBinding> {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private ViewPagerBookAdapter adapter;
    private String bookname;
    private String name;
    private String pagenum;
    private long times;
    private int top;
    private boolean type;

    @JvmStatic
    public static final BookFragment newInstance() {
        return INSTANCE.newInstance();
    }

    /* JADX INFO: renamed from: com.yd.android_brand_mvp.landscape.book.BookFragment$1, reason: invalid class name */
    /* JADX INFO: compiled from: BookFragment.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements Function3<LayoutInflater, ViewGroup, Boolean, FragmentBookDetailBinding> {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        AnonymousClass1() {
            super(3, FragmentBookDetailBinding.class, "inflate", "inflate(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Z)Lcom/yd/android_brand_mvp/databinding/FragmentBookDetailBinding;", 0);
        }

        public final FragmentBookDetailBinding invoke(LayoutInflater p0, ViewGroup viewGroup, boolean z) {
            Intrinsics.checkNotNullParameter(p0, "p0");
            return FragmentBookDetailBinding.inflate(p0, viewGroup, z);
        }

        @Override // kotlin.jvm.functions.Function3
        public /* bridge */ /* synthetic */ FragmentBookDetailBinding invoke(LayoutInflater layoutInflater, ViewGroup viewGroup, Boolean bool) {
            return invoke(layoutInflater, viewGroup, bool.booleanValue());
        }
    }

    public BookFragment() {
        super(AnonymousClass1.INSTANCE);
        this.top = 1;
        this.pagenum = "pagenum";
        this.bookname = "bookname";
        this.name = "";
    }

    /* JADX INFO: compiled from: BookFragment.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0007¨\u0006\u0005"}, d2 = {"Lcom/yd/android_brand_mvp/landscape/book/BookFragment$Companion;", "", "()V", "newInstance", "Lcom/yd/android_brand_mvp/landscape/book/BookFragment;", "app_commonRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final BookFragment newInstance() {
            return new BookFragment();
        }
    }

    @Override // com.yd.android_brand_mvp.base.KTBaseFragment, com.yd.android_brand_mvp.base.BaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        this.adapter = new ViewPagerBookAdapter(getChildFragmentManager());
        ViewPager viewPager = getBinding().viewpager;
        ViewPagerBookAdapter viewPagerBookAdapter = this.adapter;
        if (viewPagerBookAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adapter");
            viewPagerBookAdapter = null;
        }
        viewPager.setAdapter(viewPagerBookAdapter);
        setPage(1);
        setPage(2);
        getBinding().viewpager.setOffscreenPageLimit(2);
        getBinding().viewpager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() { // from class: com.yd.android_brand_mvp.landscape.book.BookFragment.onViewCreated.1
            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageScrollStateChanged(int i) {
            }

            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageScrolled(int i, float v, int i1) {
            }

            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageSelected(int i) {
                BookFragment.this.setPage(i + 1);
            }
        });
        getBinding().left.setOnClickListener(new View.OnClickListener() { // from class: com.yd.android_brand_mvp.landscape.book.-$$Lambda$BookFragment$Ncop4xY0I_bMdQUZf1IDlwhtGvU
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                BookFragment.onViewCreated$lambda$0(this.f$0, view2);
            }
        });
        getBinding().post.setOnClickListener(new View.OnClickListener() { // from class: com.yd.android_brand_mvp.landscape.book.-$$Lambda$BookFragment$HL-ce4Fbl0GhQnIj-r0SQAImnM4
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                BookFragment.onViewCreated$lambda$1(this.f$0, view2);
            }
        });
        getBinding().right.setOnClickListener(new View.OnClickListener() { // from class: com.yd.android_brand_mvp.landscape.book.-$$Lambda$BookFragment$dDji-8ARhLTCn47ju03_cIPQGTc
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                BookFragment.onViewCreated$lambda$2(this.f$0, view2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onViewCreated$lambda$0(BookFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        int currentItem = this$0.getBinding().viewpager.getCurrentItem();
        if (currentItem != 0) {
            this$0.getBinding().viewpager.setCurrentItem(currentItem - 1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onViewCreated$lambda$1(BookFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.name = this$0.getBinding().edit.getText().toString();
        Intent intent = new Intent();
        intent.setAction("Bookname");
        intent.putExtra(AppMeasurementSdk.ConditionalUserProperty.NAME, this$0.name);
        this$0.requireContext().sendBroadcast(intent);
        this$0.getBinding().viewpager.setCurrentItem(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onViewCreated$lambda$2(BookFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        ViewPagerBookAdapter viewPagerBookAdapter = this$0.adapter;
        if (viewPagerBookAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adapter");
            viewPagerBookAdapter = null;
        }
        int count = viewPagerBookAdapter.getCount();
        int currentItem = this$0.getBinding().viewpager.getCurrentItem();
        if (currentItem < count - 1) {
            this$0.getBinding().viewpager.setCurrentItem(currentItem + 1);
        }
    }

    public final long getTimes() {
        return this.times;
    }

    public final void setTimes(long j) {
        this.times = j;
    }

    public final void setPage(int i) {
        BookFragmentPage bookFragmentPage = new BookFragmentPage();
        Bundle bundle = new Bundle();
        bundle.putInt(this.pagenum, i);
        bundle.putString(this.bookname, this.name);
        bookFragmentPage.setArguments(bundle);
        ViewPagerBookAdapter viewPagerBookAdapter = this.adapter;
        if (viewPagerBookAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adapter");
            viewPagerBookAdapter = null;
        }
        viewPagerBookAdapter.addFragment(bookFragmentPage);
        ViewPager viewPager = getBinding().viewpager;
        ViewPagerBookAdapter viewPagerBookAdapter2 = this.adapter;
        if (viewPagerBookAdapter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adapter");
            viewPagerBookAdapter2 = null;
        }
        List<Fragment> list = viewPagerBookAdapter2.list;
        Integer numValueOf = list != null ? Integer.valueOf(list.size()) : null;
        Intrinsics.checkNotNull(numValueOf);
        viewPager.setOffscreenPageLimit(numValueOf.intValue());
    }

    @Override // com.yd.android_brand_mvp.base.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        SoftKeyBoardUtil.hideKeyBoard(getBinding().edit);
    }
}
