package com.huazhuhotel.module_home.attention.persenter;

import com.huazhuhotel.module_home.attention.model.FollowModel;
import com.huazhuhotel.module_home.attention.model.IFollowModel;
import com.huazhuhotel.module_home.mvp.model.FollowInfo;
import com.longshihan.mvpcomponent.mvp.BasePresenter;
import com.longshihan.mvpcomponent.mvp.IRepositoryManager;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by LONGHE001.
 *
 * @time 2019/3/4 0004
 * @des
 * @function
 */

public class FollowPersenter extends BasePresenter<FollowContract.View> implements FollowContract.Presenter {
    private IFollowModel mIModel;

    public FollowPersenter(FollowContract.View rootView, IRepositoryManager manager) {
        super(rootView);
        mIModel = new FollowModel(manager);
    }

    @Override
    public void getFollowInfo(String userId, String fid) {
        Disposable disposable = mIModel.getFollowInfo(userId, fid)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<FollowInfo>() {
                    @Override
                    public void accept(@NonNull FollowInfo info) throws Exception {
                        mRootView.getFollowInfo(info);
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        com.orhanobut.logger.Logger.e(throwable, "sss");
                    }
                });
        addDispose(disposable);
    }

    @Override
    public void getunFollowInfo(String userId, String fid) {
        Disposable disposable = mIModel.getunFollowInfo(userId, fid)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<FollowInfo>() {
                    @Override
                    public void accept(@NonNull FollowInfo info) throws Exception {
                        mRootView.getunFollowInfo(info);
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        com.orhanobut.logger.Logger.e(throwable, "sss");
                    }
                });
        addDispose(disposable);
    }
}
