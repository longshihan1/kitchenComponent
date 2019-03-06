package com.huazhuhotel.module_home.detail.ui.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.huazhuhotel.module_home.R;
import com.huazhuhotel.module_home.mvp.model.GoodsDetailInfo;
import com.longshihan.mvpcomponent.base.BaseFragment;
import com.longshihan.mvpcomponent.di.component.AppComponent;

/**
 * 商品的配方详情
 */
public class GoodsDetailFragment extends BaseFragment {


    private GoodsDetailInfo.ResultBean.RecipeBean data;

    public GoodsDetailFragment() {
        // Required empty public constructor
    }

    public void setData(GoodsDetailInfo.ResultBean.RecipeBean data) {
        this.data = data;
    }

    @Override
    public View initView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_goods_detail, container, false);
    }

    @Override
    public void initData(Bundle savedInstanceState) {

    }

    @Override
    public void setupFragmentComponent(AppComponent appComponent) {

    }
}
