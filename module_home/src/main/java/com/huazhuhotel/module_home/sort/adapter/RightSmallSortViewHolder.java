package com.huazhuhotel.module_home.sort.adapter;

import android.support.annotation.Nullable;
import android.view.View;
import android.widget.TextView;

import com.huazhuhotel.module_home.R;
import com.huazhuhotel.module_home.mvp.adapter.SimpleRecyclerAdapter;
import com.huazhuhotel.module_home.mvp.adapter.SimpleViewHolder;
import com.huazhuhotel.module_home.sort.model.entity.SortItem;


/**
 * @author pengbo
 * @date 2019/1/5 0005
 */
public class RightSmallSortViewHolder extends SimpleViewHolder<SortItem> {

    private TextView textView;

    public RightSmallSortViewHolder(View itemView, @Nullable SimpleRecyclerAdapter<SortItem> adapter) {
        super(itemView, adapter);
        textView = itemView.findViewById(R.id.tv_small);
    }

    @Override
    protected void refreshView(SortItem data) {
        textView.setText(data.name);
    }
}
