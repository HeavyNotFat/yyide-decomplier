package com.yd.android_brand_mvp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewpager2.widget.ViewPager2;
import com.yd.android_brand_mvp.R;
import com.yd.android_brand_mvp.weight.MultiStateView;
import com.youth.banner.Banner;

/* JADX INFO: loaded from: classes4.dex */
public final class MessageHomeFragmentNewBinding implements ViewBinding {
    public final RecyclerView articleRecyclerView;
    public final Banner bannerCampus;
    public final Banner bannerPoster;
    public final ConstraintLayout clCampus;
    public final ConstraintLayout clNew;
    public final ConstraintLayout clarticle;
    public final ConstraintLayout clfound;
    public final ConstraintLayout clnotice;
    public final ConstraintLayout clposter;
    public final RecyclerView foundRecyclerView;
    public final ImageView iv1;
    public final ImageView iv2;
    public final ImageView iv3;
    public final ImageView iv4;
    public final ImageView iv5;
    public final ImageView iv6;
    public final ImageView ivLeft;
    public final ImageView ivRight;
    public final MultiStateView muCampus;
    public final MultiStateView muPoster;
    public final ViewPager2 noticeViewPager2;
    private final ConstraintLayout rootView;
    public final TextView top2;
    public final TextView top3;
    public final TextView top4;
    public final TextView top5;
    public final TextView top6;
    public final TextView topNew;
    public final TextView tvNoticeNext;
    public final TextView tvNoticeNumber;
    public final TextView tvNoticeUp;
    public final ViewPager2 viewPager2;

