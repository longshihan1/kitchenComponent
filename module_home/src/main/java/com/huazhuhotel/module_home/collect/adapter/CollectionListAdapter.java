package com.huazhuhotel.module_home.collect.adapter;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.huazhuhotel.module_home.R;
import com.huazhuhotel.module_home.collect.adapter.viewholder.CollectViewHolder;
import com.huazhuhotel.module_home.list.adapter.viewholder.SearchListViewHolder;
import com.huazhuhotel.module_home.mvp.adapter.SimpleRecyclerAdapter;
import com.huazhuhotel.module_home.mvp.adapter.SimpleViewHolder;
import com.huazhuhotel.module_home.mvp.model.CollectionInfo;
import com.huazhuhotel.module_home.mvp.model.SearchInfo;

/**
 * Created by LONGHE001.
 *
 * @time 2019/3/5 0005
 * @des
 * @function
 */

public class CollectionListAdapter extends SimpleRecyclerAdapter<CollectionInfo.ResultBean.RecipesBean> {
    @Override
    public SimpleViewHolder<CollectionInfo.ResultBean.RecipesBean> onCreateViewHolder(ViewGroup parent, int viewType) {
        return new CollectViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_searchitem, parent, false),this);
    }
}
