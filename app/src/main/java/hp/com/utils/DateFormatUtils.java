package hp.com.utils;

import android.content.Context;

import hp.com.retrofitdemo.MyApplication;

/**
 * Created by tangdekun on 2017/3/15.
 */

public class DateFormatUtils {

        private static DateFormatUtils instance = null;
            private Context mContext;

            private DateFormatUtils(){
                mContext = MyApplication.mContext;
            }

            public static DateFormatUtils getInstance(){

                        if (instance == null){
                            instance = new DateFormatUtils();
                        }

                return instance;
            }

    public long getCurrentTime(){
        return 1418745237;
    }
}
