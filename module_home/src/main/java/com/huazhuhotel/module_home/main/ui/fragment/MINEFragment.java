package com.huazhuhotel.module_home.main.ui.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.huazhuhotel.module_home.R;
import com.huazhuhotel.module_home.attention.persenter.AttentionDetailContract;
import com.huazhuhotel.module_home.attention.persenter.AttentionDetailPersenter;
import com.huazhuhotel.module_home.main.adapter.HomeAdapter;
import com.huazhuhotel.module_home.main.persenter.DOUGUOContract;
import com.huazhuhotel.module_home.main.persenter.DOUGUOMANINPersenter;
import com.huazhuhotel.module_home.mvp.model.UnRecipesListInfo;
import com.huazhuhotel.module_home.mvp.model.UserInfo;
import com.huazhuhotel.module_home.mvp.model.UserNoteInfo;
import com.longshihan.mvpcomponent.base.BaseMVPFragment;
import com.longshihan.mvpcomponent.di.component.AppComponent;

/**
 * A simple {@link Fragment} subclass.
 */
public class MINEFragment extends BaseMVPFragment<AttentionDetailPersenter> implements AttentionDetailContract.View  {


    public MINEFragment() {
        // Required empty public constructor
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

    }

    @Override
    public void getUnRecipesListInfo(UnRecipesListInfo info) {

    }

    @Override
    public void getUserNoteListInfo(UserNoteInfo info) {

    }

    @Override
    public View initView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_mine, container, false);
    }

    @Override
    public void initData(Bundle savedInstanceState) {
        mPresenter.getUserInfo(com.huazhuhotel.module_home.utils.UserInfo.getUserId());
    }

    @Override
    public void setupFragmentComponent(AppComponent appComponent) {
        mPresenter=new AttentionDetailPersenter(this,appComponent.repositoryManager());
    }
}
