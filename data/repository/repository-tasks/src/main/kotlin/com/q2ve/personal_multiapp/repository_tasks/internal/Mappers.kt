package com.q2ve.personal_multiapp.repository_tasks.internal

import com.q2ve.personal_multiapp.database_room.api.RoomDB
import com.q2ve.personal_multiapp.database_room.api.entities.DbEntityTask
import com.q2ve.personal_multiapp.entities.DtoTask

internal fun DbEntityTask.toDto() = DtoTask(
	id, description, isChecked
)

internal fun DtoTask.toDbEntity() = DbEntityTask(
	id ?: RoomDB.ABSENT_ID_PLACEHOLDER, description, isChecked
)

internal fun DtoTask.toId() = id ?: RoomDB.ABSENT_ID_PLACEHOLDER
