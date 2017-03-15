package hp.com.contract;

import java.util.List;

import hp.com.base.inter.IBasePresenter;
import hp.com.base.inter.IBaseView;
import hp.com.retrofitdemo.bean.JokeBean;
import hp.com.retrofitdemo.bean.SimpleBean;

/**
 * Created by tangdekun on 2017/3/14.
 */

public class JokeContract {


public interface View extends IBaseView{
    void  fillRecyclerViewDataSimple(List<SimpleBean.ResultSimple.DataSimple> mdata);
    void  updateRecyclerViewdata(List<SimpleBean.ResultSimple.DataSimple> mdata);
    void  refreshRecyclerViewdata(List<SimpleBean.ResultSimple.DataSimple> mdata);
    void  fillRecyclerViewdata(List<JokeBean> mdata);
}

public interface Presenter extends IBasePresenter<View>{

    void getData(int page);



}

public interface Model {
//    void getData(int page);
}


}