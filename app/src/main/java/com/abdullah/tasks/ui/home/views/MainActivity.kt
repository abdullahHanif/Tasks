package com.abdullah.tasks.ui.home.views

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.abdullah.tasks.R
import com.abdullah.tasks.extension.replaceFragment

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        replaceFragment(Splash(),R.id.container,false)
    }
}
