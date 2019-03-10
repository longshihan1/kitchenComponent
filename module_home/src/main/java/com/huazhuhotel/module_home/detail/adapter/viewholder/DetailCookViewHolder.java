package com.huazhuhotel.module_home.detail.adapter.viewholder;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

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
    ImageView mItemSearchImg;
    TextView mItemSearchName;
    TextView mItemSearchMaterial;
    TextView mItemSearchAuthor;
    TextView mItemSearchPerson;
    TextView rateTv;
    private Context context;
    public DetailCookViewHolder(View view, DetailCookAdapter adapter) {
        super(view,adapter);
        context=view.getContext();
    }

    @Override
    protected void refreshView(GoodsDetailInfo.ResultBean.RecipeBean.CookstepBean data1) {
        super.refreshView(data1);

    }
}
