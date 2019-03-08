package com.huazhuhotel.module_home.detail.ui.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.huazhuhotel.module_home.R;
import com.huazhuhotel.module_home.mvp.model.GoodsDetailInfo;
import com.longshihan.mvpcomponent.base.BaseFragment;
import com.longshihan.mvpcomponent.base.BaseMVPFragment;
import com.longshihan.mvpcomponent.base.EmptyPersienter;
import com.longshihan.mvpcomponent.di.component.AppComponent;

/**
 *  商品详情 - 菜谱界面
 */
public class CookManagerFragment extends BaseMVPFragment {


    private GoodsDetailInfo.ResultBean.RecipeBean data;

    public CookManagerFragment() {
        // Required empty public constructor
    }

    public void setData(GoodsDetailInfo.ResultBean.RecipeBean data) {
        this.data = data;
    }

    @Override
    public View initView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_cook_manager, container, false);
    }

    @Override
    public void initData(Bundle savedInstanceState) {

    }

    @Override
    public void setupFragmentComponent(AppComponent appComponent) {
        mPresenter=new EmptyPersienter();
    }
}
