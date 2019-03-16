package com.huazhuhotel.module_home.detail.adapter.viewholder;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.huazhuhotel.module_home.R;
import com.huazhuhotel.module_home.detail.adapter.DetailCookAdapter;
import com.huazhuhotel.module_home.detail.adapter.DetailReCommondCookAdapter;
import com.huazhuhotel.module_home.mvp.adapter.SimpleViewHolder;
import com.huazhuhotel.module_home.mvp.model.GoodsDetailInfo;
import com.huazhuhotel.module_home.mvp.model.ReCommondInfo;
import com.longshihan.mvpcomponent.strategy.imageloader.glide.ImageConfigImpl;
import com.longshihan.mvpcomponent.utils.ArmsUtils;

/**
 * Created by LONGHE001.
 *
 * @time 2019/3/5 0005
 * @des 推荐
 * @function
 */

public class DetailRecommendCookViewHolder extends SimpleViewHolder<ReCommondInfo.ResultBean.ListBean> {
    private Context context;
    private TextView name,meterial,author,star;
    private ImageView imageView;
    public DetailRecommendCookViewHolder(View view, DetailReCommondCookAdapter adapter) {
        super(view,adapter);
        context=view.getContext();
        meterial=view.findViewById(R.id.item_recommend_meterial);
        author=view.findViewById(R.id.item_recommend_author);
        imageView=view.findViewById(R.id.item_recommend_img);
        name=view.findViewById(R.id.item_recommend_name);
        star=view.findViewById(R.id.item_recommend_star);
    }

    @Override
    protected void refreshView(ReCommondInfo.ResultBean.ListBean data1) {
        if (data1==null||data1.getR()==null){
            return;
        }
        super.refreshView(data1);
        name.setText(data1.getR().getN());
        if (data1.getR().getMajor()!=null) {
            StringBuilder stringBuilder = new StringBuilder();
            for (int i = 0; i < data1.getR().getMajor().size(); i++) {
                if (data1.getR().getMajor().get(i) != null) {
                    stringBuilder.append(data1.getR().getMajor().get(i).getTitle());
                }
            }
            meterial.setVisibility(View.VISIBLE);
            meterial.setText(stringBuilder.toString());
        }else {
            meterial.setVisibility(View.GONE);
        }
        star.setText(data1.getR().getRate()+"分");
        author.setText(data1.getR().getAn());
        ArmsUtils.getImageLoader(context)
                .loadImage(context, ImageConfigImpl.builder()
                        .url(data1.getR().getImg())
                        .imageView(imageView)
                        .build());
    }
}
