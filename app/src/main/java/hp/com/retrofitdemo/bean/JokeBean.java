package hp.com.retrofitdemo.bean;

/**
 * Created by tangdekun on 2017/1/11.
 */

public class JokeBean {
//    {"content":"我爸今天叫我一定要开他的车去接我妈回家，不能开自己的，我还在纳闷呢。 半路看他没油了，给加满了。
// 晚上的时候，我无意听到他在跟我妈说：哈哈，我又坑了闺女一箱油钱。。。。。 好吧，你又赢了。。。。",
// "hashId":"d5f956639f831b49a421d536f3c273b1","unixtime":1484119430,"updatetime":"2017-01-11 15:23:50"}
    private String content;
    private String updatetime;
    private long unixtime;

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getUpdatetime() {
        return updatetime;
    }

    public void setUpdatetime(String updatetime) {
        this.updatetime = updatetime;
    }

    public long getUnixtime() {
        return unixtime;
    }

    public void setUnixtime(long unixtime) {
        this.unixtime = unixtime;
    }
}
