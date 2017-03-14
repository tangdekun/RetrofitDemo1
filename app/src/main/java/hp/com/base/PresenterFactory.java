package hp.com.base;


import hp.com.base.inter.IBasePresenter;

/**
 * Presenter工厂类
 * Created by tangdekun on 2017/3/11.
 */

public interface PresenterFactory<T extends IBasePresenter> {
    /**
     *创建Presenter对象
     * @return
     */
    T create();
}
