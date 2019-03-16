package com.huazhuhotel.module_home.attention.adapter.viewholder;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.huazhuhotel.module_home.R;
import com.huazhuhotel.module_home.attention.adapter.AttentionAdapter;
import com.huazhuhotel.module_home.detail.adapter.DetailCookAdapter;
import com.huazhuhotel.module_home.mvp.adapter.SimpleViewHolder;
import com.huazhuhotel.module_home.mvp.model.AttentionInfo;
import com.huazhuhotel.module_home.mvp.model.GoodsDetailInfo;
import com.longshihan.mvpcomponent.strategy.imageloader.glide.ImageConfigImpl;
import com.longshihan.mvpcomponent.utils.ArmsUtils;

/**
 * Created by LONGHE001.
 *
 * @time 2019/3/5 0005
 * @des
 * @function
 */

public class AttentionViewHolder extends SimpleViewHolder<AttentionInfo.ResultBean.FollowsBean> {
    private Context context;
    private TextView nameTv,levelTv,statusTv;
    private ImageView imageView;
    public AttentionViewHolder(View view, AttentionAdapter adapter) {
        super(view,adapter);
        context=view.getContext();
        nameTv=view.findViewById(R.id.item_attention_name);
        levelTv=view.findViewById(R.id.item_attention_level);
        statusTv=view.findViewById(R.id.item_attention_status);
        imageView=view.findViewById(R.id.item_attention_img);
    }

    @Override
    protected void refreshView(AttentionInfo.ResultBean.FollowsBean data1) {
        super.refreshView(data1);
        nameTv.setText(data1.getNick());
        levelTv.setText("LV."+data1.getLvl());
        ArmsUtils.getImageLoader(context)
                .loadImage(context, ImageConfigImpl.builder()
                        .url(data1.getUser_photo())
                        .imageView(imageView)
                        .build());
    }
}
