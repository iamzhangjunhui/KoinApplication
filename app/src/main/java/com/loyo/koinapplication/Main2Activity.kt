package com.loyo.koinapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.loyo.koinapplication.databinding.ActivityMain2Binding
import org.koin.android.ext.android.inject
import org.koin.android.viewmodel.ext.android.viewModel


class Main2Activity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        val myViewModel: MyViewModel by viewModel()
        super.onCreate(savedInstanceState)
        val activityMain2Binding:ActivityMain2Binding=DataBindingUtil.setContentView(this,R.layout.activity_main2)
        activityMain2Binding.data=myViewModel
    }
}
