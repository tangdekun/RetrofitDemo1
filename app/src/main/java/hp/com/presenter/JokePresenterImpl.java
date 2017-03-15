package hp.com.presenter;

import android.os.Handler;
import android.os.Message;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.orhanobut.logger.Logger;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import hp.com.contract.JokeContract;
import hp.com.retrofitdemo.Constant;
import hp.com.retrofitdemo.bean.JsonBean;
import hp.com.retrofitdemo.inter.JokeInterf;
import hp.com.utils.DateFormatUtils;
import hp.com.utils.RetrofitCreateUtils;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;
import rx.subscriptions.CompositeSubscription;

/**
 * Created by tangdekun on 2017/03/14
 */

public class JokePresenterImpl implements JokeContract.Presenter {
    private static final String TAG = JokePresenterImpl.class.getSimpleName();

    private JokeContract.View view;
    private JokeContract.Model model;
    private Retrofit retrofit;
    private int pageSize = 20;
    private Gson gson;


    public JokePresenterImpl() {
        retrofit = RetrofitCreateUtils.getInstance().createRetrofit(Constant.BASE_URL);
        gson = new Gson();
    }




    @Override
    public void onViewAttached(JokeContract.View view) {

        this.view = view;
    }

    @Override
    public void onViewDetached() {
        this.view = null;

    }

    @Override
    public void onDestory() {

    }

    @Override
    public void getData(int page) {
        JokeInterf   mJokeInterf = retrofit.create(JokeInterf.class);
//        getDataResponseBody(page, mJokeInterf);
//        getDataJackBean(page, mJokeInterf);
//        getDataWithObservable(page,mJokeInterf);
//          getDataJackBeanSync(page,mJokeInterf);
        getDataWithPost(page,mJokeInterf);
    }

    /**
     * 不进行数据转换，response.body().string()即为json数据
     * @param page
     * @param mJokeInterf
     */
    private void getDataResponseBody(int page, JokeInterf mJokeInterf) {
        Call<ResponseBody> responseBodyCall = mJokeInterf.getJokes(null,page,pageSize,"desc", DateFormatUtils
                        .getInstance().getCurrentTime()
                );
        responseBodyCall.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                response.body().toString();
                try {
                    Logger.t(TAG).json(response.body().string());
                } catch (IOException e) {
                    e.printStackTrace();
                }
                JsonBean jsonBean = null;
                try {
                    jsonBean = gson.fromJson(response.body().string(),new TypeToken<JsonBean>(){}.getType());
                } catch (IOException e) {
                    e.printStackTrace();
                }

                try {
//                    Logger.t(TAG).d(jsonBean.getResult().getDatas().get(0).getContent());
                    view.fillRecyclerViewdata(jsonBean.getResult().getDatas());

                } catch (Exception e) {
                    e.printStackTrace();
                }

            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {

            }
        });
    }

    /**
     * 使用Call的方法直接将数据转化为JsonBean类
     * @param page
     * @param mJokeInterf
     */
    private void getDataJackBean(int page, JokeInterf mJokeInterf) {
        Call<JsonBean> responseBodyCall = mJokeInterf.getJsonBean(null,page,pageSize,"desc", DateFormatUtils
                .getInstance().getCurrentTime()
        );

        responseBodyCall.enqueue(new Callback<JsonBean>() {
            @Override
            public void onResponse(Call<JsonBean> call, Response<JsonBean> response) {
                try {
//                    Logger.t(TAG).d(jsonBean.getResult().getDatas().get(0).getContent());
                    view.fillRecyclerViewdata(response.body().getResult().getDatas());

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(Call<JsonBean> call, Throwable t) {

            }
        });

    }

    /**
     * 使用Call的
     * 同步方法直接将数据转化为JsonBean类
     * @param page
     * @param mJokeInterf
     */
    private void getDataJackBeanSync(int page, JokeInterf mJokeInterf) {
       final Call<JsonBean> responseBodyCall = mJokeInterf.getJsonBean(null,page,pageSize,"desc", DateFormatUtils
                .getInstance().getCurrentTime()
        );
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    JsonBean jsonBean =  responseBodyCall.execute().body();
                    Message msg = myHandler.obtainMessage(1);
                    msg.obj = jsonBean;
                    myHandler.sendMessage(msg);

                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }).start();



    }


    /**
     * @param page
     * @param mJokeInterf
     * 使用Rxjava来将获得的数据直接转化为JsonBean
     */
    private void getDataWithObservable(int page, JokeInterf mJokeInterf) {
        CompositeSubscription mSubscriptions = new CompositeSubscription();
        Map<String,Object> options = new HashMap<String,Object>();
//        参数名	  类型
//        sort	    s
//        page	    i
//        pagesize
//                time
        options.put("sort","asc");
        options.put("page",page+1);
        options.put("pagesize",pageSize);
        options.put("time",DateFormatUtils.getInstance().getCurrentTime());
        mSubscriptions.add(
                mJokeInterf.getJsonBeanByRxJava(options)
                        .subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe(new Observer<JsonBean>() {
                            @Override
                            public void onCompleted() {

                            }

                            @Override
                            public void onError(Throwable e) {

                            }

                            @Override
                            public void onNext(JsonBean jsonBean) {

                                try {
//                                   Logger.t(TAG).d(jsonBean.getResult().getDatas().get(0).getContent());
                                    view.fillRecyclerViewdata(jsonBean.getResult().getDatas());

                                } catch (Exception e) {
                                    e.printStackTrace();
                                }
                            }
                        })

        );

    }



    /**
     * @param page
     * @param mJokeInterf
     * 使用Post方法将获得的数据直接转化为JsonBean
     */
    private void getDataWithPost(int page, JokeInterf mJokeInterf) {
//        http://japi.juhe.cn/joke/content/list.from
        Call<JsonBean> responseBodyCall = mJokeInterf.getJsonBeanWithPost("content","list.from",page,pageSize,"desc",
                DateFormatUtils
                .getInstance().getCurrentTime()
        );
        responseBodyCall.enqueue(new Callback<JsonBean>() {
            @Override
            public void onResponse(Call<JsonBean> call, Response<JsonBean> response) {
                try {
//                    Logger.t(TAG).d(jsonBean.getResult().getDatas().get(0).getContent());
                    view.fillRecyclerViewdata(response.body().getResult().getDatas());

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(Call<JsonBean> call, Throwable t) {

            }
        });

    }

    Handler myHandler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch(msg.what){
               case 1:
                   JsonBean jsonBean = (JsonBean) msg.obj;
                   view.fillRecyclerViewdata(jsonBean.getResult().getDatas());
                   break;
               default:
                   break;
            }
        }
    };




}