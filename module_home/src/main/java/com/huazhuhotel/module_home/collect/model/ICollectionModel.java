package com.huazhuhotel.module_home.collect.model;

import com.huazhuhotel.module_home.mvp.model.CollectionInfo;

import io.reactivex.Observable;

/**
 * Created by LONGHE001.
 *
 * @time 2019/3/29 0029
 * @des
 * @function
 */

public interface ICollectionModel {
    Observable<CollectionInfo> getCollectionListInfo(String id, int page);
}
