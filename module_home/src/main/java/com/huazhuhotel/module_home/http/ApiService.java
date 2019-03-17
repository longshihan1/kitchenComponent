package com.huazhuhotel.module_home.http;

import com.huazhuhotel.module_home.mvp.model.AttentionInfo;
import com.huazhuhotel.module_home.mvp.model.GoodsDetailInfo;
import com.huazhuhotel.module_home.mvp.model.HomeInfo;
import com.huazhuhotel.module_home.mvp.model.ReCommondInfo;
import com.huazhuhotel.module_home.mvp.model.SearchInfo;
import com.huazhuhotel.module_home.mvp.model.SortInfo;
import com.huazhuhotel.module_home.mvp.model.UnRecipesListInfo;
import com.huazhuhotel.module_home.mvp.model.UserInfo;
import com.huazhuhotel.module_home.mvp.model.UserNoteInfo;

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
    String DOUGUO_API = "http://api.douguo.net/";

    /**
     * <p>http://api.douguo.net/personalized/home</p>
     * 这边应该添加一个header数据才行
     *
     * @return
     */
    @Headers({"url_name:douguo"})
    @FormUrlEncoded
    @POST("/personalized/home")
    Observable<HomeInfo> getHomeInfo(@Field("direction") String direction);


    @Headers({"version:6931.2", "url_name:douguo"})
    @POST("/recipe/flatcatalogs")
    Observable<SortInfo> getSortInfo();


    @Headers({"version:6931.2", "url_name:douguo"})
    @FormUrlEncoded
    @POST("/recipe/v2/search/{page}/20")
    Observable<SearchInfo> getSearchInfo(@Path("page") int page,
                                         @Field("keyword") String keyword, @Field("order") int order);

    @Headers({"version:6931.2", "url_name:douguo"})
    @POST("/recipe/detail/{goodsId}")
    Observable<GoodsDetailInfo> getGoodsDetailInfo(@Path("goodsId") int goodsId);

    @Headers({"version:6931.2", "url_name:douguo"})
    @FormUrlEncoded
    @POST("/recipe/mixedRecommend")
    Observable<ReCommondInfo> getRecommInfo(@Field("recipe_id") int goodsId);

    @Headers({"url_name:douguo"})
    @POST("/user/following/{userid}/0/15")
    Observable<AttentionInfo> getAttentionInfo(@Path("userid") String userId);


    //用户信息
    @Headers({"version:6931.2","url_name:douguo"})
    @POST("/user/info/{userid}")
    Observable<UserInfo> getUserInfo(@Path("userid") String id);

    //关注人的菜谱
    @Headers({"version:6931.2","url_name:douguo"})
    @POST("/recipe/urecipes/{userid}/{pageindex}/20")
    Observable<UnRecipesListInfo> getUrecipesListInfo(@Path("userid") String id,@Path("pageindex") int page);

    //关注人的笔记
    @Headers({"version:6931.2","url_name:douguo"})
    @POST("/note/usernotes/{userid}/{pageindex}/20")
    Observable<UserNoteInfo> getUsernotesInfo(@Path("userid") String id, @Path("pageindex") int page);
}
