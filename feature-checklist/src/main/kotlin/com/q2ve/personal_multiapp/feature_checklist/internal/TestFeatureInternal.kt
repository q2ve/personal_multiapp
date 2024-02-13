package com.q2ve.personal_multiapp.feature_checklist.internal

internal class TestFeatureInternal {
	fun getSomeShit(): Any? {
		return if (System.currentTimeMillis() % 2 == 0L) "PWNED" else null
	}
}