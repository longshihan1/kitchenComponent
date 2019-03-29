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
                .getCollectionListInfo(id,page,"1550565828886864166031299724",
                        "772388cf40b77d2639e956e572244324","4",
                        "1550566011",id,"ba38f4b0e6d267b4c2f0cdbb3393bd35");
    }
}
