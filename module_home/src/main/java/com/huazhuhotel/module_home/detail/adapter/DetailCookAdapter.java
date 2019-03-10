package com.huazhuhotel.module_home.detail.adapter;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.huazhuhotel.module_home.R;
import com.huazhuhotel.module_home.detail.adapter.viewholder.DetailCookViewHolder;
import com.huazhuhotel.module_home.list.adapter.viewholder.SearchListViewHolder;
import com.huazhuhotel.module_home.mvp.adapter.SimpleRecyclerAdapter;
import com.huazhuhotel.module_home.mvp.adapter.SimpleViewHolder;
import com.huazhuhotel.module_home.mvp.model.GoodsDetailInfo;
import com.huazhuhotel.module_home.mvp.model.SearchInfo;

/**
 * Created by LONGHE001.
 *
 * @time 2019/3/10 0010
 * @des
 * @function
 */

public class DetailCookAdapter extends SimpleRecyclerAdapter<GoodsDetailInfo.ResultBean.RecipeBean.CookstepBean> {
    @Override
    public SimpleViewHolder<GoodsDetailInfo.ResultBean.RecipeBean.CookstepBean> onCreateViewHolder(ViewGroup parent, int viewType) {
        return new DetailCookViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_searchitem, parent, false),this);

    }
}
