package com.beingtechnicalperson.myfriend.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.beingtechnicalperson.myfriend.R
import com.beingtechnicalperson.myfriend.ui.profileCreation.ProfileCreationActivity


class NameFragment : Fragment() {

    private val context by lazy { activity as ProfileCreationActivity }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_name, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        init()
//        saveData()
    }

    private fun init() {
        context.updateSeekBar(50)
    }


}
