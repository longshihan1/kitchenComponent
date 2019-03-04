package com.huazhuhotel.module_home.sort.adapter;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.huazhuhotel.module_home.R;
import com.huazhuhotel.module_home.mvp.adapter.SimpleRecyclerAdapter;
import com.huazhuhotel.module_home.mvp.adapter.SimpleViewHolder;
import com.huazhuhotel.module_home.sort.model.entity.ItemType;
import com.huazhuhotel.module_home.sort.model.entity.SortItem;


/**
 * @author pengbo
 * @date 2019/1/5 0005
 */
public class RightAdapter extends SimpleRecyclerAdapter<SortItem> {


    @Override
    public SimpleViewHolder<SortItem> onCreateViewHolder(ViewGroup parent, int viewType) {
        if (viewType == ItemType.BIG_SORT) {
            return new RightBigSortViewHolder(LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.recyclerview_item_right_big_sort, parent, false), this);
        } else {
            return new RightSmallSortViewHolder(LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.recyclerview_item_right_small_sort, parent, false), this);
        }
    }

    @Override
    public int getItemViewType(int position) {
        return mListData.get(position).viewType;
    }
}
