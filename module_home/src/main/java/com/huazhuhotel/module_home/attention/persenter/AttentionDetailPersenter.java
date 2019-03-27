package com.huazhuhotel.module_home.attention.persenter;

import com.huazhuhotel.module_home.attention.model.AttentionDetailModel;
import com.huazhuhotel.module_home.attention.model.IAttentionDetailModel;
import com.huazhuhotel.module_home.main.model.IMINEModel;
import com.huazhuhotel.module_home.main.model.MINEModel;
import com.huazhuhotel.module_home.mvp.model.UnRecipesListInfo;
import com.huazhuhotel.module_home.mvp.model.UserInfo;
import com.huazhuhotel.module_home.mvp.model.UserNoteInfo;
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

public class AttentionDetailPersenter extends BasePresenter<AttentionDetailContract.View> implements AttentionDetailContract.Presenter {
    private IMINEModel mIModel;
    private IAttentionDetailModel detailModel;
    public AttentionDetailPersenter(AttentionDetailContract.View rootView, IRepositoryManager manager) {
        super(rootView);
        mIModel = new MINEModel(manager);
        detailModel=new AttentionDetailModel(manager);
    }


    @Override
    public void getUserInfo(String userId) {
        Disposable disposable = mIModel.getUserInfo(userId)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<UserInfo>() {
                    @Override
                    public void accept(@NonNull UserInfo info) throws Exception {
                        mRootView.getUserInfo(info);
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
    public void getUnRecipesListInfo(String userId, int page) {
        Disposable disposable = detailModel.getUnRecipesListInfo(userId,page)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<UnRecipesListInfo>() {
                    @Override
                    public void accept(@NonNull UnRecipesListInfo info) throws Exception {
                        mRootView.getUnRecipesListInfo(info);
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
    public void getUserNoteListInfo(String userId, int page) {
        Disposable disposable = detailModel.getUserNoteInfo(userId,page)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<UserNoteInfo>() {
                    @Override
                    public void accept(@NonNull UserNoteInfo info) throws Exception {
                        mRootView.getUserNoteListInfo(info);
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
