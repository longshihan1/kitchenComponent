package com.huazhuhotel.module_home.main.ui;

import android.os.Bundle;

import com.huazhuhotel.module_home.R;
import com.longshihan.mvpcomponent.base.BaseActivity;
import com.longshihan.mvpcomponent.di.component.AppComponent;

public class DOUGUOActivity extends BaseActivity {


    @Override
    public void setupActivityComponent(AppComponent appComponent) {

    }

    @Override
    public int initView(Bundle savedInstanceState) {
        return R.layout.activity_douguo;
    }

    @Override
    public void initData() {

    }

    @Override
    public boolean useFragment() {
        return true;
    }


}
