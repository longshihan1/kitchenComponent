package com.huazhuhotel.module_home.detail.ui;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.huazhuhotel.module_home.R;
import com.huazhuhotel.module_home.detail.adapter.DetailFragmentPagerAdapter;
import com.huazhuhotel.module_home.detail.persenter.GoodsDetailContract;
import com.huazhuhotel.module_home.detail.persenter.GoodsDetailPersenter;
import com.huazhuhotel.module_home.detail.ui.fragment.CommunicateFragment;
import com.huazhuhotel.module_home.detail.ui.fragment.CookManagerFragment;
import com.huazhuhotel.module_home.detail.ui.fragment.GoodsDetailFragment;
import com.huazhuhotel.module_home.mvp.model.GoodsDetailInfo;
import com.huazhuhotel.module_home.utils.IntentContancts;
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
    private ViewPager mViewpage;

    private CommunicateFragment communicateFragment;
    private CookManagerFragment cookManagerFragment;
    private GoodsDetailFragment goodsDetailFragment;
    private List<Fragment> fragmentList;
    private int index = -1;
    private FragmentManager fragmentManager;
    private int goodsId;
    DetailFragmentPagerAdapter pagerAdapter;


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
        if (info != null && info.getResult() != null &&
                "success".equals(info.getState()) && info.getResult().getRecipe() != null) {
            communicateFragment.setData(info.getResult().getRecipe());
            cookManagerFragment.setData(info.getResult().getRecipe());
            goodsDetailFragment.setData(info.getResult().getRecipe());
        } else {
            Toast.makeText(this, "未查询到菜谱", Toast.LENGTH_SHORT).show();
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
        goodsId = getIntent().getIntExtra(IntentContancts.GOODSDETAIL_VALUE, 0);
        Logger.d(goodsId+"");
        mGoodsdetailTypeFirsttv = (TextView) findViewById(R.id.goodsdetail_type_firsttv);
        mGoodsdetailTypeFirsttv.setOnClickListener(this);
        mGoodsdetailTypeFirstline = (View) findViewById(R.id.goodsdetail_type_firstline);
        mGoodsdetailTypeSecondtv = (TextView) findViewById(R.id.goodsdetail_type_secondtv);
        mGoodsdetailTypeSecondtv.setOnClickListener(this);
        mGoodsdetailTypeSecondline = (View) findViewById(R.id.goodsdetail_type_secondline);
        mGoodsdetailTypeThridtv = (TextView) findViewById(R.id.goodsdetail_type_thridtv);
        mGoodsdetailTypeThridtv.setOnClickListener(this);
        mGoodsdetailTypeThridline = (View) findViewById(R.id.goodsdetail_type_thridline);
        mViewpage =  findViewById(R.id.goodsdetail_viewpage);

        communicateFragment = new CommunicateFragment();
        cookManagerFragment = new CookManagerFragment();
        goodsDetailFragment = new GoodsDetailFragment();

        fragmentList = new ArrayList<>();
        fragmentList.add(goodsDetailFragment);
        fragmentList.add(cookManagerFragment);
        fragmentList.add(communicateFragment);
        fragmentManager = getSupportFragmentManager();
        pagerAdapter=new DetailFragmentPagerAdapter(fragmentManager,fragmentList);
        mViewpage.setAdapter(pagerAdapter);
        mViewpage.setCurrentItem(0);
        mPresenter.getGoodsDetailInfo(goodsId);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.goodsdetail_type_firsttv:
                mViewpage.setCurrentItem(0);
                mGoodsdetailTypeFirstline.setVisibility(View.VISIBLE);
                mGoodsdetailTypeSecondline.setVisibility(View.GONE);
                mGoodsdetailTypeThridline.setVisibility(View.GONE);
                break;
            case R.id.goodsdetail_type_secondtv:
                mViewpage.setCurrentItem(1);
                mGoodsdetailTypeFirstline.setVisibility(View.GONE);
                mGoodsdetailTypeSecondline.setVisibility(View.VISIBLE);
                mGoodsdetailTypeThridline.setVisibility(View.GONE);
                break;
            case R.id.goodsdetail_type_thridtv:
                mViewpage.setCurrentItem(2);
                mGoodsdetailTypeFirstline.setVisibility(View.GONE);
                mGoodsdetailTypeSecondline.setVisibility(View.GONE);
                mGoodsdetailTypeThridline.setVisibility(View.VISIBLE);
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
