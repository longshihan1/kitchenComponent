package com.huazhuhotel.module_home.main.model;

import com.huazhuhotel.module_home.mvp.model.HomeInfo;
import com.huazhuhotel.module_home.mvp.model.UserInfo;

import io.reactivex.Observable;

/**
 * Created by LONGHE001.
 *
 * @time 2019/2/27 0027
 * @des
 * @function
 */

public interface IMINEModel {
    Observable<UserInfo> getUserInfo(String usrID);

}
