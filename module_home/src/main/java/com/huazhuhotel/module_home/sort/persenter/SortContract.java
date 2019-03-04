package com.huazhuhotel.module_home.sort.persenter;

import com.huazhuhotel.module_home.mvp.model.HomeInfo;
import com.huazhuhotel.module_home.mvp.model.SortInfo;
import com.longshihan.mvpcomponent.mvp.IView;

/**
 * Created by LONGHE001.
 *
 * @time 2019/3/4 0004
 * @des
 * @function
 */

public interface SortContract {
    interface View extends IView {

        void getSortInfo(SortInfo info);
    }

    interface Presenter {
        void getSortInfo();
    }
}
