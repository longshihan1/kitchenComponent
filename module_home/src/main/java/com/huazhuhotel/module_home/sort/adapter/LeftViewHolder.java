package com.huazhuhotel.module_home.sort.adapter;

import android.support.annotation.Nullable;
import android.view.View;
import android.widget.TextView;

import com.huazhuhotel.module_home.R;
import com.huazhuhotel.module_home.mvp.adapter.SimpleRecyclerAdapter;
import com.huazhuhotel.module_home.mvp.adapter.SimpleViewHolder;
import com.huazhuhotel.module_home.sort.model.entity.SortBean;


/**
 * @author pengbo
 * @date 2019/1/5 0005
 */
public class LeftViewHolder extends SimpleViewHolder<SortBean> {

    /**
     * tvName显示大类名称，view是显示被选中的黄色标记
     */
    private TextView tvName;
    private View view;

    public LeftViewHolder(View itemView, @Nullable SimpleRecyclerAdapter<SortBean> adapter) {
        super(itemView, adapter);
        tvName = (TextView) itemView.findViewById(R.id.tv_left);
        view = itemView.findViewById(R.id.view);
    }

    @Override
    protected void refreshView(SortBean data) {
        tvName.setText(data.bigSortName);
        //item点击后背景的变化
        if (data.isSelected) {
            view.setVisibility(View.VISIBLE);
            tvName.setBackgroundResource(R.color.color_107);
            tvName.setTextColor(getContext().getResources().getColor(R.color.color_002));
        } else {
            view.setVisibility(View.GONE);
            tvName.setBackgroundResource(R.color.color_109);
            tvName.setTextColor(getContext().getResources().getColor(R.color.color_100));
        }
    }
}
