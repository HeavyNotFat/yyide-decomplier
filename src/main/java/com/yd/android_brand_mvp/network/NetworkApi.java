package com.yd.android_brand_mvp.network;

import com.google.android.exoplayer2.text.ttml.TtmlNode;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.yd.android_brand_mvp.landscape.moraleducation.model.CheckSecurityModel;
import com.yd.android_brand_mvp.landscape.moraleducation.model.FirstIndicatorModel;
import com.yd.android_brand_mvp.landscape.moraleducation.model.IndexClassMEModel;
import com.yd.android_brand_mvp.landscape.moraleducation.model.ScoringDetailCycleModel;
import com.yd.android_brand_mvp.model.AreaBean;
import com.yd.android_brand_mvp.model.AttenceNewListBean;
import com.yd.android_brand_mvp.model.BrandRegistrationCodeRsp;
import com.yd.android_brand_mvp.model.ClassesOverInfoBean;
import com.yd.android_brand_mvp.model.ConfigComplaintBean;
import com.yd.android_brand_mvp.model.DominateDetailLevelBean;
import com.yd.android_brand_mvp.model.FaceActiveConfigBean;
import com.yd.android_brand_mvp.model.KBRsp2;
import com.yd.android_brand_mvp.model.LayoutListRsp;
import com.yd.android_brand_mvp.model.LoginQrCodeBean;
import com.yd.android_brand_mvp.model.MessageCaptionBean;
import com.yd.android_brand_mvp.model.MessageItemBean;
import com.yd.android_brand_mvp.model.MessageListBean;
import com.yd.android_brand_mvp.model.NewBrandLoginRsp;
import com.yd.android_brand_mvp.model.NewClassInfoRsp;
import com.yd.android_brand_mvp.model.NewLoginRsp;
import com.yd.android_brand_mvp.model.NewWatchWordRsp;
import com.yd.android_brand_mvp.model.ScanQrCodeBean;
import com.yd.android_brand_mvp.model.SiteInfoBean;
import com.yd.android_brand_mvp.model.UploadFileBean;
import com.yd.android_brand_mvp.model.UserIcCardBean;
import com.yd.android_brand_mvp.model.VerifyTeacherLoginBean;
import com.yd.android_brand_mvp.model.comments.CommentsDetailBean;
import com.yd.android_brand_mvp.model.duty.DutyModel;
import com.yd.android_brand_mvp.model.getNoticeRsp;
import com.yd.android_brand_mvp.model.getRegistrationCodeRsp;
import com.yd.android_brand_mvp.model.getUserSigByUserIdRsp;
import com.yd.android_brand_mvp.model.home.DominateCustomBean;
import com.yd.android_brand_mvp.model.honor.HonorActiveBean;
import com.yd.android_brand_mvp.model.honor.HonorActiveDetailBean;
import com.yd.android_brand_mvp.model.honor.HonorClassBean;
import com.yd.android_brand_mvp.model.honor.HonorCommentResultBean;
import com.yd.android_brand_mvp.model.honor.HonorGoCommentBean;
import com.yd.android_brand_mvp.model.honor.HonorKidsLIstBean;
import com.yd.android_brand_mvp.model.honor.HonorScoreCycleBean;
import com.yd.android_brand_mvp.model.honor.HonorScoreListBean;
import com.yd.android_brand_mvp.model.honor.HonorStudentBean;
import com.yd.android_brand_mvp.model.honor.HonorWallBean;
import com.yd.android_brand_mvp.model.selectNewStudentByIcCardRsp;
import com.yd.android_brand_mvp.model.selectTeacherByIcCardRsp;
import com.yd.android_brand_mvp.network.base.BaseNetworkApi;
import com.yd.android_brand_mvp.network.base.BasePageResponse;
import com.yyide.chatim_pro.model.honor.HonorScoreDetailBean;
import java.util.List;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;

