package com.huazhuhotel.module_home.main.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.huazhuhotel.module_home.R;
import com.huazhuhotel.module_home.main.adapter.viewholder.HomeBannerViewHolder;
import com.huazhuhotel.module_home.main.adapter.viewholder.HomeRecyViewHolder;
import com.huazhuhotel.module_home.mvp.model.HomeInfo;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by LONGHE001.
 *
 * @time 2019/2/27 0027
 * @des
 * @function
 */

public class HomeBannerAdapter extends RecyclerView.Adapter<HomeBannerViewHolder> {

    private Context context;
    private List<HomeInfo.ResultBean.HeaderBean.TrsBean> beanList;
    private LayoutInflater mLayoutInflater;

    public HomeBannerAdapter(Context context) {
        this.context = context;
        mLayoutInflater = LayoutInflater.from(context);
        beanList=new ArrayList<>();
    }

    @Override
    public HomeBannerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = mLayoutInflater.inflate(R.layout.item_homebanner, parent, false);
        return new HomeBannerViewHolder(view);
    }

    @Override
    public void onBindViewHolder(HomeBannerViewHolder holder, int position) {
        holder.bindHolder(beanList.get(position), position, context);
    }

    @Override
    public int getItemCount() {
        return beanList.size();
    }

    public void setBeanList(List<HomeInfo.ResultBean.HeaderBean.TrsBean> beanList) {
        if (beanList == null) {
            beanList = new ArrayList<>();
        }
        this.beanList = beanList;
        notifyDataSetChanged();
    }
}
