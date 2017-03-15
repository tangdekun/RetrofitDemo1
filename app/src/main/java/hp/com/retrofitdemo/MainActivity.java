package hp.com.retrofitdemo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import java.util.List;

import hp.com.retrofitdemo.bean.JokeBean;
import hp.com.retrofitdemo.bean.JsonBean;
import hp.com.retrofitdemo.inter.JokeInterf;
import hp.com.rxjava.RxJavaActivity;
import hp.com.utils.RetrofitCreateUtils;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class MainActivity extends AppCompatActivity  implements View.OnClickListener{

    //http://japi.juhe.cn/joke/content/list.from?key=您申请的KEY&page=2&pagesize=10&sort=asc&time=1418745237
    private static final String TAG = "MainActivity";
    Retrofit mRetrofit;
    TextView mTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mTextView = (TextView) findViewById(R.id.tv);
        mRetrofit = RetrofitCreateUtils.getInstance().createRetrofit(Constant.BASE_URL);


        JokeInterf jokeInterf = mRetrofit.create(JokeInterf.class);
//        CallJsonBean(jokeInterf);


//        Call<ResponseBody> jsonBeanCall = jokeInterf.getJsonBean("383d032d43bb6e903eaccb9ed232c30c",1,20,"asc",1418745237);
//        jsonBeanCall.enqueue(new Callback<ResponseBody>() {
//            @Override
//            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
//                Log.d(TAG,response.toString());
//                Gson gson = new Gson();
//                JsonBean jsonBean = null;
//                try {
//                    jsonBean = gson.fromJson(response.body().string(),new TypeToken<JsonBean>(){}.getType());
//
//
//
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//                List<JokeBean> datas = jsonBean.getResult().getDatas();
//                StringBuilder sb = new StringBuilder();
//
//                for (JokeBean jokeBean : datas){
//                   sb.append(jokeBean.getContent()+"\n");
//                    sb.append(jokeBean.getUpdatetime()+"\n");
//                }
//
//                mTextView.setText(response.toString()+jsonBean.getError_code()+jsonBean.getReason()+"\n"+sb.toString());
//                Toast.makeText(MainActivity.this, "tdk"+response.toString(), Toast.LENGTH_SHORT).show();
//            }
//
//            @Override
//            public void onFailure(Call<ResponseBody> call, Throwable t) {
//                Log.d(TAG,t.toString());
//                mTextView.setText(t.toString());
//                Toast.makeText(MainActivity.this, "tdk"+t.toString(), Toast.LENGTH_SHORT).show();
//            }
//        });
//
//        CompositeSubscription mSubscriptions = new CompositeSubscription();
//        mSubscriptions.add(
//                 jokeInterf.getJsonBeanByRxJava("383d032d43bb6e903eaccb9ed232c30c", 1, 20, "asc", 1418745237)
//                        .subscribeOn(Schedulers.io())
//                        .observeOn(AndroidSchedulers.mainThread())
//                        .subscribe(new Observer<JsonBean>() {
//                            @Override
//                            public void onCompleted() {
//
//                            }
//
//                            @Override
//                            public void onError(Throwable e) {
//
//                            }
//
//                            @Override
//                            public void onNext(JsonBean jsonBean) {
//                                List<JokeBean> datas = jsonBean.getResult().getDatas();
//                                StringBuilder sb = new StringBuilder();
//                                for (JokeBean jokeBean : datas) {
//                                    sb.append(jokeBean.getContent() + "1" + "\n");
//                                    sb.append(jokeBean.getUpdatetime() + "1" + "\n");
//                                }
//                                mTextView.setText(jsonBean.getError_code() + jsonBean.getReason() + "\n" + sb.toString());
//                            }
//                        })
//
//        );
    }

    private void CallJsonBean(JokeInterf jokeInterf) {
        Call<JsonBean> listCall = jokeInterf.getJsonBean("383d032d43bb6e903eaccb9ed232c30c",1,20,"asc",1418745237);
        listCall.enqueue(new Callback<JsonBean>() {
            @Override
            public void onResponse(Call<JsonBean> call, Response<JsonBean> response) {
                JsonBean jsonBean = response.body();
                List<JokeBean> datas = jsonBean.getResult().getDatas();

                StringBuilder sb = new StringBuilder();
                for (JokeBean jokeBean : datas){
                    sb.append(jokeBean.getContent()+"1"+"\n");
                    sb.append(jokeBean.getUpdatetime()+"1"+"\n");
                }

                mTextView.setText(response.toString()+jsonBean.getError_code()+jsonBean.getReason()+"\n"+sb.toString());
            }

            @Override
            public void onFailure(Call<JsonBean> call, Throwable t) {

            }
        });
    }

    @Override
    public void onClick(View view) {
        switch(view.getId()){
            case R.id.rxjava_bt:
                startActivity(new Intent(MainActivity.this, RxJavaActivity.class));
            break;
            case R.id.retrofit_bt:
                startActivity(new Intent(MainActivity.this,Main2Activity.class));
            break;
        }

    }
}

