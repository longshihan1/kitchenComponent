package com.huazhuhotel.module_home.detail.persenter;

import android.text.TextUtils;
import android.widget.Toast;

import com.huazhuhotel.module_home.detail.model.CommentInfoModel;
import com.huazhuhotel.module_home.detail.model.GoodsDetailModel;
import com.huazhuhotel.module_home.detail.model.ICommentInfoModel;
import com.huazhuhotel.module_home.detail.model.IGoodsDetailModel;
import com.huazhuhotel.module_home.mvp.model.CommentListInfo;
import com.huazhuhotel.module_home.mvp.model.CommentUploadInfo;
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

public class CommentDetailPersenter extends BasePresenter<CommentDetailContract.View> implements CommentDetailContract.Presenter {
    private ICommentInfoModel mIModel;

    public CommentDetailPersenter(CommentDetailContract.View rootView, IRepositoryManager manager) {
        super(rootView);
        mIModel = new CommentInfoModel(manager);
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
    public void putCommentUpload(String repiceId, String userId, String content) {
        Disposable disposable = mIModel.putCommentInfo(repiceId,userId,content)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<CommentUploadInfo>() {
                    @Override
                    public void accept(@NonNull CommentUploadInfo info) throws Exception {
                        mRootView.putCommentInfo(info);
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
