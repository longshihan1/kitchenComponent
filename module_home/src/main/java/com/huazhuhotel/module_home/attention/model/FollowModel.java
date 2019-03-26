package com.huazhuhotel.module_home.attention.model;

import com.huazhuhotel.module_home.http.ApiService;
import com.huazhuhotel.module_home.mvp.model.FollowInfo;
import com.longshihan.mvpcomponent.mvp.BaseModel;
import com.longshihan.mvpcomponent.mvp.IRepositoryManager;

import io.reactivex.Observable;

/**
 * Created by LONGHE001.
 *
 * @time 2019/3/26 0026
 * @des
 * @function
 */

public class FollowModel extends BaseModel implements IFollowModel {
    public FollowModel(IRepositoryManager repositoryManager) {
        super(repositoryManager);
    }

    @Override
    public Observable<FollowInfo> getFollowInfo(String userID, String fid) {
        return mRepositoryManager.obtainRetrofitService(ApiService.class)
                .getFollowInfo(userID, fid,
                        "1552976495578869785037870694","400",
                        "2a0ef8e10253a21df2fa58d1b1a6a19d", "4",
                        "1552977390", "856eb23930eed4260397eea14e2ebd8b");
    }

    @Override
    public Observable<FollowInfo> getunFollowInfo(String userID, String fid) {
        return mRepositoryManager.obtainRetrofitService(ApiService.class)
                .getunFollowInfo(userID, fid,
                        "1552976495578869785037870694",
                        "2a0ef8e10253a21df2fa58d1b1a6a19d", "4",
                        "1552977390", "6ffd44b2008538a3d789ce46d09fecec");
    }
}
