package com.q2ve.personal_multiapp.database_room.api.entities

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Entity
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.PrimaryKey
import androidx.room.Query

@Entity
class DbEntityTask(
	@PrimaryKey(autoGenerate = true) val id: Long = 0,
	val description: String,
	val isChecked: Boolean,
)

@Dao
interface TaskDao {

	@Query("SELECT * FROM dbentitytask")
	fun getAll(): LiveData<List<DbEntityTask>>

	@Insert(onConflict = OnConflictStrategy.REPLACE)
	fun insertAndReplace(entity: DbEntityTask)

	@Query("DELETE FROM dbentitytask WHERE id LIKE :id")
	fun delete(id: Long)
}
