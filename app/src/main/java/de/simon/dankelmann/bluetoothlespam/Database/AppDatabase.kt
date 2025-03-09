packagepackage de.simon.dankelmann.bluetoothlespam.Database

import android.content.Context
import de.simon.dankelmann.bluetoothlespam.AppContext

class AppDatabase {
    companion object {
        private var instance: AppDatabase? = null

        // Use the context to initialize the database
        fun getInstance(): AppDatabase {
            if (instance == null) {
                // Ensure the context is initialized before accessing the database
                if (!::AppContext.getContext().isInitialized) {
                    throw IllegalStateException("Context not initialized")
                }
                instance = AppDatabase() // Replace with actual initialization logic for your database
            }
            return instance!!
         }
    }
}
 de.simon.dankelmann.bluetoothlespam.Database

import android.content.Context
import de.simon.dankelmann.bluetoothlespam.AppContext

class AppDatabase {
    companion object {
        private var instance: AppDatabase? = null

        // Use the context to initialize the database
        fun getInstance(): AppDatabase {
            if (instance == null) {
                // Ensure the context is initialized before accessing the database
                if (!::AppContext.getContext().isInitialized) {
                    throw IllegalStateException("Context not initialized")
                }
                instance = AppDatabase() // Replace with actual initialization logic for your database
            }
            return instance!!
        }
    }
}
