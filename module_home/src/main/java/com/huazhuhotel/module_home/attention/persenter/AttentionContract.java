package com.huazhuhotel.module_home.attention.persenter;

import com.huazhuhotel.module_home.mvp.model.AttentionInfo;
import com.huazhuhotel.module_home.mvp.model.GoodsDetailInfo;
import com.huazhuhotel.module_home.mvp.model.ReCommondInfo;
import com.longshihan.mvpcomponent.mvp.IView;

/**
 * Created by LONGHE001.
 *
 * @time 2019/3/4 0004
 * @des
 * @function
 */

public interface AttentionContract {
    interface View extends IView {
        void getAtentionInfo(AttentionInfo info);
    }

    interface Presenter {
        void getAttentionInfo(String id);
    }
}
