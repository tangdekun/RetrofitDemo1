package hp.com.contract;

import java.util.List;

import hp.com.base.inter.IBasePresenter;
import hp.com.base.inter.IBaseToastView;
import hp.com.base.inter.IBaseView;
import hp.com.base.inter.IProgressDismiss;
import hp.com.retrofitdemo.bean.JokeBean;

/**
 * Created by tangdekun on 2017/3/14.
 */

public class JokeContract {


public interface View extends IBaseView,IProgressDismiss,IBaseToastView{
    void  fillRecyclerViewDataSimple(List<JokeBean> mdata);
    void  updateRecyclerViewdata(List<JokeBean> mdata);
    void  refreshRecyclerViewdata(List<JokeBean> mdata);
    void  fillRecyclerViewdata(List<JokeBean> mdata);
}

public interface Presenter extends IBasePresenter<View>{

    void getData(int page);
    void getMoreData(int page);



}

public interface Model {
//    void getData(int page);
}


}