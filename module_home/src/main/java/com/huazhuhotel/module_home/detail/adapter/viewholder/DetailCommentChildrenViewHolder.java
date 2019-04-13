package com.huazhuhotel.module_home.detail.adapter.viewholder;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.huazhuhotel.module_home.R;
import com.huazhuhotel.module_home.detail.adapter.DetailCommentChildrenAdapter;
import com.huazhuhotel.module_home.detail.adapter.DetailCommentGroupAdapter;
import com.huazhuhotel.module_home.mvp.adapter.SimpleViewHolder;
import com.huazhuhotel.module_home.mvp.model.CommentListInfo;
import com.longshihan.mvpcomponent.strategy.imageloader.glide.ImageConfigImpl;
import com.longshihan.mvpcomponent.utils.ArmsUtils;

import java.util.List;

/**
 * Created by LONGHE001.
 *
 * @time 2019/3/5 0005
 * @des
 * @function
 */

public class DetailCommentChildrenViewHolder extends SimpleViewHolder<CommentListInfo.ResultBean.CommentsBean.ChildCommentsBean> {
    private Context context;
    TextView mItemCommentChildContent,nameTv;
    public DetailCommentChildrenViewHolder(View view, DetailCommentChildrenAdapter adapter) {
        super(view,adapter);
        context=view.getContext();
        this.mItemCommentChildContent = (TextView) view.findViewById(R.id.item_comment_child_content);
        nameTv=view.findViewById(R.id.item_comment_child_name);
    }

    @Override
    protected void refreshView(CommentListInfo.ResultBean.CommentsBean.ChildCommentsBean commentsBean) {
        super.refreshView(commentsBean);
        StringBuilder stringBuilder = new StringBuilder();

        if (commentsBean != null) {
            if (commentsBean.getU() != null) {
              nameTv.setText(commentsBean.getU().getN());
            }
            List<CommentListInfo.ResultBean.CommentsBean.ChildCommentsBean.ContentBeanX> contentBeanXES
                    = commentsBean.getContent();
            if (contentBeanXES != null && contentBeanXES.size() > 0) {
                for (int i = 0; i < contentBeanXES.size(); i++) {
                    stringBuilder.append(contentBeanXES.get(i).getC());
                }
            }

        }
        mItemCommentChildContent.setText(stringBuilder.toString());
    }
}
