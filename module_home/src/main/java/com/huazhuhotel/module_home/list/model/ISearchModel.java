package com.huazhuhotel.module_home.list.model;

import com.huazhuhotel.module_home.mvp.model.SearchInfo;
import com.huazhuhotel.module_home.mvp.model.SortInfo;

import io.reactivex.Observable;

/**
 * Created by LONGHE001.
 *
 * @time 2019/3/4 0004
 * @des
 * @function
 */

public interface ISearchModel {
    Observable<SearchInfo> getSeachInfo(int page,String searchValue,int type);
}
