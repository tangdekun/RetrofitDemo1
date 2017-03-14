package hp.com.base.inter;

/**
 * Created by tangdekun on 2017/3/11.
 */

public interface IBasePresenter <T extends IBaseView>{

    /**
     * 绑定View层
     * @param view 需要实现IBaseView接口
     */
    void onViewAttached(T view);

    /**
     * 解绑View层
     */
    void onViewDetached();

    /**
     * 用于解绑Model层
     */
    void onDestory();


}
