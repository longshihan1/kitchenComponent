package com.huazhuhotel.module_home.list.ui;

import android.os.Bundle;

import com.huazhuhotel.module_home.R;
import com.huazhuhotel.module_home.list.persenter.ListContract;
import com.huazhuhotel.module_home.list.persenter.ListPersenter;
import com.huazhuhotel.module_home.mvp.model.SearchInfo;
import com.longshihan.mvpcomponent.base.BaseMVPActivity;
import com.longshihan.mvpcomponent.di.component.AppComponent;

public class ListActivity extends BaseMVPActivity<ListPersenter> implements ListContract.View {

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
    public void getListInfo(SearchInfo info) {

    }

    @Override
    public void setupActivityComponent(AppComponent appComponent) {

    }

    @Override
    public int initView(Bundle savedInstanceState) {
        return R.layout.activity_list;
    }

    @Override
    public void initData() {

    }
}
