package com.example.finnomena.ui.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.finnomena.models.FundDetail
import com.example.finnomena.network.GetFundsByRangeService
import com.example.finnomena.network.RetrofitInstance
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainViewModel : ViewModel() {
    private val _fundRankList = MutableLiveData<ArrayList<FundDetail>>()
    val fundRankList: LiveData<ArrayList<FundDetail>> = _fundRankList

    fun selectTimeRange(timeRange: TimeRange) {
        viewModelScope.launch(Dispatchers.IO) {
            val retrofitInstance =
                RetrofitInstance.invoke().create(GetFundsByRangeService::class.java)
            val response = retrofitInstance.getFundRank(timeRange.key)
            _fundRankList.postValue(response.data)
        }

    }


}