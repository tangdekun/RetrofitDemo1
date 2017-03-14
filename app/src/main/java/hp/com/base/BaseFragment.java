package hp.com.base;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;

/**
 * Created by tangdekun on 2017/3/11.
 */

public abstract class BaseFragment extends Fragment {

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        onFragmentCreatead(savedInstanceState);
    }
    /**
     * 实现父类的onActivityCreate，完成Presenter的生成以及P和V的绑定
     * @param savedInstanceState
     */
    public abstract  void onFragmentCreatead(Bundle savedInstanceState);

}
