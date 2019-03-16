package com.huazhuhotel.module_home.list.adapter.viewholder;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.huazhuhotel.module_home.R;
import com.huazhuhotel.module_home.list.adapter.SearchListAdapter;
import com.huazhuhotel.module_home.mvp.adapter.SimpleViewHolder;
import com.huazhuhotel.module_home.mvp.model.SearchInfo;
import com.huazhuhotel.module_home.sort.model.entity.SortBean;
import com.longshihan.mvpcomponent.strategy.imageloader.glide.ImageConfigImpl;
import com.longshihan.mvpcomponent.utils.ArmsUtils;

import java.math.BigDecimal;

/**
 * Created by LONGHE001.
 *
 * @time 2019/3/5 0005
 * @des
 * @function
 */

public class SearchListViewHolder extends SimpleViewHolder<SearchInfo.ResultBean.ListBean> {
    ImageView mItemSearchImg;
    TextView mItemSearchName;
    TextView mItemSearchMaterial;
    TextView mItemSearchAuthor;
    TextView mItemSearchPerson;
    TextView rateTv;
    private Context context;
    public SearchListViewHolder(View view, SearchListAdapter adapter) {
        super(view,adapter);
        context=view.getContext();
        this.mItemSearchImg = (ImageView) view.findViewById(R.id.item_search_img);
        this.mItemSearchName = (TextView) view.findViewById(R.id.item_search_name);
        this.mItemSearchMaterial = (TextView) view.findViewById(R.id.item_search_material);
        this.mItemSearchAuthor = (TextView) view.findViewById(R.id.item_search_author);
        this.mItemSearchPerson = (TextView) view.findViewById(R.id.item_search_person);
        rateTv=view.findViewById(R.id.item_search_ratetv);
    }

    @Override
    protected void refreshView(SearchInfo.ResultBean.ListBean data1) {
        super.refreshView(data1);
        if (data1!=null&&data1.getR()!=null) {
            SearchInfo.ResultBean.ListBean.RBean data=data1.getR();
            mItemSearchName.setText(data.getN());
            mItemSearchAuthor.setText(data.getAn());
            ArmsUtils.getImageLoader(context)
                    .loadImage(context, ImageConfigImpl.builder()
                            .url(data.getImg())
                            .imageView(mItemSearchImg)
                            .build());
            mItemSearchPerson.setText(data.getRecommendation_tag());
            if (data.getMajor()!=null) {
                for (int i = 0; i < data.getMajor().size(); i++) {
                    mItemSearchMaterial.append(data.getMajor().get(i).getTitle()+" ");
                }
            }
            BigDecimal decimal = new BigDecimal(data.getRate()+"");
            BigDecimal setScale = decimal.setScale(1,BigDecimal.ROUND_HALF_DOWN);
            System.out.println(setScale);
            rateTv.setText(String.valueOf(setScale)+"分");
        }

    }
}
