package mmeijiu.com.retrofit.net;

import org.json.JSONObject;

import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;
import rx.Observable;

/**
 * Created by Administrator on 2016/8/22.
 */

public interface LiaoMeiApi {

    /**
     * 这里需要稍作说明，@GET注解就表示get请求，@Query表示请求参数，将会以key=value的方式拼接在url后面    @QueryMap 传map 把key value丢进去
     * @POST注解就表示post请求，@Field表示请求参数，将会以表单的方式提交  @FieldMap 意思一样
     * 除此之外还有 @Body @Path 添加header等方法
     * @return
     */

    // http://www.560797.com/sms/login.html   account password
    @FormUrlEncoded
    @POST("sms/login")
    Observable<Rersults> login(@Field(value = "account", encoded = true) String account, @Field(value = "password", encoded = true) String pwd);

}
