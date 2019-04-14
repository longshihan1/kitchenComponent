package com.huazhuhotel.module_home.list.persenter;

import com.huazhuhotel.module_home.list.model.ISearchModel;
import com.huazhuhotel.module_home.list.model.SearchModel;
import com.huazhuhotel.module_home.mvp.model.SearchInfo;
import com.huazhuhotel.module_home.mvp.model.SortInfo;
import com.huazhuhotel.module_home.sort.model.ISortModel;
import com.huazhuhotel.module_home.sort.model.SortModel;
import com.huazhuhotel.module_home.sort.persenter.SortContract;
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

public class ListPersenter extends BasePresenter<ListContract.View> implements ListContract.Presenter {
    private ISearchModel mIModel;

    public ListPersenter(ListContract.View rootView, IRepositoryManager manager) {
        super(rootView);
        mIModel = new SearchModel(manager);
    }


    @Override
    public void getListInfo(int page,int endpage, String searchValue, int type) {
        Disposable disposable = mIModel.getSeachInfo(page,endpage, searchValue, type)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<SearchInfo>() {
                    @Override
                    public void accept(@NonNull SearchInfo sortInfo) throws Exception {
                        mRootView.getListInfo(sortInfo);
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
