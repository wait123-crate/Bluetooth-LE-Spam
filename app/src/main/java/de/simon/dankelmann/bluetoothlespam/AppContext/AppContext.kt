package de.simon.dankelmann.bluetoothlespam

import android.content.Context

class AppContext private constructor() {
    companion object {
        // Hold the app context globally
        private var _context: Context? = null
        
        // Method to initialize the AppContext
        fun initialize(context: Context) {
            if (_context == null) {
                _context = context.applicationContext
            }
        }
        
        // Method to access the app context
        fun getContext(): Context {
            return _context ?: throw IllegalStateException("AppContext not initialized!")
        }
    }
}
