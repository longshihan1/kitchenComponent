package com.huazhuhotel.module_home.detail.ui.fragment;


import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.huazhuhotel.module_home.R;
import com.huazhuhotel.module_home.detail.adapter.DetailCookCommunicateAdapter;
import com.huazhuhotel.module_home.mvp.model.GoodsDetailInfo;
import com.longshihan.mvpcomponent.base.BaseFragment;
import com.longshihan.mvpcomponent.base.BaseMVPFragment;
import com.longshihan.mvpcomponent.base.EmptyPersienter;
import com.longshihan.mvpcomponent.di.component.AppComponent;

import java.util.ArrayList;
import java.util.List;

/**
 * 交流中心
 */
public class CommunicateFragment extends BaseMVPFragment {

    private List<GoodsDetailInfo.ResultBean.RecipeBean.RecentCommentsBean> commentsBeanList;
    private GoodsDetailInfo.ResultBean.RecipeBean data;
    private DetailCookCommunicateAdapter adapter;
    private RecyclerView recyclerView;

    public CommunicateFragment() {
        // Required empty public constructor
    }


    public void setData(GoodsDetailInfo.ResultBean.RecipeBean data) {
        this.data = data;

    }

    @Override
    public View initView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_communicate2, container, false);
    }

    @Override
    public void initData(Bundle savedInstanceState) {
        commentsBeanList=new ArrayList<>();
        recyclerView=mRootview.findViewById(R.id.communicate2_recy);
        adapter=new DetailCookCommunicateAdapter();
        recyclerView.setLayoutManager(new LinearLayoutManager(mActivity,LinearLayoutManager.VERTICAL,false));
        recyclerView.setAdapter(adapter);

    }

    @Override
    public void setupFragmentComponent(AppComponent appComponent) {
        mPresenter=new EmptyPersienter();
    }

    public void restoreData() {
        setData(data);
        if (data!=null){
            if (data.getOld_comments()!=null&&data.getOld_comments().size()>0){
                commentsBeanList.addAll(data.getOld_comments());
            }
            if (data.getRecent_comments()!=null&&data.getRecent_comments().size()>0){
                commentsBeanList.addAll(data.getRecent_comments());
            }
        }
        if (commentsBeanList!=null){
            adapter.setListData(commentsBeanList);
        }
    }
}
