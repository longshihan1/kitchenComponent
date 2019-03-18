package com.huazhuhotel.module_home.attention.ui;

import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.huazhuhotel.module_home.R;
import com.huazhuhotel.module_home.attention.adapter.AttentionDetailNoteAdapter;
import com.huazhuhotel.module_home.attention.adapter.AttentionDetailRecepAdapter;
import com.huazhuhotel.module_home.attention.persenter.AttentionDetailContract;
import com.huazhuhotel.module_home.attention.persenter.AttentionDetailPersenter;
import com.huazhuhotel.module_home.mvp.model.UnRecipesListInfo;
import com.huazhuhotel.module_home.mvp.model.UserInfo;
import com.huazhuhotel.module_home.mvp.model.UserNoteInfo;
import com.huazhuhotel.module_home.utils.IntentContancts;
import com.longshihan.mvpcomponent.base.BaseMVPActivity;
import com.longshihan.mvpcomponent.di.component.AppComponent;
import com.longshihan.mvpcomponent.strategy.imageloader.glide.ImageConfigImpl;
import com.longshihan.mvpcomponent.utils.ArmsUtils;
import com.orhanobut.logger.Logger;

public class AttentionDetailActivity extends BaseMVPActivity<AttentionDetailPersenter> implements AttentionDetailContract.View, View.OnClickListener {
    private String userId;
    private int recipesPage = 0, notePage = 0;
    private ImageView mUserBgImg;
    private ImageView mUserAuthorimg;
    private TextView mUserAuthorname;
    private TextView mUserAuthorlevel;
    private LinearLayout mUserAuthorlin;
    private TextView mUserAuthorwork;
    private TextView mUserAuthorage;
    private TextView mUserAuthoraddress;
    private LinearLayout mUserAuthormsg;
    private TextView mUserAuthorFocustv;
    private TextView mUserAuthorLovetv;
    private TextView mUserAuthorExperiencetv;
    /**
     * 菜谱
     */
    private TextView mUserAuthorTab1;
    /**
     * 笔记
     */
    private TextView mUserAuthorTab2;
    private RecyclerView mUserAuthorRecyCookbook;
    private RecyclerView mUserAuthorRecyNote;
    private AttentionDetailRecepAdapter recepAdapter;
    private AttentionDetailNoteAdapter noteAdapter;


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
    public void getUserInfo(UserInfo info) {
        if (info != null && info.getResult() != null && info.getResult().getUser() != null) {
            Logger.d(info);
            mUserAuthoraddress.setText(info.getResult().getUser().getLocation());
            mUserAuthorage.setText(info.getResult().getUser().getAge());
            mUserAuthorExperiencetv.setText(info.getResult().getUser().getPoint());
            mUserAuthorFocustv.setText(info.getResult().getUser().getFavorites_count() + "");
            mUserAuthorLovetv.setText(info.getResult().getUser().getFollowers_count());

            ArmsUtils.getImageLoader(this)
                    .loadImage(this, ImageConfigImpl.builder()
                            .url(info.getResult().getUser().getUser_photo())
                            .imageView(mUserAuthorimg)
                            .build());
            ArmsUtils.getImageLoader(this)
                    .loadImage(this, ImageConfigImpl.builder()
                            .url(info.getResult().getUser().getAvatar_medium())
                            .imageView(mUserBgImg)
                            .build());
            mUserAuthorname.setText(info.getResult().getUser().getNick());
            mUserAuthorwork.setText(info.getResult().getUser().getProfession());
            mUserAuthorlevel.setText(info.getResult().getUser().getLvl() + "");
        }
    }

    @Override
    public void getUnRecipesListInfo(UnRecipesListInfo info) {
        if (info != null && info.getResult() != null && info.getResult().getList() != null) {
            Logger.d(info);
            recepAdapter.setListData(info.getResult().getList());
        }
    }

    @Override
    public void getUserNoteListInfo(UserNoteInfo info) {
        if (info != null && info.getResult() != null && info.getResult().getList() != null) {
            Logger.d(info);
            noteAdapter.setListData(info.getResult().getList());
        }
    }

    @Override
    public void setupActivityComponent(AppComponent appComponent) {
        mPresenter = new AttentionDetailPersenter(this, appComponent.repositoryManager());
    }

    @Override
    public int initView(Bundle savedInstanceState) {
        return R.layout.activity_attention_detail;

    }

    @Override
    public void initData() {
        userId = getIntent().getStringExtra(IntentContancts.USERID_VALUE);

        mUserBgImg = (ImageView) findViewById(R.id.user_bg_img);
        mUserAuthorimg = (ImageView) findViewById(R.id.user_authorimg);
        mUserAuthorname = (TextView) findViewById(R.id.user_authorname);
        mUserAuthorlevel = (TextView) findViewById(R.id.user_authorlevel);
        mUserAuthorlin = (LinearLayout) findViewById(R.id.user_authorlin);
        mUserAuthorwork = (TextView) findViewById(R.id.user_authorwork);
        mUserAuthorage = (TextView) findViewById(R.id.user_authorage);
        mUserAuthoraddress = (TextView) findViewById(R.id.user_authoraddress);
        mUserAuthormsg = (LinearLayout) findViewById(R.id.user_authormsg);
        mUserAuthorFocustv = (TextView) findViewById(R.id.user_author_focustv);
        mUserAuthorLovetv = (TextView) findViewById(R.id.user_author_lovetv);
        mUserAuthorExperiencetv = (TextView) findViewById(R.id.user_author_experiencetv);
        mUserAuthorTab1 = (TextView) findViewById(R.id.user_author_tab1);
        mUserAuthorTab1.setOnClickListener(this);
        mUserAuthorTab2 = (TextView) findViewById(R.id.user_author_tab2);
        mUserAuthorTab2.setOnClickListener(this);
        mUserAuthorRecyCookbook = (RecyclerView) findViewById(R.id.user_author_recy_cookbook);
        mUserAuthorRecyNote = (RecyclerView) findViewById(R.id.user_author_recy_note);

        mPresenter.getUserInfo(userId);
        mPresenter.getUnRecipesListInfo(userId, recipesPage);
        mPresenter.getUserNoteListInfo(userId, notePage);

        noteAdapter = new AttentionDetailNoteAdapter();
        recepAdapter = new AttentionDetailRecepAdapter();
        mUserAuthorRecyNote.setLayoutManager(new GridLayoutManager(this, 2,LinearLayoutManager.VERTICAL,false));
        mUserAuthorRecyCookbook.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        mUserAuthorRecyNote.setAdapter(noteAdapter);
        mUserAuthorRecyCookbook.setAdapter(recepAdapter);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.user_author_tab1:
                mUserAuthorRecyCookbook.setVisibility(View.VISIBLE);
                mUserAuthorRecyNote.setVisibility(View.GONE);
                break;
            case R.id.user_author_tab2:
                mUserAuthorRecyCookbook.setVisibility(View.GONE);
                mUserAuthorRecyNote.setVisibility(View.VISIBLE);
                break;
        }
    }

}
