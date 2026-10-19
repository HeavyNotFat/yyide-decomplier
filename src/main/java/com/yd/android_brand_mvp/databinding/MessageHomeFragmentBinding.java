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

/* JADX INFO: loaded from: classes4.dex */
public final class MessageHomeFragmentBinding implements ViewBinding {
    public final RecyclerView articleRecyclerView;
    public final RecyclerView campusRecyclerView;
    public final ConstraintLayout clCampus;
    public final ConstraintLayout clarticle;
    public final ConstraintLayout clfound;
    public final ConstraintLayout clnotice;
    public final ConstraintLayout clposter;
    public final RecyclerView foundRecyclerView;
    public final ConstraintLayout gankConstraintlayout;
    public final ImageView iv1;
    public final ImageView iv2;
    public final ImageView iv3;
    public final ImageView iv4;
    public final ImageView iv5;
    public final ImageView iv6;
    public final ImageView ivLeft;
    public final ImageView ivRight;
    public final RecyclerView noticeRecyclerView;
    public final RecyclerView posterRecyclerView;
    private final ConstraintLayout rootView;
    public final TextView top2;
    public final TextView top3;
    public final TextView top4;
    public final TextView top5;
    public final TextView top6;
    public final TextView topNew;
    public final TextView tvArticleMore;
    public final TextView tvCampusMore;
    public final TextView tvFoundMore;
    public final TextView tvNewsMore;
    public final TextView tvNoticeMore;
    public final TextView tvPosterMore;
    public final ViewPager2 viewPager2;

