package hp.com.base;

import android.os.Bundle;
import android.support.annotation.Nullable;

import hp.com.base.inter.IBasePresenter;
import hp.com.base.inter.IBaseView;


/**
 * Created by tangdekun on 2017/3/11.
 */

public abstract class BasePresenterActivity <P extends IBasePresenter<V>,V extends IBaseView> extends BaseActivity {

    /** mPresenter是MVP中P对象，在Activity中可以使用该对象，不用再次声明*/
    private  P  mPresenter;
    /**
     * @return 提供一个抽象的方法生成P对象，在子类中需要实现该方法
     */
    public abstract P createPresenter();

    /**
     * 使用工厂模式
     * @return PresenterFactory<P>工产类，通过工厂类产生Presenter对象
     * 在工厂类的create方法中调用子类的createPresenter生成不同的Presenter
     */
    public PresenterFactory<P>  createPresentFactory(){
        return new PresenterFactory<P>(){
            @Override
            public P create() {
                return  createPresenter();
            }
        };
    }

    public P getPresenter() {
        return mPresenter;
    }

    public V getPresenterView(){
        return (V) this;
    }

    @Override
    protected final void onActivityCreate(@Nullable Bundle paramBundle)
    {
        this.mPresenter =  createPresentFactory().create();
        this.mPresenter.onViewAttached(getPresenterView());
        onPresenterCreate(paramBundle);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        //P和V解绑
        this.mPresenter.onViewDetached();

    }

    /**
     * Activity的操作的入口，相当于原来的Activity的onCreate（）方法
     * @param paramBundle
     */
    public abstract void onPresenterCreate(@Nullable Bundle paramBundle);

}
