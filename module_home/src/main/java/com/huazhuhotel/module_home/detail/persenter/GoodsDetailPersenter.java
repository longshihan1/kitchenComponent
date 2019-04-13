package com.huazhuhotel.module_home.detail.persenter;

import android.text.TextUtils;

import com.huazhuhotel.module_home.detail.model.IGoodsDetailModel;
import com.huazhuhotel.module_home.detail.model.GoodsDetailModel;
import com.huazhuhotel.module_home.mvp.model.CollectCancelInfo;
import com.huazhuhotel.module_home.mvp.model.CollectaddInfo;
import com.huazhuhotel.module_home.mvp.model.CommentListInfo;
import com.huazhuhotel.module_home.mvp.model.GoodsDetailInfo;
import com.huazhuhotel.module_home.mvp.model.ReCommondInfo;
import com.huazhuhotel.module_home.mvp.model.SearchInfo;
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

public class GoodsDetailPersenter extends BasePresenter<GoodsDetailContract.View> implements GoodsDetailContract.Presenter {
    private IGoodsDetailModel mIModel;

    public GoodsDetailPersenter(GoodsDetailContract.View rootView, IRepositoryManager manager) {
        super(rootView);
        mIModel = new GoodsDetailModel(manager);
    }



    @Override
    public void getGoodsDetailInfo(String goodsId) {
        Disposable disposable = mIModel.getGoodsDetailInfo(goodsId)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<GoodsDetailInfo>() {
                    @Override
                    public void accept(@NonNull GoodsDetailInfo info) throws Exception {
                        mRootView.getGoodsDetailInfo(info);
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
    public void getRecommendInfo(String goodsId) {
        Disposable disposable = mIModel.getReCommendInfo(goodsId)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<ReCommondInfo>() {
                    @Override
                    public void accept(@NonNull ReCommondInfo info) throws Exception {
                        mRootView.getRecommondInfo(info);
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
    public void getCommentList(String id, int pageIndex) {
        Disposable disposable = mIModel.getCommentList(id,pageIndex)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<CommentListInfo>() {
                    @Override
                    public void accept(@NonNull CommentListInfo info) throws Exception {
                        mRootView.getCommentList(info);
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
    public void onCollection(boolean collect, String receID, String userId) {
        if (!collect){
            Disposable disposable = mIModel.addCollection(receID,userId)
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(new Consumer<CollectaddInfo>() {
                        @Override
                        public void accept(@NonNull CollectaddInfo info) throws Exception {
                           if (info!=null&&!TextUtils.isEmpty(info.getState())&&"success".equals(info.getState())){
                               mRootView.onCollection(1);
                           }
                        }
                    }, new Consumer<Throwable>() {
                        @Override
                        public void accept(Throwable throwable) throws Exception {
                            com.orhanobut.logger.Logger.e(throwable, "sss");
                        }
                    });
            addDispose(disposable);
        }else {
            Disposable disposable = mIModel.cancelCollection(receID,userId)
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(new Consumer<CollectCancelInfo>() {
                        @Override
                        public void accept(@NonNull CollectCancelInfo info) throws Exception {
                            if (info!=null&&!TextUtils.isEmpty(info.getState())&&"success".equals(info.getState())){
                                mRootView.onCollection(2);
                            }
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
}
