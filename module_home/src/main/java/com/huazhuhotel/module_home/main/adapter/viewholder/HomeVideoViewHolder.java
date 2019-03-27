package com.huazhuhotel.module_home.main.adapter.viewholder;

import android.content.Context;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;

import com.bumptech.glide.load.resource.bitmap.CenterCrop;
import com.huazhuhotel.module_home.R;
import com.huazhuhotel.module_home.main.adapter.VideoAdapter;
import com.huazhuhotel.module_home.mvp.adapter.SimpleRecyclerAdapter;
import com.huazhuhotel.module_home.mvp.adapter.SimpleViewHolder;
import com.huazhuhotel.module_home.mvp.model.VideoListInfo;
import com.longshihan.mvpcomponent.base.adapter.BaseHolder;
import com.longshihan.mvpcomponent.strategy.imageloader.glide.ImageConfigImpl;
import com.longshihan.mvpcomponent.utils.ArmsUtils;

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

    private TextView title, name, looktv, startv;

    public HomeVideoViewHolder(View itemView, @Nullable VideoAdapter adapter) {
        super(itemView, adapter);
        jzvdStd = itemView.findViewById(R.id.item_video_player);
        title = itemView.findViewById(R.id.item_video_title);
        name = itemView.findViewById(R.id.item_video_author);
        looktv = itemView.findViewById(R.id.item_video_looker);
        startv = itemView.findViewById(R.id.item_video_star);
    }

    @Override
    protected void refreshView(VideoListInfo.ResultBean.VideoListBean data) {
        super.refreshView(data);
        if (data==null){
            return;
        }
        if (!TextUtils.isEmpty(data.getVideo_url())) {
            jzvdStd.setUp(data.getVideo_url(), data.getRecipe_title(), Jzvd.SCREEN_WINDOW_LIST);
        }
        title.setText(data.getVideo_title());
        looktv.setText(data.getFavo_count()+"");
        startv.setText(data.getLike_state()+"");
        if (data.getAuthor()!=null) {
            name.setText(data.getAuthor().getN());
        }
        ArmsUtils.getImageLoader(context)
                .loadImage(context, ImageConfigImpl.builder()
                        .url(data.getVideo_cover())
                        .imageView(jzvdStd.thumbImageView)
                        .transformation(new CenterCrop())
                        .build());
    }
}
