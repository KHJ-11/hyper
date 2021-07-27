package com.example.test2

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.test2.databinding.FragmentMyBinding

class MyFragment : Fragment(), View.OnClickListener {

    private lateinit var binding: FragmentMyBinding
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentMyBinding.inflate(layoutInflater)

        binding.apply {
            accountSettings.setOnClickListener(this@MyFragment)
            accountProfile.setOnClickListener(this@MyFragment)
            accountManage.setOnClickListener(this@MyFragment)
            accountCancel.setOnClickListener(this@MyFragment)
        }

        return binding.root
    }

    override fun onClick(v: View?) {
        binding.apply {
            when(v?.id) {
                accountSettings.id -> {
                    accountSettingsM.visibility = View.VISIBLE
                    accountProfileM.visibility = View.INVISIBLE
                    accountManageM.visibility = View.INVISIBLE
                    accountCancelM.visibility = View.INVISIBLE
                }
                accountProfile.id -> {
                    accountSettingsM.visibility = View.INVISIBLE
                    accountProfileM.visibility = View.VISIBLE
                    accountManageM.visibility = View.INVISIBLE
                    accountCancelM.visibility = View.INVISIBLE
                }
                accountManage.id -> {
                    accountSettingsM.visibility = View.INVISIBLE
                    accountProfileM.visibility = View.INVISIBLE
                    accountManageM.visibility = View.VISIBLE
                    accountCancelM.visibility = View.INVISIBLE
                }
                accountCancel.id -> {
                    accountSettingsM.visibility = View.INVISIBLE
                    accountProfileM.visibility = View.INVISIBLE
                    accountManageM.visibility = View.INVISIBLE
                    accountCancelM.visibility = View.VISIBLE
                }
            }
        }
    }
}