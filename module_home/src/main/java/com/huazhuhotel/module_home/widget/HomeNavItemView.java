package com.huazhuhotel.module_home.widget;

import android.content.Context;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.huazhuhotel.module_home.R;

/**
 * Created by LONGHE001.
 *
 * @time 2019/3/4 0004
 * @des
 * @function
 */

public class HomeNavItemView extends LinearLayout {
    private Context context;
    private View view;
    private ImageView imageView;
    private TextView textView;
    private NavItemBuilder builder;

    public HomeNavItemView(Context context) {
        super(context);
        init(context);
    }

    public HomeNavItemView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public HomeNavItemView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }

    private void init(Context context) {
        this.context = context;
        view = View.inflate(context, R.layout.item_mainhomenavview, this);
        initView();
    }

    private void initView() {
        imageView = view.findViewById(R.id.item_homenav_img);
        textView = view.findViewById(R.id.item_homenav_txt);
    }

    public void setBuilder(NavItemBuilder builder) {
        this.builder = builder;
        clickCustomer();
    }

    /**
     *
     */
    public void clickSelected() {
        if (builder==null){
            return;
        }
        textView.setText(builder.getSelectedStr());
        if (builder.getSelectedColor() > 0) {
            textView.setTextColor(context.getResources().getColor(builder.getSelectedColor()));
        }
        if (!TextUtils.isEmpty(builder.getSelectedUrl())) {
            Glide.with(context)
                    .load(builder.getSelectedUrl())
                    .into(imageView);
        }else if (builder.getSelectedDrawable()>0){
            imageView.setBackgroundResource(builder.getSelectedDrawable());
        }
    }

    public void clickCustomer() {
        if (builder==null){
            return;
        }
        textView.setText(builder.getCustomerStr());
        if (builder.getCustomerColor() > 0) {
            textView.setTextColor(context.getResources().getColor(builder.getCustomerColor()));
        }
        if (!TextUtils.isEmpty(builder.getCustomerUrl())) {
            Glide.with(context)
                    .load(builder.getCustomerUrl())
                    .into(imageView);
        }else if (builder.getCustomerDrawable()>0){
            imageView.setBackgroundResource(builder.getCustomerDrawable());
        }
    }
}
