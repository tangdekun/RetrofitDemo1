package hp.com.base;

import android.os.Bundle;
import android.support.annotation.Nullable;

import hp.com.base.inter.IBasePresenter;
import hp.com.base.inter.IBaseView;


/**
 * Created by tangdekun on 2017/3/11.
 */

public abstract  class BasePresenterFragment<P extends IBasePresenter<V>,V extends IBaseView> extends BaseFragment {
    /** mPresenter是MVP中P对象，在Fragment中可以使用该对象，不用再次声明*/
    private P mPresenter;
    /**
     * @return 提供一个抽象的方法生成P对象，在子类中需要实现该方法
     */
    public abstract  P createaPresenter();
    /**
     * 使用工厂模式
     * @return PresenterFactory<P>工产类，通过工厂类产生Presenter对象
     * 在工厂类的create方法中调用子类的createPresenter生成不同的Presenter
     */
    public PresenterFactory<P> getPresentFactory(){
        return new PresenterFactory<P>() {
            @Override
            public P create() {
                return createaPresenter();
            }
        };
    }

    public P getmPresenter(){
        return  this.mPresenter;
    }

    public V getPresentView(){
        return (V) this;
    }


    @Override
    public void onFragmentCreatead(@Nullable Bundle savedInstanceState) {
        this.mPresenter = getPresentFactory().create();
        this.mPresenter.onViewAttached((V) getmPresenter());
        onPresentCreatead(savedInstanceState);
    }
    /**
     * Activity的操作的入口，相当于原来的Activity的onCreate（）方法
     * @param  savedInstanceState
     */
    public abstract void onPresentCreatead(@Nullable Bundle savedInstanceState);


    @Override
    public void onDestroy() {
        super.onDestroy();
        this.mPresenter.onViewDetached();
    }
}
