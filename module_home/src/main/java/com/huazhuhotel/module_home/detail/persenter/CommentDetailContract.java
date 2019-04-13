package com.huazhuhotel.module_home.detail.persenter;

import com.huazhuhotel.module_home.mvp.model.CommentListInfo;
import com.huazhuhotel.module_home.mvp.model.CommentUploadInfo;
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

public interface CommentDetailContract {
    interface View extends IView {
        void getCommentList(CommentListInfo info);
        void putCommentInfo(CommentUploadInfo info);
    }

    interface Presenter {
        void getCommentList(String id, int pageIndex);
        void putCommentUpload(String repiceId, String userId,String content);
    }
}
