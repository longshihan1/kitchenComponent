package com.huazhuhotel.module_home.collect.ui;

import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.huazhuhotel.module_home.R;
import com.huazhuhotel.module_home.collect.persenter.CollectionContract;
import com.huazhuhotel.module_home.collect.persenter.CollectionPersenter;
import com.huazhuhotel.module_home.list.persenter.ListContract;
import com.huazhuhotel.module_home.list.persenter.ListPersenter;
import com.huazhuhotel.module_home.mvp.model.CollectionInfo;
import com.huazhuhotel.module_home.mvp.model.SearchInfo;
import com.longshihan.mvpcomponent.base.BaseMVPActivity;
import com.longshihan.mvpcomponent.di.component.AppComponent;

public class CollectionActivity extends BaseMVPActivity<CollectionPersenter> implements CollectionContract.View {

    private RecyclerView recyclerView;


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
    public void setupActivityComponent(AppComponent appComponent) {
        mPresenter = new CollectionPersenter(this, appComponent.repositoryManager());
    }

    @Override
    public int initView(Bundle savedInstanceState) {
        return R.layout.activity_collection;
    }

    @Override
    public void initData() {
        recyclerView = findViewById(R.id.collection_recy);
    }

    @Override
    public void getCollectInfo(CollectionInfo info) {
        if (info != null && info.getResult() != null && info.getResult().getRecipes() != null) {

        }
    }
}
