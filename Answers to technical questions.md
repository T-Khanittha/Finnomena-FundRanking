# Answers

#### 1. How long did you spend on the coding test? What would you add to your solution if you had more time? If you didn't spend much time on the coding test then use this as an opportunity to explain what you would add.

- about 4 days
- would add handle error when not get fund rank by range from api

#### 2. What was the most useful feature that was added to the latest version of your chosen language? Please include a snippet of code that shows how you've used it.
- Retrofit and Gson convert 

```kotlin
  fun invoke(): Retrofit {
     return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
```
- Get request
```kotlin
interface GetFundsByRangeService {
    @GET("fund-ranking-{timeRange}.json")
    suspend fun getFundRank(@Path("timeRange") timeRange: String): FundRankResponse
}
```
- RecyclerView and Adapter for return fund ranking list
#### 3. How would you track down a performance issue in production? Have you ever had to do this.

- I never track down a performance by myself but I will learn more about Firebase Performance. Firebase Performance is a performance monitoring uses traces to collect data about processes. A trace is a report that contains data captured between two points in time in your app, collect network request and helps to understand in real time where the performance of the app can be improved so that you can use that information to fix performance issues.

#### 4. How would you improve the FINNOMENA APIs that you just used?.

- No answers
