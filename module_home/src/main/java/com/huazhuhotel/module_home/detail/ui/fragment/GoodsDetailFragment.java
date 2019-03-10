package com.huazhuhotel.module_home.detail.ui.fragment;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.Html;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.huazhuhotel.module_home.R;
import com.huazhuhotel.module_home.mvp.model.GoodsDetailInfo;
import com.huazhuhotel.module_home.widget.GoodsDetailCookItemView;
import com.huazhuhotel.module_home.widget.LineFlowLayout;
import com.longshihan.mvpcomponent.base.BaseFragment;
import com.longshihan.mvpcomponent.base.BaseMVPFragment;
import com.longshihan.mvpcomponent.base.EmptyPersienter;
import com.longshihan.mvpcomponent.di.component.AppComponent;
import com.longshihan.mvpcomponent.strategy.imageloader.glide.ImageConfigImpl;
import com.longshihan.mvpcomponent.utils.ArmsUtils;

/**
 * 商品的配方详情
 */
public class GoodsDetailFragment extends BaseMVPFragment {


    private GoodsDetailInfo.ResultBean.RecipeBean data;
    private ImageView mGoodsdetailDetailImg;
    private TextView mGoodsdetailDetailName;
    private TextView mGoodsdetailDetailLooktv;
    private LineFlowLayout mGoodsdetailDetailFlow;
    private ImageView mGoodsdetailDetailAuthorimg;
    private TextView mGoodsdetailDetailAuthorname,ideaTv;
    private LinearLayout mGoodsdetailDetailList,ideaLin;
    private TextView mGoodsdetailDetailTip;
    private LinearLayout.LayoutParams layoutParams;

    public GoodsDetailFragment() {
    }



    @Override
    public View initView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_goods_detail, container, false);
    }

    @Override
    public void initData(Bundle savedInstanceState) {
        mGoodsdetailDetailImg =  mRootview.findViewById(R.id.goodsdetail_detail_img);
        mGoodsdetailDetailName = (TextView) mRootview.findViewById(R.id.goodsdetail_detail_name);
        mGoodsdetailDetailLooktv = (TextView) mRootview.findViewById(R.id.goodsdetail_detail_looktv);
        mGoodsdetailDetailFlow = (LineFlowLayout) mRootview.findViewById(R.id.goodsdetail_detail_flow);
        mGoodsdetailDetailAuthorimg = (ImageView) mRootview.findViewById(R.id.goodsdetail_detail_authorimg);
        mGoodsdetailDetailAuthorname = (TextView) mRootview.findViewById(R.id.goodsdetail_detail_authorname);
        mGoodsdetailDetailList = (LinearLayout) mRootview.findViewById(R.id.goodsdetail_detail_list);
        mGoodsdetailDetailTip = (TextView) mRootview.findViewById(R.id.goodsdetail_detail_tip);
        ideaLin=mRootview.findViewById(R.id.goodsdetail_detail_lin);
        ideaTv=mRootview.findViewById(R.id.goodsdetail_detail_idea);
        layoutParams=new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
    }
    @Override
    public void setupFragmentComponent(AppComponent appComponent) {
        mPresenter=new EmptyPersienter();
    }

    public void setData(GoodsDetailInfo.ResultBean.RecipeBean data) {
        this.data = data;
        ArmsUtils.getImageLoader(mActivity)
                .loadImage(mActivity, ImageConfigImpl.builder()
                        .url(data.getImage())
                        .imageView(mGoodsdetailDetailImg)
                        .build());
        mGoodsdetailDetailName.setText(data.getTitle());
        mGoodsdetailDetailLooktv.setText(data.getFavo_counts()+"人想做   "+data.getRecommendation_tag());
        if (data.getUser()!=null) {
            ArmsUtils.getImageLoader(mActivity)
                    .loadImage(mActivity, ImageConfigImpl.builder()
                            .url(data.getUser().getUser_photo())
                            .imageView(mGoodsdetailDetailAuthorimg)
                            .build());
            mGoodsdetailDetailAuthorname.setText(data.getUser().getNick());
        }
        if (data.getMajor()!=null){
            mGoodsdetailDetailList.removeAllViews();
            for (int i = 0; i <data.getMajor().size(); i++) {
                if (data.getMajor().get(i)!=null) {
                    GoodsDetailCookItemView cookItemView = new GoodsDetailCookItemView(mActivity);
                    cookItemView.setLayoutParams(layoutParams);
                    cookItemView.setData(data.getMajor().get(i).getTitle(), data.getMajor().get(i).getNote(), data.getMajor().get(i).getTu());
                    mGoodsdetailDetailList.addView(cookItemView);
                }
            }
        }
        mGoodsdetailDetailTip.setText(Html.fromHtml(data.getTips()));
        if (!TextUtils.isEmpty(data.getCookstory())){
            ideaTv.setText(data.getCookstory());
            ideaLin.setVisibility(View.VISIBLE);
        }else {
            ideaLin.setVisibility(View.GONE);
        }



    }

    public void restoreData() {
        setData(data);
    }
}
