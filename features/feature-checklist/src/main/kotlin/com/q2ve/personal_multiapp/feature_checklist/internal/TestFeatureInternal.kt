package com.q2ve.personal_multiapp.feature_checklist.internal

import javax.inject.Inject
import javax.inject.Singleton

@Singleton
internal class TestFeatureInternal @Inject constructor(
	private val test: TestFeatureInternal2,
) {
	fun getSomeShit(): Any? {
		return if (test.isSomeShit()) "someshit" else "PWNED"
	}
}