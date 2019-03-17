package com.huazhuhotel.module_home.attention.ui;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.View;

import com.huazhuhotel.module_home.R;
import com.huazhuhotel.module_home.attention.adapter.AttentionAdapter;
import com.huazhuhotel.module_home.attention.persenter.AttentionContract;
import com.huazhuhotel.module_home.attention.persenter.AttentionPersenter;
import com.huazhuhotel.module_home.mvp.adapter.SimpleRecyclerAdapter;
import com.huazhuhotel.module_home.mvp.model.AttentionInfo;
import com.huazhuhotel.module_home.utils.IntentContancts;
import com.longshihan.mvpcomponent.base.BaseMVPActivity;
import com.longshihan.mvpcomponent.di.component.AppComponent;

public class AttentionActivity extends BaseMVPActivity<AttentionPersenter> implements AttentionContract.View, View.OnClickListener {

private RecyclerView recyclerView;
private AttentionAdapter attentionAdapter;

    @Override
    public void onClick(View v) {

    }

    @Override
    public void getAtentionInfo(AttentionInfo info) {
        if (info!=null&&info.getResult()!=null&&info.getResult().getFollows()!=null){
            attentionAdapter.setListData(info.getResult().getFollows());
        }

    }

    @Override
    public void setupActivityComponent(AppComponent appComponent) {
        mPresenter=new AttentionPersenter(this,appComponent.repositoryManager());

    }

    @Override
    public int initView(Bundle savedInstanceState) {
        return R.layout.activity_attention;
    }

    @Override
    public void initData() {
        recyclerView=findViewById(R.id.attention_recy);
        attentionAdapter=new AttentionAdapter();
        recyclerView.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));
        recyclerView.setAdapter(attentionAdapter);
        mPresenter.getAttentionInfo("23177077");
        attentionAdapter.setOnItemClickListener(new SimpleRecyclerAdapter.OnItemClickListener<AttentionInfo.ResultBean.FollowsBean>() {
            @Override
            public void onItemClick(AttentionInfo.ResultBean.FollowsBean item, int index) {
                if (item!=null&&!TextUtils.isEmpty(item.getUser_id())){
                    Intent intent=new Intent(AttentionActivity.this,AttentionDetailActivity.class);
                    intent.putExtra(IntentContancts.USERID_VALUE,item.getUser_id());
                    startActivity(intent);
                }
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
}
