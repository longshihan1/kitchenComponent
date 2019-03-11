package com.huazhuhotel.module_home.detail.adapter;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.huazhuhotel.module_home.R;
import com.huazhuhotel.module_home.detail.adapter.viewholder.DetailRecommendCookViewHolder;
import com.huazhuhotel.module_home.mvp.adapter.SimpleRecyclerAdapter;
import com.huazhuhotel.module_home.mvp.adapter.SimpleViewHolder;
import com.huazhuhotel.module_home.mvp.model.ReCommondInfo;

/**
 * Created by LONGHE001.
 *
 * @time 2019/3/10 0010
 * @des
 * @function
 */

public class DetailReCommondCookAdapter extends SimpleRecyclerAdapter<ReCommondInfo.ResultBean.ListBean> {
    @Override
    public SimpleViewHolder<ReCommondInfo.ResultBean.ListBean> onCreateViewHolder(ViewGroup parent, int viewType) {
        return new DetailRecommendCookViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_recommondcook, parent, false),this);

    }
}
