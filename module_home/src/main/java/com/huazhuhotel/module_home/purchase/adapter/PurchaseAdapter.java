package com.huazhuhotel.module_home.purchase.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.huazhuhotel.module_home.R;
import com.huazhuhotel.module_home.mvp.model.MajorBean;
import com.huazhuhotel.module_home.mvp.model.MajorInfo;
import com.huazhuhotel.module_home.widget.GoodsDetailCookItemView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by LONGHE001.
 *
 * @time 2019/3/10 0010
 * @des
 * @function
 */

public class PurchaseAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private int TYPE1 = 1;
    private int TYPE2 = 2;
    private List<MajorInfo> mDatas;
    private Context context;
    private LinearLayout.LayoutParams layoutParams;
    private OnViewClick onViewClick;

    public PurchaseAdapter(Context context) {
        this.context = context;
        mDatas = new ArrayList<>();
        layoutParams=new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (viewType == TYPE1) {
            View view = LayoutInflater.from(context).inflate(R.layout.item_purces_type1, parent, false);
            ViewHolder1 viewHolder1 = new ViewHolder1(view);
            return viewHolder1;
        } else {
            View view = LayoutInflater.from(context).inflate(R.layout.item_purces_type2, parent, false);
            ViewHolder viewHolder1 = new ViewHolder(view);
            return viewHolder1;
        }
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if (getItemViewType(position) == TYPE1) {
            ViewHolder1 viewHolder1= (ViewHolder1) holder;
            viewHolder1.mItemPurcesType1Name.setText(mDatas.size()+"个购物清单");
        } else if (getItemViewType(position) == TYPE2) {
            ViewHolder viewHolder= (ViewHolder) holder;
            MajorInfo data=mDatas.get(position-1);
            viewHolder.mItemPurcesType2Name.setText(data.getName());

            if (data.getMajorBean()!=null){
                viewHolder.mItemPurcesType2Lin.removeAllViews();
                for (int i = 0; i <data.getMajorBean().size(); i++) {
                    if (data.getMajorBean().get(i)!=null) {
                        MajorBean bean=data.getMajorBean().get(i);
                        GoodsDetailCookItemView cookItemView = new GoodsDetailCookItemView(context);
                        cookItemView.setLayoutParams(layoutParams);
                        cookItemView.setData(data.getMajorBean().get(i).getTitle(),
                                data.getMajorBean().get(i).getNote(),
                                data.getMajorBean().get(i).getTu());
                        if (bean.isDel()){
                            cookItemView.setDelLine(true);
                        }else {
                            cookItemView.setDelLine(false);
                        }
                        cookItemView.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                bean.setDel(!bean.isDel());
                                if (onViewClick!=null){
                                    onViewClick.refreshData(data);
                                }
                            }
                        });
                        viewHolder.mItemPurcesType2Lin.addView(cookItemView);
                    }
                }
            }


            viewHolder.mTitleLin.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (onViewClick!=null){
                        onViewClick.click(data.getId());
                    }
                }
            });

        }
    }


    @Override
    public int getItemViewType(int position) {
        if (position == 0) {
            return TYPE1;
        } else {
            return TYPE2;
        }
    }

    @Override
    public int getItemCount() {
        return mDatas.size() + 1;
    }

    public void setData(List<MajorInfo> majorInfos) {
        this.mDatas=majorInfos;
        notifyDataSetChanged();
    }

    public OnViewClick getOnViewClick() {
        return onViewClick;
    }

    public PurchaseAdapter setOnViewClick(OnViewClick onViewClick) {
        this.onViewClick = onViewClick;
        return this;
    }

    static class ViewHolder1 extends RecyclerView.ViewHolder {
        View view;
        TextView mItemPurcesType1Name;

        public ViewHolder1(View view) {
            super(view);
            this.view = view;
            this.mItemPurcesType1Name = (TextView) view.findViewById(R.id.item_purces_type1_name);
        }
    }

    static class ViewHolder extends RecyclerView.ViewHolder{
        View view;
        TextView mItemPurcesType2Name;
        LinearLayout mItemPurcesType2Lin;
        LinearLayout mTitleLin;

        ViewHolder(View view) {
            super(view);
            this.view = view;
            this.mItemPurcesType2Name = (TextView) view.findViewById(R.id.item_purces_type2_name);
            this.mItemPurcesType2Lin = (LinearLayout) view.findViewById(R.id.item_purces_type2_lin);
            mTitleLin=view.findViewById(R.id.item_purces_type2_titlelin);
        }
    }

    public interface OnViewClick{
        void click(String id);
        void refreshData(MajorInfo info);
    }
}
