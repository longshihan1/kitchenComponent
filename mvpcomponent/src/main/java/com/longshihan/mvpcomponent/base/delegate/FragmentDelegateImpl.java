package com.longshihan.mvpcomponent.base.delegate;

import android.content.Context;
import android.os.Bundle;
import android.os.Parcel;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.View;

import com.longshihan.mvpcomponent.base.App;


/**
 * {@link FragmentDelegate} 默认实现类
 */

public class FragmentDelegateImpl implements FragmentDelegate {
    private android.support.v4.app.FragmentManager mFragmentManager;
    private android.support.v4.app.Fragment mFragment;
    private IFragment iFragment;


    public FragmentDelegateImpl(android.support.v4.app.FragmentManager fragmentManager, android.support.v4.app.Fragment fragment) {
        this.mFragmentManager = fragmentManager;
        this.mFragment = fragment;
        this.iFragment = (IFragment) fragment;
    }

    @Override
    public void onAttach(Context context) {

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        iFragment.setupFragmentComponent(((App) mFragment.getActivity().getApplication()).getAppComponent());
    }



    @Override
    public void onCreateView(View view, Bundle savedInstanceState) {

    }

    @Override
    public void onActivityCreate(Bundle savedInstanceState) {
        iFragment.initData(savedInstanceState);
    }

    @Override
    public void onStart() {}

    @Override
    public void onResume() {}

    @Override
    public void onPause() {}

    @Override
    public void onStop() {}

    @Override
    public void onSaveInstanceState(Bundle outState) {}

    @Override
    public void onDestroyView() {}

    @Override
    public void onDestroy() {
        this.mFragmentManager = null;
        this.mFragment = null;
        this.iFragment = null;
    }

    @Override
    public void onDetach() {}

    /**
     * Return true if the fragment is currently added to its activity.
     */
    @Override
    public boolean isAdded() {
        return mFragment != null && mFragment.isAdded();
    }

}
