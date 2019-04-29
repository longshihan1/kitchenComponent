package com.huazhuhotel.module_home.widget;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.huazhuhotel.module_home.R;

import static com.longshihan.mvpcomponent.utils.ArmsUtils.getScreenWidth;

/**
 * Created by LONGHE001.
 *
 * @time 2019/3/4 0004
 * @des
 * @function
 */

public class HomeNavLinearLayout extends LinearLayout {
    private Context context;
    private LayoutParams layoutParams;
    private int width;
    private HomeNavItemView homeView, orderView, memberView,mineView;
    private OnSelectListener listener;

    public HomeNavLinearLayout(Context context) {
        super(context);
        init(context);
    }

    public HomeNavLinearLayout(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public HomeNavLinearLayout(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }

    private void init(Context context) {
        this.context = context;
        setOrientation(HORIZONTAL);
        initData();
    }


    private void initData() {
        width = getScreenWidth(context) / 4;
        layoutParams = new LayoutParams(width, ViewGroup.LayoutParams.MATCH_PARENT);
        //默认3个
        removeAllViews();
        homeView = new HomeNavItemView(context);
        orderView = new HomeNavItemView(context);
        memberView = new HomeNavItemView(context);
        mineView=new HomeNavItemView(context);
        homeView.setLayoutParams(layoutParams);
        orderView.setLayoutParams(layoutParams);
        memberView.setLayoutParams(layoutParams);
        mineView.setLayoutParams(layoutParams);
        addView(homeView);
        addView(orderView);
        addView(memberView);
        addView(mineView);

        NavItemBuilder homeBuilder = new NavItemBuilder()
                .setCustomerStr("首页").setSelectedStr("首页")
                .setCustomerColor(R.color.color_273261).setSelectedColor(R.color.color_f85f3d)
                .setCustomerDrawable(R.drawable.shouye);

        NavItemBuilder orderBuilder = new NavItemBuilder()
                .setCustomerStr("视频").setSelectedStr("视频")
                .setCustomerColor(R.color.color_273261).setSelectedColor(R.color.color_f85f3d)
                .setCustomerDrawable(R.drawable.dianpu);

        NavItemBuilder memberBuilder = new NavItemBuilder()
                .setCustomerStr("设备").setSelectedStr("设备")
                .setCustomerColor(R.color.color_273261).setSelectedColor(R.color.color_f85f3d)
                .setCustomerDrawable(R.drawable.kaoxiang);
        NavItemBuilder mineBuilder = new NavItemBuilder()
                .setCustomerStr("我的").setSelectedStr("我的")
                .setCustomerColor(R.color.color_273261).setSelectedColor(R.color.color_f85f3d)
                .setCustomerDrawable(R.drawable.wode);
        homeView.setBuilder(homeBuilder);
        orderView.setBuilder(orderBuilder);
        memberView.setBuilder(memberBuilder);
        mineView.setBuilder(mineBuilder);
        //预点击
        homeView.clickSelected();
        homeView.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                selectIndex(0);
            }
        });

        orderView.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                selectIndex(1);
            }
        });

        memberView.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                selectIndex(2);
            }
        });
        mineView.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                selectIndex(3);
            }
        });
    }

    public void selectIndex(int index) {
        if (listener!=null&&listener.OnInterceptorListener(index)){
            return;
        }
        if (index < getChildCount()) {
            for (int i = 0; i < getChildCount(); i++) {
                if (getChildAt(i) != null && getChildAt(i) instanceof HomeNavItemView) {
                    HomeNavItemView navItemView = (HomeNavItemView) getChildAt(i);
                    if (index == i) {
                        navItemView.clickSelected();
                    } else {
                        navItemView.clickCustomer();
                    }
                }
            }
            if (listener != null) {
                listener.OnSelectView(index);
            }
        }
    }

    public HomeNavLinearLayout setListener(OnSelectListener listener) {
        this.listener = listener;
        return this;
    }

    public interface OnSelectListener {
        void OnSelectView(int index);

        boolean OnInterceptorListener(int index);
    }

}
