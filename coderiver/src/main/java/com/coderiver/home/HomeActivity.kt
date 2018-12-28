package com.coderiver.home

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.NavigationUI
import com.coderiver.R
import com.google.android.material.bottomnavigation.BottomNavigationView
import kotlinx.android.synthetic.main.activity_home.*

class HomeActivity : AppCompatActivity() {

    companion object {
       fun launch(context: Context){
           context.startActivity(Intent(context, HomeActivity::class.java))
       }
    }

    private val mOnNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
        when (item.itemId) {
            R.id.navigation_home -> {

                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_people_square-> {

                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_my -> {

                return@OnNavigationItemSelectedListener true
            }
        }
        false
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
//        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)
        NavigationUI.setupWithNavController(navigation,frag_nav_bottom_navigation.findNavController())
    }
}
