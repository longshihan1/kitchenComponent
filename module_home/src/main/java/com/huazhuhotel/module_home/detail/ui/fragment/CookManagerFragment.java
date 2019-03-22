package com.huazhuhotel.module_home.detail.ui.fragment;


import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.huazhuhotel.module_home.R;
import com.huazhuhotel.module_home.detail.adapter.DetailCookAdapter;
import com.huazhuhotel.module_home.mvp.model.GoodsDetailInfo;
import com.longshihan.mvpcomponent.base.BaseMVPFragment;
import com.longshihan.mvpcomponent.base.EmptyPersienter;
import com.longshihan.mvpcomponent.di.component.AppComponent;

/**
 * 商品详情 - 菜谱界面
 */
public class CookManagerFragment extends BaseMVPFragment {


    private GoodsDetailInfo.ResultBean.RecipeBean data;
    private RecyclerView recyclerView;
    private DetailCookAdapter adapter;

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
        recyclerView = mRootview.findViewById(R.id.goodsdetail_detailcook_recy);
        adapter = new DetailCookAdapter();
        recyclerView.setLayoutManager(new LinearLayoutManager(mContext, LinearLayoutManager.VERTICAL, false));
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void setupFragmentComponent(AppComponent appComponent) {
        mPresenter = new EmptyPersienter();
    }

    public void restoreData() {
        setData(data);
        if (data!=null&&data.getCookstep()!=null) {
            adapter.setListData(data.getCookstep());
        }
    }
}
