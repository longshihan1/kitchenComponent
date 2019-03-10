package com.huazhuhotel.module_home.detail.ui.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.huazhuhotel.module_home.R;
import com.longshihan.mvpcomponent.base.BaseMVPFragment;
import com.longshihan.mvpcomponent.base.EmptyPersienter;
import com.longshihan.mvpcomponent.di.component.AppComponent;

/**
 * A simple {@link Fragment} subclass.
 */
public class ReCommendCookFragment  extends BaseMVPFragment {


    public ReCommendCookFragment() {
        // Required empty public constructor
    }


    public void restoreData() {

    }

    @Override
    public View initView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_re_commend_cook, container, false);
    }

    @Override
    public void initData(Bundle savedInstanceState) {
        mPresenter = new EmptyPersienter();
    }

    @Override
    public void setupFragmentComponent(AppComponent appComponent) {

    }
}
