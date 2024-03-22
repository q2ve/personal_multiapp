package com.q2ve.personal_multiapp.repository_tasks.api

import androidx.lifecycle.LiveData
import androidx.lifecycle.map
import com.q2ve.personal_multiapp.database_room.api.DatabaseHolderRoom
import com.q2ve.personal_multiapp.entities.DtoTask
import com.q2ve.personal_multiapp.repository_tasks.internal.toDbEntity
import com.q2ve.personal_multiapp.repository_tasks.internal.toDto
import com.q2ve.personal_multiapp.repository_tasks.internal.toId

class RepositoryTasks {

	fun getAll(): LiveData<List<DtoTask>> = dao().getAll().map { list -> list.map { it.toDto() } }

	fun insertAndReplace(task: DtoTask) = dao().insertAndReplace(task.toDbEntity())

	fun delete(task: DtoTask) = dao().delete(task.toId())

	fun delete(id: Long?) = id?.let { dao().delete(it) }

	private fun dao() = DatabaseHolderRoom.getDatabase().taskDao()
}
