package dev.kaycee.gif_daily.ui.login

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.lifecycleScope
import com.bumptech.glide.Glide
import dagger.hilt.android.AndroidEntryPoint
import dev.kaycee.gif_daily.DISABLE_ALPHA
import dev.kaycee.gif_daily.ENABLE_ALPHA
import dev.kaycee.gif_daily.R
import dev.kaycee.gif_daily.databinding.FragmentLogInBinding
import dev.kaycee.gif_daily.textChanges
import dev.kaycee.gif_daily.ui.BaseFragment
import kotlinx.coroutines.flow.debounce
import kotlinx.coroutines.flow.distinctUntilChanged
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach

@AndroidEntryPoint
class LogInFragment : BaseFragment<FragmentLogInBinding, LogInViewModel>() {

    override fun getViewBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentLogInBinding = FragmentLogInBinding.inflate(layoutInflater)

    override fun getViewModelClass(): Class<LogInViewModel> = LogInViewModel::class.java

    override fun onCreateView(instance: Bundle?) {
        initViews()
        initListeners()
        observeData()
    }

    private fun observeData() {
        viewModel.userName.observe(viewLifecycleOwner, {
            if (viewModel.isValidUserName) {
                binding.tvUserName.error = null
            } else {
                binding.tvUserName.error = getString(R.string.invalid_user)
            }
        })
        viewModel.password.observe(viewLifecycleOwner, {
            if (viewModel.isValidPassword) {
                binding.tvPassword.error = null
            } else {
                binding.tvPassword.error = getString(R.string.invalid_password)
            }
        })
        viewModel.email.observe(viewLifecycleOwner, {
            if (viewModel.isValidEmail) {
                binding.tvEmailAddress.error = null
            } else {
                binding.tvEmailAddress.error = getString(R.string.invalid_email)
            }
        })
        viewModel.isLogIn.observe(viewLifecycleOwner, { isLogIn ->
            if (isLogIn) {
                handleLogInMode()
            } else {
                handleSignUpMode()
            }
        })
    }

    private fun initListeners() {
        binding.btnSignUp.setOnClickListener {
        }
        binding.btnOptionLogIn.setOnClickListener {
            viewModel.enableLogInMode(true)
        }
        binding.btnOptionSignUp.setOnClickListener {
            viewModel.enableLogInMode(false)
        }
    }

    private fun initViews() {
        binding.tvUserName.textChanges()
            .distinctUntilChanged()
            .debounce(500)
            .onEach {
                if (it.isNullOrBlank()) {
                    binding.tvUserName.error = null
                } else {
                    viewModel.validateUsername(it.toString())
                }
            }
            .launchIn(lifecycleScope)

        binding.tvPassword.textChanges()
            .distinctUntilChanged()
            .debounce(500)
            .onEach {
                if (it.isNullOrBlank()) {
                    binding.tvPassword.error = null
                } else {
                    viewModel.validatePassword(it.toString())
                }
            }
            .launchIn(lifecycleScope)

        binding.tvEmailAddress.textChanges()
            .distinctUntilChanged()
            .debounce(500)
            .onEach {
                if (it.isNullOrBlank()) {
                    binding.tvEmailAddress.error = null
                } else {
                    viewModel.validateEmail(it.toString())
                }
            }
            .launchIn(lifecycleScope)
        Glide.with(this)
            .load(R.drawable.giphy)
            .into(binding.imgBackground)
    }

    private fun handleLogInMode() {
        binding.tvEmailAddress.visibility = View.GONE
        binding.btnOptionLogIn.alpha = ENABLE_ALPHA
        binding.btnOptionSignUp.alpha = DISABLE_ALPHA
        binding.btnSignUp.text = getString(R.string.log_in)
    }

    private fun handleSignUpMode() {
        binding.tvEmailAddress.visibility = View.VISIBLE
        binding.btnOptionLogIn.alpha = DISABLE_ALPHA
        binding.btnOptionSignUp.alpha = ENABLE_ALPHA
        binding.btnSignUp.text = getString(R.string.sign_up)
    }
}
