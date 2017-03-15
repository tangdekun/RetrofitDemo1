package hp.com.retrofitdemo;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.orhanobut.logger.Logger;

import java.util.List;

import hp.com.adapter.JokesJokeBeanApapter;
import hp.com.base.BasePresenterActivity;
import hp.com.contract.JokeContract;
import hp.com.presenter.JokePresenterImpl;
import hp.com.retrofitdemo.bean.JokeBean;
import hp.com.retrofitdemo.bean.SimpleBean;

public class Main2Activity extends BasePresenterActivity<JokeContract.Presenter, JokeContract.View> implements
        JokeContract.View {
    private static final String TAG = Main2Activity.class.getSimpleName();

    //    @BindView(R.id.recycler_main2)
//    RecyclerView recyclerMain2;
//    @BindView(R.id.swipe_main2)
//    SwipeRefreshLayout swipeMain2;
    List<JokeBean> jokeBeanList;
    JokesJokeBeanApapter mJokesApapter;
    RecyclerView.LayoutManager layoutManager;
    RecyclerView recyclerMain2;
    SwipeRefreshLayout swipeMain2;


    @Override
    public JokeContract.Presenter createPresenter() {
        return new JokePresenterImpl();
    }

    @Override
    public void onPresenterCreate(@Nullable Bundle paramBundle) {
        setContentView(R.layout.activity_main2);
        getPresenter().getData(1);
        recyclerMain2 = (RecyclerView) findViewById(R.id.recycler_main2);
        swipeMain2 = (SwipeRefreshLayout) findViewById(R.id.swipe_main2);
//        jokeBeanList = new ArrayList<JokeBean>();
//        swipeMain2.setColorSchemeResources(android.R.color.holo_blue_light,
//                android.R.color.holo_green_light,
//                android.R.color.holo_purple,
//                android.R.color.holo_red_light
//        );


    }

    @Override
    public void fillRecyclerViewDataSimple(List<SimpleBean.ResultSimple.DataSimple> mdata) {

    }

    @Override
    public void updateRecyclerViewdata(List<SimpleBean.ResultSimple.DataSimple> mdata) {

    }

    @Override
    public void refreshRecyclerViewdata(List<SimpleBean.ResultSimple.DataSimple> mdata) {

    }

    @Override
    public void fillRecyclerViewdata(List<JokeBean> mdata) {
        Toast.makeText(this, "mdata" + mdata.size(), Toast.LENGTH_SHORT).show();

        jokeBeanList = mdata;
        Logger.t(TAG).d(mdata.size()+"|"+jokeBeanList.size());
        Logger.t(TAG).d("fillRecyclerViewdata"+jokeBeanList.get(0).getContent());

        mJokesApapter = new JokesJokeBeanApapter(jokeBeanList, Main2Activity.this);
        layoutManager = new LinearLayoutManager(Main2Activity.this);
        recyclerMain2.setLayoutManager(layoutManager);
        recyclerMain2.setHasFixedSize(true);
        recyclerMain2.setAdapter(mJokesApapter);

    }
}
