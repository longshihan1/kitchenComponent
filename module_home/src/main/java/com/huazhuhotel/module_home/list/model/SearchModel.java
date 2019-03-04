package com.huazhuhotel.module_home.list.model;

import com.huazhuhotel.module_home.http.ApiService;
import com.huazhuhotel.module_home.mvp.model.SearchInfo;
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

public class SearchModel extends BaseModel implements ISearchModel {
    public SearchModel(IRepositoryManager repositoryManager) {
        super(repositoryManager);
    }

    @Override
    public Observable<SearchInfo> getSeachInfo(int page,String searchValue,int type) {
        Observable<SearchInfo> splashEntityObservable = mRepositoryManager.obtainRetrofitService(ApiService.class)
                .getSearchInfo(page,searchValue,type);
        return splashEntityObservable;
    }
}
