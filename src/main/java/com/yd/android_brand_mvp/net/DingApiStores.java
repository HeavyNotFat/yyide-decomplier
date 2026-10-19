package com.yd.android_brand_mvp.net;

import com.yd.android_brand_mvp.landscape.exam.comments.CommentsHomeFragment;
import com.yd.android_brand_mvp.model.AllstudentRsp;
import com.yd.android_brand_mvp.model.ApproverInfoRsp;
import com.yd.android_brand_mvp.model.ApproverListRsp;
import com.yd.android_brand_mvp.model.AttanceTodatDetailsRsp;
import com.yd.android_brand_mvp.model.AttenceBean;
import com.yd.android_brand_mvp.model.AttenceListBean;
import com.yd.android_brand_mvp.model.AttenceNewListBean;
import com.yd.android_brand_mvp.model.AttenceUser;
import com.yd.android_brand_mvp.model.AttencelistRsp2;
import com.yd.android_brand_mvp.model.BaseContentRsp;
import com.yd.android_brand_mvp.model.BrandRegistrationCodeRsp;
import com.yd.android_brand_mvp.model.ClassScheduleRsp;
import com.yd.android_brand_mvp.model.ClassesInfoBean;
import com.yd.android_brand_mvp.model.DominateDetailLevelBean;
import com.yd.android_brand_mvp.model.GeneralBean;
import com.yd.android_brand_mvp.model.GeneralBean2;
import com.yd.android_brand_mvp.model.GetAskLeaveRecordBandRsp;
import com.yd.android_brand_mvp.model.KBRsp;
import com.yd.android_brand_mvp.model.KBRsp2;
import com.yd.android_brand_mvp.model.LayoutListRsp;
import com.yd.android_brand_mvp.model.MessageCaptionBean;
import com.yd.android_brand_mvp.model.MessageItemBean;
import com.yd.android_brand_mvp.model.NewBrandLoginRsp;
import com.yd.android_brand_mvp.model.NewClassInfoRsp;
import com.yd.android_brand_mvp.model.NewLoginRsp;
import com.yd.android_brand_mvp.model.NewRemindRsp;
import com.yd.android_brand_mvp.model.NewWatchWordRsp;
import com.yd.android_brand_mvp.model.NewWeatherBean;
import com.yd.android_brand_mvp.model.NewWeatherListBean;
import com.yd.android_brand_mvp.model.NewWorkCommentRsp;
import com.yd.android_brand_mvp.model.PhotoAlbumTabBean;
import com.yd.android_brand_mvp.model.PhotoAlbumTwoBean;
import com.yd.android_brand_mvp.model.SchoolStytleRsp;
import com.yd.android_brand_mvp.model.SemesterTimeRsp;
import com.yd.android_brand_mvp.model.SiteAttendanceBean;
import com.yd.android_brand_mvp.model.StudenDutyBean;
import com.yd.android_brand_mvp.model.StudentInfoBean;
import com.yd.android_brand_mvp.model.StudentTaskBean;
import com.yd.android_brand_mvp.model.StudentWorkListBean;
import com.yd.android_brand_mvp.model.TeachersRsp;
import com.yd.android_brand_mvp.model.TimelistRsp;
import com.yd.android_brand_mvp.model.UploadFileBean;
import com.yd.android_brand_mvp.model.UserIcCardBean;
import com.yd.android_brand_mvp.model.UserTableRsp;
import com.yd.android_brand_mvp.model.VideoListBean;
import com.yd.android_brand_mvp.model.getNewestVersionRsp;
import com.yd.android_brand_mvp.model.getNoticeRsp;
import com.yd.android_brand_mvp.model.getRegistrationCodeRsp;
import com.yd.android_brand_mvp.model.getSchoolCalendarRsp;
import com.yd.android_brand_mvp.model.getUserSigByUserIdRsp;
import com.yd.android_brand_mvp.model.insetVersionUpdatedSchoolRsp;
import com.yd.android_brand_mvp.model.queryClassificListRsp;
import com.yd.android_brand_mvp.model.selectClassesInfoRsp;
import com.yd.android_brand_mvp.model.selectNewStudentByIcCardRsp;
import com.yd.android_brand_mvp.model.selectSchoolCalendarRsp;
import com.yd.android_brand_mvp.model.selectStudentByIcCardRsp;
import com.yd.android_brand_mvp.model.selectTeacherByClassesIdRsp;
import com.yd.android_brand_mvp.model.selectTeacherByIcCardRsp;
import com.yd.android_brand_mvp.model.switchlistRsp;
import com.yd.android_brand_mvp.network.base.BaseResponse;
import io.reactivex.rxjava3.core.Observable;
import java.util.List;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;
import retrofit2.http.Path;
import retrofit2.http.Query;

