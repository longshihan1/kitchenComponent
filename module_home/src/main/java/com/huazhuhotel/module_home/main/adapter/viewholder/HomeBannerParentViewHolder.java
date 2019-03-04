package com.huazhuhotel.module_home.main.adapter.viewholder;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.PagerSnapHelper;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.huazhuhotel.module_home.R;
import com.huazhuhotel.module_home.main.adapter.HomeBannerAdapter;
import com.huazhuhotel.module_home.mvp.model.HomeInfo;
import com.longshihan.mvpcomponent.base.adapter.BaseHolder;
import com.longshihan.mvpcomponent.strategy.imageloader.glide.ImageConfigImpl;
import com.longshihan.mvpcomponent.utils.ArmsUtils;

/**
 * Created by LONGHE001.
 *
 * @time 2019/2/27 0027
 * @des
 * @function
 */

public class HomeBannerParentViewHolder extends BaseHolder<HomeInfo.ResultBean.HeaderBean> {
    RecyclerView recyclerView;

    public LinearLayout searchLin;
    public ImageView sort, add;

    private HomeBannerAdapter bannerAdapter;

    public HomeBannerParentViewHolder(View itemView) {
        super(itemView);
        this.recyclerView = itemView.findViewById(R.id.item_homebanner_recy);
        searchLin = itemView.findViewById(R.id.item_homebanner_search);
        sort = itemView.findViewById(R.id.item_homebanner_sort);
        add = itemView.findViewById(R.id.item_homebanner_add);
    }

    public void attachAdapter(Context context, HomeBannerAdapter adapter) {
        bannerAdapter = new HomeBannerAdapter(context);
        recyclerView.setLayoutManager(new LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false));
        new PagerSnapHelper().attachToRecyclerView(recyclerView);
        recyclerView.setAdapter(bannerAdapter);
    }

    @Override
    public void bindHolder(HomeInfo.ResultBean.HeaderBean data, int position, Context mContext) {
        if (data.getTrs() != null) {
            bannerAdapter.setBeanList(data.getTrs());
        }
    }
}
