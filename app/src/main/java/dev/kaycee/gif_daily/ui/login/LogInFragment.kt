package dev.kaycee.gif_daily.ui.login

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.lifecycleScope
import dagger.hilt.android.AndroidEntryPoint
import dev.kaycee.gif_daily.R
import dev.kaycee.gif_daily.databinding.FragmentLogInBinding
import dev.kaycee.gif_daily.textChanges
import dev.kaycee.gif_daily.ui.BaseFragment
import kotlinx.coroutines.flow.*

@AndroidEntryPoint
class LogInFragment: BaseFragment<FragmentLogInBinding, LogInViewModel>() {

    override fun getViewBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentLogInBinding = FragmentLogInBinding.inflate(layoutInflater)

    override fun getViewModelClass(): Class<LogInViewModel> = LogInViewModel::class.java

    override fun onCreateView(instance: Bundle?) {
        observeData()
        initListeners()
        binding.tvUserName.textChanges()
            .distinctUntilChanged()
            .filterNot { it.isNullOrBlank() }
            .debounce(500)
            .onEach {
                viewModel.validateUsername(it.toString())
            }
            .launchIn(lifecycleScope)

        binding.tvPassword.textChanges()
            .distinctUntilChanged()
            .filterNot { it.isNullOrBlank() }
            .debounce(500)
            .onEach {
                viewModel.validatePassword(it.toString())
            }
            .launchIn(lifecycleScope)
    }

    private fun observeData() {
        viewModel.userName.observe(viewLifecycleOwner, Observer {
            if (viewModel.isValidUserName) {
                binding.tvUserName.error = null
            } else {
                binding.tvUserName.error = getString(R.string.invalid_user)
            }
        })
        viewModel.password.observe(viewLifecycleOwner, Observer {
            if (viewModel.isValidPassword) {
                binding.tvPassword.error = null
            } else {
                binding.tvPassword.error = getString(R.string.invalid_password)
            }
        })
    }

    private fun initListeners() {
        binding.btnSignUp.setOnClickListener {

        }
    }

}