package com.longshihan.mvpcomponent.base;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.longshihan.mvpcomponent.base.delegate.IActivity;
import com.longshihan.mvpcomponent.intergration.cache.Cache;
import com.longshihan.mvpcomponent.intergration.cache.CacheType;
import com.longshihan.mvpcomponent.intergration.lifecycle.ActivityLifecycleable;
import com.longshihan.mvpcomponent.mvp.IPresenter;
import com.longshihan.mvpcomponent.utils.ArmsUtils;
import com.trello.rxlifecycle2.android.ActivityEvent;

import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.subjects.BehaviorSubject;
import io.reactivex.subjects.Subject;
import timber.log.Timber;



/**
 * @author longshihan
 * @time 2017/8/17 14:43
 * @des 因为java只能单继承, 所以如果有需要继承特定Activity的三方库, 那你就需要自己自定义Activity，
 * 继承于这个特定的Activity,然后按照将BaseActivity的格式,复制过去记住一定要实现{@link IActivity}
 */

public abstract class BaseMVPActivity<P extends IPresenter> extends AppCompatActivity implements IActivity,ActivityLifecycleable {
    protected final String TAG = this.getClass().getSimpleName();
    protected P mPresenter;
    private final BehaviorSubject<ActivityEvent> mLifecycleSubject = BehaviorSubject.create();
    private Cache mCache;

    @NonNull
    @Override
    public synchronized Cache<String, Object> provideCache() {
        if (mCache == null) {
            mCache = ArmsUtils.obtainAppComponentFromContext(this).cacheFactory().build(CacheType.ACTIVITY_CACHE);
        }
        return mCache;
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        try {
            int layoutResID = initView(savedInstanceState);
            if (layoutResID != 0) {
                setContentView(layoutResID);
            }
        } catch (Exception e) {
            Timber.w(e.getMessage());
            e.printStackTrace();
        }
    }

    @Override
    protected void onStart() {
        super.onStart();
        if (mPresenter!=null) {
            getLifecycle().addObserver(mPresenter);
        }
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

    @NonNull
    @Override
    public final Subject<ActivityEvent> provideLifecycleSubject() {
        return mLifecycleSubject;
    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        this.mPresenter = null;
    }

    @Override
    public boolean useFragment() {
        return false;
    }
}
