package com.nec.glcodingchallenge.ui.acronym

import android.annotation.SuppressLint
import android.opengl.Visibility
import android.os.Bundle
import android.view.View
import android.widget.LinearLayout
import androidx.recyclerview.widget.LinearLayoutManager
import com.nec.glcodingchallenge.R
import com.nec.glcodingchallenge.adapter.AcronymAdapter
import com.nec.glcodingchallenge.databinding.ActivityAcronymBinding
import com.nec.glcodingchallenge.ui.base.ActivityNavigator
import com.nec.glcodingchallenge.ui.base.BaseActivity
import com.nec.glcodingchallenge.utils.hide
import com.nec.glcodingchallenge.utils.show
import kotlinx.android.synthetic.main.activity_acronym.*

class AcronymActivity : BaseActivity<ActivityAcronymBinding, AcronymViewModel>(){

    lateinit var acronym: String

    override fun getViewModelClass(): Class<AcronymViewModel> = AcronymViewModel::class.java

    override fun layoutId(): Int {
        return R.layout.activity_acronym
    }

    @SuppressLint("WrongConstant")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        acronym = intent.getStringExtra("acronym")

        viewModel.dataLoading.observe(this, { handleDataLoadingUi(it!!) })
        viewModel.loadAcronymCoroutine(acronym)

        viewModel.dataAcronym.observe(this, { it ->
            it?.let {

                binding.recyclerView.layoutManager = LinearLayoutManager(this, LinearLayout.VERTICAL, false)
                if(it.isNotEmpty()){
                    val adapter = AcronymAdapter(it[0].lfs, this)
                    recyclerView.adapter = adapter
                    binding.emptyText.hide()
                }else{
                    binding.emptyText.show()
                }

            }
        })

    }

    override fun onBackPressed() {
        ActivityNavigator.finishActivityWithAnimation(R.anim.slide_right_in, R.anim.slide_right_out, this)
    }

    private fun handleDataLoadingUi(loading: Boolean) {
        binding.progressbar.visibility = if (loading) View.VISIBLE else View.INVISIBLE

    }
}