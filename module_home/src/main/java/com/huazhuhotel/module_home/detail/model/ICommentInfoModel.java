package com.huazhuhotel.module_home.detail.model;

import com.huazhuhotel.module_home.mvp.model.CommentListInfo;
import com.huazhuhotel.module_home.mvp.model.CommentUploadInfo;
import com.huazhuhotel.module_home.mvp.model.GoodsDetailInfo;
import com.huazhuhotel.module_home.mvp.model.ReCommondInfo;

import io.reactivex.Observable;

/**
 * Created by LONGHE001.
 *
 * @time 2019/3/4 0004
 * @des
 * @function
 */

public interface ICommentInfoModel {
    Observable<CommentListInfo> getCommentList(String id, int pageIndex);
    Observable<CommentUploadInfo> putCommentInfo(String repiceId, String userId,String content);
}
