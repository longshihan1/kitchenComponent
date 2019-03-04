package com.huazhuhotel.module_home.main.ui.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.huazhuhotel.module_home.R;
import com.huazhuhotel.module_home.main.adapter.HomeAdapter;
import com.huazhuhotel.module_home.main.persenter.DOUGUOContract;
import com.huazhuhotel.module_home.main.persenter.DOUGUOMANINPersenter;
import com.huazhuhotel.module_home.mvp.model.HomeInfo;
import com.huazhuhotel.module_home.sort.ui.SortListActivity;
import com.longshihan.mvpcomponent.base.BaseMVPFragment;
import com.longshihan.mvpcomponent.di.component.AppComponent;

/**
 * Created by LONGHE001.
 *
 * @time 2019/3/3 0003
 * @des
 * @function
 */

public class HomeFragment extends BaseMVPFragment<DOUGUOMANINPersenter> implements DOUGUOContract.View,HomeAdapter.OnAdapterListener {
    RecyclerView mDouguoHomeRecy;

    private HomeAdapter adapter;

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
    public void getHomeInfo(HomeInfo info) {
        if (info != null && info.getResult() != null) {
            adapter.setBeanList(info);
        }
    }

    @Override
    public View initView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        mRootview = inflater.inflate(R.layout.fragment_douguo, container, false);
        return mRootview;
    }

    @Override
    public void initData(Bundle savedInstanceState) {
        mDouguoHomeRecy = mRootview.findViewById(R.id.douguo_home_recy);
        adapter = new HomeAdapter(mContext);
        adapter.setListener(this);
        mDouguoHomeRecy.setLayoutManager(new LinearLayoutManager(mContext, LinearLayoutManager.VERTICAL, false));
        mDouguoHomeRecy.setAdapter(adapter);
        mPresenter.getHomeInfd();
    }

    @Override
    public void setupFragmentComponent(AppComponent appComponent) {
        mPresenter = new DOUGUOMANINPersenter(this, appComponent.repositoryManager());
    }

    @Override
    public void onHomeSortListener() {
        //点击进分类
        startActivity(new Intent(mActivity, SortListActivity.class));
    }
}
