package hp.com.utils;

import android.content.Context;

import hp.com.retrofitdemo.MyApplication;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by tangdekun on 2017/3/14.
 */

public class RetrofitCreateUtils {

    private static RetrofitCreateUtils instance = null;
    private Context mContext;

    private RetrofitCreateUtils() {
        mContext = MyApplication.mContext;
    }

    public static RetrofitCreateUtils getInstance() {
                if (instance == null) {
                    instance = new RetrofitCreateUtils();
                }
        return instance;
    }

    /**
     * @param baseUrl
     * @return 创建Retrofit对象
     */
    public  Retrofit createRetrofit(String baseUrl) {
        // 调试网络请求的时候经常需要关注一下请求参数和返回值，以便判断和定位问题出在哪里，Retrofit官方提供了一个很方便查看日志的Interceptor，
        // 你可以控制你需要的打印信息类型，使用方法也很简单。
        //HttpLoggingInterceptor提供了4中控制打印信息类型的等级，分别是NONE，BASIC，HEADERS，BODY
        //NONE  没有任何日志信息
        //BASIC 打印请求类型，URL，请求体大小，返回值状态以及返回值的大小
        //HEADERS  打印返回请求和返回值的头部信息，请求类型，URL以及返回值状态码
        //BODY 打印请求和返回值的头部和body信息

        HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor();
        httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .addInterceptor(httpLoggingInterceptor)//打印log信息
                .addInterceptor(new CommonInterceptor())//添加公共参数
                .build();

        Retrofit mRetrofit = new Retrofit.Builder()
                .client(okHttpClient)
                .baseUrl(baseUrl)
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create()) //  使用RxJava作为回调适配器
                .addConverterFactory(GsonConverterFactory.create())//使用Gson作为数据转换器
                .build();

        return mRetrofit;

    }


}
