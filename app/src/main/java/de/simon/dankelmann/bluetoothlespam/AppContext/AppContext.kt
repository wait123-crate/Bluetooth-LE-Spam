package de.simon.dankelmann.bluetoothlespam

import android.content.Context

class AppContext {
    companion object {
        private lateinit var _context: Context

        // Method to initialize the context (should be called early, like in onCreate)
        fun initialize(context: Context) {
            _context = context.applicationContext // Use applicationContext for better memory management
        }

        // Method to retrieve the context
        fun getContext(): Context {
            if (!:: _context.isInitialized) {
                throw IllegalStateException("Context has not been initialized")
            }
            return _context
        }
    }
}
