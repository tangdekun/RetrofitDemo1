package hp.com.utils;

import java.io.IOException;

import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

/**
 *
 * Created by tangdekun on 2017/3/14.
 */

public class CommonInterceptor implements Interceptor {
    @Override
    public Response intercept(Chain chain) throws IOException {
        //设置公共参数
        //拦截原始请求
        Request originalRequest = chain.request();
        HttpUrl modefiedUrl = originalRequest.url().newBuilder()
                .addQueryParameter("key","383d032d43bb6e903eaccb9ed232c30c")
                .build();
         Request request = originalRequest.newBuilder().url(modefiedUrl).build();


        return chain.proceed(request);
    }
}
