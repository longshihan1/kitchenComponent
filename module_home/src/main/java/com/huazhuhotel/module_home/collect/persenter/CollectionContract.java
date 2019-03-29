package com.huazhuhotel.module_home.collect.persenter;

import com.huazhuhotel.module_home.mvp.model.CollectionInfo;
import com.huazhuhotel.module_home.mvp.model.HomeInfo;
import com.longshihan.mvpcomponent.mvp.IView;

/**
 * Created by LONGHE001.
 *
 * @time 2019/2/27 0027
 * @des
 * @function
 */

public interface CollectionContract {
    interface View extends IView {
        void getCollectInfo(CollectionInfo info);
    }

    interface Presenter {
        void getCollectionInfo(String id,int pageindex);
    }

}
