package com.huazhuhotel.module_home.detail.ui.fragment;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.huazhuhotel.module_home.R;
import com.huazhuhotel.module_home.mvp.model.GoodsDetailInfo;
import com.longshihan.mvpcomponent.base.BaseFragment;
import com.longshihan.mvpcomponent.di.component.AppComponent;
import com.longshihan.mvpcomponent.intergration.cache.Cache;

/**
 * 交流中心
 */
public class CommunicateFragment extends BaseFragment {


    private GoodsDetailInfo.ResultBean.RecipeBean data;

    public CommunicateFragment() {
        // Required empty public constructor
    }


    public void setData(GoodsDetailInfo.ResultBean.RecipeBean data) {
        this.data = data;
    }

    @Override
    public View initView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_communicate2, container, false);
    }

    @Override
    public void initData(Bundle savedInstanceState) {

    }

    @Override
    public void setupFragmentComponent(AppComponent appComponent) {

    }
}
