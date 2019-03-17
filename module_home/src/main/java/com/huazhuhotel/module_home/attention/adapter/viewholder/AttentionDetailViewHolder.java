package com.huazhuhotel.module_home.attention.adapter.viewholder;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.huazhuhotel.module_home.R;
import com.huazhuhotel.module_home.attention.adapter.AttentionAdapter;
import com.huazhuhotel.module_home.attention.adapter.AttentionDetailRecepAdapter;
import com.huazhuhotel.module_home.mvp.adapter.SimpleViewHolder;
import com.huazhuhotel.module_home.mvp.model.AttentionInfo;
import com.huazhuhotel.module_home.mvp.model.UnRecipesListInfo;
import com.longshihan.mvpcomponent.strategy.imageloader.glide.ImageConfigImpl;
import com.longshihan.mvpcomponent.utils.ArmsUtils;

/**
 * Created by LONGHE001.
 *
 * @time 2019/3/5 0005
 * @des
 * @function
 */

public class AttentionDetailViewHolder extends SimpleViewHolder<UnRecipesListInfo.ResultBean.ListBean> {
    private Context context;

    private ImageView imageView;
    public AttentionDetailViewHolder(View view, AttentionDetailRecepAdapter adapter) {
        super(view,adapter);
        context=view.getContext();
        imageView=view.findViewById(R.id.item_attention_img);
    }

    @Override
    protected void refreshView(UnRecipesListInfo.ResultBean.ListBean data1) {
        super.refreshView(data1);
        ArmsUtils.getImageLoader(context)
                .loadImage(context, ImageConfigImpl.builder()
                        .url(data1.getR().getImg())
                        .imageView(imageView)
                        .build());
    }
}
