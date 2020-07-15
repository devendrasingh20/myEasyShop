package com.beingtechnicalperson.myfriend.ui.profileCreation

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import changeFragment
import com.beingtechnicalperson.myfriend.R
import com.beingtechnicalperson.myfriend.base.BaseActivity
import com.beingtechnicalperson.myfriend.databinding.ActivityProfileCreationBinding
import com.beingtechnicalperson.myfriend.fragment.InterestFragment
import com.beingtechnicalperson.myfriend.fragment.NameFragment
import com.beingtechnicalperson.myfriend.fragment.PersonDetailsFragment
import doGone
import doVisible
import kotlinx.android.synthetic.main.activity_profile_creation.*
import org.koin.android.ext.android.inject
import setDebounceClickListener
import statusBarTransparent

class ProfileCreationActivity :
    BaseActivity<ActivityProfileCreationBinding, ProfileCreationVIewModel>(), View.OnClickListener {
    private lateinit var fragment: Fragment
    private val nameFragment by inject<NameFragment>()
    private val personalDetailsFragment by inject<PersonDetailsFragment>()
//    private val interestFragment by inject<InterestFragment>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        statusBarTransparent()
        bindViewModel()
        init()
        initControl()
    }

    override val layoutRes: Int
        get() = R.layout.activity_profile_creation
    override val viewModelClass: Class<ProfileCreationVIewModel>
        get() = ProfileCreationVIewModel::class.java

    override fun bindViewModel() {
        binding.profileCreationViewModel = viewModel
        binding.lifecycleOwner = this
    }

    override fun init() {
        btnContinueName.setDebounceClickListener(this)
        backProfile.setDebounceClickListener(this)
    }

    override fun initControl() {
        changeFragment(nameFragment, R.id.frameLayout, animation = false, towardRight = false)
    }

    fun updateSeekBar(progress: Int) {
        seekBar.progress = progress
    }

    override fun onClick(view: View) {
        when (view.id) {
            R.id.btnContinueName -> {
                replaceFragmentForward()
            }
            R.id.backProfile -> {
                replaceFragmentBackward()
            }
        }
    }

    override fun onBackPressed() {
        replaceFragmentBackward()
    }

    private fun replaceFragmentBackward() {
        fragment = supportFragmentManager.findFragmentById(R.id.frameLayout)!!
        when (fragment) {
            is NameFragment -> {
                super.onBackPressed()
            }
            is PersonDetailsFragment -> {
                changeFragment(
                    nameFragment,
                    R.id.frameLayout,
                    animation = true,
                    towardRight = false
                )
            }
        }
    }

    private fun replaceFragmentForward() {
        fragment = supportFragmentManager.findFragmentById(R.id.frameLayout)!!
        when (fragment) {
            is NameFragment -> {
                backProfile.doVisible()
                changeFragment(
                    personalDetailsFragment,
                    R.id.frameLayout,
                    animation = true,
                    towardRight = true
                )
            }
            is PersonDetailsFragment -> {
                backProfile.doVisible()
            }
        }
    }

}
