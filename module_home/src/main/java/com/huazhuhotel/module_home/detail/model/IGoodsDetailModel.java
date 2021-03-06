package com.huazhuhotel.module_home.detail.model;

import com.huazhuhotel.module_home.mvp.model.CollectCancelInfo;
import com.huazhuhotel.module_home.mvp.model.CollectaddInfo;
import com.huazhuhotel.module_home.mvp.model.CommentListInfo;
import com.huazhuhotel.module_home.mvp.model.GoodsDetailInfo;
import com.huazhuhotel.module_home.mvp.model.ReCommondInfo;
import com.huazhuhotel.module_home.mvp.model.SearchInfo;

import io.reactivex.Observable;

/**
 * Created by LONGHE001.
 *
 * @time 2019/3/4 0004
 * @des
 * @function
 */

public interface IGoodsDetailModel {
    Observable<GoodsDetailInfo> getGoodsDetailInfo(String goodsId);
    Observable<ReCommondInfo> getReCommendInfo(String goodsId);

    Observable<CommentListInfo> getCommentList(String id,int pageIndex);

    Observable<CollectaddInfo> addCollection(String receId,String userId);


    Observable<CollectCancelInfo> cancelCollection(String receId, String userId);
}
