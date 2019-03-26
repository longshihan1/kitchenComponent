package com.huazhuhotel.module_home.attention.persenter;

import com.huazhuhotel.module_home.mvp.model.FollowInfo;
import com.huazhuhotel.module_home.mvp.model.UnRecipesListInfo;
import com.huazhuhotel.module_home.mvp.model.UserInfo;
import com.huazhuhotel.module_home.mvp.model.UserNoteInfo;
import com.longshihan.mvpcomponent.mvp.IView;

/**
 * Created by LONGHE001.
 *
 * @time 2019/3/4 0004
 * @des
 * @function
 */

public interface FollowContract {
    interface View extends IView {
        void getFollowInfo(FollowInfo info);
        void getunFollowInfo(FollowInfo info);
    }

    interface Presenter {
        void getFollowInfo(String userId,String fid);
        void getunFollowInfo(String userId,String fid);
    }
}
