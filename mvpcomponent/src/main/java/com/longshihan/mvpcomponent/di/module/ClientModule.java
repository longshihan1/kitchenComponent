package com.longshihan.mvpcomponent.di.module;

import android.app.Application;
import android.content.Context;
import android.support.annotation.Nullable;

import com.google.gson.Gson;
import com.longshihan.mvpcomponent.error.core.RxErrorHandler;
import com.longshihan.mvpcomponent.error.handler.listener.ResponseErrorListener;
import com.longshihan.mvpcomponent.http.GlobalHttpHandler;
import com.longshihan.mvpcomponent.http.RequestInterceptor;
import com.longshihan.mvpcomponent.utils.DataHelper;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import io.rx_cache2.internal.RxCache;
import io.victoralbertos.jolyglot.GsonSpeaker;
import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Response;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * @author Administrator
 * @time 2017/8/16 16:15
 * @des 类的作用：网络请求相关的module
 */

public class ClientModule {
     private static final int TIME_OUT = 10;

    /**
     * @param builder
     * @param client
     * @param httpUrl
     * @return
     * @author: jess
     * @description:提供retrofit
     */
   public Retrofit provideRetrofit(Application application, @Nullable RetrofitConfiguration configuration,
                             Retrofit.Builder builder, OkHttpClient client,
                             HttpUrl httpUrl, Gson gson) {
        builder.baseUrl(httpUrl)//域名
                .client(client);//设置okhttp

        if (configuration != null)
            configuration.configRetrofit(application, builder);

        builder.addCallAdapterFactory(RxJava2CallAdapterFactory.create())//使用rxjava
                .addConverterFactory(GsonConverterFactory.create(gson));//使用Gson
        return builder.build();
    }

    /**
     * 提供OkhttpClient
     * @param application 上下文
     * @param configuration
     * @param builder
     * @param intercept 请求之前的拦截器
     * @param interceptors 拦截器集合
     * @param handler
     * @return
     */
    public OkHttpClient provideClient(Application application, @Nullable OkhttpConfiguration configuration,
                               OkHttpClient.Builder builder, Interceptor intercept,
                               @Nullable List<Interceptor> interceptors, @Nullable final GlobalHttpHandler handler) {
        builder.connectTimeout(TIME_OUT, TimeUnit.SECONDS)
                .readTimeout(TIME_OUT, TimeUnit.SECONDS)
                .addNetworkInterceptor(intercept);

        if (handler != null)
            builder.addInterceptor(new Interceptor() {
                @Override
                public Response intercept(Chain chain) throws IOException {
                    return chain.proceed(handler.onHttpRequestBefore(chain, chain.request()));
                }
            });

        if (interceptors != null) {//如果外部提供了interceptor的集合则遍历添加
            for (Interceptor interceptor : interceptors) {
                builder.addInterceptor(interceptor);
            }
        }

        if (configuration != null)
            configuration.configOkhttp(application, builder);
        return builder.build();
    }


    public Retrofit.Builder provideRetrofitBuilder() {
        return new Retrofit.Builder();
    }


    public OkHttpClient.Builder provideClientBuilder() {
        return new OkHttpClient.Builder();
    }


    public Interceptor provideInterceptor(RequestInterceptor intercept) {
        return intercept;//打印请求信息的拦截器
    }


    /**
     * 提供RXCache客户端
     *
     * @param cacheDirectory RxCache缓存路径
     * @return
     */
    public RxCache provideRxCache(Application application, @Nullable RxCacheConfiguration configuration, File cacheDirectory) {
        RxCache.Builder builder = new RxCache.Builder();
        if (configuration != null)
            configuration.configRxCache(application, builder);
        return builder.persistence(cacheDirectory, new GsonSpeaker());
    }


    /**
     * 需要单独给RxCache提供缓存路径
     * 提供RxCache缓存地址
     */
    public File provideRxCacheDirectory(File cacheDir) {
        File cacheDirectory = new File(cacheDir, "RxCache");
        return DataHelper.makeDirs(cacheDirectory);
    }

    /**
     * 提供处理Rxjava错误的管理器
     *
     * @return
     */
    public RxErrorHandler proRxErrorHandler(Application application, ResponseErrorListener listener) {
        return RxErrorHandler
                .builder()
                .with(application)
                .responseErrorListener(listener)
                .build();
    }

    public interface RetrofitConfiguration {
        void configRetrofit(Context context, Retrofit.Builder builder);
    }

    public interface OkhttpConfiguration {
        void configOkhttp(Context context, OkHttpClient.Builder builder);
    }

    public interface RxCacheConfiguration {
        void configRxCache(Context context, RxCache.Builder builder);
    }
}
