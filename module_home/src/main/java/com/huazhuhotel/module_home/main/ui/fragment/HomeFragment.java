package com.huazhuhotel.module_home.main.ui.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.huazhuhotel.module_home.Mine.RecentLookActivity;
import com.huazhuhotel.module_home.R;
import com.huazhuhotel.module_home.collect.ui.CollectionActivity;
import com.huazhuhotel.module_home.detail.ui.GoodsDetailActivity;
import com.huazhuhotel.module_home.list.persenter.ListContract;
import com.huazhuhotel.module_home.list.persenter.ListPersenter;
import com.huazhuhotel.module_home.list.ui.ListActivity;
import com.huazhuhotel.module_home.main.adapter.HomeAdapter;
import com.huazhuhotel.module_home.main.persenter.DOUGUOContract;
import com.huazhuhotel.module_home.main.persenter.DOUGUOMANINPersenter;
import com.huazhuhotel.module_home.mvp.adapter.SimpleRecyclerAdapter;
import com.huazhuhotel.module_home.mvp.model.HomeInfo;
import com.huazhuhotel.module_home.mvp.model.SearchInfo;
import com.huazhuhotel.module_home.sort.ui.SortListActivity;
import com.huazhuhotel.module_home.utils.IntentContancts;
import com.longshihan.mvpcomponent.base.BaseMVPFragment;
import com.longshihan.mvpcomponent.di.component.AppComponent;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnLoadMoreListener;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by LONGHE001.
 *
 * @time 2019/3/3 0003
 * @des
 * @function
 */

public class HomeFragment extends BaseMVPFragment<DOUGUOMANINPersenter> implements DOUGUOContract.View,HomeAdapter.OnAdapterListener , ListContract.View {
    RecyclerView mDouguoHomeRecy;
    ListPersenter listPersenter;
    private int pageIndex = 0;
    private int searchType = 0;
    private String SearchValue="烘焙";
    private SmartRefreshLayout smartRefreshLayout;
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
        smartRefreshLayout = mRootview.findViewById(R.id.search_type_smartrefresh);
        adapter = new HomeAdapter(mContext);
        adapter.setListener(this);
        mDouguoHomeRecy.setLayoutManager(new LinearLayoutManager(mContext, LinearLayoutManager.VERTICAL, false));
        mDouguoHomeRecy.setAdapter(adapter);
        mPresenter.getHomeInfd();
        refreshData();

        smartRefreshLayout.setOnLoadMoreListener(new OnLoadMoreListener() {
            @Override
            public void onLoadMore(RefreshLayout refreshLayout) {
                refreshData();
            }
        });

    }

    @Override
    public void setupFragmentComponent(AppComponent appComponent) {
        mPresenter = new DOUGUOMANINPersenter(this, appComponent.repositoryManager());
        listPersenter=new ListPersenter(this,appComponent.repositoryManager());
    }

    @Override
    public void onHomeSortListener() {
        //点击进分类
        startActivity(new Intent(mActivity, SortListActivity.class));
    }

    @Override
    public void onHomeSearchListener() {
        Intent intent=new Intent(mActivity, ListActivity.class);
        intent.putExtra(IntentContancts.SEARCH_VALUE,"");
        startActivity(intent);
    }

    @Override
    public void onCollectionListener() {
        startActivity(new Intent(mActivity, CollectionActivity.class));
    }

    @Override
    public void onRecentLookListener() {
        startActivity(new Intent(mActivity, RecentLookActivity.class));
    }

    @Override
    public void onMsgClick(SearchInfo.ResultBean.ListBean item) {
        String id=item.getR().getId();
        Intent intent=new Intent(mActivity, GoodsDetailActivity.class);
        intent.putExtra(IntentContancts.GOODSDETAIL_VALUE,id+"");
        startActivity(intent);
    }

    @Override
    public void getListInfo(SearchInfo info) {
        smartRefreshLayout.finishLoadMore();
        if (info != null && info.getResult() != null && info.getResult().getList() != null) {
            List<SearchInfo.ResultBean.ListBean> listBeans=new ArrayList<>();
            for (int i = 0; i <info.getResult().getList().size(); i++) {
                if (info.getResult().getList().get(i)!=null&&info.getResult().getList().get(i).getR()!=null){
                    listBeans.add(info.getResult().getList().get(i));
                }
            }
            adapter.setListData(listBeans);
            pageIndex+=20;
        }
    }

    public void refreshData() {
        listPersenter.getListInfo(0,pageIndex+20, SearchValue, searchType);
    }
}
