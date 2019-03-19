package com.huazhuhotel.module_home.attention.adapter;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.huazhuhotel.module_home.R;
import com.huazhuhotel.module_home.attention.adapter.viewholder.AttentionViewHolder;
import com.huazhuhotel.module_home.detail.adapter.viewholder.DetailCookViewHolder;
import com.huazhuhotel.module_home.mvp.adapter.SimpleRecyclerAdapter;
import com.huazhuhotel.module_home.mvp.adapter.SimpleViewHolder;
import com.huazhuhotel.module_home.mvp.model.AttentionInfo;
import com.huazhuhotel.module_home.mvp.model.GoodsDetailInfo;

/**
 * Created by LONGHE001.
 *
 * @time 2019/3/10 0010
 * @des
 * @function
 */

public class AttentionAdapter extends SimpleRecyclerAdapter<AttentionInfo.ResultBean.FollowsBean> {
    @Override
    public SimpleViewHolder<AttentionInfo.ResultBean.FollowsBean> onCreateViewHolder(ViewGroup parent, int viewType) {
        return new AttentionViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_attention, parent, false),this);

    }
}