package com.huazhuhotel.module_home.purchase.adapter.viewholder;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.huazhuhotel.module_home.R;
import com.huazhuhotel.module_home.attention.adapter.AttentionDetailNoteAdapter;
import com.huazhuhotel.module_home.mvp.adapter.SimpleViewHolder;
import com.huazhuhotel.module_home.mvp.model.UserNoteInfo;
import com.longshihan.mvpcomponent.strategy.imageloader.glide.ImageConfigImpl;
import com.longshihan.mvpcomponent.utils.ArmsUtils;

/**
 * Created by LONGHE001.
 *
 * @time 2019/3/5 0005
 * @des
 * @function
 */

public class PurchaseViewHolder extends SimpleViewHolder<UserNoteInfo.ResultBean.ListBean> {
    private Context context;
    private TextView title,likeTv,nameTv;
    private ImageView imageView;
    public PurchaseViewHolder(View view, AttentionDetailNoteAdapter adapter) {
        super(view,adapter);
        context=view.getContext();
        likeTv=view.findViewById(R.id.item_usernote_like);
    }

    @Override
    protected void refreshView(UserNoteInfo.ResultBean.ListBean data1) {
        super.refreshView(data1);

    }
}
