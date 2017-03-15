package hp.com.retrofitdemo.bean;

/**
 * Created by tangdekun on 2017/3/15.
 */

public class JokeOptionsBody {
//    参数名	  类型
//        sort	    s
//        page	    i
//        pagesize
//                time
    private  String sort;
    private  int page;
    private  int pagesize;
    private  long time;

    public String getSort() {
        return sort;
    }

    public void setSort(String sort) {
        this.sort = sort;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getPagesize() {
        return pagesize;
    }

    public void setPagesize(int pagesize) {
        this.pagesize = pagesize;
    }

    public long getTime() {
        return time;
    }

    public void setTime(long time) {
        this.time = time;
    }


}
