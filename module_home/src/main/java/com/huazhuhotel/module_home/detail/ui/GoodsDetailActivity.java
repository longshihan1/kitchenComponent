package com.huazhuhotel.module_home.detail.ui;

import android.os.Bundle;

import com.huazhuhotel.module_home.R;
import com.huazhuhotel.module_home.detail.persenter.GoodsDetailContract;
import com.huazhuhotel.module_home.detail.persenter.GoodsDetailPersenter;
import com.huazhuhotel.module_home.mvp.model.GoodsDetailInfo;
import com.longshihan.mvpcomponent.base.BaseMVPActivity;
import com.longshihan.mvpcomponent.di.component.AppComponent;

public class GoodsDetailActivity extends BaseMVPActivity<GoodsDetailPersenter> implements GoodsDetailContract.View {


    @Override
    public void showLoading() {

    }

    @Override
    public void hideLoading() {

    }

    @Override
    public void showError(int type, String message) {

    }

    @Override
    public void closeActivity() {

    }

    @Override
    public void getGoodsDetailInfo(GoodsDetailInfo info) {

    }

    @Override
    public void setupActivityComponent(AppComponent appComponent) {

    }

    @Override
    public int initView(Bundle savedInstanceState) {
        return R.layout.activity_goods_detail;
    }

    @Override
    public void initData() {

    }
}
