package com.huazhuhotel.module_home.attention.model;

import com.huazhuhotel.module_home.mvp.model.FollowInfo;

import io.reactivex.Observable;

public interface IFollowModel {
    Observable<FollowInfo> getFollowInfo(String userID,String fid);
    Observable<FollowInfo> getunFollowInfo(String userID,String fid);
}
