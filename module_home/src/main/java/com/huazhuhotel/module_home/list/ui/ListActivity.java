package com.huazhuhotel.module_home.list.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.huazhuhotel.module_home.R;
import com.huazhuhotel.module_home.detail.ui.GoodsDetailActivity;
import com.huazhuhotel.module_home.list.adapter.SearchListAdapter;
import com.huazhuhotel.module_home.list.persenter.ListContract;
import com.huazhuhotel.module_home.list.persenter.ListPersenter;
import com.huazhuhotel.module_home.mvp.adapter.SimpleRecyclerAdapter;
import com.huazhuhotel.module_home.mvp.model.MajorInfo;
import com.huazhuhotel.module_home.mvp.model.SearchInfo;
import com.huazhuhotel.module_home.utils.CacheConstancts;
import com.huazhuhotel.module_home.utils.GsonUtils;
import com.huazhuhotel.module_home.utils.IntentContancts;
import com.huazhuhotel.module_home.utils.SPUtils;
import com.longshihan.mvpcomponent.base.BaseMVPActivity;
import com.longshihan.mvpcomponent.di.component.AppComponent;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.footer.ClassicsFooter;
import com.scwang.smartrefresh.layout.listener.OnLoadMoreListener;

import java.util.ArrayList;
import java.util.List;

public class ListActivity extends BaseMVPActivity<ListPersenter> implements ListContract.View, View.OnClickListener {

    private String searchValue;
    private ImageView mLeftbtn;
    private EditText mSearchEdit;
    private ImageView mSearchBtn;
    /**
     * 综合最佳
     */
    private TextView mSearchTypeFirsttv;
    private View mSearchTypeFirstline;
    /**
     * 收藏最多
     */
    private TextView mSearchTypeSecondtv;
    private View mSearchTypeSecondline;
    /**
     * 做过最多
     */
    private TextView mSearchTypeThridtv;
    private View mSearchTypeThridline;
    private RecyclerView mSearchRecy;
    private int pageIndex = 0;
    private int searchType = 0;
    private SearchListAdapter adapter;
    private SmartRefreshLayout smartRefreshLayout;
    private ClassicsFooter footer;
    private Gson gson;

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

    @Override
    public void setupActivityComponent(AppComponent appComponent) {
        mPresenter = new ListPersenter(this, appComponent.repositoryManager());
    }

    @Override
    public int initView(Bundle savedInstanceState) {
        return R.layout.activity_list;
    }

    @Override
    public void initData() {
        searchValue = getIntent().getStringExtra(IntentContancts.SEARCH_VALUE);
        mLeftbtn = (ImageView) findViewById(R.id.leftbtn);
        mSearchEdit = (EditText) findViewById(R.id.search_edit);
        mSearchBtn = (ImageView) findViewById(R.id.search_btn);
        mSearchBtn.setOnClickListener(this);
        mSearchTypeFirsttv = (TextView) findViewById(R.id.search_type_firsttv);
        mSearchTypeFirsttv.setOnClickListener(this);
        mSearchTypeFirstline = (View) findViewById(R.id.search_type_firstline);
        mSearchTypeSecondtv = (TextView) findViewById(R.id.search_type_secondtv);
        mSearchTypeSecondtv.setOnClickListener(this);
        mSearchTypeSecondline = (View) findViewById(R.id.search_type_secondline);
        mSearchTypeThridtv = (TextView) findViewById(R.id.search_type_thridtv);
        mSearchTypeThridtv.setOnClickListener(this);
        mSearchTypeThridline = (View) findViewById(R.id.search_type_thridline);
        mSearchRecy = (RecyclerView) findViewById(R.id.search_recy);
        smartRefreshLayout = findViewById(R.id.search_type_smartrefresh);
        footer = findViewById(R.id.search_type_smartrefresh_footer);
        adapter = new SearchListAdapter();
        mSearchRecy.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        mSearchRecy.setAdapter(adapter);
        refreshData();
        gson=new Gson();

        smartRefreshLayout.setOnLoadMoreListener(new OnLoadMoreListener() {
            @Override
            public void onLoadMore(RefreshLayout refreshLayout) {
                refreshData();
            }
        });

        adapter.setOnItemClickListener(new SimpleRecyclerAdapter.OnItemClickListener<SearchInfo.ResultBean.ListBean>() {
            @Override
            public void onItemClick(SearchInfo.ResultBean.ListBean item, int index) {
                if (item==null||item.getR()==null||TextUtils.isEmpty(item.getR().getId())){
                    return;
                }
                String recentCache= (String) SPUtils.get(ListActivity.this, CacheConstancts.RECENTCACHE,"");
                List<SearchInfo.ResultBean.ListBean> listBeans=new ArrayList<>();
                if (!TextUtils.isEmpty(recentCache)){
                    listBeans= GsonUtils.jsonToArrayList(recentCache,SearchInfo.ResultBean.ListBean.class);
                    boolean isSame=false;
                    for (int i = 0; i <listBeans.size(); i++) {
                        if (listBeans.get(i)!=null&&
                                listBeans.get(i).getR()!=null&&
                                item.getR().getId().equals(listBeans.get(i).getR().getId())){
                            isSame=true;
                            break;
                        }
                    }
                    if (!isSame){
                        listBeans.add(item);
                        String json= gson.toJson(listBeans);
                        SPUtils.put(ListActivity.this,CacheConstancts.RECENTCACHE,json);
                    }
                }else {
                    listBeans.add(item);
                    String json= gson.toJson(listBeans);
                    SPUtils.put(ListActivity.this,CacheConstancts.RECENTCACHE,json);
                }


                String id=item.getR().getId();
                Intent intent=new Intent(ListActivity.this, GoodsDetailActivity.class);
                intent.putExtra(IntentContancts.GOODSDETAIL_VALUE,id);
                startActivity(intent);
                Toast.makeText(ListActivity.this,item.getR().getN(),Toast.LENGTH_SHORT).show();
            }
        });

        mSearchEdit.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                if (s != null && !TextUtils.isEmpty(s.toString())) {
                    pageIndex = 0;
                    searchValue = s.toString();
                    refreshData();
                } else {
                    pageIndex = 0;
                    refreshData();
                }
            }
        });
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            default:
                break;
            case R.id.search_btn:
                break;
            case R.id.search_type_firsttv:
                mSearchTypeSecondline.setVisibility(View.INVISIBLE);
                mSearchTypeThridline.setVisibility(View.INVISIBLE);
                mSearchTypeFirstline.setVisibility(View.VISIBLE);
                pageIndex = 0;
                searchType = 0;
                refreshData();
                break;
            case R.id.search_type_secondtv:
                mSearchTypeFirstline.setVisibility(View.INVISIBLE);
                mSearchTypeThridline.setVisibility(View.INVISIBLE);
                mSearchTypeSecondline.setVisibility(View.VISIBLE);
                pageIndex = 0;
                searchType = 2;
                refreshData();
                break;
            case R.id.search_type_thridtv:
                mSearchTypeSecondline.setVisibility(View.INVISIBLE);
                mSearchTypeFirstline.setVisibility(View.INVISIBLE);
                mSearchTypeThridline.setVisibility(View.VISIBLE);
                pageIndex = 0;
                searchType = 3;
                refreshData();
                break;
        }
    }


    public void refreshData() {
        mPresenter.getListInfo(0, pageIndex+20,searchValue, searchType);
    }
}
