package com.beingtechnicalperson.myfriend.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.beingtechnicalperson.myfriend.R
import com.beingtechnicalperson.myfriend.adapter.InterestAdapter
import com.beingtechnicalperson.myfriend.ui.profileCreation.ProfileCreationActivity
import kotlinx.android.synthetic.main.fragment_interest.*

class InterestFragment : Fragment() {

    private val context by lazy { activity as ProfileCreationActivity }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_interest, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        init()
        setAdapter()
    }

    private val interestLis = arrayListOf(
        "Sports",
        "Gaming",
        "Travel",
        "Politics"

    )
//    private val interestListSports = arrayListOf(
//        "Football",
//        "Cricket",
//        "BasketBall"
//
//    )


    private fun init() {
        context.updateSeekBar(10)
//        for (i in )
    }

    private fun setAdapter() {
        val value = 1
        val adp = InterestAdapter(value, interestLis)
        rv_interest.adapter = adp
    }
}
