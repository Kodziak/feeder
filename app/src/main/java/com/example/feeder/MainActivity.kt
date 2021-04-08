package com.example.feeder

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.view.WindowManager
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.ImageView
import android.widget.TextView
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController

class MainActivity : AppCompatActivity() {

    protected var SPLASH_SCREEN: Long = 2000;

    protected lateinit var textView: TextView;
    protected lateinit var topAnim: Animation;
    protected lateinit var botAnim: Animation;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        val navView: BottomNavigationView = findViewById(R.id.nav_view)

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN)

        setContentView(R.layout.splash_screen)

        // Animations
        topAnim = AnimationUtils.loadAnimation(this, R.anim.top_animation);
        botAnim = AnimationUtils.loadAnimation(this, R.anim.bottom_animation);

        // Hooks
        textView = findViewById(R.id.app_title)
        textView.setAnimation(topAnim)

        Handler().postDelayed(Runnable {
            run() {
                val intent = Intent(this, LoginActivity::class.java)
                startActivity(intent)
                finish();
            }
        }, SPLASH_SCREEN)

//        val navController = findNavController(R.id.nav_host_fragment)
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
//        val appBarConfiguration = AppBarConfiguration(
//            setOf(
//                R.id.navigation_home,
//                R.id.navigation_login,
//                R.id.navigation_notifications,
//                R.id.navigation_add_rss,
//                R.id.navigation_listing
//            )
//        )
//        setupActionBarWithNavController(navController, appBarConfiguration)
//        navView.setupWithNavController(navController)
    }
}