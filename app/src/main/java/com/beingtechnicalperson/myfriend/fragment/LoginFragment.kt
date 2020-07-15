package com.beingtechnicalperson.myfriend.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.beingtechnicalperson.myfriend.R
import com.beingtechnicalperson.myfriend.ui.loginSignup.LoginSignUpActivity
import com.beingtechnicalperson.myfriend.ui.profileCreation.ProfileCreationActivity
import kotlinx.android.synthetic.main.fragment_login.*
import setDebounceClickListener

class LoginFragment : Fragment(), View.OnClickListener {

    private val context by lazy { activity as LoginSignUpActivity }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_login, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        init()
    }

    private fun init() {
        loginBtn.setDebounceClickListener(this)
    }

    override fun onClick(view: View) {
        when (view.id) {
            R.id.loginBtn -> {
                (activity as LoginSignUpActivity).moveToNext(1)
            }
        }
    }
}
