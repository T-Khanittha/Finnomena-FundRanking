package com.example.finnomena.network

import com.example.finnomena.models.FundRankResponse
import retrofit2.http.GET
import retrofit2.http.Path

interface GetFundsByRangeService {
    @GET("fund-ranking-{timeRange}.json")
    suspend fun getFundRank(@Path("timeRange") timeRange: String): FundRankResponse
}