package com.huazhuhotel.module_home.attention.adapter;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.huazhuhotel.module_home.R;
import com.huazhuhotel.module_home.attention.adapter.viewholder.AttentionDetailViewHolder;
import com.huazhuhotel.module_home.attention.adapter.viewholder.AttentionViewHolder;
import com.huazhuhotel.module_home.mvp.adapter.SimpleRecyclerAdapter;
import com.huazhuhotel.module_home.mvp.adapter.SimpleViewHolder;
import com.huazhuhotel.module_home.mvp.model.AttentionInfo;
import com.huazhuhotel.module_home.mvp.model.UnRecipesListInfo;

/**
 * Created by LONGHE001.
 *
 * @time 2019/3/10 0010
 * @des
 * @function
 */

public class AttentionDetailRecepAdapter extends SimpleRecyclerAdapter<UnRecipesListInfo.ResultBean.ListBean> {
    @Override
    public SimpleViewHolder<UnRecipesListInfo.ResultBean.ListBean> onCreateViewHolder(ViewGroup parent, int viewType) {
        return new AttentionDetailViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_userrecipes, parent, false),this);

    }
}
