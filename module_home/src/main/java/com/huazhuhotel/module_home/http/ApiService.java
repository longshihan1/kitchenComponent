package com.huazhuhotel.module_home.http;

import com.huazhuhotel.module_home.mvp.model.HomeInfo;

import io.reactivex.Observable;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by LONGHE001.
 *
 * @time 2019/2/27 0027
 * @des
 * @function
 */

public interface ApiService {
    String DOUGUO_API="http://api.douguo.net/";

    /**
     * <p>http://api.douguo.net/personalized/home</p>
     *
     * @return
     */
    @Headers({"url_name:douguo"})
    @FormUrlEncoded
    @POST("/personalized/home")
    Observable<HomeInfo> getHomeInfo(@Field("direction") String direction);


}
