package com.beingtechnicalperson.myfriend.ui.loginSignup

import android.os.Bundle
import android.view.View
import android.widget.TextView
import changeFragment
import com.beingtechnicalperson.myfriend.R
import com.beingtechnicalperson.myfriend.base.BaseActivity
import com.beingtechnicalperson.myfriend.databinding.ActivityLoginSignUpBinding
import com.beingtechnicalperson.myfriend.extensionFunction.goToNext
import com.beingtechnicalperson.myfriend.extensionFunction.goto
import com.beingtechnicalperson.myfriend.extensionFunction.gotoFinish
import com.beingtechnicalperson.myfriend.fragment.LoginFragment
import com.beingtechnicalperson.myfriend.fragment.SignUpFragment
import com.beingtechnicalperson.myfriend.ui.home.HomeActivity
import com.beingtechnicalperson.myfriend.ui.profileCreation.ProfileCreationActivity
import com.google.android.material.bottomsheet.BottomSheetBehavior
import doGone
import doVisible
import kotlinx.android.synthetic.main.activity_login_sign_up.*
import org.koin.android.ext.android.inject
import setDebounceClickListener
import statusBarTransparent

class LoginSignUpActivity : BaseActivity<ActivityLoginSignUpBinding, LoginSignUpVIewModel>(),
    View.OnClickListener {

    private val signUpFragment by inject<SignUpFragment>()
    private val loginFragment by inject<LoginFragment>()
    private lateinit var sheetBehavior: BottomSheetBehavior<View>
    private var bottom_sheet_expanded: Boolean = false


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        statusBarTransparent()
        bindViewModel()
        init()
        initControl()
    }

    override val layoutRes: Int
        get() = R.layout.activity_login_sign_up
    override val viewModelClass: Class<LoginSignUpVIewModel>
        get() = LoginSignUpVIewModel::class.java

    override fun bindViewModel() {
        binding.loginSignUpViewModel = viewModel
        binding.lifecycleOwner = this
    }

    override fun init() {
        login.setDebounceClickListener(this)
        signUp.setDebounceClickListener(this)
        socialIntegrationLayout.setDebounceClickListener(this)
    }

    override fun initControl() {
        changeFragment(loginFragment, R.id.loginFrame, animation = false, towardRight = false)
        applyOpacity(signUp, signUp_line, login, login_line)
        sheetBehavior = BottomSheetBehavior.from(bottom_sheet_layout)
        setBottomSheet()
    }

    private fun setBottomSheet() {
        sheetBehavior.addBottomSheetCallback(object : BottomSheetBehavior.BottomSheetCallback() {
            override fun onStateChanged(view: View, p1: Int) {
                bottom_sheet_expanded = (p1 != BottomSheetBehavior.STATE_COLLAPSED)
            }

            override fun onSlide(p0: View, p1: Float) {

            }
        })

    }

    private fun applyOpacity(textView: TextView, view: View, textView2: TextView, view2: View) {
        view.doGone()
        view2.doVisible()
        textView.alpha = 0.3F
        textView2.alpha = 1F
    }

    override fun onClick(view: View) {
        when (view.id) {
            R.id.login -> {
                changeFragment(
                    loginFragment,
                    R.id.loginFrame,
                    animation = true,
                    towardRight = false
                )
                applyOpacity(signUp, signUp_line, login, login_line)
            }
            R.id.socialIntegrationLayout -> {
                if (sheetBehavior.state != BottomSheetBehavior.STATE_EXPANDED) {
                    sheetBehavior.state = BottomSheetBehavior.STATE_EXPANDED
                } else {
                    sheetBehavior.state = BottomSheetBehavior.STATE_COLLAPSED
                }
            }
            R.id.signUp -> {
                changeFragment(
                    signUpFragment,
                    R.id.loginFrame,
                    animation = true,
                    towardRight = true
                )
                applyOpacity(login, login_line, signUp, signUp_line)
            }
        }
    }

    override fun onBackPressed() {
        if (bottom_sheet_expanded) {
            sheetBehavior.state = BottomSheetBehavior.STATE_COLLAPSED

        } else {
            super.onBackPressed()
        }
    }

    /*
    * 1->From Login
    * 2->From Signup
    * */
    fun moveToNext(comingFrom: Int) {
        if (comingFrom == 1) {
            gotoFinish(HomeActivity::class.java)
        } else {
            goToNext(ProfileCreationActivity::class.java)
        }
    }
}