    private MessageHomeFragmentNewBinding(ConstraintLayout constraintLayout, RecyclerView recyclerView, Banner banner, Banner banner2, ConstraintLayout constraintLayout2, ConstraintLayout constraintLayout3, ConstraintLayout constraintLayout4, ConstraintLayout constraintLayout5, ConstraintLayout constraintLayout6, ConstraintLayout constraintLayout7, RecyclerView recyclerView2, ImageView imageView, ImageView imageView2, ImageView imageView3, ImageView imageView4, ImageView imageView5, ImageView imageView6, ImageView imageView7, ImageView imageView8, MultiStateView multiStateView, MultiStateView multiStateView2, ViewPager2 viewPager2, TextView textView, TextView textView2, TextView textView3, TextView textView4, TextView textView5, TextView textView6, TextView textView7, TextView textView8, TextView textView9, ViewPager2 viewPager3) {
        this.rootView = constraintLayout;
        this.articleRecyclerView = recyclerView;
        this.bannerCampus = banner;
        this.bannerPoster = banner2;
        this.clCampus = constraintLayout2;
        this.clNew = constraintLayout3;
        this.clarticle = constraintLayout4;
        this.clfound = constraintLayout5;
        this.clnotice = constraintLayout6;
        this.clposter = constraintLayout7;
        this.foundRecyclerView = recyclerView2;
        this.iv1 = imageView;
        this.iv2 = imageView2;
        this.iv3 = imageView3;
        this.iv4 = imageView4;
        this.iv5 = imageView5;
        this.iv6 = imageView6;
        this.ivLeft = imageView7;
        this.ivRight = imageView8;
        this.muCampus = multiStateView;
        this.muPoster = multiStateView2;
        this.noticeViewPager2 = viewPager2;
        this.top2 = textView;
        this.top3 = textView2;
        this.top4 = textView3;
        this.top5 = textView4;
        this.top6 = textView5;
        this.topNew = textView6;
        this.tvNoticeNext = textView7;
        this.tvNoticeNumber = textView8;
        this.tvNoticeUp = textView9;
        this.viewPager2 = viewPager3;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static MessageHomeFragmentNewBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static MessageHomeFragmentNewBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.message_home_fragment_new, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static MessageHomeFragmentNewBinding bind(View view) {
        int i = R.id.article_RecyclerView;
        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.article_RecyclerView);
        if (recyclerView != null) {
            i = R.id.banner_campus;
            Banner banner = (Banner) view.findViewById(R.id.banner_campus);
            if (banner != null) {
                i = R.id.banner_poster;
                Banner banner2 = (Banner) view.findViewById(R.id.banner_poster);
                if (banner2 != null) {
                    i = R.id.clCampus;
                    ConstraintLayout constraintLayout = (ConstraintLayout) view.findViewById(R.id.clCampus);
                    if (constraintLayout != null) {
                        i = R.id.cl_new;
                        ConstraintLayout constraintLayout2 = (ConstraintLayout) view.findViewById(R.id.cl_new);
                        if (constraintLayout2 != null) {
                            i = R.id.clarticle;
                            ConstraintLayout constraintLayout3 = (ConstraintLayout) view.findViewById(R.id.clarticle);
                            if (constraintLayout3 != null) {
                                i = R.id.clfound;
                                ConstraintLayout constraintLayout4 = (ConstraintLayout) view.findViewById(R.id.clfound);
                                if (constraintLayout4 != null) {
                                    i = R.id.clnotice;
                                    ConstraintLayout constraintLayout5 = (ConstraintLayout) view.findViewById(R.id.clnotice);
                                    if (constraintLayout5 != null) {
                                        i = R.id.clposter;
                                        ConstraintLayout constraintLayout6 = (ConstraintLayout) view.findViewById(R.id.clposter);
                                        if (constraintLayout6 != null) {
                                            i = R.id.found_RecyclerView;
                                            RecyclerView recyclerView2 = (RecyclerView) view.findViewById(R.id.found_RecyclerView);
                                            if (recyclerView2 != null) {
                                                i = R.id.iv1;
                                                ImageView imageView = (ImageView) view.findViewById(R.id.iv1);
                                                if (imageView != null) {
                                                    i = R.id.iv2;
                                                    ImageView imageView2 = (ImageView) view.findViewById(R.id.iv2);
                                                    if (imageView2 != null) {
                                                        i = R.id.iv3;
                                                        ImageView imageView3 = (ImageView) view.findViewById(R.id.iv3);
                                                        if (imageView3 != null) {
                                                            i = R.id.iv4;
                                                            ImageView imageView4 = (ImageView) view.findViewById(R.id.iv4);
                                                            if (imageView4 != null) {
                                                                i = R.id.iv5;
                                                                ImageView imageView5 = (ImageView) view.findViewById(R.id.iv5);
                                                                if (imageView5 != null) {
                                                                    i = R.id.iv6;
                                                                    ImageView imageView6 = (ImageView) view.findViewById(R.id.iv6);
                                                                    if (imageView6 != null) {
                                                                        i = R.id.ivLeft;
                                                                        ImageView imageView7 = (ImageView) view.findViewById(R.id.ivLeft);
                                                                        if (imageView7 != null) {
                                                                            i = R.id.ivRight;
                                                                            ImageView imageView8 = (ImageView) view.findViewById(R.id.ivRight);
                                                                            if (imageView8 != null) {
                                                                                i = R.id.mu_campus;
                                                                                MultiStateView multiStateView = (MultiStateView) view.findViewById(R.id.mu_campus);
                                                                                if (multiStateView != null) {
                                                                                    i = R.id.mu_poster;
                                                                                    MultiStateView multiStateView2 = (MultiStateView) view.findViewById(R.id.mu_poster);
                                                                                    if (multiStateView2 != null) {
                                                                                        i = R.id.noticeViewPager2;
                                                                                        ViewPager2 viewPager2 = (ViewPager2) view.findViewById(R.id.noticeViewPager2);
                                                                                        if (viewPager2 != null) {
                                                                                            i = R.id.top2;
                                                                                            TextView textView = (TextView) view.findViewById(R.id.top2);
                                                                                            if (textView != null) {
                                                                                                i = R.id.top3;
                                                                                                TextView textView2 = (TextView) view.findViewById(R.id.top3);
                                                                                                if (textView2 != null) {
                                                                                                    i = R.id.top4;
                                                                                                    TextView textView3 = (TextView) view.findViewById(R.id.top4);
                                                                                                    if (textView3 != null) {
                                                                                                        i = R.id.top5;
                                                                                                        TextView textView4 = (TextView) view.findViewById(R.id.top5);
                                                                                                        if (textView4 != null) {
                                                                                                            i = R.id.top6;
                                                                                                            TextView textView5 = (TextView) view.findViewById(R.id.top6);
                                                                                                            if (textView5 != null) {
                                                                                                                i = R.id.topNew;
                                                                                                                TextView textView6 = (TextView) view.findViewById(R.id.topNew);
                                                                                                                if (textView6 != null) {
                                                                                                                    i = R.id.tvNoticeNext;
                                                                                                                    TextView textView7 = (TextView) view.findViewById(R.id.tvNoticeNext);
                                                                                                                    if (textView7 != null) {
                                                                                                                        i = R.id.tvNoticeNumber;
                                                                                                                        TextView textView8 = (TextView) view.findViewById(R.id.tvNoticeNumber);
                                                                                                                        if (textView8 != null) {
                                                                                                                            i = R.id.tvNoticeUp;
                                                                                                                            TextView textView9 = (TextView) view.findViewById(R.id.tvNoticeUp);
                                                                                                                            if (textView9 != null) {
                                                                                                                                i = R.id.viewPager2;
                                                                                                                                ViewPager2 viewPager3 = (ViewPager2) view.findViewById(R.id.viewPager2);
                                                                                                                                if (viewPager3 != null) {
                                                                                                                                    return new MessageHomeFragmentNewBinding((ConstraintLayout) view, recyclerView, banner, banner2, constraintLayout, constraintLayout2, constraintLayout3, constraintLayout4, constraintLayout5, constraintLayout6, recyclerView2, imageView, imageView2, imageView3, imageView4, imageView5, imageView6, imageView7, imageView8, multiStateView, multiStateView2, viewPager2, textView, textView2, textView3, textView4, textView5, textView6, textView7, textView8, textView9, viewPager3);
                                                                                                                                }
                                                                                                                            }
                                                                                                                        }
                                                                                                                    }
                                                                                                                }
                                                                                                            }
                                                                                                        }
                                                                                                    }
                                                                                                }
                                                                                            }
                                                                                        }
                                                                                    }
                                                                                }
                                                                            }
                                                                        }
                                                                    }
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
