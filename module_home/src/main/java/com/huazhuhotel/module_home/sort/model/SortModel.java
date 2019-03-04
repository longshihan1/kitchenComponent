package com.huazhuhotel.module_home.sort.model;

import com.huazhuhotel.module_home.http.ApiService;
import com.huazhuhotel.module_home.mvp.model.SortInfo;
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

public class SortModel extends BaseModel implements ISortModel {
    public SortModel(IRepositoryManager repositoryManager) {
        super(repositoryManager);
    }

    @Override
    public Observable<SortInfo> getSortInfo() {
        Observable<SortInfo> splashEntityObservable = mRepositoryManager.obtainRetrofitService(ApiService.class)
                .getSortInfo();
        return splashEntityObservable;
    }
}
