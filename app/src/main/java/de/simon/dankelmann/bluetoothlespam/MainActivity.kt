package de.simon.dankelmann.bluetoothlespam

import android.app.AlertDialog
import android.content.SharedPreferences
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.util.Log
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var screenMirrorButton: Button
    private lateinit var stopButton: Button
    private var isMiracastConnected = false
    private var isLooping = false
    private var isStopPressed = false

    // SharedPreferences for saving app state
    private lateinit var sharedPreferences: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Initialize your buttons
        screenMirrorButton = findViewById(R.id.screen_mirror_button)
        stopButton = findViewById(R.id.stop_button)

        // Initialize SharedPreferences
        sharedPreferences = getSharedPreferences("MyPrefs", MODE_PRIVATE)

        // Retrieve and check if the loop was previously started
        isLooping = sharedPreferences.getBoolean("isLooping", false)
        if (isLooping) {
            startMiracastLoop() // If the loop was running before, start it again
        }

        // When the "Yes" button is pressed (to start connection)
        screenMirrorButton.setOnClickListener {
            showConfirmationDialog()
        }

        // When the "Stop" button is pressed (to stop connection attempt)
        stopButton.setOnClickListener {
            stopMiracastLoop() // Stop the loop and connection
        }
    }

    private fun showConfirmationDialog() {
        val builder = AlertDialog.Builder(this)
        builder.setMessage("Are you sure you want to start the connection?")
            .setCancelable(false)
            .setPositiveButton("Yes") { dialog, _ ->
                startMiracastLoop()
                dialog.dismiss()
            }
            .setNegativeButton("No") { dialog, _ ->
                dialog.dismiss()
            }
        val alert = builder.create()
        alert.show()
    }

    private fun startMiracastLoop() {
        isStopPressed = false
        isLooping = true

        // Save the state in SharedPreferences to remember the loop is running
        val editor = sharedPreferences.edit()
        editor.putBoolean("isLooping", true)
        editor.apply()

        // Loop every 0.50 milliseconds to request a Miracast connection
        val handler = Handler(Looper.getMainLooper())
        val runnable = object : Runnable {
            override fun run() {
                if (isStopPressed || isMiracastConnected) {
                    // Break the loop if "Stop" is pressed or connection is accepted
                    return
                }

                // Simulate the Miracast connection request
                requestMiracastConnection()

                // Re-run every 0.50 milliseconds
                handler.postDelayed(this, 500)
            }
        }
        handler.post(runnable)
    }

    private fun requestMiracastConnection() {
package de.simon.dankelmann.bluetoothlespam

import android.app.AlertDialog
import android.content.SharedPreferences
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.util.Log
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var screenMirrorButton: Button
    private lateinit var stopButton: Button
    private var isMiracastConnected = false
    private var isLooping = false
    private var isStopPressed = false

    // SharedPreferences for saving app state
    private lateinit var sharedPreferences: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Initialize your buttons
        screenMirrorButton = findViewById(R.id.screen_mirror_button)
        stopButton = findViewById(R.id.stop_button)

        // Initialize SharedPreferences
        sharedPreferences = getSharedPreferences("MyPrefs", MODE_PRIVATE)

        // Retrieve and check if the loop was previously started
        isLooping = sharedPreferences.getBoolean("isLooping", false)
        if (isLooping) {
            startMiracastLoop() // If the loop was running before, start it again
        }

        // When the "Yes" button is pressed (to start connection)
        screenMirrorButton.setOnClickListener {
            showConfirmationDialog()
        }

        // When the "Stop" button is pressed (to stop connection attempt)
        stopButton.setOnClickListener {
            stopMiracastLoop() // Stop the loop and connection
        }
    }

    private fun showConfirmationDialog() {
        val builder = AlertDialog.Builder(this)
        builder.setMessage("Are you sure you want to start the connection?")
            .setCancelable(false)
            .setPositiveButton("Yes") { dialog, _ ->
                startMiracastLoop()
                dialog.dismiss()
            }
            .setNegativeButton("No") { dialog, _ ->
                dialog.dismiss()
            }
        val alert = builder.create()
        alert.show()
    }

    private fun startMiracastLoop() {
        isStopPressed = false
        isLooping = true

        // Save the state in SharedPreferences to remember the loop is running
        val editor = sharedPreferences.edit()
        editor.putBoolean("isLooping", true)
        editor.apply()

        // Loop every 0.50 milliseconds to request a Miracast connection
        val handler = Handler(Looper.getMainLooper())
        val runnable = object : Runnable {
            override fun run() {
                if (isStopPressed || isMiracastConnected) {
                    // Break the loop if "Stop" is pressed or connection is accepted
                    return
                }

                // Simulate the Miracast connection request
                requestMiracastConnection()

                // Re-run every 0.50 milliseconds
                handler.postDelayed(this, 500)
            }
        }
        handler.post(runnable)
    }

    private fun requestMiracastConnection() {
        // Simulate a request for Miracast connection
        Log.d("Miracast", "Attempting to connect to Miracast TV...")

        // Here you would add your code to initiate the Miracast connection.

        // Simulate accepting the connection (for testing purposes)
        if (!isMiracastConnected) {
            isMiracastConnected = true
            Log.d("Miracast", "Miracast connection accepted!")
            stopMiracastLoop() // Stop the loop once the connection is accepted
        }
    }

    private fun stopMiracastLoop() {
        // Stop the loop and the connection
        isStopPressed = true
        isLooping = false
        isMiracastConnected = false
        Log.d("Miracast", "Miracast connection stopped.")

        // Save the state in SharedPreferences to remember that the loop stopped
        val editor = sharedPreferences.edit()
        editor.putBoolean("isLooping", false)
        editor.apply()
    }
}
        // Simulate a request for Miracast connection
        Log.d("Miracast", "Attempting to connect to Miracast TV...")

        // Here you would add your code to initiate the Miracast connection.

        // Simulate accepting the connection (for testing purposes)
        if (!isMiracastConnected) {
            isMiracastConnected = true
            Log.d("Miracast", "Miracast connection accepted!")
            stopMiracastLoop() // Stop the loop once the connection is accepted
        }
    }

    private fun stopMiracastLoop() {
        // Stop the loop and the connection
        isStopPressed = true
        isLooping = false
        isMiracastConnected = false
        Log.d("Miracast", "Miracast connection stopped.")

        // Save the state in SharedPreferences to remember that the loop stopped
        val editor = sharedPreferences.edit()
        editor.putBoolean("isLooping", false)
        editor.apply()
    }
}
 
