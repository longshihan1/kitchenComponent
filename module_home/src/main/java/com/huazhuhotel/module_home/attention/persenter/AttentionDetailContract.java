package com.huazhuhotel.module_home.attention.persenter;

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

public interface AttentionDetailContract {
    interface View extends IView {
        void getUserInfo(UserInfo info);
        void getUnRecipesListInfo(UnRecipesListInfo info);
        void getUserNoteListInfo(UserNoteInfo info);
    }

    interface Presenter {
        void getUserInfo(String userId);
        void getUnRecipesListInfo(String userId,int page);
        void getUserNoteListInfo(String userId,int page);
    }
}
