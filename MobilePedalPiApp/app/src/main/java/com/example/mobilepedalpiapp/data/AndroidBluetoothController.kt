package com.example.mobilepedalpiapp.data

import android.content.Context
import com.example.mobilepedalpiapp.domain.BluetoothController
import com.example.mobilepedalpiapp.domain.BluetoothDevice
import kotlinx.coroutines.flow.StateFlow

class AndroidBluetoothController(
    private val context: Context
): BluetoothController {

    override val scannedDevices: StateFlow<List<BluetoothDevice>>
        get() = TODO("Not yet implemented")
    override val pairedDevices: StateFlow<List<BluetoothDevice>>
        get() = TODO("Not yet implemented")

    override fun startDiscovery() {
        TODO("Not yet implemented")
    }

    override fun stopDiscovery() {
        TODO("Not yet implemented")
    }

    override fun release() {
        TODO("Not yet implemented")
    }

}