/* JADX INFO: loaded from: classes4.dex */
public interface DingApiStores {
    @Headers({"Content-Type: application/json", "Accept: application/json"})
    @GET("/attweb/app/attendance/getBrandAttendanceRule")
    Observable<AttencelistRsp2> Attendlist(@Query("no") String str);

    @GET("/brand/brand/campus/style")
    Observable<SchoolStytleRsp> SchoolStyle();

    @POST("/brand/brand/campus/teachers")
    Observable<TeachersRsp> Teachers(@Body RequestBody requestBody);

    @Headers({"Content-Type: application/json", "Accept: application/json"})
    @POST("/brand/class-brand-management/android/course/classSchedule")
    Observable<UserTableRsp> UserTable(@Body RequestBody requestBody);

    @POST("/cloud/proc/startInstance")
    Observable<BaseContentRsp> addLeave(@Body RequestBody requestBody);

    @POST("/cloud/student/allStudents")
    Observable<AllstudentRsp> allStudents(@Body RequestBody requestBody);

    @POST("/cloud/app/userAppr/page")
    Observable<GetAskLeaveRecordBandRsp> askForLeaveRecordBandList(@Body RequestBody requestBody);

    @POST("/face/cloud-face/attendance/peopleAttendance")
    Observable<GeneralBean> attendance(@Body RequestBody requestBody);

    @POST("/attweb/app/attendance/createBrandAttendanceSignIn")
    Observable<GeneralBean2> brandAttendanceClock(@Body RequestBody requestBody);

    @POST("/cloud/app/procAppr/deleteInstance")
    Observable<BaseContentRsp> deleteInstance(@Body RequestBody requestBody);

    @POST("/cloud/app/procAppr/getApprList")
    Observable<ApproverListRsp> getApprover(@Body RequestBody requestBody);

    @GET("/cloud/app/userAppr/getInfo")
    Observable<ApproverInfoRsp> getApproverInfo(@Query("id") String str);

    @GET("/attweb/app/attendance/getAttendanceEventTimetableByClasses")
    Observable<KBRsp2> getAttenceKB(@Query(CommentsHomeFragment.TYPE_CLASSESID) String str);

    @POST("/face/cloud-face/attendance/viewCbAttendance")
    Observable<AttenceBean> getAttencelist(@Body RequestBody requestBody);

    @POST("/attweb/app/attendance/getAttendanceSiteTimetable")
    Observable<BaseResponse<List<SiteAttendanceBean>>> getAttendanceSiteTimetable(@Body RequestBody requestBody);

    @GET("/attweb/app/attendance/getBrandAttendanceUser")
    Observable<AttenceUser> getBrandAttendanceUser(@Query("id") String str);

    @POST("/brand/obtain")
    Observable<NewBrandLoginRsp> getBrandObtain(@Body RequestBody requestBody);

    @POST("/cloud/v2/equipment/brand/getBrandAuthorizeCodeInfo")
    Observable<BrandRegistrationCodeRsp> getBrandRegistrationCode(@Body RequestBody requestBody);

    @POST("/cloud/app/timetable/getWeekTime")
    Observable<KBRsp2> getCDKB(@Body RequestBody requestBody);

    @Headers({"Content-Type: application/json", "Accept: application/json"})
    @GET("/cloud/device/mess/publish/getCaptionsNoticeInfo")
    Observable<BaseResponse<MessageCaptionBean>> getCaptionsNoticeInfo(@Query("schoolId") String str, @Query("deviceId") String str2);

    @Headers({"Content-Type: application/json", "Accept: application/json"})
    @POST("/brand/class-brand-management/android/course/classSchedule")
    Observable<ClassScheduleRsp> getClassSchedule(@Body RequestBody requestBody);

