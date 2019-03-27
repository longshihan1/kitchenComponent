package com.huazhuhotel.module_home.detail.adapter.viewholder;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.huazhuhotel.module_home.R;
import com.huazhuhotel.module_home.detail.adapter.DetailCookAdapter;
import com.huazhuhotel.module_home.detail.adapter.DetailCookCommunicateAdapter;
import com.huazhuhotel.module_home.mvp.adapter.SimpleViewHolder;
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

public class DetailCommunicateViewHolder extends SimpleViewHolder<GoodsDetailInfo.ResultBean.RecipeBean.RecentCommentsBean> {
    private Context context;
    ImageView mItemCommunicateImg;
    TextView mItemCommunicateName;
    TextView mItemCommunicateTime;
    ImageView mItemCommunicateLove;
    TextView mItemCommunicateLovetv;
    TextView mItemCommunicateMsgtv;
    TextView mItemCommunicateContent;

    public DetailCommunicateViewHolder(View view, DetailCookCommunicateAdapter adapter) {
        super(view, adapter);
        context = view.getContext();
        this.mItemCommunicateImg = (ImageView) view.findViewById(R.id.item_communicate_img);
        this.mItemCommunicateName = (TextView) view.findViewById(R.id.item_communicate_name);
        this.mItemCommunicateTime = (TextView) view.findViewById(R.id.item_communicate_time);
        this.mItemCommunicateLove = (ImageView) view.findViewById(R.id.item_communicate_love);
        this.mItemCommunicateLovetv = (TextView) view.findViewById(R.id.item_communicate_lovetv);
        this.mItemCommunicateMsgtv = (TextView) view.findViewById(R.id.item_communicate_msgtv);
        this.mItemCommunicateContent = (TextView) view.findViewById(R.id.item_communicate_content);
    }

    @Override
    protected void refreshView(GoodsDetailInfo.ResultBean.RecipeBean.RecentCommentsBean data1) {
        super.refreshView(data1);
        if (data1==null){
            return;
        }
        mItemCommunicateName.setText(data1.getAuthor_nick());
        mItemCommunicateTime.setText(data1.getTime());
        mItemCommunicateContent.setText(data1.getContent());
        if (TextUtils.isEmpty(data1.getUser_photo())){
            data1.setUser_photo("1");
        }
        ArmsUtils.getImageLoader(context)
                .loadImage(context, ImageConfigImpl.builder()
                        .url(data1.getUser_photo())
                        .imageView(mItemCommunicateImg)
                        .build());
    }
}
