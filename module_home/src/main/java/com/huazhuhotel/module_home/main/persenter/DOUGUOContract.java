package com.huazhuhotel.module_home.main.persenter;

import com.huazhuhotel.module_home.mvp.model.HomeInfo;
import com.longshihan.mvpcomponent.mvp.IView;

/**
 * Created by LONGHE001.
 *
 * @time 2019/2/27 0027
 * @des
 * @function
 */

public interface DOUGUOContract {
    interface View extends IView {

        void getHomeInfo(HomeInfo info);
    }

    interface Presenter {
        void getHomeInfd();
    }

}
