package com.huazhuhotel.module_home.main.persenter;

import com.huazhuhotel.module_home.main.model.DOUGUOModel;
import com.huazhuhotel.module_home.main.model.IDOUGUOModel;
import com.huazhuhotel.module_home.main.model.IVideoListModel;
import com.huazhuhotel.module_home.main.model.VideoListModel;
import com.huazhuhotel.module_home.mvp.model.HomeInfo;
import com.huazhuhotel.module_home.mvp.model.VideoListInfo;
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

public class VideoPersenter extends BasePresenter<VideoContract.View> implements VideoContract.Presenter {
    private IVideoListModel mIModel;

    public VideoPersenter(VideoContract.View rootView, IRepositoryManager manager) {
        super(rootView);
        mIModel = new VideoListModel(manager);
    }


    @Override
    public void getVideoInfo(String userid, int pageindex) {
        Disposable disposable = mIModel.getVideoListInfo(userid,pageindex)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<VideoListInfo>() {
                    @Override
                    public void accept(@NonNull VideoListInfo homeInfo) throws Exception {
                        mRootView.getVideoInfo(homeInfo);
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
