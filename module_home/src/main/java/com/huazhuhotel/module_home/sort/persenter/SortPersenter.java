package com.huazhuhotel.module_home.sort.persenter;

import com.huazhuhotel.module_home.main.model.DOUGUOModel;
import com.huazhuhotel.module_home.main.model.IDOUGUOModel;
import com.huazhuhotel.module_home.mvp.model.HomeInfo;
import com.huazhuhotel.module_home.mvp.model.SortInfo;
import com.huazhuhotel.module_home.sort.model.ISortModel;
import com.huazhuhotel.module_home.sort.model.SortModel;
import com.longshihan.mvpcomponent.mvp.BasePresenter;
import com.longshihan.mvpcomponent.mvp.IRepositoryManager;

import java.util.logging.Logger;

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

public class SortPersenter extends BasePresenter<SortContract.View> implements SortContract.Presenter {
    private ISortModel mIModel;

    public SortPersenter(SortContract.View rootView, IRepositoryManager manager) {
        super(rootView);
        mIModel = new SortModel(manager);
    }

    @Override
    public void getSortInfo() {
        Disposable disposable = mIModel.getSortInfo()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<SortInfo>() {
                    @Override
                    public void accept(@NonNull SortInfo sortInfo) throws Exception {
                        mRootView.getSortInfo(sortInfo);
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        com.orhanobut.logger.Logger.e(throwable,"sss");
                    }
                });
        addDispose(disposable);
    }
}
