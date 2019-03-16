package com.huazhuhotel.module_home.attention.model;

import com.huazhuhotel.module_home.http.ApiService;
import com.huazhuhotel.module_home.mvp.model.AttentionInfo;
import com.longshihan.mvpcomponent.mvp.BaseModel;
import com.longshihan.mvpcomponent.mvp.IRepositoryManager;

import io.reactivex.Observable;

public class AttentionModel extends BaseModel implements IAttentionModel  {

    public AttentionModel(IRepositoryManager repositoryManager) {
        super(repositoryManager);
    }

    @Override
    public Observable<AttentionInfo> getAttentionInfo(String id) {
        return mRepositoryManager.obtainRetrofitService(ApiService.class)
                .getAttentionInfo(id);
    }
}
