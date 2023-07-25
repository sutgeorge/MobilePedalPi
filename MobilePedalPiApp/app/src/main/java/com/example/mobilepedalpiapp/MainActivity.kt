package com.example.mobilepedalpiapp

import android.Manifest
import android.app.Activity
import android.bluetooth.BluetoothAdapter
import android.content.Intent
import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.result.contract.ActivityResultContracts
import androidx.annotation.RequiresApi
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.graphics.Color.Companion.Transparent
import androidx.core.view.WindowCompat
import com.example.mobilepedalpiapp.ui.theme.MobilePedalPiAppTheme
import com.google.accompanist.systemuicontroller.SystemUiController
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    @Inject lateinit var bluetoothAdapter: BluetoothAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        WindowCompat.setDecorFitsSystemWindows(window, false)
        super.onCreate(savedInstanceState)
        setContent {
            MobilePedalPiAppTheme {
                val systemUiController: SystemUiController = rememberSystemUiController()

                SideEffect {
                    systemUiController.setStatusBarColor(color = Transparent)
                    systemUiController.isStatusBarVisible = false;
                    systemUiController.isNavigationBarVisible = false;
                }

                Navigation()
            }
        }
    }

    @RequiresApi(Build.VERSION_CODES.S)
    override fun onStart() {
        super.onStart()
        showBluetoothDialog()
    }

    @RequiresApi(Build.VERSION_CODES.S)
    private fun showBluetoothDialog() {
        requestPermissionLauncher.launch(Manifest.permission.BLUETOOTH_CONNECT)
    }

    // Register the permissions callback, which handles the user's response to the
    // system permissions dialog. Save the return value, an instance of
    // ActivityResultLauncher. You can use either a val, as shown in this snippet,
    // or a lateinit var in your onAttach() or onCreate() method.
    @RequiresApi(Build.VERSION_CODES.S)
    private val requestPermissionLauncher =
        registerForActivityResult(
            ActivityResultContracts.RequestPermission()
        ) { isGranted: Boolean ->
            if (isGranted) {
                if (!bluetoothAdapter.isEnabled) {
                    val enableBluetoothIntent = Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE)
                    startBluetoothIntentForResult.launch(enableBluetoothIntent)
                }
            } else {
                // Explain to the user that the feature is unavailable because the
                // feature requires a permission that the user has denied. At the
                // same time, respect the user's decision. Don't link to system
                // settings in an effort to convince the user to change their
                // decision.
            }
        }

    // asks the user to enable Bluetooth or to deny doing so
    @RequiresApi(Build.VERSION_CODES.S)
    private val startBluetoothIntentForResult = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
        if (result.resultCode != Activity.RESULT_OK) {
            showBluetoothDialog()
        }
    }
}
