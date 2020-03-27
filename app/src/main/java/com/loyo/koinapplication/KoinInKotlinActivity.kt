package com.loyo.koinapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.loyo.koinapplication.databinding.ActivityMainBinding
import com.loyo.koinapplication.model.Girl
import com.loyo.koinapplication.model.HelloRepository
import com.loyo.koinapplication.model.HelloRepositoryImpl
import com.loyo.koinapplication.model.MyViewModel
import kotlinx.android.synthetic.main.activity_main.*
import org.koin.android.ext.android.inject
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.android.viewmodel.ext.android.viewModel
import org.koin.core.parameter.parametersOf
import org.koin.core.qualifier.named
import org.koin.dsl.module

val appModule = module {

    // single instance of HelloRepository
    single<HelloRepository> { HelloRepositoryImpl() }

    // MyViewModel ViewModel
    viewModel { MyViewModel(get()) }
}
@JvmField
val userModule = module {

    single(named("1")) { (name: String, age: Int) ->
        Girl(
            name,
            age
        )
    }
    single(named("2")) { (name: String, age: Int) ->
        Girl(
            name,
            age
        )
    }
}

class KoinInKotlinActivity : AppCompatActivity() {
    private val girl: Girl by inject(named("1")) { parametersOf("kaylee", 23) }
    private val girl2: Girl by inject(named("2")) { parametersOf("andy", 24) }
    private val myViewModel: MyViewModel by viewModel()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        DataBindingUtil.setContentView<ActivityMainBinding>(this, R.layout.activity_main).also {
            it.data = myViewModel
        }
        button2.setOnClickListener {
            println("1:$girl")
            println("2:$girl2")
            startActivity(
                Intent(
                    this,
                    KoinInJavaActivity::class.java
                )
            )
        }

    }
}


