package com.huazhuhotel.module_home.attention.ui;

import android.os.Bundle;
import android.view.View;

import com.huazhuhotel.module_home.R;
import com.huazhuhotel.module_home.attention.persenter.AttentionDetailContract;
import com.huazhuhotel.module_home.attention.persenter.AttentionDetailPersenter;
import com.huazhuhotel.module_home.mvp.model.UnRecipesListInfo;
import com.huazhuhotel.module_home.mvp.model.UserInfo;
import com.huazhuhotel.module_home.mvp.model.UserNoteInfo;
import com.huazhuhotel.module_home.utils.IntentContancts;
import com.longshihan.mvpcomponent.base.BaseMVPActivity;
import com.longshihan.mvpcomponent.di.component.AppComponent;
import com.orhanobut.logger.Logger;

public class AttentionDetailActivity extends BaseMVPActivity<AttentionDetailPersenter> implements AttentionDetailContract.View, View.OnClickListener  {
    private String userId;
    private int recipesPage=0,notePage=0;
    @Override
    public void onClick(View v) {

    }

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
    public void getUserInfo(UserInfo info) {
        if (info!=null&&info.getResult()!=null&&info.getResult().getUser()!=null){
            Logger.d(info);
        }
    }

    @Override
    public void getUnRecipesListInfo(UnRecipesListInfo info) {
        if (info!=null&&info.getResult()!=null&&info.getResult().getList()!=null){
            Logger.d(info);
        }
    }

    @Override
    public void getUserNoteListInfo(UserNoteInfo info) {
        if (info!=null&&info.getResult()!=null&&info.getResult().getList()!=null){
            Logger.d(info);
        }
    }

    @Override
    public void setupActivityComponent(AppComponent appComponent) {
        mPresenter=new AttentionDetailPersenter(this,appComponent.repositoryManager());
    }

    @Override
    public int initView(Bundle savedInstanceState) {
        return R.layout.activity_attention_detail;
    }

    @Override
    public void initData() {
        userId=getIntent().getStringExtra(IntentContancts.USERID_VALUE);
        mPresenter.getUserInfo(userId);
        mPresenter.getUnRecipesListInfo(userId,recipesPage);
        mPresenter.getUserNoteListInfo(userId,notePage);
    }
}
