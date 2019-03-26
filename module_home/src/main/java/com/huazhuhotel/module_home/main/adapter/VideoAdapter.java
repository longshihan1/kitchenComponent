package com.huazhuhotel.module_home.main.adapter;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.huazhuhotel.module_home.R;
import com.huazhuhotel.module_home.attention.adapter.viewholder.AttentionViewHolder;
import com.huazhuhotel.module_home.main.adapter.viewholder.HomeVideoViewHolder;
import com.huazhuhotel.module_home.mvp.adapter.SimpleRecyclerAdapter;
import com.huazhuhotel.module_home.mvp.adapter.SimpleViewHolder;
import com.huazhuhotel.module_home.mvp.model.AttentionInfo;
import com.huazhuhotel.module_home.mvp.model.VideoListInfo;

/**
 * Created by LONGHE001.
 *
 * @time 2019/3/10 0010
 * @des
 * @function
 */

public class VideoAdapter extends SimpleRecyclerAdapter<VideoListInfo.ResultBean.VideoListBean> {

    @Override
    public SimpleViewHolder<VideoListInfo.ResultBean.VideoListBean> onCreateViewHolder(ViewGroup parent, int viewType) {
       return new HomeVideoViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_video, parent, false), this);

    }
}
