package com.huazhuhotel.module_home.detail.persenter;

import com.huazhuhotel.module_home.mvp.model.GoodsDetailInfo;
import com.huazhuhotel.module_home.mvp.model.ReCommondInfo;
import com.huazhuhotel.module_home.mvp.model.SearchInfo;
import com.longshihan.mvpcomponent.mvp.IView;

/**
 * Created by LONGHE001.
 *
 * @time 2019/3/4 0004
 * @des
 * @function
 */

public interface GoodsDetailContract {
    interface View extends IView {
        void getGoodsDetailInfo(GoodsDetailInfo info);
        void getRecommondInfo(ReCommondInfo info);
    }

    interface Presenter {
        void getGoodsDetailInfo(int goodsId);
        void getRecommendInfo(int goodsId);
    }
}
