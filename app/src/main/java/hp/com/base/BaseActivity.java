package hp.com.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;


/**
 * Created by tangdekun on 2017/3/11.
 */

    public abstract  class BaseActivity extends AppCompatActivity {


        @Override
        protected void onCreate(@Nullable Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            onActivityCreate(savedInstanceState);
        }

        /**
         * 实现父类的onActivityCreate，完成Presenter的生成以及P和V的绑定
         * @param paramBundle
         */
        protected abstract void onActivityCreate(@Nullable Bundle paramBundle);

}
