package com.example.schmerzfreiapp
import android.os.Bundle
import android.view.Menu
import com.google.android.material.navigation.NavigationView
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import androidx.drawerlayout.widget.DrawerLayout
import androidx.appcompat.app.AppCompatActivity
import com.example.schmerzfreiapp.databinding.ActivityMainBinding
import android.widget.ImageView
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {

    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var binding: ActivityMainBinding
    private lateinit var uebungenCardView: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.appBarMain.toolbar)
        val navController = findNavController(R.id.nav_host_fragment_content_main)
        val drawerLayout: DrawerLayout = binding.drawerLayout
        val navView: NavigationView = binding.navView

        //// Passing each menu ID as a set of Ids because each
        //// menu should be considered as top level destinations.

        navView.setItemIconTintList(null);
        appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.nav_home, R.id.nav_hilfsmittel, R.id.nav_gesundheitstipps, R.id.nav_uebungen, R.id.nav_uebungDetail
            ), drawerLayout
        )
        setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)
        getSupportActionBar()?.setDisplayShowTitleEnabled(false)

        //----playbutton
        val uebungenCardView = findViewById<ImageView>(R.id.uebungen_card_view)
        uebungenCardView.setOnClickListener {
            navController.navigate(R.id.nav_uebungen)

//            val navController = findNavController(R.id.nav_host_fragment_content_main)
//            val navHostFragment: NavHostFragment = supportFragmentManager.findFragmentById(R.id.nav_host_fragment_content_main) as NavHostFragment
//            val inflater = navHostFragment.navController.navInflater
//            val graph = inflater.inflate(R.navigation.mobile_navigation)
//            graph.startDestination = R.id.appBarLayout
//            navController.graph = graph
        }
        //----playbuttonend

        val bottomView: BottomNavigationView = findViewById<BottomNavigationView>(R.id.bottom_bar)
// Hook your navigation controller to bottom navigation view
        bottomView.setupWithNavController(navController)
        bottomView.itemIconTintList = null
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.main, menu)
        return true
    }

    override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(R.id.nav_host_fragment_content_main)
        return navController.navigateUp(appBarConfiguration) || super.onSupportNavigateUp()
    }

//    fun navigateFirstTabWithClearStack() {
//        val navController = findNavController(R.id.nav_host_fragment_content_main)
//        val navHostFragment: NavHostFragment = supportFragmentManager.findFragmentById(R.id.nav_host_main) as NavHostFragment
//        val inflater = navHostFragment.navController.navInflater
//        val graph = inflater.inflate(R.navigation.nav_graph_main)
//        graph.startDestination = R.id.nav_graph_tab1
//
//        navController.graph = graph
//    }

}