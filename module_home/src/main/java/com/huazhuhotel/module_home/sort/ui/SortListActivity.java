package com.huazhuhotel.module_home.sort.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SimpleItemAnimator;
import android.text.TextUtils;
import android.widget.Toast;

import com.huazhuhotel.module_home.R;
import com.huazhuhotel.module_home.list.ui.ListActivity;
import com.huazhuhotel.module_home.mvp.adapter.SimpleRecyclerAdapter;
import com.huazhuhotel.module_home.mvp.model.SortInfo;
import com.huazhuhotel.module_home.sort.adapter.LeftAdapter;
import com.huazhuhotel.module_home.sort.adapter.RightAdapter;
import com.huazhuhotel.module_home.sort.model.entity.ItemType;
import com.huazhuhotel.module_home.sort.model.entity.SortBean;
import com.huazhuhotel.module_home.sort.model.entity.SortItem;
import com.huazhuhotel.module_home.sort.persenter.SortContract;
import com.huazhuhotel.module_home.sort.persenter.SortPersenter;
import com.huazhuhotel.module_home.utils.IntentContancts;
import com.longshihan.mvpcomponent.base.BaseMVPActivity;
import com.longshihan.mvpcomponent.di.component.AppComponent;
import com.orhanobut.logger.Logger;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SortListActivity extends BaseMVPActivity<SortPersenter> implements SortContract.View {
    private RecyclerView leftRecyclerView;
    private RecyclerView rightRecyclerView;

    private LeftAdapter leftAdapter;
    private RightAdapter rightAdapter;

    private  List<SortBean> mLeftList = new ArrayList<>();

    private  List<SortItem> mRightList = new ArrayList<>();

    private  Map<Integer, Integer> indexMap = new HashMap<>();

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
    public void getSortInfo(SortInfo info) {
        mLeftList = new ArrayList<>();
        mRightList = new ArrayList<>();
        indexMap = new HashMap<>();
        List<SortInfo.ResultBean.CsBeanXX.CsBeanX> csBeanList=new ArrayList<>();
        if (info!=null&&info.getResult()!=null&&info.getResult().getCs()!=null){
            for (SortInfo.ResultBean.CsBeanXX csBeanXX:info.getResult().getCs()) {
                if (csBeanXX!=null&&!TextUtils.isEmpty(csBeanXX.getName())&&"烘焙".equals(csBeanXX.getName())){
                    csBeanList=csBeanXX.getCs();
                    break;
                }
            }
        }
        // 构造点数据，比如整个数据刚刚好就是从json转过来的，一个Bean里面有一个大类，有若干个小类
        // 左侧的adapter就直接用这个构造好的list
        for (int i = 0; i < csBeanList.size(); i++) {
            if (csBeanList.get(i)==null||csBeanList.get(i).getCs()==null||csBeanList.get(i).getCs().size()<=0){

            }else {
                SortBean bean = new SortBean();
                bean.bigSortId = i;
                bean.bigSortName = csBeanList.get(i).getName();
                List<SortBean.ListBean> list = new ArrayList<>();
                for (int j = 0; j < csBeanList.get(i).getCs().size(); j++) {
                    SortBean.ListBean listBean = new SortBean.ListBean();
                    listBean.smallSortId = j;
                    listBean.smallSortName = csBeanList.get(i).getCs().get(j).getName();
                    list.add(listBean);
                }
                bean.list = list;
                mLeftList.add(bean);
            }
        }
        // 右侧的list是将每一个大类和小类按次序添加，并且标记大类的位置
        for (int i = 0; i < mLeftList.size(); i++) {
            SortItem bigItem = new SortItem();
            bigItem.viewType = ItemType.BIG_SORT;
            bigItem.id = mLeftList.get(i).bigSortId;
            bigItem.name = mLeftList.get(i).bigSortName;
            // 标记大类的位置，所有项的position默认是-1，如果是大类就添加position，让他和左侧位置对应
            bigItem.position = i;
            mRightList.add(bigItem);
            for (int j = 0; j < mLeftList.get(i).list.size(); j++) {
                SortItem smallItem = new SortItem();
                smallItem.viewType = ItemType.SMALL_SORT;
                smallItem.id = mLeftList.get(i).list.get(j).smallSortId;
                smallItem.name = mLeftList.get(i).list.get(j).smallSortName;
                mRightList.add(smallItem);
            }
        }
        // 点击左侧需要知道对应右侧的位置，用map先保存起来
        for (int i = 0; i < mRightList.size(); i++) {
            if (mRightList.get(i).position != -1) {
                indexMap.put(mRightList.get(i).position, i);
            }
        }
        rightAdapter.setListData(mRightList);
        leftAdapter.setListData(mLeftList);
        leftAdapter.setSelectedPosition(0);
        moveToMiddle(leftRecyclerView, 0);
        // 右侧滑到对应位置
        ((GridLayoutManager)rightRecyclerView.getLayoutManager())
                .scrollToPositionWithOffset(indexMap.get(0),0);
    }

    @Override
    public void setupActivityComponent(AppComponent appComponent) {
        mPresenter=new SortPersenter(this,appComponent.repositoryManager());
    }

    @Override
    public int initView(Bundle savedInstanceState) {
        return R.layout.activity_sort_list;
    }

    @Override
    public void initData() {
        leftRecyclerView = (RecyclerView) findViewById(R.id.rv_sort_left) ;
        rightRecyclerView = (RecyclerView) findViewById(R.id.rv_sort_right);
        // 左列表
        leftRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        ((SimpleItemAnimator) leftRecyclerView.getItemAnimator()).setSupportsChangeAnimations(false);
        leftAdapter = new LeftAdapter();
        leftAdapter.setListData(mLeftList);
        leftRecyclerView.setAdapter(leftAdapter);
        // 左侧列表的点击事件
        leftAdapter.setOnItemClickListener(new SimpleRecyclerAdapter.OnItemClickListener<SortBean>() {
            @Override
            public void onItemClick(SortBean item, int index) {
                // 左侧选中并滑到中间位置
                leftAdapter.setSelectedPosition(index);
                moveToMiddle(leftRecyclerView, index);
                // 右侧滑到对应位置
                ((GridLayoutManager)rightRecyclerView.getLayoutManager())
                        .scrollToPositionWithOffset(indexMap.get(index),0);
            }
        });
        // 右列表
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 3);
        gridLayoutManager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup(){
            @Override
            public int getSpanSize(int position) {
                if (mRightList.get(position).viewType == ItemType.BIG_SORT) {
                    return 3;
                } else {
                    return 1;
                }
            }
        });
        rightRecyclerView.setLayoutManager(gridLayoutManager);
        rightAdapter = new RightAdapter();
        rightAdapter.setListData(mRightList);
        rightRecyclerView.setAdapter(rightAdapter);
        rightAdapter.setOnItemClickListener(new SimpleRecyclerAdapter.OnItemClickListener<SortItem>() {
            @Override
            public void onItemClick(SortItem item, int index) {
                //点击小的
                Intent intent=new Intent(SortListActivity.this, ListActivity.class);
                intent.putExtra(IntentContancts.SEARCH_VALUE,item.name);
                startActivity(intent);
            }
        });
        //右侧列表的滚动事件
        rightRecyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                //获取右侧列表的第一个可见Item的position
                int topPosition = ((GridLayoutManager) rightRecyclerView.getLayoutManager()).findFirstVisibleItemPosition();
                // 如果此项对应的是左边的大类的index
                if (mRightList.get(topPosition).position != -1) {
                    moveToMiddle(leftRecyclerView, mRightList.get(topPosition).position);
                    leftAdapter.setSelectedPosition(mRightList.get(topPosition).position);
                }
            }
        });
        mPresenter.getSortInfo();
    }

    public  void moveToMiddle(RecyclerView recyclerView, int position) {
        //先从RecyclerView的LayoutManager中获取当前第一项和最后一项的Position
        int firstItem = ((LinearLayoutManager) recyclerView.getLayoutManager()).findFirstVisibleItemPosition();
        int lastItem = ((LinearLayoutManager) recyclerView.getLayoutManager()).findLastVisibleItemPosition();
        //中间位置
        int middle = (firstItem + lastItem)/2;
        // 取绝对值，index下标是当前的位置和中间位置的差，下标为index的view的top就是需要滑动的距离
        int index = (position - middle) >= 0 ? position - middle : -(position - middle);
        //左侧列表一共有getChildCount个Item，如果>这个值会返回null，程序崩溃，如果>getChildCount直接滑到指定位置,或者,都一样啦
        if (index >= recyclerView.getChildCount()) {
            recyclerView.scrollToPosition(position);
        } else {
            //如果当前位置在中间位置上面，往下移动，这里为了防止越界
            if(position < middle) {
                recyclerView.scrollBy(0, -recyclerView.getChildAt(index).getTop());
                // 在中间位置的下面，往上移动
            } else {
                recyclerView.scrollBy(0, recyclerView.getChildAt(index).getTop());
            }
        }
    }

}
