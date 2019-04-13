package com.huazhuhotel.module_home.detail.ui.fragment;


import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ExpandableListView;
import android.widget.TextView;
import android.widget.Toast;

import com.huazhuhotel.module_home.R;
import com.huazhuhotel.module_home.detail.adapter.CommentListExpandAdapter;
import com.huazhuhotel.module_home.detail.adapter.DetailCommentGroupAdapter;
import com.huazhuhotel.module_home.detail.adapter.DetailCookCommunicateAdapter;
import com.huazhuhotel.module_home.detail.persenter.CommentDetailContract;
import com.huazhuhotel.module_home.detail.persenter.CommentDetailPersenter;
import com.huazhuhotel.module_home.mvp.model.CommentListInfo;
import com.huazhuhotel.module_home.mvp.model.CommentUploadInfo;
import com.huazhuhotel.module_home.mvp.model.GoodsDetailInfo;
import com.huazhuhotel.module_home.utils.UserInfo;
import com.longshihan.mvpcomponent.base.BaseMVPFragment;
import com.longshihan.mvpcomponent.base.EmptyPersienter;
import com.longshihan.mvpcomponent.di.component.AppComponent;
import com.longshihan.mvpcomponent.utils.DeviceUtils;
import com.longshihan.mvpcomponent.widget.RecycleViewDivider;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnLoadMoreListener;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;

import java.util.ArrayList;
import java.util.List;

/**
 * 交流中心
 */
public class CommunicateFragment extends BaseMVPFragment<CommentDetailPersenter> implements CommentDetailContract.View {

    private List<CommentListInfo.ResultBean.CommentsBean> commentsBeanList;
    private RecyclerView expandableListView;
    private DetailCommentGroupAdapter adapter;
    private EditText editText;
    private TextView uploadTv;
    private String goodsId;
    private int pageIndex=0;
    private SmartRefreshLayout smartRefreshLayout;

    public CommunicateFragment() {
        // Required empty public constructor
    }

    @Override
    public View initView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_communicate2, container, false);
    }

    @Override
    public void initData(Bundle savedInstanceState) {
        expandableListView=mRootview.findViewById(R.id.communicate2_expand);
        editText=mRootview.findViewById(R.id.communicate2_edit);
        uploadTv=mRootview.findViewById(R.id.communicate2_upload);
        smartRefreshLayout=mRootview.findViewById(R.id.comment_smartrefresh);
        expandableListView.setLayoutManager(new LinearLayoutManager(mActivity,LinearLayoutManager.VERTICAL,false));
        adapter=new DetailCommentGroupAdapter();
        expandableListView.setAdapter(adapter);
        mPresenter.getCommentList(goodsId,pageIndex);
        expandableListView.addItemDecoration(new RecycleViewDivider(mActivity, LinearLayoutManager.VERTICAL,10,R.color.white));
        uploadTv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!TextUtils.isEmpty(editText.getText())){
                    DeviceUtils.hideSoftKeyboard(mContext,editText);
                    mPresenter.putCommentUpload(goodsId, UserInfo.getUserId(),editText.getText().toString());
                }
            }
        });
        smartRefreshLayout.setOnRefreshListener(new OnRefreshListener() {
            @Override
            public void onRefresh(@NonNull RefreshLayout refreshLayout) {
                pageIndex=0;
                mPresenter.getCommentList(goodsId,pageIndex);
            }
        });

        smartRefreshLayout.setOnLoadMoreListener(new OnLoadMoreListener() {
            @Override
            public void onLoadMore(RefreshLayout refreshLayout) {
                pageIndex++;
                mPresenter.getCommentList(goodsId,pageIndex);
            }
        });
    }

    @Override
    public void setupFragmentComponent(AppComponent appComponent) {
        mPresenter=new CommentDetailPersenter(this,appComponent.repositoryManager());
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
    public void getCommentList(CommentListInfo info) {
        if (info != null && info.getResult() != null &&
                "success".equals(info.getState()) && info.getResult().getComments() != null) {
            if (pageIndex==0) {
                adapter.setListData(info.getResult().getComments());
            }else {
                adapter.appendListData(info.getResult().getComments());
            }
            smartRefreshLayout.finishLoadMore();
            smartRefreshLayout.finishRefresh();
        }else {
            if (pageIndex>0){
                pageIndex--;
            }
        }
    }

    @Override
    public void putCommentInfo(CommentUploadInfo info) {
        if (info!=null&&!TextUtils.isEmpty(info.getState())&&"success".equals(info.getState())){
            Toast.makeText(mActivity,info.getMessage(),Toast.LENGTH_SHORT).show();
            pageIndex=0;
            mPresenter.getCommentList(goodsId,pageIndex);
        }
    }

    public void setGoodsId(String goodsId) {
        this.goodsId = goodsId;
    }
}
