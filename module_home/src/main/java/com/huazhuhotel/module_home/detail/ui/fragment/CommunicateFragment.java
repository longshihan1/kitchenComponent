package com.huazhuhotel.module_home.detail.ui.fragment;


import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ExpandableListView;

import com.huazhuhotel.module_home.R;
import com.huazhuhotel.module_home.detail.adapter.CommentListExpandAdapter;
import com.huazhuhotel.module_home.detail.adapter.DetailCookCommunicateAdapter;
import com.huazhuhotel.module_home.mvp.model.CommentListInfo;
import com.huazhuhotel.module_home.mvp.model.GoodsDetailInfo;
import com.longshihan.mvpcomponent.base.BaseMVPFragment;
import com.longshihan.mvpcomponent.base.EmptyPersienter;
import com.longshihan.mvpcomponent.di.component.AppComponent;

import java.util.ArrayList;
import java.util.List;

/**
 * 交流中心
 */
public class CommunicateFragment extends BaseMVPFragment {

    private List<CommentListInfo.ResultBean.CommentsBean> commentsBeanList;
    private ExpandableListView expandableListView;
    private CommentListExpandAdapter adapter;

    public CommunicateFragment() {
        // Required empty public constructor
    }


    public void setData(List<CommentListInfo.ResultBean.CommentsBean> data) {
        this.commentsBeanList = data;

    }

    @Override
    public View initView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_communicate2, container, false);
    }

    @Override
    public void initData(Bundle savedInstanceState) {
        expandableListView=mRootview.findViewById(R.id.communicate2_expand);
        adapter=new CommentListExpandAdapter(mActivity);
        expandableListView.setAdapter(adapter);


        expandableListView.setOnGroupClickListener(new ExpandableListView.OnGroupClickListener() {
            @Override
            public boolean onGroupClick(ExpandableListView parent, View v, int groupPosition, long id) {
                return true;
            }
        });

    }

    @Override
    public void setupFragmentComponent(AppComponent appComponent) {
        mPresenter=new EmptyPersienter();
    }

    public void restoreData() {
        adapter.setCommentsBeanList(commentsBeanList);
        for (int i = 0; i < commentsBeanList.size(); i++) {
            expandableListView.expandGroup(i);
        }

    }
}
