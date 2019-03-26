package com.huazhuhotel.module_home.main.adapter.viewholder;

import android.content.Context;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.view.View;

import com.huazhuhotel.module_home.R;
import com.huazhuhotel.module_home.main.adapter.VideoAdapter;
import com.huazhuhotel.module_home.mvp.adapter.SimpleRecyclerAdapter;
import com.huazhuhotel.module_home.mvp.adapter.SimpleViewHolder;
import com.huazhuhotel.module_home.mvp.model.VideoListInfo;
import com.longshihan.mvpcomponent.base.adapter.BaseHolder;

import cn.jzvd.Jzvd;
import cn.jzvd.JzvdStd;

/**
 * Created by LONGHE001.
 *
 * @time 2019/2/27 0027
 * @des
 * @function
 */

public class HomeVideoViewHolder extends SimpleViewHolder<VideoListInfo.ResultBean.VideoListBean> {
    JzvdStd jzvdStd;
    public HomeVideoViewHolder(View itemView, @Nullable VideoAdapter adapter) {
        super(itemView, adapter);
        jzvdStd=itemView.findViewById(R.id.item_video_player);
    }

    @Override
    protected void refreshView(VideoListInfo.ResultBean.VideoListBean data) {
        super.refreshView(data);
        if (!TextUtils.isEmpty(data.getVideo_url())){
            jzvdStd.setUp(data.getVideo_url(), data.getRecipe_title(), Jzvd.SCREEN_WINDOW_LIST);
        }
    }
}
