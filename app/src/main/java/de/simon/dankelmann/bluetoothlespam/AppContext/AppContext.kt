package de.simon.dankelmann.bluetoothlespam

import android.content.Context

object AppContext {
    private var _context: Context? = null

    fun initialize(context: Context) {
        if (_context == null) {
            _context = context.applicationContext
        }
    }

    fun getContext(): Context {
        return _context ?: throw IllegalStateException("AppContext not initialized!")
    }
}
