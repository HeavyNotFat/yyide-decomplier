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
import com.yd.android_brand_mvp.network.base.BasePageResponse;
import com.yd.android_brand_mvp.network.base.BaseResponse;
import com.yyide.chatim_pro.model.honor.HonorScoreDetailBean;
import java.util.List;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;
import retrofit2.http.Query;
import retrofit2.http.Streaming;
import retrofit2.http.Url;

/* JADX INFO: compiled from: INetworkService.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000ø\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H§@ø\u0001\u0000¢\u0006\u0002\u0010\u0005J\u001b\u0010\u0006\u001a\u00020\u00072\b\b\u0001\u0010\b\u001a\u00020\tH§@ø\u0001\u0000¢\u0006\u0002\u0010\nJ!\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\f0\u00032\b\b\u0001\u0010\r\u001a\u00020\u000eH§@ø\u0001\u0000¢\u0006\u0002\u0010\u000fJ!\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00110\u00032\b\b\u0001\u0010\u0012\u001a\u00020\u000eH§@ø\u0001\u0000¢\u0006\u0002\u0010\u000fJ!\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00140\u00032\b\b\u0001\u0010\u0012\u001a\u00020\u000eH§@ø\u0001\u0000¢\u0006\u0002\u0010\u000fJ!\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00160\u00032\b\b\u0001\u0010\u0017\u001a\u00020\tH§@ø\u0001\u0000¢\u0006\u0002\u0010\nJ\u0017\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00190\u0003H§@ø\u0001\u0000¢\u0006\u0002\u0010\u0005J'\u0010\u001a\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001c0\u001b0\u00032\b\b\u0001\u0010\u0012\u001a\u00020\u000eH§@ø\u0001\u0000¢\u0006\u0002\u0010\u000fJ!\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u001e0\u00032\b\b\u0001\u0010\u001f\u001a\u00020\tH§@ø\u0001\u0000¢\u0006\u0002\u0010\nJ!\u0010 \u001a\b\u0012\u0004\u0012\u00020\u00160\u00032\b\b\u0001\u0010\u001f\u001a\u00020\tH§@ø\u0001\u0000¢\u0006\u0002\u0010\nJ!\u0010!\u001a\b\u0012\u0004\u0012\u00020\f0\u00032\b\b\u0001\u0010\u0012\u001a\u00020\u000eH§@ø\u0001\u0000¢\u0006\u0002\u0010\u000fJ'\u0010\"\u001a\f\u0012\b\u0012\u00060#R\u00020$0\u00032\n\b\u0001\u0010%\u001a\u0004\u0018\u00010\tH§@ø\u0001\u0000¢\u0006\u0002\u0010\nJ)\u0010&\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020(0'0\u00032\n\b\u0001\u0010)\u001a\u0004\u0018\u00010\u000eH§@ø\u0001\u0000¢\u0006\u0002\u0010\u000fJ!\u0010*\u001a\b\u0012\u0004\u0012\u00020+0\u00032\b\b\u0001\u0010\u0012\u001a\u00020\u000eH§@ø\u0001\u0000¢\u0006\u0002\u0010\u000fJI\u0010,\u001a\b\u0012\u0004\u0012\u00020-0\u00032\b\b\u0001\u0010.\u001a\u00020\t2\b\b\u0001\u0010/\u001a\u00020\t2\b\b\u0001\u00100\u001a\u00020\t2\b\b\u0001\u00101\u001a\u00020\t2\b\b\u0001\u00102\u001a\u00020\tH§@ø\u0001\u0000¢\u0006\u0002\u00103J#\u00104\u001a\b\u0012\u0004\u0012\u0002050\u00032\n\b\u0001\u0010)\u001a\u0004\u0018\u00010\u000eH§@ø\u0001\u0000¢\u0006\u0002\u0010\u000fJ!\u00106\u001a\b\u0012\u0004\u0012\u00020\t0\u00032\b\b\u0001\u0010\u0012\u001a\u00020\u000eH§@ø\u0001\u0000¢\u0006\u0002\u0010\u000fJ!\u00107\u001a\b\u0012\u0004\u0012\u0002080\u00032\b\b\u0001\u0010\u0012\u001a\u00020\u000eH§@ø\u0001\u0000¢\u0006\u0002\u0010\u000fJ-\u00109\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020;0\u001b0:0\u00032\b\b\u0001\u0010\u0012\u001a\u00020\u000eH§@ø\u0001\u0000¢\u0006\u0002\u0010\u000fJ!\u0010<\u001a\b\u0012\u0004\u0012\u00020=0\u00032\b\b\u0001\u0010\u0012\u001a\u00020\u000eH§@ø\u0001\u0000¢\u0006\u0002\u0010\u000fJ'\u0010>\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020?0\u001b0\u00032\b\b\u0001\u0010\u0012\u001a\u00020\u000eH§@ø\u0001\u0000¢\u0006\u0002\u0010\u000fJ!\u0010@\u001a\b\u0012\u0004\u0012\u00020\t0\u00032\b\b\u0001\u0010\u0012\u001a\u00020\u000eH§@ø\u0001\u0000¢\u0006\u0002\u0010\u000fJ\u001d\u0010A\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020B0'0\u0003H§@ø\u0001\u0000¢\u0006\u0002\u0010\u0005J)\u0010C\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020D0\u001b0\u00032\n\b\u0001\u0010\u0012\u001a\u0004\u0018\u00010\u000eH§@ø\u0001\u0000¢\u0006\u0002\u0010\u000fJ-\u0010E\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020F0\u001b0:0\u00032\b\b\u0001\u0010\u0012\u001a\u00020\u000eH§@ø\u0001\u0000¢\u0006\u0002\u0010\u000fJ!\u0010G\u001a\b\u0012\u0004\u0012\u00020H0\u00032\b\b\u0001\u0010\u0012\u001a\u00020\u000eH§@ø\u0001\u0000¢\u0006\u0002\u0010\u000fJ!\u0010I\u001a\b\u0012\u0004\u0012\u00020\t0\u00032\b\b\u0001\u0010\u0012\u001a\u00020\u000eH§@ø\u0001\u0000¢\u0006\u0002\u0010\u000fJ'\u0010J\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020K0\u001b0\u00032\b\b\u0001\u0010\u0012\u001a\u00020\u000eH§@ø\u0001\u0000¢\u0006\u0002\u0010\u000fJ!\u0010L\u001a\b\u0012\u0004\u0012\u00020\t0\u00032\b\b\u0001\u0010%\u001a\u00020\tH§@ø\u0001\u0000¢\u0006\u0002\u0010\nJ!\u0010M\u001a\b\u0012\u0004\u0012\u00020N0\u00032\b\b\u0001\u0010%\u001a\u00020\tH§@ø\u0001\u0000¢\u0006\u0002\u0010\nJ-\u0010O\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020N0\u001b0:0\u00032\b\b\u0001\u0010\u0012\u001a\u00020\u000eH§@ø\u0001\u0000¢\u0006\u0002\u0010\u000fJ!\u0010P\u001a\b\u0012\u0004\u0012\u00020Q0\u00032\b\b\u0001\u0010\u0012\u001a\u00020\u000eH§@ø\u0001\u0000¢\u0006\u0002\u0010\u000fJ'\u0010R\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020S0'0\u00032\b\b\u0001\u0010%\u001a\u00020\tH§@ø\u0001\u0000¢\u0006\u0002\u0010\nJ'\u0010T\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020U0'0\u00032\b\b\u0001\u0010\u0012\u001a\u00020\u000eH§@ø\u0001\u0000¢\u0006\u0002\u0010\u000fJ\u001d\u0010V\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020W0'0\u0003H§@ø\u0001\u0000¢\u0006\u0002\u0010\u0005J!\u0010X\u001a\b\u0012\u0004\u0012\u00020Y0\u00032\b\b\u0001\u0010\u0012\u001a\u00020\u000eH§@ø\u0001\u0000¢\u0006\u0002\u0010\u000fJ!\u0010Z\u001a\b\u0012\u0004\u0012\u00020[0\u00032\b\b\u0001\u0010\u0012\u001a\u00020\u000eH§@ø\u0001\u0000¢\u0006\u0002\u0010\u000fJ+\u0010\\\u001a\b\u0012\u0004\u0012\u00020]0\u00032\b\b\u0001\u0010^\u001a\u00020\t2\b\b\u0001\u0010_\u001a\u00020\tH§@ø\u0001\u0000¢\u0006\u0002\u0010`J!\u0010a\u001a\b\u0012\u0004\u0012\u00020b0\u00032\b\b\u0001\u0010\r\u001a\u00020\u000eH§@ø\u0001\u0000¢\u0006\u0002\u0010\u000fJ-\u0010c\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020d0\u001b0:0\u00032\b\b\u0001\u0010\u0012\u001a\u00020\u000eH§@ø\u0001\u0000¢\u0006\u0002\u0010\u000fJ-\u0010e\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020f0\u001b0:0\u00032\b\b\u0001\u0010\u0012\u001a\u00020\u000eH§@ø\u0001\u0000¢\u0006\u0002\u0010\u000fJ!\u0010g\u001a\b\u0012\u0004\u0012\u00020h0\u00032\b\b\u0001\u0010\u0012\u001a\u00020\u000eH§@ø\u0001\u0000¢\u0006\u0002\u0010\u000fJ'\u0010i\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020j0'0\u00032\b\b\u0001\u0010\u0012\u001a\u00020\u000eH§@ø\u0001\u0000¢\u0006\u0002\u0010\u000fJ\u0017\u0010k\u001a\b\u0012\u0004\u0012\u00020l0\u0003H§@ø\u0001\u0000¢\u0006\u0002\u0010\u0005J-\u0010m\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020j0\u001b0:0\u00032\b\b\u0001\u0010\u0012\u001a\u00020\u000eH§@ø\u0001\u0000¢\u0006\u0002\u0010\u000fJ+\u0010n\u001a\b\u0012\u0004\u0012\u00020o0\u00032\b\b\u0001\u0010\u001f\u001a\u00020\t2\b\b\u0001\u0010^\u001a\u00020\tH§@ø\u0001\u0000¢\u0006\u0002\u0010`J!\u0010p\u001a\b\u0012\u0004\u0012\u00020o0\u00032\b\b\u0001\u0010\u0017\u001a\u00020\tH§@ø\u0001\u0000¢\u0006\u0002\u0010\nJ!\u0010q\u001a\b\u0012\u0004\u0012\u00020r0\u00032\b\b\u0001\u0010\u0012\u001a\u00020\u000eH§@ø\u0001\u0000¢\u0006\u0002\u0010\u000fJ!\u0010s\u001a\b\u0012\u0004\u0012\u00020\t0\u00032\b\b\u0001\u0010\u0012\u001a\u00020\u000eH§@ø\u0001\u0000¢\u0006\u0002\u0010\u000fJ'\u0010t\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020u0'0\u00032\b\b\u0001\u0010\u0012\u001a\u00020\u000eH§@ø\u0001\u0000¢\u0006\u0002\u0010\u000fJ!\u0010v\u001a\b\u0012\u0004\u0012\u00020w0\u00032\b\b\u0001\u0010%\u001a\u00020\tH§@ø\u0001\u0000¢\u0006\u0002\u0010\nJ-\u0010x\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020y0\u001b0:0\u00032\b\b\u0001\u0010\u0012\u001a\u00020\u000eH§@ø\u0001\u0000¢\u0006\u0002\u0010\u000fJ!\u0010z\u001a\b\u0012\u0004\u0012\u00020\t0\u00032\b\b\u0001\u0010\u0012\u001a\u00020\u000eH§@ø\u0001\u0000¢\u0006\u0002\u0010\u000fJ!\u0010{\u001a\b\u0012\u0004\u0012\u00020\t0\u00032\b\b\u0001\u0010\u0012\u001a\u00020\u000eH§@ø\u0001\u0000¢\u0006\u0002\u0010\u000fJ!\u0010|\u001a\b\u0012\u0004\u0012\u00020}0\u00032\b\b\u0001\u0010\u0012\u001a\u00020\u000eH§@ø\u0001\u0000¢\u0006\u0002\u0010\u000fJ#\u0010~\u001a\b\u0012\u0004\u0012\u00020\u007f0\u00032\n\b\u0001\u0010\u0012\u001a\u0004\u0018\u00010\u000eH§@ø\u0001\u0000¢\u0006\u0002\u0010\u000fJ#\u0010\u0080\u0001\u001a\t\u0012\u0005\u0012\u00030\u0081\u00010\u00032\b\b\u0001\u0010\u0012\u001a\u00020\u000eH§@ø\u0001\u0000¢\u0006\u0002\u0010\u000fJ#\u0010\u0082\u0001\u001a\t\u0012\u0005\u0012\u00030\u0083\u00010\u00032\b\b\u0001\u0010\u0012\u001a\u00020\u000eH§@ø\u0001\u0000¢\u0006\u0002\u0010\u000fJ\"\u0010\u0084\u0001\u001a\b\u0012\u0004\u0012\u00020\f0\u00032\b\b\u0001\u0010\r\u001a\u00020\u000eH§@ø\u0001\u0000¢\u0006\u0002\u0010\u000fJ1\u0010\u0085\u0001\u001a\u000f\u0012\u000b\u0012\t\u0012\u0005\u0012\u00030\u0086\u00010'0\u00032\u000f\b\u0001\u0010)\u001a\t\u0012\u0005\u0012\u00030\u0087\u00010'H§@ø\u0001\u0000¢\u0006\u0003\u0010\u0088\u0001J%\u0010\u0089\u0001\u001a\t\u0012\u0005\u0012\u00030\u008a\u00010\u00032\n\b\u0001\u0010)\u001a\u0004\u0018\u00010\u000eH§@ø\u0001\u0000¢\u0006\u0002\u0010\u000f\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u008b\u0001"}, d2 = {"Lcom/yd/android_brand_mvp/network/INetworkService;", "", "classesOverInfo", "Lcom/yd/android_brand_mvp/network/base/BaseResponse;", "Lcom/yd/android_brand_mvp/model/ClassesOverInfoBean;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "downloadFile", "Lokhttp3/ResponseBody;", "url", "", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getActivationCode", "Lcom/yd/android_brand_mvp/model/getRegistrationCodeRsp;", TtmlNode.TAG_BODY, "Lokhttp3/RequestBody;", "(Lokhttp3/RequestBody;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getBrandInfo", "Lcom/yd/android_brand_mvp/model/NewBrandLoginRsp;", "requestBody", "getBrandRegistrationCode", "Lcom/yd/android_brand_mvp/model/BrandRegistrationCodeRsp;", "getCheckLoginQrCode", "Lcom/yd/android_brand_mvp/model/LoginQrCodeBean;", "random", "getClassesInfo", "Lcom/yd/android_brand_mvp/model/NewClassInfoRsp$DataDTO;", "getDutyWeekList", "", "Lcom/yd/android_brand_mvp/model/duty/DutyModel;", "getLeaveWordSetting", "Lcom/yd/android_brand_mvp/model/ConfigComplaintBean;", "type", "getLoginQrCode", "getRegistrationCode", "getUserSig", "Lcom/yd/android_brand_mvp/model/getUserSigByUserIdRsp$DataBean;", "Lcom/yd/android_brand_mvp/model/getUserSigByUserIdRsp;", "id", "getWatchWord", "", "Lcom/yd/android_brand_mvp/model/NewWatchWordRsp$DataDTO;", "info", "gotoScore", "", FirebaseAnalytics.Event.LOGIN, "Lcom/yd/android_brand_mvp/model/NewLoginRsp;", "username", "password", "client_id", "grant_type", "client_secret", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "oneKeySchool", "", "pauschCard", "requestActiveDetail", "Lcom/yd/android_brand_mvp/model/honor/HonorActiveDetailBean;", "requestActiveHonorList", "Lcom/yd/android_brand_mvp/network/base/BasePageResponse;", "Lcom/yd/android_brand_mvp/model/honor/HonorActiveBean;", "requestActiveResultList", "Lcom/yd/android_brand_mvp/model/honor/HonorCommentResultBean;", "requestActivityCycle", "Lcom/yd/android_brand_mvp/model/honor/HonorScoreCycleBean;", "requestAddComments", "requestAreaInfo", "Lcom/yd/android_brand_mvp/model/AreaBean;", "requestAttendance", "Lcom/yd/android_brand_mvp/model/AttenceNewListBean$DataDTO;", "requestClassHonorList", "Lcom/yd/android_brand_mvp/model/honor/HonorClassBean;", "requestClassMe", "Lcom/yd/android_brand_mvp/landscape/moraleducation/model/IndexClassMEModel;", "requestClassScoreComment", "requestClassScoreResult", "Lcom/yd/android_brand_mvp/model/honor/HonorScoreListBean;", "requestCommentsDelete", "requestCommentsDetail", "Lcom/yd/android_brand_mvp/model/comments/CommentsDetailBean;", "requestCommentsList", "requestCourseList", "Lcom/yd/android_brand_mvp/model/KBRsp2$DataDTO;", "requestCustomDominateScreenList", "Lcom/yd/android_brand_mvp/model/home/DominateCustomBean;", "requestDailyScoreDetails", "Lcom/yd/android_brand_mvp/landscape/moraleducation/model/ScoringDetailCycleModel;", "requestDominateScreenLevel", "Lcom/yd/android_brand_mvp/model/DominateDetailLevelBean;", "requestFaceConfig", "Lcom/yd/android_brand_mvp/model/FaceActiveConfigBean;", "requestGoToScore", "Lcom/yd/android_brand_mvp/model/honor/HonorGoCommentBean;", "requestHomeCaption", "Lcom/yd/android_brand_mvp/model/MessageCaptionBean;", "schoolId", "deviceId", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "requestHonorWallList", "Lcom/yd/android_brand_mvp/model/honor/HonorWallBean;", "requestIdentityDetail", "Lcom/yyide/chatim_pro/model/honor/HonorScoreDetailBean;", "requestKidsHonorList", "Lcom/yd/android_brand_mvp/model/honor/HonorKidsLIstBean;", "requestMessage", "Lcom/yd/android_brand_mvp/model/getNoticeRsp$DataDTO;", "requestMessageDominateScreenList", "Lcom/yd/android_brand_mvp/model/MessageItemBean;", "requestMessageHome", "Lcom/yd/android_brand_mvp/model/MessageListBean;", "requestMessageList", "requestQrCode", "Lcom/yd/android_brand_mvp/model/ScanQrCodeBean;", "requestQrCodeCheck", "requestRTSPPath", "Lcom/yd/android_brand_mvp/model/LayoutListRsp$DataBean$LayoutClassSignDetailsEntityListBean;", "requestRecords", "requestScoringRubric", "Lcom/yd/android_brand_mvp/landscape/moraleducation/model/FirstIndicatorModel;", "requestSiteInfo", "Lcom/yd/android_brand_mvp/model/SiteInfoBean;", "requestStudentHonorList", "Lcom/yd/android_brand_mvp/model/honor/HonorStudentBean;", "requestStudentScoreComment", "requestSynchronizeStatusFaceExtraction", "securityCheck", "Lcom/yd/android_brand_mvp/landscape/moraleducation/model/CheckSecurityModel;", "selectNewStudentByIcCard", "Lcom/yd/android_brand_mvp/model/selectNewStudentByIcCardRsp$DataBean;", "selectTeacherInfoByCardOrFace", "Lcom/yd/android_brand_mvp/model/selectTeacherByIcCardRsp$DataDTO;", "selectUserByCardOrFace", "Lcom/yd/android_brand_mvp/model/UserIcCardBean$DataBean;", "updateNewRegistrationCodeByCode", "upload", "Lcom/yd/android_brand_mvp/model/UploadFileBean;", "Lokhttp3/MultipartBody$Part;", "(Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "verifyTeacherLogin", "Lcom/yd/android_brand_mvp/model/VerifyTeacherLoginBean;", "app_commonRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public interface INetworkService {
    @Headers({"Content-Type: application/json", "Accept: application/json"})
    @POST("/brand/after/school/log/board")
    Object classesOverInfo(Continuation<? super BaseResponse<ClassesOverInfoBean>> continuation);

    @Streaming
    @GET
    Object downloadFile(@Url String str, Continuation<? super ResponseBody> continuation);

    @Headers({"Content-Type: application/json", "Accept: application/json"})
    @POST("/cloud/v2/barrier/getOrBindingDevice")
    Object getActivationCode(@Body RequestBody requestBody, Continuation<? super BaseResponse<getRegistrationCodeRsp>> continuation);

    @Headers({"Content-Type: application/json", "Accept: application/json"})
    @POST("/brand/obtain")
    Object getBrandInfo(@Body RequestBody requestBody, Continuation<? super BaseResponse<NewBrandLoginRsp>> continuation);

    @Headers({"Content-Type: application/json", "Accept: application/json"})
    @POST("/cloud/v2/equipment/brand/getBrandAuthorizeCodeInfo")
    Object getBrandRegistrationCode(@Body RequestBody requestBody, Continuation<? super BaseResponse<BrandRegistrationCodeRsp>> continuation);

    @Headers({"Content-Type: application/json", "Accept: application/json"})
    @GET("/auth/qrcode/check")
    Object getCheckLoginQrCode(@Query("random") String str, Continuation<? super BaseResponse<LoginQrCodeBean>> continuation);

    @Headers({"Content-Type: application/json", "Accept: application/json"})
    @GET("/brand/brand/classes/info")
    Object getClassesInfo(Continuation<? super BaseResponse<NewClassInfoRsp.DataDTO>> continuation);

    @Headers({"Content-Type: application/json", "Accept: application/json"})
    @POST("/brand/brand/v3/studentduty/selectRecord")
    Object getDutyWeekList(@Body RequestBody requestBody, Continuation<? super BaseResponse<List<DutyModel>>> continuation);

    @Headers({"Content-Type: application/json", "Accept: application/json"})
    @GET("/cloud/leaveWord/getLeaveWordSetting")
    Object getLeaveWordSetting(@Query("type") String str, Continuation<? super BaseResponse<ConfigComplaintBean>> continuation);

    @Headers({"Content-Type: application/json", "Accept: application/json"})
    @GET("/auth/qrcode/gene")
    Object getLoginQrCode(@Query("type") String str, Continuation<? super BaseResponse<LoginQrCodeBean>> continuation);

    @Headers({"Content-Type: application/json", "Accept: application/json"})
    @POST("/cloud/v2/barrier/getRegistrationCode")
    Object getRegistrationCode(@Body RequestBody requestBody, Continuation<? super BaseResponse<getRegistrationCodeRsp>> continuation);

    @Headers({"Content-Type: application/json", "Accept: application/json"})
    @GET("/cloud/im/user/sig/gen")
    Object getUserSig(@Query("identifier") String str, Continuation<? super BaseResponse<getUserSigByUserIdRsp.DataBean>> continuation);

    @Headers({"Content-Type: application/json", "Accept: application/json"})
    @POST("/brand/brand/classes/watchword/list")
    Object getWatchWord(@Body RequestBody requestBody, Continuation<? super BaseResponse<List<NewWatchWordRsp.DataDTO>>> continuation);

    @Headers({"Content-Type: application/json", "Accept: application/json"})
    @POST("/cloud/moralEducationActivityBrand/gotoScore")
    Object gotoScore(@Body RequestBody requestBody, Continuation<? super BaseResponse<Float>> continuation);

    @Headers({"Content-Type: application/json", "Accept: application/json"})
    @POST("/brand/brand/mess/recive/index")
    Object login(@Query("username") String str, @Query("password") String str2, @Query("client_id") String str3, @Query("grant_type") String str4, @Query("client_secret") String str5, Continuation<? super BaseResponse<NewLoginRsp>> continuation);

    @Headers({"Content-Type: application/json", "Accept: application/json"})
    @POST("/brand/after/school/log/afterSchool")
    Object oneKeySchool(@Body RequestBody requestBody, Continuation<? super BaseResponse<Boolean>> continuation);

    @Headers({"Content-Type: application/json", "Accept: application/json"})
    @POST("/brand/upload/signInLog")
    Object pauschCard(@Body RequestBody requestBody, Continuation<? super BaseResponse<String>> continuation);

    @Headers({"Content-Type: application/json", "Accept: application/json"})
    @POST("/cloud/evaluationActivityBrand/detail")
    Object requestActiveDetail(@Body RequestBody requestBody, Continuation<? super BaseResponse<HonorActiveDetailBean>> continuation);

    @Headers({"Content-Type: application/json", "Accept: application/json"})
    @POST("/cloud/evaluationActivityBrand/list")
    Object requestActiveHonorList(@Body RequestBody requestBody, Continuation<? super BaseResponse<BasePageResponse<List<HonorActiveBean>>>> continuation);

    @Headers({"Content-Type: application/json", "Accept: application/json"})
    @POST("/cloud/evaluationActivityBrand/result")
    Object requestActiveResultList(@Body RequestBody requestBody, Continuation<? super BaseResponse<HonorCommentResultBean>> continuation);

    @Headers({"Content-Type: application/json", "Accept: application/json"})
    @POST("/cloud/evaluationActivityBrand/queryActivityCycle")
    Object requestActivityCycle(@Body RequestBody requestBody, Continuation<? super BaseResponse<List<HonorScoreCycleBean>>> continuation);

    @Headers({"Content-Type: application/json", "Accept: application/json"})
    @POST("/cloud/leaveWord/brand/create")
    Object requestAddComments(@Body RequestBody requestBody, Continuation<? super BaseResponse<String>> continuation);

    @Headers({"Content-Type: application/json", "Accept: application/json"})
    @GET("/app/area/list")
    Object requestAreaInfo(Continuation<? super BaseResponse<List<AreaBean>>> continuation);

    @Headers({"Content-Type: application/json", "Accept: application/json"})
    @POST("/attweb/app/attendance/listToDay")
    Object requestAttendance(@Body RequestBody requestBody, Continuation<? super BaseResponse<List<AttenceNewListBean.DataDTO>>> continuation);

    @Headers({"Content-Type: application/json", "Accept: application/json"})
    @POST("/cloud/evaluationPrize/classHonor")
    Object requestClassHonorList(@Body RequestBody requestBody, Continuation<? super BaseResponse<BasePageResponse<List<HonorClassBean>>>> continuation);

    @Headers({"Content-Type: application/json", "Accept: application/json"})
    @POST("/cloud/moralEducationActivityBrand/race")
    Object requestClassMe(@Body RequestBody requestBody, Continuation<? super BaseResponse<IndexClassMEModel>> continuation);

    @Headers({"Content-Type: application/json", "Accept: application/json"})
    @POST("/cloud/evaluationActivityBrand/scoreClass")
    Object requestClassScoreComment(@Body RequestBody requestBody, Continuation<? super BaseResponse<String>> continuation);

    @Headers({"Content-Type: application/json", "Accept: application/json"})
    @POST("/cloud/evaluationActivityBrand/queryLastClassScoreResult")
    Object requestClassScoreResult(@Body RequestBody requestBody, Continuation<? super BaseResponse<List<HonorScoreListBean>>> continuation);

    @Headers({"Content-Type: application/json", "Accept: application/json"})
    @GET("/cloud/leaveWord/delete")
    Object requestCommentsDelete(@Query("id") String str, Continuation<? super BaseResponse<String>> continuation);

    @Headers({"Content-Type: application/json", "Accept: application/json"})
    @GET("/cloud/leaveWord/get")
    Object requestCommentsDetail(@Query("id") String str, Continuation<? super BaseResponse<CommentsDetailBean>> continuation);

    @Headers({"Content-Type: application/json", "Accept: application/json"})
    @POST("/cloud/leaveWord/page")
    Object requestCommentsList(@Body RequestBody requestBody, Continuation<? super BaseResponse<BasePageResponse<List<CommentsDetailBean>>>> continuation);

    @Headers({"Content-Type: application/json", "Accept: application/json"})
    @POST("/cloud/app/timetable/getWeekTime")
    Object requestCourseList(@Body RequestBody requestBody, Continuation<? super BaseResponse<KBRsp2.DataDTO>> continuation);

    @Headers({"Content-Type: application/json", "Accept: application/json"})
    @GET("/brand/v2/custom/mode/list")
    Object requestCustomDominateScreenList(@Query("brandId") String str, Continuation<? super BaseResponse<List<DominateCustomBean>>> continuation);

    @Headers({"Content-Type: application/json", "Accept: application/json"})
    @POST("/cloud/moralEducationActivityBrand/overviewDetail")
    Object requestDailyScoreDetails(@Body RequestBody requestBody, Continuation<? super BaseResponse<List<ScoringDetailCycleModel>>> continuation);

    @Headers({"Content-Type: application/json", "Accept: application/json"})
    @GET("/brand/brand/getBrandDominateScreen")
    Object requestDominateScreenLevel(Continuation<? super BaseResponse<List<DominateDetailLevelBean>>> continuation);

    @Headers({"Content-Type: application/json", "Accept: application/json"})
    @POST("/cloud/device/shared-config/get")
    Object requestFaceConfig(@Body RequestBody requestBody, Continuation<? super BaseResponse<FaceActiveConfigBean>> continuation);

    @Headers({"Content-Type: application/json", "Accept: application/json"})
    @POST("/cloud/evaluationActivityBrand/goToScore")
    Object requestGoToScore(@Body RequestBody requestBody, Continuation<? super BaseResponse<HonorGoCommentBean>> continuation);

    @Headers({"Content-Type: application/json", "Accept: application/json"})
    @GET("/cloud/device/mess/publish/getCaptionsNoticeInfo")
    Object requestHomeCaption(@Query("schoolId") String str, @Query("deviceId") String str2, Continuation<? super BaseResponse<MessageCaptionBean>> continuation);

    @Headers({"Content-Type: application/json", "Accept: application/json"})
    @POST("/cloud/app/honor/brandPage")
    Object requestHonorWallList(@Body RequestBody requestBody, Continuation<? super BaseResponse<HonorWallBean>> continuation);

    @Headers({"Content-Type: application/json", "Accept: application/json"})
    @POST("/cloud/evaluationActivityBrand/identityDetail")
    Object requestIdentityDetail(@Body RequestBody requestBody, Continuation<? super BaseResponse<BasePageResponse<List<HonorScoreDetailBean>>>> continuation);

    @Headers({"Content-Type: application/json", "Accept: application/json"})
    @POST("/cloud/evaluationActivityMobile/childrenHonor")
    Object requestKidsHonorList(@Body RequestBody requestBody, Continuation<? super BaseResponse<BasePageResponse<List<HonorKidsLIstBean>>>> continuation);

    @Headers({"Content-Type: application/json", "Accept: application/json"})
    @POST("/brand/brand/mess/recive/page")
    Object requestMessage(@Body RequestBody requestBody, Continuation<? super BaseResponse<getNoticeRsp.DataDTO>> continuation);

    @Headers({"Content-Type: application/json", "Accept: application/json"})
    @POST("/brand/brand/mess/recive/dominateScreen/list")
    Object requestMessageDominateScreenList(@Body RequestBody requestBody, Continuation<? super BaseResponse<List<MessageItemBean>>> continuation);

    @GET("/brand/brand/mess/recive/index")
    Object requestMessageHome(Continuation<? super BaseResponse<MessageListBean>> continuation);

    @Headers({"Content-Type: application/json", "Accept: application/json"})
    @POST("/brand/brand/mess/recive/page")
    Object requestMessageList(@Body RequestBody requestBody, Continuation<? super BaseResponse<BasePageResponse<List<MessageItemBean>>>> continuation);

    @Headers({"Content-Type: application/json", "Accept: application/json"})
    @GET("/auth/qrcode/gene")
    Object requestQrCode(@Query("type") String str, @Query("schoolId") String str2, Continuation<? super BaseResponse<ScanQrCodeBean>> continuation);

    @Headers({"Content-Type: application/json", "Accept: application/json"})
    @GET("/auth/qrcode/check")
    Object requestQrCodeCheck(@Query("random") String str, Continuation<? super BaseResponse<ScanQrCodeBean>> continuation);

    @Headers({"Content-Type: application/json", "Accept: application/json"})
    @POST("/brand/layoutclasssign/getVideoStreams")
    Object requestRTSPPath(@Body RequestBody requestBody, Continuation<? super BaseResponse<LayoutListRsp.DataBean.LayoutClassSignDetailsEntityListBean>> continuation);

    @Headers({"Content-Type: application/json", "Accept: application/json"})
    @POST("/brand/openDoor/records/create")
    Object requestRecords(@Body RequestBody requestBody, Continuation<? super BaseResponse<String>> continuation);

    @Headers({"Content-Type: application/json", "Accept: application/json"})
    @POST("/cloud/moralEducationActivityBrand/scoringRubric")
    Object requestScoringRubric(@Body RequestBody requestBody, Continuation<? super BaseResponse<List<FirstIndicatorModel>>> continuation);

    @Headers({"Content-Type: application/json", "Accept: application/json"})
    @GET("/cloud/site/getSite")
    Object requestSiteInfo(@Query("id") String str, Continuation<? super BaseResponse<SiteInfoBean>> continuation);

    @Headers({"Content-Type: application/json", "Accept: application/json"})
    @POST("/cloud/evaluationPrize/studentHonor")
    Object requestStudentHonorList(@Body RequestBody requestBody, Continuation<? super BaseResponse<BasePageResponse<List<HonorStudentBean>>>> continuation);

    @Headers({"Content-Type: application/json", "Accept: application/json"})
    @POST("/cloud/evaluationActivityBrand/scoreStudent")
    Object requestStudentScoreComment(@Body RequestBody requestBody, Continuation<? super BaseResponse<String>> continuation);

    @Headers({"Content-Type: application/json", "Accept: application/json"})
    @POST("/cloud/device/face-sync/update-status")
    Object requestSynchronizeStatusFaceExtraction(@Body RequestBody requestBody, Continuation<? super BaseResponse<String>> continuation);

    @Headers({"Content-Type: application/json", "Accept: application/json"})
    @POST("/cloud/moralEducationActivityBrand/securityCheck")
    Object securityCheck(@Body RequestBody requestBody, Continuation<? super BaseResponse<CheckSecurityModel>> continuation);

    @POST("/brand/brand/Authority/selectStudentByIcCard")
    Object selectNewStudentByIcCard(@Body RequestBody requestBody, Continuation<? super BaseResponse<selectNewStudentByIcCardRsp.DataBean>> continuation);

    @Headers({"Content-Type: application/json", "Accept: application/json"})
    @POST("/brand/brand/Authority/selectTeacherByIcCard")
    Object selectTeacherInfoByCardOrFace(@Body RequestBody requestBody, Continuation<? super BaseResponse<selectTeacherByIcCardRsp.DataDTO>> continuation);

    @Headers({"Content-Type: application/json", "Accept: application/json"})
    @POST("/brand/brand/Authority/selectUserInfoByIcCard")
    Object selectUserByCardOrFace(@Body RequestBody requestBody, Continuation<? super BaseResponse<UserIcCardBean.DataBean>> continuation);

    @Headers({"Content-Type: application/json", "Accept: application/json"})
    @POST("/cloud/v2/barrier/updateRegistrationCode")
    Object updateNewRegistrationCodeByCode(@Body RequestBody requestBody, Continuation<? super BaseResponse<getRegistrationCodeRsp>> continuation);

    @POST("/app/file/upload")
    @Multipart
    Object upload(@Part List<MultipartBody.Part> list, Continuation<? super BaseResponse<List<UploadFileBean>>> continuation);

    @Headers({"Content-Type: application/json", "Accept: application/json"})
    @POST("/brand/brand/Authority/checkIotControlByPassword")
    Object verifyTeacherLogin(@Body RequestBody requestBody, Continuation<? super BaseResponse<VerifyTeacherLoginBean>> continuation);
}
