package hp.com.retrofitdemo.inter;


import java.util.Map;

import hp.com.retrofitdemo.bean.JsonBean;
import hp.com.retrofitdemo.bean.SimpleBean;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;
import retrofit2.http.QueryMap;
import rx.Observable;

/**
 * Created by tangdekun on 2017/1/11.
 */

public interface JokeInterf {
    //http://japi.juhe.cn/joke/content/list.from?key=您申请的KEY&page=2&pagesize=10&sort=asc&time=1418745237
    @GET("joke/content/list.from")
    Call<JsonBean> getJokes(@Query("key") String key, @Query("page") int page, @Query("pagesize") int pagesize, @Query("sort") String sort, @Query("time") long time);

    @GET("joke/content/list.from")
    Call<ResponseBody> getJsonBean(@Query("key") String key, @Query("page") int page, @Query("pagesize") int pagesize, @Query("sort") String sort, @Query("time") long time);


    @GET("joke/content/list.from")
    Observable<JsonBean> getJsonBeanByRxJava(@Query("key") String key, @Query("page") int page, @Query("pagesize") int pagesize, @Query("sort") String sort, @Query("time") long time);

    @GET("joke/{content}/{from}")
    Observable<SimpleBean> getSimpleBeanByRxJava(@Path("content") String content,@Path("from")String form, @QueryMap
            Map<String,String>
            options);

    @GET("joke/{content}/{from}")
    Call<SimpleBean> getSimpleBeanWithGET(@Path("content") String content,@Path("from")String form, @QueryMap
            Map<String,String>
            options);

    @POST("joke/{content}/{from}")
    Call<SimpleBean> getSimpleBeanWithPost(@Path("content") String content,@Path("from")String form, @QueryMap
            Map<String,String>
            options);





}
