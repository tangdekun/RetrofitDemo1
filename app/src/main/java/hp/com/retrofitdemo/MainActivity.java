package hp.com.retrofitdemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import java.util.List;

import hp.com.retrofitdemo.bean.JokeBean;
import hp.com.retrofitdemo.inter.JokeInterf;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";
    Retrofit mRetrofit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mRetrofit = new Retrofit.Builder()
                .baseUrl("http://japi.juhe.cn/joke/content/")
                .addConverterFactory(GsonConverterFactory.create())

                .build();
        JokeInterf jokeInterf = mRetrofit.create(JokeInterf.class);
        Call<List<JokeBean>> listCall = jokeInterf.getJokes("383d032d43bb6e903eaccb9ed232c30c",1,20,"asc",1418745237);
        listCall.enqueue(new Callback<List<JokeBean>>() {
            @Override
            public void onResponse(Call<List<JokeBean>> call, Response<List<JokeBean>> response) {
                Log.d(TAG,response.toString());
            }

            @Override
            public void onFailure(Call<List<JokeBean>> call, Throwable t) {
                Log.d(TAG,t.toString());
            }
        });


    }
}