    @GET("/management/cloud-system/pc/getClassesInfo/{classId}")
    Observable<ClassesInfoBean> getClassesInfo(@Path("classId") long j);

    @POST("/brand/brand/album/index")
    Observable<VideoListBean> getHomeVideo(@Body RequestBody requestBody);

    @POST("/timetable/cloud-timetable/v1/kcb/classes")
    Observable<KBRsp> getKB(@Query("bjid") String str, @Query("skzc") String str2);

    @POST("/brand/brand/mess/recive/dominateScreen/list")
    Observable<BaseResponse<List<MessageItemBean>>> getMessageDominateScreenList(@Body RequestBody requestBody);

    @POST("/brand/brand/album/list")
    Observable<VideoListBean> getNewClassPhotoList(@Body RequestBody requestBody);

    @GET("/brand/brand/countdown/list")
    Observable<TimelistRsp> getNewCountdownList(@Query(CommentsHomeFragment.TYPE_CLASSESID) String str);

    @POST("/brand/brand/layoutclasssign/layoutlist")
    Observable<LayoutListRsp> getNewLayoutList(@Body RequestBody requestBody);

    @POST("/brand/brand/mess/recive/page")
    Observable<getNoticeRsp> getNewNoticeWithPag(@Body RequestBody requestBody);

    @POST("/brand/brand/album/listDetail")
    Observable<PhotoAlbumTwoBean> getNewPhotoList(@Body RequestBody requestBody);

    @GET("/brand/brand/studentduty/selectRecord")
    Observable<StudenDutyBean> getNewStudentDuty();

    @POST("/brand/brand/studentwork/list")
    Observable<StudentWorkListBean> getNewStudentWorkList(@Body RequestBody requestBody);

    @POST("/cloud/app/work/pageThisWeekWork")
    Observable<StudentTaskBean> getNewTaskList(@Body RequestBody requestBody);

    @POST("/brand/weather/now")
    Observable<BaseResponse<NewWeatherBean>> getNewWeather(@Body RequestBody requestBody);

    @POST("/brand/weather/day7")
    Observable<BaseResponse<NewWeatherListBean>> getNewWeatherList(@Body RequestBody requestBody);

    @POST("/cloud/v2/barrier/getAppVersion")
    Observable<getNewestVersionRsp> getNewestVersion(@Body RequestBody requestBody);

    @POST("/cloud/v2/barrier/getOrBindingDevice")
    Observable<getRegistrationCodeRsp> getOrBindingDevice(@Body RequestBody requestBody);

    @Headers({"Content-Type: application/json", "Accept: application/json"})
    @POST("/brand/class-brand-management/android/videoalbum/classifylist")
    Observable<PhotoAlbumTabBean> getPhotoAlbumTablist(@Body RequestBody requestBody);

    @POST("/cloud/v2/barrier/getRegistrationCode")
    Observable<getRegistrationCodeRsp> getRegistrationCode(@Body RequestBody requestBody);

    @POST("/cloud/brand/calendar/getSchoolCalendar")
    Observable<getSchoolCalendarRsp> getSchoolCalendar();

    @GET("/brand/brand/school/semester/current")
    Observable<BaseResponse<SemesterTimeRsp>> getSemesterTime();

    @GET("/brand/class-brand-management/app/studentDuty/selectRecord")
    Observable<StudenDutyBean> getStudentDuty(@Query("classId") String str);

    @GET("/cloud/im/user/sig/getSystemSig")
    Observable<BaseResponse<String>> getSystemSign();

    @GET("/cloud/im/user/sig/gen")
    Observable<getUserSigByUserIdRsp> getUserSig(@Query("identifier") String str);

    @POST("/brand/brand/classes/watchword/list")
    Observable<NewWatchWordRsp> getWatchWord(@Body RequestBody requestBody);

    @POST("/brand/class-brand-management/android/appRegistraCode/insetVersionUpdatedSchool")
    Observable<insetVersionUpdatedSchoolRsp> insetVersionUpdatedSchool(@Body RequestBody requestBody);

    @POST("/attweb/app/attendance/listToDayDetail")
    Observable<AttanceTodatDetailsRsp> listToDayDetail(@Body RequestBody requestBody);

