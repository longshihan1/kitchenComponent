package com.huazhuhotel.module_home.attention.adapter.viewholder;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.huazhuhotel.module_home.R;
import com.huazhuhotel.module_home.attention.adapter.AttentionDetailNoteAdapter;
import com.huazhuhotel.module_home.attention.adapter.AttentionDetailRecepAdapter;
import com.huazhuhotel.module_home.mvp.adapter.SimpleViewHolder;
import com.huazhuhotel.module_home.mvp.model.UnRecipesListInfo;
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

public class AttentionDetailNoteViewHolder extends SimpleViewHolder<UserNoteInfo.ResultBean.ListBean> {
    private Context context;
    private TextView title,likeTv,nameTv;
    private ImageView imageView;
    public AttentionDetailNoteViewHolder(View view, AttentionDetailNoteAdapter adapter) {
        super(view,adapter);
        context=view.getContext();
        imageView=view.findViewById(R.id.item_usernote_img);
        title=view.findViewById(R.id.item_usernote_title);
        likeTv=view.findViewById(R.id.item_usernote_like);
        nameTv=view.findViewById(R.id.item_usernote_name);
    }

    @Override
    protected void refreshView(UserNoteInfo.ResultBean.ListBean data1) {
        super.refreshView(data1);
        title.setText(data1.getTitle());
        if (data1.getAuthor()!=null) {
            likeTv.setText(data1.getAuthor().getN());
        }
        nameTv.setText(data1.getLike_count()+"");
        ArmsUtils.getImageLoader(context)
                .loadImage(context, ImageConfigImpl.builder()
                        .url(data1.getImage_u())
                        .imageView(imageView)
                        .build());
    }
}
