package com.huazhuhotel.module_home.detail.adapter;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.huazhuhotel.module_home.R;
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

public class DetailCommentGroupAdapter extends SimpleRecyclerAdapter<CommentListInfo.ResultBean.CommentsBean> {
    @Override
    public SimpleViewHolder<CommentListInfo.ResultBean.CommentsBean> onCreateViewHolder(ViewGroup parent, int viewType) {
        return new DetailCommentGroupViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_commentgroup, parent, false),this);

    }
}
