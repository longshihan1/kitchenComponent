package com.huazhuhotel.module_home.detail.ui;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.huazhuhotel.module_home.R;
import com.huazhuhotel.module_home.detail.adapter.DetailFragmentPagerAdapter;
import com.huazhuhotel.module_home.detail.persenter.GoodsDetailContract;
import com.huazhuhotel.module_home.detail.persenter.GoodsDetailPersenter;
import com.huazhuhotel.module_home.detail.ui.fragment.CommunicateFragment;
import com.huazhuhotel.module_home.detail.ui.fragment.CookManagerFragment;
import com.huazhuhotel.module_home.detail.ui.fragment.GoodsDetailFragment;
import com.huazhuhotel.module_home.detail.ui.fragment.ReCommendCookFragment;
import com.huazhuhotel.module_home.mvp.model.CommentListInfo;
import com.huazhuhotel.module_home.mvp.model.GoodsDetailInfo;
import com.huazhuhotel.module_home.mvp.model.ReCommondInfo;
import com.huazhuhotel.module_home.utils.IntentContancts;
import com.huazhuhotel.module_home.utils.UserInfo;
import com.longshihan.mvpcomponent.base.BaseMVPActivity;
import com.longshihan.mvpcomponent.di.component.AppComponent;
import com.orhanobut.logger.Logger;

import java.util.ArrayList;
import java.util.List;

public class GoodsDetailActivity extends BaseMVPActivity<GoodsDetailPersenter> implements GoodsDetailContract.View, View.OnClickListener {


    /**
     * 配方
     */
    private TextView mGoodsdetailTypeFirsttv;
    private View mGoodsdetailTypeFirstline;
    /**
     * 做法
     */
    private TextView mGoodsdetailTypeSecondtv;
    private View mGoodsdetailTypeSecondline;
    /**
     * 交流
     */
    private TextView mGoodsdetailTypeThridtv;
    private View mGoodsdetailTypeThridline;
    /**
     * 推荐
     */
    private TextView mGoodsdetailTypeFiretv;
    private View mGoodsdetailTypeFireline;
    private ViewPager mViewpage;

