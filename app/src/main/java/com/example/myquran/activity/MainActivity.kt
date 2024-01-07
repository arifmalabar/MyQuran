package com.example.myquran.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.view.View
import androidx.fragment.app.FragmentTransaction
import com.example.myquran.R
import com.example.myquran.fragment.AlQuranFragment
import com.example.myquran.fragment.HomeFragment
import com.example.myquran.fragment.ProfileFragment
import com.example.myquran.fragment.SholatFragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {
    private lateinit var bottomNavigationView: BottomNavigationView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main);
        supportActionBar?.hide();
        initial();
    }

    private fun initial() {
        bottomNavigationView = findViewById(R.id.bottom_nav);

        bottomNavigationView.setOnNavigationItemReselectedListener {
            showFragment(it.itemId)
        }
    }

    private fun showFragment(it: Int) {
        var ft : FragmentTransaction = supportFragmentManager.beginTransaction();
        var view : Int = R.id.app_main;
        when(it) {
            R.id.menu_home -> {
                ft.replace(view, HomeFragment())
            }
            R.id.menu_alquran -> {
                ft.replace(view, AlQuranFragment())
            }
            R.id.menu_sholat -> {
                ft.replace(view, SholatFragment())
            }
            R.id.menu_user -> {
                ft.replace(view, ProfileFragment())
            } else -> {
                ft.replace(view, HomeFragment());
            }
        }
        ft.commit();
    }
}