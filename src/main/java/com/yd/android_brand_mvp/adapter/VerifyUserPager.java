package com.yd.android_brand_mvp.adapter;

import androidx.fragment.app.Fragment;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import com.yd.android_brand_mvp.activity.common.VerifyCardFragment;
import com.yd.android_brand_mvp.activity.common.VerifyFaceFragment;
import com.yd.android_brand_mvp.activity.common.VerifyQrCodeFragment;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: VerifyUserPager.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0002\u0018\u00002\u00020\u0001B#\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0002\u0010\bJ\u0010\u0010\r\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J\b\u0010\u0010\u001a\u00020\u000fH\u0016R\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0007\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u0011"}, d2 = {"Lcom/yd/android_brand_mvp/adapter/VerifyUserPager;", "Landroidx/viewpager2/adapter/FragmentStateAdapter;", "fragment", "Landroidx/fragment/app/Fragment;", "dataList", "", "", "type", "(Landroidx/fragment/app/Fragment;Ljava/util/List;Ljava/lang/String;)V", "getDataList", "()Ljava/util/List;", "getType", "()Ljava/lang/String;", "createFragment", "position", "", "getItemCount", "app_commonRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class VerifyUserPager extends FragmentStateAdapter {
    private final List<String> dataList;
    private final String type;

    public final List<String> getDataList() {
        return this.dataList;
    }

    public final String getType() {
        return this.type;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public VerifyUserPager(Fragment fragment, List<String> dataList, String type) {
        super(fragment);
        Intrinsics.checkNotNullParameter(fragment, "fragment");
        Intrinsics.checkNotNullParameter(dataList, "dataList");
        Intrinsics.checkNotNullParameter(type, "type");
        this.dataList = dataList;
        this.type = type;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.dataList.size();
    }

    @Override // androidx.viewpager2.adapter.FragmentStateAdapter
    public Fragment createFragment(int position) {
        String str = this.dataList.get(position);
        int iHashCode = str.hashCode();
        if (iHashCode != -952485970) {
            if (iHashCode != 3046160) {
                if (iHashCode == 3135069 && str.equals("face")) {
                    return VerifyFaceFragment.INSTANCE.newInstance(this.type);
                }
            } else if (str.equals("card")) {
                return VerifyCardFragment.INSTANCE.newInstance(this.type);
            }
        } else if (str.equals("qrCode")) {
            return VerifyQrCodeFragment.INSTANCE.newInstance(this.type);
        }
        return VerifyCardFragment.INSTANCE.newInstance(this.type);
    }
}
