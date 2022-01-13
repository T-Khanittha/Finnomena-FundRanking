package com.example.finnomena.adapter

import android.annotation.SuppressLint
import android.os.Build
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.AppCompatTextView
import androidx.recyclerview.widget.RecyclerView
import com.example.finnomena.R
import com.example.finnomena.models.FundDetail
import java.text.SimpleDateFormat
import java.util.*
import kotlin.collections.ArrayList

class FundRankAdapter : RecyclerView.Adapter<FundRankAdapter.FundRankViewHolder>() {

    private var fundDetails = ArrayList<FundDetail>()

    @SuppressLint("NotifyDataSetChanged")
    fun setUpdatedData(fundDetails: ArrayList<FundDetail>) {
        this.fundDetails = fundDetails
        notifyDataSetChanged()
    }

    inner class FundRankViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        private val rank = view.findViewById<AppCompatTextView>(R.id.rank)
        private val thailandFundCode = view.findViewById<AppCompatTextView>(R.id.thailand_fund_code)
        private val navReturn = view.findViewById<AppCompatTextView>(R.id.nav_return)
        private val navDate = view.findViewById<AppCompatTextView>(R.id.nav_date)
        private val nav = view.findViewById<AppCompatTextView>(R.id.nav)


        fun bind(data: FundDetail, position: Int) {
            rank.text = "${position + 1}"
            thailandFundCode.text = data.name
            navReturn.text = "%.3f".format(data.performance)
            navDate.text = data.updatedDate.dateFormat()
            nav.text = "%.3f".format(data.price)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FundRankViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_fund_detial_list, parent, false)
        return FundRankViewHolder(view)
    }

    override fun onBindViewHolder(holder: FundRankViewHolder, position: Int) {
        holder.bind(fundDetails[position], position)
    }

    override fun getItemCount(): Int {
        return fundDetails.size
    }

    @SuppressLint("SimpleDateFormat")
    private fun String.dateFormat(): String {
        val pattern = "dd MMM yyyy"
        val simpleDateFormat = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            SimpleDateFormat(pattern)
        } else {
            return ""
        }
        return simpleDateFormat.format(Date())
    }
}