    private CommunicateFragment communicateFragment;
    private CookManagerFragment cookManagerFragment;
    private GoodsDetailFragment goodsDetailFragment;
    private ReCommendCookFragment reCommendCookFragment;
    private List<Fragment> fragmentList;
    private int index = -1;
    private FragmentManager fragmentManager;
    private String goodsId;
    DetailFragmentPagerAdapter pagerAdapter;
    private GoodsDetailInfo info;
    private int pageIndex=0;
    private boolean isAttention=false;


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
    public void getGoodsDetailInfo(GoodsDetailInfo info) {
        this.info=info;
        if (info != null && info.getResult() != null &&
                "success".equals(info.getState()) && info.getResult().getRecipe() != null) {
            cookManagerFragment.setData(info.getResult().getRecipe());
            goodsDetailFragment.setData(info.getResult().getRecipe());
            isAttention=info.getResult().getRecipe().getCollect_status()==1;
        } else {
            Toast.makeText(this, "未查询到菜谱", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void getRecommondInfo(ReCommondInfo info) {
        if (info != null && info.getResult() != null &&
                "success".equals(info.getState()) && info.getResult().getList() != null) {
            reCommendCookFragment.setData(info.getResult().getList());
        }
    }

    @Override
    public void getCommentList(CommentListInfo info) {
    }

    @Override
    public void onCollection(int isOk) {
        if (isOk==1){//收藏成功
            isAttention=true;
            goodsDetailFragment.refreshCollect(true);
        }else if (isOk==2){//取消收藏成功
            isAttention=false;
            goodsDetailFragment.refreshCollect(false);
        }

    }

    @Override
    public void setupActivityComponent(AppComponent appComponent) {
        mPresenter = new GoodsDetailPersenter(this, appComponent.repositoryManager());
    }

    @Override
    public int initView(Bundle savedInstanceState) {
        return R.layout.activity_goods_detail;

    }

    @Override
    public void initData() {
        goodsId = getIntent().getStringExtra(IntentContancts.GOODSDETAIL_VALUE);
        Logger.d(goodsId + "");
        mGoodsdetailTypeFirsttv = (TextView) findViewById(R.id.goodsdetail_type_firsttv);
        mGoodsdetailTypeFirsttv.setOnClickListener(this);
        mGoodsdetailTypeFirstline = (View) findViewById(R.id.goodsdetail_type_firstline);
        mGoodsdetailTypeSecondtv = (TextView) findViewById(R.id.goodsdetail_type_secondtv);
        mGoodsdetailTypeSecondtv.setOnClickListener(this);
        mGoodsdetailTypeSecondline = (View) findViewById(R.id.goodsdetail_type_secondline);
        mGoodsdetailTypeThridtv = (TextView) findViewById(R.id.goodsdetail_type_thridtv);
        mGoodsdetailTypeThridtv.setOnClickListener(this);
        mGoodsdetailTypeThridline = (View) findViewById(R.id.goodsdetail_type_thridline);
        mViewpage = findViewById(R.id.goodsdetail_viewpage);
        mGoodsdetailTypeFiretv = findViewById(R.id.goodsdetail_type_firetv);
        mGoodsdetailTypeFireline = findViewById(R.id.goodsdetail_type_fireline);
        mGoodsdetailTypeFiretv.setOnClickListener(this);

        communicateFragment = new CommunicateFragment();
        cookManagerFragment = new CookManagerFragment();
        goodsDetailFragment = new GoodsDetailFragment();
        reCommendCookFragment = new ReCommendCookFragment();

        fragmentList = new ArrayList<>();
        fragmentList.add(goodsDetailFragment);
        fragmentList.add(cookManagerFragment);
        fragmentList.add(communicateFragment);
        fragmentList.add(reCommendCookFragment);
        fragmentManager = getSupportFragmentManager();
        pagerAdapter = new DetailFragmentPagerAdapter(fragmentManager, fragmentList);
        mViewpage.setAdapter(pagerAdapter);
        mViewpage.setCurrentItem(0);
        mPresenter.getGoodsDetailInfo(goodsId);
        mPresenter.getRecommendInfo(goodsId);
        communicateFragment.setGoodsId(goodsId);
//        mPresenter.getCommentList(goodsId+"",pageIndex);
        mViewpage.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                if (position == 0) {
                    goodsDetailFragment.restoreData();
                    mGoodsdetailTypeFirstline.setVisibility(View.VISIBLE);
                    mGoodsdetailTypeSecondline.setVisibility(View.GONE);
                    mGoodsdetailTypeThridline.setVisibility(View.GONE);
                    mGoodsdetailTypeFireline.setVisibility(View.GONE);
                } else if (position == 1) {
                    cookManagerFragment.restoreData();
                    mGoodsdetailTypeFirstline.setVisibility(View.GONE);
                    mGoodsdetailTypeSecondline.setVisibility(View.VISIBLE);
                    mGoodsdetailTypeThridline.setVisibility(View.GONE);
                    mGoodsdetailTypeFireline.setVisibility(View.GONE);
                } else if (position == 2) {
                    mGoodsdetailTypeFirstline.setVisibility(View.GONE);
                    mGoodsdetailTypeSecondline.setVisibility(View.GONE);
                    mGoodsdetailTypeThridline.setVisibility(View.VISIBLE);
                    mGoodsdetailTypeFireline.setVisibility(View.GONE);
                } else if (position == 3) {
                    reCommendCookFragment.restoreData();
                    mGoodsdetailTypeFirstline.setVisibility(View.GONE);
                    mGoodsdetailTypeSecondline.setVisibility(View.GONE);
                    mGoodsdetailTypeThridline.setVisibility(View.GONE);
                    mGoodsdetailTypeFireline.setVisibility(View.VISIBLE);
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

        goodsDetailFragment.setClickStepListener(new GoodsDetailFragment.OnClickStepListener() {
            @Override
            public void onCollectionClick() {
                if (TextUtils.isEmpty(com.huazhuhotel.module_home.utils.UserInfo.getUserId())) {
                    Toast.makeText(GoodsDetailActivity.this, "暂未登陆", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (!isAttention) {
                    mPresenter.onCollection(isAttention, goodsId, UserInfo.getUserId());
                }else {
                    goodsDetailFragment.refreshCollect(false);
                }
            }

            @Override
            public void onGoCommentClick() {
                onClick(mGoodsdetailTypeThridtv);
            }
        });
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.goodsdetail_type_firsttv:
                mViewpage.setCurrentItem(0);
                mGoodsdetailTypeFirstline.setVisibility(View.VISIBLE);
                mGoodsdetailTypeSecondline.setVisibility(View.GONE);
                mGoodsdetailTypeThridline.setVisibility(View.GONE);
                mGoodsdetailTypeFireline.setVisibility(View.GONE);
                break;
            case R.id.goodsdetail_type_secondtv:
                mViewpage.setCurrentItem(1);
                mGoodsdetailTypeFirstline.setVisibility(View.GONE);
                mGoodsdetailTypeSecondline.setVisibility(View.VISIBLE);
                mGoodsdetailTypeThridline.setVisibility(View.GONE);
                mGoodsdetailTypeFireline.setVisibility(View.GONE);
                break;
            case R.id.goodsdetail_type_thridtv:
                mViewpage.setCurrentItem(2);
                mGoodsdetailTypeFirstline.setVisibility(View.GONE);
                mGoodsdetailTypeSecondline.setVisibility(View.GONE);
                mGoodsdetailTypeThridline.setVisibility(View.VISIBLE);
                mGoodsdetailTypeFireline.setVisibility(View.GONE);
                break;
            case R.id.goodsdetail_type_firetv:
                mViewpage.setCurrentItem(3);
                mGoodsdetailTypeFirstline.setVisibility(View.GONE);
                mGoodsdetailTypeSecondline.setVisibility(View.GONE);
                mGoodsdetailTypeThridline.setVisibility(View.GONE);
                mGoodsdetailTypeFireline.setVisibility(View.VISIBLE);
                break;
            default:
                break;
        }
    }

    @Override
    public boolean useFragment() {
        return true;
    }

}
