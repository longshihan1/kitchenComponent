package debug.module_home.app;

import android.app.Application;
import android.content.Context;
import android.support.v4.app.FragmentManager;

import com.google.gson.GsonBuilder;
import com.huazhuhotel.module_home.http.ApiService;
import com.longshihan.mvpcomponent.BuildConfig;
import com.longshihan.mvpcomponent.base.delegate.AppLifecycles;
import com.longshihan.mvpcomponent.di.module.AppModule;
import com.longshihan.mvpcomponent.di.module.ClientModule;
import com.longshihan.mvpcomponent.di.module.GlobalConfigModule;
import com.longshihan.mvpcomponent.http.RequestInterceptor;
import com.longshihan.mvpcomponent.http.base.ActivityLifecycleCallbacksImpl;
import com.longshihan.mvpcomponent.http.base.FragmentLifecycleCallbacksImpl;
import com.longshihan.mvpcomponent.http.base.GlobalHttpHandlerImpl;
import com.longshihan.mvpcomponent.http.base.OkHttpConfig;
import com.longshihan.mvpcomponent.http.base.ResponseErrorListenerImpl;
import com.longshihan.mvpcomponent.intergration.ConfigModule;
import com.longshihan.mvpcomponent.utils.PreferenceUtils;

import java.util.List;

import io.rx_cache2.internal.RxCache;
import retrofit2.Retrofit;

/**
 * Created by LONGHE001.
 *
 * @time 2019/2/27 0027
 * @des
 * @function
 */

public class GlobalConfiguration implements ConfigModule {

    /**
     * 在application初始化的时候使用
     *
     * @param context
     * @param builder
     */
    @Override
    public void applyOptions(Context context, GlobalConfigModule.Builder builder) {
        PreferenceUtils.init(context);

//        if (!BuildConfig.DEBUG) {
            builder.printHttpLogLevel(RequestInterceptor.Level.ALL);
//        }
        //如果 BaseUrl 在 App 启动时不能确定,需要请求服务器接口动态获取,请使用以下代码
        //并且使用 Okhttp (AppComponent中提供) 请求服务器获取到正确的 BaseUrl 后赋值给 GlobalConfiguration.sDomain
        //切记整个过程必须在第一次调用 Retrofit 接口之前完成,如果已经调用过 Retrofit 接口,将不能动态切换 BaseUrl
        //                .baseurl(new BaseUrl() {
        //                    @Override
        //                    public HttpUrl url() {
        //                        return HttpUrl.parse(sDomain);
        //                    }
        //                })
        //统一注入到ClientModule里面对OKhttp做操作

        builder.baseurl(ApiService.DOUGUO_API)
                .globalHttpHandler(new GlobalHttpHandlerImpl())
                .responseErrorListener(new ResponseErrorListenerImpl())
                .gsonConfiguration(new AppModule.GsonConfiguration() {
                    @Override
                    public void configGson(Context context, GsonBuilder builder) {
                        //这里可以自己自定义配置Gson的参数
                        builder.serializeNulls()//支持序列化null的参数
                                .enableComplexMapKeySerialization();//支持将序列化key为object的map,
                        // 默认只能序列化key为string的map

                    }
                })
                .okhttpConfiguration(new OkHttpConfig())
                .retrofitConfiguration(new ClientModule.RetrofitConfiguration() {
                    @Override
                    public void configRetrofit(Context context, Retrofit.Builder builder) {
                        //这里可以自己自定义配置Retrofit的参数,甚至你可以替换系统配置好的okhttp对象
                        //   retrofitBuilder.addConverterFactory(FastJsonConverterFactory.create
                        // ());//比如使用fastjson替代gson

                    }
                })
                .rxCacheConfiguration(new ClientModule.RxCacheConfiguration() {
                    @Override
                    public void configRxCache(Context context, RxCache.Builder builder) {
                        builder.useExpiredDataIfLoaderNotAvailable(true);
                    }
                })
                .build();

    }

    @Override
    public void injectAppLifecycle(Context context, List<AppLifecycles> lifecycles) {
        lifecycles.add(new AppLifecyclesImpl());
    }

    /**
     * 将所有的处理加载到lifecycles里面，会在{@link com.longshihan.mvpcomponent.intergration.ActivityLifecycle}里面进行二次加载
     * 在里面像
     * 1.AppManager的操作已经实现
     *
     * @param context
     * @param lifecycles
     */
    @Override
    public void injectActivityLifecycle(Context context, List<Application.ActivityLifecycleCallbacks> lifecycles) {
        lifecycles.add(new ActivityLifecycleCallbacksImpl());
    }

    @Override
    public void injectFragmentLifecycle(Context context, List<FragmentManager.FragmentLifecycleCallbacks> lifecycles) {
        lifecycles.add(new FragmentLifecycleCallbacksImpl());
    }

}
