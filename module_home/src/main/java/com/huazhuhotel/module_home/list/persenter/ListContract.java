package com.huazhuhotel.module_home.list.persenter;

import com.huazhuhotel.module_home.mvp.model.SearchInfo;
import com.longshihan.mvpcomponent.mvp.IView;

/**
 * Created by LONGHE001.
 *
 * @time 2019/3/4 0004
 * @des
 * @function
 */

public interface ListContract {
    interface View extends IView {

        void getListInfo(SearchInfo info);
    }

    interface Presenter {
        void getListInfo(int page,String searchValue,int type);
    }
}
