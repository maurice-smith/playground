package com.kingmo.navigation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.NavigationUI.setupActionBarWithNavController

class MainActivity : AppCompatActivity() {
    lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //val navHost: NavHostFragment = supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment? ?: return
        //navController = navHost.navController
        //setupActionBarWithNavController(this, navController)
        actionBar?.setDisplayHomeAsUpEnabled(true)
        setContentView(R.layout.activity_main)
    }

    //override fun onSupportNavigateUp(): Boolean = navController.navigateUp()
}
