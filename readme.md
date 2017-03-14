Retrofit的功能

1.Retrofit 把REST API返回的数据转化为Java对象方便操作。

2.封装了网络代码的调用。

public interface GitHubService {
  @GET("/users/{user}/repos")
  List<Repo> listRepos(@Path("user") String user);
}