    private MessageHomeFragmentBinding(ConstraintLayout constraintLayout, RecyclerView recyclerView, RecyclerView recyclerView2, ConstraintLayout constraintLayout2, ConstraintLayout constraintLayout3, ConstraintLayout constraintLayout4, ConstraintLayout constraintLayout5, ConstraintLayout constraintLayout6, RecyclerView recyclerView3, ConstraintLayout constraintLayout7, ImageView imageView, ImageView imageView2, ImageView imageView3, ImageView imageView4, ImageView imageView5, ImageView imageView6, ImageView imageView7, ImageView imageView8, RecyclerView recyclerView4, RecyclerView recyclerView5, TextView textView, TextView textView2, TextView textView3, TextView textView4, TextView textView5, TextView textView6, TextView textView7, TextView textView8, TextView textView9, TextView textView10, TextView textView11, TextView textView12, ViewPager2 viewPager2) {
        this.rootView = constraintLayout;
        this.articleRecyclerView = recyclerView;
        this.campusRecyclerView = recyclerView2;
        this.clCampus = constraintLayout2;
        this.clarticle = constraintLayout3;
        this.clfound = constraintLayout4;
        this.clnotice = constraintLayout5;
        this.clposter = constraintLayout6;
        this.foundRecyclerView = recyclerView3;
        this.gankConstraintlayout = constraintLayout7;
        this.iv1 = imageView;
        this.iv2 = imageView2;
        this.iv3 = imageView3;
        this.iv4 = imageView4;
        this.iv5 = imageView5;
        this.iv6 = imageView6;
        this.ivLeft = imageView7;
        this.ivRight = imageView8;
        this.noticeRecyclerView = recyclerView4;
        this.posterRecyclerView = recyclerView5;
        this.top2 = textView;
        this.top3 = textView2;
        this.top4 = textView3;
        this.top5 = textView4;
        this.top6 = textView5;
        this.topNew = textView6;
        this.tvArticleMore = textView7;
        this.tvCampusMore = textView8;
        this.tvFoundMore = textView9;
        this.tvNewsMore = textView10;
        this.tvNoticeMore = textView11;
        this.tvPosterMore = textView12;
        this.viewPager2 = viewPager2;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static MessageHomeFragmentBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static MessageHomeFragmentBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.message_home_fragment, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static MessageHomeFragmentBinding bind(View view) {
        int i = R.id.article_RecyclerView;
        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.article_RecyclerView);
        if (recyclerView != null) {
            i = R.id.campus_RecyclerView;
            RecyclerView recyclerView2 = (RecyclerView) view.findViewById(R.id.campus_RecyclerView);
            if (recyclerView2 != null) {
                i = R.id.clCampus;
                ConstraintLayout constraintLayout = (ConstraintLayout) view.findViewById(R.id.clCampus);
                if (constraintLayout != null) {
                    i = R.id.clarticle;
                    ConstraintLayout constraintLayout2 = (ConstraintLayout) view.findViewById(R.id.clarticle);
                    if (constraintLayout2 != null) {
                        i = R.id.clfound;
                        ConstraintLayout constraintLayout3 = (ConstraintLayout) view.findViewById(R.id.clfound);
                        if (constraintLayout3 != null) {
                            i = R.id.clnotice;
                            ConstraintLayout constraintLayout4 = (ConstraintLayout) view.findViewById(R.id.clnotice);
                            if (constraintLayout4 != null) {
                                i = R.id.clposter;
                                ConstraintLayout constraintLayout5 = (ConstraintLayout) view.findViewById(R.id.clposter);
                                if (constraintLayout5 != null) {
                                    i = R.id.found_RecyclerView;
                                    RecyclerView recyclerView3 = (RecyclerView) view.findViewById(R.id.found_RecyclerView);
                                    if (recyclerView3 != null) {
                                        i = R.id.gank_constraintlayout;
                                        ConstraintLayout constraintLayout6 = (ConstraintLayout) view.findViewById(R.id.gank_constraintlayout);
                                        if (constraintLayout6 != null) {
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
                                                                            i = R.id.noticeRecyclerView;
                                                                            RecyclerView recyclerView4 = (RecyclerView) view.findViewById(R.id.noticeRecyclerView);
                                                                            if (recyclerView4 != null) {
                                                                                i = R.id.poster_RecyclerView;
                                                                                RecyclerView recyclerView5 = (RecyclerView) view.findViewById(R.id.poster_RecyclerView);
                                                                                if (recyclerView5 != null) {
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
                                                                                                            i = R.id.tv_article_more;
                                                                                                            TextView textView7 = (TextView) view.findViewById(R.id.tv_article_more);
                                                                                                            if (textView7 != null) {
                                                                                                                i = R.id.tv_campus_more;
                                                                                                                TextView textView8 = (TextView) view.findViewById(R.id.tv_campus_more);
                                                                                                                if (textView8 != null) {
                                                                                                                    i = R.id.tv_found_more;
                                                                                                                    TextView textView9 = (TextView) view.findViewById(R.id.tv_found_more);
                                                                                                                    if (textView9 != null) {
                                                                                                                        i = R.id.tv_news_more;
                                                                                                                        TextView textView10 = (TextView) view.findViewById(R.id.tv_news_more);
                                                                                                                        if (textView10 != null) {
                                                                                                                            i = R.id.tv_notice_more;
                                                                                                                            TextView textView11 = (TextView) view.findViewById(R.id.tv_notice_more);
                                                                                                                            if (textView11 != null) {
                                                                                                                                i = R.id.tv_poster_more;
                                                                                                                                TextView textView12 = (TextView) view.findViewById(R.id.tv_poster_more);
                                                                                                                                if (textView12 != null) {
                                                                                                                                    i = R.id.viewPager2;
                                                                                                                                    ViewPager2 viewPager2 = (ViewPager2) view.findViewById(R.id.viewPager2);
                                                                                                                                    if (viewPager2 != null) {
                                                                                                                                        return new MessageHomeFragmentBinding((ConstraintLayout) view, recyclerView, recyclerView2, constraintLayout, constraintLayout2, constraintLayout3, constraintLayout4, constraintLayout5, recyclerView3, constraintLayout6, imageView, imageView2, imageView3, imageView4, imageView5, imageView6, imageView7, imageView8, recyclerView4, recyclerView5, textView, textView2, textView3, textView4, textView5, textView6, textView7, textView8, textView9, textView10, textView11, textView12, viewPager2);
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
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
