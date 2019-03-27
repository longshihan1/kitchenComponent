package com.huazhuhotel.module_home.main.persenter;

import com.huazhuhotel.module_home.mvp.model.HomeInfo;
import com.huazhuhotel.module_home.mvp.model.VideoListInfo;
import com.longshihan.mvpcomponent.mvp.IView;

/**
 * Created by LONGHE001.
 *
 * @time 2019/2/27 0027
 * @des
 * @function
 */

public interface VideoContract {
    interface View extends IView {

        void getVideoInfo(VideoListInfo info);
    }

    interface Presenter {
        void getVideoInfo(String userid,int pageindex);
    }

}
