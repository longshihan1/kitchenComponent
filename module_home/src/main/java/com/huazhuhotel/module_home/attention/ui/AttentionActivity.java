package com.huazhuhotel.module_home.attention.ui;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.View;

import com.huazhuhotel.module_home.R;
import com.huazhuhotel.module_home.attention.adapter.AttentionAdapter;
import com.huazhuhotel.module_home.attention.adapter.viewholder.AttentionViewHolder;
import com.huazhuhotel.module_home.attention.persenter.AttentionContract;
import com.huazhuhotel.module_home.attention.persenter.AttentionPersenter;
import com.huazhuhotel.module_home.attention.persenter.FollowContract;
import com.huazhuhotel.module_home.attention.persenter.FollowPersenter;
import com.huazhuhotel.module_home.mvp.adapter.SimpleRecyclerAdapter;
import com.huazhuhotel.module_home.mvp.model.AttentionInfo;
import com.huazhuhotel.module_home.mvp.model.FollowInfo;
import com.huazhuhotel.module_home.utils.IntentContancts;
import com.huazhuhotel.module_home.utils.UserInfo;
import com.longshihan.mvpcomponent.base.BaseMVPActivity;
import com.longshihan.mvpcomponent.di.component.AppComponent;

public class AttentionActivity extends BaseMVPActivity<AttentionPersenter> implements AttentionContract.View, FollowContract.View, View.OnClickListener {

    private RecyclerView recyclerView;
    private AttentionAdapter attentionAdapter;

    private FollowPersenter followPersenter;

    @Override
    public void onClick(View v) {

    }

    @Override
    public void getAtentionInfo(AttentionInfo info) {
        if (info != null && info.getResult() != null && info.getResult().getFollows() != null) {
            attentionAdapter.setListData(info.getResult().getFollows());
        }

    }

    @Override
    public void setupActivityComponent(AppComponent appComponent) {
        mPresenter = new AttentionPersenter(this, appComponent.repositoryManager());
        followPersenter = new FollowPersenter(this, appComponent.repositoryManager());
    }

    @Override
    public int initView(Bundle savedInstanceState) {
        return R.layout.activity_attention;
    }

    @Override
    public void initData() {
        recyclerView = findViewById(R.id.attention_recy);
        attentionAdapter = new AttentionAdapter();
        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        recyclerView.setAdapter(attentionAdapter);
        mPresenter.getAttentionInfo(UserInfo.getUserId());
        attentionAdapter.setOnItemClickListener(new SimpleRecyclerAdapter.OnItemClickListener<AttentionInfo.ResultBean.FollowsBean>() {
            @Override
            public void onItemClick(AttentionInfo.ResultBean.FollowsBean item, int index) {
                if (item != null && !TextUtils.isEmpty(item.getUser_id())) {
                    Intent intent = new Intent(AttentionActivity.this, AttentionDetailActivity.class);
                    intent.putExtra(IntentContancts.USERID_VALUE, item.getUser_id());
                    startActivity(intent);
                }
            }
        });
        attentionAdapter.attchListener(new AttentionViewHolder.onImgClickListener() {
            @Override
            public void onClick(String fid) {
//                followPersenter.getFollowInfo(UserInfo.getUserId(), fid);
            }
        });
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
    public void getFollowInfo(FollowInfo info) {

    }

    @Override
    public void getunFollowInfo(FollowInfo info) {
        if (info != null && "success".equals(info.getState())) {
            mPresenter.getAttentionInfo(UserInfo.getUserId());
        }
    }
}
