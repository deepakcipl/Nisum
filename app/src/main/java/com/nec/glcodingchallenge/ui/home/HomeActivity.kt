package com.nec.glcodingchallenge.ui.home

import android.os.Bundle
import android.widget.Toast
import com.nec.glcodingchallenge.R
import com.nec.glcodingchallenge.databinding.ActivityHomeBinding
import com.nec.glcodingchallenge.ui.acronym.AcronymActivity
import com.nec.glcodingchallenge.ui.base.ActivityNavigator
import com.nec.glcodingchallenge.ui.base.BaseActivity
import com.nec.glcodingchallenge.utils.toast

class HomeActivity : BaseActivity<ActivityHomeBinding, HomeViewModel>() {

    override fun getViewModelClass(): Class<HomeViewModel> = HomeViewModel::class.java

    override fun layoutId(): Int = R.layout.activity_home

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding.btnSubmit.setOnClickListener {
            showAcronymActivity()
        }
    }

    private fun showAcronymActivity() {

        var name = binding.etAcronym.text.toString()
        if(name.isNullOrEmpty()){
            toast(resources.getString(R.string.toast_message))
        }else{
            val bundle = Bundle()
            bundle.putString("acronym", name)
            ActivityNavigator.startActivityWithData(AcronymActivity::class.java, bundle, this)
        }

    }

}