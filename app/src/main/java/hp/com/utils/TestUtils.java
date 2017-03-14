package hp.com.utils;

import android.content.Context;

import hp.com.retrofitdemo.MyApplication;
import retrofit2.Retrofit;

/**
 * Created by tangdekun on 2017/3/14.
 */

public class TestUtils {

    private static TestUtils instance = null;
        private Context mContext;

        private TestUtils(){
            mContext = MyApplication.mContext;
        }

        public TestUtils getInstance(){
            if (instance==null){
                synchronized (this){
                    if (instance == null){
                        instance = new TestUtils();
                    }
                }
            }
            return instance;
        }

}
