package com.huazhuhotel.module_home.main.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.huazhuhotel.module_home.R;
import com.huazhuhotel.module_home.main.adapter.viewholder.HomeAdvViewHolder;
import com.huazhuhotel.module_home.main.adapter.viewholder.HomeBannerParentViewHolder;
import com.huazhuhotel.module_home.main.adapter.viewholder.HomeBannerViewHolder;
import com.huazhuhotel.module_home.main.adapter.viewholder.HomeRecyViewHolder;
import com.huazhuhotel.module_home.mvp.model.HomeInfo;
import com.huazhuhotel.module_home.mvp.model.SearchInfo;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by LONGHE001.
 *
 * @time 2019/2/27 0027
 * @des
 * @function
 */

public class HomeAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private Context context;
    private List<SearchInfo.ResultBean.ListBean> beanList;
    private HomeInfo.ResultBean.HeaderBean headerBean;
    private LayoutInflater mLayoutInflater;
    private int TYPE_BANNER = 0;
    private int TYPE_LIN = 1;
    private int TYPE_LIST = 2;
    private OnAdapterListener listener;

    public HomeAdapter(Context context) {
        this.context = context;
        mLayoutInflater = LayoutInflater.from(context);
        beanList = new ArrayList<>();
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (viewType == TYPE_BANNER) {
            View view = mLayoutInflater.inflate(R.layout.view_homebanner, parent, false);
            HomeBannerParentViewHolder viewHolder=new HomeBannerParentViewHolder(view);
            viewHolder.attachAdapter(context,new HomeBannerAdapter(context));
            return viewHolder;
        } else if (viewType == TYPE_LIN) {
            View view = mLayoutInflater.inflate(R.layout.item_homesort, parent, false);
            return new HomeAdvViewHolder(view);
        } else {
            View view = mLayoutInflater.inflate(R.layout.item_homerecy, parent, false);
            return new HomeRecyViewHolder(view);
        }

    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if (getItemViewType(position) == TYPE_BANNER) {
            if (holder instanceof HomeBannerParentViewHolder) {
                HomeBannerParentViewHolder parentViewHolder= (HomeBannerParentViewHolder) holder;
                parentViewHolder.bindHolder(headerBean, position, context);
                parentViewHolder.sort.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (listener!=null){
                            listener.onHomeSortListener();
                        }
                    }
                });
                parentViewHolder.searchLin.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (listener!=null){
                            listener.onHomeSearchListener();
                        }
                    }
                });
            }
        } else if (getItemViewType(position) == TYPE_LIN) {
            if (holder instanceof HomeAdvViewHolder) {
                HomeAdvViewHolder advViewHolder= (HomeAdvViewHolder) holder;
                advViewHolder.bindHolder("", position, context);
                advViewHolder.sortTv.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (listener!=null){
                            listener.onHomeSortListener();
                        }
                    }
                });
                advViewHolder.wantTv.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (listener!=null){
                            listener.onCollectionListener();
                        }
                    }
                });
                advViewHolder.watchTv.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (listener!=null){
                            listener.onRecentLookListener();
                        }
                    }
                });
            }
        } else {
            if (holder instanceof HomeRecyViewHolder) {
                ((HomeRecyViewHolder) holder).bindHolder(beanList.get(position-2), position, context);
                ((HomeRecyViewHolder) holder).itemView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (listener!=null){
                            listener.onMsgClick(beanList.get(position-2));
                        }
                    }
                });
            }
        }

    }

    @Override
    public int getItemCount() {
        return beanList.size()+2;
    }

    @Override
    public int getItemViewType(int position) {
        if (position ==0) {
            return TYPE_BANNER;
        } else if (position == 1) {
            return TYPE_LIN;
        } else {
            return TYPE_LIST;
        }
    }

    public void setBeanList(HomeInfo info) {
        if (info != null && info.getResult() != null && info.getResult().getHeader() != null && info.getResult().getHeader().getTrs() != null) {
            headerBean = info.getResult().getHeader();
        }
        notifyDataSetChanged();
    }

    public void setListener(OnAdapterListener listener) {
        this.listener = listener;
    }

    public void setListData(List<SearchInfo.ResultBean.ListBean> list) {
        this.beanList = list;
        notifyDataSetChanged();
    }

    public void appendListData(List<SearchInfo.ResultBean.ListBean> data) {
        if (data!=null&&data.size()>0) {
            if (beanList==null){
                beanList=new ArrayList<>();
            }
            beanList.addAll(data);
            notifyDataSetChanged();
        }
    }


    public interface OnAdapterListener{
        void onHomeSortListener();
        void onHomeSearchListener();
        void onCollectionListener();
        void onRecentLookListener();
        void onMsgClick(SearchInfo.ResultBean.ListBean item);
    }
}
