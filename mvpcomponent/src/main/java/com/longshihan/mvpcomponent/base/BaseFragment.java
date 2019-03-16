package com.longshihan.mvpcomponent.base;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.longshihan.mvpcomponent.base.delegate.IFragment;
import com.longshihan.mvpcomponent.intergration.cache.Cache;
import com.longshihan.mvpcomponent.intergration.cache.CacheType;
import com.longshihan.mvpcomponent.mvp.IPresenter;
import com.longshihan.mvpcomponent.utils.ArmsUtils;

import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;

/**
 * @author longshihan
 * @time 2017/8/18 10:59
 * @des
 */

public abstract class BaseFragment<P extends IPresenter> extends Fragment implements IFragment {
    protected final String TAG = this.getClass().getSimpleName();
    protected P mPresenter;
    protected Activity mActivity;
    protected Context mContext;
    private Cache mCache;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mActivity = (Activity) context;
        mContext = context;
    }

    public BaseFragment() {
        //必须确保在Fragment实例化时setArguments()
        setArguments(new Bundle());
    }

    @NonNull
    @Override
    public synchronized Cache<String, Object> provideCache() {
        if (mCache == null) {
            mCache = ArmsUtils.obtainAppComponentFromContext(getActivity()).cacheFactory().build(CacheType.FRAGMENT_CACHE);
        }
        return mCache;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = initView(inflater, container, savedInstanceState);
        return view;
    }


    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        getLifecycle().addObserver(mPresenter);
    }

    private CompositeDisposable mCompositeDisposable;
    public void addDispose(Disposable disposable) {
        if (mCompositeDisposable == null) {
            mCompositeDisposable = new CompositeDisposable();
        }
        mCompositeDisposable.add(disposable);//将所有disposable放入,集中处理
    }

    public void unDispose() {
        if (mCompositeDisposable != null) {
            mCompositeDisposable.clear();//保证activity结束时取消所有正在执行的订阅
        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        this.mPresenter = null;
    }
}
