package com.huazhuhotel.module_home.collect.adapter.viewholder;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.huazhuhotel.module_home.R;
import com.huazhuhotel.module_home.collect.adapter.CollectionListAdapter;
import com.huazhuhotel.module_home.list.adapter.SearchListAdapter;
import com.huazhuhotel.module_home.mvp.adapter.SimpleViewHolder;
import com.huazhuhotel.module_home.mvp.model.CollectionInfo;
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

public class CollectViewHolder extends SimpleViewHolder<CollectionInfo.ResultBean.RecipesBean> {
    private Context context;

    public CollectViewHolder(View view, CollectionListAdapter adapter) {
        super(view, adapter);
        context = view.getContext();

    }

    @Override
    protected void refreshView(CollectionInfo.ResultBean.RecipesBean data1) {
        super.refreshView(data1);

//        ArmsUtils.getImageLoader(context)
//                .loadImage(context, ImageConfigImpl.builder()
//                        .url(data1.getImage())
//                        .imageView(mItemSearchImg)
//                        .build());
    }

}
