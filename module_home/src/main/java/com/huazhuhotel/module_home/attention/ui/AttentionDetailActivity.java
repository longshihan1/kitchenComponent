package com.huazhuhotel.module_home.attention.ui;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.huazhuhotel.module_home.R;
import com.huazhuhotel.module_home.attention.adapter.AttentionDetailNoteAdapter;
import com.huazhuhotel.module_home.attention.adapter.AttentionDetailRecepAdapter;
import com.huazhuhotel.module_home.attention.persenter.AttentionDetailContract;
import com.huazhuhotel.module_home.attention.persenter.AttentionDetailPersenter;
import com.huazhuhotel.module_home.attention.persenter.FollowContract;
import com.huazhuhotel.module_home.attention.persenter.FollowPersenter;
import com.huazhuhotel.module_home.attention.widget.MyNestedScrollView;
import com.huazhuhotel.module_home.attention.widget.SpacesItemDecoration;
import com.huazhuhotel.module_home.detail.ui.GoodsDetailActivity;
import com.huazhuhotel.module_home.mvp.adapter.SimpleRecyclerAdapter;
import com.huazhuhotel.module_home.mvp.model.FollowInfo;
import com.huazhuhotel.module_home.mvp.model.UnRecipesListInfo;
import com.huazhuhotel.module_home.mvp.model.UserInfo;
import com.huazhuhotel.module_home.mvp.model.UserNoteInfo;
import com.huazhuhotel.module_home.utils.IntentContancts;
import com.longshihan.mvpcomponent.base.BaseMVPActivity;
import com.longshihan.mvpcomponent.di.component.AppComponent;
import com.longshihan.mvpcomponent.strategy.imageloader.glide.ImageConfigImpl;
import com.longshihan.mvpcomponent.utils.ArmsUtils;
import com.orhanobut.logger.Logger;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnLoadMoreListener;

public class AttentionDetailActivity extends BaseMVPActivity<AttentionDetailPersenter> implements AttentionDetailContract.View,
        View.OnClickListener, FollowContract.View {
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
    private MyNestedScrollView nestedScrollView;
    private LinearLayout contentTopView;
    private LinearLayout contentScendView;
    private FollowPersenter followPersenter;
    private TextView followTv;
    private int space;


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
            mUserAuthorlevel.setText("LV." + info.getResult().getUser().getLvl() + "");
        }
    }

    @Override
    public void getUnRecipesListInfo(UnRecipesListInfo info) {
        if (info != null && info.getResult() != null && info.getResult().getList() != null) {
            Logger.d(info);
            if (recipesPage==0) {
                recepAdapter.setListData(info.getResult().getList());
            }else {
                recepAdapter.appendListData(info.getResult().getList());
            }
        }
    }

    @Override
    public void getUserNoteListInfo(UserNoteInfo info) {
        if (info != null && info.getResult() != null && info.getResult().getList() != null) {
            Logger.d(info);
            if (notePage==0) {
                noteAdapter.setListData(info.getResult().getList());
            }else {
                noteAdapter.appendListData(info.getResult().getList());
            }
        }
    }

    @Override
    public void setupActivityComponent(AppComponent appComponent) {
        mPresenter = new AttentionDetailPersenter(this, appComponent.repositoryManager());
        followPersenter = new FollowPersenter(this, appComponent.repositoryManager());
    }

    @Override
    public int initView(Bundle savedInstanceState) {
        return R.layout.activity_attention_detail;

    }

    @Override
    public void initData() {
        userId = getIntent().getStringExtra(IntentContancts.USERID_VALUE);
        space = ArmsUtils.dip2px(this, 5);
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
        nestedScrollView = findViewById(R.id.user_bg_nestscroll);
        contentTopView = findViewById(R.id.user_bg_contentid);
        contentScendView = findViewById(R.id.user_author_secondlin);
        followTv = findViewById(R.id.user_authorfollow);
        followTv.setOnClickListener(this);

        mPresenter.getUserInfo(userId);
        mPresenter.getUnRecipesListInfo(userId, recipesPage);
        mPresenter.getUserNoteListInfo(userId, notePage);

        noteAdapter = new AttentionDetailNoteAdapter();
        recepAdapter = new AttentionDetailRecepAdapter();
        mUserAuthorRecyNote.setLayoutManager(new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL));
        mUserAuthorRecyCookbook.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        mUserAuthorRecyNote.setAdapter(noteAdapter);
        mUserAuthorRecyNote.addItemDecoration(new SpacesItemDecoration(2, space));
        mUserAuthorRecyCookbook.setAdapter(recepAdapter);
        mUserAuthorRecyNote.setNestedScrollingEnabled(false);
        mUserAuthorRecyCookbook.setNestedScrollingEnabled(false);

        noteAdapter.setOnItemClickListener(new SimpleRecyclerAdapter.OnItemClickListener<UserNoteInfo.ResultBean.ListBean>() {
            @Override
            public void onItemClick(UserNoteInfo.ResultBean.ListBean item, int index) {

            }
        });

        recepAdapter.setOnItemClickListener(new SimpleRecyclerAdapter.OnItemClickListener<UnRecipesListInfo.ResultBean.ListBean>() {
            @Override
            public void onItemClick(UnRecipesListInfo.ResultBean.ListBean item, int index) {
                Intent intent = new Intent(AttentionDetailActivity.this, GoodsDetailActivity.class);
                intent.putExtra(IntentContancts.GOODSDETAIL_VALUE, item.getR().getId() + "");
                startActivity(intent);
            }
        });
        final View rootView = findViewById(android.R.id.content);
        rootView.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
            @Override
            public void onGlobalLayout() {
                rootView.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                nestedScrollView.setMyScrollHeight(contentTopView.getHeight());
                nestedScrollView.scrollTo(0, contentTopView.getHeight());
                int rvNewHeight = rootView.getHeight() - contentScendView.getHeight();

                nestedScrollView.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, rvNewHeight));
            }
        });

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.user_author_tab1:
                mUserAuthorRecyCookbook.setVisibility(View.VISIBLE);
                mUserAuthorRecyNote.setVisibility(View.GONE);
                mUserAuthorTab1.setTextColor(getResources().getColor(R.color.black));
                mUserAuthorTab2.setTextColor(getResources().getColor(R.color.gray_7f));
                break;
            case R.id.user_author_tab2:
                mUserAuthorRecyCookbook.setVisibility(View.GONE);
                mUserAuthorRecyNote.setVisibility(View.VISIBLE);
                mUserAuthorTab1.setTextColor(getResources().getColor(R.color.gray_7f));
                mUserAuthorTab2.setTextColor(getResources().getColor(R.color.black));
                break;
            case R.id.user_authorfollow:
                if ("已关注".equals(followTv.getText().toString())) {
                    followTv.setText("未关注");
                    followTv.setBackgroundResource(R.drawable.bg_attention_nomsg);
                    followPersenter.getunFollowInfo(com.huazhuhotel.module_home.utils.UserInfo.getUserId(), userId);
                } else {
                    followTv.setText("已关注");
                    followTv.setBackgroundResource(R.drawable.bg_attention_msg);
                    followPersenter.getFollowInfo(com.huazhuhotel.module_home.utils.UserInfo.getUserId(), userId);
                }
                break;
        }
    }

    @Override
    public void getFollowInfo(FollowInfo info) {
        if (info != null && "success".equals(info.getState())) {
            //关注成功
            followTv.setText("已关注");
        }
    }

    @Override
    public void getunFollowInfo(FollowInfo info) {
        if (info != null && "success".equals(info.getState())) {
            //取消关注
            followTv.setText("未关注");
        }
    }
}
