package com.huazhuhotel.module_home.main.adapter.viewholder;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.huazhuhotel.module_home.R;
import com.huazhuhotel.module_home.mvp.model.HomeInfo;
import com.huazhuhotel.module_home.mvp.model.SearchInfo;
import com.longshihan.mvpcomponent.base.adapter.BaseHolder;
import com.longshihan.mvpcomponent.strategy.imageloader.glide.GlideImageLoaderStrategy;
import com.longshihan.mvpcomponent.strategy.imageloader.glide.GlideRequest;
import com.longshihan.mvpcomponent.strategy.imageloader.glide.ImageConfigImpl;
import com.longshihan.mvpcomponent.utils.ArmsUtils;

/**
 * Created by LONGHE001.
 *
 * @time 2019/2/27 0027
 * @des
 * @function
 */

public class HomeRecyViewHolder extends BaseHolder<SearchInfo.ResultBean.ListBean> {
    ImageView mItemHomerecyImg;
    TextView mItemHomerecyName;
    TextView mItemHomerecyManagertv;
    ImageView mItemHomerecyLikeimg;
    TextView mItemHomerecyLikename;
    ImageView mItemHomerecyAuthorimg;
    public HomeRecyViewHolder(View itemView) {
        super(itemView);
        this.mItemHomerecyImg = (ImageView) itemView.findViewById(R.id.item_homerecy_img);
        this.mItemHomerecyName = (TextView) itemView.findViewById(R.id.item_homerecy_name);
        this.mItemHomerecyManagertv = (TextView) itemView.findViewById(R.id.item_homerecy_authortv);
        this.mItemHomerecyLikeimg = (ImageView) itemView.findViewById(R.id.item_homerecy_likeimg);
        this.mItemHomerecyLikename = (TextView) itemView.findViewById(R.id.item_homerecy_likename);
        mItemHomerecyAuthorimg=itemView.findViewById(R.id.item_homerecy_authorimg);
    }

    @Override
    public void bindHolder(SearchInfo.ResultBean.ListBean data, int position, Context mContext) {
        if (data.getR()!=null) {
            mItemHomerecyName.setText(data.getR().getN());
            ArmsUtils.getImageLoader(mContext)
                    .loadImage(mContext, ImageConfigImpl.builder()
                            .url(data.getR().getImg())
                            .imageView(mItemHomerecyImg)
                            .build());
            if (data.getR().getA() != null) {
                mItemHomerecyManagertv.setText(data.getR().getA().getN());
                ArmsUtils.getImageLoader(mContext)
                        .loadImage(mContext, ImageConfigImpl.builder()
                                .url(data.getR().getA().getP())
                                .imageView(mItemHomerecyAuthorimg)
                                .build());
            }
            mItemHomerecyLikename.setText(data.getR().getVc()+"");
        }
    }
}
