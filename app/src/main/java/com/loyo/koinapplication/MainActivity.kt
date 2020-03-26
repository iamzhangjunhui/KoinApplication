package com.loyo.koinapplication

import android.content.Context
import android.content.Intent
import android.database.DatabaseUtils
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.loyo.koinapplication.databinding.ActivityMainBinding
import org.koin.android.ext.android.inject
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.android.viewmodel.ext.android.viewModel
import org.koin.core.qualifier.named
import org.koin.dsl.module

val appModule = module {

    // single instance of HelloRepository
    single<HelloRepository>{ HelloRepositoryImpl() }

    // MyViewModel ViewModel
    viewModel { MyViewModel(get()) }
}


class MainActivity : AppCompatActivity() {
    private val myViewModel: MyViewModel by viewModel()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val activityMainBinding: ActivityMainBinding =
            DataBindingUtil.setContentView(this, R.layout.activity_main)
        activityMainBinding.data = myViewModel
        activityMainBinding.clickListener= ClickListener(this)
    }
    class ClickListener(var context: Context){
        fun click(){
            context.startActivity(Intent(context,Main2Activity::class.java))
        }

    }
}


