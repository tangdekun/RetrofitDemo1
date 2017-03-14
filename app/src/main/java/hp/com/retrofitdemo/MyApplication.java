package hp.com.retrofitdemo;

import android.app.Application;
import android.content.Context;

import com.hp.zy.utils.tools.CrashHandler;

/**
 * Created by tangdekun on 2017/2/5.
 */

public class MyApplication extends Application {

    public static  Context mContext;



    @Override
    public void onCreate() {
        super.onCreate();

        CrashHandler crashHandler = CrashHandler.getInstance();
        crashHandler.init(this);
        mContext = getApplicationContext();

    }


}
