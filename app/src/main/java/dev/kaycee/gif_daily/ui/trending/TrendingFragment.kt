package dev.kaycee.gif_daily.ui.trending

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import dev.kaycee.gif_daily.databinding.FragmentTrendingBinding
import dev.kaycee.gif_daily.ui.BaseFragment

class TrendingFragment: BaseFragment<FragmentTrendingBinding, TrendingGifViewModel>() {

    override fun getViewBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentTrendingBinding = FragmentTrendingBinding.inflate(layoutInflater)

    override fun getViewModelClass(): Class<TrendingGifViewModel> = TrendingGifViewModel::class.java

    override fun onCreateView(instance: Bundle?) {

    }

}
