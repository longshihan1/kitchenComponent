package com.huazhuhotel.module_home.detail.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.huazhuhotel.module_home.R;
import com.huazhuhotel.module_home.detail.adapter.viewholder.DetailCommunicateViewHolder;
import com.huazhuhotel.module_home.mvp.adapter.SimpleRecyclerAdapter;
import com.huazhuhotel.module_home.mvp.adapter.SimpleViewHolder;
import com.huazhuhotel.module_home.mvp.model.GoodsDetailInfo;

/**
 * Created by LONGHE001.
 *
 * @time 2019/3/10 0010
 * @des
 * @function
 */

public class DetailCookCommunicateAdapter extends SimpleRecyclerAdapter<GoodsDetailInfo.ResultBean.RecipeBean.RecentCommentsBean> {
    @Override
    public SimpleViewHolder<GoodsDetailInfo.ResultBean.RecipeBean.RecentCommentsBean> onCreateViewHolder(ViewGroup parent, int viewType) {
        return new DetailCommunicateViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_communicate,parent, false), this);
    }
}
