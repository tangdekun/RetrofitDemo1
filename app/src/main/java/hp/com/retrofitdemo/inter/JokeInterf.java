package hp.com.retrofitdemo.inter;

import java.util.List;

import hp.com.retrofitdemo.bean.JokeBean;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by tangdekun on 2017/1/11.
 */

public interface JokeInterf {

    @GET("list.from")
    Call<List<JokeBean>> getJokes(@Query("key") String key, @Query("page") int page,@Query("pagesize") int pagesize,@Query("sort") String sort,@Query("time") long time);

}
