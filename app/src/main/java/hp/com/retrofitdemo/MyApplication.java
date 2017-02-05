package hp.com.retrofitdemo;

import android.app.Application;

import com.hp.zy.utils.tools.CrashHandler;

/**
 * Created by tangdekun on 2017/2/5.
 */

public class MyApplication extends Application {



    @Override
    public void onCreate() {
        super.onCreate();


        CrashHandler crashHandler = CrashHandler.getInstance();
        crashHandler.init(this);
    }
}
