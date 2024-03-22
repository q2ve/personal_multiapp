package com.q2ve.personal_multiapp.database_helpers

class DatabaseHolderAbstract<T> {

	@Volatile
	var db: T? = null

	/**
	 * This method must be called single time before all database access attempts.
	 * You will have single database instance for whole application lifetime.
	 */
	fun initialize(actualDb: T) {
		if (db == null) synchronized(this) {
			if (db == null) db = actualDb
			else throw IllegalAccessException(DOUBLE_INIT_ERROR)
		} else throw IllegalAccessException(DOUBLE_INIT_ERROR)
	}

	fun getDatabase() = db ?: throw IllegalStateException(NOT_INITIALIZED_ERROR)

	companion object {
		const val DOUBLE_INIT_ERROR = "You should not initialize the database twice."
		const val NOT_INITIALIZED_ERROR =
			"DatabaseHolder should be initialized before using. " +
					"Consider to do this in your custom Application class."
	}
}
