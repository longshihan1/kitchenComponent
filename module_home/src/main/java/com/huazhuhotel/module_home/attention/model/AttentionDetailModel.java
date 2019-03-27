package com.huazhuhotel.module_home.attention.model;

import com.huazhuhotel.module_home.http.ApiService;
import com.huazhuhotel.module_home.mvp.model.UnRecipesListInfo;
import com.huazhuhotel.module_home.mvp.model.UserNoteInfo;
import com.longshihan.mvpcomponent.mvp.BaseModel;
import com.longshihan.mvpcomponent.mvp.IRepositoryManager;

import io.reactivex.Observable;

public class AttentionDetailModel extends BaseModel implements IAttentionDetailModel  {

    public AttentionDetailModel(IRepositoryManager repositoryManager) {
        super(repositoryManager);
    }

    @Override
    public Observable<UnRecipesListInfo> getUnRecipesListInfo(String userID, int page) {
        return mRepositoryManager.obtainRetrofitService(ApiService.class)
                .getUrecipesListInfo(userID,page);
    }

    @Override
    public Observable<UserNoteInfo> getUserNoteInfo(String userID, int page) {
        return mRepositoryManager.obtainRetrofitService(ApiService.class)
                .getUsernotesInfo(userID,page);
    }
}
