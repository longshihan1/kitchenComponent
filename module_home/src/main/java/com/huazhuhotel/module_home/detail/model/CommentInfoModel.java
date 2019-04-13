package com.huazhuhotel.module_home.detail.model;

import com.huazhuhotel.module_home.http.ApiService;
import com.huazhuhotel.module_home.mvp.model.CommentListInfo;
import com.huazhuhotel.module_home.mvp.model.CommentUploadInfo;
import com.huazhuhotel.module_home.mvp.model.GoodsDetailInfo;
import com.huazhuhotel.module_home.mvp.model.ReCommondInfo;
import com.longshihan.mvpcomponent.mvp.BaseModel;
import com.longshihan.mvpcomponent.mvp.IRepositoryManager;

import io.reactivex.Observable;

/**
 * Created by LONGHE001.
 *
 * @time 2019/3/4 0004
 * @des
 * @function
 */

public class CommentInfoModel extends BaseModel implements ICommentInfoModel {
    public CommentInfoModel(IRepositoryManager repositoryManager) {
        super(repositoryManager);
    }

    @Override
    public Observable<CommentListInfo> getCommentList(String id, int pageIndex) {
        return mRepositoryManager.obtainRetrofitService(ApiService.class).getCommentListInfo(id,pageIndex);
    }

    @Override
    public Observable<CommentUploadInfo> putCommentInfo(String repiceId, String userId, String content) {
        return mRepositoryManager.obtainRetrofitService(ApiService.class).putCommentInfo(repiceId,userId,content);
    }
}
