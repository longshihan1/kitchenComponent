package com.huazhuhotel.module_home.collect.ui;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.huazhuhotel.module_home.R;
import com.huazhuhotel.module_home.collect.adapter.CollectionListAdapter;
import com.huazhuhotel.module_home.collect.persenter.CollectionContract;
import com.huazhuhotel.module_home.collect.persenter.CollectionPersenter;
import com.huazhuhotel.module_home.list.persenter.ListContract;
import com.huazhuhotel.module_home.list.persenter.ListPersenter;
import com.huazhuhotel.module_home.mvp.model.CollectionInfo;
import com.huazhuhotel.module_home.mvp.model.SearchInfo;
import com.huazhuhotel.module_home.utils.UserInfo;
import com.longshihan.mvpcomponent.base.BaseMVPActivity;
import com.longshihan.mvpcomponent.di.component.AppComponent;

public class CollectionActivity extends BaseMVPActivity<CollectionPersenter> implements CollectionContract.View {

    private RecyclerView recyclerView;
    private CollectionListAdapter adapter;
    private int pageIndex=0;


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
        adapter=new CollectionListAdapter();
        recyclerView.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));
        recyclerView.setAdapter(adapter);
        mPresenter.getCollectionInfo(UserInfo.getUserId(),pageIndex);
    }

    @Override
    public void getCollectInfo(CollectionInfo info) {
        if (info != null && info.getResult() != null && info.getResult().getRecipes() != null) {
            adapter.setListData(info.getResult().getRecipes());
        }
    }
}
