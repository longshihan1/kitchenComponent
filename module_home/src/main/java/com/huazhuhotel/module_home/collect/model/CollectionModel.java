package com.huazhuhotel.module_home.collect.model;

import com.huazhuhotel.module_home.http.ApiService;
import com.huazhuhotel.module_home.mvp.model.CollectionInfo;
import com.huazhuhotel.module_home.mvp.model.HomeInfo;
import com.longshihan.mvpcomponent.mvp.BaseModel;
import com.longshihan.mvpcomponent.mvp.IRepositoryManager;

import io.reactivex.Observable;

/**
 * Created by LONGHE001.
 *
 * @time 2019/3/29 0029
 * @des
 * @function
 */

public class CollectionModel extends BaseModel implements ICollectionModel {
    public CollectionModel(IRepositoryManager repositoryManager) {
        super(repositoryManager);
    }

    @Override
    public Observable<CollectionInfo> getCollectionListInfo(String id, int page) {
        return mRepositoryManager.obtainRetrofitService(ApiService.class)
                .getCollectionListInfo(id,page,"","","","",id,"");
    }
}
