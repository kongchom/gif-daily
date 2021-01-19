package dev.kaycee.gif_daily.ui.login

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import dagger.hilt.android.AndroidEntryPoint
import dev.kaycee.gif_daily.databinding.FragmentLogInBinding
import dev.kaycee.gif_daily.ui.BaseFragment

@AndroidEntryPoint
class LogInFragment: BaseFragment<FragmentLogInBinding, LogInViewModel>() {

    override fun getViewBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentLogInBinding = FragmentLogInBinding.inflate(layoutInflater)


    override fun getViewModelClass(): Class<LogInViewModel> = LogInViewModel::class.java

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return super.onCreateView(inflater, container, savedInstanceState)

    }
}