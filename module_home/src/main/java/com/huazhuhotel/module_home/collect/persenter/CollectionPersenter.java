package com.huazhuhotel.module_home.collect.persenter;

import com.huazhuhotel.module_home.collect.model.CollectionModel;
import com.huazhuhotel.module_home.collect.model.ICollectionModel;
import com.huazhuhotel.module_home.main.model.DOUGUOModel;
import com.huazhuhotel.module_home.main.model.IDOUGUOModel;
import com.huazhuhotel.module_home.main.persenter.DOUGUOContract;
import com.huazhuhotel.module_home.mvp.model.CollectionInfo;
import com.huazhuhotel.module_home.mvp.model.HomeInfo;
import com.longshihan.mvpcomponent.mvp.BasePresenter;
import com.longshihan.mvpcomponent.mvp.IRepositoryManager;
import com.orhanobut.logger.Logger;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by LONGHE001.
 *
 * @time 2019/2/27 0027
 * @des
 * @function
 */

public class CollectionPersenter extends BasePresenter<CollectionContract.View> implements CollectionContract.Presenter {
    private ICollectionModel mIModel;

    public CollectionPersenter(CollectionContract.View rootView, IRepositoryManager manager) {
        super(rootView);
        mIModel = new CollectionModel(manager);
    }


    @Override
    public void getCollectionInfo(String id, int pageindex) {
        Disposable disposable = mIModel.getCollectionListInfo(id, pageindex)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<CollectionInfo>() {
                    @Override
                    public void accept(@NonNull CollectionInfo info) throws Exception {
                        mRootView.getCollectInfo(info);
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        Logger.d(throwable);
                    }
                });
        addDispose(disposable);
    }
}
