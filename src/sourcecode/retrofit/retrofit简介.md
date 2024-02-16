# 简介
### 1.什么是Retrofit
[Retrofit](https://link.zhihu.com/?target=https%3A//github.com/square/retrofit)：
A type-safe **HTTP client** for Android and Java。一个类型安全的 Http 请求的客户端。

底层的网络请求是基于 OkHttp 的，Retrofit 对其做了封装，提供了即方便又高效的网络访问框架。

### 2.Retrofit的基本用法
```Plain Text
class RetrofitActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //初始化一个Retrofit对象
        val retrofit = Retrofit.Builder()
            .baseUrl("https://api.github.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        //创建出GitHubApiService对象
        val service = retrofit.create(GitHubApiService::class.java)
        //返回一个 Call 对象
        val repos = service.listRepos("octocat")
        //调用 enqueue 方法在回调方法里处理结果
        repos.enqueue(object : Callback<List<Repo>?> {
            override fun onFailure(call: Call<List<Repo>?>, t: Throwable) {
                                t.printStackTrace()
            }

            override fun onResponse(call: Call<List<Repo>?>, response: Response<List<Repo>?>) {
                "response.code() = ${response.code()}".logE()
            }
        })

    }
}
复制代码
//自己定义的 API 请求接口
interface GitHubApiService {
    @GET("users/{user}/repos")
    fun listRepos(@Path("user") user: String?): Call<List<Repo>>
}
复制代码

```
以上就是 Retrofit 的基本用法。

