package com.q2ve.personal_multiapp.feature_checklist.di

import com.q2ve.personal_multiapp.feature_checklist.internal.TestFeatureInternal2
import com.q2ve.personal_multiapp.repository_tasks.api.RepositoryTasks
import dagger.Module
import dagger.Provides
import dagger.Reusable

@Module
internal class FeatureChecklistModule {
	@Provides
	@Reusable
	fun getTestFeature2(): TestFeatureInternal2 = TestFeatureInternal2()

	@Provides
	@Reusable
	fun getRepositoryTasks(): RepositoryTasks = RepositoryTasks()
}