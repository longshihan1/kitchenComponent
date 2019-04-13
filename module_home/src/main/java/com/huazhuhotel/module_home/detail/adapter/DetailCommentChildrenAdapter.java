package com.huazhuhotel.module_home.detail.adapter;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.huazhuhotel.module_home.R;
import com.huazhuhotel.module_home.detail.adapter.viewholder.DetailCommentChildrenViewHolder;
import com.huazhuhotel.module_home.detail.adapter.viewholder.DetailCommentGroupViewHolder;
import com.huazhuhotel.module_home.mvp.adapter.SimpleRecyclerAdapter;
import com.huazhuhotel.module_home.mvp.adapter.SimpleViewHolder;
import com.huazhuhotel.module_home.mvp.model.CommentListInfo;

/**
 * Created by LONGHE001.
 *
 * @time 2019/3/10 0010
 * @des
 * @function
 */

public class DetailCommentChildrenAdapter extends SimpleRecyclerAdapter<CommentListInfo.ResultBean.CommentsBean.ChildCommentsBean> {
    @Override
    public SimpleViewHolder<CommentListInfo.ResultBean.CommentsBean.ChildCommentsBean> onCreateViewHolder(ViewGroup parent, int viewType) {
        return new DetailCommentChildrenViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_commentchild, parent, false),this);

    }
}
