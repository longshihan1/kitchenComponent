package com.huazhuhotel.module_home.main.adapter.viewholder;

import android.content.Context;
import android.view.View;
import android.widget.TextView;

import com.huazhuhotel.module_home.R;
import com.longshihan.mvpcomponent.base.adapter.BaseHolder;

/**
 * Created by LONGHE001.
 *
 * @time 2019/2/27 0027
 * @des
 * @function
 */

public class HomeAdvViewHolder extends BaseHolder<String> {
    public TextView sortTv,watchTv,workTv,wantTv;
    public HomeAdvViewHolder(View itemView) {
        super(itemView);
        sortTv=itemView.findViewById(R.id.item_home_sort);
        watchTv=itemView.findViewById(R.id.item_home_watch);
        workTv=itemView.findViewById(R.id.item_home_work);
        wantTv=itemView.findViewById(R.id.item_home_want);
    }


    @Override
    public void bindHolder(String data, int position, Context mContext) {

    }
}
