package com.huazhuhotel.module_home.detail.model;

import com.huazhuhotel.module_home.http.ApiService;
import com.huazhuhotel.module_home.mvp.model.GoodsDetailInfo;
import com.huazhuhotel.module_home.mvp.model.ReCommondInfo;
import com.huazhuhotel.module_home.mvp.model.SearchInfo;
import com.longshihan.mvpcomponent.mvp.BaseModel;
import com.longshihan.mvpcomponent.mvp.IRepositoryManager;

import io.reactivex.Observable;

/**
 * Created by LONGHE001.
 *
 * @time 2019/3/4 0004
 * @des
 * @function
 */

public class GoodsDetailModel extends BaseModel implements IGoodsDetailModel {
    public GoodsDetailModel(IRepositoryManager repositoryManager) {
        super(repositoryManager);
    }

    @Override
    public Observable<GoodsDetailInfo> getGoodsDetailInfo(int goodsId) {
        return mRepositoryManager.obtainRetrofitService(ApiService.class)
                .getGoodsDetailInfo(goodsId);
    }

    @Override
    public Observable<ReCommondInfo> getReCommendInfo(int goodsId) {
        return mRepositoryManager.obtainRetrofitService(ApiService.class)
                .getRecommInfo(goodsId);
    }
}
