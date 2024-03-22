package com.q2ve.personal_multiapp.database_room.api

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.q2ve.personal_multiapp.database_room.api.entities.DbEntityTask
import com.q2ve.personal_multiapp.database_room.api.entities.TaskDao

/**
 * You should not instantiating this db manually. Just call [DatabaseHolderRoom.initialize].
 * @see DatabaseHolderRoom.getDatabase
 */
@Database(entities = [DbEntityTask::class], version = 1)
abstract class RoomDB: RoomDatabase() {
	abstract fun taskDao(): TaskDao

	companion object {
		const val ABSENT_ID_PLACEHOLDER: Long = 0
		private const val COMMON_DATABASE_NAME = "test"

		fun getCommonInstance(context: Context): RoomDB {
			return Room.databaseBuilder(context, RoomDB::class.java, COMMON_DATABASE_NAME)
				.allowMainThreadQueries()
				.build()
		}
	}
}
