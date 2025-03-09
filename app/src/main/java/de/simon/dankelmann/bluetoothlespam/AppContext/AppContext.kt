package de.simon.dankelmann.bluetoothlespam

import android.content.Context

class AppContext {
    companion object {
        private var _context: Context? = null

        // Initialize the context once (called from Application class or main entry point)
        fun initialize(context: Context) {
            if (_context == null) {
                _context = context.applicationContext // Use applicationContext to avoid memory leaks
            }
        }

        // Safely get the context
        fun getContext(): Context {
            return _context ?: throw IllegalStateException("Context has not been initialized")
        }
    }
}
