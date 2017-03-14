package hp.com.retrofitdemo;

/**
 * Created by tangdekun on 2017/3/14.
 */

public class Constant {

    /**
     * 服务器地址
     * 接口地址：
     * 1.按更新时间查询笑话： http://japi.juhe.cn/joke/content/list.from
     * 参数名	  类型	      是否必填    	说明	值
     * sort	    string	        是	         类型，desc:指定时间之前发布的，asc:指定时间之后发布的
     * page	    int	            否	         当前页数,默认1
     * pagesize	  int	        否	         每次返回条数,默认1,最大20
     * time	       string	    是	         时间戳（10位），如：1418816972
     * <p>
     * 2.最新笑话：  http://japi.juhe.cn/joke/content/text.from
     * 请求参数：
     * 参数名	   类型	      是否必填	     说明值
     * page	   int	       否	         当前页数,默认1
     * pagesize	int	       否	         每次返回条数,默认1,最大20
     * <p>
     * 3.按更新时间查询趣图 ：http://japi.juhe.cn/joke/img/list.from
     * 参数名	  类型	      是否必填    	说明	值
     * sort	    string	        是	         类型，desc:指定时间之前发布的，asc:指定时间之后发布的
     * page	    int	            否	         当前页数,默认1
     * pagesize	  int	        否	         每次返回条数,默认1,最大20
     * time	       string	    是	         时间戳（10位），如：1418816972
     * <p>
     * 4.最新趣图： http://japi.juhe.cn/joke/img/text.from
     * 请求参数：
     * 参数名	   类型	      是否必填	     说明值
     * page	   int	       否	         当前页数,默认1
     * pagesize	int	       否	         每次返回条数,默认1,最大20
     * <p>
     * 5.随机获取趣图/笑话：http://v.juhe.cn/joke/randJoke.php
     * 参数名	   类型	      是否必填	     说明值
     * type	string	否	类型(pic:趣图,不传默认为笑话)
     * //http://japi.juhe.cn/joke/content/list.from?key=您申请的KEY&page=2&pagesize=10&sort=asc&time=1418745237
     */
    public final static String BASE_URL = "http://japi.juhe.cn/";
    //http://blog.csdne.net/u014695188/article/details/52985514
//    http://www.jcodecraeer.com/a/anzhuokaifa/androidkaifa/2015/0915/3460.html
//    http://blog.csdn.net/u014165119/article/details/49280779
//    http://www.tuicool.com/articles/AveimyQ
}
