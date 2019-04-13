package com.huazhuhotel.module_home.detail.adapter.viewholder;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.huazhuhotel.module_home.R;
import com.huazhuhotel.module_home.detail.adapter.DetailCommentChildrenAdapter;
import com.huazhuhotel.module_home.detail.adapter.DetailCommentGroupAdapter;
import com.huazhuhotel.module_home.detail.adapter.DetailCookAdapter;
import com.huazhuhotel.module_home.mvp.adapter.SimpleViewHolder;
import com.huazhuhotel.module_home.mvp.model.CommentListInfo;
import com.huazhuhotel.module_home.mvp.model.GoodsDetailInfo;
import com.longshihan.mvpcomponent.strategy.imageloader.glide.ImageConfigImpl;
import com.longshihan.mvpcomponent.utils.ArmsUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by LONGHE001.
 *
 * @time 2019/3/5 0005
 * @des
 * @function
 */

public class DetailCommentGroupViewHolder extends SimpleViewHolder<CommentListInfo.ResultBean.CommentsBean> {
    private Context context;
    ImageView mItemCommentgroupImg;
    TextView mItemCommentgroupName;
    TextView mItemCommentgroupStar;
    TextView mItemCommentgroupMsg;
    TextView mItemCommentgroupContent;
    TextView addressTv,timeTv;
    RecyclerView recyclerView;
    DetailCommentChildrenAdapter detailCommentChildrenAdapter;
    public DetailCommentGroupViewHolder(View view, DetailCommentGroupAdapter adapter) {
        super(view,adapter);
        context=view.getContext();
        this.mItemCommentgroupImg = (ImageView) view.findViewById(R.id.item_commentgroup_img);
        this.mItemCommentgroupName = (TextView) view.findViewById(R.id.item_commentgroup_name);
        this.mItemCommentgroupStar = (TextView) view.findViewById(R.id.item_commentgroup_star);
        this.mItemCommentgroupMsg = (TextView) view.findViewById(R.id.item_commentgroup_msg);
        this.mItemCommentgroupContent = (TextView) view.findViewById(R.id.item_commentgroup_content);
        addressTv=view.findViewById(R.id.item_commentgroup_address);
        timeTv=view.findViewById(R.id.item_commentgroup_time);
        recyclerView=view.findViewById(R.id.item_commentgroup_recy);
        recyclerView.setLayoutManager(new LinearLayoutManager(context,LinearLayoutManager.VERTICAL,false));
        detailCommentChildrenAdapter=new DetailCommentChildrenAdapter();
        recyclerView.setAdapter(detailCommentChildrenAdapter);
    }

    @Override
    protected void refreshView(CommentListInfo.ResultBean.CommentsBean commentsBean) {
        super.refreshView(commentsBean);
        StringBuilder stringBuilder = new StringBuilder();
        if (commentsBean!= null) {
            if (commentsBean.getU() != null) {
                mItemCommentgroupName.setText(commentsBean.getU().getN());
                ArmsUtils.getImageLoader(context)
                        .loadImage(context, ImageConfigImpl.builder()
                                .url(commentsBean.getU().getP())
                                .imageView(mItemCommentgroupImg)
                                .errorPic(R.drawable.chufang)
                                .build());
            }
            addressTv.setText(commentsBean.getCity());
            if (!TextUtils.isEmpty(commentsBean.getTime())) {
                timeTv.setText(commentsBean.getTime().split(" ")[0]);
            }
            List<CommentListInfo.ResultBean.CommentsBean.ContentBean> contentBeanXES = commentsBean.getContent();
            if (contentBeanXES != null && contentBeanXES.size() > 0) {
                for (int i = 0; i < contentBeanXES.size(); i++) {
                    stringBuilder.append(contentBeanXES.get(i).getC());
                }
            }
            mItemCommentgroupContent.setText(stringBuilder.toString());
            if (commentsBean.getChild_comments()!=null&&commentsBean.getChild_comments().size()>0) {
                recyclerView.setVisibility(View.VISIBLE);
                detailCommentChildrenAdapter.setListData(commentsBean.getChild_comments());
            }else {
                recyclerView.setVisibility(View.GONE);
                detailCommentChildrenAdapter.setListData(new ArrayList<>());
            }
        }
    }
}
