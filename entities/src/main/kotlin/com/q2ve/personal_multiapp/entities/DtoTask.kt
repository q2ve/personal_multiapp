package com.q2ve.personal_multiapp.entities

data class DtoTask(
	val id: Long?,
	val description: String,
	val isChecked: Boolean,
): Dto() {
	constructor(description: String, isChecked: Boolean): this(null, description, isChecked)
}
