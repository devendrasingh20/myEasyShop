package com.beingtechnicalperson.myfriend.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.beingtechnicalperson.myfriend.R
import com.beingtechnicalperson.myfriend.ui.loginSignup.LoginSignUpActivity
import kotlinx.android.synthetic.main.fragment_login.*
import kotlinx.android.synthetic.main.fragment_sign_up.*
import setDebounceClickListener

class SignUpFragment : Fragment(), View.OnClickListener {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_sign_up, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        init()
    }

    private fun init() {
        signUpBtn.setDebounceClickListener(this)
    }

    override fun onClick(view: View) {
        when (view.id) {
            R.id.signUpBtn -> {
                (activity as LoginSignUpActivity).moveToNext(2)
            }
        }
    }

}
