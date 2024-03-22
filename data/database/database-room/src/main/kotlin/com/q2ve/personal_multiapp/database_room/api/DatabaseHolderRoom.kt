package com.q2ve.personal_multiapp.database_room.api

import android.content.Context
import com.q2ve.personal_multiapp.database_helpers.DatabaseHolderAbstract

object DatabaseHolderRoom {

	private var holder = DatabaseHolderAbstract<RoomDB>()

	/**
	 * This method must be called single time before all database access attempts.
	 * You will have single room instance for whole application lifetime.
	 */
	fun initialize(context: Context) = holder.initialize(RoomDB.getCommonInstance(context))

	fun getDatabase() = holder.getDatabase()
}
