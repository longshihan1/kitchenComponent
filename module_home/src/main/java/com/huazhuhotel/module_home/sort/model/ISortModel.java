package com.huazhuhotel.module_home.sort.model;

import com.huazhuhotel.module_home.mvp.model.SortInfo;

import io.reactivex.Observable;

/**
 * Created by LONGHE001.
 *
 * @time 2019/3/4 0004
 * @des
 * @function
 */

public interface ISortModel {
    Observable<SortInfo> getSortInfo();
}
