package com.huazhuhotel.module_home.main.model;

import com.huazhuhotel.module_home.http.ApiService;
import com.huazhuhotel.module_home.mvp.model.HomeInfo;
import com.longshihan.mvpcomponent.mvp.BaseModel;
import com.longshihan.mvpcomponent.mvp.IRepositoryManager;
import com.longshihan.mvpcomponent.utils.TimeUtil;

import io.reactivex.Observable;

/**
 * Created by LONGHE001.
 *
 * @time 2019/2/27 0027
 * @des
 * @function
 */

public class DOUGUOModel extends BaseModel implements IDOUGUOModel {
    public DOUGUOModel(IRepositoryManager repositoryManager) {
        super(repositoryManager);
    }

    @Override
    public Observable<HomeInfo> getHomeInfo(String direction) {
        Observable<HomeInfo> splashEntityObservable = mRepositoryManager.obtainRetrofitService(ApiService.class)
                .getHomeInfo(direction);
        return splashEntityObservable;
    }
}
