package debug.module_home.app;

import android.app.Application;
import android.content.Context;

import com.longshihan.mvpcomponent.BuildConfig;
import com.longshihan.mvpcomponent.base.delegate.AppLifecycles;
import com.orhanobut.logger.AndroidLogAdapter;
import com.orhanobut.logger.FormatStrategy;
import com.orhanobut.logger.Logger;
import com.orhanobut.logger.PrettyFormatStrategy;

import timber.log.Timber;

/**
 * Created by LONGHE001.
 *
 * @time 2019/2/27 0027
 * @des
 * @function
 */

public class AppLifecyclesImpl implements AppLifecycles {
    @Override
    public void attachBaseContext(Context base) {

    }

    @Override
    public void onCreate(Application application) {
        if (BuildConfig.DEBUG) {//Timber初始化
            //Timber 是一个日志框架容器,外部使用统一的Api,内部可以动态的切换成任何日志框架(打印策略)进行日志打印
            //并且支持添加多个日志框架(打印策略),做到外部调用一次 Api,内部却可以做到同时使用多个策略
            //比如添加三个策略,一个打印日志,一个将日志保存本地,一个将日志上传服务器
            Timber.plant(new Timber.DebugTree());
            // 如果你想将框架切换为 Logger 来打印日志,请使用下面的代码,如想切换为其他日志框架请根据下面的方式扩展
            //
            //                    Timber.plant(new Timber.DebugTree() {
            //                        @Override
            //                        protected void log(int priority, String tag, String message, Throwable t) {
            //                            Logger.log(priority, tag, message, t);
            //                        }
            //                    });
            //leakCanary内存泄露检查
        }

        FormatStrategy formatStrategy = PrettyFormatStrategy.newBuilder()
                .showThreadInfo(false)  //是否选择显示线程信息，默认为true
                .methodCount(0)         //方法数显示多少行，默认2行
                .methodOffset(7)        //隐藏方法内部调用到偏移量，默认5
                .tag("DOUGUO")   //自定义TAG全部标签，默认PRETTY_LOGGER
                .build();
        Logger.addLogAdapter(new AndroidLogAdapter(formatStrategy));

    }

    @Override
    public void onTerminate(Application application) {

    }
}
