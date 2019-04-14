package com.huazhuhotel.module_home.utils;

import com.longshihan.mvpcomponent.base.BaseApplication;

/**
 * Created by LONGHE001.
 *
 * @time 2019/3/26 0026
 * @des
 * @function
 */

public class UserInfo {


    public static String getUserId(){
        return (String) SPUtils.get(BaseApplication.getInstance(),"userInfo","");
    }

    public static void delUserID(){
        SPUtils.remove(BaseApplication.getInstance(),"userInfo");
    }

    public static void setUserINFO(){
        SPUtils.put(BaseApplication.getInstance(),"userInfo","23177077");
    }
}