/* JADX INFO: compiled from: NetworkApi.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000®\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J*\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\u0006\u0010\u0007\u001a\u00020\bH\u0086@ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002ø\u0001\u0002¢\u0006\u0004\b\t\u0010\nJ*\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\f0\u00052\u0006\u0010\u0007\u001a\u00020\bH\u0086@ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002ø\u0001\u0002¢\u0006\u0004\b\r\u0010\nJ*\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u000f0\u00052\u0006\u0010\u0007\u001a\u00020\bH\u0086@ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002ø\u0001\u0002¢\u0006\u0004\b\u0010\u0010\nJ\"\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00120\u0005H\u0086@ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002ø\u0001\u0002¢\u0006\u0004\b\u0013\u0010\u0014J*\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00160\u00052\u0006\u0010\u0007\u001a\u00020\bH\u0086@ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002ø\u0001\u0002¢\u0006\u0004\b\u0017\u0010\nJ*\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00190\u00052\u0006\u0010\u0007\u001a\u00020\bH\u0086@ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002ø\u0001\u0002¢\u0006\u0004\b\u001a\u0010\nJ*\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u001c0\u00052\u0006\u0010\u0007\u001a\u00020\bH\u0086@ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002ø\u0001\u0002¢\u0006\u0004\b\u001d\u0010\nJ*\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u001f0\u00052\u0006\u0010 \u001a\u00020!H\u0086@ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002ø\u0001\u0002¢\u0006\u0004\b\"\u0010#J\"\u0010$\u001a\b\u0012\u0004\u0012\u00020%0\u0005H\u0086@ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002ø\u0001\u0002¢\u0006\u0004\b&\u0010\u0014J*\u0010'\u001a\b\u0012\u0004\u0012\u00020(0\u00052\u0006\u0010\u0007\u001a\u00020\bH\u0086@ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002ø\u0001\u0002¢\u0006\u0004\b)\u0010\nJ0\u0010*\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020,0+0\u00052\u0006\u0010-\u001a\u00020!H\u0086@ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002ø\u0001\u0002¢\u0006\u0004\b.\u0010#J0\u0010/\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002000+0\u00052\u0006\u0010\u0007\u001a\u00020\bH\u0086@ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002ø\u0001\u0002¢\u0006\u0004\b1\u0010\nJ(\u00102\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002030+0\u0005H\u0086@ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002ø\u0001\u0002¢\u0006\u0004\b4\u0010\u0014J0\u00105\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u000207060\u00052\u0006\u0010\u0007\u001a\u00020\bH\u0086@ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002ø\u0001\u0002¢\u0006\u0004\b8\u0010\nJ*\u00109\u001a\b\u0012\u0004\u0012\u00020:0\u00052\u0006\u0010;\u001a\u00020\bH\u0086@ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002ø\u0001\u0002¢\u0006\u0004\b<\u0010\nJ*\u0010=\u001a\b\u0012\u0004\u0012\u00020>0\u00052\u0006\u0010?\u001a\u00020!H\u0086@ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002ø\u0001\u0002¢\u0006\u0004\b@\u0010#J(\u0010A\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020B0+0\u0005H\u0086@ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002ø\u0001\u0002¢\u0006\u0004\bC\u0010\u0014J*\u0010D\u001a\b\u0012\u0004\u0012\u00020\u001f0\u00052\u0006\u0010?\u001a\u00020!H\u0086@ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002ø\u0001\u0002¢\u0006\u0004\bE\u0010#J*\u0010F\u001a\b\u0012\u0004\u0012\u00020\u00160\u00052\u0006\u0010\u0007\u001a\u00020\bH\u0086@ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002ø\u0001\u0002¢\u0006\u0004\bG\u0010\nJ.\u0010H\u001a\f\u0012\b\u0012\u00060IR\u00020J0\u00052\u0006\u0010K\u001a\u00020!H\u0086@ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002ø\u0001\u0002¢\u0006\u0004\bL\u0010#J0\u0010M\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020N0+0\u00052\u0006\u0010\u0007\u001a\u00020\bH\u0086@ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002ø\u0001\u0002¢\u0006\u0004\bO\u0010\nJ*\u0010P\u001a\b\u0012\u0004\u0012\u00020Q0\u00052\u0006\u0010\u0007\u001a\u00020\bH\u0086@ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002ø\u0001\u0002¢\u0006\u0004\bR\u0010\nJ2\u0010S\u001a\b\u0012\u0004\u0012\u00020T0\u00052\u0006\u0010U\u001a\u00020!2\u0006\u0010V\u001a\u00020!H\u0086@ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002ø\u0001\u0002¢\u0006\u0004\bW\u0010XJ*\u0010Y\u001a\b\u0012\u0004\u0012\u00020Z0\u00052\u0006\u0010\u0007\u001a\u00020\bH\u0086@ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002ø\u0001\u0002¢\u0006\u0004\b[\u0010\nJ*\u0010\\\u001a\b\u0012\u0004\u0012\u00020!0\u00052\u0006\u0010\u0007\u001a\u00020\bH\u0086@ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002ø\u0001\u0002¢\u0006\u0004\b]\u0010\nJ*\u0010^\u001a\b\u0012\u0004\u0012\u00020_0\u00052\u0006\u0010\u0007\u001a\u00020\bH\u0086@ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002ø\u0001\u0002¢\u0006\u0004\b`\u0010\nJ6\u0010a\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020c060b0\u00052\u0006\u0010\u0007\u001a\u00020\bH\u0086@ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002ø\u0001\u0002¢\u0006\u0004\bd\u0010\nJ*\u0010e\u001a\b\u0012\u0004\u0012\u00020f0\u00052\u0006\u0010\u0007\u001a\u00020\bH\u0086@ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002ø\u0001\u0002¢\u0006\u0004\bg\u0010\nJ0\u0010h\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020i060\u00052\u0006\u0010\u0007\u001a\u00020\bH\u0086@ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002ø\u0001\u0002¢\u0006\u0004\bj\u0010\nJ*\u0010k\u001a\b\u0012\u0004\u0012\u00020!0\u00052\u0006\u0010\u0007\u001a\u00020\bH\u0086@ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002ø\u0001\u0002¢\u0006\u0004\bl\u0010\nJ0\u0010m\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020n060\u00052\u0006\u0010\u0007\u001a\u00020\bH\u0086@ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002ø\u0001\u0002¢\u0006\u0004\bo\u0010\nJ6\u0010p\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020q060b0\u00052\u0006\u0010\u0007\u001a\u00020\bH\u0086@ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002ø\u0001\u0002¢\u0006\u0004\br\u0010\nJ*\u0010s\u001a\b\u0012\u0004\u0012\u00020t0\u00052\u0006\u0010\u0007\u001a\u00020\bH\u0086@ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002ø\u0001\u0002¢\u0006\u0004\bu\u0010\nJ*\u0010v\u001a\b\u0012\u0004\u0012\u00020!0\u00052\u0006\u0010\u0007\u001a\u00020\bH\u0086@ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002ø\u0001\u0002¢\u0006\u0004\bw\u0010\nJ0\u0010x\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020y060\u00052\u0006\u0010\u0007\u001a\u00020\bH\u0086@ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002ø\u0001\u0002¢\u0006\u0004\bz\u0010\nJ*\u0010{\u001a\b\u0012\u0004\u0012\u00020!0\u00052\u0006\u0010-\u001a\u00020!H\u0086@ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002ø\u0001\u0002¢\u0006\u0004\b|\u0010#J*\u0010}\u001a\b\u0012\u0004\u0012\u00020~0\u00052\u0006\u0010-\u001a\u00020!H\u0086@ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002ø\u0001\u0002¢\u0006\u0004\b\u007f\u0010#J8\u0010\u0080\u0001\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020~060b0\u00052\u0006\u0010\u0007\u001a\u00020\bH\u0086@ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002ø\u0001\u0002¢\u0006\u0005\b\u0081\u0001\u0010\nJ3\u0010\u0082\u0001\u001a\u000f\u0012\u000b\u0012\t\u0012\u0005\u0012\u00030\u0083\u00010+0\u00052\u0006\u0010\u0007\u001a\u00020\bH\u0086@ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002ø\u0001\u0002¢\u0006\u0005\b\u0084\u0001\u0010\nJ-\u0010\u0085\u0001\u001a\t\u0012\u0005\u0012\u00030\u0086\u00010\u00052\u0006\u0010\u0007\u001a\u00020\bH\u0086@ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002ø\u0001\u0002¢\u0006\u0005\b\u0087\u0001\u0010\nJ-\u0010\u0088\u0001\u001a\t\u0012\u0005\u0012\u00030\u0089\u00010\u00052\u0006\u0010\u0007\u001a\u00020\bH\u0086@ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002ø\u0001\u0002¢\u0006\u0005\b\u008a\u0001\u0010\nJ7\u0010\u008b\u0001\u001a\t\u0012\u0005\u0012\u00030\u008c\u00010\u00052\u0007\u0010\u008d\u0001\u001a\u00020!2\u0007\u0010\u008e\u0001\u001a\u00020!H\u0086@ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002ø\u0001\u0002¢\u0006\u0005\b\u008f\u0001\u0010XJ9\u0010\u0090\u0001\u001a\u0015\u0012\u0011\u0012\u000f\u0012\u000b\u0012\t\u0012\u0005\u0012\u00030\u0091\u0001060b0\u00052\u0006\u0010\u0007\u001a\u00020\bH\u0086@ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002ø\u0001\u0002¢\u0006\u0005\b\u0092\u0001\u0010\nJ9\u0010\u0093\u0001\u001a\u0015\u0012\u0011\u0012\u000f\u0012\u000b\u0012\t\u0012\u0005\u0012\u00030\u0094\u0001060b0\u00052\u0006\u0010\u0007\u001a\u00020\bH\u0086@ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002ø\u0001\u0002¢\u0006\u0005\b\u0095\u0001\u0010\nJ-\u0010\u0096\u0001\u001a\t\u0012\u0005\u0012\u00030\u0097\u00010\u00052\u0006\u0010\u0007\u001a\u00020\bH\u0086@ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002ø\u0001\u0002¢\u0006\u0005\b\u0098\u0001\u0010\nJ%\u0010\u0099\u0001\u001a\t\u0012\u0005\u0012\u00030\u009a\u00010\u0005H\u0086@ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002ø\u0001\u0002¢\u0006\u0005\b\u009b\u0001\u0010\u0014J8\u0010\u009c\u0001\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u000200060b0\u00052\u0006\u0010\u0007\u001a\u00020\bH\u0086@ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002ø\u0001\u0002¢\u0006\u0005\b\u009d\u0001\u0010\nJ6\u0010\u009e\u0001\u001a\t\u0012\u0005\u0012\u00030\u009f\u00010\u00052\u0006\u0010?\u001a\u00020!2\u0007\u0010\u008d\u0001\u001a\u00020!H\u0086@ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002ø\u0001\u0002¢\u0006\u0005\b \u0001\u0010XJ.\u0010¡\u0001\u001a\t\u0012\u0005\u0012\u00030\u009f\u00010\u00052\u0007\u0010¢\u0001\u001a\u00020!H\u0086@ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002ø\u0001\u0002¢\u0006\u0005\b£\u0001\u0010#J-\u0010¤\u0001\u001a\t\u0012\u0005\u0012\u00030¥\u00010\u00052\u0006\u0010\u0007\u001a\u00020\bH\u0086@ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002ø\u0001\u0002¢\u0006\u0005\b¦\u0001\u0010\nJ3\u0010§\u0001\u001a\u000f\u0012\u000b\u0012\t\u0012\u0005\u0012\u00030¨\u00010+0\u00052\u0006\u0010\u0007\u001a\u00020\bH\u0086@ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002ø\u0001\u0002¢\u0006\u0005\b©\u0001\u0010\nJ-\u0010ª\u0001\u001a\t\u0012\u0005\u0012\u00030«\u00010\u00052\u0006\u0010-\u001a\u00020!H\u0086@ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002ø\u0001\u0002¢\u0006\u0005\b¬\u0001\u0010#J9\u0010\u00ad\u0001\u001a\u0015\u0012\u0011\u0012\u000f\u0012\u000b\u0012\t\u0012\u0005\u0012\u00030®\u0001060b0\u00052\u0006\u0010\u0007\u001a\u00020\bH\u0086@ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002ø\u0001\u0002¢\u0006\u0005\b¯\u0001\u0010\nJ,\u0010°\u0001\u001a\b\u0012\u0004\u0012\u00020!0\u00052\u0006\u0010\u0007\u001a\u00020\bH\u0086@ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002ø\u0001\u0002¢\u0006\u0005\b±\u0001\u0010\nJ,\u0010²\u0001\u001a\b\u0012\u0004\u0012\u00020!0\u00052\u0006\u0010\u0007\u001a\u00020\bH\u0086@ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002ø\u0001\u0002¢\u0006\u0005\b³\u0001\u0010\nJ,\u0010´\u0001\u001a\b\u0012\u0004\u0012\u00020!0\u00052\u0006\u0010\u0007\u001a\u00020\bH\u0086@ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002ø\u0001\u0002¢\u0006\u0005\bµ\u0001\u0010\nJ-\u0010¶\u0001\u001a\t\u0012\u0005\u0012\u00030·\u00010\u00052\u0006\u0010\u0007\u001a\u00020\bH\u0086@ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002ø\u0001\u0002¢\u0006\u0005\b¸\u0001\u0010\nJ<\u0010¹\u0001\u001a\u000f\u0012\u000b\u0012\t\u0012\u0005\u0012\u00030º\u00010+0\u00052\u000e\u0010»\u0001\u001a\t\u0012\u0005\u0012\u00030¼\u00010+H\u0086@ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002ø\u0001\u0002¢\u0006\u0006\b½\u0001\u0010¾\u0001J,\u0010¿\u0001\u001a\b\u0012\u0004\u0012\u00020\u00160\u00052\u0006\u0010\u0007\u001a\u00020\bH\u0086@ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002ø\u0001\u0002¢\u0006\u0005\bÀ\u0001\u0010\nJ-\u0010Á\u0001\u001a\t\u0012\u0005\u0012\u00030Â\u00010\u00052\u0006\u0010\u0007\u001a\u00020\bH\u0086@ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002ø\u0001\u0002¢\u0006\u0005\bÃ\u0001\u0010\n\u0082\u0002\u000f\n\u0002\b!\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019¨\u0006Ä\u0001"}, d2 = {"Lcom/yd/android_brand_mvp/network/NetworkApi;", "Lcom/yd/android_brand_mvp/network/base/BaseNetworkApi;", "Lcom/yd/android_brand_mvp/network/INetworkService;", "()V", "checkStudent", "Lkotlin/Result;", "Lcom/yd/android_brand_mvp/model/selectNewStudentByIcCardRsp$DataBean;", "requestBody", "Lokhttp3/RequestBody;", "checkStudent-gIAlu-s", "(Lokhttp3/RequestBody;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "checkTeacher", "Lcom/yd/android_brand_mvp/model/selectTeacherByIcCardRsp$DataDTO;", "checkTeacher-gIAlu-s", "checkUser", "Lcom/yd/android_brand_mvp/model/UserIcCardBean$DataBean;", "checkUser-gIAlu-s", "classesOverInfo", "Lcom/yd/android_brand_mvp/model/ClassesOverInfoBean;", "classesOverInfo-IoAF18A", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getActivationCode", "Lcom/yd/android_brand_mvp/model/getRegistrationCodeRsp;", "getActivationCode-gIAlu-s", "getBrandInfo", "Lcom/yd/android_brand_mvp/model/NewBrandLoginRsp;", "getBrandInfo-gIAlu-s", "getBrandRegistrationCode", "Lcom/yd/android_brand_mvp/model/BrandRegistrationCodeRsp;", "getBrandRegistrationCode-gIAlu-s", "getCheckLoginQrCode", "Lcom/yd/android_brand_mvp/model/LoginQrCodeBean;", "random", "", "getCheckLoginQrCode-gIAlu-s", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getClassesInfo", "Lcom/yd/android_brand_mvp/model/NewClassInfoRsp$DataDTO;", "getClassesInfo-IoAF18A", "getCourseListData", "Lcom/yd/android_brand_mvp/model/KBRsp2$DataDTO;", "getCourseListData-gIAlu-s", "getDominateCustomList", "", "Lcom/yd/android_brand_mvp/model/home/DominateCustomBean;", "id", "getDominateCustomList-gIAlu-s", "getDominateMessagePublishList", "Lcom/yd/android_brand_mvp/model/MessageItemBean;", "getDominateMessagePublishList-gIAlu-s", "getDominateScreenLevel", "Lcom/yd/android_brand_mvp/model/DominateDetailLevelBean;", "getDominateScreenLevel-IoAF18A", "getDutyWeekList", "", "Lcom/yd/android_brand_mvp/model/duty/DutyModel;", "getDutyWeekList-gIAlu-s", "getHonorWallList", "Lcom/yd/android_brand_mvp/model/honor/HonorWallBean;", TtmlNode.TAG_BODY, "getHonorWallList-gIAlu-s", "getLeaveWordSetting", "Lcom/yd/android_brand_mvp/model/ConfigComplaintBean;", "type", "getLeaveWordSetting-gIAlu-s", "getLocationInfo", "Lcom/yd/android_brand_mvp/model/AreaBean;", "getLocationInfo-IoAF18A", "getLoginQrCode", "getLoginQrCode-gIAlu-s", "getRegistrationCode", "getRegistrationCode-gIAlu-s", "getUserSig", "Lcom/yd/android_brand_mvp/model/getUserSigByUserIdRsp$DataBean;", "Lcom/yd/android_brand_mvp/model/getUserSigByUserIdRsp;", "userId", "getUserSig-gIAlu-s", "getWatchWord", "Lcom/yd/android_brand_mvp/model/NewWatchWordRsp$DataDTO;", "getWatchWord-gIAlu-s", "gotoScore", "", "gotoScore-gIAlu-s", FirebaseAnalytics.Event.LOGIN, "Lcom/yd/android_brand_mvp/model/NewLoginRsp;", "username", "password", "login-0E7RQCE", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "oneKeySchool", "", "oneKeySchool-gIAlu-s", "pauschCard", "pauschCard-gIAlu-s", "requestActiveDetail", "Lcom/yd/android_brand_mvp/model/honor/HonorActiveDetailBean;", "requestActiveDetail-gIAlu-s", "requestActiveHonorList", "Lcom/yd/android_brand_mvp/network/base/BasePageResponse;", "Lcom/yd/android_brand_mvp/model/honor/HonorActiveBean;", "requestActiveHonorList-gIAlu-s", "requestActiveResultList", "Lcom/yd/android_brand_mvp/model/honor/HonorCommentResultBean;", "requestActiveResultList-gIAlu-s", "requestActivityCycle", "Lcom/yd/android_brand_mvp/model/honor/HonorScoreCycleBean;", "requestActivityCycle-gIAlu-s", "requestAddComments", "requestAddComments-gIAlu-s", "requestAttendance", "Lcom/yd/android_brand_mvp/model/AttenceNewListBean$DataDTO;", "requestAttendance-gIAlu-s", "requestClassHonorList", "Lcom/yd/android_brand_mvp/model/honor/HonorClassBean;", "requestClassHonorList-gIAlu-s", "requestClassMe", "Lcom/yd/android_brand_mvp/landscape/moraleducation/model/IndexClassMEModel;", "requestClassMe-gIAlu-s", "requestClassScoreComment", "requestClassScoreComment-gIAlu-s", "requestClassScoreResult", "Lcom/yd/android_brand_mvp/model/honor/HonorScoreListBean;", "requestClassScoreResult-gIAlu-s", "requestCommentsDelete", "requestCommentsDelete-gIAlu-s", "requestCommentsDetail", "Lcom/yd/android_brand_mvp/model/comments/CommentsDetailBean;", "requestCommentsDetail-gIAlu-s", "requestCommentsList", "requestCommentsList-gIAlu-s", "requestDailyScoreDetails", "Lcom/yd/android_brand_mvp/landscape/moraleducation/model/ScoringDetailCycleModel;", "requestDailyScoreDetails-gIAlu-s", "requestFaceConfig", "Lcom/yd/android_brand_mvp/model/FaceActiveConfigBean;", "requestFaceConfig-gIAlu-s", "requestGoToScore", "Lcom/yd/android_brand_mvp/model/honor/HonorGoCommentBean;", "requestGoToScore-gIAlu-s", "requestHomeCaption", "Lcom/yd/android_brand_mvp/model/MessageCaptionBean;", "schoolId", "deviceId", "requestHomeCaption-0E7RQCE", "requestIdentityDetail", "Lcom/yyide/chatim_pro/model/honor/HonorScoreDetailBean;", "requestIdentityDetail-gIAlu-s", "requestKidsHonorList", "Lcom/yd/android_brand_mvp/model/honor/HonorKidsLIstBean;", "requestKidsHonorList-gIAlu-s", "requestMessage", "Lcom/yd/android_brand_mvp/model/getNoticeRsp$DataDTO;", "requestMessage-gIAlu-s", "requestMessageHome", "Lcom/yd/android_brand_mvp/model/MessageListBean;", "requestMessageHome-IoAF18A", "requestMessageList", "requestMessageList-gIAlu-s", "requestQrCode", "Lcom/yd/android_brand_mvp/model/ScanQrCodeBean;", "requestQrCode-0E7RQCE", "requestQrCodeCheck", "qrCode", "requestQrCodeCheck-gIAlu-s", "requestRTSPPath", "Lcom/yd/android_brand_mvp/model/LayoutListRsp$DataBean$LayoutClassSignDetailsEntityListBean;", "requestRTSPPath-gIAlu-s", "requestScoringRubric", "Lcom/yd/android_brand_mvp/landscape/moraleducation/model/FirstIndicatorModel;", "requestScoringRubric-gIAlu-s", "requestSiteInfo", "Lcom/yd/android_brand_mvp/model/SiteInfoBean;", "requestSiteInfo-gIAlu-s", "requestStudentHonorList", "Lcom/yd/android_brand_mvp/model/honor/HonorStudentBean;", "requestStudentHonorList-gIAlu-s", "requestStudentScoreComment", "requestStudentScoreComment-gIAlu-s", "requestSynchronizeStatusFaceExtraction", "requestSynchronizeStatusFaceExtraction-gIAlu-s", "requestTrafficRecodes", "requestTrafficRecodes-gIAlu-s", "securityCheck", "Lcom/yd/android_brand_mvp/landscape/moraleducation/model/CheckSecurityModel;", "securityCheck-gIAlu-s", "upPhoto", "Lcom/yd/android_brand_mvp/model/UploadFileBean;", "lists", "Lokhttp3/MultipartBody$Part;", "upPhoto-gIAlu-s", "(Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updateNewRegistrationCodeByCode", "updateNewRegistrationCodeByCode-gIAlu-s", "verifyTeacherLogin", "Lcom/yd/android_brand_mvp/model/VerifyTeacherLoginBean;", "verifyTeacherLogin-gIAlu-s", "app_commonRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class NetworkApi extends BaseNetworkApi<INetworkService> {
    public static final NetworkApi INSTANCE = new NetworkApi();

    private NetworkApi() {
        super("https://api.yyide.com");
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    /* JADX INFO: renamed from: requestHomeCaption-0E7RQCE, reason: not valid java name */
    public final Object m457requestHomeCaption0E7RQCE(String str, String str2, Continuation<? super Result<MessageCaptionBean>> continuation) {
        NetworkApi$requestHomeCaption$1 networkApi$requestHomeCaption$1;
        if (continuation instanceof NetworkApi$requestHomeCaption$1) {
            networkApi$requestHomeCaption$1 = (NetworkApi$requestHomeCaption$1) continuation;
            if ((networkApi$requestHomeCaption$1.label & Integer.MIN_VALUE) != 0) {
                networkApi$requestHomeCaption$1.label -= Integer.MIN_VALUE;
            } else {
                networkApi$requestHomeCaption$1 = new NetworkApi$requestHomeCaption$1(this, continuation);
            }
        } else {
            networkApi$requestHomeCaption$1 = new NetworkApi$requestHomeCaption$1(this, continuation);
        }
        Object obj = networkApi$requestHomeCaption$1.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = networkApi$requestHomeCaption$1.label;
        if (i != 0) {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            return ((Result) obj).getValue();
        }
        ResultKt.throwOnFailure(obj);
        NetworkApi$requestHomeCaption$2 networkApi$requestHomeCaption$2 = new NetworkApi$requestHomeCaption$2(str, str2, null);
        networkApi$requestHomeCaption$1.label = 1;
        Object obj2 = m485getResultgIAlus(networkApi$requestHomeCaption$2, networkApi$requestHomeCaption$1);
        return obj2 == coroutine_suspended ? coroutine_suspended : obj2;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    /* JADX INFO: renamed from: requestSynchronizeStatusFaceExtraction-gIAlu-s, reason: not valid java name */
    public final Object m470requestSynchronizeStatusFaceExtractiongIAlus(RequestBody requestBody, Continuation<? super Result<String>> continuation) {
        NetworkApi$requestSynchronizeStatusFaceExtraction$1 networkApi$requestSynchronizeStatusFaceExtraction$1;
        if (continuation instanceof NetworkApi$requestSynchronizeStatusFaceExtraction$1) {
            networkApi$requestSynchronizeStatusFaceExtraction$1 = (NetworkApi$requestSynchronizeStatusFaceExtraction$1) continuation;
            if ((networkApi$requestSynchronizeStatusFaceExtraction$1.label & Integer.MIN_VALUE) != 0) {
                networkApi$requestSynchronizeStatusFaceExtraction$1.label -= Integer.MIN_VALUE;
            } else {
                networkApi$requestSynchronizeStatusFaceExtraction$1 = new NetworkApi$requestSynchronizeStatusFaceExtraction$1(this, continuation);
            }
        } else {
            networkApi$requestSynchronizeStatusFaceExtraction$1 = new NetworkApi$requestSynchronizeStatusFaceExtraction$1(this, continuation);
        }
        Object obj = networkApi$requestSynchronizeStatusFaceExtraction$1.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = networkApi$requestSynchronizeStatusFaceExtraction$1.label;
        if (i != 0) {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            return ((Result) obj).getValue();
        }
        ResultKt.throwOnFailure(obj);
        NetworkApi$requestSynchronizeStatusFaceExtraction$2 networkApi$requestSynchronizeStatusFaceExtraction$2 = new NetworkApi$requestSynchronizeStatusFaceExtraction$2(requestBody, null);
        networkApi$requestSynchronizeStatusFaceExtraction$1.label = 1;
        Object obj2 = m485getResultgIAlus(networkApi$requestSynchronizeStatusFaceExtraction$2, networkApi$requestSynchronizeStatusFaceExtraction$1);
        return obj2 == coroutine_suspended ? coroutine_suspended : obj2;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    /* JADX INFO: renamed from: requestFaceConfig-gIAlu-s, reason: not valid java name */
    public final Object m455requestFaceConfiggIAlus(RequestBody requestBody, Continuation<? super Result<FaceActiveConfigBean>> continuation) {
        NetworkApi$requestFaceConfig$1 networkApi$requestFaceConfig$1;
        if (continuation instanceof NetworkApi$requestFaceConfig$1) {
            networkApi$requestFaceConfig$1 = (NetworkApi$requestFaceConfig$1) continuation;
            if ((networkApi$requestFaceConfig$1.label & Integer.MIN_VALUE) != 0) {
                networkApi$requestFaceConfig$1.label -= Integer.MIN_VALUE;
            } else {
                networkApi$requestFaceConfig$1 = new NetworkApi$requestFaceConfig$1(this, continuation);
            }
        } else {
            networkApi$requestFaceConfig$1 = new NetworkApi$requestFaceConfig$1(this, continuation);
        }
        Object obj = networkApi$requestFaceConfig$1.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = networkApi$requestFaceConfig$1.label;
        if (i != 0) {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            return ((Result) obj).getValue();
        }
        ResultKt.throwOnFailure(obj);
        NetworkApi$requestFaceConfig$2 networkApi$requestFaceConfig$2 = new NetworkApi$requestFaceConfig$2(requestBody, null);
        networkApi$requestFaceConfig$1.label = 1;
        Object obj2 = m485getResultgIAlus(networkApi$requestFaceConfig$2, networkApi$requestFaceConfig$1);
        return obj2 == coroutine_suspended ? coroutine_suspended : obj2;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    /* JADX INFO: renamed from: requestTrafficRecodes-gIAlu-s, reason: not valid java name */
    public final Object m471requestTrafficRecodesgIAlus(RequestBody requestBody, Continuation<? super Result<String>> continuation) {
        NetworkApi$requestTrafficRecodes$1 networkApi$requestTrafficRecodes$1;
        if (continuation instanceof NetworkApi$requestTrafficRecodes$1) {
            networkApi$requestTrafficRecodes$1 = (NetworkApi$requestTrafficRecodes$1) continuation;
            if ((networkApi$requestTrafficRecodes$1.label & Integer.MIN_VALUE) != 0) {
                networkApi$requestTrafficRecodes$1.label -= Integer.MIN_VALUE;
            } else {
                networkApi$requestTrafficRecodes$1 = new NetworkApi$requestTrafficRecodes$1(this, continuation);
            }
        } else {
            networkApi$requestTrafficRecodes$1 = new NetworkApi$requestTrafficRecodes$1(this, continuation);
        }
        Object obj = networkApi$requestTrafficRecodes$1.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = networkApi$requestTrafficRecodes$1.label;
        if (i != 0) {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            return ((Result) obj).getValue();
        }
        ResultKt.throwOnFailure(obj);
        NetworkApi$requestTrafficRecodes$2 networkApi$requestTrafficRecodes$2 = new NetworkApi$requestTrafficRecodes$2(requestBody, null);
        networkApi$requestTrafficRecodes$1.label = 1;
        Object obj2 = m485getResultgIAlus(networkApi$requestTrafficRecodes$2, networkApi$requestTrafficRecodes$1);
        return obj2 == coroutine_suspended ? coroutine_suspended : obj2;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    /* JADX INFO: renamed from: getLeaveWordSetting-gIAlu-s, reason: not valid java name */
    public final Object m431getLeaveWordSettinggIAlus(String str, Continuation<? super Result<ConfigComplaintBean>> continuation) {
        NetworkApi$getLeaveWordSetting$1 networkApi$getLeaveWordSetting$1;
        if (continuation instanceof NetworkApi$getLeaveWordSetting$1) {
            networkApi$getLeaveWordSetting$1 = (NetworkApi$getLeaveWordSetting$1) continuation;
            if ((networkApi$getLeaveWordSetting$1.label & Integer.MIN_VALUE) != 0) {
                networkApi$getLeaveWordSetting$1.label -= Integer.MIN_VALUE;
            } else {
                networkApi$getLeaveWordSetting$1 = new NetworkApi$getLeaveWordSetting$1(this, continuation);
            }
        } else {
            networkApi$getLeaveWordSetting$1 = new NetworkApi$getLeaveWordSetting$1(this, continuation);
        }
        Object obj = networkApi$getLeaveWordSetting$1.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = networkApi$getLeaveWordSetting$1.label;
        if (i != 0) {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            return ((Result) obj).getValue();
        }
        ResultKt.throwOnFailure(obj);
        NetworkApi$getLeaveWordSetting$2 networkApi$getLeaveWordSetting$2 = new NetworkApi$getLeaveWordSetting$2(str, null);
        networkApi$getLeaveWordSetting$1.label = 1;
        Object obj2 = m485getResultgIAlus(networkApi$getLeaveWordSetting$2, networkApi$getLeaveWordSetting$1);
        return obj2 == coroutine_suspended ? coroutine_suspended : obj2;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    /* JADX INFO: renamed from: pauschCard-gIAlu-s, reason: not valid java name */
    public final Object m440pauschCardgIAlus(RequestBody requestBody, Continuation<? super Result<String>> continuation) {
        NetworkApi$pauschCard$1 networkApi$pauschCard$1;
        if (continuation instanceof NetworkApi$pauschCard$1) {
            networkApi$pauschCard$1 = (NetworkApi$pauschCard$1) continuation;
            if ((networkApi$pauschCard$1.label & Integer.MIN_VALUE) != 0) {
                networkApi$pauschCard$1.label -= Integer.MIN_VALUE;
            } else {
                networkApi$pauschCard$1 = new NetworkApi$pauschCard$1(this, continuation);
            }
        } else {
            networkApi$pauschCard$1 = new NetworkApi$pauschCard$1(this, continuation);
        }
        Object obj = networkApi$pauschCard$1.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = networkApi$pauschCard$1.label;
        if (i != 0) {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            return ((Result) obj).getValue();
        }
        ResultKt.throwOnFailure(obj);
        NetworkApi$pauschCard$2 networkApi$pauschCard$2 = new NetworkApi$pauschCard$2(requestBody, null);
        networkApi$pauschCard$1.label = 1;
        Object obj2 = m485getResultgIAlus(networkApi$pauschCard$2, networkApi$pauschCard$1);
        return obj2 == coroutine_suspended ? coroutine_suspended : obj2;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    /* JADX INFO: renamed from: getDutyWeekList-gIAlu-s, reason: not valid java name */
    public final Object m429getDutyWeekListgIAlus(RequestBody requestBody, Continuation<? super Result<? extends List<DutyModel>>> continuation) {
        NetworkApi$getDutyWeekList$1 networkApi$getDutyWeekList$1;
        if (continuation instanceof NetworkApi$getDutyWeekList$1) {
            networkApi$getDutyWeekList$1 = (NetworkApi$getDutyWeekList$1) continuation;
            if ((networkApi$getDutyWeekList$1.label & Integer.MIN_VALUE) != 0) {
                networkApi$getDutyWeekList$1.label -= Integer.MIN_VALUE;
            } else {
                networkApi$getDutyWeekList$1 = new NetworkApi$getDutyWeekList$1(this, continuation);
            }
        } else {
            networkApi$getDutyWeekList$1 = new NetworkApi$getDutyWeekList$1(this, continuation);
        }
        Object obj = networkApi$getDutyWeekList$1.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = networkApi$getDutyWeekList$1.label;
        if (i != 0) {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            return ((Result) obj).getValue();
        }
        ResultKt.throwOnFailure(obj);
        NetworkApi$getDutyWeekList$2 networkApi$getDutyWeekList$2 = new NetworkApi$getDutyWeekList$2(requestBody, null);
        networkApi$getDutyWeekList$1.label = 1;
        Object obj2 = m485getResultgIAlus(networkApi$getDutyWeekList$2, networkApi$getDutyWeekList$1);
        return obj2 == coroutine_suspended ? coroutine_suspended : obj2;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    /* JADX INFO: renamed from: getLoginQrCode-gIAlu-s, reason: not valid java name */
    public final Object m433getLoginQrCodegIAlus(String str, Continuation<? super Result<LoginQrCodeBean>> continuation) {
        NetworkApi$getLoginQrCode$1 networkApi$getLoginQrCode$1;
        if (continuation instanceof NetworkApi$getLoginQrCode$1) {
            networkApi$getLoginQrCode$1 = (NetworkApi$getLoginQrCode$1) continuation;
            if ((networkApi$getLoginQrCode$1.label & Integer.MIN_VALUE) != 0) {
                networkApi$getLoginQrCode$1.label -= Integer.MIN_VALUE;
            } else {
                networkApi$getLoginQrCode$1 = new NetworkApi$getLoginQrCode$1(this, continuation);
            }
        } else {
            networkApi$getLoginQrCode$1 = new NetworkApi$getLoginQrCode$1(this, continuation);
        }
        Object obj = networkApi$getLoginQrCode$1.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = networkApi$getLoginQrCode$1.label;
        if (i != 0) {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            return ((Result) obj).getValue();
        }
        ResultKt.throwOnFailure(obj);
        NetworkApi$getLoginQrCode$2 networkApi$getLoginQrCode$2 = new NetworkApi$getLoginQrCode$2(str, null);
        networkApi$getLoginQrCode$1.label = 1;
        Object obj2 = m485getResultgIAlus(networkApi$getLoginQrCode$2, networkApi$getLoginQrCode$1);
        return obj2 == coroutine_suspended ? coroutine_suspended : obj2;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    /* JADX INFO: renamed from: getCheckLoginQrCode-gIAlu-s, reason: not valid java name */
    public final Object m423getCheckLoginQrCodegIAlus(String str, Continuation<? super Result<LoginQrCodeBean>> continuation) {
        NetworkApi$getCheckLoginQrCode$1 networkApi$getCheckLoginQrCode$1;
        if (continuation instanceof NetworkApi$getCheckLoginQrCode$1) {
            networkApi$getCheckLoginQrCode$1 = (NetworkApi$getCheckLoginQrCode$1) continuation;
            if ((networkApi$getCheckLoginQrCode$1.label & Integer.MIN_VALUE) != 0) {
                networkApi$getCheckLoginQrCode$1.label -= Integer.MIN_VALUE;
            } else {
                networkApi$getCheckLoginQrCode$1 = new NetworkApi$getCheckLoginQrCode$1(this, continuation);
            }
        } else {
            networkApi$getCheckLoginQrCode$1 = new NetworkApi$getCheckLoginQrCode$1(this, continuation);
        }
        Object obj = networkApi$getCheckLoginQrCode$1.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = networkApi$getCheckLoginQrCode$1.label;
        if (i != 0) {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            return ((Result) obj).getValue();
        }
        ResultKt.throwOnFailure(obj);
        NetworkApi$getCheckLoginQrCode$2 networkApi$getCheckLoginQrCode$2 = new NetworkApi$getCheckLoginQrCode$2(str, null);
        networkApi$getCheckLoginQrCode$1.label = 1;
        Object obj2 = m485getResultgIAlus(networkApi$getCheckLoginQrCode$2, networkApi$getCheckLoginQrCode$1);
        return obj2 == coroutine_suspended ? coroutine_suspended : obj2;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    /* JADX INFO: renamed from: login-0E7RQCE, reason: not valid java name */
    public final Object m438login0E7RQCE(String str, String str2, Continuation<? super Result<? extends NewLoginRsp>> continuation) {
        NetworkApi$login$1 networkApi$login$1;
        if (continuation instanceof NetworkApi$login$1) {
            networkApi$login$1 = (NetworkApi$login$1) continuation;
            if ((networkApi$login$1.label & Integer.MIN_VALUE) != 0) {
                networkApi$login$1.label -= Integer.MIN_VALUE;
            } else {
                networkApi$login$1 = new NetworkApi$login$1(this, continuation);
            }
        } else {
            networkApi$login$1 = new NetworkApi$login$1(this, continuation);
        }
        Object obj = networkApi$login$1.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = networkApi$login$1.label;
        if (i != 0) {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            return ((Result) obj).getValue();
        }
        ResultKt.throwOnFailure(obj);
        NetworkApi$login$2 networkApi$login$2 = new NetworkApi$login$2(str, str2, null);
        networkApi$login$1.label = 1;
        Object obj2 = m485getResultgIAlus(networkApi$login$2, networkApi$login$1);
        return obj2 == coroutine_suspended ? coroutine_suspended : obj2;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    /* JADX INFO: renamed from: getBrandInfo-gIAlu-s, reason: not valid java name */
    public final Object m421getBrandInfogIAlus(RequestBody requestBody, Continuation<? super Result<? extends NewBrandLoginRsp>> continuation) {
        NetworkApi$getBrandInfo$1 networkApi$getBrandInfo$1;
        if (continuation instanceof NetworkApi$getBrandInfo$1) {
            networkApi$getBrandInfo$1 = (NetworkApi$getBrandInfo$1) continuation;
            if ((networkApi$getBrandInfo$1.label & Integer.MIN_VALUE) != 0) {
                networkApi$getBrandInfo$1.label -= Integer.MIN_VALUE;
            } else {
                networkApi$getBrandInfo$1 = new NetworkApi$getBrandInfo$1(this, continuation);
            }
        } else {
            networkApi$getBrandInfo$1 = new NetworkApi$getBrandInfo$1(this, continuation);
        }
        Object obj = networkApi$getBrandInfo$1.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = networkApi$getBrandInfo$1.label;
        if (i != 0) {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            return ((Result) obj).getValue();
        }
        ResultKt.throwOnFailure(obj);
        NetworkApi$getBrandInfo$2 networkApi$getBrandInfo$2 = new NetworkApi$getBrandInfo$2(requestBody, null);
        networkApi$getBrandInfo$1.label = 1;
        Object obj2 = m485getResultgIAlus(networkApi$getBrandInfo$2, networkApi$getBrandInfo$1);
        return obj2 == coroutine_suspended ? coroutine_suspended : obj2;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    /* JADX INFO: renamed from: getRegistrationCode-gIAlu-s, reason: not valid java name */
    public final Object m434getRegistrationCodegIAlus(RequestBody requestBody, Continuation<? super Result<? extends getRegistrationCodeRsp>> continuation) {
        NetworkApi$getRegistrationCode$1 networkApi$getRegistrationCode$1;
        if (continuation instanceof NetworkApi$getRegistrationCode$1) {
            networkApi$getRegistrationCode$1 = (NetworkApi$getRegistrationCode$1) continuation;
            if ((networkApi$getRegistrationCode$1.label & Integer.MIN_VALUE) != 0) {
                networkApi$getRegistrationCode$1.label -= Integer.MIN_VALUE;
            } else {
                networkApi$getRegistrationCode$1 = new NetworkApi$getRegistrationCode$1(this, continuation);
            }
        } else {
            networkApi$getRegistrationCode$1 = new NetworkApi$getRegistrationCode$1(this, continuation);
        }
        Object obj = networkApi$getRegistrationCode$1.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = networkApi$getRegistrationCode$1.label;
        if (i != 0) {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            return ((Result) obj).getValue();
        }
        ResultKt.throwOnFailure(obj);
        NetworkApi$getRegistrationCode$2 networkApi$getRegistrationCode$2 = new NetworkApi$getRegistrationCode$2(requestBody, null);
        networkApi$getRegistrationCode$1.label = 1;
        Object obj2 = m485getResultgIAlus(networkApi$getRegistrationCode$2, networkApi$getRegistrationCode$1);
        return obj2 == coroutine_suspended ? coroutine_suspended : obj2;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    /* JADX INFO: renamed from: updateNewRegistrationCodeByCode-gIAlu-s, reason: not valid java name */
    public final Object m474updateNewRegistrationCodeByCodegIAlus(RequestBody requestBody, Continuation<? super Result<? extends getRegistrationCodeRsp>> continuation) {
        NetworkApi$updateNewRegistrationCodeByCode$1 networkApi$updateNewRegistrationCodeByCode$1;
        if (continuation instanceof NetworkApi$updateNewRegistrationCodeByCode$1) {
            networkApi$updateNewRegistrationCodeByCode$1 = (NetworkApi$updateNewRegistrationCodeByCode$1) continuation;
            if ((networkApi$updateNewRegistrationCodeByCode$1.label & Integer.MIN_VALUE) != 0) {
                networkApi$updateNewRegistrationCodeByCode$1.label -= Integer.MIN_VALUE;
            } else {
                networkApi$updateNewRegistrationCodeByCode$1 = new NetworkApi$updateNewRegistrationCodeByCode$1(this, continuation);
            }
        } else {
            networkApi$updateNewRegistrationCodeByCode$1 = new NetworkApi$updateNewRegistrationCodeByCode$1(this, continuation);
        }
        Object obj = networkApi$updateNewRegistrationCodeByCode$1.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = networkApi$updateNewRegistrationCodeByCode$1.label;
        if (i != 0) {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            return ((Result) obj).getValue();
        }
        ResultKt.throwOnFailure(obj);
        NetworkApi$updateNewRegistrationCodeByCode$2 networkApi$updateNewRegistrationCodeByCode$2 = new NetworkApi$updateNewRegistrationCodeByCode$2(requestBody, null);
        networkApi$updateNewRegistrationCodeByCode$1.label = 1;
        Object obj2 = m485getResultgIAlus(networkApi$updateNewRegistrationCodeByCode$2, networkApi$updateNewRegistrationCodeByCode$1);
        return obj2 == coroutine_suspended ? coroutine_suspended : obj2;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    /* JADX INFO: renamed from: getBrandRegistrationCode-gIAlu-s, reason: not valid java name */
    public final Object m422getBrandRegistrationCodegIAlus(RequestBody requestBody, Continuation<? super Result<? extends BrandRegistrationCodeRsp>> continuation) {
        NetworkApi$getBrandRegistrationCode$1 networkApi$getBrandRegistrationCode$1;
        if (continuation instanceof NetworkApi$getBrandRegistrationCode$1) {
            networkApi$getBrandRegistrationCode$1 = (NetworkApi$getBrandRegistrationCode$1) continuation;
            if ((networkApi$getBrandRegistrationCode$1.label & Integer.MIN_VALUE) != 0) {
                networkApi$getBrandRegistrationCode$1.label -= Integer.MIN_VALUE;
            } else {
                networkApi$getBrandRegistrationCode$1 = new NetworkApi$getBrandRegistrationCode$1(this, continuation);
            }
        } else {
            networkApi$getBrandRegistrationCode$1 = new NetworkApi$getBrandRegistrationCode$1(this, continuation);
        }
        Object obj = networkApi$getBrandRegistrationCode$1.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = networkApi$getBrandRegistrationCode$1.label;
        if (i != 0) {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            return ((Result) obj).getValue();
        }
        ResultKt.throwOnFailure(obj);
        NetworkApi$getBrandRegistrationCode$2 networkApi$getBrandRegistrationCode$2 = new NetworkApi$getBrandRegistrationCode$2(requestBody, null);
        networkApi$getBrandRegistrationCode$1.label = 1;
        Object obj2 = m485getResultgIAlus(networkApi$getBrandRegistrationCode$2, networkApi$getBrandRegistrationCode$1);
        return obj2 == coroutine_suspended ? coroutine_suspended : obj2;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    /* JADX INFO: renamed from: getActivationCode-gIAlu-s, reason: not valid java name */
    public final Object m420getActivationCodegIAlus(RequestBody requestBody, Continuation<? super Result<? extends getRegistrationCodeRsp>> continuation) {
        NetworkApi$getActivationCode$1 networkApi$getActivationCode$1;
        if (continuation instanceof NetworkApi$getActivationCode$1) {
            networkApi$getActivationCode$1 = (NetworkApi$getActivationCode$1) continuation;
            if ((networkApi$getActivationCode$1.label & Integer.MIN_VALUE) != 0) {
                networkApi$getActivationCode$1.label -= Integer.MIN_VALUE;
            } else {
                networkApi$getActivationCode$1 = new NetworkApi$getActivationCode$1(this, continuation);
            }
        } else {
            networkApi$getActivationCode$1 = new NetworkApi$getActivationCode$1(this, continuation);
        }
        Object obj = networkApi$getActivationCode$1.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = networkApi$getActivationCode$1.label;
        if (i != 0) {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            return ((Result) obj).getValue();
        }
        ResultKt.throwOnFailure(obj);
        NetworkApi$getActivationCode$2 networkApi$getActivationCode$2 = new NetworkApi$getActivationCode$2(requestBody, null);
        networkApi$getActivationCode$1.label = 1;
        Object obj2 = m485getResultgIAlus(networkApi$getActivationCode$2, networkApi$getActivationCode$1);
        return obj2 == coroutine_suspended ? coroutine_suspended : obj2;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    /* JADX INFO: renamed from: requestRTSPPath-gIAlu-s, reason: not valid java name */
    public final Object m465requestRTSPPathgIAlus(RequestBody requestBody, Continuation<? super Result<? extends LayoutListRsp.DataBean.LayoutClassSignDetailsEntityListBean>> continuation) {
        NetworkApi$requestRTSPPath$1 networkApi$requestRTSPPath$1;
        if (continuation instanceof NetworkApi$requestRTSPPath$1) {
            networkApi$requestRTSPPath$1 = (NetworkApi$requestRTSPPath$1) continuation;
            if ((networkApi$requestRTSPPath$1.label & Integer.MIN_VALUE) != 0) {
                networkApi$requestRTSPPath$1.label -= Integer.MIN_VALUE;
            } else {
                networkApi$requestRTSPPath$1 = new NetworkApi$requestRTSPPath$1(this, continuation);
            }
        } else {
            networkApi$requestRTSPPath$1 = new NetworkApi$requestRTSPPath$1(this, continuation);
        }
        Object obj = networkApi$requestRTSPPath$1.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = networkApi$requestRTSPPath$1.label;
        if (i != 0) {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            return ((Result) obj).getValue();
        }
        ResultKt.throwOnFailure(obj);
        NetworkApi$requestRTSPPath$2 networkApi$requestRTSPPath$2 = new NetworkApi$requestRTSPPath$2(requestBody, null);
        networkApi$requestRTSPPath$1.label = 1;
        Object obj2 = m485getResultgIAlus(networkApi$requestRTSPPath$2, networkApi$requestRTSPPath$1);
        return obj2 == coroutine_suspended ? coroutine_suspended : obj2;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    /* JADX INFO: renamed from: getUserSig-gIAlu-s, reason: not valid java name */
    public final Object m435getUserSiggIAlus(String str, Continuation<? super Result<? extends getUserSigByUserIdRsp.DataBean>> continuation) {
        NetworkApi$getUserSig$1 networkApi$getUserSig$1;
        if (continuation instanceof NetworkApi$getUserSig$1) {
            networkApi$getUserSig$1 = (NetworkApi$getUserSig$1) continuation;
            if ((networkApi$getUserSig$1.label & Integer.MIN_VALUE) != 0) {
                networkApi$getUserSig$1.label -= Integer.MIN_VALUE;
            } else {
                networkApi$getUserSig$1 = new NetworkApi$getUserSig$1(this, continuation);
            }
        } else {
            networkApi$getUserSig$1 = new NetworkApi$getUserSig$1(this, continuation);
        }
        Object obj = networkApi$getUserSig$1.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = networkApi$getUserSig$1.label;
        if (i != 0) {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            return ((Result) obj).getValue();
        }
        ResultKt.throwOnFailure(obj);
        NetworkApi$getUserSig$2 networkApi$getUserSig$2 = new NetworkApi$getUserSig$2(str, null);
        networkApi$getUserSig$1.label = 1;
        Object obj2 = m485getResultgIAlus(networkApi$getUserSig$2, networkApi$getUserSig$1);
        return obj2 == coroutine_suspended ? coroutine_suspended : obj2;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    /* JADX INFO: renamed from: requestQrCode-0E7RQCE, reason: not valid java name */
    public final Object m463requestQrCode0E7RQCE(String str, String str2, Continuation<? super Result<ScanQrCodeBean>> continuation) {
        NetworkApi$requestQrCode$1 networkApi$requestQrCode$1;
        if (continuation instanceof NetworkApi$requestQrCode$1) {
            networkApi$requestQrCode$1 = (NetworkApi$requestQrCode$1) continuation;
            if ((networkApi$requestQrCode$1.label & Integer.MIN_VALUE) != 0) {
                networkApi$requestQrCode$1.label -= Integer.MIN_VALUE;
            } else {
                networkApi$requestQrCode$1 = new NetworkApi$requestQrCode$1(this, continuation);
            }
        } else {
            networkApi$requestQrCode$1 = new NetworkApi$requestQrCode$1(this, continuation);
        }
        Object obj = networkApi$requestQrCode$1.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = networkApi$requestQrCode$1.label;
        if (i != 0) {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            return ((Result) obj).getValue();
        }
        ResultKt.throwOnFailure(obj);
        NetworkApi$requestQrCode$2 networkApi$requestQrCode$2 = new NetworkApi$requestQrCode$2(str, str2, null);
        networkApi$requestQrCode$1.label = 1;
        Object obj2 = m485getResultgIAlus(networkApi$requestQrCode$2, networkApi$requestQrCode$1);
        return obj2 == coroutine_suspended ? coroutine_suspended : obj2;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    /* JADX INFO: renamed from: requestQrCodeCheck-gIAlu-s, reason: not valid java name */
    public final Object m464requestQrCodeCheckgIAlus(String str, Continuation<? super Result<ScanQrCodeBean>> continuation) {
        NetworkApi$requestQrCodeCheck$1 networkApi$requestQrCodeCheck$1;
        if (continuation instanceof NetworkApi$requestQrCodeCheck$1) {
            networkApi$requestQrCodeCheck$1 = (NetworkApi$requestQrCodeCheck$1) continuation;
            if ((networkApi$requestQrCodeCheck$1.label & Integer.MIN_VALUE) != 0) {
                networkApi$requestQrCodeCheck$1.label -= Integer.MIN_VALUE;
            } else {
                networkApi$requestQrCodeCheck$1 = new NetworkApi$requestQrCodeCheck$1(this, continuation);
            }
        } else {
            networkApi$requestQrCodeCheck$1 = new NetworkApi$requestQrCodeCheck$1(this, continuation);
        }
        Object obj = networkApi$requestQrCodeCheck$1.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = networkApi$requestQrCodeCheck$1.label;
        if (i != 0) {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            return ((Result) obj).getValue();
        }
        ResultKt.throwOnFailure(obj);
        NetworkApi$requestQrCodeCheck$2 networkApi$requestQrCodeCheck$2 = new NetworkApi$requestQrCodeCheck$2(str, null);
        networkApi$requestQrCodeCheck$1.label = 1;
        Object obj2 = m485getResultgIAlus(networkApi$requestQrCodeCheck$2, networkApi$requestQrCodeCheck$1);
        return obj2 == coroutine_suspended ? coroutine_suspended : obj2;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    /* JADX INFO: renamed from: requestMessageHome-IoAF18A, reason: not valid java name */
    public final Object m461requestMessageHomeIoAF18A(Continuation<? super Result<MessageListBean>> continuation) {
        NetworkApi$requestMessageHome$1 networkApi$requestMessageHome$1;
        if (continuation instanceof NetworkApi$requestMessageHome$1) {
            networkApi$requestMessageHome$1 = (NetworkApi$requestMessageHome$1) continuation;
            if ((networkApi$requestMessageHome$1.label & Integer.MIN_VALUE) != 0) {
                networkApi$requestMessageHome$1.label -= Integer.MIN_VALUE;
            } else {
                networkApi$requestMessageHome$1 = new NetworkApi$requestMessageHome$1(this, continuation);
            }
        } else {
            networkApi$requestMessageHome$1 = new NetworkApi$requestMessageHome$1(this, continuation);
        }
        Object obj = networkApi$requestMessageHome$1.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = networkApi$requestMessageHome$1.label;
        if (i != 0) {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            return ((Result) obj).getValue();
        }
        ResultKt.throwOnFailure(obj);
        NetworkApi$requestMessageHome$2 networkApi$requestMessageHome$2 = new NetworkApi$requestMessageHome$2(null);
        networkApi$requestMessageHome$1.label = 1;
        Object obj2 = m485getResultgIAlus(networkApi$requestMessageHome$2, networkApi$requestMessageHome$1);
        return obj2 == coroutine_suspended ? coroutine_suspended : obj2;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    /* JADX INFO: renamed from: requestMessageList-gIAlu-s, reason: not valid java name */
    public final Object m462requestMessageListgIAlus(RequestBody requestBody, Continuation<? super Result<? extends BasePageResponse<List<MessageItemBean>>>> continuation) {
        NetworkApi$requestMessageList$1 networkApi$requestMessageList$1;
        if (continuation instanceof NetworkApi$requestMessageList$1) {
            networkApi$requestMessageList$1 = (NetworkApi$requestMessageList$1) continuation;
            if ((networkApi$requestMessageList$1.label & Integer.MIN_VALUE) != 0) {
                networkApi$requestMessageList$1.label -= Integer.MIN_VALUE;
            } else {
                networkApi$requestMessageList$1 = new NetworkApi$requestMessageList$1(this, continuation);
            }
        } else {
            networkApi$requestMessageList$1 = new NetworkApi$requestMessageList$1(this, continuation);
        }
        Object obj = networkApi$requestMessageList$1.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = networkApi$requestMessageList$1.label;
        if (i != 0) {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            return ((Result) obj).getValue();
        }
        ResultKt.throwOnFailure(obj);
        NetworkApi$requestMessageList$2 networkApi$requestMessageList$2 = new NetworkApi$requestMessageList$2(requestBody, null);
        networkApi$requestMessageList$1.label = 1;
        Object obj2 = m485getResultgIAlus(networkApi$requestMessageList$2, networkApi$requestMessageList$1);
        return obj2 == coroutine_suspended ? coroutine_suspended : obj2;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    /* JADX INFO: renamed from: checkStudent-gIAlu-s, reason: not valid java name */
    public final Object m416checkStudentgIAlus(RequestBody requestBody, Continuation<? super Result<? extends selectNewStudentByIcCardRsp.DataBean>> continuation) {
        NetworkApi$checkStudent$1 networkApi$checkStudent$1;
        if (continuation instanceof NetworkApi$checkStudent$1) {
            networkApi$checkStudent$1 = (NetworkApi$checkStudent$1) continuation;
            if ((networkApi$checkStudent$1.label & Integer.MIN_VALUE) != 0) {
                networkApi$checkStudent$1.label -= Integer.MIN_VALUE;
            } else {
                networkApi$checkStudent$1 = new NetworkApi$checkStudent$1(this, continuation);
            }
        } else {
            networkApi$checkStudent$1 = new NetworkApi$checkStudent$1(this, continuation);
        }
        Object obj = networkApi$checkStudent$1.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = networkApi$checkStudent$1.label;
        if (i != 0) {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            return ((Result) obj).getValue();
        }
        ResultKt.throwOnFailure(obj);
        NetworkApi$checkStudent$2 networkApi$checkStudent$2 = new NetworkApi$checkStudent$2(requestBody, null);
        networkApi$checkStudent$1.label = 1;
        Object obj2 = m485getResultgIAlus(networkApi$checkStudent$2, networkApi$checkStudent$1);
        return obj2 == coroutine_suspended ? coroutine_suspended : obj2;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    /* JADX INFO: renamed from: checkUser-gIAlu-s, reason: not valid java name */
    public final Object m418checkUsergIAlus(RequestBody requestBody, Continuation<? super Result<? extends UserIcCardBean.DataBean>> continuation) {
        NetworkApi$checkUser$1 networkApi$checkUser$1;
        if (continuation instanceof NetworkApi$checkUser$1) {
            networkApi$checkUser$1 = (NetworkApi$checkUser$1) continuation;
            if ((networkApi$checkUser$1.label & Integer.MIN_VALUE) != 0) {
                networkApi$checkUser$1.label -= Integer.MIN_VALUE;
            } else {
                networkApi$checkUser$1 = new NetworkApi$checkUser$1(this, continuation);
            }
        } else {
            networkApi$checkUser$1 = new NetworkApi$checkUser$1(this, continuation);
        }
        Object obj = networkApi$checkUser$1.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = networkApi$checkUser$1.label;
        if (i != 0) {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            return ((Result) obj).getValue();
        }
        ResultKt.throwOnFailure(obj);
        NetworkApi$checkUser$2 networkApi$checkUser$2 = new NetworkApi$checkUser$2(requestBody, null);
        networkApi$checkUser$1.label = 1;
        Object obj2 = m485getResultgIAlus(networkApi$checkUser$2, networkApi$checkUser$1);
        return obj2 == coroutine_suspended ? coroutine_suspended : obj2;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    /* JADX INFO: renamed from: checkTeacher-gIAlu-s, reason: not valid java name */
    public final Object m417checkTeachergIAlus(RequestBody requestBody, Continuation<? super Result<? extends selectTeacherByIcCardRsp.DataDTO>> continuation) {
        NetworkApi$checkTeacher$1 networkApi$checkTeacher$1;
        if (continuation instanceof NetworkApi$checkTeacher$1) {
            networkApi$checkTeacher$1 = (NetworkApi$checkTeacher$1) continuation;
            if ((networkApi$checkTeacher$1.label & Integer.MIN_VALUE) != 0) {
                networkApi$checkTeacher$1.label -= Integer.MIN_VALUE;
            } else {
                networkApi$checkTeacher$1 = new NetworkApi$checkTeacher$1(this, continuation);
            }
        } else {
            networkApi$checkTeacher$1 = new NetworkApi$checkTeacher$1(this, continuation);
        }
        Object obj = networkApi$checkTeacher$1.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = networkApi$checkTeacher$1.label;
        if (i != 0) {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            return ((Result) obj).getValue();
        }
        ResultKt.throwOnFailure(obj);
        NetworkApi$checkTeacher$2 networkApi$checkTeacher$2 = new NetworkApi$checkTeacher$2(requestBody, null);
        networkApi$checkTeacher$1.label = 1;
        Object obj2 = m485getResultgIAlus(networkApi$checkTeacher$2, networkApi$checkTeacher$1);
        return obj2 == coroutine_suspended ? coroutine_suspended : obj2;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    /* JADX INFO: renamed from: getHonorWallList-gIAlu-s, reason: not valid java name */
    public final Object m430getHonorWallListgIAlus(RequestBody requestBody, Continuation<? super Result<HonorWallBean>> continuation) {
        NetworkApi$getHonorWallList$1 networkApi$getHonorWallList$1;
        if (continuation instanceof NetworkApi$getHonorWallList$1) {
            networkApi$getHonorWallList$1 = (NetworkApi$getHonorWallList$1) continuation;
            if ((networkApi$getHonorWallList$1.label & Integer.MIN_VALUE) != 0) {
                networkApi$getHonorWallList$1.label -= Integer.MIN_VALUE;
            } else {
                networkApi$getHonorWallList$1 = new NetworkApi$getHonorWallList$1(this, continuation);
            }
        } else {
            networkApi$getHonorWallList$1 = new NetworkApi$getHonorWallList$1(this, continuation);
        }
        Object obj = networkApi$getHonorWallList$1.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = networkApi$getHonorWallList$1.label;
        if (i != 0) {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            return ((Result) obj).getValue();
        }
        ResultKt.throwOnFailure(obj);
        NetworkApi$getHonorWallList$2 networkApi$getHonorWallList$2 = new NetworkApi$getHonorWallList$2(requestBody, null);
        networkApi$getHonorWallList$1.label = 1;
        Object obj2 = m485getResultgIAlus(networkApi$getHonorWallList$2, networkApi$getHonorWallList$1);
        return obj2 == coroutine_suspended ? coroutine_suspended : obj2;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    /* JADX INFO: renamed from: requestClassHonorList-gIAlu-s, reason: not valid java name */
    public final Object m447requestClassHonorListgIAlus(RequestBody requestBody, Continuation<? super Result<? extends BasePageResponse<List<HonorClassBean>>>> continuation) {
        NetworkApi$requestClassHonorList$1 networkApi$requestClassHonorList$1;
        if (continuation instanceof NetworkApi$requestClassHonorList$1) {
            networkApi$requestClassHonorList$1 = (NetworkApi$requestClassHonorList$1) continuation;
            if ((networkApi$requestClassHonorList$1.label & Integer.MIN_VALUE) != 0) {
                networkApi$requestClassHonorList$1.label -= Integer.MIN_VALUE;
            } else {
                networkApi$requestClassHonorList$1 = new NetworkApi$requestClassHonorList$1(this, continuation);
            }
        } else {
            networkApi$requestClassHonorList$1 = new NetworkApi$requestClassHonorList$1(this, continuation);
        }
        Object obj = networkApi$requestClassHonorList$1.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = networkApi$requestClassHonorList$1.label;
        if (i != 0) {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            return ((Result) obj).getValue();
        }
        ResultKt.throwOnFailure(obj);
        NetworkApi$requestClassHonorList$2 networkApi$requestClassHonorList$2 = new NetworkApi$requestClassHonorList$2(requestBody, null);
        networkApi$requestClassHonorList$1.label = 1;
        Object obj2 = m485getResultgIAlus(networkApi$requestClassHonorList$2, networkApi$requestClassHonorList$1);
        return obj2 == coroutine_suspended ? coroutine_suspended : obj2;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    /* JADX INFO: renamed from: requestStudentHonorList-gIAlu-s, reason: not valid java name */
    public final Object m468requestStudentHonorListgIAlus(RequestBody requestBody, Continuation<? super Result<? extends BasePageResponse<List<HonorStudentBean>>>> continuation) {
        NetworkApi$requestStudentHonorList$1 networkApi$requestStudentHonorList$1;
        if (continuation instanceof NetworkApi$requestStudentHonorList$1) {
            networkApi$requestStudentHonorList$1 = (NetworkApi$requestStudentHonorList$1) continuation;
            if ((networkApi$requestStudentHonorList$1.label & Integer.MIN_VALUE) != 0) {
                networkApi$requestStudentHonorList$1.label -= Integer.MIN_VALUE;
            } else {
                networkApi$requestStudentHonorList$1 = new NetworkApi$requestStudentHonorList$1(this, continuation);
            }
        } else {
            networkApi$requestStudentHonorList$1 = new NetworkApi$requestStudentHonorList$1(this, continuation);
        }
        Object obj = networkApi$requestStudentHonorList$1.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = networkApi$requestStudentHonorList$1.label;
        if (i != 0) {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            return ((Result) obj).getValue();
        }
        ResultKt.throwOnFailure(obj);
        NetworkApi$requestStudentHonorList$2 networkApi$requestStudentHonorList$2 = new NetworkApi$requestStudentHonorList$2(requestBody, null);
        networkApi$requestStudentHonorList$1.label = 1;
        Object obj2 = m485getResultgIAlus(networkApi$requestStudentHonorList$2, networkApi$requestStudentHonorList$1);
        return obj2 == coroutine_suspended ? coroutine_suspended : obj2;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    /* JADX INFO: renamed from: requestActiveHonorList-gIAlu-s, reason: not valid java name */
    public final Object m442requestActiveHonorListgIAlus(RequestBody requestBody, Continuation<? super Result<? extends BasePageResponse<List<HonorActiveBean>>>> continuation) {
        NetworkApi$requestActiveHonorList$1 networkApi$requestActiveHonorList$1;
        if (continuation instanceof NetworkApi$requestActiveHonorList$1) {
            networkApi$requestActiveHonorList$1 = (NetworkApi$requestActiveHonorList$1) continuation;
            if ((networkApi$requestActiveHonorList$1.label & Integer.MIN_VALUE) != 0) {
                networkApi$requestActiveHonorList$1.label -= Integer.MIN_VALUE;
            } else {
                networkApi$requestActiveHonorList$1 = new NetworkApi$requestActiveHonorList$1(this, continuation);
            }
        } else {
            networkApi$requestActiveHonorList$1 = new NetworkApi$requestActiveHonorList$1(this, continuation);
        }
        Object obj = networkApi$requestActiveHonorList$1.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = networkApi$requestActiveHonorList$1.label;
        if (i != 0) {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            return ((Result) obj).getValue();
        }
        ResultKt.throwOnFailure(obj);
        NetworkApi$requestActiveHonorList$2 networkApi$requestActiveHonorList$2 = new NetworkApi$requestActiveHonorList$2(requestBody, null);
        networkApi$requestActiveHonorList$1.label = 1;
        Object obj2 = m485getResultgIAlus(networkApi$requestActiveHonorList$2, networkApi$requestActiveHonorList$1);
        return obj2 == coroutine_suspended ? coroutine_suspended : obj2;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    /* JADX INFO: renamed from: requestActiveDetail-gIAlu-s, reason: not valid java name */
    public final Object m441requestActiveDetailgIAlus(RequestBody requestBody, Continuation<? super Result<HonorActiveDetailBean>> continuation) {
        NetworkApi$requestActiveDetail$1 networkApi$requestActiveDetail$1;
        if (continuation instanceof NetworkApi$requestActiveDetail$1) {
            networkApi$requestActiveDetail$1 = (NetworkApi$requestActiveDetail$1) continuation;
            if ((networkApi$requestActiveDetail$1.label & Integer.MIN_VALUE) != 0) {
                networkApi$requestActiveDetail$1.label -= Integer.MIN_VALUE;
            } else {
                networkApi$requestActiveDetail$1 = new NetworkApi$requestActiveDetail$1(this, continuation);
            }
        } else {
            networkApi$requestActiveDetail$1 = new NetworkApi$requestActiveDetail$1(this, continuation);
        }
        Object obj = networkApi$requestActiveDetail$1.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = networkApi$requestActiveDetail$1.label;
        if (i != 0) {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            return ((Result) obj).getValue();
        }
        ResultKt.throwOnFailure(obj);
        NetworkApi$requestActiveDetail$2 networkApi$requestActiveDetail$2 = new NetworkApi$requestActiveDetail$2(requestBody, null);
        networkApi$requestActiveDetail$1.label = 1;
        Object obj2 = m485getResultgIAlus(networkApi$requestActiveDetail$2, networkApi$requestActiveDetail$1);
        return obj2 == coroutine_suspended ? coroutine_suspended : obj2;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    /* JADX INFO: renamed from: requestActiveResultList-gIAlu-s, reason: not valid java name */
    public final Object m443requestActiveResultListgIAlus(RequestBody requestBody, Continuation<? super Result<HonorCommentResultBean>> continuation) {
        NetworkApi$requestActiveResultList$1 networkApi$requestActiveResultList$1;
        if (continuation instanceof NetworkApi$requestActiveResultList$1) {
            networkApi$requestActiveResultList$1 = (NetworkApi$requestActiveResultList$1) continuation;
            if ((networkApi$requestActiveResultList$1.label & Integer.MIN_VALUE) != 0) {
                networkApi$requestActiveResultList$1.label -= Integer.MIN_VALUE;
            } else {
                networkApi$requestActiveResultList$1 = new NetworkApi$requestActiveResultList$1(this, continuation);
            }
        } else {
            networkApi$requestActiveResultList$1 = new NetworkApi$requestActiveResultList$1(this, continuation);
        }
        Object obj = networkApi$requestActiveResultList$1.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = networkApi$requestActiveResultList$1.label;
        if (i != 0) {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            return ((Result) obj).getValue();
        }
        ResultKt.throwOnFailure(obj);
        NetworkApi$requestActiveResultList$2 networkApi$requestActiveResultList$2 = new NetworkApi$requestActiveResultList$2(requestBody, null);
        networkApi$requestActiveResultList$1.label = 1;
        Object obj2 = m485getResultgIAlus(networkApi$requestActiveResultList$2, networkApi$requestActiveResultList$1);
        return obj2 == coroutine_suspended ? coroutine_suspended : obj2;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    /* JADX INFO: renamed from: requestStudentScoreComment-gIAlu-s, reason: not valid java name */
    public final Object m469requestStudentScoreCommentgIAlus(RequestBody requestBody, Continuation<? super Result<String>> continuation) {
        NetworkApi$requestStudentScoreComment$1 networkApi$requestStudentScoreComment$1;
        if (continuation instanceof NetworkApi$requestStudentScoreComment$1) {
            networkApi$requestStudentScoreComment$1 = (NetworkApi$requestStudentScoreComment$1) continuation;
            if ((networkApi$requestStudentScoreComment$1.label & Integer.MIN_VALUE) != 0) {
                networkApi$requestStudentScoreComment$1.label -= Integer.MIN_VALUE;
            } else {
                networkApi$requestStudentScoreComment$1 = new NetworkApi$requestStudentScoreComment$1(this, continuation);
            }
        } else {
            networkApi$requestStudentScoreComment$1 = new NetworkApi$requestStudentScoreComment$1(this, continuation);
        }
        Object obj = networkApi$requestStudentScoreComment$1.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = networkApi$requestStudentScoreComment$1.label;
        if (i != 0) {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            return ((Result) obj).getValue();
        }
        ResultKt.throwOnFailure(obj);
        NetworkApi$requestStudentScoreComment$2 networkApi$requestStudentScoreComment$2 = new NetworkApi$requestStudentScoreComment$2(requestBody, null);
        networkApi$requestStudentScoreComment$1.label = 1;
        Object obj2 = m485getResultgIAlus(networkApi$requestStudentScoreComment$2, networkApi$requestStudentScoreComment$1);
        return obj2 == coroutine_suspended ? coroutine_suspended : obj2;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    /* JADX INFO: renamed from: requestClassScoreComment-gIAlu-s, reason: not valid java name */
    public final Object m449requestClassScoreCommentgIAlus(RequestBody requestBody, Continuation<? super Result<String>> continuation) {
        NetworkApi$requestClassScoreComment$1 networkApi$requestClassScoreComment$1;
        if (continuation instanceof NetworkApi$requestClassScoreComment$1) {
            networkApi$requestClassScoreComment$1 = (NetworkApi$requestClassScoreComment$1) continuation;
            if ((networkApi$requestClassScoreComment$1.label & Integer.MIN_VALUE) != 0) {
                networkApi$requestClassScoreComment$1.label -= Integer.MIN_VALUE;
            } else {
                networkApi$requestClassScoreComment$1 = new NetworkApi$requestClassScoreComment$1(this, continuation);
            }
        } else {
            networkApi$requestClassScoreComment$1 = new NetworkApi$requestClassScoreComment$1(this, continuation);
        }
        Object obj = networkApi$requestClassScoreComment$1.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = networkApi$requestClassScoreComment$1.label;
        if (i != 0) {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            return ((Result) obj).getValue();
        }
        ResultKt.throwOnFailure(obj);
        NetworkApi$requestClassScoreComment$2 networkApi$requestClassScoreComment$2 = new NetworkApi$requestClassScoreComment$2(requestBody, null);
        networkApi$requestClassScoreComment$1.label = 1;
        Object obj2 = m485getResultgIAlus(networkApi$requestClassScoreComment$2, networkApi$requestClassScoreComment$1);
        return obj2 == coroutine_suspended ? coroutine_suspended : obj2;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    /* JADX INFO: renamed from: requestClassScoreResult-gIAlu-s, reason: not valid java name */
    public final Object m450requestClassScoreResultgIAlus(RequestBody requestBody, Continuation<? super Result<? extends List<HonorScoreListBean>>> continuation) {
        NetworkApi$requestClassScoreResult$1 networkApi$requestClassScoreResult$1;
        if (continuation instanceof NetworkApi$requestClassScoreResult$1) {
            networkApi$requestClassScoreResult$1 = (NetworkApi$requestClassScoreResult$1) continuation;
            if ((networkApi$requestClassScoreResult$1.label & Integer.MIN_VALUE) != 0) {
                networkApi$requestClassScoreResult$1.label -= Integer.MIN_VALUE;
            } else {
                networkApi$requestClassScoreResult$1 = new NetworkApi$requestClassScoreResult$1(this, continuation);
            }
        } else {
            networkApi$requestClassScoreResult$1 = new NetworkApi$requestClassScoreResult$1(this, continuation);
        }
        Object obj = networkApi$requestClassScoreResult$1.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = networkApi$requestClassScoreResult$1.label;
        if (i != 0) {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            return ((Result) obj).getValue();
        }
        ResultKt.throwOnFailure(obj);
        NetworkApi$requestClassScoreResult$2 networkApi$requestClassScoreResult$2 = new NetworkApi$requestClassScoreResult$2(requestBody, null);
        networkApi$requestClassScoreResult$1.label = 1;
        Object obj2 = m485getResultgIAlus(networkApi$requestClassScoreResult$2, networkApi$requestClassScoreResult$1);
        return obj2 == coroutine_suspended ? coroutine_suspended : obj2;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    /* JADX INFO: renamed from: requestKidsHonorList-gIAlu-s, reason: not valid java name */
    public final Object m459requestKidsHonorListgIAlus(RequestBody requestBody, Continuation<? super Result<? extends BasePageResponse<List<HonorKidsLIstBean>>>> continuation) {
        NetworkApi$requestKidsHonorList$1 networkApi$requestKidsHonorList$1;
        if (continuation instanceof NetworkApi$requestKidsHonorList$1) {
            networkApi$requestKidsHonorList$1 = (NetworkApi$requestKidsHonorList$1) continuation;
            if ((networkApi$requestKidsHonorList$1.label & Integer.MIN_VALUE) != 0) {
                networkApi$requestKidsHonorList$1.label -= Integer.MIN_VALUE;
            } else {
                networkApi$requestKidsHonorList$1 = new NetworkApi$requestKidsHonorList$1(this, continuation);
            }
        } else {
            networkApi$requestKidsHonorList$1 = new NetworkApi$requestKidsHonorList$1(this, continuation);
        }
        Object obj = networkApi$requestKidsHonorList$1.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = networkApi$requestKidsHonorList$1.label;
        if (i != 0) {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            return ((Result) obj).getValue();
        }
        ResultKt.throwOnFailure(obj);
        NetworkApi$requestKidsHonorList$2 networkApi$requestKidsHonorList$2 = new NetworkApi$requestKidsHonorList$2(requestBody, null);
        networkApi$requestKidsHonorList$1.label = 1;
        Object obj2 = m485getResultgIAlus(networkApi$requestKidsHonorList$2, networkApi$requestKidsHonorList$1);
        return obj2 == coroutine_suspended ? coroutine_suspended : obj2;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    /* JADX INFO: renamed from: requestGoToScore-gIAlu-s, reason: not valid java name */
    public final Object m456requestGoToScoregIAlus(RequestBody requestBody, Continuation<? super Result<HonorGoCommentBean>> continuation) {
        NetworkApi$requestGoToScore$1 networkApi$requestGoToScore$1;
        if (continuation instanceof NetworkApi$requestGoToScore$1) {
            networkApi$requestGoToScore$1 = (NetworkApi$requestGoToScore$1) continuation;
            if ((networkApi$requestGoToScore$1.label & Integer.MIN_VALUE) != 0) {
                networkApi$requestGoToScore$1.label -= Integer.MIN_VALUE;
            } else {
                networkApi$requestGoToScore$1 = new NetworkApi$requestGoToScore$1(this, continuation);
            }
        } else {
            networkApi$requestGoToScore$1 = new NetworkApi$requestGoToScore$1(this, continuation);
        }
        Object obj = networkApi$requestGoToScore$1.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = networkApi$requestGoToScore$1.label;
        if (i != 0) {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            return ((Result) obj).getValue();
        }
        ResultKt.throwOnFailure(obj);
        NetworkApi$requestGoToScore$2 networkApi$requestGoToScore$2 = new NetworkApi$requestGoToScore$2(requestBody, null);
        networkApi$requestGoToScore$1.label = 1;
        Object obj2 = m485getResultgIAlus(networkApi$requestGoToScore$2, networkApi$requestGoToScore$1);
        return obj2 == coroutine_suspended ? coroutine_suspended : obj2;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    /* JADX INFO: renamed from: requestSiteInfo-gIAlu-s, reason: not valid java name */
    public final Object m467requestSiteInfogIAlus(String str, Continuation<? super Result<SiteInfoBean>> continuation) {
        NetworkApi$requestSiteInfo$1 networkApi$requestSiteInfo$1;
        if (continuation instanceof NetworkApi$requestSiteInfo$1) {
            networkApi$requestSiteInfo$1 = (NetworkApi$requestSiteInfo$1) continuation;
            if ((networkApi$requestSiteInfo$1.label & Integer.MIN_VALUE) != 0) {
                networkApi$requestSiteInfo$1.label -= Integer.MIN_VALUE;
            } else {
                networkApi$requestSiteInfo$1 = new NetworkApi$requestSiteInfo$1(this, continuation);
            }
        } else {
            networkApi$requestSiteInfo$1 = new NetworkApi$requestSiteInfo$1(this, continuation);
        }
        Object obj = networkApi$requestSiteInfo$1.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = networkApi$requestSiteInfo$1.label;
        if (i != 0) {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            return ((Result) obj).getValue();
        }
        ResultKt.throwOnFailure(obj);
        NetworkApi$requestSiteInfo$2 networkApi$requestSiteInfo$2 = new NetworkApi$requestSiteInfo$2(str, null);
        networkApi$requestSiteInfo$1.label = 1;
        Object obj2 = m485getResultgIAlus(networkApi$requestSiteInfo$2, networkApi$requestSiteInfo$1);
        return obj2 == coroutine_suspended ? coroutine_suspended : obj2;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    /* JADX INFO: renamed from: requestMessage-gIAlu-s, reason: not valid java name */
    public final Object m460requestMessagegIAlus(RequestBody requestBody, Continuation<? super Result<? extends getNoticeRsp.DataDTO>> continuation) {
        NetworkApi$requestMessage$1 networkApi$requestMessage$1;
        if (continuation instanceof NetworkApi$requestMessage$1) {
            networkApi$requestMessage$1 = (NetworkApi$requestMessage$1) continuation;
            if ((networkApi$requestMessage$1.label & Integer.MIN_VALUE) != 0) {
                networkApi$requestMessage$1.label -= Integer.MIN_VALUE;
            } else {
                networkApi$requestMessage$1 = new NetworkApi$requestMessage$1(this, continuation);
            }
        } else {
            networkApi$requestMessage$1 = new NetworkApi$requestMessage$1(this, continuation);
        }
        Object obj = networkApi$requestMessage$1.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = networkApi$requestMessage$1.label;
        if (i != 0) {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            return ((Result) obj).getValue();
        }
        ResultKt.throwOnFailure(obj);
        NetworkApi$requestMessage$2 networkApi$requestMessage$2 = new NetworkApi$requestMessage$2(requestBody, null);
        networkApi$requestMessage$1.label = 1;
        Object obj2 = m485getResultgIAlus(networkApi$requestMessage$2, networkApi$requestMessage$1);
        return obj2 == coroutine_suspended ? coroutine_suspended : obj2;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    /* JADX INFO: renamed from: requestAddComments-gIAlu-s, reason: not valid java name */
    public final Object m445requestAddCommentsgIAlus(RequestBody requestBody, Continuation<? super Result<String>> continuation) {
        NetworkApi$requestAddComments$1 networkApi$requestAddComments$1;
        if (continuation instanceof NetworkApi$requestAddComments$1) {
            networkApi$requestAddComments$1 = (NetworkApi$requestAddComments$1) continuation;
            if ((networkApi$requestAddComments$1.label & Integer.MIN_VALUE) != 0) {
                networkApi$requestAddComments$1.label -= Integer.MIN_VALUE;
            } else {
                networkApi$requestAddComments$1 = new NetworkApi$requestAddComments$1(this, continuation);
            }
        } else {
            networkApi$requestAddComments$1 = new NetworkApi$requestAddComments$1(this, continuation);
        }
        Object obj = networkApi$requestAddComments$1.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = networkApi$requestAddComments$1.label;
        if (i != 0) {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            return ((Result) obj).getValue();
        }
        ResultKt.throwOnFailure(obj);
        NetworkApi$requestAddComments$2 networkApi$requestAddComments$2 = new NetworkApi$requestAddComments$2(requestBody, null);
        networkApi$requestAddComments$1.label = 1;
        Object obj2 = m485getResultgIAlus(networkApi$requestAddComments$2, networkApi$requestAddComments$1);
        return obj2 == coroutine_suspended ? coroutine_suspended : obj2;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    /* JADX INFO: renamed from: requestCommentsList-gIAlu-s, reason: not valid java name */
    public final Object m453requestCommentsListgIAlus(RequestBody requestBody, Continuation<? super Result<? extends BasePageResponse<List<CommentsDetailBean>>>> continuation) {
        NetworkApi$requestCommentsList$1 networkApi$requestCommentsList$1;
        if (continuation instanceof NetworkApi$requestCommentsList$1) {
            networkApi$requestCommentsList$1 = (NetworkApi$requestCommentsList$1) continuation;
            if ((networkApi$requestCommentsList$1.label & Integer.MIN_VALUE) != 0) {
                networkApi$requestCommentsList$1.label -= Integer.MIN_VALUE;
            } else {
                networkApi$requestCommentsList$1 = new NetworkApi$requestCommentsList$1(this, continuation);
            }
        } else {
            networkApi$requestCommentsList$1 = new NetworkApi$requestCommentsList$1(this, continuation);
        }
        Object obj = networkApi$requestCommentsList$1.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = networkApi$requestCommentsList$1.label;
        if (i != 0) {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            return ((Result) obj).getValue();
        }
        ResultKt.throwOnFailure(obj);
        NetworkApi$requestCommentsList$2 networkApi$requestCommentsList$2 = new NetworkApi$requestCommentsList$2(requestBody, null);
        networkApi$requestCommentsList$1.label = 1;
        Object obj2 = m485getResultgIAlus(networkApi$requestCommentsList$2, networkApi$requestCommentsList$1);
        return obj2 == coroutine_suspended ? coroutine_suspended : obj2;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    /* JADX INFO: renamed from: requestCommentsDetail-gIAlu-s, reason: not valid java name */
    public final Object m452requestCommentsDetailgIAlus(String str, Continuation<? super Result<CommentsDetailBean>> continuation) {
        NetworkApi$requestCommentsDetail$1 networkApi$requestCommentsDetail$1;
        if (continuation instanceof NetworkApi$requestCommentsDetail$1) {
            networkApi$requestCommentsDetail$1 = (NetworkApi$requestCommentsDetail$1) continuation;
            if ((networkApi$requestCommentsDetail$1.label & Integer.MIN_VALUE) != 0) {
                networkApi$requestCommentsDetail$1.label -= Integer.MIN_VALUE;
            } else {
                networkApi$requestCommentsDetail$1 = new NetworkApi$requestCommentsDetail$1(this, continuation);
            }
        } else {
            networkApi$requestCommentsDetail$1 = new NetworkApi$requestCommentsDetail$1(this, continuation);
        }
        Object obj = networkApi$requestCommentsDetail$1.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = networkApi$requestCommentsDetail$1.label;
        if (i != 0) {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            return ((Result) obj).getValue();
        }
        ResultKt.throwOnFailure(obj);
        NetworkApi$requestCommentsDetail$2 networkApi$requestCommentsDetail$2 = new NetworkApi$requestCommentsDetail$2(str, null);
        networkApi$requestCommentsDetail$1.label = 1;
        Object obj2 = m485getResultgIAlus(networkApi$requestCommentsDetail$2, networkApi$requestCommentsDetail$1);
        return obj2 == coroutine_suspended ? coroutine_suspended : obj2;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    /* JADX INFO: renamed from: requestCommentsDelete-gIAlu-s, reason: not valid java name */
    public final Object m451requestCommentsDeletegIAlus(String str, Continuation<? super Result<String>> continuation) {
        NetworkApi$requestCommentsDelete$1 networkApi$requestCommentsDelete$1;
        if (continuation instanceof NetworkApi$requestCommentsDelete$1) {
            networkApi$requestCommentsDelete$1 = (NetworkApi$requestCommentsDelete$1) continuation;
            if ((networkApi$requestCommentsDelete$1.label & Integer.MIN_VALUE) != 0) {
                networkApi$requestCommentsDelete$1.label -= Integer.MIN_VALUE;
            } else {
                networkApi$requestCommentsDelete$1 = new NetworkApi$requestCommentsDelete$1(this, continuation);
            }
        } else {
            networkApi$requestCommentsDelete$1 = new NetworkApi$requestCommentsDelete$1(this, continuation);
        }
        Object obj = networkApi$requestCommentsDelete$1.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = networkApi$requestCommentsDelete$1.label;
        if (i != 0) {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            return ((Result) obj).getValue();
        }
        ResultKt.throwOnFailure(obj);
        NetworkApi$requestCommentsDelete$2 networkApi$requestCommentsDelete$2 = new NetworkApi$requestCommentsDelete$2(str, null);
        networkApi$requestCommentsDelete$1.label = 1;
        Object obj2 = m485getResultgIAlus(networkApi$requestCommentsDelete$2, networkApi$requestCommentsDelete$1);
        return obj2 == coroutine_suspended ? coroutine_suspended : obj2;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    /* JADX INFO: renamed from: requestIdentityDetail-gIAlu-s, reason: not valid java name */
    public final Object m458requestIdentityDetailgIAlus(RequestBody requestBody, Continuation<? super Result<? extends BasePageResponse<List<HonorScoreDetailBean>>>> continuation) {
        NetworkApi$requestIdentityDetail$1 networkApi$requestIdentityDetail$1;
        if (continuation instanceof NetworkApi$requestIdentityDetail$1) {
            networkApi$requestIdentityDetail$1 = (NetworkApi$requestIdentityDetail$1) continuation;
            if ((networkApi$requestIdentityDetail$1.label & Integer.MIN_VALUE) != 0) {
                networkApi$requestIdentityDetail$1.label -= Integer.MIN_VALUE;
            } else {
                networkApi$requestIdentityDetail$1 = new NetworkApi$requestIdentityDetail$1(this, continuation);
            }
        } else {
            networkApi$requestIdentityDetail$1 = new NetworkApi$requestIdentityDetail$1(this, continuation);
        }
        Object obj = networkApi$requestIdentityDetail$1.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = networkApi$requestIdentityDetail$1.label;
        if (i != 0) {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            return ((Result) obj).getValue();
        }
        ResultKt.throwOnFailure(obj);
        NetworkApi$requestIdentityDetail$2 networkApi$requestIdentityDetail$2 = new NetworkApi$requestIdentityDetail$2(requestBody, null);
        networkApi$requestIdentityDetail$1.label = 1;
        Object obj2 = m485getResultgIAlus(networkApi$requestIdentityDetail$2, networkApi$requestIdentityDetail$1);
        return obj2 == coroutine_suspended ? coroutine_suspended : obj2;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    /* JADX INFO: renamed from: requestActivityCycle-gIAlu-s, reason: not valid java name */
    public final Object m444requestActivityCyclegIAlus(RequestBody requestBody, Continuation<? super Result<? extends List<HonorScoreCycleBean>>> continuation) {
        NetworkApi$requestActivityCycle$1 networkApi$requestActivityCycle$1;
        if (continuation instanceof NetworkApi$requestActivityCycle$1) {
            networkApi$requestActivityCycle$1 = (NetworkApi$requestActivityCycle$1) continuation;
            if ((networkApi$requestActivityCycle$1.label & Integer.MIN_VALUE) != 0) {
                networkApi$requestActivityCycle$1.label -= Integer.MIN_VALUE;
            } else {
                networkApi$requestActivityCycle$1 = new NetworkApi$requestActivityCycle$1(this, continuation);
            }
        } else {
            networkApi$requestActivityCycle$1 = new NetworkApi$requestActivityCycle$1(this, continuation);
        }
        Object obj = networkApi$requestActivityCycle$1.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = networkApi$requestActivityCycle$1.label;
        if (i != 0) {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            return ((Result) obj).getValue();
        }
        ResultKt.throwOnFailure(obj);
        NetworkApi$requestActivityCycle$2 networkApi$requestActivityCycle$2 = new NetworkApi$requestActivityCycle$2(requestBody, null);
        networkApi$requestActivityCycle$1.label = 1;
        Object obj2 = m485getResultgIAlus(networkApi$requestActivityCycle$2, networkApi$requestActivityCycle$1);
        return obj2 == coroutine_suspended ? coroutine_suspended : obj2;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    /* JADX INFO: renamed from: requestAttendance-gIAlu-s, reason: not valid java name */
    public final Object m446requestAttendancegIAlus(RequestBody requestBody, Continuation<? super Result<? extends List<AttenceNewListBean.DataDTO>>> continuation) {
        NetworkApi$requestAttendance$1 networkApi$requestAttendance$1;
        if (continuation instanceof NetworkApi$requestAttendance$1) {
            networkApi$requestAttendance$1 = (NetworkApi$requestAttendance$1) continuation;
            if ((networkApi$requestAttendance$1.label & Integer.MIN_VALUE) != 0) {
                networkApi$requestAttendance$1.label -= Integer.MIN_VALUE;
            } else {
                networkApi$requestAttendance$1 = new NetworkApi$requestAttendance$1(this, continuation);
            }
        } else {
            networkApi$requestAttendance$1 = new NetworkApi$requestAttendance$1(this, continuation);
        }
        Object obj = networkApi$requestAttendance$1.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = networkApi$requestAttendance$1.label;
        if (i != 0) {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            return ((Result) obj).getValue();
        }
        ResultKt.throwOnFailure(obj);
        NetworkApi$requestAttendance$2 networkApi$requestAttendance$2 = new NetworkApi$requestAttendance$2(requestBody, null);
        networkApi$requestAttendance$1.label = 1;
        Object obj2 = m485getResultgIAlus(networkApi$requestAttendance$2, networkApi$requestAttendance$1);
        return obj2 == coroutine_suspended ? coroutine_suspended : obj2;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    /* JADX INFO: renamed from: getDominateMessagePublishList-gIAlu-s, reason: not valid java name */
    public final Object m427getDominateMessagePublishListgIAlus(RequestBody requestBody, Continuation<? super Result<? extends List<MessageItemBean>>> continuation) {
        NetworkApi$getDominateMessagePublishList$1 networkApi$getDominateMessagePublishList$1;
        if (continuation instanceof NetworkApi$getDominateMessagePublishList$1) {
            networkApi$getDominateMessagePublishList$1 = (NetworkApi$getDominateMessagePublishList$1) continuation;
            if ((networkApi$getDominateMessagePublishList$1.label & Integer.MIN_VALUE) != 0) {
                networkApi$getDominateMessagePublishList$1.label -= Integer.MIN_VALUE;
            } else {
                networkApi$getDominateMessagePublishList$1 = new NetworkApi$getDominateMessagePublishList$1(this, continuation);
            }
        } else {
            networkApi$getDominateMessagePublishList$1 = new NetworkApi$getDominateMessagePublishList$1(this, continuation);
        }
        Object obj = networkApi$getDominateMessagePublishList$1.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = networkApi$getDominateMessagePublishList$1.label;
        if (i != 0) {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            return ((Result) obj).getValue();
        }
        ResultKt.throwOnFailure(obj);
        NetworkApi$getDominateMessagePublishList$2 networkApi$getDominateMessagePublishList$2 = new NetworkApi$getDominateMessagePublishList$2(requestBody, null);
        networkApi$getDominateMessagePublishList$1.label = 1;
        Object obj2 = m485getResultgIAlus(networkApi$getDominateMessagePublishList$2, networkApi$getDominateMessagePublishList$1);
        return obj2 == coroutine_suspended ? coroutine_suspended : obj2;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    /* JADX INFO: renamed from: getDominateCustomList-gIAlu-s, reason: not valid java name */
    public final Object m426getDominateCustomListgIAlus(String str, Continuation<? super Result<? extends List<DominateCustomBean>>> continuation) {
        NetworkApi$getDominateCustomList$1 networkApi$getDominateCustomList$1;
        if (continuation instanceof NetworkApi$getDominateCustomList$1) {
            networkApi$getDominateCustomList$1 = (NetworkApi$getDominateCustomList$1) continuation;
            if ((networkApi$getDominateCustomList$1.label & Integer.MIN_VALUE) != 0) {
                networkApi$getDominateCustomList$1.label -= Integer.MIN_VALUE;
            } else {
                networkApi$getDominateCustomList$1 = new NetworkApi$getDominateCustomList$1(this, continuation);
            }
        } else {
            networkApi$getDominateCustomList$1 = new NetworkApi$getDominateCustomList$1(this, continuation);
        }
        Object obj = networkApi$getDominateCustomList$1.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = networkApi$getDominateCustomList$1.label;
        if (i != 0) {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            return ((Result) obj).getValue();
        }
        ResultKt.throwOnFailure(obj);
        NetworkApi$getDominateCustomList$2 networkApi$getDominateCustomList$2 = new NetworkApi$getDominateCustomList$2(str, null);
        networkApi$getDominateCustomList$1.label = 1;
        Object obj2 = m485getResultgIAlus(networkApi$getDominateCustomList$2, networkApi$getDominateCustomList$1);
        return obj2 == coroutine_suspended ? coroutine_suspended : obj2;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    /* JADX INFO: renamed from: getDominateScreenLevel-IoAF18A, reason: not valid java name */
    public final Object m428getDominateScreenLevelIoAF18A(Continuation<? super Result<? extends List<DominateDetailLevelBean>>> continuation) {
        NetworkApi$getDominateScreenLevel$1 networkApi$getDominateScreenLevel$1;
        if (continuation instanceof NetworkApi$getDominateScreenLevel$1) {
            networkApi$getDominateScreenLevel$1 = (NetworkApi$getDominateScreenLevel$1) continuation;
            if ((networkApi$getDominateScreenLevel$1.label & Integer.MIN_VALUE) != 0) {
                networkApi$getDominateScreenLevel$1.label -= Integer.MIN_VALUE;
            } else {
                networkApi$getDominateScreenLevel$1 = new NetworkApi$getDominateScreenLevel$1(this, continuation);
            }
        } else {
            networkApi$getDominateScreenLevel$1 = new NetworkApi$getDominateScreenLevel$1(this, continuation);
        }
        Object obj = networkApi$getDominateScreenLevel$1.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = networkApi$getDominateScreenLevel$1.label;
        if (i != 0) {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            return ((Result) obj).getValue();
        }
        ResultKt.throwOnFailure(obj);
        NetworkApi$getDominateScreenLevel$2 networkApi$getDominateScreenLevel$2 = new NetworkApi$getDominateScreenLevel$2(null);
        networkApi$getDominateScreenLevel$1.label = 1;
        Object obj2 = m485getResultgIAlus(networkApi$getDominateScreenLevel$2, networkApi$getDominateScreenLevel$1);
        return obj2 == coroutine_suspended ? coroutine_suspended : obj2;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    /* JADX INFO: renamed from: upPhoto-gIAlu-s, reason: not valid java name */
    public final Object m473upPhotogIAlus(List<MultipartBody.Part> list, Continuation<? super Result<? extends List<UploadFileBean>>> continuation) {
        NetworkApi$upPhoto$1 networkApi$upPhoto$1;
        if (continuation instanceof NetworkApi$upPhoto$1) {
            networkApi$upPhoto$1 = (NetworkApi$upPhoto$1) continuation;
            if ((networkApi$upPhoto$1.label & Integer.MIN_VALUE) != 0) {
                networkApi$upPhoto$1.label -= Integer.MIN_VALUE;
            } else {
                networkApi$upPhoto$1 = new NetworkApi$upPhoto$1(this, continuation);
            }
        } else {
            networkApi$upPhoto$1 = new NetworkApi$upPhoto$1(this, continuation);
        }
        Object obj = networkApi$upPhoto$1.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = networkApi$upPhoto$1.label;
        if (i != 0) {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            return ((Result) obj).getValue();
        }
        ResultKt.throwOnFailure(obj);
        NetworkApi$upPhoto$2 networkApi$upPhoto$2 = new NetworkApi$upPhoto$2(list, null);
        networkApi$upPhoto$1.label = 1;
        Object obj2 = m485getResultgIAlus(networkApi$upPhoto$2, networkApi$upPhoto$1);
        return obj2 == coroutine_suspended ? coroutine_suspended : obj2;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    /* JADX INFO: renamed from: getLocationInfo-IoAF18A, reason: not valid java name */
    public final Object m432getLocationInfoIoAF18A(Continuation<? super Result<? extends List<AreaBean>>> continuation) {
        NetworkApi$getLocationInfo$1 networkApi$getLocationInfo$1;
        if (continuation instanceof NetworkApi$getLocationInfo$1) {
            networkApi$getLocationInfo$1 = (NetworkApi$getLocationInfo$1) continuation;
            if ((networkApi$getLocationInfo$1.label & Integer.MIN_VALUE) != 0) {
                networkApi$getLocationInfo$1.label -= Integer.MIN_VALUE;
            } else {
                networkApi$getLocationInfo$1 = new NetworkApi$getLocationInfo$1(this, continuation);
            }
        } else {
            networkApi$getLocationInfo$1 = new NetworkApi$getLocationInfo$1(this, continuation);
        }
        Object obj = networkApi$getLocationInfo$1.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = networkApi$getLocationInfo$1.label;
        if (i != 0) {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            return ((Result) obj).getValue();
        }
        ResultKt.throwOnFailure(obj);
        NetworkApi$getLocationInfo$2 networkApi$getLocationInfo$2 = new NetworkApi$getLocationInfo$2(null);
        networkApi$getLocationInfo$1.label = 1;
        Object obj2 = m485getResultgIAlus(networkApi$getLocationInfo$2, networkApi$getLocationInfo$1);
        return obj2 == coroutine_suspended ? coroutine_suspended : obj2;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    /* JADX INFO: renamed from: getCourseListData-gIAlu-s, reason: not valid java name */
    public final Object m425getCourseListDatagIAlus(RequestBody requestBody, Continuation<? super Result<? extends KBRsp2.DataDTO>> continuation) {
        NetworkApi$getCourseListData$1 networkApi$getCourseListData$1;
        if (continuation instanceof NetworkApi$getCourseListData$1) {
            networkApi$getCourseListData$1 = (NetworkApi$getCourseListData$1) continuation;
            if ((networkApi$getCourseListData$1.label & Integer.MIN_VALUE) != 0) {
                networkApi$getCourseListData$1.label -= Integer.MIN_VALUE;
            } else {
                networkApi$getCourseListData$1 = new NetworkApi$getCourseListData$1(this, continuation);
            }
        } else {
            networkApi$getCourseListData$1 = new NetworkApi$getCourseListData$1(this, continuation);
        }
        Object obj = networkApi$getCourseListData$1.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = networkApi$getCourseListData$1.label;
        if (i != 0) {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            return ((Result) obj).getValue();
        }
        ResultKt.throwOnFailure(obj);
        NetworkApi$getCourseListData$2 networkApi$getCourseListData$2 = new NetworkApi$getCourseListData$2(requestBody, null);
        networkApi$getCourseListData$1.label = 1;
        Object obj2 = m485getResultgIAlus(networkApi$getCourseListData$2, networkApi$getCourseListData$1);
        return obj2 == coroutine_suspended ? coroutine_suspended : obj2;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    /* JADX INFO: renamed from: requestClassMe-gIAlu-s, reason: not valid java name */
    public final Object m448requestClassMegIAlus(RequestBody requestBody, Continuation<? super Result<IndexClassMEModel>> continuation) {
        NetworkApi$requestClassMe$1 networkApi$requestClassMe$1;
        if (continuation instanceof NetworkApi$requestClassMe$1) {
            networkApi$requestClassMe$1 = (NetworkApi$requestClassMe$1) continuation;
            if ((networkApi$requestClassMe$1.label & Integer.MIN_VALUE) != 0) {
                networkApi$requestClassMe$1.label -= Integer.MIN_VALUE;
            } else {
                networkApi$requestClassMe$1 = new NetworkApi$requestClassMe$1(this, continuation);
            }
        } else {
            networkApi$requestClassMe$1 = new NetworkApi$requestClassMe$1(this, continuation);
        }
        Object obj = networkApi$requestClassMe$1.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = networkApi$requestClassMe$1.label;
        if (i != 0) {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            return ((Result) obj).getValue();
        }
        ResultKt.throwOnFailure(obj);
        NetworkApi$requestClassMe$2 networkApi$requestClassMe$2 = new NetworkApi$requestClassMe$2(requestBody, null);
        networkApi$requestClassMe$1.label = 1;
        Object obj2 = m485getResultgIAlus(networkApi$requestClassMe$2, networkApi$requestClassMe$1);
        return obj2 == coroutine_suspended ? coroutine_suspended : obj2;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    /* JADX INFO: renamed from: requestDailyScoreDetails-gIAlu-s, reason: not valid java name */
    public final Object m454requestDailyScoreDetailsgIAlus(RequestBody requestBody, Continuation<? super Result<? extends List<ScoringDetailCycleModel>>> continuation) {
        NetworkApi$requestDailyScoreDetails$1 networkApi$requestDailyScoreDetails$1;
        if (continuation instanceof NetworkApi$requestDailyScoreDetails$1) {
            networkApi$requestDailyScoreDetails$1 = (NetworkApi$requestDailyScoreDetails$1) continuation;
            if ((networkApi$requestDailyScoreDetails$1.label & Integer.MIN_VALUE) != 0) {
                networkApi$requestDailyScoreDetails$1.label -= Integer.MIN_VALUE;
            } else {
                networkApi$requestDailyScoreDetails$1 = new NetworkApi$requestDailyScoreDetails$1(this, continuation);
            }
        } else {
            networkApi$requestDailyScoreDetails$1 = new NetworkApi$requestDailyScoreDetails$1(this, continuation);
        }
        Object obj = networkApi$requestDailyScoreDetails$1.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = networkApi$requestDailyScoreDetails$1.label;
        if (i != 0) {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            return ((Result) obj).getValue();
        }
        ResultKt.throwOnFailure(obj);
        NetworkApi$requestDailyScoreDetails$2 networkApi$requestDailyScoreDetails$2 = new NetworkApi$requestDailyScoreDetails$2(requestBody, null);
        networkApi$requestDailyScoreDetails$1.label = 1;
        Object obj2 = m485getResultgIAlus(networkApi$requestDailyScoreDetails$2, networkApi$requestDailyScoreDetails$1);
        return obj2 == coroutine_suspended ? coroutine_suspended : obj2;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    /* JADX INFO: renamed from: requestScoringRubric-gIAlu-s, reason: not valid java name */
    public final Object m466requestScoringRubricgIAlus(RequestBody requestBody, Continuation<? super Result<? extends List<FirstIndicatorModel>>> continuation) {
        NetworkApi$requestScoringRubric$1 networkApi$requestScoringRubric$1;
        if (continuation instanceof NetworkApi$requestScoringRubric$1) {
            networkApi$requestScoringRubric$1 = (NetworkApi$requestScoringRubric$1) continuation;
            if ((networkApi$requestScoringRubric$1.label & Integer.MIN_VALUE) != 0) {
                networkApi$requestScoringRubric$1.label -= Integer.MIN_VALUE;
            } else {
                networkApi$requestScoringRubric$1 = new NetworkApi$requestScoringRubric$1(this, continuation);
            }
        } else {
            networkApi$requestScoringRubric$1 = new NetworkApi$requestScoringRubric$1(this, continuation);
        }
        Object obj = networkApi$requestScoringRubric$1.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = networkApi$requestScoringRubric$1.label;
        if (i != 0) {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            return ((Result) obj).getValue();
        }
        ResultKt.throwOnFailure(obj);
        NetworkApi$requestScoringRubric$2 networkApi$requestScoringRubric$2 = new NetworkApi$requestScoringRubric$2(requestBody, null);
        networkApi$requestScoringRubric$1.label = 1;
        Object obj2 = m485getResultgIAlus(networkApi$requestScoringRubric$2, networkApi$requestScoringRubric$1);
        return obj2 == coroutine_suspended ? coroutine_suspended : obj2;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    /* JADX INFO: renamed from: gotoScore-gIAlu-s, reason: not valid java name */
    public final Object m437gotoScoregIAlus(RequestBody requestBody, Continuation<? super Result<Float>> continuation) {
        NetworkApi$gotoScore$1 networkApi$gotoScore$1;
        if (continuation instanceof NetworkApi$gotoScore$1) {
            networkApi$gotoScore$1 = (NetworkApi$gotoScore$1) continuation;
            if ((networkApi$gotoScore$1.label & Integer.MIN_VALUE) != 0) {
                networkApi$gotoScore$1.label -= Integer.MIN_VALUE;
            } else {
                networkApi$gotoScore$1 = new NetworkApi$gotoScore$1(this, continuation);
            }
        } else {
            networkApi$gotoScore$1 = new NetworkApi$gotoScore$1(this, continuation);
        }
        Object obj = networkApi$gotoScore$1.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = networkApi$gotoScore$1.label;
        if (i != 0) {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            return ((Result) obj).getValue();
        }
        ResultKt.throwOnFailure(obj);
        NetworkApi$gotoScore$2 networkApi$gotoScore$2 = new NetworkApi$gotoScore$2(requestBody, null);
        networkApi$gotoScore$1.label = 1;
        Object obj2 = m485getResultgIAlus(networkApi$gotoScore$2, networkApi$gotoScore$1);
        return obj2 == coroutine_suspended ? coroutine_suspended : obj2;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    /* JADX INFO: renamed from: securityCheck-gIAlu-s, reason: not valid java name */
    public final Object m472securityCheckgIAlus(RequestBody requestBody, Continuation<? super Result<CheckSecurityModel>> continuation) {
        NetworkApi$securityCheck$1 networkApi$securityCheck$1;
        if (continuation instanceof NetworkApi$securityCheck$1) {
            networkApi$securityCheck$1 = (NetworkApi$securityCheck$1) continuation;
            if ((networkApi$securityCheck$1.label & Integer.MIN_VALUE) != 0) {
                networkApi$securityCheck$1.label -= Integer.MIN_VALUE;
            } else {
                networkApi$securityCheck$1 = new NetworkApi$securityCheck$1(this, continuation);
            }
        } else {
            networkApi$securityCheck$1 = new NetworkApi$securityCheck$1(this, continuation);
        }
        Object obj = networkApi$securityCheck$1.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = networkApi$securityCheck$1.label;
        if (i != 0) {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            return ((Result) obj).getValue();
        }
        ResultKt.throwOnFailure(obj);
        NetworkApi$securityCheck$2 networkApi$securityCheck$2 = new NetworkApi$securityCheck$2(requestBody, null);
        networkApi$securityCheck$1.label = 1;
        Object obj2 = m485getResultgIAlus(networkApi$securityCheck$2, networkApi$securityCheck$1);
        return obj2 == coroutine_suspended ? coroutine_suspended : obj2;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    /* JADX INFO: renamed from: getClassesInfo-IoAF18A, reason: not valid java name */
    public final Object m424getClassesInfoIoAF18A(Continuation<? super Result<? extends NewClassInfoRsp.DataDTO>> continuation) {
        NetworkApi$getClassesInfo$1 networkApi$getClassesInfo$1;
        if (continuation instanceof NetworkApi$getClassesInfo$1) {
            networkApi$getClassesInfo$1 = (NetworkApi$getClassesInfo$1) continuation;
            if ((networkApi$getClassesInfo$1.label & Integer.MIN_VALUE) != 0) {
                networkApi$getClassesInfo$1.label -= Integer.MIN_VALUE;
            } else {
                networkApi$getClassesInfo$1 = new NetworkApi$getClassesInfo$1(this, continuation);
            }
        } else {
            networkApi$getClassesInfo$1 = new NetworkApi$getClassesInfo$1(this, continuation);
        }
        Object obj = networkApi$getClassesInfo$1.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = networkApi$getClassesInfo$1.label;
        if (i != 0) {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            return ((Result) obj).getValue();
        }
        ResultKt.throwOnFailure(obj);
        NetworkApi$getClassesInfo$2 networkApi$getClassesInfo$2 = new NetworkApi$getClassesInfo$2(null);
        networkApi$getClassesInfo$1.label = 1;
        Object obj2 = m485getResultgIAlus(networkApi$getClassesInfo$2, networkApi$getClassesInfo$1);
        return obj2 == coroutine_suspended ? coroutine_suspended : obj2;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    /* JADX INFO: renamed from: getWatchWord-gIAlu-s, reason: not valid java name */
    public final Object m436getWatchWordgIAlus(RequestBody requestBody, Continuation<? super Result<? extends List<? extends NewWatchWordRsp.DataDTO>>> continuation) {
        NetworkApi$getWatchWord$1 networkApi$getWatchWord$1;
        if (continuation instanceof NetworkApi$getWatchWord$1) {
            networkApi$getWatchWord$1 = (NetworkApi$getWatchWord$1) continuation;
            if ((networkApi$getWatchWord$1.label & Integer.MIN_VALUE) != 0) {
                networkApi$getWatchWord$1.label -= Integer.MIN_VALUE;
            } else {
                networkApi$getWatchWord$1 = new NetworkApi$getWatchWord$1(this, continuation);
            }
        } else {
            networkApi$getWatchWord$1 = new NetworkApi$getWatchWord$1(this, continuation);
        }
        Object obj = networkApi$getWatchWord$1.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = networkApi$getWatchWord$1.label;
        if (i != 0) {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            return ((Result) obj).getValue();
        }
        ResultKt.throwOnFailure(obj);
        NetworkApi$getWatchWord$2 networkApi$getWatchWord$2 = new NetworkApi$getWatchWord$2(requestBody, null);
        networkApi$getWatchWord$1.label = 1;
        Object obj2 = m485getResultgIAlus(networkApi$getWatchWord$2, networkApi$getWatchWord$1);
        return obj2 == coroutine_suspended ? coroutine_suspended : obj2;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    /* JADX INFO: renamed from: verifyTeacherLogin-gIAlu-s, reason: not valid java name */
    public final Object m475verifyTeacherLogingIAlus(RequestBody requestBody, Continuation<? super Result<VerifyTeacherLoginBean>> continuation) {
        NetworkApi$verifyTeacherLogin$1 networkApi$verifyTeacherLogin$1;
        if (continuation instanceof NetworkApi$verifyTeacherLogin$1) {
            networkApi$verifyTeacherLogin$1 = (NetworkApi$verifyTeacherLogin$1) continuation;
            if ((networkApi$verifyTeacherLogin$1.label & Integer.MIN_VALUE) != 0) {
                networkApi$verifyTeacherLogin$1.label -= Integer.MIN_VALUE;
            } else {
                networkApi$verifyTeacherLogin$1 = new NetworkApi$verifyTeacherLogin$1(this, continuation);
            }
        } else {
            networkApi$verifyTeacherLogin$1 = new NetworkApi$verifyTeacherLogin$1(this, continuation);
        }
        Object obj = networkApi$verifyTeacherLogin$1.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = networkApi$verifyTeacherLogin$1.label;
        if (i != 0) {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            return ((Result) obj).getValue();
        }
        ResultKt.throwOnFailure(obj);
        NetworkApi$verifyTeacherLogin$2 networkApi$verifyTeacherLogin$2 = new NetworkApi$verifyTeacherLogin$2(requestBody, null);
        networkApi$verifyTeacherLogin$1.label = 1;
        Object obj2 = m485getResultgIAlus(networkApi$verifyTeacherLogin$2, networkApi$verifyTeacherLogin$1);
        return obj2 == coroutine_suspended ? coroutine_suspended : obj2;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    /* JADX INFO: renamed from: classesOverInfo-IoAF18A, reason: not valid java name */
    public final Object m419classesOverInfoIoAF18A(Continuation<? super Result<ClassesOverInfoBean>> continuation) {
        NetworkApi$classesOverInfo$1 networkApi$classesOverInfo$1;
        if (continuation instanceof NetworkApi$classesOverInfo$1) {
            networkApi$classesOverInfo$1 = (NetworkApi$classesOverInfo$1) continuation;
            if ((networkApi$classesOverInfo$1.label & Integer.MIN_VALUE) != 0) {
                networkApi$classesOverInfo$1.label -= Integer.MIN_VALUE;
            } else {
                networkApi$classesOverInfo$1 = new NetworkApi$classesOverInfo$1(this, continuation);
            }
        } else {
            networkApi$classesOverInfo$1 = new NetworkApi$classesOverInfo$1(this, continuation);
        }
        Object obj = networkApi$classesOverInfo$1.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = networkApi$classesOverInfo$1.label;
        if (i != 0) {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            return ((Result) obj).getValue();
        }
        ResultKt.throwOnFailure(obj);
        NetworkApi$classesOverInfo$2 networkApi$classesOverInfo$2 = new NetworkApi$classesOverInfo$2(null);
        networkApi$classesOverInfo$1.label = 1;
        Object obj2 = m485getResultgIAlus(networkApi$classesOverInfo$2, networkApi$classesOverInfo$1);
        return obj2 == coroutine_suspended ? coroutine_suspended : obj2;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    /* JADX INFO: renamed from: oneKeySchool-gIAlu-s, reason: not valid java name */
    public final Object m439oneKeySchoolgIAlus(RequestBody requestBody, Continuation<? super Result<Boolean>> continuation) {
        NetworkApi$oneKeySchool$1 networkApi$oneKeySchool$1;
        if (continuation instanceof NetworkApi$oneKeySchool$1) {
            networkApi$oneKeySchool$1 = (NetworkApi$oneKeySchool$1) continuation;
            if ((networkApi$oneKeySchool$1.label & Integer.MIN_VALUE) != 0) {
                networkApi$oneKeySchool$1.label -= Integer.MIN_VALUE;
            } else {
                networkApi$oneKeySchool$1 = new NetworkApi$oneKeySchool$1(this, continuation);
            }
        } else {
            networkApi$oneKeySchool$1 = new NetworkApi$oneKeySchool$1(this, continuation);
        }
        Object obj = networkApi$oneKeySchool$1.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = networkApi$oneKeySchool$1.label;
        if (i != 0) {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            return ((Result) obj).getValue();
        }
        ResultKt.throwOnFailure(obj);
        NetworkApi$oneKeySchool$2 networkApi$oneKeySchool$2 = new NetworkApi$oneKeySchool$2(requestBody, null);
        networkApi$oneKeySchool$1.label = 1;
        Object obj2 = m485getResultgIAlus(networkApi$oneKeySchool$2, networkApi$oneKeySchool$1);
        return obj2 == coroutine_suspended ? coroutine_suspended : obj2;
    }
}
