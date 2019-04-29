package com.huazhuhotel.module_home.detail.adapter.viewholder;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.RequestOptions;
import com.huazhuhotel.module_home.R;
import com.huazhuhotel.module_home.detail.adapter.DetailCookAdapter;
import com.huazhuhotel.module_home.list.adapter.SearchListAdapter;
import com.huazhuhotel.module_home.mvp.adapter.SimpleViewHolder;
import com.huazhuhotel.module_home.mvp.model.GoodsDetailInfo;
import com.huazhuhotel.module_home.mvp.model.SearchInfo;
import com.longshihan.mvpcomponent.strategy.imageloader.glide.ImageConfigImpl;
import com.longshihan.mvpcomponent.utils.ArmsUtils;

import java.math.BigDecimal;

/**
 * Created by LONGHE001.
 *
 * @time 2019/3/5 0005
 * @des
 * @function
 */

public class DetailCookViewHolder extends SimpleViewHolder<GoodsDetailInfo.ResultBean.RecipeBean.CookstepBean> {
    private Context context;
    private TextView stepTv, desTv;
    private ImageView imageView;
    RequestOptions options;

    public DetailCookViewHolder(View view, DetailCookAdapter adapter) {
        super(view, adapter);
        context = view.getContext();
        stepTv = view.findViewById(R.id.item_detail_cooksteptv);
        desTv = view.findViewById(R.id.item_detail_cookstepdes);
        imageView = view.findViewById(R.id.item_detail_cookstepimg);
        options = new RequestOptions()
                .dontAnimate()
                .dontTransform()
                .override(ArmsUtils.getScreenWidth(context),ArmsUtils.dip2px(context,200))
                .centerCrop()
                .diskCacheStrategy(DiskCacheStrategy.ALL);
    }

    @Override
    protected void refreshView(GoodsDetailInfo.ResultBean.RecipeBean.CookstepBean data1) {
        super.refreshView(data1);
        desTv.setText(data1.getContent());
        stepTv.setText("步骤" + data1.getPosition() + "/" + adapter.getItemCount());
        Glide.with(context).load(data1.getImage())
                .apply(options)
                .into(imageView);
//        ArmsUtils.getImageLoader(context)
//                .loadImage(context, ImageConfigImpl.builder()
//                        .url(data1.getImage())
//                        .cacheStrategy(0)
//                        .imageView(imageView)
//                        .build());
    }
}
