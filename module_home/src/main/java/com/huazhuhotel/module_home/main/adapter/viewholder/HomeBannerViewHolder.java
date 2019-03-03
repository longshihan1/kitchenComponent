package com.huazhuhotel.module_home.main.adapter.viewholder;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.huazhuhotel.module_home.R;
import com.huazhuhotel.module_home.mvp.model.HomeInfo;
import com.longshihan.mvpcomponent.base.adapter.BaseHolder;
import com.longshihan.mvpcomponent.strategy.imageloader.glide.ImageConfigImpl;
import com.longshihan.mvpcomponent.utils.ArmsUtils;

/**
 * Created by LONGHE001.
 *
 * @time 2019/2/27 0027
 * @des
 * @function
 */

public class HomeBannerViewHolder extends BaseHolder<HomeInfo.ResultBean.HeaderBean.TrsBean> {
    ImageView mItemHomerecyImg;
    public HomeBannerViewHolder(View itemView) {
        super(itemView);
        this.mItemHomerecyImg = (ImageView) itemView.findViewById(R.id.item_homebanner_img);
    }

    @Override
    public void bindHolder(HomeInfo.ResultBean.HeaderBean.TrsBean data, int position, Context mContext) {
        if (data.getB()!=null) {
            ArmsUtils.getImageLoader(mContext)
                    .loadImage(mContext, ImageConfigImpl.builder()
                            .url(data.getB().getI())
                            .imageView(mItemHomerecyImg)
                            .build());
        }
    }
}
