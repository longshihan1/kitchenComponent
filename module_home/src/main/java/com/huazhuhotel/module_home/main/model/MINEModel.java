package com.huazhuhotel.module_home.main.model;

import com.huazhuhotel.module_home.http.ApiService;
import com.huazhuhotel.module_home.mvp.model.HomeInfo;
import com.huazhuhotel.module_home.mvp.model.UserInfo;
import com.longshihan.mvpcomponent.mvp.BaseModel;
import com.longshihan.mvpcomponent.mvp.IRepositoryManager;

import io.reactivex.Observable;

/**
 * Created by LONGHE001.
 *
 * @time 2019/2/27 0027
 * @des
 * @function
 */

public class MINEModel extends BaseModel implements  IMINEModel{
    public MINEModel(IRepositoryManager repositoryManager) {
        super(repositoryManager);
    }

    @Override
    public Observable<UserInfo> getUserInfo(String usrID) {
        Observable<UserInfo> splashEntityObservable = mRepositoryManager.obtainRetrofitService(ApiService.class)
                .getUserInfo(usrID);
        return splashEntityObservable;
    }
}
