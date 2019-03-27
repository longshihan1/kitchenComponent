package com.huazhuhotel.module_home.attention.adapter;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.huazhuhotel.module_home.R;
import com.huazhuhotel.module_home.attention.adapter.viewholder.AttentionDetailNoteViewHolder;
import com.huazhuhotel.module_home.attention.adapter.viewholder.AttentionDetailViewHolder;
import com.huazhuhotel.module_home.mvp.adapter.SimpleRecyclerAdapter;
import com.huazhuhotel.module_home.mvp.adapter.SimpleViewHolder;
import com.huazhuhotel.module_home.mvp.model.UnRecipesListInfo;
import com.huazhuhotel.module_home.mvp.model.UserNoteInfo;

/**
 * Created by LONGHE001.
 *
 * @time 2019/3/10 0010
 * @des
 * @function
 */

public class AttentionDetailNoteAdapter extends SimpleRecyclerAdapter<UserNoteInfo.ResultBean.ListBean> {
    @Override
    public SimpleViewHolder<UserNoteInfo.ResultBean.ListBean> onCreateViewHolder(ViewGroup parent, int viewType) {
        return new AttentionDetailNoteViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_usernote, parent, false),this);

    }
}
