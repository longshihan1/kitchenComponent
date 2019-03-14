package com.huazhuhotel.module_home.detail.ui.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.huazhuhotel.module_home.R;
import com.huazhuhotel.module_home.detail.adapter.DetailReCommondCookAdapter;
import com.huazhuhotel.module_home.mvp.model.ReCommondInfo;
import com.longshihan.mvpcomponent.base.BaseMVPFragment;
import com.longshihan.mvpcomponent.base.EmptyPersienter;
import com.longshihan.mvpcomponent.di.component.AppComponent;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class ReCommendCookFragment extends BaseMVPFragment {

    private List<ReCommondInfo.ResultBean.ListBean> datas;
    private RecyclerView recyclerView;
    private DetailReCommondCookAdapter adapter;

    public ReCommendCookFragment() {
        // Required empty public constructor
    }

    public void setData(List<ReCommondInfo.ResultBean.ListBean> datas) {
        if (datas==null){
            datas=new ArrayList<>();
        }
        this.datas = datas;
        adapter.setListData(datas);
    }

    public void restoreData() {
        setData(datas);
    }

    @Override
    public View initView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_re_commend_cook, container, false);
    }

    @Override
    public void initData(Bundle savedInstanceState) {
        recyclerView = mRootview.findViewById(R.id.goodsdetail_detailrecommend_recy);
        adapter = new DetailReCommondCookAdapter();
        recyclerView.setLayoutManager(new LinearLayoutManager(mContext, LinearLayoutManager.VERTICAL, false));
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void setupFragmentComponent(AppComponent appComponent) {
        mPresenter = new EmptyPersienter();
    }
}
