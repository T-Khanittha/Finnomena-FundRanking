package com.example.finnomena.models

import com.google.gson.annotations.SerializedName

data class FundRankResponse(
    @SerializedName("status") val status: Boolean,
    @SerializedName("error") val error: String,
    @SerializedName("data") val data: ArrayList<FundDetail>,
)

data class FundDetail(
    @SerializedName("thailand_fund_code") val name: String,
    @SerializedName("nav_return") val performance: Double,
    @SerializedName("nav") val price: Double,
    @SerializedName("nav_date") val updatedDate: String,
)