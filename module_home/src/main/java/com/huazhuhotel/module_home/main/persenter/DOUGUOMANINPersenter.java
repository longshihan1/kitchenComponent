package com.huazhuhotel.module_home.main.persenter;

import android.support.v4.app.Fragment;

import com.huazhuhotel.module_home.main.model.DOUGUOModel;
import com.huazhuhotel.module_home.main.model.IDOUGUOModel;
import com.huazhuhotel.module_home.mvp.model.HomeInfo;
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
 * @time 2019/2/27 0027
 * @des
 * @function
 */

public class DOUGUOMANINPersenter extends BasePresenter<DOUGUOContract.View> implements DOUGUOContract.Presenter {
    private IDOUGUOModel mIModel;

    public DOUGUOMANINPersenter(DOUGUOContract.View rootView, IRepositoryManager manager) {
        super(rootView);
        mIModel = new DOUGUOModel(manager);
    }

    @Override
    public void getHomeInfd() {
        Disposable disposable = mIModel.getHomeInfo("1")
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<HomeInfo>() {
                    @Override
                    public void accept(@NonNull HomeInfo homeInfo) throws Exception {
                        mRootView.getHomeInfo(homeInfo);
                    }
                });
        addDispose(disposable);
    }
}
