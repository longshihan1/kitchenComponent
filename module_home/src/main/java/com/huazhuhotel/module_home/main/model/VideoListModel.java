package com.huazhuhotel.module_home.main.model;

import com.huazhuhotel.module_home.http.ApiService;
import com.huazhuhotel.module_home.mvp.model.UserInfo;
import com.huazhuhotel.module_home.mvp.model.VideoListInfo;
import com.longshihan.mvpcomponent.mvp.BaseModel;
import com.longshihan.mvpcomponent.mvp.IRepositoryManager;

import io.reactivex.Observable;

public class VideoListModel extends BaseModel implements IVideoListModel {
    public VideoListModel(IRepositoryManager repositoryManager) {
        super(repositoryManager);
    }

    @Override
    public Observable<VideoListInfo> getVideoListInfo(String usrID, int padgeIndex) {
        Observable<VideoListInfo> splashEntityObservable = mRepositoryManager.obtainRetrofitService(ApiService.class)
                .getVideoListInfo(usrID,padgeIndex);
        return splashEntityObservable;
    }
}
