package dev.kaycee.gif_daily.ui.trending

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import dagger.hilt.android.AndroidEntryPoint
import dev.kaycee.gif_daily.databinding.FragmentTrendingBinding
import dev.kaycee.gif_daily.model.State
import dev.kaycee.gif_daily.ui.BaseFragment

@AndroidEntryPoint
class TrendingFragment : BaseFragment<FragmentTrendingBinding, TrendingGifViewModel>() {

    override fun getViewBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentTrendingBinding = FragmentTrendingBinding.inflate(layoutInflater)

    override fun getViewModelClass(): Class<TrendingGifViewModel> = TrendingGifViewModel::class.java

    override fun onCreateView(instance: Bundle?) {
        viewModel.trendingGifLiveData.observe(viewLifecycleOwner, { state ->
            when (state) {
                is State.Loading -> {
                    Log.d("congnm", "state loading")
                }

                is State.Success -> {
                }
                is State.Error -> {
                    Log.d("congnm", state.message ?: "Cannot get state error message")
                }
            }
        })
    }
}
