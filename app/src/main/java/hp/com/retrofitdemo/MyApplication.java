package hp.com.retrofitdemo;

import android.app.Application;
import android.content.Context;

import com.hp.zy.utils.tools.CrashHandler;
import com.orhanobut.logger.Logger;

/**
 * Created by tangdekun on 2017/2/5.
 */

public class MyApplication extends Application {
    private final static String TAG = MyApplication.class.getSimpleName();

    public static  Context mContext;



    @Override
    public void onCreate() {
        super.onCreate();
        CrashHandler crashHandler = CrashHandler.getInstance();
        crashHandler.init(this);
        mContext = getApplicationContext();
        setLogger();

    }

    /**
     * 使用Logger架包打印Log信息
     * 完成Logger一些设置
     */
    private void setLogger(){
        Logger
                .init(TAG)                 // default PRETTYLOGGER or use just init()
                .methodCount(3)                 // 显示方法的数量【引用层级】
//                .hideThreadInfo()             // 隐藏线程信息  默认显示
//                .logLevel(LogLevel.NONE)      //默认LogLevel.FULL，在版本发布的时候改为LogLevel.NONE
                .methodOffset(2);               // default 0

    }


}
