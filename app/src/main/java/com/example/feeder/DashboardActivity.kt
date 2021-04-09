package com.example.feeder

import android.app.Dialog
import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import androidx.fragment.app.FragmentActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.example.feeder.ui.events.EventDetailsFragment
import com.google.android.material.dialog.MaterialAlertDialogBuilder

class DashboardActivity : AppCompatActivity() {
    private val CHANNEL_ID = "1"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)

        createNotificationChannel()

        MaterialAlertDialogBuilder(this)
            .setTitle(resources.getString(R.string.whats_new))
            .setMessage(resources.getString(R.string.whats_new_body))
            .setPositiveButton(resources.getString(R.string.ok)) { dialog, which ->}
            .show()

        val notification = NotificationCompat.Builder(this, CHANNEL_ID)
            .setSmallIcon(R.drawable.ic_baseline_rss_feed_24)
            .setContentTitle("Check application bro!")
            .setContentText("Lorem ipsum dolor sit amet.")
            .setPriority(NotificationCompat.PRIORITY_DEFAULT).build()

        with(NotificationManagerCompat.from(this)) {
            notify(0, notification)
        }

        val navView: BottomNavigationView = findViewById(R.id.nav_view)

        val navController = findNavController(R.id.nav_host_fragment)
        navView.setupWithNavController(navController)
    }

    private fun createNotificationChannel() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val descriptionText = getString(R.string.app_description)
            val importance = NotificationManager.IMPORTANCE_DEFAULT
            val channel = NotificationChannel(CHANNEL_ID, getString(R.string.app_name), importance).apply {
                description = descriptionText
            }

            // Register the channel with the system
            val notificationManager: NotificationManager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
            notificationManager.createNotificationChannel(channel)
        }
    }

    public fun clickDeleteAccount(view: View) {
        MaterialAlertDialogBuilder(this)
            .setTitle(resources.getString(R.string.delete_account))
            .setMessage(resources.getString(R.string.are_you_sure))
            .setPositiveButton(resources.getString(R.string.ok)) { dialog, which ->
                val intent = Intent(this, LoginActivity::class.java)
                startActivity(intent)
                finish();
            }
            .setNegativeButton(resources.getString(R.string.cancel)) {dialog, which ->}
            .show()

    }
}