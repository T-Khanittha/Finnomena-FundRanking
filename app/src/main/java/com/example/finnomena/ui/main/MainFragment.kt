package com.example.finnomena.ui.main

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.finnomena.R
import com.example.finnomena.adapter.FundRankAdapter
import com.example.finnomena.databinding.MainFragmentBinding

class MainFragment : Fragment(R.layout.main_fragment) {

    companion object {
        fun newInstance() = MainFragment()
    }

    private lateinit var viewModel: MainViewModel

    private lateinit var binding: MainFragmentBinding

    private lateinit var fundRankAdapter: FundRankAdapter
    private val defaultTimeRange = TimeRange.ONE_YEAR

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val mainFragmentBinding = MainFragmentBinding.bind(view)
        binding = mainFragmentBinding
        binding.oneYearRadio.isChecked = true
        bind()
        initViewModel()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.main_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this)[MainViewModel::class.java]
        observeLiveData()
    }

    private fun observeLiveData() {
        viewModel.fundRankList.observe(viewLifecycleOwner, {
            if (it != null) {
                fundRankAdapter.setUpdatedData(it)
            }
        })
        viewModel.selectTimeRange(defaultTimeRange)
    }

    private fun bind() = with(binding) {
        timeRangeRadioGroup.setOnCheckedChangeListener { _, checkedId ->
            when (checkedId) {
                R.id.one_day_radio -> viewModel.selectTimeRange(TimeRange.ONE_DAY)
                R.id.one_week_radio -> viewModel.selectTimeRange(TimeRange.ONE_WEEK)
                R.id.one_mounth_radio -> viewModel.selectTimeRange(TimeRange.ONE_MOUNTH)
                R.id.one_year_radio -> viewModel.selectTimeRange(TimeRange.ONE_YEAR)
                else -> {
                    viewModel.selectTimeRange(TimeRange.ONE_YEAR)
                }
            }
        }
    }

    private fun initViewModel() {
        binding.recyclerView.layoutManager = LinearLayoutManager(activity)
        fundRankAdapter = FundRankAdapter()
        binding.recyclerView.adapter = fundRankAdapter
    }


}