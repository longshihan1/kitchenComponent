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
public class RightBigSortViewHolder extends SimpleViewHolder<SortItem> {

    TextView tvTitle;

    public RightBigSortViewHolder(View itemView, @Nullable SimpleRecyclerAdapter<SortItem> adapter) {
        super(itemView, adapter);
        tvTitle = (TextView) itemView.findViewById(R.id.tv_title);
    }

    @Override
    protected void refreshView(SortItem data) {
        tvTitle.setText(data.name);
    }

}
