package dev.kaycee.gif_daily.ui.login

import android.util.Log
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class LogInViewModel @ViewModelInject constructor(

): ViewModel() {

    var isValidUserName: Boolean = false
    var isValidPassword: Boolean = false

    val _userName = MutableLiveData<String>()
    val userName: LiveData<String>
    get() = _userName

    val _password = MutableLiveData<String>()
    val password: LiveData<String>
    get() = _password

    fun validateUsername(username: String) {
        isValidUserName =  isLengthValidCharactersValid(username)
                && isSatisfyOtherRequirements(username)
        _userName.postValue(username)
    }

    fun validatePassword(password: String) {
        isValidPassword = isValidPassword(password)
        _password.postValue(password)
    }

    fun showUsernameInvalidError() {

    }

    /**
     * The username may be claimed by a suspended or deactivated account.
     * The username already exists - check remotely
     */

    private fun isSatisfyOtherRequirements(username: String): Boolean {
        return true
    }

    /**
     * A username can only contain alphanumeric characters (letters A-Z, numbers 0-9)
     * with the exception of underscores.
     * Your username cannot be longer than 15 characters
     * or shorter than 4 characters
     */

    private fun isLengthValidCharactersValid(username: String): Boolean {
        val regexString = "^[a-zA-Z0-9][a-zA-Z0-9_]{4,15}+$"
        Log.d("congnm",Regex(regexString).matches(username).toString())
        return Regex(regexString).matches(username)
    }

    /**
     * Check password with at least 8 characters in length. At least one letter and one number
     */

    private fun isValidPassword(pw: String): Boolean {
        val regexString = "^(?=.*[A-Za-z])(?=.*\\d).{8,}\$"
        return Regex(regexString).matches(pw)
    }
}