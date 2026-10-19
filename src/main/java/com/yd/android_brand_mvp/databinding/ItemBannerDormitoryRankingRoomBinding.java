package com.yd.android_brand_mvp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.yd.android_brand_mvp.R;

/* JADX INFO: loaded from: classes4.dex */
public final class ItemBannerDormitoryRankingRoomBinding implements ViewBinding {
    private final ConstraintLayout rootView;
    public final TextView tvItemRankingRoomName;
    public final TextView tvItemRankingRoomScore;

    private ItemBannerDormitoryRankingRoomBinding(ConstraintLayout constraintLayout, TextView textView, TextView textView2) {
        this.rootView = constraintLayout;
        this.tvItemRankingRoomName = textView;
        this.tvItemRankingRoomScore = textView2;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static ItemBannerDormitoryRankingRoomBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static ItemBannerDormitoryRankingRoomBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.item_banner_dormitory_ranking_room, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static ItemBannerDormitoryRankingRoomBinding bind(View view) {
        int i = R.id.tv_item_ranking_room_name;
        TextView textView = (TextView) view.findViewById(R.id.tv_item_ranking_room_name);
        if (textView != null) {
            i = R.id.tv_item_ranking_room_score;
            TextView textView2 = (TextView) view.findViewById(R.id.tv_item_ranking_room_score);
            if (textView2 != null) {
                return new ItemBannerDormitoryRankingRoomBinding((ConstraintLayout) view, textView, textView2);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