    @POST("/auth/oauth/token")
    Observable<NewLoginRsp> newLogin(@Query("username") String str, @Query("password") String str2, @Query("client_id") String str3, @Query("grant_type") String str4, @Query("client_secret") String str5, @Query("random") String str6);

    @GET("/brand/brand/remind/list")
    Observable<NewRemindRsp> newRemind(@Query("brandId") String str);

    @POST("/attweb/app/attendance/listToDay")
    Observable<AttenceNewListBean> queryBrandAttendanceByAttendanceTimeId(@Body RequestBody requestBody);

    @POST("/face/cloud-face/attendance/brand/app/v2/queryBrandAttendanceByClassIds")
    Observable<AttenceListBean> queryBrandAttendanceByClassIds(@Body RequestBody requestBody);

    @POST("/backstage/cloud-backstage/kf/application/queryClassificList")
    Observable<queryClassificListRsp> queryClassificList(@Body RequestBody requestBody);

    @Headers({"Content-Type: application/json", "Accept: application/json"})
    @GET("/brand/v2/custom/mode/list")
    Observable<BaseResponse<List<DominateDetailLevelBean>>> requestDominateScreenLevel(@Query("brandId") String str);

    @POST("/brand/class-brand-management/android/class/selectClassesInfo")
    Observable<selectClassesInfoRsp> selectClassesInfo(@Query("brandClassLoginName") String str);

    @GET("/brand/brand/classes/info")
    Observable<NewClassInfoRsp> selectNewClassesInfo(@Query(CommentsHomeFragment.TYPE_CLASSESID) String str);

    @POST("/brand/brand/Authority/selectStudentByIcCard")
    Observable<selectNewStudentByIcCardRsp> selectNewStudentByIcCard(@Body RequestBody requestBody);

    @GET("/brand/brand/studentwork/selectStudentInfo")
    Observable<StudentInfoBean> selectNewStudentInfo(@Query("id") String str);

    @POST("/brand/brand/Authority/selectTeacherByClassesId")
    Observable<selectTeacherByClassesIdRsp> selectNewTeacherByClassesId(@Body RequestBody requestBody);

    @POST("/brand/brand/Authority/selectTeacherByIcCard")
    Observable<selectTeacherByIcCardRsp> selectNewTeacherByIcCard(@Body RequestBody requestBody);

    @POST("/brand/brand/Authority/selectUserInfoByIcCard")
    Observable<UserIcCardBean> selectNewUserInfoByIcCard(@Body RequestBody requestBody);

    @POST("/cloud/calendar/selectSchoolCalendar")
    Observable<selectSchoolCalendarRsp> selectSchoolCalendar(@Body RequestBody requestBody);

    @Headers({"Content-Type: application/json", "Accept: application/json"})
    @POST("/brand/class-brand-management/android/studentspace/selectStudentByIcCard")
    @Deprecated
    Observable<selectStudentByIcCardRsp> selectStudentByIcCard(@Body RequestBody requestBody);

    @Headers({"Content-Type: application/json", "Accept: application/json"})
    @POST("/brand/class-brand-management/Android/Authority/selectTeacherByIcCard")
    @Deprecated
    Observable<selectTeacherByIcCardRsp> selectTeacherByIcCard(@Body RequestBody requestBody);

    @POST("/brand/brand/studentwork/workComment")
    Observable<NewWorkCommentRsp> setNewWorkComment(@Body RequestBody requestBody);

    @GET("/brand/brand/studentwork/workLike")
    Observable<NewWorkCommentRsp> setNewWorkLike(@Query("id") String str, @Query("userId") String str2);

    @GET("/brand/brand/getSwitchsType")
    Observable<switchlistRsp> switchNewList(@Query("id") String str);

    @POST("/brand/brand/updateApkVersion")
    Observable<Object> updateApkVersion(@Body RequestBody requestBody);

    @POST("/cloud/v2/barrier/updateRegistrationCode")
    Observable<getRegistrationCodeRsp> updateNewRegistrationCodeByCode(@Body RequestBody requestBody);

    @POST("/app/file/upload")
    @Multipart
    Observable<BaseResponse<List<UploadFileBean>>> upload(@Part List<MultipartBody.Part> list);

    @POST("/file/upload/path")
    Observable<BaseResponse<List<UploadFileBean>>> uploadLogFile(@Body RequestBody requestBody);
}
