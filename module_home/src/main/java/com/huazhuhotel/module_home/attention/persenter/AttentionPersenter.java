package com.huazhuhotel.module_home.attention.persenter;

import com.huazhuhotel.module_home.attention.model.AttentionModel;
import com.huazhuhotel.module_home.attention.model.IAttentionModel;
import com.huazhuhotel.module_home.detail.model.GoodsDetailModel;
import com.huazhuhotel.module_home.detail.model.IGoodsDetailModel;
import com.huazhuhotel.module_home.detail.persenter.GoodsDetailContract;
import com.huazhuhotel.module_home.mvp.model.AttentionInfo;
import com.huazhuhotel.module_home.mvp.model.GoodsDetailInfo;
import com.huazhuhotel.module_home.mvp.model.ReCommondInfo;
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

public class AttentionPersenter extends BasePresenter<AttentionContract.View> implements AttentionContract.Presenter {
    private IAttentionModel mIModel;

    public AttentionPersenter(AttentionContract.View rootView, IRepositoryManager manager) {
        super(rootView);
        mIModel = new AttentionModel(manager);
    }


    @Override
    public void getAttentionInfo(String id) {
        Disposable disposable = mIModel.getAttentionInfo(id)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<AttentionInfo>() {
                    @Override
                    public void accept(@NonNull AttentionInfo info) throws Exception {
                        mRootView.getAtentionInfo(info);
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
