package hp.com.retrofitdemo.bean;

import java.util.List;

/**
 * Created by tangdekun on 2017/1/11.
 */

public class DataBean {
    private List<JokeBean> data;

    public List<JokeBean> getDatas() {
        return data;
    }

    public void setDatas(List<JokeBean> datas) {
        this.data = datas;
    }
}
