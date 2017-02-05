package hp.com.retrofitdemo.inter;


import hp.com.retrofitdemo.bean.JsonBean;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;
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
}
