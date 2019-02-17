package com.longshihan.mvpcomponent.strategy.imageloader.glide;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.GlideBuilder;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions;
import com.longshihan.mvpcomponent.strategy.imageloader.BaseImageLoaderStrategy;
import com.longshihan.mvpcomponent.strategy.imageloader.glide.GlideTransformation.GlideTransform;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;


/**
 * @author Administrator
 * @time 2017/8/10 16:00
 * @des 类作用：管理Glide控制器
 * 此类只是简单的实现了 Glide 加载的策略,方便快速使用,但大部分情况会需要应对复杂的场景
 * 这时可自行实现 {@link BaseImageLoaderStrategy} 和 {@link ImageConfigImpl} 替换现有策略
 */

public class GlideImageLoaderStrategy implements BaseImageLoaderStrategy<ImageConfigImpl>,
        GlideAppliesOptions {

    @Override
    public void loadImage(Context ctx, ImageConfigImpl config) {
        if (config == null)
            throw new NullPointerException("ImageConfigImpl is required");
        if (config.getGlideRequest()!=null){
            config.getGlideRequest().into(config.getImageView());
        }else {
            if (ctx == null)
                throw new NullPointerException("Context is required");
            if (TextUtils.isEmpty(config.getUrl()))
                throw new NullPointerException("Url is required");
            if (config.getImageView() == null)
                throw new NullPointerException("Imageview is required");

            GlideRequests requests;

            requests = GlideArms.with(ctx);//如果context是activity则自动使用Activity的生命周期
            GlideRequest<Drawable> glideRequest = requests.load(config.getUrl())
                    .transition(DrawableTransitionOptions.withCrossFade())
                    .centerCrop();

            switch (config.getCacheStrategy()) {//缓存策略
                case 0:
                    glideRequest.diskCacheStrategy(DiskCacheStrategy.ALL);
                    break;
                case 1:
                    glideRequest.diskCacheStrategy(DiskCacheStrategy.NONE);
                    break;
                case 2:
                    glideRequest.diskCacheStrategy(DiskCacheStrategy.RESOURCE);
                    break;
                case 3:
                    glideRequest.diskCacheStrategy(DiskCacheStrategy.DATA);
                    break;
                case 4:
                    glideRequest.diskCacheStrategy(DiskCacheStrategy.AUTOMATIC);
                    break;
                default:
                    glideRequest.diskCacheStrategy(DiskCacheStrategy.ALL);
                    break;
            }
            if (config.getTransformation() != null) {//glide用它来改变图形的形状
                glideRequest.transform(config.getTransformation());
            } else {
                glideRequest.transform(new GlideTransform());
            }
            if (config.getPlaceholder() != 0)//设置占位符
                glideRequest.placeholder(config.getPlaceholder());

            if (config.getErrorPic() != 0)//设置错误的图片
                glideRequest.error(config.getErrorPic());

            if (config.getFallback() != 0)//设置请求 url 为空图片
                glideRequest.fallback(config.getFallback());
            glideRequest.into(config.getImageView());
        }
    }

    @Override
    public void clear(final Context ctx, ImageConfigImpl config) {
        if (ctx == null)
            throw new NullPointerException("Context is required");
        if (config == null)
            throw new NullPointerException("ImageConfigImpl is required");

        if (config.getImageViews() != null && config.getImageViews().length > 0) {//取消在执行的任务并且释放资源
            for (ImageView imageView : config.getImageViews()) {
                GlideArms.get(ctx).getRequestManagerRetriever().get(ctx).clear(imageView);
            }
        }

        if (config.isClearDiskCache()) {//清除本地缓存
            Observable.just(0)
                    .observeOn(Schedulers.io())
                    .subscribe(integer -> Glide.get(ctx).clearDiskCache());
        }

        if (config.isClearMemory()) {//清除内存缓存
            Observable.just(0)
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(integer -> Glide.get(ctx).clearMemory());
        }

    }


    @Override
    public void applyGlideOptions(Context context, GlideBuilder builder) {
    }
}
