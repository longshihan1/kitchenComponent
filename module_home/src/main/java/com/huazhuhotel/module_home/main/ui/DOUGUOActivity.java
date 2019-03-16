package com.huazhuhotel.module_home.main.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.widget.FrameLayout;

import com.huazhuhotel.module_home.R;
import com.huazhuhotel.module_home.attention.ui.AttentionActivity;
import com.huazhuhotel.module_home.main.ui.fragment.HomeFragment;
import com.huazhuhotel.module_home.widget.HomeNavLinearLayout;
import com.longshihan.mvpcomponent.base.BaseActivity;
import com.longshihan.mvpcomponent.di.component.AppComponent;

import java.util.ArrayList;
import java.util.List;

public class DOUGUOActivity extends BaseActivity {

    private FrameLayout mainFragment;
    HomeNavLinearLayout navLinearLayout;
    private FragmentManager fragmentManager;
    private HomeFragment homeFragment;
    private HomeFragment noticeFragment;
    private HomeFragment communityFragment;
    private HomeFragment mineFragment;
    private List<Fragment> fragmentList;
    private int index=-1;

    @Override
    public void setupActivityComponent(AppComponent appComponent) {

    }

    @Override
    public int initView(Bundle savedInstanceState) {
        return R.layout.activity_douguo;
    }

    @Override
    public void initData() {
        mainFragment=findViewById(R.id.activity_mainfragment);
        navLinearLayout=findViewById(R.id.activity_mainnavlayout);

        fragmentManager = getSupportFragmentManager();
        homeFragment = new HomeFragment();
        noticeFragment = new HomeFragment();
        communityFragment = new HomeFragment();
        mineFragment = new HomeFragment();

        fragmentList = new ArrayList<>();
        fragmentList.add(homeFragment);
        fragmentList.add(noticeFragment);
        fragmentList.add(communityFragment);
        fragmentList.add(mineFragment);
        addFragmentStack(0);

        navLinearLayout.setListener(new HomeNavLinearLayout.OnSelectListener() {
            @Override
            public void OnSelectView(final int index) {
                //点击了第几个
                addFragmentStack(index);
            }

            @Override
            public boolean OnInterceptorListener(final int index) {
                return false;
            }
        });

    }

    public void addFragmentStack(int position) {
        if (position == index) {
            return;
        }
        this.index = position;
        FragmentTransaction ft = fragmentManager.beginTransaction();
        Fragment fragment = fragmentList.get(position);
        if (!fragment.isAdded()) {
            ft.add(R.id.activity_mainfragment, fragment);
        }
        for (int i = 0; i < fragmentList.size(); i++) {
            if (i == position) {
                ft.show(fragmentList.get(i));
            } else {
                ft.hide(fragmentList.get(i));
            }
        }
        ft.commitAllowingStateLoss();

        if (position == 0) {

        } else if (position == 1) {

        } else if (position == 2) {

        }else if (position==3){
            startActivity(new Intent(this, AttentionActivity.class));
        }
    }
    @Override
    public boolean useFragment() {
        return true;
    }


}
