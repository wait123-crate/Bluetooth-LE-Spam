package de.simon.dankelmann.bluetoothlespam

import android.app.Application
import de.simon.dankelmann.bluetoothlespam.Interfaces.Services.IBluetoothLeScanService
import de.simon.dankelmann.bluetoothlespam.Services.BluetoothLeScanService
import de.simon.dankelmann.bluetoothlespam.AppContext

class BleSpamApplication : Application() {
    lateinit var scanService: IBluetoothLeScanService
        private set

    override fun onCreate() {
        super.onCreate()

        // Initialize AppContext here
        AppContext.initialize(this)

        // Initialize BluetoothLeScanService
        scanService = BluetoothLeScanService(this)
    }
}
